package com.tencent.beacon.qimei;

import com.tencent.beacon.core.d.g;

class d
  implements g
{
  d(e parame) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramBoolean = true;
    if (paramInt != 103)
    {
      com.tencent.beacon.core.e.d.i("[qimei] qimei req unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      com.tencent.beacon.core.e.d.a("[qimei] query qimei finish, result: " + paramBoolean, new Object[0]);
      if (!paramBoolean) {
        break;
      }
      com.tencent.beacon.core.e.d.d("[qimei] process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
      this.a.a(paramArrayOfByte);
      com.tencent.beacon.core.a.d.a().a(112, false);
      i.a(e.a(this.a));
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.d
 * JD-Core Version:    0.7.0.1
 */