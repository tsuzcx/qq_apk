package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class NewFriendsPlayMode$GenShareThumbReceiver
  extends QQUIEventReceiver
{
  public NewFriendsPlayMode$GenShareThumbReceiver(@NonNull NewFriendsPlayMode paramNewFriendsPlayMode)
  {
    super(paramNewFriendsPlayMode);
  }
  
  public void a(@NonNull NewFriendsPlayMode paramNewFriendsPlayMode, @NonNull NewFriendsPlayMode.GenShareThumbEvent paramGenShareThumbEvent)
  {
    paramNewFriendsPlayMode.s();
    paramNewFriendsPlayMode.r();
    if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.a("Q.qqstory.player.NewFriendsPlayMode", "generate thumbnail success. shareThumbPath = %s.", paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
      if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 0)
      {
        NewFriendsPlayMode.a(paramNewFriendsPlayMode).a(paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
        NewFriendsPlayMode.a(paramNewFriendsPlayMode).a(paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      paramNewFriendsPlayMode.a(paramNewFriendsPlayMode.a.getContext(), paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
      return;
    }
    SLog.e("Q.qqstory.player.NewFriendsPlayMode", "send video to friend failed because generate thumbnail failed.");
    QQToast.a(VideoPlayModeBase.a(), 1, "发送失败，请稍后重试", 0).a();
  }
  
  public Class acceptEventClass()
  {
    return NewFriendsPlayMode.GenShareThumbEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode.GenShareThumbReceiver
 * JD-Core Version:    0.7.0.1
 */