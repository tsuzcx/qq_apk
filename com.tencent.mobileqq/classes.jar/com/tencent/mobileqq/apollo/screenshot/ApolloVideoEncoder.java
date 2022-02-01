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
    QLog.i("ApolloVideoEncoder", 1, "ApolloVideoEncoder ver1.0, " + Build.BRAND + ", " + Build.MODEL + ", " + Build.VERSION.SDK_INT);
  }
  
  private int a(int paramInt)
  {
    return paramInt / 4 * 4;
  }
  
  private long a(long paramLong)
  {
    return (100.0F + (float)(1000000L * paramLong / this.jdField_a_of_type_Int) * 1.8F);
  }
  
  private Bitmap a()
  {
    if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.c >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    label261:
    for (;;)
    {
      try
      {
        String str = (String)this.jdField_a_of_type_JavaUtilList.get(this.c);
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject1);
        localObject1 = new StringBuilder().append("getNextBitmap ").append(this.c).append(", ").append(str).append(": ");
        if (localBitmap == null)
        {
          i = 0;
          QLog.d("ApolloVideoEncoder", 4, i);
          this.c += 1;
          if (localBitmap == null) {
            break label261;
          }
          Object localObject3 = Bitmap.createScaledBitmap(localBitmap, this.f, this.g, true);
          localObject1 = localObject3;
          if (localBitmap != localObject3)
          {
            localBitmap.recycle();
            localObject1 = localObject3;
          }
          localObject3 = new StringBuilder().append("getNextBitmap ").append(this.c).append(", ").append(str).append(": ");
          if (localObject1 == null)
          {
            i = 0;
            QLog.d("ApolloVideoEncoder", 4, i);
            return localObject1;
          }
        }
        else
        {
          i = localBitmap.getByteCount();
          continue;
        }
        int i = ((Bitmap)localObject1).getByteCount();
        continue;
        Object localObject2 = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ApolloVideoEncoder", 2, "getNextBitmap error", localOutOfMemoryError);
        System.gc();
        return null;
      }
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
    for (;;)
    {
      ByteBuffer[] arrayOfByteBuffer;
      int i;
      try
      {
        if (Build.VERSION.SDK_INT > 21) {
          break label468;
        }
        arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        if (paramBoolean) {}
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
          i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
          if (i != -1) {
            break label109;
          }
          if (!paramBoolean) {
            return;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        QLog.i("ApolloVideoEncoder", 4, "no output available, spinning to await EOS");
      }
      catch (Exception paramBufferInfo)
      {
        QLog.i("ApolloVideoEncoder", 1, "drainEncoder error: " + paramBufferInfo.getMessage(), paramBufferInfo);
        a(3, "");
        return;
      }
      continue;
      label109:
      Object localObject;
      if (i == -2)
      {
        if (this.jdField_b_of_type_Boolean) {
          throw new RuntimeException("format changed twice");
        }
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        this.d = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
        this.jdField_b_of_type_Boolean = true;
      }
      else if (i < 0)
      {
        QLog.i("ApolloVideoEncoder", 4, "unexpected result from encoder.dequeueOutputBuffer: " + i);
      }
      else
      {
        if (Build.VERSION.SDK_INT <= 21) {}
        for (localObject = arrayOfByteBuffer[i]; localObject == null; localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffer(i)) {
          throw new RuntimeException("encoderOutputBuffer " + i + " was null");
        }
        if ((paramBufferInfo.flags & 0x2) != 0)
        {
          QLog.d("ApolloVideoEncoder", 4, "ignoring BUFFER_FLAG_CODEC_CONFIG");
          paramBufferInfo.size = 0;
        }
        if (paramBufferInfo.size != 0)
        {
          if (!this.jdField_b_of_type_Boolean) {
            throw new RuntimeException("muxer hasn't started");
          }
          ((ByteBuffer)localObject).position(paramBufferInfo.offset);
          ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
          QLog.d("ApolloVideoEncoder", 4, "BufferInfo: " + paramBufferInfo.offset + ", " + paramBufferInfo.size + ", " + paramBufferInfo.presentationTimeUs);
        }
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.d, (ByteBuffer)localObject, paramBufferInfo);
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
          if ((paramBufferInfo.flags & 0x4) == 0) {
            continue;
          }
          if (!paramBoolean)
          {
            QLog.i("ApolloVideoEncoder", 1, "reached end of stream unexpectedly");
            a(1, "");
            return;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.i("ApolloVideoEncoder", 4, "Too many frames");
          }
          QLog.i("ApolloVideoEncoder", 1, "end of stream reached");
          return;
        }
        label468:
        arrayOfByteBuffer = null;
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_Int == 0) {
      i = paramInt1 * paramInt2;
    }
    QLog.i("ApolloVideoEncoder", 1, "bitrate = " + i);
    Object localObject = a();
    int k = localObject.length;
    int j = 0;
    for (;;)
    {
      int m;
      if (j < k)
      {
        m = localObject[j];
        switch (m)
        {
        }
      }
      while (this.e > 0)
      {
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
          QLog.e("ApolloVideoEncoder", 1, "init error video/avc, " + this.e, localException);
          a(4, "");
        }
        QLog.i("ApolloVideoEncoder", 2, "COLOR_FormatYUV420SemiPlanar");
        this.e = m;
        continue;
        QLog.i("ApolloVideoEncoder", 2, "COLOR_FormatYUV420Planar");
        this.e = m;
        continue;
        QLog.i("ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedSemiPlanar");
        this.e = m;
        continue;
        QLog.i("ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedPlanar");
        this.e = m;
      }
      j += 1;
    }
    return false;
  }
  
  private byte[] a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int[] arrayOfInt;
    try
    {
      arrayOfInt = new int[paramInt1 * paramInt2];
      paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      paramBitmap = new byte[paramInt1 * paramInt2 * 3 / 2];
      QLog.d("ApolloVideoEncoder", 4, "getNV12 " + this.e);
      switch (this.e)
      {
      case 21: 
        ApolloVideoUtils.a(paramBitmap, arrayOfInt, paramInt1, paramInt2);
        return paramBitmap;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("ApolloVideoEncoder", 1, "getNV12 OOM", paramBitmap);
      System.gc();
      return null;
    }
    ApolloVideoUtils.b(paramBitmap, arrayOfInt, paramInt1, paramInt2);
    return paramBitmap;
    ApolloVideoUtils.c(paramBitmap, arrayOfInt, paramInt1, paramInt2);
    return paramBitmap;
    ApolloVideoUtils.d(paramBitmap, arrayOfInt, paramInt1, paramInt2);
    return paramBitmap;
    return paramBitmap;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaCodec == null) || (this.jdField_a_of_type_AndroidMediaMediaMuxer == null))
    {
      QLog.e("ApolloVideoEncoder", 1, "doStart exits due to codec or muxer null: " + this.jdField_a_of_type_AndroidMediaMediaCodec + ", " + this.jdField_a_of_type_AndroidMediaMediaMuxer);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    ByteBuffer[] arrayOfByteBuffer;
    long l1;
    if (Build.VERSION.SDK_INT <= 21)
    {
      arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      l1 = 0L;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
        QLog.d("ApolloVideoEncoder", 4, "run " + i);
        long l2;
        if (i >= 0)
        {
          l2 = a(l1);
          if (l1 >= this.jdField_a_of_type_JavaUtilList.size())
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, l2, 4);
            this.jdField_a_of_type_Boolean = false;
            a(true, localBufferInfo);
            l1 += 1L;
          }
        }
        for (;;)
        {
          break;
          Bitmap localBitmap = a();
          Object localObject3 = "";
          int j = this.c - 1;
          Object localObject2 = localObject3;
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = localObject3;
            if (j >= 0) {
              localObject2 = (String)this.jdField_a_of_type_JavaUtilList.get(j);
            }
          }
          if (localBitmap == null)
          {
            QLog.e("ApolloVideoEncoder", 1, "getNextBitmap returns null: " + (String)localObject2);
            a(2, "");
            return;
          }
          localObject3 = a(a(localBitmap.getWidth()), a(localBitmap.getHeight()), localBitmap);
          localBitmap.recycle();
          if (localObject3 == null)
          {
            QLog.e("ApolloVideoEncoder", 1, "getNV12 returns null: " + (String)localObject2);
            a(6, "");
            return;
          }
          if (Build.VERSION.SDK_INT <= 21) {}
          for (localObject2 = arrayOfByteBuffer[i];; localObject2 = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffer(i))
          {
            ((ByteBuffer)localObject2).clear();
            ((ByteBuffer)localObject2).put((byte[])localObject3);
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, localObject3.length, l2, 0);
            a(false, localBufferInfo);
            break;
          }
          QLog.i("ApolloVideoEncoder", 4, "input buffer not available");
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
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
        a(0, this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloVideoEncoder", 1, "flush error: " + localException.getMessage(), localException);
        a(5, "");
        return;
      }
      Object localObject1 = null;
      l1 = 0L;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaIoFile == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaIoFile.getAbsolutePath())))
    {
      QLog.e("ApolloVideoEncoder", 1, "cannot start due to empty output path");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloVideoEncoder.1(this));
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
    if ((i < k) && (localObject1 == null))
    {
      localObject2 = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject2).isEncoder()) {}
    }
    label138:
    for (;;)
    {
      i += 1;
      break;
      String[] arrayOfString = ((MediaCodecInfo)localObject2).getSupportedTypes();
      int j = 0;
      label49:
      if (j < arrayOfString.length) {
        if (!arrayOfString[j].equals("video/avc")) {}
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label138;
        }
        localObject1 = localObject2;
        break;
        j += 1;
        break label49;
        localObject2 = localObject1.getCapabilitiesForType("video/avc");
        QLog.d("ApolloVideoEncoder", 4, "getMediaCodecList " + localObject1.getName());
        return ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      if (this.jdField_a_of_type_AndroidMediaMediaMuxer == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
            this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          }
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("ApolloVideoEncoder", 1, "finish media muxer error: " + localException2.getMessage(), localException2);
        }
        localException1 = localException1;
        QLog.e("ApolloVideoEncoder", 1, "finish media codec error: " + localException1.getMessage(), localException1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder
 * JD-Core Version:    0.7.0.1
 */