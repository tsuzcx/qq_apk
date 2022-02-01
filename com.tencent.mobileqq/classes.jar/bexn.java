import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;

public abstract class bexn
{
  protected int a;
  protected long a;
  protected Context a;
  protected FragmentActivity a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected TroopAppShortcutContainer a;
  protected boolean a;
  protected long b;
  protected boolean b;
  
  public bexn(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer = paramTroopAppShortcutContainer;
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramBundle.getParcelable("sessionInfo"));
      this.jdField_a_of_type_Long = paramBundle.getLong("troopUin", 0L);
      this.jdField_b_of_type_Long = paramBundle.getLong("troopClassExt", 0L);
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isNight", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("isAdminOrOwner", false);
      this.jdField_a_of_type_Int = paramBundle.getInt("reportFrom");
    }
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract Object a();
  
  public abstract void a_(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexn
 * JD-Core Version:    0.7.0.1
 */