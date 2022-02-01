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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
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
  implements AVGameMediaPlayerWrapper.OnAVGameMediaPlayerCallBack, IAVGameMediaPlayerCtrl
{
  private RGBToI420Filter jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
  private RecordParam jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  protected AVGameMediaPlayerWrapper a;
  private AVGameMediaPlayerCtrl.CustomHandler jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
  private AVGameVideoPreLoadMgr jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr;
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private volatile Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  private CopyOnWriteArrayList<WeakReference<IAVGameMediaPlayerCtrl.PushDecodeMsg>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
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
    Integer localInteger = this.jdField_a_of_type_JavaLangInteger;
    if ((localInteger != null) && (paramInt1 == localInteger.intValue()) && (paramInt2 == this.jdField_b_of_type_JavaLangInteger.intValue()))
    {
      paramInt1 = 0;
    }
    else
    {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
      paramInt1 = 1;
    }
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
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), paramLong);
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 15);
    }
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong)
  {
    paramSurfaceTexture = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if ((paramSurfaceTexture != null) && (paramSurfaceTexture.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a() == -1) {
        return;
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = new EglHandlerThread("eglHandelr_thread", null);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.start();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler = new AVGameMediaPlayerCtrl.CustomHandler(this, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.getLooper());
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
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    localObject = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null)
    {
      ((RenderBuffer)localObject).destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter;
    if (localObject != null)
    {
      ((RGBToI420Filter)localObject).c();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRGBToI420Filter = null;
    }
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public long a()
  {
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (localAVGameMediaPlayerWrapper != null) {
      return localAVGameMediaPlayerWrapper.a();
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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (localObject != null) {
      ((AVGameMediaPlayerWrapper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (localObject != null) {
      ((AVGameMediaPlayerCtrl.CustomHandler)localObject).sendEmptyMessage(258);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramInt3 * 1.0F / paramInt2);
  }
  
  public void a(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
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
    if (!this.c) {
      return;
    }
    i();
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramTPAudioFrameBuffer.getChannelLayout() == 3L)
      {
        int n = paramTPAudioFrameBuffer.getSize()[0] / 2;
        byte[] arrayOfByte1 = new byte[n];
        int k = 0;
        int m = 0;
        while (k < n)
        {
          byte[] arrayOfByte2 = paramTPAudioFrameBuffer.data[0];
          int i4 = k * 2;
          int i2 = (short)arrayOfByte2[i4];
          int i1 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 1)];
          int i3 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 2)];
          i4 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 3)];
          i2 = (i2 + i3) / 2;
          i1 = (i1 + i4) / 2;
          i3 = m + 1;
          int j = -128;
          int i;
          if (i2 > 127) {
            i = 127;
          } else if (i2 < -128) {
            i = -128;
          } else {
            i = (byte)i2;
          }
          arrayOfByte1[m] = i;
          m = i3 + 1;
          if (i1 > 127) {
            i = 127;
          } else if (i1 < -128) {
            i = j;
          } else {
            i = (byte)i1;
          }
          arrayOfByte1[i3] = i;
          k += 2;
        }
        if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F)) {
          AudioProcess.a(arrayOfByte1, this.jdField_a_of_type_JavaLangFloat.floatValue());
        }
        AudioProcess.a(arrayOfByte1, arrayOfByte1.length);
        return;
      }
      if (paramTPAudioFrameBuffer.getChannelLayout() == 4L)
      {
        if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F)) {
          AudioProcess.a(paramTPAudioFrameBuffer.data[0], this.jdField_a_of_type_JavaLangFloat.floatValue());
        }
        AudioProcess.a(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
      }
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playAudioByURL");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(this.jdField_a_of_type_JavaLangString);
    paramString = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (paramString != null) {
      paramString.a(this.jdField_a_of_type_JavaLangString, paramLong);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(3);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playVideoByURl hasAVRoom:=");
    localStringBuilder.append(paramBoolean);
    QLog.d("AVGameMediaPlayerCtrl", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean))
    {
      if (!this.jdField_b_of_type_Boolean) {
        if (paramBoolean) {
          AVGameBusinessCtrl.b().b(true);
        } else {
          AVGameBusinessCtrl.b().a(true);
        }
      }
      this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(this.jdField_a_of_type_JavaLangString);
      paramString = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
      if (paramString != null) {
        paramString.b(this.jdField_a_of_type_JavaLangString, paramLong);
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a(3);
    }
  }
  
  public void a(List<AVGameMediaFileInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPreLoadVideoResourceInfos infoList:=");
    ((StringBuilder)localObject).append(Arrays.toString(paramList.toArray()));
    QLog.d("AVGameMediaPlayerCtrl", 1, ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (AVGameMediaFileInfo)paramList.next();
      this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a(((AVGameMediaFileInfo)localObject).jdField_a_of_type_JavaLangString, ((AVGameMediaFileInfo)localObject).jdField_a_of_type_Long, 3000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool3 = this.jdField_b_of_type_Boolean;
    boolean bool1 = false;
    boolean bool2 = false;
    if (bool3)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper.a()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (localAVGameMediaPlayerWrapper != null) {
      bool1 = localAVGameMediaPlayerWrapper.a();
    }
    return bool1;
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoPlay");
    AVGameMediaPlayerWrapper localAVGameMediaPlayerWrapper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (localAVGameMediaPlayerWrapper != null) {
      localAVGameMediaPlayerWrapper.b();
    }
  }
  
  public void b(IAVGameMediaPlayerCtrl.PushDecodeMsg paramPushDecodeMsg)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    label11:
    WeakReference localWeakReference;
    for (Object localObject = null; localIterator.hasNext(); localObject = localWeakReference)
    {
      localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference == null) || (paramPushDecodeMsg != localWeakReference.get())) {
        break label11;
      }
    }
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).b(paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (localCustomHandler == null) {
      return;
    }
    localCustomHandler.post(new AVGameMediaPlayerCtrl.1(this, paramBoolean));
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoSend");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      AVGameBusinessCtrl.b().b(false);
    }
  }
  
  public void c(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B1F3", "0X800B1F3", 0, 0, "", "", "", "");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).c(paramString);
      }
    }
  }
  
  public void d()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopNoAVRoomVideoSend");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      AVGameBusinessCtrl.b().a(false);
    }
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IAVGameMediaPlayerCtrl.PushDecodeMsg)localWeakReference.get()).d(paramString);
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
    AVGameMediaPlayerCtrl.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
    if (localCustomHandler != null) {
      localCustomHandler.sendEmptyMessage(258);
    }
  }
  
  public void h()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInit");
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaPlayerWrapper;
    if (localObject != null) {
      ((AVGameMediaPlayerWrapper)localObject).c();
    }
    this.jdField_a_of_type_ComTencentAvgameQavAVGameVideoPreLoadMgr.a();
    c();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameQavAVGameMediaPlayerCtrl$CustomHandler;
      if (localObject != null) {
        ((AVGameMediaPlayerCtrl.CustomHandler)localObject).sendEmptyMessage(153);
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = null;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaLangFloat != null) {
      return;
    }
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = ((AudioManager)localObject).getStreamVolume(0);
    int j = ((AudioManager)localObject).getStreamMaxVolume(0);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(i * 1.0F / j);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init scaleFacors:=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangFloat);
    AVLog.d("AVGameMediaPlayerCtrl", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaPlayerCtrl
 * JD-Core Version:    0.7.0.1
 */