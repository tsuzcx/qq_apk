import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class anim
  implements arok<Integer>
{
  public anim(EmoticonMainPanel paramEmoticonMainPanel, long paramLong) {}
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c(paramInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d(paramInteger.intValue());
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d)) {
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.f();
    }
    paramInteger = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_JavaUtilList;
    if (paramInteger.size() > EmoticonMainPanel.jdField_e_of_type_Int) {
      if (((ankb)paramInteger.get(EmoticonMainPanel.jdField_e_of_type_Int)).a != 8) {
        EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.h);
      }
    }
    for (;;)
    {
      EmoticonMainPanel.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      return;
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anim
 * JD-Core Version:    0.7.0.1
 */