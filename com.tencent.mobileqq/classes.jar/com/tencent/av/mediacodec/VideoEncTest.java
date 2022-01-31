package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.List;

@SuppressLint({"NewApi"})
public class VideoEncTest
  implements Runnable
{
  int jdField_a_of_type_Int;
  VideoEncTest.PlayerCallback jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback;
  String jdField_a_of_type_JavaLangString;
  Thread jdField_a_of_type_JavaLangThread;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public VideoEncTest(String paramString, boolean paramBoolean, VideoEncTest.PlayerCallback paramPlayerCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback = paramPlayerCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
    AndroidCodec.b();
    paramString = BaseApplicationImpl.getContext();
    paramPlayerCallback = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MODEL=" + Build.MODEL.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "SDK=" + Build.VERSION.SDK_INT + ";";
    paramPlayerCallback = paramPlayerCallback + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
    paramString = paramString.getApplicationInfo();
    paramPlayerCallback = paramPlayerCallback + "DATADIR=" + paramString.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramString = paramPlayerCallback + "LIBDIR=" + paramString.nativeLibraryDir + ";";; paramString = paramPlayerCallback + "LIBDIR=" + paramString.dataDir + "/lib;")
    {
      this.jdField_a_of_type_Int = QuaCreate(paramString);
      return;
    }
  }
  
  public static native void QuaClose(int paramInt);
  
  public static native int QuaCreate(String paramString);
  
  public static native int Quacaculatessim(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static int a(InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInputStream == null) {}
    for (;;)
    {
      return 0;
      try
      {
        if (paramInputStream.read(paramArrayOfByte1, 0, paramInt) != -1)
        {
          System.out.write(paramArrayOfByte1, 0, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncTest", 2, "read file to byte write 0");
          }
          if (paramInputStream.read(paramArrayOfByte2, 0, paramInt) == -1) {
            break label104;
          }
          System.out.write(paramArrayOfByte2, 0, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("VideoEncTest", 2, "read file to byte write 1");
          }
        }
        try
        {
          paramInputStream.close();
          return 1;
          try
          {
            paramInputStream.close();
            return 0;
          }
          catch (IOException paramInputStream) {}
          if (QLog.isColorLevel())
          {
            QLog.e("VideoEncTest", 2, "close input stream error!!!", paramInputStream);
            return 0;
            try
            {
              label104:
              paramInputStream.close();
              return 0;
            }
            catch (IOException paramInputStream) {}
            if (QLog.isColorLevel())
            {
              QLog.e("VideoEncTest", 2, "close input stream error!!!", paramInputStream);
              return 0;
            }
          }
        }
        catch (IOException paramInputStream)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoEncTest", 2, "close input stream error!!!", paramInputStream);
            }
          }
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        paramArrayOfByte1 = paramArrayOfByte1;
        if (QLog.isColorLevel()) {
          QLog.e("VideoEncTest", 2, "read input stream error!!!", paramArrayOfByte1);
        }
        try
        {
          paramInputStream.close();
          return 0;
        }
        catch (IOException paramInputStream) {}
        if (QLog.isColorLevel())
        {
          QLog.e("VideoEncTest", 2, "close input stream error!!!", paramInputStream);
          return 0;
        }
      }
      finally {}
    }
    try
    {
      paramInputStream.close();
      throw paramArrayOfByte1;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoEncTest", 2, "close input stream error!!!", paramInputStream);
        }
      }
    }
  }
  
  static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int k = paramInt1 / 2;
    int m = paramInt2 / 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 0, paramInt1 * paramInt2);
    int i = 0;
    int j;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte1[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte1[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 0, paramInt1 * paramInt2);
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte2[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte2[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "Movie Player");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback != null)) {
      this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback.a(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  public int b()
  {
    return a();
  }
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    int i7 = 0;
    int i9 = -1;
    int i10 = -1;
    Object localObject5 = AndroidCodec.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.w("VideoEncTest", 2, "useAsyncMode:" + this.jdField_a_of_type_Boolean);
    }
    List localList = AndroidCodec.b((String)localObject5);
    int i = 0;
    int i3;
    label115:
    int j;
    label181:
    int m;
    int n;
    int i1;
    for (;;)
    {
      if (i < localList.size())
      {
        Object localObject3 = AndroidCodec.a((MediaCodecInfo)localList.get(i), (String)localObject5);
        if (localObject3 == null)
        {
          i += 1;
        }
        else
        {
          if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats, 21))
          {
            i3 = 21;
            if ((i3 == 19) || (i3 == 21)) {
              break label181;
            }
            a(-1, "", i3, 0, 0, -1, -1);
          }
          for (;;)
          {
            return;
            if ("OMX.IMG.TOPAZ.VIDEO.Encoder".equals(""))
            {
              i3 = 0;
              i = 0;
              break label115;
            }
            if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats, 19)) {
              break;
            }
            i3 = 19;
            break label115;
            int i4 = 200;
            AndroidCodec localAndroidCodec = new AndroidCodec();
            localObject3 = MediaFormat.createVideoFormat((String)localObject5, 320, 240);
            ((MediaFormat)localObject3).setInteger("color-format", i3);
            ((MediaFormat)localObject3).setInteger("frame-rate", 10);
            ((MediaFormat)localObject3).setInteger("bitrate", 204800);
            ((MediaFormat)localObject3).setInteger("i-frame-interval", 300);
            localObject5 = AndroidCodec.a((MediaCodecInfo)localList.get(i), (String)localObject5);
            int k;
            if (localObject5 != null)
            {
              j = 16;
              m = 0;
              if (m < ((MediaCodecInfo.CodecCapabilities)localObject5).profileLevels.length)
              {
                switch (localObject5.profileLevels[m].profile)
                {
                }
                for (;;)
                {
                  m += 1;
                  break;
                  ((MediaFormat)localObject3).setInteger("profile", 1);
                  k = j;
                  if (j < localObject5.profileLevels[m].level) {
                    k = localObject5.profileLevels[m].level;
                  }
                  ((MediaFormat)localObject3).setInteger("level", k);
                  j = k;
                }
              }
            }
            String str = ((MediaCodecInfo)localList.get(i)).getName();
            if (!localAndroidCodec.a((MediaFormat)localObject3, str, null))
            {
              a(-3, str, i3, 0, 0, -1, -1);
              return;
            }
            int i2;
            long l;
            int i5;
            int i8;
            byte[][] arrayOfByte1;
            try
            {
              bool = localAndroidCodec.a();
              if (!bool)
              {
                a(-4, str, i3, 0, 0, -1, -1);
                return;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.e("VideoEncTest", 2, "Exception", localException1);
                }
                boolean bool = false;
              }
              j = 0;
              i2 = 0;
              l = 0L;
              n = 0;
              i5 = 0;
              i8 = 0;
              i1 = 0;
              arrayOfByte1 = new byte[2][];
              arrayOfByte1[0] = null;
              arrayOfByte1[1] = null;
              arrayOfByte1[0] = new byte[115200];
              arrayOfByte1[1] = new byte[115200];
              try
              {
                a(new FileInputStream(new File(this.jdField_a_of_type_JavaLangString)), 115200, arrayOfByte1[0], arrayOfByte1[1]);
                if ((arrayOfByte1[0] != null) && (arrayOfByte1[1] != null)) {
                  break label619;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("VideoEncTest", 2, "testHWCodecIfNeed read file to byte fail");
                return;
              }
              catch (Exception localException2) {}
            }
            label619:
            byte[][] arrayOfByte2;
            int i6;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoEncTest", 2, "testHWCodecIfNeed read file to byte exception", localException2);
              return;
              arrayOfByte2 = new byte[2][];
              arrayOfByte2[0] = null;
              arrayOfByte2[1] = null;
              if (i3 == 21)
              {
                arrayOfByte2[0] = new byte[115200];
                arrayOfByte2[1] = new byte[115200];
                a(arrayOfByte1[0], arrayOfByte1[1], 320, 240, arrayOfByte2[0], arrayOfByte2[1]);
              }
              i6 = 0;
              m = i10;
              k = i9;
              i = i7;
              label698:
              if (i2 != 0) {}
            }
            label724:
            label757:
            int i11;
            label921:
            int i15;
            int i12;
            int i14;
            int i13;
            try
            {
              if (this.jdField_b_of_type_Boolean) {
                continue;
              }
              if (j != 0) {
                break label2546;
              }
              localObject1 = localAndroidCodec.a();
              i7 = 0;
              if (localObject1 != null) {
                break label2543;
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                Object localObject1;
                AndroidCodec.BufferData localBufferData;
                int i16;
                Object localObject4;
                localException4.printStackTrace();
                if (QLog.isColorLevel()) {
                  QLog.e("VideoEncTest", 2, "Exception", localException4);
                }
                a(-9, str, i3, 0, i, k, m);
                continue;
                localAndroidCodec.a(localException4.jdField_a_of_type_Int, 0, 0L, 4);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoEncTest", 2, "sent input EOS");
                }
                j = n;
                n = 1;
              }
            }
            try
            {
              Thread.sleep(50L);
              localObject3 = localAndroidCodec.a();
              localObject1 = localObject3;
              i7 += 1;
              if (localObject1 != null) {}
              for (;;)
              {
                if (localObject1 != null) {
                  break label941;
                }
                if ((this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback != null) && (a() == 0))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoEncTest", 2, "mCallback: " + this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback + ", getLastErr: " + a() + ", ssim: " + i);
                  }
                  this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback.a(b(), str, i3, i1, i, k, m);
                }
                try
                {
                  localAndroidCodec.c();
                  localAndroidCodec.d();
                  return;
                }
                catch (Exception localException3)
                {
                  localException3.printStackTrace();
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("VideoEncTest", 2, "Exception", localException3);
                return;
                if (i7 <= 8) {
                  break label2570;
                }
                try
                {
                  a(-5, str, i3, 0, i, k, m);
                }
                catch (InterruptedException localInterruptedException2) {}
              }
            }
            catch (InterruptedException localInterruptedException3)
            {
              break label921;
              localObject2 = localInterruptedException3;
              i6 = i14;
              i8 = i13;
              i = k;
              i5 = i12;
              i1 = i4;
              i4 = i15;
              k = i9;
              break label2146;
              localObject5 = localInterruptedException3;
              i2 = i;
              i8 = i9;
              break label1795;
              i7 = i2;
              break label1132;
              i7 = i;
              i = m;
              m = i5;
              i9 = i4;
              i5 = i1;
              i4 = i6;
              i6 = i8;
              i8 = m;
              i1 = i2;
              i2 = i9;
              m = k;
              k = i7;
              break label2193;
              i7 = n;
              n = j;
              j = i7;
            }
          }
          if (!QLog.isColorLevel()) {
            break label2567;
          }
          QLog.e("VideoEncTest", 2, "InterruptedException", localInterruptedException2);
          break label2567;
          label941:
          if (n < 100)
          {
            localException3.jdField_a_of_type_JavaNioByteBuffer.clear();
            i7 = n & 0x1;
            if (i3 == 21)
            {
              localException3.jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte2[i7]);
              label984:
              localAndroidCodec.a(localException3.jdField_a_of_type_Int, 115200, l * 100000L, 0);
              i7 = n + 1;
              l = 1L + l;
              n = j;
              j = i7;
              label1022:
              if (i2 != 0) {
                break label2530;
              }
              localBufferData = localAndroidCodec.b();
              if (localBufferData == null) {
                break label2483;
              }
              i16 = localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
              if ((i16 & 0x4) == 0) {
                break label2476;
              }
              i9 = i8 * 8 * 10 / ((i5 - 50) * 1024);
              i2 = i;
              i10 = k;
              i11 = i9;
            }
          }
          try
          {
            if (!QLog.isColorLevel()) {
              break label2573;
            }
            i2 = i;
            i10 = k;
            i11 = i9;
            QLog.d("VideoEncTest", 2, "testHWCodecIfNeed testH264EncoderIfNeed avgbit is: " + i9);
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              label1132:
              m = i11;
              label1795:
              i = i2;
              k = i10;
            }
          }
          localObject4 = localBufferData;
          i9 = i;
          i15 = i6;
          i12 = i1;
          i14 = i8;
          i13 = i5;
          if (i7 == 0)
          {
            i2 = i;
            i10 = k;
            i11 = m;
            localObject4 = localBufferData;
            i9 = i;
            i15 = i6;
            i12 = i1;
            i14 = i8;
            i13 = i5;
            if (localBufferData.jdField_a_of_type_Int >= 0)
            {
              i2 = i;
              i10 = k;
              i11 = m;
              localObject4 = localBufferData;
              i9 = i;
              i15 = i6;
              i12 = i1;
              i14 = i8;
              i13 = i5;
              if (localBufferData.jdField_a_of_type_JavaNioByteBuffer != null)
              {
                i2 = i;
                i10 = k;
                i11 = m;
                if (QLog.isColorLevel())
                {
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  QLog.d("VideoEncTest", 2, "index: " + localBufferData.jdField_a_of_type_Int + ", flags: " + i16 + ", size: " + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                }
                i2 = i;
                i10 = k;
                i11 = m;
                i9 = i8 + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
                i2 = i;
                i10 = k;
                i11 = m;
                localObject4 = new byte[localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
                i2 = i;
                i10 = k;
                i11 = m;
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.limit(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                i2 = i;
                i10 = k;
                i11 = m;
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.position(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                i2 = i;
                i10 = k;
                i11 = m;
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.flip();
                i2 = i;
                i10 = k;
                i11 = m;
                localBufferData.jdField_a_of_type_JavaNioByteBuffer.get((byte[])localObject4);
                localObject5 = localObject4;
                i2 = i;
                i8 = i9;
                if (i16 == 2)
                {
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  i = Quacaculatessim(this.jdField_a_of_type_Int, (byte[])localObject4, arrayOfByte1[0]);
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localBufferData = localAndroidCodec.b();
                  if ((localBufferData == null) || (i7 != 0)) {
                    break label2462;
                  }
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  if (localBufferData.jdField_a_of_type_Int < 0) {
                    break label2462;
                  }
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  if (localBufferData.jdField_a_of_type_JavaNioByteBuffer == null) {
                    break label2462;
                  }
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  if (QLog.isColorLevel())
                  {
                    i2 = i;
                    i10 = k;
                    i11 = m;
                    QLog.d("VideoEncTest", 2, "index: " + localBufferData.jdField_a_of_type_Int + ", flags: " + i16 + ", size: " + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                  }
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  i8 = i9 + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localObject5 = new byte[localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.limit(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.position(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.flip();
                  i2 = i;
                  i10 = k;
                  i11 = m;
                  localBufferData.jdField_a_of_type_JavaNioByteBuffer.get((byte[])localObject5);
                  i2 = i;
                }
                localObject4 = localBufferData;
                i9 = i2;
                i15 = i6;
                i12 = i1;
                i14 = i8;
                i13 = i5;
                if (localBufferData != null)
                {
                  i = i2;
                  if (i5 < 50)
                  {
                    i10 = k;
                    i11 = m;
                    i = Quacaculatessim(this.jdField_a_of_type_Int, (byte[])localObject5, arrayOfByte1[i6]);
                  }
                  i6 ^= 0x1;
                  i5 += 1;
                  if (i5 == 1)
                  {
                    i2 = i;
                    i10 = k;
                    i11 = m;
                    if (!QLog.isColorLevel()) {
                      break label2583;
                    }
                    i2 = i;
                    i10 = k;
                    i11 = m;
                    QLog.d("VideoEncTest", 2, "testHWCodecIfNeed testH264EncoderIfNeed output delay is: " + j);
                    break label2583;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = localBufferData;
      i9 = i;
      i15 = i6;
      i12 = i1;
      i14 = i8;
      i13 = i5;
      if (i5 == 50)
      {
        i2 = i;
        i10 = k;
        i11 = m;
        k = i8 * 8 / 1024 / 5;
        i2 = i;
        i10 = k;
        i11 = m;
        if (QLog.isColorLevel())
        {
          i2 = i;
          i10 = k;
          i11 = m;
          QLog.d("VideoEncTest", 2, "testHWCodecIfNeed testH264EncoderIfNeed avgbit is: " + k);
        }
        i9 = i4 + 100;
        i2 = i;
        i10 = k;
        i11 = m;
        localObject4 = new Bundle();
        i2 = i;
        i10 = k;
        i11 = m;
        ((Bundle)localObject4).putInt(AndroidCodec.c, 1);
        i2 = i;
        i10 = k;
        i11 = m;
        ((Bundle)localObject4).putInt("video-bitrate", i9 * 1024);
        i2 = i;
        i10 = k;
        i11 = m;
        localAndroidCodec.a((Bundle)localObject4);
        i4 = i6;
        i6 = 0;
        i8 = i5;
        i2 = k;
        i5 = i1;
        i1 = i9;
        k = i;
        i = i2;
        label2146:
        if (localBufferData != null) {}
        for (;;)
        {
          try
          {
            if (localBufferData.jdField_a_of_type_JavaNioByteBuffer != null) {
              localAndroidCodec.a(localBufferData.jdField_a_of_type_Int);
            }
          }
          catch (Exception localException6)
          {
            label2193:
            j = i;
            i = k;
            k = j;
            continue;
          }
          try
          {
            Thread.sleep(30L);
            i2 = m;
            m = i;
            i = i2;
            i2 = i1;
            i1 = i7;
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("VideoEncTest", 2, "InterruptedException", localInterruptedException1);
            i2 = i1;
            i1 = i7;
            i7 = i;
            i = m;
            m = i7;
          }
        }
        i7 = i6;
        i9 = i8;
        i10 = i1;
        i11 = i2;
        i12 = n;
        n = i;
        i = k;
        k = m;
        m = n;
        i6 = i4;
        i1 = i5;
        i8 = i7;
        i5 = i9;
        i2 = i10;
        i4 = i11;
        n = j;
        j = i12;
        break label698;
        localBufferData.jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte1[i7]);
        break label984;
      }
      Object localObject2;
      label2462:
      label2476:
      label2483:
      label2530:
      break label698;
      label2543:
      break label757;
      label2546:
      i7 = j;
      j = n;
      n = i7;
      break label1022;
      i3 = 0;
      i = 0;
      break;
      label2567:
      break label757;
      label2570:
      break label724;
      label2573:
      i7 = 1;
      m = i9;
      break label1132;
      label2583:
      i1 = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.mediacodec.VideoEncTest
 * JD-Core Version:    0.7.0.1
 */