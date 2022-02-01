package com.tencent.aelight.camera.ae.camera.core;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView.AEEditMaterialSelectedListener;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.perf.IAEFpsManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoVoiceRecognizer;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import mqq.os.MqqHandler;
import org.light.LightAsset;

class AECameraGLSurfaceView$17
  implements Runnable
{
  AECameraGLSurfaceView$17(AECameraGLSurfaceView paramAECameraGLSurfaceView, String paramString) {}
  
  public void run()
  {
    if (Looper.myLooper() == null)
    {
      AEQLog.d("AECameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
      Looper.prepare();
    }
    boolean bool4 = this.this$0.isRecording();
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    if ((!bool4) && (AECameraGLSurfaceView.access$1500(this.this$0)))
    {
      Object localObject2 = this.val$path;
      AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)AECameraGLSurfaceView.access$000(this.this$0);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        AECameraGLSurfaceView.access$1800(this.this$0).a(null);
        localAEFilterProcessTex.a = true;
        this.this$0.onSelectFaceEffect(null);
        AECameraGLSurfaceView.access$1902(this.this$0, false);
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.1(this, localAEFilterProcessTex));
        AECameraGLSurfaceView.access$2000(this.this$0, localAEFilterProcessTex);
        AECameraGLSurfaceView.access$2100(this.this$0).a();
        AECameraGLSurfaceView.access$502(this.this$0, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[setMaterial] materialPath:");
        ((StringBuilder)localObject1).append((String)localObject2);
        AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = localObject2;
      if (!new File((String)localObject2).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("Android");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!new File((String)localObject1).exists())
      {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.2(this, localAEFilterProcessTex));
        AEQLog.d("AECameraGLSurfaceView", "[setMaterial] materialPath not exist");
        return;
      }
      localObject1 = VideoMaterial.loadLightAsset(this.val$path);
      if (localObject1 == null)
      {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.3(this, localAEFilterProcessTex));
        AEQLog.d("AECameraGLSurfaceView", "[setMaterial] videoMaterial null");
        return;
      }
      AECameraGLSurfaceView.access$1800(this.this$0).a((VideoMaterial)localObject1);
      if (AEMaterialManager.a((VideoMaterial)localObject1))
      {
        AEQLog.a("PreCheckAERes", "[setMaterial] set special template");
        if (AEResUtil.a(AEResInfo.LIGHT_RES_BASE_PACKAGE))
        {
          AEQLog.a("PreCheckAERes", "[setMaterial] version check success");
          if (FeatureManager.ensureMaterialSoLoaded((VideoMaterial)localObject1))
          {
            AEQLog.a("PreCheckAERes", "[setMaterial] so load success");
            long l = AEResUtil.a((VideoMaterial)localObject1);
            if (l != 0L)
            {
              AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus not ready, go fetch bundles ...");
              AECameraGLSurfaceView.access$700(this.this$0, HardCodeUtil.a(2131689762));
              AEResUtil.a(this.this$0.getContext(), l);
              return;
            }
            AEQLog.a("PreCheckAERes", "[setMaterial] bundleStatus ready, apply material...");
          }
          else
          {
            AEQLog.d("PreCheckAERes", "[setMaterial] so load failed");
          }
        }
        else
        {
          AEQLog.d("PreCheckAERes", "[setMaterial] version check failed");
        }
      }
      else
      {
        AEQLog.b("AECameraGLSurfaceView", "not special material.");
      }
      if ((((VideoMaterial)localObject1).isWatermarkMaterial()) && (!AECameraGLSurfaceView.access$2200(this.this$0))) {
        if (!AECameraGLSurfaceView.access$2300(this.this$0))
        {
          if (AECameraGLSurfaceView.access$1600(this.this$0))
          {
            AECameraGLSurfaceView.access$2402(this.this$0, true);
            AEQLog.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true, but is paused, skip");
          }
          else
          {
            AECameraGLSurfaceView.access$2402(this.this$0, false);
            AECameraGLSurfaceView.access$2302(this.this$0, true);
            AEQLog.b("AECameraGLSurfaceView", "updateWMProps requestLocationPermission true");
            ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.17.4(this));
          }
        }
        else if (AECameraGLSurfaceView.access$2600(this.this$0)) {
          ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.17.5(this));
        }
      }
      localObject2 = AEMaterialManager.b();
      StringBuilder localStringBuilder;
      if (localObject2 != null)
      {
        bool1 = ((VideoMaterial)localObject1).isEditableWatermark();
        ((AEMaterialMetaData)localObject2).a = bool1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("editable id: ");
        localStringBuilder.append(((AEMaterialMetaData)localObject2).k);
        localStringBuilder.append(" enable: ");
        localStringBuilder.append(bool1);
        AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
      }
      if (AEMaterialManager.a() != null)
      {
        localObject2 = AEMaterialManager.a();
        bool1 = ((VideoMaterial)localObject1).isEditableWatermark();
        ((AEMaterialMetaData)localObject2).a = bool1;
        if (AECameraGLSurfaceView.access$2800(this.this$0) != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("editable id: ");
          localStringBuilder.append(((AEMaterialMetaData)localObject2).k);
          localStringBuilder.append(" enable: ");
          localStringBuilder.append(bool1);
          AEQLog.b("AECameraGLSurfaceView", localStringBuilder.toString());
          AECameraGLSurfaceView.access$2800(this.this$0).a(bool1);
        }
      }
      if ((this.this$0.mAudioChangeCapture != null) && (((VideoMaterial)localObject1).getLightAsset() != null))
      {
        this.this$0.mAudioChangeCapture.a(((VideoMaterial)localObject1).needVoiceChange(), ((VideoMaterial)localObject1).getLightAsset().getVoiceKind(), ((VideoMaterial)localObject1).getLightAsset().getVoiceEnvironment());
        if ((AECameraGLSurfaceView.access$2900(this.this$0)) && (!((VideoMaterial)localObject1).needVoiceChange()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AECameraGLSurfaceView.access$900(this.this$0).a);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          ((StringBuilder)localObject2).append(".aac");
          localObject2 = ((StringBuilder)localObject2).toString();
          this.this$0.audioCapture.a(true, (String)localObject2);
          this.this$0.mAudioChangeCapture.a(false, null);
        }
        else if ((AECameraGLSurfaceView.access$2900(this.this$0)) && (((VideoMaterial)localObject1).needVoiceChange()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AECameraGLSurfaceView.access$900(this.this$0).a);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          ((StringBuilder)localObject2).append(".aac");
          localObject2 = ((StringBuilder)localObject2).toString();
          this.this$0.audioCapture.a(false, null);
          this.this$0.mAudioChangeCapture.a(true, (String)localObject2);
        }
        else
        {
          this.this$0.mAudioChangeCapture.a(false, null);
        }
      }
      if (((VideoMaterial)localObject1).isAudio2textMaterial()) {
        AECameraGLSurfaceView.access$2100(this.this$0).a(this.this$0.getContext(), this.this$0.audioCapture);
      } else {
        AECameraGLSurfaceView.access$2100(this.this$0).a();
      }
      if ((((VideoMaterial)localObject1).getLightAsset() != null) && (((VideoMaterial)localObject1).getLightAsset().needVoiceDecibel())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.this$0.audioCapture.c(bool1);
      if ((bool1) && (!((VideoMaterial)localObject1).isAudio2textMaterial())) {
        this.this$0.audioCapture.e();
      }
      AECameraGLSurfaceView.access$1902(this.this$0, ((VideoMaterial)localObject1).needFaceInfo());
      this.this$0.onSelectFaceEffect((VideoMaterial)localObject1);
      AECameraGLSurfaceView.access$2000(this.this$0, localAEFilterProcessTex);
      bool1 = bool3;
      if (((VideoMaterial)localObject1).isEditableWatermark())
      {
        bool1 = bool2;
        if (AECameraGLSurfaceView.access$500(this.this$0) != null) {
          if (!AECameraGLSurfaceView.access$500(this.this$0).getId().equals(((VideoMaterial)localObject1).getId())) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[setMaterial] isWatermarkEditable case, applyMaterial=");
        ((StringBuilder)localObject2).append(bool1);
        AEQLog.b("AECameraGLSurfaceView", ((StringBuilder)localObject2).toString());
      }
      AECameraGLSurfaceView.access$502(this.this$0, (VideoMaterial)localObject1);
      if (bool1) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.6(this, (VideoMaterial)localObject1, localAEFilterProcessTex));
      }
      if (AECameraGLSurfaceView.access$2200(this.this$0)) {
        this.this$0.queueEvent(new AECameraGLSurfaceView.17.7(this, localAEFilterProcessTex));
      }
      if ((AEDashboardUtil.a()) && (!TextUtils.isEmpty(this.val$path))) {
        AEDashboardUtil.a(this.this$0.debugInfoCallback, 1500L);
      }
      return;
    }
    if (!FeatureManager.Features.LIGHT_SDK.isFunctionReady()) {
      bool1 = FeatureManager.Features.LIGHT_SDK.init();
    }
    if ((AECameraGLSurfaceView.access$1600(this.this$0)) && (bool1)) {
      AEFilterProcessTex.a(AECameraGLSurfaceView.access$1700(this.this$0), VideoSDKMaterialParser.parseVideoMaterial(this.val$path, "params"));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[setMaterial]isRecording");
    ((StringBuilder)localObject1).append(this.this$0.isRecording());
    AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[setMaterial]isAEKitAvailable");
    ((StringBuilder)localObject1).append(AECameraGLSurfaceView.access$1500(this.this$0));
    AEQLog.d("AECameraGLSurfaceView", ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.17
 * JD-Core Version:    0.7.0.1
 */