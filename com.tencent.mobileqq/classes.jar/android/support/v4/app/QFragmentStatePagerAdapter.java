package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class QFragmentStatePagerAdapter
  extends PagerAdapter
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapter";
  private QFragmentTransaction mCurTransaction = null;
  private QFragment mCurrentPrimaryItem = null;
  private final QFragmentManager mFragmentManager;
  private ArrayList<QFragment> mFragments = new ArrayList();
  private ArrayList<QFragment.SavedState> mSavedState = new ArrayList();
  
  public QFragmentStatePagerAdapter(QFragmentManager paramQFragmentManager)
  {
    this.mFragmentManager = paramQFragmentManager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (QFragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    ArrayList localArrayList = this.mSavedState;
    if (paramObject.isAdded()) {}
    for (paramViewGroup = this.mFragmentManager.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.mFragments.set(paramInt, null);
      this.mCurTransaction.remove(paramObject);
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitAllowingStateLoss();
      this.mCurTransaction = null;
    }
  }
  
  public abstract QFragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mFragments.size() > paramInt)
    {
      localQFragment = (QFragment)this.mFragments.get(paramInt);
      if (localQFragment != null) {
        return localQFragment;
      }
    }
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    QFragment localQFragment = getItem(paramInt);
    if (this.mSavedState.size() > paramInt)
    {
      QFragment.SavedState localSavedState = (QFragment.SavedState)this.mSavedState.get(paramInt);
      if (localSavedState != null) {
        localQFragment.setInitialSavedState(localSavedState);
      }
    }
    while (this.mFragments.size() <= paramInt) {
      this.mFragments.add(null);
    }
    localQFragment.setMenuVisibility(false);
    localQFragment.setUserVisibleHint(false);
    this.mFragments.set(paramInt, localQFragment);
    this.mCurTransaction.add(paramViewGroup.getId(), localQFragment);
    return localQFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((QFragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.mSavedState.add((QFragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          QFragment localQFragment = this.mFragmentManager.getFragment(paramParcelable, str);
          if (localQFragment != null)
          {
            while (this.mFragments.size() <= i) {
              this.mFragments.add(null);
            }
            localQFragment.setMenuVisibility(false);
            this.mFragments.set(i, localQFragment);
          }
          else
          {
            Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new QFragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    while (i < this.mFragments.size())
    {
      QFragment localQFragment = (QFragment)this.mFragments.get(i);
      localObject2 = localObject1;
      if (localQFragment != null)
      {
        localObject2 = localObject1;
        if (localQFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = "f" + i;
          this.mFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localQFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (QFragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */