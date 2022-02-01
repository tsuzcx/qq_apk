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
import com.tencent.biz.qqstory.utils.UIUtils;
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
public class bnoc
  extends Handler
{
  public bnoc(bnob parambnob, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(bnod parambnod)
  {
    int i = 0;
    bnog localbnog = new bnog();
    localbnog.jdField_a_of_type_Bnod = parambnod;
    localbnog.jdField_b_of_type_Long = (boaj.a(parambnod.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(parambnod.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception parambnod)
      {
        parambnod = parambnod;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", parambnod);
        if (!(parambnod instanceof IllegalArgumentException)) {
          break label548;
        }
        localbnog.jdField_a_of_type_Int = 100;
        xvv.c("MediaCodecThumbnailGen", "Error when generate thumbnail", parambnod);
        obtainMessage(4, localbnog).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = bnoa.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = parambnod.jdField_b_of_type_Int;
      Object localObject1 = new long[parambnod.d];
      long[] arrayOfLong = new long[parambnod.d];
      while (i < parambnod.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += parambnod.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localbnog.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = parambnod.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        parambnod = new bnoh((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, parambnod.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localbnog.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localbnog.jdField_a_of_type_Bnoh = parambnod;
        localbnog.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localbnog.c = k;
        localbnog.jdField_a_of_type_Int = 0;
        localbnog.d = 0;
        localbnog.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localbnog.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localbnog).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localbnog.jdField_a_of_type_Bnod.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localbnog.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((parambnod instanceof RuntimeException))
          {
            localbnog.jdField_a_of_type_Int = 101;
            continue;
          }
          localbnog.jdField_a_of_type_Int = -1;
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
  
  private void a(bnog parambnog)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (parambnog.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (parambnog.jdField_a_of_type_Bnoh != null)
      {
        parambnog.jdField_a_of_type_Bnoh.a();
        parambnog.jdField_a_of_type_Bnoh = null;
      }
      if (parambnog.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        parambnog.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        parambnog.jdField_a_of_type_AndroidMediaMediaCodec.release();
        parambnog.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (parambnog.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        parambnog.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        parambnog.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      bnof localbnof = new bnof();
      localbnof.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(parambnog.jdField_a_of_type_JavaUtilArrayList);
      localbnof.b = Collections.unmodifiableList(parambnog.jdField_b_of_type_JavaUtilArrayList);
      localbnof.jdField_a_of_type_Int = parambnog.jdField_a_of_type_Int;
      if (bool1) {
        if (parambnog.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localbnof.jdField_a_of_type_Boolean = bool2;
        xvv.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localbnof.jdField_a_of_type_Boolean);
        xwa.a("actBlackThumbnailVideo", localbnof.jdField_a_of_type_Boolean, System.currentTimeMillis() - bnob.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, parambnog, bool1, localbnof));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(bnog parambnog, boolean paramBoolean)
  {
    Object localObject1 = parambnog.jdField_a_of_type_Bnoh;
    bnod localbnod = parambnog.jdField_a_of_type_Bnod;
    int k = parambnog.d;
    ArrayList localArrayList1 = parambnog.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = parambnog.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((bnoh)localObject1).c();
        ((bnoh)localObject1).d();
        ((bnoh)localObject1).a(false);
        bnoe localbnoe = new bnoe();
        localObject1 = ((bnoh)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = parambnog.jdField_b_of_type_Int;
        if ((parambnog.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (parambnog.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = UIUtils.rotateBitmap((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localbnod.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = parambnog.jdField_b_of_type_ArrayOfLong;
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
              localbnoe.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              xvv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localbnoe.jdField_a_of_type_Int = parambnog.d;
              localbnoe.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localbnod.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (parambnog.d == 0)
                {
                  f1 = bnob.a((Bitmap)localObject1);
                  xvv.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localbnoe.jdField_a_of_type_Long = parambnog.jdField_b_of_type_ArrayOfLong[parambnog.d];
                }
              }
              if ((f1 >= 0.9F) && (localbnoe.jdField_a_of_type_Long <= 500000L) && (localbnoe.jdField_a_of_type_Long + 100000L <= parambnog.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localbnoe.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              parambnog.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, parambnog, localbnoe));
              parambnog.d += 1;
              obtainMessage(2, parambnog).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              xvv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = parambnog.d;
          localObject1[i] += 50000L;
          obtainMessage(2, parambnog).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, parambnog), 100L);
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
  
  private void b(bnog parambnog)
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
      MediaExtractor localMediaExtractor = parambnog.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = parambnog.jdField_a_of_type_AndroidMediaMediaCodec;
      bnod localbnod = parambnog.jdField_a_of_type_Bnod;
      long[] arrayOfLong1 = parambnog.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = parambnog.jdField_b_of_type_ArrayOfLong;
      int i1 = parambnog.c;
      i2 = parambnog.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localbnod.d)) {
        break label724;
      }
      if ((parambnog.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        parambnog.jdField_a_of_type_Long = arrayOfLong1[i2];
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
      obtainMessage(4, parambnog).sendToTarget();
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
      bjmd.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
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
            obtainMessage(4, parambnog).sendToTarget();
            return;
          }
          obtainMessage(3, parambnog).sendToTarget();
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
      Object localObject = (bnod)paramMessage.obj;
      xvv.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((bnod)localObject);
      continue;
      localObject = (bnog)paramMessage.obj;
      xvv.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((bnog)localObject);
      continue;
      localObject = (bnog)paramMessage.obj;
      xvv.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((bnog)localObject, false);
      continue;
      localObject = (bnog)paramMessage.obj;
      xvv.c("MediaCodecThumbnailGen", "finishCapture");
      a((bnog)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoc
 * JD-Core Version:    0.7.0.1
 */