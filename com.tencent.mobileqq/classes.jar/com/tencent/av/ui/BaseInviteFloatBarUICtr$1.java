package com.tencent.av.ui;

import android.graphics.Bitmap;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;

class BaseInviteFloatBarUICtr$1
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  BaseInviteFloatBarUICtr$1(BaseInviteFloatBarUICtr paramBaseInviteFloatBarUICtr) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    boolean bool = false;
    if (this.a.a != null)
    {
      this.a.a.a(paramBitmap);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr.1
 * JD-Core Version:    0.7.0.1
 */