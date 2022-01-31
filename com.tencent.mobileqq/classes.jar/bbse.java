import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class bbse
  implements bbrl, hr
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private bbrm jdField_a_of_type_Bbrm;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private hl jdField_a_of_type_Hl = new bbsg(this);
  private ho jdField_a_of_type_Ho;
  private Observer jdField_a_of_type_JavaUtilObserver = new bbsf(this);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public bbse(bbrk parambbrk, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_Bbrm = parambbrk.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    hs.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected hn a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_Ho = ((ho)this.jdField_a_of_type_MqqAppAppRuntime.getManager(42));
      this.jdField_a_of_type_Ho.a(this);
      return this.jdField_a_of_type_Ho.a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).c(), 0);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbrm.a().sendEmptyMessage(10003);
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
    this.jdField_a_of_type_Bbrm.a(paramInt1);
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Hl);
  }
  
  protected void a(ETTextView paramETTextView, hn paramhn, float paramFloat)
  {
    if (paramhn.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramhn.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramhn = paramhn.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramhn.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramhn.equals(paramETTextView.mFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
      paramhn.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramhn, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramhn.jdField_a_of_type_Int, paramhn.jdField_a_of_type_JavaLangString, paramFloat, paramhn.b, paramhn.jdField_a_of_type_AndroidGraphicsTypeface);
      paramhn.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramhn = localETFont;
    }
  }
  
  public void b()
  {
    if (AppUtil.isMainProcess()) {}
    for (hn localhn = a(this.jdField_a_of_type_Bbrm.a(), this.jdField_a_of_type_Int);; localhn = hs.a().a(this.jdField_a_of_type_Bbrm.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localhn + " fontId:" + this.jdField_a_of_type_Bbrm.a());
      if ((localhn != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localhn, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void c()
  {
    hs.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
    if (this.jdField_a_of_type_Ho != null) {
      this.jdField_a_of_type_Ho.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbse
 * JD-Core Version:    0.7.0.1
 */