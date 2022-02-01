package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.MessageDataManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class SendPanelManager
  implements Manager
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IPanelDataListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener;
  private MessageDataManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager;
  public volatile String a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<RecentUser> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<SendPanelItemInfo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  public volatile boolean a;
  private volatile String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private volatile boolean c;
  
  private SendPanelManager()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    a();
  }
  
  public static SendPanelManager a()
  {
    return SendPanelManager.SingletonPatternHolder.a();
  }
  
  private String a(RecentUser paramRecentUser)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramRecentUser != null)
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      localObject2 = localObject1;
      if (localHashMap != null)
      {
        if (localHashMap.isEmpty()) {
          return "";
        }
        int i = paramRecentUser.getType();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 1000)
            {
              if (i != 1004)
              {
                if (i == 3000) {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramRecentUser.uin);
                }
              }
              else {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(paramRecentUser.troopUin, paramRecentUser.uin);
              }
            }
            else {
              PeakIpcController.b(paramRecentUser.troopUin, paramRecentUser.uin);
            }
          }
          else
          {
            localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramRecentUser.uin);
            ((StringBuilder)localObject2).append(1);
            localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramRecentUser.uin);
          ((StringBuilder)localObject2).append(0);
          localObject1 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = paramRecentUser.displayName;
        }
      }
    }
    return localObject2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager = new MessageDataManager();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    PeakIpcModuleClient.a();
  }
  
  private void a(SendPanelItemInfo paramSendPanelItemInfo, int paramInt1, int paramInt2)
  {
    int i = paramSendPanelItemInfo.jdField_b_of_type_Int;
    if (i == 1)
    {
      if ((paramInt1 != 1003) && (paramInt1 != 1007))
      {
        if ((paramInt1 != 1004) && (paramInt1 != 1005) && (paramInt1 != 1006))
        {
          paramSendPanelItemInfo.jdField_c_of_type_Int = paramInt2;
          return;
        }
        paramSendPanelItemInfo.jdField_b_of_type_Int = 2;
        return;
      }
      paramSendPanelItemInfo.jdField_b_of_type_Int = 3;
      paramSendPanelItemInfo.jdField_c_of_type_Int = 100;
      return;
    }
    if ((i == 0) && ((paramInt1 == 1003) || (paramInt1 == 1007)))
    {
      paramSendPanelItemInfo.jdField_b_of_type_Int = 3;
      paramSendPanelItemInfo.jdField_c_of_type_Int = 100;
    }
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (a(localRecentUser.getType())) {
          this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 3000) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadPanelData");
    }
    IPanelDataListener localIPanelDataListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener;
    if (localIPanelDataListener != null) {
      localIPanelDataListener.c();
    }
    j();
    d();
    this.jdField_a_of_type_Int = 1;
    try
    {
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.1(this));
      ThreadManager.getSubThreadHandler().post(new SendPanelManager.2(this));
      ThreadManager.getFileThreadHandler().post(new SendPanelManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener == null) {
        break label176;
      }
      if (!QLog.isColorLevel()) {
        break label167;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadPanelData exception = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("SendPanelManager", 2, localStringBuilder.toString());
      this.jdField_a_of_type_Int = 3;
      i();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label88:
      break label88;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "loadPanelData OutOfMemoryError");
      }
      this.jdField_a_of_type_Int = 3;
      i();
      return;
    }
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_panel_animation_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(RecentUser.class, "select * from recent order by lastmsgtime desc", null));
    f();
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadRecentUserList finish");
    }
    h();
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
        if (localRecentUser.showUpTime > 0L) {
          ((List)localObject2).add(localRecentUser);
        } else {
          ((List)localObject1).add(localRecentUser);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new RecentUserComparator());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new RecentUserComparator());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanMessageDataManager.b(1, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "loadNameList finish");
    }
    h();
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "conformAllData");
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          SendPanelItemInfo localSendPanelItemInfo = new SendPanelItemInfo();
          localSendPanelItemInfo.jdField_a_of_type_JavaLangString = localRecentUser.uin;
          localSendPanelItemInfo.jdField_b_of_type_JavaLangString = localRecentUser.troopUin;
          if (localRecentUser.getType() == 1000)
          {
            localSendPanelItemInfo.jdField_c_of_type_JavaLangString = localRecentUser.displayName;
            ((List)localObject).add(localRecentUser);
          }
          else
          {
            localSendPanelItemInfo.jdField_c_of_type_JavaLangString = a(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            Pair localPair = PeakIpcController.a(localRecentUser.uin);
            if (localPair != null)
            {
              if (((Boolean)localPair.first).booleanValue())
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("SendPanelManager", 2, "conformAllData troop is disband");
                continue;
              }
              localSendPanelItemInfo.jdField_c_of_type_Boolean = ((Boolean)localPair.second).booleanValue();
            }
          }
          localSendPanelItemInfo.jdField_a_of_type_Int = localRecentUser.getType();
          if ((localRecentUser.getType() == 0) && (!TextUtils.isEmpty(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && ((TextUtils.isEmpty(localSendPanelItemInfo.jdField_c_of_type_JavaLangString)) || (localSendPanelItemInfo.jdField_a_of_type_JavaLangString.equals(localSendPanelItemInfo.jdField_c_of_type_JavaLangString)))) {
            localSendPanelItemInfo.jdField_c_of_type_JavaLangString = PeakIpcController.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localSendPanelItemInfo);
        }
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((RecentUser)((Iterator)localObject).next());
          }
        }
        localObject = this.jdField_a_of_type_JavaUtilList;
        if (localObject != null) {
          ((List)localObject).clear();
        }
        localObject = this.jdField_a_of_type_JavaUtilHashMap;
        if (localObject != null) {
          ((HashMap)localObject).clear();
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish");
          }
          this.jdField_a_of_type_Int = 2;
          i();
        }
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelManager", 2, "conformAllData onLoadFinish recentUserList is empty");
        }
        this.jdField_a_of_type_Int = 2;
        i();
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.4(this));
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      ((HashMap)localObject).clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List<SendPanelItemInfo> a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > 0)) {
      return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    }
    b();
    return null;
  }
  
  public void a(IPanelDataListener paramIPanelDataListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener = paramIPanelDataListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateOperateStatus uin is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
      {
        int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        int i = 0;
        while (i < j)
        {
          localObject = (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          if ((!TextUtils.isEmpty(((SendPanelItemInfo)localObject).jdField_a_of_type_JavaLangString)) && (((SendPanelItemInfo)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) && (((SendPanelItemInfo)localObject).jdField_a_of_type_Int == paramInt1) && (((SendPanelItemInfo)localObject).jdField_b_of_type_Boolean))
          {
            a((SendPanelItemInfo)localObject, paramInt2, paramInt3);
            if (((SendPanelItemInfo)localObject).jdField_a_of_type_Long <= 0L) {
              ((SendPanelItemInfo)localObject).jdField_a_of_type_Long = paramLong;
            }
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("updateOperateStatus operateStatus = ");
              paramString.append(((SendPanelItemInfo)localObject).jdField_b_of_type_Int);
              paramString.append(" ,progress = ");
              paramString.append(((SendPanelItemInfo)localObject).jdField_c_of_type_Int);
              paramString.append(" ,position = ");
              paramString.append(i);
              paramString.append(", uinseq:");
              paramString.append(((SendPanelItemInfo)localObject).jdField_a_of_type_Long);
              QLog.i("SendPanelManager", 2, paramString.toString());
            }
            this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.6(this, i, (SendPanelItemInfo)localObject));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath fileMd5 is null");
      }
      return;
    }
    paramString1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      paramString1 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (paramString1.hasNext()) {
        ((SendPanelItemInfo)paramString1.next()).g = paramString2;
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      SendPanelItemInfo localSendPanelItemInfo = null;
      Object localObject1 = null;
      int j = -1;
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      Object localObject2 = localSendPanelItemInfo;
      int k = j;
      if (localCopyOnWriteArrayList != null)
      {
        localObject2 = localSendPanelItemInfo;
        k = j;
        if (localCopyOnWriteArrayList.size() > 0)
        {
          int m = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          int i = 0;
          for (;;)
          {
            localObject2 = localObject1;
            k = j;
            if (i >= m) {
              break;
            }
            localSendPanelItemInfo = (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
            localSendPanelItemInfo.e = paramString2;
            localSendPanelItemInfo.f = paramString3;
            localSendPanelItemInfo.jdField_a_of_type_Boolean = paramBoolean;
            localObject2 = localObject1;
            k = j;
            if (!TextUtils.isEmpty(localSendPanelItemInfo.jdField_a_of_type_JavaLangString))
            {
              localObject2 = localObject1;
              k = j;
              if (localSendPanelItemInfo.jdField_a_of_type_JavaLangString.equals(paramString1))
              {
                localObject2 = localObject1;
                k = j;
                if (paramInt == localSendPanelItemInfo.jdField_a_of_type_Int)
                {
                  k = i;
                  localObject2 = localSendPanelItemInfo;
                }
              }
            }
            i += 1;
            localObject1 = localObject2;
            j = k;
          }
        }
      }
      if (localObject2 != null)
      {
        ((SendPanelItemInfo)localObject2).jdField_b_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.7(this, k, (SendPanelItemInfo)localObject2));
        }
        if (paramBoolean) {
          PeakIpcController.a(((SendPanelItemInfo)localObject2).e, paramString3, (SendPanelItemInfo)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        } else {
          PeakIpcController.a(paramString2, (SendPanelItemInfo)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        }
        ((SendPanelItemInfo)localObject2).jdField_b_of_type_Boolean = true;
        CaptureReportUtil.a((SendPanelItemInfo)localObject2);
        ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn(((SendPanelItemInfo)localObject2).g, ((SendPanelItemInfo)localObject2).jdField_a_of_type_Int);
        paramString2 = new StringBuilder();
        paramString2.append("【updateFilePath】messageType:");
        paramString2.append(((SendPanelItemInfo)localObject2).jdField_a_of_type_Int);
        AEQLog.b("SendPanelManager", paramString2.toString());
        a(paramString1, paramInt, ((SendPanelItemInfo)localObject2).g);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SendPanelManager", 2, "updateFilePath can not find sendItemInfo");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("updateFilePath fail uin = ");
      paramString3.append(paramString1);
      paramString3.append(" ,filePath = ");
      paramString3.append(paramString2);
      QLog.e("SendPanelManager", 2, paramString3.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener;
    if (paramString1 != null) {
      paramString1.g();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
        if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
        {
          int j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          int i = 0;
          while (i < j)
          {
            localObject = (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
            if ((!TextUtils.isEmpty(((SendPanelItemInfo)localObject).jdField_a_of_type_JavaLangString)) && (((SendPanelItemInfo)localObject).jdField_a_of_type_JavaLangString.equals(paramString1)) && (((SendPanelItemInfo)localObject).jdField_a_of_type_Int == 1000))
            {
              ((SendPanelItemInfo)localObject).jdField_c_of_type_JavaLangString = paramString2;
              if (QLog.isColorLevel()) {
                QLog.e("SendPanelManager", 2, "updateTroopMemberName");
              }
              this.jdField_a_of_type_AndroidOsHandler.post(new SendPanelManager.5(this, i, (SendPanelItemInfo)localObject));
              return;
            }
            i += 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateTroopMemberName exception uin = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" ,name = ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("SendPanelManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTroopMemberName uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ,name = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.e("SendPanelManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("file_short_send_panel", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_panel_animation_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendPanelManager", 2, "onDestroy()");
    }
    j();
    IPanelDataListener localIPanelDataListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener;
    if (localIPanelDataListener != null)
    {
      localIPanelDataListener.f();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelIPanelDataListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager
 * JD-Core Version:    0.7.0.1
 */