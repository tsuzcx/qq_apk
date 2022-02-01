import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class asnn
{
  int jdField_a_of_type_Int = 0;
  public asmr a;
  asmy jdField_a_of_type_Asmy;
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
  boolean j = false;
  boolean k = false;
  
  public asnn() {}
  
  public asnn(EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = paramEmoticonMainPanel;
    if (paramEmoticonMainPanel != null)
    {
      paramEmoticonMainPanel = paramEmoticonMainPanel.a();
      if (paramEmoticonMainPanel != null)
      {
        this.jdField_a_of_type_Asmr = paramEmoticonMainPanel.jdField_a_of_type_Asmr;
        this.jdField_a_of_type_Boolean = paramEmoticonMainPanel.h;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        this.c = paramEmoticonMainPanel.k;
        this.jdField_a_of_type_Asmy = EmoticonPanelController.a(paramEmoticonMainPanel);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramEmoticonMainPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        this.i = EmoticonPanelController.a(paramEmoticonMainPanel);
        this.k = paramEmoticonMainPanel.l;
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
    localEmoticonPanelController.jdField_a_of_type_Asnn = this;
    localEmoticonPanelController.jdField_a_of_type_Asmr = this.jdField_a_of_type_Asmr;
    localEmoticonPanelController.h = this.jdField_a_of_type_Boolean;
    localEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localEmoticonPanelController.k = this.c;
    EmoticonPanelController.a(localEmoticonPanelController, this.jdField_a_of_type_Asmy);
    localEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    EmoticonPanelController.a(localEmoticonPanelController, this.i);
    localEmoticonPanelController.l = this.k;
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
 * Qualified Name:     asnn
 * JD-Core Version:    0.7.0.1
 */