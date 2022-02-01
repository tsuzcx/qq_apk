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
public class bpqz
  extends Handler
{
  public bpqz(bpqy parambpqy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bpra parambpra)
  {
    int i = 0;
    bprd localbprd = new bprd();
    localbprd.jdField_a_of_type_Bpra = parambpra;
    localbprd.jdField_b_of_type_Long = (bqfh.a(parambpra.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(parambpra.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception parambpra)
      {
        parambpra = parambpra;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", parambpra);
        if (!(parambpra instanceof IllegalArgumentException)) {
          break label548;
        }
        localbprd.jdField_a_of_type_Int = 100;
        yqp.c("MediaCodecThumbnailGen", "Error when generate thumbnail", parambpra);
        obtainMessage(4, localbprd).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = bpqx.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = parambpra.jdField_b_of_type_Int;
      Object localObject1 = new long[parambpra.d];
      long[] arrayOfLong = new long[parambpra.d];
      while (i < parambpra.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += parambpra.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localbprd.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = parambpra.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        parambpra = new bpre((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, parambpra.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localbprd.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localbprd.jdField_a_of_type_Bpre = parambpra;
        localbprd.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localbprd.c = k;
        localbprd.jdField_a_of_type_Int = 0;
        localbprd.d = 0;
        localbprd.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localbprd.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localbprd).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localbprd.jdField_a_of_type_Bpra.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localbprd.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((parambpra instanceof RuntimeException))
          {
            localbprd.jdField_a_of_type_Int = 101;
            continue;
          }
          localbprd.jdField_a_of_type_Int = -1;
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
  
  private void a(bprd parambprd)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (parambprd.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (parambprd.jdField_a_of_type_Bpre != null)
      {
        parambprd.jdField_a_of_type_Bpre.a();
        parambprd.jdField_a_of_type_Bpre = null;
      }
      if (parambprd.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        parambprd.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        parambprd.jdField_a_of_type_AndroidMediaMediaCodec.release();
        parambprd.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (parambprd.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        parambprd.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        parambprd.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      bprc localbprc = new bprc();
      localbprc.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(parambprd.jdField_a_of_type_JavaUtilArrayList);
      localbprc.b = Collections.unmodifiableList(parambprd.jdField_b_of_type_JavaUtilArrayList);
      localbprc.jdField_a_of_type_Int = parambprd.jdField_a_of_type_Int;
      if (bool1) {
        if (parambprd.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localbprc.jdField_a_of_type_Boolean = bool2;
        yqp.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localbprc.jdField_a_of_type_Boolean);
        yqu.a("actBlackThumbnailVideo", localbprc.jdField_a_of_type_Boolean, System.currentTimeMillis() - bpqy.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parambprd, bool1, localbprc));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(bprd parambprd, boolean paramBoolean)
  {
    Object localObject1 = parambprd.jdField_a_of_type_Bpre;
    bpra localbpra = parambprd.jdField_a_of_type_Bpra;
    int k = parambprd.d;
    ArrayList localArrayList1 = parambprd.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = parambprd.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((bpre)localObject1).c();
        ((bpre)localObject1).d();
        ((bpre)localObject1).a(false);
        bprb localbprb = new bprb();
        localObject1 = ((bpre)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = parambprd.jdField_b_of_type_Int;
        if ((parambprd.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (parambprd.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = zlx.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localbpra.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = parambprd.jdField_b_of_type_ArrayOfLong;
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
              localbprb.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              yqp.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localbprb.jdField_a_of_type_Int = parambprd.d;
              localbprb.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localbpra.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (parambprd.d == 0)
                {
                  f1 = bpqy.a((Bitmap)localObject1);
                  yqp.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localbprb.jdField_a_of_type_Long = parambprd.jdField_b_of_type_ArrayOfLong[parambprd.d];
                }
              }
              if ((f1 >= 0.9F) && (localbprb.jdField_a_of_type_Long <= 500000L) && (localbprb.jdField_a_of_type_Long + 100000L <= parambprd.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localbprb.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              parambprd.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parambprd, localbprb));
              parambprd.d += 1;
              obtainMessage(2, parambprd).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              yqp.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = parambprd.d;
          localObject1[i] += 50000L;
          obtainMessage(2, parambprd).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, parambprd), 100L);
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
  
  private void b(bprd parambprd)
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
      MediaExtractor localMediaExtractor = parambprd.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = parambprd.jdField_a_of_type_AndroidMediaMediaCodec;
      bpra localbpra = parambprd.jdField_a_of_type_Bpra;
      long[] arrayOfLong1 = parambprd.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = parambprd.jdField_b_of_type_ArrayOfLong;
      int i1 = parambprd.c;
      i2 = parambprd.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localbpra.d)) {
        break label724;
      }
      if ((parambprd.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        parambprd.jdField_a_of_type_Long = arrayOfLong1[i2];
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
      obtainMessage(4, parambprd).sendToTarget();
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
      bkfk.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
            obtainMessage(4, parambprd).sendToTarget();
            return;
          }
          obtainMessage(3, parambprd).sendToTarget();
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
      Object localObject = (bpra)paramMessage.obj;
      yqp.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((bpra)localObject);
      continue;
      localObject = (bprd)paramMessage.obj;
      yqp.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((bprd)localObject);
      continue;
      localObject = (bprd)paramMessage.obj;
      yqp.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((bprd)localObject, false);
      continue;
      localObject = (bprd)paramMessage.obj;
      yqp.c("MediaCodecThumbnailGen", "finishCapture");
      a((bprd)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqz
 * JD-Core Version:    0.7.0.1
 */