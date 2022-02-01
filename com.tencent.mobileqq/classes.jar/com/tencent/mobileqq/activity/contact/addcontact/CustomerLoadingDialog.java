package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class CustomerLoadingDialog
  extends ReportDialog
{
  private View a;
  private String b;
  
  public CustomerLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131952648);
  }
  
  public CustomerLoadingDialog(Context paramContext, String paramString)
  {
    super(paramContext, 2131952648);
    this.b = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131627937, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 48;
    localLayoutParams.y += getContext().getResources().getDimensionPixelOffset(2131300012);
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!TextUtils.isEmpty(this.b))
    {
      localObject = (TextView)paramBundle.findViewById(2131438913);
      if (localObject != null) {
        ((TextView)localObject).setText(this.b);
      }
    }
    this.a = paramBundle;
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.CustomerLoadingDialog
 * JD-Core Version:    0.7.0.1
 */