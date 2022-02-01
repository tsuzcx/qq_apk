package com.tencent.mobileqq.activity.contact.newfriend;

import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddRequestSuspiciousMsgFragment$2
  implements ActionSheet.OnButtonClickListener
{
  AddRequestSuspiciousMsgFragment$2(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (NetworkUtil.isNetSupport(this.b.getBaseActivity()))
      {
        paramView = this.b.getBaseActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AddRequestSuspiciousMsgFragment.a(this.b).uin);
        localStringBuilder.append("");
        NewReportPlugin.a(paramView, localStringBuilder.toString(), null, AddRequestSuspiciousMsgFragment.d(this.b).getCurrentAccountUin(), 20010, null);
      }
      else
      {
        QQToast.makeText(this.b.getBaseActivity(), 2131892104, 0).show();
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment.2
 * JD-Core Version:    0.7.0.1
 */