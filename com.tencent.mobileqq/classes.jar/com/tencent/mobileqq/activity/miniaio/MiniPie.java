package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.utils.AVEnterPopActionSheetUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams.Builder;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloItemBuilderHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SoftKeyboardHeight;
import com.tencent.mobileqq.utils.SoftKeyboardHeight.OnGetSoftHeightListener;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class MiniPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, IChatWindow, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, OverScrollViewListener, Observer
{
  static int e;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext;
  public MovementMethod a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  protected ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RefreshMessageContext jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  MiniChatAdapter jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter;
  MiniChatProvider jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MiniPie.10(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public MessageForReplyText.SourceMsgInfo a;
  IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = null;
  SoftKeyboardHeight.OnGetSoftHeightListener jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener = new MiniPie.11(this);
  private SoftKeyboardHeight jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight;
  XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  protected XPanelContainer a;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public String a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 2;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  protected boolean c;
  int jdField_d_of_type_Int = 0;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  protected boolean d;
  protected boolean e;
  protected int f;
  boolean f;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = true;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public MiniPie(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "MiniPie";
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    MiniChatConstants.SCREEN_HEIGHT = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    if (MiniChatConstants.SCREEN_HEIGHT <= 0)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "SCREEN_HEIGHT <= 0 reset to 1080");
      MiniChatConstants.SCREEN_HEIGHT = 1080;
    }
    y();
  }
  
  private void A()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      return;
    }
    localImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850170);
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(Color.argb(255, 3, 8, 26));
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
  }
  
  private void B()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.8F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844834);
      localImageView = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369216);
      localImageView.setBackgroundResource(0);
      if (SimpleUIUtil.a()) {
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844769));
      } else {
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850474));
      }
      localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368591);
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851067));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844835);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369216);
    localImageView.setBackgroundResource(0);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850473));
    localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368591);
    Object localObject = localImageView.getLayoutParams();
    if ((localObject instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localImageView.setBackgroundResource(0);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851066));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053));
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.8F);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioVideoBtnClick curType=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localStringBuilder.append(" curFriendUin= ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" troopUin ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AVEnterPopActionSheetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3);
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView());
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void E()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView(), this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MiniPie.5(this));
  }
  
  private void F()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshListAdaper dirty ");
      ((StringBuilder)localObject2).append(this.jdField_f_of_type_Int);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, -1L, true);
    EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1, (List)localObject2);
    a((List)localObject1, (List)localObject2);
    b((List)localObject1, (List)localObject2);
    this.jdField_f_of_type_Int = 0;
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateListUnRead: ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(Integer.toString(paramInt));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
    }
    if (paramInt > 0)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject1).setId(2131371572);
        ((TextView)localObject1).setBackgroundResource(2130838330);
        ((TextView)localObject1).setGravity(1);
        ((TextView)localObject1).setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F + 0.5F), 0, 0);
        ((TextView)localObject1).setSingleLine();
        ((TextView)localObject1).setTextColor(-1);
        ((TextView)localObject1).setTextSize(2, 16.0F);
        ((TextView)localObject1).setOnClickListener(this);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368875);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        float f1 = this.jdField_a_of_type_Float;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(f1 * 10.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(f1 * 10.0F + 0.5F));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      }
      localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramInt > 99) {
        localObject1 = "99";
      } else {
        localObject1 = Integer.toString(paramInt);
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 3000)
      {
        if (paramInt == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public SpannableString a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((((SessionInfo)localObject1).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject1).jdField_a_of_type_Int != 3000)) {
      return null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName)) {
        return null;
      }
      localObject2 = ((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
      int m = 0;
      boolean bool1;
      if (localObject2 != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int n = ((SessionInfo)localObject1).jdField_a_of_type_Int;
      localObject2 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject3).append("");
      localObject2 = ContactUtils.a(localQQAppInterface, n, (String)localObject2, ((StringBuilder)localObject3).toString());
      localObject3 = this.jdField_a_of_type_AndroidContentContext;
      String str = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      boolean bool2;
      if (((SessionInfo)localObject1).jdField_a_of_type_Int == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObject1 = AtTroopMemberSpan.a(localQQAppInterface, (Context)localObject3, str, (String)localObject4, (String)localObject2, bool1, localXEditTextEx, bool2, true);
      if (localObject1 != null)
      {
        if (((SpannableString)localObject1).length() <= 0) {
          return null;
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject1);
          return localObject1;
        }
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() >= 0) {
          m = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(m, (CharSequence)localObject1);
        return localObject1;
      }
    }
    return null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131558839, paramViewGroup, false);
    }
    else
    {
      paramLayoutInflater = paramView;
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = this.jdField_a_of_type_JavaLangString;
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("setCustomRootView() called hit cache convertView = [");
        paramViewGroup.append(paramView);
        paramViewGroup.append("]");
        QLog.d(paramLayoutInflater, 2, paramViewGroup.toString());
        paramLayoutInflater = paramView;
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131362288));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364485));
    return paramLayoutInflater;
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(paramInt);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh with dirty: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|dirty ");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append(" delay ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int n = this.jdField_f_of_type_Int;
    if (n == paramInt) {
      return;
    }
    int m = 0xFFFF0000 & paramInt;
    paramInt &= 0xFFFF;
    if (paramInt <= (n & 0xFFFF)) {
      paramInt = n & 0xFFFF;
    }
    this.jdField_f_of_type_Int = (m | paramInt);
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh with refreshFlag: ");
      localStringBuilder.append(m);
      localStringBuilder.append(" scrollFlag: ");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
      ((Message)localObject).what = 6;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(((Message)localObject).what)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(((Message)localObject).what);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update hold for not in Resuming ");
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_d_of_type_Int = ((Activity)paramContext).getWindow().getAttributes().y;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, SoftKeyboardHeight.a(0), 2, 32, -1);
    paramContext = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    paramContext.gravity = 81;
    paramContext.windowAnimations = 2131755352;
    this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight = new SoftKeyboardHeight(((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight$OnGetSoftHeightListener);
    this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight.a();
    this.jdField_j_of_type_Int = SoftKeyboardHeight.a(this.jdField_j_of_type_Int);
    paramContext = new MiniPie.7(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = ((IEmoticonMainPanelService)((QQAppInterface)localAppRuntime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.jdField_a_of_type_AndroidContentContext, 100003).setCallBack(paramContext).setOnlySysAndEmoji(true).setToastOffset(m).create();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.hideAllTabs();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_j_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setDispatchKeyEventListener(new MiniPie.8(this));
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "get QQAppInterface fail");
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {
      return;
    }
    if (paramLong == 0L) {
      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, Long.parseLong(paramChatMessage.senderuin));
    }
    paramString = ReplyMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramInt, paramLong, paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramString;
    paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
    int m = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
    paramString = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, paramInt - m, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), null);
    if (paramString != null)
    {
      Drawable localDrawable = paramString.getDrawable();
      Rect localRect = localDrawable.getBounds();
      localDrawable.setBounds(localRect.left, localRect.top + 20, localRect.right, localRect.bottom + 20);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(30);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373876, paramString);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
      paramString = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      paramString.setPadding(paramString.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin)))) {
        a(false);
      }
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(paramInt);
    }
    else
    {
      paramString = this.jdField_a_of_type_AndroidTextMethodMovementMethod;
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(paramString);
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.12(this), 200L);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(String paramString)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if ((str != null) && (str.equals(paramString)))
    {
      a(131073, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onlyRefreshData not me");
    }
  }
  
  protected void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int m = this.jdField_f_of_type_Int & 0xFFFF0000;
    if (QLog.isColorLevel())
    {
      paramList1 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("listViewSrollPosition tempBindType ");
      localStringBuilder.append(m);
      QLog.d(paramList1, 2, localStringBuilder.toString());
    }
    if (m != 65536)
    {
      if ((m != 131072) && (m != 262144)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a(paramList2, null, 0);
      this.jdField_a_of_type_AndroidViewViewGroup.invalidate();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558901, null);
        }
        ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider = new MiniChatProvider(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(4);
    b();
    e();
    g();
    d();
    h();
    if (!this.jdField_d_of_type_Boolean)
    {
      w();
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    c();
    u();
    x();
    a();
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext = new RefreshMessageContext();
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.a = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_h_of_type_Boolean = true;
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (a(paramMessageRecord.istroop)) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localButton.setEnabled(bool);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    if (localBundle != null)
    {
      this.jdField_i_of_type_Boolean = localBundle.getBoolean("KEY_DELAY_SET_READ", false);
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("KEY_IS_IN_MULTI_AIO", false);
    }
  }
  
  protected void b(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int m = this.jdField_f_of_type_Int & 0xFFFF;
    Object localObject = (MiniPieHelper)a(1);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("listViewSrollPosition tempScrollType ");
      localStringBuilder.append(m);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (m != 0)
    {
      if (m != 1)
      {
        if ((m != 2) && (m != 3))
        {
          if (m != 4)
          {
            if ((m != 8) && (localObject != null)) {
              this.jdField_g_of_type_Int = ((MiniPieHelper)localObject).a(paramList1, paramList2, this.jdField_g_of_type_Int);
            }
          }
          else if (localObject != null) {
            this.jdField_g_of_type_Int = ((MiniPieHelper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_g_of_type_Int, paramList1, paramList2);
          }
        }
        else
        {
          if (!c()) {
            this.jdField_a_of_type_MqqOsMqqHandler.post(new MiniPie.6(this));
          } else {
            QLog.w(this.jdField_a_of_type_JavaLangString, 1, "listViewSrollPosition: disableScrollBottom");
          }
          this.jdField_g_of_type_Int = paramList2.size();
        }
      }
      else if (localObject != null)
      {
        ((MiniPieHelper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, 0, paramList1, paramList2);
        m = paramList1.size();
        int n = paramList2.size();
        this.jdField_g_of_type_Int = (this.jdField_g_of_type_Int + n - m);
      }
    }
    else
    {
      m = MiniPieHelper.b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_g_of_type_Int, paramList1, paramList2);
      if (m != 0)
      {
        this.jdField_f_of_type_Int += m;
        b(paramList1, paramList2);
      }
      if (localObject != null) {
        this.jdField_g_of_type_Int = ((MiniPieHelper)localObject).a(paramList1, paramList2, this.jdField_g_of_type_Int);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList1 = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("listViewSrollPosition mReadedCnt ");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
      ((StringBuilder)localObject).append(" newSize ");
      ((StringBuilder)localObject).append(paramList2.size());
      QLog.d(paramList1, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramCharSequence = (AtTroopMemberSpan[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, AtTroopMemberSpan.class);
      if (QLog.isDevelopLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("find beforeTextChanged atTroopMemberSpan1 ...");
        localStringBuilder.append(paramCharSequence.length);
        localStringBuilder.append(",start = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",before = ");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 4, localStringBuilder.toString());
      }
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.k = true;
        MiniChatReportHelper.a("0X800A9AC", "1");
      }
    }
  }
  
  protected void c()
  {
    if (jdField_e_of_type_Int == 0) {
      jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131427346);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 5)) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.9(this), 200L);
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId)))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850604);
        return;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850371);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDelaySetRead() called with: delaySetRead = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370119));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    boolean bool = true;
    ((ChatXListView)localObject).setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0)
    {
      localObject = new View(this.jdField_a_of_type_AndroidContentContext);
      int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, m));
      ((View)localObject).setId(2131362422);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView((View)localObject, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(m);
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter = new MiniChatAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int != 3) {
      bool = false;
    }
    ((MiniChatAdapter)localObject).a(bool);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter);
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      return;
    }
    if ((!paramBoolean) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376636));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378784));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376645));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378872));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    ImageView localImageView1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369216);
    localImageView1.setOnClickListener(this);
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131369211));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      A();
    }
    if (this.jdField_d_of_type_Boolean) {
      B();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 5))
    {
      ImageView localImageView2 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368591);
      Object localObject = localImageView2.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(13.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(13.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView2.setImageResource(2130850438);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localImageView1.setImageResource(2130850599);
      if (Build.VERSION.SDK_INT >= 16)
      {
        localImageView1.setBackground(null);
        return;
      }
      localImageView1.setBackgroundDrawable(null);
    }
  }
  
  protected void h()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368875));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376809));
    i();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368874));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "input set error", localException);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367417));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372306);
    ((PanelIconLinearLayout)localObject).setPanelIconListener(new MiniPie.1(this));
    if (this.jdField_d_of_type_Boolean)
    {
      ((PanelIconLinearLayout)localObject).setCustomHeight(AIOUtils.b(50.0F, ((PanelIconLinearLayout)localObject).getContext().getResources()));
      ((PanelIconLinearLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
      ((PanelIconLinearLayout)localObject).a(null, new UpdateParams.Builder().b(true).a());
    }
    else
    {
      ((PanelIconLinearLayout)localObject).setCustomHeight(0);
    }
    if ((this.jdField_d_of_type_Boolean) && (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))))
    {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368882);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130850177);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundResource(2130850177);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130850178);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838215);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167040));
    }
    localObject = new MiniPie.EnterForSend(this, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener((View.OnKeyListener)localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 5)
    {
      if (m != 6)
      {
        if (m != 7)
        {
          if (m == 8)
          {
            boolean bool = VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
            if (QLog.isColorLevel())
            {
              paramMessage = this.jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("MSG_EFRESH_FONT_BUBBLE, needRefresh=");
              localStringBuilder.append(bool);
              QLog.d(paramMessage, 2, localStringBuilder.toString());
            }
            if (bool) {
              this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.notifyDataSetChanged();
            }
          }
        }
        else {
          TextItemBuilder.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
        }
      }
      else {
        F();
      }
    }
    else {
      a(paramMessage.arg1);
    }
    return true;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnResume() called");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(MiniChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(7);
    if (!this.jdField_g_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } else {
      this.jdField_g_of_type_Boolean = false;
    }
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    QQLiveImage.onForeground((Activity)this.jdField_a_of_type_AndroidContentContext);
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
    AbstractVideoImage.resumeAll();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) {
      MiniChatReportHelper.a("0X8009C2F");
    }
  }
  
  public void l()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
      if ((localConversationFacade != null) && (localConversationFacade.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int) > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resumeOthersForMultiAIO() called");
        }
        a(131075, 0L);
      }
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause() called");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(11);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(MiniChatActivity.class);
    ApngImage.pauseByTag(0);
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(5);
  }
  
  public void o()
  {
    QQLiveImage.onBackground((Activity)this.jdField_a_of_type_AndroidContentContext);
    ShortVideoItemBuilder.g();
    ShortVideoRealItemBuilder.g();
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(12);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131371572: 
      this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.getCount();
      if (this.jdField_g_of_type_Int > 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        ((ChatXListView)localObject).setSelectionFromBottom(((ChatXListView)localObject).getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      break;
    case 2131369216: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) {
        MiniChatReportHelper.a("0X8009C31");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 5))
      {
        this.jdField_f_of_type_Boolean = true;
        localObject = AIOUtils.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 0, 2 });
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          ((MiniMsgHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a();
        }
        MiniMsgIPCServer.a().d();
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.2(this, (Intent)localObject), 200L);
      }
      break;
    case 2131369211: 
      C();
      break;
    case 2131369202: 
      r();
      break;
    case 2131368874: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick case R.id.input");
      }
      s();
      break;
    case 2131367417: 
      localObject = (MiniPieHelper)a(1);
      if (localObject != null) {
        ((MiniPieHelper)localObject).c();
      }
      this.k = false;
      int m = 200;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a() != null) {
        m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a().getInt("key_mini_msgtab_businame");
      }
      ReportController.b(null, "dc00898", "", "", "0X800A194", "0X800A194", m, 1, "", "", "", "");
      try
      {
        int n = ForegroundNotifyManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if ((m == 28) && (n > 0)) {
          ReportController.b(null, "dc00898", "", "", "0X800AFD0", "0X800AFD0", n, 0, "", "", "", "");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "onClick: failed. ", localThrowable);
      }
    case 2131362370: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick case aio_input_right_btn");
      }
      ImageButton localImageButton = (ImageButton)paramView;
      if (this.jdField_i_of_type_Int == 0)
      {
        this.jdField_i_of_type_Int = 1;
        localImageButton.setImageResource(2130840142);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        t();
      }
      else
      {
        this.jdField_i_of_type_Int = 0;
        localImageButton.setImageResource(2130840141);
        s();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onNotCompleteVisable");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = (MiniPieHelper)a(1);
    if (paramAbsListView != null) {
      paramAbsListView.a(paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(20);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ScrollPlayer.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.b();
      VasFaceManager.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    AbstractGifImage.pauseAll();
    ScrollPlayer.a(true);
    if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.b();
    }
    VasFaceManager.a();
    URLDrawable.pause();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    AbstractVideoImage.pauseAll();
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onScrollToButtom");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.k) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      MiniChatReportHelper.a("0X800A9AE");
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewCompleteVisable");
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewCompleteVisableAndReleased");
    }
    v();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewNotCompleteVisableAndReleased");
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(MiniChatActivity.class);
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(15);
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.c();
    q();
    QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    ShortVideoItemBuilder.g();
    ShortVideoRealItemBuilder.g();
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsSoftKeyboardHeight;
    if (localObject != null) {
      ((SoftKeyboardHeight)localObject).a();
    }
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
  }
  
  protected void q()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(14);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  protected void s()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel != null)) {
      D();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.3(this), 200L);
  }
  
  protected void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        D();
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.4(this), 200L);
    }
  }
  
  protected void u()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, -1L, false);
    if ((localList != null) && (localList.size() > 0))
    {
      EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1, localList);
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadFirstData() called size = [");
        localStringBuilder.append(localList.size());
        localStringBuilder.append("]");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter.a(localList, null, 0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramObservable = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" update");
      QLog.d(paramObservable, 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((paramObject instanceof ChatMessage))
    {
      paramObservable = (MessageRecord)paramObject;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update mr.msgseq");
        localStringBuilder.append(paramObservable.msgseq);
        localStringBuilder.append(",time is:");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append(" status:");
        localStringBuilder.append(paramObservable.extraflag);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (a(paramObservable))
      {
        x();
        ((ChatMessage)paramObject).mMsgAnimFlag = true;
        if (paramObservable.isSendFromLocal())
        {
          a(131075, 0L);
          return;
        }
        a(131072, 0L);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramObservable = this.jdField_a_of_type_JavaLangString;
        paramObject = new StringBuilder();
        paramObject.append("update--> isNeedUpdate false  isResume ");
        paramObject.append(this.jdField_b_of_type_Boolean);
        QLog.d(paramObservable, 2, paramObject.toString());
      }
    }
    else if ((paramObject instanceof RefreshMessageContext))
    {
      paramObservable = (RefreshMessageContext)paramObject;
      paramObject = (ChatContext)paramObservable.a;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.a())))
      {
        if ((this.jdField_a_of_type_Long == paramObject.a()) && (paramObservable.jdField_h_of_type_Boolean) && (paramObservable.jdField_d_of_type_Boolean))
        {
          long l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
          if (l <= 0L) {
            l = 0L;
          }
          a(131076, l);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageContext sync theSameUinAIO return");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update--> do nothing");
    }
  }
  
  protected void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatAdapter;
    if ((localObject != null) && (((MiniChatAdapter)localObject).getCount() > 0))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.a).a(this.jdField_a_of_type_Long);
      localObject = this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
      ((RefreshMessageContext)localObject).jdField_e_of_type_Boolean = false;
      ((RefreshMessageContext)localObject).jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
      return;
    }
    a(false);
  }
  
  protected void w()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362370));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    float f1 = this.jdField_a_of_type_Float;
    AIOUtils.a(localImageButton, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), 0, 0);
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  public void x()
  {
    if (this.jdField_i_of_type_Boolean) {
      return;
    }
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((m != 1033) && (m != 1034))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      FightMsgReporter.a(1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, m);
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
  }
  
  protected abstract void y();
  
  public void z()
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Long);
    if (localChatMessage != null) {
      a(localChatMessage, 0, ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, Long.parseLong(localChatMessage.senderuin)), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie
 * JD-Core Version:    0.7.0.1
 */