package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardMsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MultiForwardScroller;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.BlurUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class MultiForwardChatPie
  extends BaseChatPie
{
  private final int bA = 300;
  private List<ChatMessage> bB;
  private long bC;
  private MessageForStructing bD;
  private int bE;
  private Runnable bF = new MultiForwardChatPie.4(this);
  private Drawable bG;
  private Drawable[] bH;
  private int bI;
  private BizTroopObserver bJ = new MultiForwardChatPie.10(this);
  private FMObserver bK = new MultiForwardChatPie.11(this);
  View bi;
  ScrollerRunnable bj;
  long bk;
  String bl;
  String bm;
  public Runnable bn;
  public boolean bo = false;
  public MqqHandler bp = new MultiForwardChatPie.1(this);
  FriendListObserver bq = new MultiForwardChatPie.12(this);
  TroopObserver br = new MultiForwardChatPie.13(this);
  private RelativeLayout bs;
  private RelativeLayout bt;
  private TextView bu;
  private ImageView bv;
  private ChatXListView bw;
  private AIOAnimationConatiner bx;
  private ChatAdapter1 by = null;
  private View bz;
  
  public MultiForwardChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a(View paramView, int paramInt, ActionSheet paramActionSheet)
  {
    if (paramView == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    String str = paramActionSheet.getContent(paramInt);
    if (str == null)
    {
      paramActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramActionSheet.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131890804)))
    {
      MultiMsgUtil.a("0X8009AB5");
      c(this.bk);
    }
    paramActionSheet.dismiss();
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.m.removeMessages(24);
    if (this.ao != null)
    {
      if (!this.ao.isShowing()) {
        return;
      }
      Object localObject;
      if ((paramBoolean) && (paramObject != null) && (MultiMsgManager.a().e == 6))
      {
        this.ao.dismiss();
        MultiMsgManager.a().d.clear();
        localObject = MultiMsgManager.a().d;
        Map localMap = (Map)paramObject;
        ((HashMap)localObject).putAll(localMap);
        ((MultiFavoriteHelper)this.g.a(11)).a(localMap, MultiMsgManager.a().c, MultiMsgManager.a().e);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMultiFavorite = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void bD()
  {
    this.m.removeCallbacks(this.bF);
    AIOMessageRecordExposeDataReportHelper localAIOMessageRecordExposeDataReportHelper = (AIOMessageRecordExposeDataReportHelper)q(49);
    if (localAIOMessageRecordExposeDataReportHelper != null) {
      localAIOMessageRecordExposeDataReportHelper.onMoveToState(9);
    }
  }
  
  private void c(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  private void e(View paramView)
  {
    paramView = ActionSheet.createMenuSheet(paramView.getContext());
    paramView.addButton(2131890804);
    paramView.addCancelButton(2131887648);
    paramView.setOnButtonClickListener(new MultiForwardChatPie.8(this, paramView));
    paramView.show();
  }
  
  private void t(int paramInt)
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)q(4);
    if (localChatPieSelectableHelper != null) {
      localChatPieSelectableHelper.onMoveToState(paramInt);
    }
  }
  
  public void K()
  {
    this.aE = 9;
    t(14);
    this.aP = null;
    this.aQ = null;
    this.aR = 0;
    this.aS = 0;
    this.by.d();
    Object localObject = this.bB;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    av();
    this.m.removeCallbacks(this.bF);
    localObject = (AIOMessageRecordExposeDataReportHelper)q(49);
    if (localObject != null) {
      ((AIOMessageRecordExposeDataReportHelper)localObject).onMoveToState(15);
    }
    if (this.bd != null) {
      this.bd.c();
    }
  }
  
  public void L()
  {
    Runnable localRunnable = this.bn;
    if (localRunnable != null)
    {
      this.bw.removeCallbacks(localRunnable);
      this.bn = null;
    }
    if (this.f != null) {
      this.f.finish();
    }
  }
  
  public void N()
  {
    this.aE = 3;
  }
  
  public void O()
  {
    this.aE = 6;
    t(12);
  }
  
  public void P()
  {
    QQLiveImage.pauseAll(this.f);
    AbstractGifImage.pauseAll();
    this.aE = 5;
    t(11);
    if (this.bd != null) {
      this.bd.b();
    }
  }
  
  public void S()
  {
    if (this.aC) {
      this.m.postDelayed(this.bF, 800L);
    }
    if (this.aC)
    {
      this.bw.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.aC = false;
    }
    else
    {
      this.by.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(this.f);
    AbstractGifImage.resumeAll();
    this.aE = 4;
    t(7);
    if (this.bd != null) {
      this.bd.a();
    }
  }
  
  public boolean V()
  {
    Object localObject = (ChatPieSelectableHelper)q(4);
    if ((localObject != null) && (((ChatPieSelectableHelper)localObject).a())) {
      return true;
    }
    localObject = this.bn;
    if (localObject != null)
    {
      this.bw.removeCallbacks((Runnable)localObject);
      this.bn = null;
    }
    BaseChatItemLayout.ad = this.bo;
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.d.getApplication().getString(2131917002));
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
  }
  
  protected boolean a()
  {
    if (this.bG == null)
    {
      this.bG = this.f.getResources().getDrawable(2130839590);
      this.bH = this.C.getCompoundDrawables();
      this.bI = this.C.getCompoundDrawablePadding();
      this.C.setCompoundDrawablePadding(10);
      TextView localTextView = this.C;
      Drawable localDrawable = this.bG;
      Drawable[] arrayOfDrawable = this.bH;
      localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      ((Animatable)this.bG).start();
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.aC = true;
    this.bo = BaseChatItemLayout.ad;
    BaseChatItemLayout.ad = false;
    this.aL = ThemeUtil.isDefaultOrDIYTheme(false);
    this.aE = 2;
    Object localObject1 = (ViewGroup)this.aZ.findViewById(2131427887);
    ((ViewGroup)localObject1).removeView(this.aZ.findViewById(2131445137));
    Object localObject2 = View.inflate(this.f, 2131624119, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.bE = this.f.getIntent().getIntExtra("callback_type", 1);
    this.bl = this.f.getIntent().getStringExtra("multi_url");
    this.bk = this.f.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.bm = this.f.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.bm)) {
      this.bm = HardCodeUtil.a(2131904877);
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MultiForwardActivity.doOnCreate ResID = ");
      ((StringBuilder)localObject1).append(this.bl);
      ((StringBuilder)localObject1).append("  msg.uniseq = ");
      ((StringBuilder)localObject1).append(this.bk);
      ((StringBuilder)localObject1).append(" downCallBackType");
      ((StringBuilder)localObject1).append(this.bE);
      QLog.d("MultiMsg_TAG.Nest", 4, ((StringBuilder)localObject1).toString());
    }
    this.p = ((NavBarAIO)this.aZ.findViewById(2131444897));
    this.aM = ((ImageView)this.aZ.findViewById(2131444898));
    this.s = ((TextView)this.aZ.findViewById(2131436180));
    this.u = ((ImageView)this.aZ.findViewById(2131436194));
    this.A = ((ImageView)this.aZ.findViewById(2131436189));
    this.w = ((ImageView)this.aZ.findViewById(2131436666));
    this.ai = this.d.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.w, 0, 0, 0, (int)(this.ai * 50.0F + 0.5F));
    this.x = ((TextView)this.aZ.findViewById(2131448219));
    this.q = ((ViewGroup)this.aZ.findViewById(2131447534));
    localObject1 = this.q.getLayoutParams();
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      i = AIOUtils.b(64.0F, this.q.getResources());
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.s.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.u.setContentDescription(HardCodeUtil.a(2131904875));
    this.C = ((TextView)this.aZ.findViewById(2131447463));
    this.I = ((TextView)this.aZ.findViewById(2131447572));
    this.A.setVisibility(4);
    this.u.setVisibility(4);
    this.s.setText(this.f.getString(2131887625));
    b(false);
    this.bs = ((RelativeLayout)this.aZ.findViewById(2131439000));
    this.bt = ((RelativeLayout)this.aZ.findViewById(2131438998));
    this.bv = ((ImageView)this.aZ.findViewById(2131439009));
    this.bu = ((TextView)this.aZ.findViewById(2131438997));
    this.bw = ((ChatXListView)this.aZ.findViewById(2131439005));
    this.bw.setStackFromBottom(false);
    this.bw.setTranscriptMode(0);
    this.bw.setLongClickable(true);
    this.bw.setDelAnimationDuration(300L);
    this.bw.setOnScrollListener(this);
    this.bx = ((AIOAnimationConatiner)this.aZ.findViewById(2131428370));
    this.bx.a(this.bw);
    this.bj = new ScrollerRunnable(this.bw);
    localObject1 = this.f.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).getString("uin");
      String str = ((Bundle)localObject1).getString("troop_code");
      i = ((Bundle)localObject1).getInt("uintype");
      this.ah.b = ((String)localObject2);
      this.ah.a = i;
      this.ah.c = str;
    }
    MultiMsgManager.a().a(this.ah);
    localObject1 = this.d.getMessageFacade().a(this.ah.b, this.ah.a, this.bk);
    if (localObject1 != null) {
      MultiMsgManager.a().a(((MessageRecord)localObject1).issend);
    } else {
      MultiMsgManager.a().a(0);
    }
    this.bz = new View(this.f);
    this.bz.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.f.getResources().getDisplayMetrics())));
    this.bw.addFooterView(this.bz);
    this.bj = new ScrollerRunnable(this.bw);
    this.by = new ChatAdapter1(this.d, this.f, this.ah, this.bx, this);
    if (this.bi == null)
    {
      this.bi = new View(this.e);
      i = this.e.getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(this.e);
      this.bi.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.bi.setId(2131428030);
      this.bw.addHeaderView(this.bi, null, false);
      this.bw.setOverscrollHeaderTop(i);
    }
    this.bw.setAdapter(this.by);
    this.j.b().b(this.bw, this.by);
    localObject1 = LayoutInflater.from(this.d.getApp()).inflate(2131624523, null);
    this.bw.setOverScrollHeader((View)localObject1);
    ((MultiForwardScroller)this.j.d()).a((MultiForwardContext)this.i);
    this.ah.H = new ChatBackground();
    this.ah.r = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.d.getCurrentAccountUin(), this.ah.b, true, 7, this.ah.H)) {
      this.bs.setBackgroundDrawable(this.ah.H.c);
    }
    ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
    this.C.setSingleLine(false);
    this.C.setMaxLines(2);
    this.C.setTextSize(16.0F);
    this.C.setText(this.bm);
    if (!this.aL)
    {
      this.aM.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      localObject1 = this.e.getResources().getColorStateList(2131167990);
      this.C.setTextColor((ColorStateList)localObject1);
      this.s.setVisibility(0);
    }
    else
    {
      this.aM.setVisibility(0);
      if (!TextUtils.isEmpty(this.x.getText())) {
        this.x.setVisibility(0);
      } else {
        this.x.setVisibility(4);
      }
      localObject1 = this.e.getResources().getColorStateList(2131167991);
      this.C.setTextColor((ColorStateList)localObject1);
      this.s.setVisibility(8);
    }
    localObject1 = this.u;
    int i = 2130841087;
    if (this.aL) {
      i = 2130844816;
    }
    ((ImageView)localObject1).setImageResource(i);
    ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131904874));
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setOnClickListener(new MultiForwardChatPie.3(this));
    au();
    localObject1 = (AIOMessageRecordExposeDataReportHelper)q(49);
    if (localObject1 != null) {
      ((AIOMessageRecordExposeDataReportHelper)localObject1).onMoveToState(4);
    }
    this.bd = ((QQBlurView)this.aZ.findViewById(2131429596));
    BlurUtil.a(this.bd, this.aZ, 2131168025, r(2131439000));
    return true;
  }
  
  public void au()
  {
    this.d.getFileManagerNotifyCenter().addObserver(this.bK);
    this.d.addObserver(this.bJ);
    this.d.addObserver(this.bq);
    this.d.addObserver(this.br);
  }
  
  public void av()
  {
    this.d.getFileManagerNotifyCenter().deleteObserver(this.bK);
    this.d.removeObserver(this.bJ);
    this.d.removeObserver(this.bq);
    this.d.removeObserver(this.br);
  }
  
  protected void b(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleScrollOutScreen , view = ");
      String str;
      if (paramView == null) {
        str = "null";
      } else {
        str = paramView.toString();
      }
      localStringBuilder.append(str);
      QLog.i("MultiForwardActivity", 2, localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.b(paramView);
    if ((paramView instanceof TextItemBuilder.Holder))
    {
      paramView = (TextItemBuilder.Holder)paramView;
      if (paramView.w != null) {
        paramView.w.n();
      }
    }
  }
  
  public void b(List<ChatMessage> paramList)
  {
    this.bB = paramList;
  }
  
  public void bA()
  {
    Object localObject2 = MultiMsgManager.a().a(this.d, this.bk);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      b((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.bB, this.ah, this.d);
      localObject1 = ChatActivityUtils.a(this.d, BaseApplicationImpl.getContext(), this.ah, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MultiForwardActivity.onDownload, requestReceiveMultiMsg uses ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.bC);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
      }
      MultiMsgManager.a().a(this.d, this.bB, true);
      this.f.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.f.runOnUiThread(new MultiForwardChatPie.7(this));
  }
  
  public ListView bB()
  {
    return this.bw;
  }
  
  public ChatAdapter1 bC()
  {
    return this.by;
  }
  
  protected boolean bz()
  {
    Object localObject = this.bG;
    if (localObject != null)
    {
      ((Animatable)localObject).stop();
      this.bG = null;
      this.C.setCompoundDrawablePadding(this.bI);
      localObject = this.C;
      Drawable[] arrayOfDrawable = this.bH;
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected AIOContext d()
  {
    return new MultiForwardContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new MultiForwardMsgListRefresher(this.i)).a(new MultiForwardScroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a();
  }
  
  public boolean f(int paramInt)
  {
    this.aE = 8;
    this.m.removeCallbacks(this.bF);
    Runnable localRunnable = this.bn;
    if (localRunnable != null)
    {
      this.bw.removeCallbacks(localRunnable);
      this.bn = null;
    }
    return false;
  }
  
  protected void h()
  {
    this.c = "MultiForwardChatPie";
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131436180) || (i == 2131436666) || (i == 2131448219)) {
      L();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.aR < paramInt1)
    {
      b(this.aP);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 < this.aS) && (paramInt3 > 0)) {
        b(this.aQ);
      }
    }
    this.aR = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.aS = paramInt1;
    }
    this.aP = paramAbsListView.getChildAt(0);
    this.aQ = paramAbsListView.getChildAt(paramInt2 - 1);
    paramAbsListView = (AIOMessageRecordExposeDataReportHelper)q(49);
    if (paramAbsListView != null) {
      paramAbsListView.onMoveToState(20);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      t(18);
      return;
    }
    t(16);
  }
  
  public DownCallBack s(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.bk);
      }
      return new MultiForwardChatPie.LongTextDownloadCallback(this);
    }
    return new MultiForwardChatPie.MultiMsgDownloadCallback(this, this.bk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie
 * JD-Core Version:    0.7.0.1
 */