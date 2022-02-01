package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomFragmentStatePagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidxFragmentAppFragment = null;
  private final FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = null;
  private ArrayList<Fragment.SavedState> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<Fragment> b = new ArrayList();
  
  public CustomFragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
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
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("Removing item #");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(": f=");
      paramViewGroup.append(paramObject);
      paramViewGroup.append(" v=");
      paramViewGroup.append(localFragment.getView());
      QLog.d("FragmentStatePagerAdapter", 2, paramViewGroup.toString());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilArrayList.add(null);
    }
    paramObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localFragment.isAdded()) {
      paramViewGroup = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.saveFragmentInstanceState(localFragment);
    } else {
      paramViewGroup = null;
    }
    paramObject.set(paramInt, paramViewGroup);
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      this.b.set(paramInt, null);
    }
    this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction.remove(localFragment);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = null;
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
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    }
    Fragment localFragment = a(paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Adding item #");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(": f=");
      ((StringBuilder)localObject).append(localFragment);
      QLog.d("FragmentStatePagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (localFragment != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)
      {
        localObject = (Fragment.SavedState)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localObject != null) {
          localFragment.setInitialSavedState((Fragment.SavedState)localObject);
        }
      }
      while (this.b.size() <= paramInt) {
        this.b.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.b.set(paramInt, localFragment);
      if (!localFragment.isAdded()) {
        this.jdField_a_of_type_AndroidxFragmentAppFragmentTransaction.add(paramViewGroup.getId(), localFragment);
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
    if (paramParcelable != null)
    {
      QLog.d("FragmentStatePagerAdapter", 2, "restoreState");
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      paramParcelable = localBundle.getParcelableArray("states");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.b.clear();
      int i;
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
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          StringBuilder localStringBuilder;
          try
          {
            if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.getFragments() != null) {
              paramParcelable = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.getFragment(localBundle, str);
            }
          }
          catch (Exception paramParcelable)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreState error: ");
            localStringBuilder.append(paramParcelable.getMessage());
            QLog.e("FragmentStatePagerAdapter", 1, localStringBuilder.toString());
            paramParcelable = null;
          }
          if (paramParcelable != null)
          {
            while (this.b.size() <= i) {
              this.b.add(null);
            }
            paramParcelable.setMenuVisibility(false);
            this.b.set(i, paramParcelable);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreState key: ");
            localStringBuilder.append(str);
            localStringBuilder.append("  ");
            localStringBuilder.append(paramParcelable);
            QLog.d("FragmentStatePagerAdapter", 2, localStringBuilder.toString());
          }
          else
          {
            paramParcelable = new StringBuilder();
            paramParcelable.append("Bad fragment at key ");
            paramParcelable.append(str);
            QLog.d("FragmentStatePagerAdapter", 2, paramParcelable.toString());
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    else
    {
      localObject2 = null;
    }
    int i = 0;
    Object localObject3;
    while (i < this.b.size())
    {
      Object localObject4 = (Fragment)this.b.get(i);
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (((Fragment)localObject4).isAdded())
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("f");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveState key: ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("  ");
          localStringBuilder.append(localObject4);
          QLog.d("FragmentStatePagerAdapter", 2, localStringBuilder.toString());
          try
          {
            this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, (Fragment)localObject4);
          }
          catch (Exception localException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("saveState error: ");
            ((StringBuilder)localObject4).append(localException.getMessage());
            QLog.e("FragmentStatePagerAdapter", 1, ((StringBuilder)localObject4).toString());
          }
        }
      }
      i += 1;
      localObject3 = localObject1;
    }
    return localObject3;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = this.jdField_a_of_type_AndroidxFragmentAppFragment;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(false);
        this.jdField_a_of_type_AndroidxFragmentAppFragment.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.jdField_a_of_type_AndroidxFragmentAppFragment = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */