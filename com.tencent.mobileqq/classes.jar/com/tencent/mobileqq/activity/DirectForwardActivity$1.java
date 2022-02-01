package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.utils.ContactUtils;

class DirectForwardActivity$1
  implements Runnable
{
  DirectForwardActivity$1(DirectForwardActivity paramDirectForwardActivity, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    String str = ((ITeamWorkHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).convertCryptoUinToTrueUin(this.jdField_a_of_type_JavaLangString, this.b, this.c);
    if (TextUtils.isEmpty(str))
    {
      this.this$0.finish();
      return;
    }
    this.this$0.getIntent().putExtra("uinname", ContactUtils.a(this.this$0.app, str, this.jdField_a_of_type_Int));
    this.this$0.getIntent().putExtra("uin", str);
    this.this$0.runOnUiThread(new DirectForwardActivity.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity.1
 * JD-Core Version:    0.7.0.1
 */