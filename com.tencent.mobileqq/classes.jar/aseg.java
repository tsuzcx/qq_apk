import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.forward.ForwardShortVideoOption.PressDarkImageView;
import com.tencent.qphone.base.util.QLog;

public class aseg
{
  public ImageView a;
  public ForwardShortVideoOption.PressDarkImageView a;
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardShortVideoOption$PressDarkImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "setPreviewImage null");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837969);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setMaxHeight(bdoo.a(140.0F));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aseg
 * JD-Core Version:    0.7.0.1
 */