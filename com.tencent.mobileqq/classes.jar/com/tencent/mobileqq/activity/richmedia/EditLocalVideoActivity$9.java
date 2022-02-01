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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Actvity]");
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" QQCustomDialog click :");
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131898212));
    localObject = ((StringBuilder)localObject).toString();
    RDMEtraMsgCollector.getInstance().addUserAction((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.9
 * JD-Core Version:    0.7.0.1
 */