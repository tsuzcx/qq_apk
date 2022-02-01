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
  private int jdField_a_of_type_Int = 0;
  protected INetPageLoader a;
  private IGroupPageLoader.CallBack jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack;
  private MemoriesFeedPlayPageLoader.GetCollectListEventReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMemoriesFeedPlayPageLoader$GetCollectListEventReceiver;
  private final MemoriesFeedPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public MemoriesFeedPlayPageLoader(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo = paramMemoriesFeedPlayInfo;
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
        ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_JavaUtilMap.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public IDataProvider.StartInfo a()
  {
    MemoriesFeedPlayPageLoader.MemoriesFeedGroupId localMemoriesFeedGroupId;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId)) {
      localMemoriesFeedGroupId = new MemoriesFeedPlayPageLoader.MemoriesFeedGroupId(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
    } else {
      localMemoriesFeedGroupId = null;
    }
    return new IDataProvider.StartInfo(localMemoriesFeedGroupId, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
  }
  
  public List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader = new DateCollectionListPageLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader = new ShareGroupDateListPageLoader(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMemoriesFeedPlayPageLoader$GetCollectListEventReceiver = new MemoriesFeedPlayPageLoader.GetCollectListEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMemoriesFeedPlayPageLoader$GetCollectListEventReceiver);
    AssertUtils.checkNotNull(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo);
  }
  
  public void a(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    b(paramInt, paramCallBack);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderMemoriesFeedPlayPageLoader$GetCollectListEventReceiver);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(int paramInt, IGroupPageLoader.CallBack paramCallBack)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size() > 0))
    {
      MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size());
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localMemoryManager.a((String)localIterator.next()));
      }
      paramCallBack.b(new ErrorMessage(), b(localArrayList), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mIsEnd);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader$CallBack = paramCallBack;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader.c();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader
 * JD-Core Version:    0.7.0.1
 */