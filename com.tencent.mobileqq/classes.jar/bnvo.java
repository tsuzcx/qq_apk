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

public class bnvo
  extends bokv
{
  private bcgy jdField_a_of_type_Bcgy = new bcgy();
  private bnpc jdField_a_of_type_Bnpc;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<bnpb> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  private bnpc a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getAEMaterialManager");
    }
    if (this.jdField_a_of_type_Bnpc == null) {
      this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a(18));
    }
    return this.jdField_a_of_type_Bnpc;
  }
  
  private List<bnpb> a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, bnot.a);
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
              paramString = (bnpf)localHashMap.get(localPSMetaMaterial.id);
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
                paramString = new bnpf();
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
      paramString = new bnpb();
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
  
  private List<bnpb> a(List<bnpb> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, a(new LinkedList(a().b())));
  }
  
  private List<bnpb> a(@NonNull List<bnpb> paramList, @NonNull Map<String, bnpf> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.jdField_a_of_type_JavaLangString = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      bnpb localbnpb = (bnpb)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localbnpb.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bnpf)localbnpb.jdField_a_of_type_JavaUtilList.get(j);
        if (((bnpf)localObject).g != 0)
        {
          ((bnpf)localObject).jdField_e_of_type_Boolean = a((bnpf)localObject);
          localLinkedList2.add(localObject);
          if (((bnpf)localObject).g == 2) {
            this.jdField_a_of_type_JavaLangString = ((bnpf)localObject).n;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((bnpf)localObject).jdField_a_of_type_JavaLangString))
          {
            bnpf localbnpf = (bnpf)paramMap.get(((bnpf)localObject).jdField_a_of_type_JavaLangString);
            localbnpf.l = ((bnpf)localObject).l;
            localbnpf.k = localbnpb.jdField_a_of_type_JavaLangString;
            localbnpf.m = ((bnpf)localObject).m;
            if ((TextUtils.isEmpty(localbnpf.i)) && (!TextUtils.isEmpty(((bnpf)localObject).i))) {
              localbnpf.i = ((bnpf)localObject).i;
            }
            localLinkedList2.add(localbnpf);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new bnpb();
        ((bnpb)localObject).jdField_b_of_type_JavaLangString = localbnpb.jdField_b_of_type_JavaLangString;
        ((bnpb)localObject).jdField_b_of_type_Int = localbnpb.jdField_b_of_type_Int;
        ((bnpb)localObject).jdField_a_of_type_JavaLangString = localbnpb.jdField_a_of_type_JavaLangString;
        ((bnpb)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private Map<String, bnpf> a(@Nullable List<bnpb> paramList)
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
      Object localObject = (bnpb)paramList.next();
      if ((localObject != null) && (((bnpb)localObject).jdField_a_of_type_JavaUtilList != null) && (((bnpb)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((bnpb)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          bnpf localbnpf = (bnpf)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localbnpf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbnpf.jdField_e_of_type_JavaLangString))) {
            localHashMap.put(localbnpf.jdField_a_of_type_JavaLangString, localbnpf);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull bnpf parambnpf)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + parambnpf.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bndm.d, parambnpf.jdField_a_of_type_JavaLangString);
    parambnpf = new File(bndm.jdField_e_of_type_JavaLangString, parambnpf.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bgmg.d(localFile.getPath());
    }
    if (parambnpf.exists()) {
      bgmg.a(parambnpf.getPath());
    }
  }
  
  private void a(@NonNull List<bnpb> paramList1, @NonNull List<bnpb> paramList2)
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
        paramList2 = (bnpf)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (bnpf)localMap.get(str);
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
  
  private boolean a(@NonNull bnpf parambnpf)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + parambnpf.jdField_a_of_type_JavaLangString);
    }
    switch (parambnpf.g)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    a();
    return bnpc.a(parambnpf);
  }
  
  private List<bnpb> b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(bndr.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(bndr.jdField_b_of_type_JavaLangString);
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
      return a(a(bqgc.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = a(a(bqgc.a(localFile2)));
      bgmg.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = a(bqgc.a(localFile1));
    List localList2 = a(bqgc.a(localFile2));
    a(localList1, localList2);
    localList1 = a(localList2);
    bgmg.d(localFile1.getPath());
    bgmg.b(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private void g()
  {
    bnzb.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  public List<bnpb> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(bcha parambcha)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + parambcha);
    }
    this.jdField_a_of_type_Bcgy.a(parambcha);
  }
  
  public void a(bcha parambcha, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + parambcha + ", eventId=" + paramInt);
    }
    this.jdField_a_of_type_Bcgy.a(parambcha, new int[] { paramInt });
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    f();
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    f();
  }
  
  public void e()
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
 * Qualified Name:     bnvo
 * JD-Core Version:    0.7.0.1
 */