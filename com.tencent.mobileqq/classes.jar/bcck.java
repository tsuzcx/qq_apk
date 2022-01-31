import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.qphone.base.util.QLog;

public class bcck
  extends CountDownTimer
{
  public bcck(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.b())
    {
      this.a.b();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
      {
        bdjz localbdjz = bdgm.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131697879).setNegativeButton(2131697915, new bccm(this)).setPositiveButton(2131697907, new bccl(this));
        localbdjz.setCancelable(false);
        localbdjz.show();
      }
    }
  }
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onTick remainSecond = " + i);
    }
    if (i == 5) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131697871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcck
 * JD-Core Version:    0.7.0.1
 */