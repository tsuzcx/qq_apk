package com.tencent.biz.qqcircle.immersive.tab;

import androidx.lifecycle.Observer;

class QFSNearbyTabFragment$3
  implements Observer<Integer>
{
  QFSNearbyTabFragment$3(QFSNearbyTabFragment paramQFSNearbyTabFragment) {}
  
  public void a(Integer paramInteger)
  {
    QFSNearbyTabFragment localQFSNearbyTabFragment = this.a;
    int i;
    if (paramInteger == null) {
      i = 0;
    } else {
      i = paramInteger.intValue();
    }
    QFSNearbyTabFragment.a(localQFSNearbyTabFragment, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment.3
 * JD-Core Version:    0.7.0.1
 */