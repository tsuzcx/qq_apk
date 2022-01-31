package com.tencent.kingkong;

import abui;
import abuj;
import abuk;
import abum;
import abus;
import abut;
import abuu;
import abuv;
import abuw;
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
    Object localObject1 = abum.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((abum)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      abut localabut = (abut)((Iterator)localObject2).next();
      if ((localabut.g.equals("UPDATED")) || (localabut.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localabut);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      abui.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((abut)((Iterator)localObject1).next());
      }
      abui.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(abut paramabut)
  {
    Object localObject = paramabut.jdField_a_of_type_JavaLangString;
    paramabut = paramabut.f;
    abui.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramabut = abus.b((String)localObject, paramabut).iterator();
    while (paramabut.hasNext())
    {
      String str = Common.a((String)paramabut.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        abui.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramabut = Common.a((String)localObject + ".apk");
    localObject = new File(paramabut);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    abui.a("KingKongUpdateManager", "Delete file failed " + paramabut);
  }
  
  public static void a(abut paramabut, boolean paramBoolean)
  {
    abum localabum = abum.a(jdField_a_of_type_AndroidContentContext);
    String str = paramabut.jdField_a_of_type_JavaLangString;
    if (a(localabum, paramabut, paramBoolean))
    {
      abui.a("KingKongUpdateManager", "--> Updating patch : " + paramabut);
      localabum.a(paramabut);
      if ("DISABLED".equals(paramabut.g)) {
        localabum.a(paramabut);
      }
    }
    else
    {
      return;
    }
    if (!a(paramabut))
    {
      localabum.a(paramabut);
      a(paramabut);
      abui.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramabut)) || (abus.b(jdField_a_of_type_JavaLangString, paramabut) == null))
    {
      abui.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramabut.g = "DISABLED";
      localabum.a(paramabut);
      return;
    }
    paramabut.g = "UPDATED";
    localabum.a(paramabut);
    abui.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = abuk.b();
    abuj.jdField_a_of_type_JavaLangString += b;
    abuj.c = abuj.c + b + ".apk";
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
      abui.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = abut.a(new JSONObject(paramJSONObject.toString()));
      paramContext = abum.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        abui.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        abui.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        abui.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        abui.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static boolean a()
  {
    if (!abuv.a(jdField_a_of_type_AndroidContentContext).equals(abuv.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = abum.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((abut)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(abum paramabum, abut paramabut, boolean paramBoolean)
  {
    if ((paramabum == null) || (paramabut == null)) {
      return false;
    }
    abut localabut = paramabum.a(paramabut.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = abuv.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramabut.a()).append(", support " + paramabut.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localabut == null)
    {
      paramabum = "None";
      localStringBuilder2.append(paramabum).append(", new version " + paramabut.b);
      if ((!paramBoolean) && (paramabut.a()) && (paramabut.b()) && (localabut != null) && (localabut.b.equals(paramabut.b))) {
        break label409;
      }
      if ((paramabut.a()) && (paramabut.b())) {
        break label314;
      }
      if (localabut != null)
      {
        abui.a("KingKongUpdateManager", "close old patch : " + localabut.jdField_a_of_type_JavaLangString + " , " + localabut.b);
        Common.a(2084, localabut.jdField_a_of_type_JavaLangString, localabut.b);
      }
    }
    for (paramabut.g = "DISABLED";; paramabut.g = "UPDATING")
    {
      abui.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramabum = localabut.b;
      break;
      label314:
      if ((localabut != null) && (!localabut.b.equals(paramabut.b))) {
        abui.a("KingKongUpdateManager", "upgrade patch : from " + localabut.jdField_a_of_type_JavaLangString + " , " + localabut.b + " to " + paramabut.jdField_a_of_type_JavaLangString + " , " + paramabut.b);
      }
    }
    label409:
    abui.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(abus paramabus)
  {
    return paramabus.a();
  }
  
  public static boolean a(abut paramabut)
  {
    String str1 = paramabut.e;
    String str2 = Common.a(paramabut.jdField_a_of_type_JavaLangString + ".apk");
    if (!abuv.c(str1, str2)) {}
    while (!abuv.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramabut.jdField_a_of_type_JavaLangString, paramabut.b);
    return true;
  }
  
  private static boolean a(ArrayList<abut> paramArrayList)
  {
    abui.a("KingKongUpdateManager", "Removing obsoleted patches");
    abum localabum = abum.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      abut localabut = (abut)paramArrayList.next();
      String str = localabut.jdField_a_of_type_JavaLangString;
      b(localabut);
      Common.a(str);
      localabum.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = abum.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (abut)localIterator.next();
      if (((abut)localObject).g.equals("UPDATING"))
      {
        abui.a("KingKongUpdateManager", "Continue udpating " + ((abut)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((abut)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(abut paramabut)
  {
    String str = paramabut.jdField_a_of_type_JavaLangString;
    paramabut = paramabut.f;
    abui.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramabut = abus.b(str, paramabut).iterator();
    while (paramabut.hasNext())
    {
      str = Common.b((String)paramabut.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        abui.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return abuv.a(jdField_a_of_type_AndroidContentContext).equals(abuv.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(abut paramabut)
  {
    String str1 = paramabut.jdField_a_of_type_JavaLangString;
    paramabut = abus.a(str1, paramabut.f);
    if ((paramabut == null) || (paramabut.size() == 0))
    {
      abui.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramabut.size()) {
        break label115;
      }
      String str2 = (String)paramabut.get(i);
      String str3 = Common.a(str2);
      if (!abuv.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label115:
    return true;
  }
  
  private static boolean b(ArrayList<abut> paramArrayList)
  {
    abui.a("KingKongUpdateManager", "Installing updated patches");
    abum localabum = abum.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      abut localabut = (abut)paramArrayList.next();
      Object localObject = localabut.g;
      String str1 = localabut.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        abui.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        abui.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = abus.a(str1, localabut.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!abuv.b(str3, str2))
            {
              abui.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localabut.g = "UPDATING";
              localabum.a(localabut);
              return false;
            }
          }
        }
        localObject = abus.b(jdField_a_of_type_JavaLangString, localabut);
        if ((localObject == null) || (!a((abus)localObject))) {
          abui.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localabut.g = "READY";
        localabum.a(localabut);
        abui.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */