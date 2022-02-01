import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

public class bdbl
  extends CountDownTimer.CountDownTimerListener
{
  public bdbl(CountdownTextView paramCountdownTextView, long paramLong, bdbm parambdbm)
  {
    super(paramLong);
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_Bdbm != null) {
      this.jdField_a_of_type_Bdbm.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_Bdbm != null) {
      this.jdField_a_of_type_Bdbm.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbl
 * JD-Core Version:    0.7.0.1
 */