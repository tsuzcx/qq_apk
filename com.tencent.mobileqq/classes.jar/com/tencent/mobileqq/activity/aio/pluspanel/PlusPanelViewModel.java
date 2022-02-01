package com.tencent.mobileqq.activity.aio.pluspanel;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOZhituHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QBaseFragment;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.utils.TroopReportor;
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
  private final MutableLiveData<Boolean> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private final List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private final MutableLiveData<ArrayList<PluginData>> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
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
    if (paramInt <= 7) {
      return;
    }
    Object localObject = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlusPanelAppInfo)((Iterator)localObject).next()).onChatPieLifeCycle(paramInt);
      }
    }
  }
  
  private void a(int paramInt, PluginData paramPluginData, IRedTouchManager paramIRedTouchManager)
  {
    paramPluginData = paramIRedTouchManager.getAppInfoFilterByID(10, paramPluginData.c, paramPluginData.f);
    if (paramPluginData != null) {
      paramIRedTouchManager.reportLevelOneRedInfo(paramPluginData.uiAppId.get(), 30);
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.g(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b))
    {
      localTroopManager.h(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      return true;
    }
    return false;
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    MutableLiveData localMutableLiveData = this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    localMutableLiveData = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    localMutableLiveData = ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt > 0)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      paramBaseChatPie = localIRedTouchManager.getAppInfoFilterByID(10, String.valueOf(paramInt), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      if (paramBaseChatPie != null) {
        localIRedTouchManager.reportLevelOneRedInfo(paramBaseChatPie.uiAppId.get(), 31);
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
      paramBaseChatPie = (QBaseFragment)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_Fragment");
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
      ITroopAppService localITroopAppService = (ITroopAppService)paramQQAppInterface.getRuntimeService(ITroopAppService.class, "all");
      if (paramPlusPanelAppInfo.redPoint)
      {
        ((ITroopAioAppService)paramQQAppInterface.getRuntimeService(ITroopAioAppService.class, "")).requestClearRedDot(paramPlusPanelAppInfo.getAppID());
        ThreadManager.excute(new PlusPanelViewModel.2(this, localITroopAppService, paramPlusPanelAppInfo), 128, null, false);
      }
      boolean bool = paramPlusPanelAppInfo.canRemove;
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramPlusPanelAppInfo.getAppID(), bool);
      int i = paramPlusPanelAppInfo.getAppID();
      if ((localITroopAppService != null) && (i > 0))
      {
        localITroopAppService.addReportClick(i, false, paramSessionInfo.jdField_a_of_type_JavaLangString);
        new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("add_page").d("Clk_app").a(new String[] { paramSessionInfo.jdField_a_of_type_JavaLangString }).a(new String[] { String.valueOf(i) }).a(new String[] { "1" }).a();
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
    if (paramInt != 7)
    {
      if (paramInt == 15) {
        e(paramBaseChatPie);
      }
    }
    else {
      d(paramBaseChatPie);
    }
    a(paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, PluginData paramPluginData)
  {
    if (a(paramBaseChatPie)) {
      return;
    }
    SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    PlusPanelAppInfo localPlusPanelAppInfo = a(paramPluginData.jdField_b_of_type_Int);
    if (localPlusPanelAppInfo != null)
    {
      int i = localSessionInfo.jdField_a_of_type_Int;
      b(paramBaseChatPie, localPlusPanelAppInfo.getRedDotID());
      b(paramBaseChatPie, paramPluginData);
      ((AIOZhituHelper)paramBaseChatPie.a(116)).a();
      localPlusPanelAppInfo.handlePanelClick(this, paramBaseChatPie, localSessionInfo);
      QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((localSessionInfo.jdField_a_of_type_Int != 1001) && (localSessionInfo.jdField_a_of_type_Int != 10002))
      {
        if (localSessionInfo.jdField_a_of_type_Int == 1) {
          a(localSessionInfo, localPlusPanelAppInfo, localQQAppInterface);
        }
      }
      else
      {
        if (localSessionInfo.jdField_a_of_type_Int == 1001) {
          paramPluginData = "0";
        } else {
          paramPluginData = "1";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramPluginData, ((PlusPanelRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(localPlusPanelAppInfo.getAppID()), "", "");
      }
      b(paramBaseChatPie);
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
    int i = this.jdField_a_of_type_Int;
    if (i == 2)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
      return;
    }
    if (i == 6)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      return;
    }
    if (i == 7) {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 1106717414)
    {
      TroopReportor.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Clk");
      return;
    }
    if (paramInt == 1106729451) {
      TroopReportor.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Clk");
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, PluginData paramPluginData)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, PluginData paramPluginData)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      localObject = ((TroopManager)localObject).b(paramString);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((TroopInfo)localObject).dwGroupClassExt);
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((String)localObject);
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009E24", "0X8009E24", 0, 0, "", "", localStringBuilder.toString(), "");
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, List<PluginData> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanelViewModel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt2), " Stack: ", FeedUtils.a(5) });
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (PluginData)localIterator.next();
      a(paramQQAppInterface, paramInt1, paramString, paramList);
      switch (paramList.jdField_b_of_type_Int)
      {
      }
      for (;;)
      {
        break;
        TroopReportor.a(paramQQAppInterface, paramString, "MassMessage", "grpapp_Show");
        continue;
        TroopReportor.a(paramQQAppInterface, paramString, "Grp_chain", "ChainEntry_Show");
        continue;
        a(paramQQAppInterface, paramString);
        ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
        for (;;)
        {
          break;
          IApolloDtReportHelper localIApolloDtReportHelper = (IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class);
          localIApolloDtReportHelper.report("aio", "plus_panel", "expose", new DtReportParamsBuilder().a(localIApolloDtReportHelper.getApolloMode(paramQQAppInterface)).b(localIApolloDtReportHelper.getReportSessionType(paramInt1)).b(paramString).a());
        }
      }
      if (paramList.jdField_b_of_type_Int == 209) {
        ReportController.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
      }
    }
    if (paramInt2 == this.jdField_b_of_type_Int) {
      TroopGiftPanel.a(paramInt2, this.jdField_a_of_type_Int);
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
    if (paramBoolean) {
      if (this.jdField_a_of_type_Boolean) {
        ((TroopChatPie)paramBaseChatPie).aC();
      } else {
        return;
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.isColorLevel();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    String str = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i;
    if ((((TroopManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel
 * JD-Core Version:    0.7.0.1
 */