package com.tencent.mobileqq.activity.miniaio;

import afud;
import aful;
import afun;
import afuo;
import afup;
import afus;
import afut;
import afuv;
import afuw;
import afux;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avgj;
import avgk;
import avgx;
import awqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class MiniMsgTabFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  aful jdField_a_of_type_Aful;
  afuo jdField_a_of_type_Afuo;
  public afup a;
  afux jdField_a_of_type_Afux = new afut(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avgj jdField_a_of_type_Avgj;
  private avgk jdField_a_of_type_Avgk = new afus(this);
  private avgx jdField_a_of_type_Avgx;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FPSSwipListView a;
  private MiniAppConfig jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig;
  private String jdField_a_of_type_JavaLangString;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_j_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_k_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_l_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private LinearLayout m;
  
  private Intent a()
  {
    return getActivity().getIntent();
  }
  
  private RecentBaseData a()
  {
    return new RecentItemChatMsgData(new RecentUser("0", 0));
  }
  
  private List<RecentBaseData> a(List<RecentBaseData> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      localObject = new ArrayList();
      return localObject;
    }
    int n = 0;
    for (;;)
    {
      localObject = paramList;
      if (n >= paramList.size()) {
        break;
      }
      localObject = (RecentBaseData)paramList.get(n);
      if (((RecentBaseData)localObject).a() == 6000)
      {
        paramList.remove(localObject);
        return paramList;
      }
      n += 1;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("miniAppID");
    a().getStringExtra("miniAppName");
    boolean bool = a().getBooleanExtra("isOpenMonitorPanel", false);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    Object localObject;
    label80:
    label112:
    int n;
    label133:
    label180:
    label214:
    label235:
    int i1;
    if (bool)
    {
      localObject = "Pref.Off";
      localTextView.setText((CharSequence)localObject);
      bool = a().getBooleanExtra("debugEnable", false);
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label805;
      }
      localObject = "Debug.Off";
      localTextView.setText((CharSequence)localObject);
      if (!a().getBooleanExtra("showShareQQ", false)) {
        break label813;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      b();
      if (!a().getBooleanExtra("showShareQzone", false)) {
        break label825;
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      bool = a().getBooleanExtra("showShareWeChatFriends", false);
      n = a().getIntExtra("key_color_note", 0);
      if (!bool) {
        break label837;
      }
      if (n == 0) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838736);
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!a().getBooleanExtra("showShareWeChatMoment", false)) {
        break label849;
      }
      if (n == 0) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838730);
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!a().getBooleanExtra("showDebug", false)) {
        break label861;
      }
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!a().getBooleanExtra("showMonitor", false)) {
        break label873;
      }
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label256:
      if (!a().getBooleanExtra("showDetail", false)) {
        break label885;
      }
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label277:
      if (!a().getBooleanExtra("showComplaint", false)) {
        break label897;
      }
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label298:
      i1 = a().getIntExtra("topType", 0);
      if (i1 != 0) {
        break label909;
      }
      if (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
        this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840825);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641078));
      label354:
      if (a().getBooleanExtra("isSpecialMiniApp", false)) {
        this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (!a().getBooleanExtra("addShortcut", false)) {
        break label983;
      }
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label397:
      i1 = a().getIntExtra("showBackHome", 0);
      if (i1 != -1) {
        break label995;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label422:
      if (n != 0) {
        break label1058;
      }
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      localObject = getArguments();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig = ((MiniAppConfig)((Bundle)localObject).getParcelable("key_mini_app_config"));
      }
      this.jdField_b_of_type_Int = a().getIntExtra("key_mini_app_version_type", -1);
      this.jdField_d_of_type_Boolean = a().getBooleanExtra("key_mini_app_is_game", false);
      this.jdField_b_of_type_Boolean = a().getBooleanExtra("isFromShareButton", false);
      this.jdField_a_of_type_Boolean = a().getBooleanExtra("isLandscape", false);
      if ("dark".equalsIgnoreCase(a().getStringExtra("menuStyle")))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.86F);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-16777216);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      if ("1108291530".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = a().getBooleanExtra("showKingcardTip", false);
      if (this.jdField_e_of_type_Boolean)
      {
        this.m.setVisibility(0);
        if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_TEXT)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(MiniAppGlobal.KINGCARD_GUIDE_TEXT);
        }
        if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_ICON))
        {
          localObject = MiniAppUtils.getIcon(getActivity(), MiniAppGlobal.KINGCARD_GUIDE_ICON, true, 2130840822, 17, 17);
          if (localObject != null) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      return;
      localObject = "Pref.On";
      break;
      label805:
      localObject = "Debug.On";
      break label80;
      label813:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label112;
      label825:
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label133;
      label837:
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label180;
      label849:
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label214;
      label861:
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label235;
      label873:
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label256;
      label885:
      this.jdField_k_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label277;
      label897:
      this.jdField_l_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label298;
      label909:
      if ((i1 == -11) && (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
      {
        this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label354;
      }
      if (this.jdField_h_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
        this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840826);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641070));
      break label354;
      label983:
      this.jdField_j_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label397;
      label995:
      if (i1 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
        break label422;
      }
      if (i1 != 0) {
        break label422;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      break label422;
      label1058:
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (n == 1)
      {
        this.jdField_l_of_type_AndroidWidgetTextView.setText(2131625288);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841708);
      }
      else if (n == 2)
      {
        this.jdField_l_of_type_AndroidWidgetTextView.setText(2131625291);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841710);
      }
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Bundle localBundle;
    if ((localObject instanceof RecentUserBaseData))
    {
      localObject = (RecentUserBaseData)localObject;
      localBundle = new Bundle();
      localBundle.putString("key_mini_app_share_chat_uin", ((RecentUserBaseData)localObject).a());
      localBundle.putString("key_mini_app_share_chat_name", ((RecentUserBaseData)localObject).b());
      localBundle.putInt("key_mini_app_share_chat_type", ((RecentUserBaseData)localObject).a());
      if (!this.jdField_c_of_type_Boolean) {
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break label242;
        }
      }
    }
    label193:
    label242:
    for (localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).a();
        if (localObject == null) {
          break label193;
        }
        paramInt = ((QQMessageFacade)localObject).c();
        label114:
        localObject = a();
        ((Intent)localObject).putExtra("miniAppID", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("clickID", 12);
        ((Intent)localObject).putExtra("param_proc_badge_count", paramInt);
        ((Intent)localObject).putExtras(localBundle);
        getActivity().setResult(-1, (Intent)localObject);
        getActivity().finish();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniMsgTabFragment", 2, "handleShareChatItemClick");
        }
        return;
        localObject = null;
        break;
        paramInt = 0;
        break label114;
        a(12, localBundle);
      }
      QLog.e("MiniMsgTabFragment", 2, "handleShareChatItemClick : position = " + paramInt + ", data is null!");
      return;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new afuw(this, paramInt, paramBundle));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  private void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Avgx = new avgx();
    paramActivity = this.jdField_a_of_type_Avgx.a(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.addAll(a(paramActivity));
  }
  
  private void b()
  {
    a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniMsgTabFragment", 2, "initShareChatList shareChatListData is empty");
      }
      return;
    }
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Avgj = new avgj(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 1);
    this.jdField_a_of_type_Avgj.a(this.jdField_a_of_type_Avgk);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Avgj);
    this.jdField_a_of_type_Avgj.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setAnimationListener(new afuv(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
  }
  
  private void d()
  {
    List localList = this.jdField_a_of_type_Aful.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int);
    if ((!this.jdField_c_of_type_Boolean) && (localList.size() == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = a();
      }
      localList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131311698).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afup.a(localList);
      return;
      this.jdField_b_of_type_AndroidViewView.findViewById(2131311698).setVisibility(0);
    }
  }
  
  public int a()
  {
    int n = 0;
    QQAppInterface localQQAppInterface = getActivity().app;
    if (localQQAppInterface != null) {
      n = localQQAppInterface.a().c();
    }
    return n;
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
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      d();
    }
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Afup.getCount() < 1) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MiniMsgTabFragment.5(this), 100L);
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
    int n = 1;
    int i1 = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramView.getId() == 2131311698) && (a().getBooleanExtra("key_mini_msgtab_isneed_back_conversation", false)))
    {
      paramView = (Intent)a().getParcelableExtra("key_mini_msgtab_back_pending_intent");
      if (paramView != null)
      {
        paramView.setClass(getActivity(), SplashActivity.class);
        afun.a().c();
        if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          break label583;
        }
      }
    }
    label573:
    label578:
    label583:
    for (localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      startActivity(paramView);
      paramView = localObject2;
      if (localObject1 != null) {
        paramView = ((QQAppInterface)localObject1).a();
      }
      if (paramView != null) {}
      for (n = paramView.c();; n = 0)
      {
        paramView = a();
        paramView.putExtra("param_proc_badge_count", n);
        getActivity().setResult(-1, paramView);
        getActivity().finish();
        return;
        paramView = new Intent();
        paramView.setClass(getActivity(), SplashActivity.class);
        paramView.setFlags(67108864);
        paramView.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
        paramView.putExtra("fragment_id", 1);
        break;
      }
      if (paramView.getId() == 2131296648) {
        n = 0;
      }
      for (;;)
      {
        if (!this.jdField_c_of_type_Boolean) {
          if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            break label573;
          }
        }
        for (paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramView = null)
        {
          if (paramView != null) {
            localObject1 = paramView.a();
          }
          if (localObject1 != null) {
            i1 = ((QQMessageFacade)localObject1).c();
          }
          paramView = a();
          paramView.putExtra("miniAppID", this.jdField_a_of_type_JavaLangString);
          paramView.putExtra("clickID", n);
          paramView.putExtra("param_proc_badge_count", i1);
          getActivity().setResult(-1, paramView);
          getActivity().finish();
          return;
          if (paramView.getId() == 2131304652) {
            break;
          }
          if (paramView.getId() == 2131304653)
          {
            n = 5;
            break;
          }
          if (paramView.getId() == 2131304654)
          {
            n = 6;
            break;
          }
          if (paramView.getId() == 2131304655)
          {
            n = 7;
            break;
          }
          if (paramView.getId() == 2131304625)
          {
            n = 2;
            break;
          }
          if (paramView.getId() == 2131304650)
          {
            n = 3;
            break;
          }
          if (paramView.getId() == 2131304627)
          {
            if (this.jdField_b_of_type_Int == -1) {
              break label578;
            }
            if (this.jdField_d_of_type_Boolean)
            {
              MainPageFragment.launchForMiniGame(getActivity(), this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig, 1, true);
              n = -1;
              break;
            }
            MainPageFragment.launch(getActivity(), this.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppConfig, this.jdField_b_of_type_Int);
            n = -1;
            break;
          }
          if (paramView.getId() == 2131304629)
          {
            n = -1;
            break;
          }
          if (paramView.getId() == 2131304662)
          {
            n = 8;
            break;
          }
          if (paramView.getId() == 2131304614)
          {
            n = 10;
            break;
          }
          if (paramView.getId() == 2131304616)
          {
            n = 9;
            break;
          }
          if (paramView.getId() == 2131304620)
          {
            n = 11;
            break;
          }
          if (paramView.getId() != 2131304615) {
            break label578;
          }
          n = 13;
          break;
          a(n, null);
          return;
        }
        n = -1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = a().getIntExtra("key_mini_msgtab_type", 0);
    this.jdField_c_of_type_Boolean = a().getBooleanExtra("key_mini_msgtab_need_action_sheet", false);
    this.jdField_e_of_type_Int = a().getIntExtra("key_mini_msgtab_businame", 0);
    int n = a();
    awqx.b(null, "dc00898", "", "", "0X800A0F6", "0X800A0F6", this.jdField_e_of_type_Int, 1, "" + n, "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity().app == null) {
      return null;
    }
    this.jdField_c_of_type_Int = getActivity().getResources().getDisplayMetrics().heightPixels;
    this.jdField_d_of_type_Int = ImmersiveUtils.getStatusBarHeight(getActivity());
    a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131493716, paramViewGroup, false);
    if (paramLayoutInflater == null)
    {
      getActivity().finish();
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131296648);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramLayoutInflater.findViewById(2131304815));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollTouchMode(1);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOverScrollFlingMode(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131304613));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304616));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641074));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304652));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641068));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304653));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641066));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304654));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304635));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641073));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304655));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304636));
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641067));
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304625));
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641076));
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304650));
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641071));
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304662));
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641077));
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304615));
    this.jdField_i_of_type_AndroidWidgetLinearLayout.setContentDescription(getActivity().getResources().getString(2131625288));
    this.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_j_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304614));
    this.jdField_j_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641065));
    this.jdField_j_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_k_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304627));
    this.jdField_k_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641075));
    this.jdField_k_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_l_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131304620));
    this.jdField_l_of_type_AndroidWidgetLinearLayout.setContentDescription(ajjy.a(2131641069));
    this.jdField_l_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304629));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131641072));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304658));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304624));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304671));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304670));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131310251));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304637));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304659));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304638));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304667));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304624));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramLayoutInflater.findViewById(2131309798));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131304619));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131304618));
    this.m = ((LinearLayout)paramLayoutInflater.findViewById(2131303182));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131303183));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131303184));
    paramViewGroup = View.inflate(getActivity(), 2131493715, null);
    paramViewGroup.findViewById(2131299411).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(paramViewGroup);
    a();
    if (QLog.isColorLevel()) {
      QLog.d("MiniMsgTabFragment", 0, "mini msg tab oncreateView.mFilterMsgType " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setMaxHeight(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight());
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.removeHeaderView(paramViewGroup);
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Afup = new afup(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this.jdField_a_of_type_Afux);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_Afup);
      this.jdField_a_of_type_Aful = ((aful)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(147));
      this.jdField_a_of_type_Afuo = afun.a().a();
      return paramLayoutInflater;
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getLayoutParams();
      paramBundle.topMargin = 0;
      paramViewGroup.findViewById(2131311698).setOnClickListener(this);
      paramViewGroup.findViewById(2131311698).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setLayoutParams(paramBundle);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a();
    }
    if (this.jdField_a_of_type_Avgj != null) {
      this.jdField_a_of_type_Avgj.a();
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
    if (this.jdField_a_of_type_Afup.getCount() > 0) {
      afud.a("0X8009C2B");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    d();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment
 * JD-Core Version:    0.7.0.1
 */