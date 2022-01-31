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

public class biwo
  extends bjbe
{
  private axgh jdField_a_of_type_Axgh = new axgh();
  private biqk jdField_a_of_type_Biqk;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<biqj> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  private biqk a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getAEMaterialManager");
    }
    if (this.jdField_a_of_type_Biqk == null) {
      this.jdField_a_of_type_Biqk = ((biqk)bjae.a(18));
    }
    return this.jdField_a_of_type_Biqk;
  }
  
  private List<biqj> a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, biqb.a);
    if ((localGetPlayShowCatMatTreeRsp == null) || (localGetPlayShowCatMatTreeRsp.Categories == null) || (localGetPlayShowCatMatTreeRsp.Categories.size() == 0)) {
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    PSMetaCategory localPSMetaCategory;
    if (i < localGetPlayShowCatMatTreeRsp.Categories.size())
    {
      localPSMetaCategory = (PSMetaCategory)localGetPlayShowCatMatTreeRsp.Categories.get(i);
      if ((localPSMetaCategory != null) && (localPSMetaCategory.materials != null) && (localPSMetaCategory.materials.size() != 0)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      PSMetaMaterial localPSMetaMaterial;
      if (j < localPSMetaCategory.materials.size())
      {
        localPSMetaMaterial = (PSMetaMaterial)localPSMetaCategory.materials.get(j);
        if ((localPSMetaMaterial == null) || (TextUtils.isEmpty(localPSMetaMaterial.id)) || (TextUtils.isEmpty(localPSMetaMaterial.thumbUrl))) {}
        for (;;)
        {
          label214:
          j += 1;
          break;
          if (!localHashMap.containsKey(localPSMetaMaterial.id)) {
            break label332;
          }
          paramString = (biqn)localHashMap.get(localPSMetaMaterial.id);
          label252:
          if ((paramString.jdField_f_of_type_Int != 4) && (paramString.jdField_f_of_type_Int != 5) && (paramString.jdField_f_of_type_Int != 6) && (paramString.jdField_f_of_type_Int != 7)) {
            break label458;
          }
          if ((!TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString.e)))
          {
            label306:
            localHashMap.put(localPSMetaMaterial.id, paramString);
            localLinkedList2.add(paramString);
          }
        }
        label332:
        paramString = new biqn();
        paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
        paramString.jdField_f_of_type_JavaLangString = localPSMetaMaterial.id;
        paramString.jdField_d_of_type_JavaLangString = localPSMetaMaterial.packageUrl;
        paramString.e = localPSMetaMaterial.packageMd5;
        paramString.jdField_f_of_type_Int = localPSMetaMaterial.type;
        paramString.j = localPSMetaMaterial.thumbUrl;
        paramString.i = localPSMetaCategory.id;
        paramString.k = localPSMetaMaterial.name;
      }
      try
      {
        for (;;)
        {
          paramString.l = ((String)localPSMetaMaterial.additionalFields.get("web_url"));
          try
          {
            label431:
            paramString.m = ((String)localPSMetaMaterial.additionalFields.get("mini_app_id"));
          }
          catch (Throwable localThrowable1) {}
        }
        break label252;
        label458:
        if (paramString.jdField_f_of_type_Int == 2)
        {
          if (!TextUtils.isEmpty(paramString.l)) {
            break label306;
          }
          break label214;
        }
        if ((paramString.jdField_f_of_type_Int != 3) || (TextUtils.isEmpty(paramString.m))) {
          break label306;
        }
        break label214;
        if (localLinkedList2.size() <= 0) {
          continue;
        }
        paramString = new biqj();
        paramString.jdField_b_of_type_JavaLangString = localPSMetaCategory.name;
        paramString.jdField_a_of_type_JavaLangString = localPSMetaCategory.id;
        if (localPSMetaCategory.onlyFlag) {}
        for (j = 1;; j = 2)
        {
          paramString.jdField_b_of_type_Int = j;
          paramString.jdField_a_of_type_Boolean = localPSMetaCategory.defaultFlag;
          paramString.jdField_a_of_type_JavaUtilList = localLinkedList2;
          localLinkedList1.add(paramString);
          break;
        }
        return localLinkedList1;
      }
      catch (Throwable localThrowable2)
      {
        break label431;
      }
    }
  }
  
  private List<biqj> a(List<biqj> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, a(new LinkedList(a().a())));
  }
  
  private List<biqj> a(@NonNull List<biqj> paramList, @NonNull Map<String, biqn> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.jdField_a_of_type_JavaLangString = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      biqj localbiqj = (biqj)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localbiqj.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (biqn)localbiqj.jdField_a_of_type_JavaUtilList.get(j);
        if (((biqn)localObject).jdField_f_of_type_Int != 0)
        {
          ((biqn)localObject).jdField_d_of_type_Boolean = a((biqn)localObject);
          localLinkedList2.add(localObject);
          if (((biqn)localObject).jdField_f_of_type_Int == 2) {
            this.jdField_a_of_type_JavaLangString = ((biqn)localObject).l;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((biqn)localObject).jdField_a_of_type_JavaLangString))
          {
            biqn localbiqn = (biqn)paramMap.get(((biqn)localObject).jdField_a_of_type_JavaLangString);
            localbiqn.j = ((biqn)localObject).j;
            localbiqn.i = localbiqj.jdField_a_of_type_JavaLangString;
            localbiqn.k = ((biqn)localObject).k;
            localLinkedList2.add(localbiqn);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new biqj();
        ((biqj)localObject).jdField_b_of_type_JavaLangString = localbiqj.jdField_b_of_type_JavaLangString;
        ((biqj)localObject).jdField_b_of_type_Int = localbiqj.jdField_b_of_type_Int;
        ((biqj)localObject).jdField_a_of_type_JavaLangString = localbiqj.jdField_a_of_type_JavaLangString;
        ((biqj)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private Map<String, biqn> a(@Nullable List<biqj> paramList)
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
      Object localObject = (biqj)paramList.next();
      if ((localObject != null) && (((biqj)localObject).jdField_a_of_type_JavaUtilList != null) && (((biqj)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = new LinkedList(((biqj)localObject).jdField_a_of_type_JavaUtilList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          biqn localbiqn = (biqn)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localbiqn.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbiqn.e))) {
            localHashMap.put(localbiqn.jdField_a_of_type_JavaLangString, localbiqn);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull biqn parambiqn)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + parambiqn.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(biid.jdField_d_of_type_JavaLangString, parambiqn.jdField_a_of_type_JavaLangString);
    parambiqn = new File(biid.e, parambiqn.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bbdj.d(localFile.getPath());
    }
    if (parambiqn.exists()) {
      bbdj.a(parambiqn.getPath());
    }
  }
  
  private void a(@NonNull List<biqj> paramList1, @NonNull List<biqj> paramList2)
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
        paramList2 = (biqn)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (biqn)localMap.get(str);
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
  
  private boolean a(@NonNull biqn parambiqn)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + parambiqn.jdField_a_of_type_JavaLangString);
    }
    switch (parambiqn.jdField_f_of_type_Int)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    a();
    return biqk.a(parambiqn);
  }
  
  private List<biqj> b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(biii.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(biii.jdField_b_of_type_JavaLangString);
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
      return a(a(bkyy.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = a(a(bkyy.a(localFile2)));
      bbdj.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = a(bkyy.a(localFile1));
    List localList2 = a(bkyy.a(localFile2));
    a(localList1, localList2);
    localList1 = a(localList2);
    bbdj.d(localFile1.getPath());
    bbdj.b(localFile2.getPath(), localFile1.getPath());
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
    bizq.b("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  public List<biqj> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(axgj paramaxgj)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + paramaxgj);
    }
    this.jdField_a_of_type_Axgh.a(paramaxgj);
  }
  
  public void a(axgj paramaxgj, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + paramaxgj + ", eventId=" + paramInt);
    }
    this.jdField_a_of_type_Axgh.a(paramaxgj, new int[] { paramInt });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwo
 * JD-Core Version:    0.7.0.1
 */