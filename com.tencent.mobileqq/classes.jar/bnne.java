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

public class bnne
{
  private static final String jdField_a_of_type_JavaLangString = bnne.class.getSimpleName();
  private Observer<bnuq> jdField_a_of_type_AndroidArchLifecycleObserver = new bnnf(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new bnng(this, null);
  private bndy jdField_a_of_type_Bndy;
  private bnnh jdField_a_of_type_Bnnh;
  private bnni jdField_a_of_type_Bnni;
  private bnnj jdField_a_of_type_Bnnj;
  private bnuy jdField_a_of_type_Bnuy;
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
  
  public bnne(View paramView, bnvb parambnvb)
  {
    this.jdField_a_of_type_Bndy = ((bndy)parambnvb.a(65537, new Object[0]));
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
    this.jdField_a_of_type_Bnni = new bnni((ViewStub)paramView.findViewById(2131377956));
    this.jdField_a_of_type_Bnnh = new bnnh((ViewStub)paramView.findViewById(2131377957));
    this.jdField_a_of_type_Bnnj = new bnnj((ViewStub)paramView.findViewById(2131377966));
    this.jdField_a_of_type_Bnuy.a.observe(this.jdField_a_of_type_Bndy, this.jdField_a_of_type_AndroidArchLifecycleObserver);
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
        this.jdField_a_of_type_Bnnh.c();
        this.jdField_a_of_type_Bnni.b();
        return;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
    this.jdField_a_of_type_Bnni.c();
    this.jdField_a_of_type_Bnnh.b();
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
          this.jdField_a_of_type_Bnnh.c();
          if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
            break;
          }
        } while (!this.d);
        this.jdField_a_of_type_Bnni.c();
        i();
        return;
        this.jdField_a_of_type_Bnni.c();
        i();
        return;
      } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
      this.jdField_a_of_type_Bnni.c();
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
        break;
      }
    } while (!this.d);
    this.jdField_a_of_type_Bnnh.c();
    i();
    return;
    this.jdField_a_of_type_Bnnh.c();
    i();
  }
  
  private void i()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bnnj.b();
    }
    while (this.f) {
      return;
    }
    bnnj localbnnj = this.jdField_a_of_type_Bnnj;
    String str = this.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (Bitmap localBitmap = null;; localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localbnnj.a(str, localBitmap, true);
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
    this.jdField_a_of_type_Bnni.c();
    this.jdField_a_of_type_Bnnh.c();
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
    this.jdField_a_of_type_Bnni.c();
    this.jdField_a_of_type_Bnnh.c();
    this.jdField_a_of_type_Bnnj.a(null, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bnni.d();
    this.jdField_a_of_type_Bnnh.d();
  }
  
  public void d()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "### onChangeCamera");
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnne
 * JD-Core Version:    0.7.0.1
 */