package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$9
  implements View.OnClickListener
{
  AddFriendVerifyActivity$9(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyActivity.i(this.e);
    Object localObject;
    if ("".equals(this.a.getText().toString().trim()))
    {
      localObject = this.e;
      QQToast.makeText((Context)localObject, 0, ((AddFriendVerifyActivity)localObject).getString(2131886666), 0).show(this.e.getTitleBarHeight());
    }
    else if (NetworkUtil.isNetSupport(this.e))
    {
      localObject = this.e.getIntent().getStringExtra("extra");
      String str1 = this.a.getText().toString().trim();
      int i = this.e.getIntent().getIntExtra("sub_source_id", 0);
      String str2 = this.e.getIntent().getStringExtra("src_name");
      ((IFriendHandlerService)this.e.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(AddFriendVerifyActivity.d(this.e), (String)localObject, this.b, (byte)0, str1, this.c, i, false, null, false, null, str2, this.e.getIntent().getBundleExtra("flc_extra_param"), true);
    }
    else
    {
      localObject = this.e;
      QQToast.makeText((Context)localObject, 1, ((AddFriendVerifyActivity)localObject).getString(2131892104), 0).show(this.e.getTitleBarHeight());
    }
    ReportController.b(this.e.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.c), String.valueOf(this.d), "", "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportClickEvent action: 0X80077B4  sourceId = ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" subSourceId = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("AddFriendVerifyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.e.w)) {
      ReportController.b(this.e.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
    }
    this.e.a(this.c, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.9
 * JD-Core Version:    0.7.0.1
 */