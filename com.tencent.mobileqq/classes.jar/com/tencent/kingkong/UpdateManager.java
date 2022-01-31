package com.tencent.kingkong;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import zyz;
import zza;
import zzb;
import zzd;
import zzj;
import zzk;
import zzl;
import zzm;
import zzn;

public class UpdateManager
{
  public static Context a;
  public static UpdateManager.UpdateThread a;
  public static String a;
  public static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a()
  {
    Object localObject1 = zzd.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((zzd)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      zzk localzzk = (zzk)((Iterator)localObject2).next();
      if ((localzzk.g.equals("UPDATED")) || (localzzk.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localzzk);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      zyz.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((zzk)((Iterator)localObject1).next());
      }
      zyz.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = zzb.b();
    zza.jdField_a_of_type_JavaLangString += b;
    zza.c = zza.c + b + ".apk";
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread = new UpdateManager.UpdateThread();
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread.start();
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!Common.a()) {}
    do
    {
      return;
      if ((jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread != null) && (UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread) != null)) {
        break;
      }
      zyz.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = zzk.a(new JSONObject(paramJSONObject.toString()));
      paramContext = zzd.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        zyz.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        zyz.a("KingKongUpdateManager", "Update Exception : " + paramContext);
      }
    }
    paramContext = paramJSONObject.toString();
    paramJSONObject = UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putString("PATCH_JSON_STRING", paramContext);
    localBundle.putBoolean("PATCH_FORCE_UPDATE", paramBoolean);
    paramJSONObject.setData(localBundle);
    UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).sendMessage(paramJSONObject);
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        zyz.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
        if (localJSONObject != null) {
          a(BaseApplicationImpl.sApplication, localJSONObject, false);
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zyz.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static void a(zzk paramzzk)
  {
    Object localObject = paramzzk.jdField_a_of_type_JavaLangString;
    paramzzk = paramzzk.f;
    zyz.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramzzk = zzj.b((String)localObject, paramzzk).iterator();
    while (paramzzk.hasNext())
    {
      String str = Common.a((String)paramzzk.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zyz.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramzzk = Common.a((String)localObject + ".apk");
    localObject = new File(paramzzk);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    zyz.a("KingKongUpdateManager", "Delete file failed " + paramzzk);
  }
  
  public static void a(zzk paramzzk, boolean paramBoolean)
  {
    zzd localzzd = zzd.a(jdField_a_of_type_AndroidContentContext);
    String str = paramzzk.jdField_a_of_type_JavaLangString;
    if (a(localzzd, paramzzk, paramBoolean))
    {
      zyz.a("KingKongUpdateManager", "--> Updating patch : " + paramzzk);
      localzzd.a(paramzzk);
      if ("DISABLED".equals(paramzzk.g)) {
        localzzd.a(paramzzk);
      }
    }
    else
    {
      return;
    }
    if (!a(paramzzk))
    {
      localzzd.a(paramzzk);
      a(paramzzk);
      zyz.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramzzk)) || (zzj.b(jdField_a_of_type_JavaLangString, paramzzk) == null))
    {
      zyz.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramzzk.g = "DISABLED";
      localzzd.a(paramzzk);
      return;
    }
    paramzzk.g = "UPDATED";
    localzzd.a(paramzzk);
    zyz.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static boolean a()
  {
    if (!zzm.a(jdField_a_of_type_AndroidContentContext).equals(zzm.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = zzd.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((zzk)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(ArrayList<zzk> paramArrayList)
  {
    zyz.a("KingKongUpdateManager", "Removing obsoleted patches");
    zzd localzzd = zzd.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzk localzzk = (zzk)paramArrayList.next();
      String str = localzzk.jdField_a_of_type_JavaLangString;
      b(localzzk);
      Common.a(str);
      localzzd.a(str);
    }
    return true;
  }
  
  public static boolean a(zzd paramzzd, zzk paramzzk, boolean paramBoolean)
  {
    if ((paramzzd == null) || (paramzzk == null)) {
      return false;
    }
    zzk localzzk = paramzzd.a(paramzzk.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = zzm.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramzzk.a()).append(", support " + paramzzk.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localzzk == null)
    {
      paramzzd = "None";
      localStringBuilder2.append(paramzzd).append(", new version " + paramzzk.b);
      if ((!paramBoolean) && (paramzzk.a()) && (paramzzk.b()) && (localzzk != null) && (localzzk.b.equals(paramzzk.b))) {
        break label409;
      }
      if ((paramzzk.a()) && (paramzzk.b())) {
        break label314;
      }
      if (localzzk != null)
      {
        zyz.a("KingKongUpdateManager", "close old patch : " + localzzk.jdField_a_of_type_JavaLangString + " , " + localzzk.b);
        Common.a(2084, localzzk.jdField_a_of_type_JavaLangString, localzzk.b);
      }
    }
    for (paramzzk.g = "DISABLED";; paramzzk.g = "UPDATING")
    {
      zyz.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramzzd = localzzk.b;
      break;
      label314:
      if ((localzzk != null) && (!localzzk.b.equals(paramzzk.b))) {
        zyz.a("KingKongUpdateManager", "upgrade patch : from " + localzzk.jdField_a_of_type_JavaLangString + " , " + localzzk.b + " to " + paramzzk.jdField_a_of_type_JavaLangString + " , " + paramzzk.b);
      }
    }
    label409:
    zyz.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(zzj paramzzj)
  {
    return paramzzj.a();
  }
  
  public static boolean a(zzk paramzzk)
  {
    String str1 = paramzzk.e;
    String str2 = Common.a(paramzzk.jdField_a_of_type_JavaLangString + ".apk");
    if (!zzm.c(str1, str2)) {}
    while (!zzm.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramzzk.jdField_a_of_type_JavaLangString, paramzzk.b);
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = zzd.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (zzk)localIterator.next();
      if (((zzk)localObject).g.equals("UPDATING"))
      {
        zyz.a("KingKongUpdateManager", "Continue udpating " + ((zzk)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((zzk)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(zzk paramzzk)
  {
    String str = paramzzk.jdField_a_of_type_JavaLangString;
    paramzzk = paramzzk.f;
    zyz.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramzzk = zzj.b(str, paramzzk).iterator();
    while (paramzzk.hasNext())
    {
      str = Common.b((String)paramzzk.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zyz.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return zzm.a(jdField_a_of_type_AndroidContentContext).equals(zzm.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(ArrayList<zzk> paramArrayList)
  {
    zyz.a("KingKongUpdateManager", "Installing updated patches");
    zzd localzzd = zzd.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzk localzzk = (zzk)paramArrayList.next();
      Object localObject = localzzk.g;
      String str1 = localzzk.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        zyz.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        zyz.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = zzj.a(str1, localzzk.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!zzm.b(str3, str2))
            {
              zyz.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localzzk.g = "UPDATING";
              localzzd.a(localzzk);
              return false;
            }
          }
        }
        localObject = zzj.b(jdField_a_of_type_JavaLangString, localzzk);
        if ((localObject == null) || (!a((zzj)localObject))) {
          zyz.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localzzk.g = "READY";
        localzzd.a(localzzk);
        zyz.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
  
  private static boolean b(zzk paramzzk)
  {
    String str1 = paramzzk.jdField_a_of_type_JavaLangString;
    paramzzk = zzj.a(str1, paramzzk.f);
    if ((paramzzk == null) || (paramzzk.size() == 0))
    {
      zyz.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramzzk.size()) {
        break label115;
      }
      String str2 = (String)paramzzk.get(i);
      String str3 = Common.a(str2);
      if (!zzm.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label115:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */