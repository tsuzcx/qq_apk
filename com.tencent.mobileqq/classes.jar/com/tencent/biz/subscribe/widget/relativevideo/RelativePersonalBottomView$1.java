package com.tencent.biz.subscribe.widget.relativevideo;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativePersonalBottomView$1
  implements RadioGroup.OnCheckedChangeListener
{
  RelativePersonalBottomView$1(RelativePersonalBottomView paramRelativePersonalBottomView) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (RelativePersonalBottomView.a(this.a).getId() == paramInt)
    {
      RelativePersonalBottomView.b(this.a).setCurrentItem(0);
    }
    else if (RelativePersonalBottomView.c(this.a).getId() == paramInt)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 23) {
        bool = PermissionUtils.isStorePermissionEnable(this.a.getContext());
      } else {
        bool = true;
      }
      if (!bool)
      {
        DialogUtil.a((PublicFragmentActivity)this.a.getContext());
        RelativePersonalBottomView.d(this.a).getChildAt(0).performClick();
      }
      else
      {
        RelativePersonalBottomView.b(this.a).setCurrentItem(1);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.1
 * JD-Core Version:    0.7.0.1
 */