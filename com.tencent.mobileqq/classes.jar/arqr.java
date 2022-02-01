import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class arqr
  extends arpe<CameraEmotionData>
{
  private boolean a;
  private boolean b;
  
  public arqr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private CameraEmotionData a(anin paramanin, int paramInt)
  {
    if ((paramanin == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localCameraEmotionData.emoId = (paramInt + 1);
    localCameraEmotionData.resid = paramanin.a;
    localCameraEmotionData.strContext = paramanin.b;
    localCameraEmotionData.templateId = paramanin.e;
    if (bgsp.a(paramanin.d)) {}
    for (localCameraEmotionData.md5 = arqh.a(paramanin.a);; localCameraEmotionData.md5 = paramanin.d)
    {
      localCameraEmotionData.url = paramanin.jdField_c_of_type_JavaLangString;
      return localCameraEmotionData;
    }
  }
  
  private void a(List<anin> paramList1, List<anin> paramList2)
  {
    int k = 0;
    if (paramList2.size() < paramList1.size())
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.remove((anin)paramList2.next());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramList2 = a();
        if (paramList2 != null) {
          for (int i = 1;; i = j)
          {
            j = i;
            if (k >= paramList2.size()) {
              break;
            }
            int m = ((CameraEmotionData)paramList2.get(k)).emoId;
            j = i;
            if (i < m) {
              j = m;
            }
            k += 1;
          }
        }
        int j = 1;
        paramList2 = new ArrayList();
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (anin)localIterator.next();
          j += 1;
          localObject = a((anin)localObject, j);
          ((CameraEmotionData)localObject).RomaingType = "normal";
          b((CustomEmotionBase)localObject, 1);
          paramList2.add(localObject);
        }
        a(paramList2, 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needAdd = " + bool + "| remoteImgList.size = " + paramList1.size());
      }
      return;
    }
  }
  
  private void a(List<String> paramList, List<CameraEmotionData> paramList1, boolean paramBoolean)
  {
    Object localObject = b("needDel");
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        if (((List)localObject).size() > 0)
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext()) {
            if (!paramList.contains(((CameraEmotionData)localIterator.next()).resid)) {
              localIterator.remove();
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, locNeedDelList.size = " + ((List)localObject).size());
        }
      }
      if (paramBoolean) {
        ((List)localObject).addAll(paramList1);
      }
      if (((List)localObject).size() > 0)
      {
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext()) {
          b((CameraEmotionData)paramList.next(), 4);
        }
        a((List)localObject, 4);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needDelete = " + paramBoolean + "| localNotInServerList.size = " + paramList1.size());
      }
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if ("needDel".equals(((CameraEmotionData)localIterator.next()).RomaingType)) {
        break label59;
      }
      i += 1;
    }
    label59:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public arxg a(CameraEmotionData paramCameraEmotionData)
  {
    arws localarws = new arws();
    localarws.jdField_c_of_type_Int = 11;
    localarws.e = a(paramCameraEmotionData);
    localarws.a = paramCameraEmotionData.strContext;
    localarws.jdField_c_of_type_JavaLangString = paramCameraEmotionData.templateId;
    localarws.f = paramCameraEmotionData.url;
    localarws.jdField_g_of_type_Int = paramCameraEmotionData.emoId;
    localarws.d = paramCameraEmotionData.resid;
    localarws.h = paramCameraEmotionData.RomaingType;
    localarws.b = paramCameraEmotionData.thumbPath;
    localarws.jdField_g_of_type_JavaLangString = paramCameraEmotionData.resid;
    return localarws;
  }
  
  public Class a()
  {
    return CameraEmotionData.class;
  }
  
  public String a(CameraEmotionData paramCameraEmotionData)
  {
    if ((paramCameraEmotionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return "";
    }
    if (!TextUtils.isEmpty(paramCameraEmotionData.emoPath)) {
      return paramCameraEmotionData.emoPath;
    }
    String str2 = paramCameraEmotionData.md5;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(paramCameraEmotionData.resid)) {
        return "";
      }
      str1 = arqh.a(paramCameraEmotionData.resid);
    }
    return arqh.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
  }
  
  public List<CameraEmotionData> a()
  {
    Object localObject3;
    Object localObject4;
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label118;
      }
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (CameraEmotionData)((Iterator)localObject3).next();
        if (localObject4 != null) {
          localArrayList.add(localObject4);
        }
      }
      localObject3 = localObject1;
    }
    finally {}
    if (QLog.isColorLevel())
    {
      QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from cache: data size = " + localObject1.size());
      localObject3 = localObject1;
    }
    for (;;)
    {
      return localObject3;
      label118:
      localObject3 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        Object localObject2;
        int i;
        if (localObject3 != null)
        {
          localObject2 = ((EntityManager)localObject3).query(a(), false, null, null, null, null, null, null);
          localObject3 = new ArrayList();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label412;
            }
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject4).next();
            if (TextUtils.isEmpty(localCameraEmotionData.RomaingType))
            {
              localCameraEmotionData.RomaingType = "init";
              ((List)localObject3).add(localCameraEmotionData);
              i = 1;
            }
            for (;;)
            {
              b(localCameraEmotionData, 1);
              break;
              if (localCameraEmotionData.RomaingType.equals("needUpload"))
              {
                localCameraEmotionData.RomaingType = "failed";
                ((List)localObject3).add(localCameraEmotionData);
                b();
                i = 1;
              }
            }
          }
        }
        label412:
        for (;;)
        {
          a();
          if (i != 0) {
            a((List)localObject3, 2);
          }
          if (QLog.isColorLevel()) {
            if (localObject2 != null)
            {
              QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from db : data size = " + ((List)localObject2).size());
              this.jdField_a_of_type_Boolean = true;
            }
            else
            {
              localObject2 = new ArrayList();
              QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from db : data size = null");
              if (this.jdField_a_of_type_Boolean) {
                bctj.a(BaseApplication.getContext()).a("", "CameraEmoDBError", true, 0L, 0L, null, "");
              }
            }
          }
          break;
          i = 0;
          continue;
          break;
        }
        localObject3 = localObject2;
      }
    }
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, int paramInt)
  {
    super.a(paramCameraEmotionData, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramCameraEmotionData = aijp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramCameraEmotionData != null) {
        paramCameraEmotionData.g();
      }
    }
  }
  
  protected void a(List<CameraEmotionData> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      aijp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).g();
    }
  }
  
  public void a(List<anin> paramList, List<String> paramList1, List<String> paramList2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Object localObject1;
    int i;
    ArrayList localArrayList;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateLocalDBFromServer, start remoteImgList.size = ").append(paramList.size()).append("| deleteSize =");
      if (paramList2 == null)
      {
        i = 0;
        QLog.d("CameraEmotionRoamingDBManager", 2, i);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      localObject2 = a();
      if (localObject2 == null) {
        break label243;
      }
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      bool2 = bool1;
      if (!((Iterator)localObject2).hasNext()) {
        break label243;
      }
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject2).next();
      if ((!localCameraEmotionData.RomaingType.equals("needDel")) && (!localCameraEmotionData.RomaingType.equals("failed")) && (!localCameraEmotionData.RomaingType.equals("needUpload")))
      {
        i = paramList1.indexOf(localCameraEmotionData.resid);
        if (i < 0)
        {
          bool1 = true;
          ((List)localObject1).add(localCameraEmotionData);
          continue;
          i = paramList2.size();
          break;
        }
        localArrayList.add(paramList.get(i));
      }
    }
    label243:
    a(paramList2, (List)localObject1, bool2);
    a(paramList, localArrayList);
    a();
  }
  
  public List<arxg> b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPanel.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          CameraEmotionData localCameraEmotionData = (CameraEmotionData)localList.get(i);
          if ("needDel".equals(localCameraEmotionData.RomaingType)) {
            QLog.d("CameraEmotionRoamingDBManager", 1, "data need delete, do not need display -> resId:" + localCameraEmotionData.resid);
          } else {
            localArrayList.add(a(localCameraEmotionData));
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPanel, display size:" + localArrayList.size());
      }
      return localArrayList;
      i -= 1;
    }
  }
  
  public void b()
  {
    if (!this.b)
    {
      this.b = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("sucFlag", "0");
      localHashMap.put("retCode", String.valueOf(15));
      bctj.a(BaseApplication.getContext()).a(null, "CamEmoUpload", false, 0L, 0L, localHashMap, null);
    }
  }
  
  protected List<arxg> c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          CameraEmotionData localCameraEmotionData = (CameraEmotionData)localList.get(i);
          if (!"normal".equals(localCameraEmotionData.RomaingType))
          {
            QLog.d("CameraEmotionRoamingDBManager", 1, "data need hidden, do not need display -> resId:" + localCameraEmotionData.resid);
          }
          else
          {
            arws localarws = new arws();
            localarws.jdField_c_of_type_Int = 11;
            localarws.e = a(localCameraEmotionData);
            localarws.a = localCameraEmotionData.strContext;
            localarws.jdField_c_of_type_JavaLangString = localCameraEmotionData.templateId;
            localarws.f = localCameraEmotionData.url;
            localarws.jdField_g_of_type_Int = localCameraEmotionData.emoId;
            localarws.d = localCameraEmotionData.resid;
            localarws.h = localCameraEmotionData.RomaingType;
            localarws.b = localCameraEmotionData.thumbPath;
            localarws.jdField_g_of_type_JavaLangString = localCameraEmotionData.resid;
            localArrayList.add(localarws);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + localArrayList.size());
      }
      return localArrayList;
      i -= 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    arqo.a().a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqr
 * JD-Core Version:    0.7.0.1
 */