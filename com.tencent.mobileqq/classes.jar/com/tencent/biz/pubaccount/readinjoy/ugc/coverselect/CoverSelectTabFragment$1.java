package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class CoverSelectTabFragment$1
  extends FragmentPagerAdapter
{
  CoverSelectTabFragment$1(CoverSelectTabFragment paramCoverSelectTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return CoverSelectTabFragment.a(this.a).size();
  }
  
  @NotNull
  public Fragment getItem(int paramInt)
  {
    return (Fragment)CoverSelectTabFragment.a(this.a).get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return CoverSelectTabFragment.a()[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment.1
 * JD-Core Version:    0.7.0.1
 */