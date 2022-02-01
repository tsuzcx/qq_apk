package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pkd;
import pyi;
import tds;

public class ReadInJoyChannelViewPager$CustomFragmentPagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private final FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidSupportV4AppFragmentTransaction;
  private ArrayList<Fragment.SavedState> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  tds jdField_a_of_type_Tds;
  private ArrayList<Fragment> b = new ArrayList();
  
  public ReadInJoyChannelViewPager$CustomFragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    b();
  }
  
  private void a(Fragment paramFragment)
  {
    if ((paramFragment instanceof ReadInJoyBaseFragment))
    {
      pkd.a().a();
      paramFragment = (ReadInJoyBaseFragment)paramFragment;
      pkd.a().a(String.valueOf(paramFragment.a()));
    }
  }
  
  private Fragment b(int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= getCount())) {
      localObject = null;
    }
    TabChannelCoverInfo localTabChannelCoverInfo;
    Fragment localFragment;
    do
    {
      return localObject;
      localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localFragment = pyi.a().a(localTabChannelCoverInfo);
      localObject = localFragment;
    } while (!(localFragment instanceof ReadInJoyBaseFragment));
    ((ReadInJoyBaseFragment)localFragment).c(paramInt);
    ((ReadInJoyBaseFragment)localFragment).a(this.jdField_a_of_type_Tds, localTabChannelCoverInfo.mChannelCoverId);
    return localFragment;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragment;
  }
  
  public Fragment a(int paramInt)
  {
    if (this.b.size() > paramInt) {
      return (Fragment)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("CustomFragmentPagerAdapter", 1, "clearData exception.");
    }
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(tds paramtds)
  {
    this.jdField_a_of_type_Tds = paramtds;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    }
    QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "destroyItem position = ", Integer.valueOf(paramInt), ", f = ", paramObject });
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
      this.jdField_a_of_type_JavaUtilArrayList.add(null);
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramObject.isAdded()) {}
    for (paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.b.set(paramInt, null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.remove(paramObject);
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
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if ((paramObject instanceof ReadInJoyBaseFragment))
    {
      paramObject = (ReadInJoyBaseFragment)paramObject;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == paramObject.a())
        {
          int j = paramObject.d();
          QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.a()), ", channelName = ", ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverName, ", oldPos = ", Integer.valueOf(j), ", newPos = ", Integer.valueOf(i) });
          if (j == i) {
            return -1;
          }
        }
        i += 1;
      }
      QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.a()), ",  POSITION_NONE" });
    }
    return -2;
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
    Fragment localFragment = b(paramInt);
    QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "instantiateItem position = ", Integer.valueOf(paramInt), ", f = ", localFragment });
    while (this.b.size() <= paramInt) {
      this.b.add(null);
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    this.b.set(paramInt, localFragment);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.add(paramViewGroup.getId(), localFragment);
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
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.b.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add((Fragment.SavedState)paramClassLoader[i]);
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
          Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.getFragment(paramParcelable, str);
          if (localFragment != null)
          {
            while (this.b.size() <= i) {
              this.b.add(null);
            }
            localFragment.setMenuVisibility(false);
            this.b.set(i, localFragment);
          }
          else
          {
            Log.w("CustomFragmentPagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.jdField_a_of_type_JavaUtilArrayList.size()];
      this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    while (i < this.b.size())
    {
      Fragment localFragment = (Fragment)this.b.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = "f" + i;
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
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
      a(this.jdField_a_of_type_AndroidSupportV4AppFragment);
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter
 * JD-Core Version:    0.7.0.1
 */