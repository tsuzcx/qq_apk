package com.tencent.comic;

import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleLogListener;
import org.jetbrains.annotations.NotNull;

final class VipComicHelper$4
  implements WebBundleLogListener
{
  public void log(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    if (QLog.isColorLevel())
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            QLog.e(paramString1, 2, paramString2);
            return;
          }
          QLog.w(paramString1, 2, paramString2);
          return;
        }
        QLog.i(paramString1, 2, paramString2);
        return;
      }
      QLog.d(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.4
 * JD-Core Version:    0.7.0.1
 */