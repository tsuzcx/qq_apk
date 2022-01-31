package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopStoryForAIOPlayMode$StoryVideoTagUpdateReceiver
  extends QQUIEventReceiver
{
  public TroopStoryForAIOPlayMode$StoryVideoTagUpdateReceiver(@NonNull TroopStoryForAIOPlayMode paramTroopStoryForAIOPlayMode)
  {
    super(paramTroopStoryForAIOPlayMode);
  }
  
  public void a(@NonNull TroopStoryForAIOPlayMode paramTroopStoryForAIOPlayMode, @NonNull GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent paramGetStoryPlayerTagInfoEvent)
  {
    SLog.b(this.TAG, "StoryVideoTagUpdateReceiver onEvent.");
    List localList1 = paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_JavaUtilList;
    List localList2 = paramGetStoryPlayerTagInfoEvent.b;
    if ((paramGetStoryPlayerTagInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (localList2 == null)) {
      SLog.e(this.TAG, "StoryVideoTagUpdateReceiver onEvent: failed.");
    }
    int i;
    do
    {
      return;
      SLog.b(this.TAG, "---------------onEvent start----------------------");
      paramGetStoryPlayerTagInfoEvent = paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      StoryVideoItem localStoryVideoItem;
      while (paramGetStoryPlayerTagInfoEvent.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)paramGetStoryPlayerTagInfoEvent.next();
        SLog.b(this.TAG, localStoryVideoItem.mVid);
      }
      SLog.a(this.TAG, "adapter size = %s", Integer.valueOf(paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.size()));
      SLog.b(this.TAG, "---------------onEvent end------------------------");
      paramGetStoryPlayerTagInfoEvent = paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramGetStoryPlayerTagInfoEvent.hasNext())
      {
        localStoryVideoItem = (StoryVideoItem)paramGetStoryPlayerTagInfoEvent.next();
        GetStoryPlayerTagInfoRequest.TagInfoBaseVidList localTagInfoBaseVidList = GetStoryPlayerTagInfoHandler.a(localStoryVideoItem.mVid, localList2);
        if (localTagInfoBaseVidList != null) {
          localStoryVideoItem.mTagInfoBase = localTagInfoBaseVidList.a;
        } else if (localList1.contains(localStoryVideoItem.mVid)) {
          localStoryVideoItem.mTagInfoBase = null;
        }
      }
      i = paramTroopStoryForAIOPlayMode.b;
      paramGetStoryPlayerTagInfoEvent = (VideoPlayerPagerAdapter.VideoViewHolder)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if ((paramGetStoryPlayerTagInfoEvent != null) && (i >= 0) && (i < paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        PlayModeUtils.a(paramGetStoryPlayerTagInfoEvent, ((StoryVideoItem)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.get(i)).mTagInfoBase);
      }
      paramGetStoryPlayerTagInfoEvent = (VideoPlayerPagerAdapter.VideoViewHolder)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_AndroidUtilSparseArray.get(i - 1);
      if ((paramGetStoryPlayerTagInfoEvent != null) && (i - 1 >= 0) && (i - 1 < paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.size())) {
        PlayModeUtils.a(paramGetStoryPlayerTagInfoEvent, ((StoryVideoItem)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.get(i - 1)).mTagInfoBase);
      }
      paramGetStoryPlayerTagInfoEvent = (VideoPlayerPagerAdapter.VideoViewHolder)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_AndroidUtilSparseArray.get(i + 1);
    } while ((paramGetStoryPlayerTagInfoEvent == null) || (i + 1 < 0) || (i + 1 >= paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.size()));
    PlayModeUtils.a(paramGetStoryPlayerTagInfoEvent, ((StoryVideoItem)paramTroopStoryForAIOPlayMode.a.jdField_a_of_type_JavaUtilArrayList.get(i + 1)).mTagInfoBase);
  }
  
  public Class acceptEventClass()
  {
    return GetStoryPlayerTagInfoHandler.GetStoryPlayerTagInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.TroopStoryForAIOPlayMode.StoryVideoTagUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */