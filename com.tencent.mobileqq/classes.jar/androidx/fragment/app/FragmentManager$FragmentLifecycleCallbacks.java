package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class FragmentManager$FragmentLifecycleCallbacks
{
  public void onFragmentActivityCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
  
  public void onFragmentAttached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Context paramContext) {}
  
  public void onFragmentCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
  
  public void onFragmentDestroyed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentDetached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentPaused(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentPreAttached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Context paramContext) {}
  
  public void onFragmentPreCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
  
  public void onFragmentResumed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentSaveInstanceState(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Bundle paramBundle) {}
  
  public void onFragmentStarted(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentStopped(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  
  public void onFragmentViewCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull View paramView, @Nullable Bundle paramBundle) {}
  
  public void onFragmentViewDestroyed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */