import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class apjm
  extends aphz<CameraEmotionData>
{
  private boolean a;
  private boolean b;
  
  public apjm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private CameraEmotionData a(alkt paramalkt, int paramInt)
  {
    if ((paramalkt == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localCameraEmotionData.emoId = (paramInt + 1);
    localCameraEmotionData.resid = paramalkt.a;
    localCameraEmotionData.strContext = paramalkt.b;
    localCameraEmotionData.templateId = paramalkt.e;
    if (bdje.a(paramalkt.d)) {}
    for (localCameraEmotionData.md5 = apjc.a(paramalkt.a);; localCameraEmotionData.md5 = paramalkt.d)
    {
      localCameraEmotionData.url = paramalkt.jdField_c_of_type_JavaLangString;
      return localCameraEmotionData;
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
  
  public appw a(CameraEmotionData paramCameraEmotionData)
  {
    appi localappi = new appi();
    localappi.jdField_c_of_type_Int = 11;
    localappi.e = a(paramCameraEmotionData);
    localappi.a = paramCameraEmotionData.strContext;
    localappi.jdField_c_of_type_JavaLangString = paramCameraEmotionData.templateId;
    localappi.f = paramCameraEmotionData.url;
    localappi.jdField_g_of_type_Int = paramCameraEmotionData.emoId;
    localappi.d = paramCameraEmotionData.resid;
    localappi.h = paramCameraEmotionData.RomaingType;
    localappi.b = paramCameraEmotionData.thumbPath;
    localappi.jdField_g_of_type_JavaLangString = paramCameraEmotionData.resid;
    return localappi;
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
      str1 = apjc.a(paramCameraEmotionData.resid);
    }
    return apjc.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        Object localObject2;
        int i;
        if (localObject3 != null)
        {
          localObject2 = ((awbw)localObject3).a(a(), false, null, null, null, null, null, null);
          localObject3 = new ArrayList();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label406;
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
        label406:
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
                azmz.a(BaseApplication.getContext()).a("", "CameraEmoDBError", true, 0L, 0L, null, "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).g();
    }
  }
  
  protected void a(List<CameraEmotionData> paramList, int paramInt)
  {
    super.a(paramList, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).g();
    }
  }
  
  public void a(List<alkt> paramList, List<String> paramList1, List<String> paramList2)
  {
    int k = 0;
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateLocalDBFromServer, start remoteimgList.size = ").append(paramList.size()).append("| deleteSize =");
      if (paramList2 == null)
      {
        i = 0;
        QLog.d("CameraEmotionRoamingDBManager", 2, i);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Object localObject3 = a();
      if (localObject3 == null) {
        break label241;
      }
      localObject3 = ((List)localObject3).iterator();
      bool1 = false;
      label112:
      CameraEmotionData localCameraEmotionData;
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localCameraEmotionData = (CameraEmotionData)((Iterator)localObject3).next();
      } while ((localCameraEmotionData.RomaingType.equals("needDel")) || (localCameraEmotionData.RomaingType.equals("failed")) || (localCameraEmotionData.RomaingType.equals("needUpload")));
      i = paramList1.indexOf(localCameraEmotionData.resid);
      if (i >= 0) {
        break label222;
      }
      ((List)localObject1).add(localCameraEmotionData);
      bool1 = true;
    }
    for (;;)
    {
      break label112;
      i = paramList2.size();
      break;
      label222:
      ((List)localObject2).add(paramList.get(i));
    }
    label241:
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needDelete = " + bool2 + "| localNotInServerList.size = " + ((List)localObject1).size());
    }
    if (((List)localObject2).size() < paramList.size())
    {
      paramList1 = ((List)localObject2).iterator();
      while (paramList1.hasNext()) {
        paramList.remove((alkt)paramList1.next());
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needAdd = " + bool1 + "| remoteimgList.size = " + paramList.size());
      }
      paramList1 = b("needDel");
      if (paramList1 == null) {
        paramList1 = new ArrayList();
      }
      for (;;)
      {
        if ((paramList2 != null) && (paramList2.size() > 0))
        {
          if (paramList1.size() > 0)
          {
            localObject2 = paramList1.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (!paramList2.contains(((CameraEmotionData)((Iterator)localObject2).next()).resid)) {
                ((Iterator)localObject2).remove();
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, locNeedDelList.size = " + paramList1.size());
          }
        }
        if (bool2) {
          paramList1.addAll((Collection)localObject1);
        }
        if (paramList1.size() > 0)
        {
          paramList2 = paramList1.iterator();
          while (paramList2.hasNext()) {
            b((CameraEmotionData)paramList2.next(), 4);
          }
          a(paramList1, 4);
        }
        int j;
        if (bool1)
        {
          paramList1 = a();
          if (paramList1 != null)
          {
            i = 1;
            j = i;
            if (k >= paramList1.size()) {
              break label657;
            }
            j = ((CameraEmotionData)paramList1.get(k)).emoId;
            if (i >= j) {
              break label740;
            }
            i = j;
          }
        }
        label657:
        label740:
        for (;;)
        {
          k += 1;
          break;
          j = 1;
          paramList1 = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramList2 = (alkt)paramList.next();
            j += 1;
            paramList2 = a(paramList2, j);
            paramList2.RomaingType = "normal";
            b(paramList2, 1);
            paramList1.add(paramList2);
          }
          a(paramList1, 1);
          a();
          return;
        }
      }
    }
  }
  
  public List<appw> b()
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
      azmz.a(BaseApplication.getContext()).a(null, "CamEmoUpload", false, 0L, 0L, localHashMap, null);
    }
  }
  
  protected List<appw> c()
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
            appi localappi = new appi();
            localappi.jdField_c_of_type_Int = 11;
            localappi.e = a(localCameraEmotionData);
            localappi.a = localCameraEmotionData.strContext;
            localappi.jdField_c_of_type_JavaLangString = localCameraEmotionData.templateId;
            localappi.f = localCameraEmotionData.url;
            localappi.jdField_g_of_type_Int = localCameraEmotionData.emoId;
            localappi.d = localCameraEmotionData.resid;
            localappi.h = localCameraEmotionData.RomaingType;
            localappi.b = localCameraEmotionData.thumbPath;
            localappi.jdField_g_of_type_JavaLangString = localCameraEmotionData.resid;
            localArrayList.add(localappi);
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
    apjj.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjm
 * JD-Core Version:    0.7.0.1
 */