package com.tencent.mobileqq.apollo.screenshot;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

@RequiresApi(api=21)
public class ApolloVideoEncoder
{
  private int jdField_a_of_type_Int = 10;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private ApolloVideoEncoder.OnEncodeFinishListener jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener;
  private File jdField_a_of_type_JavaIoFile;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ApolloVideoEncoder(List<String> paramList, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoFile = new File(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Boolean = false;
    this.d = 0;
    this.jdField_b_of_type_Boolean = false;
    this.f = paramInt1;
    this.g = paramInt2;
    paramList = new StringBuilder();
    paramList.append("ApolloVideoEncoder ver1.1, ");
    paramList.append(Build.BRAND);
    paramList.append(", ");
    paramList.append(Build.MODEL);
    paramList.append(", ");
    paramList.append(Build.VERSION.SDK_INT);
    QLog.i("[cmshow]ApolloVideoEncoder", 1, paramList.toString());
  }
  
  private int a(int paramInt)
  {
    return paramInt / 4 * 4;
  }
  
  private long a(long paramLong)
  {
    return ((float)(paramLong * 1000000L / this.jdField_a_of_type_Int) * 1.8F + 100.0F);
  }
  
  private Bitmap a()
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      if (this.c >= this.jdField_a_of_type_JavaUtilList.size()) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        String str = (String)this.jdField_a_of_type_JavaUtilList.get(this.c);
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNextBitmap ");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(": ");
        int j = 0;
        int i;
        if (localBitmap == null) {
          i = 0;
        } else {
          i = localBitmap.getByteCount();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject1).toString());
        this.c += 1;
        if (localBitmap == null) {
          break label302;
        }
        Object localObject3 = Bitmap.createScaledBitmap(localBitmap, this.f, this.g, true);
        localObject1 = localObject3;
        if (localBitmap != localObject3)
        {
          localBitmap.recycle();
          localObject1 = localObject3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getNextBitmap ");
        ((StringBuilder)localObject3).append(this.c);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(": ");
        if (localObject1 == null) {
          i = j;
        } else {
          i = ((Bitmap)localObject1).getByteCount();
        }
        ((StringBuilder)localObject3).append(i);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject3).toString());
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]ApolloVideoEncoder", 2, "getNextBitmap error", localOutOfMemoryError);
        System.gc();
      }
      return null;
      label302:
      Object localObject2 = null;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener != null)
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener.a(paramInt, paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener = null;
    }
  }
  
  private void a(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    localObject1 = null;
    label361:
    do
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 21) {
          localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
        if (paramBoolean) {
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        for (;;)
        {
          i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
          if (i == -1)
          {
            if (!paramBoolean) {
              return;
            }
            QLog.i("[cmshow]ApolloVideoEncoder", 4, "no output available, spinning to await EOS");
          }
          else if (i == -2)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
              this.d = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject2);
              this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
              this.jdField_b_of_type_Boolean = true;
            }
            else
            {
              throw new RuntimeException("format changed twice");
            }
          }
          else
          {
            if (i >= 0) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("unexpected result from encoder.dequeueOutputBuffer: ");
            ((StringBuilder)localObject2).append(i);
            QLog.i("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject2).toString());
          }
        }
        if (Build.VERSION.SDK_INT <= 21) {
          localObject2 = localObject1[i];
        } else {
          localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffer(i);
        }
        if (localObject2 != null)
        {
          if ((paramBufferInfo.flags & 0x2) != 0)
          {
            QLog.d("[cmshow]ApolloVideoEncoder", 4, "ignoring BUFFER_FLAG_CODEC_CONFIG");
            paramBufferInfo.size = 0;
          }
          if (paramBufferInfo.size != 0) {
            if (this.jdField_b_of_type_Boolean)
            {
              ((ByteBuffer)localObject2).position(paramBufferInfo.offset);
              ((ByteBuffer)localObject2).limit(paramBufferInfo.offset + paramBufferInfo.size);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("BufferInfo: ");
              localStringBuilder.append(paramBufferInfo.offset);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramBufferInfo.size);
              localStringBuilder.append(", ");
              localStringBuilder.append(paramBufferInfo.presentationTimeUs);
              QLog.d("[cmshow]ApolloVideoEncoder", 4, localStringBuilder.toString());
            }
          }
        }
      }
      catch (Exception paramBufferInfo)
      {
        int i;
        Object localObject2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("drainEncoder error: ");
        ((StringBuilder)localObject1).append(paramBufferInfo.getMessage());
        QLog.i("[cmshow]ApolloVideoEncoder", 1, ((StringBuilder)localObject1).toString(), paramBufferInfo);
        a(3, "");
        return;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.d, (ByteBuffer)localObject2, paramBufferInfo);
      }
      catch (Exception localException2)
      {
        break label361;
      }
      QLog.i("[cmshow]ApolloVideoEncoder", 4, "Too many frames");
      break label384;
      throw new RuntimeException("muxer hasn't started");
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
    } while ((paramBufferInfo.flags & 0x4) == 0);
    label384:
    if (!paramBoolean)
    {
      QLog.i("[cmshow]ApolloVideoEncoder", 1, "reached end of stream unexpectedly");
      a(1, "");
      return;
    }
    QLog.i("[cmshow]ApolloVideoEncoder", 1, "end of stream reached");
    return;
    paramBufferInfo = new StringBuilder();
    paramBufferInfo.append("encoderOutputBuffer ");
    paramBufferInfo.append(i);
    paramBufferInfo.append(" was null");
    throw new RuntimeException(paramBufferInfo.toString());
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int j = this.jdField_b_of_type_Int;
    int i = j;
    if (j == 0) {
      i = paramInt1 * paramInt2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bitrate = ");
    ((StringBuilder)localObject).append(i);
    QLog.i("[cmshow]ApolloVideoEncoder", 1, ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloVideoEncoder", 1, "getMediaCodecList returns null");
      return false;
    }
    int k = localObject.length;
    j = 0;
    while (j < k)
    {
      int m = localObject[j];
      if (m != 39)
      {
        switch (m)
        {
        default: 
          break;
        case 21: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420SemiPlanar");
          this.e = m;
          break;
        case 20: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedPlanar");
          this.e = m;
          break;
        case 19: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420Planar");
          this.e = m;
          break;
        }
      }
      else
      {
        QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedSemiPlanar");
        this.e = m;
      }
      if (this.e > 0) {
        break;
      }
      j += 1;
    }
    if (this.e <= 0) {
      this.e = 21;
    }
    localObject = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    ((MediaFormat)localObject).setInteger("color-format", this.e);
    ((MediaFormat)localObject).setInteger("bitrate", i);
    ((MediaFormat)localObject).setInteger("frame-rate", this.jdField_a_of_type_Int);
    ((MediaFormat)localObject).setInteger("i-frame-interval", 0);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 0);
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init error video/avc, ");
      localStringBuilder.append(this.e);
      QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder.toString(), localException);
      a(4, "");
    }
    return false;
  }
  
  private byte[] a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i = paramInt1 * paramInt2;
    try
    {
      int[] arrayOfInt = new int[i];
      paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      paramBitmap = new byte[i * 3 / 2];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNV12 ");
      localStringBuilder.append(this.e);
      QLog.d("[cmshow]ApolloVideoEncoder", 4, localStringBuilder.toString());
      i = this.e;
      if (i != 39) {}
      switch (i)
      {
      case 21: 
        ApolloVideoUtils.a(paramBitmap, arrayOfInt, paramInt1, paramInt2);
        return paramBitmap;
      case 20: 
        ApolloVideoUtils.d(paramBitmap, arrayOfInt, paramInt1, paramInt2);
        return paramBitmap;
      case 19: 
        ApolloVideoUtils.b(paramBitmap, arrayOfInt, paramInt1, paramInt2);
        return paramBitmap;
        ApolloVideoUtils.c(paramBitmap, arrayOfInt, paramInt1, paramInt2);
        return paramBitmap;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("[cmshow]ApolloVideoEncoder", 1, "getNV12 OOM", paramBitmap);
      System.gc();
      return null;
    }
    return paramBitmap;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaCodec != null) && (this.jdField_a_of_type_AndroidMediaMediaMuxer != null))
    {
      this.jdField_a_of_type_Boolean = true;
      long l1 = 0L;
      MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
      Object localObject1 = null;
      if (Build.VERSION.SDK_INT <= 21) {
        localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      }
      while (this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("run ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject2).toString());
        if (i >= 0)
        {
          long l2 = a(l1);
          if (l1 >= this.jdField_a_of_type_JavaUtilList.size())
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, l2, 4);
            this.jdField_a_of_type_Boolean = false;
            a(true, localBufferInfo);
          }
          else
          {
            Bitmap localBitmap = a();
            int j = this.c - 1;
            if ((j < this.jdField_a_of_type_JavaUtilList.size()) && (j >= 0)) {
              localObject2 = (String)this.jdField_a_of_type_JavaUtilList.get(j);
            } else {
              localObject2 = "";
            }
            if (localBitmap == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("getNextBitmap returns null: ");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.e("[cmshow]ApolloVideoEncoder", 1, ((StringBuilder)localObject1).toString());
              a(2, "");
              return;
            }
            byte[] arrayOfByte = a(a(localBitmap.getWidth()), a(localBitmap.getHeight()), localBitmap);
            localBitmap.recycle();
            if (arrayOfByte == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("getNV12 returns null: ");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.e("[cmshow]ApolloVideoEncoder", 1, ((StringBuilder)localObject1).toString());
              a(6, "");
              return;
            }
            if (Build.VERSION.SDK_INT <= 21) {
              localObject2 = localObject1[i];
            } else {
              localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffer(i);
            }
            ((ByteBuffer)localObject2).clear();
            ((ByteBuffer)localObject2).put(arrayOfByte);
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, arrayOfByte.length, l2, 0);
            a(false, localBufferInfo);
          }
          l1 += 1L;
        }
        else
        {
          QLog.i("[cmshow]ApolloVideoEncoder", 4, "input buffer not available");
          try
          {
            Thread.sleep(50L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec;
      if (localObject1 != null) {
        try
        {
          ((MediaCodec)localObject1).flush();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("flush error: ");
          localStringBuilder2.append(localException.getMessage());
          QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder2.toString(), localException);
          a(5, "");
          return;
        }
      }
      a(0, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("doStart exits due to codec or muxer null: ");
    localStringBuilder1.append(this.jdField_a_of_type_AndroidMediaMediaCodec);
    localStringBuilder1.append(", ");
    localStringBuilder1.append(this.jdField_a_of_type_AndroidMediaMediaMuxer);
    QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder1.toString());
  }
  
  public void a()
  {
    File localFile = this.jdField_a_of_type_JavaIoFile;
    if ((localFile != null) && (!TextUtils.isEmpty(localFile.getAbsolutePath())))
    {
      ThreadManager.getSubThreadHandler().post(new ApolloVideoEncoder.1(this));
      return;
    }
    QLog.e("[cmshow]ApolloVideoEncoder", 1, "cannot start due to empty output path");
  }
  
  public void a(ApolloVideoEncoder.OnEncodeFinishListener paramOnEncodeFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener = paramOnEncodeFinishListener;
  }
  
  public int[] a()
  {
    int k = MediaCodecList.getCodecCount();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while ((i < k) && (localObject1 == null))
    {
      localObject2 = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject2).isEncoder())
      {
        localObject3 = ((MediaCodecInfo)localObject2).getSupportedTypes();
        int j = 0;
        while (j < localObject3.length)
        {
          if (localObject3[j].equals("video/avc"))
          {
            j = 1;
            break label79;
          }
          j += 1;
        }
        j = 0;
        label79:
        if (j != 0) {
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1.getCapabilitiesForType("video/avc");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getMediaCodecList ");
      ((StringBuilder)localObject3).append(localObject1.getName());
      QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject3).toString());
      return ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    MediaCodec localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
    StringBuilder localStringBuilder;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.stop();
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish media codec error: ");
        localStringBuilder.append(localException1.getMessage());
        QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder.toString(), localException1);
      }
    }
    MediaMuxer localMediaMuxer = this.jdField_a_of_type_AndroidMediaMediaMuxer;
    if (localMediaMuxer != null) {
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localMediaMuxer.stop();
          this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          return;
        }
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish media muxer error: ");
        localStringBuilder.append(localException2.getMessage());
        QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder.toString(), localException2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder
 * JD-Core Version:    0.7.0.1
 */