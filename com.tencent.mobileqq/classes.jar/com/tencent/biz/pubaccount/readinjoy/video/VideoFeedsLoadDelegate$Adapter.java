package com.tencent.biz.pubaccount.readinjoy.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class VideoFeedsLoadDelegate$Adapter
  extends FragmentStatePagerAdapter
{
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilList.indexOf(paramObject) < 0) {
      return -2;
    }
    return -1;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLoadDelegate.Adapter
 * JD-Core Version:    0.7.0.1
 */