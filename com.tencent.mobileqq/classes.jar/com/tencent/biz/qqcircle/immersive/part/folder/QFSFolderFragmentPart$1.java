package com.tencent.biz.qqcircle.immersive.part.folder;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSFolderRightProfileFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QFSFolderFragmentPart$1
  implements ViewPager.OnPageChangeListener
{
  QFSFolderFragmentPart$1(QFSFolderFragmentPart paramQFSFolderFragmentPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramInt2);
    QLog.d("QFSFolderFragmentPart", 1, localStringBuilder.toString());
    if (paramFloat > 0.0F) {
      QFSFolderFragmentPart.a(this.a).z();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mFolderViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(QFSFolderFragmentPart.b(this.a));
    QLog.i("QFSFolderFragmentPart", 1, localStringBuilder.toString());
    int i = 0;
    while (i < QFSFolderFragmentPart.c(this.a).size())
    {
      if (i == paramInt)
      {
        ((QFSBaseFragment)QFSFolderFragmentPart.c(this.a).get(i)).onResume();
        if ((QFSFolderFragmentPart.c(this.a).get(i) instanceof IPageChangeObserver)) {
          ((IPageChangeObserver)QFSFolderFragmentPart.c(this.a).get(i)).a(paramInt);
        }
      }
      else if (i == QFSFolderFragmentPart.b(this.a))
      {
        ((QFSBaseFragment)QFSFolderFragmentPart.c(this.a).get(i)).onStop();
      }
      i += 1;
    }
    QFSFolderFragmentPart.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.folder.QFSFolderFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */