import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

public class asbq
  extends asbm
{
  private int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationTextView jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView;
  
  public asbq(bdjz parambdjz)
  {
    super(parambdjz);
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)((this.jdField_a_of_type_Bdjz.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296991)) / bdoo.a));
    }
    return this.jdField_a_of_type_Int;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558924, null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377620));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new asbr(this));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(new bamp(paramString2, 5, 20));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbq
 * JD-Core Version:    0.7.0.1
 */