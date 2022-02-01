import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class bftd
  extends CountDownTimer
{
  public bftd(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.b())
    {
      this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
      {
        QQCustomDialog localQQCustomDialog = bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131697187).setNegativeButton(2131697223, new bftf(this)).setPositiveButton(2131697215, new bfte(this));
        localQQCustomDialog.setCancelable(false);
        localQQCustomDialog.show();
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
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131697179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftd
 * JD-Core Version:    0.7.0.1
 */