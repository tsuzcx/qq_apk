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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  @NonNull
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  AIODtReportHelper(@NonNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 1000) && (paramInt != 1001))
        {
          if (paramInt != 1008)
          {
            if ((paramInt == 1009) || (paramInt == 1020)) {
              break label142;
            }
            if (paramInt != 3000) {
              if ((paramInt == 10002) || (paramInt == 10004) || (paramInt == 10008) || (paramInt == 10010)) {
                break label142;
              }
            }
          }
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return 5;
              return 4;
              return 3;
            }
            break;
          }
        }
        label142:
        return 2;
      }
      i = 0;
    }
    return i;
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
      if (localGroupCatalogBean.jdField_a_of_type_Int > 2)
      {
        paramString = localGroupCatalogBean;
        if (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) {
          paramString = a(localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.b);
        }
      }
      return paramString;
    }
    return null;
  }
  
  private static String a()
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
  
  private void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
  }
  
  public static void a(SessionInfo paramSessionInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type_aio_pg", String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)));
    localHashMap.put("uin_to", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("cur_time", paramString);
    localHashMap.put("A8", a());
    UserAction.onUserAction("qq_aio_setting_click", true, 0L, 0L, localHashMap, true, true);
    paramSessionInfo = new StringBuilder();
    paramSessionInfo.append("reportClickSetting: params = ");
    paramSessionInfo.append(localHashMap.toString());
    QLog.d("AIODtReportHelper_850_reportEvent", 1, paramSessionInfo.toString());
  }
  
  private static void a(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_more_panel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    int i;
    if (((IRedTouchManager)paramBaseChatPie.a().getRuntimeService(IRedTouchManager.class, "")).getRedTouchInfoByAppSet(10) != null) {
      i = 1;
    } else {
      i = 0;
    }
    VideoReport.setElementParam(paramView, "is_red_tips_before", Integer.valueOf(i));
  }
  
  public static void a(PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    int k = paramPanelIconLinearLayout.getChildCount();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramPanelIconLinearLayout.getChildAt(i);
      int m = ((Integer)((View)localObject).getTag()).intValue();
      String str = DtAIOReportUtil.a(m);
      boolean bool1 = TextUtils.isEmpty(str);
      int j = 1;
      if (bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIODtReportHelper", 2, new Object[] { "[initChatPanelIconReportData]", " tag: ", Integer.valueOf(m), " has not register dt report id" });
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
          bool2 = ((RedTouch)localObject).c();
          localObject = ((RedTouch)localObject).a();
          bool1 = false;
        }
        else
        {
          boolean bool3 = true;
          bool2 = bool1;
          bool1 = bool3;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIODtReportHelper", 2, new Object[] { "[initChatPanelIconReportData] register panel icon: ", Integer.valueOf(m), "isOldRedDotSystem: ", Boolean.valueOf(bool1), " isShowing red dot: ", Boolean.valueOf(bool2) });
        }
        VideoReport.setElementId(localObject, str);
        VideoReport.setElementClickPolicy(localObject, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(localObject, ExposurePolicy.REPORT_NONE);
        if (!bool2) {
          j = 0;
        }
        VideoReport.setElementParam(localObject, "is_red_tips_em", Integer.valueOf(j));
        a((View)localObject, m);
      }
      i += 1;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject == null) {
      return;
    }
    localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
    localObject = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo((String)localObject);
    a((TroopInfo)localObject);
    a(paramMap, (TroopInfo)localObject);
  }
  
  private void a(Map<String, String> paramMap, TroopInfo paramTroopInfo)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    boolean bool = paramTroopInfo.isTroopOwner(str);
    int i = 1;
    if (!bool) {
      if (paramTroopInfo.isTroopAdmin(str)) {
        i = 2;
      } else if (((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramTroopInfo.troopuin) == null) {
        i = 4;
      }
    }
    paramMap.put("group_uin_type", String.valueOf(i));
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new PageParams(paramMap));
  }
  
  private int b()
  {
    int j = this.jdField_a_of_type_Int;
    int k = c(this.c);
    int i;
    if (k != 4)
    {
      i = j;
      if (k != 0) {}
    }
    else
    {
      i = j / 2;
    }
    return i;
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
  
  private void b(View paramView)
  {
    VideoReport.resetPageParams(paramView);
    HashMap localHashMap = new HashMap();
    int i = c(this.c);
    localHashMap.put("source_aio_appear", String.valueOf(i));
    localHashMap.put("aio_session_time", String.valueOf(this.jdField_b_of_type_Long));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject != null)
    {
      int j = a(((SessionInfo)localObject).jdField_a_of_type_Int);
      a(j, localHashMap);
      localHashMap.put("type_aio_pg", String.valueOf(j));
      localHashMap.put("uin_to", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("AIODtReportHelper_QQDtReporter", 1, new Object[] { "setViewReport, curType = ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), ", exUinType = ", Integer.valueOf(j), ", curUin = ", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ", mMsgSource = ", Integer.valueOf(this.c), ", exMsgSource = ", Integer.valueOf(i) });
    }
    else
    {
      QLog.d("AIODtReportHelper", 1, "setViewReport, but session is null");
    }
    localHashMap.put("aio_disappear_type", "3");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append("");
    localHashMap.put("aio_recv_msg_cnt", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    localHashMap.put("aio_send_msg_cnt", ((StringBuilder)localObject).toString());
    VideoReport.setPageParams(paramView, new PageParams(localHashMap));
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "pg_aio");
    VideoReport.setPageContentId(this.jdField_a_of_type_AndroidViewView, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
  
  private void b(Map<String, String> paramMap)
  {
    VideoReport.setPageParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), new PageParams(paramMap));
  }
  
  private int c(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 0)
    {
      i = paramInt;
      if (paramInt != 1)
      {
        i = paramInt;
        if (paramInt != 2)
        {
          i = paramInt;
          if (paramInt != 3) {
            i = 14;
          }
        }
      }
    }
    return i;
  }
  
  private void c(View paramView)
  {
    a(paramView, "em_return_button_aio_pg");
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    g();
    VideoReport.addToDetectionWhitelist(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_AndroidViewView = localViewGroup;
    View localView1 = localViewGroup.findViewById(2131369563);
    View localView2 = localViewGroup.findViewById(2131369202);
    View localView3 = localViewGroup.findViewById(2131369985);
    View localView4 = localViewGroup.findViewById(2131379476);
    View localView5 = localViewGroup.findViewById(2131369216);
    b(localViewGroup);
    c(localView1);
    c(localView2);
    c(localView3);
    c(localView4);
    d(localView5);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    QLog.d("AIODtReportHelper", 1, new Object[] { "doOnAioCreate, mOnStartT = ", Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  private void d(View paramView)
  {
    a(paramView, "em_setting_banner_aio_pg");
  }
  
  private void e()
  {
    l();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    f();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.c = 999;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      this.c = localIntent.getExtras().getInt("aio_msg_source", 999);
    }
    this.jdField_b_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    VideoReport.resetPageParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {
      j();
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStart: mOnStartT = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.d("AIODtReportHelper", 1, localStringBuilder.toString());
  }
  
  private void j()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("aio_disappear_type", "3");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("");
    localTreeMap.put("aio_send_msg_cnt", localStringBuilder.toString());
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    VideoReport.setPageParams(localViewGroup, new PageParams(localTreeMap));
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("stay_time", String.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
      localHashMap.put("cur_time", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      localHashMap.put("is_return", String.valueOf(this.jdField_a_of_type_Boolean ^ true));
      localHashMap.put("source_aio_appear", String.valueOf(c(this.c)));
      String str = a();
      localHashMap.put("A8", str);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject != null)
      {
        localHashMap.put("type_aio_pg", String.valueOf(a(((SessionInfo)localObject).jdField_a_of_type_Int)));
        localHashMap.put("uin_to", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void l()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a().a();
    a(localView, "em_aio_textbox_amazing_button");
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_NONE);
  }
  
  private void m()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      bool = true;
    }
    QLog.d("AIODtReportHelper", 1, new Object[] { "doOnDestroy: mRootView = null ? ", Boolean.valueOf(bool) });
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      VideoReport.pageLogicDestroy(localView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    Object localObject2 = new TreeMap();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    int i = DtAIOReportUtil.a((String)localObject3);
    if (i > 0) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((Map)localObject2).put("is_text_with_stickers", localObject1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((String)localObject3).length() - i * 2);
    ((StringBuilder)localObject1).append("");
    ((Map)localObject2).put("number_text_send", ((StringBuilder)localObject1).toString());
    ((Map)localObject2).put("type_aio_pg", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.g));
    ((Map)localObject2).put("uin_to", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Map)localObject2).put("source_aio_appear", String.valueOf(c(this.c)));
    ((Map)localObject2).put("aio_session_time", String.valueOf(this.jdField_b_of_type_Long));
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
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramInt));
    localStringBuilder.append("");
    localTreeMap.put("aio_disappear_type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("");
    localTreeMap.put("aio_send_msg_cnt", localStringBuilder.toString());
    VideoReport.setPageParams(localObject, new PageParams(localTreeMap));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onExitAIO] set send: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", recv: ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    QLog.d("AIODtReportHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(View paramView)
  {
    a(paramView, "em_aio_textbox_amazing_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementParam(paramView, "text_in_textbox", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int += 1;
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    b(localTreeMap);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int += 1;
    TreeMap localTreeMap = new TreeMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("");
    localTreeMap.put("aio_recv_msg_cnt", localStringBuilder.toString());
    b(localTreeMap);
  }
  
  public void d(int paramInt)
  {
    a(paramInt);
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
              k();
              return;
            }
            h();
            return;
          }
          m();
          return;
        }
        e();
        return;
      }
      i();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper
 * JD-Core Version:    0.7.0.1
 */