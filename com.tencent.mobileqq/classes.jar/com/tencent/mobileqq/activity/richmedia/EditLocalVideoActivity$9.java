package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet.OnDismissListener;
import cooperation.qzone.RDMEtraMsgCollector;

class EditLocalVideoActivity$9
  implements ActionSheet.OnDismissListener
{
  EditLocalVideoActivity$9(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onDismiss()
  {
    String str = "[Actvity]" + getClass().getSimpleName() + " QQCustomDialog click :" + HardCodeUtil.a(2131703674);
    RDMEtraMsgCollector.getInstance().addUserAction(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.9
 * JD-Core Version:    0.7.0.1
 */