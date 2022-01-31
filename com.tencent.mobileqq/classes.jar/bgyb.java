import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.AECamera.AEPlayShowMaterialManager.1;
import dov.com.qq.im.AECamera.AEPlayShowMaterialManager.2;
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

public class bgyb
  extends bhgm
{
  public static final String a;
  private static final String b;
  private awhb jdField_a_of_type_Awhb = new awhb();
  private bgxx jdField_a_of_type_Bgxx;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private List<bgxt> jdField_a_of_type_JavaUtilList = new LinkedList();
  private String c;
  
  static
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label13:
      File localFile;
      break label13;
    }
    if (i != 0) {}
    for (localFile = new File(ajed.aU);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_b_of_type_JavaLangString = new File(localFile, "dov_ptv_template_dov").getPath();
      jdField_a_of_type_JavaLangString = jdField_b_of_type_JavaLangString + File.separator + "ptv_template_usable";
      return;
    }
  }
  
  private bgxx a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getAEMaterialManager");
    }
    if (this.jdField_a_of_type_Bgxx == null) {
      this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a(18));
    }
    return this.jdField_a_of_type_Bgxx;
  }
  
  private List<bgxt> a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, avzi.a);
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
          paramString = (bgya)localHashMap.get(localPSMetaMaterial.id);
          label252:
          if ((paramString.jdField_e_of_type_Int != 4) && (paramString.jdField_e_of_type_Int != 5) && (paramString.jdField_e_of_type_Int != 6) && (paramString.jdField_e_of_type_Int != 7)) {
            break label458;
          }
          if ((!TextUtils.isEmpty(paramString.c)) && (!TextUtils.isEmpty(paramString.jdField_d_of_type_JavaLangString)))
          {
            label306:
            localHashMap.put(localPSMetaMaterial.id, paramString);
            localLinkedList2.add(paramString);
          }
        }
        label332:
        paramString = new bgya();
        paramString.jdField_a_of_type_JavaLangString = localPSMetaMaterial.id;
        paramString.jdField_e_of_type_JavaLangString = localPSMetaMaterial.id;
        paramString.c = localPSMetaMaterial.packageUrl;
        paramString.jdField_d_of_type_JavaLangString = localPSMetaMaterial.packageMd5;
        paramString.jdField_e_of_type_Int = localPSMetaMaterial.type;
        paramString.i = localPSMetaMaterial.thumbUrl;
        paramString.h = localPSMetaCategory.id;
        paramString.j = localPSMetaMaterial.name;
      }
      try
      {
        for (;;)
        {
          paramString.k = ((String)localPSMetaMaterial.additionalFields.get("web_url"));
          try
          {
            label431:
            paramString.l = ((String)localPSMetaMaterial.additionalFields.get("mini_app_id"));
          }
          catch (Throwable localThrowable1) {}
        }
        break label252;
        label458:
        if (paramString.jdField_e_of_type_Int == 2)
        {
          if (!TextUtils.isEmpty(paramString.k)) {
            break label306;
          }
          break label214;
        }
        if ((paramString.jdField_e_of_type_Int != 3) || (TextUtils.isEmpty(paramString.l))) {
          break label306;
        }
        break label214;
        if (localLinkedList2.size() <= 0) {
          continue;
        }
        paramString = new bgxt();
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
  
  private List<bgxt> a(List<bgxt> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, a(new LinkedList(a().a())));
  }
  
  private List<bgxt> a(@NonNull List<bgxt> paramList, @NonNull Map<String, bgya> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.c = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      bgxt localbgxt = (bgxt)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localbgxt.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bgya)localbgxt.jdField_a_of_type_JavaUtilList.get(j);
        if (((bgya)localObject).jdField_e_of_type_Int != 0)
        {
          ((bgya)localObject).jdField_d_of_type_Boolean = a((bgya)localObject);
          localLinkedList2.add(localObject);
          if (((bgya)localObject).jdField_e_of_type_Int == 2) {
            this.c = ((bgya)localObject).k;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((bgya)localObject).jdField_a_of_type_JavaLangString))
          {
            bgya localbgya = (bgya)paramMap.get(((bgya)localObject).jdField_a_of_type_JavaLangString);
            localbgya.i = ((bgya)localObject).i;
            localbgya.h = localbgxt.jdField_a_of_type_JavaLangString;
            localbgya.j = ((bgya)localObject).j;
            localLinkedList2.add(localbgya);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new bgxt();
        ((bgxt)localObject).jdField_b_of_type_JavaLangString = localbgxt.jdField_b_of_type_JavaLangString;
        ((bgxt)localObject).jdField_b_of_type_Int = localbgxt.jdField_b_of_type_Int;
        ((bgxt)localObject).jdField_a_of_type_JavaLangString = localbgxt.jdField_a_of_type_JavaLangString;
        ((bgxt)localObject).jdField_a_of_type_JavaUtilList = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private Map<String, bgya> a(@Nullable List<bgxt> paramList)
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
      Object localObject = (bgxt)paramList.next();
      if ((localObject != null) && (((bgxt)localObject).jdField_a_of_type_JavaUtilList != null) && (((bgxt)localObject).jdField_a_of_type_JavaUtilList.size() != 0))
      {
        localObject = ((bgxt)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bgya localbgya = (bgya)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localbgya.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbgya.jdField_d_of_type_JavaLangString))) {
            localHashMap.put(localbgya.jdField_a_of_type_JavaLangString, localbgya);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void a(@NonNull bgya parambgya)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + parambgya.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(jdField_b_of_type_JavaLangString, parambgya.jdField_a_of_type_JavaLangString);
    parambgya = new File(jdField_a_of_type_JavaLangString, parambgya.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      bace.d(localFile.getPath());
    }
    if (parambgya.exists()) {
      bace.a(parambgya.getPath());
    }
  }
  
  private void a(@NonNull List<bgxt> paramList1, @NonNull List<bgxt> paramList2)
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
        paramList2 = (bgya)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (bgya)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.jdField_e_of_type_Int != 4) && (paramList1.jdField_e_of_type_Int != 5) && (paramList1.jdField_e_of_type_Int != 6) && (paramList1.jdField_e_of_type_Int != 7)) || (paramList1.jdField_d_of_type_JavaLangString.equals(paramList2.jdField_d_of_type_JavaLangString))) {
            break label212;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.jdField_e_of_type_Int != 4) && (paramList1.jdField_e_of_type_Int != 5) && (paramList1.jdField_e_of_type_Int != 6) && (paramList1.jdField_e_of_type_Int != 7))) {
          break label215;
        }
        a(paramList1);
        break;
        return;
      }
    }
  }
  
  private boolean a(@NonNull bgya parambgya)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + parambgya.jdField_a_of_type_JavaLangString);
    }
    switch (parambgya.jdField_e_of_type_Int)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    a();
    return bgxx.a(parambgya);
  }
  
  private List<bgxt> b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(avzg.c);
    File localFile2 = new File(avzg.jdField_d_of_type_JavaLangString);
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
      return a(a(bjin.a(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = a(a(bjin.a(localFile2)));
      bace.b(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = a(bjin.a(localFile1));
    List localList2 = a(bjin.a(localFile2));
    a(localList1, localList2);
    localList1 = a(localList2);
    bace.d(localFile1.getPath());
    bace.b(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  private void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private void e()
  {
    bhcs.a("AEPlayShowMaterialManager", 1, "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  @Nullable
  public String a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPreLoadUrl, preLoadUrl=" + this.c);
    }
    return this.c;
  }
  
  public List<bgxt> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    d();
  }
  
  public void a(awhd paramawhd)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + paramawhd);
    }
    this.jdField_a_of_type_Awhb.a(paramawhd);
  }
  
  public void a(awhd paramawhd, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + paramawhd + ", eventId=" + paramInt);
    }
    this.jdField_a_of_type_Awhb.a(paramawhd, new int[] { paramInt });
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    d();
  }
  
  public void c()
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
 * Qualified Name:     bgyb
 * JD-Core Version:    0.7.0.1
 */