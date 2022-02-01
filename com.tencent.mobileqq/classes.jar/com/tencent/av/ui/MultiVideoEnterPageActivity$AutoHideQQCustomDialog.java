package com.tencent.av.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$AutoHideQQCustomDialog
  extends QQCustomDialog
{
  public MultiVideoEnterPageActivity$AutoHideQQCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new AutoHideQQCustomDialog(paramContext, 2131953338);
    paramContext.setContentView(2131624611);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWindowFocusChanged, hasFocus[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w("MultiVideoEnterPageActivity", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.AutoHideQQCustomDialog
 * JD-Core Version:    0.7.0.1
 */