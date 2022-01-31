package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneUnityVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private String a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      super.setResult(-1, paramIntent);
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561146);
    super.setTitle(getString(2131695183));
    this.leftView.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693339);
    this.rightViewText.setOnClickListener(this);
    paramBundle = (Button)super.findViewById(2131371794);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    paramBundle = super.getIntent();
    if (paramBundle != null) {
      this.a = paramBundle.getStringExtra("url");
    }
    return true;
  }
  
  public boolean onBackEvent()
  {
    super.setResult(-1, new Intent());
    super.finish();
    super.overridePendingTransition(0, 2130772001);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371794: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.getCurrentAccountUin());
      paramView.putExtra("url", this.a);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("portraitOnly", true);
      paramView.putExtra("isShowAd", false);
      paramView.putExtra("needResult", true);
      paramView.putExtra("business", 16384L);
      super.startActivityForResult(paramView, 1001);
      return;
    }
    super.setResult(-1, new Intent());
    super.finish();
    super.overridePendingTransition(0, 2130772001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityVerifyActivity
 * JD-Core Version:    0.7.0.1
 */