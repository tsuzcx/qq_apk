package com.tencent.aelight.camera.ae.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPath.GIF;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AEGifMaterialManager
{
  private static final AEGifMaterialManager a = new AEGifMaterialManager();
  private static final Type b = new AEGifMaterialManager.1().getType();
  private String c = "";
  private final Object d = new Object();
  private List<AEGifCategoryWrapper> e = new LinkedList();
  private Map<String, WeakReference<AEGifMaterialManager.DownloadCallback>> f = new ConcurrentHashMap();
  private Map<String, MetaMaterial> g = new HashMap();
  
  public static AEGifMaterialManager a()
  {
    return a;
  }
  
  @Nullable
  private String a(@NonNull MetaCategory paramMetaCategory, @NonNull String paramString)
  {
    if (paramMetaCategory.dynamicFields == null) {
      return null;
    }
    return (String)paramMetaCategory.dynamicFields.get(paramString);
  }
  
  private Map<String, MetaMaterial> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    AEQLog.a("AEGifMaterialManager", "[buildMaterialMap]");
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEGifCategoryWrapper)paramList.next();
      if ((localObject != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)))
      {
        localObject = ((AEGifCategoryWrapper)localObject).materialWrapperList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)((Iterator)localObject).next();
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.a)) && (localAEMaterialWrapper.b != null)) {
            localHashMap.put(localAEMaterialWrapper.a, localAEMaterialWrapper.b);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.f.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.f.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (AEGifMaterialManager.DownloadCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AEGifMaterialManager.DownloadCallback)localObject).a(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  private void a(@NonNull List<AEGifCategoryWrapper> paramList1, @NonNull List<AEGifCategoryWrapper> paramList2)
  {
    AEQLog.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial]");
    paramList1 = a(paramList1);
    paramList2 = a(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramList1 = (Map.Entry)localIterator.next();
      Object localObject = (String)paramList1.getKey();
      paramList1 = (MetaMaterial)paramList1.getValue();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramList1 != null))
      {
        if (paramList2.containsKey(localObject))
        {
          localObject = (MetaMaterial)paramList2.get(localObject);
          if ((localObject != null) && (!paramList1.packageMd5.equals(((MetaMaterial)localObject).packageMd5))) {}
        }
        else
        {
          paramList1 = null;
        }
        if (paramList1 != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[diffTwoListAndDeleteOutdatedMaterial] find outdated material id=");
          ((StringBuilder)localObject).append(paramList1.id);
          AEQLog.a("AEGifMaterialManager", ((StringBuilder)localObject).toString());
          c(paramList1);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[notifyGifCategoryListUpdated], validData=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEGifMaterialManager", localStringBuilder.toString());
    CameraOperationHelper.e().postValue(Boolean.valueOf(paramBoolean));
  }
  
  private boolean a(@NonNull MetaCategory paramMetaCategory)
  {
    paramMetaCategory = a(paramMetaCategory, "show_list");
    return (!TextUtils.isEmpty(paramMetaCategory)) && ("true".equals(paramMetaCategory));
  }
  
  private boolean a(AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (paramAEMaterialWrapper == null) {
      return true;
    }
    if (ParamsUtil.a(paramAEMaterialWrapper.c) > ParamsUtil.b()) {
      return false;
    }
    if (paramAEMaterialWrapper.d != null)
    {
      String str = ParamsUtil.c();
      if (paramAEMaterialWrapper.d.contains(str)) {
        return false;
      }
    }
    return true;
  }
  
  private List<AEGifCategoryWrapper> b(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    AEQLog.a("AEGifMaterialManager", "[updateMaterialStatus]");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEGifCategoryWrapper)localIterator.next();
      if ((localObject != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)))
      {
        localObject = ((AEGifCategoryWrapper)localObject).materialWrapperList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)((Iterator)localObject).next();
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.a)) && (localAEMaterialWrapper.b != null))
          {
            int i;
            if (b(localAEMaterialWrapper.b)) {
              i = 2;
            } else {
              i = 0;
            }
            localAEMaterialWrapper.f = i;
          }
        }
      }
    }
    return paramList;
  }
  
  private boolean b(@Nullable MetaMaterial paramMetaMaterial)
  {
    boolean bool = false;
    if ((paramMetaMaterial != null) && (!TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      File localFile1 = new File(AEPath.CAMERA.FILES.h, paramMetaMaterial.id);
      if (!localFile1.exists()) {
        return false;
      }
      File localFile3 = new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id);
      paramMetaMaterial = new File(localFile3, "params.json");
      File localFile2 = new File(localFile3, "params.dat");
      if ((!paramMetaMaterial.exists()) && (!localFile2.exists())) {
        try
        {
          ZipUtils.unZipFile(localFile1, localFile3.getPath());
          return true;
        }
        catch (Exception localException)
        {
          AEQLog.a("AEGifMaterialManager", "[materialExists] unZipFile raised exception", localException);
          if ((paramMetaMaterial.exists()) || (localFile2.exists())) {
            bool = true;
          }
          return bool;
        }
      }
      return true;
    }
    AEQLog.d("AEGifMaterialManager", "[materialExists] metaMaterial is invalid");
    return false;
  }
  
  @NonNull
  private List<AEGifCategoryWrapper> c(@Nullable String paramString)
  {
    AEQLog.a("AEGifMaterialManager", "[parseGifCategoryFromJson]");
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] jsonString is empty");
      return new LinkedList();
    }
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)GsonUtils.json2Obj(paramString, b);
    if ((localGetCategoryMaterialRsp != null) && (!CollectionUtils.isEmpty(localGetCategoryMaterialRsp.Categories)))
    {
      LinkedList localLinkedList1 = new LinkedList();
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < localGetCategoryMaterialRsp.Categories.size())
      {
        MetaCategory localMetaCategory = (MetaCategory)localGetCategoryMaterialRsp.Categories.get(i);
        if ((localMetaCategory != null) && (!CollectionUtils.isEmpty(localMetaCategory.materials)))
        {
          LinkedList localLinkedList2 = new LinkedList();
          int j = 0;
          while (j < localMetaCategory.materials.size())
          {
            Object localObject = (MetaMaterial)localMetaCategory.materials.get(j);
            if ((localObject != null) && (!TextUtils.isEmpty(((MetaMaterial)localObject).id)))
            {
              Map localMap = ((MetaMaterial)localObject).additionalFields;
              if (localHashMap.get(((MetaMaterial)localObject).id) == null)
              {
                paramString = new AEMaterialWrapper();
                paramString.a = ((MetaMaterial)localObject).id;
                paramString.b = ((MetaMaterial)localObject);
                if (localMap != null)
                {
                  paramString.c = ((String)localMap.get("minimum_device_level"));
                  paramString.d = ((String)localMap.get("shield_devices"));
                }
                paramString.e = a(paramString);
                if (paramString.e)
                {
                  localHashMap.put(((MetaMaterial)localObject).id, paramString);
                }
                else
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("can not add gif material id: ");
                  ((StringBuilder)localObject).append(paramString.a);
                  AEQLog.a("AEGifMaterialManager", ((StringBuilder)localObject).toString());
                }
              }
              else
              {
                paramString = (AEMaterialWrapper)localHashMap.get(((MetaMaterial)localObject).id);
              }
              if (paramString.e) {
                localLinkedList2.add(paramString);
              }
            }
            j += 1;
          }
          if (CollectionUtils.isEmpty(localLinkedList2))
          {
            paramString = new StringBuilder();
            paramString.append("[parseGifCategoryFromJson] materialWrapperList is empty, categoryId=");
            paramString.append(localMetaCategory.id);
            AEQLog.d("AEGifMaterialManager", paramString.toString());
          }
          else
          {
            paramString = new AEGifCategoryWrapper();
            paramString.categoryId = localMetaCategory.id;
            paramString.categoryName = localMetaCategory.name;
            paramString.materialWrapperList = localLinkedList2;
            paramString.showCategory = a(localMetaCategory);
            paramString.fontId = a(localMetaCategory, "font_id");
            localLinkedList1.add(paramString);
          }
        }
        i += 1;
      }
      return localLinkedList1;
    }
    AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] parsed response is empty");
    return new LinkedList();
  }
  
  private void c(@NonNull MetaMaterial paramMetaMaterial)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[deleteMaterialZipAndDir], metaMaterial.id=");
    ((StringBuilder)localObject).append(paramMetaMaterial.id);
    AEQLog.a("AEGifMaterialManager", ((StringBuilder)localObject).toString());
    localObject = new File(AEPath.CAMERA.FILES.h, paramMetaMaterial.id);
    paramMetaMaterial = new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id);
    if (((File)localObject).exists()) {
      FileUtils.deleteFile(((File)localObject).getPath());
    }
    if (paramMetaMaterial.exists()) {
      FileUtils.deleteDirectory(paramMetaMaterial.getPath());
    }
  }
  
  @WorkerThread
  private List<AEGifCategoryWrapper> d()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync]");
    File localFile1 = new File(AEPath.GIF.a);
    File localFile2 = new File(AEPath.GIF.b);
    if (!localFile2.exists())
    {
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile not exists");
      if (!localFile1.exists())
      {
        AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
        AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCategoryMaterialMqEmoCamera", 4);
        return new LinkedList();
      }
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
      return b(c(FileUtils.readFileContent(localFile1)));
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile exists");
    if (!localFile1.exists())
    {
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
      localList1 = c(FileUtils.readFileContent(localFile2));
      b(localList1);
      FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
    List localList1 = c(FileUtils.readFileContent(localFile1));
    List localList2 = c(FileUtils.readFileContent(localFile2));
    a(localList1, localList2);
    b(localList2);
    FileUtils.deleteFile(localFile1.getPath());
    FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
    return localList2;
  }
  
  private void d(MetaMaterial paramMetaMaterial)
  {
    if (this.f.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.f.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (AEGifMaterialManager.DownloadCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AEGifMaterialManager.DownloadCallback)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id).getAbsolutePath();
  }
  
  @NonNull
  public List<AEGifCategoryWrapper> a(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return new LinkedList(this.e);
    }
    LinkedList localLinkedList = new LinkedList();
    int i;
    if (paramInt == 2) {
      i = 1;
    } else {
      i = 0;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)localIterator.next();
      if ((localAEGifCategoryWrapper != null) && (localAEGifCategoryWrapper.showCategory == i)) {
        localLinkedList.add(localAEGifCategoryWrapper);
      }
    }
    return localLinkedList;
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, AEGifMaterialManager.DownloadCallback paramDownloadCallback)
  {
    if ((paramMetaMaterial != null) && (!TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      this.f.put(paramMetaMaterial.id, new WeakReference(paramDownloadCallback));
      ThreadManager.getFileThreadHandler().post(new AEGifMaterialManager.3(this, paramMetaMaterial, paramAppInterface));
      return;
    }
    if (paramDownloadCallback != null) {
      paramDownloadCallback.b(paramMetaMaterial);
    }
  }
  
  public boolean a(String paramString)
  {
    return this.g.containsKey(paramString);
  }
  
  public void b()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListAsync]");
    ThreadManager.excute(new AEGifMaterialManager.2(this), 64, null, true);
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager
 * JD-Core Version:    0.7.0.1
 */