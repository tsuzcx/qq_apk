import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.data.AEGifMaterialManager.2;
import dov.com.qq.im.ae.data.AEGifMaterialManager.3;
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

public class boqm
{
  private static final boqm jdField_a_of_type_Boqm = new boqm();
  private static final Type jdField_a_of_type_JavaLangReflectType = new boqn().getType();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Map<String, WeakReference<boqp>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, MetaMaterial> b = new HashMap();
  
  public static boqm a()
  {
    return jdField_a_of_type_Boqm;
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
    bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync]");
    File localFile1 = new File(boex.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(boex.b);
    if (!localFile2.exists())
    {
      bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile not exists");
      if (!localFile1.exists())
      {
        bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
        bozz.a().a("CameraModuleSvc.GetCompressedCategoryMaterialMqEmoCamera", 4);
        return new LinkedList();
      }
      bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
      return a(a(bhmi.a(localFile1)));
    }
    bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], updateConfigFile exists");
    if (!localFile1.exists())
    {
      bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile not exists");
      localList1 = a(bhmi.a(localFile2));
      a(localList1);
      bhmi.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    bpam.a("AEGifMaterialManager", "[updateGifCategoryListSync], defaultConfigFile exists");
    List localList1 = a(bhmi.a(localFile1));
    List localList2 = a(bhmi.a(localFile2));
    a(localList1, localList2);
    a(localList2);
    bhmi.d(localFile1.getPath());
    bhmi.b(localFile2.getPath(), localFile1.getPath());
    return localList2;
  }
  
