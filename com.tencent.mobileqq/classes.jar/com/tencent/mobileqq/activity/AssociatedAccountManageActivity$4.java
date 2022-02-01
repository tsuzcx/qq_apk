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
    if ((paramView instanceof RotateSwitchImageView))
    {
      Object localObject1 = AssociatedAccountManageActivity.access$600(this.a, paramView);
      View localView = AssociatedAccountManageActivity.access$700(this.a, paramView);
      Object localObject2;
      if (AssociatedAccountManageActivity.access$800(this.a) == null)
      {
        AssociatedAccountManageActivity.access$802(this.a, (RotateSwitchImageView)paramView);
        AssociatedAccountManageActivity.access$800(this.a).b();
        if (localView != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(AssociatedAccountManageActivity.access$900(this.a) * 12.0F + AssociatedAccountManageActivity.access$1000(this.a) * 75.0F));
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if ((localObject1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject1).b();
        }
        if (AppSetting.e) {
          paramView.setContentDescription(this.a.getString(2131887795));
        }
      }
      else if (AssociatedAccountManageActivity.access$800(this.a) == paramView)
      {
        AssociatedAccountManageActivity.access$800(this.a).a();
        if (localView != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(AssociatedAccountManageActivity.access$1100(this.a) * 12.0F));
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if ((localObject1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject1).f();
        }
        AssociatedAccountManageActivity.access$802(this.a, null);
        if (AppSetting.e) {
          paramView.setContentDescription(this.a.getString(2131917725));
        }
      }
      else
      {
        AssociatedAccountManageActivity.access$800(this.a).a();
        localObject2 = this.a;
        localObject2 = AssociatedAccountManageActivity.access$700((AssociatedAccountManageActivity)localObject2, AssociatedAccountManageActivity.access$800((AssociatedAccountManageActivity)localObject2));
        RelativeLayout.LayoutParams localLayoutParams;
        if (localObject2 != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          localLayoutParams.rightMargin = ((int)(AssociatedAccountManageActivity.access$1200(this.a) * 12.0F));
          ((View)localObject2).setLayoutParams(localLayoutParams);
        }
        localObject2 = (RotateSwitchImageView)paramView;
        ((RotateSwitchImageView)localObject2).b();
        if (localView != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.rightMargin = ((int)(AssociatedAccountManageActivity.access$1300(this.a) * 12.0F + AssociatedAccountManageActivity.access$1400(this.a) * 75.0F));
          localView.setLayoutParams(localLayoutParams);
        }
        if (AppSetting.e)
        {
          paramView.setContentDescription(this.a.getString(2131887795));
          AssociatedAccountManageActivity.access$800(this.a).setContentDescription(this.a.getString(2131917725));
        }
        if ((localObject1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject1).b();
        }
        localObject1 = this.a;
        localObject1 = AssociatedAccountManageActivity.access$600((AssociatedAccountManageActivity)localObject1, AssociatedAccountManageActivity.access$800((AssociatedAccountManageActivity)localObject1));
        if ((localObject1 instanceof ShaderAnimLayout)) {
          ((ShaderAnimLayout)localObject1).f();
        }
        AssociatedAccountManageActivity.access$802(this.a, (RotateSwitchImageView)localObject2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.4
 * JD-Core Version:    0.7.0.1
 */