import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.networkedmodule.QzoneModuleRecordFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjml
{
  private static volatile bjml jdField_a_of_type_Bjml;
  private Map<String, bjmm> jdField_a_of_type_JavaUtilMap = a(LocalMultiProcConfig.getString("Qz_setting", "NetworkedModuleConfig_cur", ""));
  private Map<String, bjmm> b = new ConcurrentHashMap();
  
  public static bjml a()
  {
    if (jdField_a_of_type_Bjml == null) {}
    try
    {
      if (jdField_a_of_type_Bjml == null) {
        jdField_a_of_type_Bjml = new bjml();
      }
      return jdField_a_of_type_Bjml;
    }
    finally {}
  }
  
  private bjmm a(UPDATE_INFO paramUPDATE_INFO)
  {
    String str3 = paramUPDATE_INFO.id;
    String str4 = paramUPDATE_INFO.md5;
    Object localObject1 = "";
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneModuleConfigManager", 1, "id:" + str3);
    }
    String str5 = paramUPDATE_INFO.ver;
    String str6 = paramUPDATE_INFO.mainVersion;
    Object localObject3 = "";
    Object localObject4 = "";
    String str2;
    String str1;
    String[] arrayOfString;
    if (paramUPDATE_INFO.plugin_info != null)
    {
      str2 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(2));
      str1 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(0));
      paramUPDATE_INFO = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(1));
      localObject1 = str2;
      localObject3 = str1;
      localObject4 = paramUPDATE_INFO;
      if (!TextUtils.isEmpty(paramUPDATE_INFO))
      {
        arrayOfString = paramUPDATE_INFO.split("#");
        localObject1 = str2;
        localObject3 = str1;
        localObject4 = paramUPDATE_INFO;
        if (arrayOfString.length < 2) {}
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        i = Integer.parseInt(arrayOfString[0]);
        localObject4 = arrayOfString[1];
        paramUPDATE_INFO = str2;
        localObject3 = str1;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneModuleConfigManager", 1, "id:" + str3 + " ,md5:" + str4 + ",url:" + (String)localObject3 + " ,keyClassName:" + paramUPDATE_INFO + ",version:" + str5 + ",mainVersion:" + str6 + ",classIds:" + (String)localObject4 + ",classIDsCount:" + i);
        }
        if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str4))) {
          break;
        }
        localObject1 = new bjmn();
        ((bjmn)localObject1).a(str3).b(str5).c(str6).d((String)localObject3).e(str4).f(paramUPDATE_INFO).g((String)localObject4).a(i).a(0L);
        return ((bjmn)localObject1).a();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("QzoneModuleConfigManager", 1, "catch an exception: ", localNumberFormatException);
        localObject4 = paramUPDATE_INFO;
        localObject3 = str1;
        localObject2 = str2;
      }
      paramUPDATE_INFO = localObject2;
      int i = 0;
    }
    return null;
  }
  
  static String a(Map<String, bjmm> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          JSONObject localJSONObject2 = new JSONObject();
          localObject = (bjmm)paramMap.get(localObject);
          try
          {
            localJSONObject2.put("module_id", ((bjmm)localObject).jdField_a_of_type_JavaLangString);
            localJSONObject2.put("module_md5", ((bjmm)localObject).e);
            localJSONObject2.put("module_url", ((bjmm)localObject).d);
            localJSONObject2.put("module_version", ((bjmm)localObject).b);
            localJSONObject2.put("module_main_version", ((bjmm)localObject).c);
            localJSONObject2.put("module_key_class_name", ((bjmm)localObject).f);
            localJSONObject2.put("module_class_ids", ((bjmm)localObject).h);
            localJSONObject2.put("module_class_ids_count", ((bjmm)localObject).jdField_a_of_type_Int);
            localJSONObject2.put("module_file_length", ((bjmm)localObject).jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      try
      {
        localJSONObject1.put("qzone_networked_modules", localJSONArray);
        paramMap = localJSONObject1.toString();
        return paramMap;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
      }
    }
    return "";
  }
  
  static Map<String, bjmm> a(String paramString)
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("qzone_networked_modules");
        if (paramString != null)
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = paramString.getJSONObject(i);
            Object localObject1 = ((JSONObject)localObject2).optString("module_id");
            String str1 = ((JSONObject)localObject2).optString("module_md5");
            String str2 = ((JSONObject)localObject2).optString("module_url");
            String str3 = ((JSONObject)localObject2).optString("module_version");
            String str4 = ((JSONObject)localObject2).optString("module_main_version");
            String str5 = ((JSONObject)localObject2).optString("module_key_class_name");
            String str6 = ((JSONObject)localObject2).optString("module_class_ids");
            int k = ((JSONObject)localObject2).optInt("module_class_ids_count");
            long l = ((JSONObject)localObject2).optLong("module_file_length");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
            {
              localObject2 = new bjmn();
              ((bjmn)localObject2).a((String)localObject1).b(str3).c(str4).d(str2).e(str1).f(str5).g(str6).a(k).a(l);
              localObject1 = ((bjmn)localObject2).a();
              localConcurrentHashMap.put(((bjmm)localObject1).jdField_a_of_type_JavaLangString, localObject1);
            }
            i += 1;
          }
        }
        return localConcurrentHashMap;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.e("QzoneModuleConfigManager", 1, paramString, new Object[0]);
      }
    }
  }
  
  public bjmm a(String paramString)
  {
    boolean bool = true;
    label386:
    for (;;)
    {
      try
      {
        bjmm localbjmm1 = (bjmm)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        bjmm localbjmm2 = (bjmm)this.b.get(paramString);
        Object localObject = localbjmm2;
        if (localbjmm2 == null)
        {
          localbjmm2 = QzoneModuleRecordFactory.getInstance().createRecord(paramString);
          localObject = new StringBuilder().append("try to create record locally,success ? : ");
          if (localbjmm2 == null) {
            continue;
          }
          QLog.i("QzoneModuleConfigManager", 2, String.valueOf(bool));
          localObject = localbjmm2;
          if (localbjmm2 != null)
          {
            this.b.put(paramString, localbjmm2);
            localObject = localbjmm2;
          }
        }
        if (localbjmm1 != null)
        {
          localbjmm1.jdField_a_of_type_Bjmm = ((bjmm)localObject);
          paramString = localbjmm1;
          localObject = paramString;
          if (paramString != null)
          {
            if ((paramString.jdField_a_of_type_Bjmm != null) && (!TextUtils.isEmpty(paramString.jdField_a_of_type_Bjmm.g)) && (!bjdm.a().equalsIgnoreCase(paramString.jdField_a_of_type_Bjmm.g)))
            {
              QLog.i("QzoneModuleConfigManager", 1, "mNewVersion.mQua=" + paramString.jdField_a_of_type_Bjmm.g + " is not equal QUA=" + bjdm.a());
              paramString.jdField_a_of_type_Bjmm = null;
            }
            localObject = paramString;
            if (!TextUtils.isEmpty(paramString.g))
            {
              localObject = paramString;
              if (!bjdm.a().equalsIgnoreCase(paramString.g))
              {
                QLog.i("QzoneModuleConfigManager", 1, "curRecord.mQua=" + paramString.g + " is not equal QUA=" + bjdm.a());
                if ((paramString.jdField_a_of_type_Bjmm == null) || (!paramString.e.equalsIgnoreCase(paramString.jdField_a_of_type_Bjmm.e))) {
                  continue;
                }
                localObject = paramString.jdField_a_of_type_Bjmm;
                a((bjmm)localObject);
                QLog.i("QzoneModuleConfigManager", 1, "curRecord and updateRecord has the same md5,so needn't to download again,just call updateConfigAfterDownloaded to update cur configs");
              }
            }
          }
          return localObject;
          bool = false;
        }
        else
        {
          paramString = localbjmm1;
          if (localObject == null) {
            continue;
          }
          ((bjmm)localObject).jdField_a_of_type_Bjmm = ((bjmm)localObject);
          if (!TextUtils.equals(((bjmm)localObject).e, ((bjmm)localObject).e)) {
            break label386;
          }
          ((bjmm)localObject).jdField_a_of_type_Long = ((bjmm)localObject).jdField_a_of_type_Long;
          break label386;
        }
        localObject = paramString.jdField_a_of_type_Bjmm;
        continue;
        paramString = (String)localObject;
      }
      finally {}
    }
  }
  
  public ArrayList<UPDATE_INFO> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = QzoneModuleConst.QZONE_MODULES_QBOSS.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = str;
      bjmm localbjmm = (bjmm)this.jdField_a_of_type_JavaUtilMap.get(str);
      if (localbjmm != null) {}
      for (localUPDATE_INFO.ver = localbjmm.b;; localUPDATE_INFO.ver = "0")
      {
        localArrayList.add(localUPDATE_INFO);
        QLog.i("QzoneModuleConfigManager", 1, "getUpdateInfo:" + str);
        break;
      }
    }
    return localArrayList;
  }
  
  public void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    for (;;)
    {
      try
      {
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:");
        if ((paramSQ_CLIENT_UPDATE_RSP == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule.size() <= 0)) {
          break label505;
        }
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:" + paramSQ_CLIENT_UPDATE_RSP.vModule.size());
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.vModule;
        i = 0;
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.iterator();
        if (paramSQ_CLIENT_UPDATE_RSP.hasNext())
        {
          UPDATE_INFO localUPDATE_INFO = (UPDATE_INFO)paramSQ_CLIENT_UPDATE_RSP.next();
          Object localObject = a(localUPDATE_INFO);
          if (localObject != null) {
            this.b.put(((bjmm)localObject).jdField_a_of_type_JavaLangString, localObject);
          }
          if (localUPDATE_INFO.actype == 4)
          {
            QLog.w("QzoneModuleConfigManager", 1, "clear module config:" + localUPDATE_INFO.id);
            localObject = (bjmm)this.jdField_a_of_type_JavaUtilMap.get(localUPDATE_INFO.id);
            if (localObject == null) {
              break label508;
            }
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (bjmm)localObject));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            this.jdField_a_of_type_JavaUtilMap.remove(localUPDATE_INFO.id);
            i = 1;
            if (this.b.containsKey(localUPDATE_INFO.id)) {
              this.b.remove(localUPDATE_INFO.id);
            }
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
            continue;
          }
          if (localUPDATE_INFO.actype == 0) {
            continue;
          }
          QLog.w("QzoneModuleConfigManager", 1, "force update module config:" + localUPDATE_INFO.id);
          bjmm localbjmm = (bjmm)this.jdField_a_of_type_JavaUtilMap.get(localUPDATE_INFO.id);
          if (localbjmm == null) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilMap.remove(localUPDATE_INFO.id);
          if (!localbjmm.e.equalsIgnoreCase(localUPDATE_INFO.md5))
          {
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), localbjmm));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is not same,so just delete local file and config:" + localUPDATE_INFO.id);
          }
          else if (localObject != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(localUPDATE_INFO.id, localObject);
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is same,so just update config:" + localUPDATE_INFO.id);
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
          }
        }
      }
      finally {}
      if (i != 0) {
        LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", a(this.jdField_a_of_type_JavaUtilMap));
      }
      label505:
      return;
      label508:
      continue;
      int i = 1;
    }
  }
  
  public void a(bjmm parambjmm)
  {
    if (parambjmm != null) {}
    try
    {
      this.b.remove(parambjmm.jdField_a_of_type_JavaLangString);
      Object localObject = (bjmm)this.jdField_a_of_type_JavaUtilMap.get(parambjmm.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (!((bjmm)localObject).e.equalsIgnoreCase(parambjmm.e)))
      {
        localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (bjmm)localObject));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), parambjmm));
      if (((File)localObject).exists()) {
        parambjmm.jdField_a_of_type_Long = ((File)localObject).length();
      }
      this.jdField_a_of_type_JavaUtilMap.put(parambjmm.jdField_a_of_type_JavaLangString, parambjmm);
      LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", a(this.jdField_a_of_type_JavaUtilMap));
      QzoneModuleConst.clearLastCrashCount(parambjmm.jdField_a_of_type_JavaLangString);
      return;
    }
    finally {}
  }
  
  public void b(bjmm parambjmm)
  {
    try
    {
      this.b.put(parambjmm.jdField_a_of_type_JavaLangString, parambjmm);
      return;
    }
    finally
    {
      parambjmm = finally;
      throw parambjmm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjml
 * JD-Core Version:    0.7.0.1
 */