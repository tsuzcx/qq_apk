package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle.State;
import androidx.viewpager.widget.PagerAdapter;

public abstract class FragmentPagerAdapter
  extends PagerAdapter
{
  public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
  @Deprecated
  public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentPagerAdapter";
  private final int mBehavior;
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private boolean mExecutingFinishUpdate;
  private final FragmentManager mFragmentManager;
  
  @Deprecated
  public FragmentPagerAdapter(@NonNull FragmentManager paramFragmentManager)
  {
    this(paramFragmentManager, 0);
  }
  
  public FragmentPagerAdapter(@NonNull FragmentManager paramFragmentManager, int paramInt)
  {
    this.mFragmentManager = paramFragmentManager;
    this.mBehavior = paramInt;
  }
  
  private static String makeFragmentName(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    this.mCurTransaction.detach(paramViewGroup);
    if (paramViewGroup.equals(this.mCurrentPrimaryItem)) {
      this.mCurrentPrimaryItem = null;
    }
  }
  
  public void finishUpdate(@NonNull ViewGroup paramViewGroup)
  {
    if ((this.mCurTransaction == null) || (!this.mExecutingFinishUpdate)) {}
    try
    {
      this.mExecutingFinishUpdate = true;
      this.mCurTransaction.commitNowAllowingStateLoss();
      this.mExecutingFinishUpdate = false;
      this.mCurTransaction = null;
      return;
    }
    finally
    {
      this.mExecutingFinishUpdate = false;
    }
  }
  
  @NonNull
  public abstract Fragment getItem(int paramInt);
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    long l = getItemId(paramInt);
    Object localObject = makeFragmentName(paramViewGroup.getId(), l);
    localObject = this.mFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null) {
      this.mCurTransaction.attach((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.mCurrentPrimaryItem)
      {
        paramViewGroup.setMenuVisibility(false);
        if (this.mBehavior != 1) {
          break;
        }
        this.mCurTransaction.setMaxLifecycle(paramViewGroup, Lifecycle.State.STARTED);
      }
      return paramViewGroup;
      localObject = getItem(paramInt);
      this.mCurTransaction.add(paramViewGroup.getId(), (Fragment)localObject, makeFragmentName(paramViewGroup.getId(), l));
    }
    paramViewGroup.setUserVisibleHint(false);
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(@Nullable Parcelable paramParcelable, @Nullable ClassLoader paramClassLoader) {}
  
  @Nullable
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        if (this.mBehavior != 1) {
          break label118;
        }
        if (this.mCurTransaction == null) {
          this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
      }
      paramViewGroup.setMenuVisibility(true);
      if (this.mBehavior != 1) {
        break label129;
      }
      if (this.mCurTransaction == null) {
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }
      this.mCurTransaction.setMaxLifecycle(paramViewGroup, Lifecycle.State.RESUMED);
    }
    for (;;)
    {
      this.mCurrentPrimaryItem = paramViewGroup;
      return;
      label118:
      this.mCurrentPrimaryItem.setUserVisibleHint(false);
      break;
      label129:
      paramViewGroup.setUserVisibleHint(true);
    }
  }
  
  public void startUpdate(@NonNull ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */