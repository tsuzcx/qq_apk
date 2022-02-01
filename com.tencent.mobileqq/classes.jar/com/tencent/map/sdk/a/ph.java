package com.tencent.map.sdk.a;

import android.os.Handler;

public final class ph
  implements lh
{
  private pn a;
  
  public ph(pn parampn)
  {
    this.a = parampn;
  }
  
  public final void a(kc paramkc)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return;
    }
    if (paramkc != null) {
      localpn.a(localpn.az.e());
    }
    if (this.a.C != null) {
      this.a.C.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ph
 * JD-Core Version:    0.7.0.1
 */