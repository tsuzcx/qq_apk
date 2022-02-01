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

public class UpdateManager
{
  public static Context a;
  public static UpdateManager.UpdateThread a;
  public static String a = "";
  public static String b = "";
  
  public static void a()
  {
    Object localObject1 = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((MainConfig)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)((Iterator)localObject2).next();
      if ((localPatchInfo.g.equals("UPDATED")) || (localPatchInfo.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localPatchInfo);
      }
    }
    if ((a((ArrayList)localObject1)) && (b((ArrayList)localObject1))) {
      Common.Log.a("KingKongUpdateManager", "Install updates success!");
    } else {
      Common.Log.a("KingKongUpdateManager", "Do Install updates failed");
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      a((PatchInfo)((Iterator)localObject1).next());
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_JavaLangString = Common.a();
    b = DataReport.b();
    paramContext = new StringBuilder();
    paramContext.append(Constant.jdField_a_of_type_JavaLangString);
    paramContext.append(b);
    Constant.jdField_a_of_type_JavaLangString = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append(Constant.c);
    paramContext.append(b);
    paramContext.append(".apk");
    Constant.c = paramContext.toString();
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread = new UpdateManager.UpdateThread();
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread.start();
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!Common.a()) {
      return;
    }
    Object localObject = jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread;
    if ((localObject != null) && (UpdateManager.UpdateThread.a((UpdateManager.UpdateThread)localObject) != null))
    {
      paramContext = paramJSONObject.toString();
      paramJSONObject = UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).obtainMessage();
      localObject = new Bundle();
      ((Bundle)localObject).putString("PATCH_JSON_STRING", paramContext);
      ((Bundle)localObject).putBoolean("PATCH_FORCE_UPDATE", paramBoolean);
      paramJSONObject.setData((Bundle)localObject);
      UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).sendMessage(paramJSONObject);
      return;
    }
    Common.Log.a("KingKongUpdateManager", "System or Update Thread not ready yet");
    Common.SetContext(paramContext);
    Common.b();
    if (!Common.a.a()) {
      return;
    }
    try
    {
      paramJSONObject = PatchInfo.a(new JSONObject(paramJSONObject.toString()));
      paramContext = MainConfig.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--> Updating patch : ");
        ((StringBuilder)localObject).append(paramJSONObject);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject).toString());
        paramContext.a(paramJSONObject);
      }
    }
    catch (Exception paramContext)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("Update Exception : ");
      paramJSONObject.append(paramContext);
      Common.Log.a("KingKongUpdateManager", paramJSONObject.toString());
    }
    Common.a.a();
  }
  
  public static void a(PatchInfo paramPatchInfo)
  {
    Object localObject1 = paramPatchInfo.jdField_a_of_type_JavaLangString;
    paramPatchInfo = paramPatchInfo.f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Clear update patch files ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject2).toString());
    paramPatchInfo = Patch.b((String)localObject1, paramPatchInfo).iterator();
    while (paramPatchInfo.hasNext())
    {
      localObject2 = Common.a((String)paramPatchInfo.next());
      Object localObject3 = new File((String)localObject2);
      if ((((File)localObject3).exists()) && (!((File)localObject3).delete()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Delete file failed ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject3).toString());
      }
    }
    paramPatchInfo = new StringBuilder();
    paramPatchInfo.append((String)localObject1);
    paramPatchInfo.append(".apk");
    paramPatchInfo = Common.a(paramPatchInfo.toString());
    localObject1 = new File(paramPatchInfo);
    if (!((File)localObject1).exists()) {
      return;
    }
    if (!((File)localObject1).delete())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Delete file failed ");
      ((StringBuilder)localObject1).append(paramPatchInfo);
      Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    String str = paramPatchInfo.jdField_a_of_type_JavaLangString;
    if (a(localMainConfig, paramPatchInfo, paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> Updating patch : ");
      localStringBuilder.append(paramPatchInfo);
      Common.Log.a("KingKongUpdateManager", localStringBuilder.toString());
      localMainConfig.a(paramPatchInfo);
      if ("DISABLED".equals(paramPatchInfo.g))
      {
        localMainConfig.a(paramPatchInfo);
        return;
      }
      if (!a(paramPatchInfo))
      {
        localMainConfig.a(paramPatchInfo);
        a(paramPatchInfo);
        paramPatchInfo = new StringBuilder();
        paramPatchInfo.append("--> Download patch exception : ");
        paramPatchInfo.append(str);
        Common.Log.a("KingKongUpdateManager", paramPatchInfo.toString());
        return;
      }
      if ((b(paramPatchInfo)) && (Patch.b(jdField_a_of_type_JavaLangString, paramPatchInfo) != null))
      {
        paramPatchInfo.g = "UPDATED";
        localMainConfig.a(paramPatchInfo);
        paramPatchInfo = new StringBuilder();
        paramPatchInfo.append("--> Updated ");
        paramPatchInfo.append(str);
        Common.Log.a("KingKongUpdateManager", paramPatchInfo.toString());
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> Update got damaged patch, disable ");
      localStringBuilder.append(str);
      Common.Log.a("KingKongUpdateManager", localStringBuilder.toString());
      paramPatchInfo.g = "DISABLED";
      localMainConfig.a(paramPatchInfo);
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder2 = null;
    Object localObject = localStringBuilder2;
    StringBuilder localStringBuilder1;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localObject = new JSONObject(paramString);
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("KingKongUpdateManager Update get DPC config exception=");
      localStringBuilder3.append(localJSONException);
      Common.Log.a("PatchLogTag", localStringBuilder3.toString());
      localStringBuilder1 = localStringBuilder2;
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("KingKongUpdateManager Update get DPC config=");
    localStringBuilder2.append(paramString);
    Common.Log.a("PatchLogTag", localStringBuilder2.toString());
    if (localStringBuilder1 != null) {
      a(BaseApplicationImpl.sApplication, localStringBuilder1, false);
    }
  }
  
  public static boolean a()
  {
    if (!Utils.a(jdField_a_of_type_AndroidContentContext).equals(Utils.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = MainConfig.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((PatchInfo)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MainConfig paramMainConfig, PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    if (paramMainConfig != null)
    {
      if (paramPatchInfo == null) {
        return false;
      }
      PatchInfo localPatchInfo = paramMainConfig.a(paramPatchInfo.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder1 = Utils.a();
      localStringBuilder1.append("Check update : ");
      paramMainConfig = new StringBuilder();
      paramMainConfig.append(" forceUpdate ");
      paramMainConfig.append(paramBoolean);
      localStringBuilder1.append(paramMainConfig.toString());
      paramMainConfig = new StringBuilder();
      paramMainConfig.append(", enabled ");
      paramMainConfig.append(paramPatchInfo.a());
      localStringBuilder1.append(paramMainConfig.toString());
      paramMainConfig = new StringBuilder();
      paramMainConfig.append(", support ");
      paramMainConfig.append(paramPatchInfo.b());
      localStringBuilder1.append(paramMainConfig.toString());
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", old version ");
      if (localPatchInfo == null) {
        paramMainConfig = "None";
      } else {
        paramMainConfig = localPatchInfo.b;
      }
      localStringBuilder2.append(paramMainConfig);
      localStringBuilder1.append(localStringBuilder2.toString());
      paramMainConfig = new StringBuilder();
      paramMainConfig.append(", new version ");
      paramMainConfig.append(paramPatchInfo.b);
      localStringBuilder1.append(paramMainConfig.toString());
      if ((!paramBoolean) && (paramPatchInfo.a()) && (paramPatchInfo.b()) && (localPatchInfo != null) && (localPatchInfo.b.equals(paramPatchInfo.b)))
      {
        localStringBuilder1.append(" --> Refused");
        Common.Log.a("KingKongUpdateManager", localStringBuilder1.toString());
        return false;
      }
      if ((paramPatchInfo.a()) && (paramPatchInfo.b()))
      {
        if ((localPatchInfo != null) && (!localPatchInfo.b.equals(paramPatchInfo.b)))
        {
          paramMainConfig = new StringBuilder();
          paramMainConfig.append("upgrade patch : from ");
          paramMainConfig.append(localPatchInfo.jdField_a_of_type_JavaLangString);
          paramMainConfig.append(" , ");
          paramMainConfig.append(localPatchInfo.b);
          paramMainConfig.append(" to ");
          paramMainConfig.append(paramPatchInfo.jdField_a_of_type_JavaLangString);
          paramMainConfig.append(" , ");
          paramMainConfig.append(paramPatchInfo.b);
          Common.Log.a("KingKongUpdateManager", paramMainConfig.toString());
        }
        paramPatchInfo.g = "UPDATING";
      }
      else
      {
        if (localPatchInfo != null)
        {
          paramMainConfig = new StringBuilder();
          paramMainConfig.append("close old patch : ");
          paramMainConfig.append(localPatchInfo.jdField_a_of_type_JavaLangString);
          paramMainConfig.append(" , ");
          paramMainConfig.append(localPatchInfo.b);
          Common.Log.a("KingKongUpdateManager", paramMainConfig.toString());
          Common.a(2084, localPatchInfo.jdField_a_of_type_JavaLangString, localPatchInfo.b);
        }
        paramPatchInfo.g = "DISABLED";
      }
      localStringBuilder1.append(" --> Passed");
      Common.Log.a("KingKongUpdateManager", localStringBuilder1.toString());
      return true;
    }
    return false;
  }
  
  private static boolean a(Patch paramPatch)
  {
    return paramPatch.a();
  }
  
  public static boolean a(PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.e;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramPatchInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(".apk");
    localObject = Common.a(((StringBuilder)localObject).toString());
    if (!Utils.c(str, (String)localObject)) {
      return false;
    }
    if (!Utils.a((String)localObject, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramPatchInfo.jdField_a_of_type_JavaLangString, paramPatchInfo.b);
    return true;
  }
  
  private static boolean a(ArrayList<PatchInfo> paramArrayList)
  {
    Common.Log.a("KingKongUpdateManager", "Removing obsoleted patches");
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)paramArrayList.next();
      String str = localPatchInfo.jdField_a_of_type_JavaLangString;
      b(localPatchInfo);
      Common.a(str);
      localMainConfig.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = MainConfig.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (PatchInfo)localIterator.next();
      if (((PatchInfo)localObject).g.equals("UPDATING"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Continue udpating ");
        localStringBuilder.append(((PatchInfo)localObject).jdField_a_of_type_JavaLangString);
        Common.Log.a("KingKongUpdateManager", localStringBuilder.toString());
        localObject = ((PatchInfo)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.jdField_a_of_type_JavaLangString;
    paramPatchInfo = paramPatchInfo.f;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Clear update patch files ");
    ((StringBuilder)localObject).append(str);
    Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject).toString());
    paramPatchInfo = Patch.b(str, paramPatchInfo).iterator();
    while (paramPatchInfo.hasNext())
    {
      str = Common.b((String)paramPatchInfo.next());
      localObject = new File(str);
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Delete file failed ");
        ((StringBuilder)localObject).append(str);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean b()
  {
    return Utils.a(jdField_a_of_type_AndroidContentContext).equals(Utils.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(PatchInfo paramPatchInfo)
  {
    String str1 = paramPatchInfo.jdField_a_of_type_JavaLangString;
    paramPatchInfo = Patch.a(str1, paramPatchInfo.f);
    if ((paramPatchInfo != null) && (paramPatchInfo.size() != 0))
    {
      int i = 0;
      while (i < paramPatchInfo.size())
      {
        String str2 = (String)paramPatchInfo.get(i);
        String str3 = Common.a(str2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(".apk");
        if (!Utils.a(Common.a(localStringBuilder.toString()), str2, str3)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    paramPatchInfo = new StringBuilder();
    paramPatchInfo.append("Empty file list in ");
    paramPatchInfo.append(str1);
    Common.Log.a("KingKongUpdateManager", paramPatchInfo.toString());
    return false;
  }
  
  private static boolean b(ArrayList<PatchInfo> paramArrayList)
  {
    Common.Log.a("KingKongUpdateManager", "Installing updated patches");
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    Object localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (PatchInfo)((Iterator)localObject1).next();
      Object localObject3 = ((PatchInfo)localObject2).g;
      paramArrayList = ((PatchInfo)localObject2).jdField_a_of_type_JavaLangString;
      if (((String)localObject3).equals("DISABLED"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Removed ");
        ((StringBuilder)localObject2).append(paramArrayList);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("--> Installing ");
        ((StringBuilder)localObject3).append(paramArrayList);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject3).toString());
        localObject3 = Patch.a(paramArrayList, ((PatchInfo)localObject2).f);
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localObject3 = Common.a(str);
            str = Common.b(str);
            if (!Utils.b(str, (String)localObject3))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Install patch failed : ");
              ((StringBuilder)localObject1).append(paramArrayList);
              ((StringBuilder)localObject1).append(", ");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(" <-- ");
              ((StringBuilder)localObject1).append((String)localObject3);
              Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject1).toString());
              ((PatchInfo)localObject2).g = "UPDATING";
              localMainConfig.a((PatchInfo)localObject2);
              return false;
            }
          }
        }
        localObject3 = Patch.b(jdField_a_of_type_JavaLangString, (PatchInfo)localObject2);
        if ((localObject3 == null) || (!a((Patch)localObject3)))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Init patch failed ");
          ((StringBuilder)localObject3).append(paramArrayList);
          Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject3).toString());
        }
        ((PatchInfo)localObject2).g = "READY";
        localMainConfig.a((PatchInfo)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Installed ");
        ((StringBuilder)localObject2).append(paramArrayList);
        Common.Log.a("KingKongUpdateManager", ((StringBuilder)localObject2).toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.UpdateManager
 * JD-Core Version:    0.7.0.1
 */