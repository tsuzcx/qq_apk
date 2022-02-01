package com.tencent.biz.qqcircle.immersive.part.qqtab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QFSTabFolderFragmentPart$1
  implements ViewPager.OnPageChangeListener
{
  QFSTabFolderFragmentPart$1(QFSTabFolderFragmentPart paramQFSTabFolderFragmentPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mFolderViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(QFSTabFolderFragmentPart.a(this.a));
    QLog.i("QFSFolderFragmentPart", 1, localStringBuilder.toString());
    int i = 0;
    while (i < QFSTabFolderFragmentPart.b(this.a).size())
    {
      if (i == paramInt) {
        ((QFSBaseFragment)QFSTabFolderFragmentPart.b(this.a).get(i)).onResume();
      } else if (i == QFSTabFolderFragmentPart.a(this.a)) {
        ((QFSBaseFragment)QFSTabFolderFragmentPart.b(this.a).get(i)).onStop();
      }
      i += 1;
    }
    QFSTabFolderFragmentPart.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.qqtab.QFSTabFolderFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */