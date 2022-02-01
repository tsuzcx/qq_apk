package com.tencent.beacon.a.c;

import com.tencent.beacon.base.util.c;
import com.tencent.qmsp.sdk.base.IVendorCallback;

class d
  implements IVendorCallback
{
  d(f paramf) {}
  
  public void onResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    c.a("getOAID: isEnable: %s, aaid: %s, oaid: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    f.a(this.a, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.c.d
 * JD-Core Version:    0.7.0.1
 */