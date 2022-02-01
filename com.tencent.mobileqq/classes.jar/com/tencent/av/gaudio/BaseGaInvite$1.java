package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import android.widget.TextView;

class BaseGaInvite$1
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  BaseGaInvite$1(BaseGaInvite paramBaseGaInvite) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    boolean bool = this.a.a(paramBitmap, 6);
    if (this.a.k != null)
    {
      paramBitmap = BaseGaInvite.a(this.a.e, this.a.k, paramString, this.a.d, String.valueOf(this.a.b), this.a.i);
      this.a.k.setText(paramBitmap);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.1
 * JD-Core Version:    0.7.0.1
 */