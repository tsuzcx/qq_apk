package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class AIODtReportHelper
  implements ILifeCycleHelper
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
  private int b;
  private int c;
  
  AIODtReportHelper(@NonNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 5;
    case 0: 
      return 1;
    case 1000: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 1025: 
    case 10002: 
    case 10004: 
    case 10008: 
    case 10010: 
      return 2;
    case 1: 
      return 0;
    case 3000: 
      return 4;
    }
    return 3;
  }
  
  private GroupCatalogBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = GroupCatalogTool.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), paramString);
    } while (paramString == null);
    if ((paramString.jdField_a_of_type_Int > 2) && (paramString.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null)) {
      return a(paramString.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b);
    }
    return paramString;
  }
  
  private static String a()
  {
    String str2 = "0";
    Object localObject = BaseApplicationImpl.getApplication();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).peekAppRuntime();
      str1 = str2;
      if (localObject != null)
      {
        str2 = ((AppRuntime)localObject).getAccount();
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "0";
        }
      }
    }
    return str1;
  }
  
  private void a()
  {
    QLog.d("AIODtReportHelper", 1, "doOnAioCreate");
    this.jdField_a_of_type_Boolean = true;
    b();
    VideoReport.addToDetectionWhitelist(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.jdField_a_of_type_AndroidViewView = localViewGroup;
    View localView1 = localViewGroup.findViewById(2131369878);
    View localView2 = localViewGroup.findViewById(2131369487);
    View localView3 = localViewGroup.findViewById(2131370317);
    View localView4 = localViewGroup.findViewById(2131380148);
    View localView5 = localViewGroup.findViewById(2131369501);
    a(localViewGroup);
    b(localView1);
    b(localView2);
    b(localView3);
    b(localView4);
    c(localView5);
  }
  
  private void a(int paramInt, Map<String, String> paramMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.b = 2;
    a(paramMap);
  }
  
  private void a(View paramView)
  {
    VideoReport.resetPageParams(paramView);
    HashMap localHashMap = new HashMap();
    int i = b(this.c);
    localHashMap.put("source_aio_appear", String.valueOf(i));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      a(j, localHashMap);
      localHashMap.put("type_aio_pg", String.valueOf(j));
      localHashMap.put("uin_to", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("AIODtReportHelper_QQDtReporter", 1, new Object[] { "setViewReport, curType = ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), ", exUinType = ", Integer.valueOf(j), ", curUin = ", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ", mMsgSource = ", Integer.valueOf(this.c), ", exMsgSource = ", Integer.valueOf(i) });
    }
    for (;;)
    {
      VideoReport.setPageParams(paramView, new PageParams(localHashMap));
      c();
      return;
      QLog.d("AIODtReportHelper", 1, "setViewReport, but session is null");
    }
  }
  
  private void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
  }
  
  public static void a(SessionInfo paramSessionInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type_aio_pg", String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)));
    localHashMap.put("uin_to", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("cur_time", paramString);
    localHashMap.put("A8", a());
    UserAction.onUserAction("qq_aio_setting_click", true, 0L, 0L, localHashMap, true, true);
    QLog.d("AIODtReportHelper_850_reportEvent", 1, "reportClickSetting: params = " + localHashMap.toString());
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    ThreadManagerV2.excute(new AIODtReportHelper.2(this, paramTroopInfo), 64, null, false);
  }
  
  private void a(Map<String, String> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localObject = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo((String)localObject);
    a((TroopInfo)localObject);
    a(paramMap, (TroopInfo)localObject);
  }
  
  private void a(Map<String, String> paramMap, TroopInfo paramTroopInfo)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    if (paramTroopInfo.isTroopOwner(str))
    {
      paramMap.put("group_uin_type", String.valueOf(1));
      c();
    }
    do
    {
      return;
      if (paramTroopInfo.isTroopAdmin(str))
      {
        paramMap.put("group_uin_type", String.valueOf(2));
        c();
        return;
      }
      paramMap = (ITroopMemberInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopMemberInfoService.class, "");
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    paramMap.getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, new AIODtReportHelper.1(this));
  }
  
  private int b(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 14;
    }
    return i;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    this.c = 999;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null)) {
      this.c = localIntent.getExtras().getInt("aio_msg_source", 999);
    }
  }
  
  private void b(View paramView)
  {
    a(paramView, "em_return_button_aio_pg");
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int > this.b)
    {
      VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "pg_aio");
      VideoReport.setPageContentId(this.jdField_a_of_type_AndroidViewView, String.valueOf(SystemClock.elapsedRealtime()), true);
    }
  }
  
  private void c(View paramView)
  {
    a(paramView, "em_setting_banner_aio_pg");
  }
  
  private void d()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    QLog.d("AIODtReportHelper", 1, "onStart: mOnStartT = " + this.jdField_a_of_type_Long);
  }
  
  private void e()
  {
    int i;
    if (this.jdField_a_of_type_Long > 0L)
    {
      HashMap localHashMap = new HashMap();
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      localHashMap.put("stay_time", String.valueOf(l));
      localHashMap.put("cur_time", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        localHashMap.put("is_return", String.valueOf(i));
        localHashMap.put("source_aio_appear", String.valueOf(b(this.c)));
        localHashMap.put("A8", a());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          localHashMap.put("type_aio_pg", String.valueOf(a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)));
          localHashMap.put("uin_to", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        UserAction.onUserAction("qq_aio_pg_in", true, l, 0L, localHashMap, true, true);
        QLog.d("AIODtReportHelper_850_reportEvent", 1, "onStop report show: params = " + localHashMap.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
      return;
      i = 1;
      break;
      QLog.d("AIODtReportHelper", 1, "onStop: mOnStartT = 0");
    }
  }
  
  private void f()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      bool = true;
    }
    QLog.d("AIODtReportHelper", 1, new Object[] { "doOnDestroy: mRootView = null ? ", Boolean.valueOf(bool) });
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      VideoReport.pageLogicDestroy(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "AIODtReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 5, 11, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    case 5: 
      d();
      return;
    case 11: 
      e();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper
 * JD-Core Version:    0.7.0.1
 */