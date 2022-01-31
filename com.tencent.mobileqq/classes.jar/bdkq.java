import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;

public class bdkq
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bdkq(QQAppInterface paramQQAppInterface, boolean paramBoolean1, ImageView paramImageView, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramBoolean2;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(127);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(127);
        continue;
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
          continue;
          if (Build.VERSION.SDK_INT >= 16) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
          }
          for (;;)
          {
            if (!this.b) {
              break label192;
            }
            VipUtils.b(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F0D", "0X8009F0D", 0, 0, "", "", "", "");
            break;
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
          }
          label192:
          VipUtils.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkq
 * JD-Core Version:    0.7.0.1
 */