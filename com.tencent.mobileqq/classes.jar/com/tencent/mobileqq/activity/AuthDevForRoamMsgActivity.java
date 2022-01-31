package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import rky;

public class AuthDevForRoamMsgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  Handler.Callback a;
  public QQProgressDialog a;
  
  public AuthDevForRoamMsgActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new rky(this);
  }
  
  private void a()
  {
    MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)this.app.a(59);
    if (localMessageRoamHandler != null)
    {
      localMessageRoamHandler.a((short)1);
      if (QLog.isColorLevel()) {
        QLog.d("AuthDevForRoamMsgActivity", 2, "set_roam_message_auth_mode: 1");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在开启...");
      if (!isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthDevForRoamMsgActivity", 2, "not verify passwd");
        }
        setResult(0);
        finish();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthDevForRoamMsgActivity", 2, "verify passwd ok ");
        }
        a();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970883);
    super.setTitle(2131430651);
    super.findViewById(2131372075).setOnClickListener(this);
    super.findViewById(2131372076).setOnClickListener(this);
    paramBundle = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.app.setHandler(getClass(), paramBundle);
    VipUtils.a(this.app, "chat_history", "LockSet", "switch_devlock", 1, 0, new String[0]);
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034121, 2131034122);
  }
  
  protected boolean onBackEvent()
  {
    setResult(0);
    boolean bool = super.onBackEvent();
    overridePendingTransition(2131034121, 2131034122);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372075)
    {
      findViewById(2131372075).setEnabled(false);
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "switch_devlock"));
      VipUtils.a(this.app, "chat_history", "LockSet", "Clk_usedevlock", 1, 0, new String[0]);
      startActivityForResult(paramView, 10000);
    }
    while (paramView.getId() != 2131372076) {
      return;
    }
    VipUtils.a(this.app, "chat_history", "LockSet", "Clk_PswUse", 2, 0, new String[0]);
    setResult(0);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevForRoamMsgActivity
 * JD-Core Version:    0.7.0.1
 */