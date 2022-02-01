package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class MemoriesFeedPlayPageLoader
  extends IGroupPageLoader.BaseGroupPageLoader
  implements IEventReceiver
{
  protected INetPageLoader a;
  private final MemoriesFeedPlayInfo b;
  private MemoriesFeedPlayPageLoader.GetCollectListEventReceiver c;
  private int d = 0;
  private AtomicBoolean e = new AtomicBoolean(false);
  private IGroupPageLoader.CallBack f;
  
  public MemoriesFeedPlayPageLoader(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.b = paramMemoriesFeedPlayInfo;
  }
  
  @NonNull
  public static List<IDataProvider.GroupInfo> b(List<VideoCollectionItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem != null) && (localVideoCollectionItem.collectionType == 1))
      {
        Object localObject = new MemoriesFeedPlayPageLoader.MemoriesFeedGroupId(localVideoCollectionItem.feedId);
        ((MemoriesFeedPlayPageLoader.MemoriesFeedGroupId)localObject).a = new FeedIdListSeqInfo(localVideoCollectionItem.feedId, 0, localVideoCollectionItem.uin, String.valueOf(localVideoCollectionItem.collectionTime));
        localObject = new IDataProvider.GroupInfo((IDataProvider.GroupId)localObject);
        localArrayList.add(localObject);
        ((IDataProvider.GroupInfo)localObject).c = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((IDataProvider.GroupInfo)localObject).c.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((IDataProvider.GroupInfo)localObject).d.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a()
  {
    if (this.b.mDataType == 0) {
      this.a = new DateCollectionListPageLoader(this.b.mUid, this.b.mContext);
    } else {
      this.a = new ShareGroupDateListPageLoader(this.b.mUid, this.b.mDataType, this.b.mContext);
    }
    this.c = new MemoriesFeedPlayPageLoader.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.c);
    AssertUtils.checkNotNull(this.b);
  }
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    b(paramInt, paramCallBack);
    this.d += 1;
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.c);
    this.e.set(true);
  }
  
  public void b(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    if ((this.d == 0) && (this.b.mKeyList.size() > 0))
    {
      MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
      ArrayList localArrayList = new ArrayList(this.b.mKeyList.size());
      Iterator localIterator = this.b.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localMemoryManager.a((String)localIterator.next()));
      }
      paramCallBack.b(new ErrorMessage(), b(localArrayList), this.b.mIsEnd);
      return;
    }
    this.f = paramCallBack;
    this.a.c();
  }
  
  public IDataProvider.StartInfo c()
  {
    MemoriesFeedPlayPageLoader.MemoriesFeedGroupId localMemoriesFeedGroupId;
    if (!TextUtils.isEmpty(this.b.mStartFeedId)) {
      localMemoriesFeedGroupId = new MemoriesFeedPlayPageLoader.MemoriesFeedGroupId(this.b.mStartFeedId);
    } else {
      localMemoriesFeedGroupId = null;
    }
    return new IDataProvider.StartInfo(localMemoriesFeedGroupId, this.b.mStartVid, this.b.mStartFeedId);
  }
  
  public boolean isValidate()
  {
    return this.e.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */