package com.google.protobuf;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream
  extends ByteOutput
{
  private static final Logger b = Logger.getLogger(CodedOutputStream.class.getName());
  private static final boolean c = UnsafeUtil.a();
  CodedOutputStreamWriter a;
  private boolean d;
  
  static int a(int paramInt)
  {
    if (paramInt > 4096) {
      return 4096;
    }
    return paramInt;
  }
  
  public static int a(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return h(paramInt) + a(paramLazyFieldLite);
  }
  
  public static int a(LazyFieldLite paramLazyFieldLite)
  {
    return o(paramLazyFieldLite.b());
  }
  
  public static CodedOutputStream a(OutputStream paramOutputStream, int paramInt)
  {
    return new CodedOutputStream.OutputStreamEncoder(paramOutputStream, paramInt);
  }
  
  public static CodedOutputStream a(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int b(double paramDouble)
  {
    return 8;
  }
  
  public static int b(float paramFloat)
  {
    return 4;
  }
  
  public static int b(int paramInt, double paramDouble)
  {
    return h(paramInt) + b(paramDouble);
  }
  
  public static int b(int paramInt, float paramFloat)
  {
    return h(paramInt) + b(paramFloat);
  }
  
  public static int b(int paramInt, LazyFieldLite paramLazyFieldLite)
  {
    return h(1) * 2 + i(2, paramInt) + a(3, paramLazyFieldLite);
  }
  
  static int b(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    return h(paramInt) + b(paramMessageLite, paramSchema);
  }
  
  public static int b(int paramInt, String paramString)
  {
    return h(paramInt) + b(paramString);
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    return h(paramInt) + b(paramBoolean);
  }
  
  public static int b(ByteString paramByteString)
  {
    return o(paramByteString.size());
  }
  
  public static int b(MessageLite paramMessageLite)
  {
    return o(paramMessageLite.getSerializedSize());
  }
  
  static int b(MessageLite paramMessageLite, Schema paramSchema)
  {
    return o(((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema));
  }
  
  public static int b(String paramString)
  {
    try
    {
      i = Utf8.a(paramString);
    }
    catch (Utf8.UnpairedSurrogateException localUnpairedSurrogateException)
    {
      int i;
      label8:
      break label8;
    }
    i = paramString.getBytes(Internal.a).length;
    return o(i);
  }
  
  public static int b(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int c(int paramInt, ByteString paramByteString)
  {
    return h(paramInt) + b(paramByteString);
  }
  
  public static int c(int paramInt, MessageLite paramMessageLite)
  {
    return h(paramInt) + b(paramMessageLite);
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    return o(paramArrayOfByte.length);
  }
  
  public static CodedOutputStream c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedOutputStream.ArrayEncoder(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int d(int paramInt, ByteString paramByteString)
  {
    return h(1) * 2 + i(2, paramInt) + c(3, paramByteString);
  }
  
  public static int d(int paramInt, MessageLite paramMessageLite)
  {
    return h(1) * 2 + i(2, paramInt) + c(3, paramMessageLite);
  }
  
  @Deprecated
  static int d(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    return h(paramInt) * 2 + d(paramMessageLite, paramSchema);
  }
  
  @Deprecated
  public static int d(MessageLite paramMessageLite)
  {
    return paramMessageLite.getSerializedSize();
  }
  
  @Deprecated
  static int d(MessageLite paramMessageLite, Schema paramSchema)
  {
    return ((AbstractMessageLite)paramMessageLite).getSerializedSize(paramSchema);
  }
  
  public static int f(int paramInt, long paramLong)
  {
    return h(paramInt) + f(paramLong);
  }
  
  @Deprecated
  public static int f(int paramInt, MessageLite paramMessageLite)
  {
    return h(paramInt) * 2 + d(paramMessageLite);
  }
  
  public static int f(long paramLong)
  {
    return g(paramLong);
  }
  
  public static int g(int paramInt, long paramLong)
  {
    return h(paramInt) + g(paramLong);
  }
  
  public static int g(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0x0 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    else
    {
      j = 2;
    }
    int i = j;
    long l = paramLong;
    if ((0xFFE00000 & paramLong) != 0L)
    {
      i = j + 2;
      l = paramLong >>> 14;
    }
    int j = i;
    if ((l & 0xFFFFC000) != 0L) {
      j = i + 1;
    }
    return j;
  }
  
  public static int h(int paramInt)
  {
    return j(WireFormat.a(paramInt, 0));
  }
  
  public static int h(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + i(paramInt2);
  }
  
  public static int h(int paramInt, long paramLong)
  {
    return h(paramInt) + h(paramLong);
  }
  
  public static int h(long paramLong)
  {
    return g(k(paramLong));
  }
  
  public static int i(int paramInt)
  {
    if (paramInt >= 0) {
      return j(paramInt);
    }
    return 10;
  }
  
  public static int i(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + j(paramInt2);
  }
  
  public static int i(int paramInt, long paramLong)
  {
    return h(paramInt) + i(paramLong);
  }
  
  public static int i(long paramLong)
  {
    return 8;
  }
  
  public static int j(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int j(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + k(paramInt2);
  }
  
  public static int j(int paramInt, long paramLong)
  {
    return h(paramInt) + j(paramLong);
  }
  
  public static int j(long paramLong)
  {
    return 8;
  }
  
  public static int k(int paramInt)
  {
    return j(p(paramInt));
  }
  
  public static int k(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + l(paramInt2);
  }
  
  public static long k(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int l(int paramInt)
  {
    return 4;
  }
  
  public static int l(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + m(paramInt2);
  }
  
  public static int m(int paramInt)
  {
    return 4;
  }
  
  public static int m(int paramInt1, int paramInt2)
  {
    return h(paramInt1) + n(paramInt2);
  }
  
  public static int n(int paramInt)
  {
    return i(paramInt);
  }
  
  static int o(int paramInt)
  {
    return j(paramInt) + paramInt;
  }
  
  public static int p(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  @Deprecated
  public static int r(int paramInt)
  {
    return j(paramInt);
  }
  
  public abstract void a(byte paramByte);
  
  public final void a(double paramDouble)
  {
    d(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void a(float paramFloat)
  {
    e(Float.floatToRawIntBits(paramFloat));
  }
  
  public final void a(int paramInt, double paramDouble)
  {
    d(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    e(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public final void a(int paramInt, long paramLong)
  {
    b(paramInt, paramLong);
  }
  
  public abstract void a(int paramInt, ByteString paramByteString);
  
  public abstract void a(int paramInt, MessageLite paramMessageLite);
  
  abstract void a(int paramInt, MessageLite paramMessageLite, Schema paramSchema);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public final void a(long paramLong)
  {
    b(paramLong);
  }
  
  public abstract void a(ByteString paramByteString);
  
  public abstract void a(MessageLite paramMessageLite);
  
  abstract void a(MessageLite paramMessageLite, Schema paramSchema);
  
  public abstract void a(String paramString);
  
  final void a(String paramString, Utf8.UnpairedSurrogateException paramUnpairedSurrogateException)
  {
    b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramUnpairedSurrogateException);
    paramString = paramString.getBytes(Internal.a);
    try
    {
      c(paramString.length);
      b(paramString, 0, paramString.length);
      return;
    }
    catch (CodedOutputStream.OutOfSpaceException paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new CodedOutputStream.OutOfSpaceException(paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    a((byte)paramBoolean);
  }
  
  boolean a()
  {
    return this.d;
  }
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt, long paramLong);
  
  public abstract void b(int paramInt, ByteString paramByteString);
  
  public abstract void b(int paramInt, MessageLite paramMessageLite);
  
  public abstract void b(long paramLong);
  
  public final void b(byte[] paramArrayOfByte)
  {
    d(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public final void c(int paramInt, long paramLong)
  {
    b(paramInt, k(paramLong));
  }
  
  @Deprecated
  final void c(int paramInt, MessageLite paramMessageLite, Schema paramSchema)
  {
    a(paramInt, 3);
    c(paramMessageLite, paramSchema);
    a(paramInt, 4);
  }
  
  public final void c(long paramLong)
  {
    b(k(paramLong));
  }
  
  @Deprecated
  public final void c(MessageLite paramMessageLite)
  {
    paramMessageLite.writeTo(this);
  }
  
  @Deprecated
  final void c(MessageLite paramMessageLite, Schema paramSchema)
  {
    paramSchema.a(paramMessageLite, this.a);
  }
  
  public final void d()
  {
    if (c() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public final void d(int paramInt)
  {
    c(p(paramInt));
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    c(paramInt1, p(paramInt2));
  }
  
  public abstract void d(int paramInt, long paramLong);
  
  public abstract void d(long paramLong);
  
  abstract void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void e(int paramInt);
  
  public abstract void e(int paramInt1, int paramInt2);
  
  public final void e(int paramInt, long paramLong)
  {
    d(paramInt, paramLong);
  }
  
  @Deprecated
  public final void e(int paramInt, MessageLite paramMessageLite)
  {
    a(paramInt, 3);
    c(paramMessageLite);
    a(paramInt, 4);
  }
  
  public final void e(long paramLong)
  {
    d(paramLong);
  }
  
  public final void f(int paramInt)
  {
    e(paramInt);
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    e(paramInt1, paramInt2);
  }
  
  public final void g(int paramInt)
  {
    b(paramInt);
  }
  
  public final void g(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  @Deprecated
  public final void q(int paramInt)
  {
    c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream
 * JD-Core Version:    0.7.0.1
 */