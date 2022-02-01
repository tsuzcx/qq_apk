package com.tencent.mobileqq.activity.phone;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  static final int MSG_FINISH = 2;
  static final int MSG_PROGRESS = 1;
  public static final int RESULT_START_NUMBER = 2;
  public static final int RESULT_USER_CANCEL = 1;
  private View mContentView;
  protected IPhoneContactService mPhoneContactService;
  private DialogBaseActivity.UiHandler mUiHandler;
  QQProgressDialog progressDialog;
  
  protected boolean dismissProgressDialog()
  {
    boolean bool;
    if (this.mUiHandler.hasMessages(1))
    {
      this.mUiHandler.removeMessages(1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    QQProgressDialog localQQProgressDialog = this.progressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.progressDialog.setOnDismissListener(null);
      this.progressDialog = null;
      bool = true;
    }
    return bool;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mUiHandler = new DialogBaseActivity.UiHandler(this);
    this.mPhoneContactService = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class));
    return true;
  }
  
  void doShowProgressDialog(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.progressDialog == null))
    {
      this.progressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.progressDialog.setOnDismissListener(new DialogBaseActivity.4(this));
      this.progressDialog.c(paramInt);
      this.progressDialog.setCancelable(paramBoolean);
      this.progressDialog.setCanceledOnTouchOutside(false);
      this.progressDialog.show();
    }
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = this.mContentView;
    if (localView1 != null) {
      localView1 = localView1.findViewById(paramInt);
    } else {
      localView1 = null;
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setContentView(int paramInt)
  {
    this.mContentView = setContentViewB(paramInt);
  }
  
  protected String setLastActivityName()
  {
    return null;
  }
  
  protected void showConfirmFinish(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new DialogBaseActivity.1(this), null).show();
    }
  }
  
  void showConfirmSkipDialog(boolean paramBoolean)
  {
    if (!isFinishing())
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      String str1 = getResources().getString(2131694747);
      int i;
      if (paramBoolean) {
        i = 2131703408;
      } else {
        i = 2131703407;
      }
      String str2 = HardCodeUtil.a(i);
      if (paramBoolean) {
        i = 2131703411;
      } else {
        i = 2131703409;
      }
      String str3 = HardCodeUtil.a(i);
      DialogUtil.a(this, 230, str2, str1, HardCodeUtil.a(2131703410), str3, new DialogBaseActivity.2(this, paramBoolean), new DialogBaseActivity.3(this, paramBoolean)).show();
    }
  }
  
  protected void showFetalAndFinish(int paramInt, long paramLong)
  {
    if (!isFinishing())
    {
      showToast(paramInt);
      this.mUiHandler.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  protected void showProgressDialog(int paramInt, long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void showToast(int paramInt)
  {
    showToast(getResources().getString(paramInt));
  }
  
  protected void showToast(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected void showToast(String paramString)
  {
    showToast(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */