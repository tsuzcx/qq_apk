import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

public class bdtq
  extends CountDownTimer.CountDownTimerListener
{
  public bdtq(CountdownTextView paramCountdownTextView, long paramLong, bdtr parambdtr)
  {
    super(paramLong);
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_Bdtr != null) {
      this.jdField_a_of_type_Bdtr.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_Bdtr != null) {
      this.jdField_a_of_type_Bdtr.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtq
 * JD-Core Version:    0.7.0.1
 */