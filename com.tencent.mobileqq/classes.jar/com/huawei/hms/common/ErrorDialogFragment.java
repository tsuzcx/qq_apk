package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

public class ErrorDialogFragment
  extends ReportDialogFragment
{
  private DialogInterface.OnCancelListener myCancelLister = null;
  private Dialog myDialog = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog)
  {
    return newInstance(paramDialog, null);
  }
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Preconditions.checkNotNull(paramDialog, "Dialog cannot be null!");
    ErrorDialogFragment localErrorDialogFragment = new ErrorDialogFragment();
    localErrorDialogFragment.myDialog = paramDialog;
    localErrorDialogFragment.myDialog.setOnCancelListener(null);
    localErrorDialogFragment.myDialog.setOnDismissListener(null);
    if (paramOnCancelListener != null) {
      localErrorDialogFragment.myCancelLister = paramOnCancelListener;
    }
    return localErrorDialogFragment;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = this.myCancelLister;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (this.myDialog == null) {
      setShowsDialog(false);
    }
    return this.myDialog;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    Preconditions.checkNotNull(paramFragmentManager, "FragmentManager cannot be null!");
    super.show(paramFragmentManager, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.ErrorDialogFragment
 * JD-Core Version:    0.7.0.1
 */