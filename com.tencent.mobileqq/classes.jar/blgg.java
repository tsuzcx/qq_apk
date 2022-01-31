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

public class blgg
  extends blrr
{
  private azfy jdField_a_of_type_Azfy = new azfy();
  private bkzy jdField_a_of_type_Bkzy;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<bkzx> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  private bkzy a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getAEMaterialManager");
    }
    if (this.jdField_a_of_type_Bkzy == null) {
      this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a(18));
    }
    return this.jdField_a_of_type_Bkzy;
  }
  
  private List<bkzx> a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, bkzp.a);
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
              paramString = (blab)localHashMap.get(localPSMetaMaterial.id);
              if ((paramString.jdField_f_of_type_Int != 4) && (paramString.jdField_f_of_type_Int != 5) && (paramString.jdField_f_of_type_Int != 6) && (paramString.jdField_f_of_type_Int != 7)) {
                break label475;
              }
              if ((TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString.e))) {
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
                paramString = new blab();
                paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
                paramString.jdField_f_of_type_JavaLangString = localPSMetaMaterial.id;
                paramString.jdField_d_of_type_JavaLangString = localPSMetaMaterial.packageUrl;
                paramString.e = localPSMetaMaterial.packageMd5;
                paramString.jdField_f_of_type_Int = localPSMetaMaterial.type;
                paramString.k = localPSMetaMaterial.thumbUrl;
                paramString.j = localPSMetaCategory.id;
                paramString.l = localPSMetaMaterial.name;
                Map localMap = localPSMetaMaterial.additionalFields;
                if (localMap != null)
                {
                  paramString.m = ((String)localMap.get("web_url"));
                  paramString.n = ((String)localMap.get("mini_app_id"));
                  paramString.i = ((String)localMap.get("takeSameName"));
                }
                break label252;
                if (paramString.jdField_f_of_type_Int != 2) {
                  break label496;
                }
              } while (!TextUtils.isEmpty(paramString.m));
              break;
            } while ((paramString.jdField_f_of_type_Int != 3) || (TextUtils.isEmpty(paramString.n)));
          }
        }
      } while (localLinkedList2.size() <= 0);
      label475:
      label496:
      paramString = new bkzx();
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
  
  private List<bkzx> a(List<bkzx> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, a(new LinkedList(a().a())));
  }
  
  private List<bkzx> a(@NonNull List<bkzx> paramList, @NonNull Map<String, blab> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.jdField_a_of_type_JavaLangString = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      bkzx localbkzx = (bkzx)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localbkzx.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (blab)localbkzx.jdField_a_of_type_JavaUtilList.get(j);
        if (((blab)localObject).jdField_f_of_type_Int != 0)
        {
          ((blab)localObject).jdField_d_of_type_Boolean = a((blab)localObject);
          localLinkedList2.add(localObject);
          if (((blab)localObject).jdField_f_of_type_Int == 2) {
            this.jdField_a_of_type_JavaLangString = ((blab)localObject).m;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((blab)localObject).jdField_a_of_type_JavaLangString))
          {
            blab localblab = (blab)paramMap.get(((blab)localObject).jdField_a_of_type_JavaLangString);
            localblab.k = ((blab)localObject).k;
            localblab.j = localbkzx.jdField_a_of_type_JavaLangString;
            localblab.l = ((blab)localObject).l;
            if ((TextUtils.isEmpty(localblab.i)) && (!TextUtils.isEmpty(((blab)localObject).i))) {
              localblab.i = ((blab)localObject).i;
            }
            localLinkedList2.add(localblab);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new bkzx();
        ((bkzx)localObject).jdField_b_of_type_JavaLangString = localbkzx.jdField_b_of_type_JavaLangString;
        ((bkzx)localObject).jdField_b_of_type_Int = localbkzx.jdField_b_of_type_Int;
        ((bkzx)localObject).jdField_a_of_type_JavaLangString = localbkzx.jdField_a_of_type_JavaLangString;
        ((bkzx)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private Map<String, blab> a(@Nullable List<bkzx> paramList)
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
      Object localObject = (bkzx)paramList.next();
      if ((localObject != null) && (((bkzx)localObject).jdField_a_of_type_JavaUtilList != null) && (((bkzx)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((bkzx)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          blab localblab = (blab)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localblab.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localblab.e))) {
            localHashMap.put(localblab.jdField_a_of_type_JavaLangString, localblab);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull blab paramblab)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + paramblab.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(bkoz.jdField_d_of_type_JavaLangString, paramblab.jdField_a_of_type_JavaLangString);
    paramblab = new File(bkoz.e, paramblab.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bdhb.d(localFile.getPath());
    }
    if (paramblab.exists()) {
      bdhb.a(paramblab.getPath());
    }
  }
  
  private void a(@NonNull List<bkzx> paramList1, @NonNull List<bkzx> paramList2)
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
        paramList2 = (blab)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (blab)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.jdField_f_of_type_Int != 4) && (paramList1.jdField_f_of_type_Int != 5) && (paramList1.jdField_f_of_type_Int != 6) && (paramList1.jdField_f_of_type_Int != 7)) || (paramList1.e.equals(paramList2.e))) {
            break label212;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.jdField_f_of_type_Int != 4) && (paramList1.jdField_f_of_type_Int != 5) && (paramList1.jdField_f_of_type_Int != 6) && (paramList1.jdField_f_of_type_Int != 7))) {
          break label215;
        }
        a(paramList1);
        break;
        return;
      }
    }
  }
  
  private boolean a(@NonNull blab paramblab)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + paramblab.jdField_a_of_type_JavaLangString);
    }
    switch (paramblab.jdField_f_of_type_Int)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    a();
    return bkzy.a(paramblab);
  }
  
  private List<bkzx> b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(bkpe.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(bkpe.jdField_b_of_type_JavaLangString);
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
      return a(a(bnpl.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = a(a(bnpl.a(localFile2)));
      bdhb.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = a(bnpl.a(localFile1));
    List localList2 = a(bnpl.a(localFile2));
    a(localList1, localList2);
    localList1 = a(localList2);
    bdhb.d(localFile1.getPath());
    bdhb.b(localFile2.getPath(), localFile1.getPath());
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
    bljn.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  public List<bkzx> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(azga paramazga)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + paramazga);
    }
    this.jdField_a_of_type_Azfy.a(paramazga);
  }
  
  public void a(azga paramazga, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + paramazga + ", eventId=" + paramInt);
    }
    this.jdField_a_of_type_Azfy.a(paramazga, new int[] { paramInt });
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
 * Qualified Name:     blgg
 * JD-Core Version:    0.7.0.1
 */