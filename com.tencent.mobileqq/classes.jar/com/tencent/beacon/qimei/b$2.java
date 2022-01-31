package com.tencent.beacon.qimei;

import com.tencent.beacon.core.c.g;

final class b$2
  implements g
{
  b$2(b paramb) {}
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramBoolean = true;
    if (paramInt != 103)
    {
      com.tencent.beacon.core.d.b.c("[qimei] qimei req unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      com.tencent.beacon.core.d.b.b("[qimei] query qimei finish, result: " + paramBoolean, new Object[0]);
      if (!paramBoolean) {
        break;
      }
      com.tencent.beacon.core.d.b.a("[qimei] process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
      this.a.a(paramArrayOfByte);
      com.tencent.beacon.core.a.b.b().a(112, false);
      d.c(b.a(this.a));
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.qimei.b.2
 * JD-Core Version:    0.7.0.1
 */