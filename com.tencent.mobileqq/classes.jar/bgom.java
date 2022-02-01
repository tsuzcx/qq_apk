import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;

public class bgom
  extends bgku
{
  public bgom(TroopAppShortcutContainer paramTroopAppShortcutContainer, QQAppInterface paramQQAppInterface)
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
    bgnv localbgnv = new bgnv(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopAppShortcutContainer.a(this.a), TroopAppShortcutContainer.a(this.a));
    bgnw localbgnw = new bgnw();
    bgkr localbgkr = ((bgks)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355)).a(Long.valueOf(TroopAppShortcutContainer.a(this.a)));
    if (localbgkr != null) {
      localbgnw.jdField_a_of_type_Bgkr = localbgkr;
    }
    localbgnw.b = bgqr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopAppShortcutContainer.a(this.a));
    if (!paramBoolean)
    {
      if (paramInt != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbgnw.jdField_a_of_type_Boolean = paramBoolean;
        bgqr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbgnw, TroopAppShortcutContainer.a(this.a));
        localbgnv.a(localbgnw);
        this.a.jdField_a_of_type_Bgon.a(0, localbgnv);
        return;
      }
    }
    if (paramInt == 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbgnw.jdField_a_of_type_Boolean = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgom
 * JD-Core Version:    0.7.0.1
 */