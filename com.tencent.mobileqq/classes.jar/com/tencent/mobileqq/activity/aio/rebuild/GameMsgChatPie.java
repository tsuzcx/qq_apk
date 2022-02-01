package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.GameMsgAddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper;
import com.tencent.mobileqq.activity.aio.helper.GameMsgHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GameMsgListRefresher;
import com.tencent.mobileqq.activity.aio.tips.GameMsgTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriendRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSayHelloRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSendTimesRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.ui.BubblePopupWindow;
import com.tencent.mobileqq.gamecenter.ui.GameAioViewSwitcher;
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
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class GameMsgChatPie
  extends BaseChatPie
{
  public static final String d = HardCodeUtil.a(2131692796);
  public static String e;
  private static final String f;
  private static final String jdField_g_of_type_JavaLangString;
  private boolean D;
  private boolean E;
  private boolean F = false;
  private boolean G;
  private boolean H = false;
  private boolean I = false;
  private boolean J = true;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GameMsgChatPie.7(this);
  private GameMsgChatPie.GameMessageReceiver jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameMessageReceiver;
  private GameMsgChatPie.GameUsrAvatarClickLis jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  private GameMsgChatPie.StrangerRecomInfo jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
  private GameMsgTipsBar jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new GameMsgChatPie.2(this);
  protected MessageObserver a;
  private IGameMsgAddFriendRulesApi jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgAddFriendRulesApi;
  private IGameMsgManagerService jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService = null;
  private IGameMsgSayHelloRulesApi jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi;
  private IGameMsgSendTimesRulesApi jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi;
  private GameDetailInfo jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
  private GameCenterUnissoObserver jdField_a_of_type_ComTencentMobileqqGamecenterSsoGameCenterUnissoObserver = new GameMsgChatPie.1(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow;
  private GameAioViewSwitcher jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher;
  private GameMsgQuickReplyView jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<GameMsgChatPie.GamePriorityInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GameMsgChatPie.8(this);
  private GameMsgChatPie.GameUsrAvatarClickLis jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  private GameDetailInfo jdField_b_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
  private RelativeLayout c;
  private int jdField_g_of_type_Int;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int = 0;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int = 0;
  private String jdField_j_of_type_JavaLangString;
  private int jdField_k_of_type_Int = 0;
  private String jdField_k_of_type_JavaLangString;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private String jdField_l_of_type_JavaLangString;
  private String m = "";
  
  static
  {
    jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131705148);
    jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131705147);
  }
  
  public GameMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new GameMsgChatPie.11(this);
  }
  
  private String a(GameDetailInfo paramGameDetailInfo, int paramInt)
  {
    paramGameDetailInfo = this.jdField_k_of_type_JavaLangString;
    if (paramGameDetailInfo != null) {
      return paramGameDetailInfo;
    }
    return "";
  }
  
  private void a(GameMsgChatPie.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null)
    {
      QLog.i("GameMsgChatPie", 1, "[doOnButtonClick] buttonInfo is null.");
      return;
    }
    if (paramButtonInfo.jdField_a_of_type_Int == 1)
    {
      paramButtonInfo = paramButtonInfo.jdField_a_of_type_JavaLangString;
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramButtonInfo);
      a().startActivity(localIntent);
    }
    else if ((paramButtonInfo.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.doOnBackPressed();
    }
    paramButtonInfo = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramButtonInfo != null) && (paramButtonInfo.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      return;
    }
    try
    {
      int i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 9.0F);
      int n = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 11.0F);
      localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((TextView)localObject).setId(2131378460);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextSize(2, 13.0F);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setPadding(n, i1, n, i1);
      i1 = (int)((TextView)localObject).getPaint().measureText(paramString);
      int i2 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F);
      int i3 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.5F);
      int i4 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 11.0F);
      int i5 = -i1 / 2;
      int i6 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 5.0F);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow = new BubblePopupWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.setAnimationStyle(2131755514);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.a(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.setContentView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.setWidth(n * 2 + i1);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.a(i4, i3);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.a(i4 / 2);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.b(-721420288);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.c(i2);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.showAsDropDown(paramView, i5, i6, 80);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameMsgChatPie", 1, "showAsDropDown", paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, GameMsgChatPie.ButtonInfo paramButtonInfo1, GameMsgChatPie.ButtonInfo paramButtonInfo2)
  {
    if ((paramButtonInfo1 == null) && (paramButtonInfo2 == null)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      return;
    }
    if ((paramButtonInfo1 != null) && (paramButtonInfo2 != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, paramString1, paramString2, paramButtonInfo1.b, paramButtonInfo2.b, new GameMsgChatPie.3(this, paramButtonInfo2), new GameMsgChatPie.4(this, paramButtonInfo1));
    } else if (paramButtonInfo1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, paramString1, paramString2, paramButtonInfo1.b, "", null, new GameMsgChatPie.5(this, paramButtonInfo1));
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (paramString1 != null) {
      paramString1.show();
    }
  }
  
  private void a(List<String> paramList, boolean paramBoolean)
  {
    if (this.c == null) {
      this.c = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131376643));
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(0);
      ar();
      as();
      if ((paramList != null) && (paramList.size() > 0))
      {
        if (paramBoolean)
        {
          this.G = true;
          localObject = jdField_f_of_type_JavaLangString;
        }
        else
        {
          this.jdField_j_of_type_Int = 0;
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
          if (!((SharedPreferences)localObject).getBoolean("sp_pubacc_msg_showed_red_hot", false))
          {
            this.G = true;
            ((SharedPreferences)localObject).edit().putBoolean("sp_pubacc_msg_showed_red_hot", true).commit();
          }
          localObject = jdField_g_of_type_JavaLangString;
        }
        this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher.setData(paramList);
        if (this.G)
        {
          a(true, this.jdField_k_of_type_Int);
          paramList = Message.obtain();
          paramList.what = 1;
          paramList.obj = localObject;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramList);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("GameMsgChatPie", 2, "[updateRight2Icon] mUrls list is null or empty.");
      }
    }
    else
    {
      QLog.e("GameMsgChatPie", 1, "[updateRight2Icon] mRight2 view is null, add view failed.");
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int n = this.jdField_j_of_type_Int;
    Object localObject;
    if (n == 0)
    {
      localObject = this.jdField_l_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ((ImageView)localObject).setVisibility(0);
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        ((ImageView)localObject).setVisibility(8);
      }
    }
    else if (n == 1)
    {
      localObject = this.jdField_h_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        if ((paramBoolean) && (paramInt > 0))
        {
          ((TextView)localObject).setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramInt);
          localObject = ((StringBuilder)localObject).toString();
          if (paramInt > 99) {
            localObject = "99+";
          }
          this.jdField_h_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          return;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void ao()
  {
    Object localObject = (GameMsgAddFriendHelper)a(113);
    GameMsgChatPie.StrangerRecomInfo localStrangerRecomInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
    if (localStrangerRecomInfo != null) {
      if (localStrangerRecomInfo.b == 1)
      {
        ((GameMsgAddFriendHelper)localObject).b(2131689826);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.b == 2)
      {
        ((GameMsgAddFriendHelper)localObject).b(2131692789);
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92015", "207876", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
        }
      }
    }
    localStrangerRecomInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
    if (localStrangerRecomInfo != null) {
      if (localStrangerRecomInfo.jdField_c_of_type_Int == 0) {
        ((GameMsgAddFriendHelper)localObject).a(2131689944);
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_c_of_type_Int == 1) {
        ((GameMsgAddFriendHelper)localObject).a(2131689943);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
    if ((localObject != null) && (((GameMsgChatPie.StrangerRecomInfo)localObject).b != 0)) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92015", "207867", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
    }
  }
  
  private void ap()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    this.jdField_h_of_type_Int = ((Intent)localObject).getIntExtra("game_msg_open_aio_from", -1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friRoleId:");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(",myRoleId:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", fromPage:");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    QLog.i("GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis = new GameMsgChatPie.GameUsrAvatarClickLis(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis = new GameMsgChatPie.GameUsrAvatarClickLis(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(str1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(str2);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getSingleGameDetail(str1);
    this.jdField_b_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getSingleGameDetail(str2);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null)
    {
      IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      String str3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString;
      String str4 = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.b);
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_Int == 0) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localIGameMsgHelperApi.reportForGameMsg(str3, "1", "145", "920", "92005", "206350", str4, (String)localObject, "8", "0");
    }
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getAioPopInfo(str2, str1);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null)
    {
      ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameStartPriority(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString);
      jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView = new GameMsgQuickReplyView(this);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameSwitch();
  }
  
  private void aq()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
    if (localObject != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.isGameMsgSync(((GameDetailInfo)localObject).jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isMsgSync:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        return;
      }
      if (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isShowMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, 1, 0);
        this.F = true;
      }
    }
  }
  
  private void ar()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher = new GameAioViewSwitcher(a());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(24.0F, a().getResources()), AIOUtils.b(24.0F, a().getResources()));
      localLayoutParams.addRule(13);
      this.c.addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher, 0, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher.setOnClickListener(new GameMsgChatPie.6(this));
    }
  }
  
  private void as()
  {
    if (this.c == null) {
      return;
    }
    if (this.jdField_l_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      this.jdField_l_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      this.jdField_l_of_type_AndroidWidgetImageView.setImageResource(2130850766);
      this.c.addView(this.jdField_l_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_h_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(16.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()), AIOUtils.b(16.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      localLayoutParams.addRule(11);
      this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
      localLayoutParams.rightMargin = AIOUtils.b(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      localLayoutParams.topMargin = AIOUtils.b(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(10.0F);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_k_of_type_Int > 99) {
        localObject = "99+";
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130850766);
      this.c.addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameMessageReceiver = new GameMsgChatPie.GameMessageReceiver(this);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameMessageReceiver, (IntentFilter)localObject);
    }
  }
  
  private void at()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow = null;
    }
  }
  
  private void au()
  {
    if (this.E)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false);
      }
      if ((this.E) && (a() != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a().getCurrentUin());
        ((StringBuilder)localObject).append("_game_msg_chatpie_reddot_click_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString);
        localObject = ((StringBuilder)localObject).toString();
        localSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      }
      this.E = false;
    }
  }
  
  private void av()
  {
    Dialog localDialog = this.jdField_b_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  @TargetApi(14)
  private void aw()
  {
    ad();
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      Object localObject1 = new RelativeLayout(a());
      Object localObject2 = new RoundRectLinearLayout(a());
      ((RoundRectLinearLayout)localObject2).setRoundRect(AIOUtils.b(15.0F, a().getResources()), -1, false);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(30.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(a());
      ((View)localObject2).setBackgroundColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(450.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(10.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      ((TextView)localObject2).setText("游戏中心启动专属特权");
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(20.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(20.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(20.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(a());
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject2).setImageResource(2130851248);
      ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(5.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.b(10.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(a());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(60.0F, a().getResources()), AIOUtils.b(60.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(66.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(20.0F, a().getResources());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_j_of_type_JavaLangString))
      {
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/").mkdirs();
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.b(60.0F, a().getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = AIOUtils.b(60.0F, a().getResources());
        ((ImageView)localObject2).setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_j_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject4, this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_j_of_type_JavaLangString));
      }
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
      if (localObject3 != null) {
        ((TextView)localObject2).setText(((GameDetailInfo)localObject3).jdField_i_of_type_JavaLangString);
      }
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(15.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(75.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(88.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(a());
      ((TextView)localObject2).setText("启动特权生效中");
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(-32768);
      ((TextView)localObject2).setDuplicateParentStateEnabled(false);
      ((TextView)localObject2).setBackgroundDrawable(new RoundRectColorDrawable(385843200, AIOUtils.b(4.0F, a().getResources()), AIOUtils.b(80.0F, a().getResources()), AIOUtils.b(18.0F, a().getResources())));
      ((TextView)localObject2).setTextSize(10.0F);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(101.0F, a().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(88.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(a());
      ((View)localObject2).setBackgroundColor(369098752);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(335.0F, a().getResources()), 1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(142.0F, a().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int n = 0;
        while ((n < this.jdField_a_of_type_JavaUtilList.size()) && (n < 4))
        {
          localObject2 = (GameMsgChatPie.GamePriorityInfo)this.jdField_a_of_type_JavaUtilList.get(n);
          localObject3 = new ImageView(a());
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, a().getResources()), AIOUtils.b(40.0F, a().getResources()));
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9);
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(158.0F, a().getResources());
          float f2 = (float)((DeviceInfoUtil.i() - AIOUtils.b(40.0F, a().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          float f3 = AIOUtils.b(40.0F, a().getResources());
          f1 = n;
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(f2 + (f3 + f2) * f1));
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
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.b(63.0F, a().getResources()), -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          f2 = (float)((DeviceInfoUtil.i() - AIOUtils.b(63.0F, a().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f2 + (AIOUtils.b(63.0F, a().getResources()) + f2) * f1));
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(208.0F, a().getResources());
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          n += 1;
        }
      }
      localObject2 = new RoundRectLinearLayout(a());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(335.0F, a().getResources()), AIOUtils.b(40.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(32.0F, a().getResources());
      ((RoundRectLinearLayout)localObject2).setGravity(17);
      float f1 = AIOUtils.b(20.0F, a().getResources());
      Object localObject4 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, AIOUtils.b(335.0F, a().getResources()), 0.0F, -16733441, -16751361, Shader.TileMode.CLAMP);
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
      ((RoundRectLinearLayout)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(a(), 2131756189);
      this.jdField_b_of_type_AndroidAppDialog.setContentView((View)localObject1);
      localObject1 = this.jdField_b_of_type_AndroidAppDialog.getWindow();
      ((Window)localObject1).setGravity(80);
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
      ((Window)localObject1).setWindowAnimations(2131755901);
      ((Window)localObject1).setLayout(-1, AIOUtils.b(460.0F, a().getResources()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207564", "", "", "8", "0");
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void b(GameDetailInfo paramGameDetailInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgChatPie", 2, "[setTitleInfo]");
    }
    if (paramGameDetailInfo != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)
        {
          paramGameDetailInfo.a();
          if (paramGameDetailInfo.jdField_a_of_type_Int > 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setEarIconVisible(false);
            }
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
            if (paramGameDetailInfo.jdField_a_of_type_Int != 1) {
              continue;
            }
            n = 2130840182;
            this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable(a().getResources().getDrawable(n));
          }
          if (!TextUtils.isEmpty(paramGameDetailInfo.jdField_g_of_type_JavaLangString))
          {
            this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetImageView.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
            ((LinearLayout.LayoutParams)localObject).width = AIOUtils.b(18.0F, BaseApplication.getContext().getResources());
            ((LinearLayout.LayoutParams)localObject).height = AIOUtils.b(18.0F, BaseApplication.getContext().getResources());
            localObject = URLDrawable.getDrawable(paramGameDetailInfo.jdField_g_of_type_JavaLangString);
            this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int)
          {
            localObject = new StringBuilder(100);
            ((StringBuilder)localObject).append(paramGameDetailInfo.jdField_e_of_type_JavaLangString);
            String str = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString);
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
              ((StringBuilder)localObject).append("(");
            }
            ((StringBuilder)localObject).append(str);
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
              ((StringBuilder)localObject).append(")");
            }
            this.jdField_e_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
          }
          else if ((2 == this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int == 0))
          {
            if (!TextUtils.isEmpty(paramGameDetailInfo.jdField_e_of_type_JavaLangString)) {
              this.jdField_e_of_type_AndroidWidgetTextView.setText(paramGameDetailInfo.jdField_e_of_type_JavaLangString);
            } else {
              this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131692790));
            }
          }
          localObject = a(paramGameDetailInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            a(true);
            this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
          this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
          if (TextUtils.isEmpty(paramGameDetailInfo.jdField_j_of_type_JavaLangString)) {
            continue;
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          paramGameDetailInfo = URLDrawable.getDrawable(paramGameDetailInfo.jdField_j_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(paramGameDetailInfo);
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detail or strangerRecom info is null. detail:");
        ((StringBuilder)localObject).append(paramGameDetailInfo);
        ((StringBuilder)localObject).append(",strangerRecom:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo);
        QLog.w("GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131692790));
        return;
      }
      catch (Throwable paramGameDetailInfo)
      {
        int n;
        continue;
      }
      QLog.e("GameMsgChatPie", 1, paramGameDetailInfo.getMessage());
      return;
      n = 2130840181;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = ((IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getPlayerInfoUrl();
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramContext != null) && (!TextUtils.isEmpty(paramString)))
      {
        boolean bool = paramQQAppInterface.contains("?");
        StringBuilder localStringBuilder;
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append("&roleId=");
          localStringBuilder.append(URLEncoder.encode(paramString, "utf-8"));
          paramQQAppInterface = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append("?roleId=");
          localStringBuilder.append(URLEncoder.encode(paramString, "utf-8"));
          paramQQAppInterface = localStringBuilder.toString();
        }
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.putExtra("url", paramQQAppInterface);
        paramContext.startActivity(paramString);
        return true;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("GameMsgChatPie", 1, paramQQAppInterface, new Object[0]);
    }
    return false;
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar = new GameMsgTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar, new Object[0]);
    }
  }
  
  private void f(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[showQuickReply], from:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("GameMsgChatPie", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
    if (paramString == null)
    {
      QLog.w("GameMsgChatPie", 1, "[showQuickReply], param is null, return.");
      return;
    }
    if (this.I)
    {
      QLog.w("GameMsgChatPie", 1, "[showQuickReply], has shown, return.");
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getAioQuickReply(paramString.jdField_c_of_type_JavaLangString);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      paramString = a();
      int n = 0;
      Object localObject2;
      while (n < paramString.size())
      {
        localObject2 = (ChatMessage)paramString.get(n);
        if ((localObject2 != null) && (!(localObject2 instanceof MessageForUniteGrayTip)))
        {
          n = 1;
          break label158;
        }
        n += 1;
      }
      n = 0;
      label158:
      if (n > 0) {
        return;
      }
      paramString = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        GameMsgQuickReplyInfo localGameMsgQuickReplyInfo = new GameMsgQuickReplyInfo();
        localGameMsgQuickReplyInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
        paramString.add(localGameMsgQuickReplyInfo);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView != null) && (paramString.size() > 0))
      {
        this.J = false;
        this.I = true;
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView.a(paramString);
        localObject1 = new StringBuilder(500);
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          ((StringBuilder)localObject1).append(((GameMsgQuickReplyInfo)paramString.next()).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("|");
        }
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207648", ((StringBuilder)localObject1).toString(), "", "8", "");
      }
      return;
    }
    QLog.i("GameMsgChatPie", 1, "[showQuickReply], no quick replys, return.");
  }
  
  private void m(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[createRules], relation:");
    localStringBuilder.append(paramInt);
    QLog.i("GameMsgChatPie.strangerRecom", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgAddFriendRulesApi = ((IGameMsgAddFriendRulesApi)QRoute.api(IGameMsgAddFriendRulesApi.class));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgAddFriendRulesApi.doInit(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_add_friend_info_", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 5);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi = ((IGameMsgSayHelloRulesApi)QRoute.api(IGameMsgSayHelloRulesApi.class));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi.doInit(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_say_hello_", 5, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), a());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi = ((IGameMsgSendTimesRulesApi)QRoute.api(IGameMsgSendTimesRulesApi.class));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi.doInit(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "game_msg_sp_key_send_msg_without_reply_", 3, paramInt, a());
  }
  
  private void m(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
    if (localObject != null) {
      localObject = ((GameDetailInfo)localObject).jdField_e_of_type_JavaLangString;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("你已屏蔽");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("的临时会话");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("你已允许接收");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("的临时会话");
      localObject = localStringBuilder.toString();
    }
    GameMsgGrayTipsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, -1, -1, "", 0L);
  }
  
  private boolean u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgChatPie", 2, "[showStartGame]");
    }
    if (c() == null) {
      return false;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).startGame(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, c());
    return true;
  }
  
  public void F()
  {
    super.F();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(a());
    }
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterSsoGameCenterUnissoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterSsoGameCenterUnissoObserver);
  }
  
  public void W()
  {
    super.W();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.c();
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 3)
    {
      RelativeLayout localRelativeLayout = null;
      AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)a(105);
      if (localAIOEmoticonUIHelper != null) {
        localRelativeLayout = localAIOEmoticonUIHelper.b().getView();
      }
      return localRelativeLayout;
    }
    return super.a(paramInt);
  }
  
  protected AIOContext a()
  {
    return new GameMsgContext();
  }
  
  protected AIOInput a()
  {
    return new AIOInputBuilder().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new GameMsgChatPie.GameMsgMessageSender(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new GameMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  protected HelperProvider a()
  {
    return new GameMsgHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  }
  
  public GameMsgChatPie.StrangerRecomInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
  }
  
  public IGameMsgAddFriendRulesApi a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgAddFriendRulesApi;
  }
  
  public GameDetailInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
  }
  
  protected String a()
  {
    GameMsgChatPie.StrangerRecomInfo localStrangerRecomInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
    if (localStrangerRecomInfo != null) {
      return localStrangerRecomInfo.jdField_a_of_type_JavaLangString;
    }
    QLog.i("GameMsgChatPie.strangerRecom", 1, "[getUin4AddAndShiledFriend], mStrangerRecomInfo is null.");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo);
  }
  
  protected boolean a()
  {
    return this.x;
  }
  
  public boolean a(String paramString)
  {
    if (!t()) {
      return false;
    }
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    a(localSendMsgParams);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, null, localSendMsgParams);
    this.J = true;
    if (this.jdField_h_of_type_Int == 4) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92015", "207857", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "18", "");
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService = ((IGameMsgManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IGameMsgManagerService.class, ""));
    ap();
    QLog.i("GameMsgChatPie", 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameUsrAvatarClickLis;
  }
  
  public GameDetailInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.d();
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(paramInt1, paramInt2);
    }
  }
  
  protected void b(Intent paramIntent) {}
  
  public GameDetailInfo c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo;
  }
  
  protected void d(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
    if (paramString != null)
    {
      paramString.b = 0;
      paramString.jdField_a_of_type_Int = 1;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi;
    if (paramString != null) {
      paramString.updateRelation(1);
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi;
    if (paramString != null) {
      paramString.updateRelation(1);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo);
    e(this.jdField_l_of_type_JavaLangString);
  }
  
  public String e()
  {
    return this.jdField_l_of_type_JavaLangString;
  }
  
  protected void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    QLog.i("GameMsgChatPie", 1, "[onShowFirst]");
    f("onShowFirst");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService;
    if (localObject != null)
    {
      this.jdField_i_of_type_Int = ((IGameMsgManagerService)localObject).getUnreadCnt4MsgTab();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((TextUtils.isEmpty(this.m)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
          this.m = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getSessionInfoByRoleId(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a()).d();
        }
      }
      this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getAIORedDotStyle();
      this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getUnreadCnt();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onShowFirst] mCurrentRedDotStyle = ");
        ((StringBuilder)localObject).append(this.jdField_j_of_type_Int);
        ((StringBuilder)localObject).append(", mCurrentUnreadCnt = ");
        ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
        QLog.d("GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
      }
      a(this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService.getUnreadFriIcon(), true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = paramMessage.what;
    if (n != 1)
    {
      if (n == 2) {
        at();
      }
    }
    else {
      a((String)paramMessage.obj, this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher);
    }
    return super.handleMessage(paramMessage);
  }
  
  public void l(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService;
    if (localObject == null)
    {
      QLog.i("GameMsgChatPie", 1, "[onUnreadMsgCntChange] mCurrentRedDotStyle is null.");
      return;
    }
    this.jdField_j_of_type_Int = ((IGameMsgManagerService)localObject).getAIORedDotStyle();
    this.jdField_k_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onUnreadMsgCntChange] style:");
      ((StringBuilder)localObject).append(this.jdField_j_of_type_Int);
      ((StringBuilder)localObject).append(", cnt:");
      ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
      QLog.d("GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
    }
    paramInt = this.jdField_k_of_type_Int;
    if (paramInt > 0) {
      a(true, paramInt);
    }
  }
  
  protected void m()
  {
    super.m();
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131378837: 
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) && (b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a()))) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "208403", Integer.toString(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.b), null, "20", null);
      }
      break;
    case 2131376321: 
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207563", "", "", "20", "0");
      }
      au();
      bool = ApkUtils.a(this.jdField_h_of_type_JavaLangString, BaseApplicationImpl.getApplication());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGamePackageName:");
      localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
      localStringBuilder.append(" isInstall:");
      localStringBuilder.append(bool);
      QLog.i("GameMsgChatPie", 1, localStringBuilder.toString());
      if ((c() != null) && (this.jdField_g_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        aw();
      } else {
        if (!u()) {
          break;
        }
      }
      break;
    case 2131369216: 
      au();
      bool = ApkUtils.a(this.jdField_h_of_type_JavaLangString, BaseApplicationImpl.getApplication());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGamePackageName:");
      localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
      localStringBuilder.append(" isInstall:");
      localStringBuilder.append(bool);
      QLog.i("GameMsgChatPie", 1, localStringBuilder.toString());
      if ((c() != null) && (this.jdField_g_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null)
        {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "1", "", "20", "0");
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207565", "", "", "20", "0");
        }
        aw();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "0", "", "20", "0");
        }
        if (!u()) {
          break;
        }
      }
      break;
    case 2131368874: 
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
      break;
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    super.p();
    Object localObject = this.jdField_b_of_type_AndroidAppDialog;
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameMsgQuickReplyView;
    if (localObject != null) {
      ((GameMsgQuickReplyView)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMsgTipsBar;
    if (localObject != null) {
      ((GameMsgTipsBar)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterUiBubblePopupWindow = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterUiGameAioViewSwitcher;
    if (localObject != null) {
      ((GameAioViewSwitcher)localObject).b();
    }
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameMessageReceiver != null)) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$GameMessageReceiver);
    }
  }
  
  public boolean t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi;
    if ((localObject != null) && (!((IGameMsgSayHelloRulesApi)localObject).isAbleToAction()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131692795), 1).a();
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92015", "207871", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
      }
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi;
    if ((localObject != null) && (!((IGameMsgSendTimesRulesApi)localObject).isAbleToAction()))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi.isSend3Tips(a()))
      {
        GameMsgGrayTipsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, d, -1, -1, "", 0L);
        if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.jdField_a_of_type_ComTencentMobileqqGamecenterMsgInfoGameDetailInfo.jdField_c_of_type_JavaLangString, "1", "145", "920", "92015", "207872", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
        }
      }
      return false;
    }
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 10007)
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSayHelloRulesApi;
        if (paramObject != null) {
          paramObject.onMsgUpdate(paramObservable);
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgSendTimesRulesApi;
        if (paramObject != null) {
          paramObject.onMsgUpdate(paramObservable);
        }
        int n = this.jdField_h_of_type_Int;
        if (((n == 3) || (n == 4)) && (!this.H))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10007, 0);
          this.H = true;
          QLog.d("GameMsgChatPie", 2, "[update], save conversation.");
        }
      }
    }
  }
  
  public void v()
  {
    super.v();
  }
  
  protected void w()
  {
    super.w();
    GameMsgChatHelper localGameMsgChatHelper = (GameMsgChatHelper)a(56);
    if (localGameMsgChatHelper != null) {
      localGameMsgChatHelper.a(this.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void y()
  {
    super.y();
    Object localObject = (GameMsgChatHelper)a(56);
    if (localObject != null) {
      ((GameMsgChatHelper)localObject).a(a());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqGamecenterApiIGameMsgManagerService;
    if (localObject != null) {
      ((IGameMsgManagerService)localObject).cleanSessionUnread(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie
 * JD-Core Version:    0.7.0.1
 */