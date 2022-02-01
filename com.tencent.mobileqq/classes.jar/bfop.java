import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;

public class bfop
  extends TroopAppShortcutContainer
{
  public bfop(TroopAppShortcutFragment paramTroopAppShortcutFragment, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    super(paramQQAppInterface, paramFragmentActivity, paramContext, paramSessionInfo, paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfop
 * JD-Core Version:    0.7.0.1
 */