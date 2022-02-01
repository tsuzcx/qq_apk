package com.tencent.mobileqq.activity.qwallet.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

class SendHbMainFragment$3
  extends FragmentPagerAdapter
{
  SendHbMainFragment$3(SendHbMainFragment paramSendHbMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SendHbMainFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return ((SendHbMainFragment.HbHolder)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((SendHbMainFragment.HbHolder)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment.3
 * JD-Core Version:    0.7.0.1
 */