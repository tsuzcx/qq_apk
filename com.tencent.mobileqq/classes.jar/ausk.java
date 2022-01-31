import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Environment;
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

public class ausk
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
  public ausq a;
  private autg jdField_a_of_type_Autg;
  private awhb jdField_a_of_type_Awhb;
  CaptureRedDotConfig jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  public PtvTemplateManager.PtvTemplateInfo a;
  HashMap<Integer, auso> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<autg> a;
  String d;
  String e;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "new_ptv_template_usable";
    jdField_a_of_type_JavaLangObject = new Object();
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label47:
      File localFile;
      break label47;
    }
    if (i != 0) {}
    for (localFile = new File(ajed.aU);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "capture_ptv_template");
      jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_a_of_type_JavaLangString + File.separator;
      jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator + jdField_b_of_type_JavaLangString;
      jdField_b_of_type_JavaIoFile = new File(localFile, "new_ptv_template");
      jdField_c_of_type_JavaLangString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + jdField_c_of_type_JavaLangString + File.separator;
      return;
    }
  }
  
  private ausk()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final ausk a()
  {
    return ausp.a();
  }
  
  private auss a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, awdz paramawdz)
  {
    auss localauss = new auss();
    localauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localauss.jdField_a_of_type_Awdz = paramawdz;
    paramawdz = new ausr();
    paramawdz.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgStageName;
    paramawdz.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResmd5;
    paramawdz.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResurl;
    paramawdz.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgStageUsable;
    paramawdz.jdField_b_of_type_Boolean = false;
    localauss.jdField_a_of_type_JavaUtilArrayList.add(paramawdz);
    paramawdz = new ausr();
    paramawdz.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgModelName;
    paramawdz.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResmd5;
    paramawdz.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResurl;
    paramawdz.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgModelUsable;
    paramawdz.jdField_b_of_type_Boolean = false;
    localauss.jdField_a_of_type_JavaUtilArrayList.add(paramawdz);
    paramawdz = new ausr();
    paramawdz.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramawdz.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramawdz.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramawdz.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramawdz.jdField_b_of_type_Boolean = true;
    localauss.jdField_a_of_type_JavaUtilArrayList.add(paramawdz);
    localauss.jdField_a_of_type_Int = 3;
    return localauss;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bace.a(paramFile);
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
  
  public static List<autg> a(ausk paramausk, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
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
        if (paramausk != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            paramausk.d = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            paramausk.e = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            bedz.jdField_a_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            bedz.jdField_b_of_type_JavaLangString = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            bedz.jdField_c_of_type_JavaLangString = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            bedz.jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        Object localObject1 = "";
        Object localObject2 = "";
        String str2 = "";
        String str1 = str2;
        paramString = (String)localObject2;
        paramausk = (ausk)localObject1;
        Object localObject3;
        if (localJSONObject.has("bigheadCommonRes"))
        {
          localObject3 = localJSONObject.getJSONObject("bigheadCommonRes");
          str1 = str2;
          paramString = (String)localObject2;
          paramausk = (ausk)localObject1;
          if (localObject3 != null)
          {
            paramausk = ((JSONObject)localObject3).optString("bighead_model_name", "");
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
                  break label867;
                }
                localObject3 = new CaptureRedDotConfig.RedDotItemConfig();
                ((CaptureRedDotConfig.RedDotItemConfig)localObject3).filterId = str2;
                ((StringBuilder)localObject1).append(str2).append(",");
                paramCaptureRedDotConfig.redDotItems.put(str2, localObject3);
                break label867;
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
        a(paramCaptureRedDotConfig, paramausk, str1, paramString);
        return paramCaptureRedDotConfig;
      }
      catch (JSONException paramausk) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      paramausk.printStackTrace();
      return null;
      label867:
      i += 1;
    }
  }
  
  static List<autg> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
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
      autg localautg;
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localautg = new autg();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localautg.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localautg.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localautg.jdField_a_of_type_Boolean = bool;
            awkk.a((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localautg.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("TipsVer");
            localautg.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label489;
          }
          localautg.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label712;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localautg.jdField_a_of_type_Int));
          if (localObject1 == null) {
            break label426;
          }
          if (((CaptureRedDotConfig.CategoryRedConfig)localObject1).version == k) {
            break label709;
          }
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject1).firstShowTime = 0L;
          if ((localautg.jdField_a_of_type_JavaUtilList == null) || (localautg.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label462;
          }
          localObject4 = localautg.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label462;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localautg.jdField_a_of_type_Int;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localautg.jdField_a_of_type_JavaLangString;
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
      label426:
      Object localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localautg.jdField_a_of_type_Int;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = k;
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      continue;
      label462:
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      label489:
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
          if (localautg.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localautg.jdField_a_of_type_JavaUtilList.iterator();
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
          localArrayList.add(localautg);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
      break;
      label709:
      continue;
      label712:
      Object localObject2 = null;
    }
  }
  
  private void a(auss paramauss)
  {
    auso localauso2 = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
    auso localauso1 = localauso2;
    if (localauso2 == null)
    {
      localauso1 = new auso();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramauss.jdField_a_of_type_Int), localauso1);
    }
    localauso1.b.add(paramauss);
  }
  
  private void a(auss paramauss, ausr paramausr, long paramLong1, long paramLong2)
  {
    if ((paramauss == null) || (paramausr == null)) {}
    do
    {
      auso localauso;
      do
      {
        return;
        localauso = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
        if (localauso != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "multiSessionDownloadProcessUpdate: BusinessParam=null  kind=" + paramauss.jdField_a_of_type_Int + " mItem.mName=" + paramausr.jdField_a_of_type_JavaLangString);
      return;
      paramausr.jdField_a_of_type_Long = paramLong1;
      paramausr.jdField_b_of_type_Long = paramLong2;
      paramausr.jdField_c_of_type_Boolean = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramausr = paramauss.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramausr.hasNext())
      {
        ausr localausr = (ausr)paramausr.next();
        if (!localausr.jdField_a_of_type_Boolean)
        {
          localausr = (ausr)localauso.jdField_a_of_type_JavaUtilHashMap.get(localausr.jdField_a_of_type_JavaLangString);
          if (localausr != null) {
            if (localausr.jdField_c_of_type_Boolean)
            {
              paramLong2 += localausr.jdField_a_of_type_Long;
              paramLong1 += localausr.jdField_b_of_type_Long;
            }
            else
            {
              paramLong1 += 1000L;
            }
          }
        }
      }
    } while (paramauss.jdField_a_of_type_Awdz == null);
    paramauss.jdField_a_of_type_Awdz.a(paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
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
        ahji.a(-1);
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
            break label550;
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
          ahji.a(-1);
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
        localObject3 = new axro();
        ((axro)localObject3).jdField_a_of_type_Axrt = new ausl(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((axro)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((axro)localObject3).jdField_a_of_type_Int = 0;
        ((axro)localObject3).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((axro)localObject3).jdField_c_of_type_Int = badq.a(axsr.a().a());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((axsp)localObject3);
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
      label550:
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
    } while (this.jdField_a_of_type_Ausq == null);
    this.jdField_a_of_type_Ausq.a();
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<autg> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (autg)paramList.next();
      if ((((autg)localObject).jdField_a_of_type_JavaUtilList == null) || (((autg)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localObject = ((autg)localObject).jdField_a_of_type_JavaUtilList.iterator();
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
  
  private boolean a(auss paramauss)
  {
    auso localauso = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
    if (localauso != null)
    {
      if (localauso.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      paramauss = paramauss.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramauss.hasNext())
      {
        ausr localausr = (ausr)paramauss.next();
        if (!localauso.jdField_a_of_type_JavaUtilArrayList.contains(localausr.jdField_a_of_type_JavaLangString)) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(auss paramauss, ausr paramausr)
  {
    if ((paramauss == null) || (paramausr == null)) {
      return false;
    }
    auso localauso = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
    if (localauso != null)
    {
      localauso.jdField_a_of_type_JavaUtilArrayList.remove(paramausr.jdField_a_of_type_JavaLangString);
      if (a(paramauss))
      {
        paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = a(paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        paramausr = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramausr.hasNext())
        {
          Object localObject = (autg)paramausr.next();
          if (((autg)localObject).jdField_a_of_type_JavaUtilList != null)
          {
            localObject = ((autg)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if (localPtvTemplateInfo.id.equals(paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              } else if (paramauss.jdField_a_of_type_Int == localPtvTemplateInfo.kind) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              }
            }
          }
        }
        if (paramauss.jdField_a_of_type_Awdz != null) {
          paramauss.jdField_a_of_type_Awdz.a(paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
        }
        if (localauso.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          localauso.jdField_a_of_type_JavaUtilHashMap.clear();
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
          Object localObject = bace.c(localFile.getPath());
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
              mpx.a(localFile, a(paramString2));
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
  
  private auss b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, awdz paramawdz)
  {
    auss localauss = new auss();
    localauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localauss.jdField_a_of_type_Awdz = paramawdz;
    paramawdz = new ausr();
    paramawdz.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadName;
    paramawdz.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadMd5;
    paramawdz.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadUrl;
    paramawdz.jdField_a_of_type_Boolean = paramPtvTemplateInfo.bigHeadModelUsable;
    paramawdz.jdField_b_of_type_Boolean = false;
    localauss.jdField_a_of_type_JavaUtilArrayList.add(paramawdz);
    paramawdz = new ausr();
    paramawdz.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    paramawdz.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    paramawdz.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    paramawdz.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    paramawdz.jdField_b_of_type_Boolean = true;
    localauss.jdField_a_of_type_JavaUtilArrayList.add(paramawdz);
    localauss.jdField_a_of_type_Int = 20;
    return localauss;
  }
  
  private void b(auss paramauss)
  {
    auso localauso = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
    if (localauso != null) {
      localauso.b.remove(paramauss);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Autg != null) && (this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.size() >= 30);
  }
  
  private ArrayList<autg> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = awhg.c();
    boolean bool2 = awla.c();
    boolean bool3 = QmcfManager.getInstance().hasQmcfEntrance(3);
    if ((!bool1) || (!bool2) || (!bool3))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        autg localautg = (autg)localIterator1.next();
        List localList = localautg.jdField_a_of_type_JavaUtilList;
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
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localautg.jdField_a_of_type_Int);
          }
          localIterator1.remove();
        }
      }
      autu.a().a(bool1, bool2);
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
      Object localObject2 = (autg)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((autg)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((autg)localObject2).jdField_a_of_type_JavaUtilList);
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
    baig.a(j, i);
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
            localObject = bace.c(((File)localObject).getPath());
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
              mpx.a(new File(jdField_a_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
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
  
  public autg a(autg paramautg)
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
      return paramautg;
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
            paramautg.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          localObject = (autg)localIterator.next();
        } while ((((autg)localObject).jdField_a_of_type_Int != paramInt) || (((autg)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((autg)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList<autg> a()
  {
    ArrayList localArrayList = c();
    if (!awkk.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List<autg> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      autg localautg = (autg)localIterator.next();
      if (localautg.jdField_a_of_type_Boolean) {
        localArrayList.add(localautg);
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
    if (this.jdField_a_of_type_Awhb != null)
    {
      this.jdField_a_of_type_Awhb.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(ausq paramausq)
  {
    this.jdField_a_of_type_Ausq = paramausq;
  }
  
  public void a(awhd paramawhd, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Awhb == null) {
        this.jdField_a_of_type_Awhb = new awhb();
      }
      this.jdField_a_of_type_Awhb.a(paramawhd, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, auss paramauss)
  {
    if ((paramauss.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (paramAppInterface == null)) {}
    label98:
    label99:
    for (;;)
    {
      return;
      if ((paramauss.jdField_a_of_type_JavaUtilArrayList != null) && (paramauss.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        a(paramauss);
        Iterator localIterator = paramauss.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          ausr localausr = (ausr)localIterator.next();
          if (localausr.jdField_a_of_type_Boolean) {
            break label98;
          }
          a(paramAppInterface, paramauss, localausr);
          i = 1;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            break label99;
          }
          b(paramauss);
          return;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, auss paramauss, ausr paramausr)
  {
    Object localObject = (auso)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramauss.jdField_a_of_type_Int));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem url: businessParam = null kind=" + paramauss.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramausr.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      if (((auso)localObject).jdField_a_of_type_JavaUtilHashMap.get(paramausr.jdField_a_of_type_JavaLangString) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem[no need download] url: " + paramausr.jdField_c_of_type_JavaLangString + " item.mName=" + paramausr.jdField_a_of_type_JavaLangString);
        return;
      }
      ((auso)localObject).jdField_a_of_type_JavaUtilHashMap.put(paramausr.jdField_a_of_type_JavaLangString, paramausr);
      ((auso)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramausr.jdField_a_of_type_JavaLangString);
      localObject = new axro();
      ((axro)localObject).jdField_a_of_type_Axrt = new aust(this, paramauss, paramausr);
      ((axro)localObject).jdField_a_of_type_JavaLangString = paramausr.jdField_c_of_type_JavaLangString;
      ((axro)localObject).jdField_a_of_type_Int = 0;
      ((axro)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, paramausr.jdField_a_of_type_JavaLangString).getPath();
      ((axro)localObject).a(paramausr);
      ((axro)localObject).jdField_c_of_type_Int = badq.a(axsr.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a((axsp)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadSessionTemplateItem url: " + paramausr.jdField_c_of_type_JavaLangString);
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
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, awdz paramawdz)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      a(paramAppInterface, a(paramPtvTemplateInfo, paramawdz));
      return;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      a(paramAppInterface, b(paramPtvTemplateInfo, paramawdz));
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramawdz);
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
    if (this.jdField_a_of_type_Autg == null)
    {
      this.jdField_a_of_type_Autg = new autg(ajjy.a(2131635570));
      this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Autg);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!b())
        {
          this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Autg);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.remove(29);
        this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
        a(paramInt, this.jdField_a_of_type_Autg);
        continue;
        if (j != 0)
        {
          this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.remove(j);
          this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Autg);
        }
      }
    }
  }
  
  public void a(List<autg> paramList)
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
      localList = ((autg)paramList.next()).jdField_a_of_type_JavaUtilList;
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
        int j = (int)(bace.a() / 1024.0F / 1024.0F);
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
        axro localaxro = new axro();
        localaxro.jdField_a_of_type_Axrt = new ausm(this, localPtvTemplateInfo);
        localaxro.jdField_a_of_type_JavaLangString = localPtvTemplateInfo.resurl;
        localaxro.jdField_a_of_type_Int = 0;
        localaxro.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
        localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
            if (localAppRuntime != null)
            {
              ((PeakAppInterface)localAppRuntime).getNetEngine(0).a(localaxro);
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
  
  public void a(List<autg> paramList, boolean paramBoolean)
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
  
  public ArrayList<autg> b()
  {
    ArrayList localArrayList = a();
    if (this.jdField_a_of_type_Autg == null)
    {
      this.jdField_a_of_type_Autg = new autg(ajjy.a(2131635569));
      this.jdField_a_of_type_Autg.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Autg);
    }
    localArrayList.add(0, this.jdField_a_of_type_Autg);
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
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, awdz paramawdz)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = new ausn(this, paramPtvTemplateInfo, paramawdz);
      localaxro.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localaxro.jdField_a_of_type_Int = 0;
      localaxro.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.md5).getPath();
      localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localaxro);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ausk
 * JD-Core Version:    0.7.0.1
 */