package com.tencent.mobileqq.activity.qwallet.fragment;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;

class QzoneHbFragment$4
  implements PreloadImgManager.OnSingleDownloadCallback
{
  QzoneHbFragment$4(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramObject = QzoneHbFragment.a(this.a).obtainMessage();
      paramObject.what = 102;
      QzoneHbFragment.a(this.a).sendMessage(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment.4
 * JD-Core Version:    0.7.0.1
 */