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
import zyw;
import zyx;
import zyy;
import zza;
import zzg;
import zzh;
import zzi;
import zzj;
import zzk;

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
    Object localObject1 = zza.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((zza)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      zzh localzzh = (zzh)((Iterator)localObject2).next();
      if ((localzzh.g.equals("UPDATED")) || (localzzh.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localzzh);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      zyw.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((zzh)((Iterator)localObject1).next());
      }
      zyw.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = zyy.b();
    zyx.jdField_a_of_type_JavaLangString += b;
    zyx.c = zyx.c + b + ".apk";
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
      zyw.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = zzh.a(new JSONObject(paramJSONObject.toString()));
      paramContext = zza.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        zyw.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        zyw.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        zyw.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        zyw.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static void a(zzh paramzzh)
  {
    Object localObject = paramzzh.jdField_a_of_type_JavaLangString;
    paramzzh = paramzzh.f;
    zyw.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramzzh = zzg.b((String)localObject, paramzzh).iterator();
    while (paramzzh.hasNext())
    {
      String str = Common.a((String)paramzzh.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zyw.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramzzh = Common.a((String)localObject + ".apk");
    localObject = new File(paramzzh);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    zyw.a("KingKongUpdateManager", "Delete file failed " + paramzzh);
  }
  
  public static void a(zzh paramzzh, boolean paramBoolean)
  {
    zza localzza = zza.a(jdField_a_of_type_AndroidContentContext);
    String str = paramzzh.jdField_a_of_type_JavaLangString;
    if (a(localzza, paramzzh, paramBoolean))
    {
      zyw.a("KingKongUpdateManager", "--> Updating patch : " + paramzzh);
      localzza.a(paramzzh);
      if ("DISABLED".equals(paramzzh.g)) {
        localzza.a(paramzzh);
      }
    }
    else
    {
      return;
    }
    if (!a(paramzzh))
    {
      localzza.a(paramzzh);
      a(paramzzh);
      zyw.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramzzh)) || (zzg.b(jdField_a_of_type_JavaLangString, paramzzh) == null))
    {
      zyw.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramzzh.g = "DISABLED";
      localzza.a(paramzzh);
      return;
    }
    paramzzh.g = "UPDATED";
    localzza.a(paramzzh);
    zyw.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static boolean a()
  {
    if (!zzj.a(jdField_a_of_type_AndroidContentContext).equals(zzj.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = zza.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((zzh)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(ArrayList<zzh> paramArrayList)
  {
    zyw.a("KingKongUpdateManager", "Removing obsoleted patches");
    zza localzza = zza.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzh localzzh = (zzh)paramArrayList.next();
      String str = localzzh.jdField_a_of_type_JavaLangString;
      b(localzzh);
      Common.a(str);
      localzza.a(str);
    }
    return true;
  }
  
  public static boolean a(zza paramzza, zzh paramzzh, boolean paramBoolean)
  {
    if ((paramzza == null) || (paramzzh == null)) {
      return false;
    }
    zzh localzzh = paramzza.a(paramzzh.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = zzj.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramzzh.a()).append(", support " + paramzzh.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localzzh == null)
    {
      paramzza = "None";
      localStringBuilder2.append(paramzza).append(", new version " + paramzzh.b);
      if ((!paramBoolean) && (paramzzh.a()) && (paramzzh.b()) && (localzzh != null) && (localzzh.b.equals(paramzzh.b))) {
        break label409;
      }
      if ((paramzzh.a()) && (paramzzh.b())) {
        break label314;
      }
      if (localzzh != null)
      {
        zyw.a("KingKongUpdateManager", "close old patch : " + localzzh.jdField_a_of_type_JavaLangString + " , " + localzzh.b);
        Common.a(2084, localzzh.jdField_a_of_type_JavaLangString, localzzh.b);
      }
    }
    for (paramzzh.g = "DISABLED";; paramzzh.g = "UPDATING")
    {
      zyw.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramzza = localzzh.b;
      break;
      label314:
      if ((localzzh != null) && (!localzzh.b.equals(paramzzh.b))) {
        zyw.a("KingKongUpdateManager", "upgrade patch : from " + localzzh.jdField_a_of_type_JavaLangString + " , " + localzzh.b + " to " + paramzzh.jdField_a_of_type_JavaLangString + " , " + paramzzh.b);
      }
    }
    label409:
    zyw.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(zzg paramzzg)
  {
    return paramzzg.a();
  }
  
  public static boolean a(zzh paramzzh)
  {
    String str1 = paramzzh.e;
    String str2 = Common.a(paramzzh.jdField_a_of_type_JavaLangString + ".apk");
    if (!zzj.c(str1, str2)) {}
    while (!zzj.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramzzh.jdField_a_of_type_JavaLangString, paramzzh.b);
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = zza.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (zzh)localIterator.next();
      if (((zzh)localObject).g.equals("UPDATING"))
      {
        zyw.a("KingKongUpdateManager", "Continue udpating " + ((zzh)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((zzh)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(zzh paramzzh)
  {
    String str = paramzzh.jdField_a_of_type_JavaLangString;
    paramzzh = paramzzh.f;
    zyw.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramzzh = zzg.b(str, paramzzh).iterator();
    while (paramzzh.hasNext())
    {
      str = Common.b((String)paramzzh.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zyw.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return zzj.a(jdField_a_of_type_AndroidContentContext).equals(zzj.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(ArrayList<zzh> paramArrayList)
  {
    zyw.a("KingKongUpdateManager", "Installing updated patches");
    zza localzza = zza.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zzh localzzh = (zzh)paramArrayList.next();
      Object localObject = localzzh.g;
      String str1 = localzzh.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        zyw.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        zyw.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = zzg.a(str1, localzzh.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!zzj.b(str3, str2))
            {
              zyw.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localzzh.g = "UPDATING";
              localzza.a(localzzh);
              return false;
            }
          }
        }
        localObject = zzg.b(jdField_a_of_type_JavaLangString, localzzh);
        if ((localObject == null) || (!a((zzg)localObject))) {
          zyw.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localzzh.g = "READY";
        localzza.a(localzzh);
        zyw.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
  
  private static boolean b(zzh paramzzh)
  {
    String str1 = paramzzh.jdField_a_of_type_JavaLangString;
    paramzzh = zzg.a(str1, paramzzh.f);
    if ((paramzzh == null) || (paramzzh.size() == 0))
    {
      zyw.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramzzh.size()) {
        break label115;
      }
      String str2 = (String)paramzzh.get(i);
      String str3 = Common.a(str2);
      if (!zzj.a(Common.a(str1 + ".apk"), str2, str3)) {
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