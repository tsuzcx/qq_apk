package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleVideoPlayMode$GetVideoBasicInfoListReceiver
  extends QQUIEventReceiver
{
  public SingleVideoPlayMode$GetVideoBasicInfoListReceiver(@NonNull SingleVideoPlayMode paramSingleVideoPlayMode)
  {
    super(paramSingleVideoPlayMode);
  }
  
  public void a(@NonNull SingleVideoPlayMode paramSingleVideoPlayMode, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if ((paramGetVideoBasicInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList == null) || (paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList == null) || (paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    Activity localActivity = paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a;
    paramGetVideoBasicInfoListEvent = paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList.iterator();
    label181:
    while (paramGetVideoBasicInfoListEvent.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramGetVideoBasicInfoListEvent.next();
      int j = paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label181;
        }
        Object localObject = (StoryVideoItem)paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localStoryVideoItem.equals(localObject))
        {
          ((StoryVideoItem)localObject).copy(localStoryVideoItem);
          localObject = (VideoPlayerPagerAdapter.VideoViewHolder)paramSingleVideoPlayMode.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if ((localObject == null) || (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).c != i)) {
            break;
          }
          PlayModeUtils.a(localActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localStoryVideoItem, null);
          break;
        }
        i += 1;
      }
    }
    paramSingleVideoPlayMode.a(0);
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.SingleVideoPlayMode.GetVideoBasicInfoListReceiver
 * JD-Core Version:    0.7.0.1
 */