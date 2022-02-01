package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

public class ErrDlgFragmentForSupport
  extends ReportDialogFragment
{
  private DialogInterface.OnCancelListener listener = null;
  private Dialog log = null;
  
  public static ErrDlgFragmentForSupport newInstance(Dialog paramDialog)
  {
    return newInstance(paramDialog, null);
  }
  
  public static ErrDlgFragmentForSupport newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Preconditions.checkNotNull(paramDialog, "Dialog cannot be null!");
    ErrDlgFragmentForSupport localErrDlgFragmentForSupport = new ErrDlgFragmentForSupport();
    localErrDlgFragmentForSupport.log = paramDialog;
    localErrDlgFragmentForSupport.log.setOnCancelListener(null);
    localErrDlgFragmentForSupport.log.setOnDismissListener(null);
    localErrDlgFragmentForSupport.listener = paramOnCancelListener;
    return localErrDlgFragmentForSupport;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = this.listener;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (this.log == null) {
      setShowsDialog(false);
    }
    return this.log;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    Preconditions.checkNotNull(paramFragmentManager, "FragmentManager cannot be null!");
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.ErrDlgFragmentForSupport
 * JD-Core Version:    0.7.0.1
 */