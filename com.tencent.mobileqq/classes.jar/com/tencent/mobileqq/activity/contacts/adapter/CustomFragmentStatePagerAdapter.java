package com.tencent.mobileqq.activity.contacts.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomFragmentStatePagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private final FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidSupportV4AppFragmentTransaction;
  private ArrayList<Fragment.SavedState> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<Fragment> b = new ArrayList();
  
  public CustomFragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
  }
  
  public abstract Fragment a(int paramInt);
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FragmentStatePagerAdapter", 2, "Removing item #" + paramInt + ": f=" + paramObject + " v=" + ((Fragment)paramObject).getView());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilArrayList.add(null);
    }
    paramObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localFragment.isAdded()) {}
    for (paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.saveFragmentInstanceState(localFragment);; paramViewGroup = null)
    {
      paramObject.set(paramInt, paramViewGroup);
      if ((paramInt >= 0) && (paramInt < this.b.size())) {
        this.b.set(paramInt, null);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.remove(localFragment);
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = null;
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b.size() > paramInt)
    {
      localFragment = (Fragment)this.b.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    }
    Fragment localFragment = a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FragmentStatePagerAdapter", 2, "Adding item #" + paramInt + ": f=" + localFragment);
    }
    if (localFragment != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
      {
        Fragment.SavedState localSavedState = (Fragment.SavedState)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localSavedState != null) {
          localFragment.setInitialSavedState(localSavedState);
        }
      }
      while (this.b.size() <= paramInt) {
        this.b.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.b.set(paramInt, localFragment);
      if (!localFragment.isAdded()) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.add(paramViewGroup.getId(), localFragment);
      }
    }
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    Bundle localBundle;
    int i;
    String str;
    if (paramParcelable != null)
    {
      QLog.d("FragmentStatePagerAdapter", 2, "restoreState");
      localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      paramParcelable = localBundle.getParcelableArray("states");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.b.clear();
      if (paramParcelable != null)
      {
        i = 0;
        while (i < paramParcelable.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add((Fragment.SavedState)paramParcelable[i]);
          i += 1;
        }
      }
      paramClassLoader = localBundle.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        str = (String)paramClassLoader.next();
        if (str.startsWith("f")) {
          i = Integer.parseInt(str.substring(1));
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.getFragments() == null) {
          break label296;
        }
        paramParcelable = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.getFragment(localBundle, str);
        if (paramParcelable == null) {
          break label266;
        }
        if (this.b.size() <= i)
        {
          this.b.add(null);
          continue;
        }
      }
      catch (Exception paramParcelable)
      {
        QLog.e("FragmentStatePagerAdapter", 1, "restoreState error: " + paramParcelable.getMessage());
        paramParcelable = null;
        continue;
        paramParcelable.setMenuVisibility(false);
        this.b.set(i, paramParcelable);
        QLog.d("FragmentStatePagerAdapter", 2, "restoreState key: " + str + "  " + paramParcelable);
      }
      break;
      label266:
      QLog.d("FragmentStatePagerAdapter", 2, "Bad fragment at key " + str);
      break;
      return;
      label296:
      paramParcelable = null;
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    Object localObject2 = localObject1;
    for (;;)
    {
      if (i < this.b.size())
      {
        Fragment localFragment = (Fragment)this.b.get(i);
        localObject1 = localObject2;
        if (localFragment != null)
        {
          localObject1 = localObject2;
          if (localFragment.isAdded())
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Bundle();
            }
            localObject2 = "f" + i;
            QLog.d("FragmentStatePagerAdapter", 2, "saveState key: " + (String)localObject2 + "  " + localFragment);
          }
        }
        try
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
          i += 1;
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FragmentStatePagerAdapter", 1, "saveState error: " + localException.getMessage());
          }
        }
      }
    }
    return localException;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.jdField_a_of_type_AndroidSupportV4AppFragment)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragment.setMenuVisibility(false);
        this.jdField_a_of_type_AndroidSupportV4AppFragment.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragment = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.CustomFragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */