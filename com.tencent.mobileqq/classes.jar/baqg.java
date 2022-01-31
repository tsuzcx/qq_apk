import android.os.Bundle;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;

public class baqg
  implements bapo
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private bapp jdField_a_of_type_Bapp;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private fs jdField_a_of_type_Fs = new baqi(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new baqh(this);
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public baqg(bapn parambapn, AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Bapp = parambapn.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    fz.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected fu a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      return ((fv)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(42)).a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).c(), 0);
    }
    return null;
  }
  
  public void a()
  {
    if (AppUtil.isMainProcess()) {}
    for (fu localfu = a(this.jdField_a_of_type_Bapp.a(), this.jdField_a_of_type_Int);; localfu = fz.a().a(this.jdField_a_of_type_Bapp.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localfu + " fontId:" + this.jdField_a_of_type_Bapp.a());
      if ((localfu != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localfu, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bapp.a(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
    a();
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Fs);
  }
  
  protected void a(ETTextView paramETTextView, fu paramfu, float paramFloat)
  {
    if (paramfu.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramfu.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramfu = paramfu.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramfu.setSize(paramFloat);
    }
    for (;;)
    {
      if ((paramETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (!paramfu.equals(paramETTextView.jdField_a_of_type_ComEtrumpMixlayoutETFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.d = this.jdField_a_of_type_Boolean;
      paramfu.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramfu, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramfu.jdField_a_of_type_Int, paramfu.jdField_a_of_type_JavaLangString, paramFloat, paramfu.b, paramfu.jdField_a_of_type_AndroidGraphicsTypeface);
      paramfu.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramfu = localETFont;
    }
  }
  
  public void b()
  {
    fz.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     baqg
 * JD-Core Version:    0.7.0.1
 */