package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.struct.editor.DoodleInfo;
import com.tencent.aelight.camera.struct.editor.DoodleInfoLoadObserver;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PtvTemplateManager
{
  private static PtvTemplateManager jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager;
  private static File jdField_a_of_type_JavaIoFile;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "dov_ptv_template_usable_doodle";
  private static boolean jdField_a_of_type_Boolean = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.E);
  private static Object b = new Object();
  private PtvTemplateInfo jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(new File(PathUtils.d), "dov_doodle_template");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaIoFile.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static PtvTemplateManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager = new PtvTemplateManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager;
  }
  
  static PtvTemplateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = (PtvTemplateInfo)JSONUtils.a(localJSONObject, PtvTemplateInfo.class);
      localObject = paramString;
      try
      {
        if (!localJSONObject.has("doodleinfo")) {
          break label77;
        }
        localObject = localJSONObject.getJSONArray("doodleinfo");
      }
      catch (JSONException localJSONException1) {}
      localObject = paramString;
    }
    catch (JSONException localJSONException2)
    {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      localJSONException2.printStackTrace();
      localObject = paramString;
    }
    label77:
    DoodleInfo localDoodleInfo = null;
    paramString = (String)localObject;
    Object localObject = localDoodleInfo;
    if (localObject != null)
    {
      if (paramString == null) {
        return null;
      }
      try
      {
        int j = ((JSONArray)localObject).length();
        if (j <= 0) {
          return null;
        }
        paramString.a = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localDoodleInfo = (DoodleInfo)JSONUtils.a(((JSONArray)localObject).getJSONObject(i), DoodleInfo.class);
          if (localDoodleInfo != null) {
            paramString.a.add(localDoodleInfo);
          }
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseDoodleConfig|templateInfo= ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        if (QLog.isDevelopLevel()) {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
        return null;
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
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    if ((localObject1 != null) && (!((PtvTemplateInfo)localObject1).a.isEmpty()))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preDownloadDoodleTemplate|app= ");
        ((StringBuilder)localObject1).append(paramQQAppInterface);
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DoodleInfo localDoodleInfo = (DoodleInfo)((Iterator)localObject1).next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.c)) && (!localDoodleInfo.jdField_a_of_type_Boolean))
        {
          Object localObject2 = new PtvTemplateManager.4(this, localDoodleInfo, paramQQAppInterface);
          IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
          if (localIPreDownloadController.isEnable())
          {
            localObject2 = new RunnableTask(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject2, 4000L);
            localIPreDownloadController.requestPreDownload(10020, null, localDoodleInfo.b, 0, localDoodleInfo.c, new File(jdField_a_of_type_JavaIoFile, localDoodleInfo.b).getPath(), 2, 0, true, (AbsPreDownloadTask)localObject2);
          }
          else
          {
            ThreadManager.post((Runnable)localObject2, 8, null, true);
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "dov_doodle_template_new.cfg").exists();
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    if ((localObject1 != null) && (((PtvTemplateInfo)localObject1).a != null) && (!this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a.isEmpty()))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (DoodleInfo)((Iterator)localObject2).next();
        if (Integer.valueOf(((DoodleInfo)localObject1).jdField_a_of_type_JavaLangString).intValue() == paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(((DoodleInfo)localObject1).b);
          return ((StringBuilder)localObject2).toString();
        }
      }
    }
    return "";
  }
  
  public ArrayList<DoodleInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    label416:
    synchronized (b)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo != null) && (!this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a.isEmpty()))
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a.iterator();
        while (localIterator.hasNext())
        {
          DoodleInfo localDoodleInfo = (DoodleInfo)localIterator.next();
          Object localObject3;
          if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.b)))
          {
            boolean bool = new File(jdField_a_of_type_JavaIoFile, localDoodleInfo.b).exists();
            int k = 0;
            if (!bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
              }
              localDoodleInfo.jdField_a_of_type_Boolean = false;
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject3).append(localDoodleInfo.b);
              ((StringBuilder)localObject3).append(File.separator);
              localObject3 = new File(((StringBuilder)localObject3).toString(), "params.json");
              if (!((File)localObject3).exists())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
                }
                localDoodleInfo.jdField_a_of_type_Boolean = false;
              }
              else
              {
                Object localObject4 = ((File)localObject3).getParentFile();
                int j = k;
                if (((File)localObject4).isDirectory())
                {
                  localObject4 = ((File)localObject4).listFiles();
                  j = k;
                  if (localObject4 != null)
                  {
                    j = k;
                    if (localObject4.length > 0)
                    {
                      int m = localObject4.length;
                      i = 0;
                      j = k;
                      if (i < m)
                      {
                        if (!localObject4[i].getName().endsWith("png")) {
                          break label416;
                        }
                        j = 1;
                      }
                    }
                  }
                }
                if (j == 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|image is not exist ");
                  }
                  ((File)localObject3).delete();
                }
                else
                {
                  localArrayList.add(localDoodleInfo);
                }
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("info is null or info name is null ");
            ((StringBuilder)localObject3).append(localDoodleInfo);
            QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject3).toString());
          }
        }
        return localArrayList;
      }
      return null;
    }
  }
  
  public void a(AppInterface paramAppInterface, DoodleInfoLoadObserver paramDoodleInfoLoadObserver)
  {
    File localFile = new File(jdField_a_of_type_JavaIoFile, "dov_doodle_template_new.cfg");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "initLocalDoodleInfo config file not exist.");
      }
      return;
    }
    ThreadManager.excute(new PtvTemplateManager.1(this, localFile, paramDoodleInfoLoadObserver, paramAppInterface), 64, null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 4, "initLocalDoodleInfo async");
    }
  }
  
  public void a(String arg1, QQAppInterface paramQQAppInterface)
  {
    PtvTemplateInfo localPtvTemplateInfo = a(???);
    if (localPtvTemplateInfo == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.2(this, ???));
    synchronized (b)
    {
      this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo = localPtvTemplateInfo;
      ThreadManager.getFileThreadHandler().post(new PtvTemplateManager.3(this));
      a(paramQQAppInterface);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("key_sp_doodle_resource", 4).edit().putBoolean("key_doodle_resource_download_fail", paramBoolean ^ true).apply();
  }
  
  public boolean a(DoodleInfo paramDoodleInfo, boolean paramBoolean)
  {
    if (paramDoodleInfo != null)
    {
      if (TextUtils.isEmpty(paramDoodleInfo.b)) {
        return false;
      }
      Object localObject = new File(jdField_a_of_type_JavaIoFile, paramDoodleInfo.b);
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isDoodleTemplateUsable|file is not exist -> ");
          ((StringBuilder)localObject).append(paramDoodleInfo.b);
          QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
        }
        return false;
      }
      try
      {
        localObject = FileUtils.calcMd5(((File)localObject).getPath());
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramDoodleInfo.d)))
        {
          if (paramBoolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append(paramDoodleInfo.b);
            ((StringBuilder)localObject).append(File.separator);
            if (!new File(((StringBuilder)localObject).toString(), "params.json").exists())
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("isDoodleTemplateUsable|paramFile is not exist->>");
                ((StringBuilder)localObject).append(paramDoodleInfo.b);
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
              }
              try
              {
                ZipUtils.unZipFile(new File(jdField_a_of_type_JavaIoFile, paramDoodleInfo.b), jdField_a_of_type_JavaLangString);
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("isDoodleTemplateUsable|unZipFile->>");
                  ((StringBuilder)localObject).append(paramDoodleInfo.b);
                  QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
                }
                return true;
              }
              catch (IOException paramDoodleInfo)
              {
                if (QLog.isColorLevel()) {
                  paramDoodleInfo.printStackTrace();
                }
                return false;
              }
            }
          }
          return true;
        }
        return false;
      }
      catch (UnsatisfiedLinkError paramDoodleInfo)
      {
        if (QLog.isColorLevel()) {
          paramDoodleInfo.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("key_sp_doodle_resource", 4).getBoolean("key_doodle_resource_download_fail", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */