package com.tencent.avgame.qav;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.opengl.effects.RGBToI420Filter;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class AVGameMediaPlayerCtrl
  implements AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack
{
  private RGBToI420Filter jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
  private RecordParam jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  protected AVGameMediaPlayerWrapper a;
  private AVGameMediaPlayerCtrl.CustomHandler jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
  private AVGameVideoPreLoadMgr jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private volatile Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  private CopyOnWriteArrayList<WeakReference<AVGameMediaPlayerCtrl.PushDecodeMsg>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  private Integer jdField_b_of_type_JavaLangInteger;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private boolean c = true;
  private volatile boolean d = true;
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangInteger == null) || (paramInt1 != this.jdField_a_of_type_JavaLangInteger.intValue()) || (paramInt2 != this.jdField_b_of_type_JavaLangInteger.intValue()))
    {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        l();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 33984);
        Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
        Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      }
      if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 33985);
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2);
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2];
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter == null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = new RGBToI420Filter();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.b();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.a(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    a(paramInt1 / 16 * 16, paramInt2 / 8 * 8);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a(), this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
    GLES20.glReadPixels(0, 0, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 8, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2);
    this.jdField_a_of_type_JavaNioByteBuffer.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), paramLong);
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 15);
    }
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a() == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a() == -1)) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a().updateTexImage();
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a().getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        if (this.d)
        {
          a(paramInt1, paramInt2, paramLong);
          return;
        }
      }
      catch (Throwable paramSurfaceTexture)
      {
        QLog.d("AVGameMediaPlayerCtrl", 1, "onFrameAvailable", paramSurfaceTexture);
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("eglHandelr_thread", null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler = new AVGameMediaPlayerCtrl.CustomHandler(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.getLooper());
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.sendEmptyMessage(152);
    }
  }
  
  private void k()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "initEgl");
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a(this, this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler);
  }
  
  private void l()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInitEgl");
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter.c();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
    }
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a();
    }
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "relasePlayVideo");
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a();
    }
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler != null) {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.sendEmptyMessage(258);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramInt3 * 1.0F / paramInt2);
  }
  
  public void a(AVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramPushDecodeMsg == localWeakReference.get())) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramPushDecodeMsg));
  }
  
  public void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (!this.c) {}
    label150:
    label205:
    do
    {
      do
      {
        return;
        i();
      } while (Build.VERSION.SDK_INT < 16);
      if (paramTPAudioFrameBuffer.getChannelLayout() == 3L)
      {
        int m = paramTPAudioFrameBuffer.getSize()[0] / 2;
        byte[] arrayOfByte = new byte[m];
        int j = 0;
        int k = 0;
        if (j < m)
        {
          int i2 = (short)paramTPAudioFrameBuffer.data[0][(j * 2)];
          int n = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 1)];
          int i3 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 2)];
          int i1 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 3)];
          i2 = (i2 + i3) / 2;
          n = (n + i1) / 2;
          i1 = k + 1;
          int i;
          if (i2 > 127)
          {
            i = 127;
            arrayOfByte[k] = i;
            k = i1 + 1;
            if (n <= 127) {
              break label205;
            }
            i = 127;
          }
          for (;;)
          {
            arrayOfByte[i1] = i;
            j += 2;
            break;
            if (i2 < -128)
            {
              i = -128;
              break label150;
            }
            i = (byte)i2;
            break label150;
            if (n < -128) {
              i = -128;
            } else {
              i = (byte)n;
            }
          }
        }
        if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F))
        {
          AudioProcess.a();
          AudioProcess.a(arrayOfByte, this.jdField_a_of_type_JavaLangFloat.floatValue());
        }
        AudioProcess.a().a(arrayOfByte, arrayOfByte.length);
        return;
      }
    } while (paramTPAudioFrameBuffer.getChannelLayout() != 4L);
    if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F))
    {
      AudioProcess.a();
      AudioProcess.a(paramTPAudioFrameBuffer.data[0], this.jdField_a_of_type_JavaLangFloat.floatValue());
    }
    AudioProcess.a().a(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playAudioByURL");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a(this.jdField_a_of_type_JavaLangString, paramLong);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a().a(3);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playVideoByURl hasAVRoom:=" + paramBoolean);
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      if (Build.VERSION.SDK_INT >= 16) {
        AudioProcess.a().a(3);
      }
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (!paramBoolean) {
        break label115;
      }
      AVGameBusinessCtrl.b().b(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.b(this.jdField_a_of_type_JavaLangString, paramLong);
      break;
      label115:
      AVGameBusinessCtrl.b().a(true);
    }
  }
  
  public void a(List<AVGameMediaFileInfo> paramList)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "setPreLoadVideoResourceInfos infoList:=" + Arrays.toString(paramList.toArray()));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AVGameMediaFileInfo localAVGameMediaFileInfo = (AVGameMediaFileInfo)paramList.next();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(localAVGameMediaFileInfo.jdField_a_of_type_JavaLangString, localAVGameMediaFileInfo.jdField_a_of_type_Long, 3000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a()) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper == null);
    return this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a();
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoPlay");
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.b();
    }
  }
  
  public void b(AVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference == null) || (paramPushDecodeMsg != localWeakReference.get())) {
        break label63;
      }
      localObject = localWeakReference;
    }
    label63:
    for (;;)
    {
      break;
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).b(paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.post(new AVGameMediaPlayerCtrl.1(this, paramBoolean));
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoSend");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    AVGameBusinessCtrl.b().b(false);
  }
  
  public void c(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B1F3", "0X800B1F3", 0, 0, "", "", "", "");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).c(paramString);
      }
    }
  }
  
  public void d()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopNoAVRoomVideoSend");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    AVGameBusinessCtrl.b().a(false);
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((AVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).d(paramString);
      }
    }
  }
  
  public void e()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "init");
    this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr = new AVGameVideoPreLoadMgr();
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper = new AVGameMediaPlayerWrapper();
    j();
  }
  
  public void f()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnResume");
    this.d = true;
  }
  
  public void g()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnStop");
    this.d = false;
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler != null) {
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.sendEmptyMessage(258);
    }
  }
  
  public void h()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInit");
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.c();
    }
    this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a();
    c();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread != null)
    {
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler != null) {
        this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler.sendEmptyMessage(153);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = null;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaLangFloat != null) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = localAudioManager.getStreamVolume(0);
    int j = localAudioManager.getStreamMaxVolume(0);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(i * 1.0F / j);
    AVLog.d("AVGameMediaPlayerCtrl", "init scaleFacors:=" + this.jdField_a_of_type_JavaLangFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaPlayerCtrl
 * JD-Core Version:    0.7.0.1
 */