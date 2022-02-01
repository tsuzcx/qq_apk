package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.av.AVLog;
import com.tencent.av.video.effect.lowlight.LowLightTools;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CaptureVideoFilterManager
{
  public static int a;
  public static Object a;
  public static final String a;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  public static String c;
  private static int d;
  public static String d;
  private static int jdField_e_of_type_Int = -1;
  private static final String jdField_e_of_type_JavaLangString;
  private static int jdField_f_of_type_Int = 0;
  private static final String jdField_f_of_type_JavaLangString;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public CaptureRedDotConfig a;
  private CaptureVideoFilterManager.OnResourceDownloadListener jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureVideoFilterManager$OnResourceDownloadListener;
  public FilterCategoryItem a;
  HashMap<String, FilterDesc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CopyOnWriteArrayList<FilterCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private final CopyOnWriteArrayList<FilterCategoryItem> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("pddata/prd/dov_capture_qsvf");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("capture_res");
    localStringBuilder.append(File.separator);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_Boolean = false;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("qav");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("beauty");
    localStringBuilder.append(File.separator);
    jdField_e_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_e_of_type_JavaLangString);
    localStringBuilder.append("SKINCOLOR");
    localStringBuilder.append(File.separator);
    jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("lowlight");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("LowLight.png");
    jdField_d_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = 0;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
  }
  
  private CaptureVideoFilterManager()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(DeviceInfoUtil.h());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(DeviceInfoUtil.d());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceInfo ");
    localStringBuilder.append((String)localObject);
    QLog.i("CaptureVideoFilterManager", 2, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public static int a(Context paramContext)
  {
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_qq_video_filter_config_version", 0);
    int i = j;
    if (j > 0)
    {
      paramContext = new StringBuilder();
      paramContext.append(jdField_a_of_type_JavaLangString);
      paramContext.append("filter_config.xml");
      i = j;
      if (!new File(paramContext.toString()).exists())
      {
        AVLog.printColorLog("CaptureVideoFilterManager", "getQQShortVideoFilterConfigVersion config file don't exist!");
        i = 0;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("getQQShortVideoFilterConfigVersion:");
    paramContext.append(i);
    AVLog.printColorLog("CaptureVideoFilterManager", paramContext.toString());
    return i;
  }
  
  public static final CaptureVideoFilterManager a()
  {
    return CaptureVideoFilterManager.CaptureVideoFilterManagerHolder.a();
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("filter_config.xml");
      localObject = new File(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQQShortVideoFilterConfig:");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("filter_config.xml");
      localStringBuilder.append("|");
      localStringBuilder.append(((File)localObject).exists());
      AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
      if (((File)localObject).exists()) {
        return FileUtils.readFileToString((File)localObject);
      }
      a(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setQQShortVideoFilterConfigVersion:");
    localStringBuilder.append(paramInt);
    AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = null;
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    else
    {
      paramContext = null;
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      paramString1 = new ArrayList();
      a(paramString2, paramString1);
    }
    else
    {
      paramString1 = localIterator;
      if (new File(jdField_b_of_type_JavaLangString).exists())
      {
        FileUtils.deleteDirectory(jdField_b_of_type_JavaLangString);
        paramString1 = localIterator;
      }
    }
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      if (paramString1 != null) {
        paramString1 = paramString1.iterator();
      }
    }
    else {
      while (paramString1.hasNext())
      {
        paramString2 = (FilterDesc)paramString1.next();
        localIterator = paramContext.iterator();
        while (localIterator.hasNext())
        {
          FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
          if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent res:");
            localStringBuilder.append(localFilterDesc.name);
            localStringBuilder.append("|");
            localStringBuilder.append(localFilterDesc.resMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.resMD5);
            AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
            if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
              FileUtils.deleteDirectory(paramString2.getResFold(jdField_b_of_type_JavaLangString));
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("compareContent iconMD5:");
            localStringBuilder.append(localFilterDesc.name);
            localStringBuilder.append("|");
            localStringBuilder.append(localFilterDesc.iconMD5);
            localStringBuilder.append("|");
            localStringBuilder.append(paramString2.iconMD5);
            AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
            if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
              FileUtils.deleteFile(paramString2.getIconFile(jdField_b_of_type_JavaLangString));
            }
          }
        }
        continue;
        AVLog.printColorLog("CaptureVideoFilterManager", "compareContent newList.size=0");
        FileUtils.deleteDirectory(jdField_b_of_type_JavaLangString);
      }
    }
    long l2 = System.currentTimeMillis();
    paramContext = new StringBuilder();
    paramContext.append("compareContent :");
    paramContext.append(l2 - l1);
    AVLog.printColorLog("CaptureVideoFilterManager", paramContext.toString());
  }
  
  static void a(String paramString, List<FilterDesc> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      paramList.clear();
      try
      {
        paramList.addAll(FilterDesc.parse(new JSONObject(paramString).getJSONArray("filters")));
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    AVLog.printColorLog("CaptureVideoFilterManager", "parseConfig|content is empty.");
  }
  
  private void b()
  {
    File localFile = new File(jdField_d_of_type_JavaLangString);
    if (localFile.exists())
    {
      localFile.delete();
    }
    else
    {
      localObject1 = localFile.getParentFile();
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
    }
    Object localObject1 = LowLightTools.getLowLightImage(3.0F, 0.88F, 0.96F, 1.22F, false);
    try
    {
      localObject2 = new FileOutputStream(localFile);
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).flush();
      ((FileOutputStream)localObject2).close();
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LowLightTools saveBitmap:");
      ((StringBuilder)localObject2).append(localException);
      QLog.w("CaptureVideoFilterManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (!localFile.exists())
    {
      jdField_a_of_type_Int = jdField_e_of_type_Int;
      return;
    }
    jdField_a_of_type_Int = jdField_c_of_type_Int;
  }
  
  public FilterCategoryItem a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraStructEditorFilterCategoryItem;
  }
  
  public FilterDesc a(String paramString)
  {
    return (FilterDesc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    CaptureRedDotConfig localCaptureRedDotConfig = CaptureRedDotConfig.getRedDotConfigFromFile(jdField_a_of_type_JavaLangString, "_Filter");
    if (localCaptureRedDotConfig != null)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("CaptureVideoFilterManger init UpdateByServer= ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Boolean);
        QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)???).toString());
      }
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig = localCaptureRedDotConfig;
        }
        return;
      }
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      AVLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig error ");
      return;
    }
    a(paramContext, paramString, a(paramContext));
    FileUtils.writeFile(jdField_a_of_type_JavaLangString, "filter_config.xml", paramString);
    a(paramContext, paramInt);
    a();
    a(paramString);
    AVLog.printColorLog("CaptureVideoFilterManager", "updateQQShortVideoFilterConfig sendBroadcast");
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      CaptureRedDotConfig localCaptureRedDotConfig = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig;
      if ((localCaptureRedDotConfig != null) && (localCaptureRedDotConfig.update))
      {
        localCaptureRedDotConfig = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig;
        localCaptureRedDotConfig.update = false;
        CaptureRedDotConfig.saveRedDotConfig(localCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
      }
    }
    else
    {
      CaptureRedDotConfig.saveRedDotConfig(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig, jdField_a_of_type_JavaLangString, "_Filter");
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "needShowRedDot|mCaptureRedDotConfig is null");
        }
        return false;
      }
      boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.needShowRedDot(paramInt1, paramInt2, paramString);
      if ((bool) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ShowRedDot==> type=");
        localStringBuilder.append(paramInt1);
        if (paramInt1 == 2)
        {
          localStringBuilder.append(",categoryId=");
          localStringBuilder.append(paramInt2);
        }
        else if (paramInt1 == 3)
        {
          localStringBuilder.append(",id=");
          localStringBuilder.append(paramString);
        }
        else if (paramInt1 == 4)
        {
          localStringBuilder.append(",defaultId=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultUseId);
        }
        else if (paramInt1 == 5)
        {
          localStringBuilder.append(",defaultCategoryId=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId);
        }
        QLog.d("QIMRedDotConfig_Filter", 2, localStringBuilder.toString());
      }
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i;
    label783:
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig = new CaptureRedDotConfig(1);
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig_Filter", 2, "updateFromServer config is null");
        }
      }
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).getJSONArray("categorys");
        i = ((JSONObject)localObject2).optInt("iconRedDotVersion");
        boolean bool = ((JSONObject)localObject2).optBoolean("needRedDot");
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFromServer oldVer=");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.iconVersion);
          ((StringBuilder)localObject3).append(",ver=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",showRed ");
          ((StringBuilder)localObject3).append(bool);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
        }
        int j = ((JSONObject)localObject2).optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.showTime = j;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.iconVersion != i)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.iconVersion = i;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.showRedDot = bool;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.hasShow = false;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.firstShowTime = 0L;
        }
        i = ((JSONObject)localObject2).optInt("defaultCategoryVersion");
        j = ((JSONObject)localObject2).optInt("defaultCategoryId", -1);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateFromServer oldVer=");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer);
          ((StringBuilder)localObject3).append(",ver=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",defaultCategoryId ");
          ((StringBuilder)localObject3).append(j);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer != i)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryVer = i;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultCategoryId = j;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.hasChoose = false;
        }
        i = ((JSONObject)localObject2).optInt("defaultUseVersion");
        Object localObject3 = ((JSONObject)localObject2).optString("defaultUseId");
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("updateFromServer oldVer=");
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer);
          ((StringBuilder)localObject4).append(",ver=");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append(",defaultUseId ");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject4).toString());
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer != i)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultUseVer = i;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.defaultUseId = ((String)localObject3);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.hasUse = false;
        }
        i = ((JSONObject)localObject2).optInt("itemRedDotVersion");
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.redDotVersion != i)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.redDotVersion = i;
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.redDotItems.clear();
          if (((JSONObject)localObject2).has("itemNeedRedDot"))
          {
            localObject2 = ((JSONObject)localObject2).getJSONArray("itemNeedRedDot");
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("updateFromServer redDotList: ");
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject4 = ((JSONArray)localObject2).optString(i);
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label783;
              }
              CaptureRedDotConfig.RedDotItemConfig localRedDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
              localRedDotItemConfig.filterId = ((String)localObject4);
              ((StringBuilder)localObject3).append((String)localObject4);
              ((StringBuilder)localObject3).append(",");
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig.redDotItems.put(localObject4, localRedDotItemConfig);
              break label783;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMRedDotConfig_Filter", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
        localObject2 = new ArrayList(paramString.length());
        i = 0;
        while (i < paramString.length())
        {
          ((ArrayList)localObject2).add(new FilterCategory(paramString.getJSONObject(i), this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaCaptureDataCaptureRedDotConfig));
          i += 1;
        }
        this.jdField_a_of_type_Boolean = true;
        a(false);
        return true;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QIMRedDotConfig", 2, QLog.getStackTraceString(paramString));
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */