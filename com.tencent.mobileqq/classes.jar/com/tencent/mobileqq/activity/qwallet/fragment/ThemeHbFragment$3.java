package com.tencent.mobileqq.activity.qwallet.fragment;

import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ThemeHbFragment$3
  implements PreloadImgManager.OnSingleDownloadCallback
{
  ThemeHbFragment$3(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess download back obj = " + paramObject);
    }
    if (((paramObject instanceof String)) && (ThemeHbFragment.a(this.a) != null)) {
      ThemeHbFragment.a(this.a).post(new ThemeHbFragment.3.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.3
 * JD-Core Version:    0.7.0.1
 */