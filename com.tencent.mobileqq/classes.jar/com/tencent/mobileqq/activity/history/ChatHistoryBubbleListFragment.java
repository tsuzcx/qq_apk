package com.tencent.mobileqq.activity.history;

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
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter.HistoryDeleteOperator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
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

public class ChatHistoryBubbleListFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, ChatHistoryBubbleListAdapter.HistoryDeleteOperator, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  int a;
  String b;
  String c;
  ChatXListView d;
  ChatHistoryBubbleListAdapter e;
  QQAppInterface f;
  long g = 9223372036854775807L;
  long h = 0L;
  long i;
  View j;
  TextView k;
  int l = 0;
  int m;
  MqqHandler n;
  
  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l1 <= 0L) {
      return;
    }
    paramIntent = this.e.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.i = l1;
    c();
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
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryBubbleListFragment.5(this, paramChatMessage, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.d.setOverScrollHeader(this.j);
      this.d.setOverScrollListener(this);
    }
    else
    {
      this.d.setOverScrollHeader(null);
      this.d.setOverScrollListener(null);
    }
    TextView localTextView = this.k;
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
    ThreadManager.post(new ChatHistoryBubbleListFragment.1(this), 5, null, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryBubbleListFragment.2(this), 5, null, true);
  }
  
  public void d()
  {
    if (!this.e.t) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.k.setText(HardCodeUtil.a(2131899865));
    int i1 = this.l + 1;
    this.l = i1;
    ThreadManager.post(new ChatHistoryBubbleListFragment.3(this, i1), 5, null, true);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.f == null) {
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131887723));
    this.d = ((ChatXListView)this.mContentView.findViewById(2131437282));
    paramLayoutInflater = new SessionInfo();
    if (this.a == 1)
    {
      paramViewGroup = this.c;
      paramLayoutInflater.b = paramViewGroup;
      paramLayoutInflater.a = 1;
      paramLayoutInflater.c = paramViewGroup;
    }
    else
    {
      paramLayoutInflater.b = this.b;
      paramLayoutInflater.a = 0;
    }
    paramLayoutInflater.H = new ChatBackground();
    paramLayoutInflater.r = ChatTextSizeSettingActivity.a(localBaseActivity);
    int i1 = UIUtils.a(localBaseActivity, 10.0F);
    this.j = LayoutInflater.from(localBaseActivity).inflate(2131624523, this.d, false);
    this.j.setPadding(0, 0, 0, i1);
    this.k = new TextView(localBaseActivity);
    this.k.setTextSize(16.0F);
    this.k.setTextColor(getResources().getColorStateList(2131168125));
    this.k.setGravity(1);
    this.k.setPadding(0, i1, 0, i1);
    this.k.setVisibility(8);
    this.k.setOnClickListener(this);
    this.d.addFooterView(this.k);
    this.d.setOnScrollToButtomListener(this);
    this.d.setOnScrollListener(this);
    this.e = new ChatHistoryBubbleListAdapter(this.f, localBaseActivity, paramLayoutInflater);
    this.d.setAdapter(this.e);
    this.e.a(this);
    if (this.i > 0L)
    {
      c();
      return;
    }
    b();
  }
  
  public void e()
  {
    if (!this.e.s) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i1 = this.l + 1;
    this.l = i1;
    ThreadManager.post(new ChatHistoryBubbleListFragment.4(this, i1), 5, null, true);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626669;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      paramMessage = this.e;
      if (paramMessage != null) {
        paramMessage.notifyDataSetChanged();
      }
    }
    return true;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.a = paramBundle.getInt("uintype");
    if (this.a == 1)
    {
      this.c = paramBundle.getString("troop_uin");
      if (this.c == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
        a();
      }
    }
    else
    {
      this.b = paramBundle.getString("uin");
      if (this.b == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "friend uin id required");
        a();
        return;
      }
    }
    Object localObject = getBaseActivity();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((BaseActivity)localObject).getAppInterface();
    }
    if ((localObject instanceof QQAppInterface))
    {
      this.f = ((QQAppInterface)localObject);
      this.i = paramBundle.getLong("target_shmsgseq", 0L);
      this.m = paramBundle.getInt("from", 0);
      paramBundle = new StringBuilder();
      paramBundle.append("mTargetShmsgseq:");
      paramBundle.append(this.i);
      QLog.i("chatHistory.troop.msgList", 1, paramBundle.toString());
      this.n = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.k) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getBaseActivity());
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.f.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.d);
    this.e.d();
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
    if (this.n != null) {
      this.f.removeHandler(ChatHistoryBubbleListFragment.class);
    }
    ShortVideoPTVItemBuilder.a(this.d);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
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
    ((MediaPlayerManager)this.f.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.d, this.e, null);
    Object localObject = this.n;
    if (localObject != null) {
      this.f.setHandler(ChatHistoryBubbleListFragment.class, (MqqHandler)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      ((ChatHistoryBubbleListAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    AbstractGifImage.pauseAll();
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
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment
 * JD-Core Version:    0.7.0.1
 */