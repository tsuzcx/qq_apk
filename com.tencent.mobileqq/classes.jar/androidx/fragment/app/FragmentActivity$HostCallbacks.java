package androidx.fragment.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class FragmentActivity$HostCallbacks
  extends FragmentHostCallback<FragmentActivity>
  implements OnBackPressedDispatcherOwner, ViewModelStoreOwner
{
  public FragmentActivity$HostCallbacks(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.this$0.mFragmentLifecycleRegistry;
  }
  
  @NonNull
  public OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.this$0.getOnBackPressedDispatcher();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    return this.this$0.getViewModelStore();
  }
  
  public void onAttachFragment(@NonNull Fragment paramFragment)
  {
    this.this$0.onAttachFragment(paramFragment);
  }
  
  public void onDump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    this.this$0.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    return this.this$0.findViewById(paramInt);
  }
  
  public FragmentActivity onGetHost()
  {
    return this.this$0;
  }
  
  @NonNull
  public LayoutInflater onGetLayoutInflater()
  {
    return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
  }
  
  public int onGetWindowAnimations()
  {
    Window localWindow = this.this$0.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return localWindow.getAttributes().windowAnimations;
  }
  
  public boolean onHasView()
  {
    Window localWindow = this.this$0.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public boolean onHasWindowAnimations()
  {
    return this.this$0.getWindow() != null;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt)
  {
    this.this$0.requestPermissionsFromFragment(paramFragment, paramArrayOfString, paramInt);
  }
  
  public boolean onShouldSaveFragmentState(@NonNull Fragment paramFragment)
  {
    return this.this$0.isFinishing() ^ true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, paramString);
  }
  
  public void onStartActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.this$0.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  public void onStartActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    this.this$0.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public void onStartIntentSenderFromFragment(@NonNull Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.this$0.startIntentSenderFromFragment(paramFragment, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void onSupportInvalidateOptionsMenu()
  {
    this.this$0.supportInvalidateOptionsMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentActivity.HostCallbacks
 * JD-Core Version:    0.7.0.1
 */