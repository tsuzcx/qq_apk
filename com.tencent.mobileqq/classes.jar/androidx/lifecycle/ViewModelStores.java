package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores
{
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelStore of(@NonNull Fragment paramFragment)
  {
    return paramFragment.getViewModelStore();
  }
  
  @Deprecated
  @MainThread
  @NonNull
  public static ViewModelStore of(@NonNull FragmentActivity paramFragmentActivity)
  {
    return paramFragmentActivity.getViewModelStore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelStores
 * JD-Core Version:    0.7.0.1
 */