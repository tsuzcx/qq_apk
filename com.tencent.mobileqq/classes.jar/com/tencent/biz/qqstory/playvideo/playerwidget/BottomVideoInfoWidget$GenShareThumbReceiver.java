package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper;
import com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.GenShareThumbEvent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class BottomVideoInfoWidget$GenShareThumbReceiver
  extends QQUIEventReceiver<BottomVideoInfoWidget, SendVideoToFriendHelper.GenShareThumbEvent>
{
  public BottomVideoInfoWidget$GenShareThumbReceiver(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget)
  {
    super(paramBottomVideoInfoWidget);
  }
  
  public void a(@NonNull BottomVideoInfoWidget paramBottomVideoInfoWidget, @NonNull SendVideoToFriendHelper.GenShareThumbEvent paramGenShareThumbEvent)
  {
    if (!TextUtils.equals(paramGenShareThumbEvent.b, String.valueOf(paramBottomVideoInfoWidget.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramBottomVideoInfoWidget.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramBottomVideoInfoWidget.l();
    if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
      if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        SendVideoToFriendHelper.a().a(paramBottomVideoInfoWidget.b(), paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
        return;
      }
      SendVideoToFriendHelper.a().a(paramBottomVideoInfoWidget.b(), paramGenShareThumbEvent.jdField_a_of_type_JavaLangString, paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramBottomVideoInfoWidget.hashCode());
      return;
    }
    SLog.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131701250), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return SendVideoToFriendHelper.GenShareThumbEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.GenShareThumbReceiver
 * JD-Core Version:    0.7.0.1
 */