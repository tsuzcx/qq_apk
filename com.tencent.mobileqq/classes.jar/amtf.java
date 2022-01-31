import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class amtf
{
  Context a;
  public avwn a;
  public bdfq a;
  
  public amtf(Context paramContext, avwn paramavwn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Avwn = paramavwn;
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new amtg(this);
    this.jdField_a_of_type_Bdfq.setPositiveButton(2131690231, paramContext);
    this.jdField_a_of_type_Bdfq.setNegativeButton(2131690230, paramContext);
    this.jdField_a_of_type_Bdfq.setMessage(2131690233);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bdfq.isShowing()) {
      this.jdField_a_of_type_Bdfq.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    azmj.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */