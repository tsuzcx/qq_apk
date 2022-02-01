package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.immersive.views.QFSViewPager.OnSlideListener;
import com.tencent.qphone.base.util.QLog;

class QFSMainMultiTabFragmentPart$4
  implements QFSViewPager.OnSlideListener
{
  QFSMainMultiTabFragmentPart$4(QFSMainMultiTabFragmentPart paramQFSMainMultiTabFragmentPart) {}
  
  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEndPageSelected:");
    localStringBuilder.append(QFSMainMultiTabFragmentPart.g(this.a));
    QLog.d("QFSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    return QFSMainMultiTabFragmentPart.g(this.a);
  }
  
  public void b()
  {
    QLog.d("QFSMainMultiTabFragmentPart", 1, "onSlideRightAtEnd trigger");
    QFSMainMultiTabFragmentPart.h(this.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.4
 * JD-Core Version:    0.7.0.1
 */