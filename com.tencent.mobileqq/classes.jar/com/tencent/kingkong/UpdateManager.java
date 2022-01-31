package com.tencent.kingkong;

import abpt;
import abpu;
import abpv;
import abpx;
import abqd;
import abqe;
import abqf;
import abqg;
import abqh;
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
    Object localObject1 = abpx.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((abpx)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      abqe localabqe = (abqe)((Iterator)localObject2).next();
      if ((localabqe.g.equals("UPDATED")) || (localabqe.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localabqe);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      abpt.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((abqe)((Iterator)localObject1).next());
      }
      abpt.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(abqe paramabqe)
  {
    Object localObject = paramabqe.jdField_a_of_type_JavaLangString;
    paramabqe = paramabqe.f;
    abpt.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramabqe = abqd.b((String)localObject, paramabqe).iterator();
    while (paramabqe.hasNext())
    {
      String str = Common.a((String)paramabqe.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        abpt.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramabqe = Common.a((String)localObject + ".apk");
    localObject = new File(paramabqe);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    abpt.a("KingKongUpdateManager", "Delete file failed " + paramabqe);
  }
  
  public static void a(abqe paramabqe, boolean paramBoolean)
  {
    abpx localabpx = abpx.a(jdField_a_of_type_AndroidContentContext);
    String str = paramabqe.jdField_a_of_type_JavaLangString;
    if (a(localabpx, paramabqe, paramBoolean))
    {
      abpt.a("KingKongUpdateManager", "--> Updating patch : " + paramabqe);
      localabpx.a(paramabqe);
      if ("DISABLED".equals(paramabqe.g)) {
        localabpx.a(paramabqe);
      }
    }
    else
    {
      return;
    }
    if (!a(paramabqe))
    {
      localabpx.a(paramabqe);
      a(paramabqe);
      abpt.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramabqe)) || (abqd.b(jdField_a_of_type_JavaLangString, paramabqe) == null))
    {
      abpt.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramabqe.g = "DISABLED";
      localabpx.a(paramabqe);
      return;
    }
    paramabqe.g = "UPDATED";
    localabpx.a(paramabqe);
    abpt.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = abpv.b();
    abpu.jdField_a_of_type_JavaLangString += b;
    abpu.c = abpu.c + b + ".apk";
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
      abpt.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = abqe.a(new JSONObject(paramJSONObject.toString()));
      paramContext = abpx.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        abpt.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        abpt.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        abpt.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        abpt.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static boolean a()
  {
    if (!abqg.a(jdField_a_of_type_AndroidContentContext).equals(abqg.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = abpx.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((abqe)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(abpx paramabpx, abqe paramabqe, boolean paramBoolean)
  {
    if ((paramabpx == null) || (paramabqe == null)) {
      return false;
    }
    abqe localabqe = paramabpx.a(paramabqe.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = abqg.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramabqe.a()).append(", support " + paramabqe.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localabqe == null)
    {
      paramabpx = "None";
      localStringBuilder2.append(paramabpx).append(", new version " + paramabqe.b);
      if ((!paramBoolean) && (paramabqe.a()) && (paramabqe.b()) && (localabqe != null) && (localabqe.b.equals(paramabqe.b))) {
        break label409;
      }
      if ((paramabqe.a()) && (paramabqe.b())) {
        break label314;
      }
      if (localabqe != null)
      {
        abpt.a("KingKongUpdateManager", "close old patch : " + localabqe.jdField_a_of_type_JavaLangString + " , " + localabqe.b);
        Common.a(2084, localabqe.jdField_a_of_type_JavaLangString, localabqe.b);
      }
    }
    for (paramabqe.g = "DISABLED";; paramabqe.g = "UPDATING")
    {
      abpt.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramabpx = localabqe.b;
      break;
      label314:
      if ((localabqe != null) && (!localabqe.b.equals(paramabqe.b))) {
        abpt.a("KingKongUpdateManager", "upgrade patch : from " + localabqe.jdField_a_of_type_JavaLangString + " , " + localabqe.b + " to " + paramabqe.jdField_a_of_type_JavaLangString + " , " + paramabqe.b);
      }
    }
    label409:
    abpt.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(abqd paramabqd)
  {
    return paramabqd.a();
  }
  
  public static boolean a(abqe paramabqe)
  {
    String str1 = paramabqe.e;
    String str2 = Common.a(paramabqe.jdField_a_of_type_JavaLangString + ".apk");
    if (!abqg.c(str1, str2)) {}
    while (!abqg.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramabqe.jdField_a_of_type_JavaLangString, paramabqe.b);
    return true;
  }
  
  private static boolean a(ArrayList<abqe> paramArrayList)
  {
    abpt.a("KingKongUpdateManager", "Removing obsoleted patches");
    abpx localabpx = abpx.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      abqe localabqe = (abqe)paramArrayList.next();
      String str = localabqe.jdField_a_of_type_JavaLangString;
      b(localabqe);
      Common.a(str);
      localabpx.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = abpx.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (abqe)localIterator.next();
      if (((abqe)localObject).g.equals("UPDATING"))
      {
        abpt.a("KingKongUpdateManager", "Continue udpating " + ((abqe)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((abqe)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(abqe paramabqe)
  {
    String str = paramabqe.jdField_a_of_type_JavaLangString;
    paramabqe = paramabqe.f;
    abpt.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramabqe = abqd.b(str, paramabqe).iterator();
    while (paramabqe.hasNext())
    {
      str = Common.b((String)paramabqe.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        abpt.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return abqg.a(jdField_a_of_type_AndroidContentContext).equals(abqg.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(abqe paramabqe)
  {
    String str1 = paramabqe.jdField_a_of_type_JavaLangString;
    paramabqe = abqd.a(str1, paramabqe.f);
    if ((paramabqe == null) || (paramabqe.size() == 0))
    {
      abpt.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramabqe.size()) {
        break label115;
      }
      String str2 = (String)paramabqe.get(i);
      String str3 = Common.a(str2);
      if (!abqg.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label115:
    return true;
  }
  
  private static boolean b(ArrayList<abqe> paramArrayList)
  {
    abpt.a("KingKongUpdateManager", "Installing updated patches");
    abpx localabpx = abpx.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      abqe localabqe = (abqe)paramArrayList.next();
      Object localObject = localabqe.g;
      String str1 = localabqe.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        abpt.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        abpt.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = abqd.a(str1, localabqe.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!abqg.b(str3, str2))
            {
              abpt.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localabqe.g = "UPDATING";
              localabpx.a(localabqe);
              return false;
            }
          }
        }
        localObject = abqd.b(jdField_a_of_type_JavaLangString, localabqe);
        if ((localObject == null) || (!a((abqd)localObject))) {
          abpt.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localabqe.g = "READY";
        localabpx.a(localabqe);
        abpt.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */