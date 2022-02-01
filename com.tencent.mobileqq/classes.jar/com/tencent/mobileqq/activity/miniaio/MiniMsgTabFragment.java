package com.tencent.mobileqq.activity.miniaio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class MiniMsgTabFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  MiniMsgHandler jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgHandler;
  MiniMsgIPCServer.MiniProcInfo jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
  MiniMsgTabAdapter jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter;
  MiniMsgTabFragment.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$OnItemClickListener = new MiniMsgTabFragment.2(this);
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = new MiniMsgTabFragment.1(this);
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = true;
  
  private Intent a()
  {
    if (getBaseActivity() != null) {
      return getBaseActivity().getIntent();
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
    if (a().getBooleanExtra("showShareDataline", false)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
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
    int i;
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4))
    {
      i = 0;
    }
    else
    {
      this.jdField_f_of_type_Int += 1;
      i = 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int j = a().getIntExtra("key_color_note", 0);
    if (j != 0) {
      if (j == 1) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
      } else if (j == 2) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
      }
    }
    j = a().getIntExtra("topType", 0);
    a().getBooleanExtra("isSpecialMiniApp", false);
    bool2 = a().getBooleanExtra("is_limited_access_app", false);
    if ((!a().getBooleanExtra("disableAddToMyApp", false)) && (!bool2)) {
      if (j == 0) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
      } else if (j != -11) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
      }
    }
    if ((a().getBooleanExtra("addShortcut", false)) && (!bool2)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
    }
    j = a().getIntExtra("showBackHome", -1);
    if ((j != -1) && (j == 1)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(81));
    }
    if (a().getBooleanExtra("showRestartMiniApp", true)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(128));
    }
    if (!a().getBooleanExtra("disableAddToMyFavor", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
    }
    if ((a().getBooleanExtra("setToTroop", false)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isTroopAdminOrCreated())) {
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
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(151));
    }
    bool2 = a().getBooleanExtra("showDebug", false);
    bool3 = a().getBooleanExtra("debugEnable", false);
    if (bool2) {
      if (bool3) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(75));
      } else {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
      }
    }
    bool2 = a().getBooleanExtra("showMonitor", false);
    bool3 = a().getBooleanExtra("isOpenMonitorPanel", false);
    if (bool2) {
      if (bool3) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(80));
      } else {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(79));
      }
    }
    Object localObject = getArguments();
    if (localObject != null) {
      this.jdField_a_of_type_AndroidOsParcelable = ((Bundle)localObject).getParcelable("key_mini_app_config");
    }
    this.jdField_b_of_type_Int = a().getIntExtra("key_mini_app_version_type", -1);
    this.jdField_b_of_type_Boolean = a().getBooleanExtra("isFromShareButton", false);
    this.jdField_a_of_type_Boolean = a().getBooleanExtra("isLandscape", false);
    if (("1108291530".equals(this.jdField_a_of_type_JavaLangString)) || (MiniAppSecurityUtil.doCheckSafeUnblockWithLogin(this.jdField_a_of_type_JavaLangString))) {
      i = 0;
    }
    this.jdField_e_of_type_Boolean = a().getBooleanExtra("showKingcardTip", false);
    bool2 = this.jdField_e_of_type_Boolean;
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("miniAppID");
    this.jdField_b_of_type_JavaLangString = a().getStringExtra("miniAppName");
    getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_miniapp");
    localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = getBaseActivity();
    ((ShareActionSheetV2.Param)localObject).canceledOnTouchOutside = false;
    ((ShareActionSheetV2.Param)localObject).flagNotTouchModal = true;
    ((ShareActionSheetV2.Param)localObject).dimAmount = 0.0F;
    ((ShareActionSheetV2.Param)localObject).lp = new ViewGroup.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    if (bool1)
    {
      this.jdField_f_of_type_Int += 1;
      localObject = new Intent();
      ((Intent)localObject).putExtra("forward_type", 27);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
    }
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle("");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new MiniMsgTabFragment.3(this));
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null) {
      ((ShareActionSheet)localObject).dismissImmediately();
    }
    if (getBaseActivity() == null)
    {
      QLog.e("MiniMsgTabFragment", 1, "getActivity is null when calling dismissMsgFragment");
      return;
    }
    boolean bool = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
    QQMessageFacade localQQMessageFacade = null;
    if (bool) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localQQMessageFacade = ((QQAppInterface)localObject).getMessageFacade();
    }
    int i;
    if (localQQMessageFacade != null) {
      i = localQQMessageFacade.c();
    } else {
      i = 0;
    }
    localObject = a();
    ((Intent)localObject).putExtra("miniAppID", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("clickID", paramInt);
    if (paramBundle != null) {
      ((Intent)localObject).putExtras(paramBundle);
    }
    ((Intent)localObject).putExtra("param_proc_badge_count", i);
    getBaseActivity().setResult(-1, (Intent)localObject);
    getBaseActivity().finish();
  }
  
  private void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareToChatDirectly handleShareChatItemClick, uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",uinType:");
    localStringBuilder.append(paramInt);
    QLog.d("MiniMsgTabFragment", 2, localStringBuilder.toString());
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
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgHandler.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int);
    if ((!this.jdField_c_of_type_Boolean) && (localList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = a();
      }
      localList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131378953).setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.findViewById(2131378953).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter.a(localList);
  }
  
  public int a()
  {
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if ((localQQAppInterface != null) && (localQQAppInterface.getMessageFacade() != null)) {
      return localQQAppInterface.getMessageFacade().c();
    }
    return 0;
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
    MiniMsgTabAdapter localMiniMsgTabAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter;
    if (localMiniMsgTabAdapter != null) {
      localMiniMsgTabAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      b();
      try
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter.getCount() < 1) && (this.jdField_a_of_type_AndroidOsHandler != null))
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MiniMsgTabFragment.4(this), 100L);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("MiniMsgTabFragment", 1, "onActivityResult error", paramIntent);
      }
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
    int k = paramView.getId();
    int i = -1;
    Object localObject2 = null;
    int j = 0;
    if ((k == 2131378953) && (a().getBooleanExtra("key_mini_msgtab_isneed_back_conversation", false)))
    {
      Object localObject1 = (Intent)a().getParcelableExtra("key_mini_msgtab_back_pending_intent");
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getBaseActivity(), SplashActivity.class);
        MiniMsgIPCServer.a().c();
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getBaseActivity(), SplashActivity.class);
        ((Intent)localObject1).setFlags(67108864);
        ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
        ((Intent)localObject1).putExtra("fragment_id", 1);
      }
      QQAppInterface localQQAppInterface;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } else {
        localQQAppInterface = null;
      }
      startActivity((Intent)localObject1);
      localObject1 = localObject2;
      if (localQQAppInterface != null) {
        localObject1 = localQQAppInterface.getMessageFacade();
      }
      i = j;
      if (localObject1 != null) {
        i = ((QQMessageFacade)localObject1).c();
      }
      localObject1 = a();
      ((Intent)localObject1).putExtra("param_proc_badge_count", i);
      getBaseActivity().setResult(-1, (Intent)localObject1);
      getBaseActivity().finish();
    }
    else
    {
      if (paramView.getId() == 2131362288) {
        i = 0;
      }
      a(i, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = a().getIntExtra("key_mini_msgtab_type", 0);
    this.jdField_c_of_type_Boolean = a().getBooleanExtra("key_mini_msgtab_need_action_sheet", false);
    this.jdField_e_of_type_Int = a().getIntExtra("key_mini_msgtab_businame", 0);
    int i = a();
    int j = this.jdField_e_of_type_Int;
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(i);
    ReportController.b(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", j, 1, paramBundle.toString(), "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Object localObject = getBaseActivity().app;
    paramBundle = null;
    if (localObject == null)
    {
      paramLayoutInflater = paramBundle;
    }
    else
    {
      this.jdField_c_of_type_Int = getBaseActivity().getResources().getDisplayMetrics().heightPixels;
      this.jdField_d_of_type_Int = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      localObject = a();
      paramLayoutInflater = paramLayoutInflater.inflate(2131559413, paramViewGroup, false);
      if (paramLayoutInflater == null)
      {
        getBaseActivity().finish();
        paramLayoutInflater = paramBundle;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
        this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131362288);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#80000000"));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramLayoutInflater.findViewById(2131371547));
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollTouchMode(1);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollFlingMode(1);
        paramViewGroup = View.inflate(getBaseActivity(), 2131559412, null);
        paramViewGroup.findViewById(2131365474).setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewView = paramViewGroup;
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(paramViewGroup);
        a();
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("mini msg tab oncreateView.mFilterMsgType ");
          paramBundle.append(this.jdField_a_of_type_Int);
          QLog.d("MiniMsgTabFragment", 0, paramBundle.toString());
        }
        if (this.jdField_c_of_type_Boolean)
        {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
          if (paramBundle != null) {
            paramBundle.show();
          }
          int i = this.jdField_c_of_type_Int;
          int j = this.jdField_d_of_type_Int;
          int k = this.jdField_f_of_type_Int;
          int m = DisplayUtil.dip2px(getBaseActivity(), 120.0F);
          int n = DisplayUtil.dip2px(getBaseActivity(), 36.0F);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setMaxHeight(i - j - k * m - n);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(paramViewGroup);
        }
        else
        {
          paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLayoutParams();
          paramBundle.topMargin = 0;
          paramViewGroup.findViewById(2131378953).setOnClickListener(this);
          paramViewGroup.findViewById(2131378953).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setLayoutParams(paramBundle);
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
          if (paramViewGroup != null) {
            paramViewGroup.dismissImmediately();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter = new MiniMsgTabAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$OnItemClickListener);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter);
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgHandler = ((MiniMsgHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER));
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo = MiniMsgIPCServer.a().a();
        if ((localObject != null) && (!((Intent)localObject).getBooleanExtra("showChatNewsList", true)))
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(8);
        }
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter;
    if (localObject != null) {
      ((MiniMsgTabAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
    if (localObject != null) {
      ((ShareActionSheet)localObject).dismissImmediately();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabAdapter.getCount() > 0) {
      MiniChatReportHelper.a("0X8009C2B");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment
 * JD-Core Version:    0.7.0.1
 */