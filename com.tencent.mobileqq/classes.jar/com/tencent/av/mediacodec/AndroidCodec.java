package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.mediacodec.config.CodecConfigParser;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class AndroidCodec
{
  public static int a;
  public static String a;
  protected static Method a;
  protected static boolean a;
  public static int b;
  public static String b;
  public static Method b;
  public static boolean b;
  public static int c;
  public static String c;
  public static Method c;
  public static String d;
  protected static Method d;
  public MediaCodec a;
  protected MediaFormat a;
  Object a;
  protected ByteBuffer[] a;
  public MediaFormat b;
  public ByteBuffer[] b;
  public int d;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "video/avc";
    jdField_b_of_type_JavaLangString = "video/hevc";
    jdField_c_of_type_JavaLangString = "request-sync";
    jdField_d_of_type_JavaLangString = "AndroidCodec";
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Int = 33000;
  }
  
  public AndroidCodec()
  {
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_d_of_type_Int = jdField_b_of_type_Int;
    a();
    if ((Build.VERSION.SDK_INT >= 19) && (jdField_d_of_type_JavaLangReflectMethod == null)) {}
    try
    {
      jdField_d_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      jdField_d_of_type_JavaLangReflectMethod = null;
    }
  }
  
  public static int a(Context paramContext)
  {
    int k = 0;
    int i = 0;
    int j;
    if (Build.VERSION.SDK_INT < 16) {
      j = i;
    }
    do
    {
      do
      {
        return j;
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        a();
        j = i;
      } while (!jdField_b_of_type_Boolean);
      j = i;
    } while (!new File(paramContext.getApplicationInfo().nativeLibraryDir + "/libhwcodec.so").exists());
    String str;
    if (!jdField_a_of_type_Boolean)
    {
      b();
      if (jdField_a_of_type_Boolean)
      {
        str = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
        str = str + "MODEL=" + Build.MODEL.toLowerCase() + ";";
        str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
        str = str + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
        str = str + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        paramContext = paramContext.getApplicationInfo();
        str = str + "DATADIR=" + paramContext.dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label427;
        }
      }
    }
    label394:
    label427:
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;")
    {
      NativeCodec.set_device_infos(paramContext);
      j = i;
      if (!jdField_a_of_type_Boolean) {
        break;
      }
      QLog.e(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature start");
      if (!DeviceCheck.b()) {
        break label463;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in decoder white list.");
      }
      i = k;
      if (DeviceCheck.e()) {
        i = 1;
      }
      if (!DeviceCheck.a()) {
        break label644;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in encoder white list.");
      }
      j = i;
      if (!DeviceCheck.f()) {
        break;
      }
      return i + 2;
    }
    label463:
    paramContext = ConfigInfo.instance();
    if (paramContext != null)
    {
      paramContext = paramContext.getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature decoder sharpConfigPayload:\n" + paramContext);
      }
      paramContext = new CodecConfigParser(paramContext);
      if (!paramContext.c()) {
        break label829;
      }
      if (!DeviceCheck.e()) {
        break label824;
      }
      j = 1;
      label532:
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature avc decoder enabled ret：\n" + j);
      }
    }
    label644:
    label824:
    label829:
    for (i = j;; i = 0)
    {
      k = i;
      if (paramContext.a())
      {
        j = i;
        if (DeviceCheck.c()) {
          j = i + 4;
        }
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature hevc decoder enabled ret：\n" + j);
          k = j;
        }
      }
      i = k;
      break label394;
      QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature1 configInfo null\n");
      i = k;
      break label394;
      paramContext = ConfigInfo.instance();
      if (paramContext != null)
      {
        paramContext = paramContext.getSharpConfigPayloadFromFile();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature encoder sharpConfigPayload:\n" + paramContext);
        }
        paramContext = new CodecConfigParser(paramContext);
        k = i;
        if (paramContext.d())
        {
          j = i;
          if (DeviceCheck.f()) {
            j = i + 2;
          }
          k = j;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature avc encoder enabled ret：\n" + j);
            k = j;
          }
        }
        j = k;
        if (!paramContext.b()) {
          break;
        }
        i = k;
        if (DeviceCheck.d()) {
          i = k + 8;
        }
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature hevc encoder enabled ret：\n" + i);
        return i;
      }
      QLog.d(jdField_d_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature2 configInfo null\n");
      return i;
      j = 0;
      break label532;
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramString)
    {
      do
      {
        paramMediaCodecInfo = localObject;
      } while (!QLog.isDevelopLevel());
      QLog.d(jdField_d_of_type_JavaLangString, 4, "getCodecCapabilities", paramString);
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
  
  @SuppressLint({"NewApi"})
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
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
  
  public static void a()
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
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public static List b(String paramString)
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
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
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
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
      System.loadLibrary("hwcodec");
      int i = NativeCodec.getVersion();
      if ((QLog.isColorLevel()) || (i > 0)) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "Native so version =" + i);
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public MediaFormat a(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public AndroidCodec.BufferData a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 370	com/tencent/av/mediacodec/AndroidCodec$BufferData
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 373	com/tencent/av/mediacodec/AndroidCodec$BufferData:<init>	(Lcom/tencent/av/mediacodec/AndroidCodec;)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   22: getstatic 44	com/tencent/av/mediacodec/AndroidCodec:jdField_c_of_type_Int	I
    //   25: i2l
    //   26: invokevirtual 377	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   29: istore_1
    //   30: iload_1
    //   31: iflt -24 -> 7
    //   34: getstatic 63	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmpgt +29 -> 68
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_2
    //   45: iload_1
    //   46: putfield 378	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Int	I
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 380	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   54: iload_1
    //   55: aaload
    //   56: putfield 383	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: areturn
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_2
    //   71: iload_1
    //   72: putfield 378	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Int	I
    //   75: aload_2
    //   76: getstatic 296	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   79: aload_0
    //   80: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: iload_1
    //   90: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokevirtual 355	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 385	java/nio/ByteBuffer
    //   100: putfield 383	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 386	java/lang/IllegalAccessException:printStackTrace	()V
    //   112: aload_2
    //   113: iconst_0
    //   114: putfield 387	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 388	java/lang/IllegalArgumentException:printStackTrace	()V
    //   130: aload_2
    //   131: iconst_0
    //   132: putfield 387	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   135: goto -32 -> 103
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 389	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   143: aload_2
    //   144: iconst_0
    //   145: putfield 387	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AndroidCodec
    //   29	61	1	i	int
    //   17	45	2	localBufferData1	AndroidCodec.BufferData
    //   63	50	2	localBufferData2	AndroidCodec.BufferData
    //   120	24	2	localObject	Object
    //   107	2	3	localIllegalAccessException	IllegalAccessException
    //   125	2	3	localIllegalArgumentException	IllegalArgumentException
    //   138	2	3	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   44	61	63	finally
    //   64	66	63	finally
    //   75	103	107	java/lang/IllegalAccessException
    //   70	75	120	finally
    //   75	103	120	finally
    //   103	105	120	finally
    //   108	117	120	finally
    //   121	123	120	finally
    //   126	135	120	finally
    //   139	148	120	finally
    //   75	103	125	java/lang/IllegalArgumentException
    //   75	103	138	java/lang/reflect/InvocationTargetException
  }
  
  public ByteBuffer a(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 397	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	AndroidCodec
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 402	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq -24 -> 13
    //   40: getstatic 39	com/tencent/av/mediacodec/AndroidCodec:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   43: iconst_2
    //   44: ldc_w 404
    //   47: aload 6
    //   49: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: goto -39 -> 13
    //   55: astore 6
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 6
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	AndroidCodec
    //   0	62	1	paramInt1	int
    //   0	62	2	paramInt2	int
    //   0	62	3	paramLong	long
    //   0	62	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	16	6	localException	Exception
    //   55	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	55	finally
    //   16	29	55	finally
    //   34	52	55	finally
  }
  
  public void a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    while ((this.jdField_a_of_type_AndroidMediaMediaCodec == null) || (jdField_d_of_type_JavaLangReflectMethod == null)) {
      return;
    }
    try
    {
      jdField_d_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { paramBundle });
      return;
    }
    catch (IllegalArgumentException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramBundle)
    {
      paramBundle.printStackTrace();
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
    catch (Exception localException) {}
    return true;
  }
  
  /* Error */
  public boolean a(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 420	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   8: iload_2
    //   9: getstatic 54	com/tencent/av/mediacodec/AndroidCodec:jdField_b_of_type_Int	I
    //   12: if_icmpne +150 -> 162
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 420	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   20: ldc_w 422
    //   23: invokevirtual 426	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 430	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   29: putfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 56	com/tencent/av/mediacodec/AndroidCodec:jdField_d_of_type_Int	I
    //   37: aload_0
    //   38: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +101 -> 142
    //   44: iload_2
    //   45: getstatic 23	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_Int	I
    //   48: if_icmpne +148 -> 196
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_3
    //   54: ifnull +74 -> 128
    //   57: invokestatic 433	com/tencent/av/mediacodec/DeviceCheck:g	()Z
    //   60: ifeq +68 -> 128
    //   63: invokestatic 438	com/tencent/av/utils/ClassLoaderUtil:a	()Ldalvik/system/DexClassLoader;
    //   66: astore_1
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 440
    //   72: invokestatic 443	com/tencent/av/utils/ClassLoaderUtil:a	(Ldalvik/system/DexClassLoader;Ljava/lang/String;)Ljava/lang/Object;
    //   75: putfield 52	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   78: aload_0
    //   79: getfield 52	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   82: astore 5
    //   84: aload_0
    //   85: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   88: astore 6
    //   90: aload_1
    //   91: aload 5
    //   93: ldc_w 445
    //   96: iconst_2
    //   97: anewarray 71	java/lang/Class
    //   100: dup
    //   101: iconst_0
    //   102: ldc 67
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc_w 447
    //   110: aastore
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 6
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_3
    //   123: aastore
    //   124: invokestatic 450	com/tencent/av/utils/ClassLoaderUtil:a	(Ldalvik/system/DexClassLoader;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_0
    //   129: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   132: aload_0
    //   133: getfield 420	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   136: aconst_null
    //   137: aconst_null
    //   138: iload_2
    //   139: invokevirtual 454	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   142: aload_0
    //   143: getfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   146: ifnull +6 -> 152
    //   149: iconst_1
    //   150: istore 4
    //   152: iload 4
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 420	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   167: ldc_w 422
    //   170: invokevirtual 426	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: invokestatic 458	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   176: putfield 345	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   179: goto -147 -> 32
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: iconst_0
    //   197: istore_2
    //   198: goto -145 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	AndroidCodec
    //   0	201	1	paramMediaFormat	MediaFormat
    //   0	201	2	paramInt	int
    //   0	201	3	paramIMediaCodecCallback	IMediaCodecCallback
    //   1	152	4	bool	boolean
    //   82	10	5	localObject	Object
    //   88	30	6	localMediaCodec	MediaCodec
    // Exception table:
    //   from	to	target	type
    //   15	32	155	java/lang/Exception
    //   162	179	182	java/lang/Exception
    //   37	51	189	java/lang/Exception
    //   57	128	189	java/lang/Exception
    //   128	142	189	java/lang/Exception
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        paramMediaFormat = a(paramString);
        if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
        {
          this.jdField_d_of_type_Int = jdField_a_of_type_Int;
          i = 1;
          MediaCodec localMediaCodec;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            if ((paramIMediaCodecCallback != null) && (DeviceCheck.g()))
            {
              paramMediaFormat = ClassLoaderUtil.a();
              this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(paramMediaFormat, "com.tencent.av.mediacodec.MediaCodecWrapper");
              paramString = this.jdField_a_of_type_JavaLangObject;
              localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
              ClassLoaderUtil.a(paramMediaFormat, paramString, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { localMediaCodec, paramIMediaCodecCallback });
            }
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, paramSurface, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            break label159;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label159:
      int i = 0;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.jdField_d_of_type_Int = jdField_a_of_type_Int;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        MediaCodec localMediaCodec;
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            if ((paramIMediaCodecCallback != null) && (DeviceCheck.g()))
            {
              paramMediaFormat = ClassLoaderUtil.a();
              this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(paramMediaFormat, "com.tencent.av.mediacodec.MediaCodecWrapper");
              paramString = this.jdField_a_of_type_JavaLangObject;
              localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
              ClassLoaderUtil.a(paramMediaFormat, paramString, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { localMediaCodec, paramIMediaCodecCallback });
            }
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
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public AndroidCodec.BufferData b()
  {
    Object localObject5 = null;
    for (;;)
    {
      AndroidCodec.BufferData localBufferData;
      int i;
      try
      {
        Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = localObject5;
          return localObject1;
        }
        localBufferData = new AndroidCodec.BufferData(this);
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, jdField_c_of_type_Int);
        switch (i)
        {
        case -3: 
          localObject1 = localObject5;
          if (i < 0) {
            continue;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label361;
          }
          localBufferData.jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          localBufferData.jdField_a_of_type_Int = i;
          localBufferData.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject1 = localBufferData;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_d_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          localBufferData.jdField_a_of_type_Int = -3;
          localObject1 = localObject5;
          break;
        case -2: 
          localBufferData.jdField_a_of_type_Int = -2;
        }
      }
      finally {}
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      Object localObject3 = localObject5;
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        i = this.jdField_d_of_type_Int;
        int j = jdField_b_of_type_Int;
        Object localObject4;
        if (i == j)
        {
          try
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            localObject3 = localObject5;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_d_of_type_JavaLangString, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            localObject3 = localObject5;
          }
          catch (Exception localException)
          {
            localObject4 = localObject5;
          }
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_d_of_type_JavaLangString, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
            localObject4 = localObject5;
          }
        }
        else
        {
          localObject4 = localObject5;
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_d_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
            localObject4 = localObject5;
            continue;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_d_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
            }
            localBufferData.jdField_a_of_type_Int = -1;
            localObject4 = localBufferData;
            continue;
            label361:
            localBufferData.jdField_a_of_type_Int = i;
            try
            {
              localBufferData.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
              localBufferData.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
              localObject4 = localBufferData;
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
            catch (InvocationTargetException localInvocationTargetException)
            {
              for (;;)
              {
                localInvocationTargetException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
      }
    }
  }
  
  public ByteBuffer b(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_d_of_type_JavaLangString, 2, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
  }
  
  public void d()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.mediacodec.AndroidCodec
 * JD-Core Version:    0.7.0.1
 */