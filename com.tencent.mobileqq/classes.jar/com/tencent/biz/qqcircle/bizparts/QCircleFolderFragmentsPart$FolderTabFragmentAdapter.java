package com.tencent.biz.qqcircle.bizparts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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
    return QCircleFolderFragmentsPart.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.a(this.a).get(paramInt)).hashCode();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)QCircleFolderFragmentsPart.b(this.a).get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */