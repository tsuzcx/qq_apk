package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter.HistoryDeleteOperator;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventLinearLayout;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.CommonSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryTroopAllFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, ChatHistoryBubbleListAdapter.HistoryDeleteOperator, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  TextView A;
  int B = 0;
  MqqHandler C;
  RelativeLayout D;
  private int E;
  private View F;
  private View G;
  private int H;
  private SessionInfo I;
  private TroopAllMessageSearchDialog J;
  private View K;
  private BizTroopObserver L = new ChatHistoryTroopAllFragment.7(this);
  String s;
  public ChatXListView t;
  ChatHistoryBubbleListAdapter u;
  public QQAppInterface v;
  long w = 9223372036854775807L;
  long x = 0L;
  long y;
  View z;
  
  private void b(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleScrollOutScreen in history, view = ");
      String str;
      if (paramView == null) {
        str = "null";
      } else {
        str = paramView.toString();
      }
      localStringBuilder.append(str);
      QLog.i("chatHistory.troop.msgList", 2, localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    paramView = AIOUtils.b(paramView);
    if (ShortVideoItemBuilder.Holder.class.isInstance(paramView))
    {
      ((ShortVideoItemBuilder.Holder)paramView).a();
      return;
    }
    if (ShortVideoRealItemBuilder.Holder.class.isInstance(paramView))
    {
      ((ShortVideoRealItemBuilder.Holder)paramView).a();
      return;
    }
    if ((paramView instanceof TextItemBuilder.Holder))
    {
      paramView = (TextItemBuilder.Holder)paramView;
      if (paramView.w != null) {
        paramView.w.n();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (paramView.a != null) {
        paramView.a.n();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      paramView = (LongMsgItemBuilder.Holder)paramView;
      if (paramView.f != null) {
        paramView.f.n();
      }
    }
  }
  
  protected void a()
  {
    this.s = g();
    if (this.s == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      v();
      return;
    }
    Object localObject = getBaseActivity();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((BaseActivity)localObject).getAppInterface();
    }
    if ((localObject instanceof QQAppInterface))
    {
      this.v = ((QQAppInterface)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mTargetShmsgseq:");
      ((StringBuilder)localObject).append(this.y);
      QLog.i("chatHistory.troop.msgList", 1, ((StringBuilder)localObject).toString());
      this.C = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    v();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChatHistoryTroopAllFragment doOnActivityResult, resultCode = ");
      localStringBuilder.append(paramInt1);
      QLog.d("chatHistory.troop.msgList", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 21)
    {
      if (paramInt1 != 38) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "ChatHistoryTroopAllFragment, locateToPosition");
      }
      if (paramIntent != null) {
        a(paramIntent);
      }
    }
    else if (-1 == paramInt2)
    {
      ForwardUtils.a(this.v, paramIntent, getBaseActivity());
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l <= 0L) {
      return;
    }
    paramIntent = this.u.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.y = l;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("locateToPosition, mTargetShmsgseq = ");
      paramIntent.append(this.y);
      paramIntent.append(" , loadTarget");
      QLog.d("chatHistory.troop.msgList", 2, paramIntent.toString());
    }
    x();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle, View paramView)
  {
    if (this.v == null) {
      return;
    }
    paramViewGroup = getBaseActivity();
    if (paramViewGroup == null) {
      return;
    }
    this.t = ((ChatXListView)paramView.findViewById(2131437282));
    paramLayoutInflater = new SessionInfo();
    paramBundle = this.s;
    paramLayoutInflater.b = paramBundle;
    paramLayoutInflater.a = 1;
    paramLayoutInflater.c = paramBundle;
    paramLayoutInflater.H = new ChatBackground();
    paramLayoutInflater.r = ChatTextSizeSettingActivity.a(paramViewGroup);
    int i = UIUtils.a(paramViewGroup, 10.0F);
    this.z = LayoutInflater.from(paramViewGroup).inflate(2131624523, this.t, false);
    this.z.setPadding(0, 0, 0, i);
    this.A = new TextView(paramViewGroup);
    this.A.setTextSize(16.0F);
    this.A.setTextColor(getResources().getColorStateList(2131168125));
    this.A.setGravity(1);
    this.A.setPadding(0, i, 0, i);
    this.A.setVisibility(8);
    this.A.setOnClickListener(this);
    this.t.addFooterView(this.A);
    this.t.setOnScrollToButtomListener(this);
    this.t.setOnScrollListener(this);
    this.u = new ChatHistoryBubbleListAdapter(this.v, paramViewGroup, paramLayoutInflater);
    this.t.setAdapter(this.u);
    this.u.a(this);
    if (this.y > 0L) {
      x();
    } else {
      w();
    }
    a(paramView);
    paramViewGroup = (DispatchTouchEventLinearLayout)paramView.findViewById(2131445148);
    paramViewGroup.setOnDispatchListener(new ChatHistoryTroopAllFragment.1(this));
    this.K = paramView.findViewById(2131432529);
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.v.getCurrentAccountUin(), paramLayoutInflater.b, true, 0, paramLayoutInflater.H)) {
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.H.c);
    }
  }
  
  void a(View paramView)
  {
    this.D = ((RelativeLayout)((LinearLayout)paramView.findViewById(2131445148)).findViewById(2131445390));
    this.D.findViewById(2131429816).setVisibility(8);
    paramView = (EditText)this.D.findViewById(2131432634);
    paramView.setFocusableInTouchMode(false);
    paramView.setCursorVisible(false);
    paramView.setOnClickListener(this);
    if ((this.D != null) && (Build.VERSION.SDK_INT > 10)) {
      this.D.setLayerType(0, null);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteMessage uniseq=");
      ((StringBuilder)localObject).append(paramChatMessage.uniseq);
      ((StringBuilder)localObject).append(",id=");
      ((StringBuilder)localObject).append(paramChatMessage.getId());
      QLog.d("chatHistory.troop.msgList", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getBaseActivity();
    if (localObject == null) {
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.b((Context)localObject, null);
    ((ActionSheet)localObject).setMainTitle(getResources().getString(2131893858));
    ((ActionSheet)localObject).addButton(2131888438, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryTroopAllFragment.6(this, paramChatMessage, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.t.setOverScrollHeader(this.z);
      this.t.setOverScrollListener(this);
    }
    else
    {
      this.t.setOverScrollHeader(null);
      this.t.setOverScrollListener(null);
    }
    TextView localTextView = this.A;
    int i;
    if (paramBoolean2) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  void b()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.v.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.I = new SessionInfo();
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.I.b = localBundle.getString("uin");
    this.I.a = localBundle.getInt("uintype");
    this.I.c = localBundle.getString("troop_uin");
    this.I.H = new ChatBackground();
    this.I.r = ChatTextSizeSettingActivity.a(getBaseActivity());
    this.J = new TroopAllMessageSearchDialog(getBaseActivity(), this.v, this.I, localMessageRoamManager.I());
    this.J.show();
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      paramMessage = this.u;
      if (paramMessage != null)
      {
        if (paramMessage.getCount() == 0) {
          this.t.setEmptyView(this.K);
        }
        this.u.notifyDataSetChanged();
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.A)
    {
      y();
    }
    else if (paramView.getId() == 2131432634)
    {
      b();
      ReportController.b(this.v, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131626668, paramViewGroup, false);
    a();
    a(paramLayoutInflater, paramViewGroup, paramBundle, localView);
    this.v.addObserver(this.L);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getBaseActivity());
    BizTroopObserver localBizTroopObserver = this.L;
    if (localBizTroopObserver != null) {
      this.v.removeObserver(localBizTroopObserver);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.v.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.t);
    this.u.d();
    super.onDestroyView();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    if (this.C != null) {
      this.v.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    ShortVideoPTVItemBuilder.a(this.t);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.l()) && (localAIOSelectableDelegateImpl.i())) {
      localAIOSelectableDelegateImpl.n();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getBaseActivity());
    ShortVideoItemBuilder.i();
    ShortVideoRealItemBuilder.i();
    ((MediaPlayerManager)this.v.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.t, this.u, null);
    Object localObject = this.C;
    if (localObject != null) {
      this.v.setHandler(ChatHistoryTroopAllFragment.class, (MqqHandler)localObject);
    }
    localObject = this.u;
    if (localObject != null)
    {
      if (((ChatHistoryBubbleListAdapter)localObject).getCount() == 0) {
        this.t.setEmptyView(this.K);
      }
      this.u.notifyDataSetChanged();
    }
    ReportController.b(this.v, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.E < paramInt1)
    {
      b(this.F);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 > 0) && (paramInt3 < this.H)) {
        b(this.G);
      }
    }
    this.E = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.H = paramInt1;
    }
    this.F = paramAbsListView.getChildAt(0);
    this.G = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.m.onMoveToState(18);
      AbstractGifImage.resumeAll();
      return;
    }
    this.m.onMoveToState(16);
    AbstractGifImage.pauseAll();
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0) {
      y();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground(getBaseActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    QQLiveImage.onBackground(getBaseActivity());
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    z();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  protected void v()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.2(this), 5, null, true);
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.3(this), 5, null, true);
  }
  
  public void y()
  {
    if (!this.u.t) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.A.setText(HardCodeUtil.a(2131899836));
    int i = this.B + 1;
    this.B = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void z()
  {
    if (!this.u.s) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.B + 1;
    this.B = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.5(this, i), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */