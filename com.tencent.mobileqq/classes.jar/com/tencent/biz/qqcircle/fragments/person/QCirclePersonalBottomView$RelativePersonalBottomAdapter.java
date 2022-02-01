package com.tencent.biz.qqcircle.fragments.person;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

class QCirclePersonalBottomView$RelativePersonalBottomAdapter
  extends FragmentPagerAdapter
{
  public QCirclePersonalBottomView$RelativePersonalBottomAdapter(QCirclePersonalBottomView paramQCirclePersonalBottomView, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return QCirclePersonalBottomView.h(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < QCirclePersonalBottomView.h(this.a).size()) {
      return (Fragment)QCirclePersonalBottomView.h(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.RelativePersonalBottomAdapter
 * JD-Core Version:    0.7.0.1
 */