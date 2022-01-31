import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.1;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.4;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.6;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.7;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.CategoryRedConfig;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig.RedDotItemConfig;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axoc
{
  public static int a;
  public static File a;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  public static File b;
  public static String b;
  public static String c;
  public Handler a;
  public axoi a;
  private axoy jdField_a_of_type_Axoy;
  private azfy jdField_a_of_type_Azfy;
  CaptureRedDotConfig jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  public PtvTemplateManager.PtvTemplateInfo a;
  HashMap<Integer, axog> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<axoy> a;
  String d;
  String e;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "new_ptv_template_usable";
    jdField_a_of_type_JavaLangObject = new Object();
    File localFile = BaseApplicationImpl.getApplication().getCacheDir();
    jdField_a_of_type_JavaIoFile = new File(localFile, "capture_ptv_template");
    jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
    jdField_b_of_type_JavaIoFile = new File(localFile, "new_ptv_template");
    jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
  }
  
  private axoc()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final axoc a()
  {
    return axoh.a();
  }
  
  private axok a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, azcw paramazcw)
  {
    axok localaxok = new axok();
    localaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localaxok.jdField_a_of_type_Azcw = paramazcw;
    paramazcw = new axoj();
    paramazcw.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgStageName;
    paramazcw.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResmd5;
    paramazcw.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResurl;
    paramazcw.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgStageUsable;
    paramazcw.jdField_b_of_type_Boolean = false;
    localaxok.jdField_a_of_type_JavaUtilArrayList.add(paramazcw);
    paramazcw = new axoj();
    paramazcw.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgModelName;
    paramazcw.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResmd5;
    paramazcw.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResurl;
    paramazcw.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgModelUsable;
    paramazcw.jdField_b_of_type_Boolean = false;
    localaxok.jdField_a_of_type_JavaUtilArrayList.add(paramazcw);
    paramazcw = new axoj();
    paramazcw.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramazcw.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramazcw.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramazcw.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramazcw.jdField_b_of_type_Boolean = true;
    localaxok.jdField_a_of_type_JavaUtilArrayList.add(paramazcw);
    localaxok.jdField_a_of_type_Int = 3;
    return localaxok;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bdhb.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return jdField_c_of_type_JavaLangString + paramString + File.separator;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = jdField_a_of_type_JavaLangString + paramString1;
    paramString1 = jdField_c_of_type_JavaLangString + paramString2 + File.separator + paramString1;
    if (new File(paramString1).exists()) {
      return paramString1;
    }
    return str;
  }
  
  public static List<axoy> a(axoc paramaxoc, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parseConfigRaw " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (paramaxoc != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            paramaxoc.d = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            paramaxoc.e = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            bhrh.jdField_a_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            bhrh.jdField_b_of_type_JavaLangString = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            bhrh.jdField_c_of_type_JavaLangString = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            bhrh.jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        Object localObject1 = "";
        Object localObject2 = "";
        String str2 = "";
        String str1 = str2;
        paramString = (String)localObject2;
        paramaxoc = (axoc)localObject1;
        Object localObject3;
        if (localJSONObject.has("bigheadCommonRes"))
        {
          localObject3 = localJSONObject.getJSONObject("bigheadCommonRes");
          str1 = str2;
          paramString = (String)localObject2;
          paramaxoc = (axoc)localObject1;
          if (localObject3 != null)
          {
            paramaxoc = ((JSONObject)localObject3).optString("bighead_model_name", "");
            str1 = ((JSONObject)localObject3).optString("bighead_model_resurl", "");
            paramString = ((JSONObject)localObject3).optString("bighead_model_resmd5", "");
          }
        }
        if (paramCaptureRedDotConfig != null)
        {
          int j = localJSONObject.optInt("iconRedDotVersion");
          boolean bool = localJSONObject.optBoolean("needRedDot");
          int k = localJSONObject.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.iconVersion + ",ver=" + j + ",showRed=" + bool + ",showTime=" + k);
          }
          paramCaptureRedDotConfig.showTime = k;
          if (paramCaptureRedDotConfig.iconVersion != j)
          {
            paramCaptureRedDotConfig.iconVersion = j;
            paramCaptureRedDotConfig.showRedDot = bool;
            paramCaptureRedDotConfig.hasShow = false;
            paramCaptureRedDotConfig.firstShowTime = 0L;
          }
          j = localJSONObject.optInt("defaultCategoryVersion");
          k = localJSONObject.optInt("defaultCategoryId", -1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultCategoryVer + ",ver=" + j + ",defaultCategoryId=" + k);
          }
          if (paramCaptureRedDotConfig.defaultCategoryVer != j)
          {
            paramCaptureRedDotConfig.defaultCategoryVer = j;
            paramCaptureRedDotConfig.defaultCategoryId = k;
            paramCaptureRedDotConfig.hasChoose = false;
          }
          j = localJSONObject.optInt("defaultUseVersion");
          localObject1 = localJSONObject.optString("defaultUseId");
          if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + paramCaptureRedDotConfig.defaultUseVer + ",ver=" + j + ",defaultUseId=" + (String)localObject1);
          }
          if (paramCaptureRedDotConfig.defaultUseVer != j)
          {
            paramCaptureRedDotConfig.defaultUseVer = j;
            paramCaptureRedDotConfig.defaultUseId = ((String)localObject1);
            paramCaptureRedDotConfig.hasUse = false;
          }
          j = localJSONObject.optInt("itemRedDotVersion");
          if (paramCaptureRedDotConfig.redDotVersion != j)
          {
            paramCaptureRedDotConfig.redDotVersion = j;
            paramCaptureRedDotConfig.redDotItems.clear();
            if (localJSONObject.has("itemNeedRedDot"))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("parseConfig|redDotList:");
              localObject2 = localJSONObject.getJSONArray("itemNeedRedDot");
              if (i < ((JSONArray)localObject2).length())
              {
                str2 = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty(str2)) {
                  break label865;
                }
                localObject3 = new CaptureRedDotConfig.RedDotItemConfig();
                ((CaptureRedDotConfig.RedDotItemConfig)localObject3).filterId = str2;
                ((StringBuilder)localObject1).append(str2).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str2, localObject3);
                break label865;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|redDotItem= " + ((StringBuilder)localObject1).toString());
              }
            }
          }
        }
        if (!localJSONObject.has("category")) {
          break;
        }
        paramCaptureRedDotConfig = a(localJSONObject.getJSONArray("category"), paramCaptureRedDotConfig);
        a(paramCaptureRedDotConfig, paramaxoc, str1, paramString);
        return paramCaptureRedDotConfig;
      }
      catch (JSONException paramaxoc) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramaxoc.printStackTrace();
      return null;
      label865:
      i += 1;
    }
  }
  
  static List<axoy> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "parse config: " + paramJSONArray);
    }
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    if (j <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      axoy localaxoy;
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localaxoy = new axoy();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localaxoy.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localaxoy.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localaxoy.jdField_a_of_type_Boolean = bool;
            azjh.a((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localaxoy.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("TipsVer");
            localaxoy.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label488;
          }
          localaxoy.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label711;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localaxoy.jdField_a_of_type_Int));
          if (localObject1 == null) {
            break label425;
          }
          if (((CaptureRedDotConfig.CategoryRedConfig)localObject1).version == k) {
            break label708;
          }
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).firstShowTime = 0L;
          if ((localaxoy.jdField_a_of_type_JavaUtilList == null) || (localaxoy.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label461;
          }
          localObject4 = localaxoy.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label461;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localaxoy.jdField_a_of_type_Int;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localaxoy.jdField_a_of_type_JavaLangString;
          continue;
          return localArrayList;
        }
      }
      catch (JSONException paramJSONArray)
      {
        if (QLog.isColorLevel()) {
          paramJSONArray.printStackTrace();
        }
      }
      boolean bool = false;
      continue;
      label425:
      Object localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localaxoy.jdField_a_of_type_Int;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      continue;
      label461:
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      label488:
      bool = ((JSONObject)localObject3).has("commonRes");
      if (bool) {
        try
        {
          Object localObject6 = ((JSONObject)localObject3).getJSONObject("commonRes");
          localObject1 = ((JSONObject)localObject6).getString("dg_stage_name");
          RecentDanceConfigMgr.a((String)localObject1);
          localObject3 = ((JSONObject)localObject6).getString("dg_stage_resurl");
          localObject4 = ((JSONObject)localObject6).getString("dg_stage_resmd5");
          localObject5 = ((JSONObject)localObject6).getString("dg_model_name");
          String str = ((JSONObject)localObject6).getString("dg_model_resurl");
          localObject6 = ((JSONObject)localObject6).getString("dg_model_resmd5");
          if (localaxoy.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localaxoy.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
              if ((localPtvTemplateInfo.kind == 3) || (localPtvTemplateInfo.kind == 4))
              {
                localPtvTemplateInfo.dgStageName = ((String)localObject1);
                localPtvTemplateInfo.dgStageResurl = ((String)localObject3);
                localPtvTemplateInfo.dgStageResmd5 = ((String)localObject4);
                localPtvTemplateInfo.dgModelName = ((String)localObject5);
                localPtvTemplateInfo.dgModelResurl = str;
                localPtvTemplateInfo.dgModelResmd5 = ((String)localObject6);
              }
            }
          }
          localArrayList.add(localaxoy);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
      break;
      label708:
      continue;
      label711:
      Object localObject2 = null;
    }
  }
  
  private void a(axok paramaxok)
  {
    axog localaxog2 = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
    axog localaxog1 = localaxog2;
    if (localaxog2 == null)
    {
      localaxog1 = new axog();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramaxok.jdField_a_of_type_Int), localaxog1);
    }
    localaxog1.b.add(paramaxok);
  }
  
  private void a(axok paramaxok, axoj paramaxoj, long paramLong1, long paramLong2)
  {
    if ((paramaxok == null) || (paramaxoj == null)) {}
    do
    {
      axog localaxog;
      do
      {
        return;
        localaxog = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
        if (localaxog != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "multiSessionDownloadProcessUpdate: BusinessParam=null  kind=" + paramaxok.jdField_a_of_type_Int + " mItem.mName=" + paramaxoj.jdField_a_of_type_JavaLangString);
      return;
      paramaxoj.jdField_a_of_type_Long = paramLong1;
      paramaxoj.jdField_b_of_type_Long = paramLong2;
      paramaxoj.jdField_c_of_type_Boolean = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramaxoj = paramaxok.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramaxoj.hasNext())
      {
        axoj localaxoj = (axoj)paramaxoj.next();
        if (!localaxoj.jdField_a_of_type_Boolean)
        {
          localaxoj = (axoj)localaxog.jdField_a_of_type_JavaUtilHashMap.get(localaxoj.jdField_a_of_type_JavaLangString);
          if (localaxoj != null) {
            if (localaxoj.jdField_c_of_type_Boolean)
            {
              paramLong2 += localaxoj.jdField_a_of_type_Long;
              paramLong1 += localaxoj.jdField_b_of_type_Long;
            }
            else
            {
              paramLong1 += 1000L;
            }
          }
        }
      }
    } while (paramaxok.jdField_a_of_type_Azcw == null);
    paramaxok.jdField_a_of_type_Azcw.a(paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(2);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "parseFilterConfigZip RedDot is null");
        }
      }
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
        }
        ajrw.a(-1);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip config=" + paramString);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(paramString);
          paramString = "";
          str = "";
          if (((JSONObject)localObject2).has("pendantMD5")) {
            paramString = ((JSONObject)localObject2).getString("pendantMD5");
          }
          if (!((JSONObject)localObject2).has("pendantUrl")) {
            break label549;
          }
          ??? = ((JSONObject)localObject2).getString("pendantUrl");
          if (((JSONObject)localObject2).has("pendantName")) {
            str = ((JSONObject)localObject2).getString("pendantName");
          }
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip pendantMD5=" + paramString + " pendantUrl=" + (String)???);
          }
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)???))) {
            break label279;
          }
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "zipMd5 or zipUrl empty return!");
          }
          ajrw.a(-1);
          return;
        }
        catch (JSONException paramQQAppInterface) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface.printStackTrace();
        return;
        label279:
        Object localObject2 = jdField_a_of_type_JavaIoFile + File.separator;
        String str = jdField_a_of_type_JavaIoFile + File.separator + str;
        File localFile = new File(jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
        if (localFile.exists())
        {
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip file.delete()");
          }
        }
        Object localObject3 = new File(str);
        if (((File)localObject3).exists())
        {
          ((File)localObject3).delete();
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip filejson.delete()");
          }
        }
        localObject3 = new baub();
        ((baub)localObject3).jdField_a_of_type_Baug = new axod(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((baub)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((baub)localObject3).jdField_a_of_type_Int = 0;
        ((baub)localObject3).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((baub)localObject3).jdField_c_of_type_Int = bdin.a(bavg.a().a());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((bave)localObject3);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + (String)???);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
      }
      label549:
      ??? = "";
    }
  }
  
  private void a(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
    do
    {
      do
      {
        return;
        paramFile = a(paramFile);
      } while (TextUtils.isEmpty(paramFile));
      paramFile = a(a(), paramFile, null);
      if (paramFile != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramFile);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "rebuildTemplateInfos");
      }
      a(paramFile, paramBoolean);
      a();
    } while (this.jdField_a_of_type_Axoi == null);
    this.jdField_a_of_type_Axoi.a();
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<axoy> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (axoy)paramList.next();
      if ((((axoy)localObject).jdField_a_of_type_JavaUtilList == null) || (((axoy)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localObject = ((axoy)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
        {
          localPtvTemplateInfo.bigHeadName = paramString1;
          localPtvTemplateInfo.bigHeadUrl = paramString2;
          localPtvTemplateInfo.bigHeadMd5 = paramString3;
        }
      }
    }
  }
  
  public static boolean a()
  {
    File localFile1 = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    File localFile2 = new File(jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    return (localFile1.exists()) && (localFile2.exists());
  }
  
  private boolean a(axok paramaxok)
  {
    axog localaxog = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
    if (localaxog != null)
    {
      if (localaxog.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      paramaxok = paramaxok.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramaxok.hasNext())
      {
        axoj localaxoj = (axoj)paramaxok.next();
        if (!localaxog.jdField_a_of_type_JavaUtilArrayList.contains(localaxoj.jdField_a_of_type_JavaLangString)) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(axok paramaxok, axoj paramaxoj)
  {
    if ((paramaxok == null) || (paramaxoj == null)) {
      return false;
    }
    axog localaxog = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
    if (localaxog != null)
    {
      localaxog.jdField_a_of_type_JavaUtilArrayList.remove(paramaxoj.jdField_a_of_type_JavaLangString);
      if (a(paramaxok))
      {
        paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = a(paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        paramaxoj = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramaxoj.hasNext())
        {
          Object localObject = (axoy)paramaxoj.next();
          if (((axoy)localObject).jdField_a_of_type_JavaUtilList != null)
          {
            localObject = ((axoy)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if (localPtvTemplateInfo.id.equals(paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              } else if (paramaxok.jdField_a_of_type_Int == localPtvTemplateInfo.kind) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              }
            }
          }
        }
        if (paramaxok.jdField_a_of_type_Azcw != null) {
          paramaxok.jdField_a_of_type_Azcw.a(paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
        }
        if (localaxog.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          localaxog.jdField_a_of_type_JavaUtilHashMap.clear();
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool1 = false;
      return bool1;
    }
    File localFile = new File(jdField_b_of_type_JavaIoFile, paramString2);
    if (localFile.exists()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localFile = new File(jdField_a_of_type_JavaIoFile, paramString1);
        if (!localFile.exists()) {}
      }
      for (;;)
      {
        try
        {
          Object localObject = bdhb.c(localFile.getPath());
          int j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            bool1 = ((String)localObject).equalsIgnoreCase(paramString2);
            j = i;
            if (bool1) {
              j = 1;
            }
          }
          i = j;
          if (i != 0)
          {
            localObject = a(paramString1, paramString2) + File.separator;
            paramString1 = new File((String)localObject, "params.json");
            localObject = new File((String)localObject, "params.dat");
            long l = paramString1.length();
            if ((!paramString1.exists()) || (l >= 1L))
            {
              bool1 = bool2;
              if (paramString1.exists()) {
                break;
              }
              if (paramBoolean)
              {
                bool1 = bool2;
                if (((File)localObject).exists()) {
                  break;
                }
              }
            }
            try
            {
              ndr.a(localFile, a(paramString2));
              return true;
            }
            catch (Exception paramString1)
            {
              if (QLog.isColorLevel()) {
                paramString1.printStackTrace();
              }
              return false;
            }
            continue;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (QLog.isColorLevel()) {
            localUnsatisfiedLinkError.printStackTrace();
          }
        }
        return false;
      }
    }
  }
  
  private axok b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, azcw paramazcw)
  {
    axok localaxok = new axok();
    localaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localaxok.jdField_a_of_type_Azcw = paramazcw;
    paramazcw = new axoj();
    paramazcw.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadName;
    paramazcw.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadMd5;
    paramazcw.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadUrl;
    paramazcw.jdField_a_of_type_Boolean = paramPtvTemplateInfo.bigHeadModelUsable;
    paramazcw.jdField_b_of_type_Boolean = false;
    localaxok.jdField_a_of_type_JavaUtilArrayList.add(paramazcw);
    paramazcw = new axoj();
    paramazcw.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramazcw.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramazcw.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramazcw.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramazcw.jdField_b_of_type_Boolean = true;
    localaxok.jdField_a_of_type_JavaUtilArrayList.add(paramazcw);
    localaxok.jdField_a_of_type_Int = 20;
    return localaxok;
  }
  
  private void b(axok paramaxok)
  {
    axog localaxog = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
    if (localaxog != null) {
      localaxog.b.remove(paramaxok);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Axoy != null) && (this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.size() >= 30);
  }
  
  private ArrayList<axoy> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = azgd.c();
    boolean bool2 = azjx.c();
    boolean bool3 = QmcfManager.getInstance().hasQmcfEntrance(3);
    if ((!bool1) || (!bool2) || (!bool3))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        axoy localaxoy = (axoy)localIterator1.next();
        List localList = localaxoy.jdField_a_of_type_JavaUtilList;
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator2.next();
          if (((!bool1) && (localPtvTemplateInfo.kind == 3)) || ((!bool2) && (localPtvTemplateInfo.kind == 4)) || ((!bool3) && (localPtvTemplateInfo.kind == 20)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("CapturePtvTemplateManager", 2, "should hide dg item! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " itemID=" + localPtvTemplateInfo.id);
            }
            localIterator2.remove();
          }
        }
        if (localList.size() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localaxoy.jdField_a_of_type_Int);
          }
          localIterator1.remove();
        }
      }
      axpn.a().a(bool1, bool2);
    }
    return localArrayList;
  }
  
  private void c()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.jdField_a_of_type_JavaUtilList);
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (axoy)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((axoy)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((axoy)localObject2).jdField_a_of_type_JavaUtilList);
        localObject2 = ((List)localObject3).iterator();
        for (;;)
        {
          k = i;
          m = j;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            k = i + 1;
            ((PtvTemplateManager.PtvTemplateInfo)localObject3).usable = a((PtvTemplateManager.PtvTemplateInfo)localObject3);
            i = k;
            if (((PtvTemplateManager.PtvTemplateInfo)localObject3).usable)
            {
              j += 1;
              i = k;
            }
          }
        }
      }
      j = m;
      i = k;
    }
    bdne.a(j, i);
  }
  
  private static boolean c(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      for (;;)
      {
        return false;
        Object localObject = new File(jdField_a_of_type_JavaIoFile, paramString1);
        if (((File)localObject).exists()) {
          try
          {
            localObject = bdhb.c(((File)localObject).getPath());
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
            {
              localObject = jdField_a_of_type_JavaLangString + paramString1 + File.separator;
              paramString2 = new File((String)localObject, "params.json");
              localObject = new File((String)localObject, "params.dat");
              long l = paramString2.length();
              if (((!paramString2.exists()) || (l >= 1L)) && ((paramString2.exists()) || ((paramBoolean) && (((File)localObject).exists())))) {
                break label194;
              }
              if (!QLog.isColorLevel()) {}
            }
          }
          catch (UnsatisfiedLinkError paramString1)
          {
            try
            {
              ndr.a(new File(jdField_a_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
              return true;
            }
            catch (Exception paramString1) {}
            paramString1 = paramString1;
          }
        }
      }
      paramString1.printStackTrace();
      return false;
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
    label194:
    return true;
  }
  
  public int a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.hasChoose))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_PTV", 2, "getDefaultCategoryId=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId;
        return i;
      }
      return -1;
    }
  }
  
  public axoy a(axoy paramaxoy)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("recent_template_setting", 0);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject1 = ((SharedPreferences)localObject1).getString("recent_template_list" + (String)localObject2, null);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplate list=" + (String)localObject1);
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return paramaxoy;
      localObject1 = ((String)localObject1).split("\\$");
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2 = localObject1[i].split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          int j = Integer.valueOf(localObject2[1]).intValue();
          localObject2 = a(localObject2[0], j);
          if (localObject2 != null) {
            paramaxoy.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(String paramString, int paramInt)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      Iterator localIterator = a().iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (axoy)localIterator.next();
        } while ((((axoy)localObject).jdField_a_of_type_Int != paramInt) || (((axoy)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((axoy)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList<axoy> a()
  {
    ArrayList localArrayList = c();
    if (!azjh.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List<axoy> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axoy localaxoy = (axoy)localIterator.next();
      if (localaxoy.jdField_a_of_type_Boolean) {
        localArrayList.add(localaxoy);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new CapturePtvTemplateManager.4(this), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.updateRedDotInfo(paramInt1, paramInt2, paramString))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateRedDotInfo==> type=");
            if (paramInt1 == 2)
            {
              localStringBuilder.append(",categoryId=").append(paramInt2);
              QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
            this.jdField_a_of_type_AndroidOsHandler.post(new CapturePtvTemplateManager.7(this));
          }
        }
        else {
          return;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Azfy != null)
    {
      this.jdField_a_of_type_Azfy.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(axoi paramaxoi)
  {
    this.jdField_a_of_type_Axoi = paramaxoi;
  }
  
  public void a(azga paramazga, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azfy == null) {
        this.jdField_a_of_type_Azfy = new azfy();
      }
      this.jdField_a_of_type_Azfy.a(paramazga, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, axok paramaxok)
  {
    if ((paramaxok.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (paramAppInterface == null)) {}
    label98:
    label99:
    for (;;)
    {
      return;
      if ((paramaxok.jdField_a_of_type_JavaUtilArrayList != null) && (paramaxok.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        a(paramaxok);
        Iterator localIterator = paramaxok.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          axoj localaxoj = (axoj)localIterator.next();
          if (localaxoj.jdField_a_of_type_Boolean) {
            break label98;
          }
          a(paramAppInterface, paramaxok, localaxoj);
          i = 1;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            break label99;
          }
          b(paramaxok);
          return;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, axok paramaxok, axoj paramaxoj)
  {
    Object localObject = (axog)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxok.jdField_a_of_type_Int));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem url: businessParam = null kind=" + paramaxok.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramaxoj.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      if (((axog)localObject).jdField_a_of_type_JavaUtilHashMap.get(paramaxoj.jdField_a_of_type_JavaLangString) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem[no need download] url: " + paramaxoj.jdField_c_of_type_JavaLangString + " item.mName=" + paramaxoj.jdField_a_of_type_JavaLangString);
        return;
      }
      ((axog)localObject).jdField_a_of_type_JavaUtilHashMap.put(paramaxoj.jdField_a_of_type_JavaLangString, paramaxoj);
      ((axog)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramaxoj.jdField_a_of_type_JavaLangString);
      localObject = new baub();
      ((baub)localObject).jdField_a_of_type_Baug = new axol(this, paramaxok, paramaxoj);
      ((baub)localObject).jdField_a_of_type_JavaLangString = paramaxoj.jdField_c_of_type_JavaLangString;
      ((baub)localObject).jdField_a_of_type_Int = 0;
      ((baub)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramaxoj.jdField_a_of_type_JavaLangString).getPath();
      ((baub)localObject).a(paramaxoj);
      ((baub)localObject).jdField_c_of_type_Int = bdin.a(bavg.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a((bave)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadSessionTemplateItem url: " + paramaxoj.jdField_c_of_type_JavaLangString);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, azcw paramazcw)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      a(paramAppInterface, a(paramPtvTemplateInfo, paramazcw));
      return;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      a(paramAppInterface, b(paramPtvTemplateInfo, paramazcw));
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramazcw);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    a(paramQQAppInterface, paramString);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Axoy == null)
    {
      this.jdField_a_of_type_Axoy = new axoy(alud.a(2131701750));
      this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Axoy);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!b())
        {
          this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Axoy);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.remove(29);
        this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
        a(paramInt, this.jdField_a_of_type_Axoy);
        continue;
        if (j != 0)
        {
          this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.remove(j);
          this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Axoy);
        }
      }
    }
  }
  
  public void a(List<axoy> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    label21:
    List localList;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localList = ((axoy)paramList.next()).jdField_a_of_type_JavaUtilList;
    } while (localList == null);
    int i = 0;
    label51:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (i < localList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localList.get(i);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label106;
      }
    }
    for (;;)
    {
      i += 1;
      break label51;
      break label21;
      label106:
      if (a(localPtvTemplateInfo))
      {
        localPtvTemplateInfo.usable = true;
      }
      else
      {
        localPtvTemplateInfo.usable = false;
        int j = (int)(bdhb.a() / 1024.0F / 1024.0F);
        int k = (int)(localPtvTemplateInfo.sizeFree * 1024.0D);
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + j + " mSizeFree: " + k);
        }
        if (j < k)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CapturePtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + j + " mSizeFree: " + k);
          return;
        }
        baub localbaub = new baub();
        localbaub.jdField_a_of_type_Baug = new axoe(this, localPtvTemplateInfo);
        localbaub.jdField_a_of_type_JavaLangString = localPtvTemplateInfo.resurl;
        localbaub.jdField_a_of_type_Int = 0;
        localbaub.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
        localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
            if (localAppRuntime != null)
            {
              ((PeakAppInterface)localAppRuntime).getNetEngine(0).a(localbaub);
              if (QLog.isColorLevel()) {
                QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + localPtvTemplateInfo.resurl);
              }
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(List<axoy> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        c();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "updateFaceuTemplateConfigInfo size=" + this.jdField_a_of_type_JavaUtilList.size());
        return;
        ThreadManager.getSubThreadHandler().post(new CapturePtvTemplateManager.6(this));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new CapturePtvTemplateManager.1(this, paramBoolean), null, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          return false;
        }
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
        if ((bool) && (QLog.isColorLevel()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("ShowRedDot ==> type=");
          localStringBuilder.append(paramInt1);
          if (paramInt1 == 2)
          {
            localStringBuilder.append(",categoryId=").append(paramInt2);
            QLog.d("QIMRedDotConfig_PTV", 2, localStringBuilder.toString());
          }
        }
        else
        {
          return bool;
        }
      }
      if (paramInt1 == 3) {
        localStringBuilder.append(",id=").append(paramString);
      } else if (paramInt1 == 4) {
        localStringBuilder.append(",defaultId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
      } else if (paramInt1 == 5) {
        localStringBuilder.append(",defaultCategoryId=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
      }
    }
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          if (paramPtvTemplateInfo.kind != 3) {
            break;
          }
          paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
          paramPtvTemplateInfo.dgModelUsable = c(paramPtvTemplateInfo.dgModelName, paramPtvTemplateInfo.dgModelResmd5, false);
          bool = c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
          }
        } while ((!paramPtvTemplateInfo.dgStageUsable) || (!paramPtvTemplateInfo.dgModelUsable));
        return bool;
        if (paramPtvTemplateInfo.kind != 20) {
          break;
        }
        if (!paramPtvTemplateInfo.bigHeadModelUsable) {
          paramPtvTemplateInfo.bigHeadModelUsable = c(paramPtvTemplateInfo.bigHeadName, paramPtvTemplateInfo.bigHeadMd5, false);
        }
        bool = c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
        if (QLog.isColorLevel()) {
          QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.dgStageUsable), Boolean.valueOf(paramPtvTemplateInfo.dgModelUsable), Boolean.valueOf(bool), paramPtvTemplateInfo.id }));
        }
      } while (!paramPtvTemplateInfo.bigHeadModelUsable);
      return bool;
      if (paramPtvTemplateInfo.kind != 4) {
        break;
      }
      paramPtvTemplateInfo.dgStageUsable = c(paramPtvTemplateInfo.dgStageName, paramPtvTemplateInfo.dgStageResmd5, false);
    } while (!paramPtvTemplateInfo.dgStageUsable);
    return c(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, false);
    return a(paramPtvTemplateInfo.name, paramPtvTemplateInfo.md5, true);
  }
  
  public ArrayList<axoy> b()
  {
    ArrayList localArrayList = a();
    if (this.jdField_a_of_type_Axoy == null)
    {
      this.jdField_a_of_type_Axoy = new axoy(alud.a(2131701749));
      this.jdField_a_of_type_Axoy.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Axoy);
    }
    localArrayList.add(0, this.jdField_a_of_type_Axoy);
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "getRecentTemplateAndConfigTemplate al size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void b()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
    if (localCaptureRedDotConfig != null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig == null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, azcw paramazcw)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Baug = new axof(this, paramPtvTemplateInfo, paramazcw);
      localbaub.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localbaub.jdField_a_of_type_Int = 0;
      localbaub.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.md5).getPath();
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localbaub);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  @TargetApi(9)
  public void b(boolean paramBoolean)
  {
    b();
    File localFile = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      a(false);
      return;
    }
    a(localFile, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
      }
      return;
    }
    CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaIoFile.getAbsolutePath(), "_PTV");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axoc
 * JD-Core Version:    0.7.0.1
 */