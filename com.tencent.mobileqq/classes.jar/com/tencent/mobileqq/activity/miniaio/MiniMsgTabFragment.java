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
  private ShareActionSheet.OnItemClickListener A = new MiniMsgTabFragment.1(this);
  private int B = 0;
  FPSSwipListView a;
  MiniMsgTabAdapter b;
  MiniMsgHandler c;
  MiniMsgIPCServer.MiniProcInfo d;
  MiniMsgTabFragment.OnItemClickListener e = new MiniMsgTabFragment.2(this);
  private QQAppInterface f;
  private View g;
  private String h = null;
  private String i = null;
  private Animation j;
  private boolean k = false;
  private boolean l = false;
  private Handler m;
  private int n;
  private boolean o;
  private boolean p;
  private Parcelable q;
  private int r;
  private int s;
  private int t;
  private View u;
  private RecentBaseData v;
  private int w;
  private boolean x;
  private boolean y = true;
  private ShareActionSheet z;
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = this.z;
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
    int i1;
    if (localQQMessageFacade != null) {
      i1 = localQQMessageFacade.y();
    } else {
      i1 = 0;
    }
    localObject = c();
    ((Intent)localObject).putExtra("miniAppID", this.h);
    ((Intent)localObject).putExtra("clickID", paramInt);
    if (paramBundle != null) {
      ((Intent)localObject).putExtras(paramBundle);
    }
    ((Intent)localObject).putExtra("param_proc_badge_count", i1);
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
    this.B = 1;
    ArrayList localArrayList1 = new ArrayList();
    boolean bool1 = c().getBooleanExtra("showShareQQ", false);
    if (bool1) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    if (c().getBooleanExtra("showShareDataline", false)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    }
    boolean bool2 = c().getBooleanExtra("showShareQzone", false);
    if (bool2) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    boolean bool3 = c().getBooleanExtra("showShareWeChatFriends", false);
    if (bool3) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    boolean bool4 = c().getBooleanExtra("showShareWeChatMoment", false);
    if (bool4) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    int i1;
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4))
    {
      i1 = 0;
    }
    else
    {
      this.B += 1;
      i1 = 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i2 = c().getIntExtra("key_color_note", 0);
    if (i2 != 0) {
      if (i2 == 1) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
      } else if (i2 == 2) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
      }
    }
    i2 = c().getIntExtra("topType", 0);
    c().getBooleanExtra("isSpecialMiniApp", false);
    bool2 = c().getBooleanExtra("is_limited_access_app", false);
    if ((!c().getBooleanExtra("disableAddToMyApp", false)) && (!bool2)) {
      if (i2 == 0) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
      } else if (i2 != -11) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
      }
    }
    if ((c().getBooleanExtra("addShortcut", false)) && (!bool2)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
    }
    i2 = c().getIntExtra("showBackHome", -1);
    if ((i2 != -1) && (i2 == 1)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(81));
    }
    if (c().getBooleanExtra("showRestartMiniApp", true)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(128));
    }
    if (!c().getBooleanExtra("disableAddToMyFavor", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
    }
    if ((c().getBooleanExtra("setToTroop", false)) && (((IMiniAppService)QRoute.api(IMiniAppService.class)).isTroopAdminOrCreated())) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(158));
    }
    if (c().getBooleanExtra("addToCurrentTroop", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(159));
    }
    if (c().getBooleanExtra("showDetail", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(78));
    }
    if (c().getBooleanExtra("showSetting", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(83));
    }
    if (c().getBooleanExtra("showComplaint", false)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(151));
    }
    bool2 = c().getBooleanExtra("showDebug", false);
    bool3 = c().getBooleanExtra("debugEnable", false);
    if (bool2) {
      if (bool3) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(75));
      } else {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(74));
      }
    }
    bool2 = c().getBooleanExtra("showMonitor", false);
    bool3 = c().getBooleanExtra("isOpenMonitorPanel", false);
    if (bool2) {
      if (bool3) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(80));
      } else {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(79));
      }
    }
    Object localObject = getArguments();
    if (localObject != null) {
      this.q = ((Bundle)localObject).getParcelable("key_mini_app_config");
    }
    this.r = c().getIntExtra("key_mini_app_version_type", -1);
    this.l = c().getBooleanExtra("isFromShareButton", false);
    this.k = c().getBooleanExtra("isLandscape", false);
    if (("1108291530".equals(this.h)) || (MiniAppSecurityUtil.doCheckSafeUnblockWithLogin(this.h))) {
      i1 = 0;
    }
    this.x = c().getBooleanExtra("showKingcardTip", false);
    bool2 = this.x;
    this.h = c().getStringExtra("miniAppID");
    this.i = c().getStringExtra("miniAppName");
    getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_miniapp");
    localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = getBaseActivity();
    ((ShareActionSheetV2.Param)localObject).canceledOnTouchOutside = false;
    ((ShareActionSheetV2.Param)localObject).flagNotTouchModal = true;
    ((ShareActionSheetV2.Param)localObject).dimAmount = 0.0F;
    ((ShareActionSheetV2.Param)localObject).lp = new ViewGroup.LayoutParams(-1, -2);
    this.z = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    if (bool1)
    {
      this.B += 1;
      localObject = new Intent();
      ((Intent)localObject).putExtra("forward_type", 27);
      this.z.setIntentForStartForwardRecentActivity((Intent)localObject);
      this.z.setRowVisibility(0, 0, 0);
    }
    else
    {
      this.z.setRowVisibility(8, 0, 0);
    }
    if (i1 == 0) {
      this.z.setActionSheetTitle("");
    }
    this.z.setActionSheetItems(localArrayList1, localArrayList2);
    this.z.setItemClickListenerV2(this.A);
    this.z.setCancelListener(new MiniMsgTabFragment.3(this));
  }
  
  private Intent c()
  {
    if (getBaseActivity() != null) {
      return getBaseActivity().getIntent();
    }
    QLog.e("MiniMsgTabFragment", 1, "Fragment.getActivity() is null when calling getIntent()");
    return new Intent();
  }
  
  private void d()
  {
    if (!this.y)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniMsgTabFragment", 2, "mShouldUpdateChatData: false");
      }
      return;
    }
    List localList = this.c.a(this.w, this.n);
    if ((!this.o) && (localList.size() == 0))
    {
      if (this.v == null) {
        this.v = e();
      }
      localList.add(this.v);
      this.u.findViewById(2131447655).setVisibility(8);
    }
    else
    {
      this.u.findViewById(2131447655).setVisibility(0);
    }
    this.b.a(localList);
  }
  
  private RecentBaseData e()
  {
    return new RecentItemChatMsgData(new RecentUser("0", 0));
  }
  
  public int a()
  {
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if ((localQQAppInterface != null) && (localQQAppInterface.getMessageFacade() != null)) {
      return localQQAppInterface.getMessageFacade().y();
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
    MiniMsgTabAdapter localMiniMsgTabAdapter = this.b;
    if (localMiniMsgTabAdapter != null) {
      localMiniMsgTabAdapter.a(this.f);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.g.setVisibility(0);
      d();
      try
      {
        if ((this.k) && (this.b.getCount() < 1) && (this.m != null))
        {
          this.m.postDelayed(new MiniMsgTabFragment.4(this), 100L);
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
    if (this.o)
    {
      a(-1, null);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i3 = paramView.getId();
    int i1 = -1;
    Object localObject2 = null;
    int i2 = 0;
    if ((i3 == 2131447655) && (c().getBooleanExtra("key_mini_msgtab_isneed_back_conversation", false)))
    {
      Object localObject1 = (Intent)c().getParcelableExtra("key_mini_msgtab_back_pending_intent");
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getBaseActivity(), SplashActivity.class);
        MiniMsgIPCServer.a().e();
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(getBaseActivity(), SplashActivity.class);
        ((Intent)localObject1).setFlags(67108864);
        ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.a);
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
      i1 = i2;
      if (localObject1 != null) {
        i1 = ((QQMessageFacade)localObject1).y();
      }
      localObject1 = c();
      ((Intent)localObject1).putExtra("param_proc_badge_count", i1);
      getBaseActivity().setResult(-1, (Intent)localObject1);
      getBaseActivity().finish();
    }
    else
    {
      if (paramView.getId() == 2131427887) {
        i1 = 0;
      }
      a(i1, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.n = c().getIntExtra("key_mini_msgtab_type", 0);
    this.o = c().getBooleanExtra("key_mini_msgtab_need_action_sheet", false);
    this.w = c().getIntExtra("key_mini_msgtab_businame", 0);
    int i1 = a();
    int i2 = this.w;
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(i1);
    ReportController.b(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", i2, 1, paramBundle.toString(), "", "", "");
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
      this.s = getBaseActivity().getResources().getDisplayMetrics().heightPixels;
      this.t = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      localObject = c();
      paramLayoutInflater = paramLayoutInflater.inflate(2131625379, paramViewGroup, false);
      if (paramLayoutInflater == null)
      {
        getBaseActivity().finish();
        paramLayoutInflater = paramBundle;
      }
      else
      {
        this.f = getBaseActivity().app;
        this.g = paramLayoutInflater.findViewById(2131427887);
        this.g.setOnClickListener(this);
        this.g.setBackgroundColor(Color.parseColor("#80000000"));
        this.a = ((FPSSwipListView)paramLayoutInflater.findViewById(2131438926));
        this.a.setOverScrollTouchMode(1);
        this.a.setOverScrollFlingMode(1);
        paramViewGroup = View.inflate(getBaseActivity(), 2131625378, null);
        paramViewGroup.findViewById(2131431689).setOnClickListener(this);
        this.u = paramViewGroup;
        this.a.addHeaderView(paramViewGroup);
        b();
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("mini msg tab oncreateView.mFilterMsgType ");
          paramBundle.append(this.n);
          QLog.d("MiniMsgTabFragment", 0, paramBundle.toString());
        }
        if (this.o)
        {
          paramBundle = this.z;
          if (paramBundle != null) {
            paramBundle.show();
          }
          int i1 = this.s;
          int i2 = this.t;
          int i3 = this.B;
          int i4 = DisplayUtil.dip2px(getBaseActivity(), 120.0F);
          int i5 = DisplayUtil.dip2px(getBaseActivity(), 36.0F);
          this.a.setMaxHeight(i1 - i2 - i3 * i4 - i5);
          this.a.removeHeaderView(paramViewGroup);
        }
        else
        {
          paramBundle = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
          paramBundle.topMargin = 0;
          paramViewGroup.findViewById(2131447655).setOnClickListener(this);
          paramViewGroup.findViewById(2131447655).setVisibility(0);
          this.a.setLayoutParams(paramBundle);
          paramViewGroup = this.z;
          if (paramViewGroup != null) {
            paramViewGroup.dismissImmediately();
          }
        }
        this.b = new MiniMsgTabAdapter(this.f, getBaseActivity(), this.a, this.e);
        this.a.setAdapter(this.b);
        this.c = ((MiniMsgHandler)this.f.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER));
        this.d = MiniMsgIPCServer.a().b();
        if ((localObject != null) && (!((Intent)localObject).getBooleanExtra("showChatNewsList", true)))
        {
          this.y = false;
          this.a.setVisibility(8);
        }
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.j != null)
    {
      this.g.clearAnimation();
      this.j.cancel();
      this.j.setAnimationListener(null);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((MiniMsgTabAdapter)localObject).b();
    }
    localObject = this.z;
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
    if (this.b.getCount() > 0) {
      MiniChatReportHelper.a("0X8009C2B");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    d();
  }
  
  public void onStop()
  {
    a(-1, null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment
 * JD-Core Version:    0.7.0.1
 */