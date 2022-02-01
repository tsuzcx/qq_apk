package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RIJUGCTipsUtils
{
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null)) {}
    do
    {
      return;
      localObject = paramActivity.getWindow().getDecorView();
    } while (!(localObject instanceof FrameLayout));
    Object localObject = (FrameLayout)localObject;
    if (RIJXTabConfigHandler.b().a()) {}
    for (int i = 2131560414;; i = 2131560413)
    {
      View localView = paramActivity.getLayoutInflater().inflate(i, (ViewGroup)localObject, false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = AIOUtils.a(6.0F, paramActivity.getResources());
      localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(paramActivity) + paramActivity.getResources().getDimensionPixelSize(2131299166) - AIOUtils.a(12.0F, paramActivity.getResources()));
      localView.setLayoutParams(localLayoutParams);
      paramActivity = (TextView)localView.findViewById(2131380647);
      if (paramActivity != null) {
        paramActivity.setText(RIJUGCAddAccountAladdinUtils.e());
      }
      ((FrameLayout)localObject).addView(localView);
      localView.setOnClickListener(new RIJUGCTipsUtils.1(localView));
      RIJThreadHandler.b().postDelayed(new RIJUGCTipsUtils.2(localView), RIJUGCAddAccountAladdinUtils.a() * 1000);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCTipsUtils
 * JD-Core Version:    0.7.0.1
 */