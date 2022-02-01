package com.tencent.luggage.wxa.pl;

import com.tencent.luggage.wxa.pk.c;
import java.nio.ByteBuffer;

public class b
  extends e
  implements a
{
  static final ByteBuffer a = ByteBuffer.allocate(0);
  private int f;
  private String g;
  
  public b()
  {
    super(d.a.f);
    a(true);
  }
  
  public b(int paramInt, String paramString)
  {
    super(d.a.f);
    a(true);
    a(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    int i = paramInt;
    if (paramInt == 1015)
    {
      localObject = "";
      i = 1005;
    }
    if (i == 1005)
    {
      if (((String)localObject).length() <= 0) {
        return;
      }
      throw new com.tencent.luggage.wxa.pk.b(1002, "A close frame must have a closecode if it has a reason");
    }
    paramString = com.tencent.luggage.wxa.pn.b.a((String)localObject);
    localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt(i);
    ((ByteBuffer)localObject).position(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length + 2);
    localByteBuffer.put((ByteBuffer)localObject);
    localByteBuffer.put(paramString);
    localByteBuffer.rewind();
    a(localByteBuffer);
  }
  
  private void g()
  {
    this.f = 1005;
    Object localObject = super.c();
    ((ByteBuffer)localObject).mark();
    if (((ByteBuffer)localObject).remaining() >= 2)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.position(2);
      localByteBuffer.putShort(((ByteBuffer)localObject).getShort());
      localByteBuffer.position(0);
      this.f = localByteBuffer.getInt();
      int i = this.f;
      if ((i == 1006) || (i == 1015) || (i == 1005) || (i > 4999) || (i < 1000) || (i == 1004))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("closecode must not be sent over the wire: ");
        ((StringBuilder)localObject).append(this.f);
        throw new c(((StringBuilder)localObject).toString());
      }
    }
    ((ByteBuffer)localObject).reset();
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/luggage/wxa/pl/b:f	I
    //   4: sipush 1005
    //   7: if_icmpne +15 -> 22
    //   10: aload_0
    //   11: aload_0
    //   12: invokespecial 84	com/tencent/luggage/wxa/pl/e:c	()Ljava/nio/ByteBuffer;
    //   15: invokestatic 132	com/tencent/luggage/wxa/pn/b:a	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   18: putfield 134	com/tencent/luggage/wxa/pl/b:g	Ljava/lang/String;
    //   21: return
    //   22: aload_0
    //   23: invokespecial 84	com/tencent/luggage/wxa/pl/e:c	()Ljava/nio/ByteBuffer;
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 136	java/nio/ByteBuffer:position	()I
    //   31: istore_1
    //   32: aload_2
    //   33: aload_2
    //   34: invokevirtual 136	java/nio/ByteBuffer:position	()I
    //   37: iconst_2
    //   38: iadd
    //   39: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   42: pop
    //   43: aload_0
    //   44: aload_2
    //   45: invokestatic 132	com/tencent/luggage/wxa/pn/b:a	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   48: putfield 134	com/tencent/luggage/wxa/pl/b:g	Ljava/lang/String;
    //   51: aload_2
    //   52: iload_1
    //   53: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   56: pop
    //   57: return
    //   58: astore_3
    //   59: goto +13 -> 72
    //   62: astore_3
    //   63: new 116	com/tencent/luggage/wxa/pk/c
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 139	com/tencent/luggage/wxa/pk/c:<init>	(Ljava/lang/Throwable;)V
    //   71: athrow
    //   72: aload_2
    //   73: iload_1
    //   74: invokevirtual 64	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   77: pop
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   31	43	1	i	int
    //   26	47	2	localByteBuffer	ByteBuffer
    //   58	1	3	localObject	Object
    //   62	17	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   32	51	58	finally
    //   63	72	58	finally
    //   32	51	62	java/lang/IllegalArgumentException
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    super.a(paramByteBuffer);
    g();
    h();
  }
  
  public String b()
  {
    return this.g;
  }
  
  public ByteBuffer c()
  {
    if (this.f == 1005) {
      return a;
    }
    return super.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("code: ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pl.b
 * JD-Core Version:    0.7.0.1
 */