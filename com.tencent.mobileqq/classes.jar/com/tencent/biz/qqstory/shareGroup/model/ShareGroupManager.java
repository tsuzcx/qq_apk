package com.tencent.biz.qqstory.shareGroup.model;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareGroupManager
  implements IManager
{
  protected HashMap<String, String> a = new HashMap();
  private OneObjectCacheList<String, ShareGroupItem> b = new OneObjectCacheList(300);
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static boolean b(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return false;
    }
    long l = paramShareGroupItem.groupUin;
    return TroopAssistantManager.a().a(QQStoryContext.j(), String.valueOf(l));
  }
  
  private QQStoryContext c()
  {
    return QQStoryContext.a();
  }
  
  public ShareGroupItem a(ShareGroupItem paramShareGroupItem)
  {
    paramShareGroupItem = (ShareGroupItem)this.b.a(paramShareGroupItem.shareGroupId, paramShareGroupItem);
    ShareGroupEntry localShareGroupEntry = paramShareGroupItem.convertTo();
    c().d().createEntityManager().persistOrReplace(localShareGroupEntry);
    return paramShareGroupItem;
  }
  
  public ShareGroupItem a(String paramString)
  {
    AssertUtils.checkNotNull(paramString);
    Object localObject = (ShareGroupItem)this.b.a(paramString);
    if (localObject != null)
    {
      paramString = new StringBuilder();
      paramString.append("read sg cc:%s, unionId:");
      paramString.append(((ShareGroupItem)localObject).headerUnionIdList);
      SLog.d("Q.qqstory.discover.ShareGroupManager", paramString.toString(), new Object[] { ((ShareGroupItem)localObject).shareGroupId });
      return localObject;
    }
    localObject = a(c().d().createEntityManager(), ShareGroupEntry.class, ShareGroupEntry.class.getSimpleName(), ShareGroupEntry.getShareGroupSelectionNoArg(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new ShareGroupItem((ShareGroupEntry)((List)localObject).get(0));
      return (ShareGroupItem)this.b.a(paramString, (Copyable)localObject);
    }
    SLog.d("Q.qqstory.discover.ShareGroupManager", "find not find share group:%s", new Object[] { paramString });
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1 = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doGetFeedIdVidList: videoCollectionItem is null, feedId:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("Q.qqstory.discover.ShareGroupManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if (((VideoCollectionItem)localObject1).collectionCount == ((VideoCollectionItem)localObject1).videoVidList.size())
    {
      localObject2 = new ShareGroupManager.GetFeedIdVidListEvent();
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject2).a = paramString;
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject2).b = ((VideoCollectionItem)localObject1).videoVidList;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject2);
      return;
    }
    int i = ((VideoCollectionItem)localObject1).videoVidList.size();
    Object localObject2 = new qqstory_service.ReqLoadMoreVideoList();
    ((qqstory_service.ReqLoadMoreVideoList)localObject2).feed_id.set(ByteStringMicro.copyFromUtf8(((VideoCollectionItem)localObject1).feedId));
    ((qqstory_service.ReqLoadMoreVideoList)localObject2).from.set(paramInt);
    ((qqstory_service.ReqLoadMoreVideoList)localObject2).start_cookie.set(ByteStringMicro.copyFromUtf8(((VideoCollectionItem)localObject1).nextCookie));
    ((qqstory_service.ReqLoadMoreVideoList)localObject2).video_count.set(10);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_feedid", ((VideoCollectionItem)localObject1).feedId);
    ProtoUtils.a(PlayModeUtils.b(), new ShareGroupManager.1(this, i, paramString, paramInt), ((qqstory_service.ReqLoadMoreVideoList)localObject2).toByteArray(), StoryApi.a("StoryGroupSvc.datacard_load_more_video"), localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
  
  public ShareGroupItem b(String paramString)
  {
    ShareGroupItem localShareGroupItem2 = a(paramString);
    ShareGroupItem localShareGroupItem1 = localShareGroupItem2;
    if (localShareGroupItem2 == null)
    {
      localShareGroupItem1 = new ShareGroupItem();
      localShareGroupItem1.shareGroupId = paramString;
      localShareGroupItem1.name = paramString;
      localShareGroupItem1.ownerUnionId = QQStoryContext.a().i();
      localShareGroupItem1.assertItem();
      SLog.d("Q.qqstory.discover.ShareGroupManager", "create one fake groupItem:%s", new Object[] { localShareGroupItem1 });
    }
    return localShareGroupItem1;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager
 * JD-Core Version:    0.7.0.1
 */