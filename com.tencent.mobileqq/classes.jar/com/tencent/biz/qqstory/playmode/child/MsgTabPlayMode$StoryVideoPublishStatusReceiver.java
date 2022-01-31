package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nof;
import nog;

public class MsgTabPlayMode$StoryVideoPublishStatusReceiver
  extends QQUIEventReceiver
{
  public String a;
  
  public MsgTabPlayMode$StoryVideoPublishStatusReceiver(@NonNull MsgTabPlayMode paramMsgTabPlayMode)
  {
    super(paramMsgTabPlayMode);
  }
  
  private StoryVideoItem a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent, String paramString)
  {
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {}
    while (!TextUtils.equals(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramString)) {
      return null;
    }
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc())
    {
      this.jdField_a_of_type_JavaLangString = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
      if (paramStoryVideoPublishStatusEvent.b == null) {
        return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      }
      return paramStoryVideoPublishStatusEvent.b;
    }
    return paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  }
  
  public void a(@NonNull MsgTabPlayMode paramMsgTabPlayMode, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if ((paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList == null) || (paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    label331:
    for (;;)
    {
      return;
      Object localObject1 = (StoryVideoItem)paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramMsgTabPlayMode.b);
      if (paramStoryVideoPublishStatusEvent.b()) {}
      for (paramStoryVideoPublishStatusEvent = a(paramStoryVideoPublishStatusEvent, ((StoryVideoItem)localObject1).mVid);; paramStoryVideoPublishStatusEvent = null)
      {
        if (paramStoryVideoPublishStatusEvent == null) {
          break label331;
        }
        if (StoryVideoItem.isFakeVid(paramStoryVideoPublishStatusEvent.mVid))
        {
          localObject1 = (VideoPlayerPagerAdapter.VideoViewHolder)paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramMsgTabPlayMode.b);
          if (localObject1 == null) {
            break;
          }
          paramMsgTabPlayMode.d((VideoPlayerPagerAdapter.VideoViewHolder)localObject1, paramStoryVideoPublishStatusEvent);
          return;
        }
        if ((StoryVideoItem.isFakeVid(((StoryVideoItem)localObject1).mVid)) && (!StoryVideoItem.isFakeVid(paramStoryVideoPublishStatusEvent.mVid)))
        {
          Object localObject2 = (List)paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider.a.get(paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)((Iterator)localObject2).next();
              if (TextUtils.equals(localMsgTabVideoData.b, ((StoryVideoItem)localObject1).mVid))
              {
                localMsgTabVideoData.b = paramStoryVideoPublishStatusEvent.mVid;
                localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.copy(paramStoryVideoPublishStatusEvent);
                localMsgTabVideoData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
              }
            }
          }
        }
        localObject1 = (VideoPlayerPagerAdapter.VideoViewHolder)paramMsgTabPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramMsgTabPlayMode.b);
        if (localObject1 != null) {
          paramMsgTabPlayMode.d((VideoPlayerPagerAdapter.VideoViewHolder)localObject1, paramStoryVideoPublishStatusEvent);
        }
        localObject1 = new BatchGetVideoInfo(Collections.singletonList(paramStoryVideoPublishStatusEvent.mVid));
        ((BatchGetVideoInfo)localObject1).a = new nof(this);
        ((BatchGetVideoInfo)localObject1).a(new nog(this, paramMsgTabPlayMode, paramStoryVideoPublishStatusEvent));
        ((BatchGetVideoInfo)localObject1).b();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        GetFeedFeatureHandler.a(Collections.singletonList(this.jdField_a_of_type_JavaLangString));
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
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode.StoryVideoPublishStatusReceiver
 * JD-Core Version:    0.7.0.1
 */