import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apqn
  implements aubp<Integer>
{
  public apqn(EmoticonPanelController paramEmoticonPanelController, long paramLong) {}
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.f(paramInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.d(paramInteger.intValue());
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apqo.e) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apqo.f)) {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).i();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apqo.f = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apqo.g) {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).i();
    }
    paramInteger = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b;
    if (paramInteger.size() > EmoticonPanelController.d) {
      if (((apsm)paramInteger.get(EmoticonPanelController.d)).a != 8) {
        EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g);
      }
    }
    for (;;)
    {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).i();
      return;
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqn
 * JD-Core Version:    0.7.0.1
 */