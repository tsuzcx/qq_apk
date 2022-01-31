import android.os.Handler;
import android.os.Message;
import com.tencent.widget.ProgressPieView;

public class biad
  extends Handler
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public biad(ProgressPieView paramProgressPieView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_ComTencentWidgetProgressPieView.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentWidgetProgressPieView.e);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetProgressPieView.b < this.jdField_a_of_type_Int)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetProgressPieView.b + this.jdField_a_of_type_ComTencentWidgetProgressPieView.jdField_f_of_type_Int;
        if (i <= this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(i);
        }
        for (;;)
        {
          sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentWidgetProgressPieView.e);
          return;
          this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_Int);
        }
      }
      removeMessages(0);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setShowImage(false);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biad
 * JD-Core Version:    0.7.0.1
 */