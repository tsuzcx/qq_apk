package com.tencent.mobileqq.activity.aio.pluspanel;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlusPanelViewModel
  extends BaseViewModel<PlusPanelRepository>
{
  public static ViewModelProvider.Factory a;
  int jdField_a_of_type_Int = 0;
  private MutableLiveData<Boolean> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private MutableLiveData<ArrayList<PluginData>> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new PlusPanelViewModel.4();
  }
  
  public PlusPanelViewModel(PlusPanelRepository paramPlusPanelRepository)
  {
    super(paramPlusPanelRepository);
    this.jdField_b_of_type_Int = -1;
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 6) {}
    for (;;)
    {
      return;
      Object localObject = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PlusPanelAppInfo)((Iterator)localObject).next()).onChatPieLifeCycle(paramInt);
        }
      }
    }
  }
  
  private void a(int paramInt, PluginData paramPluginData, RedTouchManager paramRedTouchManager)
  {
    paramPluginData = paramRedTouchManager.a(10, paramPluginData.c, paramPluginData.f);
    if (paramPluginData != null) {
      paramRedTouchManager.a(paramPluginData.uiAppId.get(), 30);
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.h(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b))
    {
      localTroopManager.h(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      return true;
    }
    return false;
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    if (this.jdField_b_of_type_AndroidxLifecycleMutableLiveData != null) {
      this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    if (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData != null) {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    MutableLiveData localMutableLiveData = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt > 0)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      paramBaseChatPie = localRedTouchManager.a(10, String.valueOf(paramInt), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      if (paramBaseChatPie != null) {
        localRedTouchManager.a(paramBaseChatPie.uiAppId.get(), 31);
      }
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, PluginData paramPluginData)
  {
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramPluginData);
  }
  
  LifecycleOwner a(BaseChatPie paramBaseChatPie)
  {
    try
    {
      paramBaseChatPie = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_fragment");
      if ((paramBaseChatPie instanceof LifeCycleFragment))
      {
        paramBaseChatPie = (LifeCycleFragment)paramBaseChatPie;
        return paramBaseChatPie;
      }
    }
    catch (Exception paramBaseChatPie)
    {
      QLog.d("PlusPanelViewModel", 1, paramBaseChatPie, new Object[0]);
    }
    return null;
  }
  
  public MutableLiveData<ArrayList<PluginData>> a()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  PlusPanelAppInfo a(int paramInt)
  {
    return ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramInt);
  }
  
  public List<PlusPanelAppInfo> a(BaseChatPie paramBaseChatPie)
  {
    if (((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a != null)
    {
      ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a.a(paramBaseChatPie);
      return ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a.a();
    }
    return new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a().observe(paramLifecycleOwner, new PlusPanelViewModel.3(this));
  }
  
  void a(SessionInfo paramSessionInfo, PlusPanelAppInfo paramPlusPanelAppInfo, QQAppInterface paramQQAppInterface)
  {
    if (!((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      TroopAppMgr localTroopAppMgr = (TroopAppMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_APP_MGR);
      if (paramPlusPanelAppInfo.redPoint)
      {
        AioGroupAppsManager.a(paramQQAppInterface).a(paramPlusPanelAppInfo.getAppID());
        ThreadManager.excute(new PlusPanelViewModel.2(this, localTroopAppMgr, paramPlusPanelAppInfo), 128, null, false);
      }
      boolean bool = paramPlusPanelAppInfo.canRemove;
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramPlusPanelAppInfo.getAppID(), bool);
      if (localTroopAppMgr != null) {
        localTroopAppMgr.a(paramPlusPanelAppInfo.getAppID(), false, paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramBaseChatPie, this.c);
    this.jdField_a_of_type_Int = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramBaseChatPie.getClass());
  }
  
  public void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(paramInt);
      return;
      d(paramBaseChatPie);
      continue;
      e(paramBaseChatPie);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, PluginData paramPluginData)
  {
    if (a(paramBaseChatPie)) {}
    SessionInfo localSessionInfo;
    PlusPanelAppInfo localPlusPanelAppInfo;
    do
    {
      return;
      localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      localPlusPanelAppInfo = a(paramPluginData.jdField_b_of_type_Int);
    } while (localPlusPanelAppInfo == null);
    if (localSessionInfo.jdField_a_of_type_Int == 1) {}
    b(paramBaseChatPie, localPlusPanelAppInfo.getRedDotID());
    b(paramBaseChatPie, paramPluginData);
    paramBaseChatPie.aZ();
    localPlusPanelAppInfo.handlePanelClick(this, paramBaseChatPie, localSessionInfo);
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localSessionInfo.jdField_a_of_type_Int == 1001) || (localSessionInfo.jdField_a_of_type_Int == 10002)) {
      if (localSessionInfo.jdField_a_of_type_Int == 1001)
      {
        paramPluginData = "0";
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramPluginData, ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(localPlusPanelAppInfo.getAppID()), "", "");
      }
    }
    for (;;)
    {
      b(paramBaseChatPie);
      return;
      paramPluginData = "1";
      break;
      if (localSessionInfo.jdField_a_of_type_Int == 1) {
        a(localSessionInfo, localPlusPanelAppInfo, localQQAppInterface);
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<PluginData> paramList, int paramInt)
  {
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramList, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      c(paramBaseChatPie);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 2) {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 7);
    ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1106717414) {
      TroopReportor.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    TroopReportor.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Clk");
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, PluginData paramPluginData)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (!TextUtils.isEmpty(paramPluginData.c)) {
      a(paramInt, paramPluginData, localRedTouchManager);
    }
    int j;
    label103:
    int k;
    label111:
    boolean bool;
    if ((paramPluginData.jdField_b_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramPluginData.jdField_b_of_type_Int))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramPluginData.jdField_b_of_type_Int));
      if ((paramInt != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramString))) {
        break label180;
      }
      i = 1;
      if (paramInt != 3000) {
        break label186;
      }
      j = 1;
      if (paramInt != 1) {
        break label192;
      }
      k = 1;
      bool = a(paramInt);
      if (i == 0) {
        break label198;
      }
      paramInt = 1;
      label125:
      j = paramPluginData.jdField_b_of_type_Int;
      if (!paramPluginData.jdField_a_of_type_Boolean) {
        break label233;
      }
    }
    label180:
    label186:
    label192:
    label198:
    label233:
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46B", "0X800A46B", j, i, String.valueOf(paramInt), "", "", "");
      return;
      i = 0;
      break;
      j = 0;
      break label103;
      k = 0;
      break label111;
      if (j != 0)
      {
        paramInt = 2;
        break label125;
      }
      if (k != 0)
      {
        paramInt = 3;
        break label125;
      }
      if (bool)
      {
        paramInt = 4;
        break label125;
      }
      paramInt = 5;
      break label125;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, PluginData paramPluginData)
  {
    int k = 0;
    int i;
    int j;
    label44:
    boolean bool;
    if (paramPluginData.jdField_b_of_type_Int > 0)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label120;
      }
      i = 1;
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        break label126;
      }
      j = 1;
      bool = a(paramSessionInfo.jdField_a_of_type_Int);
      if (i == 0) {
        break label132;
      }
      i = 1;
    }
    for (;;)
    {
      int m = paramPluginData.jdField_b_of_type_Int;
      j = k;
      if (paramPluginData.jdField_a_of_type_Boolean) {
        j = 1;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46C", "0X800A46C", m, j, String.valueOf(i), "", "", "");
      return;
      label120:
      i = 0;
      break;
      label126:
      j = 0;
      break label44;
      label132:
      if (j != 0) {
        i = 2;
      } else if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = 3;
      } else if (bool) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {}
    for (localObject = ((TroopManager)localObject).b(paramString);; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = "" + ((TroopInfo)localObject).dwGroupClassExt;; localObject = "")
      {
        ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        return;
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, List<PluginData> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelViewModel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt2), " Stack: ", FeedUtils.a(5) });
    }
    paramList = paramList.iterator();
    label316:
    while (paramList.hasNext())
    {
      PluginData localPluginData = (PluginData)paramList.next();
      a(paramQQAppInterface, paramInt1, paramString, localPluginData);
      switch (localPluginData.jdField_b_of_type_Int)
      {
      }
      for (;;)
      {
        if (localPluginData.jdField_b_of_type_Int != 209) {
          break label316;
        }
        ReportController.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
        break;
        TroopReportor.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Show");
        continue;
        TroopReportor.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Show");
        continue;
        a(paramQQAppInterface, paramString);
        ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
        continue;
        ApolloDtReportUtil.a("aio", "plus_panel", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramQQAppInterface)).b(ApolloDtReportUtil.a(paramInt1)).b(paramString).a());
      }
    }
    if (paramInt2 == this.jdField_b_of_type_Int) {
      TroopGiftPanel.b(paramInt2, this.jdField_a_of_type_Int);
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramInt);
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, paramString, str, "", "");
    }
    if ((paramBoolean) && (paramInt != 0)) {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, paramString, String.valueOf(paramInt), "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramString1, paramString2);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a(int paramInt)
  {
    int[] arrayOfInt = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramBaseChatPie);
    if ((paramBaseChatPie != null) && (!paramBaseChatPie.isEmpty())) {
      ThreadManagerV2.getUIHandlerV2().post(new PlusPanelViewModel.1(this, paramBaseChatPie));
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        ((TroopChatPie)paramBaseChatPie).bw();
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label32;
      }
      if (!QLog.isColorLevel()) {}
    }
    return;
    label32:
    this.jdField_a_of_type_Boolean = false;
    String str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((((TroopManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      QQToast.a(paramBaseChatPie.a(), TroopConfessUtil.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    f(paramBaseChatPie);
  }
  
  public void c(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie);
    b(paramBaseChatPie);
  }
  
  void d(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  void e(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
    }
    paramBaseChatPie = a(paramBaseChatPie);
    if (paramBaseChatPie != null) {
      b(paramBaseChatPie);
    }
  }
  
  void f(BaseChatPie paramBaseChatPie)
  {
    if ((a(1106865772) != null) && (!TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")))
    {
      String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", NearbyURLSafeUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      Intent localIntent = paramBaseChatPie.a().getIntent();
      localIntent.putExtra("url", str);
      localIntent.putExtra("confess_half_screen_web", true);
      if ((paramBaseChatPie instanceof TroopChatPie)) {
        this.jdField_b_of_type_Boolean = TroopConfessUtil.a(paramBaseChatPie);
      }
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1106865772, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel
 * JD-Core Version:    0.7.0.1
 */