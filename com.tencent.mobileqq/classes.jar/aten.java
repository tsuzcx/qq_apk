import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

public class aten
  extends aphy
{
  public aten(UiApiPlugin paramUiApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    String str3;
    String str1;
    Object localObject3;
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.a.key))
    {
      str3 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject3 = paramBundle.getBundle("response");
      localObject2 = paramBundle.getBundle("request");
      if (localObject2 != null) {
        break label88;
      }
      QLog.e("UiApiPlugin", 1, "reqBundle is null, cmd is : " + str3);
    }
    label784:
    label832:
    for (;;)
    {
      return;
      label88:
      Object localObject1 = ((Bundle)localObject2).getString("uin");
      String str2 = ((Bundle)localObject2).getString("action");
      Object localObject4 = new int[5];
      tmp113_111 = localObject4;
      tmp113_111[0] = 1;
      tmp117_113 = tmp113_111;
      tmp117_113[1] = 41;
      tmp122_117 = tmp117_113;
      tmp122_117[2] = 75;
      tmp127_122 = tmp122_117;
      tmp127_122[3] = 21;
      tmp132_127 = tmp127_122;
      tmp132_127[4] = 58;
      tmp132_127;
      if (this.a.mRuntime == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mRuntime == null");
        }
      }
      else
      {
        Activity localActivity = this.a.mRuntime.a();
        if (("checkRelation".equals(str3)) && (localActivity != null) && (localObject1 != null))
        {
          paramBundle = null;
          int k;
          int i;
          if ("openSocialCard".equals(str2))
          {
            k = ((Bundle)localObject2).getInt("source");
            paramBundle = ((Bundle)localObject2).getString("sign");
            int j = ((Bundle)localObject2).getInt("nProfileEntryType");
            i = j;
            if (j == 0) {
              i = 999;
            }
            localObject2 = this.a.mRuntime.a();
            if ((((Bundle)localObject3).getBoolean("result", false)) && (localObject2 != null) && (!((AppInterface)localObject2).getCurrentAccountUin().equals(localObject1)))
            {
              paramBundle = new Intent(localActivity, FriendProfileCardActivity.class);
              localObject1 = new ProfileActivity.AllInOne((String)localObject1, localObject4[k]);
              ((ProfileActivity.AllInOne)localObject1).h = i;
              paramBundle.putExtra("AllInOne", (Parcelable)localObject1);
              localActivity.startActivity(paramBundle);
              paramBundle = "{\"result\": 0}";
            }
          }
          for (;;)
          {
            if ((TextUtils.isEmpty(str1)) || (paramBundle == null)) {
              break label832;
            }
            this.a.callJs(str1, new String[] { paramBundle });
            return;
            localObject1 = new ProfileActivity.AllInOne((String)localObject1, localObject4[k]);
            if (!TextUtils.isEmpty(paramBundle)) {
              ((ProfileActivity.AllInOne)localObject1).b = ChatActivityUtils.a(paramBundle);
            }
            ((ProfileActivity.AllInOne)localObject1).h = i;
            paramBundle = new Intent(localActivity, NearbyPeopleProfileActivity.class);
            paramBundle.putExtra("param_mode", 3);
            paramBundle.putExtra("AllInOne", (Parcelable)localObject1);
            break;
            if ("openStrangerAIO".equals(str2)) {
              if (((Bundle)localObject3).getBoolean("result", false))
              {
                paramBundle = new Intent(localActivity, ChatActivity.class);
                paramBundle.putExtra("uin", (String)localObject1);
                paramBundle.putExtra("uintype", 0);
                localActivity.startActivity(paramBundle);
                paramBundle = "{\"result\": 0}";
              }
              else
              {
                i = ((Bundle)localObject2).getInt("sourceType");
                paramBundle = ((Bundle)localObject2).getString("sign");
                boolean bool = ((Bundle)localObject2).getBoolean("isGroup");
                localObject3 = ((Bundle)localObject2).getString("strangerchat_ext");
                localObject4 = new Intent();
                ((Intent)localObject4).putExtra("uin", (String)localObject1);
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  ((Intent)localObject4).putExtra("strangerchat_ext", (String)localObject3);
                }
                if ((bool) || (!TextUtils.isEmpty(paramBundle)) || (i == 6))
                {
                  if (bool)
                  {
                    ((Intent)localObject4).putExtra("open_chatfragment", true);
                    ((Intent)localObject4).setClass(localActivity, SplashActivity.class);
                    i = 1;
                    if (((Bundle)localObject2).getInt("fromAIO") >= 1) {
                      ((Intent)localObject4).addFlags(67108864);
                    }
                    ((Intent)localObject4).putExtra("uintype", i);
                    if (i != 1001) {
                      break label784;
                    }
                    ((Intent)localObject4).putExtra("rich_accost_sig", ChatActivityUtils.a(paramBundle));
                  }
                  for (;;)
                  {
                    localActivity.startActivity((Intent)localObject4);
                    paramBundle = "{\"result\": 0}";
                    break;
                    ((Intent)localObject4).setClass(localActivity, ChatActivity.class);
                    switch (i)
                    {
                    case 5: 
                    case 7: 
                    default: 
                      i = 1001;
                      break;
                    case 0: 
                      i = 0;
                      break;
                    case 1: 
                      i = 1001;
                      break;
                    case 2: 
                      i = 1010;
                      break;
                    case 3: 
                      i = 1;
                      break;
                    case 4: 
                      i = 1020;
                      break;
                    case 6: 
                      i = 10002;
                      break;
                    case 8: 
                      i = 10004;
                      break;
                      if (i == 1010) {
                        ((Intent)localObject4).putExtra("rich_date_sig", ChatActivityUtils.a(paramBundle));
                      } else if (i == 10004) {
                        ((Intent)localObject4).putExtra("rich_movie_sig", ChatActivityUtils.a(paramBundle));
                      }
                      break;
                    }
                  }
                }
                paramBundle = "{\"result\": -2, \"message\":\"Can't send message to a stranger without sign!\"}";
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aten
 * JD-Core Version:    0.7.0.1
 */