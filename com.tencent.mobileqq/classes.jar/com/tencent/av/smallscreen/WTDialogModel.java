package com.tencent.av.smallscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.BaseActivity;

public class WTDialogModel
  extends DialogModelBase
{
  private QQCustomDialog b = null;
  private int c = 1;
  private String d = null;
  
  public WTDialogModel(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private void e()
  {
    this.b = DialogUtil.a(this.a, 230).setTitle(null).setMessage(this.d).setNegativeButton(2131893757, new WTDialogModel.1(this));
    this.b.setCancelable(false);
  }
  
  protected void a()
  {
    if ((this.c == 1) && (this.b == null))
    {
      e();
      QQCustomDialog localQQCustomDialog = this.b;
      if (localQQCustomDialog != null) {
        a("WTDialogModel.onResume", localQQCustomDialog);
      }
    }
    else
    {
      this.a.finish();
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    paramBundle = this.a.getIntent();
    this.c = paramBundle.getIntExtra("tag_style", 1);
    this.d = paramBundle.getStringExtra("tag_msg");
    if ((this.c == 1) && (TextUtils.isEmpty(this.d))) {
      this.a.finish();
    }
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d()
  {
    QQCustomDialog localQQCustomDialog = this.b;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.WTDialogModel
 * JD-Core Version:    0.7.0.1
 */