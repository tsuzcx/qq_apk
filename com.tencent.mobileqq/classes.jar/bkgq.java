import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

public class bkgq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  apzc jdField_a_of_type_Apzc;
  public DynamicTextConfigManager.DynamicTextConfigBean a;
  QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  ImageView c;
  ImageView d;
  
  public bkgq(View paramView, apzc paramapzc)
  {
    super(paramView);
    this.jdField_a_of_type_Apzc = paramapzc;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365531));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365532));
    this.c = ((ImageView)paramView.findViewById(2131365534));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365533);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131369507));
    this.d = ((ImageView)paramView.findViewById(2131368056));
    paramView.setOnClickListener(this);
    paramapzc = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramapzc.width = paramView.width;
    paramapzc.height = paramView.height;
    paramapzc.addRule(10);
    paramapzc.addRule(9);
    paramapzc.addRule(12);
    paramapzc.addRule(11);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setLayoutParams(paramapzc);
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
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      if (this.jdField_a_of_type_Apzc != null) {
        this.jdField_a_of_type_Apzc.a(paramView, getAdapterPosition(), -1);
      }
      vel.a("video_edit_text", "clk_textIcon", 0, 0, new String[] { (String)tax.a().a("EditVideoDTextFace.mSrcFrom"), String.valueOf(getAdapterPosition() + 1), "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgq
 * JD-Core Version:    0.7.0.1
 */