import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;

public class beya
  extends beud
{
  public beya(TroopAppShortcutContainer paramTroopAppShortcutContainer, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void a(long paramLong)
  {
    if (paramLong != TroopAppShortcutContainer.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutContainer", 2, "onShortcutBarItemUpdated troopCode:" + paramLong);
    }
    TroopAppShortcutContainer.a(this.a, 1, 0, 3);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.e("TroopAppShortcutContainer", 2, "onSetTotalSwitch:" + String.valueOf(paramLong) + "isSuccess" + paramBoolean + "disabled" + paramInt);
    }
    bexk localbexk = new bexk(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopAppShortcutContainer.a(this.a), TroopAppShortcutContainer.a(this.a));
    bexl localbexl = new bexl();
    betz localbetz = ((beua)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(TroopAppShortcutContainer.a(this.a)));
    if (localbetz != null) {
      localbexl.jdField_a_of_type_Betz = localbetz;
    }
    localbexl.b = bfaf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopAppShortcutContainer.a(this.a));
    if (!paramBoolean)
    {
      if (paramInt != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbexl.jdField_a_of_type_Boolean = paramBoolean;
        bfaf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbexl, TroopAppShortcutContainer.a(this.a));
        localbexk.a_(localbexl);
        this.a.jdField_a_of_type_Beyb.a(0, localbexk);
        return;
      }
    }
    if (paramInt == 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbexl.jdField_a_of_type_Boolean = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beya
 * JD-Core Version:    0.7.0.1
 */