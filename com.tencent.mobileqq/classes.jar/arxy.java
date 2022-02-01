import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class arxy
  implements awnc<Integer>
{
  public arxy(EmoticonPanelController paramEmoticonPanelController, long paramLong) {}
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.f(paramInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.d(paramInteger.intValue());
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.e) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.f)) {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.f = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.g) {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).a();
    }
    paramInteger = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.b;
    if (paramInteger.size() > EmoticonPanelController.d) {
      if (((asaf)paramInteger.get(EmoticonPanelController.d)).a != 8) {
        EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g);
      }
    }
    for (;;)
    {
      EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController).a();
      return;
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxy
 * JD-Core Version:    0.7.0.1
 */