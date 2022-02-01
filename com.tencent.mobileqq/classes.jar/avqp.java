import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;

public class avqp
  implements aaob
{
  public avqp(UiApiPlugin paramUiApiPlugin, Integer paramInteger, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isSuccess", false))
    {
      int i = paramBundle.getInt("appid");
      Object localObject = paramBundle.getString("openId");
      if ((i != this.jdField_a_of_type_JavaLangInteger.intValue()) || (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {
        break label178;
      }
      str1 = paramBundle.getString("uin");
      bool = paramBundle.getBoolean("isFriend", false);
      localObject = paramBundle.getString("nickName");
      str2 = paramBundle.getString("remark");
      if (!TextUtils.isEmpty(str1))
      {
        if (!bool) {
          break label163;
        }
        paramBundle = new ProfileActivity.AllInOne(str1, 1);
        paramBundle.h = ((String)localObject);
        paramBundle.i = str2;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(), FriendProfileCardActivity.class);
        ((Intent)localObject).putExtra("AllInOne", paramBundle);
        ((Intent)localObject).addFlags(536870912);
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a().startActivity((Intent)localObject);
      }
    }
    label163:
    label178:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str1;
        boolean bool;
        String str2;
        return;
        paramBundle = new ProfileActivity.AllInOne(str1, 105);
      }
    }
    QLog.d("UiApiPlugin", 2, "appId != appID || !openId.equals(openID)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqp
 * JD-Core Version:    0.7.0.1
 */