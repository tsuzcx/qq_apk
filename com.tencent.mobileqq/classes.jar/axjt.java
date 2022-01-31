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

public class axjt
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
  public axjz a;
  private axkp jdField_a_of_type_Axkp;
  private azbp jdField_a_of_type_Azbp;
  CaptureRedDotConfig jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  public PtvTemplateManager.PtvTemplateInfo a;
  HashMap<Integer, axjx> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<axkp> a;
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
  
  private axjt()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final axjt a()
  {
    return axjy.a();
  }
  
  private axkb a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn)
  {
    axkb localaxkb = new axkb();
    localaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localaxkb.jdField_a_of_type_Ayyn = paramayyn;
    paramayyn = new axka();
    paramayyn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgStageName;
    paramayyn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResmd5;
    paramayyn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResurl;
    paramayyn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgStageUsable;
    paramayyn.jdField_b_of_type_Boolean = false;
    localaxkb.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
    paramayyn = new axka();
    paramayyn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgModelName;
    paramayyn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResmd5;
    paramayyn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResurl;
    paramayyn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgModelUsable;
    paramayyn.jdField_b_of_type_Boolean = false;
    localaxkb.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
    paramayyn = new axka();
    paramayyn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramayyn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramayyn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramayyn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramayyn.jdField_b_of_type_Boolean = true;
    localaxkb.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
    localaxkb.jdField_a_of_type_Int = 3;
    return localaxkb;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bdcs.a(paramFile);
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
  
  public static List<axkp> a(axjt paramaxjt, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
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
        if (paramaxjt != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            paramaxjt.d = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            paramaxjt.e = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            bhna.jdField_a_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            bhna.jdField_b_of_type_JavaLangString = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            bhna.jdField_c_of_type_JavaLangString = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            bhna.jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        Object localObject1 = "";
        Object localObject2 = "";
        String str2 = "";
        String str1 = str2;
        paramString = (String)localObject2;
        paramaxjt = (axjt)localObject1;
        Object localObject3;
        if (localJSONObject.has("bigheadCommonRes"))
        {
          localObject3 = localJSONObject.getJSONObject("bigheadCommonRes");
          str1 = str2;
          paramString = (String)localObject2;
          paramaxjt = (axjt)localObject1;
          if (localObject3 != null)
          {
            paramaxjt = ((JSONObject)localObject3).optString("bighead_model_name", "");
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
        a(paramCaptureRedDotConfig, paramaxjt, str1, paramString);
        return paramCaptureRedDotConfig;
      }
      catch (JSONException paramaxjt) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramaxjt.printStackTrace();
      return null;
      label865:
      i += 1;
    }
  }
  
  static List<axkp> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
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
      axkp localaxkp;
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localaxkp = new axkp();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localaxkp.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localaxkp.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localaxkp.jdField_a_of_type_Boolean = bool;
            azey.a((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localaxkp.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("TipsVer");
            localaxkp.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label488;
          }
          localaxkp.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label711;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localaxkp.jdField_a_of_type_Int));
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
          if ((localaxkp.jdField_a_of_type_JavaUtilList == null) || (localaxkp.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label461;
          }
          localObject4 = localaxkp.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label461;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localaxkp.jdField_a_of_type_Int;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localaxkp.jdField_a_of_type_JavaLangString;
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
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localaxkp.jdField_a_of_type_Int;
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
          if (localaxkp.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localaxkp.jdField_a_of_type_JavaUtilList.iterator();
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
          localArrayList.add(localaxkp);
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
  
  private void a(axkb paramaxkb)
  {
    axjx localaxjx2 = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
    axjx localaxjx1 = localaxjx2;
    if (localaxjx2 == null)
    {
      localaxjx1 = new axjx();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramaxkb.jdField_a_of_type_Int), localaxjx1);
    }
    localaxjx1.b.add(paramaxkb);
  }
  
  private void a(axkb paramaxkb, axka paramaxka, long paramLong1, long paramLong2)
  {
    if ((paramaxkb == null) || (paramaxka == null)) {}
    do
    {
      axjx localaxjx;
      do
      {
        return;
        localaxjx = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
        if (localaxjx != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "multiSessionDownloadProcessUpdate: BusinessParam=null  kind=" + paramaxkb.jdField_a_of_type_Int + " mItem.mName=" + paramaxka.jdField_a_of_type_JavaLangString);
      return;
      paramaxka.jdField_a_of_type_Long = paramLong1;
      paramaxka.jdField_b_of_type_Long = paramLong2;
      paramaxka.jdField_c_of_type_Boolean = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramaxka = paramaxkb.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramaxka.hasNext())
      {
        axka localaxka = (axka)paramaxka.next();
        if (!localaxka.jdField_a_of_type_Boolean)
        {
          localaxka = (axka)localaxjx.jdField_a_of_type_JavaUtilHashMap.get(localaxka.jdField_a_of_type_JavaLangString);
          if (localaxka != null) {
            if (localaxka.jdField_c_of_type_Boolean)
            {
              paramLong2 += localaxka.jdField_a_of_type_Long;
              paramLong1 += localaxka.jdField_b_of_type_Long;
            }
            else
            {
              paramLong1 += 1000L;
            }
          }
        }
      }
    } while (paramaxkb.jdField_a_of_type_Ayyn == null);
    paramaxkb.jdField_a_of_type_Ayyn.a(paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
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
        ajnh.a(-1);
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
          ajnh.a(-1);
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
        localObject3 = new baps();
        ((baps)localObject3).jdField_a_of_type_Bapx = new axju(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((baps)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((baps)localObject3).jdField_a_of_type_Int = 0;
        ((baps)localObject3).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((baps)localObject3).jdField_c_of_type_Int = bdee.a(baqx.a().a());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((baqv)localObject3);
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
    } while (this.jdField_a_of_type_Axjz == null);
    this.jdField_a_of_type_Axjz.a();
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<axkp> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (axkp)paramList.next();
      if ((((axkp)localObject).jdField_a_of_type_JavaUtilList == null) || (((axkp)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localObject = ((axkp)localObject).jdField_a_of_type_JavaUtilList.iterator();
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
  
  private boolean a(axkb paramaxkb)
  {
    axjx localaxjx = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
    if (localaxjx != null)
    {
      if (localaxjx.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      paramaxkb = paramaxkb.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramaxkb.hasNext())
      {
        axka localaxka = (axka)paramaxkb.next();
        if (!localaxjx.jdField_a_of_type_JavaUtilArrayList.contains(localaxka.jdField_a_of_type_JavaLangString)) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(axkb paramaxkb, axka paramaxka)
  {
    if ((paramaxkb == null) || (paramaxka == null)) {
      return false;
    }
    axjx localaxjx = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
    if (localaxjx != null)
    {
      localaxjx.jdField_a_of_type_JavaUtilArrayList.remove(paramaxka.jdField_a_of_type_JavaLangString);
      if (a(paramaxkb))
      {
        paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = a(paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        paramaxka = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramaxka.hasNext())
        {
          Object localObject = (axkp)paramaxka.next();
          if (((axkp)localObject).jdField_a_of_type_JavaUtilList != null)
          {
            localObject = ((axkp)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if (localPtvTemplateInfo.id.equals(paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              } else if (paramaxkb.jdField_a_of_type_Int == localPtvTemplateInfo.kind) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              }
            }
          }
        }
        if (paramaxkb.jdField_a_of_type_Ayyn != null) {
          paramaxkb.jdField_a_of_type_Ayyn.a(paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
        }
        if (localaxjx.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          localaxjx.jdField_a_of_type_JavaUtilHashMap.clear();
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
          Object localObject = bdcs.c(localFile.getPath());
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
  
  private axkb b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn)
  {
    axkb localaxkb = new axkb();
    localaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localaxkb.jdField_a_of_type_Ayyn = paramayyn;
    paramayyn = new axka();
    paramayyn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadName;
    paramayyn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadMd5;
    paramayyn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadUrl;
    paramayyn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.bigHeadModelUsable;
    paramayyn.jdField_b_of_type_Boolean = false;
    localaxkb.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
    paramayyn = new axka();
    paramayyn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramayyn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramayyn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramayyn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramayyn.jdField_b_of_type_Boolean = true;
    localaxkb.jdField_a_of_type_JavaUtilArrayList.add(paramayyn);
    localaxkb.jdField_a_of_type_Int = 20;
    return localaxkb;
  }
  
  private void b(axkb paramaxkb)
  {
    axjx localaxjx = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
    if (localaxjx != null) {
      localaxjx.b.remove(paramaxkb);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Axkp != null) && (this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.size() >= 30);
  }
  
  private ArrayList<axkp> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = azbu.c();
    boolean bool2 = azfo.c();
    boolean bool3 = QmcfManager.getInstance().hasQmcfEntrance(3);
    if ((!bool1) || (!bool2) || (!bool3))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        axkp localaxkp = (axkp)localIterator1.next();
        List localList = localaxkp.jdField_a_of_type_JavaUtilList;
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
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localaxkp.jdField_a_of_type_Int);
          }
          localIterator1.remove();
        }
      }
      axle.a().a(bool1, bool2);
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
      Object localObject2 = (axkp)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((axkp)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((axkp)localObject2).jdField_a_of_type_JavaUtilList);
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
    bdiv.a(j, i);
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
            localObject = bdcs.c(((File)localObject).getPath());
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
  
  public axkp a(axkp paramaxkp)
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
      return paramaxkp;
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
            paramaxkp.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          localObject = (axkp)localIterator.next();
        } while ((((axkp)localObject).jdField_a_of_type_Int != paramInt) || (((axkp)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((axkp)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList<axkp> a()
  {
    ArrayList localArrayList = c();
    if (!azey.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List<axkp> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axkp localaxkp = (axkp)localIterator.next();
      if (localaxkp.jdField_a_of_type_Boolean) {
        localArrayList.add(localaxkp);
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
    if (this.jdField_a_of_type_Azbp != null)
    {
      this.jdField_a_of_type_Azbp.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(axjz paramaxjz)
  {
    this.jdField_a_of_type_Axjz = paramaxjz;
  }
  
  public void a(azbr paramazbr, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Azbp == null) {
        this.jdField_a_of_type_Azbp = new azbp();
      }
      this.jdField_a_of_type_Azbp.a(paramazbr, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, axkb paramaxkb)
  {
    if ((paramaxkb.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (paramAppInterface == null)) {}
    label98:
    label99:
    for (;;)
    {
      return;
      if ((paramaxkb.jdField_a_of_type_JavaUtilArrayList != null) && (paramaxkb.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        a(paramaxkb);
        Iterator localIterator = paramaxkb.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          axka localaxka = (axka)localIterator.next();
          if (localaxka.jdField_a_of_type_Boolean) {
            break label98;
          }
          a(paramAppInterface, paramaxkb, localaxka);
          i = 1;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            break label99;
          }
          b(paramaxkb);
          return;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, axkb paramaxkb, axka paramaxka)
  {
    Object localObject = (axjx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramaxkb.jdField_a_of_type_Int));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem url: businessParam = null kind=" + paramaxkb.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramaxka.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      if (((axjx)localObject).jdField_a_of_type_JavaUtilHashMap.get(paramaxka.jdField_a_of_type_JavaLangString) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem[no need download] url: " + paramaxka.jdField_c_of_type_JavaLangString + " item.mName=" + paramaxka.jdField_a_of_type_JavaLangString);
        return;
      }
      ((axjx)localObject).jdField_a_of_type_JavaUtilHashMap.put(paramaxka.jdField_a_of_type_JavaLangString, paramaxka);
      ((axjx)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramaxka.jdField_a_of_type_JavaLangString);
      localObject = new baps();
      ((baps)localObject).jdField_a_of_type_Bapx = new axkc(this, paramaxkb, paramaxka);
      ((baps)localObject).jdField_a_of_type_JavaLangString = paramaxka.jdField_c_of_type_JavaLangString;
      ((baps)localObject).jdField_a_of_type_Int = 0;
      ((baps)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramaxka.jdField_a_of_type_JavaLangString).getPath();
      ((baps)localObject).a(paramaxka);
      ((baps)localObject).jdField_c_of_type_Int = bdee.a(baqx.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a((baqv)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadSessionTemplateItem url: " + paramaxka.jdField_c_of_type_JavaLangString);
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
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      a(paramAppInterface, a(paramPtvTemplateInfo, paramayyn));
      return;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      a(paramAppInterface, b(paramPtvTemplateInfo, paramayyn));
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramayyn);
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
    if (this.jdField_a_of_type_Axkp == null)
    {
      this.jdField_a_of_type_Axkp = new axkp(alpo.a(2131701738));
      this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Axkp);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!b())
        {
          this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Axkp);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.remove(29);
        this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
        a(paramInt, this.jdField_a_of_type_Axkp);
        continue;
        if (j != 0)
        {
          this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.remove(j);
          this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Axkp);
        }
      }
    }
  }
  
  public void a(List<axkp> paramList)
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
      localList = ((axkp)paramList.next()).jdField_a_of_type_JavaUtilList;
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
        int j = (int)(bdcs.a() / 1024.0F / 1024.0F);
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
        baps localbaps = new baps();
        localbaps.jdField_a_of_type_Bapx = new axjv(this, localPtvTemplateInfo);
        localbaps.jdField_a_of_type_JavaLangString = localPtvTemplateInfo.resurl;
        localbaps.jdField_a_of_type_Int = 0;
        localbaps.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
        localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
            if (localAppRuntime != null)
            {
              ((PeakAppInterface)localAppRuntime).getNetEngine(0).a(localbaps);
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
  
  public void a(List<axkp> paramList, boolean paramBoolean)
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
  
  public ArrayList<axkp> b()
  {
    ArrayList localArrayList = a();
    if (this.jdField_a_of_type_Axkp == null)
    {
      this.jdField_a_of_type_Axkp = new axkp(alpo.a(2131701737));
      this.jdField_a_of_type_Axkp.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Axkp);
    }
    localArrayList.add(0, this.jdField_a_of_type_Axkp);
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
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, ayyn paramayyn)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new axjw(this, paramPtvTemplateInfo, paramayyn);
      localbaps.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.md5).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localbaps);
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
 * Qualified Name:     axjt
 * JD-Core Version:    0.7.0.1
 */