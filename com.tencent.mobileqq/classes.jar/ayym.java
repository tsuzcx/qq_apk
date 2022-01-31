import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.qphone.base.util.QLog;

public class ayym
  extends CountDownTimer
{
  public ayym(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
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
        bafb localbafb = babr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131631979).setNegativeButton(2131632007, new ayyo(this)).setPositiveButton(2131632003, new ayyn(this));
        localbafb.setCancelable(false);
        localbafb.show();
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
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131631975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayym
 * JD-Core Version:    0.7.0.1
 */