package com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.RDMEtraMsgCollector;

class EditLocalVideoActivity$8
  implements ActionSheet.OnButtonClickListener
{
  EditLocalVideoActivity$8(EditLocalVideoActivity paramEditLocalVideoActivity, Bundle paramBundle) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = new StringBuilder();
    paramView.append("[Actvity]");
    paramView.append(getClass().getSimpleName());
    paramView.append(" QQCustomDialog click :");
    paramView.append(HardCodeUtil.a(2131901767));
    paramView = paramView.toString();
    RDMEtraMsgCollector.getInstance().addUserAction(paramView);
    EditLocalVideoActivity.n(this.b).dismiss();
    EditLocalVideoActivity.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.8
 * JD-Core Version:    0.7.0.1
 */