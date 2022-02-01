package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class GdtMotiveVideoDialog$MyDismissListener
  implements DialogInterface.OnDismissListener
{
  WeakReference<GdtMotiveVideoDialog> a;
  
  public GdtMotiveVideoDialog$MyDismissListener(GdtMotiveVideoDialog paramGdtMotiveVideoDialog)
  {
    this.a = new WeakReference(paramGdtMotiveVideoDialog);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (GdtMotiveVideoDialog)this.a.get();
    if (paramDialogInterface == null)
    {
      QLog.i("GdtMotiveVideoDialog", 1, "gdtMotiveVideoDialog == null");
      return;
    }
    GdtMotiveVideoDialog.e(paramDialogInterface).setIntent(GdtMotiveVideoDialog.f(paramDialogInterface));
    GdtMotiveVideoDialog.e(paramDialogInterface).getApplication().unregisterActivityLifecycleCallbacks(GdtMotiveVideoDialog.g(paramDialogInterface));
    GdtMotiveVideoDialog.c(paramDialogInterface).p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoDialog.MyDismissListener
 * JD-Core Version:    0.7.0.1
 */