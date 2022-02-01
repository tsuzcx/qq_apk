import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class bfok
  implements bkhe
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public bfok(TroopAppShortcutContainer paramTroopAppShortcutContainer) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
    this.b = paramInt3;
    TroopAppShortcutContainer.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer, this.jdField_a_of_type_Int);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_a_of_type_Int != this.b - 1) || (!TroopAppShortcutContainer.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer).a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAppShortcutContainer", 2, "needLoad mCurPage:" + TroopAppShortcutContainer.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer).a());
    }
    TroopAppShortcutContainer.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer, TroopAppShortcutContainer.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer).a() + 1, 30, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfok
 * JD-Core Version:    0.7.0.1
 */