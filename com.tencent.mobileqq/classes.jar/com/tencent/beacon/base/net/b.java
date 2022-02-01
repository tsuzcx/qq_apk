package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.util.c;

class b
  implements com.tencent.beacon.base.net.a.b<byte[]>
{
  b(d paramd, k paramk, boolean paramBoolean, com.tencent.beacon.base.net.a.b paramb) {}
  
  public void a(e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jceRequest: ");
    localStringBuilder.append(parame.toString());
    c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
    this.d.a(parame);
    this.c.a(parame);
    d.a(this.d);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jceRequest: ");
        localStringBuilder.append(this.a.g());
        localStringBuilder.append(" request success!");
        c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
        this.c.a(paramArrayOfByte);
        d.a(this.d);
        return;
      }
      catch (Exception localException)
      {
        String str2 = this.a.g().name();
        if (this.b) {
          paramArrayOfByte = "403";
        } else {
          paramArrayOfByte = "453";
        }
        a(new e(str2, paramArrayOfByte, 200, localException.getMessage(), localException));
        return;
      }
    }
    String str1 = this.a.g().name();
    if (this.b) {
      paramArrayOfByte = "402";
    } else {
      paramArrayOfByte = "452";
    }
    a(new e(str1, paramArrayOfByte, 200, "raw response == null", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b
 * JD-Core Version:    0.7.0.1
 */