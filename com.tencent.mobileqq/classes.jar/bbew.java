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

public class bbew
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
  public bbfc a;
  private bbfs jdField_a_of_type_Bbfs;
  private bczq jdField_a_of_type_Bczq;
  CaptureRedDotConfig jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig;
  public PtvTemplateManager.PtvTemplateInfo a;
  HashMap<Integer, bbfa> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<bbfs> a;
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
  
  private bbew()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static final bbew a()
  {
    return bbfb.a();
  }
  
  private bbfe a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bcwn parambcwn)
  {
    bbfe localbbfe = new bbfe();
    localbbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localbbfe.jdField_a_of_type_Bcwn = parambcwn;
    parambcwn = new bbfd();
    parambcwn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgStageName;
    parambcwn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResmd5;
    parambcwn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgStageResurl;
    parambcwn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgStageUsable;
    parambcwn.jdField_b_of_type_Boolean = false;
    localbbfe.jdField_a_of_type_JavaUtilArrayList.add(parambcwn);
    parambcwn = new bbfd();
    parambcwn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.dgModelName;
    parambcwn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResmd5;
    parambcwn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.dgModelResurl;
    parambcwn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.dgModelUsable;
    parambcwn.jdField_b_of_type_Boolean = false;
    localbbfe.jdField_a_of_type_JavaUtilArrayList.add(parambcwn);
    parambcwn = new bbfd();
    parambcwn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    parambcwn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    parambcwn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    parambcwn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    parambcwn.jdField_b_of_type_Boolean = true;
    localbbfe.jdField_a_of_type_JavaUtilArrayList.add(parambcwn);
    localbbfe.jdField_a_of_type_Int = 3;
    return localbbfe;
  }
  
  public static String a(File paramFile)
  {
    paramFile = bhmi.a(paramFile);
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
  
  public static List<bbfs> a(bbew parambbew, String paramString, CaptureRedDotConfig paramCaptureRedDotConfig)
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
        if (parambbew != null)
        {
          if (localJSONObject.has("guide_video_url")) {
            parambbew.d = localJSONObject.getString("guide_video_url");
          }
          if (localJSONObject.has("guide_video_md5")) {
            parambbew.e = localJSONObject.getString("guide_video_md5");
          }
          if (localJSONObject.has("gestureGapFrame")) {
            blfv.jdField_a_of_type_JavaLangString = localJSONObject.getString("gestureGapFrame");
          }
          if (localJSONObject.has("gestureGapTime")) {
            blfv.jdField_b_of_type_JavaLangString = localJSONObject.getString("gestureGapTime");
          }
          if (localJSONObject.has("gesturethreadcoldtime")) {
            blfv.jdField_c_of_type_JavaLangString = localJSONObject.getString("gesturethreadcoldtime");
          }
          if (localJSONObject.has("gestureShouldUpload")) {
            blfv.jdField_a_of_type_Boolean = localJSONObject.getBoolean("gestureShouldUpload");
          }
        }
        Object localObject1 = "";
        Object localObject2 = "";
        String str2 = "";
        String str1 = str2;
        paramString = (String)localObject2;
        parambbew = (bbew)localObject1;
        Object localObject3;
        if (localJSONObject.has("bigheadCommonRes"))
        {
          localObject3 = localJSONObject.getJSONObject("bigheadCommonRes");
          str1 = str2;
          paramString = (String)localObject2;
          parambbew = (bbew)localObject1;
          if (localObject3 != null)
          {
            parambbew = ((JSONObject)localObject3).optString("bighead_model_name", "");
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
        a(paramCaptureRedDotConfig, parambbew, str1, paramString);
        return paramCaptureRedDotConfig;
      }
      catch (JSONException parambbew) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      parambbew.printStackTrace();
      return null;
      label865:
      i += 1;
    }
  }
  
  static List<bbfs> a(JSONArray paramJSONArray, CaptureRedDotConfig paramCaptureRedDotConfig)
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
      bbfs localbbfs;
      Object localObject3;
      int k;
      Object localObject4;
      Object localObject5;
      try
      {
        localbbfs = new bbfs();
        localObject3 = paramJSONArray.getJSONObject(i);
        if (((JSONObject)localObject3).has("content")) {
          localbbfs.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfo.convertFrom(((JSONObject)localObject3).getJSONArray("content"));
        }
        if (((JSONObject)localObject3).has("categoryName")) {
          localbbfs.jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("categoryName");
        }
        if (((JSONObject)localObject3).has("GetRedBag"))
        {
          if (((JSONObject)localObject3).getInt("GetRedBag") == 1)
          {
            bool = true;
            localbbfs.jdField_a_of_type_Boolean = bool;
            bdcy.a((JSONObject)localObject3);
          }
        }
        else
        {
          if ((((JSONObject)localObject3).has("TipsVer")) && (((JSONObject)localObject3).has("Tips")))
          {
            localbbfs.jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("TipsVer");
            localbbfs.jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("Tips");
          }
          if (!((JSONObject)localObject3).has("categoryId")) {
            break label488;
          }
          localbbfs.jdField_a_of_type_Int = ((JSONObject)localObject3).getInt("categoryId");
          if (paramCaptureRedDotConfig == null) {
            break label711;
          }
          k = ((JSONObject)localObject3).optInt("redDotVersion");
          bool = ((JSONObject)localObject3).optBoolean("needRedDot");
          localObject1 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(localbbfs.jdField_a_of_type_Int));
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
          if ((localbbfs.jdField_a_of_type_JavaUtilList == null) || (localbbfs.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label461;
          }
          localObject4 = localbbfs.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label461;
          }
          localObject5 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject4).next();
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryId = localbbfs.jdField_a_of_type_Int;
          ((PtvTemplateManager.PtvTemplateInfo)localObject5).categoryName = localbbfs.jdField_a_of_type_JavaLangString;
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
      ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = localbbfs.jdField_a_of_type_Int;
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
          if (localbbfs.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = localbbfs.jdField_a_of_type_JavaUtilList.iterator();
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
          localArrayList.add(localbbfs);
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
  
  private void a(bbfe parambbfe)
  {
    bbfa localbbfa2 = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
    bbfa localbbfa1 = localbbfa2;
    if (localbbfa2 == null)
    {
      localbbfa1 = new bbfa();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(parambbfe.jdField_a_of_type_Int), localbbfa1);
    }
    localbbfa1.b.add(parambbfe);
  }
  
  private void a(bbfe parambbfe, bbfd parambbfd, long paramLong1, long paramLong2)
  {
    if ((parambbfe == null) || (parambbfd == null)) {}
    do
    {
      bbfa localbbfa;
      do
      {
        return;
        localbbfa = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
        if (localbbfa != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "multiSessionDownloadProcessUpdate: BusinessParam=null  kind=" + parambbfe.jdField_a_of_type_Int + " mItem.mName=" + parambbfd.jdField_a_of_type_JavaLangString);
      return;
      parambbfd.jdField_a_of_type_Long = paramLong1;
      parambbfd.jdField_b_of_type_Long = paramLong2;
      parambbfd.jdField_c_of_type_Boolean = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      parambbfd = parambbfe.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (parambbfd.hasNext())
      {
        bbfd localbbfd = (bbfd)parambbfd.next();
        if (!localbbfd.jdField_a_of_type_Boolean)
        {
          localbbfd = (bbfd)localbbfa.jdField_a_of_type_JavaUtilHashMap.get(localbbfd.jdField_a_of_type_JavaLangString);
          if (localbbfd != null) {
            if (localbbfd.jdField_c_of_type_Boolean)
            {
              paramLong2 += localbbfd.jdField_a_of_type_Long;
              paramLong1 += localbbfd.jdField_b_of_type_Long;
            }
            else
            {
              paramLong1 += 1000L;
            }
          }
        }
      }
    } while (parambbfe.jdField_a_of_type_Bcwn == null);
    parambbfe.jdField_a_of_type_Bcwn.a(parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
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
        alwe.a(-1);
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
          alwe.a(-1);
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
        localObject3 = new beum();
        ((beum)localObject3).jdField_a_of_type_Beuq = new bbex(this, paramString, (String)localObject2, paramQQAppInterface, str);
        ((beum)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((beum)localObject3).jdField_a_of_type_Int = 0;
        ((beum)localObject3).jdField_c_of_type_JavaLangString = localFile.getPath();
        ((beum)localObject3).jdField_b_of_type_Int = bhnv.a(bevn.a().a());
        try
        {
          paramQQAppInterface = BaseApplicationImpl.getApplication().getRuntime();
          if (!QQAppInterface.class.isInstance(paramQQAppInterface)) {
            break;
          }
          ((QQAppInterface)paramQQAppInterface).getNetEngine(0).a((bevl)localObject3);
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
    } while (this.jdField_a_of_type_Bbfc == null);
    this.jdField_a_of_type_Bbfc.a();
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new CapturePtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<bbfs> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    while ((paramList == null) || (paramList.size() <= 0)) {}
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (bbfs)paramList.next();
      if ((((bbfs)localObject).jdField_a_of_type_JavaUtilList == null) || (((bbfs)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      localObject = ((bbfs)localObject).jdField_a_of_type_JavaUtilList.iterator();
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
  
  private boolean a(bbfe parambbfe)
  {
    bbfa localbbfa = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
    if (localbbfa != null)
    {
      if (localbbfa.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      parambbfe = parambbfe.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (parambbfe.hasNext())
      {
        bbfd localbbfd = (bbfd)parambbfe.next();
        if (!localbbfa.jdField_a_of_type_JavaUtilArrayList.contains(localbbfd.jdField_a_of_type_JavaLangString)) {}
        for (int i = 1; i == 0; i = 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(bbfe parambbfe, bbfd parambbfd)
  {
    if ((parambbfe == null) || (parambbfd == null)) {
      return false;
    }
    bbfa localbbfa = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
    if (localbbfa != null)
    {
      localbbfa.jdField_a_of_type_JavaUtilArrayList.remove(parambbfd.jdField_a_of_type_JavaLangString);
      if (a(parambbfe))
      {
        parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = a(parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
        parambbfd = this.jdField_a_of_type_JavaUtilList.iterator();
        while (parambbfd.hasNext())
        {
          Object localObject = (bbfs)parambbfd.next();
          if (((bbfs)localObject).jdField_a_of_type_JavaUtilList != null)
          {
            localObject = ((bbfs)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
              if (localPtvTemplateInfo.id.equals(parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              } else if (parambbfe.jdField_a_of_type_Int == localPtvTemplateInfo.kind) {
                localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
              }
            }
          }
        }
        if (parambbfe.jdField_a_of_type_Bcwn != null) {
          parambbfe.jdField_a_of_type_Bcwn.a(parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
        }
        if (localbbfa.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          localbbfa.jdField_a_of_type_JavaUtilHashMap.clear();
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
          Object localObject = bhmi.c(localFile.getPath());
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
              nof.a(localFile, a(paramString2));
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
  
  private bbfe b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bcwn parambcwn)
  {
    bbfe localbbfe = new bbfe();
    localbbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
    localbbfe.jdField_a_of_type_Bcwn = parambcwn;
    parambcwn = new bbfd();
    parambcwn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadName;
    parambcwn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadMd5;
    parambcwn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.bigHeadUrl;
    parambcwn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.bigHeadModelUsable;
    parambcwn.jdField_b_of_type_Boolean = false;
    localbbfe.jdField_a_of_type_JavaUtilArrayList.add(parambcwn);
    parambcwn = new bbfd();
    parambcwn.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.name;
    parambcwn.jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.md5;
    parambcwn.jdField_c_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
    parambcwn.jdField_a_of_type_Boolean = paramPtvTemplateInfo.usable;
    parambcwn.jdField_b_of_type_Boolean = true;
    localbbfe.jdField_a_of_type_JavaUtilArrayList.add(parambcwn);
    localbbfe.jdField_a_of_type_Int = 20;
    return localbbfe;
  }
  
  private void b(bbfe parambbfe)
  {
    bbfa localbbfa = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
    if (localbbfa != null) {
      localbbfa.b.remove(parambbfe);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Bbfs != null) && (this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.size() >= 30);
  }
  
  private ArrayList<bbfs> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool1 = bczv.c();
    boolean bool2 = bddo.c();
    boolean bool3 = QmcfManager.getInstance().hasQmcfEntrance(3);
    if ((!bool1) || (!bool2) || (!bool3))
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        bbfs localbbfs = (bbfs)localIterator1.next();
        List localList = localbbfs.jdField_a_of_type_JavaUtilList;
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
            QLog.d("CapturePtvTemplateManager", 2, "should hide dg tab! isQmcfEnableEntry=" + bool1 + " isFaceDanceEnableEntry=" + bool2 + " categoryID=" + localbbfs.jdField_a_of_type_Int);
          }
          localIterator1.remove();
        }
      }
      bbgh.a().a(bool1, bool2);
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
      Object localObject2 = (bbfs)((Iterator)localObject1).next();
      int k = i;
      int m = j;
      if (((bbfs)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).addAll(((bbfs)localObject2).jdField_a_of_type_JavaUtilList);
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
    bhsi.a(j, i);
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
            localObject = bhmi.c(((File)localObject).getPath());
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
              nof.a(new File(jdField_a_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
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
  
  public bbfs a(bbfs parambbfs)
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
      return parambbfs;
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
            parambbfs.jdField_a_of_type_JavaUtilList.add(localObject2);
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
          localObject = (bbfs)localIterator.next();
        } while ((((bbfs)localObject).jdField_a_of_type_Int != paramInt) || (((bbfs)localObject).jdField_a_of_type_JavaUtilList == null));
        localObject = ((bbfs)localObject).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
    } while (!localPtvTemplateInfo.id.equals(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("CapturePtvTemplateManager", 2, "QIMPtvTemplateManager existTemplateInfo id=" + paramString + " tagId=" + paramInt);
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public ArrayList<bbfs> a()
  {
    ArrayList localArrayList = c();
    if (!bdcy.a(jdField_a_of_type_Int))
    {
      List localList = a();
      if ((localList != null) && (!localList.isEmpty())) {
        localArrayList.removeAll(localList);
      }
    }
    return localArrayList;
  }
  
  public List<bbfs> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bbfs localbbfs = (bbfs)localIterator.next();
      if (localbbfs.jdField_a_of_type_Boolean) {
        localArrayList.add(localbbfs);
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
    if (this.jdField_a_of_type_Bczq != null)
    {
      this.jdField_a_of_type_Bczq.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager", 2, "notifyEventId eventId" + paramInt);
      }
    }
  }
  
  public void a(bbfc parambbfc)
  {
    this.jdField_a_of_type_Bbfc = parambbfc;
  }
  
  public void a(bczs parambczs, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Bczq == null) {
        this.jdField_a_of_type_Bczq = new bczq();
      }
      this.jdField_a_of_type_Bczq.a(parambczs, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AppInterface paramAppInterface, bbfe parambbfe)
  {
    if ((parambbfe.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null) || (paramAppInterface == null)) {}
    label98:
    label99:
    for (;;)
    {
      return;
      if ((parambbfe.jdField_a_of_type_JavaUtilArrayList != null) && (parambbfe.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        a(parambbfe);
        Iterator localIterator = parambbfe.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          bbfd localbbfd = (bbfd)localIterator.next();
          if (localbbfd.jdField_a_of_type_Boolean) {
            break label98;
          }
          a(paramAppInterface, parambbfe, localbbfd);
          i = 1;
        }
        for (;;)
        {
          break;
          if (i != 0) {
            break label99;
          }
          b(parambbfe);
          return;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, bbfe parambbfe, bbfd parambbfd)
  {
    Object localObject = (bbfa)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(parambbfe.jdField_a_of_type_Int));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem url: businessParam = null kind=" + parambbfe.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(parambbfd.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      if (((bbfa)localObject).jdField_a_of_type_JavaUtilHashMap.get(parambbfd.jdField_a_of_type_JavaLangString) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CapturePtvTemplateManager", 2, "[BG]downloadSessionTemplateItem[no need download] url: " + parambbfd.jdField_c_of_type_JavaLangString + " item.mName=" + parambbfd.jdField_a_of_type_JavaLangString);
        return;
      }
      ((bbfa)localObject).jdField_a_of_type_JavaUtilHashMap.put(parambbfd.jdField_a_of_type_JavaLangString, parambbfd);
      ((bbfa)localObject).jdField_a_of_type_JavaUtilArrayList.add(parambbfd.jdField_a_of_type_JavaLangString);
      localObject = new beum();
      ((beum)localObject).jdField_a_of_type_Beuq = new bbff(this, parambbfe, parambbfd);
      ((beum)localObject).jdField_a_of_type_JavaLangString = parambbfd.jdField_c_of_type_JavaLangString;
      ((beum)localObject).jdField_a_of_type_Int = 0;
      ((beum)localObject).jdField_c_of_type_JavaLangString = new File(jdField_a_of_type_JavaIoFile, parambbfd.jdField_a_of_type_JavaLangString).getPath();
      ((beum)localObject).a(parambbfd);
      ((beum)localObject).jdField_b_of_type_Int = bhnv.a(bevn.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a((bevl)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CapturePtvTemplateManager", 2, "downloadSessionTemplateItem url: " + parambbfd.jdField_c_of_type_JavaLangString);
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
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bcwn parambcwn)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    if ((paramPtvTemplateInfo.kind == 3) || (paramPtvTemplateInfo.kind == 4))
    {
      a(paramAppInterface, a(paramPtvTemplateInfo, parambcwn));
      return;
    }
    if (paramPtvTemplateInfo.kind == 20)
    {
      a(paramAppInterface, b(paramPtvTemplateInfo, parambcwn));
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, parambcwn);
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
    if (this.jdField_a_of_type_Bbfs == null)
    {
      this.jdField_a_of_type_Bbfs = new bbfs(anzj.a(2131700277));
      this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Bbfs);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.size())
      {
        if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.get(i)).id.equals(paramPtvTemplateInfo.id)) {
          j = i;
        }
        i += 1;
      }
      if (j == -1) {
        if (!b())
        {
          this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Bbfs);
          if (QLog.isColorLevel()) {
            QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("CapturePtvTemplateManager", 2, "setCurrentTemplateInfoToRecent index=" + j);
        return;
        this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.remove(29);
        this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
        a(paramInt, this.jdField_a_of_type_Bbfs);
        continue;
        if (j != 0)
        {
          this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.remove(j);
          this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          a(paramInt, this.jdField_a_of_type_Bbfs);
        }
      }
    }
  }
  
  public void a(List<bbfs> paramList)
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
      localList = ((bbfs)paramList.next()).jdField_a_of_type_JavaUtilList;
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
        int j = (int)(bhmi.a() / 1024.0F / 1024.0F);
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
        beum localbeum = new beum();
        localbeum.jdField_a_of_type_Beuq = new bbey(this, localPtvTemplateInfo);
        localbeum.jdField_a_of_type_JavaLangString = localPtvTemplateInfo.resurl;
        localbeum.jdField_a_of_type_Int = 0;
        localbeum.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, localPtvTemplateInfo.md5).getPath();
        localbeum.jdField_b_of_type_Int = bhnv.a(bevn.a().a());
        try
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if ((localAppRuntime != null) && ((localAppRuntime instanceof ToolRuntimePeak)))
          {
            localAppRuntime = ((ToolRuntimePeak)localAppRuntime).onGetSubRuntime("peak");
            if (localAppRuntime != null)
            {
              ((PeakAppInterface)localAppRuntime).getNetEngine(0).a(localbeum);
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
  
  public void a(List<bbfs> paramList, boolean paramBoolean)
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
  
  public ArrayList<bbfs> b()
  {
    ArrayList localArrayList = a();
    if (this.jdField_a_of_type_Bbfs == null)
    {
      this.jdField_a_of_type_Bbfs = new bbfs(anzj.a(2131700276));
      this.jdField_a_of_type_Bbfs.jdField_a_of_type_JavaUtilList = new ArrayList(30);
      a(this.jdField_a_of_type_Bbfs);
    }
    localArrayList.add(0, this.jdField_a_of_type_Bbfs);
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
  
  public void b(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bcwn parambcwn)
  {
    if ((paramPtvTemplateInfo == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bbez(this, paramPtvTemplateInfo, parambcwn);
      localbeum.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.jdField_c_of_type_JavaLangString = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.md5).getPath();
      localbeum.jdField_b_of_type_Int = bhnv.a(bevn.a().a());
      try
      {
        paramAppInterface.getNetEngine(0).a(localbeum);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbew
 * JD-Core Version:    0.7.0.1
 */