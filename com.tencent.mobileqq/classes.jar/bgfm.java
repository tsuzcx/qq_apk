import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;

public class bgfm
  extends bgbj
{
  public bgfm(TroopAppShortcutContainer paramTroopAppShortcutContainer, QQAppInterface paramQQAppInterface)
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
    bgew localbgew = new bgew(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, TroopAppShortcutContainer.a(this.a), TroopAppShortcutContainer.a(this.a));
    bgex localbgex = new bgex();
    bgbf localbgbf = ((bgbg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(TroopAppShortcutContainer.a(this.a)));
    if (localbgbf != null) {
      localbgex.jdField_a_of_type_Bgbf = localbgbf;
    }
    localbgex.b = bgil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopAppShortcutContainer.a(this.a));
    if (!paramBoolean)
    {
      if (paramInt != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localbgex.jdField_a_of_type_Boolean = paramBoolean;
        bgil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbgex, TroopAppShortcutContainer.a(this.a));
        localbgew.a_(localbgex);
        this.a.jdField_a_of_type_Bgfn.a(0, localbgew);
        return;
      }
    }
    if (paramInt == 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localbgex.jdField_a_of_type_Boolean = paramBoolean;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfm
 * JD-Core Version:    0.7.0.1
 */