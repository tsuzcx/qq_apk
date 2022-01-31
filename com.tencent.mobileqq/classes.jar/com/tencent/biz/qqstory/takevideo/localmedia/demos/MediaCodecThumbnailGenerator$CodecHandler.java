package com.tencent.biz.qqstory.takevideo.localmedia.demos;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.localmedia.baoutils.media.VideoUtils;
import com.tencent.biz.qqstory.takevideo.localmedia.opengl.CodecOutputSurface;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;
import oji;
import ojj;

@TargetApi(16)
public class MediaCodecThumbnailGenerator$CodecHandler
  extends Handler
{
  public MediaCodecThumbnailGenerator$CodecHandler(MediaCodecThumbnailGenerator paramMediaCodecThumbnailGenerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailArgs paramThumbnailArgs)
  {
    int i = 0;
    MediaCodecThumbnailGenerator.ThumbnailTaskContext localThumbnailTaskContext = new MediaCodecThumbnailGenerator.ThumbnailTaskContext();
    localThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs = paramThumbnailArgs;
    localThumbnailTaskContext.jdField_b_of_type_Long = (MediaUtil.a(paramThumbnailArgs.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramThumbnailArgs.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramThumbnailArgs)
      {
        paramThumbnailArgs = paramThumbnailArgs;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramThumbnailArgs);
        if (!(paramThumbnailArgs instanceof IllegalArgumentException)) {
          break label548;
        }
        localThumbnailTaskContext.jdField_a_of_type_Int = 100;
        SLog.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramThumbnailArgs);
        obtainMessage(4, localThumbnailTaskContext).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = VideoUtils.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramThumbnailArgs.jdField_b_of_type_Int;
      Object localObject1 = new long[paramThumbnailArgs.d];
      long[] arrayOfLong = new long[paramThumbnailArgs.d];
      while (i < paramThumbnailArgs.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramThumbnailArgs.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localThumbnailTaskContext.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramThumbnailArgs.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramThumbnailArgs = new CodecOutputSurface((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramThumbnailArgs.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface = paramThumbnailArgs;
        localThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localThumbnailTaskContext.c = k;
        localThumbnailTaskContext.jdField_a_of_type_Int = 0;
        localThumbnailTaskContext.d = 0;
        localThumbnailTaskContext.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localThumbnailTaskContext.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localThumbnailTaskContext).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localThumbnailTaskContext.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramThumbnailArgs instanceof RuntimeException))
          {
            localThumbnailTaskContext.jdField_a_of_type_Int = 101;
            continue;
          }
          localThumbnailTaskContext.jdField_a_of_type_Int = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label540;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label318;
      }
    }
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    boolean bool = true;
    if (paramThumbnailTaskContext.jdField_a_of_type_Int != 0) {
      bool = false;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface.a();
      paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor != null)
    {
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = null;
    }
    MediaCodecThumbnailGenerator.ThumbnailResult localThumbnailResult = new MediaCodecThumbnailGenerator.ThumbnailResult();
    localThumbnailResult.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList);
    localThumbnailResult.b = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList);
    localThumbnailResult.jdField_a_of_type_Int = paramThumbnailTaskContext.jdField_a_of_type_Int;
    this.a.a.post(new oji(this, paramThumbnailTaskContext, bool, localThumbnailResult));
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext, boolean paramBoolean)
  {
    Object localObject1 = paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface;
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
    int k = paramThumbnailTaskContext.d;
    ArrayList localArrayList1 = paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList;
    label576:
    label579:
    for (;;)
    {
      try
      {
        ((CodecOutputSurface)localObject1).c();
        ((CodecOutputSurface)localObject1).d();
        ((CodecOutputSurface)localObject1).a(false);
        MediaCodecThumbnailGenerator.ThumbnailProgress localThumbnailProgress = new MediaCodecThumbnailGenerator.ThumbnailProgress();
        localObject1 = ((CodecOutputSurface)localObject1).a();
        if (localObject1 == null) {
          break label576;
        }
        int j = paramThumbnailTaskContext.jdField_b_of_type_Int;
        int i;
        if ((paramThumbnailTaskContext.jdField_b_of_type_Int % 180 <= 0) || (((Bitmap)localObject1).getWidth() >= ((Bitmap)localObject1).getHeight()))
        {
          i = j;
          if (paramThumbnailTaskContext.jdField_b_of_type_Int % 180 == 0)
          {
            i = j;
            if (((Bitmap)localObject1).getWidth() <= ((Bitmap)localObject1).getHeight()) {}
          }
        }
        else
        {
          i = j;
          if (localThumbnailArgs.jdField_a_of_type_Boolean) {
            i = j + 90;
          }
        }
        if (i > 0)
        {
          Object localObject2 = UIUtils.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          if (!paramBoolean) {
            break label579;
          }
          localObject2 = new File(localThumbnailArgs.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
          }
          finally
          {
            try
            {
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
              if (localBufferedOutputStream == null) {}
            }
            finally
            {
              continue;
            }
            try
            {
              localBufferedOutputStream.close();
              localThumbnailProgress.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localThumbnailProgress.jdField_a_of_type_Int = paramThumbnailTaskContext.d;
              localThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localThumbnailArgs.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramThumbnailTaskContext.d == 0)
                {
                  f1 = MediaCodecThumbnailGenerator.a(this.a, (Bitmap)localObject1);
                  SLog.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localThumbnailProgress.jdField_a_of_type_Long = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong[paramThumbnailTaskContext.d];
                }
              }
              if ((f1 >= 0.9F) && (localThumbnailProgress.jdField_a_of_type_Long <= 500000L) && (localThumbnailProgress.jdField_a_of_type_Long + 100000L <= paramThumbnailTaskContext.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localThumbnailProgress.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              this.a.a.post(new ojj(this, paramThumbnailTaskContext, localThumbnailProgress));
              paramThumbnailTaskContext.d += 1;
              obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramThumbnailTaskContext.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramThumbnailTaskContext), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
    }
  }
  
  private void b(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    MediaExtractor localMediaExtractor = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor;
    MediaCodec localMediaCodec = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec;
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
    long[] arrayOfLong1 = paramThumbnailTaskContext.jdField_a_of_type_ArrayOfLong;
    long[] arrayOfLong2 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
    int i1 = paramThumbnailTaskContext.c;
    int i2 = paramThumbnailTaskContext.d;
    long l1 = localMediaExtractor.getSampleTime();
    ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int j = 0;
    int i = 0;
    int k = 0;
    int n;
    int m;
    long l2;
    label237:
    boolean bool;
    for (;;)
    {
      label667:
      label681:
      if ((i == 0) && (i2 < localThumbnailArgs.d))
      {
        if ((paramThumbnailTaskContext.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
        {
          Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
          localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
          paramThumbnailTaskContext.jdField_a_of_type_Long = arrayOfLong1[i2];
          localMediaCodec.flush();
        }
        n = k;
        m = j;
        l2 = l1;
        if (k == 0)
        {
          m = localMediaCodec.dequeueInputBuffer(-1L);
          if (m < 0) {
            break label453;
          }
          n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
          if (n >= 0) {
            break label302;
          }
          localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
          k = 1;
          Log.d("MediaCodecThumbnailGen", "sent input EOS");
          l2 = l1;
          m = j;
          n = k;
        }
        for (;;)
        {
          k = n;
          j = m;
          l1 = l2;
          if (i != 0) {
            break;
          }
          j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
          if (j != -1) {
            break label476;
          }
          Log.d("MediaCodecThumbnailGen", "no output from decoder available");
          k = n;
          j = m;
          l1 = l2;
          break;
          label302:
          if (localMediaExtractor.getSampleTrackIndex() != i1) {
            Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
          }
          localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
          Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
          l1 = localMediaExtractor.getSampleTime();
          Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
          localMediaExtractor.advance();
          j += 1;
          break label237;
          label453:
          Log.d("MediaCodecThumbnailGen", "input buffer not available");
          n = k;
          m = j;
          l2 = l1;
        }
        label476:
        if (j == -3)
        {
          Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
          k = n;
          j = m;
          l1 = l2;
        }
        else if (j == -2)
        {
          MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
          Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
          k = n;
          j = m;
          l1 = l2;
        }
        else if (j < 0)
        {
          Assert.fail("unexpected result from decoder.dequeueOutputBuffer: " + j);
          k = n;
          j = m;
          l1 = l2;
        }
        else
        {
          Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            Log.d("MediaCodecThumbnailGen", "output EOS");
            i = 1;
            if (l2 > arrayOfLong2[i2])
            {
              bool = true;
              localMediaCodec.releaseOutputBuffer(j, bool);
              if (!bool) {
                break label753;
              }
              Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
            }
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
        return;
        bool = false;
        break label681;
      }
      obtainMessage(3, paramThumbnailTaskContext).sendToTarget();
      return;
      label753:
      k = n;
      j = m;
      l1 = l2;
      break;
      break label667;
    }
  }
  
  public String a(int paramInt)
  {
    return String.format(Locale.getDefault(), "thumbnail-%d.jpg", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      a((MediaCodecThumbnailGenerator.ThumbnailArgs)paramMessage.obj);
      continue;
      b((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj);
      continue;
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj, true);
      continue;
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler
 * JD-Core Version:    0.7.0.1
 */