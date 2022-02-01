import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;

public class bdue
  extends CountDownTimer.CountDownTimerListener
{
  public bdue(CountdownTextView paramCountdownTextView, long paramLong, bduf parambduf)
  {
    super(paramLong);
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_Bduf != null) {
      this.jdField_a_of_type_Bduf.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgWidgetCountdownTextView.a();
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_Bduf != null) {
      this.jdField_a_of_type_Bduf.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdue
 * JD-Core Version:    0.7.0.1
 */