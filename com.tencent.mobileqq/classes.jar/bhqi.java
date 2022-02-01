import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class bhqi
  implements bhpn, ge
{
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  protected bhpo a;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private fy jdField_a_of_type_Fy = new bhqk(this);
  protected gb a;
  private Observer jdField_a_of_type_JavaUtilObserver = new bhqj(this);
  protected AppRuntime a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public bhqi(bhpm parambhpm, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bhpo = parambhpm.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    gf.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected ga a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_Gb = ((gb)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
      this.jdField_a_of_type_Gb.a(this);
      return this.jdField_a_of_type_Gb.a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentUin(), 0);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhpo.a().sendEmptyMessage(10003);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    this.jdField_a_of_type_Bhpo.a(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
    b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "downloadDone type = " + paramInt);
    }
  }
  
  public void a(ETTextView paramETTextView, float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Fy);
  }
  
  protected void a(ETTextView paramETTextView, ga paramga, float paramFloat)
  {
    if (paramga.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramga.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramga = paramga.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramga.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramga.equals(paramETTextView.mFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
      paramga.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramga, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramga.jdField_a_of_type_Int, paramga.jdField_a_of_type_JavaLangString, paramFloat, paramga.b, paramga.jdField_a_of_type_AndroidGraphicsTypeface);
      paramga.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramga = localETFont;
    }
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (ga localga = a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int);; localga = gf.a().a(this.jdField_a_of_type_Bhpo.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localga + " fontId:" + this.jdField_a_of_type_Bhpo.a());
      if ((localga != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localga, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void c()
  {
    gf.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = null;
    }
    if (this.jdField_a_of_type_Gb != null) {
      this.jdField_a_of_type_Gb.b(this);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqi
 * JD-Core Version:    0.7.0.1
 */