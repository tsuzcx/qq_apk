import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

public class aqdz
  extends aqdv
{
  private int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationTextView jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView;
  
  public aqdz(bbgu parambbgu)
  {
    super(parambbgu);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)((this.jdField_a_of_type_Bbgu.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296975)) / bbll.a));
    }
    return this.jdField_a_of_type_Int;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558888, null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377045));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new aqea(this));
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewTextController", 2, " bindData ");
    }
    if (paramString1 != null) {
      a(paramString1);
    }
    if ((paramString2 != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(new aykk(paramString2, 5, 20));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdz
 * JD-Core Version:    0.7.0.1
 */