package androidx.fragment.app;

import androidx.annotation.NonNull;

class FragmentManager$3
  extends FragmentFactory
{
  FragmentManager$3(FragmentManager paramFragmentManager) {}
  
  @NonNull
  public Fragment instantiate(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    return this.this$0.mHost.instantiate(this.this$0.mHost.getContext(), paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.3
 * JD-Core Version:    0.7.0.1
 */