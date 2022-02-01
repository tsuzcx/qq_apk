package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.libpag.PAGView;

public class AETipsViewController
{
  private AEPituCameraUnit a;
  private AEVideoStoryCaptureModeViewModel b;
  private AECaptureMode c = AECaptureMode.NORMAL;
  private Handler d = new AETipsViewController.TipsHandler(this);
  private boolean e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private View k;
  private FaceDetectTipViewStubHolder l;
  private FaceDetectTipGifViewStubHolder m;
  private MaterialTipsViewStubHolder n;
  private final ViewStub o;
  private PAGView p;
  private ARCakeTipsViewStubHolder q;
  private boolean r;
  private String s;
  private String t;
  private Bitmap u;
  private VideoMaterial v;
  
  public AETipsViewController(View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.k = paramView;
    this.a = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.b = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.a).get(AEVideoStoryCaptureModeViewModel.class));
    this.l = new FaceDetectTipViewStubHolder((ViewStub)paramView.findViewById(2063991437));
    this.m = new FaceDetectTipGifViewStubHolder((ViewStub)paramView.findViewById(2063991438));
    this.n = new MaterialTipsViewStubHolder((ViewStub)paramView.findViewById(2063991451));
    this.q = new ARCakeTipsViewStubHolder((ViewStub)paramView.findViewById(2063991456));
    this.o = ((ViewStub)paramView.findViewById(2063991449));
    this.b.a.observe(this.a, new AETipsViewController.1(this));
    paramView = new HashMap();
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value), "张开你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value), "挑动你的眉毛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK.value), "眨眨你的眼睛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.KISS.value), "嘟起你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value), "眨眨你的左眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value), "眨眨你的右眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_NOD.value), "点一点你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value), "点击屏幕试试");
    AETipsManager.getInstance().updateActionTipsString(paramView);
  }
  
  private void b(VideoMaterial paramVideoMaterial)
  {
    n();
    if (paramVideoMaterial == null) {
      return;
    }
    this.v = paramVideoMaterial;
    AETipsManager.getInstance().setVideoMaterial(paramVideoMaterial);
  }
  
  private void j()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void k()
  {
    if (this.v == null) {
      return;
    }
    this.e = true;
    if (this.c == AECaptureMode.PLAY)
    {
      c();
      return;
    }
    if (this.c == AECaptureMode.NORMAL)
    {
      this.m.e();
      this.l.d();
      return;
    }
    if (this.c == AECaptureMode.GIF)
    {
      this.l.e();
      this.m.d();
    }
  }
  
  private void l()
  {
    this.e = true;
    if (this.c == AECaptureMode.PLAY)
    {
      c();
      return;
    }
    VideoMaterial localVideoMaterial;
    if (this.c == AECaptureMode.NORMAL)
    {
      this.m.e();
      localVideoMaterial = this.v;
      if ((localVideoMaterial != null) && (localVideoMaterial.needFaceInfo()))
      {
        if (this.h)
        {
          this.l.e();
          m();
        }
      }
      else
      {
        this.l.e();
        m();
      }
    }
    else if (this.c == AECaptureMode.GIF)
    {
      this.l.e();
      localVideoMaterial = this.v;
      if ((localVideoMaterial != null) && (localVideoMaterial.needFaceInfo()))
      {
        if (this.h)
        {
          this.m.e();
          m();
        }
      }
      else
      {
        this.m.e();
        m();
      }
    }
  }
  
  private void m()
  {
    if (!this.r)
    {
      MaterialTipsViewStubHolder localMaterialTipsViewStubHolder = this.n;
      String str = this.s;
      Bitmap localBitmap;
      if (TextUtils.isEmpty(this.t)) {
        localBitmap = null;
      } else {
        localBitmap = this.u;
      }
      localMaterialTipsViewStubHolder.a(str, localBitmap, 3000);
      this.r = true;
    }
  }
  
  private void n()
  {
    this.s = null;
    this.t = null;
    this.u = null;
    Bitmap localBitmap = this.u;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.u.recycle();
    }
    this.v = null;
  }
  
  public Handler a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.q.a(paramInt);
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.r = false;
    b(paramVideoMaterial);
    j();
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPagTip: pagPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AETipsViewController", localStringBuilder.toString());
    if (this.p == null) {
      this.p = ((PAGView)this.o.inflate());
    }
    this.p.addPAGFlushListener(new AETipsViewController.3(this));
    this.p.setPath(paramString);
    this.p.setRepeatCount(1);
    this.p.addListener(new AETipsViewController.4(this));
    this.p.flush();
    this.p.setProgress(0.0D);
    this.p.setVisibility(0);
    this.p.play();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNormalTip: tip=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AETipsViewController", localStringBuilder.toString());
    paramString2 = BitmapUtils.decodeSampleBitmap(this.a.s(), paramString2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    this.n.a(paramString1, paramString2, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = paramBoolean1;
    this.h = paramBoolean2;
    if ((this.f != this.g) || (this.h != this.i))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("### onDetectStateChange, materialNeedFace=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", hasFaceDetected=");
      localStringBuilder.append(paramBoolean2);
      QLog.d("AETipsViewController", 4, localStringBuilder.toString());
      this.g = this.f;
      this.i = this.h;
      j();
    }
  }
  
  public void b()
  {
    this.l.e();
    this.m.e();
  }
  
  public void c()
  {
    this.l.e();
    this.m.e();
    this.n.d();
  }
  
  public void d()
  {
    this.l.f();
    this.m.f();
  }
  
  public void e()
  {
    QLog.d("AETipsViewController", 4, "### onChangeCameraByMaterial");
    if (this.e) {
      j();
    }
  }
  
  public void f()
  {
    AEQLog.a("AETipsViewController", "hideNormalTip: ");
    this.n.d();
  }
  
  public void g()
  {
    AEQLog.a("AETipsViewController", "hidePagTip: ");
    PAGView localPAGView = this.p;
    if (localPAGView == null) {
      return;
    }
    if (localPAGView.isPlaying()) {
      this.p.stop();
    }
    this.p.setVisibility(8);
  }
  
  public void h()
  {
    this.q.d();
  }
  
  public void i()
  {
    this.q.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController
 * JD-Core Version:    0.7.0.1
 */