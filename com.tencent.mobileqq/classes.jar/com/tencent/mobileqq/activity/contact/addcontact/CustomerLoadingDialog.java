package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class CustomerLoadingDialog
  extends Dialog
{
  public CustomerLoadingDialog(Context paramContext)
  {
    super(paramContext, 2131624537);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = LayoutInflater.from(getContext()).inflate(2130970689, null);
    paramBundle = getWindow();
    paramBundle.setContentView((View)localObject);
    localObject = paramBundle.getAttributes();
    ((WindowManager.LayoutParams)localObject).width = -2;
    ((WindowManager.LayoutParams)localObject).height = -2;
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    ((WindowManager.LayoutParams)localObject).y += getContext().getResources().getDimensionPixelOffset(2131559042);
    paramBundle.setAttributes((WindowManager.LayoutParams)localObject);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.CustomerLoadingDialog
 * JD-Core Version:    0.7.0.1
 */