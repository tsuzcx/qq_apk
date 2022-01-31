import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor.1;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class bdes
{
  @NonNull
  private static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    if (paramDiscussionInfo == null) {
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return "";
    }
    if (paramDiscussionInfo.isOwnerOrInheritOwner(paramQQAppInterface)) {
      return "0";
    }
    return "1";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return "0";
      }
      if (paramString.isAdmin()) {
        return "1";
      }
    }
    return "2";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return a(((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1, paramString2));
  }
  
  public static String a(TroopInfo paramTroopInfo, AppRuntime paramAppRuntime)
  {
    String str2 = "";
    String str1 = str2;
    if (paramAppRuntime != null)
    {
      str1 = str2;
      if (paramTroopInfo != null)
      {
        paramAppRuntime = paramAppRuntime.getAccount();
        str1 = str2;
        if (!TextUtils.isEmpty(paramAppRuntime))
        {
          if (!paramTroopInfo.isTroopOwner(paramAppRuntime)) {
            break label42;
          }
          str1 = "0";
        }
      }
    }
    return str1;
    label42:
    if (paramTroopInfo.isTroopAdmin(paramAppRuntime)) {
      return "1";
    }
    return "2";
  }
  
  public static String a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {
      return "";
    }
    switch (paramTroopMemberInfo.level)
    {
    default: 
      return "";
    case 335: 
      return "student";
    case 334: 
      return "parent";
    case 333: 
      return "teacher";
    }
    return "classteacher";
  }
  
  public static String a(TroopInfoData paramTroopInfoData)
  {
    if (paramTroopInfoData == null) {
      return "";
    }
    if (paramTroopInfoData.bOwner) {
      return "0";
    }
    if (paramTroopInfoData.bAdmin) {
      return "1";
    }
    if (paramTroopInfoData.isMember) {
      return "2";
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject).b(paramString1, paramQQAppInterface.getCurrentAccountUin());
    localObject = ((TroopManager)localObject).c(paramString1);
    a("Grp_edu", paramString2, paramString3, 0, 0, new String[] { paramString1, a(localTroopMemberInfo), a((TroopInfo)localObject, paramQQAppInterface), String.valueOf(((TroopInfo)localObject).dwGroupClassExt) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if ((paramQQAppInterface == null) || (paramVarArgs == null) || (paramVarArgs.length < 4)) {
      return;
    }
    if (((TroopManager)paramQQAppInterface.getManager(52)).a(paramString1, paramQQAppInterface.getCurrentAccountUin()) == null)
    {
      ThreadManagerV2.excute(new TroopReportor.1(paramString2, paramString3, paramInt1, paramInt2, paramVarArgs, paramQQAppInterface, paramString1), 32, null, true);
      return;
    }
    a("Grp_edu", paramString2, paramString3, paramInt1, paramInt2, new String[] { paramVarArgs[0], a(paramQQAppInterface, paramString1, paramQQAppInterface.getCurrentAccountUin()), paramVarArgs[2], paramVarArgs[3] });
  }
  
  public static void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("department");
      String str1 = ((JSONObject)localObject).getString("opType");
      String str2 = ((JSONObject)localObject).getString("opName");
      int i = ((JSONObject)localObject).getInt("opIn");
      int j = ((JSONObject)localObject).getInt("opResult");
      localObject = a(((JSONObject)localObject).getJSONObject("remains"));
      if ((localObject != null) && (localObject.length >= 4)) {
        a(paramString, str1, str2, i, j, new String[] { localObject[0], localObject[1], localObject[2], localObject[3] });
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if (paramInt3 == 10001) {
      str = "1";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {}
      label202:
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt3 == 10002)
            {
              str = "2";
              break;
            }
            if (paramInt3 == 10003)
            {
              str = "3";
              break;
            }
            if (paramInt3 == 10004)
            {
              str = "4";
              break;
            }
            if ((paramInt3 == 10018) || (paramInt3 == 10017))
            {
              str = "6";
              break;
            }
            if ((paramInt3 == 10020) || (paramInt3 == 10019))
            {
              str = "7";
              break;
            }
            if ((paramInt3 != 10022) && (paramInt3 != 10021)) {
              break label266;
            }
            str = "8";
            break;
            if (QLog.isColorLevel()) {
              QLog.d("TroopReportor", 2, "reportRecSrc");
            }
            if (paramInt1 != 0) {
              break label202;
            }
            if (paramInt2 == 1)
            {
              a("Grp_set_new", "recommend", "exp_new", 3, 0, new String[] { paramString, str });
              return;
            }
          } while (paramInt2 != 0);
          a("Grp_set_new", "recommend", "clkjoin_new", 3, 0, new String[] { paramString, str });
          return;
        } while (paramInt1 != 1);
        if (paramInt2 == 1)
        {
          a("Grp_join_new", "person_data", "exp_new", 3, 0, new String[] { paramString, str });
          return;
        }
      } while (paramInt2 != 0);
      a("Grp_join_new", "recommend", "clkjoin_new", 3, 0, new String[] { paramString, str });
      return;
      label266:
      str = null;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (wxe.a()) {
        wxe.c("TroopReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      azqs.b(null, "dc00899", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopReportor", 2, localException, new Object[0]);
        }
      }
    }
  }
  
  public static String[] a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    String[] arrayOfString;
    for (;;)
    {
      return localObject;
      arrayOfString = new String[4];
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      arrayOfString[2] = "";
      arrayOfString[3] = "";
      try
      {
        if (paramJSONObject.has("r1")) {
          arrayOfString[0] = paramJSONObject.getString("r1");
        }
        if (paramJSONObject.has("r2")) {
          arrayOfString[1] = paramJSONObject.getString("r2");
        }
        if (paramJSONObject.has("r3")) {
          arrayOfString[2] = paramJSONObject.getString("r3");
        }
        localObject = arrayOfString;
        if (paramJSONObject.has("r4"))
        {
          arrayOfString[3] = paramJSONObject.getString("r4");
          return arrayOfString;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdes
 * JD-Core Version:    0.7.0.1
 */