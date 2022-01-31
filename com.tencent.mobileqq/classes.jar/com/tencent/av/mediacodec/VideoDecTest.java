package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class VideoDecTest
  implements IMediaCodecCallback, Runnable
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  AndroidCodec jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
  VideoDecTest.PlayerCallback jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback;
  String jdField_a_of_type_JavaLangString;
  Thread jdField_a_of_type_JavaLangThread;
  Map jdField_a_of_type_JavaUtilMap = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = -1L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  private volatile boolean f;
  
  public VideoDecTest(String paramString, boolean paramBoolean, VideoDecTest.PlayerCallback paramPlayerCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback = paramPlayerCallback;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private static int a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    while (i < j)
    {
      if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "Movie Player");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback != null)) {
      this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback.a(paramInt1, paramString, paramInt2, paramInt3);
    }
  }
  
  public int b()
  {
    if ((a() == 0) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return 0;
    }
    return a();
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    Object localObject2;
    Object localObject3;
    label197:
    label373:
    do
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
        i = a(this.jdField_a_of_type_AndroidMediaMediaExtractor);
        if (i < 0)
        {
          a(-2, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
          return;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        a(-1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
      MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
      localObject2 = localMediaFormat.getString("mime");
      localObject3 = AndroidCodec.a((String)localObject2);
      i = 0;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      while (i < ((List)localObject3).size())
      {
        this.jdField_b_of_type_JavaLangString = ((MediaCodecInfo)((List)localObject3).get(i)).getName();
        localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)((List)localObject3).get(i), (String)localObject2);
        if (localCodecCapabilities == null)
        {
          i += 1;
        }
        else
        {
          if (!ArrayUtils.a(localCodecCapabilities.colorFormats, 19)) {
            break label373;
          }
          this.jdField_c_of_type_Int = 19;
        }
      }
      if (this.jdField_c_of_type_Int == 0)
      {
        this.jdField_b_of_type_JavaLangString = ((MediaCodecInfo)((List)localObject3).get(0)).getName();
        localObject2 = AndroidCodec.a((MediaCodecInfo)((List)localObject3).get(0), (String)localObject2);
        if ((localObject2 != null) && (((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats != null) && (((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length > 0)) {
          this.jdField_c_of_type_Int = localObject2.colorFormats[0];
        }
      }
      localMediaFormat.setInteger("color-format", this.jdField_c_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.w("VideoDecTest", 2, "useAsyncMode:" + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      for (boolean bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localMediaFormat, this.jdField_b_of_type_JavaLangString, this);; bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localMediaFormat, this.jdField_b_of_type_JavaLangString, null))
      {
        if (bool) {
          break label414;
        }
        a(-3, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
        return;
        if (!ArrayUtils.a(localCodecCapabilities.colorFormats, 21)) {
          break;
        }
        this.jdField_c_of_type_Int = 21;
        break label197;
      }
      try
      {
        bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        if (!bool)
        {
          a(-4, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          bool = false;
        }
      }
    } while (this.jdField_c_of_type_Boolean);
    label414:
    int k = 0;
    int m = 0;
    long l2 = 0L;
    int i1 = 0;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    long l1 = l2;
    int i = k;
    int n = i1;
    int j = m;
    if (j == 0) {}
    for (;;)
    {
      try
      {
        if (this.f) {
          break;
        }
        if (i != 0) {
          break label1306;
        }
        localBufferData1 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        k = 0;
        localObject2 = localBufferData1;
        if (localBufferData1 == null) {
          localObject3 = localBufferData1;
        }
      }
      catch (Exception localException4)
      {
        AndroidCodec.BufferData localBufferData1;
        label568:
        Object localObject1;
        localException4.printStackTrace();
        a(-9, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
        continue;
        k = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_JavaNioByteBuffer, 0);
        if (k >= 0) {
          break label888;
        }
      }
      try
      {
        Thread.sleep(50L);
        localObject3 = localBufferData1;
        localObject2 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        m = k + 1;
        if (localObject2 == null) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      if (localObject2 != null) {
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback != null) && (a() == 0)) {
        this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback.a(b(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long);
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.c();
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.d();
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        return;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        return;
      }
      k = m;
      localObject1 = localObject2;
      if (m > 8)
      {
        localObject3 = localObject2;
        a(-5, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
      }
    }
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_Int, 0, 0L, 4);
    i = 1;
    label770:
    AndroidCodec.BufferData localBufferData2;
    label822:
    label888:
    int i5;
    label917:
    label922:
    int i4;
    int i2;
    int i7;
    int i6;
    int i9;
    label1083:
    int i3;
    if (QLog.isDevelopLevel())
    {
      QLog.w("VideoDecTest", 4, "sent input EOS");
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        m = j;
        i1 = n;
        l2 = l1;
        k = i;
        if (j != 0) {
          break;
        }
        localBufferData2 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
        m = j;
        k = n;
        if (localBufferData2 == null) {
          break label1265;
        }
        if ((localBufferData2.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break label1300;
        }
        j = 1;
        k = n;
        if (localBufferData2.jdField_a_of_type_Int < 0) {
          break label1236;
        }
        if (localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat == null) {
          break label922;
        }
        this.jdField_c_of_type_Int = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("color-format");
        if (DeviceCheck.a(this.jdField_c_of_type_Int)) {
          break label917;
        }
        a(-6, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, -1);
        this.jdField_a_of_type_Boolean = false;
        break label568;
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_Int, k, 30000L * l1, 0);
        l1 += 1L;
      }
      this.jdField_a_of_type_Boolean = true;
      k = n;
      if (j == 0)
      {
        k = n;
        if (localBufferData2.jdField_a_of_type_JavaNioByteBuffer != null)
        {
          k = n;
          if (localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat != null)
          {
            i5 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("width");
            i4 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
            i2 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-left");
            i7 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-right");
            int i8 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-top");
            i6 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-bottom");
            i1 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("stride");
            m = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("slice-height");
            i9 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            k = m;
            if (m >= i4) {
              break label1309;
            }
            k = i4;
            break label1309;
            i3 = k;
            i1 = i8;
            if (i9 != 2130706688) {
              break label1327;
            }
            i3 = k - i8 / 2;
            i1 = 0;
            i2 = 0;
            break label1327;
          }
        }
      }
    }
    label1287:
    label1300:
    label1306:
    label1309:
    label1327:
    label1470:
    label1485:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoDecTest", 2, "error decoderInfomations.");
      }
      a(-7, this.jdField_b_of_type_JavaLangString, i9, -1);
      break label568;
      label1146:
      if (this.jdField_b_of_type_Long == -1L) {
        this.jdField_b_of_type_Long = ((l1 - 1L) * 30L);
      }
      k = GraphicRenderMgr.checkhwyuv(localBufferData2.jdField_a_of_type_JavaNioByteBuffer, localBufferData2.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, k, m, i2, i3, i1, i4, i9, n);
      if (k != 0)
      {
        a(-8, this.jdField_b_of_type_JavaLangString, i9, k);
        this.jdField_b_of_type_Boolean = false;
        break label568;
      }
      this.jdField_b_of_type_Boolean = true;
      k = n + 1;
      label1236:
      if (localBufferData2.jdField_a_of_type_JavaNioByteBuffer != null) {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBufferData2.jdField_a_of_type_Int);
      }
      try
      {
        Thread.sleep(30L);
        m = j;
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          label1265:
          localInterruptedException2.printStackTrace();
          m = j;
        }
      }
      j = m;
      n = k;
      break;
      k = m;
      break label1470;
      do
      {
        m = i4;
        break label1375;
        break label822;
        break;
        break label770;
        m = i1;
        if (i1 >= i5) {
          break label1083;
        }
        m = i5;
        break label1083;
        k = m;
        if (m < i5) {
          k = i5;
        }
      } while (((2141391876 != i9) && (2130706433 != i9) && (2130706944 != i9)) || (i4 >= i3));
      m = i3;
      label1375:
      if (i2 + i7 + i1 + i6 == 0)
      {
        i2 = 0;
        i3 = i5 - 1;
        i4 -= 1;
        i1 = 0;
      }
      for (;;)
      {
        if ((k <= 0) || (m <= 0) || (i3 <= 0)) {
          break label1485;
        }
        if (i4 > 0) {
          break label1146;
        }
        break;
        i5 = i7 - i2 + 1;
        i4 = i6 - i1 + 1;
        i3 = k;
        if (k < i5) {
          i3 = i5;
        }
        if (m >= i4) {
          break label1287;
        }
        k = i4;
        m = k;
        k = i3;
        i3 = i7;
        i4 = i6;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.mediacodec.VideoDecTest
 * JD-Core Version:    0.7.0.1
 */