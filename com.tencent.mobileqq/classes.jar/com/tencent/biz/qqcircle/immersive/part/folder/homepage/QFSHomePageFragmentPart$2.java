package com.tencent.biz.qqcircle.immersive.part.folder.homepage;

import android.widget.RadioButton;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.folder.IPageChangeObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QFSHomePageFragmentPart$2
  implements ViewPager.OnPageChangeListener
{
  QFSHomePageFragmentPart$2(QFSHomePageFragmentPart paramQFSHomePageFragmentPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mFolderViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(QFSHomePageFragmentPart.d(this.a));
    QLog.i("QFSFolderFragmentPart", 1, localStringBuilder.toString());
    int i = 0;
    while (i < QFSHomePageFragmentPart.e(this.a).size())
    {
      if (i == paramInt)
      {
        ((QFSBaseFragment)QFSHomePageFragmentPart.e(this.a).get(i)).onResume();
        if ((QFSHomePageFragmentPart.e(this.a).get(i) instanceof IPageChangeObserver)) {
          ((IPageChangeObserver)QFSHomePageFragmentPart.e(this.a).get(i)).a(paramInt);
        }
        ((RadioButton)QFSHomePageFragmentPart.f(this.a).get(i)).performClick();
      }
      else if (i == QFSHomePageFragmentPart.d(this.a))
      {
        ((QFSBaseFragment)QFSHomePageFragmentPart.e(this.a).get(i)).onStop();
      }
      i += 1;
    }
    QFSHomePageFragmentPart.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.folder.homepage.QFSHomePageFragmentPart.2
 * JD-Core Version:    0.7.0.1
 */