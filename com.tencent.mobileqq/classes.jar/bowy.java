import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager.2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class bowy
  extends bpmq
{
  private bczq jdField_a_of_type_Bczq = new bczq();
  private boqr jdField_a_of_type_Boqr;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<boqq> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  private boqr a()
  {
    if (this.jdField_a_of_type_Boqr == null) {
      this.jdField_a_of_type_Boqr = ((boqr)bplq.a(18));
    }
    return this.jdField_a_of_type_Boqr;
  }
  
  private List<boqq> a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, boqe.a);
    if ((localGetPlayShowCatMatTreeRsp == null) || (localGetPlayShowCatMatTreeRsp.Categories == null) || (localGetPlayShowCatMatTreeRsp.Categories.size() == 0)) {
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < localGetPlayShowCatMatTreeRsp.Categories.size())
    {
      PSMetaCategory localPSMetaCategory = (PSMetaCategory)localGetPlayShowCatMatTreeRsp.Categories.get(i);
      if ((localPSMetaCategory == null) || (localPSMetaCategory.materials == null) || (localPSMetaCategory.materials.size() == 0)) {}
      LinkedList localLinkedList2;
      label252:
      do
      {
        i += 1;
        break;
        localLinkedList2 = new LinkedList();
        j = 0;
        if (j < localPSMetaCategory.materials.size())
        {
          PSMetaMaterial localPSMetaMaterial = (PSMetaMaterial)localPSMetaCategory.materials.get(j);
          if ((localPSMetaMaterial == null) || (TextUtils.isEmpty(localPSMetaMaterial.id)) || (TextUtils.isEmpty(localPSMetaMaterial.thumbUrl))) {}
          for (;;)
          {
            j += 1;
            break;
            if (localHashMap.containsKey(localPSMetaMaterial.id))
            {
              paramString = (boqu)localHashMap.get(localPSMetaMaterial.id);
              if ((paramString.g != 4) && (paramString.g != 5) && (paramString.g != 6) && (paramString.g != 7)) {
                break label475;
              }
              if ((TextUtils.isEmpty(paramString.d)) || (TextUtils.isEmpty(paramString.jdField_e_of_type_JavaLangString))) {
                continue;
              }
            }
            do
            {
              do
              {
                localHashMap.put(localPSMetaMaterial.id, paramString);
                localLinkedList2.add(paramString);
                break;
                paramString = new boqu();
                paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
                paramString.f = localPSMetaMaterial.id;
                paramString.d = localPSMetaMaterial.packageUrl;
                paramString.jdField_e_of_type_JavaLangString = localPSMetaMaterial.packageMd5;
                paramString.g = localPSMetaMaterial.type;
                paramString.l = localPSMetaMaterial.thumbUrl;
                paramString.k = localPSMetaCategory.id;
                paramString.m = localPSMetaMaterial.name;
                Map localMap = localPSMetaMaterial.additionalFields;
                if (localMap != null)
                {
                  paramString.n = ((String)localMap.get("web_url"));
                  paramString.o = ((String)localMap.get("mini_app_id"));
                  paramString.i = ((String)localMap.get("takeSameName"));
                }
                break label252;
                if (paramString.g != 2) {
                  break label496;
                }
              } while (!TextUtils.isEmpty(paramString.n));
              break;
            } while ((paramString.g != 3) || (TextUtils.isEmpty(paramString.o)));
          }
        }
      } while (localLinkedList2.size() <= 0);
      label475:
      label496:
      paramString = new boqq();
      paramString.jdField_b_of_type_JavaLangString = localPSMetaCategory.name;
      paramString.jdField_a_of_type_JavaLangString = localPSMetaCategory.id;
      if (localPSMetaCategory.onlyFlag) {}
      for (int j = 1;; j = 2)
      {
        paramString.jdField_b_of_type_Int = j;
        paramString.jdField_a_of_type_Boolean = localPSMetaCategory.defaultFlag;
        paramString.jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(paramString);
        break;
      }
    }
    return localLinkedList1;
  }
  
  private List<boqq> a(List<boqq> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, a(new LinkedList(a().b())));
  }
  
  private List<boqq> a(@NonNull List<boqq> paramList, @NonNull Map<String, boqu> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.jdField_a_of_type_JavaLangString = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      boqq localboqq = (boqq)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localboqq.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (boqu)localboqq.jdField_a_of_type_JavaUtilList.get(j);
        if (((boqu)localObject).g != 0)
        {
          ((boqu)localObject).jdField_e_of_type_Boolean = a((boqu)localObject);
          localLinkedList2.add(localObject);
          if (((boqu)localObject).g == 2) {
            this.jdField_a_of_type_JavaLangString = ((boqu)localObject).n;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((boqu)localObject).jdField_a_of_type_JavaLangString))
          {
            boqu localboqu = (boqu)paramMap.get(((boqu)localObject).jdField_a_of_type_JavaLangString);
            localboqu.l = ((boqu)localObject).l;
            localboqu.k = localboqq.jdField_a_of_type_JavaLangString;
            localboqu.m = ((boqu)localObject).m;
            if ((TextUtils.isEmpty(localboqu.i)) && (!TextUtils.isEmpty(((boqu)localObject).i))) {
              localboqu.i = ((boqu)localObject).i;
            }
            localLinkedList2.add(localboqu);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new boqq();
        ((boqq)localObject).jdField_b_of_type_JavaLangString = localboqq.jdField_b_of_type_JavaLangString;
        ((boqq)localObject).jdField_b_of_type_Int = localboqq.jdField_b_of_type_Int;
        ((boqq)localObject).jdField_a_of_type_JavaLangString = localboqq.jdField_a_of_type_JavaLangString;
        ((boqq)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private Map<String, boqu> a(@Nullable List<boqq> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "buildMaterialDataMap");
    }
    if (paramList == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    paramList = new LinkedList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (boqq)paramList.next();
      if ((localObject != null) && (((boqq)localObject).jdField_a_of_type_JavaUtilList != null) && (((boqq)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((boqq)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          boqu localboqu = (boqu)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localboqu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localboqu.jdField_e_of_type_JavaLangString))) {
            localHashMap.put(localboqu.jdField_a_of_type_JavaLangString, localboqu);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull boqu paramboqu)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + paramboqu.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(boev.d, paramboqu.jdField_a_of_type_JavaLangString);
    paramboqu = new File(boev.jdField_e_of_type_JavaLangString, paramboqu.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bhmi.d(localFile.getPath());
    }
    if (paramboqu.exists()) {
      bhmi.a(paramboqu.getPath());
    }
  }
  
  private void a(@NonNull List<boqq> paramList1, @NonNull List<boqq> paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "diffTwoListAndDeleteOutdatedMaterial");
    }
    paramList1 = a(paramList1);
    Map localMap = a(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    label212:
    label215:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList1 = (Map.Entry)localIterator.next();
        String str = (String)paramList1.getKey();
        paramList2 = (boqu)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (boqu)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.g != 4) && (paramList1.g != 5) && (paramList1.g != 6) && (paramList1.g != 7)) || (paramList1.jdField_e_of_type_JavaLangString.equals(paramList2.jdField_e_of_type_JavaLangString))) {
            break label212;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.g != 4) && (paramList1.g != 5) && (paramList1.g != 6) && (paramList1.g != 7))) {
          break label215;
        }
        a(paramList1);
        break;
        return;
      }
    }
  }
  
  private boolean a(@NonNull boqu paramboqu)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + paramboqu.jdField_a_of_type_JavaLangString);
    }
    switch (paramboqu.g)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    a();
    return boqr.a(paramboqu);
  }
  
  private List<boqq> b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(bofa.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(bofa.jdField_b_of_type_JavaLangString);
    if (!localFile2.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=null, thread=" + Thread.currentThread());
      }
      if (!localFile1.exists())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
        }
        return new LinkedList();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
      }
      return a(a(brhn.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = a(a(brhn.a(localFile2)));
      bhmi.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = a(brhn.a(localFile1));
    List localList2 = a(brhn.a(localFile2));
    a(localList1, localList2);
    localList1 = a(localList2);
    bhmi.d(localFile1.getPath());
    bhmi.b(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  private void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private void h()
  {
    bpam.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  public List<boqq> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(bczs parambczs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + parambczs);
    }
    this.jdField_a_of_type_Bczq.a(parambczs);
  }
  
  public void a(bczs parambczs, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + parambczs + ", eventId=" + paramInt);
    }
    this.jdField_a_of_type_Bczq.a(parambczs, new int[] { paramInt });
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    g();
  }
  
  protected void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    g();
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowy
 * JD-Core Version:    0.7.0.1
 */