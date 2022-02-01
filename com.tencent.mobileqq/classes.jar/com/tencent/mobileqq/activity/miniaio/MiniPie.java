package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.LinearLayout;
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
import com.tencent.imcore.message.BaseMsgProxy;
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
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQTheme;
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
  static int D;
  WindowManager A;
  WindowManager.LayoutParams B;
  int C = 0;
  MiniChatProvider E;
  protected int F = 0;
  RefreshMessageContext G;
  protected long H = -1L;
  int I = 0;
  int J = 0;
  Boolean K = Boolean.valueOf(true);
  float L;
  boolean M = false;
  protected XPanelContainer N;
  protected boolean O = false;
  protected boolean P = false;
  protected boolean Q = false;
  protected TextView R;
  protected ImageView S;
  protected boolean T = false;
  public MessageForReplyText.SourceMsgInfo U;
  public MovementMethod V;
  boolean W = false;
  SoftKeyboardHeight.OnGetSoftHeightListener X = new MiniPie.11(this);
  private TextView Y;
  private boolean Z = true;
  public String a = "MiniPie";
  private boolean aa = false;
  private boolean ab = false;
  private RelativeLayout ac;
  private boolean ad;
  private int ae = 0;
  private boolean af;
  private FriendListObserver ag = new MiniPie.10(this);
  private int ah;
  private SoftKeyboardHeight ai;
  Context b;
  SessionInfo c;
  QQAppInterface d;
  MqqHandler e;
  int f;
  String g;
  String h;
  ChatXListView i;
  MiniChatAdapter j;
  View k;
  int l = 0;
  RelativeLayout m;
  RelativeLayout n;
  RelativeLayout o;
  TextView p;
  ViewGroup q;
  RelativeLayout r;
  ViewGroup s;
  XEditTextEx t;
  Button u;
  ImageButton v;
  LinearLayout w;
  int x = 2;
  IEmoticonMainPanel y = null;
  boolean z;
  
  public MiniPie(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.b = paramContext;
    this.c = paramSessionInfo;
    this.d = paramQQAppInterface;
    MiniChatConstants.SCREEN_HEIGHT = this.b.getResources().getDisplayMetrics().heightPixels;
    if (MiniChatConstants.SCREEN_HEIGHT <= 0)
    {
      QLog.e(this.a, 1, "SCREEN_HEIGHT <= 0 reset to 1080");
      MiniChatConstants.SCREEN_HEIGHT = 1080;
    }
    A();
  }
  
  private void C()
  {
    if (this.S == null) {
      return;
    }
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.S.setColorFilter(-1);
    } else if ("1103".equals(ThemeUtil.curThemeId)) {
      this.S.setColorFilter(-7829368);
    }
    this.S.setVisibility(0);
    if (QQTheme.isNowSimpleUI()) {
      this.S.setImageResource(2130851959);
    } else {
      this.S.setImageResource(2130851961);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.S.setBackground(null);
      return;
    }
    this.S.setBackgroundDrawable(null);
  }
  
  private void D()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.m.setBackgroundResource(2130846269);
      return;
    }
    if (QQTheme.isNowSimpleUI())
    {
      this.m.setBackgroundResource(2130852232);
      return;
    }
    this.m.setBackgroundResource(2130846268);
  }
  
  private void E()
  {
    this.n.setVisibility(0);
    a(this.r.getResources());
    b(this.r.getResources());
  }
  
  private void F()
  {
    if (this.c == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioVideoBtnClick curType=");
      localStringBuilder.append(this.c.a);
      localStringBuilder.append(" curFriendUin= ");
      localStringBuilder.append(this.c.b);
      localStringBuilder.append(" troopUin ");
      localStringBuilder.append(this.c.c);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AVEnterPopActionSheetUtil.a(this.d, this.b, this.c, 3);
  }
  
  private void G()
  {
    this.A.removeView(this.y.getView());
    this.z = false;
  }
  
  private void H()
  {
    this.A.addView(this.y.getView(), this.B);
    this.z = true;
    this.e.post(new MiniPie.5(this));
  }
  
  private void I()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshListAdaper dirty ");
      ((StringBuilder)localObject2).append(this.F);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.j.a();
    Object localObject2 = this.d.getMessageFacade().c(this.g, this.f, -1L, true);
    EmojiStickerManager.a().a(this.d, this.i, this.c.b, this.c.a, 1, (List)localObject2);
    a((List)localObject1, (List)localObject2);
    b((List)localObject1, (List)localObject2);
    this.F = 0;
  }
  
  private boolean J()
  {
    return this.ad;
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a(Resources paramResources)
  {
    a(this.n);
    a(this.o);
    Object localObject1 = (ImageView)this.n.findViewById(2131435503);
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if ((localObject2 instanceof RelativeLayout.LayoutParams))
    {
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).width = AIOUtils.b(35.0F, paramResources);
      ((RelativeLayout.LayoutParams)localObject2).height = AIOUtils.b(35.0F, paramResources);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    ((ImageView)localObject1).setBackgroundResource(0);
    ((ImageView)localObject1).setImageDrawable(paramResources.getDrawable(2130853297));
    paramResources = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    localObject1 = (RelativeLayout.LayoutParams)this.R.getLayoutParams();
    if (QQTheme.isNowSimpleUI())
    {
      paramResources.addRule(14, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, 0);
    }
    else
    {
      paramResources.addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    }
    this.p.setLayoutParams(paramResources);
    this.R.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void a(Message paramMessage, int paramInt)
  {
    if (paramMessage.what == 9)
    {
      if (paramMessage.getData() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "refreshMiniListItem:MSG_REFRESH_LIST_ITEM");
      }
      long l1 = paramMessage.getData().getLong("messageUniseq");
      paramInt = paramMessage.getData().getInt("refreshType");
      paramMessage = (ChatMessage)this.d.getMessageProxy(this.c.a).b(this.c.b, this.c.a, l1);
      this.j.a(paramMessage, paramInt);
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    localLayoutParams.addRule(15, -1);
    paramRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  private void b(Resources paramResources)
  {
    c(this.r.getResources());
    d(this.r.getResources());
    D();
  }
  
  private void c(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateListUnRead: ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 0)
    {
      localObject1 = this.Y;
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(Integer.toString(paramInt));
        this.Y.setVisibility(8);
        return;
      }
    }
    if (paramInt > 0)
    {
      if (this.Y == null)
      {
        localObject1 = new TextView(this.b);
        ((TextView)localObject1).setId(2131438953);
        ((TextView)localObject1).setBackgroundResource(2130838379);
        ((TextView)localObject1).setGravity(1);
        ((TextView)localObject1).setPadding(0, (int)(this.L * 2.0F + 0.5F), 0, 0);
        ((TextView)localObject1).setSingleLine();
        ((TextView)localObject1).setTextColor(-1);
        ((TextView)localObject1).setTextSize(2, 16.0F);
        ((TextView)localObject1).setOnClickListener(this);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131435809);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        float f1 = this.L;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(f1 * 10.0F + 0.5F));
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(f1 * 10.0F + 0.5F));
        this.r.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.Y = ((TextView)localObject1);
      }
      localObject2 = this.Y;
      if (paramInt > 99) {
        localObject1 = "99";
      } else {
        localObject1 = Integer.toString(paramInt);
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.Y.setVisibility(0);
    }
  }
  
  private void c(Resources paramResources)
  {
    this.R.setAlpha(0.8F);
    if (ThemeUtil.isFixTheme(ThemeUtil.curThemeId))
    {
      this.p.setTextColor(paramResources.getColor(2131167990));
      this.R.setTextColor(paramResources.getColor(2131167990));
      return;
    }
    this.p.setTextColor(-1);
    this.R.setTextColor(-1);
  }
  
  private void d(Resources paramResources)
  {
    ImageView localImageView = (ImageView)this.ac.findViewById(2131436194);
    localImageView.setBackgroundResource(0);
    if (ThemeUtil.isFixTheme(ThemeUtil.curThemeId))
    {
      localImageView.setImageDrawable(paramResources.getDrawable(2130852269));
      return;
    }
    localImageView.setImageDrawable(paramResources.getDrawable(2130852270));
  }
  
  private boolean d(int paramInt)
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
  
  protected abstract void A();
  
  public void B()
  {
    ChatMessage localChatMessage = (ChatMessage)this.d.getMessageFacade().c(this.c.b, this.c.a, this.c.D);
    if (localChatMessage != null) {
      a(localChatMessage, 0, ReplyTextItemBuilder.a(this.d, this.c, Long.parseLong(localChatMessage.senderuin)), null);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131624459, paramViewGroup, false);
    }
    else
    {
      paramLayoutInflater = paramView;
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = this.a;
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("setCustomRootView() called hit cache convertView = [");
        paramViewGroup.append(paramView);
        paramViewGroup.append("]");
        QLog.d(paramLayoutInflater, 2, paramViewGroup.toString());
        paramLayoutInflater = paramView;
      }
    }
    this.q = ((ViewGroup)paramLayoutInflater.findViewById(2131427887));
    this.r = ((RelativeLayout)this.q.findViewById(2131430542));
    return paramLayoutInflater;
  }
  
  protected void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 6, null);
  }
  
  protected void a(int paramInt1, long paramLong, int paramInt2, Bundle paramBundle)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh with dirty: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|dirty ");
      localStringBuilder.append(this.F);
      localStringBuilder.append(" delay ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.F == paramInt1) && (paramInt2 != 9)) {
      return;
    }
    int i1 = 0xFFFF0000 & paramInt1;
    paramInt1 = Math.max(paramInt1 & 0xFFFF, 0xFFFF & this.F);
    this.F = (i1 | paramInt1);
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh with refreshFlag: ");
      localStringBuilder.append(i1);
      localStringBuilder.append(" scrollFlag: ");
      localStringBuilder.append(paramInt1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.M)
    {
      localObject = this.e.obtainMessage();
      ((Message)localObject).what = paramInt2;
      if (this.e.hasMessages(((Message)localObject).what)) {
        this.e.removeMessages(((Message)localObject).what);
      }
      if (paramBundle != null) {
        ((Message)localObject).setData(paramBundle);
      }
      this.e.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "update hold for not in Resuming ");
    }
  }
  
  protected void a(Context paramContext)
  {
    this.C = ((Activity)paramContext).getWindow().getAttributes().y;
    this.A = ((WindowManager)paramContext.getSystemService("window"));
    this.B = new WindowManager.LayoutParams(-1, SoftKeyboardHeight.a(0), 2, 32, -1);
    paramContext = this.B;
    paramContext.gravity = 81;
    paramContext.windowAnimations = 2131952054;
    this.ai = new SoftKeyboardHeight(((ViewGroup)((Activity)this.b).getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.A.getDefaultDisplay().getHeight(), this.X);
    this.ah = this.ai.a();
    this.ah = SoftKeyboardHeight.a(this.ah);
    paramContext = new MiniPie.7(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i1 = this.b.getResources().getDimensionPixelSize(2131299920);
      this.y = ((IEmoticonMainPanelService)((QQAppInterface)localAppRuntime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.b, 100003).setCallBack(paramContext).setOnlySysAndEmoji(true).setToastOffset(i1).create();
      this.y.hideAllTabs();
      this.B.height = this.ah;
      this.y.setDispatchKeyEventListener(new MiniPie.8(this));
      return;
    }
    QLog.e(this.a, 1, "get QQAppInterface fail");
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {
      return;
    }
    if (paramLong == 0L) {
      ReplyTextItemBuilder.a(this.d, this.c, Long.parseLong(paramChatMessage.senderuin));
    }
    paramString = ReplyMsgUtils.a(this.d, paramChatMessage, paramInt, paramLong, paramString);
    if (paramString == null) {
      return;
    }
    this.U = paramString;
    paramInt = this.t.getWidth();
    int i1 = this.t.getPaddingLeft();
    paramString = ReplyedMessageSpan.a(this.d, this.b, this.U, paramInt - i1, this.t.getPaint(), null);
    if (paramString != null)
    {
      Drawable localDrawable = paramString.getDrawable();
      Rect localRect = localDrawable.getBounds();
      localDrawable.setBounds(localRect.left, localRect.top + 20, localRect.right, localRect.bottom + 20);
      this.t.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.t.setCompoundDrawablePadding(30);
      this.t.setTag(2131441550, paramString);
      this.V = this.t.getMovementMethod();
      this.t.setMovementMethod(ReplyClickMovementMethod.a());
      paramString = this.t;
      paramString.setPadding(paramString.getPaddingLeft(), this.t.getPaddingTop(), this.t.getPaddingLeft(), this.t.getPaddingBottom());
      if ((this.U != null) && (!this.d.getCurrentUin().equals(String.valueOf(this.U.mSourceMsgSenderUin)))) {
        f(false);
      }
      paramInt = this.t.getMeasuredHeight();
      this.t.setMinHeight(paramInt);
    }
    else
    {
      paramString = this.V;
      if (paramString != null) {
        this.t.setMovementMethod(paramString);
      }
    }
    this.e.postDelayed(new MiniPie.12(this), 200L);
    MessageForReplyText.reportReplyMsg(this.d, this.c, paramChatMessage);
  }
  
  public void a(String paramString)
  {
    String str = this.g;
    if ((str != null) && (str.equals(paramString)))
    {
      a(131073, 0L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onlyRefreshData not me");
    }
  }
  
  protected void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int i1 = this.F & 0xFFFF0000;
    if (QLog.isColorLevel())
    {
      paramList1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("listViewSrollPosition tempBindType ");
      localStringBuilder.append(i1);
      QLog.d(paramList1, 2, localStringBuilder.toString());
    }
    if (i1 != 65536)
    {
      if ((i1 != 131072) && (i1 != 262144)) {
        return;
      }
      this.j.a(paramList2, null, 0);
      this.q.invalidate();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.i.getOverScrollHeaderView() == null)
      {
        if (this.k == null) {
          this.k = LayoutInflater.from(this.b).inflate(2131624523, null);
        }
        ViewParent localViewParent = this.k.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(this.k);
        }
        this.i.setOverScrollHeader(this.k);
      }
    }
    else
    {
      this.i.setOverscrollHeader((Drawable)null);
      this.i.setOverScrollHeader((View)null);
    }
  }
  
  public boolean a()
  {
    this.L = this.d.getApplication().getResources().getDisplayMetrics().density;
    this.e = new MqqHandler(Looper.getMainLooper(), this);
    this.E = new MiniChatProvider(this);
    this.E.b(4);
    d();
    g();
    i();
    f();
    j();
    if (!this.P)
    {
      y();
      a(this.b);
    }
    e();
    w();
    z();
    b();
    this.G = new RefreshMessageContext();
    this.G.a = new ChatContext(this.c.b);
    this.G.j = true;
    return true;
  }
  
  protected boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3)
        {
          bool1 = bool2;
          if (paramInt != 4)
          {
            if (paramInt == 5) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (d(paramMessageRecord.istroop)) && (d(this.c.a)) && (this.c.b.equals(paramMessageRecord.frienduin)) && (this.c.a == paramMessageRecord.istroop);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.u;
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localButton.setEnabled(bool);
  }
  
  public <T extends IHelper> T b(int paramInt)
  {
    return this.E.a(paramInt);
  }
  
  protected void b()
  {
    this.d.addObserver(this.ag);
  }
  
  protected void b(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int i1 = this.F & 0xFFFF;
    Object localObject = (MiniPieHelper)b(1);
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("listViewSrollPosition tempScrollType ");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if ((i1 != 2) && (i1 != 3))
        {
          if (i1 != 4)
          {
            if ((i1 != 9) && (localObject != null)) {
              this.I = ((MiniPieHelper)localObject).a(paramList1, paramList2, this.I);
            }
          }
          else if (localObject != null) {
            this.I = ((MiniPieHelper)localObject).a(this.i, this.I, paramList1, paramList2);
          }
        }
        else
        {
          if (!J()) {
            this.e.post(new MiniPie.6(this));
          } else {
            QLog.w(this.a, 1, "listViewSrollPosition: disableScrollBottom");
          }
          this.I = paramList2.size();
        }
      }
      else if (localObject != null)
      {
        ((MiniPieHelper)localObject).a(this.i, 0, paramList1, paramList2);
        i1 = paramList1.size();
        int i2 = paramList2.size();
        this.I = (this.I + i2 - i1);
      }
    }
    else
    {
      i1 = MiniPieHelper.b(this.i, this.I, paramList1, paramList2);
      if (i1 != 0)
      {
        this.F += i1;
        b(paramList1, paramList2);
      }
      if (localObject != null) {
        this.I = ((MiniPieHelper)localObject).a(paramList1, paramList2, this.I);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList1 = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("listViewSrollPosition mReadedCnt ");
      ((StringBuilder)localObject).append(this.I);
      ((StringBuilder)localObject).append(" newSize ");
      ((StringBuilder)localObject).append(paramList2.size());
      QLog.d(paramList1, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.ad = paramBoolean;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramCharSequence = (AtTroopMemberSpan[])this.t.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, AtTroopMemberSpan.class);
      if (QLog.isDevelopLevel())
      {
        String str = this.a;
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
        this.af = true;
        MiniChatReportHelper.a("0X800A9AC", "1");
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.aa))
    {
      this.aa = true;
      if ((this.c.B == 2) || (this.c.B == 5)) {
        this.e.postDelayed(new MiniPie.9(this), 200L);
      }
    }
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    this.f = this.c.a;
    this.g = this.c.b;
    this.h = this.c.e;
    Bundle localBundle = this.c.b();
    if (localBundle != null)
    {
      this.ab = localBundle.getBoolean("KEY_DELAY_SET_READ", false);
      this.P = localBundle.getBoolean("KEY_IS_IN_MULTI_AIO", false);
    }
    this.Q = a(this.c.B);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDelaySetRead() called with: delaySetRead = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.ab = paramBoolean;
  }
  
  protected void e()
  {
    if (D == 0) {
      D = this.b.getResources().getInteger(2131492891);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.R.getVisibility() == 8))
    {
      this.R.setVisibility(0);
      this.p.setTextSize(1, 17.0F);
      return;
    }
    if ((!paramBoolean) && (this.R.getVisibility() == 0))
    {
      this.R.setVisibility(8);
      this.p.setTextSize(1, 17.0F);
    }
  }
  
  public SpannableString f(boolean paramBoolean)
  {
    Object localObject1 = this.c;
    QQAppInterface localQQAppInterface = this.d;
    if ((((SessionInfo)localObject1).a != 1) && (((SessionInfo)localObject1).a != 3000)) {
      return null;
    }
    Object localObject2 = this.U;
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName)) {
        return null;
      }
      localObject2 = ((HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(((SessionInfo)localObject1).b);
      int i1 = 0;
      boolean bool1;
      if (localObject2 != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i2 = ((SessionInfo)localObject1).a;
      localObject2 = ((SessionInfo)localObject1).b;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.U.mSourceMsgSenderUin);
      ((StringBuilder)localObject3).append("");
      localObject2 = ContactUtils.a(localQQAppInterface, i2, (String)localObject2, ((StringBuilder)localObject3).toString());
      localObject3 = this.b;
      String str = ((SessionInfo)localObject1).b;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.U.mSourceMsgSenderUin);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      XEditTextEx localXEditTextEx = this.t;
      boolean bool2;
      if (((SessionInfo)localObject1).a == 1) {
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
          this.t.getEditableText().insert(0, (CharSequence)localObject1);
          return localObject1;
        }
        if (this.t.getSelectionStart() >= 0) {
          i1 = this.t.getSelectionStart();
        }
        this.t.getEditableText().insert(i1, (CharSequence)localObject1);
        return localObject1;
      }
    }
    return null;
  }
  
  protected void f()
  {
    if ((this.P) || (this.c.B == 2) || (this.c.B == 5))
    {
      if (QQTheme.isNowThemeIsNight())
      {
        this.q.setBackgroundResource(2130852162);
        return;
      }
      this.q.setBackgroundResource(2130852402);
    }
  }
  
  protected void g()
  {
    this.i = ((ChatXListView)this.q.findViewById(2131437281));
    Object localObject = this.i;
    boolean bool = true;
    ((ChatXListView)localObject).setStackFromBottom(true);
    this.i.setTranscriptMode(0);
    this.i.setOnScrollToButtomListener(this);
    this.i.setOnScrollListener(this);
    if (this.i.getHeaderViewsCount() == 0)
    {
      localObject = new View(this.b);
      int i1 = this.b.getResources().getDimensionPixelSize(2131299920);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, i1));
      ((View)localObject).setId(2131428030);
      this.i.addHeaderView((View)localObject, null, false);
      this.i.setOverscrollHeaderTop(i1);
    }
    a(true);
    this.i.setOverScrollListener(this);
    this.j = new MiniChatAdapter(this.d, this.b, this.c);
    this.j.a(this.i);
    localObject = this.j;
    if (this.c.B != 3) {
      bool = false;
    }
    ((MiniChatAdapter)localObject).a(bool);
    this.i.setAdapter(this.j);
  }
  
  protected void h() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 9: 
      a(paramMessage, paramMessage.arg1);
      break;
    case 8: 
      boolean bool = VasUtils.a(this.d, this.i);
      if (QLog.isColorLevel())
      {
        paramMessage = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSG_EFRESH_FONT_BUBBLE, needRefresh=");
        localStringBuilder.append(bool);
        QLog.d(paramMessage, 2, localStringBuilder.toString());
      }
      if (bool) {
        this.j.notifyDataSetChanged();
      }
      break;
    case 7: 
      TextItemBuilder.a(paramMessage, this.i);
      break;
    case 6: 
      I();
      break;
    case 5: 
      c(paramMessage.arg1);
    }
    return true;
  }
  
  protected void i()
  {
    this.m = ((RelativeLayout)this.q.findViewById(2131444897));
    this.p = ((TextView)this.m.findViewById(2131447463));
    this.p.setText(this.h);
    this.n = ((RelativeLayout)this.m.findViewById(2131436180));
    this.n.setOnClickListener(this);
    this.n.setVisibility(8);
    this.o = ((RelativeLayout)this.m.findViewById(2131447535));
    this.ac = ((RelativeLayout)this.m.findViewById(2131444906));
    this.R = ((TextView)this.m.findViewById(2131447572));
    this.R.setVisibility(8);
    ImageView localImageView1 = (ImageView)this.ac.findViewById(2131436194);
    localImageView1.setOnClickListener(this);
    if ((this.T) && (!this.P))
    {
      this.S = ((ImageView)this.ac.findViewById(2131436189));
      this.S.setOnClickListener(this);
      C();
    }
    if (this.P) {
      E();
    }
    if ((this.c.B == 2) || (this.c.B == 5))
    {
      ImageView localImageView2 = (ImageView)this.n.findViewById(2131435503);
      Object localObject = localImageView2.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(13.5F, this.b.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(13.5F, this.b.getResources());
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView2.setImageResource(2130852234);
      this.n.setVisibility(0);
      localImageView1.setImageResource(2130852397);
      if (Build.VERSION.SDK_INT >= 16) {
        localImageView1.setBackground(null);
      } else {
        localImageView1.setBackgroundDrawable(null);
      }
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        localImageView2.setColorFilter(-1);
        localImageView1.setColorFilter(-1);
      }
      else if ("1103".equals(ThemeUtil.curThemeId))
      {
        localImageView2.setColorFilter(-7829368);
        localImageView1.setColorFilter(-7829368);
      }
      c(this.r.getResources());
      D();
      a(this.n);
      a(this.o);
    }
  }
  
  protected void j()
  {
    this.s = ((ViewGroup)this.q.findViewById(2131435809));
    this.N = ((XPanelContainer)this.q.findViewById(2131445137));
    this.N.setIsNeedHandleMultiScreenSdkBelow24(this.P);
    k();
    this.t = ((XEditTextEx)this.q.findViewById(2131435808));
    this.t.removeTextChangedListener(this);
    this.w = ((LinearLayout)this.q.findViewById(2131435821));
    try
    {
      this.t.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    }
    catch (Exception localException)
    {
      QLog.e(this.a, 1, "input set error", localException);
    }
    this.t.addTextChangedListener(this);
    this.t.setOnClickListener(this);
    this.u = ((Button)this.q.findViewById(2131433920));
    this.u.setOnClickListener(this);
    Object localObject = (PanelIconLinearLayout)this.q.findViewById(2131439817);
    ((PanelIconLinearLayout)localObject).setPanelIconListener(new MiniPie.1(this));
    if (this.Q) {
      ((PanelIconLinearLayout)localObject).setCustomHeight(0);
    } else if (this.P)
    {
      if (QQTheme.isNowSimpleUI())
      {
        ((PanelIconLinearLayout)localObject).setCustomHeight(0);
        ((ImageView)this.q.findViewById(2131446053)).setVisibility(0);
        ((ImageView)this.q.findViewById(2131428040)).setVisibility(0);
      }
      else
      {
        ((PanelIconLinearLayout)localObject).setCustomHeight(AIOUtils.b(50.0F, ((PanelIconLinearLayout)localObject).getContext().getResources()));
        ((PanelIconLinearLayout)localObject).a(this.d, this.c, null);
        ((PanelIconLinearLayout)localObject).a(null, new UpdateParams.Builder().b(true).a());
      }
    }
    else {
      ((PanelIconLinearLayout)localObject).setCustomHeight(0);
    }
    if (((this.Q) || (this.P)) && (QQTheme.isNowThemeIsNight()))
    {
      AIOUtils.a(this.s, 2130851968);
      this.t.setTextColor(this.b.getResources().getColor(2131167990));
    }
    if (ThemeUtil.isFixTheme(ThemeUtil.curThemeId))
    {
      AIOUtils.a(this.w, 2130851969);
      this.u.setBackgroundResource(2130838269);
      this.u.setTextColor(this.b.getResources().getColor(2131167976));
    }
    localObject = new MiniPie.EnterForSend(this, null);
    this.t.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
    this.t.setOnKeyListener((View.OnKeyListener)localObject);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "doOnResume() called");
    }
    this.M = true;
    this.d.setHandler(MiniChatActivity.class, this.e);
    this.E.b(7);
    if (!this.Z) {
      a(this.c.b);
    } else {
      this.Z = false;
    }
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll((Activity)this.b);
    QQLiveImage.onForeground((Activity)this.b);
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
    AbstractVideoImage.resumeAll();
    if (this.c.B == 2) {
      MiniChatReportHelper.a("0X8009C2F");
    }
  }
  
  public void n()
  {
    if (this.P)
    {
      ConversationFacade localConversationFacade = this.d.getConversationFacade();
      if ((localConversationFacade != null) && (localConversationFacade.a(this.g, this.f) > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "resumeOthersForMultiAIO() called");
        }
        a(131075, 0L);
      }
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "doOnPause() called");
    }
    this.M = false;
    this.E.b(11);
    this.d.removeHandler(MiniChatActivity.class);
    ApngImage.pauseByTag(0);
    QQLiveImage.pauseAll((Activity)this.b);
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131438953: 
      this.I = this.j.getCount();
      if (this.I > 0)
      {
        localObject = this.i;
        ((ChatXListView)localObject).setSelectionFromBottom(((ChatXListView)localObject).getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      break;
    case 2131436194: 
      if (this.c.B == 2) {
        MiniChatReportHelper.a("0X8009C31");
      }
      if ((this.c.B == 2) || (this.c.B == 5))
      {
        this.W = true;
        localObject = AIOUtils.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 0, 2 });
        ((Intent)localObject).putExtra("uin", this.c.b);
        ((Intent)localObject).putExtra("uintype", this.c.a);
        ((Intent)localObject).putExtra("troop_uin", this.c.c);
        ((Intent)localObject).putExtra("uinname", this.c.e);
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          ((MiniMsgHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a();
        }
        MiniMsgIPCServer.a().f();
        this.N.a();
        this.e.postDelayed(new MiniPie.2(this, (Intent)localObject), 200L);
      }
      break;
    case 2131436189: 
      F();
      break;
    case 2131436180: 
      t();
      break;
    case 2131435808: 
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onClick case R.id.input");
      }
      u();
      break;
    case 2131433920: 
      localObject = (MiniPieHelper)b(1);
      if (localObject != null) {
        ((MiniPieHelper)localObject).c();
      }
      this.af = false;
      localObject = this.c.b();
      int i1 = 200;
      if (localObject != null) {
        i1 = this.c.b().getInt("key_mini_msgtab_businame", 200);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A194", "0X800A194", i1, 1, "", "", "", "");
      try
      {
        int i2 = ForegroundNotifyManager.c(this.c.a);
        if ((i1 == 28) && (i2 > 0)) {
          ReportController.b(null, "dc00898", "", "", "0X800AFD0", "0X800AFD0", i2, 0, "", "", "", "");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.a, 1, "onClick: failed. ", localThrowable);
      }
    case 2131427978: 
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onClick case aio_input_right_btn");
      }
      ImageButton localImageButton = (ImageButton)paramView;
      if (this.ae == 0)
      {
        this.ae = 1;
        localImageButton.setImageResource(2130840447);
        this.N.a();
        v();
      }
      else
      {
        this.ae = 0;
        localImageButton.setImageResource(2130840446);
        u();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "MiniPie onNotCompleteVisable");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = (MiniPieHelper)b(1);
    if (paramAbsListView != null) {
      paramAbsListView.a(paramInt1, paramInt2, paramInt3);
    }
    this.E.b(20);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      ScrollPlayer.a(false);
      this.j.c();
      VasFaceManager.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      com.etrump.mixlayout.api.ETFontUtil.enableAnimation = true;
      QQLiveImage.resumeAll((Activity)this.b);
      return;
    }
    AbstractGifImage.pauseAll();
    ScrollPlayer.a(true);
    if (paramInt == 2) {
      this.j.b();
    } else {
      this.j.c();
    }
    VasFaceManager.a();
    URLDrawable.pause();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    com.etrump.mixlayout.api.ETFontUtil.enableAnimation = false;
    AbstractVideoImage.pauseAll();
    QQLiveImage.pauseAll((Activity)this.b);
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "MiniPie onScrollToButtom");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.af) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      MiniChatReportHelper.a("0X800A9AE");
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "MiniPie onViewCompleteVisable");
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "MiniPie onViewCompleteVisableAndReleased");
    }
    x();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "MiniPie onViewNotCompleteVisableAndReleased");
    }
  }
  
  public void p()
  {
    this.E.b(5);
  }
  
  public void q()
  {
    QQLiveImage.onBackground((Activity)this.b);
    ShortVideoItemBuilder.j();
    ShortVideoRealItemBuilder.j();
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
    this.E.b(12);
  }
  
  public void r()
  {
    this.e.removeCallbacksAndMessages(null);
    this.d.removeHandler(MiniChatActivity.class);
    this.I = 0;
    this.J = 0;
    this.E.b(15);
    ((MediaPlayerManager)this.d.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.i);
    this.j.d();
    s();
    QQLiveImage.releaseAll((Activity)this.b);
    ShortVideoItemBuilder.j();
    ShortVideoRealItemBuilder.j();
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
    Object localObject = this.y;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onDestory();
    }
    localObject = this.ai;
    if (localObject != null) {
      ((SoftKeyboardHeight)localObject).b();
    }
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
  }
  
  protected void s()
  {
    QQAppInterface localQQAppInterface = this.d;
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.removeObserver(this.ag);
  }
  
  public void t()
  {
    this.N.a();
    this.E.b(14);
    ((Activity)this.b).finish();
  }
  
  protected void u()
  {
    if ((this.z) && (this.y != null)) {
      G();
    }
    this.e.postDelayed(new MiniPie.3(this), 200L);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramObservable = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" update");
      QLog.d(paramObservable, 2, ((StringBuilder)localObject).toString());
    }
    if (!this.M) {
      return;
    }
    if ((paramObject instanceof ChatMessage))
    {
      paramObservable = (MessageRecord)paramObject;
      if (QLog.isColorLevel())
      {
        localObject = this.a;
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
        z();
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
        paramObservable = this.a;
        paramObject = new StringBuilder();
        paramObject.append("update--> isNeedUpdate false  isResume ");
        paramObject.append(this.M);
        QLog.d(paramObservable, 2, paramObject.toString());
      }
    }
    else if ((paramObject instanceof RefreshMessageContext))
    {
      paramObservable = (RefreshMessageContext)paramObject;
      paramObject = (ChatContext)paramObservable.a;
      if ((this.c.b != null) && (this.c.b.equals(paramObject.a())))
      {
        if ((this.H == paramObject.b()) && (paramObservable.j) && (paramObservable.f))
        {
          long l1 = this.H + 300L - SystemClock.uptimeMillis();
          if (l1 <= 0L) {
            l1 = 0L;
          }
          a(131076, l1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "refreshMessageContext sync theSameUinAIO return");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.a, 2, "update--> do nothing");
    }
  }
  
  protected void v()
  {
    if (this.y != null)
    {
      if (this.z)
      {
        G();
        return;
      }
      this.e.postDelayed(new MiniPie.4(this), 200L);
    }
  }
  
  protected void w()
  {
    List localList = this.d.getMessageFacade().c(this.g, this.f, -1L, false);
    if ((localList != null) && (localList.size() > 0))
    {
      EmojiStickerManager.a().a(this.d, this.i, this.c.b, this.c.a, 1, localList);
      if (QLog.isColorLevel())
      {
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadFirstData() called size = [");
        localStringBuilder.append(localList.size());
        localStringBuilder.append("]");
        QLog.d(str, 2, localStringBuilder.toString());
      }
      this.j.a(localList, null, 0);
    }
  }
  
  protected void x()
  {
    Object localObject = this.j;
    if ((localObject != null) && (((MiniChatAdapter)localObject).getCount() > 0))
    {
      this.H = SystemClock.uptimeMillis();
      ((ChatContext)this.G.a).a(this.H);
      localObject = this.G;
      ((RefreshMessageContext)localObject).g = false;
      ((RefreshMessageContext)localObject).h = true;
      this.d.getMessageFacade().a(this.c.b, this.c.a, 20, this.G);
      return;
    }
    a(false);
  }
  
  protected void y()
  {
    this.v = ((ImageButton)this.q.findViewById(2131427978));
    this.v.setVisibility(0);
    this.v.setOnClickListener(this);
    ImageButton localImageButton = this.v;
    float f1 = this.L;
    AIOUtils.a(localImageButton, (int)(f1 * 5.0F + 0.5F), (int)(f1 * 5.0F + 0.5F), 0, 0);
    if (this.P) {
      this.v.setVisibility(8);
    }
  }
  
  public void z()
  {
    if (this.ab) {
      return;
    }
    int i1 = this.c.a;
    if ((i1 != 1033) && (i1 != 1034))
    {
      i1 = this.d.getConversationFacade().a(this.c.b, this.c.a);
      FightMsgReporter.a(1, 0, this.c.a, i1);
    }
    ChatActivityFacade.a(this.d, this.c);
    this.d.getMessageFacade().a(this.c.b, this.c.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie
 * JD-Core Version:    0.7.0.1
 */