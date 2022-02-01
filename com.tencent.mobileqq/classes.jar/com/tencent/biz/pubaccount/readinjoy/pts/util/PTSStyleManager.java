package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSStyleManager
{
  private static volatile PTSStyleManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSStyleManager;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "native_article", "default_feeds" };
  private HashMap<String, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, Boolean> b = new HashMap();
  
  private int a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    paramString2 = b(paramString2);
    int j = Math.min(paramString1.size(), paramString2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)paramString1.get(i)).intValue() > ((Integer)paramString2.get(i)).intValue()) {
        return 1;
      }
      if (((Integer)paramString1.get(i)).intValue() < ((Integer)paramString2.get(i)).intValue()) {
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  public static PTSStyleManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSStyleManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSStyleManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSStyleManager = new PTSStyleManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSStyleManager;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    String str = "";
    if (TextUtils.equals(paramString, "native_article")) {
      str = ReadInJoyHelper.a("native_proteus_offline_bid");
    }
    if (TextUtils.equals(paramString, "default_feeds")) {
      str = ReadInJoyHelper.a("default_feeds_proteus_offline_bid");
    }
    return str;
  }
  
  private void a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      String str1 = "proteus" + File.separator + paramString + File.separator + "pages";
      QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], businessName = " + paramString + ", path = " + str1);
      Object localObject = str1 + File.separator + "manifest";
      String str2 = PTSFileUtil.getFileContent((String)localObject, localBaseApplication, true);
      QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], manifestFilePath = " + (String)localObject + ", manifest content = " + str2);
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      localObject = str2.split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str2 = localObject[i];
        QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp] manifest pageName = " + str2);
        String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
        PTSFileUtil.loadFile(str3, localBaseApplication, true);
        if (PTSFileUtil.isFileInMap(str3))
        {
          a(str3, true);
          a(str2, paramString);
          if ((QLog.isColorLevel()) || (QLog.isDebugVersion())) {
            QLog.i("PTSStyleManager", 2, "[loadLocalStyleFileImp] load style succeed, pageName = " + str2 + ", frameTreeJsonPath = " + str3);
          }
        }
        i += 1;
      }
    }
    QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], manifestContent is empty.");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localObject);
    }
    ((List)localObject).add(paramString1);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str = PTSFileUtil.getFileContent(paramString, BaseApplicationImpl.getContext(), paramBoolean);
    if (!TextUtils.isEmpty(str))
    {
      paramBoolean = a(str, "8.5.5");
      this.b.put(paramString, Boolean.valueOf(paramBoolean));
      QLog.i("PTSStyleManager", 1, "[checkFrameTreeVersion] frameTreeJsonPath = " + paramString + "isValid = " + paramBoolean);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new JSONObject(paramString1);
      paramString1 = ((JSONObject)localObject).optString("max_version", "");
      localObject = ((JSONObject)localObject).optString("min_version", "");
      PTSLog.i("PTSStyleManager", "[isVersionValid] currentVersion = " + paramString2 + ", minVersion = " + (String)localObject + ", maxVersion = " + paramString1 + ", timeCost = " + (System.currentTimeMillis() - l));
      if ((!TextUtils.isEmpty(paramString1)) && (a(paramString2, paramString1) > 0)) {
        return false;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = a(paramString2, (String)localObject);
        if (i < 0) {
          break label161;
        }
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        PTSLog.e("PTSStyleManager", "[isVersionValid] e = " + paramString1);
      }
    }
    return true;
    label161:
    return false;
  }
  
  private List<Integer> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split("\\.");
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {
        try
        {
          localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            PTSLog.e("PTSStyleManager", "[getVersionArray] e =" + localException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b(String paramString)
  {
    int i = 0;
    String str1 = a(paramString);
    if ((TextUtils.isEmpty(str1)) || (str1.equals("0")))
    {
      QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], bid is null or empty.");
      return;
    }
    str1 = OfflineEnvHelper.a(str1) + str1;
    str1 = str1 + File.separator + "pages";
    QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], businessName = " + paramString + ", path = " + str1);
    for (;;)
    {
      try
      {
        Object localObject = new File(str1);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          int j = localObject.length;
          if (i >= j) {
            break;
          }
          String str2 = localObject[i].getName();
          QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pageName = " + str2);
          String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
          PTSFileUtil.loadFile(str3, null, false);
          if (!PTSFileUtil.isFileInMap(str3)) {
            break label337;
          }
          a(str3, false);
          a(str2, paramString);
          if ((!QLog.isColorLevel()) && (!QLog.isDebugVersion())) {
            break label337;
          }
          QLog.i("PTSStyleManager", 2, "[loadOfflineStyleFileImp] load style succeed, pageName = " + str2 + ", frameTreeJsonPath = " + str3);
          break label337;
        }
        QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pages directory does not exists.");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("PTSStyleManager", 1, "[loadOfflineStyleFileImp], e = " + paramString);
        return;
      }
      label337:
      i += 1;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], businessName or pageName is null.");
      localObject1 = "";
      return localObject1;
    }
    Object localObject1 = "";
    Object localObject2 = a(paramString1);
    localObject2 = PTSFileUtil.getFilePath(paramString2, OfflineEnvHelper.a((String)localObject2) + (String)localObject2 + File.separator + "pages", ".frametree");
    Object localObject3;
    if (PTSFileUtil.isFileInMap((String)localObject2))
    {
      localObject1 = PTSFileUtil.getFileContent((String)localObject2, null, false);
      localObject3 = (Boolean)this.b.get(localObject2);
      if ((localObject3 == null) || (((Boolean)localObject3).booleanValue())) {
        break label337;
      }
      QLog.i("PTSStyleManager", 1, "[getFrameTreeJson] version is not valid, frameTreeJsonPath = " + (String)localObject2);
      localObject1 = "";
    }
    label334:
    label337:
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = PTSFileUtil.getFilePath(paramString2, "proteus" + File.separator + paramString1 + File.separator + "pages", ".frametree");
        localObject2 = localObject1;
        if (PTSFileUtil.isFileInMap((String)localObject3))
        {
          localObject2 = PTSFileUtil.getFileContent((String)localObject3, BaseApplicationImpl.getContext(), true);
          localObject1 = (Boolean)this.b.get(localObject3);
          if ((localObject1 == null) || (((Boolean)localObject1).booleanValue())) {
            break label334;
          }
          QLog.i("PTSStyleManager", 1, "[getFrameTreeJson] version is not valid, frameTreeJsonPath = " + (String)localObject3);
          localObject2 = "";
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], frameTreeJson is empty, businessName = " + paramString1 + ", pageName = " + paramString2);
        return localObject2;
      }
    }
  }
  
  public List<String> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      a(str);
      b(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSStyleManager
 * JD-Core Version:    0.7.0.1
 */