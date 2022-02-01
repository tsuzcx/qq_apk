package com.tencent.biz.qqcircle.fragments.main;

import androidx.lifecycle.Observer;

class QCircleFolderNearbyTabFragment$4
  implements Observer<Integer>
{
  QCircleFolderNearbyTabFragment$4(QCircleFolderNearbyTabFragment paramQCircleFolderNearbyTabFragment) {}
  
  public void a(Integer paramInteger)
  {
    QCircleFolderNearbyTabFragment localQCircleFolderNearbyTabFragment = this.a;
    int i;
    if (paramInteger == null) {
      i = 0;
    } else {
      i = paramInteger.intValue();
    }
    QCircleFolderNearbyTabFragment.a(localQCircleFolderNearbyTabFragment, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment.4
 * JD-Core Version:    0.7.0.1
 */