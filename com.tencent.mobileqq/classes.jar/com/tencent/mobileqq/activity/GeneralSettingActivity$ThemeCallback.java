package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import mqq.util.WeakReference;

class GeneralSettingActivity$ThemeCallback
  extends ThemeSwitchCallback
{
  WeakReference<SimpleUIChoiceView> weakColorfulSimple;
  WeakReference<View> weakSimpleUIChoiceView;
  
  GeneralSettingActivity$ThemeCallback(SimpleUIChoiceView paramSimpleUIChoiceView, View paramView)
  {
    this.weakColorfulSimple = new WeakReference(paramSimpleUIChoiceView);
    this.weakSimpleUIChoiceView = new WeakReference(paramView);
  }
  
  public boolean postSwitch(int paramInt)
  {
    SimpleUIChoiceView localSimpleUIChoiceView = (SimpleUIChoiceView)this.weakColorfulSimple.get();
    View localView = (View)this.weakSimpleUIChoiceView.get();
    if ((localSimpleUIChoiceView != null) && (localView != null)) {
      localView.post(new GeneralSettingActivity.ThemeCallback.1(this, localSimpleUIChoiceView, localView));
    }
    return super.postSwitch(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.ThemeCallback
 * JD-Core Version:    0.7.0.1
 */