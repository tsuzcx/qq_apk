package com.tencent.kingkong;

import acwx;
import acwy;
import acwz;
import acxb;
import acxh;
import acxi;
import acxj;
import acxk;
import acxl;
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
    Object localObject1 = acxb.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((acxb)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      acxi localacxi = (acxi)((Iterator)localObject2).next();
      if ((localacxi.g.equals("UPDATED")) || (localacxi.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localacxi);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      acwx.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((acxi)((Iterator)localObject1).next());
      }
      acwx.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(acxi paramacxi)
  {
    Object localObject = paramacxi.jdField_a_of_type_JavaLangString;
    paramacxi = paramacxi.f;
    acwx.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramacxi = acxh.b((String)localObject, paramacxi).iterator();
    while (paramacxi.hasNext())
    {
      String str = Common.a((String)paramacxi.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        acwx.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramacxi = Common.a((String)localObject + ".apk");
    localObject = new File(paramacxi);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    acwx.a("KingKongUpdateManager", "Delete file failed " + paramacxi);
  }
  
  public static void a(acxi paramacxi, boolean paramBoolean)
  {
    acxb localacxb = acxb.a(jdField_a_of_type_AndroidContentContext);
    String str = paramacxi.jdField_a_of_type_JavaLangString;
    if (a(localacxb, paramacxi, paramBoolean))
    {
      acwx.a("KingKongUpdateManager", "--> Updating patch : " + paramacxi);
      localacxb.a(paramacxi);
      if ("DISABLED".equals(paramacxi.g)) {
        localacxb.a(paramacxi);
      }
    }
    else
    {
      return;
    }
    if (!a(paramacxi))
    {
      localacxb.a(paramacxi);
      a(paramacxi);
      acwx.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramacxi)) || (acxh.b(jdField_a_of_type_JavaLangString, paramacxi) == null))
    {
      acwx.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramacxi.g = "DISABLED";
      localacxb.a(paramacxi);
      return;
    }
    paramacxi.g = "UPDATED";
    localacxb.a(paramacxi);
    acwx.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = acwz.b();
    acwy.jdField_a_of_type_JavaLangString += b;
    acwy.c = acwy.c + b + ".apk";
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
      acwx.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = acxi.a(new JSONObject(paramJSONObject.toString()));
      paramContext = acxb.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        acwx.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.a(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        acwx.a("KingKongUpdateManager", "Update Exception : " + paramContext);
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
        acwx.a("PatchLogTag", "KingKongUpdateManager Update get DPC config=" + paramString);
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
        acwx.a("PatchLogTag", "KingKongUpdateManager Update get DPC config exception=" + localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public static boolean a()
  {
    if (!acxk.a(jdField_a_of_type_AndroidContentContext).equals(acxk.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = acxb.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((acxi)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(acxb paramacxb, acxi paramacxi, boolean paramBoolean)
  {
    if ((paramacxb == null) || (paramacxi == null)) {
      return false;
    }
    acxi localacxi = paramacxb.a(paramacxi.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = acxk.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramacxi.a()).append(", support " + paramacxi.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localacxi == null)
    {
      paramacxb = "None";
      localStringBuilder2.append(paramacxb).append(", new version " + paramacxi.b);
      if ((!paramBoolean) && (paramacxi.a()) && (paramacxi.b()) && (localacxi != null) && (localacxi.b.equals(paramacxi.b))) {
        break label409;
      }
      if ((paramacxi.a()) && (paramacxi.b())) {
        break label314;
      }
      if (localacxi != null)
      {
        acwx.a("KingKongUpdateManager", "close old patch : " + localacxi.jdField_a_of_type_JavaLangString + " , " + localacxi.b);
        Common.a(2084, localacxi.jdField_a_of_type_JavaLangString, localacxi.b);
      }
    }
    for (paramacxi.g = "DISABLED";; paramacxi.g = "UPDATING")
    {
      acwx.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramacxb = localacxi.b;
      break;
      label314:
      if ((localacxi != null) && (!localacxi.b.equals(paramacxi.b))) {
        acwx.a("KingKongUpdateManager", "upgrade patch : from " + localacxi.jdField_a_of_type_JavaLangString + " , " + localacxi.b + " to " + paramacxi.jdField_a_of_type_JavaLangString + " , " + paramacxi.b);
      }
    }
    label409:
    acwx.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(acxh paramacxh)
  {
    return paramacxh.a();
  }
  
  public static boolean a(acxi paramacxi)
  {
    String str1 = paramacxi.e;
    String str2 = Common.a(paramacxi.jdField_a_of_type_JavaLangString + ".apk");
    if (!acxk.c(str1, str2)) {}
    while (!acxk.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramacxi.jdField_a_of_type_JavaLangString, paramacxi.b);
    return true;
  }
  
  private static boolean a(ArrayList<acxi> paramArrayList)
  {
    acwx.a("KingKongUpdateManager", "Removing obsoleted patches");
    acxb localacxb = acxb.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      acxi localacxi = (acxi)paramArrayList.next();
      String str = localacxi.jdField_a_of_type_JavaLangString;
      b(localacxi);
      Common.a(str);
      localacxb.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = acxb.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (acxi)localIterator.next();
      if (((acxi)localObject).g.equals("UPDATING"))
      {
        acwx.a("KingKongUpdateManager", "Continue udpating " + ((acxi)localObject).jdField_a_of_type_JavaLangString);
        localObject = ((acxi)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(acxi paramacxi)
  {
    String str = paramacxi.jdField_a_of_type_JavaLangString;
    paramacxi = paramacxi.f;
    acwx.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramacxi = acxh.b(str, paramacxi).iterator();
    while (paramacxi.hasNext())
    {
      str = Common.b((String)paramacxi.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        acwx.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return acxk.a(jdField_a_of_type_AndroidContentContext).equals(acxk.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(acxi paramacxi)
  {
    String str1 = paramacxi.jdField_a_of_type_JavaLangString;
    paramacxi = acxh.a(str1, paramacxi.f);
    if ((paramacxi == null) || (paramacxi.size() == 0))
    {
      acwx.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramacxi.size()) {
        break label115;
      }
      String str2 = (String)paramacxi.get(i);
      String str3 = Common.a(str2);
      if (!acxk.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label115:
    return true;
  }
  
  private static boolean b(ArrayList<acxi> paramArrayList)
  {
    acwx.a("KingKongUpdateManager", "Installing updated patches");
    acxb localacxb = acxb.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      acxi localacxi = (acxi)paramArrayList.next();
      Object localObject = localacxi.g;
      String str1 = localacxi.jdField_a_of_type_JavaLangString;
      if (((String)localObject).equals("DISABLED"))
      {
        acwx.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        acwx.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = acxh.a(str1, localacxi.f);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str3 = (String)((Iterator)localObject).next();
            String str2 = Common.a(str3);
            str3 = Common.b(str3);
            if (!acxk.b(str3, str2))
            {
              acwx.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
              localacxi.g = "UPDATING";
              localacxb.a(localacxi);
              return false;
            }
          }
        }
        localObject = acxh.b(jdField_a_of_type_JavaLangString, localacxi);
        if ((localObject == null) || (!a((acxh)localObject))) {
          acwx.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localacxi.g = "READY";
        localacxb.a(localacxi);
        acwx.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */