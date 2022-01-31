import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ImageUploadHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class babw
  implements bhxi
{
  private babe a;
  
  public babw(ArithmeticViewHolder paramArithmeticViewHolder, babe parambabe)
  {
    this.jdField_a_of_type_Babe = parambabe;
  }
  
  private void a(babe parambabe)
  {
    ThreadManager.getUIHandler().post(new ArithmeticViewHolder.ImageUploadHandler.1(this, parambabe));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Babe.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Babe.jdField_a_of_type_Int = paramInt;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Babe);
    a(this.jdField_a_of_type_Babe);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Babe.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Babe.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Babe.jdField_a_of_type_Int = 100;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Babe);
    a(this.jdField_a_of_type_Babe);
    if (QLog.isColorLevel()) {
      QLog.d("ArithmeticViewHolder", 2, "update success , url = " + paramString);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Babe.jdField_b_of_type_Int = 2;
    a(this.jdField_a_of_type_Babe);
    QLog.w("ArithmeticViewHolder", 2, "upload error , code = " + paramInt + " ;local path = " + this.jdField_a_of_type_Babe.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babw
 * JD-Core Version:    0.7.0.1
 */