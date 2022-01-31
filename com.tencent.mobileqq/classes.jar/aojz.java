import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class aojz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  public View a;
  public ImageView a;
  OnHolderItemClickListener a;
  public DynamicTextConfigManager.DynamicTextConfigBean a;
  public QIMCommonLoadingView a;
  View b;
  public ImageView b;
  public ImageView c;
  public ImageView d;
  
  public aojz(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371713));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371714));
    this.c = ((ImageView)paramView.findViewById(2131371716));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371715);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131363471));
    this.d = ((ImageView)paramView.findViewById(2131371717));
    paramView.setOnClickListener(this);
    paramOnHolderItemClickListener = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramOnHolderItemClickListener.width = paramView.width;
    paramOnHolderItemClickListener.height = paramView.height;
    paramOnHolderItemClickListener.addRule(10);
    paramOnHolderItemClickListener.addRule(9);
    paramOnHolderItemClickListener.addRule(12);
    paramOnHolderItemClickListener.addRule(11);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setLayoutParams(paramOnHolderItemClickListener);
    localLayoutParams.width = paramView.width;
    localLayoutParams.height = paramView.height;
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.c.setLayoutParams(localLayoutParams);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setProgress((int)paramFloat);
    int i = this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getMeasuredWidth();
    int j = this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getMeasuredHeight();
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "updateProgress progress is: " + paramFloat + " pos is: " + this.jdField_a_of_type_Int + " width is: " + i + "height is: " + j);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getVisibility() != 8) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
    }
    if (paramBoolean) {
      if (this.d.getVisibility() != 8) {
        this.d.setVisibility(8);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "finish download pos is: " + this.jdField_a_of_type_Int);
      }
      return;
      if (this.d.getVisibility() != 0) {
        this.d.setVisibility(0);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.c.getVisibility() != 0) {
        this.c.setVisibility(0);
      }
    }
    while (this.c.getVisibility() == 8) {
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener.a(paramView, getPosition(), -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojz
 * JD-Core Version:    0.7.0.1
 */