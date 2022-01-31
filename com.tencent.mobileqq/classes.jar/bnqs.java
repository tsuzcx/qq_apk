import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class bnqs
{
  public static int a;
  public static String a;
  protected static Method a;
  protected static boolean a;
  public static int b;
  public static String b;
  protected static Method b;
  public static String c;
  protected static Method c;
  protected static Method d;
  protected MediaCodec a;
  protected MediaFormat a;
  protected ByteBuffer[] a;
  protected MediaFormat b;
  protected ByteBuffer[] b;
  protected int c;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "video/avc";
    jdField_b_of_type_JavaLangString = "request-sync";
    jdField_c_of_type_JavaLangString = "AndroidCodec";
    jdField_a_of_type_Boolean = true;
  }
  
  public bnqs()
  {
    this.jdField_c_of_type_Int = jdField_b_of_type_Int;
    a();
    if ((Build.VERSION.SDK_INT >= 19) && (d == null)) {}
    try
    {
      d = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      d = null;
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "getCodecCapabilities erro", paramMediaCodecInfo);
      }
    }
    return null;
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localMediaCodecInfo.getName().contains(".sw.")) || (localMediaCodecInfo.getName().contains(".SW.")) || (localMediaCodecInfo.getName().contains("google")) || (localMediaCodecInfo.getName().contains("Google")) || (localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static void a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_b_of_type_JavaLangReflectMethod == null) {
        jdField_b_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_c_of_type_JavaLangReflectMethod == null) {
        jdField_c_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_JavaLangReflectMethod = null;
      jdField_b_of_type_JavaLangReflectMethod = null;
      jdField_c_of_type_JavaLangReflectMethod = null;
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public MediaCodec a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaCodec;
  }
  
  /* Error */
  public bnqt a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 165	bnqs:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 174	bnqt
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 177	bnqt:<init>	(Lbnqs;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 165	bnqs:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   23: lload_1
    //   24: invokevirtual 181	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   27: istore_3
    //   28: iload_3
    //   29: iflt +139 -> 168
    //   32: getstatic 53	android/os/Build$VERSION:SDK_INT	I
    //   35: bipush 20
    //   37: if_icmpgt +34 -> 71
    //   40: aload_0
    //   41: monitorenter
    //   42: aload 4
    //   44: iload_3
    //   45: putfield 182	bnqt:jdField_a_of_type_Int	I
    //   48: aload 4
    //   50: aload_0
    //   51: getfield 184	bnqs:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   54: iload_3
    //   55: aaload
    //   56: putfield 187	bnqt:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload 4
    //   63: areturn
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: aload_0
    //   72: monitorenter
    //   73: aload 4
    //   75: iload_3
    //   76: putfield 182	bnqt:jdField_a_of_type_Int	I
    //   79: aload 4
    //   81: getstatic 146	bnqs:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   84: aload_0
    //   85: getfield 165	bnqs:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_3
    //   95: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokevirtual 197	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 199	java/nio/ByteBuffer
    //   105: putfield 187	bnqt:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   108: aload_0
    //   109: monitorexit
    //   110: aload 4
    //   112: areturn
    //   113: astore 5
    //   115: aload 5
    //   117: invokevirtual 202	java/lang/IllegalAccessException:printStackTrace	()V
    //   120: aload 4
    //   122: iconst_0
    //   123: putfield 203	bnqt:jdField_a_of_type_Boolean	Z
    //   126: goto -18 -> 108
    //   129: astore 4
    //   131: aload_0
    //   132: monitorexit
    //   133: aload 4
    //   135: athrow
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 204	java/lang/IllegalArgumentException:printStackTrace	()V
    //   143: aload 4
    //   145: iconst_0
    //   146: putfield 203	bnqt:jdField_a_of_type_Boolean	Z
    //   149: goto -41 -> 108
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 205	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   159: aload 4
    //   161: iconst_0
    //   162: putfield 203	bnqt:jdField_a_of_type_Boolean	Z
    //   165: goto -57 -> 108
    //   168: aload 4
    //   170: iload_3
    //   171: putfield 182	bnqt:jdField_a_of_type_Int	I
    //   174: aload 4
    //   176: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	bnqs
    //   0	177	1	paramLong	long
    //   27	144	3	i	int
    //   17	45	4	localbnqt1	bnqt
    //   64	57	4	localbnqt2	bnqt
    //   129	46	4	localbnqt3	bnqt
    //   113	3	5	localIllegalAccessException	IllegalAccessException
    //   136	3	5	localIllegalArgumentException	IllegalArgumentException
    //   152	3	5	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   42	61	64	finally
    //   66	68	64	finally
    //   79	108	113	java/lang/IllegalAccessException
    //   73	79	129	finally
    //   79	108	129	finally
    //   108	110	129	finally
    //   115	126	129	finally
    //   131	133	129	finally
    //   138	149	129	finally
    //   154	165	129	finally
    //   79	108	136	java/lang/IllegalArgumentException
    //   79	108	152	java/lang/reflect/InvocationTargetException
  }
  
  public void a(bnqt parambnqt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(parambnqt.jdField_a_of_type_Int, false);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "releaseOutputBuffer index = " + parambnqt.jdField_a_of_type_Int);
        }
      }
      return;
    }
    finally
    {
      parambnqt = finally;
      throw parambnqt;
    }
  }
  
  public void a(bnqt parambnqt, int paramInt1, long paramLong, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(parambnqt.jdField_a_of_type_Int, 0, paramInt1, paramLong, paramInt2);
      }
      return;
    }
    finally
    {
      parambnqt = finally;
      throw parambnqt;
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
            this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          }
          finally {}
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public bnqt b(long paramLong)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject5;
      int i;
      try
      {
        localObject5 = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (localObject5 == null) {
          return localObject1;
        }
        localObject5 = new bnqt(this);
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, paramLong);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags + ",offset=" + ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + ",size= " + ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + ",TimeUs=" + ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label444;
          }
          ((bnqt)localObject5).jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          ((bnqt)localObject5).jdField_a_of_type_Int = i;
          ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject1 = localObject5;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          ((bnqt)localObject5).jdField_a_of_type_Int = -3;
        }
      }
      finally {}
      ((bnqt)localObject5).jdField_a_of_type_Int = -2;
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        i = this.jdField_c_of_type_Int;
        int j = jdField_b_of_type_Int;
        if (i == j)
        {
          try
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            if (!QLog.isColorLevel()) {
              break label566;
            }
            QLog.e(jdField_c_of_type_JavaLangString, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label566;
            }
          }
          QLog.e(jdField_c_of_type_JavaLangString, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(jdField_c_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label566;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
          ((bnqt)localObject5).jdField_a_of_type_Int = -1;
          Object localObject3 = localObject5;
          continue;
          label444:
          ((bnqt)localObject5).jdField_a_of_type_Int = i;
          try
          {
            ((bnqt)localObject5).jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            ((bnqt)localObject5).jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localObject5;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              ((bnqt)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              ((bnqt)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              ((bnqt)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          continue;
        }
      }
      label566:
      Object localObject4 = localObject5;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = null;
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = null;
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqs
 * JD-Core Version:    0.7.0.1
 */