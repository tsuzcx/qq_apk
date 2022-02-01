import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;

public class bfol
  extends bfkt
{
  public bfol(TroopAppShortcutContainer paramTroopAppShortcutContainer, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutContainer", 2, "onSetTotalSwitch:" + String.valueOf(paramLong) + "isSuccess" + paramBoolean + "disabled" + paramInt);
    }
    bfnu localbfnu = new bfnu(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopAppShortcutContainer.a(this.a), TroopAppShortcutContainer.a(this.a));
    bfnv localbfnv = new bfnv();
    bfkq localbfkq = ((bfkr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(TroopAppShortcutContainer.a(this.a)));
    if (localbfkq != null) {
      localbfnv.jdField_a_of_type_Bfkq = localbfkq;
    }
    localbfnv.b = bfqq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopAppShortcutContainer.a(this.a));
    if (!paramBoolean)
    {
      if (paramInt != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbfnv.jdField_a_of_type_Boolean = paramBoolean;
        bfqq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbfnv, TroopAppShortcutContainer.a(this.a));
        localbfnu.a(localbfnv);
        this.a.jdField_a_of_type_Bfom.a(0, localbfnu);
        return;
      }
    }
    if (paramInt == 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbfnv.jdField_a_of_type_Boolean = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfol
 * JD-Core Version:    0.7.0.1
 */