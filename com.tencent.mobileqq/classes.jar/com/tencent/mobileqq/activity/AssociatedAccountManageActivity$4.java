package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociatedAccountManageActivity$4
  implements View.OnClickListener
{
  AssociatedAccountManageActivity$4(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView instanceof RotateSwitchImageView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView1 = AssociatedAccountManageActivity.a(this.a, paramView);
      View localView2 = AssociatedAccountManageActivity.b(this.a, paramView);
      Object localObject;
      if (AssociatedAccountManageActivity.a(this.a) == null)
      {
        AssociatedAccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
        AssociatedAccountManageActivity.a(this.a).b();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.a(this.a) * 12.0F + AssociatedAccountManageActivity.b(this.a) * 75.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
        if (AppSetting.d) {
          paramView.setContentDescription(this.a.getString(2131690930));
        }
      }
      else if (AssociatedAccountManageActivity.a(this.a) == paramView)
      {
        AssociatedAccountManageActivity.a(this.a).a();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.c(this.a) * 12.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).f();
        }
        AssociatedAccountManageActivity.a(this.a, null);
        if (AppSetting.d) {
          paramView.setContentDescription(this.a.getString(2131720361));
        }
      }
      else
      {
        AssociatedAccountManageActivity.a(this.a).a();
        localObject = AssociatedAccountManageActivity.b(this.a, AssociatedAccountManageActivity.a(this.a));
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.rightMargin = ((int)(AssociatedAccountManageActivity.d(this.a) * 12.0F));
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
        ((RotateSwitchImageView)paramView).b();
        if (localView2 != null)
        {
          localObject = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(AssociatedAccountManageActivity.e(this.a) * 12.0F + AssociatedAccountManageActivity.f(this.a) * 75.0F));
          localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if (AppSetting.d)
        {
          paramView.setContentDescription(this.a.getString(2131690930));
          AssociatedAccountManageActivity.a(this.a).setContentDescription(this.a.getString(2131720361));
        }
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).b();
        }
        localView1 = AssociatedAccountManageActivity.a(this.a, AssociatedAccountManageActivity.a(this.a));
        if ((localView1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localView1).f();
        }
        AssociatedAccountManageActivity.a(this.a, (RotateSwitchImageView)paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.4
 * JD-Core Version:    0.7.0.1
 */