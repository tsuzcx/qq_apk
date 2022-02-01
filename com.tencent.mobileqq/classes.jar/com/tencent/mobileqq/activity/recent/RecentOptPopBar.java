package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
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
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.List;

public class RecentOptPopBar
  implements View.OnClickListener
{
  public static final int[] a;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131691265, 2130839515 };
  private static final int[] c;
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131691267, 2130839520 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2131691276, 2130839519 };
  private static final int[] jdField_f_of_type_ArrayOfInt = { 2131691274, 2130839527 };
  private static final int[] jdField_g_of_type_ArrayOfInt = { 2131691268, 2130839521 };
  private static final int[] jdField_h_of_type_ArrayOfInt = { 2131691272, 2130839526 };
  private static final int[] jdField_i_of_type_ArrayOfInt = { 2131691271, 2130839525 };
  private static final int[] j = { 2131699241, 2130839528 };
  private static final int[] k = { 2131691270, 2130839523 };
  private static final int[] l = { 2131691266, 2130839516 };
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private String jdField_a_of_type_JavaLangString = "";
  private List<PopupMenuDialog.MenuItem> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  public boolean c;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean jdField_i_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691275, 2130839529 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131691269, 2130839501 };
  }
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public static void a(Intent paramIntent, FrameHelperActivity paramFrameHelperActivity)
  {
    if ((paramIntent != null) && (paramFrameHelperActivity != null) && ((paramFrameHelperActivity.a() instanceof SplashActivity)))
    {
      paramFrameHelperActivity = (SplashActivity)paramFrameHelperActivity.a();
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
    localIntent.putExtra("leftViewText", paramQBaseActivity.getString(2131690706));
    localIntent.putExtra("selfSet_leftViewText", paramQBaseActivity.getString(2131690706));
    localIntent.putExtra("start_time", System.currentTimeMillis());
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
      QQToast.a(paramQBaseActivity, HardCodeUtil.a(2131713133), 0).a();
      return false;
    }
    return true;
  }
  
  private void b(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    if (((this.jdField_h_of_type_Boolean) && (!((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))) || ((!this.jdField_h_of_type_Boolean) && (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false))))
    {
      a(paramRecentOptPopBarSwitchBean);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = null;
    }
    if (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
    {
      paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setTextColor(paramRecentOptPopBarSwitchBean.getResources().getColor(2131165578));
      }
      paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setImageResource(2130839521);
      }
    }
    else
    {
      paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setTextColor(paramRecentOptPopBarSwitchBean.getResources().getColor(2131167056));
      }
      paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramRecentOptPopBarSwitchBean != null) {
        paramRecentOptPopBarSwitchBean.setImageResource(2130839522);
      }
    }
  }
  
  private boolean c()
  {
    String str1 = IliveDbManager.getIliveDrawerData("drawer_plus_text");
    String str2 = this.jdField_b_of_type_JavaLangString;
    boolean bool = true;
    int m;
    if ((str2 != null) && (!str2.equals(str1))) {
      m = 1;
    } else {
      m = 0;
    }
    if (IliveEntranceUtil.c() == this.jdField_f_of_type_Boolean)
    {
      if (m != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void l()
  {
    IliveEntranceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "add");
  }
  
  private void m()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) || (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch == null))
    {
      localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131365169);
      int m = 0;
      while (m < ((LinearLayout)localObject1).getChildCount())
      {
        try
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(m);
          if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131691265)
          {
            localObject2 = (TextView)((View)localObject2).findViewById(2131378623);
            this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).b(21).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131691276)
          {
            localObject2 = ((View)localObject2).findViewById(2131368714);
            this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject2).b(53).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject2).getTag()).id == 2131691268)
          {
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378623));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131368714));
            if (((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).isShowF2FRedpackEntryColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin()))
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131165578));
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839521);
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getColor(2131167056));
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839522);
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        m += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      localObject1 = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101210.101211");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    }
  }
  
  public PopupMenuDialog.MenuItem a(int[] paramArrayOfInt)
  {
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.id = paramArrayOfInt[0];
    localMenuItem.title = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.contentDescription = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(paramArrayOfInt[0]);
    localMenuItem.iconId = paramArrayOfInt[1];
    return localMenuItem;
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  protected void a(int paramInt)
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&entry=2&seq=");
    localStringBuilder.append(l1);
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    RecentOptPopBarSwitchBean localRecentOptPopBarSwitchBean = (RecentOptPopBarSwitchBean)QConfigManager.a().a(744);
    if (RecentOptPopBarSwitchBean.a(localRecentOptPopBarSwitchBean)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if ((localObject != null) && (((PopupMenuDialog)localObject).mNeedRebuild)) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null)
    {
      a(localRecentOptPopBarSwitchBean);
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {}
    }
    else
    {
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
        if (localObject != null)
        {
          String str = this.jdField_a_of_type_JavaLangString;
          if ((str != null) && (!((String)localObject).equals(str))) {
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (c()) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_e_of_type_Boolean) && (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))) || ((!this.jdField_e_of_type_Boolean) && (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (((this.jdField_g_of_type_Boolean) && (!AvGameEntranceUtils.a())) || ((!this.jdField_g_of_type_Boolean) && (AvGameEntranceUtils.a()))) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(localRecentOptPopBarSwitchBean);
        this.jdField_a_of_type_Boolean = false;
      }
      if (b()) {
        b(localRecentOptPopBarSwitchBean);
      }
    }
    if (this.jdField_e_of_type_Boolean) {
      ((IExpandPluginPreload)QRoute.api(IExpandPluginPreload.class)).preloadProcessIfPlugin(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 0L);
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
    m();
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), "peak_preload_plus_panel");
    if (this.jdField_e_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69B", "0X800A69B", 0, 0, "", "", "", "");
    }
  }
  
  public void a(RecentOptPopBarSwitchBean paramRecentOptPopBarSwitchBean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRecentOptPopBarSwitchBean.a()) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_f_of_type_ArrayOfInt));
    }
    if (paramRecentOptPopBarSwitchBean.b()) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_b_of_type_ArrayOfInt));
    }
    boolean bool1 = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).bNeedShowLimitChatByAllController(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    boolean bool2 = true;
    if ((bool1) && (paramRecentOptPopBarSwitchBean.c())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Boolean = bool1;
    Object localObject2;
    if (this.jdField_e_of_type_Boolean)
    {
      localObject1 = a(k);
      this.jdField_a_of_type_JavaLangString = ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getLimitChatOnPlusName(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        ((PopupMenuDialog.MenuItem)localObject1).title = ((String)localObject2);
        ((PopupMenuDialog.MenuItem)localObject1).contentDescription = ((String)localObject2);
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
    if ((AvGameEntranceUtils.a()) && (paramRecentOptPopBarSwitchBean.d())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_g_of_type_Boolean = bool1;
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.add(a(l));
    }
    if (paramRecentOptPopBarSwitchBean.e()) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_a_of_type_ArrayOfInt));
    }
    if (paramRecentOptPopBarSwitchBean.f()) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_c_of_type_ArrayOfInt));
    }
    if (paramRecentOptPopBarSwitchBean.g()) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_d_of_type_ArrayOfInt));
    }
    Object localObject1 = MiniAppConfProcessor.a();
    int m;
    if ((localObject1 != null) && (((MiniAppConfBean)localObject1).c())) {
      m = 1;
    } else {
      m = 0;
    }
    if ((m != 0) && (paramRecentOptPopBarSwitchBean.h())) {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_i_of_type_ArrayOfInt));
    }
    if ((((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin(), "F2FRedpackEntry", false)) && (b())) {
      m = 1;
    } else {
      m = 0;
    }
    if ((m != 0) && (paramRecentOptPopBarSwitchBean.i())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_h_of_type_Boolean = bool1;
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.add(a(jdField_g_of_type_ArrayOfInt));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "hongbaocaidan.show", 0, 0, "", "", "", "");
    }
    if ((IliveEntranceUtil.c()) && (paramRecentOptPopBarSwitchBean.j())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_f_of_type_Boolean = bool1;
    if (this.jdField_f_of_type_Boolean)
    {
      localObject2 = a(j);
      localObject1 = IliveDbManager.getIliveDrawerData("drawer_plus_text");
      paramRecentOptPopBarSwitchBean = (RecentOptPopBarSwitchBean)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699241);
      }
      ((PopupMenuDialog.MenuItem)localObject2).title = paramRecentOptPopBarSwitchBean;
      this.jdField_b_of_type_JavaLangString = ((PopupMenuDialog.MenuItem)localObject2).title;
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
    }
    if (QQAudioHelper.b()) {
      PstnCardTestActivity.addDebugMenu(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaUtilList);
    }
    paramRecentOptPopBarSwitchBean = this.jdField_a_of_type_JavaUtilList;
    if (paramRecentOptPopBarSwitchBean != null)
    {
      if (paramRecentOptPopBarSwitchBean.size() == 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.conversationPlusBuild(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaUtilList, new RecentOptPopBar.1(this), new RecentOptPopBar.2(this));
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_SHOT_REDTOUCH_TIME");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin());
    if (localBaseActivity.getSharedPreferences(localStringBuilder.toString(), 0).getLong(paramString, 0L) == 0L)
    {
      localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SP_SHOT_REDTOUCH_TIME");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin());
      localBaseActivity.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong(paramString, paramLong).commit();
    }
  }
  
  public boolean a()
  {
    PopupMenuDialog localPopupMenuDialog = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    return (localPopupMenuDialog != null) && (localPopupMenuDialog.isShowing());
  }
  
  public boolean a(String paramString)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_SHOT_REDTOUCH");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getCurrentAccountUin());
    return localBaseActivity.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString, true);
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, 0L, 0);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", 2);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690706));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690706));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("101210.101211");
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void d() {}
  
  protected void e()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void f()
  {
    long l1 = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "/qwallet/redpacket/QrcodeHbGuider");
    localActivityURIRequest.extra().putLong("vacreport_key_seq", l1);
    localActivityURIRequest.extra().putString("appInfo", "");
    QRoute.startUri(localActivityURIRequest, new RecentOptPopBar.3(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewTroopCreateActivity.class);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.setFlags(603979776);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("create_source", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130772011, 2130772015);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Grp_create", "", "msg_page", "exp_creategrp", 0, 0, "", "", "", "");
  }
  
  protected void h()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X800780A", "0X800780A", 0, 0, "", "", "", "");
    StoryReportor.a("plus_shoot", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    StoryReportor.a("plus_shoot", "exp_shoot", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void i()
  {
    PopupMenuDialog localPopupMenuDialog = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
    if (localPopupMenuDialog != null) {
      localPopupMenuDialog.onPause();
    }
  }
  
  protected void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && (((BaseActivity)localObject).app != null))
    {
      localObject = (IExpandEntrance)QRoute.api(IExpandEntrance.class);
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      ((IExpandEntrance)localObject).enterExpandLimitMatch(localBaseActivity, localBaseActivity.app, 6);
      ExtendFriendReport.a().b(4);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A69C", "0X800A69C", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("RecentOptPopBar", 2, "activity or app is null");
  }
  
  protected void k()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800B010", "0X800B010", 0, 0, "", "", "", "");
    QPublicFragmentActivity.start(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVGameRoomCenterFragment.class);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentOptPopBar
 * JD-Core Version:    0.7.0.1
 */