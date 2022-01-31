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
public class bmzt
  extends Handler
{
  public bmzt(bmzs parambmzs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bmzu parambmzu)
  {
    int i = 0;
    bmzx localbmzx = new bmzx();
    localbmzx.jdField_a_of_type_Bmzu = parambmzu;
    localbmzx.jdField_b_of_type_Long = (bnon.a(parambmzu.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(parambmzu.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception parambmzu)
      {
        parambmzu = parambmzu;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", parambmzu);
        if (!(parambmzu instanceof IllegalArgumentException)) {
          break label548;
        }
        localbmzx.jdField_a_of_type_Int = 100;
        wxe.c("MediaCodecThumbnailGen", "Error when generate thumbnail", parambmzu);
        obtainMessage(4, localbmzx).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = bmzr.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = parambmzu.jdField_b_of_type_Int;
      Object localObject1 = new long[parambmzu.d];
      long[] arrayOfLong = new long[parambmzu.d];
      while (i < parambmzu.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += parambmzu.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localbmzx.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = parambmzu.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        parambmzu = new bmzy((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, parambmzu.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localbmzx.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localbmzx.jdField_a_of_type_Bmzy = parambmzu;
        localbmzx.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localbmzx.c = k;
        localbmzx.jdField_a_of_type_Int = 0;
        localbmzx.d = 0;
        localbmzx.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localbmzx.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localbmzx).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localbmzx.jdField_a_of_type_Bmzu.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localbmzx.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((parambmzu instanceof RuntimeException))
          {
            localbmzx.jdField_a_of_type_Int = 101;
            continue;
          }
          localbmzx.jdField_a_of_type_Int = -1;
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
  
  private void a(bmzx parambmzx)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (parambmzx.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (parambmzx.jdField_a_of_type_Bmzy != null)
      {
        parambmzx.jdField_a_of_type_Bmzy.a();
        parambmzx.jdField_a_of_type_Bmzy = null;
      }
      if (parambmzx.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        parambmzx.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        parambmzx.jdField_a_of_type_AndroidMediaMediaCodec.release();
        parambmzx.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (parambmzx.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        parambmzx.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        parambmzx.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      bmzw localbmzw = new bmzw();
      localbmzw.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(parambmzx.jdField_a_of_type_JavaUtilArrayList);
      localbmzw.b = Collections.unmodifiableList(parambmzx.jdField_b_of_type_JavaUtilArrayList);
      localbmzw.jdField_a_of_type_Int = parambmzx.jdField_a_of_type_Int;
      if (bool1) {
        if (parambmzx.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localbmzw.jdField_a_of_type_Boolean = bool2;
        wxe.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localbmzw.jdField_a_of_type_Boolean);
        wxj.a("actBlackThumbnailVideo", localbmzw.jdField_a_of_type_Boolean, System.currentTimeMillis() - bmzs.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parambmzx, bool1, localbmzw));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(bmzx parambmzx, boolean paramBoolean)
  {
    Object localObject1 = parambmzx.jdField_a_of_type_Bmzy;
    bmzu localbmzu = parambmzx.jdField_a_of_type_Bmzu;
    int k = parambmzx.d;
    ArrayList localArrayList1 = parambmzx.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = parambmzx.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((bmzy)localObject1).c();
        ((bmzy)localObject1).d();
        ((bmzy)localObject1).a(false);
        bmzv localbmzv = new bmzv();
        localObject1 = ((bmzy)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = parambmzx.jdField_b_of_type_Int;
        if ((parambmzx.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (parambmzx.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = xsm.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localbmzu.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = parambmzx.jdField_b_of_type_ArrayOfLong;
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
              localbmzv.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              wxe.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localbmzv.jdField_a_of_type_Int = parambmzx.d;
              localbmzv.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localbmzu.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (parambmzx.d == 0)
                {
                  f1 = bmzs.a((Bitmap)localObject1);
                  wxe.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localbmzv.jdField_a_of_type_Long = parambmzx.jdField_b_of_type_ArrayOfLong[parambmzx.d];
                }
              }
              if ((f1 >= 0.9F) && (localbmzv.jdField_a_of_type_Long <= 500000L) && (localbmzv.jdField_a_of_type_Long + 100000L <= parambmzx.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localbmzv.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              parambmzx.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parambmzx, localbmzv));
              parambmzx.d += 1;
              obtainMessage(2, parambmzx).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              wxe.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = parambmzx.d;
          localObject1[i] += 50000L;
          obtainMessage(2, parambmzx).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, parambmzx), 100L);
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
  
  private void b(bmzx parambmzx)
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
      MediaExtractor localMediaExtractor = parambmzx.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = parambmzx.jdField_a_of_type_AndroidMediaMediaCodec;
      bmzu localbmzu = parambmzx.jdField_a_of_type_Bmzu;
      long[] arrayOfLong1 = parambmzx.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = parambmzx.jdField_b_of_type_ArrayOfLong;
      int i1 = parambmzx.c;
      i2 = parambmzx.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localbmzu.d)) {
        break label724;
      }
      if ((parambmzx.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        parambmzx.jdField_a_of_type_Long = arrayOfLong1[i2];
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
      obtainMessage(4, parambmzx).sendToTarget();
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
      bhsa.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
            obtainMessage(4, parambmzx).sendToTarget();
            return;
          }
          obtainMessage(3, parambmzx).sendToTarget();
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
      Object localObject = (bmzu)paramMessage.obj;
      wxe.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((bmzu)localObject);
      continue;
      localObject = (bmzx)paramMessage.obj;
      wxe.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((bmzx)localObject);
      continue;
      localObject = (bmzx)paramMessage.obj;
      wxe.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((bmzx)localObject, false);
      continue;
      localObject = (bmzx)paramMessage.obj;
      wxe.c("MediaCodecThumbnailGen", "finishCapture");
      a((bmzx)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzt
 * JD-Core Version:    0.7.0.1
 */