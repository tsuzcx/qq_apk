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
  private static String a = "dov_ptv_template_usable_doodle";
  private static File b;
  private static boolean c = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeatureRom(CameraCompatibleConstants.F);
  private static Object d = new Object();
  private static Object e = new Object();
  private static PtvTemplateManager f;
  private PtvTemplateInfo g;
  
  static
  {
    b = new File(new File(PathUtils.d), "dov_doodle_template");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  public static PtvTemplateManager a()
  {
    if (f == null) {
      synchronized (d)
      {
        if (f == null) {
          f = new PtvTemplateManager();
        }
      }
    }
    return f;
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
        paramString.k = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localDoodleInfo = (DoodleInfo)JSONUtils.a(((JSONArray)localObject).getJSONObject(i), DoodleInfo.class);
          if (localDoodleInfo != null) {
            paramString.k.add(localDoodleInfo);
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
    Object localObject1 = this.g;
    if ((localObject1 != null) && (!((PtvTemplateInfo)localObject1).k.isEmpty()))
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
      localObject1 = this.g.k.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        DoodleInfo localDoodleInfo = (DoodleInfo)((Iterator)localObject1).next();
        if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.c)) && (!localDoodleInfo.e))
        {
          Object localObject2 = new PtvTemplateManager.4(this, localDoodleInfo, paramQQAppInterface);
          IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramQQAppInterface.getRuntimeService(IPreDownloadController.class);
          if (localIPreDownloadController.isEnable())
          {
            localObject2 = new RunnableTask(paramQQAppInterface, "qq_doodle_res", (Runnable)localObject2, 4000L);
            localIPreDownloadController.requestPreDownload(10020, null, localDoodleInfo.b, 0, localDoodleInfo.c, new File(b, localDoodleInfo.b).getPath(), 2, 0, true, (AbsPreDownloadTask)localObject2);
          }
          else
          {
            ThreadManager.post((Runnable)localObject2, 8, null, true);
          }
        }
      }
    }
  }
  
  public static boolean b()
  {
    return new File(b, "dov_doodle_template_new.cfg").exists();
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((PtvTemplateInfo)localObject1).k != null) && (!this.g.k.isEmpty()))
    {
      Object localObject2 = this.g.k.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (DoodleInfo)((Iterator)localObject2).next();
        if (Integer.valueOf(((DoodleInfo)localObject1).a).intValue() == paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(a);
          ((StringBuilder)localObject2).append(((DoodleInfo)localObject1).b);
          return ((StringBuilder)localObject2).toString();
        }
      }
    }
    return "";
  }
  
  public void a(AppInterface paramAppInterface, DoodleInfoLoadObserver paramDoodleInfoLoadObserver)
  {
    File localFile = new File(b, "dov_doodle_template_new.cfg");
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
    synchronized (e)
    {
      this.g = localPtvTemplateInfo;
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
      Object localObject = new File(b, paramDoodleInfo.b);
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
            ((StringBuilder)localObject).append(a);
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
                ZipUtils.unZipFile(new File(b, paramDoodleInfo.b), a);
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
  
  public boolean c()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("key_sp_doodle_resource", 4).getBoolean("key_doodle_resource_download_fail", false);
  }
  
  public ArrayList<DoodleInfo> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    label416:
    synchronized (e)
    {
      if ((this.g != null) && (!this.g.k.isEmpty()))
      {
        Iterator localIterator = this.g.k.iterator();
        while (localIterator.hasNext())
        {
          DoodleInfo localDoodleInfo = (DoodleInfo)localIterator.next();
          Object localObject3;
          if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.b)))
          {
            boolean bool = new File(b, localDoodleInfo.b).exists();
            int k = 0;
            if (!bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|file is not exist ");
              }
              localDoodleInfo.e = false;
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(a);
              ((StringBuilder)localObject3).append(localDoodleInfo.b);
              ((StringBuilder)localObject3).append(File.separator);
              localObject3 = new File(((StringBuilder)localObject3).toString(), "params.json");
              if (!((File)localObject3).exists())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("DOV_Doodle_Strokes_PtvTemplateManager", 2, "getDoodleInfos|paramFile is not exist ");
                }
                localDoodleInfo.e = false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager
 * JD-Core Version:    0.7.0.1
 */