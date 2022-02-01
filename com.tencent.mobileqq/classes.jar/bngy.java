import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import dov.com.qq.im.ae.camera.ui.tips.AETipsViewController.2;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class bngy
{
  private static final String jdField_a_of_type_JavaLangString = bngy.class.getSimpleName();
  private Observer<bnpr> jdField_a_of_type_AndroidArchLifecycleObserver = new bngz(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new bnha(this, null);
  private bmxa jdField_a_of_type_Bmxa;
  private bnhb jdField_a_of_type_Bnhb;
  private bnhc jdField_a_of_type_Bnhc;
  private bnhd jdField_a_of_type_Bnhd;
  private bnpz jdField_a_of_type_Bnpz;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public bngy(View paramView, bnqc parambnqc)
  {
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnhc = new bnhc((ViewStub)paramView.findViewById(2131378168));
    this.jdField_a_of_type_Bnhb = new bnhb((ViewStub)paramView.findViewById(2131378169));
    this.jdField_a_of_type_Bnhd = new bnhd((ViewStub)paramView.findViewById(2131378178));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, this.jdField_a_of_type_AndroidArchLifecycleObserver);
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
    j();
    if (paramVideoMaterial == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
    AETipsManager.getInstance().setVideoMaterial(paramVideoMaterial);
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY)
      {
        b();
        return;
      }
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
      {
        this.jdField_a_of_type_Bnhb.c();
        this.jdField_a_of_type_Bnhc.b();
        return;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
    this.jdField_a_of_type_Bnhc.c();
    this.jdField_a_of_type_Bnhb.b();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = AETipsManager.getInstance().getCustomTipText();
      } while (TextUtils.isEmpty(str));
      this.jdField_b_of_type_JavaLangString = str;
      str = AETipsManager.getInstance().getCustomTipText();
    } while (TextUtils.isEmpty(str));
    this.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getDataPath() + File.separator + str);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.jdField_c_of_type_JavaLangString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
  }
  
  private void h()
  {
    g();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
      b();
    }
    label89:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
            break label89;
          }
          this.jdField_a_of_type_Bnhb.c();
          if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
            break;
          }
        } while (!this.d);
        this.jdField_a_of_type_Bnhc.c();
        i();
        return;
        this.jdField_a_of_type_Bnhc.c();
        i();
        return;
      } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
      this.jdField_a_of_type_Bnhc.c();
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
        break;
      }
    } while (!this.d);
    this.jdField_a_of_type_Bnhb.c();
    i();
    return;
    this.jdField_a_of_type_Bnhb.c();
    i();
  }
  
  private void i()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bnhd.b();
    }
    while (this.f) {
      return;
    }
    bnhd localbnhd = this.jdField_a_of_type_Bnhd;
    String str = this.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (Bitmap localBitmap = null;; localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localbnhd.a(str, localBitmap, true);
      this.f = true;
      return;
    }
  }
  
  private void j()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnhc.c();
    this.jdField_a_of_type_Bnhb.c();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.f = false;
    b(paramVideoMaterial);
    e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
    if ((this.jdField_b_of_type_Boolean != this.jdField_c_of_type_Boolean) || (this.d != this.e))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "### onDetectStateChange, materialNeedFace=" + paramBoolean1 + ", hasFaceDetected=" + paramBoolean2);
      this.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      this.e = this.d;
      e();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bnhc.c();
    this.jdField_a_of_type_Bnhb.c();
    this.jdField_a_of_type_Bnhd.a(null, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bnhc.d();
    this.jdField_a_of_type_Bnhb.d();
  }
  
  public void d()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "### onChangeCameraByMaterial");
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngy
 * JD-Core Version:    0.7.0.1
 */