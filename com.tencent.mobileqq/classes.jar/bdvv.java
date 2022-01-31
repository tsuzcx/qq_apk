import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class bdvv
  implements bdvc, ga
{
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  protected bdvd a;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private fu jdField_a_of_type_Fu = new bdvx(this);
  protected fx a;
  private Observer jdField_a_of_type_JavaUtilObserver = new bdvw(this);
  protected AppRuntime a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public bdvv(bdvb parambdvb, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bdvd = parambdvb.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    gb.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected fw a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_Fx = ((fx)this.jdField_a_of_type_MqqAppAppRuntime.getManager(42));
      this.jdField_a_of_type_Fx.a(this);
      return this.jdField_a_of_type_Fx.a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).c(), 0);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdvd.a().sendEmptyMessage(10003);
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
    this.jdField_a_of_type_Bdvd.a(paramInt1);
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Fu);
  }
  
  protected void a(ETTextView paramETTextView, fw paramfw, float paramFloat)
  {
    if (paramfw.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramfw = paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramfw.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramfw.equals(paramETTextView.mFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
      paramfw.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramfw, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramfw.jdField_a_of_type_Int, paramfw.jdField_a_of_type_JavaLangString, paramFloat, paramfw.b, paramfw.jdField_a_of_type_AndroidGraphicsTypeface);
      paramfw.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramfw = localETFont;
    }
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (fw localfw = a(this.jdField_a_of_type_Bdvd.a(), this.jdField_a_of_type_Int);; localfw = gb.a().a(this.jdField_a_of_type_Bdvd.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localfw + " fontId:" + this.jdField_a_of_type_Bdvd.a());
      if ((localfw != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localfw, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void c()
  {
    gb.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = null;
    }
    if (this.jdField_a_of_type_Fx != null) {
      this.jdField_a_of_type_Fx.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvv
 * JD-Core Version:    0.7.0.1
 */