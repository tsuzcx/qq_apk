import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class apkb
{
  Context a;
  public azdh a;
  public bhpc a;
  
  public apkb(Context paramContext, azdh paramazdh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Azdh = paramazdh;
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new apkc(this);
    this.jdField_a_of_type_Bhpc.setPositiveButton(2131690086, paramContext);
    this.jdField_a_of_type_Bhpc.setNegativeButton(2131690085, paramContext);
    this.jdField_a_of_type_Bhpc.setMessage(2131690088);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bhpc.isShowing()) {
      this.jdField_a_of_type_Bhpc.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    bdll.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkb
 * JD-Core Version:    0.7.0.1
 */