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
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.1;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.2;
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

@TargetApi(16)
public class bmvh
  extends Handler
{
  public bmvh(bmvg parambmvg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bmvi parambmvi)
  {
    int i = 0;
    bmvl localbmvl = new bmvl();
    localbmvl.jdField_a_of_type_Bmvi = parambmvi;
    localbmvl.jdField_b_of_type_Long = (bnkb.a(parambmvi.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(parambmvi.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception parambmvi)
      {
        parambmvi = parambmvi;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", parambmvi);
        if (!(parambmvi instanceof IllegalArgumentException)) {
          break label548;
        }
        localbmvl.jdField_a_of_type_Int = 100;
        wsv.c("MediaCodecThumbnailGen", "Error when generate thumbnail", parambmvi);
        obtainMessage(4, localbmvl).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = bmvf.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = parambmvi.jdField_b_of_type_Int;
      Object localObject1 = new long[parambmvi.d];
      long[] arrayOfLong = new long[parambmvi.d];
      while (i < parambmvi.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += parambmvi.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localbmvl.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = parambmvi.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        parambmvi = new bmvm((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, parambmvi.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localbmvl.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localbmvl.jdField_a_of_type_Bmvm = parambmvi;
        localbmvl.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localbmvl.c = k;
        localbmvl.jdField_a_of_type_Int = 0;
        localbmvl.d = 0;
        localbmvl.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localbmvl.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localbmvl).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localbmvl.jdField_a_of_type_Bmvi.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localbmvl.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((parambmvi instanceof RuntimeException))
          {
            localbmvl.jdField_a_of_type_Int = 101;
            continue;
          }
          localbmvl.jdField_a_of_type_Int = -1;
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
  
  private void a(bmvl parambmvl)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (parambmvl.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (parambmvl.jdField_a_of_type_Bmvm != null)
      {
        parambmvl.jdField_a_of_type_Bmvm.a();
        parambmvl.jdField_a_of_type_Bmvm = null;
      }
      if (parambmvl.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        parambmvl.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        parambmvl.jdField_a_of_type_AndroidMediaMediaCodec.release();
        parambmvl.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (parambmvl.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        parambmvl.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        parambmvl.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      bmvk localbmvk = new bmvk();
      localbmvk.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(parambmvl.jdField_a_of_type_JavaUtilArrayList);
      localbmvk.b = Collections.unmodifiableList(parambmvl.jdField_b_of_type_JavaUtilArrayList);
      localbmvk.jdField_a_of_type_Int = parambmvl.jdField_a_of_type_Int;
      if (bool1) {
        if (parambmvl.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localbmvk.jdField_a_of_type_Boolean = bool2;
        wsv.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localbmvk.jdField_a_of_type_Boolean);
        wta.a("actBlackThumbnailVideo", localbmvk.jdField_a_of_type_Boolean, System.currentTimeMillis() - bmvg.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parambmvl, bool1, localbmvk));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(bmvl parambmvl, boolean paramBoolean)
  {
    Object localObject1 = parambmvl.jdField_a_of_type_Bmvm;
    bmvi localbmvi = parambmvl.jdField_a_of_type_Bmvi;
    int k = parambmvl.d;
    ArrayList localArrayList1 = parambmvl.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = parambmvl.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((bmvm)localObject1).c();
        ((bmvm)localObject1).d();
        ((bmvm)localObject1).a(false);
        bmvj localbmvj = new bmvj();
        localObject1 = ((bmvm)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = parambmvl.jdField_b_of_type_Int;
        if ((parambmvl.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (parambmvl.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = xod.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localbmvi.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = parambmvl.jdField_b_of_type_ArrayOfLong;
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
              localArrayList1.add(((File)localObject2).getAbsolutePath());
              localbmvj.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              wsv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localbmvj.jdField_a_of_type_Int = parambmvl.d;
              localbmvj.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localbmvi.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (parambmvl.d == 0)
                {
                  f1 = bmvg.a((Bitmap)localObject1);
                  wsv.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localbmvj.jdField_a_of_type_Long = parambmvl.jdField_b_of_type_ArrayOfLong[parambmvl.d];
                }
              }
              if ((f1 >= 0.9F) && (localbmvj.jdField_a_of_type_Long <= 500000L) && (localbmvj.jdField_a_of_type_Long + 100000L <= parambmvl.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localbmvj.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              parambmvl.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parambmvl, localbmvj));
              parambmvl.d += 1;
              obtainMessage(2, parambmvl).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              wsv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = parambmvl.d;
          localObject1[i] += 50000L;
          obtainMessage(2, parambmvl).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, parambmvl), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
      label590:
      continue;
      label593:
      int i = j + 90;
      continue;
      label603:
      continue;
      label606:
      paramBoolean = false;
    }
  }
  
  private void b(bmvl parambmvl)
  {
    MediaCodec localMediaCodec;
    long[] arrayOfLong2;
    int i2;
    long l1;
    MediaCodec.BufferInfo localBufferInfo;
    int j;
    int i;
    int k;
    int m;
    int n;
    long l2;
    try
    {
      MediaExtractor localMediaExtractor = parambmvl.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = parambmvl.jdField_a_of_type_AndroidMediaMediaCodec;
      bmvi localbmvi = parambmvl.jdField_a_of_type_Bmvi;
      long[] arrayOfLong1 = parambmvl.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = parambmvl.jdField_b_of_type_ArrayOfLong;
      int i1 = parambmvl.c;
      i2 = parambmvl.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localbmvi.d)) {
        break label724;
      }
      if ((parambmvl.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        parambmvl.jdField_a_of_type_Long = arrayOfLong1[i2];
        localMediaCodec.flush();
      }
      m = k;
      n = j;
      l2 = l1;
      if (k == 0)
      {
        m = localMediaCodec.dequeueInputBuffer(-1L);
        if (m < 0) {
          break label448;
        }
        n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
        if (n >= 0) {
          break label289;
        }
        localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
        m = 1;
        Log.d("MediaCodecThumbnailGen", "sent input EOS");
        k = j;
        j = m;
        break label729;
      }
      for (;;)
      {
        label246:
        k = m;
        j = n;
        l1 = l2;
        if (i != 0) {
          break;
        }
        j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
        if (j != -1) {
          break label494;
        }
        Log.d("MediaCodecThumbnailGen", "no output from decoder available");
        break label743;
        label289:
        if (localMediaExtractor.getSampleTrackIndex() != i1) {
          Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
        }
        localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
        Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
        l1 = localMediaExtractor.getSampleTime();
        Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
        localMediaExtractor.advance();
        m = j + 1;
        j = k;
        k = m;
        break label729;
        label448:
        Log.d("MediaCodecThumbnailGen", "input buffer not available");
        m = k;
        n = j;
        l2 = l1;
      }
      if (j != -3) {
        break label512;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", localIllegalStateException);
      obtainMessage(4, parambmvl).sendToTarget();
      return;
    }
    label494:
    Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
    break label743;
    label512:
    if (j == -2)
    {
      MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
      Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
    }
    else if (j < 0)
    {
      bhnt.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
    }
    else
    {
      Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
      if ((localBufferInfo.flags & 0x4) != 0)
      {
        Log.d("MediaCodecThumbnailGen", "output EOS");
        i = 1;
        break label757;
      }
    }
    for (;;)
    {
      boolean bool;
      localMediaCodec.releaseOutputBuffer(j, bool);
      if (bool)
      {
        Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
        label724:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            obtainMessage(4, parambmvl).sendToTarget();
            return;
          }
          obtainMessage(3, parambmvl).sendToTarget();
          return;
          break;
        }
        label729:
        m = j;
        n = k;
        l2 = l1;
        break label246;
      }
      label743:
      k = m;
      j = n;
      l1 = l2;
      break;
      label757:
      if (l2 > arrayOfLong2[i2]) {
        bool = true;
      } else {
        bool = false;
      }
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
      Object localObject = (bmvi)paramMessage.obj;
      wsv.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((bmvi)localObject);
      continue;
      localObject = (bmvl)paramMessage.obj;
      wsv.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((bmvl)localObject);
      continue;
      localObject = (bmvl)paramMessage.obj;
      wsv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((bmvl)localObject, false);
      continue;
      localObject = (bmvl)paramMessage.obj;
      wsv.c("MediaCodecThumbnailGen", "finishCapture");
      a((bmvl)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvh
 * JD-Core Version:    0.7.0.1
 */