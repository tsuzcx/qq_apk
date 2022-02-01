package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddRequestActivity$4
  implements ActionSheet.OnButtonClickListener
{
  AddRequestActivity$4(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramView = this.b;
        NewReportPlugin.a(paramView, paramView.a, null, this.b.app.getCurrentAccountUin(), 20010, null);
      }
      else
      {
        QQToast.makeText(this.b, 2131892104, 0).show(this.b.getTitleBarHeight());
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.4
 * JD-Core Version:    0.7.0.1
 */