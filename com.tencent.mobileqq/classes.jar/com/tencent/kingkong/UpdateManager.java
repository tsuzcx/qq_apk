package com.tencent.kingkong;

import acgp;
import acgq;
import acgr;
import acgt;
import acgz;
import acha;
import achb;
import achc;
import achd;
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
    Object localObject1 = acgt.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((acgt)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      acha localacha = (acha)((Iterator)localObject2).next();
      if ((localacha.g.equals("UPDATED")) || (localacha.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localacha);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      acgp.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((acha)((Iterator)localObject1).next());
      }
      acgp.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(acha paramacha)
  {
    Object localObject = paramacha.jdField_a_of_type_JavaLangString;
    paramacha = paramacha.f;
    acgp.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramacha = acgz.b((String)localObject, paramacha).iterator();
    while (paramacha.hasNext())
    {
      String str = Common.a((String)paramacha.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        acgp.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramacha = Common.a((String)localObject + ".apk");
    localObject = new File(paramacha);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    acgp.a("KingKongUpdateManager", "Delete file failed " + paramacha);
  }
  
  public static void a(acha paramacha, boolean paramBoolean)
  {
    acgt localacgt = acgt.a(jdField_a_of_type_AndroidContentContext);
    String str = paramacha.jdField_a_of_type_JavaLangString;
    if (a(localacgt, paramacha, paramBoolean))
    {
      acgp.a("KingKongUpdateManager", "--> Updating patch : " + paramacha);
      localacgt.a(paramacha);
      if ("DISABLED".equals(paramacha.g)) {
        localacgt.a(paramacha);
      }
    }
    else
    {
      return;
    }
    if (!a(paramacha))
    {
      localacgt.a(paramacha);
      a(paramacha);
      acgp.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramacha)) || (acgz.b(jdField_a_of_type_JavaLangString, paramacha) == null))
    {
      acgp.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramacha.g = "DISABLED";
      localacgt.a(paramacha);
      return;
    }
    paramacha.g = "UPDATED";
    localacgt.a(paramacha);
    acgp.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = acgr.b();
    acgq.jdField_a_of_type_JavaLangString += b;
    acgq.c = acgq.c + b + ".apk";
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
      acgp.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = acha.a(new JSONObject(paramJSONObject.toString()));
      paramContext = acgt.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        acgp.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        acgp.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        acgp.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        acgp.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static boolean a()
  {
    if (!achc.a(jdField_a_of_type_AndroidContentContext).equals(achc.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = acgt.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((acha)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(acgt paramacgt, acha paramacha, boolean paramBoolean)
  {
    if ((paramacgt == null) || (paramacha == null)) {
      return false;
    }
    acha localacha = paramacgt.a(paramacha.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = achc.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramacha.a()).append(", support " + paramacha.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localacha == null)
    {
      paramacgt = "None";
      localStringBuilder2.append(paramacgt).append(", new version " + paramacha.b);
      if ((!paramBoolean) && (paramacha.a()) && (paramacha.b()) && (localacha != null) && (localacha.b.equals(paramacha.b))) {
        break label409;
      }
      if ((paramacha.a()) && (paramacha.b())) {
        break label314;
      }
      if (localacha != null)
      {
        acgp.a("KingKongUpdateManager", "close old patch : " + localacha.jdField_a_of_type_JavaLangString + " , " + localacha.b);
        Common.a(2084, localacha.jdField_a_of_type_JavaLangString, localacha.b);
      }
    }
    for (paramacha.g = "DISABLED";; paramacha.g = "UPDATING")
    {
      acgp.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramacgt = localacha.b;
      break;
      label314:
      if ((localacha != null) && (!localacha.b.equals(paramacha.b))) {
        acgp.a("KingKongUpdateManager", "upgrade patch : from " + localacha.jdField_a_of_type_JavaLangString + " , " + localacha.b + " to " + paramacha.jdField_a_of_type_JavaLangString + " , " + paramacha.b);
      }
    }
    label409:
    acgp.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(acgz paramacgz)
  {
    return paramacgz.a();
  }
  
  public static boolean a(acha paramacha)
  {
    String str1 = paramacha.e;
    String str2 = Common.a(paramacha.jdField_a_of_type_JavaLangString + ".apk");
    if (!achc.c(str1, str2)) {}
    while (!achc.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramacha.jdField_a_of_type_JavaLangString, paramacha.b);
    return true;
  }
  
  private static boolean a(ArrayList<acha> paramArrayList)
  {
    acgp.a("KingKongUpdateManager", "Removing obsoleted patches");
    acgt localacgt = acgt.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      acha localacha = (acha)paramArrayList.next();
      String str = localacha.jdField_a_of_type_JavaLangString;
      b(localacha);
      Common.a(str);
      localacgt.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = acgt.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (acha)localIterator.next();
      if (((acha)localObject).g.equals("UPDATING"))
      {
        acgp.a("KingKongUpdateManager", "Continue udpating " + ((acha)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((acha)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(acha paramacha)
  {
    String str = paramacha.jdField_a_of_type_JavaLangString;
    paramacha = paramacha.f;
    acgp.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramacha = acgz.b(str, paramacha).iterator();
    while (paramacha.hasNext())
    {
      str = Common.b((String)paramacha.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        acgp.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return achc.a(jdField_a_of_type_AndroidContentContext).equals(achc.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(acha paramacha)
  {
    String str1 = paramacha.jdField_a_of_type_JavaLangString;
    paramacha = acgz.a(str1, paramacha.f);
    if ((paramacha == null) || (paramacha.size() == 0))
    {
      acgp.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramacha.size()) {
        break label115;
      }
      String str2 = (String)paramacha.get(i);
      String str3 = Common.a(str2);
      if (!achc.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label115:
    return true;
  }
  
  private static boolean b(ArrayList<acha> paramArrayList)
  {
    acgp.a("KingKongUpdateManager", "Installing updated patches");
    acgt localacgt = acgt.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      acha localacha = (acha)paramArrayList.next();
      Object localObject = localacha.g;
      String str1 = localacha.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        acgp.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        acgp.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = acgz.a(str1, localacha.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!achc.b(str3, str2))
            {
              acgp.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localacha.g = "UPDATING";
              localacgt.a(localacha);
              return false;
            }
          }
        }
        localObject = acgz.b(jdField_a_of_type_JavaLangString, localacha);
        if ((localObject == null) || (!a((acgz)localObject))) {
          acgp.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localacha.g = "READY";
        localacgt.a(localacha);
        acgp.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */