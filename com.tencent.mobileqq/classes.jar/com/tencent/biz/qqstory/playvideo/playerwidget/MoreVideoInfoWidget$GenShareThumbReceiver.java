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

public class MoreVideoInfoWidget$GenShareThumbReceiver
  extends QQUIEventReceiver<MoreVideoInfoWidget, SendVideoToFriendHelper.GenShareThumbEvent>
{
  public MoreVideoInfoWidget$GenShareThumbReceiver(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget)
  {
    super(paramMoreVideoInfoWidget);
  }
  
  public void a(@NonNull MoreVideoInfoWidget paramMoreVideoInfoWidget, @NonNull SendVideoToFriendHelper.GenShareThumbEvent paramGenShareThumbEvent)
  {
    if (!TextUtils.equals(paramGenShareThumbEvent.b, String.valueOf(paramMoreVideoInfoWidget.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramMoreVideoInfoWidget.a()).a();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramMoreVideoInfoWidget.l();
    if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
      if (paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
      {
        SendVideoToFriendHelper.a().a(paramMoreVideoInfoWidget.b(), paramGenShareThumbEvent.jdField_a_of_type_JavaLangString);
        return;
      }
      SendVideoToFriendHelper.a().a(paramMoreVideoInfoWidget.b(), paramGenShareThumbEvent.jdField_a_of_type_JavaLangString, paramGenShareThumbEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramMoreVideoInfoWidget.hashCode());
      return;
    }
    SLog.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131706913), 0).a();
  }
  
  public Class acceptEventClass()
  {
    return SendVideoToFriendHelper.GenShareThumbEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.GenShareThumbReceiver
 * JD-Core Version:    0.7.0.1
 */