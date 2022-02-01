package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.data.TemplateGroupItem;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMPtvTemplateManager
  extends QIMAsyncManager
{
  public static int a;
  public static File a;
  public static final Long a;
  public static String a;
  public static AtomicBoolean a;
  private static File jdField_b_of_type_JavaIoFile;
  public static String b;
  public static String c;
  private static final String h;
  private TemplateGroupItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem;
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
  protected final Object a;
  HashMap<Integer, QIMPtvTemplateManager.BusinessParam> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected List<TemplateGroupItem> a;
  private TemplateGroupItem jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem;
  protected Object b;
  String d;
  String e;
  public String f = "recent_template_setting";
  public String g = "recent_template_list";
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(2000L);
    jdField_a_of_type_JavaLangString = "ptv_template_usable";
    jdField_b_of_type_JavaLangString = "ptv_debug";
    jdField_c_of_type_JavaLangString = "ptv_template_usable_doodle";
    Object localObject = new File(PathUtils.d);
    h = ((File)localObject).getPath();
    jdField_b_of_type_JavaIoFile = new File((File)localObject, "dov_ptv_template_dov");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_JavaIoFile = new File((File)localObject, "doodle_template");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaIoFile.getPath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QIMPtvTemplateManager()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private int a(List<PtvTemplateInfo> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return -1;
      }
      int j = 0;
      while (j < paramList.size())
      {
        if (((PtvTemplateInfo)paramList.get(j)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          return j;
        }
        j += 1;
      }
    }
    return -1;
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
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
        QLog.e("QIMPtvTemplateManager_PTV", 1, "loadFileContent error, ", paramFile);
      }
    }
    return null;
  }
  
  static List<TemplateGroupItem> a(QIMPtvTemplateManager paramQIMPtvTemplateManager, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        if (paramQIMPtvTemplateManager != null)
        {
          if (((JSONObject)localObject).has("guide_video_url")) {
            paramQIMPtvTemplateManager.d = ((JSONObject)localObject).getString("guide_video_url");
          }
          if (((JSONObject)localObject).has("guide_video_md5")) {
            paramQIMPtvTemplateManager.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).getString("guide_video_md5");
          }
        }
        boolean bool = ((JSONObject)localObject).has("bigheadCommonRes");
        String str = "";
        if (!bool) {
          break label168;
        }
        paramString = ((JSONObject)localObject).getJSONObject("bigheadCommonRes");
        if (paramString == null) {
          break label168;
        }
        str = paramString.optString("bighead_model_name", "");
        paramQIMPtvTemplateManager = paramString.optString("bighead_model_resurl", "");
        paramString = paramString.optString("bighead_model_resmd5", "");
        if (((JSONObject)localObject).has("category"))
        {
          localObject = a(((JSONObject)localObject).getJSONArray("category"));
          a((List)localObject, str, paramQIMPtvTemplateManager, paramString);
          return localObject;
        }
      }
      catch (JSONException paramQIMPtvTemplateManager)
      {
        if (QLog.isColorLevel()) {
          paramQIMPtvTemplateManager.printStackTrace();
        }
      }
      return null;
      label168:
      paramString = "";
      paramQIMPtvTemplateManager = paramString;
    }
  }
  
  static List<TemplateGroupItem> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int k = paramJSONArray.length();
    if (k <= 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    for (;;)
    {
      if (j < k) {
        try
        {
          TemplateGroupItem localTemplateGroupItem = new TemplateGroupItem();
          Object localObject = paramJSONArray.getJSONObject(j);
          if (((JSONObject)localObject).has("content")) {
            localTemplateGroupItem.jdField_a_of_type_JavaUtilList = PtvTemplateManager.PtvTemplateInfoUtil.a(((JSONObject)localObject).getJSONArray("content"));
          }
          if (((JSONObject)localObject).has("categoryName")) {
            localTemplateGroupItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("categoryName");
          }
          if ((((JSONObject)localObject).has("TipsVer")) && (((JSONObject)localObject).has("Tips")))
          {
            localTemplateGroupItem.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("TipsVer");
            localTemplateGroupItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("Tips");
          }
          localTemplateGroupItem.jdField_b_of_type_Boolean = "1".equals(((JSONObject)localObject).optString("random_position"));
          if (((JSONObject)localObject).has("categoryId"))
          {
            localTemplateGroupItem.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("categoryId");
            if ((localTemplateGroupItem.jdField_a_of_type_JavaUtilList != null) && (!localTemplateGroupItem.jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              localObject = localTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((PtvTemplateInfo)((Iterator)localObject).next()).jdField_c_of_type_Int = localTemplateGroupItem.jdField_a_of_type_Int;
              }
            }
          }
          localArrayList.add(localTemplateGroupItem);
          j += 1;
        }
        catch (JSONException paramJSONArray)
        {
          if (QLog.isColorLevel()) {
            paramJSONArray.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(QIMPtvTemplateManager.DLSession paramDLSession, QIMPtvTemplateManager.DLItem paramDLItem, long paramLong1, long paramLong2)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return;
      }
      Object localObject = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("multiSessionDownloadProcessUpdate: BusinessParam=null  kind=");
          ((StringBuilder)localObject).append(paramDLSession.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append(" mItem.mName=");
          ((StringBuilder)localObject).append(paramDLItem.jdField_a_of_type_JavaLangString);
          QLog.e("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      paramDLItem.jdField_a_of_type_Long = paramLong1;
      paramDLItem.b = paramLong2;
      paramDLItem.c = true;
      paramLong2 = 0L;
      paramLong1 = 1L;
      paramDLItem = paramDLSession.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDLItem.hasNext())
      {
        QIMPtvTemplateManager.DLItem localDLItem = (QIMPtvTemplateManager.DLItem)paramDLItem.next();
        if (!localDLItem.jdField_a_of_type_Boolean)
        {
          localDLItem = (QIMPtvTemplateManager.DLItem)((QIMPtvTemplateManager.BusinessParam)localObject).jdField_a_of_type_JavaUtilHashMap.get(localDLItem.jdField_a_of_type_JavaLangString);
          if (localDLItem != null)
          {
            long l;
            if (localDLItem.c)
            {
              paramLong2 += localDLItem.jdField_a_of_type_Long;
              l = localDLItem.b;
            }
            else
            {
              l = 1000L;
            }
            paramLong1 += l;
          }
        }
      }
      if (paramDLSession.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
        paramDLSession.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo, (int)(paramLong2 * 100L / paramLong1));
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.2(paramString2, paramString1));
  }
  
  private static void a(List<TemplateGroupItem> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (paramList != null)
      {
        if (paramList.size() <= 0) {
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (TemplateGroupItem)paramList.next();
          if ((((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null) && (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.size() > 0))
          {
            localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
              if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.jdField_e_of_type_Int == 20))
              {
                localPtvTemplateInfo.y = paramString1;
                localPtvTemplateInfo.z = paramString2;
                localPtvTemplateInfo.A = paramString3;
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_b_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QIMPtvTemplateManager isStickerConfigFileExist");
      localStringBuilder.append(bool);
      QLog.i("QIMPtvTemplateManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean a(QIMPtvTemplateManager.DLSession paramDLSession)
  {
    QIMPtvTemplateManager.BusinessParam localBusinessParam = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
    if (localBusinessParam != null)
    {
      if (localBusinessParam.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return true;
      }
      paramDLSession = paramDLSession.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDLSession.hasNext())
      {
        QIMPtvTemplateManager.DLItem localDLItem = (QIMPtvTemplateManager.DLItem)paramDLSession.next();
        if (!(localBusinessParam.jdField_a_of_type_JavaUtilArrayList.contains(localDLItem.jdField_a_of_type_JavaLangString) ^ true)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean a(QIMPtvTemplateManager.DLSession paramDLSession, QIMPtvTemplateManager.DLItem paramDLItem)
  {
    if (paramDLSession != null)
    {
      if (paramDLItem == null) {
        return false;
      }
      QIMPtvTemplateManager.BusinessParam localBusinessParam = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramDLSession.jdField_a_of_type_Int));
      if (localBusinessParam != null)
      {
        localBusinessParam.jdField_a_of_type_JavaUtilArrayList.remove(paramDLItem.jdField_a_of_type_JavaLangString);
        if (a(paramDLSession))
        {
          paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.jdField_b_of_type_Boolean = a(paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo);
          paramDLItem = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramDLItem.hasNext())
          {
            Object localObject = (TemplateGroupItem)paramDLItem.next();
            if (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null)
            {
              localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
                if (localPtvTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.jdField_a_of_type_JavaLangString)) {
                  localPtvTemplateInfo.jdField_b_of_type_Boolean = a(localPtvTemplateInfo);
                } else if (paramDLSession.jdField_a_of_type_Int == localPtvTemplateInfo.jdField_e_of_type_Int) {
                  localPtvTemplateInfo.jdField_b_of_type_Boolean = a(localPtvTemplateInfo);
                }
              }
            }
          }
          if (paramDLSession.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
            paramDLSession.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo, paramDLSession.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.jdField_b_of_type_Boolean);
          }
          if (localBusinessParam.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
            localBusinessParam.jdField_a_of_type_JavaUtilHashMap.clear();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new File(jdField_b_of_type_JavaIoFile, paramString1);
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      localObject = FileUtils.calcMd5(((File)localObject).getPath());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramString2)))
      {
        paramString2 = new StringBuilder();
        paramString2.append(jdField_a_of_type_JavaLangString);
        paramString2.append(paramString1);
        paramString2.append(File.separator);
        localObject = paramString2.toString();
        paramString2 = new File((String)localObject, "params.json");
        localObject = new File((String)localObject, "params.dat");
        if ((!paramString2.exists()) && ((!paramBoolean) || (!((File)localObject).exists()))) {
          try
          {
            ZipUtils.unZipFile(new File(jdField_b_of_type_JavaIoFile, paramString1), jdField_a_of_type_JavaLangString);
            return true;
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable unZipFile exp:", paramString1);
            }
            return (paramString2.exists()) && ((paramBoolean) || (((File)localObject).exists()));
          }
        }
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("judgeTemplateUsable md5 exp, fileMd5:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", tempMd5:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", name:");
        localStringBuilder.append(paramString1);
        QLog.e("QIMPtvTemplateManager", 2, localStringBuilder.toString());
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMPtvTemplateManager", 2, "judgeTemplateUsable calcMd5 error:", paramString1);
      }
    }
    return false;
  }
  
  private boolean b()
  {
    TemplateGroupItem localTemplateGroupItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem;
    return (localTemplateGroupItem != null) && (localTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences(this.f, 0);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.g);
    ((StringBuilder)localObject3).append((String)???);
    ??? = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject3).toString(), null);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getRecentTemplate list=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("QIMPtvTemplateManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)???)) {
      return paramTemplateGroupItem;
    }
    localObject2 = ((String)???).split("\\$");
    int j;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.clear();
      j = 0;
      if (j < localObject2.length)
      {
        localObject3 = localObject2[j].split("\\|");
        if ((localObject3 != null) && (localObject3.length == 2))
        {
          Integer.valueOf(localObject3[1]).intValue();
          localObject3 = a(localObject3[0]);
          if (localObject3 != null)
          {
            if (paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() >= 100) {
              return paramTemplateGroupItem;
            }
            paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
        }
      }
      else
      {
        return paramTemplateGroupItem;
      }
    }
  }
  
  public PtvTemplateInfo a(String paramString)
  {
    Object localObject;
    PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      localObject = a().iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localIterator = ((TemplateGroupItem)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList.iterator();
      }
      localPtvTemplateInfo = (PtvTemplateInfo)localIterator.next();
    } while (!localPtvTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramString));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QIMPtvTemplateManager existTemplateInfo id=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QIMPtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    return localPtvTemplateInfo;
    return null;
  }
  
  public Runnable a(File paramFile)
  {
    return new QIMPtvTemplateManager.5(this, paramFile);
  }
  
  public Runnable a(boolean paramBoolean)
  {
    return new QIMPtvTemplateManager.1(this, paramBoolean);
  }
  
  public String a()
  {
    return this.i;
  }
  
  public ArrayList<TemplateGroupItem> a()
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    List localList = a();
    if ((localList != null) && (!localList.isEmpty())) {
      localArrayList.removeAll(localList);
    }
    return localArrayList;
  }
  
  public List<TemplateGroupItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)localIterator.next();
      if (localTemplateGroupItem.jdField_a_of_type_Boolean) {
        localArrayList.add(localTemplateGroupItem);
      }
    }
    return localArrayList;
  }
  
  protected List<TemplateGroupItem> a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    paramFile = a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return null;
    }
    paramFile = a(this, paramFile);
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return null;
      }
      Iterator localIterator = paramFile.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TemplateGroupItem)localIterator.next();
        if ((((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList != null) && (((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
        {
          localObject = ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject).next();
            if (localPtvTemplateInfo != null) {
              localPtvTemplateInfo.jdField_b_of_type_Boolean = a(localPtvTemplateInfo);
            }
          }
        }
      }
      e();
      return paramFile;
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
    if (localObservable != null)
    {
      localObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("notifyEventId eventId");
        paramObject.append(paramInt);
        QLog.d("QIMPtvTemplateManager", 2, paramObject.toString());
      }
    }
  }
  
  public void a(PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem == null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem = new TemplateGroupItem(HardCodeUtil.a(2131709784));
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList(100);
        a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem);
      }
      if (this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem == null) {
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.a();
      }
      int j = a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList, paramPtvTemplateInfo.jdField_a_of_type_JavaLangString);
      if (j == -1)
      {
        if (!b())
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem });
          }
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "setCurrentTemplateInfoToRecent not isRecentTemplateFull ");
          }
        }
        else
        {
          PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(99);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(localPtvTemplateInfo);
          this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem });
          }
        }
      }
      else if (j != 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.remove(j);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(0, paramPtvTemplateInfo);
      }
      if (QLog.isColorLevel())
      {
        paramPtvTemplateInfo = new StringBuilder();
        paramPtvTemplateInfo.append("setCurrentTemplateInfoToRecent index=");
        paramPtvTemplateInfo.append(j);
        QLog.d("QIMPtvTemplateManager", 2, paramPtvTemplateInfo.toString());
      }
      return;
    }
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "startDownloadTemplate is null");
      }
      return;
    }
    b(paramAppInterface, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
  }
  
  public void a(String paramString, int paramInt)
  {
    List localList = a(null, paramString);
    if ((localList != null) && (!localList.isEmpty()))
    {
      a(paramString, "ptv_template_new.cfg");
      a().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
      return;
    }
    QLog.d("QIMPtvTemplateManager", 1, "handleGetServerConfig no infos");
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMPtvTemplateManager setSelectedPtvTemplate id=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" categoryId =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPath=");
    localStringBuilder.append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, localStringBuilder.toString());
    }
    a(113, null);
  }
  
  void a(List<TemplateGroupItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TemplateGroupItem)paramList.next();
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList);
        int j = 0;
        while (j < localArrayList.size())
        {
          localObject = (PtvTemplateInfo)localArrayList.get(j);
          if ((localObject != null) && (((PtvTemplateInfo)localObject).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((PtvTemplateInfo)localObject).jdField_c_of_type_JavaLangString))) {
            ThreadManager.getFileThreadHandler().post(new QIMPtvTemplateManager.4(this, (PtvTemplateInfo)localObject));
          }
          j += 1;
        }
      }
    }
  }
  
  public boolean a(PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return false;
    }
    try
    {
      if (paramPtvTemplateInfo.jdField_e_of_type_Int == 5)
      {
        paramPtvTemplateInfo.h = a(paramPtvTemplateInfo.u, paramPtvTemplateInfo.v, false);
        paramPtvTemplateInfo.i = a(paramPtvTemplateInfo.w, paramPtvTemplateInfo.x, false);
        bool1 = a(paramPtvTemplateInfo.jdField_e_of_type_JavaLangString, paramPtvTemplateInfo.d, false);
        if (QLog.isColorLevel()) {
          QLog.d("QIMPtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", new Object[] { Boolean.valueOf(paramPtvTemplateInfo.h), Boolean.valueOf(paramPtvTemplateInfo.i), Boolean.valueOf(bool1), paramPtvTemplateInfo.jdField_a_of_type_JavaLangString }));
        }
        if (paramPtvTemplateInfo.h)
        {
          boolean bool2 = paramPtvTemplateInfo.i;
          if (bool2) {
            return bool1;
          }
        }
        return false;
      }
      if (paramPtvTemplateInfo.jdField_e_of_type_Int == 6)
      {
        paramPtvTemplateInfo.h = a(paramPtvTemplateInfo.u, paramPtvTemplateInfo.v, false);
        if (paramPtvTemplateInfo.h)
        {
          bool1 = a(paramPtvTemplateInfo.jdField_e_of_type_JavaLangString, paramPtvTemplateInfo.d, false);
          return bool1;
        }
        return false;
      }
      boolean bool1 = a(paramPtvTemplateInfo.jdField_e_of_type_JavaLangString, paramPtvTemplateInfo.d, true);
      return bool1;
    }
    finally {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTemplateGroupItem = null;
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "QIMPtvTemplateManager onDestroy");
    }
  }
  
  public void b(AppInterface paramAppInterface, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      paramPtvTemplateInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new QIMPtvTemplateManager.6(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.mReqUrl = paramPtvTemplateInfo.jdField_c_of_type_JavaLangString;
      localHttpNetReq.mHttpMethod = 0;
      if (paramPtvTemplateInfo.jdField_e_of_type_JavaLangString == null)
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("startDownloadTemplate fail, info.name is null, url:");
        paramAppInterface.append(paramPtvTemplateInfo.jdField_c_of_type_JavaLangString);
        QLog.i("QIMPtvTemplateManager", 1, paramAppInterface.toString());
        return;
      }
      localHttpNetReq.mOutPath = new File(jdField_b_of_type_JavaIoFile, paramPtvTemplateInfo.jdField_e_of_type_JavaLangString).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          paramAppInterface.printStackTrace();
        }
      }
      localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("startDownloadTemplate url: ");
        paramAppInterface.append(paramPtvTemplateInfo.jdField_c_of_type_JavaLangString);
        QLog.i("QIMPtvTemplateManager", 2, paramAppInterface.toString());
      }
    }
  }
  
  public void d()
  {
    f();
  }
  
  protected void e()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QIMPtvTemplateManager.3(this), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void f()
  {
    File localFile = new File(jdField_b_of_type_JavaIoFile, "ptv_template_new.cfg");
    Runnable localRunnable;
    if (!localFile.exists()) {
      localRunnable = a(false);
    } else {
      localRunnable = a(localFile);
    }
    localRunnable.run();
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMPtvTemplateManager", 4, new Object[] { "initTemplateConfig, cacheFile exists:", Boolean.valueOf(localFile.exists()), ", runnable:", Integer.valueOf(localRunnable.hashCode()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */