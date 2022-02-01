package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GameMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.GameMsgTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.api.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgAddFriendDialog;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.util.GameMsgAddFriendRules;
import com.tencent.mobileqq.gamecenter.util.GameMsgSayHelloRules;
import com.tencent.mobileqq.gamecenter.util.GameMsgSendTimesRules;
import com.tencent.mobileqq.gamecenter.util.GameMsgStrangerRules;
import com.tencent.mobileqq.gamecenter.view.BubblePopupWindow;
import com.tencent.mobileqq.gamecenter.view.GameAioViewSwitcher;
import com.tencent.mobileqq.gamecenter.view.GameMsgQuickReplyView;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class GameMsgChatPie
  extends BaseChatPie
{
  public static final String f;
  public static final String g;
  public static String h;
  private static final String i;
  private static final String j;
  private boolean N;
  private boolean O;
  private boolean P = false;
  private boolean Q;
  private boolean R = false;
  private boolean S = false;
  private boolean T = true;
  private GameMsgChatPie.GameUsrAvatarClickLis jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  private GameMsgChatPie.StrangerRecomInfo jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
  private GameMsgTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar;
  protected MessageObserver a;
  private GameDetailInfo jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  private GameMsgManager jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager = null;
  private GameCenterUnissoObserver jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoObserver = new GameMsgChatPie.1(this);
  private GameMsgSayHelloRules jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules;
  private GameMsgSendTimesRules jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules;
  private GameMsgStrangerRules jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgStrangerRules;
  private BubblePopupWindow jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow;
  private GameAioViewSwitcher jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher;
  private GameMsgQuickReplyView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GameMsgChatPie.6(this);
  private GameMsgChatPie.GameUsrAvatarClickLis jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  private GameDetailInfo jdField_b_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<GameMsgChatPie.GamePriorityInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new GameMsgChatPie.7(this);
  private RelativeLayout e;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString;
  private String n;
  private String o = "";
  
  static
  {
    jdField_f_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
    jdField_g_of_type_JavaLangString = jdField_f_of_type_JavaLangString + ".strangerRecom";
    i = HardCodeUtil.a(2131705072);
    jdField_j_of_type_JavaLangString = HardCodeUtil.a(2131705071);
  }
  
  public GameMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new GameMsgChatPie.10(this);
  }
  
  private boolean F()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_f_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (c() == null) {
      return false;
    }
    GameMsgUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, c());
    return true;
  }
  
  private String a(GameDetailInfo paramGameDetailInfo, int paramInt)
  {
    if (paramGameDetailInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramGameDetailInfo.jdField_j_of_type_JavaLangString).append(paramGameDetailInfo.jdField_l_of_type_JavaLangString);
    if (paramInt == 0) {
      localStringBuilder.append("-").append("来自好友推荐");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if ((1 == paramInt) || (3 == paramInt)) {
        localStringBuilder.append("-").append("QQ好友");
      } else if (2 == paramInt) {
        localStringBuilder.append("-").append("游戏好友");
      }
    }
  }
  
  private void a(GameMsgChatPie.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {
      QLog.i(jdField_f_of_type_JavaLangString, 1, "[doOnButtonClick] buttonInfo is null.");
    }
    for (;;)
    {
      return;
      if (paramButtonInfo.jdField_a_of_type_Int == 1)
      {
        paramButtonInfo = paramButtonInfo.jdField_a_of_type_JavaLangString;
        Intent localIntent = new Intent(a(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramButtonInfo);
        a().startActivity(localIntent);
      }
      while ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        return;
        if ((paramButtonInfo.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
        }
      }
    }
  }
  
  private void a(GameMsgChatPie.StrangerRecomInfo paramStrangerRecomInfo)
  {
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(paramStrangerRecomInfo);
    }
  }
  
  private void a(GameDetailInfo paramGameDetailInfo)
  {
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(paramGameDetailInfo);
    }
  }
  
  private void a(String paramString, View paramView)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.isShowing())) {
      return;
    }
    try
    {
      int i2 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 9.0F);
      int i1 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 11.0F);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      localTextView.setId(2131379091);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 13.0F);
      localTextView.setText(paramString);
      localTextView.setTextColor(-1);
      localTextView.setPadding(i1, i2, i1, i2);
      i2 = (int)localTextView.getPaint().measureText(paramString);
      int i3 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 5.0F);
      int i4 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 6.5F);
      int i5 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 11.0F);
      int i6 = -i2 / 2;
      int i7 = DisplayUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 5.0F);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow = new BubblePopupWindow(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.setAnimationStyle(2131755337);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.a(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.setContentView(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.setWidth(i1 * 2 + i2);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.a(i5, i4);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.a(i5 / 2);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.b(-721420288);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.c(i3);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.showAsDropDown(paramView, i6, i7, 80);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_f_of_type_JavaLangString, 1, "showAsDropDown", paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, GameMsgChatPie.ButtonInfo paramButtonInfo1, GameMsgChatPie.ButtonInfo paramButtonInfo2)
  {
    if ((paramButtonInfo1 == null) && (paramButtonInfo2 == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        if ((paramButtonInfo1 != null) && (paramButtonInfo2 != null)) {
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, paramString1, paramString2, paramButtonInfo1.b, paramButtonInfo2.b, new GameMsgChatPie.2(this, paramButtonInfo2), new GameMsgChatPie.3(this, paramButtonInfo1));
        }
        while (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          return;
          if (paramButtonInfo1 != null) {
            this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, paramString1, paramString2, paramButtonInfo1.b, "", null, new GameMsgChatPie.4(this, paramButtonInfo1));
          }
        }
      }
    }
  }
  
  private void a(List<String> paramList, boolean paramBoolean)
  {
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131377172));
    }
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher = new GameAioViewSwitcher(a());
        localObject = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, a().getResources()), AIOUtils.a(24.0F, a().getResources()));
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher, 0, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher.setOnClickListener(new GameMsgChatPie.5(this));
        this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        this.jdField_l_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850830);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_l_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
        this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if ((paramList != null) && (paramList.size() > 0)) {
        if (paramBoolean)
        {
          this.Q = true;
          localObject = i;
          this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher.setData(paramList);
          if (this.Q)
          {
            u(true);
            paramList = Message.obtain();
            paramList.what = 1;
            paramList.obj = localObject;
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramList);
          }
        }
      }
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          return;
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
          if (!((SharedPreferences)localObject).getBoolean("sp_pubacc_msg_showed_red_hot", false))
          {
            this.Q = true;
            ((SharedPreferences)localObject).edit().putBoolean("sp_pubacc_msg_showed_red_hot", true).commit();
          }
          localObject = jdField_j_of_type_JavaLangString;
        }
      }
      QLog.d(jdField_f_of_type_JavaLangString, 2, "[updateRight2Icon] mUrls list is null or empty.");
      return;
    }
    QLog.e(jdField_f_of_type_JavaLangString, 1, "[updateRight2Icon] mRight2 view is null, add view failed.");
  }
  
  private void b(GameDetailInfo paramGameDetailInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_f_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramGameDetailInfo != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo == null)
        {
          QLog.w(jdField_f_of_type_JavaLangString, 1, "detail or strangerRecom info is null. detail:" + paramGameDetailInfo + ",strangerRecom:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo);
          this.d.setVisibility(4);
          this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131692836));
          return;
        }
        paramGameDetailInfo.a();
        if (paramGameDetailInfo.jdField_a_of_type_Int > 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
          }
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
          if (paramGameDetailInfo.jdField_a_of_type_Int == 1)
          {
            i1 = 2130840323;
            this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(a().getResources().getDrawable(i1));
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramGameDetailInfo.h))
          {
            this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
            ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(18.0F, BaseApplication.getContext().getResources());
            ((LinearLayout.LayoutParams)localObject).height = AIOUtils.a(18.0F, BaseApplication.getContext().getResources());
            localObject = URLDrawable.getDrawable(paramGameDetailInfo.h);
            this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          if (1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int) {
            break label460;
          }
          Object localObject = new StringBuilder(100);
          ((StringBuilder)localObject).append(paramGameDetailInfo.jdField_f_of_type_JavaLangString);
          String str = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
            ((StringBuilder)localObject).append("(");
          }
          ((StringBuilder)localObject).append(str);
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
            ((StringBuilder)localObject).append(")");
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
          localObject = a(paramGameDetailInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            b(true);
            this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
          if (TextUtils.isEmpty(paramGameDetailInfo.jdField_k_of_type_JavaLangString)) {
            break;
          }
          this.d.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          paramGameDetailInfo = URLDrawable.getDrawable(paramGameDetailInfo.jdField_k_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramGameDetailInfo);
          return;
        }
      }
      catch (Throwable paramGameDetailInfo)
      {
        QLog.e(jdField_f_of_type_JavaLangString, 1, paramGameDetailInfo.getMessage());
        return;
      }
      int i1 = 2130840322;
      continue;
      label460:
      if ((2 == this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int == 0)) {
        if (!TextUtils.isEmpty(paramGameDetailInfo.jdField_f_of_type_JavaLangString)) {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(paramGameDetailInfo.jdField_f_of_type_JavaLangString);
        } else {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131692836));
        }
      }
    }
  }
  
  private void bi()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null) && (this.jdField_k_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b == 1) {
        this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689912));
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null) && (this.jdField_j_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c != 0) {
        break label230;
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690029));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b != 0)) {
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207867", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b != 2) {
        break;
      }
      this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131692835));
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo == null) {
        break;
      }
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207876", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
      break;
      label230:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c == 1) {
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690028));
      }
    }
  }
  
  private void bj()
  {
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[shieldOrCancelMsg], mStrangerRecomInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo == null) {
      return;
    }
    String str = "";
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c == 0)
    {
      str = "207868";
      i1 = 2;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), "");
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo == null)) {
        break;
      }
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", str, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "20", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c == 1)
      {
        str = "207869";
        i1 = 4;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void bk()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    this.jdField_l_of_type_Int = ((Intent)localObject).getIntExtra("game_msg_open_aio_from", -1);
    QLog.i(jdField_f_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + str2 + ", fromPage:" + this.jdField_l_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis = new GameMsgChatPie.GameUsrAvatarClickLis(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis = new GameMsgChatPie.GameUsrAvatarClickLis(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(str2);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.a(str1);
    this.jdField_b_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.a(str2);
    String str3;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null)
    {
      str3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.c != 0) {
        break label292;
      }
    }
    label292:
    for (localObject = "1";; localObject = "0")
    {
      GameMsgUtil.a(str3, "1", "145", "920", "92005", "206350", "", (String)localObject, "8", "0");
      localObject = (GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER);
      ((GameCenterUnissoHandler)localObject).a(str2, str1);
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null)
      {
        ((GameCenterUnissoHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString);
        h = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView = new GameMsgQuickReplyView(this);
      ((GameCenterUnissoHandler)localObject).a();
      return;
    }
  }
  
  private void bl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_f_of_type_JavaLangString, 2, "isMsgSync:" + bool);
      }
      if (!bool) {
        break label60;
      }
    }
    label60:
    while (!GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, 1, 0);
    this.P = true;
  }
  
  private void bm()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow = null;
    }
  }
  
  private void bn()
  {
    if (this.O)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false);
      }
      if ((this.O) && (a() != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        String str = a().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString;
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      this.O = false;
    }
  }
  
  private void bo()
  {
    if (this.jdField_c_of_type_AndroidAppDialog != null) {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  @TargetApi(14)
  private void bp()
  {
    aF();
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      Object localObject1 = new RelativeLayout(a());
      Object localObject2 = new RoundRectLinearLayout(a());
      ((RoundRectLinearLayout)localObject2).setRoundRect(AIOUtils.a(15.0F, a().getResources()), -1, false);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(30.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(a());
      ((View)localObject2).setBackgroundColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(450.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(10.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      ((TextView)localObject2).setText("游戏中心启动专属特权");
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(20.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(20.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(20.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(a());
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject2).setImageResource(2130851332);
      ((ImageView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(5.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.a(10.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(a());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(60.0F, a().getResources()), AIOUtils.a(60.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(66.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(20.0F, a().getResources());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_k_of_type_JavaLangString))
      {
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/").mkdirs();
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.a(60.0F, a().getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = AIOUtils.a(60.0F, a().getResources());
        ((ImageView)localObject2).setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_k_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject4, this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_k_of_type_JavaLangString));
      }
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
        ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_j_of_type_JavaLangString);
      }
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(15.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(75.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(88.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      ((TextView)localObject2).setText("启动特权生效中");
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(-32768);
      ((TextView)localObject2).setDuplicateParentStateEnabled(false);
      ((TextView)localObject2).setBackgroundDrawable(new RoundRectColorDrawable(385843200, AIOUtils.a(4.0F, a().getResources()), AIOUtils.a(80.0F, a().getResources()), AIOUtils.a(18.0F, a().getResources())));
      ((TextView)localObject2).setTextSize(10.0F);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(101.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(88.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(a());
      ((View)localObject2).setBackgroundColor(369098752);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(335.0F, a().getResources()), 1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(142.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        int i1 = 0;
        while ((i1 < this.jdField_b_of_type_JavaUtilList.size()) && (i1 < 4))
        {
          localObject2 = (GameMsgChatPie.GamePriorityInfo)this.jdField_b_of_type_JavaUtilList.get(i1);
          localObject3 = new ImageView(a());
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, a().getResources()), AIOUtils.a(40.0F, a().getResources()));
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9);
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.a(158.0F, a().getResources());
          f1 = (float)((DeviceInfoUtil.i() - AIOUtils.a(40.0F, a().getResources()) * this.jdField_b_of_type_JavaUtilList.size()) / (this.jdField_b_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(f1 + (AIOUtils.a(40.0F, a().getResources()) + f1) * i1));
          if (!TextUtils.isEmpty(((GameMsgChatPie.GamePriorityInfo)localObject2).jdField_a_of_type_JavaLangString)) {
            ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((GameMsgChatPie.GamePriorityInfo)localObject2).jdField_a_of_type_JavaLangString));
          }
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject3 = new TextView(a());
          ((TextView)localObject3).setText(((GameMsgChatPie.GamePriorityInfo)localObject2).b);
          ((TextView)localObject3).setTextColor(-2144128205);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setLines(3);
          ((TextView)localObject3).setGravity(3);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(63.0F, a().getResources()), -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          f1 = (float)((DeviceInfoUtil.i() - AIOUtils.a(63.0F, a().getResources()) * this.jdField_b_of_type_JavaUtilList.size()) / (this.jdField_b_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f1 + (AIOUtils.a(63.0F, a().getResources()) + f1) * i1));
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(208.0F, a().getResources());
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          i1 += 1;
        }
      }
      localObject2 = new RoundRectLinearLayout(a());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(335.0F, a().getResources()), AIOUtils.a(40.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(32.0F, a().getResources());
      ((RoundRectLinearLayout)localObject2).setGravity(17);
      float f1 = AIOUtils.a(20.0F, a().getResources());
      Object localObject4 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, AIOUtils.a(335.0F, a().getResources()), 0.0F, -16733441, -16751361, Shader.TileMode.CLAMP);
      ((ShapeDrawable)localObject4).getPaint().setShader(localLinearGradient);
      ((RoundRectLinearLayout)localObject2).setBackgroundDrawable((Drawable)localObject4);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(a());
      ((TextView)localObject3).setText("立即启动");
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((TextView)localObject3).setGravity(17);
      ((RoundRectLinearLayout)localObject2).addView((View)localObject3);
      ((RoundRectLinearLayout)localObject2).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(a(), 2131755842);
      this.jdField_c_of_type_AndroidAppDialog.setContentView((View)localObject1);
      localObject1 = this.jdField_c_of_type_AndroidAppDialog.getWindow();
      ((Window)localObject1).setGravity(80);
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
      ((Window)localObject1).setWindowAnimations(2131755555);
      ((Window)localObject1).setLayout(-1, AIOUtils.a(460.0F, a().getResources()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "207564", "", "", "8", "0");
    }
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  private void i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar = new GameMsgTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar, new Object[0]);
    }
  }
  
  private void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_f_of_type_JavaLangString, 2, "[showQuickReply], from:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo == null) {
      QLog.w(jdField_f_of_type_JavaLangString, 1, "[showQuickReply], param is null, return.");
    }
    label343:
    for (;;)
    {
      return;
      if (this.S)
      {
        QLog.w(jdField_f_of_type_JavaLangString, 1, "[showQuickReply], has shown, return.");
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        QLog.i(jdField_f_of_type_JavaLangString, 1, "[showQuickReply], no quick replys, return.");
        return;
      }
      paramString = a();
      int i1 = 0;
      Object localObject2;
      if (i1 < paramString.size())
      {
        localObject2 = (ChatMessage)paramString.get(i1);
        if ((localObject2 == null) || ((localObject2 instanceof MessageForUniteGrayTip))) {}
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 > 0) {
          break label343;
        }
        paramString = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            GameMsgQuickReplyInfo localGameMsgQuickReplyInfo = new GameMsgQuickReplyInfo();
            localGameMsgQuickReplyInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
            paramString.add(localGameMsgQuickReplyInfo);
            continue;
            i1 += 1;
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView == null) || (paramString.size() <= 0)) {
          break;
        }
        this.T = false;
        this.S = true;
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView.a(paramString);
        localObject1 = new StringBuilder(500);
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((StringBuilder)localObject1).append(((GameMsgQuickReplyInfo)paramString.next()).jdField_a_of_type_JavaLangString).append("|");
        }
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "207648", ((StringBuilder)localObject1).toString(), "", "8", "");
        return;
      }
    }
  }
  
  private void t(boolean paramBoolean)
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_f_of_type_JavaLangString;
    }
    if (paramBoolean) {}
    for (str = "你已屏蔽" + str + "的临时会话";; str = "你已允许接收" + str + "的临时会话")
    {
      GameMsgGrayTipsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, -1, -1, "");
      return;
    }
  }
  
  private void u(boolean paramBoolean)
  {
    if (this.jdField_l_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void v(int paramInt)
  {
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[createRules], relation:" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgStrangerRules = new GameMsgAddFriendRules(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_add_friend_info_", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules = new GameMsgSayHelloRules(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_say_hello_", 5, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules = new GameMsgSendTimesRules(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_send_msg_without_reply_", 3, paramInt, a());
  }
  
  public void B()
  {
    super.B();
  }
  
  public boolean E()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules != null) && (!this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules.a()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131692841), 1).a();
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)) {
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207871", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules == null);
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules.a());
    if (!this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules.a(a()))
    {
      GameMsgGrayTipsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, GameMsgSendTimesRules.jdField_a_of_type_JavaLangString, -1, -1, "");
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)) {
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207872", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
      }
    }
    return false;
  }
  
  public void J()
  {
    super.J();
    if (this.jdField_c_of_type_AndroidAppDialog != null) {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher.b();
    }
  }
  
  public void O()
  {
    super.O();
  }
  
  public void P()
  {
    super.P();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void R()
  {
    super.R();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void Y()
  {
    super.Y();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(a());
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)a(105);
      if (localAIOEmoticonUIHelper != null) {
        return localAIOEmoticonUIHelper.b();
      }
    }
    else
    {
      return super.a(paramInt);
    }
    return null;
  }
  
  public AIOContext a()
  {
    return new GameMsgContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new GameMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  }
  
  public GameDetailInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString;
    }
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[getUin4AddAndShiledFriend], mStrangerRecomInfo is null.");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo);
  }
  
  public void a(String paramString)
  {
    bj();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[updateShiledStatusAsync]");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c != 0) {
        break label39;
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
    }
    label39:
    while (1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.c) {
      return;
    }
    this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
  }
  
  public boolean a()
  {
    return this.D;
  }
  
  public boolean a(String paramString)
  {
    if (!E()) {
      return false;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    a(localSendMsgParams);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, null, localSendMsgParams);
    this.T = true;
    if (this.jdField_l_of_type_Int == 4) {
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207857", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "18", "");
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager = ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER));
    bk();
    QLog.i(jdField_f_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoObserver);
  }
  
  public void av()
  {
    super.av();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.c();
    }
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  }
  
  public GameDetailInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  }
  
  public void b(String paramString)
  {
    bj();
  }
  
  public void bf()
  {
    super.bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
  }
  
  public GameDetailInfo c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(paramInt1, paramInt2);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b != 0);
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.d();
    }
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public void f(String paramString)
  {
    super.f(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules.a(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules.a(1);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo);
    i(this.n);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      a((String)paramMessage.obj, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameAioViewSwitcher);
      continue;
      bm();
    }
  }
  
  public void m()
  {
    QLog.i(jdField_g_of_type_JavaLangString, 1, "[addFriend], mStrangerRecomInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b == 1)
        {
          super.m();
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b != 2);
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)) {
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207877", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "20", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgStrangerRules.a()) {
        break;
      }
      QQToast.a(a(), HardCodeUtil.a(2131692833), 1).a();
    } while ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo == null));
    GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92015", "207870", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
    return;
    GameDetailInfo localGameDetailInfo = c();
    String str1 = "";
    String str2 = "";
    if (localGameDetailInfo != null)
    {
      str1 = localGameDetailInfo.jdField_j_of_type_JavaLangString;
      str2 = localGameDetailInfo.jdField_d_of_type_JavaLangString;
    }
    GameMsgAddFriendDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.n, str1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), str2);
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    QLog.i(jdField_f_of_type_JavaLangString, 1, "[onShowFirst]");
    j("onShowFirst");
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager != null)
    {
      this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.o = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((TextUtils.isEmpty(this.o)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
          this.o = this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a()).d();
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameMsgManager.c(), true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
          GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().getBytes().length <= this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_Int) {
            break label152;
          }
          ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131692838, 1);
        }
        catch (Throwable localThrowable) {}
        break;
        label152:
        if (E())
        {
          if ((!this.T) && (this.jdField_l_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null)) {
            GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "207647", "", "", "8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "");
          }
          this.T = true;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
            GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "207563", "", "", "20", "0");
          }
          bn();
          boolean bool = ApkUtils.a(this.jdField_k_of_type_JavaLangString, BaseApplicationImpl.getApplication());
          QLog.i(jdField_f_of_type_JavaLangString, 1, "mGamePackageName:" + this.jdField_k_of_type_JavaLangString + " isInstall:" + bool);
          if ((c() != null) && (this.jdField_k_of_type_Int == 1) && (bool) && (!this.jdField_b_of_type_JavaUtilList.isEmpty()))
          {
            bp();
          }
          else
          {
            if (!F()) {
              break;
            }
            continue;
            bn();
            bool = ApkUtils.a(this.jdField_k_of_type_JavaLangString, BaseApplicationImpl.getApplication());
            QLog.i(jdField_f_of_type_JavaLangString, 1, "mGamePackageName:" + this.jdField_k_of_type_JavaLangString + " isInstall:" + bool);
            if ((c() != null) && (this.jdField_k_of_type_Int == 1) && (bool) && (!this.jdField_b_of_type_JavaUtilList.isEmpty()))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null)
              {
                GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "1", "", "20", "0");
                GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "207565", "", "", "20", "0");
              }
              bp();
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
                GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "0", "", "20", "0");
              }
              if (!F()) {
                break;
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo != null) {
        GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo.jdField_d_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 10007)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules != null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSayHelloRules.a(paramObservable);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules != null) {
          this.jdField_a_of_type_ComTencentMobileqqGamecenterUtilGameMsgSendTimesRules.a(paramObservable);
        }
        if (((this.jdField_l_of_type_Int == 3) || (this.jdField_l_of_type_Int == 4)) && (!this.R))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10007, 0);
          this.R = true;
          QLog.d(jdField_f_of_type_JavaLangString, 2, "[update], save conversation.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie
 * JD-Core Version:    0.7.0.1
 */