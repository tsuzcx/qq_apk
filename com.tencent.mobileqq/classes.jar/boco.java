import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodec.BufferData;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class boco
  extends AndroidCodec
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoCodec";
    jdField_a_of_type_Int = -1;
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_Int >= 0) {
      return jdField_a_of_type_Int;
    }
    jdField_a_of_type_Int = 0;
    if (paramContext == null) {
      return jdField_a_of_type_Int;
    }
    VcControllerImpl.loadLibrary(paramContext);
    if (Build.VERSION.SDK_INT < 16) {
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      invoke21Apis();
      if (!fInvokeAPILevel21)
      {
        jdField_a_of_type_Int = 0;
        return jdField_a_of_type_Int;
      }
    }
    if (DeviceCheck.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.e()) {
        jdField_a_of_type_Int = 1;
      }
      if (!a()) {
        break label146;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      if (DeviceCheck.f()) {
        jdField_a_of_type_Int += 2;
      }
    }
    for (;;)
    {
      return jdField_a_of_type_Int;
      if (!DeviceCheck.e()) {
        break;
      }
      jdField_a_of_type_Int = 1;
      break;
      label146:
      if (DeviceCheck.f()) {
        jdField_a_of_type_Int += 2;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> a(String paramString, boolean paramBoolean)
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
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 3")) && (Build.PRODUCT.equalsIgnoreCase("pisces"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return DeviceCheck.f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4"))) {
        return DeviceCheck.f();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Meizu")) || (!Build.MODEL.equalsIgnoreCase("MX4 Pro")));
    return DeviceCheck.f();
  }
  
  public MediaCodec a()
  {
    return this.mMediaCodec;
  }
  
  public AndroidCodec.BufferData dequeueOutputBuffer()
  {
    label512:
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new AndroidCodec.BufferData(this);
        i = this.mMediaCodec.dequeueOutputBuffer(((AndroidCodec.BufferData)localObject1).info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label512;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((AndroidCodec.BufferData)localObject1).info.flags + ",offset=" + ((AndroidCodec.BufferData)localObject1).info.offset + ",size= " + ((AndroidCodec.BufferData)localObject1).info.size + ",TimeUs=" + ((AndroidCodec.BufferData)localObject1).info.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label406;
          }
          ((AndroidCodec.BufferData)localObject1).buffer = this.outputBuffers[i];
          ((AndroidCodec.BufferData)localObject1).index = i;
          ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((AndroidCodec.BufferData)localObject1).index = -3;
        }
      }
      finally {}
      ((AndroidCodec.BufferData)localObject1).index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      if (this.mOutputFormat != null)
      {
        ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
        if (this.mCodecType == DEC_CODEC)
        {
          if (this.mOutputFormat.containsKey("color-format"))
          {
            i = this.mOutputFormat.getInteger("color-format");
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label512;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
          localObject2.index = -1;
          continue;
          label406:
          localObject2.index = i;
          try
          {
            localObject2.buffer = ((ByteBuffer)fgetOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject2.format = ((MediaFormat)fgetOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            localObject2.success = false;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            localObject2.success = false;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            localInvocationTargetException.printStackTrace();
            localObject2.success = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boco
 * JD-Core Version:    0.7.0.1
 */