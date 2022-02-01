import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ImageUploadHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bfvh
  implements bmjf
{
  private bfup a;
  
  public bfvh(ArithmeticViewHolder paramArithmeticViewHolder, bfup parambfup)
  {
    this.jdField_a_of_type_Bfup = parambfup;
  }
  
  private void a(bfup parambfup)
  {
    ThreadManager.getUIHandler().post(new ArithmeticViewHolder.ImageUploadHandler.1(this, parambfup));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bfup.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Bfup.jdField_a_of_type_Int = paramInt;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Bfup);
    a(this.jdField_a_of_type_Bfup);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfup.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Bfup.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bfup.jdField_a_of_type_Int = 100;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Bfup);
    a(this.jdField_a_of_type_Bfup);
    if (QLog.isColorLevel()) {
      QLog.d("ArithmeticViewHolder", 2, "update success , url = " + paramString);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bfup.jdField_b_of_type_Int = 2;
    a(this.jdField_a_of_type_Bfup);
    QLog.w("ArithmeticViewHolder", 2, "upload error , code = " + paramInt + " ;local path = " + this.jdField_a_of_type_Bfup.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvh
 * JD-Core Version:    0.7.0.1
 */