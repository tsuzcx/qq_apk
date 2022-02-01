package com.tencent.component.network.module.common.dns;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;

final class UdpClient
{
  private static final int EPHEMERAL_RANGE = 64511;
  private static final int EPHEMERAL_START = 1024;
  private static final int EPHEMERAL_STOP = 65535;
  private static final int MAX_SIZE = 512;
  private static SecureRandom prng = new SecureRandom();
  private long timeout_value = 5000L;
  
  private static void blockUntil(SelectionKey paramSelectionKey, long paramLong)
  {
    paramLong -= System.currentTimeMillis();
    int i;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    } else if (paramLong == 0L) {
      i = paramSelectionKey.selector().selectNow();
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    throw new SocketTimeoutException();
  }
  
  /* Error */
  public byte[] sendrecv(java.lang.String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 67	java/nio/channels/DatagramChannel:open	()Ljava/nio/channels/DatagramChannel;
    //   3: astore 8
    //   5: aload 8
    //   7: iconst_0
    //   8: invokevirtual 73	java/nio/channels/SelectableChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   11: pop
    //   12: aload 8
    //   14: invokestatic 75	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   17: iconst_1
    //   18: invokevirtual 79	java/nio/channels/SelectableChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   21: astore 8
    //   23: aload 8
    //   25: invokevirtual 83	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   28: checkcast 63	java/nio/channels/DatagramChannel
    //   31: astore 9
    //   33: new 85	java/net/InetSocketAddress
    //   36: dup
    //   37: getstatic 26	com/tencent/component/network/module/common/dns/UdpClient:prng	Ljava/security/SecureRandom;
    //   40: ldc 7
    //   42: invokevirtual 89	java/security/SecureRandom:nextInt	(I)I
    //   45: sipush 1024
    //   48: iadd
    //   49: invokespecial 92	java/net/InetSocketAddress:<init>	(I)V
    //   52: astore 10
    //   54: aload 9
    //   56: invokevirtual 96	java/nio/channels/DatagramChannel:socket	()Ljava/net/DatagramSocket;
    //   59: aload 10
    //   61: invokevirtual 102	java/net/DatagramSocket:bind	(Ljava/net/SocketAddress;)V
    //   64: aload 9
    //   66: new 85	java/net/InetSocketAddress
    //   69: dup
    //   70: aload_1
    //   71: invokestatic 108	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   74: bipush 53
    //   76: invokespecial 111	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
    //   79: invokevirtual 115	java/nio/channels/DatagramChannel:connect	(Ljava/net/SocketAddress;)Ljava/nio/channels/DatagramChannel;
    //   82: pop
    //   83: aload 9
    //   85: aload_2
    //   86: invokestatic 121	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   89: invokevirtual 125	java/nio/channels/DatagramChannel:write	(Ljava/nio/ByteBuffer;)I
    //   92: pop
    //   93: sipush 512
    //   96: newarray byte
    //   98: astore_1
    //   99: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   102: lstore 4
    //   104: aload_0
    //   105: getfield 32	com/tencent/component/network/module/common/dns/UdpClient:timeout_value	J
    //   108: lstore 6
    //   110: aload 8
    //   112: invokevirtual 129	java/nio/channels/SelectionKey:isReadable	()Z
    //   115: ifne +16 -> 131
    //   118: aload 8
    //   120: lload 4
    //   122: lload 6
    //   124: ladd
    //   125: invokestatic 131	com/tencent/component/network/module/common/dns/UdpClient:blockUntil	(Ljava/nio/channels/SelectionKey;J)V
    //   128: goto -18 -> 110
    //   131: aload 8
    //   133: invokevirtual 134	java/nio/channels/SelectionKey:isValid	()Z
    //   136: ifeq +10 -> 146
    //   139: aload 8
    //   141: iconst_0
    //   142: invokevirtual 138	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   145: pop
    //   146: aload 9
    //   148: aload_1
    //   149: invokestatic 121	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   152: invokevirtual 141	java/nio/channels/DatagramChannel:read	(Ljava/nio/ByteBuffer;)I
    //   155: i2l
    //   156: lstore 4
    //   158: lload 4
    //   160: lconst_0
    //   161: lcmp
    //   162: ifle +42 -> 204
    //   165: lload 4
    //   167: l2i
    //   168: istore_3
    //   169: iload_3
    //   170: newarray byte
    //   172: astore_2
    //   173: aload_1
    //   174: iconst_0
    //   175: aload_2
    //   176: iconst_0
    //   177: iload_3
    //   178: invokestatic 145	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   181: aload 8
    //   183: ifnull +19 -> 202
    //   186: aload 8
    //   188: invokevirtual 46	java/nio/channels/SelectionKey:selector	()Ljava/nio/channels/Selector;
    //   191: invokevirtual 148	java/nio/channels/Selector:close	()V
    //   194: aload 8
    //   196: invokevirtual 83	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   199: invokevirtual 149	java/nio/channels/SelectableChannel:close	()V
    //   202: aload_2
    //   203: areturn
    //   204: aload 8
    //   206: ifnull +19 -> 225
    //   209: aload 8
    //   211: invokevirtual 46	java/nio/channels/SelectionKey:selector	()Ljava/nio/channels/Selector;
    //   214: invokevirtual 148	java/nio/channels/Selector:close	()V
    //   217: aload 8
    //   219: invokevirtual 83	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   222: invokevirtual 149	java/nio/channels/SelectableChannel:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_1
    //   228: aload 8
    //   230: invokevirtual 134	java/nio/channels/SelectionKey:isValid	()Z
    //   233: ifeq +10 -> 243
    //   236: aload 8
    //   238: iconst_0
    //   239: invokevirtual 138	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   242: pop
    //   243: aload_1
    //   244: athrow
    //   245: astore_2
    //   246: aload 8
    //   248: astore_1
    //   249: goto +6 -> 255
    //   252: astore_2
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +17 -> 273
    //   259: aload_1
    //   260: invokevirtual 46	java/nio/channels/SelectionKey:selector	()Ljava/nio/channels/Selector;
    //   263: invokevirtual 148	java/nio/channels/Selector:close	()V
    //   266: aload_1
    //   267: invokevirtual 83	java/nio/channels/SelectionKey:channel	()Ljava/nio/channels/SelectableChannel;
    //   270: invokevirtual 149	java/nio/channels/SelectableChannel:close	()V
    //   273: goto +5 -> 278
    //   276: aload_2
    //   277: athrow
    //   278: goto -2 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	UdpClient
    //   0	281	1	paramString	java.lang.String
    //   0	281	2	paramArrayOfByte	byte[]
    //   168	10	3	i	int
    //   102	64	4	l1	long
    //   108	15	6	l2	long
    //   3	244	8	localObject	Object
    //   31	116	9	localDatagramChannel	java.nio.channels.DatagramChannel
    //   52	8	10	localInetSocketAddress	java.net.InetSocketAddress
    // Exception table:
    //   from	to	target	type
    //   110	128	227	finally
    //   23	110	245	finally
    //   131	146	245	finally
    //   146	158	245	finally
    //   169	181	245	finally
    //   228	243	245	finally
    //   243	245	245	finally
    //   0	23	252	finally
  }
  
  public void setTimeout(long paramLong)
  {
    if (paramLong > 0L) {
      this.timeout_value = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.UdpClient
 * JD-Core Version:    0.7.0.1
 */