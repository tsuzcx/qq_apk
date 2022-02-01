package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig
{
  @Nullable
  private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
  @Nullable
  private final Collection<Fragment> mFragments;
  @Nullable
  private final Map<String, ViewModelStore> mViewModelStores;
  
  FragmentManagerNonConfig(@Nullable Collection<Fragment> paramCollection, @Nullable Map<String, FragmentManagerNonConfig> paramMap, @Nullable Map<String, ViewModelStore> paramMap1)
  {
    this.mFragments = paramCollection;
    this.mChildNonConfigs = paramMap;
    this.mViewModelStores = paramMap1;
  }
  
  @Nullable
  Map<String, FragmentManagerNonConfig> getChildNonConfigs()
  {
    return this.mChildNonConfigs;
  }
  
  @Nullable
  Collection<Fragment> getFragments()
  {
    return this.mFragments;
  }
  
  @Nullable
  Map<String, ViewModelStore> getViewModelStores()
  {
    return this.mViewModelStores;
  }
  
  boolean isRetaining(Fragment paramFragment)
  {
    if (this.mFragments == null) {
      return false;
    }
    return this.mFragments.contains(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerNonConfig
 * JD-Core Version:    0.7.0.1
 */