import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ImageUploadHandler.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bceo
  implements bkda
{
  private bcdw a;
  
  public bceo(ArithmeticViewHolder paramArithmeticViewHolder, bcdw parambcdw)
  {
    this.jdField_a_of_type_Bcdw = parambcdw;
  }
  
  private void a(bcdw parambcdw)
  {
    ThreadManager.getUIHandler().post(new ArithmeticViewHolder.ImageUploadHandler.1(this, parambcdw));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bcdw.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Bcdw.jdField_a_of_type_Int = paramInt;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Bcdw);
    a(this.jdField_a_of_type_Bcdw);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bcdw.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Bcdw.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bcdw.jdField_a_of_type_Int = 100;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_Bcdw);
    a(this.jdField_a_of_type_Bcdw);
    if (QLog.isColorLevel()) {
      QLog.d("ArithmeticViewHolder", 2, "update success , url = " + paramString);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bcdw.jdField_b_of_type_Int = 2;
    a(this.jdField_a_of_type_Bcdw);
    QLog.w("ArithmeticViewHolder", 2, "upload error , code = " + paramInt + " ;local path = " + this.jdField_a_of_type_Bcdw.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceo
 * JD-Core Version:    0.7.0.1
 */