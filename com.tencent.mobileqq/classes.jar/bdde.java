import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class bdde
  extends nac
{
  bdde(bddb parambddb, String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      arzy.a("KEY_STAGE_2_GO_TO_CHAT_D55", bool1);
      this.jdField_a_of_type_Bddb.c();
      if (!this.jdField_a_of_type_Bddb.c) {
        break;
      }
      azmj.b(bddb.a(this.jdField_a_of_type_Bddb), "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext.getString(2131699926), "");
      QQToast.a(this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext, 1, 2131699926, 1).a();
      paramArrayOfByte = new Intent(this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      paramArrayOfByte.addFlags(67108864);
      paramArrayOfByte.addFlags(268435456);
      this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext.startActivity(paramArrayOfByte);
      bddb.c(this.jdField_a_of_type_Bddb);
      return;
    }
    if (this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt == 0) {
      paramInt = 0;
    }
    boolean bool2;
    Object localObject;
    for (;;)
    {
      if (paramInt <= 1)
      {
        paramBundle = (String)this.jdField_a_of_type_Bddb.jdField_a_of_type_JavaUtilHashMap.get("uin");
        if ((paramBundle == null) || (paramBundle.length() < 5) || (SearchBaseActivity.b.matcher(paramBundle).matches()))
        {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131699924, 1).a();
          azmj.b(bddb.a(this.jdField_a_of_type_Bddb), "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext.getString(2131699927), "");
          bddb.c(this.jdField_a_of_type_Bddb);
          return;
          if (paramInt == 25501) {
            paramInt = 1;
          } else {
            paramInt = 2;
          }
        }
        else
        {
          bool2 = ((aloz)bddb.a(this.jdField_a_of_type_Bddb).getManager(51)).b(paramBundle);
          paramArrayOfByte = bdbt.a(bddb.a(this.jdField_a_of_type_Bddb), paramBundle);
          if ((bool2) && (paramInt == 0))
          {
            localObject = new Intent(this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
            ((Intent)localObject).putExtra("uin", paramBundle);
            ((Intent)localObject).putExtra("uintype", 0);
            ((Intent)localObject).putExtra("openid", this.jdField_a_of_type_JavaLangString);
            ((Intent)localObject).putExtra("appid", this.b);
            ((Intent)localObject).putExtra("thridparty_pull_aio", true);
            paramBundle = aekt.a((Intent)localObject, new int[] { 2 });
            paramBundle.putExtra("pull_aio_audio", this.c.equals("audio_chat"));
            paramBundle.putExtra("pull_aio_video", this.c.equals("video_chat"));
            if (paramArrayOfByte != null) {
              paramBundle.putExtra("uinname", paramArrayOfByte);
            }
            this.jdField_a_of_type_Bddb.jdField_a_of_type_AndroidContentContext.startActivity(paramBundle);
          }
        }
      }
    }
    for (;;)
    {
      bddb.c(this.jdField_a_of_type_Bddb);
      return;
      if (paramInt == 1)
      {
        bool1 = true;
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("pull_show_open_id_diff_main", bool1);
        ((Bundle)localObject).putString("uin", paramBundle);
        ((Bundle)localObject).putInt("uintype", 0);
        if (paramArrayOfByte != null) {
          ((Bundle)localObject).putString("uinname", paramArrayOfByte);
        }
        ((Bundle)localObject).putString("openid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putString("appid", this.b);
        azmj.b(bddb.a(this.jdField_a_of_type_Bddb), "dc01160", "", "", "0X800A40F", "0X800A40F", 0, 0, "", "", "", "");
        if (!bool2) {
          break label658;
        }
        ((Bundle)localObject).putBoolean("thridparty_pull_aio", true);
        ((Bundle)localObject).putBoolean("pull_aio_audio", this.c.equals("audio_chat"));
        ((Bundle)localObject).putBoolean("pull_aio_video", this.c.equals("video_chat"));
      }
      for (;;)
      {
        bddb.a(this.jdField_a_of_type_Bddb, (Bundle)localObject);
        bddb.c(this.jdField_a_of_type_Bddb);
        return;
        bool1 = false;
        break;
        label658:
        ((Bundle)localObject).putInt("fragment_id", 1);
        ((Bundle)localObject).putBoolean("pull_add_friend_tip", true);
      }
      paramArrayOfByte = alnx.a(paramArrayOfByte);
      azmj.a(bddb.a(this.jdField_a_of_type_Bddb), "inter", "skip", "inter_fail", "", 1, "", paramArrayOfByte, "", "", "", "", "", "", "");
      paramBundle = new Bundle();
      paramBundle.putBoolean("pull_app_not_privilege", true);
      paramBundle.putString("pull_app_not_privilege_string", paramArrayOfByte);
      bddb.a(this.jdField_a_of_type_Bddb, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdde
 * JD-Core Version:    0.7.0.1
 */