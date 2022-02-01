package com.tencent.biz.qqcircle.bizparts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import java.util.ArrayList;

public class QCircleAggregationFragmentsPart$FolderTabFragmentAdapter
  extends FragmentPagerAdapter
{
  public QCircleAggregationFragmentsPart$FolderTabFragmentAdapter(QCircleAggregationFragmentsPart paramQCircleAggregationFragmentsPart, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return QCircleAggregationFragmentsPart.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)QCircleAggregationFragmentsPart.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((QCircleBaseAggregationFragment)QCircleAggregationFragmentsPart.a(this.a).get(paramInt)).hashCode();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)QCircleAggregationFragmentsPart.b(this.a).get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleAggregationFragmentsPart.FolderTabFragmentAdapter
 * JD-Core Version:    0.7.0.1
 */