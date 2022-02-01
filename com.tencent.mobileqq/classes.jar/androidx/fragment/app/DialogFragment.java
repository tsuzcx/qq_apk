package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

public class DialogFragment
  extends ReportAndroidXFragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private static final String SAVED_BACK_STACK_ID = "android:backStackId";
  private static final String SAVED_CANCELABLE = "android:cancelable";
  private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
  private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
  private static final String SAVED_STYLE = "android:style";
  private static final String SAVED_THEME = "android:theme";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  private int mBackStackId = -1;
  private boolean mCancelable = true;
  private boolean mCreatingDialog;
  @Nullable
  private Dialog mDialog;
  private Runnable mDismissRunnable = new DialogFragment.1(this);
  private boolean mDismissed;
  private Handler mHandler;
  private DialogInterface.OnCancelListener mOnCancelListener = new DialogFragment.2(this);
  private DialogInterface.OnDismissListener mOnDismissListener = new DialogFragment.3(this);
  private boolean mShownByMe;
  private boolean mShowsDialog = true;
  private int mStyle = 0;
  private int mTheme = 0;
  private boolean mViewDestroyed;
  
  private void dismissInternal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mDismissed) {
      return;
    }
    this.mDismissed = true;
    this.mShownByMe = false;
    Object localObject = this.mDialog;
    if (localObject != null)
    {
      ((Dialog)localObject).setOnDismissListener(null);
      this.mDialog.dismiss();
      if (!paramBoolean2) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
          onDismiss(this.mDialog);
        } else {
          this.mHandler.post(this.mDismissRunnable);
        }
      }
    }
    this.mViewDestroyed = true;
    if (this.mBackStackId >= 0)
    {
      getParentFragmentManager().popBackStack(this.mBackStackId, 1);
      this.mBackStackId = -1;
      return;
    }
    localObject = getParentFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).remove(this);
    if (paramBoolean1)
    {
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
    ((FragmentTransaction)localObject).commit();
  }
  
  public void dismiss()
  {
    dismissInternal(false, false);
  }
  
  public void dismissAllowingStateLoss()
  {
    dismissInternal(true, false);
  }
  
  @Nullable
  public Dialog getDialog()
  {
    return this.mDialog;
  }
  
  public boolean getShowsDialog()
  {
    return this.mShowsDialog;
  }
  
  @StyleRes
  public int getTheme()
  {
    return this.mTheme;
  }
  
  public boolean isCancelable()
  {
    return this.mCancelable;
  }
  
  @MainThread
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.mShowsDialog) {
      return;
    }
    Object localObject = getView();
    if (this.mDialog != null)
    {
      if (localObject != null) {
        if (((View)localObject).getParent() == null) {
          this.mDialog.setContentView((View)localObject);
        } else {
          throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
      }
      localObject = getActivity();
      if (localObject != null) {
        this.mDialog.setOwnerActivity((Activity)localObject);
      }
      this.mDialog.setCancelable(this.mCancelable);
      this.mDialog.setOnCancelListener(this.mOnCancelListener);
      this.mDialog.setOnDismissListener(this.mOnDismissListener);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("android:savedDialogState");
        if (paramBundle != null) {
          this.mDialog.onRestoreInstanceState(paramBundle);
        }
      }
    }
  }
  
  @MainThread
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (!this.mShownByMe) {
      this.mDismissed = false;
    }
  }
  
  public void onCancel(@NonNull DialogInterface paramDialogInterface) {}
  
  @MainThread
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new Handler();
    boolean bool;
    if (this.mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mShowsDialog = bool;
    if (paramBundle != null)
    {
      this.mStyle = paramBundle.getInt("android:style", 0);
      this.mTheme = paramBundle.getInt("android:theme", 0);
      this.mCancelable = paramBundle.getBoolean("android:cancelable", true);
      this.mShowsDialog = paramBundle.getBoolean("android:showsDialog", this.mShowsDialog);
      this.mBackStackId = paramBundle.getInt("android:backStackId", -1);
    }
  }
  
  @MainThread
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    return new ReportDialog(requireContext(), getTheme());
  }
  
  @MainThread
  public void onDestroyView()
  {
    super.onDestroyView();
    Dialog localDialog = this.mDialog;
    if (localDialog != null)
    {
      this.mViewDestroyed = true;
      localDialog.setOnDismissListener(null);
      this.mDialog.dismiss();
      if (!this.mDismissed) {
        onDismiss(this.mDialog);
      }
      this.mDialog = null;
    }
  }
  
  @MainThread
  public void onDetach()
  {
    super.onDetach();
    if ((!this.mShownByMe) && (!this.mDismissed)) {
      this.mDismissed = true;
    }
  }
  
  public void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    if (!this.mViewDestroyed) {
      dismissInternal(true, true);
    }
  }
  
  @NonNull
  public LayoutInflater onGetLayoutInflater(@Nullable Bundle paramBundle)
  {
    LayoutInflater localLayoutInflater = super.onGetLayoutInflater(paramBundle);
    if (this.mShowsDialog)
    {
      if (this.mCreatingDialog) {
        return localLayoutInflater;
      }
      try
      {
        this.mCreatingDialog = true;
        this.mDialog = onCreateDialog(paramBundle);
        setupDialog(this.mDialog, this.mStyle);
        return localLayoutInflater.cloneInContext(requireDialog().getContext());
      }
      finally
      {
        this.mCreatingDialog = false;
      }
    }
    return localLayoutInflater;
  }
  
  @MainThread
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      paramBundle.putBundle("android:savedDialogState", localDialog.onSaveInstanceState());
    }
    int i = this.mStyle;
    if (i != 0) {
      paramBundle.putInt("android:style", i);
    }
    i = this.mTheme;
    if (i != 0) {
      paramBundle.putInt("android:theme", i);
    }
    boolean bool = this.mCancelable;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = this.mShowsDialog;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i = this.mBackStackId;
    if (i != -1) {
      paramBundle.putInt("android:backStackId", i);
    }
  }
  
  @MainThread
  public void onStart()
  {
    super.onStart();
    Dialog localDialog = this.mDialog;
    if (localDialog != null)
    {
      this.mViewDestroyed = false;
      localDialog.show();
    }
  }
  
  @MainThread
  public void onStop()
  {
    super.onStop();
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  @NonNull
  public final Dialog requireDialog()
  {
    Object localObject = getDialog();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DialogFragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a Dialog.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    this.mCancelable = paramBoolean;
    Dialog localDialog = this.mDialog;
    if (localDialog != null) {
      localDialog.setCancelable(paramBoolean);
    }
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    this.mShowsDialog = paramBoolean;
  }
  
  public void setStyle(int paramInt1, @StyleRes int paramInt2)
  {
    this.mStyle = paramInt1;
    paramInt1 = this.mStyle;
    if ((paramInt1 == 2) || (paramInt1 == 3)) {
      this.mTheme = 16973913;
    }
    if (paramInt2 != 0) {
      this.mTheme = paramInt2;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setupDialog(@NonNull Dialog paramDialog, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return;
      }
      Window localWindow = paramDialog.getWindow();
      if (localWindow != null) {
        localWindow.addFlags(24);
      }
    }
    paramDialog.requestWindowFeature(1);
  }
  
  public int show(@NonNull FragmentTransaction paramFragmentTransaction, @Nullable String paramString)
  {
    this.mDismissed = false;
    this.mShownByMe = true;
    paramFragmentTransaction.add(this, paramString);
    this.mViewDestroyed = false;
    this.mBackStackId = paramFragmentTransaction.commit();
    return this.mBackStackId;
  }
  
  public void show(@NonNull FragmentManager paramFragmentManager, @Nullable String paramString)
  {
    this.mDismissed = false;
    this.mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.commit();
  }
  
  public void showNow(@NonNull FragmentManager paramFragmentManager, @Nullable String paramString)
  {
    this.mDismissed = false;
    this.mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.commitNow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.DialogFragment
 * JD-Core Version:    0.7.0.1
 */