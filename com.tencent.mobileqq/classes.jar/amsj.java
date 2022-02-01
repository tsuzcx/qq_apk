import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class amsj
{
  public String a;
  
  public amsj(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(anct paramanct, Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = amme.a(paramQQAppInterface);
    if ((paramanct == null) || (paramContext == null) || (paramQQAppInterface == null) || (i == 1)) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      paramContext = "apollo_friend_profile_drawer_first" + paramQQAppInterface.getCurrentAccountUin();
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(paramContext, true));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileBubble", 2, "onBubbleShow first");
    }
    anck.a(paramanct, paramString, 3, 0);
    localSharedPreferences.edit().putBoolean(paramContext, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_show", 0, 0, new String[] { "", "", "", this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsj
 * JD-Core Version:    0.7.0.1
 */