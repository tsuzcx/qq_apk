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
public class bqsu
  extends Handler
{
  public bqsu(bqst parambqst, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bqsv parambqsv)
  {
    int i = 0;
    bqsy localbqsy = new bqsy();
    localbqsy.jdField_a_of_type_Bqsv = parambqsv;
    localbqsy.jdField_b_of_type_Long = (brgs.a(parambqsv.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(parambqsv.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception parambqsv)
      {
        parambqsv = parambqsv;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", parambqsv);
        if (!(parambqsv instanceof IllegalArgumentException)) {
          break label548;
        }
        localbqsy.jdField_a_of_type_Int = 100;
        yuk.c("MediaCodecThumbnailGen", "Error when generate thumbnail", parambqsv);
        obtainMessage(4, localbqsy).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = bqss.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = parambqsv.jdField_b_of_type_Int;
      Object localObject1 = new long[parambqsv.d];
      long[] arrayOfLong = new long[parambqsv.d];
      while (i < parambqsv.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += parambqsv.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localbqsy.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = parambqsv.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        parambqsv = new bqsz((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, parambqsv.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localbqsy.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localbqsy.jdField_a_of_type_Bqsz = parambqsv;
        localbqsy.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localbqsy.c = k;
        localbqsy.jdField_a_of_type_Int = 0;
        localbqsy.d = 0;
        localbqsy.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localbqsy.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localbqsy).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localbqsy.jdField_a_of_type_Bqsv.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localbqsy.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((parambqsv instanceof RuntimeException))
          {
            localbqsy.jdField_a_of_type_Int = 101;
            continue;
          }
          localbqsy.jdField_a_of_type_Int = -1;
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
  
  private void a(bqsy parambqsy)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (parambqsy.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (parambqsy.jdField_a_of_type_Bqsz != null)
      {
        parambqsy.jdField_a_of_type_Bqsz.a();
        parambqsy.jdField_a_of_type_Bqsz = null;
      }
      if (parambqsy.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        parambqsy.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        parambqsy.jdField_a_of_type_AndroidMediaMediaCodec.release();
        parambqsy.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (parambqsy.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        parambqsy.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        parambqsy.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      bqsx localbqsx = new bqsx();
      localbqsx.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(parambqsy.jdField_a_of_type_JavaUtilArrayList);
      localbqsx.b = Collections.unmodifiableList(parambqsy.jdField_b_of_type_JavaUtilArrayList);
      localbqsx.jdField_a_of_type_Int = parambqsy.jdField_a_of_type_Int;
      if (bool1) {
        if (parambqsy.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localbqsx.jdField_a_of_type_Boolean = bool2;
        yuk.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localbqsx.jdField_a_of_type_Boolean);
        yup.a("actBlackThumbnailVideo", localbqsx.jdField_a_of_type_Boolean, System.currentTimeMillis() - bqst.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parambqsy, bool1, localbqsx));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(bqsy parambqsy, boolean paramBoolean)
  {
    Object localObject1 = parambqsy.jdField_a_of_type_Bqsz;
    bqsv localbqsv = parambqsy.jdField_a_of_type_Bqsv;
    int k = parambqsy.d;
    ArrayList localArrayList1 = parambqsy.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = parambqsy.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((bqsz)localObject1).c();
        ((bqsz)localObject1).d();
        ((bqsz)localObject1).a(false);
        bqsw localbqsw = new bqsw();
        localObject1 = ((bqsz)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = parambqsy.jdField_b_of_type_Int;
        if ((parambqsy.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (parambqsy.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = zps.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localbqsv.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = parambqsy.jdField_b_of_type_ArrayOfLong;
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
              localbqsw.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              yuk.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localbqsw.jdField_a_of_type_Int = parambqsy.d;
              localbqsw.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localbqsv.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (parambqsy.d == 0)
                {
                  f1 = bqst.a((Bitmap)localObject1);
                  yuk.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localbqsw.jdField_a_of_type_Long = parambqsy.jdField_b_of_type_ArrayOfLong[parambqsy.d];
                }
              }
              if ((f1 >= 0.9F) && (localbqsw.jdField_a_of_type_Long <= 500000L) && (localbqsw.jdField_a_of_type_Long + 100000L <= parambqsy.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localbqsw.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              parambqsy.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parambqsy, localbqsw));
              parambqsy.d += 1;
              obtainMessage(2, parambqsy).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              yuk.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = parambqsy.d;
          localObject1[i] += 50000L;
          obtainMessage(2, parambqsy).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, parambqsy), 100L);
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
  
  private void b(bqsy parambqsy)
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
      MediaExtractor localMediaExtractor = parambqsy.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = parambqsy.jdField_a_of_type_AndroidMediaMediaCodec;
      bqsv localbqsv = parambqsy.jdField_a_of_type_Bqsv;
      long[] arrayOfLong1 = parambqsy.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = parambqsy.jdField_b_of_type_ArrayOfLong;
      int i1 = parambqsy.c;
      i2 = parambqsy.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localbqsv.d)) {
        break label724;
      }
      if ((parambqsy.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        parambqsy.jdField_a_of_type_Long = arrayOfLong1[i2];
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
      obtainMessage(4, parambqsy).sendToTarget();
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
      blgo.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
            obtainMessage(4, parambqsy).sendToTarget();
            return;
          }
          obtainMessage(3, parambqsy).sendToTarget();
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
      Object localObject = (bqsv)paramMessage.obj;
      yuk.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((bqsv)localObject);
      continue;
      localObject = (bqsy)paramMessage.obj;
      yuk.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((bqsy)localObject);
      continue;
      localObject = (bqsy)paramMessage.obj;
      yuk.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((bqsy)localObject, false);
      continue;
      localObject = (bqsy)paramMessage.obj;
      yuk.c("MediaCodecThumbnailGen", "finishCapture");
      a((bqsy)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqsu
 * JD-Core Version:    0.7.0.1
 */