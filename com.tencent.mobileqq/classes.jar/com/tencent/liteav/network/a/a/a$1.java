package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import java.io.IOException;
import java.net.InetAddress;

final class a$1
  implements com.tencent.liteav.network.a.c
{
  public e[] a(b paramb, d paramd)
  {
    InetAddress[] arrayOfInetAddress2 = a.b();
    InetAddress[] arrayOfInetAddress1 = arrayOfInetAddress2;
    if (arrayOfInetAddress2 == null) {
      arrayOfInetAddress1 = a.a();
    }
    if (arrayOfInetAddress1 != null) {
      return new c(arrayOfInetAddress1[0]).a(paramb, paramd);
    }
    throw new IOException("cant get local dns server");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */