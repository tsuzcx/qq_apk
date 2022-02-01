import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import dov.com.qq.im.capture.data.TransitionCategoryItem;

public class bpmi
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TransitionCategoryItem jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem;
  boolean jdField_a_of_type_Boolean = false;
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_DovComQqImCaptureDataTransitionCategoryItem != null))
    {
      if (!paramBoolean) {
        break label45;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844450);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844483);
    return;
    label45:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpmi
 * JD-Core Version:    0.7.0.1
 */