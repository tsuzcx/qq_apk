package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dt.DtAIOReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XEditTextEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.AppRuntime;

public class AIODtReportHelper
  implements OnFinishListener, ILifeCycleHelper
{
  @NonNull
  protected final BaseChatPie a;
  @Nullable
  protected SessionInfo b;
  protected QQAppInterface c;
  @Nullable
  protected View d;
  private int e;
  private int f;
  private int g;
  private boolean h = false;
  private long i = 0L;
  private long j;
  private boolean k;
  
  public AIODtReportHelper(@NonNull BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public static int a(int paramInt)
  {
    int m = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 1000) && (paramInt != 1001))
        {
          if (paramInt != 1008)
          {
            if ((paramInt == 1009) || (paramInt == 1020)) {
              break label161;
            }
            if (paramInt != 3000)
            {
              if ((paramInt == 10002) || (paramInt == 10004) || (paramInt == 10008) || (paramInt == 10010) || (paramInt == 10013)) {
                break label161;
              }
              if (paramInt == 10014) {}
            }
          }
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return 5;
              return 6;
              return 4;
              return 3;
            }
            break;
          }
        }
        label161:
        return 2;
      }
      m = 0;
    }
    return m;
  }
  
  private GroupCatalogBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), paramString);
    if (localGroupCatalogBean != null)
    {
      paramString = localGroupCatalogBean;
      if (localGroupCatalogBean.a > 2)
      {
        paramString = localGroupCatalogBean;
        if (localGroupCatalogBean.e != null) {
          paramString = a(localGroupCatalogBean.e.c);
        }
      }
      return paramString;
    }
    return null;
  }
  
  private void a(int paramInt, Map<String, String> paramMap)
  {
    if (paramInt != 0) {
      return;
    }
    a(paramMap);
  }
  
  private static void a(View paramView, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(SessionInfo paramSessionInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type_aio_pg", String.valueOf(a(paramSessionInfo.a)));
    localHashMap.put("uin_to", paramSessionInfo.b);
    localHashMap.put("cur_time", paramString);
    localHashMap.put("A8", p());
    UserAction.onUserAction("qq_aio_setting_click", true, 0L, 0L, localHashMap, true, true);
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("reportClickSetting: params = ");
    paramSessionInfo.append(localHashMap.toString());
    QLog.d("AIODtReportHelper_850_reportEvent", 1, paramSessionInfo.toString());
  }
  
  private static void a(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie.W);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_more_panel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    int m;
    if (((IRedTouchManager)paramBaseChatPie.i().getRuntimeService(IRedTouchManager.class, "")).getRedTouchInfoByAppSet(10) != null) {
      m = 1;
    } else {
      m = 0;
    }
    VideoReport.setElementParam(paramView, "is_red_tips_before", Integer.valueOf(m));
  }
  
  public static void a(PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    int i1 = paramPanelIconLinearLayout.getChildCount();
    int m = 0;
    while (m < i1)
    {
      Object localObject = paramPanelIconLinearLayout.getChildAt(m);
      int i2 = ((Integer)((View)localObject).getTag()).intValue();
      String str = DtAIOReportUtil.a(i2);
      boolean bool1 = TextUtils.isEmpty(str);
      int n = 1;
      if (bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIODtReportHelper", 2, new Object[] { "[initChatPanelIconReportData]", " tag: ", Integer.valueOf(i2), " has not register dt report id" });
        }
      }
      else
      {
        if ((localObject instanceof RedDotImageView)) {
          bool1 = ((RedDotImageView)localObject).a();
        } else {
          bool1 = false;
        }
        boolean bool2;
        if ((localObject instanceof RedTouch))
        {
          localObject = (RedTouch)localObject;
          bool2 = ((RedTouch)localObject).h();
          localObject = ((RedTouch)localObject).getTarget();
          bool1 = false;
        }
        else
        {
          boolean bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIODtReportHelper", 2, new Object[] { "[initChatPanelIconReportData] register panel icon: ", Integer.valueOf(i2), "isOldRedDotSystem: ", Boolean.valueOf(bool1), " isShowing red dot: ", Boolean.valueOf(bool2) });
        }
        VideoReport.setElementId(localObject, str);
        VideoReport.setElementClickPolicy(localObject, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(localObject, ExposurePolicy.REPORT_NONE);
        if (!bool2) {
          n = 0;
        }
        VideoReport.setElementParam(localObject, "is_red_tips_em", Integer.valueOf(n));
        a((View)localObject, i2);
      }
      m += 1;
    }
  }
  
  public static void a(PhotoListPanel paramPhotoListPanel)
  {
    VideoReport.setElementId(paramPhotoListPanel, "em_aio_photo_panel");
    VideoReport.setElementExposePolicy(paramPhotoListPanel, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementParam(paramPhotoListPanel, "is_red_tips_before", Integer.valueOf(0));
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    ThreadManagerV2.excute(new AIODtReportHelper.1(this, paramTroopInfo), 64, null, false);
  }
  
  private void a(Map<String, String> paramMap)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((SessionInfo)localObject).b;
    localObject = ((ITroopInfoService)this.c.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo((String)localObject);
    a((TroopInfo)localObject);
    a(paramMap, (TroopInfo)localObject);
  }
  
  private void a(Map<String, String> paramMap, TroopInfo paramTroopInfo)
  {
    String str = this.c.getCurrentUin();
    int m;
    if (paramTroopInfo.isTroopOwner(str)) {
      m = 1;
    } else if (paramTroopInfo.isTroopAdmin(str)) {
      m = 2;
    } else if (((ITroopInfoService)this.c.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramTroopInfo.troopuin) == null) {
      m = 4;
    } else {
      m = 3;
    }
    paramMap.put("group_uin_type", String.valueOf(m));
    VideoReport.setPageParams(this.d, new PageParams(paramMap));
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5) {
          return 3;
        }
        return 1;
      }
      return 0;
    }
    return 2;
  }
  
  private void b(Map<String, String> paramMap)
  {
    VideoReport.setPageParams(this.a.aW(), new PageParams(paramMap));
  }
  
  private void e(View paramView)
  {
    a(paramView, "em_return_button_aio_pg");
  }
  
  private int f(int paramInt)
  {
    int m = paramInt;
    if (paramInt != 0)
    {
      m = paramInt;
      if (paramInt != 1)
      {
        m = paramInt;
        if (paramInt != 2)
        {
          m = paramInt;
          if (paramInt != 3) {
            m = 14;
          }
        }
      }
    }
    return m;
  }
  
  private void f()
  {
    m();
    a(this.a);
    g();
  }
  
  private void g()
  {
    this.a.bv().d().a(this);
  }
  
  private void h()
  {
    this.c = this.a.d;
    this.b = this.a.aE();
    this.g = 999;
    Intent localIntent = this.a.f.getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      this.g = localIntent.getExtras().getInt("aio_msg_source", 999);
    }
    this.j = System.nanoTime();
    this.e = 0;
    this.f = 0;
    VideoReport.resetPageParams(this.a.aW());
  }
  
  private void i()
  {
    if (!this.k) {
      k();
    }
  }
  
  private void j()
  {
    this.k = false;
    this.i = SystemClock.elapsedRealtime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStart: mOnStartT = ");
    localStringBuilder.append(this.i);
    QLog.d("AIODtReportHelper", 1, localStringBuilder.toString());
  }
  
  private void k()
  {
    ViewGroup localViewGroup = this.a.aW();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("aio_disappear_type", "3");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(n());
    localStringBuilder.append("");
    localTreeMap.put("aio_send_msg_cnt", localStringBuilder.toString());
    this.e = 0;
    this.f = 0;
    VideoReport.setPageParams(localViewGroup, new PageParams(localTreeMap));
  }
  
  private void l()
  {
    if (this.i > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("stay_time", String.valueOf(SystemClock.elapsedRealtime() - this.i));
      localHashMap.put("cur_time", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      localHashMap.put("is_return", String.valueOf(this.h ^ true));
      localHashMap.put("source_aio_appear", String.valueOf(f(this.g)));
      String str = p();
      localHashMap.put("A8", str);
      Object localObject = this.b;
      if (localObject != null)
      {
        localHashMap.put("type_aio_pg", String.valueOf(a(((SessionInfo)localObject).a)));
        localHashMap.put("uin_to", this.b.b);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStop report show: params = ");
      ((StringBuilder)localObject).append(localHashMap.toString());
      QLog.d("AIODtReportHelper_850_reportEvent", 1, ((StringBuilder)localObject).toString());
      QQBeaconReport.a(str, "qq_aio_pg_in", true, localHashMap, true);
    }
    else
    {
      QLog.d("AIODtReportHelper", 1, "onStop: mOnStartT = 0");
    }
    this.h = false;
    this.i = 0L;
  }
  
  private void m()
  {
    View localView = this.a.bv().p().d().c().a();
    a(localView, "em_aio_textbox_amazing_button");
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_NONE);
  }
  
  private int n()
  {
    int n = this.e;
    int i1 = f(this.g);
    int m;
    if (i1 != 4)
    {
      m = n;
      if (i1 != 0) {}
    }
    else
    {
      m = n / 2;
    }
    return m;
  }
  
  private void o()
  {
    boolean bool = false;
    if (this.d == null) {
      bool = true;
    }
    QLog.d("AIODtReportHelper", 1, new Object[] { "doOnDestroy: mRootView = null ? ", Boolean.valueOf(bool) });
    View localView = this.d;
    if (localView != null)
    {
      VideoReport.pageLogicDestroy(localView);
      this.d = null;
    }
  }
  
  private static String p()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    String str2 = "0";
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).peekAppRuntime();
      str1 = str2;
      if (localObject != null)
      {
        str1 = ((AppRuntime)localObject).getAccount();
        if (TextUtils.isEmpty(str1)) {
          return "0";
        }
      }
    }
    return str1;
  }
  
  protected void a()
  {
    this.h = true;
    h();
    VideoReport.addToDetectionWhitelist(this.a.f);
    ViewGroup localViewGroup = this.a.aW();
    this.d = localViewGroup;
    b(localViewGroup);
    a(localViewGroup);
    this.i = SystemClock.elapsedRealtime();
    QLog.d("AIODtReportHelper", 1, new Object[] { "doOnAioCreate, mOnStartT = ", Long.valueOf(this.i) });
  }
  
  protected void a(View paramView)
  {
    View localView1 = paramView.findViewById(2131436666);
    View localView2 = paramView.findViewById(2131436180);
    View localView3 = paramView.findViewById(2131437136);
    View localView4 = paramView.findViewById(2131448219);
    paramView = paramView.findViewById(2131436194);
    e(localView1);
    e(localView2);
    e(localView3);
    e(localView4);
    c(paramView);
  }
  
  protected void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    Object localObject2 = new TreeMap();
    Object localObject3 = this.a.Y.getText().toString();
    int m = DtAIOReportUtil.a((String)localObject3);
    if (m > 0) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject2).put("is_text_with_stickers", localObject1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((String)localObject3).length() - m * 2);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("number_text_send", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("type_aio_pg", String.valueOf(this.b.C));
    ((Map)localObject2).put("uin_to", this.b.b);
    ((Map)localObject2).put("source_aio_appear", String.valueOf(f(this.g)));
    ((Map)localObject2).put("aio_session_time", String.valueOf(this.j));
    VideoReport.reportEvent("aio_textbox_send", (Map)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getKey());
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append((String)((Map.Entry)localObject3).getValue());
        ((StringBuilder)localObject1).append("|");
      }
      QLog.d("AIODtReportHelper", 2, new Object[] { "[doDtFunBtnClickReport] params: ", ((StringBuilder)localObject1).toString() });
    }
  }
  
  protected void b(View paramView)
  {
    VideoReport.resetPageParams(paramView);
    HashMap localHashMap = new HashMap();
    int m = f(this.g);
    localHashMap.put("source_aio_appear", String.valueOf(m));
    localHashMap.put("aio_session_time", String.valueOf(this.j));
    Object localObject = this.b;
    if (localObject != null)
    {
      int n = a(((SessionInfo)localObject).a);
      a(n, localHashMap);
      localHashMap.put("type_aio_pg", String.valueOf(n));
      localHashMap.put("uin_to", this.b.b);
      QLog.d("AIODtReportHelper_QQDtReporter", 1, new Object[] { "setViewReport, curType = ", Integer.valueOf(this.b.a), ", exUinType = ", Integer.valueOf(n), ", curUin = ", this.b.b, ", mMsgSource = ", Integer.valueOf(this.g), ", exMsgSource = ", Integer.valueOf(m) });
    }
    else
    {
      QLog.d("AIODtReportHelper", 1, "setViewReport, but session is null");
    }
    localHashMap.put("aio_disappear_type", "3");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("");
    localHashMap.put("aio_recv_msg_cnt", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("");
    localHashMap.put("aio_send_msg_cnt", ((StringBuilder)localObject).toString());
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    VideoReport.setPageId(this.d, "pg_aio");
    VideoReport.setPageContentId(this.d, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.k = true;
    Object localObject = this.a.aW();
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramInt));
    localStringBuilder.append("");
    localTreeMap.put("aio_disappear_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(n());
    localStringBuilder.append("");
    localTreeMap.put("aio_send_msg_cnt", localStringBuilder.toString());
    VideoReport.setPageParams(localObject, new PageParams(localTreeMap));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onExitAIO] set send: ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(", recv: ");
    ((StringBuilder)localObject).append(this.f);
    QLog.d("AIODtReportHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  protected void c(View paramView)
  {
    a(paramView, "em_setting_banner_aio_pg");
  }
  
  public void d()
  {
    this.f += 1;
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    b(localTreeMap);
  }
  
  public void d(View paramView)
  {
    a(paramView, "em_aio_textbox_amazing_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementParam(paramView, "text_in_textbox", this.a.Y.getText().toString());
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e()
  {
    this.e += 1;
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n());
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    b(localTreeMap);
  }
  
  public void e(int paramInt)
  {
    c(paramInt);
  }
  
  @NonNull
  public String getTag()
  {
    return "AIODtReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 5, 9, 11, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15)
          {
            if (paramInt != 11)
            {
              if (paramInt != 12) {
                return;
              }
              l();
              return;
            }
            i();
            return;
          }
          o();
          return;
        }
        f();
        return;
      }
      j();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper
 * JD-Core Version:    0.7.0.1
 */