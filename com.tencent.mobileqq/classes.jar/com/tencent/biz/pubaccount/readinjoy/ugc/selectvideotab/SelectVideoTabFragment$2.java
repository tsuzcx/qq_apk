package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

class SelectVideoTabFragment$2
  extends FragmentPagerAdapter
{
  SelectVideoTabFragment$2(SelectVideoTabFragment paramSelectVideoTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SelectVideoTabFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)SelectVideoTabFragment.a(this.a).get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return SelectVideoTabFragment.a(this.a).getString(SelectVideoTabFragment.a()[paramInt]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment.2
 * JD-Core Version:    0.7.0.1
 */