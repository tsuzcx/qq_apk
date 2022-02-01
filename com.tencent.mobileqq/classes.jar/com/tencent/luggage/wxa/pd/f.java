package com.tencent.luggage.wxa.pd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import kotlin.jvm.JvmStatic;

public class f
{
  @JvmStatic
  public static ProgressDialog a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return WeUIProgresssDialog.show(paramContext, paramCharSequence, paramBoolean, paramOnCancelListener);
  }
  
  @JvmStatic
  public static MMAlertDialog a(Context paramContext, String paramString)
  {
    paramContext = new MMAlertDialog.Builder(paramContext).setTitle(paramString).create();
    paramContext.show();
    return paramContext;
  }
  
  @JvmStatic
  public static MMAlertDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new MMAlertDialog.Builder(paramContext).setTitle(paramString1).setPositiveBtnText(paramString2).setPositiveBtnListener(paramOnClickListener).create();
    paramContext.show();
    return paramContext;
  }
  
  @JvmStatic
  public static MMAlertDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new MMAlertDialog.Builder(paramContext).setTitle(paramString2).setMsg(paramString1).setPositiveBtnText(paramString3).setPositiveBtnListener(paramOnClickListener1).setNegativeBtnText(paramString4).setNegativeBtnListener(paramOnClickListener2).create();
    paramContext.show();
    return paramContext;
  }
  
  @JvmStatic
  public static MMAlertDialog a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new MMAlertDialog.Builder(paramContext).setTitle(paramString2).setMsg(paramString1).setPositiveBtnText(2131891475).setPositiveBtnListener(paramOnClickListener).setCancelable(paramBoolean).create();
    paramContext.show();
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.f
 * JD-Core Version:    0.7.0.1
 */