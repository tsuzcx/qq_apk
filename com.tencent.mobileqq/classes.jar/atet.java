import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class atet
  implements aszl, Manager
{
  QQAppInterface a;
  
  public atet(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static Bundle a(IVPluginInfo paramIVPluginInfo, aszh paramaszh)
  {
    int m = 0;
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localObject1 = ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
        str2 = ((AppRuntime)localObject1).getAccount();
        localObject2 = (alto)((AppRuntime)localObject1).getManager(51);
        localObject3 = ((alto)localObject2).e(str2);
        if (localObject3 == null) {
          break label470;
        }
        localObject1 = ((Friends)localObject3).name;
        j = ((Friends)localObject3).gender;
        i = ((Friends)localObject3).age;
        localObject3 = ((alto)localObject2).b(str2);
        if (localObject3 == null) {
          break label452;
        }
        k = (int)((Card)localObject3).lBirthday;
        localObject2 = ((Card)localObject3).strCountry;
        str1 = ((Card)localObject3).strProvince;
        localObject3 = ((Card)localObject3).strCity;
      }
      catch (Exception paramIVPluginInfo)
      {
        String str2;
        paramIVPluginInfo.printStackTrace();
        return localBundle;
      }
      localBundle.putString("nickname", (String)localObject1);
      localBundle.putLong("roomid", paramIVPluginInfo.a);
      localBundle.putInt("authtype", 1);
      localBundle.putString("authid", paramaszh.a().b);
      localBundle.putInt("gender", j);
      localBundle.putInt("vastype", 2);
      localBundle.putLong("hostid", Long.parseLong(str2));
      localBundle.putString("authkey", paramaszh.a().a);
      localBundle.putString("appid", paramIVPluginInfo.b);
      localBundle.putString("vasname", paramIVPluginInfo.g);
      localBundle.putString("userdata", paramIVPluginInfo.d);
      localBundle.putInt("fromid", Integer.parseInt(paramIVPluginInfo.e));
      localBundle.putInt("age", i);
      localBundle.putInt("birthyear", n);
      localBundle.putInt("birthmonth", m);
      localBundle.putInt("birthday", k);
      localBundle.putBoolean("loghost", true);
      localBundle.putBoolean("reporthost", true);
      localBundle.putString("backType", paramIVPluginInfo.h);
      localBundle.putInt("isGroupCode", paramIVPluginInfo.c);
      localBundle.putString("openType", paramIVPluginInfo.i);
      localBundle.putString("extra", paramIVPluginInfo.j);
      localBundle.putString("payToken", paramaszh.a().c);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localBundle.putString("addrCountry", (String)localObject2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("addrProv", str1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localBundle.putString("addrCity", (String)localObject3);
      }
      return localBundle;
      int n = k >>> 16;
      m = (0xFF00 & k) >>> 8;
      k &= 0xFF;
      continue;
      label452:
      Object localObject2 = "";
      int k = 0;
      String str1 = "";
      Object localObject3 = "";
      break label481;
      label470:
      int i = 0;
      int j = 0;
      Object localObject1 = "";
      continue;
      label481:
      if (k == 0)
      {
        n = 1995;
        k = 0;
      }
    }
  }
  
  public void a() {}
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt) {}
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XProxy|ODPROXY", 2, "onDestroy");
    }
    a();
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atet
 * JD-Core Version:    0.7.0.1
 */