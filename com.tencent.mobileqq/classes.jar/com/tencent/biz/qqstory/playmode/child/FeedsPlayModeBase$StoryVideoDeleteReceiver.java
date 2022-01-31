package com.tencent.biz.qqstory.playmode.child;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class FeedsPlayModeBase$StoryVideoDeleteReceiver
  extends QQUIEventReceiver
{
  public FeedsPlayModeBase$StoryVideoDeleteReceiver(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase)
  {
    super(paramFeedsPlayModeBase);
  }
  
  public void a(@NonNull FeedsPlayModeBase paramFeedsPlayModeBase, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    paramFeedsPlayModeBase.r();
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "delelte onEvent");
    }
    if (paramDeleteStoryVideoEvent.errorInfo.isSuccess()) {
      paramFeedsPlayModeBase.a(paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString, paramDeleteStoryVideoEvent.b, paramDeleteStoryVideoEvent.c);
    }
    if ((!paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean) && (paramDeleteStoryVideoEvent.errorInfo.isFail()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "删除失败：" + paramDeleteStoryVideoEvent.getErrorMessage());
      }
      QQToast.a(paramFeedsPlayModeBase.a.getContext(), 1, "删除失败，请稍后重试", 0).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase.StoryVideoDeleteReceiver
 * JD-Core Version:    0.7.0.1
 */