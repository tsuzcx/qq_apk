package com.tencent.biz.qqstory.shareGroup.model;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nrd;

public class ShareGroupManager
  implements IManager
{
  private OneObjectCacheList a;
  protected HashMap a;
  
  public ShareGroupManager()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static boolean a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return false;
    }
    long l = paramShareGroupItem.groupUin;
    return TroopAssistantManager.a().a(QQStoryContext.a(), String.valueOf(l));
  }
  
  public ShareGroupItem a(ShareGroupItem paramShareGroupItem)
  {
    paramShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramShareGroupItem.shareGroupId, paramShareGroupItem);
    ShareGroupEntry localShareGroupEntry = paramShareGroupItem.convertTo();
    a().a().createEntityManager().b(localShareGroupEntry);
    return paramShareGroupItem;
  }
  
  public ShareGroupItem a(String paramString)
  {
    AssertUtils.a(paramString);
    Object localObject = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    if (localObject != null)
    {
      SLog.d("Q.qqstory.discover.ShareGroupManager", "read sg cc:%s, unionId:" + ((ShareGroupItem)localObject).headerUnionIdList, new Object[] { ((ShareGroupItem)localObject).shareGroupId });
      return localObject;
    }
    localObject = a(a().a().createEntityManager(), ShareGroupEntry.class, ShareGroupEntry.class.getSimpleName(), ShareGroupEntry.getShareGroupSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      SLog.d("Q.qqstory.discover.ShareGroupManager", "find not find share group:%s", new Object[] { paramString });
      return null;
    }
    localObject = new ShareGroupItem((ShareGroupEntry)((List)localObject).get(0));
    return (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString, (Copyable)localObject);
  }
  
  public void a() {}
  
  public void a(String paramString, int paramInt)
  {
    VideoCollectionItem localVideoCollectionItem = ((MemoryManager)SuperManager.a(19)).a(paramString);
    if (localVideoCollectionItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.discover.ShareGroupManager", 2, "doGetFeedIdVidList: videoCollectionItem is null, feedId:" + paramString);
      }
      return;
    }
    if (localVideoCollectionItem.collectionCount == localVideoCollectionItem.videoVidList.size())
    {
      localObject = new ShareGroupManager.GetFeedIdVidListEvent();
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((ShareGroupManager.GetFeedIdVidListEvent)localObject).jdField_a_of_type_JavaUtilArrayList = localVideoCollectionItem.videoVidList;
      Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    int i = localVideoCollectionItem.videoVidList.size();
    Object localObject = new qqstory_service.ReqLoadMoreVideoList();
    ((qqstory_service.ReqLoadMoreVideoList)localObject).feed_id.set(ByteStringMicro.copyFromUtf8(localVideoCollectionItem.feedId));
    ((qqstory_service.ReqLoadMoreVideoList)localObject).from.set(paramInt);
    ((qqstory_service.ReqLoadMoreVideoList)localObject).start_cookie.set(ByteStringMicro.copyFromUtf8(localVideoCollectionItem.nextCookie));
    ((qqstory_service.ReqLoadMoreVideoList)localObject).video_count.set(10);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_feedid", localVideoCollectionItem.feedId);
    ProtoUtils.a(PlayModeUtils.a(), new nrd(this, i, paramString, paramInt), ((qqstory_service.ReqLoadMoreVideoList)localObject).toByteArray(), StoryApi.a("StoryGroupSvc.datacard_load_more_video"), localBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
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
      localShareGroupItem1.ownerUnionId = QQStoryContext.a().b();
      localShareGroupItem1.assertItem();
      SLog.d("Q.qqstory.discover.ShareGroupManager", "create one fake groupItem:%s", new Object[] { localShareGroupItem1 });
    }
    return localShareGroupItem1;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager
 * JD-Core Version:    0.7.0.1
 */