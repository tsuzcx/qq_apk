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
import com.tencent.mobileqq.activity.ChatActivityUtils;
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
  public static ViewModelProvider.Factory e = new PlusPanelViewModel.4();
  boolean a = false;
  boolean b = false;
  int c = 0;
  public int d = -1;
  private final List<Integer> f = new ArrayList();
  private final MutableLiveData<Boolean> g = new MutableLiveData();
  private final MutableLiveData<ArrayList<PluginData>> h = new MutableLiveData();
  private boolean i = false;
  
  public PlusPanelViewModel(PlusPanelRepository paramPlusPanelRepository)
  {
    super(paramPlusPanelRepository);
  }
  
  private void a(int paramInt, PluginData paramPluginData, IRedTouchManager paramIRedTouchManager)
  {
    paramPluginData = paramIRedTouchManager.getAppInfoFilterByID(10, paramPluginData.f, paramPluginData.i);
    if (paramPluginData != null) {
      paramIRedTouchManager.reportLevelOneRedInfo(paramPluginData.uiAppId.get(), 30);
    }
  }
  
  private void b(LifecycleOwner paramLifecycleOwner)
  {
    MutableLiveData localMutableLiveData = this.h;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    localMutableLiveData = this.g;
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
    localMutableLiveData = ((PlusPanelRepository)this.z).a();
    if (localMutableLiveData != null) {
      localMutableLiveData.removeObservers(paramLifecycleOwner);
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt > 0)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramBaseChatPie.d.getRuntimeService(IRedTouchManager.class, "");
      paramBaseChatPie = localIRedTouchManager.getAppInfoFilterByID(10, String.valueOf(paramInt), paramBaseChatPie.ah.c);
      if (paramBaseChatPie != null) {
        localIRedTouchManager.reportLevelOneRedInfo(paramBaseChatPie.uiAppId.get(), 31);
      }
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, PluginData paramPluginData)
  {
    a(paramBaseChatPie.d, paramBaseChatPie.ah, paramPluginData);
  }
  
  private void c(int paramInt)
  {
    if (paramInt <= 7) {
      return;
    }
    Object localObject = ((PlusPanelRepository)this.z).c();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PlusPanelAppInfo)((Iterator)localObject).next()).onChatPieLifeCycle(paramInt);
      }
    }
  }
  
  private boolean i(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.ah.a != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)paramBaseChatPie.d.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.F(paramBaseChatPie.ah.c))
    {
      localTroopManager.E(paramBaseChatPie.ah.c);
      return true;
    }
    return false;
  }
  
  PlusPanelAppInfo a(int paramInt)
  {
    return ((PlusPanelRepository)this.z).c(paramInt);
  }
  
  public void a()
  {
    this.f.clear();
  }
  
  public void a(LifecycleOwner paramLifecycleOwner)
  {
    ((PlusPanelRepository)this.z).a().observe(paramLifecycleOwner, new PlusPanelViewModel.3(this));
  }
  
  void a(SessionInfo paramSessionInfo, PlusPanelAppInfo paramPlusPanelAppInfo, QQAppInterface paramQQAppInterface)
  {
    if (!((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramSessionInfo.b))
    {
      ITroopAppService localITroopAppService = (ITroopAppService)paramQQAppInterface.getRuntimeService(ITroopAppService.class, "all");
      if (paramPlusPanelAppInfo.redPoint)
      {
        ((ITroopAioAppService)paramQQAppInterface.getRuntimeService(ITroopAioAppService.class, "")).requestClearRedDot(paramPlusPanelAppInfo.getAppID());
        ThreadManager.excute(new PlusPanelViewModel.2(this, localITroopAppService, paramPlusPanelAppInfo), 128, null, false);
      }
      boolean bool = paramPlusPanelAppInfo.canRemove;
      a(paramQQAppInterface, paramSessionInfo.b, paramPlusPanelAppInfo.getAppID(), bool);
      int j = paramPlusPanelAppInfo.getAppID();
      if ((localITroopAppService != null) && (j > 0))
      {
        localITroopAppService.addReportClick(j, false, paramSessionInfo.b);
        new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("add_page").d("Clk_app").a(new String[] { paramSessionInfo.b }).a(new String[] { String.valueOf(j) }).a(new String[] { "1" }).a();
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    ((PlusPanelRepository)this.z).a(paramBaseChatPie, this.i);
    this.c = ((PlusPanelRepository)this.z).a(paramBaseChatPie.getClass());
  }
  
  public void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt == 15) {
        f(paramBaseChatPie);
      }
    }
    else {
      e(paramBaseChatPie);
    }
    c(paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, PluginData paramPluginData)
  {
    if (i(paramBaseChatPie)) {
      return;
    }
    SessionInfo localSessionInfo = paramBaseChatPie.ah;
    PlusPanelAppInfo localPlusPanelAppInfo = a(paramPluginData.b);
    if (localPlusPanelAppInfo != null)
    {
      int j = localSessionInfo.a;
      b(paramBaseChatPie, localPlusPanelAppInfo.getRedDotID());
      b(paramBaseChatPie, paramPluginData);
      ((AIOZhituHelper)paramBaseChatPie.q(116)).a();
      localPlusPanelAppInfo.handlePanelClick(this, paramBaseChatPie, localSessionInfo);
      QQAppInterface localQQAppInterface = paramBaseChatPie.d;
      if ((localSessionInfo.a != 1001) && (localSessionInfo.a != 10002))
      {
        if (localSessionInfo.a == 1) {
          a(localSessionInfo, localPlusPanelAppInfo, localQQAppInterface);
        }
      }
      else
      {
        if (localSessionInfo.a == 1001) {
          paramPluginData = "0";
        } else {
          paramPluginData = "1";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramPluginData, ((PlusPanelRepository)this.z).b(localPlusPanelAppInfo.getAppID()), "", "");
      }
      b(paramBaseChatPie);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, List<PluginData> paramList, int paramInt)
  {
    a(paramBaseChatPie.d, paramBaseChatPie.ah.b, paramBaseChatPie.ah.a, paramList, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      d(paramBaseChatPie);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int j = this.c;
    if (j == 2)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
      return;
    }
    if (j == 6)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      return;
    }
    if (j == 7) {
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
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if (!TextUtils.isEmpty(paramPluginData.f)) {
      a(paramInt, paramPluginData, localIRedTouchManager);
    }
    if ((paramPluginData.b > 0) && (!this.f.contains(Integer.valueOf(paramPluginData.b))))
    {
      this.f.add(Integer.valueOf(paramPluginData.b));
      int m = 0;
      int n = 1;
      if ((paramInt != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramString))) {
        j = 0;
      } else {
        j = 1;
      }
      int k;
      if (paramInt == 3000) {
        k = 1;
      } else {
        k = 0;
      }
      if (paramInt == 1) {
        m = 1;
      }
      boolean bool = b(paramInt);
      if (j != 0) {
        paramInt = n;
      } else if (k != 0) {
        paramInt = 2;
      } else if (m != 0) {
        paramInt = 3;
      } else if (bool) {
        paramInt = 4;
      } else {
        paramInt = 5;
      }
      int j = paramPluginData.b;
      if (paramPluginData.c) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46B", "0X800A46B", j, 0, paramString, String.valueOf(paramInt), "", "");
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, PluginData paramPluginData)
  {
    if (paramPluginData.b > 0)
    {
      int j = paramSessionInfo.a;
      int k = 0;
      int m = 1;
      if ((j != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.b))) {
        j = 0;
      } else {
        j = 1;
      }
      if (paramSessionInfo.a == 3000) {
        k = 1;
      }
      boolean bool = b(paramSessionInfo.a);
      if (j != 0) {
        j = m;
      } else if (k != 0) {
        j = 2;
      } else if (paramSessionInfo.a == 1) {
        j = 3;
      } else if (bool) {
        j = 4;
      } else {
        j = 5;
      }
      k = paramPluginData.b;
      if (paramPluginData.c) {
        paramSessionInfo = "1";
      } else {
        paramSessionInfo = "0";
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46C", "0X800A46C", k, 0, paramSessionInfo, String.valueOf(j), "", "");
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null) {
      localObject = ((TroopManager)localObject).f(paramString);
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
      switch (paramList.b)
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
          localIApolloDtReportHelper.report("aio", "plus_panel", "expose", new DtReportParamsBuilder().a(localIApolloDtReportHelper.getApolloMode(paramQQAppInterface)).b(localIApolloDtReportHelper.getReportSessionType(paramInt1)).c(paramString).a());
        }
      }
      if (paramList.b == 209) {
        ReportController.b(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
      }
    }
    if (paramInt2 == this.d) {
      TroopGiftPanel.a(paramInt2, this.c);
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = ((PlusPanelRepository)this.z).a(paramInt);
    if (!TextUtils.isEmpty(str)) {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, paramString, str, "", "");
    }
    if ((paramBoolean) && (paramInt != 0)) {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, paramString, String.valueOf(paramInt), "", "");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((PlusPanelRepository)this.z).a(paramString1, paramString2);
    this.g.setValue(Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public MutableLiveData<ArrayList<PluginData>> b()
  {
    return this.h;
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = ((PlusPanelRepository)this.z).a(paramBaseChatPie);
    if ((paramBaseChatPie != null) && (!paramBaseChatPie.isEmpty())) {
      ThreadManagerV2.getUIHandlerV2().post(new PlusPanelViewModel.1(this, paramBaseChatPie));
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a) {
        ((TroopChatPie)paramBaseChatPie).bU();
      } else {
        return;
      }
    }
    if (this.b)
    {
      QLog.isColorLevel();
      return;
    }
    this.a = false;
    String str = paramBaseChatPie.ah.b;
    int j;
    if ((((TroopManager)paramBaseChatPie.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(str).dwGroupFlagExt3 & 0x2000) == 0L) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      QQToast.makeText(paramBaseChatPie.aX(), TroopConfessUtil.a, 0).show();
      return;
    }
    h(paramBaseChatPie);
  }
  
  boolean b(int paramInt)
  {
    int[] arrayOfInt = ((PlusPanelRepository)this.z).b();
    int k = arrayOfInt.length;
    int j = 0;
    while (j < k)
    {
      if (arrayOfInt[j] == paramInt) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public MutableLiveData<Boolean> c()
  {
    return this.g;
  }
  
  public List<PlusPanelAppInfo> c(BaseChatPie paramBaseChatPie)
  {
    if (((PlusPanelRepository)this.z).a != null)
    {
      ((PlusPanelRepository)this.z).a.a(paramBaseChatPie);
      return ((PlusPanelRepository)this.z).a.a();
    }
    return new ArrayList();
  }
  
  public void d(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie);
    b(paramBaseChatPie);
  }
  
  void e(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      this.b = false;
    }
  }
  
  void f(BaseChatPie paramBaseChatPie)
  {
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      this.b = false;
      this.a = false;
    }
    paramBaseChatPie = g(paramBaseChatPie);
    if (paramBaseChatPie != null) {
      b(paramBaseChatPie);
    }
  }
  
  LifecycleOwner g(BaseChatPie paramBaseChatPie)
  {
    try
    {
      paramBaseChatPie = (QBaseFragment)paramBaseChatPie.f.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_Fragment");
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
  
  void h(BaseChatPie paramBaseChatPie)
  {
    if ((a(1106865772) != null) && (!TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")))
    {
      String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", NearbyURLSafeUtil.b(paramBaseChatPie.ah.b));
      Intent localIntent = paramBaseChatPie.aX().getIntent();
      localIntent.putExtra("url", str);
      localIntent.putExtra("confess_half_screen_web", true);
      if ((paramBaseChatPie instanceof TroopChatPie)) {
        this.b = TroopConfessUtil.a(paramBaseChatPie);
      }
      a(paramBaseChatPie.d, 1106865772, paramBaseChatPie.ah.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel
 * JD-Core Version:    0.7.0.1
 */