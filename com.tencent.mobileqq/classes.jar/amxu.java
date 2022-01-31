import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class amxu
{
  Context a;
  public awaw a;
  public bdjz a;
  
  public amxu(Context paramContext, awaw paramawaw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Awaw = paramawaw;
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230);
    paramContext = new amxv(this);
    this.jdField_a_of_type_Bdjz.setPositiveButton(2131690231, paramContext);
    this.jdField_a_of_type_Bdjz.setNegativeButton(2131690230, paramContext);
    this.jdField_a_of_type_Bdjz.setMessage(2131690233);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Bdjz.isShowing()) {
      this.jdField_a_of_type_Bdjz.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    azqs.b(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxu
 * JD-Core Version:    0.7.0.1
 */