  @NonNull
  private List<AEGifCategoryWrapper> a(@Nullable String paramString)
  {
    bpam.a("AEGifMaterialManager", "[parseGifCategoryFromJson]");
    if (TextUtils.isEmpty(paramString))
    {
      bpam.d("AEGifMaterialManager", "[parseGifCategoryFromJson] jsonString is empty");
      return new LinkedList();
    }
    GetCategoryMaterialRsp localGetCategoryMaterialRsp = (GetCategoryMaterialRsp)GsonUtils.json2Obj(paramString, jdField_a_of_type_JavaLangReflectType);
    if ((localGetCategoryMaterialRsp == null) || (CollectionUtils.isEmpty(localGetCategoryMaterialRsp.Categories)))
    {
      bpam.d("AEGifMaterialManager", "[parseGifCategoryFromJson] parsed response is empty");
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < localGetCategoryMaterialRsp.Categories.size())
    {
      MetaCategory localMetaCategory = (MetaCategory)localGetCategoryMaterialRsp.Categories.get(i);
      if ((localMetaCategory == null) || (CollectionUtils.isEmpty(localMetaCategory.materials))) {}
      for (;;)
      {
        i += 1;
        break;
        LinkedList localLinkedList2 = new LinkedList();
        int j = 0;
        while (j < localMetaCategory.materials.size())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localMetaCategory.materials.get(j);
          if ((localMetaMaterial == null) || (TextUtils.isEmpty(localMetaMaterial.id)))
          {
            j += 1;
          }
          else
          {
            if (localHashMap.get(localMetaMaterial.id) == null)
            {
              paramString = new boqw();
              paramString.jdField_a_of_type_JavaLangString = localMetaMaterial.id;
              paramString.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = localMetaMaterial;
              localHashMap.put(localMetaMaterial.id, paramString);
            }
            for (;;)
            {
              localLinkedList2.add(paramString);
              break;
              paramString = (boqw)localHashMap.get(localMetaMaterial.id);
            }
          }
        }
        if (CollectionUtils.isEmpty(localLinkedList2))
        {
          bpam.d("AEGifMaterialManager", "[parseGifCategoryFromJson] materialWrapperList is empty, categoryId=" + localMetaCategory.id);
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
    }
    return localLinkedList1;
  }
  
  private List<AEGifCategoryWrapper> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    bpam.a("AEGifMaterialManager", "[updateMaterialStatus]");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEGifCategoryWrapper)localIterator.next();
      if ((localObject != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)))
      {
        localObject = ((AEGifCategoryWrapper)localObject).materialWrapperList.iterator();
        label62:
        boqw localboqw;
        while (((Iterator)localObject).hasNext())
        {
          localboqw = (boqw)((Iterator)localObject).next();
          if ((localboqw != null) && (!TextUtils.isEmpty(localboqw.jdField_a_of_type_JavaLangString)) && (localboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)) {
            if (!a(localboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial)) {
              break label131;
            }
          }
        }
        label131:
        for (int i = 2;; i = 0)
        {
          localboqw.jdField_a_of_type_Int = i;
          break label62;
          break;
        }
      }
    }
    return paramList;
  }
  
  private Map<String, MetaMaterial> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    bpam.a("AEGifMaterialManager", "[buildMaterialMap]");
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
          boqw localboqw = (boqw)((Iterator)localObject).next();
          if ((localboqw != null) && (!TextUtils.isEmpty(localboqw.jdField_a_of_type_JavaLangString)) && (localboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)) {
            localHashMap.put(localboqw.jdField_a_of_type_JavaLangString, localboqw.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial)
  {
    bpam.a("AEGifMaterialManager", "[deleteMaterialZipAndDir], metaMaterial.id=" + paramMetaMaterial.id);
    File localFile = new File(boev.d, paramMetaMaterial.id);
    paramMetaMaterial = new File(boev.e, paramMetaMaterial.id);
    if (localFile.exists()) {
      bhmi.d(localFile.getPath());
    }
    if (paramMetaMaterial.exists()) {
      bhmi.a(paramMetaMaterial.getPath());
    }
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (boqp)((WeakReference)localObject).get();
        if (localObject != null) {
          ((boqp)localObject).a(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  private void a(@NonNull List<AEGifCategoryWrapper> paramList1, @NonNull List<AEGifCategoryWrapper> paramList2)
  {
    bpam.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial]");
    paramList1 = a(paramList1);
    paramList2 = a(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    label169:
    label172:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList1 = (Map.Entry)localIterator.next();
        Object localObject = (String)paramList1.getKey();
        paramList1 = (MetaMaterial)paramList1.getValue();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (paramList1 == null)) {
          continue;
        }
        if (!paramList2.containsKey(localObject)) {
          break label169;
        }
        localObject = (MetaMaterial)paramList2.get(localObject);
        if ((localObject == null) || (paramList1.packageMd5.equals(((MetaMaterial)localObject).packageMd5))) {
          break label169;
        }
      }
      for (;;)
      {
        if (paramList1 == null) {
          break label172;
        }
        bpam.a("AEGifMaterialManager", "[diffTwoListAndDeleteOutdatedMaterial] find outdated material id=" + paramList1.id);
        a(paramList1);
        break;
        return;
        paramList1 = null;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    bpam.a("AEGifMaterialManager", "[notifyGifCategoryListUpdated], validData=" + paramBoolean);
    boqg.c().postValue(Boolean.valueOf(paramBoolean));
  }
  
  private boolean a(@NonNull MetaCategory paramMetaCategory)
  {
    paramMetaCategory = a(paramMetaCategory, "show_list");
    return (!TextUtils.isEmpty(paramMetaCategory)) && ("true".equals(paramMetaCategory));
  }
  
  private boolean a(@Nullable MetaMaterial paramMetaMaterial)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id))) {
      bpam.d("AEGifMaterialManager", "[materialExists] metaMaterial is invalid");
    }
    File localFile2;
    do
    {
      File localFile1;
      do
      {
        return false;
        localFile1 = new File(boev.d, paramMetaMaterial.id);
      } while (!localFile1.exists());
      File localFile3 = new File(boev.e, paramMetaMaterial.id);
      paramMetaMaterial = new File(localFile3, "params.json");
      localFile2 = new File(localFile3, "params.dat");
      if ((paramMetaMaterial.exists()) || (localFile2.exists())) {
        break;
      }
      try
      {
        nof.a(localFile1, localFile3.getPath());
        return true;
      }
      catch (Exception localException)
      {
        bpam.a("AEGifMaterialManager", "[materialExists] unZipFile raised exception", localException);
      }
    } while ((!paramMetaMaterial.exists()) && (!localFile2.exists()));
    return true;
    return true;
  }
  
  private void b(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (boqp)((WeakReference)localObject).get();
        if (localObject != null) {
          ((boqp)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(boev.e, paramMetaMaterial.id).getAbsolutePath();
  }
  
  @NonNull
  public List<AEGifCategoryWrapper> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new LinkedList(this.jdField_a_of_type_JavaUtilList);
    }
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 2) {}
    for (int i = 1;; i = 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AEGifCategoryWrapper localAEGifCategoryWrapper = (AEGifCategoryWrapper)localIterator.next();
        if ((localAEGifCategoryWrapper != null) && (localAEGifCategoryWrapper.showCategory == i)) {
          localLinkedList.add(localAEGifCategoryWrapper);
        }
      }
    }
    return localLinkedList;
  }
  
  public void a()
  {
    bpam.a("AEGifMaterialManager", "[updateGifCategoryListAsync]");
    ThreadManager.excute(new AEGifMaterialManager.2(this), 64, null, true);
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, boqp paramboqp)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      if (paramboqp != null) {
        paramboqp.b(paramMetaMaterial);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramMetaMaterial.id, new WeakReference(paramboqp));
    ThreadManager.getFileThreadHandler().post(new AEGifMaterialManager.3(this, paramMetaMaterial, paramAppInterface));
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqm
 * JD-Core Version:    0.7.0.1
 */