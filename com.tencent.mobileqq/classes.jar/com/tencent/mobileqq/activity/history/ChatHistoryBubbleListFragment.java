package com.tencent.mobileqq.activity.history;

import aeqq;
import agai;
import agat;
import ahdr;
import ahdt;
import ahyp;
import alud;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bhtu;
import bhtv;
import bhuf;
import bhus;
import bhzf;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import xsm;

public class ChatHistoryBubbleListFragment
  extends IphoneTitleBarFragment
  implements ahdt, Handler.Callback, View.OnClickListener, bhtu, bhtv, bhzf
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 9223372036854775807L;
  public ahdr a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  
  private void a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l <= 0L) {
      return;
    }
    paramIntent = this.jdField_a_of_type_Ahdr.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.jdField_c_of_type_Long = l;
    c();
  }
  
  protected void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "deleteMessage uniseq=" + paramChatMessage.uniseq + ",id=" + paramChatMessage.getId());
    }
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = (bhuf)bhus.a((Context)localObject, null);
    ((bhuf)localObject).a(getResources().getString(2131696570));
    ((bhuf)localObject).a(2131691562, 3);
    ((bhuf)localObject).c(2131690648);
    ((bhuf)localObject).a(new ahyp(this, paramChatMessage, (bhuf)localObject));
    ((bhuf)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean2) {
        break label61;
      }
    }
    label61:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
      break;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    e();
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryBubbleListFragment.1(this), 5, null, true);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryBubbleListFragment.2(this), 5, null, true);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    if (!this.jdField_a_of_type_Ahdr.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131702020));
    int i = this.jdField_b_of_type_Int + 1;
    this.jdField_b_of_type_Int = i;
    ThreadManager.post(new ChatHistoryBubbleListFragment.3(this, i), 5, null, true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while (localFragmentActivity == null);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131690766));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mContentView.findViewById(2131369528));
    paramLayoutInflater = new SessionInfo();
    if (this.jdField_a_of_type_Int == 1)
    {
      paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramLayoutInflater.jdField_a_of_type_Int = 1;
      paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      paramLayoutInflater.jdField_a_of_type_Aeqq = new aeqq();
      paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(localFragmentActivity);
      int i = xsm.a(localFragmentActivity, 10.0F);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localFragmentActivity).inflate(2131558860, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, i);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localFragmentActivity);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166983));
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
      this.jdField_a_of_type_Ahdr = new ahdr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFragmentActivity, paramLayoutInflater);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Ahdr);
      this.jdField_a_of_type_Ahdr.a(this);
      if (this.jdField_c_of_type_Long <= 0L) {
        break;
      }
      c();
      return;
      paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramLayoutInflater.jdField_a_of_type_Int = 0;
    }
    b();
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Ahdr.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.jdField_b_of_type_Int + 1;
    this.jdField_b_of_type_Int = i;
    ThreadManager.post(new ChatHistoryBubbleListFragment.4(this, i), 5, null, true);
  }
  
  public int getContentLayoutId()
  {
    return 2131560414;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Ahdr != null) {
        this.jdField_a_of_type_Ahdr.notifyDataSetChanged();
      }
    }
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
      if (this.jdField_b_of_type_JavaLangString == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
        a();
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        QLog.e("chatHistory.troop.msgList", 1, "friend uin id required");
        a();
        return;
      }
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof QQAppInterface); localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      this.jdField_c_of_type_Long = paramBundle.getLong("target_shmsgseq", 0L);
      this.jdField_c_of_type_Int = paramBundle.getInt("from", 0);
      QLog.i("chatHistory.troop.msgList", 1, "mTargetShmsgseq:" + this.jdField_c_of_type_Long);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      d();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getActivity());
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Ahdr.c();
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryBubbleListFragment.class);
    }
    agat.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    agai.e();
    ShortVideoRealItemBuilder.e();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    agai.f();
    ShortVideoRealItemBuilder.f();
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Ahdr, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryBubbleListFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_Ahdr != null) {
      this.jdField_a_of_type_Ahdr.notifyDataSetChanged();
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
  
  public void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground(getActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    QQLiveImage.onBackground(getActivity());
  }
  
  public void y(int paramInt)
  {
    if (paramInt < 0) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBubbleListFragment
 * JD-Core Version:    0.7.0.1
 */