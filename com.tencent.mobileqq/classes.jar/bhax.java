import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class bhax
  implements bhad, gf
{
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  protected bhae a;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private fz jdField_a_of_type_Fz = new bhaz(this);
  protected gc a;
  private Observer jdField_a_of_type_JavaUtilObserver = new bhay(this);
  protected AppRuntime a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public bhax(bhac parambhac, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bhae = parambhac.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    gg.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected gb a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_Gc = ((gc)this.jdField_a_of_type_MqqAppAppRuntime.getManager(42));
      this.jdField_a_of_type_Gc.a(this);
      return this.jdField_a_of_type_Gc.a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).c(), 0);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhae.a().sendEmptyMessage(10003);
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
    this.jdField_a_of_type_Bhae.a(paramInt1);
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Fz);
  }
  
  protected void a(ETTextView paramETTextView, gb paramgb, float paramFloat)
  {
    if (paramgb.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramgb.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramgb = paramgb.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramgb.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramgb.equals(paramETTextView.mFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
      paramgb.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramgb, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramgb.jdField_a_of_type_Int, paramgb.jdField_a_of_type_JavaLangString, paramFloat, paramgb.b, paramgb.jdField_a_of_type_AndroidGraphicsTypeface);
      paramgb.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramgb = localETFont;
    }
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (gb localgb = a(this.jdField_a_of_type_Bhae.a(), this.jdField_a_of_type_Int);; localgb = gg.a().a(this.jdField_a_of_type_Bhae.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localgb + " fontId:" + this.jdField_a_of_type_Bhae.a());
      if ((localgb != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localgb, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void c()
  {
    gg.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = null;
    }
    if (this.jdField_a_of_type_Gc != null) {
      this.jdField_a_of_type_Gc.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhax
 * JD-Core Version:    0.7.0.1
 */