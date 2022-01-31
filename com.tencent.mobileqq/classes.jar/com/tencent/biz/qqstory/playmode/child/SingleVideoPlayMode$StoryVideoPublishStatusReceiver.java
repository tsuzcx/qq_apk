package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.OneVideoInfo;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.ShareGroupFakeItem;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleVideoPlayMode$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver
{
  public String a;
  
  public SingleVideoPlayMode$StoryVideoPublishStatusReceiver(@NonNull SingleVideoPlayMode paramSingleVideoPlayMode)
  {
    super(paramSingleVideoPlayMode);
  }
  
  private StoryVideoItem a(SingleVideoPlayMode paramSingleVideoPlayMode, StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent, String paramString)
  {
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {}
    while (!TextUtils.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramString)) {
      return null;
    }
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
    {
      this.a = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
      if (paramStoryVideoPublishStatusEvent.b == null) {
        return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      }
      return paramStoryVideoPublishStatusEvent.b;
    }
    return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  }
  
  private StoryVideoItem b(SingleVideoPlayMode paramSingleVideoPlayMode, StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent, String paramString)
  {
    if ((paramStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList == null) || (paramStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    StoryVideoUploadManager.ShareGroupFakeItem localShareGroupFakeItem;
    do
    {
      paramSingleVideoPlayMode = paramStoryVideoPublishStatusEvent.jdField_a_of_type_JavaUtilArrayList.iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          if (!paramSingleVideoPlayMode.hasNext()) {
            break;
          }
          localShareGroupFakeItem = (StoryVideoUploadManager.ShareGroupFakeItem)paramSingleVideoPlayMode.next();
        } while ((localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList == null) || (localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList.isEmpty()));
        localIterator = localShareGroupFakeItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      paramStoryVideoPublishStatusEvent = (StoryVideoUploadManager.OneVideoInfo)localIterator.next();
    } while (!TextUtils.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramString));
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
    {
      if (localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem == null) {}
      for (paramSingleVideoPlayMode = localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId;; paramSingleVideoPlayMode = localShareGroupFakeItem.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId)
      {
        this.a = paramSingleVideoPlayMode;
        if (paramStoryVideoPublishStatusEvent.b != null) {
          break;
        }
        return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      }
      return paramStoryVideoPublishStatusEvent.b;
    }
    return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    return null;
  }
  
  public void a(@NonNull SingleVideoPlayMode paramSingleVideoPlayMode, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((paramSingleVideoPlayMode.jdField_a_of_type_JavaUtilList == null) || (paramSingleVideoPlayMode.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    label261:
    for (;;)
    {
      return;
      Object localObject = null;
      if (paramStoryVideoPublishStatusEvent.b()) {
        localObject = a(paramSingleVideoPlayMode, paramStoryVideoPublishStatusEvent, (String)paramSingleVideoPlayMode.jdField_a_of_type_JavaUtilList.get(0));
      }
      if (((localObject == null) || (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject).mVid))) && (paramStoryVideoPublishStatusEvent.c())) {}
      for (paramStoryVideoPublishStatusEvent = b(paramSingleVideoPlayMode, paramStoryVideoPublishStatusEvent, (String)paramSingleVideoPlayMode.jdField_a_of_type_JavaUtilList.get(0));; paramStoryVideoPublishStatusEvent = (StoryVideoUploadManager.StoryVideoPublishStatusEvent)localObject)
      {
        if (paramStoryVideoPublishStatusEvent == null) {
          break label261;
        }
        if (StoryVideoItem.isFakeVid(paramStoryVideoPublishStatusEvent.mVid))
        {
          localObject = (VideoPlayerPagerAdapter.VideoViewHolder)paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramSingleVideoPlayMode.b);
          if (localObject == null) {
            break;
          }
          paramSingleVideoPlayMode.d((VideoPlayerPagerAdapter.VideoViewHolder)localObject, paramStoryVideoPublishStatusEvent);
          return;
        }
        paramSingleVideoPlayMode.jdField_a_of_type_JavaUtilList.set(0, paramStoryVideoPublishStatusEvent.mVid);
        if (paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        localObject = (StoryVideoItem)paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramSingleVideoPlayMode.b);
        if ((StoryVideoItem.isFakeVid(((StoryVideoItem)localObject).mVid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoPublishStatusEvent.mVid))) {
          ((StoryVideoItem)localObject).mVid = paramStoryVideoPublishStatusEvent.mVid;
        }
        if (!TextUtils.isEmpty(this.a)) {
          paramSingleVideoPlayMode.g = this.a;
        }
        localObject = (VideoPlayerPagerAdapter.VideoViewHolder)paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramSingleVideoPlayMode.b);
        if (localObject != null) {
          paramSingleVideoPlayMode.d((VideoPlayerPagerAdapter.VideoViewHolder)localObject, paramStoryVideoPublishStatusEvent);
        }
        SingleVideoPlayMode.a(paramSingleVideoPlayMode);
        return;
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.SingleVideoPlayMode.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */