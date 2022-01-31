import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleVideoDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleVideoDecoder.EmptyHWDecodeListener;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleVideoDecoder.timeStampPair;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.TrackingDecoderListener;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.TrackingUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class anxn
  implements Runnable
{
  public int a;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private final TrackingDecoderListener jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "SimpleVideoDecoder.DecodeRunnable";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  public final long b;
  private final DecodeConfig jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private volatile boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public anxn(String paramString, Surface paramSurface, TrackingDecoderListener paramTrackingDecoderListener)
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "create DecodeRunnable filePath: " + paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramTrackingDecoderListener != null) {}
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener = paramTrackingDecoderListener;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Long = VideoUtil.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      return;
      paramTrackingDecoderListener = new SimpleVideoDecoder.EmptyHWDecodeListener();
    }
  }
  
  private long a(int paramInt, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    default: 
      return paramLong1 + paramLong2;
    case 1: 
      return paramLong2 / 2L + paramLong1;
    case 2: 
      return 2L * paramLong2 + paramLong1;
    case 3: 
      return (int)((float)paramLong2 / 1.5F) + paramLong1;
    case 4: 
      return 4L * paramLong2 + paramLong1;
    }
    return paramLong1 - paramLong2;
  }
  
  private long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(l2 / 1000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = l2;
    this.jdField_d_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "end seekTo seekTime=" + 0 + " timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
    }
    return l2;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    label262:
    label302:
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        if (this.jdField_a_of_type_AndroidViewSurface == null) {
          this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a();
        }
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
        i = 0;
        if (i >= this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
          break;
        }
        MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
        localObject = localMediaFormat.getString("mime");
        if (!((String)localObject).startsWith("video/")) {
          break label302;
        }
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        localMediaFormat.setInteger("rotation-degrees", this.jdField_a_of_type_Int);
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
          if (this.e)
          {
            if (!SimpleVideoDecoder.a(this.jdField_a_of_type_AndroidMediaMediaCodec.getCodecInfo(), (String)localObject, 2135033992)) {
              break label204;
            }
            localMediaFormat.setInteger("color-format", 2135033992);
          }
          if ((this.e) || ((this.jdField_a_of_type_AndroidViewSurface != null) && (this.jdField_a_of_type_AndroidViewSurface.isValid()))) {
            break label224;
          }
          throw new RuntimeException("surface is not valid.");
        }
        catch (Throwable localThrowable)
        {
          if (!Thread.interrupted()) {
            break label262;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
        }
        return false;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return false;
      }
      label204:
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unable to set decode color format, color format type  not supported");
        continue;
        label224:
        if (this.e)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIOException, null, null, 0);
          break;
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIOException, this.jdField_a_of_type_AndroidViewSurface, null, 0);
        break;
        localObject = new RuntimeException(localIOException);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(1, (Throwable)localObject);
        if (QLog.isColorLevel())
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode configure error", localIOException);
          return false;
          i += 1;
        }
      }
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "output EOS");
        }
        this.jdField_c_of_type_Boolean = true;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
    case -3: 
      while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_a_of_type_Long)
      {
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      }
    }
    label256:
    Object localObject;
    label304:
    label331:
    do
    {
      for (;;)
      {
        return true;
        this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "New format " + this.jdField_a_of_type_AndroidMediaMediaFormat);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
        }
      }
      if ((!paramBoolean) || (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size == 0)) {
        break;
      }
      paramBoolean = true;
      Image localImage = null;
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size > 0) && (this.e))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label555;
        }
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffer(i);
        localImage = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputImage(i);
        if (this.jdField_a_of_type_AndroidMediaMediaFormat == null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label569;
          }
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat(i);
        }
        this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("color-format");
        if ((localImage == null) || (Build.VERSION.SDK_INT < 21)) {
          break label583;
        }
        int j = localImage.getWidth();
        int k = localImage.getHeight();
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_ArrayOfByte = new byte[j * k];
        }
        TrackingUtil.a(localImage, this.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, paramBoolean);
    } while (!paramBoolean);
    for (;;)
    {
      try
      {
        label418:
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label661;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label661;
        }
        localObject = (SimpleVideoDecoder.timeStampPair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (((SimpleVideoDecoder.timeStampPair)localObject).jdField_b_of_type_Long != this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs) {
          break label654;
        }
        l = ((SimpleVideoDecoder.timeStampPair)localObject).jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L, l * 1000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
      }
      break;
      paramBoolean = false;
      break label256;
      label555:
      ByteBuffer localByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers()[i];
      break label304;
      label569:
      this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      break label331;
      label583:
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
      }
      localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
      break label418;
      label654:
      i += 1;
      continue;
      label661:
      long l = -1L;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Can't find video info!");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a();
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        }
        catch (Throwable localThrowable)
        {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
            this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
            this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5) {
              this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
            }
            return true;
          }
          catch (Exception localException)
          {
            RuntimeException localRuntimeException;
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(2, localException);
            SdkContext.a().a().a(this.jdField_a_of_type_JavaLangString, "decode start error2", localException);
          }
          localThrowable = localThrowable;
          if (Thread.interrupted())
          {
            if (QLog.isColorLevel())
            {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
              return false;
            }
          }
          else
          {
            localRuntimeException = new RuntimeException(localThrowable);
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(2, localRuntimeException);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error", localThrowable);
    return false;
    return false;
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      Object localObject;
      int j;
      long l2;
      long l1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffer(i);
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(this.jdField_c_of_type_Long - 1000L, 0);
        }
        j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
        l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
        l1 = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long * 1000L;
        long l3 = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long * 1000L;
        if ((j >= 0) && ((l3 <= 0L) || (l2 <= l3)))
        {
          if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int != 5) {
            break label188;
          }
          if (l1 <= 0L) {
            break label181;
          }
          label141:
          if (l2 >= l1) {
            break label188;
          }
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        return true;
        localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers()[i];
        break;
        label181:
        l1 = 10000L;
        break label141;
        label188:
        l1 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = l2;
        this.jdField_d_of_type_Long = a(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l2 - l1);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        localObject = new SimpleVideoDecoder.timeStampPair(this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "queueSampleToCodec inIndex = " + i);
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    if (!this.jdField_c_of_type_Boolean) {
      a(paramBoolean);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1000L * paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.jdField_b_of_type_Long)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "setPlayRange ignore, startTimeMs=" + paramLong1 + ", videoDuration=" + this.jdField_b_of_type_Long);
      return;
    }
    if (paramLong2 > this.jdField_b_of_type_Long) {
      paramLong2 = this.jdField_b_of_type_Long;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.jdField_b_of_type_Long;
      }
      if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "segment not changed, setPlayRange ignore, startTimeMs=" + paramLong1 + ", endTimeMs=" + l);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int == 5)
      {
        a(l);
        return;
      }
      a(paramLong1);
      return;
    }
  }
  
  public void a(DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.jdField_a_of_type_Int);
    a(paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
    c(paramDecodeConfig.jdField_b_of_type_Boolean);
    b(paramDecodeConfig.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Int = paramDecodeConfig.jdField_b_of_type_Int;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   8: aload_0
    //   9: getfield 110	anxn:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   12: invokevirtual 507	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
    //   15: aload_0
    //   16: invokespecial 509	anxn:a	()Z
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: invokespecial 511	anxn:b	()Z
    //   27: ifeq -5 -> 22
    //   30: invokestatic 418	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   33: invokevirtual 421	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   36: invokeinterface 512 1 0
    //   41: ifeq +42 -> 83
    //   44: invokestatic 418	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/SdkContext;
    //   47: invokevirtual 421	com/tencent/sveffects/SdkContext:a	()Lcom/tencent/sveffects/Logger;
    //   50: aload_0
    //   51: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: new 64	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 514
    //   64: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   70: lload_1
    //   71: lsub
    //   72: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokeinterface 517 3 0
    //   83: invokestatic 253	java/lang/Thread:interrupted	()Z
    //   86: ifne +416 -> 502
    //   89: aload_0
    //   90: getfield 38	anxn:jdField_a_of_type_Boolean	Z
    //   93: ifne +409 -> 502
    //   96: aload_0
    //   97: getfield 110	anxn:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   100: getfield 410	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   103: aload_0
    //   104: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   107: getfield 410	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   110: if_icmpeq +29 -> 139
    //   113: aload_0
    //   114: getfield 110	anxn:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   117: getfield 410	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   120: iconst_5
    //   121: if_icmpne +18 -> 139
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   129: getfield 411	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Long	J
    //   132: ldc2_w 142
    //   135: lmul
    //   136: putfield 153	anxn:jdField_c_of_type_Long	J
    //   139: aload_0
    //   140: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   143: aload_0
    //   144: getfield 110	anxn:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   147: invokevirtual 507	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
    //   150: aload_0
    //   151: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   154: getfield 440	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Long	J
    //   157: ldc2_w 142
    //   160: lmul
    //   161: lstore_1
    //   162: aload_0
    //   163: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   166: getfield 411	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Long	J
    //   169: ldc2_w 142
    //   172: lmul
    //   173: lstore_3
    //   174: aload_0
    //   175: getfield 55	anxn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   178: invokevirtual 519	java/util/concurrent/atomic/AtomicLong:get	()J
    //   181: lstore 5
    //   183: lload 5
    //   185: lconst_0
    //   186: lcmp
    //   187: iflt +24 -> 211
    //   190: lload 5
    //   192: lload_1
    //   193: lcmp
    //   194: iflt +17 -> 211
    //   197: lload 5
    //   199: lload_3
    //   200: lcmp
    //   201: ifgt +10 -> 211
    //   204: aload_0
    //   205: lload 5
    //   207: invokespecial 521	anxn:a	(J)J
    //   210: pop2
    //   211: aload_0
    //   212: getfield 55	anxn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   215: lload 5
    //   217: ldc2_w 49
    //   220: invokevirtual 525	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   223: pop
    //   224: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   227: lstore 5
    //   229: aload_0
    //   230: iconst_1
    //   231: invokespecial 527	anxn:d	(Z)V
    //   234: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +36 -> 273
    //   240: aload_0
    //   241: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: iconst_2
    //   245: new 64	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 514
    //   255: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   261: lload 5
    //   263: lsub
    //   264: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_0
    //   274: getfield 151	anxn:jdField_c_of_type_Boolean	Z
    //   277: ifeq +72 -> 349
    //   280: aload_0
    //   281: getfield 60	anxn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   284: ifnull +10 -> 294
    //   287: aload_0
    //   288: getfield 60	anxn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   291: invokevirtual 530	java/util/ArrayList:clear	()V
    //   294: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +14 -> 311
    //   300: aload_0
    //   301: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: iconst_2
    //   305: ldc_w 532
    //   308: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_0
    //   312: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   315: getfield 498	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_b_of_type_Boolean	Z
    //   318: ifeq +184 -> 502
    //   321: aload_0
    //   322: getfield 112	anxn:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   325: getfield 410	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   328: iconst_5
    //   329: if_icmpne +162 -> 491
    //   332: lload_3
    //   333: lstore_1
    //   334: aload_0
    //   335: lload_1
    //   336: invokespecial 521	anxn:a	(J)J
    //   339: pop2
    //   340: aload_0
    //   341: getfield 94	anxn:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener	Ldov/com/tencent/mobileqq/richmedia/mediacodec/tracker/TrackingDecoderListener;
    //   344: invokeinterface 534 1 0
    //   349: aload_0
    //   350: getfield 536	anxn:jdField_d_of_type_Boolean	Z
    //   353: ifeq -270 -> 83
    //   356: aload_0
    //   357: getfield 62	anxn:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   360: astore 7
    //   362: aload 7
    //   364: monitorenter
    //   365: aload_0
    //   366: getfield 38	anxn:jdField_a_of_type_Boolean	Z
    //   369: ifne +10 -> 379
    //   372: aload_0
    //   373: getfield 62	anxn:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   376: invokevirtual 539	java/lang/Object:wait	()V
    //   379: aload 7
    //   381: monitorexit
    //   382: aload_0
    //   383: invokestatic 44	java/lang/System:currentTimeMillis	()J
    //   386: aload_0
    //   387: getfield 280	anxn:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   390: getfield 297	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   393: ldc2_w 142
    //   396: ldiv
    //   397: lsub
    //   398: putfield 46	anxn:jdField_a_of_type_Long	J
    //   401: goto -318 -> 83
    //   404: astore 7
    //   406: aload 7
    //   408: invokevirtual 303	java/lang/InterruptedException:printStackTrace	()V
    //   411: aload_0
    //   412: iconst_1
    //   413: putfield 38	anxn:jdField_a_of_type_Boolean	Z
    //   416: goto -333 -> 83
    //   419: astore 7
    //   421: invokestatic 253	java/lang/Thread:interrupted	()Z
    //   424: ifeq +24 -> 448
    //   427: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq -196 -> 234
    //   433: aload_0
    //   434: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   437: iconst_2
    //   438: ldc 255
    //   440: aload 7
    //   442: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: goto -211 -> 234
    //   448: new 244	java/lang/RuntimeException
    //   451: dup
    //   452: aload 7
    //   454: invokespecial 270	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   457: astore 8
    //   459: aload_0
    //   460: getfield 94	anxn:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener	Ldov/com/tencent/mobileqq/richmedia/mediacodec/tracker/TrackingDecoderListener;
    //   463: iconst_3
    //   464: aload 8
    //   466: invokeinterface 273 3 0
    //   471: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -452 -> 22
    //   477: aload_0
    //   478: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   481: iconst_2
    //   482: ldc_w 275
    //   485: aload 7
    //   487: invokestatic 258	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: return
    //   491: goto -157 -> 334
    //   494: astore 8
    //   496: aload 7
    //   498: monitorexit
    //   499: aload 8
    //   501: athrow
    //   502: aload_0
    //   503: getfield 125	anxn:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   506: invokevirtual 542	android/media/MediaCodec:stop	()V
    //   509: aload_0
    //   510: getfield 125	anxn:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   513: invokevirtual 545	android/media/MediaCodec:release	()V
    //   516: aload_0
    //   517: getfield 132	anxn:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   520: invokevirtual 546	android/media/MediaExtractor:release	()V
    //   523: aload_0
    //   524: getfield 151	anxn:jdField_c_of_type_Boolean	Z
    //   527: ifeq +56 -> 583
    //   530: aload_0
    //   531: getfield 94	anxn:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener	Ldov/com/tencent/mobileqq/richmedia/mediacodec/tracker/TrackingDecoderListener;
    //   534: invokeinterface 548 1 0
    //   539: return
    //   540: astore 7
    //   542: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq -22 -> 523
    //   548: aload_0
    //   549: getfield 36	anxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   552: iconst_2
    //   553: new 64	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 550
    //   563: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 7
    //   568: invokevirtual 551	java/lang/Exception:toString	()Ljava/lang/String;
    //   571: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 398	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: goto -57 -> 523
    //   583: aload_0
    //   584: getfield 94	anxn:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener	Ldov/com/tencent/mobileqq/richmedia/mediacodec/tracker/TrackingDecoderListener;
    //   587: invokeinterface 553 1 0
    //   592: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	anxn
    //   3	333	1	l1	long
    //   173	160	3	l2	long
    //   181	81	5	l3	long
    //   404	3	7	localInterruptedException	InterruptedException
    //   419	78	7	localThrowable	Throwable
    //   540	27	7	localException	Exception
    //   457	8	8	localRuntimeException	RuntimeException
    //   494	6	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   356	365	404	java/lang/InterruptedException
    //   382	401	404	java/lang/InterruptedException
    //   499	502	404	java/lang/InterruptedException
    //   229	234	419	java/lang/Throwable
    //   365	379	494	finally
    //   379	382	494	finally
    //   496	499	494	finally
    //   502	523	540	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxn
 * JD-Core Version:    0.7.0.1
 */