import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aphi
  extends aphp
{
  public aphi(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!azzz.a(localRecentUser.uin)) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {}
    label17:
    do
    {
      do
      {
        do
        {
          break label17;
          do
          {
            return;
          } while ((this.jdField_a_of_type_AndroidOsBundle == null) || (paramBundle == null));
          if (QLog.isColorLevel()) {
            QLog.d("ForwardApolloGameMsgOption", 2, "[buildForwardDialig]extra:" + paramBundle.toString() + "mExtraData:" + this.jdField_a_of_type_AndroidOsBundle.toString());
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
          this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
          this.jdField_a_of_type_AndroidOsBundle.putInt("share_result_key", 0);
          paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("apollo.game.invite.from");
          if (paramInt != 4) {
            break;
          }
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_Int = paramBundle.getInt("uintype");
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
          ((SessionInfo)localObject).jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
          paramBundle = new ArkAppMessage();
          paramBundle.appName = "com.tencent.qqpay.b2c_redpacket";
          paramBundle.appView = "redpacket";
          paramBundle.appMinVersion = "1.0.0.1";
          paramBundle.appDesc = ajjy.a(2131638939);
          paramBundle.promptText = ajjy.a(2131638941);
          paramBundle.metaList = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.redpacket_info", "");
          aael.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramBundle);
        } while (this.jdField_a_of_type_AndroidAppActivity == null);
        paramBundle = new Intent();
        paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        if (paramInt != 2) {
          break;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("uin", paramBundle.getString("uin"));
        ((Bundle)localObject).putInt("uintype", paramBundle.getInt("uintype"));
        ((Bundle)localObject).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject).putString("uinname", paramBundle.getString("uinname"));
        ((Bundle)localObject).putBoolean("launchApolloGame", true);
        ((Bundle)localObject).putInt("gameId", this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameid"));
        ((Bundle)localObject).putInt("gameMode", this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameMode"));
        ((Bundle)localObject).putInt("enter", 4);
      } while (this.jdField_a_of_type_AndroidAppActivity == null);
      this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      this.jdField_a_of_type_AndroidContentIntent = aciy.a(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
      this.jdField_a_of_type_AndroidContentIntent.putExtras((Bundle)localObject);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      paramBundle = new Intent();
      paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      Object localObject = new ajdd();
      ((ajdd)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.actionid");
      ((ajdd)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameid");
      ((ajdd)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameMode");
      ((ajdd)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("forward.apollo.roomid");
      ((ajdd)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.gamename");
      ((ajdd)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.actionname");
      ((ajdd)localObject).d = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.msgtype");
      ((ajdd)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.sharejson");
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
      localSessionInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
      localSessionInfo.jdField_a_of_type_Int = paramBundle.getInt("uintype");
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ajdd)localObject, localSessionInfo);
      aipq.a(localSessionInfo.jdField_a_of_type_JavaLangString);
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_msg_sent", ApolloUtil.a(localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 3, new String[] { "" + ((ajdd)localObject).jdField_a_of_type_Int });
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    paramBundle = new Intent();
    paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardApolloGameMsgOption", 2, new Object[] { "[endForwardCallback], isCompleted:", Boolean.valueOf(paramBoolean) });
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("share_result_key", 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphi
 * JD-Core Version:    0.7.0.1
 */