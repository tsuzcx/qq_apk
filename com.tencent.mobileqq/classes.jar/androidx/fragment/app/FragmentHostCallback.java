package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E>
  extends FragmentContainer
{
  @Nullable
  private final Activity mActivity;
  @NonNull
  private final Context mContext;
  final FragmentManager mFragmentManager = new FragmentManagerImpl();
  @NonNull
  private final Handler mHandler;
  private final int mWindowAnimations;
  
  FragmentHostCallback(@Nullable Activity paramActivity, @NonNull Context paramContext, @NonNull Handler paramHandler, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "context == null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "handler == null"));
    this.mWindowAnimations = paramInt;
  }
  
  public FragmentHostCallback(@NonNull Context paramContext, @NonNull Handler paramHandler, int paramInt)
  {
    this(localActivity, paramContext, paramHandler, paramInt);
  }
  
  FragmentHostCallback(@NonNull FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, new Handler(), 0);
  }
  
  @Nullable
  Activity getActivity()
  {
    return this.mActivity;
  }
  
  @NonNull
  Context getContext()
  {
    return this.mContext;
  }
  
  @NonNull
  Handler getHandler()
  {
    return this.mHandler;
  }
  
  void onAttachFragment(@NonNull Fragment paramFragment) {}
  
  public void onDump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString) {}
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  @Nullable
  public abstract E onGetHost();
  
  @NonNull
  public LayoutInflater onGetLayoutInflater()
  {
    return LayoutInflater.from(this.mContext);
  }
  
  public int onGetWindowAnimations()
  {
    return this.mWindowAnimations;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState(@NonNull Fragment paramFragment)
  {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    return false;
  }
  
  public void onStartActivityFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    onStartActivityFromFragment(paramFragment, paramIntent, paramInt, null);
  }
  
  public void onStartActivityFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      this.mContext.startActivity(paramIntent);
      return;
    }
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  public void onStartIntentSenderFromFragment(@NonNull Fragment paramFragment, @SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startIntentSenderForResult(this.mActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
  }
  
  public void onSupportInvalidateOptionsMenu() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentHostCallback
 * JD-Core Version:    0.7.0.1
 */