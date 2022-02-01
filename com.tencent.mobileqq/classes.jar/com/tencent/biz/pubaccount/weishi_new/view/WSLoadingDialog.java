package com.tencent.biz.pubaccount.weishi_new.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

public class WSLoadingDialog
  extends Dialog
{
  private View a;
  private String b;
  
  public WSLoadingDialog(Context paramContext, String paramString)
  {
    super(paramContext, 2131952648);
    this.b = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131626463, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSLoadingDialog
 * JD-Core Version:    0.7.0.1
 */