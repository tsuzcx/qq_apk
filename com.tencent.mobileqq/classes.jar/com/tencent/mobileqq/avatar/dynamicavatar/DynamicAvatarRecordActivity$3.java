package com.tencent.mobileqq.avatar.dynamicavatar;

import android.view.View;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DynamicAvatarRecordActivity$3
  implements ActionSheet.OnButtonClickListener
{
  DynamicAvatarRecordActivity$3(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.a.e.a("DynamicAvatarRecordActivity");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.3
 * JD-Core Version:    0.7.0.1
 */