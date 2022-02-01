package com.tencent.biz.qqcircle.bizparts;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import java.util.ArrayList;

public class QCircleFolderFragmentsPart$FolderTabFragmentAdapter
  extends FragmentPagerAdapter
{
  public QCircleFolderFragmentsPart$FolderTabFragmentAdapter(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return QCircleFolderFragmentsPart.c(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)QCircleFolderFragmentsPart.c(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.c(this.a).get(paramInt)).hashCode();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)QCircleFolderFragmentsPart.e(this.a).get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */