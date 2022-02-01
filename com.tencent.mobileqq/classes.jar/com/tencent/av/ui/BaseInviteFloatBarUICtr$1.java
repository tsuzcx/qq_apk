package com.tencent.av.ui;

import android.graphics.Bitmap;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;

class BaseInviteFloatBarUICtr$1
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  BaseInviteFloatBarUICtr$1(BaseInviteFloatBarUICtr paramBaseInviteFloatBarUICtr) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (this.a.a != null)
    {
      this.a.a.a(paramBitmap);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr.1
 * JD-Core Version:    0.7.0.1
 */