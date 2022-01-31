import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class aorq
  implements View.OnTouchListener
{
  public aorq(FileAssistantActivity paramFileAssistantActivity, URLImageView paramURLImageView, View paramView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(null);
      if ((Math.abs(i - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantFileAssistantActivity.e) < 10) || (Math.abs(j - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantFileAssistantActivity.f) < 10))
      {
        this.jdField_a_of_type_AndroidViewView.callOnClick();
        continue;
        FileAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantFileAssistantActivity, this.jdField_a_of_type_ComTencentImageURLImageView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantFileAssistantActivity.e = i;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantFileAssistantActivity.f = j;
        continue;
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorq
 * JD-Core Version:    0.7.0.1
 */