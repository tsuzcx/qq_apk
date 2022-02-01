package com.tencent.mobileqq.apollo.api.aio.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameConnManager;
import com.tencent.mobileqq.apollo.lightGame.CmGamePlayAgainDialog;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler.TopGameInfo;
import com.tencent.mobileqq.apollo.lightGame.DotPollingView;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar.OnTipsItemClickListener;
import com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar.TipsDataItem;
import com.tencent.mobileqq.apollo.lightGame.RobotDataUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import mqq.os.MqqHandler;

public class CmGameChatPie
  extends BaseChatPie
  implements QuickInputTipsBar.OnTipsItemClickListener
{
  public static boolean O;
  public boolean N = false;
  private boolean P = false;
  private boolean Q;
  private boolean R = false;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y;
  private boolean Z;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new CmGameChatPie.2(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private CmGameChatPie.ChatPieMsgListener jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener;
  private CmGameChatPie.UserInfo jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo;
  private CmGamePlayAgainDialog jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGamePlayAgainDialog;
  private DotPollingView jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView;
  private QuickInputTipsBar jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar;
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  protected MessageObserver a;
  public MessageForCmGameTips a;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private boolean aa;
  private boolean ab;
  private boolean ac = false;
  public View.OnClickListener b;
  private FrameGifView jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<ApolloGameData> jdField_b_of_type_JavaUtilList;
  private QQCustomDialog c;
  private RelativeLayout e;
  private RelativeLayout f;
  private RelativeLayout g;
  private RelativeLayout h;
  private int k = 319;
  private int jdField_l_of_type_Int;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private int jdField_m_of_type_Int;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private int jdField_n_of_type_Int = 0;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  
  public CmGameChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new CmGameChatPie.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new CmGameChatPie.13(this);
    ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().a(this);
  }
  
  private void a(CmGameChatPie.UserInfo paramUserInfo)
  {
    if (paramUserInfo == null) {
      return;
    }
    if ((paramUserInfo.jdField_a_of_type_Int <= 0) && (android.text.TextUtils.isEmpty(paramUserInfo.jdField_c_of_type_JavaLangString)) && (paramUserInfo.b <= 0)) {
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_l_of_type_AndroidWidgetTextView.setText(paramUserInfo.jdField_a_of_type_Int + HardCodeUtil.a(2131702107));
      this.jdField_m_of_type_AndroidWidgetTextView.setText(paramUserInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramUserInfo.d);
      if (!android.text.TextUtils.isEmpty(paramUserInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.o.setText(paramUserInfo.e);
      return;
      if (paramUserInfo.jdField_a_of_type_Int > 0) {
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (!android.text.TextUtils.isEmpty(paramUserInfo.jdField_c_of_type_JavaLangString)) {
        this.h.setVisibility(0);
      }
      if ((paramUserInfo.b == 1) || (paramUserInfo.b == 2)) {
        this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.o.setText(paramUserInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    this.ab = true;
    if (paramInt1 == 0)
    {
      paramInt2 = (int)(System.currentTimeMillis() / 1000L - paramInt2);
      if (paramInt2 > 86400)
      {
        paramString = (int)Math.ceil(paramInt2 / 86400.0D) + HardCodeUtil.a(2131702105);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
        u(false);
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        }
        if (this.U) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        }
        this.X = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "updateUserStatus status:", Integer.valueOf(paramInt1) });
      }
      return;
      if (paramInt2 > 3600)
      {
        paramString = (int)Math.ceil(paramInt2 / 3600.0D) + HardCodeUtil.a(2131702109);
        break;
      }
      paramString = (int)Math.ceil(paramInt2 / 60.0D) + HardCodeUtil.a(2131702103);
      break;
      this.X = true;
      this.jdField_f_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131719512));
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
    }
  }
  
  private void a(String paramString, CmGameChatPie.UserInfo paramUserInfo, int paramInt)
  {
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.W = bool;
      this.aa = true;
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
      }
      if (this.g == null) {
        break label69;
      }
      v(paramInt);
    }
    label69:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
        } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
        if (paramUserInfo == null)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "[updateFriendAndShield] info is null.");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo = paramUserInfo;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[updateFriendAndShield] friUin:" + paramString + ", " + paramUserInfo.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 0);
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null)
        {
          paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          bool = paramString.getBooleanExtra("key_show_one_more_page", false);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "[updateFriendAndShield] show one more page:", Boolean.valueOf(bool) });
          }
          if (bool)
          {
            paramString = paramString.getStringExtra("key_req_data");
            a(((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(paramString, "gameId"), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(paramString, "scoreState"), paramString);
          }
        }
        if ((!android.text.TextUtils.isEmpty(paramUserInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null))
        {
          paramString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uinname");
          if ((android.text.TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_AndroidWidgetTextView != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString;
            this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          }
        }
      } while (paramUserInfo.jdField_c_of_type_Int == 4);
      this.g = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558972, null));
      this.g.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)this.g.findViewById(2131369550));
      this.o = ((TextView)this.g.findViewById(2131380475));
      this.p = ((TextView)this.g.findViewById(2131363917));
      this.q = ((TextView)this.g.findViewById(2131380709));
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView = ((DotPollingView)this.g.findViewById(2131366041));
      this.r = ((TextView)this.g.findViewById(2131363916));
      this.s = ((TextView)this.g.findViewById(2131380568));
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.g.findViewById(2131369805));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.g.findViewById(2131380190));
      this.h = ((RelativeLayout)this.g.findViewById(2131377232));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.g.findViewById(2131380257));
      this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.g.findViewById(2131380222));
      a(paramUserInfo);
      this.p.setBackgroundDrawable(CmGameSessionUtil.a(this.jdField_a_of_type_AndroidContentContext, AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.p.setTextColor(CmGameSessionUtil.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.r.setBackgroundDrawable(CmGameSessionUtil.a(this.jdField_a_of_type_AndroidContentContext, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), "#000000"));
      this.r.setTextColor(CmGameSessionUtil.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
      this.p.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.r.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      v(paramUserInfo.jdField_c_of_type_Int);
      paramString = new RelativeLayout.LayoutParams(-1, AIOUtils.a(66.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramString.addRule(3, 2131377159);
      if (!this.D) {
        paramString.topMargin = 0;
      }
      this.jdField_m_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnPreDrawListener(new CmGameChatPie.9(this, paramUserInfo));
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.g, paramString);
    } while (((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().size() != 0) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().get(0) instanceof MessageForCmGameTips))) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips == null));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void a(List<QuickInputTipsBar.TipsDataItem> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int i = AIOUtils.a(7.0F, a().getResources());
    if (DeviceInfoUtil.a() <= 2.0F) {
      i = AIOUtils.a(9.0F, a().getResources());
    }
    QuickInputTipsBar.TipsDataItem localTipsDataItem = CmGameTempSessionHandler.a(paramInt);
    if (localTipsDataItem != null)
    {
      paramList.add(localTipsDataItem);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 1;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702098);
      paramList.add(localTipsDataItem);
      return;
    case 7: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 7;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(193), 3, i);
      paramList.add(localTipsDataItem);
      return;
    case 6: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 6;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702113);
      paramList.add(localTipsDataItem);
      return;
    case 5: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 5;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702108);
      paramList.add(localTipsDataItem);
      return;
    case 4: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 4;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(209), 3, i);
      paramList.add(localTipsDataItem);
      return;
    case 3: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 3;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702106);
      paramList.add(localTipsDataItem);
      return;
    case 2: 
      localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
      localTipsDataItem.jdField_a_of_type_Int = 2;
      localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = new QQText(com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(192), 3, i);
      paramList.add(localTipsDataItem);
      return;
    }
    localTipsDataItem = new QuickInputTipsBar.TipsDataItem();
    localTipsDataItem.jdField_a_of_type_Int = 1;
    localTipsDataItem.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702097);
    paramList.add(localTipsDataItem);
  }
  
  private void bj()
  {
    ThreadManagerV2.excute(new CmGameChatPie.8(this), 16, null, false);
  }
  
  private void bk()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (new Random().nextBoolean()) && (RobotDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      CmGameTempSessionHandler localCmGameTempSessionHandler = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler();
      int i = (int)(System.currentTimeMillis() / 1000L);
      this.jdField_l_of_type_Int = i;
      this.jdField_m_of_type_Int = i;
      localCmGameTempSessionHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGamePlayAgainDialog.jdField_a_of_type_Int, this.jdField_l_of_type_Int);
    }
  }
  
  private void bl()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkTipsBarLayout");
    }
    if (this.Y) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "checkTipsBarLayout mQuickBarClickRemoved");
    }
    do
    {
      return;
      if ((!this.aa) || (!this.ab) || (!this.Z))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mMateStateChecked:", Boolean.valueOf(this.aa), " mOnLineStateChecked:", Boolean.valueOf(this.ab), " mAudioOnLineChecked:", Boolean.valueOf(this.Z) });
        return;
      }
      if (this.X) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkTipsBarLayout !mFriendOnLine");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = new QuickInputTipsBar(a(), null);
      localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(48.0F, a().getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369142);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.setTipsClickListener(this);
    }
    Object localObject = new ArrayList();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "checkTipsBarLayout mIsMate:", Boolean.valueOf(this.W), " mFriendAudioOnLine:", Boolean.valueOf(this.V), " sLaunchGameFromAIO:", Boolean.valueOf(O) });
    if (this.W) {
      if (this.V) {
        if (O)
        {
          a((List)localObject, 7);
          a((List)localObject, 5);
          a((List)localObject, 3);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a((List)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), false, "cmGame_addFooter", 0);
      this.U = true;
      return;
      a((List)localObject, 6);
      a((List)localObject, 4);
      a((List)localObject, 2);
      continue;
      if (O)
      {
        a((List)localObject, 7);
        a((List)localObject, 1);
        a((List)localObject, 3);
      }
      else
      {
        a((List)localObject, 6);
        a((List)localObject, 1);
        a((List)localObject, 2);
        continue;
        a((List)localObject, 0);
        if (this.V)
        {
          if (O)
          {
            a((List)localObject, 5);
            a((List)localObject, 3);
          }
          else
          {
            a((List)localObject, 4);
            a((List)localObject, 2);
          }
        }
        else
        {
          a((List)localObject, 1);
          if (O) {
            a((List)localObject, 3);
          } else {
            a((List)localObject, 2);
          }
        }
      }
    }
  }
  
  private void v(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.p.setVisibility(0);
      this.q.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      return;
    case 1: 
      this.p.setVisibility(8);
      this.q.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(0);
      this.r.setVisibility(8);
      this.s.setVisibility(8);
      return;
    }
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloLightGameDotPollingView.setVisibility(8);
    this.r.setVisibility(0);
    this.s.setVisibility(0);
  }
  
  public boolean E()
  {
    return this.Q;
  }
  
  public void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[doOnDestory] chatPie:" + this + "," + this.P);
    }
    this.N = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = null;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    localIApolloManagerService.getGameTempMsgHandler().a();
    localIApolloManagerService.getGameTempMsgHandler().b(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener);
    localIApolloManagerService.getCmGameConnManager().b("page_tag_aio");
    if (this.P)
    {
      localIApolloManagerService.getGameTempMsgHandler().d(b());
      this.P = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener = null;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGamePlayAgainDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGamePlayAgainDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGamePlayAgainDialog = null;
    }
    super.J();
    this.Q = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    O = false;
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if (this.c != null) {
      this.c.dismiss();
    }
    if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
    {
      v(true);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
      this.ac = false;
    }
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout != null)
    {
      w(true);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ac = false;
    }
    localIApolloManagerService.getCmGameAudioManager().a(null);
    localIApolloManagerService.getCmGameAudioManager().c(b(), 319);
  }
  
  public void M()
  {
    super.M();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_show_one_more_page", false))) {
      a();
    }
  }
  
  public void N()
  {
    super.N();
    this.T = true;
  }
  
  public void O()
  {
    super.O();
    this.S = true;
  }
  
  public void R()
  {
    super.R();
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (this.S) {
      localIApolloManagerService.getCmGameConnManager().a();
    }
    this.S = false;
    this.T = false;
    if (O)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("apollo_audio_intro", true))
    {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(a());
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ImageView localImageView = new ImageView(a());
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setId(2131362802);
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = AIOUtils.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_btn.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject2);
      localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localImageView = new ImageView(a());
      localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131362802);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      localObject1 = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_audio_intro_txt.png", (URLDrawable.URLDrawableOptions)localObject1);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      this.ac = true;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new CmGameChatPie.17(this));
      ((FrameLayout)a().getWindow().getDecorView()).addView(this.jdField_f_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[showOpenAudioIntro] already show audio intro.");
      localSharedPreferences.edit().putBoolean("apollo_audio_intro", false).commit();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "[showOneMoreGameView] gameId:", Integer.valueOf(paramInt1), ",isWinner:", Integer.valueOf(paramInt2), ",reqData:", paramString });
    }
    this.jdField_n_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_show_one_more_page", false);
      ThreadManager.getUIHandler().post(new CmGameChatPie.12(this, paramInt1, paramInt2, paramString));
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_show_one_more_page", true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("key_req_data", paramString);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[showOneMoreGameView] friendInfo is null,update intent extra param");
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ApolloGameMsgInfo localApolloGameMsgInfo = new ApolloGameMsgInfo();
    Object localObject = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    String str = HardCodeUtil.a(2131702110);
    ApolloGameData localApolloGameData = ((IApolloDaoManagerService)localObject).findGameById(paramInt);
    if ((localApolloGameData != null) && (!android.text.TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((IApolloDaoManagerService)localObject).findActionById(localApolloGameData.actionId);
      if (localObject == null) {
        break label190;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label190:
    for (;;)
    {
      int i = localApolloGameData.actionId;
      localApolloGameMsgInfo.gameName = localApolloGameData.name;
      for (;;)
      {
        localApolloGameMsgInfo.actionName = str;
        localApolloGameMsgInfo.actionId = i;
        localApolloGameMsgInfo.roomId = paramLong;
        localApolloGameMsgInfo.gameId = paramInt;
        localApolloGameMsgInfo.msgType = 3;
        localApolloGameMsgInfo.gameStatus = 0;
        CmGameSessionUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localApolloGameMsgInfo);
        return;
        localApolloGameMsgInfo.gameName = HardCodeUtil.a(2131702104);
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramInt, true, "message", paramLong, 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.k, null);
    localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    localStartCheckParam.disableMinGame = true;
    localStartCheckParam.mRobotOpenId = paramString;
    localStartCheckParam.src = 318001;
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localStartCheckParam);
    O = true;
    CmGameSessionUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt, paramLong);
  }
  
  public void a(CmGameTempSessionHandler.TopGameInfo paramTopGameInfo)
  {
    if (paramTopGameInfo == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "[addTopGame] gameMap is null.");
      return;
    }
    if ((paramTopGameInfo.jdField_b_of_type_JavaUtilList.size() < 3) || (paramTopGameInfo.jdField_b_of_type_JavaUtilList.size() % 3 != 0))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "[addTopGame] game size is not a multiple of 3.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[addTopGame] alreadyAdd:" + this.N);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (!this.N)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips = ((MessageForCmGameTips)MessageRecordFactory.a(-7004));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.msgtype = -7004;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.mIsParsed = true;
      if ((this.g != null) && (localList.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = true;
      }
      MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", 1036);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.gameInfo = paramTopGameInfo;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), true, false, false, true);
      localList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips);
      this.N = true;
    }
    ThreadManager.getUIHandler().post(new CmGameChatPie.10(this));
  }
  
  public void a(QuickInputTipsBar.TipsDataItem paramTipsDataItem)
  {
    if ((paramTipsDataItem != null) && (paramTipsDataItem.jdField_a_of_type_JavaLangCharSequence != null) && (!this.Y))
    {
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramTipsDataItem.jdField_a_of_type_JavaLangCharSequence.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777216);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777216, 600L);
        this.Y = true;
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickMessage", 0, 0, new String[] { String.valueOf(paramTipsDataItem.jdField_a_of_type_Int) });
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      VipUtils.a(null, "cmshow", "Apollo", "picClick", 0, 0, new String[] { "" });
      return;
    case 3: 
      VipUtils.a(null, "cmshow", "Apollo", "expressionClick", 0, 0, new String[] { "" });
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "gameClick", 0, 0, new String[] { "" });
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt == 3)
    {
      paramString1 = new UniteGrayTipParam(paramString1, paramString2, HardCodeUtil.a(2131702101), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, MessageCache.a());
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
    }
    String str2;
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      do
      {
        return;
        str2 = "apollo_add_playMate_gray_tip" + paramString2 + "_" + paramString1 + "_" + paramInt;
        localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      } while (!localSharedPreferences.getBoolean(str2, true));
      l1 = MessageCache.a();
      str1 = "";
      if (paramInt != 0) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo.jdField_c_of_type_Int == 4));
    String str1 = HardCodeUtil.a(2131702114);
    for (;;)
    {
      paramString1 = new UniteGrayTipParam(paramString1, paramString2, str1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l1);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
      localSharedPreferences.edit().putBoolean(str2, false).commit();
      return;
      if (paramInt == 1) {
        str1 = HardCodeUtil.a(2131702112) + paramString3 + HardCodeUtil.a(2131702102);
      } else if (paramInt == 2) {
        str1 = HardCodeUtil.a(2131702099) + paramString3 + HardCodeUtil.a(2131702100);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[doOnCreate] chatPie:" + this + "," + this.P);
    }
    this.B = false;
    this.P = true;
    Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ((IApolloManagerService)localObject).getCmGameConnManager().a("page_tag_aio");
    ((IApolloManagerService)localObject).getGameTempMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "join");
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return super.a(paramBoolean);
  }
  
  public void aP()
  {
    super.aP();
    this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(7);
    this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839343);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", QQFrameZipDecoder.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(new CmGameChatPie.11(this));
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView = new FrameGifView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839344);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip", QQFrameZipDecoder.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micSmall.zip"), false);
      localObject = new LinearLayout.LayoutParams(AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setPadding(0, 0, 5, 0);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((ViewGroup)this.jdField_e_of_type_AndroidWidgetTextView.getParent()).addView(this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView, (ViewGroup.LayoutParams)localObject);
    }
    if (!CmGameAudioManager.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    }
  }
  
  public void ac()
  {
    super.ac();
    this.jdField_b_of_type_Boolean = false;
    b(true);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void ah()
  {
    super.ah();
    int i = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (i == 21) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void b(List<ApolloGameData> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void bi()
  {
    if (this.ac) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[showAddPlaymateIntro] isShow intro return.");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo == null)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[showAddPlaymateIntro] friendInfo is null return.");
        return;
      }
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while ((!localSharedPreferences.getBoolean("apollo_add_playMate_intro", true)) || (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo.jdField_c_of_type_Int != 0));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(a());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#cf000000"));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_n_of_type_Int = 0;
    ImageView localImageView = new ImageView(a());
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362801);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro.png", (URLDrawable.URLDrawableOptions)localObject));
    localImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.a(91.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(11);
    localLayoutParams1.addRule(10);
    localLayoutParams1.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    localImageView = new ImageView(a());
    localLayoutParams1 = new RelativeLayout.LayoutParams(AIOUtils.a(210.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.addRule(3, 2131362801);
    localLayoutParams1.addRule(11);
    localLayoutParams1.setMargins(0, 0, AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/add_playmate_intro1.png", (URLDrawable.URLDrawableOptions)localObject);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(localImageView, localLayoutParams1);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new CmGameChatPie.18(this));
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[showAddPlaymateIntro] already show addplaymate intro.");
    ((FrameLayout)a().getWindow().getDecorView()).addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.ac = true;
    localSharedPreferences.edit().putBoolean("apollo_add_playMate_intro", false).commit();
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "CmGameTemp_CmGameChatPie";
  }
  
  public void c(long paramLong)
  {
    ThreadManagerV2.getUIHandlerV2().post(new CmGameChatPie.16(this, paramLong));
  }
  
  public boolean c()
  {
    return !y();
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener = new CmGameChatPie.ChatPieMsgListener(this);
    }
    ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getGameTempMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$ChatPieMsgListener);
    StartupTracker.a("AIO_updateSession_business", null);
    this.Q = true;
    bj();
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
  }
  
  public boolean g()
  {
    if (this.ac)
    {
      v(true);
      w(true);
      return true;
    }
    return super.g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      bl();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar);
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameQuickInputTipsBar = null;
          continue;
          Object localObject = (String)paramMessage.obj;
          if ("dialog_type_permission".equals(localObject))
          {
            if (this.c == null)
            {
              localObject = DialogUtil.a(a(), 230).setMessage(a().getString(2131695642)).setTitle(a().getString(2131695643)).setNegativeButton(2131690800, new CmGameChatPie.4(this));
              if (!UITools.a(a())) {
                break label218;
              }
            }
            label218:
            for (int i = 2131695644;; i = 2131695645)
            {
              this.c = ((QQCustomDialog)localObject).setPositiveButton(i, new CmGameChatPie.3(this));
              this.c.show();
              break;
            }
          }
          if ("dialog_type_confirm".equals(localObject))
          {
            if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(a(), 230).setMessage(HardCodeUtil.a(2131702111)).setPositiveButton(a().getString(2131694615), new CmGameChatPie.6(this)).setNegativeButton(a().getString(2131690800), new CmGameChatPie.5(this));
            }
            this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          }
        }
      }
    }
  }
  
  public void i(String paramString)
  {
    if (this.g != null)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeView(this.g);
      a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqApolloApiAioImplCmGameChatPie$UserInfo.jdField_a_of_type_JavaLangString, 2);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForCmGameTips.needTopPadding = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      }
    }
  }
  
  public void j(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 16777218;
    localMessage.obj = paramString;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777218);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void l()
  {
    Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    CmGameTempSessionHandler localCmGameTempSessionHandler = ((IApolloManagerService)localObject).getGameTempMsgHandler();
    localCmGameTempSessionHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
    localCmGameTempSessionHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((IApolloManagerService)localObject).getCmGameAudioManager();
    if ((CmGameAudioManager.a) && (!((CmGameAudioManager)localObject).b())) {
      ((CmGameAudioManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    }
    if ((!android.text.TextUtils.isEmpty(((CmGameAudioManager)localObject).a())) && (((CmGameAudioManager)localObject).a().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839345);
    }
    localCmGameTempSessionHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 319);
    localCmGameTempSessionHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VipUtils.a(null, "cmshow", "Apollo", "returnBtn", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "dataEntry", 0, 0, new String[] { "" });
      continue;
      VipUtils.a(null, "cmshow", "Apollo", "inputBoxClick", 0, 0, new String[] { "" });
    }
  }
  
  public void t()
  {
    super.t();
  }
  
  public void t(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.14(this, paramBoolean));
  }
  
  public void u(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new CmGameChatPie.15(this, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "updateFriendVoiceStatus isVoiceOpen:", Boolean.valueOf(paramBoolean) });
    }
    this.V = paramBoolean;
    this.Z = true;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16777215);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16777215, 500L);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      ChatMessage localChatMessage = (ChatMessage)paramObject;
      if (localChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[update] get friend message,update friend status");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localChatMessage.selfuin;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 60000L);
        ThreadManager.getUIHandler().post(new CmGameChatPie.7(this));
      }
    }
    super.update(paramObservable, paramObject);
  }
  
  public void v(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_AndroidWidgetRelativeLayout != null) && (this.ac))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = null;
      this.ac = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAddFriend", 0, 0, new String[] { "2" });
      }
    }
  }
  
  public void w(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_AndroidWidgetRelativeLayout != null) && (this.ac))
    {
      ((FrameLayout)a().getWindow().getDecorView()).removeView(this.jdField_f_of_type_AndroidWidgetRelativeLayout);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = null;
      this.ac = false;
      if (paramBoolean) {
        VipUtils.a(null, "cmshow", "Apollo", "guideOfAudio", 0, 0, new String[] { "2" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie
 * JD-Core Version:    0.7.0.1
 */