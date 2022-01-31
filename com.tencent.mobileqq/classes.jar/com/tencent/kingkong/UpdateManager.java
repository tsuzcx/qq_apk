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
import zph;
import zpi;
import zpj;
import zpl;
import zpr;
import zps;
import zpt;
import zpu;
import zpv;

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
    Object localObject1 = zpl.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((zpl)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      zps localzps = (zps)((Iterator)localObject2).next();
      if ((localzps.g.equals("UPDATED")) || (localzps.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localzps);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      zph.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((zps)((Iterator)localObject1).next());
      }
      zph.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = zpj.b();
    zpi.jdField_a_of_type_JavaLangString += b;
    zpi.c = zpi.c + b + ".apk";
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
      zph.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = zps.a(new JSONObject(paramJSONObject.toString()));
      paramContext = zpl.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        zph.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        zph.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        zph.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        zph.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static void a(zps paramzps)
  {
    Object localObject = paramzps.jdField_a_of_type_JavaLangString;
    paramzps = paramzps.f;
    zph.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramzps = zpr.b((String)localObject, paramzps).iterator();
    while (paramzps.hasNext())
    {
      String str = Common.a((String)paramzps.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zph.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramzps = Common.a((String)localObject + ".apk");
    localObject = new File(paramzps);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    zph.a("KingKongUpdateManager", "Delete file failed " + paramzps);
  }
  
  public static void a(zps paramzps, boolean paramBoolean)
  {
    zpl localzpl = zpl.a(jdField_a_of_type_AndroidContentContext);
    String str = paramzps.jdField_a_of_type_JavaLangString;
    if (a(localzpl, paramzps, paramBoolean))
    {
      zph.a("KingKongUpdateManager", "--> Updating patch : " + paramzps);
      localzpl.a(paramzps);
      if ("DISABLED".equals(paramzps.g)) {
        localzpl.a(paramzps);
      }
    }
    else
    {
      return;
    }
    if (!a(paramzps))
    {
      localzpl.a(paramzps);
      a(paramzps);
      zph.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramzps)) || (zpr.b(jdField_a_of_type_JavaLangString, paramzps) == null))
    {
      zph.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramzps.g = "DISABLED";
      localzpl.a(paramzps);
      return;
    }
    paramzps.g = "UPDATED";
    localzpl.a(paramzps);
    zph.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static boolean a()
  {
    if (!zpu.a(jdField_a_of_type_AndroidContentContext).equals(zpu.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = zpl.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((zps)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(ArrayList<zps> paramArrayList)
  {
    zph.a("KingKongUpdateManager", "Removing obsoleted patches");
    zpl localzpl = zpl.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zps localzps = (zps)paramArrayList.next();
      String str = localzps.jdField_a_of_type_JavaLangString;
      b(localzps);
      Common.a(str);
      localzpl.a(str);
    }
    return true;
  }
  
  public static boolean a(zpl paramzpl, zps paramzps, boolean paramBoolean)
  {
    if ((paramzpl == null) || (paramzps == null)) {
      return false;
    }
    zps localzps = paramzpl.a(paramzps.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = zpu.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramzps.a()).append(", support " + paramzps.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localzps == null)
    {
      paramzpl = "None";
      localStringBuilder2.append(paramzpl).append(", new version " + paramzps.b);
      if ((!paramBoolean) && (paramzps.a()) && (paramzps.b()) && (localzps != null) && (localzps.b.equals(paramzps.b))) {
        break label409;
      }
      if ((paramzps.a()) && (paramzps.b())) {
        break label314;
      }
      if (localzps != null)
      {
        zph.a("KingKongUpdateManager", "close old patch : " + localzps.jdField_a_of_type_JavaLangString + " , " + localzps.b);
        Common.a(2084, localzps.jdField_a_of_type_JavaLangString, localzps.b);
      }
    }
    for (paramzps.g = "DISABLED";; paramzps.g = "UPDATING")
    {
      zph.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramzpl = localzps.b;
      break;
      label314:
      if ((localzps != null) && (!localzps.b.equals(paramzps.b))) {
        zph.a("KingKongUpdateManager", "upgrade patch : from " + localzps.jdField_a_of_type_JavaLangString + " , " + localzps.b + " to " + paramzps.jdField_a_of_type_JavaLangString + " , " + paramzps.b);
      }
    }
    label409:
    zph.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(zpr paramzpr)
  {
    return paramzpr.a();
  }
  
  public static boolean a(zps paramzps)
  {
    String str1 = paramzps.e;
    String str2 = Common.a(paramzps.jdField_a_of_type_JavaLangString + ".apk");
    if (!zpu.c(str1, str2)) {}
    while (!zpu.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramzps.jdField_a_of_type_JavaLangString, paramzps.b);
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = zpl.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (zps)localIterator.next();
      if (((zps)localObject).g.equals("UPDATING"))
      {
        zph.a("KingKongUpdateManager", "Continue udpating " + ((zps)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((zps)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(zps paramzps)
  {
    String str = paramzps.jdField_a_of_type_JavaLangString;
    paramzps = paramzps.f;
    zph.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramzps = zpr.b(str, paramzps).iterator();
    while (paramzps.hasNext())
    {
      str = Common.b((String)paramzps.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        zph.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return zpu.a(jdField_a_of_type_AndroidContentContext).equals(zpu.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(ArrayList<zps> paramArrayList)
  {
    zph.a("KingKongUpdateManager", "Installing updated patches");
    zpl localzpl = zpl.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      zps localzps = (zps)paramArrayList.next();
      Object localObject = localzps.g;
      String str1 = localzps.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        zph.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        zph.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = zpr.a(str1, localzps.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!zpu.b(str3, str2))
            {
              zph.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localzps.g = "UPDATING";
              localzpl.a(localzps);
              return false;
            }
          }
        }
        localObject = zpr.b(jdField_a_of_type_JavaLangString, localzps);
        if ((localObject == null) || (!a((zpr)localObject))) {
          zph.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localzps.g = "READY";
        localzpl.a(localzps);
        zph.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
  
  private static boolean b(zps paramzps)
  {
    String str1 = paramzps.jdField_a_of_type_JavaLangString;
    paramzps = zpr.a(str1, paramzps.f);
    if ((paramzps == null) || (paramzps.size() == 0))
    {
      zph.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramzps.size()) {
        break label115;
      }
      String str2 = (String)paramzps.get(i);
      String str3 = Common.a(str2);
      if (!zpu.a(Common.a(str1 + ".apk"), str2, str3)) {
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