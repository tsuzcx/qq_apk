package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import java.net.InetAddress;
import java.util.Random;

public final class c
  implements com.tencent.liteav.network.a.c
{
  private static final Random b = new Random();
  final InetAddress a;
  private final int c;
  
  public c(InetAddress paramInetAddress)
  {
    this(paramInetAddress, 10);
  }
  
  public c(InetAddress paramInetAddress, int paramInt)
  {
    this.a = paramInetAddress;
    this.c = paramInt;
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 34	java/net/DatagramSocket
    //   3: dup
    //   4: invokespecial 35	java/net/DatagramSocket:<init>	()V
    //   7: astore_2
    //   8: new 37	java/net/DatagramPacket
    //   11: dup
    //   12: aload_1
    //   13: aload_1
    //   14: arraylength
    //   15: aload_0
    //   16: getfield 29	com/tencent/liteav/network/a/a/c:a	Ljava/net/InetAddress;
    //   19: bipush 53
    //   21: invokespecial 40	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
    //   24: astore_1
    //   25: aload_2
    //   26: aload_0
    //   27: getfield 31	com/tencent/liteav/network/a/a/c:c	I
    //   30: sipush 1000
    //   33: imul
    //   34: invokevirtual 44	java/net/DatagramSocket:setSoTimeout	(I)V
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 48	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
    //   42: new 37	java/net/DatagramPacket
    //   45: dup
    //   46: sipush 1500
    //   49: newarray byte
    //   51: sipush 1500
    //   54: invokespecial 51	java/net/DatagramPacket:<init>	([BI)V
    //   57: astore_1
    //   58: aload_2
    //   59: aload_1
    //   60: invokevirtual 54	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   63: aload_1
    //   64: invokevirtual 58	java/net/DatagramPacket:getData	()[B
    //   67: astore_1
    //   68: aload_2
    //   69: invokevirtual 61	java/net/DatagramSocket:close	()V
    //   72: aload_1
    //   73: areturn
    //   74: astore_3
    //   75: aload_2
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: goto +6 -> 85
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 61	java/net/DatagramSocket:close	()V
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	c
    //   0	95	1	paramArrayOfByte	byte[]
    //   7	72	2	localObject1	Object
    //   82	12	2	localObject2	Object
    //   74	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	68	74	finally
    //   0	8	82	finally
  }
  
  public e[] a(com.tencent.liteav.network.a.b paramb, d arg2)
  {
    synchronized (b)
    {
      int i = b.nextInt() & 0xFF;
      ??? = a(b.a(paramb.a, i));
      if (??? != null) {
        return b.a(???, i, paramb.a);
      }
      throw new a(paramb.a, "cant get answer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.c
 * JD-Core Version:    0.7.0.1
 */