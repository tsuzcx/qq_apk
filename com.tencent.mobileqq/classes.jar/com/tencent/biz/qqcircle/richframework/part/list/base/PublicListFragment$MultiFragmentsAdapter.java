package com.tencent.biz.qqcircle.richframework.part.list.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

class PublicListFragment$MultiFragmentsAdapter
  extends FragmentPagerAdapter
{
  private PublicListFragment$MultiFragmentsAdapter(PublicListFragment paramPublicListFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return this.a.d.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < this.a.d.size()) {
      return (Fragment)this.a.d.get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.PublicListFragment.MultiFragmentsAdapter
 * JD-Core Version:    0.7.0.1
 */