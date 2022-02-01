package com.tencent.av.ui;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.BaseActivity;

public class VideoControlUI$QavStatusBar
{
  View a;
  View b;
  
  VideoControlUI$QavStatusBar(View paramView)
  {
    this.a = paramView.findViewById(2131373614);
    this.b = paramView.getRootView().findViewById(2131373615);
  }
  
  static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null)
    {
      if (this.a == null) {
        return;
      }
      if (ImmersiveUtils.isSupporImmersive() != 1)
      {
        this.a.setVisibility(8);
        paramBaseActivity = this.b;
        if (paramBaseActivity != null) {
          paramBaseActivity.setVisibility(8);
        }
        return;
      }
      int i = ImmersiveUtils.getStatusBarHeight(paramBaseActivity);
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append("adjust, height[");
      paramBaseActivity.append(i);
      paramBaseActivity.append("]");
      QLog.w("QavStatusBar", 1, paramBaseActivity.toString());
      if (i > 0)
      {
        a(this.a, i);
        a(this.b, i);
      }
      if (AudioHelper.a(0) == 1)
      {
        this.a.setBackgroundColor(2140405971);
        paramBaseActivity = this.b;
        if (paramBaseActivity != null) {
          paramBaseActivity.setBackgroundColor(2140405971);
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBackgroundColor, bDoubleScreen[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w("QavStatusBar", 1, localStringBuilder.toString());
      if (paramBoolean)
      {
        this.a.setBackgroundColor(-16777216);
        return;
      }
      this.a.setBackgroundColor(0);
    }
  }
  
  public boolean a()
  {
    View localView = this.a;
    return (localView != null) && (localView.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.QavStatusBar
 * JD-Core Version:    0.7.0.1
 */