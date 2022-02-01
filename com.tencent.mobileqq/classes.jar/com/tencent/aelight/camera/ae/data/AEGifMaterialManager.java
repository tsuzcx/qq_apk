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
  private static final AEGifMaterialManager jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager = new AEGifMaterialManager();
  private static final Type jdField_a_of_type_JavaLangReflectType = new AEGifMaterialManager.1().getType();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, WeakReference<AEGifMaterialManager.DownloadCallback>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, MetaMaterial> b = new HashMap();
  
  public static AEGifMaterialManager a()
  {
    return jdField_a_of_type_ComTencentAelightCameraAeDataAEGifMaterialManager;
  }
  
  @Nullable
  private String a(@NonNull MetaCategory paramMetaCategory, @NonNull String paramString)
  {
    if (paramMetaCategory.dynamicFields == null) {
      return null;
    }
    return (String)paramMetaCategory.dynamicFields.get(paramString);
  }
  
  @WorkerThread
  private List<AEGifCategoryWrapper> a()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync]");
    File localFile1 = new File(AEPath.GIF.jdField_a_of_type_JavaLangString);
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
      return a(a(FileUtils.readFileContent(localFile1)));
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile exists");
    if (!localFile1.exists())
    {
      AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
      localList1 = a(FileUtils.readFileContent(localFile2));
      a(localList1);
      FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
    List localList1 = a(FileUtils.readFileContent(localFile1));
    List localList2 = a(FileUtils.readFileContent(localFile2));
    a(localList1, localList2);
    a(localList2);
    FileUtils.deleteFile(localFile1.getPath());
    FileUtils.moveFile(localFile2.getPath(), localFile1.getPath());
    return localList2;
  }
  
  @NonNull
  private List<AEGifCategoryWrapper> a(@Nullable String paramString)
  {
    AEQLog.a("AEGifMaterialManager", "[parseGifCategoryFromJson]");
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEGifMaterialManager", "[parseGifCategoryFromJson] jsonString is empty");
      return new LinkedList();
    }
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)GsonUtils.json2Obj(paramString, jdField_a_of_type_JavaLangReflectType);
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
                paramString.jdField_a_of_type_JavaLangString = ((MetaMaterial)localObject).id;
                paramString.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = ((MetaMaterial)localObject);
                if (localMap != null)
                {
                  paramString.b = ((String)localMap.get("minimum_device_level"));
                  paramString.c = ((String)localMap.get("shield_devices"));
                }
                paramString.jdField_a_of_type_Boolean = a(paramString);
                if (paramString.jdField_a_of_type_Boolean)
                {
                  localHashMap.put(((MetaMaterial)localObject).id, paramString);
                }
                else
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("can not add gif material id: ");
                  ((StringBuilder)localObject).append(paramString.jdField_a_of_type_JavaLangString);
                  AEQLog.a("AEGifMaterialManager", ((StringBuilder)localObject).toString());
                }
              }
              else
              {
                paramString = (AEMaterialWrapper)localHashMap.get(((MetaMaterial)localObject).id);
              }
              if (paramString.jdField_a_of_type_Boolean) {
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
  
  private List<AEGifCategoryWrapper> a(@NonNull List<AEGifCategoryWrapper> paramList)
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
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.jdField_a_of_type_JavaLangString)) && (localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null))
          {
            int i;
            if (a(localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)) {
              i = 2;
            } else {
              i = 0;
            }
            localAEMaterialWrapper.jdField_a_of_type_Int = i;
          }
        }
      }
    }
    return paramList;
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
          if ((localAEMaterialWrapper != null) && (!TextUtils.isEmpty(localAEMaterialWrapper.jdField_a_of_type_JavaLangString)) && (localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)) {
            localHashMap.put(localAEMaterialWrapper.jdField_a_of_type_JavaLangString, localAEMaterialWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
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
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
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
          a(paramList1);
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
    CameraOperationHelper.c().postValue(Boolean.valueOf(paramBoolean));
  }
  
  private boolean a(@NonNull MetaCategory paramMetaCategory)
  {
    paramMetaCategory = a(paramMetaCategory, "show_list");
    return (!TextUtils.isEmpty(paramMetaCategory)) && ("true".equals(paramMetaCategory));
  }
  
  private boolean a(@Nullable MetaMaterial paramMetaMaterial)
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
  
  private boolean a(AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (paramAEMaterialWrapper == null) {
      return true;
    }
    if (ParamsUtil.a(paramAEMaterialWrapper.b) > ParamsUtil.a()) {
      return false;
    }
    if (paramAEMaterialWrapper.c != null)
    {
      String str = ParamsUtil.b();
      if (paramAEMaterialWrapper.c.contains(str)) {
        return false;
      }
    }
    return true;
  }
  
  private void b(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (AEGifMaterialManager.DownloadCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((AEGifMaterialManager.DownloadCallback)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(AEPath.CAMERA.FILES.i, paramMetaMaterial.id).getAbsolutePath();
  }
  
  @NonNull
  public List<AEGifCategoryWrapper> a(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return new LinkedList(this.jdField_a_of_type_JavaUtilList);
    }
    LinkedList localLinkedList = new LinkedList();
    int i;
    if (paramInt == 2) {
      i = 1;
    } else {
      i = 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)localIterator.next();
      if ((localAEGifCategoryWrapper != null) && (localAEGifCategoryWrapper.showCategory == i)) {
        localLinkedList.add(localAEGifCategoryWrapper);
      }
    }
    return localLinkedList;
  }
  
  public void a()
  {
    AEQLog.a("AEGifMaterialManager", "[updateGifCategoryListAsync]");
    ThreadManager.excute(new AEGifMaterialManager.2(this), 64, null, true);
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, AEGifMaterialManager.DownloadCallback paramDownloadCallback)
  {
    if ((paramMetaMaterial != null) && (!TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramMetaMaterial.id, new WeakReference(paramDownloadCallback));
      ThreadManager.getFileThreadHandler().post(new AEGifMaterialManager.3(this, paramMetaMaterial, paramAppInterface));
      return;
    }
    if (paramDownloadCallback != null) {
      paramDownloadCallback.b(paramMetaMaterial);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGifMaterialManager
 * JD-Core Version:    0.7.0.1
 */