import android.graphics.Bitmap;
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
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.AR_MATERIAL_TYPE;
import dov.com.qq.im.ae.camera.ui.tips.AETipsViewController.2;
import java.io.File;
import mqq.os.MqqHandler;

public class bipc
{
  private static final String jdField_a_of_type_JavaLangString = bipc.class.getSimpleName();
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bijd jdField_a_of_type_Bijd;
  private bipe jdField_a_of_type_Bipe;
  private bipf jdField_a_of_type_Bipf;
  private bipg jdField_a_of_type_Bipg;
  private biwo jdField_a_of_type_Biwo = biwo.jdField_a_of_type_Biwo;
  private biwp jdField_a_of_type_Biwp;
  private bjos<biwo> jdField_a_of_type_Bjos = new bipd(this);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public bipc(View paramView, biws parambiws)
  {
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Bipf = new bipf((ViewStub)paramView.findViewById(2131376595));
    this.jdField_a_of_type_Bipe = new bipe((ViewStub)paramView.findViewById(2131376596));
    this.jdField_a_of_type_Bipg = new bipg((ViewStub)paramView.findViewById(2131376604));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, this.jdField_a_of_type_Bjos);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return "张开你的嘴";
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return "挑动你的眉毛";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return "眨眨你的眼睛";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return "摇一摇你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return "嘟起你的嘴";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value) {
      return "眨眨你的左眼";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value) {
      return "眨眨你的右眼";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return "点一点你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value) {
      return "摇一摇你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value) {
      return "点击屏幕试试";
    }
    return null;
  }
  
  private void b(VideoMaterial paramVideoMaterial)
  {
    g();
    if (paramVideoMaterial == null) {}
    String str;
    do
    {
      return;
      str = paramVideoMaterial.getTipsText();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = str;
      str = paramVideoMaterial.getTipsIcon();
    } while (TextUtils.isEmpty(str));
    this.jdField_c_of_type_JavaLangString = (paramVideoMaterial.getDataPath() + File.separator + str);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.jdField_c_of_type_JavaLangString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    return;
    int j = paramVideoMaterial.getTriggerType();
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (paramVideoMaterial.getArParticleType() == VideoMaterialUtil.AR_MATERIAL_TYPE.CLICKABLE.value) {
        i = PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value;
      }
    }
    this.jdField_b_of_type_JavaLangString = a(i);
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Biwo == biwo.b) {
      a();
    }
    do
    {
      return;
      if (this.f)
      {
        a();
        return;
      }
      if (this.jdField_a_of_type_Biwo == biwo.jdField_a_of_type_Biwo)
      {
        this.jdField_a_of_type_Bipe.c();
        if (this.jdField_b_of_type_Boolean)
        {
          if (this.d)
          {
            this.jdField_a_of_type_Bipf.c();
            f();
            return;
          }
          this.jdField_a_of_type_Bipf.b();
          return;
        }
        this.jdField_a_of_type_Bipf.c();
        f();
        return;
      }
    } while (this.jdField_a_of_type_Biwo != biwo.c);
    this.jdField_a_of_type_Bipf.c();
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.d)
      {
        this.jdField_a_of_type_Bipe.c();
        f();
        return;
      }
      this.jdField_a_of_type_Bipe.b();
      return;
    }
    this.jdField_a_of_type_Bipe.c();
    f();
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bipg.b();
    }
    while (this.g) {
      return;
    }
    bipg localbipg = this.jdField_a_of_type_Bipg;
    String str = this.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (Bitmap localBitmap = null;; localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localbipg.a(str, localBitmap, true);
      this.g = true;
      return;
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bipf.c();
    this.jdField_a_of_type_Bipe.c();
    this.jdField_a_of_type_Bipg.a(null, null, false);
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.g = false;
    b(paramVideoMaterial);
    d();
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
      d();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bipf.d();
    this.jdField_a_of_type_Bipe.d();
  }
  
  public void c()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "### onChangeCamera");
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipc
 * JD-Core Version:    0.7.0.1
 */