import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

public class bcmq
  extends CountDownTimer.CountDownTimerListener
{
  public bcmq(CountdownTextView paramCountdownTextView, long paramLong, bcmr parambcmr)
  {
    super(paramLong);
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_Bcmr != null) {
      this.jdField_a_of_type_Bcmr.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_Bcmr != null) {
      this.jdField_a_of_type_Bcmr.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmq
 * JD-Core Version:    0.7.0.1
 */