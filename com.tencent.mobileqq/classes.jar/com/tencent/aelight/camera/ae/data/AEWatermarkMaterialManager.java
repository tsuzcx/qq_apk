package com.tencent.aelight.camera.ae.data;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPath.Watermark;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AEWatermarkMaterialManager
{
  private final ArrayList<AEWatermarkMaterialManager.IWatermarkMgrListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final CopyOnWriteArrayList<AEMaterialCategory> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static AEWatermarkMaterialManager a()
  {
    return AEWatermarkMaterialManager.Holder.a();
  }
  
  private List<AEMaterialCategory> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = AEMaterialConfigParser.a(paramFile);
    if (paramFile != null)
    {
      if (paramFile.isEmpty()) {
        return localArrayList;
      }
      return paramFile;
    }
    return localArrayList;
  }
  
  private List<AEMaterialCategory> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return paramFile1;
      }
      Iterator localIterator1 = paramFile1.iterator();
      label228:
      while (localIterator1.hasNext())
      {
        paramFile2 = (AEMaterialCategory)localIterator1.next();
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          paramFile1 = (AEMaterialCategory)localIterator2.next();
          if (paramFile1.b.equals(paramFile2.b)) {
            break label104;
          }
        }
        paramFile1 = null;
        label104:
        if (paramFile1 == null)
        {
          paramFile1 = paramFile2.a.iterator();
          while (paramFile1.hasNext()) {
            a((AEMaterialMetaData)paramFile1.next());
          }
        }
        else
        {
          localIterator2 = paramFile2.a.iterator();
          while (localIterator2.hasNext())
          {
            AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
            Iterator localIterator3 = paramFile1.a.iterator();
            while (localIterator3.hasNext())
            {
              paramFile2 = (AEMaterialMetaData)localIterator3.next();
              if (localAEMaterialMetaData.k.equals(paramFile2.k)) {
                break label228;
              }
            }
            paramFile2 = null;
            if (paramFile2 == null) {
              a(localAEMaterialMetaData);
            } else if (!localAEMaterialMetaData.o.equals(paramFile2.o)) {
              a(localAEMaterialMetaData);
            }
          }
        }
      }
      return localList;
    }
    return paramFile1;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMaterialFolder: ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.k);
      QLog.d("AEWatermarkMaterialManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.k);
    if (((File)localObject).exists()) {
      FileUtils.deleteDirectory(((File)localObject).getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.k);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.deleteDirectory(paramAEMaterialMetaData.getPath());
    }
  }
  
  private void a(List<AEMaterialCategory> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEMaterialCategory)paramList.next();
      if ((localObject != null) && (((AEMaterialCategory)localObject).a != null))
      {
        localObject = ((AEMaterialCategory)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
          if (localAEMaterialMetaData != null) {
            localAEMaterialMetaData.e = AEMaterialManager.a(localAEMaterialMetaData);
          }
        }
      }
    }
  }
  
  private List<AEMaterialCategory> b()
  {
    File localFile = new File(AEPath.Watermark.b);
    Object localObject3 = new File(AEPath.Watermark.a);
    Object localObject1;
    Object localObject2;
    if (!localFile.exists())
    {
      if (!((File)localObject3).exists())
      {
        localObject1 = new ArrayList();
        AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        b();
        return localObject1;
      }
      try
      {
        localObject1 = a((File)localObject3);
        AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localObject1;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        FileUtils.deleteFile(((File)localObject3).getPath());
        localObject1 = new ArrayList();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("readAndParseConfigFile -> oldJson exists, newJson not exist, exception:");
        ((StringBuilder)localObject3).append(localAEMaterialConfigParseException3.toString());
        AEQLog.d("AEWatermarkMaterialManager", ((StringBuilder)localObject3).toString());
        b();
      }
    }
    else
    {
      if (!((File)localObject3).exists()) {}
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          localObject1 = a(localAEMaterialConfigParseException3);
          FileUtils.moveFile(localAEMaterialConfigParseException3.getPath(), ((File)localObject3).getPath());
          AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
          return localObject1;
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
        {
          FileUtils.deleteFile(localAEMaterialConfigParseException3.getPath());
          localObject3 = new ArrayList();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("readAndParseConfigFile -> oldJson not exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException1.toString());
          AEQLog.d("AEWatermarkMaterialManager", localStringBuilder.toString());
          b();
          return localObject3;
        }
        try
        {
          localObject2 = a((File)localObject3, localStringBuilder);
          FileUtils.deleteFile(((File)localObject3).getPath());
          FileUtils.moveFile(localStringBuilder.getPath(), ((File)localObject3).getPath());
          AEQLog.a("AEWatermarkMaterialManager", "readAndParseConfigFile -> try check update ");
        }
        catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
        {
          localObject2 = new ArrayList();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadMaterialListFromAssets  -> oldJson exists: exception:");
          localStringBuilder.append(localAEMaterialConfigParseException2.toString());
          AEQLog.d("AEWatermarkMaterialManager", localStringBuilder.toString());
          b();
        }
      }
    }
    return localObject2;
  }
  
  private void b()
  {
    AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqCircleWatermark", 4);
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  @WorkerThread
  public List<AEMaterialCategory> a()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getMaterialsSync---mHasLoaded=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      AEQLog.b("AEWatermarkMaterialManager", ((StringBuilder)localObject1).toString());
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
        return localObject1;
      }
      localObject1 = b();
      a((List)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll((Collection)localObject1);
      this.jdField_a_of_type_Boolean = true;
      localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      AEQLog.b("AEWatermarkMaterialManager", "onConfigUpdated---");
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((AEWatermarkMaterialManager.IWatermarkMgrListener)localIterator.next()).a();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(AEWatermarkMaterialManager.IWatermarkMgrListener paramIWatermarkMgrListener)
  {
    if (paramIWatermarkMgrListener == null)
    {
      AEQLog.d("AEWatermarkMaterialManager", "registerListener---the listener param is null");
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramIWatermarkMgrListener)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramIWatermarkMgrListener);
    }
  }
  
  public void b(AEWatermarkMaterialManager.IWatermarkMgrListener paramIWatermarkMgrListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramIWatermarkMgrListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager
 * JD-Core Version:    0.7.0.1
 */