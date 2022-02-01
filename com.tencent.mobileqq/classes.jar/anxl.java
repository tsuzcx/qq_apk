import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LebaHelper.1;
import com.tencent.mobileqq.app.LebaHelper.2;
import com.tencent.mobileqq.app.LebaHelper.3;
import com.tencent.mobileqq.app.LebaHelper.4;
import com.tencent.mobileqq.app.LebaHelper.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;

public class anxl
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  public bilm a;
  public QQAppInterface a;
  List<LebaPluginInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  int jdField_b_of_type_Int = 0;
  List<LebaPluginInfo> jdField_b_of_type_JavaUtilList;
  public boolean b;
  List<ResourcePluginListener> jdField_c_of_type_JavaUtilList;
  boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + bhcu.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  }
  
  public anxl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
  }
  
  private void b(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      List localList = LebaPluginInfo.getAll((EntityManager)localObject1);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cDataType == 1)) {
            LebaPluginInfo.remove((EntityManager)localObject1, localLebaPluginInfo.uiResId);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((EntityManager)localObject1).close();
      }
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void j()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131717136);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.jdField_b_of_type_JavaUtilList.add(localLebaPluginInfo);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = anxo.a(anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = LebaPluginInfo.getAll((EntityManager)???);
    ((EntityManager)???).close();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localList != null) && (localList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          anxm localanxm = (anxm)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (localanxm == null)
          {
            localStringBuilder.append(",remove ").append(localLebaPluginInfo);
            localList.remove(localLebaPluginInfo);
          }
          else
          {
            localStringBuilder.append(",add ").append(localLebaPluginInfo);
            localLebaPluginInfo.sPriority = anxo.a(localanxm);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
      QLog.i("LebaHelper", 1, "loadServerPlugins data =  " + localStringBuilder);
      return;
      i -= 1;
    }
  }
  
  public List<LebaPluginInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public PluginConfig.GetResourceReq a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "getLebaPluginInfoReq");
    }
    if (anxo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isAppUpgrade");
      anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (anxv.c())
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isLocaleUpdated");
      anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    }
    try
    {
      ((EntityManager)localObject).drop(LebaPluginInfo.class);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList;
        LebaPluginInfo localLebaPluginInfo2;
        QLog.e("LebaHelper", 1, "getLebaPluginInfoReq exception", localThrowable);
        if (localObject != null) {
          ((EntityManager)localObject).close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label322;
      }
      ((EntityManager)localObject).close();
    }
    if (anxo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isChangeModel");
      anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    int k = anxo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = LebaPluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager());
    localArrayList = new ArrayList();
    if (localObject != null)
    {
      i = 0;
      if (i < ((List)localObject).size())
      {
        LebaPluginInfo localLebaPluginInfo1 = (LebaPluginInfo)((List)localObject).get(i);
        if ((localLebaPluginInfo1 != null) && (localLebaPluginInfo1.cDataType == 0))
        {
          localLebaPluginInfo2 = new LebaPluginInfo();
          if (k > 0) {
            break label325;
          }
        }
        label322:
        label325:
        for (int j = 0;; j = localLebaPluginInfo1.sResSeq)
        {
          localLebaPluginInfo2.sResSeq = j;
          localLebaPluginInfo2.uiResId = localLebaPluginInfo1.uiResId;
          localArrayList.add(localLebaPluginInfo2);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "" + localLebaPluginInfo1);
          }
          i += 1;
          break;
        }
      }
    }
    if (localList.isEmpty()) {}
    for (int i = 0;; i = k)
    {
      HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "getLebaPluginInfoReq, layoutSeq=" + i + ", lebaPluginInfos.size" + localList.size() + ", tempLebaList.size()=" + ((List)localObject).size());
      }
      return anxo.a(i, localList);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    b(new LebaHelper.1(this));
  }
  
  public void a(int paramInt1, List<anxm> paramList, int paramInt2, int paramInt3)
  {
    int j = anxo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
      if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
      {
        anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
        anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
        anxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.i("leba_study", 1, "tryCloseShowAllPluginAsyn");
    a(new LebaHelper.4(this, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder("closeShowAllPlugin->");
    Object localObject2 = ajzy.a().a(paramContext, paramQQAppInterface);
    Object localObject1 = ajzy.a().a();
    long l = NetConnInfoCenter.getServerTimeMillis();
    localStringBuilder.append(l);
    paramContext = new ArrayList();
    Object localObject3;
    if (localObject2 != null)
    {
      localStringBuilder.append("close->");
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (arpq)((Iterator)localObject2).next();
        if ((localObject3 == null) || (((arpq)localObject3).a == null))
        {
          localStringBuilder.append("null;");
        }
        else
        {
          localStringBuilder.append(((arpq)localObject3).a.uiResId).append(";");
          if ((4030L != ((arpq)localObject3).a.uiResId) && (3504L != ((arpq)localObject3).a.uiResId))
          {
            ajzy.a().a(paramQQAppInterface, ((arpq)localObject3).a.uiResId, false, l, -9223372036854775808L, true);
            BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
            localAppSetting.appid.set((int)((arpq)localObject3).a.uiResId);
            localAppSetting.setting.set(false);
            localAppSetting.modify_ts.set(l);
            paramContext.add(localAppSetting);
          }
        }
      }
    }
    if (localObject1 != null)
    {
      localStringBuilder.append("open->");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (arpq)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((arpq)localObject2).a == null))
        {
          localStringBuilder.append("null;");
        }
        else if ((4030L == ((arpq)localObject2).a.uiResId) || (3504L == ((arpq)localObject2).a.uiResId))
        {
          ajzy.a().a(paramQQAppInterface, ((arpq)localObject2).a.uiResId, true, l, -9223372036854775808L, true);
          localObject3 = new BusinessInfoCheckUpdate.AppSetting();
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).appid.set((int)((arpq)localObject2).a.uiResId);
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).setting.set(true);
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).modify_ts.set(l);
          paramContext.add(localObject3);
        }
      }
    }
    QLog.i("leba_study", 1, localStringBuilder.toString());
    if (paramContext.isEmpty()) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      h();
      return;
      ((awcz)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COMMPLGUGIN_HANDLER)).a(paramContext);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
        this.jdField_c_of_type_JavaUtilList.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 128, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = false;
      h();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, int paramInt1, List<anxm> arg3, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    b(paramBoolean, paramInt1, ???, paramList1, paramInt2, paramInt3);
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    StringBuffer localStringBuffer;
    boolean bool3;
    boolean bool4;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      bool2 = false;
      bool1 = false;
      bool5 = false;
      paramBoolean = false;
      localStringBuffer = new StringBuffer();
      bool3 = bool5;
      bool4 = bool2;
    }
    for (;;)
    {
      boolean bool6;
      boolean bool7;
      try
      {
        localStringBuffer.append("onGetPluginConfig saveDb start");
        bool3 = bool5;
        bool4 = bool2;
        localEntityTransaction.begin();
        bool3 = bool5;
        bool4 = bool2;
        paramList1 = paramList1.iterator();
        bool3 = paramBoolean;
        bool4 = bool1;
        if (paramList1.hasNext())
        {
          bool3 = paramBoolean;
          bool4 = bool1;
          localLebaPluginInfo = (LebaPluginInfo)paramList1.next();
          if (localLebaPluginInfo == null) {
            continue;
          }
          bool3 = paramBoolean;
          bool4 = bool1;
          localStringBuffer.append(localLebaPluginInfo);
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.sResSubType != 0)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            bool6 = paramBoolean;
            bool7 = bool1;
            if (localLebaPluginInfo.sResSubType != 2) {
              break label698;
            }
          }
          bool2 = paramBoolean;
          bool5 = bool1;
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.state == 3)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
            bool5 = true;
            bool2 = true;
          }
          bool3 = bool2;
          bool4 = bool5;
          bool6 = bool2;
          bool7 = bool5;
          if (localLebaPluginInfo.state != 1) {
            break label698;
          }
          bool3 = bool2;
          bool4 = bool5;
          LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
          bool1 = true;
          paramBoolean = bool2;
        }
      }
      catch (Exception paramList1)
      {
        LebaPluginInfo localLebaPluginInfo;
        QLog.i("LebaHelper", 1, "onGetPluginConfig", paramList1);
        paramBoolean = false;
        paramList1.printStackTrace();
        localEntityTransaction.end();
        localEntityManager.close();
        bool1 = bool4;
        continue;
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
      try
      {
        if (localLebaPluginInfo.state != 2) {
          break label695;
        }
        LebaPluginInfo.remove(localEntityManager, localLebaPluginInfo.uiResId);
        bool1 = true;
      }
      catch (Exception paramList1)
      {
        bool3 = paramBoolean;
        bool4 = bool1;
        continue;
        continue;
      }
      bool2 = true;
      bool3 = paramBoolean;
      bool4 = bool1;
      localEntityTransaction.commit();
      localEntityTransaction.end();
      localEntityManager.close();
      bool3 = paramBoolean;
      paramBoolean = bool2;
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
        QLog.i("LebaHelper", 2, localStringBuffer.toString());
      }
      if (paramBoolean) {
        a(paramInt1, ???, paramInt2, paramInt3);
      }
      f();
      h();
      if (bool3) {
        ((aocj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER)).a(1);
      }
      if (bool1)
      {
        ??? = new ArrayList(this.jdField_c_of_type_JavaUtilList).iterator();
        if (!???.hasNext()) {
          break;
        }
        paramList1 = (ResourcePluginListener)???.next();
        if (bool3)
        {
          ResourcePluginListener.a(paramList1, (byte)3, 1);
          continue;
        }
        ResourcePluginListener.a(paramList1, (byte)2, 1);
        continue;
      }
      ??? = this.jdField_c_of_type_JavaUtilList;
      paramInt1 = 0;
      try
      {
        while (paramInt1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.jdField_c_of_type_JavaUtilList.get(paramInt1), (byte)1, 1);
          paramInt1 += 1;
        }
        return;
      }
      finally {}
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_Boolean = true;
        paramInt1 = 0;
        while (paramInt1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.jdField_c_of_type_JavaUtilList.get(paramInt1), (byte)-1, 1);
          paramInt1 += 1;
        }
        return;
      }
      label695:
      label698:
      bool1 = bool7;
      paramBoolean = bool6;
    }
  }
  
  public boolean a()
  {
    return anxo.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!anxo.a(paramInt)))
    {
      QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin failed isSuc = " + paramBoolean + ",pluginType=" + paramInt);
      return false;
    }
    if (anxo.c(paramQQAppInterface) == 2)
    {
      QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin failed has Close");
      return false;
    }
    QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin");
    ((awcz)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COMMPLGUGIN_HANDLER)).c();
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      ((awcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COMMPLGUGIN_HANDLER)).a();
      this.jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "checkPluginConfig, mGetPluginConfigFail=" + this.jdField_a_of_type_Boolean + ", mPluginRetryTime=" + this.jdField_a_of_type_Int);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    QLog.i("leba_study", 1, "setHasClosePluginFlagYes");
    anxo.b(paramQQAppInterface, 2);
    anxo.a(paramQQAppInterface, true);
    a(new LebaHelper.5(this, paramQQAppInterface));
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void b(boolean paramBoolean, int paramInt1, List<anxm> paramList, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(" onGetPluginConfig, isSucc= ").append(paramBoolean).append(",layoutSeq=").append(paramInt1).append(",layoutType=").append(paramInt2).append(",pluginType=").append(paramInt3);
    localStringBuilder.append(",groupList=");
    if (paramList != null)
    {
      localStringBuilder.append(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        anxm localanxm = (anxm)paramList.next();
        if (localanxm != null) {
          localStringBuilder.append(localanxm.toString());
        }
      }
    }
    localStringBuilder.append(",resultInfos=");
    if (paramList1 != null)
    {
      localStringBuilder.append(paramList1.size());
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (LebaPluginInfo)paramList.next();
        if (paramList1 != null) {
          localStringBuilder.append(paramList1.toString());
        }
      }
    }
    QLog.i("LebaHelper", 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    if (anxo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void e()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int += 1;
      ThreadManager.excute(new LebaHelper.3(this), 128, null, true);
      QLog.i("leba_sort", 1, "checkPluginSort, mGetUserSortFail=" + this.jdField_c_of_type_Boolean + ", mPluginRetryTime=" + this.jdField_b_of_type_Int);
    }
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	anxl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 64	anxl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 92	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 122
    //   25: iconst_2
    //   26: ldc_w 635
    //   29: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 71	anxl:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 71	anxl:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 626 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 637	anxl:j	()V
    //   55: aload_0
    //   56: invokespecial 639	anxl:k	()V
    //   59: aload_0
    //   60: getfield 54	anxl:jdField_a_of_type_ArrayOfByte	[B
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 69	anxl:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: invokeinterface 626 1 0
    //   75: aload_0
    //   76: getfield 69	anxl:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 71	anxl:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   83: invokeinterface 280 2 0
    //   88: pop
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: ldc 122
    //   99: iconst_2
    //   100: new 20	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 641
    //   110: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 69	anxl:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   117: invokeinterface 150 1 0
    //   122: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 643	anxl:jdField_b_of_type_Boolean	Z
    //   136: return
    //   137: astore_2
    //   138: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -92 -> 49
    //   144: ldc 122
    //   146: iconst_2
    //   147: aload_2
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 646	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -106 -> 49
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   168: goto -113 -> 55
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	anxl
    //   163	10	1	localException1	Exception
    //   137	11	2	localException2	Exception
    //   158	4	2	localObject2	Object
    //   171	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	137	java/lang/Exception
    //   40	49	158	finally
    //   49	51	158	finally
    //   138	155	158	finally
    //   159	161	158	finally
    //   51	55	163	java/lang/Exception
    //   66	91	171	finally
    //   172	174	171	finally
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bilm != null) {
      this.jdField_a_of_type_Bilm.a();
    }
  }
  
  public void h()
  {
    Iterator localIterator = new ArrayList(this.jdField_c_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anxl
 * JD-Core Version:    0.7.0.1
 */