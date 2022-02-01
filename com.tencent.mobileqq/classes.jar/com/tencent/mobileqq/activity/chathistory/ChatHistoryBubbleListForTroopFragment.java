package com.tencent.mobileqq.activity.chathistory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventFrameLayout;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.CommonSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryBubbleListForTroopFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, ChatHistoryBubbleListAdapter.HistoryDeleteOperator, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  String a;
  public ChatXListView b;
  ChatHistoryBubbleListAdapter c;
  QQAppInterface d;
  long e = 9223372036854775807L;
  long f = 0L;
  long g;
  View h;
  TextView i;
  int j = 0;
  int k;
  MqqHandler l;
  DispatchTouchEventFrameLayout m;
  protected CommonSelectableHelper n;
  private int o;
  private View p;
  private View q;
  private int r;
  
  public static void a(Activity paramActivity, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("target_shmsgseq", paramLong);
    localIntent.putExtra("from", paramInt2);
    PublicFragmentActivity.a(paramActivity, localIntent, ChatHistoryBubbleListForTroopFragment.class, paramInt1);
  }
  
  public static void a(Activity paramActivity, String paramString, @Nullable MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    long l1;
    if (paramMessageRecord == null) {
      l1 = 0L;
    } else {
      l1 = paramMessageRecord.shmsgseq;
    }
    a(paramActivity, paramString, l1, paramInt1, paramInt2);
  }
  
  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l1 <= 0L) {
      return;
    }
    paramIntent = this.c.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.g = l1;
    c();
  }
  
  private void a(View paramView)
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
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
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
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryBubbleListForTroopFragment.6(this, paramChatMessage, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.b.setOverScrollHeader(this.h);
      this.b.setOverScrollListener(this);
    }
    else
    {
      this.b.setOverScrollHeader(null);
      this.b.setOverScrollListener(null);
    }
    TextView localTextView = this.i;
    int i1;
    if (paramBoolean2) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.2(this), 5, null, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.3(this), 5, null, true);
  }
  
  public void d()
  {
    if (!this.c.t) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.i.setText(HardCodeUtil.a(2131899843));
    int i1 = this.j + 1;
    this.j = i1;
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.4(this, i1), 5, null, true);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.d == null) {
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131887723));
    this.b = ((ChatXListView)this.mContentView.findViewById(2131437282));
    paramLayoutInflater = new SessionInfo();
    paramViewGroup = this.a;
    paramLayoutInflater.b = paramViewGroup;
    paramLayoutInflater.a = 1;
    paramLayoutInflater.c = paramViewGroup;
    paramLayoutInflater.H = new ChatBackground();
    try
    {
      paramLayoutInflater.H.b = localBaseActivity.getResources().getColorStateList(2131168022);
    }
    catch (RuntimeException paramViewGroup)
    {
      label115:
      int i1;
      break label115;
    }
    QLog.d("chatHistory.troop.msgList", 2, "getChatBackground error");
    paramLayoutInflater.r = ChatTextSizeSettingActivity.a(localBaseActivity);
    i1 = UIUtils.a(localBaseActivity, 10.0F);
    this.h = LayoutInflater.from(localBaseActivity).inflate(2131624523, this.b, false);
    this.h.setPadding(0, 0, 0, i1);
    this.i = new TextView(localBaseActivity);
    this.i.setTextSize(16.0F);
    this.i.setTextColor(getResources().getColorStateList(2131168125));
    this.i.setGravity(1);
    this.i.setPadding(0, i1, 0, i1);
    this.i.setVisibility(8);
    this.i.setOnClickListener(this);
    this.b.addFooterView(this.i);
    this.b.setOnScrollToButtomListener(this);
    this.b.setOnScrollListener(this);
    this.c = new ChatHistoryBubbleListAdapter(this.d, localBaseActivity, paramLayoutInflater);
    this.b.setAdapter(this.c);
    this.c.a(this);
    if (this.g > 0L) {
      c();
    } else {
      b();
    }
    this.n = new CommonSelectableHelper(this);
    this.m = ((DispatchTouchEventFrameLayout)this.mContentView.findViewById(2131445137));
    this.m.setOnDispatchListener(new ChatHistoryBubbleListForTroopFragment.1(this));
    ReportController.b(this.d, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_exp", 0, 0, this.a, String.valueOf(this.k), "", "");
  }
  
  public void e()
  {
    if (!this.c.s) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i1 = this.j + 1;
    this.j = i1;
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.5(this, i1), 5, null, true);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626669;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      paramMessage = this.c;
      if (paramMessage != null) {
        paramMessage.notifyDataSetChanged();
      }
    }
    return true;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.a = paramBundle.getString("troop_uin");
    if (this.a == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      a();
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
      this.d = ((QQAppInterface)localObject);
      this.g = paramBundle.getLong("target_shmsgseq", 0L);
      this.k = paramBundle.getInt("from", 0);
      paramBundle = new StringBuilder();
      paramBundle.append("mTargetShmsgseq:");
      paramBundle.append(this.g);
      QLog.i("chatHistory.troop.msgList", 1, paramBundle.toString());
      this.l = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21)
      {
        if (paramInt1 != 38) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("chatHistory.troop.msgList", 2, "resultCode == Activity.RESULT_OK, case REQUEST_JUMP_TO_POSITION");
        }
        a(paramIntent);
      }
      ForwardUtils.a(this.d, paramIntent, getBaseActivity());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.i) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getBaseActivity());
    CommonSelectableHelper localCommonSelectableHelper = this.n;
    if (localCommonSelectableHelper != null) {
      localCommonSelectableHelper.onMoveToState(14);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.d.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.b);
    this.c.d();
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    if (this.l != null) {
      this.d.removeHandler(ChatHistoryBubbleListForTroopFragment.class);
    }
    ShortVideoPTVItemBuilder.a(this.b);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    super.onPause();
    this.n.onMoveToState(11);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getBaseActivity());
    ((MediaPlayerManager)this.d.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.b, this.c, null);
    Object localObject = this.l;
    if (localObject != null) {
      this.d.setHandler(ChatHistoryBubbleListForTroopFragment.class, (MqqHandler)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ChatHistoryBubbleListAdapter)localObject).notifyDataSetChanged();
    }
    this.n.onMoveToState(7);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.o < paramInt1)
    {
      a(this.p);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 > 0) && (paramInt3 < this.r)) {
        a(this.q);
      }
    }
    this.o = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.r = paramInt1;
    }
    this.p = paramAbsListView.getChildAt(0);
    this.q = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      this.n.onMoveToState(18);
      return;
    }
    AbstractGifImage.pauseAll();
    this.n.onMoveToState(16);
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0) {
      d();
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
    e();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment
 * JD-Core Version:    0.7.0.1
 */