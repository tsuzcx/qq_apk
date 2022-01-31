import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class bfhd
  extends Writer
{
  static Class jdField_a_of_type_JavaLangClass;
  static Field jdField_a_of_type_JavaLangReflectField;
  static Field jdField_b_of_type_JavaLangReflectField;
  static boolean jdField_b_of_type_Boolean = true;
  private final OutputStream jdField_a_of_type_JavaIoOutputStream;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(8192);
  CharBuffer jdField_a_of_type_JavaNioCharBuffer;
  private CharsetEncoder jdField_a_of_type_JavaNioCharsetCharsetEncoder;
  boolean jdField_a_of_type_Boolean = false;
  
  public bfhd(File paramFile, boolean paramBoolean)
  {
    this(new BufferedOutputStream(new FileOutputStream(paramFile, paramBoolean)));
  }
  
  public bfhd(OutputStream paramOutputStream)
  {
    this(paramOutputStream, Charset.defaultCharset());
  }
  
  public bfhd(OutputStream paramOutputStream, Charset paramCharset)
  {
    super(paramOutputStream);
    this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
    this.jdField_a_of_type_JavaNioCharsetCharsetEncoder = paramCharset.newEncoder();
    this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.onMalformedInput(CodingErrorAction.REPLACE);
    this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  /* Error */
  private CharBuffer a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	bfhd:jdField_a_of_type_Boolean	Z
    //   4: ifne +23 -> 27
    //   7: aload_0
    //   8: aload_1
    //   9: iload_2
    //   10: iload_3
    //   11: invokestatic 91	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   14: putfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 52	bfhd:jdField_a_of_type_Boolean	Z
    //   22: aload_0
    //   23: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   26: areturn
    //   27: getstatic 17	bfhd:jdField_b_of_type_Boolean	Z
    //   30: ifeq +258 -> 288
    //   33: aload_0
    //   34: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   37: invokevirtual 97	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   40: pop
    //   41: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   44: ifnull +15 -> 59
    //   47: getstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   50: ifnull +9 -> 59
    //   53: getstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   56: ifnonnull +87 -> 143
    //   59: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 8
    //   64: if_icmplt +161 -> 225
    //   67: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   70: bipush 17
    //   72: if_icmpgt +153 -> 225
    //   75: ldc 111
    //   77: invokestatic 117	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   80: putstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   83: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   86: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: ldc 123
    //   91: invokevirtual 127	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   94: putstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   97: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   100: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   103: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   106: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   109: ldc 129
    //   111: invokevirtual 127	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   114: putstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   117: getstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   120: ifnull +10 -> 130
    //   123: getstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   126: iconst_1
    //   127: invokevirtual 135	java/lang/reflect/Field:setAccessible	(Z)V
    //   130: getstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   133: ifnull +10 -> 143
    //   136: getstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   139: iconst_1
    //   140: invokevirtual 135	java/lang/reflect/Field:setAccessible	(Z)V
    //   143: getstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   146: ifnull +133 -> 279
    //   149: getstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   152: ifnull +127 -> 279
    //   155: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   158: ifnull +121 -> 279
    //   161: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   164: aload_0
    //   165: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   168: invokevirtual 139	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   171: ifeq +108 -> 279
    //   174: getstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   177: aload_0
    //   178: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   181: aload_1
    //   182: invokevirtual 143	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   185: getstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   188: aload_0
    //   189: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   192: aload_1
    //   193: arraylength
    //   194: invokestatic 148	bfhe:a	(I)Ljava/lang/Integer;
    //   197: invokevirtual 143	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   200: aload_0
    //   201: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   204: iload_2
    //   205: invokevirtual 152	java/nio/CharBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload_0
    //   210: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   213: iload_2
    //   214: iload_3
    //   215: iadd
    //   216: invokevirtual 155	java/nio/CharBuffer:limit	(I)Ljava/nio/Buffer;
    //   219: pop
    //   220: aload_0
    //   221: getfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   224: areturn
    //   225: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   228: bipush 18
    //   230: if_icmplt -113 -> 117
    //   233: ldc 157
    //   235: invokestatic 117	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   238: putstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   241: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   244: ldc 123
    //   246: invokevirtual 127	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   249: putstatic 101	bfhd:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   252: getstatic 99	bfhd:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   255: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   258: invokevirtual 121	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   261: ldc 129
    //   263: invokevirtual 127	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   266: putstatic 103	bfhd:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   269: goto -152 -> 117
    //   272: astore 4
    //   274: aload 4
    //   276: invokevirtual 160	java/lang/ClassNotFoundException:printStackTrace	()V
    //   279: iconst_0
    //   280: putstatic 17	bfhd:jdField_b_of_type_Boolean	Z
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 93	bfhd:jdField_a_of_type_JavaNioCharBuffer	Ljava/nio/CharBuffer;
    //   288: aload_1
    //   289: iload_2
    //   290: iload_3
    //   291: invokestatic 91	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   294: areturn
    //   295: astore 4
    //   297: aload 4
    //   299: invokevirtual 161	java/lang/NoSuchFieldException:printStackTrace	()V
    //   302: goto -23 -> 279
    //   305: astore 4
    //   307: aload 4
    //   309: invokevirtual 162	java/lang/IllegalArgumentException:printStackTrace	()V
    //   312: goto -33 -> 279
    //   315: astore 4
    //   317: aload 4
    //   319: invokevirtual 163	java/lang/IllegalAccessException:printStackTrace	()V
    //   322: goto -43 -> 279
    //   325: astore 4
    //   327: aload 4
    //   329: invokevirtual 164	java/lang/Throwable:printStackTrace	()V
    //   332: goto -53 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	bfhd
    //   0	335	1	paramArrayOfChar	char[]
    //   0	335	2	paramInt1	int
    //   0	335	3	paramInt2	int
    //   272	3	4	localClassNotFoundException	java.lang.ClassNotFoundException
    //   295	3	4	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   305	3	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   315	3	4	localIllegalAccessException	java.lang.IllegalAccessException
    //   325	3	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   41	59	272	java/lang/ClassNotFoundException
    //   59	117	272	java/lang/ClassNotFoundException
    //   117	130	272	java/lang/ClassNotFoundException
    //   130	143	272	java/lang/ClassNotFoundException
    //   143	225	272	java/lang/ClassNotFoundException
    //   225	269	272	java/lang/ClassNotFoundException
    //   41	59	295	java/lang/NoSuchFieldException
    //   59	117	295	java/lang/NoSuchFieldException
    //   117	130	295	java/lang/NoSuchFieldException
    //   130	143	295	java/lang/NoSuchFieldException
    //   143	225	295	java/lang/NoSuchFieldException
    //   225	269	295	java/lang/NoSuchFieldException
    //   41	59	305	java/lang/IllegalArgumentException
    //   59	117	305	java/lang/IllegalArgumentException
    //   117	130	305	java/lang/IllegalArgumentException
    //   130	143	305	java/lang/IllegalArgumentException
    //   143	225	305	java/lang/IllegalArgumentException
    //   225	269	305	java/lang/IllegalArgumentException
    //   41	59	315	java/lang/IllegalAccessException
    //   59	117	315	java/lang/IllegalAccessException
    //   117	130	315	java/lang/IllegalAccessException
    //   130	143	315	java/lang/IllegalAccessException
    //   143	225	315	java/lang/IllegalAccessException
    //   225	269	315	java/lang/IllegalAccessException
    //   41	59	325	java/lang/Throwable
    //   59	117	325	java/lang/Throwable
    //   117	130	325	java/lang/Throwable
    //   130	143	325	java/lang/Throwable
    //   143	225	325	java/lang/Throwable
    //   225	269	325	java/lang/Throwable
  }
  
  private void a()
  {
    Object localObject = CharBuffer.allocate(0);
    CoderResult localCoderResult = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.encode((CharBuffer)localObject, this.jdField_a_of_type_JavaNioByteBuffer, true);
    if (localCoderResult.isError())
    {
      localCoderResult.throwException();
      label30:
      localObject = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.flush(this.jdField_a_of_type_JavaNioByteBuffer);
    }
    for (;;)
    {
      if (((CoderResult)localObject).isUnderflow()) {
        return;
      }
      if (((CoderResult)localObject).isOverflow())
      {
        a(false);
        localObject = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.flush(this.jdField_a_of_type_JavaNioByteBuffer);
        continue;
        if (!localCoderResult.isOverflow()) {
          break label30;
        }
        a(false);
        break;
      }
      ((CoderResult)localObject).throwException();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3))
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt3);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  private void a(CharBuffer paramCharBuffer)
  {
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = this.jdField_a_of_type_JavaNioCharsetCharsetEncoder.encode(paramCharBuffer, this.jdField_a_of_type_JavaNioByteBuffer, false);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      a(false);
    }
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      b();
      int i = this.jdField_a_of_type_JavaNioByteBuffer.position();
      if (i > 0)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.flip();
        this.jdField_a_of_type_JavaIoOutputStream.write(this.jdField_a_of_type_JavaNioByteBuffer.array(), this.jdField_a_of_type_JavaNioByteBuffer.arrayOffset(), i);
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
      }
      if (paramBoolean) {
        this.jdField_a_of_type_JavaIoOutputStream.flush();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaNioCharsetCharsetEncoder == null) {
      throw new IOException("OutputStreamWriter is closed");
    }
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      if (this.jdField_a_of_type_JavaNioCharsetCharsetEncoder != null)
      {
        a();
        a(false);
        this.jdField_a_of_type_JavaIoOutputStream.close();
        this.jdField_a_of_type_JavaNioCharsetCharsetEncoder = null;
        this.jdField_a_of_type_JavaNioByteBuffer = null;
      }
      return;
    }
  }
  
  public void flush()
  {
    a(true);
  }
  
  public void write(int paramInt)
  {
    synchronized (this.lock)
    {
      b();
      a(CharBuffer.wrap(new char[] { (char)paramInt }));
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.lock;
    StringBuilder localStringBuilder;
    if (paramInt2 < 0) {
      try
      {
        localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("length=");
        localStringBuilder.append(paramString.length());
        localStringBuilder.append("; regionStart=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("; regionLength=");
        localStringBuilder.append(paramInt2);
        throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
      }
      finally {}
    }
    if (paramString == null) {
      throw new NullPointerException("str == null");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramString.length() - paramInt2))
    {
      localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramString.length());
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt2);
      throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
    }
    b();
    a(CharBuffer.wrap(paramString, paramInt1, paramInt2 + paramInt1));
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      b();
      a(paramArrayOfChar.length, paramInt1, paramInt2);
      a(a(paramArrayOfChar, paramInt1, paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhd
 * JD-Core Version:    0.7.0.1
 */