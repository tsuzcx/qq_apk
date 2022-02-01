import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.PromptDialogActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_StartGameMessage;

class aubo
  implements aubp
{
  aubo(aubl paramaubl, long paramLong1, SubMsgType0xaa.GameTeam_StartGameMessage paramGameTeam_StartGameMessage, long paramLong2, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)aubl.a(this.jdField_a_of_type_Aubl).get();
    if (localQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("result").getJSONArray("team_list");
        if (paramString.length() <= 0) {
          continue;
        }
        paramString = paramString.getJSONObject(0);
        int i;
        int j;
        boolean bool;
        label426:
        return;
      }
      catch (JSONException paramString)
      {
        try
        {
          i = paramString.getInt("expire");
          j = i;
          if (i <= 0) {
            j = aubl.a;
          }
          i = paramString.getInt("status");
          if (QLog.isColorLevel()) {
            QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, getTeamContext finished, deltaTime = " + this.jdField_a_of_type_Long + ", expire = " + j + ", status = " + i);
          }
          if (this.jdField_a_of_type_Long < j)
          {
            paramString = paramString.getJSONObject("leader");
            bool = localQQAppInterface.getCurrentAccountUin().equals(paramString.getString("uin"));
            if ((i > 0) && (i < 5))
            {
              paramString = new Intent(localQQAppInterface.getApp().getApplicationContext(), PromptDialogActivity.class);
              paramString.addFlags(268435456);
              paramString.putExtra("title", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_title.get());
              paramString.putExtra("summary", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_summary.get());
              paramString.putExtra("picUrl", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_picUrl.get());
              paramString.putExtra("appid", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_appid.get());
              paramString.putExtra("packageName", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_packageName.get());
              paramString.putExtra("gamedata", this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xaaSubMsgType0xaa$GameTeam_StartGameMessage.str_gamedata.get());
              paramString.putExtra("leader", bool);
              paramString.putExtra("createMsgTime", this.b);
              localQQAppInterface.getApp().startActivity(paramString);
              if (!this.jdField_a_of_type_Boolean) {
                break label426;
              }
              bhvw.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "0", false);
              return;
              paramString = paramString;
              if (QLog.isColorLevel()) {
                QLog.d("GamePartyManager", 2, "handlePushMsg_StartGame, getTeamContext finished, parse json error e = " + paramString);
              }
            }
          }
          if (this.jdField_a_of_type_Boolean)
          {
            bhvw.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2044", "1", false);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            i = 0;
          }
          bhvw.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "0", false);
          return;
        }
        bhvw.a().a(localQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2043", "1", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubo
 * JD-Core Version:    0.7.0.1
 */