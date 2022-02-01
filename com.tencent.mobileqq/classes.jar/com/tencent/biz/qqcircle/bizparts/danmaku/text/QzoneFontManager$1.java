package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleTrueTypeResult;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.MultiHashMap;

class QzoneFontManager$1
  implements QCircleTrueTypeResult
{
  QzoneFontManager$1(QzoneFontManager paramQzoneFontManager, int paramInt) {}
  
  public void result(int paramInt, String paramString1, String arg3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      synchronized (QzoneFontManager.b())
      {
        QzoneFontManager.a(this.b).remove(Integer.valueOf(this.a));
        QzoneFontManager.a(this.b, null);
      }
    }
    QzoneFontManager.a(this.b, paramInt, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager.1
 * JD-Core Version:    0.7.0.1
 */