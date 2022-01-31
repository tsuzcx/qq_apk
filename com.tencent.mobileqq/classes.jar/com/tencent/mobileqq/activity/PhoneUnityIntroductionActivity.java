package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class PhoneUnityIntroductionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      if (this.a == 9)
      {
        super.setResult(paramInt2);
        super.finish();
        ReportController.b(this.app, "CliOper", "", "", "0X8006EF9", "0X8006EF9", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    paramIntent.putExtra("kSrouce", this.a);
    paramIntent.putExtra("kBindNew", true);
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("selfSet_leftViewText", getString(2131436773));
    super.startActivity(paramIntent);
    super.setResult(paramInt2);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970475);
    super.setTitle(getString(2131436819));
    super.setContentBackgroundResource(2130838210);
    this.a = super.getIntent().getIntExtra("kSrouce", -1);
    if (this.a == 0)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8005B74", "0X8005B74", 1, 0, "", "", "", "");
      if ((this.a == 1) || (this.a == 9)) {}
      switch (this.a)
      {
      default: 
        paramBundle = "关闭";
        label119:
        this.leftView.setText(paramBundle);
        if (AppSetting.b) {
          this.leftView.setContentDescription(paramBundle);
        }
        paramBundle = (TextView)super.findViewById(2131365405);
        if (this.a == 9)
        {
          String str = ((PhoneContactManagerImp)this.app.getManager(10)).b();
          if (!TextUtils.isEmpty(str))
          {
            paramBundle.setText(str);
            label188:
            ReportController.b(this.app, "dc00898", "", "", "0X8006899", "0X8006899", 0, 0, "", "", "", "");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramBundle = (Button)super.findViewById(2131370825);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(this);
      }
      return true;
      if (this.a != 1) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005B74", "0X8005B74", 2, 0, "", "", "", "");
      break;
      paramBundle = "设置";
      break label119;
      paramBundle.setText(2131436823);
      break label188;
      paramBundle.setGravity(3);
    }
  }
  
  protected void doOnDestroy()
  {
    try
    {
      ActivityLeakSolution.a(this);
      super.doOnDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370825)
    {
      if (NetworkUtil.d(this)) {
        break label40;
      }
      if (!isFinishing()) {
        QQToast.a(this, 0, 2131434596, 0).b(super.getTitleBarHeight());
      }
    }
    label40:
    do
    {
      return;
      if (this.a == 9)
      {
        ContactUtils.a(2);
        ReportController.b(this.app, "dc00898", "", "", "0X800689A", "0X800689A", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        paramView = new Intent(this, BindNumberActivity.class);
        if (this.a != 9) {
          paramView.putExtra("cmd_param_is_from_uni", true);
        }
        paramView.putExtra("cmd_param_is_from_change_bind", false);
        paramView.putExtra("kSrouce", this.a);
        super.startActivityForResult(paramView, 1);
        if (this.a != 0) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005B75", "0X8005B75", 1, 0, "", "", "", "");
        return;
        if (this.a == 1) {
          ContactUtils.a(3);
        }
      }
    } while (this.a != 1);
    ReportController.b(this.app, "CliOper", "", "", "0X8005B75", "0X8005B75", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityIntroductionActivity
 * JD-Core Version:    0.7.0.1
 */