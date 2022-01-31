package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jjl;

@TargetApi(16)
public class NativeCodec
  implements IMediaCodecCallback
{
  static jjl jdField_a_of_type_Jjl;
  static jjl jdField_b_of_type_Jjl;
  public static boolean b;
  public static String c;
  static jjl jdField_c_of_type_Jjl;
  public static String d;
  static jjl jdField_d_of_type_Jjl;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j = "csd-0";
  public static String k = "slice-height";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  MediaFormat jdField_a_of_type_AndroidMediaMediaFormat = null;
  AndroidCodec jdField_a_of_type_ComTencentAvMediacodecAndroidCodec;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  Map jdField_a_of_type_JavaUtilMap = null;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  Map jdField_b_of_type_JavaUtilMap = null;
  int jdField_c_of_type_Int = 320;
  Map jdField_c_of_type_JavaUtilMap = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 240;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  int f;
  int g;
  int h;
  int i;
  private int mNativeContext;
  
  static
  {
    jdField_c_of_type_JavaLangString = "crop-left";
    jdField_d_of_type_JavaLangString = "crop-top";
    jdField_e_of_type_JavaLangString = "crop-right";
    jdField_f_of_type_JavaLangString = "crop-bottom";
    jdField_g_of_type_JavaLangString = "stride";
    jdField_h_of_type_JavaLangString = "csd-0";
    jdField_i_of_type_JavaLangString = "csd-1";
  }
  
  public NativeCodec()
  {
    this.jdField_f_of_type_Int = 20;
    this.jdField_g_of_type_Int = 40000;
    this.jdField_i_of_type_Int = 0;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, Map paramMap, boolean paramBoolean)
  {
    this.jdField_f_of_type_Int = 20;
    this.jdField_g_of_type_Int = 40000;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = ((Integer)paramMap.get("width")).intValue();
    this.jdField_d_of_type_Int = ((Integer)paramMap.get("height")).intValue();
    if (this.jdField_a_of_type_Boolean)
    {
      try
      {
        int m = this.jdField_c_of_type_Int;
        int n = this.jdField_d_of_type_Int;
        this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat(paramString, m, n);
        if (paramString.contains(AndroidCodec.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", m * n);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 21);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", 25);
          ByteBuffer localByteBuffer1 = (ByteBuffer)paramMap.get(jdField_h_of_type_JavaLangString);
          ByteBuffer localByteBuffer2 = (ByteBuffer)paramMap.get(jdField_i_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setByteBuffer(jdField_h_of_type_JavaLangString, localByteBuffer1);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setByteBuffer(jdField_i_of_type_JavaLangString, localByteBuffer2);
        }
        if (paramString.contains(AndroidCodec.jdField_b_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", m * n);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 21);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", 25);
          paramString = (ByteBuffer)paramMap.get(j);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setByteBuffer(j, paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "<init>, width =" + m + ",height =" + n);
        }
        c();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label453:
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
        }
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        this.jdField_b_of_type_JavaUtilMap = new HashMap();
        this.jdField_c_of_type_JavaUtilMap = new HashMap();
        if (!jdField_b_of_type_Boolean) {
          break label557;
        }
        paramString = "Async ";
        this.jdField_b_of_type_JavaLangString = paramString;
        paramMap = new StringBuilder().append(this.jdField_b_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Boolean) {
          break label563;
        }
      }
    }
    label557:
    label563:
    for (paramString = "DEC ";; paramString = "ENC ")
    {
      for (;;)
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        return;
        try
        {
          this.jdField_h_of_type_Int = ((Integer)paramMap.get("bitrate")).intValue();
          this.jdField_f_of_type_Int = ((Integer)paramMap.get("frame-rate")).intValue();
          a();
        }
        catch (Exception paramString)
        {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
        }
      }
      break;
      paramString = " Sync ";
      break label453;
    }
  }
  
  private static void a(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, jjl paramjjl)
  {
    switch (paramCodecProfileLevel.level)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                  } while ((paramjjl.jdField_a_of_type_Int >= 176) && (paramjjl.jdField_b_of_type_Int >= 144));
                                  paramjjl.jdField_a_of_type_Int = 176;
                                  paramjjl.jdField_b_of_type_Int = 144;
                                  return;
                                } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                                paramjjl.jdField_a_of_type_Int = 352;
                                paramjjl.jdField_b_of_type_Int = 288;
                                return;
                              } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                              paramjjl.jdField_a_of_type_Int = 352;
                              paramjjl.jdField_b_of_type_Int = 288;
                              return;
                            } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                            paramjjl.jdField_a_of_type_Int = 352;
                            paramjjl.jdField_b_of_type_Int = 288;
                            return;
                          } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                          paramjjl.jdField_a_of_type_Int = 352;
                          paramjjl.jdField_b_of_type_Int = 288;
                          return;
                        } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                        paramjjl.jdField_a_of_type_Int = 352;
                        paramjjl.jdField_b_of_type_Int = 288;
                        return;
                      } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 576));
                      paramjjl.jdField_a_of_type_Int = 352;
                      paramjjl.jdField_b_of_type_Int = 576;
                      return;
                    } while ((paramjjl.jdField_a_of_type_Int >= 720) && (paramjjl.jdField_b_of_type_Int >= 576));
                    paramjjl.jdField_a_of_type_Int = 720;
                    paramjjl.jdField_b_of_type_Int = 576;
                    return;
                  } while ((paramjjl.jdField_a_of_type_Int >= 720) && (paramjjl.jdField_b_of_type_Int >= 576));
                  paramjjl.jdField_a_of_type_Int = 720;
                  paramjjl.jdField_b_of_type_Int = 576;
                  return;
                } while ((paramjjl.jdField_a_of_type_Int >= 1280) && (paramjjl.jdField_b_of_type_Int >= 720));
                paramjjl.jdField_a_of_type_Int = 1280;
                paramjjl.jdField_b_of_type_Int = 720;
                return;
              } while ((paramjjl.jdField_a_of_type_Int >= 1280) && (paramjjl.jdField_b_of_type_Int >= 1024));
              paramjjl.jdField_a_of_type_Int = 1280;
              paramjjl.jdField_b_of_type_Int = 1024;
              return;
            } while ((paramjjl.jdField_a_of_type_Int >= 2048) && (paramjjl.jdField_b_of_type_Int >= 1024));
            paramjjl.jdField_a_of_type_Int = 2048;
            paramjjl.jdField_b_of_type_Int = 1024;
            return;
          } while ((paramjjl.jdField_a_of_type_Int >= 2048) && (paramjjl.jdField_b_of_type_Int >= 1024));
          paramjjl.jdField_a_of_type_Int = 2048;
          paramjjl.jdField_b_of_type_Int = 1024;
          return;
        } while ((paramjjl.jdField_a_of_type_Int >= 2048) && (paramjjl.jdField_b_of_type_Int >= 1088));
        paramjjl.jdField_a_of_type_Int = 2048;
        paramjjl.jdField_b_of_type_Int = 1088;
        return;
      } while ((paramjjl.jdField_a_of_type_Int >= 3680) && (paramjjl.jdField_b_of_type_Int >= 1536));
      paramjjl.jdField_a_of_type_Int = 3680;
      paramjjl.jdField_b_of_type_Int = 1536;
      return;
    } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 2304));
    paramjjl.jdField_a_of_type_Int = 4096;
    paramjjl.jdField_b_of_type_Int = 2304;
  }
  
  private boolean a(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i4 = paramMediaFormat.getInteger("width");
    int i5 = paramMediaFormat.getInteger("height");
    int i2 = paramMediaFormat.getInteger(jdField_c_of_type_JavaLangString);
    int i7 = paramMediaFormat.getInteger(jdField_e_of_type_JavaLangString);
    int i8 = paramMediaFormat.getInteger(jdField_d_of_type_JavaLangString);
    int i6 = paramMediaFormat.getInteger(jdField_f_of_type_JavaLangString);
    int i1 = paramMediaFormat.getInteger(jdField_g_of_type_JavaLangString);
    int n = paramMediaFormat.getInteger(k);
    int i9 = paramMediaFormat.getInteger("color-format");
    QLog.d("AndroidCodec", 2, "setFrame, width: " + i4);
    QLog.d("AndroidCodec", 2, "setFrame, height: " + i5);
    QLog.d("AndroidCodec", 2, "setFrame, crop_left: " + i2);
    QLog.d("AndroidCodec", 2, "setFrame, crop_right: " + i7);
    QLog.d("AndroidCodec", 2, "setFrame, crop_top: " + i8);
    QLog.d("AndroidCodec", 2, "setFrame, crop_bottom: " + i6);
    QLog.d("AndroidCodec", 2, "setFrame, stride: " + i1);
    QLog.d("AndroidCodec", 2, "setFrame, slice_height: " + n);
    QLog.d("AndroidCodec", 2, "setFrame, colorFormat: " + i9);
    int m = n;
    if (n < i5) {
      m = i5;
    }
    n = i1;
    if (i1 < i4) {
      n = i4;
    }
    int i3 = m;
    i1 = i8;
    if (i9 == 2130706688)
    {
      i3 = m - i8 / 2;
      i1 = 0;
      i2 = 0;
    }
    m = n;
    if (n < i4) {
      m = i4;
    }
    if (((2141391876 == i9) || (2130706433 == i9) || (2130706944 == i9)) && (i5 < i3)) {}
    for (n = i3;; n = i5)
    {
      if (i2 + i7 + i1 + i6 == 0)
      {
        i2 = 0;
        i5 -= 1;
        i1 = 0;
        i6 = i4 - 1;
        i4 = n;
        i3 = m;
        n = i6;
        m = i5;
        if ((i3 <= 0) || (i4 <= 0) || (n <= 0) || (m <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "error decoderInfomations.");
          }
          return false;
        }
      }
      else
      {
        i5 = i7 - i2 + 1;
        i4 = i6 - i1 + 1;
        i3 = m;
        if (m < i5) {
          i3 = i5;
        }
        if (n >= i4) {
          break label671;
        }
      }
      label671:
      for (m = i4;; m = n)
      {
        n = i7;
        i4 = m;
        m = i6;
        break;
        QLog.d("AndroidCodec", 2, "setFrame, picWidth: " + i3);
        QLog.d("AndroidCodec", 2, "setFrame, picHeight: " + i4);
        SystemClock.elapsedRealtime();
        paramInt = readOutputDataEx(paramByteBuffer, paramInt, i3, i4, i2, i1, n - i2 + 1, m - i1 + 1, i9);
        SystemClock.elapsedRealtime();
        return paramInt > 0;
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   4: ifnull +82 -> 86
    //   7: aload_0
    //   8: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 102	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 284	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 289 1 0
    //   31: aload_0
    //   32: getfield 104	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_Boolean	Z
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: getfield 106	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: invokeinterface 290 1 0
    //   47: aload_0
    //   48: getfield 108	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   51: invokeinterface 290 1 0
    //   56: aload_0
    //   57: getfield 110	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   60: invokeinterface 290 1 0
    //   65: aload_0
    //   66: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   69: invokevirtual 291	com/tencent/av/mediacodec/AndroidCodec:c	()V
    //   72: aload_0
    //   73: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   76: invokevirtual 293	com/tencent/av/mediacodec/AndroidCodec:d	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 125	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Boolean	Z
    //   90: ifeq +63 -> 153
    //   93: aload_0
    //   94: invokespecial 204	com/tencent/av/mediacodec/NativeCodec:c	()V
    //   97: aload_0
    //   98: lconst_0
    //   99: putfield 73	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Long	J
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 75	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   107: aload_0
    //   108: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   111: invokevirtual 295	com/tencent/av/mediacodec/AndroidCodec:a	()Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 102	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: iconst_0
    //   120: invokevirtual 284	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   123: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +12 -> 138
    //   129: ldc 181
    //   131: iconst_2
    //   132: ldc_w 297
    //   135: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: astore_2
    //   140: aload_1
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    //   144: astore_1
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   150: goto -64 -> 86
    //   153: aload_0
    //   154: invokevirtual 221	com/tencent/av/mediacodec/NativeCodec:a	()V
    //   157: goto -60 -> 97
    //   160: astore_1
    //   161: goto -38 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	NativeCodec
    //   144	1	1	localException1	Exception
    //   160	1	1	localException2	Exception
    //   139	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	65	139	finally
    //   65	86	139	finally
    //   140	142	139	finally
    //   7	14	144	java/lang/Exception
    //   142	144	144	java/lang/Exception
    //   86	97	160	java/lang/Exception
    //   97	123	160	java/lang/Exception
    //   153	157	160	java/lang/Exception
  }
  
  private static void b(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, jjl paramjjl)
  {
    if (paramCodecProfileLevel.level == 1) {
      if ((paramjjl.jdField_a_of_type_Int < 192) || (paramjjl.jdField_b_of_type_Int < 144))
      {
        paramjjl.jdField_a_of_type_Int = 192;
        paramjjl.jdField_b_of_type_Int = 144;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            if (paramCodecProfileLevel.level != 4) {
                              break;
                            }
                          } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 288));
                          paramjjl.jdField_a_of_type_Int = 352;
                          paramjjl.jdField_b_of_type_Int = 288;
                          return;
                          if (paramCodecProfileLevel.level != 16) {
                            break;
                          }
                        } while ((paramjjl.jdField_a_of_type_Int >= 352) && (paramjjl.jdField_b_of_type_Int >= 576));
                        paramjjl.jdField_a_of_type_Int = 352;
                        paramjjl.jdField_b_of_type_Int = 576;
                        return;
                        if (paramCodecProfileLevel.level != 64) {
                          break;
                        }
                      } while ((paramjjl.jdField_a_of_type_Int >= 720) && (paramjjl.jdField_b_of_type_Int >= 576));
                      paramjjl.jdField_a_of_type_Int = 720;
                      paramjjl.jdField_b_of_type_Int = 576;
                      return;
                      if (paramCodecProfileLevel.level != 256) {
                        break;
                      }
                    } while ((paramjjl.jdField_a_of_type_Int >= 1280) && (paramjjl.jdField_b_of_type_Int >= 720));
                    paramjjl.jdField_a_of_type_Int = 1280;
                    paramjjl.jdField_b_of_type_Int = 720;
                    return;
                    if (paramCodecProfileLevel.level != 1024) {
                      break;
                    }
                  } while ((paramjjl.jdField_a_of_type_Int >= 1920) && (paramjjl.jdField_b_of_type_Int >= 1080));
                  paramjjl.jdField_a_of_type_Int = 1920;
                  paramjjl.jdField_b_of_type_Int = 1080;
                  return;
                  if (paramCodecProfileLevel.level != 4096) {
                    break;
                  }
                } while ((paramjjl.jdField_a_of_type_Int >= 1920) && (paramjjl.jdField_b_of_type_Int >= 1080));
                paramjjl.jdField_a_of_type_Int = 1920;
                paramjjl.jdField_b_of_type_Int = 1080;
                return;
                if (paramCodecProfileLevel.level != 16384) {
                  break;
                }
              } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 2048));
              paramjjl.jdField_a_of_type_Int = 4096;
              paramjjl.jdField_b_of_type_Int = 2048;
              return;
              if (paramCodecProfileLevel.level != 65536) {
                break;
              }
            } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 2048));
            paramjjl.jdField_a_of_type_Int = 4096;
            paramjjl.jdField_b_of_type_Int = 2048;
            return;
            if (paramCodecProfileLevel.level != 262144) {
              break;
            }
          } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 2048));
          paramjjl.jdField_a_of_type_Int = 4096;
          paramjjl.jdField_b_of_type_Int = 2048;
          return;
          if (paramCodecProfileLevel.level != 1048576) {
            break;
          }
        } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 4096));
        paramjjl.jdField_a_of_type_Int = 4096;
        paramjjl.jdField_b_of_type_Int = 4096;
        return;
        if (paramCodecProfileLevel.level != 4194304) {
          break;
        }
      } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 4096));
      paramjjl.jdField_a_of_type_Int = 4096;
      paramjjl.jdField_b_of_type_Int = 4096;
      return;
      if (paramCodecProfileLevel.level != 16777216) {
        break;
      }
    } while ((paramjjl.jdField_a_of_type_Int >= 4096) && (paramjjl.jdField_b_of_type_Int >= 4096));
    paramjjl.jdField_a_of_type_Int = 4096;
    paramjjl.jdField_b_of_type_Int = 4096;
    return;
    QLog.e("AndroidCodec", 2, "setHevcLevel level.level = " + paramCodecProfileLevel.level);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
    List localList;
    int m;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localList = AndroidCodec.a(this.jdField_a_of_type_JavaLangString);
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      m = 0;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (m >= localList.size()) {
          break label119;
        }
        localObject = AndroidCodec.a((MediaCodecInfo)localList.get(m), this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        m += 1;
      }
      if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
        break label144;
      }
      localObject = (MediaCodecInfo)localList.get(m);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 19);
    }
    for (;;)
    {
      label119:
      if (!this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(this.jdField_a_of_type_AndroidMediaMediaFormat, ((MediaCodecInfo)localObject).getName(), this)) {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      }
      return;
      label144:
      if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
        break;
      }
      localObject = (MediaCodecInfo)localList.get(m);
      this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 21);
    }
  }
  
  private static void d()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_a_of_type_JavaLangString).get(0), AndroidCodec.jdField_a_of_type_JavaLangString);
    jdField_d_of_type_Jjl = new jjl();
    if (localCodecCapabilities != null)
    {
      int m = 0;
      if (m < localCodecCapabilities.profileLevels.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AndroidCodec", 2, "initAVCEncoderCaps k: " + m + ", caps.profileLevels[k].profile: " + localCodecCapabilities.profileLevels[m].profile);
        }
        switch (localCodecCapabilities.profileLevels[m].profile)
        {
        }
        for (;;)
        {
          m += 1;
          break;
          jdField_d_of_type_Jjl.jdField_c_of_type_Int = 3;
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localCodecCapabilities.profileLevels[m];
          localCodecProfileLevel.level = 512;
          a(localCodecProfileLevel, jdField_d_of_type_Jjl);
        }
      }
    }
  }
  
  private static void e()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_b_of_type_JavaLangString).get(0), AndroidCodec.jdField_b_of_type_JavaLangString);
    jdField_c_of_type_Jjl = new jjl();
    if (localCodecCapabilities == null) {}
    int m;
    do
    {
      return;
      m = 0;
    } while (m >= localCodecCapabilities.profileLevels.length);
    switch (localCodecCapabilities.profileLevels[m].profile)
    {
    }
    for (;;)
    {
      m += 1;
      break;
      jdField_c_of_type_Jjl.jdField_c_of_type_Int = 1;
      MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = localCodecCapabilities.profileLevels[m];
      localCodecProfileLevel.level = 16384;
      b(localCodecProfileLevel, jdField_c_of_type_Jjl);
    }
  }
  
  private static void f()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_a_of_type_JavaLangString).get(0), AndroidCodec.jdField_a_of_type_JavaLangString);
    jdField_a_of_type_Jjl = new jjl();
    if ((localCodecCapabilities == null) || (localCodecCapabilities.profileLevels == null)) {}
    int m;
    do
    {
      return;
      m = 0;
    } while (m >= localCodecCapabilities.profileLevels.length);
    switch (localCodecCapabilities.profileLevels[m].profile)
    {
    default: 
      label132:
      switch (localCodecCapabilities.profileLevels[m].level)
      {
      }
      break;
    }
    for (;;)
    {
      m += 1;
      break;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 3) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 3;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 5) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 5;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 5) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 5;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 5) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 5;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 5) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 5;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 5) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 5;
      break label132;
      if (jdField_a_of_type_Jjl.jdField_c_of_type_Int > 4) {
        break label132;
      }
      jdField_a_of_type_Jjl.jdField_c_of_type_Int = 4;
      break label132;
      if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 176) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 144))
      {
        jdField_a_of_type_Jjl.jdField_a_of_type_Int = 176;
        jdField_a_of_type_Jjl.jdField_b_of_type_Int = 144;
        continue;
        if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 288))
        {
          jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
          jdField_a_of_type_Jjl.jdField_b_of_type_Int = 288;
          continue;
          if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 288))
          {
            jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
            jdField_a_of_type_Jjl.jdField_b_of_type_Int = 288;
            continue;
            if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 288))
            {
              jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
              jdField_a_of_type_Jjl.jdField_b_of_type_Int = 288;
              continue;
              if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 288))
              {
                jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
                jdField_a_of_type_Jjl.jdField_b_of_type_Int = 288;
                continue;
                if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 288))
                {
                  jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
                  jdField_a_of_type_Jjl.jdField_b_of_type_Int = 288;
                  continue;
                  if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 576))
                  {
                    jdField_a_of_type_Jjl.jdField_a_of_type_Int = 352;
                    jdField_a_of_type_Jjl.jdField_b_of_type_Int = 576;
                    continue;
                    if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 720) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 576))
                    {
                      jdField_a_of_type_Jjl.jdField_a_of_type_Int = 720;
                      jdField_a_of_type_Jjl.jdField_b_of_type_Int = 576;
                      continue;
                      if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 720) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 576))
                      {
                        jdField_a_of_type_Jjl.jdField_a_of_type_Int = 720;
                        jdField_a_of_type_Jjl.jdField_b_of_type_Int = 576;
                        continue;
                        if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 1280) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 720))
                        {
                          jdField_a_of_type_Jjl.jdField_a_of_type_Int = 1280;
                          jdField_a_of_type_Jjl.jdField_b_of_type_Int = 720;
                          continue;
                          if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 1280) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 1024))
                          {
                            jdField_a_of_type_Jjl.jdField_a_of_type_Int = 1280;
                            jdField_a_of_type_Jjl.jdField_b_of_type_Int = 1024;
                            continue;
                            if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 1024))
                            {
                              jdField_a_of_type_Jjl.jdField_a_of_type_Int = 2048;
                              jdField_a_of_type_Jjl.jdField_b_of_type_Int = 1024;
                              continue;
                              if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 1024))
                              {
                                jdField_a_of_type_Jjl.jdField_a_of_type_Int = 2048;
                                jdField_a_of_type_Jjl.jdField_b_of_type_Int = 1024;
                                continue;
                                if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 1088))
                                {
                                  jdField_a_of_type_Jjl.jdField_a_of_type_Int = 2048;
                                  jdField_a_of_type_Jjl.jdField_b_of_type_Int = 1088;
                                  continue;
                                  if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 3680) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 1536))
                                  {
                                    jdField_a_of_type_Jjl.jdField_a_of_type_Int = 3680;
                                    jdField_a_of_type_Jjl.jdField_b_of_type_Int = 1536;
                                    continue;
                                    if ((jdField_a_of_type_Jjl.jdField_a_of_type_Int < 4096) || (jdField_a_of_type_Jjl.jdField_b_of_type_Int < 2304))
                                    {
                                      jdField_a_of_type_Jjl.jdField_a_of_type_Int = 4096;
                                      jdField_a_of_type_Jjl.jdField_b_of_type_Int = 2304;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void g()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_b_of_type_JavaLangString).get(0), AndroidCodec.jdField_b_of_type_JavaLangString);
    jdField_b_of_type_Jjl = new jjl();
    if (localCodecCapabilities == null) {
      return;
    }
    int m = 0;
    label39:
    if (m < localCodecCapabilities.profileLevels.length)
    {
      if (localCodecCapabilities.profileLevels[m].profile > 1) {
        break label140;
      }
      if (jdField_b_of_type_Jjl.jdField_c_of_type_Int <= 1) {
        jdField_b_of_type_Jjl.jdField_c_of_type_Int = 1;
      }
      label78:
      if (localCodecCapabilities.profileLevels[m].level > 1) {
        break label206;
      }
      if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 288))
      {
        jdField_b_of_type_Jjl.jdField_a_of_type_Int = 352;
        jdField_b_of_type_Jjl.jdField_b_of_type_Int = 288;
      }
    }
    for (;;)
    {
      m += 1;
      break label39;
      break;
      label140:
      if (localCodecCapabilities.profileLevels[m].profile == 2)
      {
        if (jdField_b_of_type_Jjl.jdField_c_of_type_Int > 2) {
          break label78;
        }
        jdField_b_of_type_Jjl.jdField_c_of_type_Int = 2;
        break label78;
      }
      if ((localCodecCapabilities.profileLevels[m].profile < 2) || (jdField_b_of_type_Jjl.jdField_c_of_type_Int > 2)) {
        break label78;
      }
      jdField_b_of_type_Jjl.jdField_c_of_type_Int = 2;
      break label78;
      label206:
      if (localCodecCapabilities.profileLevels[m].level == 4)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 288))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 352;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 16)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 352) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 576))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 352;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 64)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 720) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 576))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 720;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 256)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 1280) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 720))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 1280;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 720;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 1024)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 2048) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 1024))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 2048;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 4096)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 2048) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 1024))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 2048;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 16384)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 4096) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 2304))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 4096;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 2304;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 65536)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 4096) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 2304))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 4096;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 2304;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 262144)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 4096) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 2304))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 4096;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 2304;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 1048576)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 8192) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 4320))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 8192;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 4320;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level == 4194304)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 8192) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 4320))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 8192;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 4320;
        }
      }
      else if (localCodecCapabilities.profileLevels[m].level > 16777216)
      {
        if ((jdField_b_of_type_Jjl.jdField_a_of_type_Int < 8192) || (jdField_b_of_type_Jjl.jdField_b_of_type_Int < 4320))
        {
          jdField_b_of_type_Jjl.jdField_a_of_type_Int = 8192;
          jdField_b_of_type_Jjl.jdField_b_of_type_Int = 4320;
        }
      }
      else {
        QLog.e("AndroidCodec", 2, "initHevcDecoderCaps caps.profileLevels[" + m + "].level = " + localCodecCapabilities.profileLevels[m].level);
      }
    }
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCodec", 2, "getIntValues mime: " + paramString1 + ", key: " + paramString2);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    label332:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return 0;
                if (!"supportAsync".equalsIgnoreCase(paramString2)) {
                  break;
                }
                jdField_b_of_type_Boolean = DeviceCheck.g();
              } while (!jdField_b_of_type_Boolean);
              return 1;
              if (!paramString1.equalsIgnoreCase(AndroidCodec.jdField_a_of_type_JavaLangString)) {
                break label332;
              }
              if (!paramBoolean) {
                break;
              }
              if (jdField_a_of_type_Jjl == null) {
                f();
              }
              if (paramString2.equalsIgnoreCase("width")) {
                return jdField_a_of_type_Jjl.jdField_a_of_type_Int;
              }
              if (paramString2.equalsIgnoreCase("height")) {
                return jdField_a_of_type_Jjl.jdField_b_of_type_Int;
              }
            } while (!paramString2.equalsIgnoreCase("profile"));
            return jdField_a_of_type_Jjl.jdField_c_of_type_Int;
            if (jdField_d_of_type_Jjl == null)
            {
              d();
              if (QLog.isColorLevel()) {
                QLog.d("AndroidCodec", 2, "initAVCEncoderCaps start ");
              }
            }
            if (paramString2.equalsIgnoreCase("width"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("AndroidCodec", 2, "gAVCEncoderCaps width: " + jdField_d_of_type_Jjl.jdField_a_of_type_Int);
              }
              return jdField_d_of_type_Jjl.jdField_a_of_type_Int;
            }
            if (paramString2.equalsIgnoreCase("height"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("AndroidCodec", 2, "getIntValues height: " + jdField_d_of_type_Jjl.jdField_b_of_type_Int);
              }
              return jdField_d_of_type_Jjl.jdField_b_of_type_Int;
            }
          } while (!paramString2.equalsIgnoreCase("profile"));
          if (QLog.isColorLevel()) {
            QLog.d("AndroidCodec", 2, "getIntValues profile: " + jdField_d_of_type_Jjl.jdField_c_of_type_Int);
          }
          return jdField_d_of_type_Jjl.jdField_c_of_type_Int;
        } while (!paramString1.equalsIgnoreCase(AndroidCodec.jdField_b_of_type_JavaLangString));
        if (!paramBoolean) {
          break;
        }
        if (jdField_b_of_type_Jjl == null) {
          g();
        }
        if (paramString2.equalsIgnoreCase("width")) {
          return jdField_b_of_type_Jjl.jdField_a_of_type_Int;
        }
        if (paramString2.equalsIgnoreCase("height")) {
          return jdField_b_of_type_Jjl.jdField_b_of_type_Int;
        }
      } while (!paramString2.equalsIgnoreCase("profile"));
      return jdField_b_of_type_Jjl.jdField_c_of_type_Int;
      if (jdField_c_of_type_Jjl == null) {
        e();
      }
      if (paramString2.equalsIgnoreCase("width")) {
        return jdField_c_of_type_Jjl.jdField_a_of_type_Int;
      }
      if (paramString2.equalsIgnoreCase("height")) {
        return jdField_c_of_type_Jjl.jdField_b_of_type_Int;
      }
    } while (!paramString2.equalsIgnoreCase("profile"));
    return jdField_c_of_type_Jjl.jdField_c_of_type_Int;
  }
  
  public static native int getVersion();
  
  private static boolean onAttach(String paramString, int paramInt, boolean paramBoolean, Map paramMap)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return false;
      paramString = new NativeCodec(paramString, paramMap, paramBoolean);
    } while (paramString.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null);
    paramString.mNativeContext = paramInt;
    paramString.attachCodec(paramString);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_a_of_type_Int = 0;
    paramString.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.e("AndroidCodec", 2, "onAttach");
    }
    return paramString.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " frameIndex:" + paramInt);
      }
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    }
    return true;
  }
  
  private static void onDetach(Object arg0)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    NativeCodec localNativeCodec;
    do
    {
      return;
      localNativeCodec = (NativeCodec)???;
    } while (localNativeCodec == null);
    localNativeCodec.detachCodec();
    localNativeCodec.jdField_a_of_type_Int = 0;
    localNativeCodec.jdField_a_of_type_Long = 0L;
    localNativeCodec.jdField_a_of_type_AndroidMediaMediaFormat = null;
    localNativeCodec.jdField_b_of_type_Long = 0L;
    synchronized (localNativeCodec.jdField_a_of_type_JavaUtilList)
    {
      localNativeCodec.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      localNativeCodec.jdField_a_of_type_JavaUtilList.clear();
      if (localNativeCodec.jdField_c_of_type_Boolean)
      {
        localNativeCodec.jdField_a_of_type_JavaUtilMap.clear();
        localNativeCodec.jdField_b_of_type_JavaUtilMap.clear();
        localNativeCodec.jdField_c_of_type_JavaUtilMap.clear();
      }
      AndroidCodec localAndroidCodec = localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec;
      if (localAndroidCodec == null) {}
    }
    try
    {
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.c();
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.d();
      label123:
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "onDetach");
      }
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      break label123;
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Int >= 10) && (paramInt1 == 0))
    {
      b();
      if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {
        return false;
      }
    }
    Object localObject4;
    label272:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        paramInt1 = 0;
        localObject4 = localObject1;
        int n;
        Object localObject5;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "inputbuffer not available");
          }
          n = paramInt1;
          localObject5 = localObject1;
        }
        try
        {
          Thread.sleep(50L);
          n = paramInt1;
          localObject5 = localObject1;
          localObject4 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
          int m = paramInt1 + 1;
          if (localObject4 != null)
          {
            if (!this.jdField_a_of_type_Boolean) {
              break label272;
            }
            paramInt1 = writeInputData(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, false);
            if (paramInt1 >= 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("AndroidCodec", 2, "writeInputData, SampleSize < 0");
            }
            return false;
          }
          n = m;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            n = m;
            localObject5 = localObject4;
            QLog.e("AndroidCodec", 2, "inputbuffer not available");
          }
          paramInt1 = m;
          localObject1 = localObject4;
          if (m <= 8) {
            continue;
          }
          n = m;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            n = m;
            localObject5 = localObject4;
            QLog.e("AndroidCodec", 2, "inputbuffer not available, try count=" + m);
          }
          return false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          paramInt1 = n;
          Object localObject2 = localObject5;
        }
        continue;
        paramInt1 = writeInputData2(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, this.jdField_e_of_type_Int, false);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "onDoCodec Exception!");
        }
        return false;
      }
    }
    this.jdField_b_of_type_Long += this.jdField_g_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(System.currentTimeMillis()));
      this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(paramInt2));
    }
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int, paramInt1, this.jdField_b_of_type_Long, 0);
    Object localObject3 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
    if (localObject3 != null)
    {
      if (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "dequeueOutputBuffer, try again later,count =" + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_Int >= 16) {
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        if (!((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Boolean)
        {
          if (!QLog.isColorLevel()) {
            break label878;
          }
          QLog.e("AndroidCodec", 2, "onDoCodec err!");
          break label878;
        }
        if ((((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaFormat == null) || (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer == null))
        {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
          return false;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          a(true, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaFormat);
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
          break label880;
        }
        if (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags == 1) {
          QLog.e("AndroidCodec", 2, "onDoCodec err flags!");
        }
        if (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags == 2)
        {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
          readOutputStream(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags);
          localObject4 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
          if (localObject4 != null)
          {
            if (((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int == -1)
            {
              this.jdField_b_of_type_Int += 1;
              if (QLog.isColorLevel()) {
                QLog.e("AndroidCodec", 2, "re-dequeue dequeueOutputBuffer, try again later,count =" + this.jdField_b_of_type_Int);
              }
              if (this.jdField_b_of_type_Int < 16) {
                break label882;
              }
              return false;
            }
            this.jdField_b_of_type_Int = 0;
            if (!((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Boolean)
            {
              if (!QLog.isColorLevel()) {
                break label884;
              }
              QLog.e("AndroidCodec", 2, "re-dequeue onDoCodec err!");
              break label884;
            }
            if ((((AndroidCodec.BufferData)localObject4).jdField_a_of_type_AndroidMediaMediaFormat == null) || (((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer == null))
            {
              this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int);
              return false;
            }
          }
          localObject3 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("AndroidCodec", 2, "re-dequeue success");
            localObject3 = localObject4;
          }
        }
        for (;;)
        {
          a(true, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          readOutputStream(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags);
          break;
        }
      }
      return true;
      label878:
      return false;
    }
    label880:
    return true;
    label882:
    return true;
    label884:
    return false;
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "NOT in async mode.");
      }
      return -1;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "hardware coders exit, return.");
          }
          return 2;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "InputData pendingInputBuffers exist, size:" + this.jdField_a_of_type_JavaUtilList.size());
        }
        AndroidCodec.InputBufferData localInputBufferData = (AndroidCodec.InputBufferData)this.jdField_a_of_type_JavaUtilList.get(0);
        if (localInputBufferData == null) {
          return 2;
        }
        if (localInputBufferData.jdField_a_of_type_JavaNioByteBuffer == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "inputbuffer null, return");
          }
          return -1;
        }
        if (localInputBufferData.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramInt1 = writeInputData(localInputBufferData.jdField_a_of_type_JavaNioByteBuffer, false);
          if (paramInt1 <= 0) {
            break label361;
          }
          this.jdField_b_of_type_Long += this.jdField_g_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(0);
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(System.currentTimeMillis()));
            this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(paramInt2));
          }
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localInputBufferData.jdField_a_of_type_Int, paramInt1, this.jdField_b_of_type_Long, 0);
          return 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "call writeInputData2 in onDoCodec");
      }
      paramInt1 = writeInputData2(localObject.jdField_a_of_type_JavaNioByteBuffer, this.jdField_e_of_type_Int, false);
    }
    for (;;)
    {
      return 0;
      label361:
      do
      {
        return -1;
        return 2;
        if (paramInt1 == 0) {
          break;
        }
      } while (paramInt1 != -1);
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString == null);
        if (!paramString.equalsIgnoreCase("frame-rate")) {
          break;
        }
      } while (paramInt <= 0);
      this.jdField_f_of_type_Int = paramInt;
      this.jdField_g_of_type_Int = (1000000 / this.jdField_f_of_type_Int);
      b();
      QLog.e("AndroidCodec", 2, "HWENC setParameters mFrameRate =" + this.jdField_f_of_type_Int);
    } while (Build.VERSION.SDK_INT < 19);
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, paramInt);
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
  }
  
  public static native void set_device_infos(String paramString);
  
  void a()
  {
    int i2 = 0;
    int m;
    Object localObject;
    label85:
    int n;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int i1;
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {
      try
      {
        List localList = AndroidCodec.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_Int = 21;
        m = 0;
        if (m >= localList.size()) {
          break label549;
        }
        localObject = AndroidCodec.a((MediaCodecInfo)localList.get(m), this.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          break label554;
        }
        if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {}
        for (this.jdField_e_of_type_Int = 21;; this.jdField_e_of_type_Int = 19)
        {
          localObject = MediaFormat.createVideoFormat(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
          ((MediaFormat)localObject).setInteger("color-format", this.jdField_e_of_type_Int);
          ((MediaFormat)localObject).setInteger("frame-rate", this.jdField_f_of_type_Int);
          ((MediaFormat)localObject).setInteger("bitrate", this.jdField_h_of_type_Int);
          n = 30;
          if (this.jdField_f_of_type_Int * 30 > 255) {
            n = 255 / this.jdField_f_of_type_Int;
          }
          QLog.e("AndroidCodec", 2, "KEY_I_FRAME_INTERVAL =" + n + ", mFrameRate = " + this.jdField_f_of_type_Int);
          ((MediaFormat)localObject).setInteger("i-frame-interval", n);
          localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)localList.get(m), this.jdField_a_of_type_JavaLangString);
          if (localCodecCapabilities == null) {
            break;
          }
          if (!this.jdField_a_of_type_JavaLangString.contains(AndroidCodec.jdField_a_of_type_JavaLangString)) {
            break label370;
          }
          n = 0;
          if (n >= localCodecCapabilities.profileLevels.length) {
            break label370;
          }
          switch (localCodecCapabilities.profileLevels[n].profile)
          {
          case 1: 
            if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
              break label554;
            }
          }
        }
        i1 = 512;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (512 < localCodecCapabilities.profileLevels[n].level) {
          i1 = localCodecCapabilities.profileLevels[n].level;
        }
        ((MediaFormat)localObject).setInteger("level", i1);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      }
    } else {
      return;
    }
    label370:
    if (this.jdField_a_of_type_JavaLangString.contains(AndroidCodec.jdField_b_of_type_JavaLangString)) {
      n = i2;
    }
    for (;;)
    {
      if (n < localCodecCapabilities.profileLevels.length) {}
      switch (localCodecCapabilities.profileLevels[n].profile)
      {
      case 1: 
        i1 = 16384;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (16384 < localCodecCapabilities.profileLevels[n].level) {
          i1 = localCodecCapabilities.profileLevels[n].level;
        }
        ((MediaFormat)localObject).setInteger("level", i1);
        break label568;
        this.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)localObject);
        if (this.jdField_f_of_type_Int > 0) {}
        for (this.jdField_g_of_type_Int = (1000000 / this.jdField_f_of_type_Int);; this.jdField_g_of_type_Int = 40000)
        {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(this.jdField_a_of_type_AndroidMediaMediaFormat, ((MediaCodecInfo)localException.get(m)).getName(), this);
          return;
        }
        m = 0;
        break label85;
        m += 1;
        break;
        n += 1;
        break;
      default: 
        label549:
        label554:
        label568:
        n += 1;
      }
    }
  }
  
  void a(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      Object localObject = (Long)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " small, " + paramBufferInfo.presentationTimeUs + "      takes:" + (System.currentTimeMillis() - ((Long)localObject).longValue()));
        }
        this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        Long localLong = (Long)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localLong != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " big  , " + paramBufferInfo.presentationTimeUs + "      takes:" + (System.currentTimeMillis() - localLong.longValue()));
          }
          this.jdField_b_of_type_JavaUtilMap.remove(localObject);
        }
        this.jdField_c_of_type_JavaUtilMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public native boolean attachCodec(Object paramObject);
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onError");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AndroidCodec", 2, "onError", paramException);
  }
  
  /* Error */
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   10: iload_2
    //   11: invokevirtual 610	com/tencent/av/mediacodec/AndroidCodec:a	(I)Ljava/nio/ByteBuffer;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +36 -> 54
    //   21: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +29 -> 53
    //   27: ldc 181
    //   29: iconst_2
    //   30: new 183	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 612
    //   40: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: return
    //   54: iload 5
    //   56: istore_3
    //   57: aload_0
    //   58: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   61: astore_1
    //   62: iload 5
    //   64: istore_3
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 102	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   71: invokevirtual 539	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   74: ifeq +74 -> 148
    //   77: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +12 -> 92
    //   83: ldc 181
    //   85: iconst_2
    //   86: ldc_w 614
    //   89: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: iconst_0
    //   106: invokeinterface 311 2 0
    //   111: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   114: iconst_0
    //   115: putfield 549	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   118: aload_1
    //   119: monitorexit
    //   120: return
    //   121: astore 6
    //   123: aload_1
    //   124: monitorexit
    //   125: aload 6
    //   127: athrow
    //   128: astore 6
    //   130: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -15 -> 118
    //   136: ldc 181
    //   138: iconst_2
    //   139: ldc_w 616
    //   142: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto -27 -> 118
    //   148: aload_0
    //   149: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   152: new 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   155: dup
    //   156: aload 6
    //   158: iload_2
    //   159: invokespecial 619	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   162: invokeinterface 622 2 0
    //   167: pop
    //   168: aload_0
    //   169: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   172: iconst_0
    //   173: invokeinterface 311 2 0
    //   178: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   181: iconst_1
    //   182: putfield 549	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   185: aload_1
    //   186: monitorexit
    //   187: iload 5
    //   189: istore_3
    //   190: aload_0
    //   191: getfield 125	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Boolean	Z
    //   194: ifeq +254 -> 448
    //   197: iload 5
    //   199: istore_3
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   205: iconst_0
    //   206: invokeinterface 311 2 0
    //   211: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   214: getfield 546	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   217: iconst_1
    //   218: invokevirtual 470	com/tencent/av/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   221: istore_2
    //   222: iload_2
    //   223: ifle +120 -> 343
    //   226: iload_2
    //   227: istore_3
    //   228: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +31 -> 262
    //   234: iload_2
    //   235: istore_3
    //   236: ldc 181
    //   238: iconst_2
    //   239: new 183	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 624
    //   249: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_2
    //   253: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: iload_2
    //   263: istore_3
    //   264: aload_0
    //   265: aload_0
    //   266: getfield 75	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   269: aload_0
    //   270: getfield 90	com/tencent/av/mediacodec/NativeCodec:jdField_g_of_type_Int	I
    //   273: i2l
    //   274: ladd
    //   275: putfield 75	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   278: iload_2
    //   279: istore_3
    //   280: aload_0
    //   281: getfield 104	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_Boolean	Z
    //   284: ifeq +28 -> 312
    //   287: iload_2
    //   288: istore_3
    //   289: aload_0
    //   290: getfield 106	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   293: aload_0
    //   294: getfield 75	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   297: invokestatic 432	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   300: invokestatic 427	java/lang/System:currentTimeMillis	()J
    //   303: invokestatic 432	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   306: invokeinterface 436 3 0
    //   311: pop
    //   312: iload_2
    //   313: istore_3
    //   314: aload_0
    //   315: getfield 215	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   318: aload_0
    //   319: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   322: iconst_0
    //   323: invokeinterface 311 2 0
    //   328: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   331: getfield 555	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Int	I
    //   334: iload_2
    //   335: aload_0
    //   336: getfield 75	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   339: iconst_0
    //   340: invokevirtual 489	com/tencent/av/mediacodec/AndroidCodec:a	(IIJI)V
    //   343: aload_0
    //   344: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   347: astore_1
    //   348: aload_1
    //   349: monitorenter
    //   350: aload_0
    //   351: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   354: iconst_0
    //   355: invokeinterface 311 2 0
    //   360: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   363: iconst_0
    //   364: putfield 549	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   367: iload_2
    //   368: ifle +14 -> 382
    //   371: aload_0
    //   372: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   375: iconst_0
    //   376: invokeinterface 554 2 0
    //   381: pop
    //   382: aload_1
    //   383: monitorexit
    //   384: return
    //   385: astore 6
    //   387: aload_1
    //   388: monitorexit
    //   389: aload 6
    //   391: athrow
    //   392: astore 6
    //   394: aload_1
    //   395: monitorexit
    //   396: iload 5
    //   398: istore_3
    //   399: aload 6
    //   401: athrow
    //   402: astore 6
    //   404: aload_0
    //   405: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   408: astore_1
    //   409: aload_1
    //   410: monitorenter
    //   411: aload_0
    //   412: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   415: iconst_0
    //   416: invokeinterface 311 2 0
    //   421: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   424: iconst_0
    //   425: putfield 549	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   428: iload_3
    //   429: ifle +14 -> 443
    //   432: aload_0
    //   433: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   436: iconst_0
    //   437: invokeinterface 554 2 0
    //   442: pop
    //   443: aload_1
    //   444: monitorexit
    //   445: aload 6
    //   447: athrow
    //   448: iload 5
    //   450: istore_3
    //   451: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +15 -> 469
    //   457: iload 5
    //   459: istore_3
    //   460: ldc 181
    //   462: iconst_2
    //   463: ldc_w 626
    //   466: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: iload 5
    //   471: istore_3
    //   472: aload_0
    //   473: aload_0
    //   474: getfield 95	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   477: iconst_0
    //   478: invokeinterface 311 2 0
    //   483: checkcast 545	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   486: getfield 546	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   489: aload_0
    //   490: getfield 481	com/tencent/av/mediacodec/NativeCodec:jdField_e_of_type_Int	I
    //   493: iconst_1
    //   494: invokevirtual 485	com/tencent/av/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   497: istore_2
    //   498: goto -276 -> 222
    //   501: astore_1
    //   502: iload 4
    //   504: istore_2
    //   505: iload 5
    //   507: istore_3
    //   508: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq -289 -> 222
    //   514: iload 5
    //   516: istore_3
    //   517: ldc 181
    //   519: iconst_2
    //   520: ldc_w 628
    //   523: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: iload 4
    //   528: istore_2
    //   529: goto -307 -> 222
    //   532: astore_1
    //   533: iload_2
    //   534: istore_3
    //   535: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq -195 -> 343
    //   541: iload_2
    //   542: istore_3
    //   543: ldc 181
    //   545: iconst_2
    //   546: ldc_w 630
    //   549: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: goto -209 -> 343
    //   555: astore 6
    //   557: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq -178 -> 382
    //   563: ldc 181
    //   565: iconst_2
    //   566: ldc_w 616
    //   569: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: goto -190 -> 382
    //   575: astore 7
    //   577: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq -137 -> 443
    //   583: ldc 181
    //   585: iconst_2
    //   586: ldc_w 616
    //   589: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: goto -149 -> 443
    //   595: astore 6
    //   597: aload_1
    //   598: monitorexit
    //   599: aload 6
    //   601: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	NativeCodec
    //   0	602	2	paramInt	int
    //   56	487	3	m	int
    //   4	523	4	n	int
    //   1	514	5	i1	int
    //   14	3	6	localByteBuffer	ByteBuffer
    //   121	5	6	localObject1	Object
    //   128	29	6	localException1	Exception
    //   385	5	6	localObject2	Object
    //   392	8	6	localObject3	Object
    //   402	44	6	localObject4	Object
    //   555	1	6	localException2	Exception
    //   595	5	6	localObject5	Object
    //   575	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   101	118	121	finally
    //   118	120	121	finally
    //   123	125	121	finally
    //   130	145	121	finally
    //   101	118	128	java/lang/Exception
    //   350	367	385	finally
    //   371	382	385	finally
    //   382	384	385	finally
    //   387	389	385	finally
    //   557	572	385	finally
    //   67	92	392	finally
    //   92	94	392	finally
    //   148	187	392	finally
    //   394	396	392	finally
    //   57	62	402	finally
    //   65	67	402	finally
    //   190	197	402	finally
    //   200	222	402	finally
    //   228	234	402	finally
    //   236	262	402	finally
    //   264	278	402	finally
    //   280	287	402	finally
    //   289	312	402	finally
    //   314	343	402	finally
    //   399	402	402	finally
    //   451	457	402	finally
    //   460	469	402	finally
    //   472	498	402	finally
    //   508	514	402	finally
    //   517	526	402	finally
    //   535	541	402	finally
    //   543	552	402	finally
    //   190	197	501	java/lang/Exception
    //   200	222	501	java/lang/Exception
    //   451	457	501	java/lang/Exception
    //   460	469	501	java/lang/Exception
    //   472	498	501	java/lang/Exception
    //   314	343	532	java/lang/Exception
    //   350	367	555	java/lang/Exception
    //   371	382	555	java/lang/Exception
    //   411	428	575	java/lang/Exception
    //   432	443	575	java/lang/Exception
    //   411	428	595	finally
    //   432	443	595	finally
    //   443	445	595	finally
    //   577	592	595	finally
    //   597	599	595	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onOutputBufferAvailable");
      }
    }
    do
    {
      return;
      paramMediaCodec = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.jdField_a_of_type_Boolean)
    {
      MediaFormat localMediaFormat = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
      if (localMediaFormat != null)
      {
        a(false, paramBufferInfo);
        a(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("AndroidCodec", 2, "getOutputFormat null");
        continue;
        if (paramBufferInfo.flags == 1) {}
        a(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onOutputFormatChanged");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AndroidCodec", 2, "onOutputFormatChanged");
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AndroidCodec", 2, "setParams_impl");
    }
    Bundle localBundle;
    if (this.jdField_d_of_type_Boolean)
    {
      localBundle = new Bundle();
      localBundle.putInt(AndroidCodec.jdField_c_of_type_JavaLangString, 1);
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_i_of_type_Int > 0) {
        localBundle.putInt("bitrate", this.jdField_i_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
      this.jdField_i_of_type_Int = 0;
    }
    if (this.jdField_i_of_type_Int > 0)
    {
      localBundle = new Bundle();
      localBundle.putInt("bitrate", this.jdField_i_of_type_Int);
      if (this.jdField_d_of_type_Boolean == true) {
        localBundle.putInt(AndroidCodec.jdField_c_of_type_JavaLangString, 1);
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
      this.jdField_i_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.mediacodec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */