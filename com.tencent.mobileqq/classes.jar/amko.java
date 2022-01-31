import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.widget.ProgressPieView;

public class amko
  extends Handler
{
  long jdField_a_of_type_Long;
  
  public amko(ProgressPieView paramProgressPieView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    if (i < this.jdField_a_of_type_ComTencentWidgetProgressPieView.a)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(i);
      sendEmptyMessageDelayed(0, 1L);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_ComTencentWidgetProgressPieView.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amko
 * JD-Core Version:    0.7.0.1
 */