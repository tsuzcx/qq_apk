package com.tencent.mobileqq.ark.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class ArkIDESettingFragment$3
  implements View.OnClickListener
{
  ArkIDESettingFragment$3(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(BaseActivity.sTopActivity, null);
    localActionSheet.setMainTitle(BaseActivity.sTopActivity.getString(2131690140));
    localActionSheet.addButton(2131690139, 3);
    localActionSheet.addCancelButton(2131690141);
    localActionSheet.setOnDismissListener(new ArkIDESettingFragment.3.1(this, localActionSheet));
    localActionSheet.setOnButtonClickListener(new ArkIDESettingFragment.3.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.3
 * JD-Core Version:    0.7.0.1
 */