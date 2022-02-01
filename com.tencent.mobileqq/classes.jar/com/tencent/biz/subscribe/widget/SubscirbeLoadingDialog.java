package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.contact.addcontact.CustomerLoadingDialog;

public class SubscirbeLoadingDialog
  extends CustomerLoadingDialog
{
  public SubscirbeLoadingDialog(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    localLayoutParams.y -= getContext().getResources().getDimensionPixelOffset(2131300012);
    paramBundle.setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscirbeLoadingDialog
 * JD-Core Version:    0.7.0.1
 */