package com.tencent.biz.qqstory.playmode.child;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.GetVideoBasicInfoListEvent;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyMemoryPlayMode$GetVideoBasicListReceiver
  extends QQUIEventReceiver
{
  public MyMemoryPlayMode$GetVideoBasicListReceiver(@NonNull VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(@NonNull VideoPlayModeBase paramVideoPlayModeBase, @NonNull VidToBasicInfoHandler.GetVideoBasicInfoListEvent paramGetVideoBasicInfoListEvent)
  {
    if ((paramGetVideoBasicInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    Activity localActivity = paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a;
    paramGetVideoBasicInfoListEvent = paramGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList.iterator();
    label162:
    for (;;)
    {
      label37:
      Object localObject;
      int j;
      int i;
      if (paramGetVideoBasicInfoListEvent.hasNext())
      {
        localObject = (StoryVideoItem)paramGetVideoBasicInfoListEvent.next();
        j = paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label162;
        }
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (((StoryVideoItem)localObject).equals(localStoryVideoItem))
        {
          localStoryVideoItem.copy(localObject);
          localObject = (VideoPlayerPagerAdapter.VideoViewHolder)paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if ((localObject == null) || (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).c != i)) {
            break label37;
          }
          PlayModeUtils.a(localActivity, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localStoryVideoItem, localStoryVideoItem.mStoryType);
          break label37;
          break;
        }
        i += 1;
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToBasicInfoHandler.GetVideoBasicInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.MyMemoryPlayMode.GetVideoBasicListReceiver
 * JD-Core Version:    0.7.0.1
 */