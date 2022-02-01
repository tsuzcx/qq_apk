package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.recent.config.optpopbar.RecentOptPopBarSwitchBean;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.debug.PstnCardTestActivity;
import com.tencent.mobileqq.education.api.IAnswerSearchApi;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.plugin.preload.IExpandPluginPreload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.ilive.QQLiveJumpUtil;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.List;

public class RecentOptPopBar
  implements View.OnClickListener
{
  public static final int[] b = { 2131888225, 2130839727 };
  private static final int[] g = { 2131888213, 2130839712 };
  private static final int[] h = { 2131888219, 2130839692 };
  private static final int[] i = { 2131888215, 2130839717 };
  private static final int[] j = { 2131888226, 2130839716 };
  private static final int[] k = { 2131888224, 2130839725 };
  private static final int[] l = { 2131888218, 2130839718 };
  private static final int[] m = { 2131888222, 2130839724 };
  private static final int[] n = { 2131888221, 2130839723 };
  private static final int[] o = { 2131897257, 2130839726 };
  private static final int[] p = { 2131888220, 2130839721 };
  private static final int[] q = { 2131888214, 2130839713 };
  private List<PopupMenuDialog.MenuItem> A;
  private RedTouch B = null;
  private RedTouch C = null;
  private boolean D = false;
  private QQProgressDialog E = null;
  public BaseActivity a;
  public boolean c;
  public boolean d = false;
  PopupMenuDialog e;
  public boolean f = false;
  private boolean r = false;
  private boolean s = false;
  private String t = "";
  private boolean u = false;
  private String v;
  private boolean w = false;
  private boolean x = false;
  private TextView y = null;
  private ImageView z = null;
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.C() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.C();
      if (paramIntent.getBooleanExtra("open_leba_tab_fragment", false))
      {
        paramFrameHelperActivity.openMainFragment(paramIntent);
        return;
      }
      if (paramIntent.getBooleanExtra("open_chatfragment", false)) {
        RecentUtil.a(paramFrameHelperActivity, paramIntent);
      }
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramQBaseActivity)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("from_+", true);
    localIntent.putExtra("leftViewText", paramQBaseActivity.getString(2131887625));
    localIntent.putExtra("selfSet_leftViewText", paramQBaseActivity.getString(2131887625));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("key_entrance_type", 1);
    Bundle localBundle = new Bundle();
    localBundle.putLong("PromotionType", paramLong1);
    localBundle.putLong("RecoglizeMask", paramLong2);
    localBundle.putString("H5Source", String.valueOf(paramInt));
    localIntent.putExtra("web_invoke_params", localBundle);
    localIntent.setFlags(67108864);
    RouteUtils.a(paramQBaseActivity, localIntent, "/qrscan/scanner");
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (paramQBaseActivity.isInMultiWindow())
    {
      QQToast.makeText(paramQBaseActivity, HardCodeUtil.a(2131910692), 0).show();
      return false;
    }
    return true;
  }
  
  private void b(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    boolean bool2 = IliveEntranceUtil.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("liveBizSwitch: ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" isQQLiveSwitch: ");
    ((StringBuilder)localObject).append(paramRecentOptPopBarSwitchBean.j());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = true;
    QLog.d("RecentOptPopBar", 1, (String)localObject);
    if ((!bool2) || (!paramRecentOptPopBarSwitchBean.j())) {
      bool1 = false;
    }
    this.u = bool1;
    if (this.u)
    {
      PopupMenuDialog.MenuItem localMenuItem = a(o);
      localObject = IliveDbManager.getIliveDrawerData("drawer_plus_text");
      if (this.a.getResources() != null) {
        TextUtils.isEmpty(this.a.getResources().getString(2131897257));
      }
      paramRecentOptPopBarSwitchBean = (RecentOptPopBarSwitchBean)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramRecentOptPopBarSwitchBean = "发起直播";
      }
      localMenuItem.title = paramRecentOptPopBarSwitchBean;
      this.v = localMenuItem.title;
      this.A.add(localMenuItem);
    }
  }
  
  private void c(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    if (((this.x) && (!((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.a.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.x) && (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.a.getCurrentAccountUin(), "F2FRedpackEntry", false)))) {
      a(paramRecentOptPopBarSwitchBean);
    }
    if (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.a.getCurrentAccountUin()))
    {
      paramRecentOptPopBarSwitchBean = this.y;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setTextColor(paramRecentOptPopBarSwitchBean.getResources().getColor(2131165922));
      }
      paramRecentOptPopBarSwitchBean = this.z;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setImageResource(2130839718);
      }
    }
    else
    {
      paramRecentOptPopBarSwitchBean = this.y;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setTextColor(paramRecentOptPopBarSwitchBean.getResources().getColor(2131167993));
      }
      paramRecentOptPopBarSwitchBean = this.z;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setImageResource(2130839719);
      }
    }
  }
  
  private void r()
  {
    QQLiveJumpUtil.a(this.a, true, null);
  }
  
  private boolean s()
  {
    String str1 = IliveDbManager.getIliveDrawerData("drawer_plus_text");
    String str2 = this.v;
    boolean bool = true;
    int i1;
    if ((str2 != null) && (!str2.equals(str1))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (IliveEntranceUtil.c() == this.u)
    {
      if (i1 != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void t()
  {
    Object localObject1;
    if ((this.B == null) || (this.C == null))
    {
      localObject1 = (LinearLayout)this.e.getContentView().findViewById(2131431322);
      int i1 = 0;
      while (i1 < ((LinearLayout)localObject1).getChildCount())
      {
        try
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(i1);
          if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131888213)
          {
            localObject2 = (TextView)((View)localObject2).findViewById(2131447262);
            this.B = new RedTouch(this.a, (View)localObject2).c(21).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131888225)
          {
            localObject2 = ((View)localObject2).findViewById(2131447262);
            this.C = new RedTouch(this.a, (View)localObject2).c(21).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131888218)
          {
            this.y = ((TextView)((View)localObject2).findViewById(2131447262));
            this.z = ((ImageView)((View)localObject2).findViewById(2131435627));
            if (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.a.getCurrentAccountUin()))
            {
              this.y.setTextColor(this.y.getResources().getColor(2131165922));
              this.z.setImageResource(2130839718);
            }
            else
            {
              this.y.setTextColor(this.y.getResources().getColor(2131167993));
              this.z.setImageResource(2130839719);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        i1 += 1;
      }
    }
    if (this.B != null)
    {
      localObject1 = ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101210.101211");
      this.B.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    }
    if (this.C != null)
    {
      localObject1 = (IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject1).getAppInfoByPath("140101");
      this.C.a(localAppInfo);
      ((IRedTouchManager)localObject1).onRedTouchItemExposure(localAppInfo, null);
      ((IRedTouchManager)localObject1).checkMsgExpire();
      if (localAppInfo.iNewFlag.get() != 0)
      {
        ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#qqaio_page#add_reddot", null);
        ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("expose#qqaio_page#scan_reddot", null);
      }
    }
  }
  
  private void u()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "");
    localIRedTouchManager.onRedTouchItemClick(localIRedTouchManager.getAppInfoByPath("140101"), null);
  }
  
  public PopupMenuDialog.MenuItem a(int[] paramArrayOfInt)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = paramArrayOfInt[0];
    localMenuItem.title = this.a.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.contentDescription = this.a.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.iconId = paramArrayOfInt[1];
    return localMenuItem;
  }
  
  public void a()
  {
    List localList = this.A;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return;
      }
      this.e = PopupMenuDialog.conversationPlusBuild(this.a, this.A, new RecentOptPopBar.1(this), new RecentOptPopBar.2(this));
    }
  }
  
  protected void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.a, JumpActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&entry=2&seq=");
    localStringBuilder.append(l1);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    this.a.startActivityForResult(localIntent, -1);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    RecentOptPopBarSwitchBean localRecentOptPopBarSwitchBean = (RecentOptPopBarSwitchBean)QConfigManager.b().b(744);
    if (RecentOptPopBarSwitchBean.a(localRecentOptPopBarSwitchBean)) {
      return;
    }
    Object localObject = this.e;
    if ((localObject != null) && (((PopupMenuDialog)localObject).mNeedRebuild)) {
      this.e = null;
    }
    if (this.e == null)
    {
      a(localRecentOptPopBarSwitchBean);
      if (this.e != null) {}
    }
    else
    {
      if (this.s)
      {
        localObject = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.a.app);
        if (localObject != null)
        {
          String str = this.t;
          if ((str != null) && (!((String)localObject).equals(str))) {
            this.c = true;
          }
        }
      }
      if (s()) {
        this.c = true;
      }
      if (((this.s) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.a.app))) || ((!this.s) && (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.a.app)))) {
        this.c = true;
      }
      if (((this.w) && (!AvGameEntranceUtils.a())) || ((!this.w) && (AvGameEntranceUtils.a()))) {
        this.c = true;
      }
      if (this.c)
      {
        a(localRecentOptPopBarSwitchBean);
        this.c = false;
      }
      if (o()) {
        c(localRecentOptPopBarSwitchBean);
      }
    }
    if (this.s) {
      ((IExpandPluginPreload)QRoute.api(IExpandPluginPreload.class)).preloadProcessIfPlugin(this.a.app, 0L);
    }
    this.e.showAsDropDown(paramView, paramInt1, paramInt2);
    t();
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
    if (this.s) {
      ReportController.b(this.a.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
    }
  }
  
  public void a(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    this.A = new ArrayList();
    if (paramRecentOptPopBarSwitchBean.a()) {
      this.A.add(a(k));
    }
    if (paramRecentOptPopBarSwitchBean.b()) {
      this.A.add(a(g));
    }
    boolean bool1 = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.a.app);
    boolean bool2 = true;
    if ((bool1) && (paramRecentOptPopBarSwitchBean.c())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    if (this.s)
    {
      localObject = a(p);
      this.t = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.a.app);
      if (!TextUtils.isEmpty(this.t))
      {
        String str = this.t;
        ((PopupMenuDialog.MenuItem)localObject).title = str;
        ((PopupMenuDialog.MenuItem)localObject).contentDescription = str;
      }
      this.A.add(localObject);
    }
    if ((b()) && (paramRecentOptPopBarSwitchBean.d())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.w = bool1;
    if (this.w) {
      this.A.add(a(q));
    }
    if (paramRecentOptPopBarSwitchBean.e()) {
      this.A.add(a(b));
    }
    if (paramRecentOptPopBarSwitchBean.f()) {
      this.A.add(a(h));
    }
    if (paramRecentOptPopBarSwitchBean.g()) {
      this.A.add(a(i));
    }
    Object localObject = c();
    int i1;
    if ((localObject != null) && (((MiniAppConfBean)localObject).d())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (paramRecentOptPopBarSwitchBean.h())) {
      this.A.add(a(n));
    }
    if ((((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.a.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (o())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (paramRecentOptPopBarSwitchBean.i())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.x = bool1;
    if (this.x)
    {
      this.A.add(a(l));
      ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    b(paramRecentOptPopBarSwitchBean);
    if (QQAudioHelper.b()) {
      PstnCardTestActivity.addDebugMenu(this.a.app, this.A);
    }
    this.B = null;
    this.C = null;
    a();
  }
  
  public boolean b()
  {
    return AvGameEntranceUtils.a();
  }
  
  public MiniAppConfBean c()
  {
    return MiniAppConfProcessor.a();
  }
  
  public boolean d()
  {
    PopupMenuDialog localPopupMenuDialog = this.e;
    return (localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing());
  }
  
  public void e()
  {
    if (d()) {
      this.e.dismiss();
    }
  }
  
  public boolean f()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("140101");
    if ((localAppInfo.iNewFlag.get() != 0) && (localAppInfo.exposure_max.get() > 0) && (localAppInfo.red_display_info.get() != null) && (localAppInfo.red_display_info.red_type_info.get().size() > 0))
    {
      QLog.i("RecentOptPopBar", 1, "needsExposeRedTouchUpward: QRScanner exposing");
      ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("expose#qqaio_page#add_reddot", null);
      return true;
    }
    return false;
  }
  
  protected void g()
  {
    a(this.a, 0L, 0L, 0);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("140101");
    if (localAppInfo.iNewFlag.get() != 0) {
      ((IAnswerSearchApi)QRoute.api(IAnswerSearchApi.class)).reportEvent("click#qqaio_page#scan_reddot", null);
    }
    localIRedTouchManager.onRedTouchItemClick(localAppInfo, null);
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this.a, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.a.getString(2131887625));
    localIntent.putExtra("selfSet_leftViewText", this.a.getString(2131887625));
    this.a.startActivity(localIntent);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101210.101211");
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void i() {}
  
  protected void j()
  {
    QQProxyForQlink.a(this.a, 8, null);
    ReportController.b(this.a.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void k()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.a, "/qwallet/redpacket/QrcodeHbGuider");
    localActivityURIRequest.extra().putLong("vacreport_key_seq", l1);
    localActivityURIRequest.extra().putString("appInfo", "");
    QRoute.startUri(localActivityURIRequest, new RecentOptPopBar.3(this));
    ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  protected void l()
  {
    Intent localIntent = new Intent(this.a, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("create_source", 0);
    this.a.startActivityForResult(localIntent, 1300);
    this.a.overridePendingTransition(2130772014, 2130772018);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    ReportController.b(this.a.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void m()
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void n()
  {
    PopupMenuDialog localPopupMenuDialog = this.e;
    if (localPopupMenuDialog != null) {
      localPopupMenuDialog.onPause();
    }
  }
  
  public boolean o()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    this.e.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void p()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseActivity)localObject).app != null))
    {
      localObject = (IExpandEntrance)QRoute.api(IExpandEntrance.class);
      BaseActivity localBaseActivity = this.a;
      ((IExpandEntrance)localObject).enterExpandLimitMatch(localBaseActivity, localBaseActivity.app, 6);
      ExtendFriendReport.a().b(4);
      ReportController.b(this.a.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  protected void q()
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
    QPublicFragmentActivity.start(this.a, AVGameRoomCenterFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar
 * JD-Core Version:    0.7.0.1
 */