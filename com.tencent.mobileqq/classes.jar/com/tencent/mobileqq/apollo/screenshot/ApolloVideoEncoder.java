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
  public boolean a;
  private int b = 10;
  private File c;
  private int d = 0;
  private final List<String> e = new ArrayList();
  private int f = 0;
  private MediaCodec g;
  private MediaMuxer h;
  private int i;
  private boolean j;
  private int k;
  private int l;
  private int m;
  private ApolloVideoEncoder.OnEncodeFinishListener n;
  
  public ApolloVideoEncoder(List<String> paramList, String paramString, int paramInt1, int paramInt2)
  {
    this.c = new File(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.e.addAll(paramList);
    }
    this.a = false;
    this.i = 0;
    this.j = false;
    this.l = paramInt1;
    this.m = paramInt2;
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
    return ((float)(paramLong * 1000000L / this.b) * 1.8F + 100.0F);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.n != null)
    {
      c();
      this.n.a(paramInt, paramString);
      this.n = null;
    }
  }
  
  private void a(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    localObject1 = null;
    label360:
    label381:
    do
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 21) {
          localObject1 = this.g.getOutputBuffers();
        }
        if (paramBoolean) {
          try
          {
            this.g.signalEndOfInputStream();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        for (;;)
        {
          i1 = this.g.dequeueOutputBuffer(paramBufferInfo, 10000L);
          if (i1 == -1)
          {
            if (!paramBoolean) {
              return;
            }
            QLog.i("[cmshow]ApolloVideoEncoder", 4, "no output available, spinning to await EOS");
          }
          else if (i1 == -2)
          {
            if (!this.j)
            {
              localObject2 = this.g.getOutputFormat();
              this.i = this.h.addTrack((MediaFormat)localObject2);
              this.h.start();
              this.j = true;
            }
            else
            {
              throw new RuntimeException("format changed twice");
            }
          }
          else
          {
            if (i1 >= 0) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("unexpected result from encoder.dequeueOutputBuffer: ");
            ((StringBuilder)localObject2).append(i1);
            QLog.i("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject2).toString());
          }
        }
        if (Build.VERSION.SDK_INT <= 21) {
          localObject2 = localObject1[i1];
        } else {
          localObject2 = this.g.getOutputBuffer(i1);
        }
        if (localObject2 != null)
        {
          if ((paramBufferInfo.flags & 0x2) != 0)
          {
            QLog.d("[cmshow]ApolloVideoEncoder", 4, "ignoring BUFFER_FLAG_CODEC_CONFIG");
            paramBufferInfo.size = 0;
          }
          if (paramBufferInfo.size != 0) {
            if (this.j)
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
        int i1;
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
        this.h.writeSampleData(this.i, (ByteBuffer)localObject2, paramBufferInfo);
      }
      catch (Exception localException2)
      {
        break label360;
      }
      QLog.i("[cmshow]ApolloVideoEncoder", 4, "Too many frames");
      break label381;
      throw new RuntimeException("muxer hasn't started");
      this.g.releaseOutputBuffer(i1, false);
    } while ((paramBufferInfo.flags & 0x4) == 0);
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
    paramBufferInfo.append(i1);
    paramBufferInfo.append(" was null");
    throw new RuntimeException(paramBufferInfo.toString());
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i2 = this.d;
    int i1 = i2;
    if (i2 == 0) {
      i1 = paramInt1 * paramInt2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bitrate = ");
    ((StringBuilder)localObject).append(i1);
    QLog.i("[cmshow]ApolloVideoEncoder", 1, ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloVideoEncoder", 1, "getMediaCodecList returns null");
      return false;
    }
    int i3 = localObject.length;
    i2 = 0;
    while (i2 < i3)
    {
      int i4 = localObject[i2];
      if (i4 != 39)
      {
        switch (i4)
        {
        default: 
          break;
        case 21: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420SemiPlanar");
          this.k = i4;
          break;
        case 20: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedPlanar");
          this.k = i4;
          break;
        case 19: 
          QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420Planar");
          this.k = i4;
          break;
        }
      }
      else
      {
        QLog.i("[cmshow]ApolloVideoEncoder", 2, "COLOR_FormatYUV420PackedSemiPlanar");
        this.k = i4;
      }
      if (this.k > 0) {
        break;
      }
      i2 += 1;
    }
    if (this.k <= 0) {
      this.k = 21;
    }
    localObject = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    ((MediaFormat)localObject).setInteger("color-format", this.k);
    ((MediaFormat)localObject).setInteger("bitrate", i1);
    ((MediaFormat)localObject).setInteger("frame-rate", this.b);
    ((MediaFormat)localObject).setInteger("i-frame-interval", 0);
    try
    {
      this.g = MediaCodec.createEncoderByType("video/avc");
      this.h = new MediaMuxer(this.c.getAbsolutePath(), 0);
      this.g.configure((MediaFormat)localObject, null, null, 1);
      this.g.start();
      this.a = true;
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init error video/avc, ");
      localStringBuilder.append(this.k);
      QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder.toString(), localException);
      a(4, "");
    }
    return false;
  }
  
  private byte[] a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int i1 = paramInt1 * paramInt2;
    try
    {
      int[] arrayOfInt = new int[i1];
      paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      paramBitmap = new byte[i1 * 3 / 2];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNV12 ");
      localStringBuilder.append(this.k);
      QLog.d("[cmshow]ApolloVideoEncoder", 4, localStringBuilder.toString());
      i1 = this.k;
      if (i1 != 39) {}
      switch (i1)
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
  
  private Bitmap d()
  {
    if (!this.e.isEmpty()) {
      if (this.f >= this.e.size()) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        String str = (String)this.e.get(this.f);
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNextBitmap ");
        ((StringBuilder)localObject1).append(this.f);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(": ");
        int i2 = 0;
        int i1;
        if (localBitmap == null) {
          i1 = 0;
        } else {
          i1 = localBitmap.getByteCount();
        }
        ((StringBuilder)localObject1).append(i1);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject1).toString());
        this.f += 1;
        if (localBitmap == null) {
          break label307;
        }
        Object localObject3 = Bitmap.createScaledBitmap(localBitmap, this.l, this.m, true);
        localObject1 = localObject3;
        if (localBitmap != localObject3)
        {
          localBitmap.recycle();
          localObject1 = localObject3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getNextBitmap ");
        ((StringBuilder)localObject3).append(this.f);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(": ");
        if (localObject1 == null) {
          i1 = i2;
        } else {
          i1 = ((Bitmap)localObject1).getByteCount();
        }
        ((StringBuilder)localObject3).append(i1);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject3).toString());
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow]ApolloVideoEncoder", 2, "getNextBitmap error", localOutOfMemoryError);
        System.gc();
      }
      return null;
      label307:
      Object localObject2 = null;
    }
  }
  
  private void e()
  {
    if ((this.g != null) && (this.h != null))
    {
      this.a = true;
      long l1 = 0L;
      MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
      Object localObject1 = null;
      if (Build.VERSION.SDK_INT <= 21) {
        localObject1 = this.g.getInputBuffers();
      }
      while (this.a)
      {
        int i1 = this.g.dequeueInputBuffer(10000L);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("run ");
        ((StringBuilder)localObject2).append(i1);
        QLog.d("[cmshow]ApolloVideoEncoder", 4, ((StringBuilder)localObject2).toString());
        if (i1 >= 0)
        {
          long l2 = a(l1);
          if (l1 >= this.e.size())
          {
            this.g.queueInputBuffer(i1, 0, 0, l2, 4);
            this.a = false;
            a(true, localBufferInfo);
          }
          else
          {
            Bitmap localBitmap = d();
            int i2 = this.f - 1;
            if ((i2 < this.e.size()) && (i2 >= 0)) {
              localObject2 = (String)this.e.get(i2);
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
              localObject2 = localObject1[i1];
            } else {
              localObject2 = this.g.getInputBuffer(i1);
            }
            ((ByteBuffer)localObject2).clear();
            ((ByteBuffer)localObject2).put(arrayOfByte);
            this.g.queueInputBuffer(i1, 0, arrayOfByte.length, l2, 0);
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
      localObject1 = this.g;
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
      a(0, this.c.getAbsolutePath());
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("doStart exits due to codec or muxer null: ");
    localStringBuilder1.append(this.g);
    localStringBuilder1.append(", ");
    localStringBuilder1.append(this.h);
    QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder1.toString());
  }
  
  public void a(ApolloVideoEncoder.OnEncodeFinishListener paramOnEncodeFinishListener)
  {
    this.n = paramOnEncodeFinishListener;
  }
  
  public int[] a()
  {
    int i3 = MediaCodecList.getCodecCount();
    Object localObject1 = null;
    int i1 = 0;
    Object localObject2;
    Object localObject3;
    while ((i1 < i3) && (localObject1 == null))
    {
      localObject2 = MediaCodecList.getCodecInfoAt(i1);
      if (((MediaCodecInfo)localObject2).isEncoder())
      {
        localObject3 = ((MediaCodecInfo)localObject2).getSupportedTypes();
        int i2 = 0;
        while (i2 < localObject3.length)
        {
          if (localObject3[i2].equals("video/avc"))
          {
            i2 = 1;
            break label79;
          }
          i2 += 1;
        }
        i2 = 0;
        label79:
        if (i2 != 0) {
          localObject1 = localObject2;
        }
      }
      i1 += 1;
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
    File localFile = this.c;
    if ((localFile != null) && (!TextUtils.isEmpty(localFile.getAbsolutePath())))
    {
      ThreadManager.getSubThreadHandler().post(new ApolloVideoEncoder.1(this));
      return;
    }
    QLog.e("[cmshow]ApolloVideoEncoder", 1, "cannot start due to empty output path");
  }
  
  public void c()
  {
    this.a = false;
    MediaCodec localMediaCodec = this.g;
    StringBuilder localStringBuilder;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.stop();
        this.g.release();
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("finish media codec error: ");
        localStringBuilder.append(localException1.getMessage());
        QLog.e("[cmshow]ApolloVideoEncoder", 1, localStringBuilder.toString(), localException1);
      }
    }
    MediaMuxer localMediaMuxer = this.h;
    if (localMediaMuxer != null) {
      try
      {
        if (this.j)
        {
          localMediaMuxer.stop();
          this.h.release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder
 * JD-Core Version:    0.7.0.1
 */