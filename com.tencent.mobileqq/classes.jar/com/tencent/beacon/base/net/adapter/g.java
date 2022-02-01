package com.tencent.beacon.base.net.adapter;

import android.text.TextUtils;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.f;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.pack.SocketRequestPackage;
import com.tencent.beacon.pack.SocketResponsePackage;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class g
  extends a
{
  private com.tencent.beacon.base.net.b.c<byte[], SocketResponsePackage> a = new com.tencent.beacon.base.net.b.e();
  private com.tencent.beacon.base.net.b.c<k, SocketRequestPackage> b = new com.tencent.beacon.base.net.b.d();
  
  public static a a()
  {
    return new g();
  }
  
  private Socket a(String paramString, int paramInt)
  {
    com.tencent.beacon.base.util.c.a("SocketAdapter", "create socket domain: %s, port: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new Socket(InetAddress.getByName(paramString).getHostAddress(), paramInt);
    paramString.setSoTimeout(30000);
    return paramString;
  }
  
  private void a(com.tencent.beacon.base.net.a.b<byte[]> paramb, String paramString, SocketResponsePackage paramSocketResponsePackage)
  {
    String str = paramSocketResponsePackage.msg;
    if ((str != null) && (str.equals("decrypt Data fail!")))
    {
      paramb.a(new com.tencent.beacon.base.net.e(paramString, "405", paramSocketResponsePackage.statusCode, "server encrypt-status error!"));
      return;
    }
    paramb.a(paramSocketResponsePackage.body);
  }
  
  private void a(Socket paramSocket, SocketRequestPackage paramSocketRequestPackage)
  {
    com.tencent.beacon.pack.b localb = new com.tencent.beacon.pack.b();
    paramSocketRequestPackage.writeTo(localb);
    paramSocket = paramSocket.getOutputStream();
    paramSocketRequestPackage = localb.b();
    paramSocket.write(a(paramSocketRequestPackage, paramSocketRequestPackage.length));
    paramSocket.flush();
  }
  
  /* Error */
  private byte[] a(Socket paramSocket, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokevirtual 141	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   7: astore 5
    //   9: new 143	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 144	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_1
    //   17: sipush 2048
    //   20: newarray byte
    //   22: astore 4
    //   24: aload 5
    //   26: aload 4
    //   28: invokevirtual 150	java/io/InputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +14 -> 48
    //   37: aload_1
    //   38: aload 4
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 153	java/io/ByteArrayOutputStream:write	([BII)V
    //   45: goto -21 -> 24
    //   48: aload_1
    //   49: invokevirtual 154	java/io/ByteArrayOutputStream:flush	()V
    //   52: aload_1
    //   53: invokevirtual 157	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   56: astore 6
    //   58: aload 6
    //   60: astore 4
    //   62: iload_2
    //   63: ifne +34 -> 97
    //   66: aload 6
    //   68: arraylength
    //   69: iconst_4
    //   70: isub
    //   71: invokestatic 163	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   74: astore 4
    //   76: aload 4
    //   78: aload 6
    //   80: iconst_2
    //   81: aload 6
    //   83: arraylength
    //   84: iconst_4
    //   85: isub
    //   86: invokevirtual 167	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   89: pop
    //   90: aload 4
    //   92: invokevirtual 170	java/nio/ByteBuffer:array	()[B
    //   95: astore 4
    //   97: aload_1
    //   98: invokevirtual 173	java/io/ByteArrayOutputStream:close	()V
    //   101: aload 5
    //   103: invokevirtual 174	java/io/InputStream:close	()V
    //   106: iconst_2
    //   107: anewarray 176	java/io/Closeable
    //   110: dup
    //   111: iconst_0
    //   112: aload 5
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_1
    //   118: aastore
    //   119: invokestatic 181	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   122: aload 4
    //   124: areturn
    //   125: astore 4
    //   127: goto +67 -> 194
    //   130: astore 4
    //   132: goto +14 -> 146
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_1
    //   139: goto +55 -> 194
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_1
    //   146: goto +22 -> 168
    //   149: astore 4
    //   151: aconst_null
    //   152: astore 5
    //   154: aload 5
    //   156: astore_1
    //   157: goto +37 -> 194
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_1
    //   164: aload 6
    //   166: astore 5
    //   168: aload 4
    //   170: invokestatic 184	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   173: iconst_2
    //   174: anewarray 176	java/io/Closeable
    //   177: dup
    //   178: iconst_0
    //   179: aload 5
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_1
    //   185: aastore
    //   186: invokestatic 181	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: iconst_2
    //   195: anewarray 176	java/io/Closeable
    //   198: dup
    //   199: iconst_0
    //   200: aload 5
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_1
    //   206: aastore
    //   207: invokestatic 181	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   210: goto +6 -> 216
    //   213: aload 4
    //   215: athrow
    //   216: goto -3 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	g
    //   0	219	1	paramSocket	Socket
    //   0	219	2	paramBoolean	boolean
    //   31	11	3	i	int
    //   22	101	4	localObject1	Object
    //   125	1	4	localObject2	Object
    //   130	1	4	localThrowable1	Throwable
    //   135	1	4	localObject3	Object
    //   142	1	4	localThrowable2	Throwable
    //   149	1	4	localObject4	Object
    //   160	30	4	localThrowable3	Throwable
    //   192	22	4	localObject5	Object
    //   7	194	5	localObject6	Object
    //   1	164	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	125	finally
    //   24	32	125	finally
    //   37	45	125	finally
    //   48	58	125	finally
    //   66	97	125	finally
    //   97	106	125	finally
    //   17	24	130	java/lang/Throwable
    //   24	32	130	java/lang/Throwable
    //   37	45	130	java/lang/Throwable
    //   48	58	130	java/lang/Throwable
    //   66	97	130	java/lang/Throwable
    //   97	106	130	java/lang/Throwable
    //   9	17	135	finally
    //   9	17	142	java/lang/Throwable
    //   3	9	149	finally
    //   3	9	160	java/lang/Throwable
    //   168	173	192	finally
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putShort((short)(i & 0xFFFF));
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.put((byte)13);
    localByteBuffer.put((byte)10);
    if (paramInt >= 65532) {
      com.tencent.beacon.base.util.c.b("[Error] send bytes exceed 64kB will failure!", new Object[0]);
    }
    return localByteBuffer.array();
  }
  
  public void request(f paramf, com.tencent.beacon.base.net.a.b<com.tencent.beacon.base.net.a> paramb) {}
  
  public void request(k paramk, com.tencent.beacon.base.net.a.b<byte[]> paramb)
  {
    Object localObject = paramk.c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    String str = paramk.g().name();
    for (;;)
    {
      try
      {
        localObject = a((String)localObject, paramk.e());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send data size: ");
        localStringBuilder.append(paramk.b().length);
        com.tencent.beacon.base.util.c.a("SocketAdapter", 0, localStringBuilder.toString(), new Object[0]);
        a((Socket)localObject, (SocketRequestPackage)this.b.a(paramk));
        if (paramk.g() == RequestType.EVENT)
        {
          bool = true;
          paramk = a((Socket)localObject, bool);
          if ((paramk != null) && (paramk.length > 0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("receivedData: ");
            ((StringBuilder)localObject).append(paramk.length);
            com.tencent.beacon.base.util.c.a("SocketAdapter", 1, ((StringBuilder)localObject).toString(), new Object[0]);
            paramk = (SocketResponsePackage)this.a.a(paramk);
            if (paramk == null)
            {
              paramb.a(new com.tencent.beacon.base.net.e(str, "402", -1, "responsePackage == null"));
              return;
            }
            com.tencent.beacon.base.util.c.a("SocketAdapter", 2, "socket response code: %s, header: %s, msg: %s", new Object[] { Integer.valueOf(paramk.statusCode), paramk.header, paramk.msg });
            if (paramk.statusCode == 200)
            {
              a(paramb, str, paramk);
              return;
            }
            int i = paramk.statusCode;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("responsePackage msg: ");
            ((StringBuilder)localObject).append(paramk.msg);
            paramb.a(new com.tencent.beacon.base.net.e(str, "402", i, ((StringBuilder)localObject).toString()));
            return;
          }
          paramb.a(new com.tencent.beacon.base.net.e(str, "402", -1, "receiveData == null"));
          return;
        }
      }
      catch (Throwable paramk)
      {
        com.tencent.beacon.base.util.c.b("SocketAdapter socket request error: %s", new Object[] { paramk.getMessage() });
        com.tencent.beacon.base.util.c.a(paramk);
        paramb.a(new com.tencent.beacon.base.net.e(str, "449", -1, " unknown request error!", paramk));
        com.tencent.beacon.base.net.d.c().b(this);
        return;
      }
      catch (SocketTimeoutException paramk)
      {
        paramb.a(new com.tencent.beacon.base.net.e(str, "401", -1, " request time more than 30s", paramk));
        com.tencent.beacon.base.net.d.c().b(this);
        return;
      }
      catch (ConnectException paramk)
      {
        paramb.a(new com.tencent.beacon.base.net.e(str, "401", -1, " connect time more than 30s", paramk));
        com.tencent.beacon.base.net.d.c().b(this);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.g
 * JD-Core Version:    0.7.0.1
 */