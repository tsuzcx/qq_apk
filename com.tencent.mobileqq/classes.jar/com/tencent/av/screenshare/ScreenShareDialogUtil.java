package com.tencent.av.screenshare;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ScreenShareDialogUtil
{
  public static QQCustomDialog a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    ScreenShareQQCustomDialog localScreenShareQQCustomDialog = new ScreenShareQQCustomDialog(paramContext, 2131756189, paramString2, paramBoolean, paramInt);
    localScreenShareQQCustomDialog.setContentView(2131558978);
    localScreenShareQQCustomDialog.setCanceledOnTouchOutside(false);
    localScreenShareQQCustomDialog.setTitle(paramString1);
    localScreenShareQQCustomDialog.setMessage(paramCharSequence);
    localScreenShareQQCustomDialog.a(Typeface.DEFAULT_BOLD, paramContext.getResources().getColorStateList(2131165557));
    localScreenShareQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
    localScreenShareQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
    return localScreenShareQQCustomDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareDialogUtil
 * JD-Core Version:    0.7.0.1
 */