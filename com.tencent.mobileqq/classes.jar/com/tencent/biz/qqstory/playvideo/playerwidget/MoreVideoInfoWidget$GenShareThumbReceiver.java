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
    if (!TextUtils.equals(paramGenShareThumbEvent.c, String.valueOf(paramMoreVideoInfoWidget.hashCode()))) {
      return;
    }
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)paramMoreVideoInfoWidget.d()).r();
    if (localVideoViewVideoHolder != null) {
      localVideoViewVideoHolder.c(false);
    }
    paramMoreVideoInfoWidget.E();
    if (paramGenShareThumbEvent.g.isSuccess())
    {
      SLog.a(this.TAG, "generate thumbnail success. shareThumbPath = %s.", paramGenShareThumbEvent.b);
      if (paramGenShareThumbEvent.a.mIsPicture == 1)
      {
        SendVideoToFriendHelper.a().a(paramMoreVideoInfoWidget.y(), paramGenShareThumbEvent.b);
        return;
      }
      SendVideoToFriendHelper.a().a(paramMoreVideoInfoWidget.y(), paramGenShareThumbEvent.b, paramGenShareThumbEvent.a, paramMoreVideoInfoWidget.hashCode());
      return;
    }
    SLog.e(this.TAG, "send video to friend failed because generate thumbnail failed.");
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131904758), 0).show();
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