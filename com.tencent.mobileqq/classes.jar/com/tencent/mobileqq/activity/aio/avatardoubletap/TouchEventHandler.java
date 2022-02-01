package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class TouchEventHandler
{
  public void a(View paramView, Context paramContext)
  {
    if (AppSetting.d) {
      return;
    }
    paramView = (VasAvatar)paramView;
    AvatarOnGestureListener localAvatarOnGestureListener = new AvatarOnGestureListener();
    paramContext = new AvatarGestureDetector(paramContext, localAvatarOnGestureListener, new Handler(Looper.getMainLooper()));
    localAvatarOnGestureListener.a(paramContext);
    paramView.setOnTouchListener(new TouchEventHandler.1(this));
    paramView.setTag(2131362333, paramContext);
    paramContext.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.TouchEventHandler
 * JD-Core Version:    0.7.0.1
 */