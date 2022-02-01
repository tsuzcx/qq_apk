package com.tencent.mobileqq.activity.miniaio;

import akej;
import akes;
import akeu;
import akew;
import akex;
import akfa;
import akfb;
import akfd;
import akfe;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class MiniMsgTabFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  akes jdField_a_of_type_Akes;
  akew jdField_a_of_type_Akew;
  public akex a;
  akfe jdField_a_of_type_Akfe = new akfb(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private MiniAppConfig jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = new akfa(this);
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  
  private Intent a()
  {
    if (getActivity() != null) {
      return getActivity().getIntent();
    }
    QLog.e("MiniMsgTabFragment", 1, "Fragment.getActivity() is null when calling getIntent()");
    return new Intent();
  }
  
  private RecentBaseData a()
  {
    return new RecentItemChatMsgData(new RecentUser("0", 0));
  }
  
  private void a()
  {
    this.jdField_f_of_type_Int = 1;
    ArrayList localArrayList1 = new ArrayList();
    boolean bool1 = a().getBooleanExtra("showShareQQ", false);
    if (bool1) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    boolean bool2 = a().getBooleanExtra("showShareQzone", false);
    if (bool2) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    boolean bool3 = a().getBooleanExtra("showShareWeChatFriends", false);
    if (bool3) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    boolean bool4 = a().getBooleanExtra("showShareWeChatMoment", false);
    if (bool4) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    if ((bool1) || (bool2) || (bool3) || (bool4)) {
      this.jdField_f_of_type_Int += 1;
    }
    for (int i = 1;; i = 0)
    {
      ArrayList localArrayList2 = new ArrayList();
      int j = a().getIntExtra("key_color_note", 0);
      if (j == 0)
      {
        j = a().getIntExtra("topType", 0);
        bool2 = a().getBooleanExtra("isSpecialMiniApp", false);
        bool3 = a().getBooleanExtra("is_limited_access_app", false);
        if ((!bool2) && (!bool3)) {
          break label934;
        }
        label230:
        if ((a().getBooleanExtra("addShortcut", false)) && (!bool3)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
        }
        j = a().getIntExtra("showBackHome", -1);
        if (j != -1) {
          break label976;
        }
        label277:
        if (a().getBooleanExtra("showRestartMiniApp", true)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(128));
        }
        if (a().getBooleanExtra("showFavorite", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
        }
        if ((a().getBooleanExtra("setToTroop", false)) && (TroopApplicationListUtil.isAdminOrCreated())) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(158));
        }
        if (a().getBooleanExtra("addToCurrentTroop", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(159));
        }
        if (a().getBooleanExtra("showDetail", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(78));
        }
        if (a().getBooleanExtra("showSetting", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(83));
        }
        if (a().getBooleanExtra("showComplaint", false)) {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        bool2 = a().getBooleanExtra("showDebug", false);
        bool3 = a().getBooleanExtra("debugEnable", false);
        if (bool2)
        {
          if (!bool3) {
            break label1004;
          }
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(75));
        }
        label515:
        bool2 = a().getBooleanExtra("showMonitor", false);
        bool3 = a().getBooleanExtra("isOpenMonitorPanel", false);
        if (bool2)
        {
          if (!bool3) {
            break label1020;
          }
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(80));
        }
        label562:
        Object localObject = getArguments();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig = ((MiniAppConfig)((Bundle)localObject).getParcelable("key_mini_app_config"));
        }
        this.jdField_b_of_type_Int = a().getIntExtra("key_mini_app_version_type", -1);
        this.jdField_b_of_type_Boolean = a().getBooleanExtra("isFromShareButton", false);
        this.jdField_a_of_type_Boolean = a().getBooleanExtra("isLandscape", false);
        if (("1108291530".equals(this.jdField_a_of_type_JavaLangString)) || (MiniAppSecurityUtil.doCheckSafeUnblockWithLogin(this.jdField_a_of_type_JavaLangString))) {
          i = 0;
        }
        this.jdField_e_of_type_Boolean = a().getBooleanExtra("showKingcardTip", false);
        if (this.jdField_e_of_type_Boolean) {}
        this.jdField_a_of_type_JavaLangString = a().getStringExtra("miniAppID");
        this.jdField_b_of_type_JavaLangString = a().getStringExtra("miniAppName");
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_miniapp");
        localObject = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject).context = getActivity();
        ((ShareActionSheetV2.Param)localObject).canceledOnTouchOutside = false;
        ((ShareActionSheetV2.Param)localObject).flagNotTouchModal = true;
        ((ShareActionSheetV2.Param)localObject).dimAmount = 0.0F;
        ((ShareActionSheetV2.Param)localObject).lp = new ViewGroup.LayoutParams(-1, -2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
        if (!bool1) {
          break label1036;
        }
        this.jdField_f_of_type_Int += 1;
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", 27);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
      }
      for (;;)
      {
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle("");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new akfd(this));
        return;
        if (j == 1)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
          break;
        }
        if (j != 2) {
          break;
        }
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
        break;
        label934:
        if (j == 0)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
          break label230;
        }
        if (j == -11) {
          break label230;
        }
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
        break label230;
        label976:
        if (j == 1)
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(81));
          break label277;
        }
        if (j != 0) {
          break label277;
        }
        break label277;
        label1004:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
        break label515;
        label1020:
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(79));
        break label562;
        label1036:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
    }
    if (getActivity() == null)
    {
      QLog.e("MiniMsgTabFragment", 1, "getActivity is null when calling dismissMsgFragment");
      return;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getMessageFacade();
        if (localObject == null) {
          break label152;
        }
      }
      label152:
      for (int i = ((QQMessageFacade)localObject).getMiniUnreadMsgsNum();; i = 0)
      {
        localObject = a();
        ((Intent)localObject).putExtra("miniAppID", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("clickID", paramInt);
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        ((Intent)localObject).putExtra("param_proc_badge_count", i);
        getActivity().setResult(-1, (Intent)localObject);
        getActivity().finish();
        return;
        localObject = null;
        break;
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    QLog.d("MiniMsgTabFragment", 2, "shareToChatDirectly handleShareChatItemClick, uin:" + paramString + ",uinType:" + paramInt);
    localBundle.putString("key_mini_app_share_chat_uin", paramString);
    localBundle.putInt("key_mini_app_share_chat_type", paramInt);
    a(12, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("MiniMsgTabFragment", 2, "handleShareChatItemClick");
    }
  }
  
  private void b()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniMsgTabFragment", 2, "mShouldUpdateChatData: false");
      }
      return;
    }
    List localList = this.jdField_a_of_type_Akes.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int);
    if ((!this.jdField_c_of_type_Boolean) && (localList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = a();
      }
      localList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131379172).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Akex.a(localList);
      return;
      this.jdField_b_of_type_AndroidViewView.findViewById(2131379172).setVisibility(0);
    }
  }
  
  public int a()
  {
    int j = 0;
    QQAppInterface localQQAppInterface = getActivity().app;
    int i = j;
    if (localQQAppInterface != null)
    {
      i = j;
      if (localQQAppInterface.getMessageFacade() != null) {
        i = localQQAppInterface.getMessageFacade().getMiniUnreadMsgsNum();
      }
    }
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Akex != null) {
      this.jdField_a_of_type_Akex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      b();
    }
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Akex.getCount() < 1) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MiniMsgTabFragment.4(this), 100L);
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("MiniMsgTabFragment", 1, "onActivityResult error", paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      a(-1, null);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    if ((paramView.getId() == 2131379172) && (a().getBooleanExtra("key_mini_msgtab_isneed_back_conversation", false)))
    {
      localObject1 = (Intent)a().getParcelableExtra("key_mini_msgtab_back_pending_intent");
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getActivity(), SplashActivity.class);
        akeu.a().c();
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break label234;
        }
      }
    }
    label234:
    for (QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localQQAppInterface = null)
    {
      startActivity((Intent)localObject1);
      localObject1 = localObject2;
      if (localQQAppInterface != null) {
        localObject1 = localQQAppInterface.getMessageFacade();
      }
      if (localObject1 != null) {}
      for (i = ((QQMessageFacade)localObject1).getMiniUnreadMsgsNum();; i = 0)
      {
        localObject1 = a();
        ((Intent)localObject1).putExtra("param_proc_badge_count", i);
        getActivity().setResult(-1, (Intent)localObject1);
        getActivity().finish();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getActivity(), SplashActivity.class);
        ((Intent)localObject1).setFlags(67108864);
        ((Intent)localObject1).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
        ((Intent)localObject1).putExtra("fragment_id", 1);
        break;
      }
      if (paramView.getId() == 2131362299) {}
      for (;;)
      {
        a(i, null);
        break;
        i = -1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = a().getIntExtra("key_mini_msgtab_type", 0);
    this.jdField_c_of_type_Boolean = a().getBooleanExtra("key_mini_msgtab_need_action_sheet", false);
    this.jdField_e_of_type_Int = a().getIntExtra("key_mini_msgtab_businame", 0);
    int i = a();
    bdla.b(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", this.jdField_e_of_type_Int, 1, "" + i, "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = null)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_c_of_type_Int = getActivity().getResources().getDisplayMetrics().heightPixels;
      this.jdField_d_of_type_Int = ImmersiveUtils.getStatusBarHeight(getActivity());
      paramBundle = a();
      paramLayoutInflater = paramLayoutInflater.inflate(2131559469, paramViewGroup, false);
      if (paramLayoutInflater != null) {
        break;
      }
      getActivity().finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131362299);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramLayoutInflater.findViewById(2131371626));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollTouchMode(1);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollFlingMode(1);
    paramViewGroup = View.inflate(getActivity(), 2131559468, null);
    paramViewGroup.findViewById(2131365469).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(paramViewGroup);
    a();
    if (QLog.isColorLevel()) {
      QLog.d("MiniMsgTabFragment", 0, "mini msg tab oncreateView.mFilterMsgType " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      }
      int i = this.jdField_c_of_type_Int;
      int j = this.jdField_d_of_type_Int;
      int k = this.jdField_f_of_type_Int;
      int m = DisplayUtil.dip2px(getActivity(), 120.0F);
      int n = DisplayUtil.dip2px(getActivity(), 36.0F);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setMaxHeight(i - j - k * m - n);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Akex = new akex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_Akfe);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Akex);
      this.jdField_a_of_type_Akes = ((akes)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER));
      this.jdField_a_of_type_Akew = akeu.a().a();
      if ((paramBundle != null) && (!paramBundle.getBooleanExtra("showChatNewsList", true)))
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
      }
      break;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLayoutParams();
      localLayoutParams.topMargin = 0;
      paramViewGroup.findViewById(2131379172).setOnClickListener(this);
      paramViewGroup.findViewById(2131379172).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_Akex != null) {
      this.jdField_a_of_type_Akex.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismissImmediately();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Akex.getCount() > 0) {
      akej.a("0X8009C2B");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    b();
  }
  
  public void onStop()
  {
    a(-1, null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment
 * JD-Core Version:    0.7.0.1
 */