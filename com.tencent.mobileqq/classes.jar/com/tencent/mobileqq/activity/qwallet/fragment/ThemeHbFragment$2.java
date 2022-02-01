package com.tencent.mobileqq.activity.qwallet.fragment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ThemeHbFragment$2
  implements PreloadImgManager.OnSingleDownloadCallback
{
  ThemeHbFragment$2(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (ThemeHbFragment.a(this.a) == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back context is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back drawable = " + paramObject);
      }
    } while (!(paramObject instanceof Drawable));
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess image set...");
    }
    ThemeHbFragment.a(this.a).post(new ThemeHbFragment.2.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.2
 * JD-Core Version:    0.7.0.1
 */