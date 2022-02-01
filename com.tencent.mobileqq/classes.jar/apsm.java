import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class apsm
{
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, 0);
  }
  
  public static ArrayList<String> a(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getString("key_ark_authority_app_list_" + paramString, "");
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        while (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            localArrayList.add(localCharSequence);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ArrayList localArrayList = a(paramString2);
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = 0;
    int n = 0;
    int m;
    for (int i = 0; j < localArrayList.size(); i = m)
    {
      String str = (String)localArrayList.get(j);
      int k = n;
      m = i;
      if (!TextUtils.isEmpty(str))
      {
        if (n > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(str);
        n += 1;
        k = n;
        m = i;
        if (str.equals(paramString1))
        {
          m = 1;
          k = n;
        }
      }
      j += 1;
      n = k;
    }
    if (i == 0)
    {
      if (n > 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append(paramString1);
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putString("key_ark_authority_app_list_" + paramString2, localStringBuilder.toString()).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, apsq paramapsq)
  {
    Object localObject2 = ArkAppCacheMgr.getApplicationDesc(paramString2);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString2;
    }
    localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
    String str = "key_ark_authority_show_dialog" + "_" + (String)localObject1 + "_" + paramString3 + "_" + paramString1;
    boolean bool = ((SharedPreferences)localObject2).getBoolean(str, false);
    if (TextUtils.isEmpty(paramString1)) {
      if (paramapsq != null) {
        paramapsq.a();
      }
    }
    do
    {
      do
      {
        return;
        if ((!bool) && (apsl.a))
        {
          ArkAppCenter.a().postToMainThread(new ArkAppModuleBase.APIAuthority.1((String)localObject1, paramString4, paramString2, paramapsq, paramString3, paramString1));
          ((SharedPreferences)localObject2).edit().putBoolean(str, true).apply();
          a((String)localObject1, paramString1);
          return;
        }
        if (1 != a((String)localObject1, paramString3, paramString1)) {
          break;
        }
      } while (paramapsq == null);
      paramapsq.a();
      return;
    } while (paramapsq == null);
    paramapsq.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsm
 * JD-Core Version:    0.7.0.1
 */