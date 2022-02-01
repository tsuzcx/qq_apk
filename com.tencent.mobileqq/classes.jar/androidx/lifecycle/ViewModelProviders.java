package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelProviders
{
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelProvider of(@NonNull Fragment paramFragment)
  {
    return new ViewModelProvider(paramFragment);
  }
  
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelProvider of(@NonNull Fragment paramFragment, @Nullable ViewModelProvider.Factory paramFactory)
  {
    ViewModelProvider.Factory localFactory = paramFactory;
    if (paramFactory == null) {
      localFactory = paramFragment.getDefaultViewModelProviderFactory();
    }
    return new ViewModelProvider(paramFragment.getViewModelStore(), localFactory);
  }
  
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelProvider of(@NonNull FragmentActivity paramFragmentActivity)
  {
    return new ViewModelProvider(paramFragmentActivity);
  }
  
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelProvider of(@NonNull FragmentActivity paramFragmentActivity, @Nullable ViewModelProvider.Factory paramFactory)
  {
    ViewModelProvider.Factory localFactory = paramFactory;
    if (paramFactory == null) {
      localFactory = paramFragmentActivity.getDefaultViewModelProviderFactory();
    }
    return new ViewModelProvider(paramFragmentActivity.getViewModelStore(), localFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProviders
 * JD-Core Version:    0.7.0.1
 */