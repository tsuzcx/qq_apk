package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTips;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.Frame;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.facedetect.FaceDetector.FACE_DETECT_MODE;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import jkf;
import jkg;
import jkh;

@TargetApi(17)
public class FilterProcessRender
{
  int jdField_a_of_type_Int = -1;
  public long a;
  AVRedPacketManager jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager;
  Beauty20Render jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
  LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
  private final VideoPreviewFaceOutlineDetector jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector = VideoPreviewFaceOutlineDetector.getInstance();
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  List jdField_a_of_type_JavaUtilList;
  private jkh jdField_a_of_type_Jkh = new jkh();
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  float[] jdField_a_of_type_ArrayOfFloat;
  public int[] a;
  int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = true;
  byte[] jdField_b_of_type_ArrayOfByte;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  byte[] jdField_c_of_type_ArrayOfByte;
  private int[] jdField_c_of_type_ArrayOfInt = new int[1];
  int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean;
  byte[] jdField_d_of_type_ArrayOfByte;
  private int[] jdField_d_of_type_ArrayOfInt = new int[1];
  int e;
  public byte[] e;
  int f = -1;
  private int g;
  private int h;
  private int i;
  
  public FilterProcessRender(Context paramContext, EffectPendantTips paramEffectPendantTips, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    VideoModule.init(paramContext);
    this.jdField_a_of_type_Jkh.a = paramEffectPendantTips;
    this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setFaceDetectMode(FaceDetector.FACE_DETECT_MODE.SINGLE);
    VideoPrefsUtil.setMaterialMute(true);
    VideoMaterialUtil.SCALE_FACE_DETECT = 0.25D;
    this.jdField_c_of_type_ArrayOfInt[0] = -1;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.g * this.h / 4 / 4;
    if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length < j))
    {
      this.jdField_c_of_type_ArrayOfByte = new byte[j];
      this.jdField_d_of_type_ArrayOfByte = new byte[j];
      this.jdField_e_of_type_ArrayOfByte = new byte[j << 2];
    }
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != this.h * this.g)) {
      this.jdField_b_of_type_ArrayOfByte = new byte[this.h * this.g];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, 0, this.g * this.h);
    GraphicRenderMgr.getInstance().nativeScalePlane(this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte, this.h, this.g, this.h / 4, this.g / 4);
    GraphicRenderMgr.getInstance().nativeRotatePlane(this.jdField_c_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, this.h / 4, this.g / 4, paramInt * 90);
    paramInt = 0;
    while (paramInt < this.jdField_d_of_type_ArrayOfByte.length)
    {
      j = paramInt << 2;
      this.jdField_e_of_type_ArrayOfByte[j] = this.jdField_d_of_type_ArrayOfByte[paramInt];
      this.jdField_e_of_type_ArrayOfByte[(j + 1)] = this.jdField_d_of_type_ArrayOfByte[paramInt];
      this.jdField_e_of_type_ArrayOfByte[(j + 2)] = this.jdField_d_of_type_ArrayOfByte[paramInt];
      this.jdField_e_of_type_ArrayOfByte[(j + 3)] = -1;
      paramInt += 1;
    }
    if (!this.jdField_d_of_type_Boolean) {
      d();
    }
    if (this.jdField_d_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.doTrack(this.jdField_e_of_type_ArrayOfByte, this.g / 4, this.h / 4);
      paramInt = this.g;
      j = this.h;
      boolean bool = this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.needDetectFace();
      if (bool)
      {
        this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.postJob(new jkf(this, paramInt, j));
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.getAllPoints(0);
        this.jdField_a_of_type_ArrayOfFloat = this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.getFaceAngles(0);
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.getFaceCount();
        if (QLog.isColorLevel())
        {
          long l = System.currentTimeMillis();
          StringBuilder localStringBuilder = new StringBuilder().append("faceDetect, faceCount[").append(this.jdField_c_of_type_Int).append("], needDetectFace[").append(bool).append("], Detect[").append(paramInt).append(" x ").append(j).append("], s_doFaceTime[").append(this.jdField_a_of_type_Long).append("][");
          if (l <= this.jdField_a_of_type_Long) {
            break label530;
          }
          paramArrayOfByte = Long.valueOf(l - this.jdField_a_of_type_Long);
          QLog.w("FilterProcessRender", 1, paramArrayOfByte + "]");
        }
        return this.jdField_c_of_type_Int;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FilterProcessRender", 2, "faceDetect e = " + paramArrayOfByte);
          continue;
          this.jdField_c_of_type_Int = 0;
          continue;
          label530:
          paramArrayOfByte = "small";
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt4, int paramInt5)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt1 * paramInt2 * 3 / 2) || (this.jdField_a_of_type_JavaNioByteBuffer.capacity() < paramInt1 * paramInt2 * 3 / 2)) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramArrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramArrayOfInt[1]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    paramArrayOfByte = TextureProgramFactory.a(1);
    ShaderParameter[] arrayOfShaderParameter = paramArrayOfByte.a();
    GLES20.glUseProgram(paramArrayOfByte.a());
    GLES20.glUniform1f(arrayOfShaderParameter[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniform1f(arrayOfShaderParameter[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOfShaderParameter[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[9].jdField_a_of_type_Int, 1, false, paramArrayOfFloat, 0);
    if (paramInt3 == 17)
    {
      GLES20.glUniform1i(arrayOfShaderParameter[10].jdField_a_of_type_Int, 3);
      GLES20.glUniform1i(arrayOfShaderParameter[11].jdField_a_of_type_Int, 0);
      GLES20.glDisable(3042);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glUniform1i(arrayOfShaderParameter[4].jdField_a_of_type_Int, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramArrayOfInt[1]);
      GLES20.glUniform1i(arrayOfShaderParameter[5].jdField_a_of_type_Int, 1);
      if (paramInt5 % 4 != 1) {
        break label584;
      }
      GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, AVGLUtils.c, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].jdField_a_of_type_Int, 1, false, AVGLUtils.jdField_a_of_type_ArrayOfFloat, 0);
      GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].jdField_a_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].jdField_a_of_type_Int);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(arrayOfShaderParameter[0].jdField_a_of_type_Int);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      GLES20.glUniform1i(arrayOfShaderParameter[10].jdField_a_of_type_Int, 1);
      break;
      label584:
      GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, AVGLUtils.d, 0);
    }
  }
  
  private void d()
  {
    boolean bool2 = false;
    boolean bool3 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
    boolean bool4 = PtvFilterSoLoad.a();
    String str = null;
    if ((bool3) && (bool4))
    {
      YTCommonInterface.initAuth(BaseApplicationImpl.getContext(), "youtusdk_mqq.licence", 0, true);
      str = PtvFilterSoLoad.b(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setModelPath(str);
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + str);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.init();
        this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setRefine(true);
        AVLog.e("FilterProcessRender", "faceDetector init failed " + localException1.getMessage());
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_d_of_type_Boolean = true;
          bool1 = true;
          if (!bool1) {
            AVRedPacketDataCollector.a();
          }
          VideoController.a().k(bool1);
          if ((!this.jdField_d_of_type_Boolean) || (QLog.isColorLevel()))
          {
            if (!TextUtils.isEmpty(str)) {
              bool2 = new File(str).exists();
            }
            QLog.w("FilterProcessRender", 1, "FilterProcessRender, mIsYoutuLibInit[" + this.jdField_d_of_type_Boolean + "], ptuSo[" + bool3 + "], ptuSoVersion[" + bool4 + "], bLoadptuSo[" + bool1 + "], modelPath[" + str + "], exists[" + bool2 + "]");
          }
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool1 = true;
          }
        }
        localException1 = localException1;
        bool1 = false;
      }
      continue;
      boolean bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public int a(boolean paramBoolean)
  {
    int k = 1;
    if (this.f == -1)
    {
      EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
      if ((localEffectFaceDeviceConfig == null) || (!localEffectFaceDeviceConfig.g())) {
        break label53;
      }
    }
    label53:
    for (this.f = 1;; this.f = 0)
    {
      int j = k;
      if (paramBoolean)
      {
        j = k;
        if (this.f != 1) {
          j = 3;
        }
      }
      return j;
    }
  }
  
  FilterProcessRender.RenderResult a(EffectsRenderController.CameraFrame paramCameraFrame, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    a(this.h, this.g, paramInt1);
    a(this.jdField_b_of_type_Int, this.h, this.h, this.jdField_a_of_type_ArrayOfByte);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int);
    FilterProcessRender.RenderResult localRenderResult = null;
    if (!this.jdField_b_of_type_Boolean)
    {
      paramCameraFrame.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      paramCameraFrame.jdField_a_of_type_Int = this.h;
      paramCameraFrame.jdField_b_of_type_Int = this.g;
      paramCameraFrame.jdField_c_of_type_Int = 21;
      paramCameraFrame.jdField_d_of_type_Int = ((paramCameraFrame.jdField_d_of_type_Int - a(paramCameraFrame.jdField_a_of_type_Boolean) - 1 + 4) % 4);
      localRenderResult = new FilterProcessRender.RenderResult(paramCameraFrame, paramArrayOfByte1, paramArrayOfByte2);
    }
    this.jdField_b_of_type_Boolean = false;
    return localRenderResult;
  }
  
  public FilterProcessRender.RenderResult a(EffectsRenderController.TempTime paramTempTime, EffectsRenderController.CameraFrame paramCameraFrame, FilterRender paramFilterRender, VideoFilterList paramVideoFilterList, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, int paramInt)
  {
    int i1 = paramCameraFrame.jdField_a_of_type_Int;
    int i2 = paramCameraFrame.jdField_b_of_type_Int;
    byte[] arrayOfByte = paramCameraFrame.jdField_a_of_type_ArrayOfByte;
    int i3 = a(paramCameraFrame.jdField_a_of_type_Boolean);
    AVLog.c("FilterProcessRender", " showPreview:" + i1 + "|" + i2 + "|" + paramFilterRender + "|" + this.g + "|" + this.h + "|" + paramVideoFilterList + "|" + paramBoolean1);
    if ((this.g == 0) || (this.h == 0) || (arrayOfByte == null)) {
      return null;
    }
    if (this.jdField_a_of_type_Int == -1) {
      a();
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != this.i)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[this.i];
    }
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ArrayOfFloat = null;
    if (paramTempTime.jdField_a_of_type_Boolean) {
      paramTempTime.jdField_a_of_type_Long = AudioHelper.b();
    }
    paramCameraFrame.jdField_a_of_type_ArrayOfByte = a(arrayOfByte, paramFilterRender);
    if ((!EffectBeautyTools.a()) && (paramFilterRender == null) && (paramVideoFilterList == null) && (!paramBoolean2) && (!this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c()) && (!this.jdField_a_of_type_Boolean))
    {
      paramCameraFrame.jdField_a_of_type_Int = this.h;
      paramCameraFrame.jdField_b_of_type_Int = this.g;
      return new FilterProcessRender.RenderResult(paramCameraFrame, null, null);
    }
    if (paramTempTime.jdField_a_of_type_Boolean) {
      paramTempTime.b = AudioHelper.b();
    }
    a(paramCameraFrame);
    jkg localjkg = a(this.jdField_a_of_type_Int, this.jdField_c_of_type_ArrayOfInt[0]);
    localjkg = a(localjkg.jdField_a_of_type_Int, localjkg.jdField_b_of_type_Int, paramCameraFrame.jdField_a_of_type_Boolean);
    GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
    if (paramTempTime.jdField_a_of_type_Boolean) {
      paramTempTime.c = AudioHelper.b();
    }
    localjkg = a(localjkg.jdField_a_of_type_Int, localjkg.jdField_b_of_type_Int, paramFilterRender);
    if (paramTempTime.jdField_a_of_type_Boolean) {
      paramTempTime.d = AudioHelper.b();
    }
    int m;
    if (paramBoolean1)
    {
      paramPendantItem = a(paramVideoFilterList, arrayOfByte, i3, localjkg.jdField_a_of_type_Int, localjkg.jdField_b_of_type_Int, paramPendantItem, paramInt);
      paramFilterRender = a(paramFilterRender, paramPendantItem.jdField_a_of_type_Int, paramPendantItem.jdField_b_of_type_Int);
      m = paramFilterRender.jdField_b_of_type_Int;
    }
    for (int k = paramFilterRender.jdField_a_of_type_Int;; k = paramFilterRender.jdField_a_of_type_Int)
    {
      int j = 0;
      if (paramVideoFilterList != null) {
        j = 1;
      }
      if (paramTempTime.jdField_a_of_type_Boolean) {
        paramTempTime.e = AudioHelper.b();
      }
      int n = j;
      if (paramVideoFilterList == null)
      {
        n = j;
        if (paramBoolean2)
        {
          j = a(arrayOfByte, i3);
          this.jdField_a_of_type_Jkh.a(paramInt, j, this.jdField_c_of_type_Boolean, paramBoolean2, null, null);
          n = 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c())
      {
        if (n == 0) {
          a(arrayOfByte, i3);
        }
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_ArrayOfFloat.length > 0)) {
          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfFloat);
        }
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(m, i1, i2);
      }
      paramFilterRender = null;
      paramVideoFilterList = null;
      if (paramBoolean2)
      {
        paramFilterRender = a(i2, i1);
        paramVideoFilterList = b(i2, i1);
      }
      if (paramTempTime.jdField_a_of_type_Boolean) {
        paramTempTime.f = AudioHelper.b();
      }
      return a(paramCameraFrame, m, k, paramFilterRender, paramVideoFilterList);
      paramFilterRender = a(paramFilterRender, localjkg.jdField_a_of_type_Int, localjkg.jdField_b_of_type_Int);
      paramFilterRender = a(paramVideoFilterList, arrayOfByte, i3, paramFilterRender.jdField_a_of_type_Int, paramFilterRender.jdField_b_of_type_Int, paramPendantItem, paramInt);
      m = paramFilterRender.jdField_b_of_type_Int;
    }
  }
  
  public Beauty20Render a()
  {
    int j = VideoController.a().a().K;
    if (j == 0)
    {
      this.jdField_e_of_type_Int = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = new Beauty20Render(VideoController.a().a());
    }
    if (j == this.jdField_e_of_type_Int) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.setBeautyLevel(j * 1.0F / 100.0F);
    this.jdField_e_of_type_Int = j;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
  }
  
  public BeautyRender a()
  {
    int j = VideoController.a().a().K;
    if (j == 0)
    {
      this.jdField_d_of_type_Int = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(VideoController.a().a(), EffectBeautyTools.jdField_a_of_type_JavaLangString);
    }
    if (j == this.jdField_d_of_type_Int) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(j * 1.0F / 100.0F * EffectBeautyTools.a());
    this.jdField_d_of_type_Int = j;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(LowlightAndDenoiseTools.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().a());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  jkg a(int paramInt1, int paramInt2)
  {
    if (!LowlightAndDenoiseTools.b())
    {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
      return new jkg(this, paramInt1, paramInt2);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
      return new jkg(this, paramInt1, paramInt2);
    }
    Object localObject = a();
    int k = paramInt1;
    int j = paramInt2;
    if (localObject != null)
    {
      localObject = ((DenoiseRender)localObject).process(paramInt2, paramInt1, this.g, this.h);
      j = ((EffectTexture)localObject).getTextureId();
      k = ((EffectTexture)localObject).getFbo();
      this.jdField_a_of_type_ArrayOfInt[3] = 1;
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[5] += 1;
    }
    return new jkg(this, k, j);
  }
  
  jkg a(int paramInt1, int paramInt2, FilterRender paramFilterRender)
  {
    if (!EffectBeautyTools.a()) {
      return new jkg(this, paramInt1, paramInt2);
    }
    if ((paramFilterRender != null) && (paramFilterRender.getFilterType() == 3)) {
      return new jkg(this, paramInt1, paramInt2);
    }
    BeautyRender localBeautyRender = a();
    int k = paramInt1;
    int j = paramInt2;
    if (localBeautyRender != null)
    {
      if ((paramFilterRender == null) || ((paramFilterRender.getFilterType() != 1) && (paramFilterRender.getFilterType() != 2))) {
        break label124;
      }
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      paramFilterRender = localBeautyRender.process(paramInt2, paramInt1, this.g, this.h);
      j = paramFilterRender.getTextureId();
      k = paramFilterRender.getFbo();
      return new jkg(this, k, j);
      label124:
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  jkg a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!LowlightAndDenoiseTools.a())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      return new jkg(this, paramInt1, paramInt2);
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      return new jkg(this, paramInt1, paramInt2);
    }
    Object localObject = a();
    int k = paramInt1;
    int j = paramInt2;
    if (localObject != null)
    {
      localObject = ((LowLightRender)localObject).process(paramInt2, paramInt1, this.g, this.h);
      j = ((EffectTexture)localObject).getTextureId();
      k = ((EffectTexture)localObject).getFbo();
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[2] += 1;
    }
    return new jkg(this, k, j);
  }
  
  jkg a(FilterRender paramFilterRender, int paramInt1, int paramInt2)
  {
    if (paramFilterRender != null)
    {
      paramFilterRender = paramFilterRender.process(paramInt2, paramInt1, this.g, this.h);
      return new jkg(this, paramFilterRender.getFbo(), paramFilterRender.getTextureId());
    }
    return new jkg(this, paramInt1, paramInt2);
  }
  
  jkg a(VideoFilterList paramVideoFilterList, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, PendantItem paramPendantItem, int paramInt4)
  {
    if (this.h * this.g * 3 / 2 != paramArrayOfByte.length)
    {
      AVLog.d("FilterProcessRender", "renderPendant (mHeight * mWidth * 3 / 2) != yuvData.length error");
      return new jkg(this, paramInt2, paramInt3);
    }
    if (!GraphicRenderMgr.soloadedPTV) {
      return new jkg(this, paramInt2, paramInt3);
    }
    if (paramVideoFilterList == null) {
      return new jkg(this, paramInt2, paramInt3);
    }
    boolean bool1 = false;
    boolean bool2 = false;
    String str2 = "";
    String str1 = "";
    if (paramPendantItem != null)
    {
      bool1 = paramPendantItem.hasGesture();
      str2 = paramPendantItem.getGestureType();
      str1 = paramPendantItem.getGestureWording();
      bool2 = paramPendantItem.hasFace();
    }
    a(paramInt3, paramPendantItem, bool1);
    paramInt1 = a(paramArrayOfByte, paramInt1);
    this.jdField_a_of_type_Jkh.a(paramInt4, paramInt1, this.jdField_c_of_type_Boolean, bool2, str1, str2);
    paramVideoFilterList.b(this.g, this.h, 0.25D);
    paramVideoFilterList = paramVideoFilterList.a(paramInt2, paramInt3, this.g, this.h, VideoMaterialUtil.SCALE_FACE_DETECT, this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector, System.currentTimeMillis());
    return new jkg(this, paramVideoFilterList.getFBO(), paramVideoFilterList.getTextureId());
  }
  
  public void a()
  {
    AVLog.c("FilterProcessRender", "initial: " + this.g + "|" + this.h + "|" + this.jdField_c_of_type_ArrayOfInt[0] + "|");
    if (this.jdField_c_of_type_ArrayOfInt[0] != -1) {}
    do
    {
      return;
      GLES20.glGenTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
      GLES20.glGenTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
      GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    } while (this.g == 0);
    int j = this.g;
    int k = this.h;
    this.g = 0;
    this.h = 0;
    a(j, k);
  }
  
  void a(int paramInt)
  {
    GestureMgrRecognize.a().a(Long.valueOf(PtvTemplateManager.h).longValue());
    GestureMgrRecognize.a().b(Integer.valueOf(PtvTemplateManager.g).intValue());
    int j = RetrieveDataManager.DATA_TYPE.RGBA.value;
    j = this.g / 4;
    int k = this.h / 4;
    GestureMgrRecognize.a().a(paramInt, j, k, this.g, this.h);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AVLog.c("FilterProcessRender", "updatePreviewSize: " + paramInt1 + "|" + paramInt2 + "|" + this.g + "|" + this.h);
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.g == paramInt1) && (this.h == paramInt2))) {
      return;
    }
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = (this.g * this.h * 4);
    if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
    }
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    this.jdField_a_of_type_Int = AVGLUtils.a(paramInt1, paramInt2, this.jdField_c_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_Int = AVGLUtils.a(paramInt2, paramInt1, this.jdField_d_of_type_ArrayOfInt[0]);
    e();
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_Int);
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    TextureProgram localTextureProgram = TextureProgramFactory.a(5);
    ShaderParameter[] arrayOfShaderParameter = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20Canvas.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfShaderParameter[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOfShaderParameter[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[1].jdField_a_of_type_Int, 1, false, AVGLUtils.c, 0);
    GLES20.glUniformMatrix4fv(arrayOfShaderParameter[3].jdField_a_of_type_Int, 1, false, AVGLUtils.jdField_a_of_type_ArrayOfFloat, 0);
    GLES20.glVertexAttribPointer(arrayOfShaderParameter[0].jdField_a_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfShaderParameter[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  void a(int paramInt, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        GestureMgrRecognize.a().a();
        this.jdField_c_of_type_Boolean = true;
        GestureFilterManager.jdField_d_of_type_Int = GestureFilterManager.jdField_c_of_type_Int;
      }
      GestureFilterManager.jdField_a_of_type_JavaLangString = paramPendantItem.getGestureType();
      a(paramInt);
      this.jdField_a_of_type_Jkh.a(paramPendantItem.getGestureType());
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      GestureMgrRecognize.a().b();
      this.jdField_c_of_type_Boolean = false;
      GestureFilterManager.jdField_d_of_type_Int = GestureFilterManager.jdField_a_of_type_Int;
    }
    GestureFilterManager.jdField_a_of_type_JavaLangString = "";
  }
  
  void a(EffectsRenderController.CameraFrame paramCameraFrame)
  {
    a(this.h, this.g, AndroidCamera.m, YUVTexture.jdField_a_of_type_ArrayOfFloat, paramCameraFrame.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfInt, this.jdField_a_of_type_Int, a(paramCameraFrame.jdField_a_of_type_Boolean));
    GLES20.glViewport(0, 0, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int);
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        float f1 = 960.0F / paramInt1;
        float f2 = 1280.0F / paramInt2;
        AVLog.c("FilterProcessRender", "getFaceFeature:" + paramInt1 + "|" + paramInt2 + "|" + f1);
        localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 4);
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          short s1 = (short)(int)(localPointF.x * f1);
          short s2 = (short)(int)(localPointF.y * f2);
          ((ByteBuffer)localObject).putShort(s1);
          ((ByteBuffer)localObject).putShort(s2);
          paramInt1 += 1;
        }
        localObject = ((ByteBuffer)localObject).array();
      }
    }
    return localObject;
  }
  
  byte[] a(byte[] paramArrayOfByte, FilterRender paramFilterRender)
  {
    if (EffectBeautyTools.a()) {}
    while ((paramFilterRender != null) && (paramFilterRender.getFilterType() == 3)) {
      return paramArrayOfByte;
    }
    if (this.h * this.g * 3 / 2 != paramArrayOfByte.length)
    {
      AVLog.e("FilterProcessRender", "(mHeight * mWidth * 3 / 2) != yuvData.length");
      return paramArrayOfByte;
    }
    paramFilterRender = a();
    EffectFrame localEffectFrame1;
    if (paramFilterRender != null)
    {
      localEffectFrame1 = new EffectFrame();
      localEffectFrame1.frameData = paramArrayOfByte;
      localEffectFrame1.frameWidth = this.h;
      localEffectFrame1.frameHeight = this.g;
      if (AndroidCamera.m == 17)
      {
        paramArrayOfByte = ColorFormat.NV21;
        localEffectFrame1.frameFormat = paramArrayOfByte;
        EffectFrame localEffectFrame2 = paramFilterRender.processData(localEffectFrame1);
        paramFilterRender = localEffectFrame2.frameData;
        paramArrayOfByte = paramFilterRender;
        if (localEffectFrame2.frameFormat != ColorFormat.I420) {}
      }
    }
    for (;;)
    {
      try
      {
        if (AndroidCamera.m == 17)
        {
          paramArrayOfByte = BeautyNative.convertI420ToNV21(paramFilterRender, this.h, this.g);
          return paramArrayOfByte;
          paramArrayOfByte = ColorFormat.NV12;
          break;
        }
        paramArrayOfByte = BeautyNative.convertI420ToNV12(paramFilterRender, this.h, this.g);
      }
      catch (Throwable paramArrayOfByte)
      {
        AVLog.e("FilterProcessRender", "convertI420ToNV21 or convertI420ToNV12 e = " + paramArrayOfByte.getMessage());
        paramArrayOfByte = localEffectFrame1.frameData;
      }
    }
  }
  
  public int b()
  {
    return this.h;
  }
  
  void b()
  {
    this.jdField_a_of_type_Jkh.a();
    if (this.jdField_c_of_type_Boolean)
    {
      GestureMgrRecognize.a().b();
      this.jdField_c_of_type_Boolean = false;
    }
    GestureFilterManager.jdField_d_of_type_Int = GestureFilterManager.jdField_a_of_type_Int;
    GestureFilterManager.jdField_a_of_type_JavaLangString = "";
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(0);
      for (;;)
      {
        VideoController.a().a().K = paramInt;
        return;
        if (!EffectBeautyTools.a()) {
          break;
        }
        GraphicRenderMgr.getInstance().setBeautyFlag(2);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        AVLog.c("FilterProcessRender", "BeautyToolbar UnsatisfiedLinkError! libqav_graphics.so no impl");
        continue;
        GraphicRenderMgr.getInstance().setBeautyFlag(1);
      }
    }
  }
  
  byte[] b(int paramInt1, int paramInt2)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = localPointF;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        float f1 = 9.6E+008F / paramInt1;
        float f2 = 1.28E+009F / paramInt2;
        AVLog.c("FilterProcessRender", "getFaceFeature2:" + paramInt1 + "|" + paramInt2 + "|" + f1);
        localObject = ByteBuffer.allocate(this.jdField_a_of_type_JavaUtilList.size() * 8);
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localPointF = (PointF)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          paramInt2 = (int)(localPointF.x * f1);
          int j = (int)(localPointF.y * f2);
          ((ByteBuffer)localObject).putInt(paramInt2);
          ((ByteBuffer)localObject).putInt(j);
          paramInt1 += 1;
        }
        localObject = ((ByteBuffer)localObject).array();
      }
    }
    return localObject;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.jdField_b_of_type_Int, this.jdField_a_of_type_Int }, 0);
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
    }
    if (this.jdField_c_of_type_ArrayOfInt[0] != -1)
    {
      GLES20.glDeleteTextures(this.jdField_c_of_type_ArrayOfInt.length, this.jdField_c_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
      GLES20.glDeleteTextures(this.jdField_d_of_type_ArrayOfInt.length, this.jdField_d_of_type_ArrayOfInt, 0);
      this.jdField_b_of_type_ArrayOfInt[0] = -1;
      this.jdField_b_of_type_ArrayOfInt[1] = -1;
      this.jdField_c_of_type_ArrayOfInt[0] = -1;
      this.jdField_d_of_type_ArrayOfInt[0] = -1;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
    }
    GestureMgrRecognize.a().b();
    this.jdField_c_of_type_Boolean = false;
    GestureFilterManager.jdField_d_of_type_Int = GestureFilterManager.jdField_a_of_type_Int;
    GestureFilterManager.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Jkh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */