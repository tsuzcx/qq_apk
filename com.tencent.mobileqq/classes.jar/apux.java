import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class apux
{
  int jdField_a_of_type_Int = 0;
  public apuc a;
  apuj jdField_a_of_type_Apuj;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public boolean b = false;
  public int c;
  boolean c = true;
  public boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public apux() {}
  
  public apux(EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    if (paramEmoticonMainPanel != null)
    {
      paramEmoticonMainPanel = paramEmoticonMainPanel.a();
      if (paramEmoticonMainPanel != null)
      {
        this.jdField_a_of_type_Apuc = paramEmoticonMainPanel.jdField_a_of_type_Apuc;
        this.jdField_a_of_type_Boolean = paramEmoticonMainPanel.h;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        this.c = paramEmoticonMainPanel.k;
        this.jdField_a_of_type_Apuj = EmoticonPanelController.a(paramEmoticonMainPanel);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        this.i = EmoticonPanelController.a(paramEmoticonMainPanel);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) {}
    EmoticonPanelController localEmoticonPanelController;
    do
    {
      return;
      localEmoticonPanelController = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a();
    } while (localEmoticonPanelController == null);
    this.h = false;
    localEmoticonPanelController.jdField_a_of_type_Apux = this;
    localEmoticonPanelController.jdField_a_of_type_Apuc = this.jdField_a_of_type_Apuc;
    localEmoticonPanelController.h = this.jdField_a_of_type_Boolean;
    localEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localEmoticonPanelController.k = this.c;
    EmoticonPanelController.a(localEmoticonPanelController, this.jdField_a_of_type_Apuj);
    localEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    EmoticonPanelController.a(localEmoticonPanelController, this.i);
    localEmoticonPanelController.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a() == null)) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apux
 * JD-Core Version:    0.7.0.1
 */