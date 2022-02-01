package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.QQLiveImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingRelativeLayout;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class UpComingMsgChatPie
  extends BaseChatPie
{
  Comparator<MessageRecord> bi = new UpComingMsgChatPie.4(this);
  Comparator<MessageRecord> bj = new UpComingMsgChatPie.5(this);
  private Long[] bk;
  private View bl;
  private ChatAdapter1 bm;
  private List<ChatMessage> bn;
  private RelativeLayout bo;
  private boolean bp;
  private TextView bq;
  private boolean br;
  private FriendListObserver bs = new UpComingMsgChatPie.7(this);
  
  public UpComingMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    ((AIOUpComingMsgHelper)this.g.a(59)).a(this.bn);
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
    if (str.equals(paramView.getResources().getString(2131886604)))
    {
      a();
      ReportController.b(null, "dc00898", "", "", "0X800AE92", "0X800AE92", 0, 0, "", "", "", "");
    }
    else if (str.equals(paramView.getResources().getString(2131886605)))
    {
      bz();
      ReportController.b(null, "dc00898", "", "", "0X800AE93", "0X800AE93", 0, 0, "", "", "", "");
    }
    paramActionSheet.dismiss();
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (((ChatMessage)paramList.get(0)).istroop == 1)
      {
        Collections.sort(paramList, this.bi);
        return;
      }
      Collections.sort(paramList, this.bj);
    }
  }
  
  private void bA()
  {
    Object localObject1 = this.bk;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.bk;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        MessageRecord localMessageRecord = localObject2[i];
        localMessageRecord = this.d.getMessageFacade().b(this.ah.b, this.ah.a, localMessageRecord.longValue());
        if (((localMessageRecord instanceof ChatMessage)) && (UpComingMsgUtil.a(localMessageRecord))) {
          ((List)localObject1).add((ChatMessage)localMessageRecord);
        } else {
          this.bp = true;
        }
        i += 1;
      }
      b((List)localObject1);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 96;
      ((Message)localObject2).obj = localObject1;
      this.m.sendMessage((Message)localObject2);
    }
  }
  
  private void bB()
  {
    Object localObject1 = aX().getIntent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.bk = ((Long[])((Intent)localObject1).getSerializableExtra("key_uniseq"));
    }
    else
    {
      localObject2 = (Object[])((Intent)localObject1).getSerializableExtra("key_uniseq");
      this.bk = ((Long[])Arrays.copyOf((Object[])localObject2, localObject2.length, [Ljava.lang.Long.class));
    }
    Object localObject2 = this.bk;
    if ((localObject2 == null) || (localObject2.length == 0)) {
      aX().finish();
    }
    this.ah.b = ((Intent)localObject1).getStringExtra("uin");
    this.ah.a = ((Intent)localObject1).getIntExtra("uintype", -1);
    if (this.ah.a == 0) {
      this.ah.e = ContactUtils.a(this.d, this.ah.b, this.ah.c, ContactUtils.c(this.ah.a), 3);
    } else {
      this.ah.e = ((Intent)localObject1).getStringExtra("uinname");
    }
    this.ah.G = true;
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Q.aio.BaseChatPie parseIntent...sessionInfo.curFriendUin = ");
      ((StringBuilder)localObject2).append(this.ah.b);
      ((StringBuilder)localObject2).append(", sessionInfo.curType = ");
      ((StringBuilder)localObject2).append(this.ah.a);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void bz()
  {
    Object localObject = this.bn;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ChatMessage)this.bn.get(0);
      ((UpComingMsgManager)this.d.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER)).a(aX(), (ChatMessage)localObject, this.ah.e);
    }
  }
  
  private void e(View paramView)
  {
    paramView = ActionSheet.createMenuSheet(paramView.getContext());
    paramView.addButton(2131886604);
    paramView.addButton(2131886605);
    paramView.addCancelButton(2131887648);
    paramView.setOnButtonClickListener(new UpComingMsgChatPie.3(this, paramView));
    paramView.show();
  }
  
  private void s(int paramInt)
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)q(4);
    if (localChatPieSelectableHelper != null) {
      localChatPieSelectableHelper.onMoveToState(paramInt);
    }
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnDestroy...");
    }
    this.aE = 9;
    s(14);
    this.aP = null;
    this.aQ = null;
    this.aR = 0;
    this.aS = 0;
    this.bm.d();
    List localList = this.bn;
    if (localList != null) {
      localList.clear();
    }
    av();
  }
  
  public void L()
  {
    if (this.f != null) {
      this.f.finish();
    }
  }
  
  public void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnStart...");
    }
    this.aE = 3;
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnStop...");
    }
    this.aE = 6;
    s(12);
  }
  
  public void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnPause...");
    }
    BaseChatItemLayout.ad = this.br;
    QQLiveImage.pauseAll(this.f);
    AbstractGifImage.pauseAll();
    this.aE = 5;
    s(11);
  }
  
  public void S()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnResume...");
    }
    this.br = BaseChatItemLayout.ad;
    BaseChatItemLayout.ad = false;
    if (this.aC)
    {
      this.U.postDelayed(new UpComingMsgChatPie.6(this), 600L);
      this.aC = false;
    }
    else
    {
      this.bm.notifyDataSetChanged();
    }
    QQLiveImage.resumeAll(this.f);
    AbstractGifImage.resumeAll();
    this.aE = 4;
    s(7);
  }
  
  public boolean V()
  {
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)q(4);
    return (localChatPieSelectableHelper != null) && (localChatPieSelectableHelper.a());
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "Q.aio.BaseChatPie doOnCreate...");
    }
    this.bp = false;
    this.aC = true;
    bB();
    this.aL = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.aZ.findViewById(2131427887);
    ((ViewGroup)localObject1).removeView(this.aZ.findViewById(2131445137));
    Object localObject2 = this.aZ.findViewById(2131428157);
    if (localObject2 != null) {
      ((ViewGroup)localObject1).removeView((View)localObject2);
    }
    this.bo = new UpComingRelativeLayout(aX());
    this.bo.setId(2131428157);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.bo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ViewGroup)localObject1).addView(this.bo, 0);
    this.U = new ChatXListView(aX());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.U.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.bo.addView(this.U);
    this.bl = new View(this.f);
    this.bl.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.f.getResources().getDisplayMetrics())));
    this.U.addFooterView(this.bl);
    this.U.setStackFromBottom(false);
    this.U.setTranscriptMode(0);
    this.U.setLongClickable(true);
    this.U.setDelAnimationDuration(300L);
    this.U.setDivider(null);
    this.U.setVerticalScrollBarEnabled(false);
    this.bq = new TextView(aX());
    this.bq.setText(aX().getResources().getString(2131886607));
    this.bq.setTextSize(2, 16.0F);
    this.bq.setTextColor(-7829368);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    this.bo.addView(this.bq, (ViewGroup.LayoutParams)localObject1);
    this.bq.setVisibility(8);
    this.p = ((NavBarAIO)this.aZ.findViewById(2131444897));
    this.aM = ((ImageView)this.aZ.findViewById(2131444898));
    this.s = ((TextView)this.aZ.findViewById(2131436180));
    this.u = ((ImageView)this.aZ.findViewById(2131436194));
    this.A = ((ImageView)this.aZ.findViewById(2131436189));
    this.w = ((ImageView)this.aZ.findViewById(2131436666));
    this.C = ((TextView)this.aZ.findViewById(2131447463));
    this.I = ((TextView)this.aZ.findViewById(2131447572));
    this.I.setVisibility(8);
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
    this.aU = new AIOAnimationConatiner(aX());
    this.aU.a(this.U);
    this.bm = new ChatAdapter1(this.d, this.f, this.ah, this.aU, this);
    this.bm.g = Boolean.valueOf(false);
    if (this.bc == null)
    {
      this.bc = new View(this.e);
      i = this.e.getResources().getDimensionPixelSize(2131299920);
      this.bc.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.bc.setId(2131428030);
      this.U.addHeaderView(this.bc, null, false);
      this.U.setOverscrollHeaderTop(i);
    }
    this.U.setAdapter(this.bm);
    this.ah.H = new ChatBackground();
    this.ah.r = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.d.getCurrentAccountUin(), this.ah.b, true, 7, this.ah.H)) {
      this.bo.setBackgroundDrawable(this.ah.H.c);
    }
    this.A.setVisibility(4);
    this.u.setVisibility(4);
    this.s.setText(this.f.getString(2131887625));
    b(false);
    this.C.setSingleLine(false);
    this.C.setMaxLines(2);
    this.C.setTextSize(16.0F);
    this.C.setText(aX().getResources().getString(2131886602));
    if (!this.aL)
    {
      this.p.setBackgroundResource(2130852228);
      this.aM.setVisibility(8);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      localObject1 = this.e.getResources().getColorStateList(2131167990);
      this.C.setTextColor((ColorStateList)localObject1);
      this.s.setVisibility(0);
    }
    else
    {
      this.p.setBackgroundResource(2130852229);
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
    ThreadManager.post(new UpComingMsgChatPie.1(this), 8, null, true);
    localObject1 = this.u;
    int i = 2130841087;
    if (this.aL) {
      i = 2130844816;
    }
    ((ImageView)localObject1).setImageResource(i);
    ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131904874));
    ((ImageView)localObject1).setOnClickListener(new UpComingMsgChatPie.2(this));
    au();
    return true;
  }
  
  protected void au()
  {
    if (this.d == null) {
      return;
    }
    this.d.addObserver(this.bs);
  }
  
  protected void av()
  {
    if (this.d == null) {
      return;
    }
    this.d.removeObserver(this.bs);
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
      QLog.i("Q.aio.BaseChatPie", 2, localStringBuilder.toString());
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
  
  public boolean f(int paramInt)
  {
    this.aE = 8;
    return false;
  }
  
  protected void h()
  {
    this.c = "UpComingMsgLogic.UpComingMsgChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 96) && ((paramMessage.obj instanceof List)))
    {
      Object localObject = (List)paramMessage.obj;
      this.bn = ((List)localObject);
      if (this.bn.size() <= 0)
      {
        this.U.setVisibility(8);
        this.bq.setVisibility(0);
        this.u.setVisibility(8);
        ReportController.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 1, 0, "", "", "", "");
      }
      else
      {
        if (this.bp)
        {
          QQToast.makeText(aX(), 0, 2131886608, 3000).show();
          ReportController.b(null, "dc00898", "", "", "0X800AE95", "0X800AE95", 2, 0, "", "", "", "");
        }
        this.u.setVisibility(0);
        this.bm.a((List)localObject, null);
      }
      if (QLog.isColorLevel())
      {
        localObject = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Q.aio.BaseChatPie upComing. dataList.size = ");
        localStringBuilder.append(this.bn.size());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    return super.handleMessage(paramMessage);
  }
  
  public void l(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE91", "0X800AE91", 0, 0, "", "", "", "");
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
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      s(18);
      return;
    }
    s(16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie
 * JD-Core Version:    0.7.0.1
 */