package com.tencent.biz.subscribe.widget.relativevideo;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
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
    if (RelativePersonalBottomView.a(this.a).getId() == paramInt) {
      RelativePersonalBottomView.a(this.a).setCurrentItem(0);
    }
    while (RelativePersonalBottomView.b(this.a).getId() != paramInt)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(this.a.getContext());; bool = true)
    {
      if (!bool)
      {
        DialogUtil.a((PublicFragmentActivity)this.a.getContext());
        RelativePersonalBottomView.a(this.a).getChildAt(0).performClick();
        break;
      }
      RelativePersonalBottomView.a(this.a).setCurrentItem(1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.1
 * JD-Core Version:    0.7.0.1
 */