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

public class boop
{
  private static final String jdField_a_of_type_JavaLangString = boop.class.getSimpleName();
  private Observer<bowc> jdField_a_of_type_AndroidArchLifecycleObserver = new booq(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new boor(this, null);
  private bofh jdField_a_of_type_Bofh;
  private boos jdField_a_of_type_Boos;
  private boot jdField_a_of_type_Boot;
  private boou jdField_a_of_type_Boou;
  private bowk jdField_a_of_type_Bowk;
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
  
  public boop(View paramView, bown parambown)
  {
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Boot = new boot((ViewStub)paramView.findViewById(2131378111));
    this.jdField_a_of_type_Boos = new boos((ViewStub)paramView.findViewById(2131378112));
    this.jdField_a_of_type_Boou = new boou((ViewStub)paramView.findViewById(2131378121));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, this.jdField_a_of_type_AndroidArchLifecycleObserver);
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
        this.jdField_a_of_type_Boos.c();
        this.jdField_a_of_type_Boot.b();
        return;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
    this.jdField_a_of_type_Boot.c();
    this.jdField_a_of_type_Boos.b();
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
          this.jdField_a_of_type_Boos.c();
          if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
            break;
          }
        } while (!this.d);
        this.jdField_a_of_type_Boot.c();
        i();
        return;
        this.jdField_a_of_type_Boot.c();
        i();
        return;
      } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
      this.jdField_a_of_type_Boot.c();
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
        break;
      }
    } while (!this.d);
    this.jdField_a_of_type_Boos.c();
    i();
    return;
    this.jdField_a_of_type_Boos.c();
    i();
  }
  
  private void i()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Boou.b();
    }
    while (this.f) {
      return;
    }
    boou localboou = this.jdField_a_of_type_Boou;
    String str = this.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (Bitmap localBitmap = null;; localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localboou.a(str, localBitmap, true);
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
    this.jdField_a_of_type_Boot.c();
    this.jdField_a_of_type_Boos.c();
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
    this.jdField_a_of_type_Boot.c();
    this.jdField_a_of_type_Boos.c();
    this.jdField_a_of_type_Boou.a(null, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boot.d();
    this.jdField_a_of_type_Boos.d();
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
 * Qualified Name:     boop
 * JD-Core Version:    0.7.0.1
 */