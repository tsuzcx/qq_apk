package com.tencent.mobileqq.activity.chathistory;

import agej;
import aggu;
import ahld;
import ahlp;
import ahmq;
import ahrh;
import ahri;
import ahrx;
import ahtx;
import ajbn;
import ajbp;
import ajbr;
import ajbs;
import ambx;
import amcd;
import android.app.Activity;
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
import anzj;
import bdll;
import blig;
import blih;
import blir;
import blji;
import blnt;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import zps;

public class ChatHistoryBubbleListForTroopFragment
  extends IphoneTitleBarFragment
  implements ajbp, Handler.Callback, View.OnClickListener, blig, blih, blnt
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  public ajbn a;
  public amcd a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DispatchTouchEventFrameLayout jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatXListView a;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
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
    if (paramMessageRecord == null) {}
    for (long l = 0L;; l = paramMessageRecord.shmsgseq)
    {
      a(paramActivity, paramString, l, paramInt1, paramInt2);
      return;
    }
  }
  
  private void a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("target_shmsgseq", 0L);
    if (l <= 0L) {
      return;
    }
    paramIntent = this.jdField_a_of_type_Ajbn.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.jdField_c_of_type_Long = l;
    c();
  }
  
  private void a(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen in history, view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("chatHistory.troop.msgList", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramView.toString();
            break;
            paramView = agej.a(paramView);
            if (ahrh.class.isInstance(paramView))
            {
              ((ahrh)paramView).a();
              return;
            }
            if (ahrx.class.isInstance(paramView))
            {
              ((ahrx)paramView).a();
              return;
            }
            if (ahld.class.isInstance(paramView))
            {
              ((ahld)paramView).a();
              return;
            }
            if (!(paramView instanceof ahtx)) {
              break label136;
            }
            paramView = (ahtx)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof ahmq)) {
            break label163;
          }
          paramView = (ahmq)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof ahlp));
      paramView = (ahlp)paramView;
    } while (paramView.a == null);
    label136:
    label163:
    paramView.a.d();
  }
  
  protected void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      d();
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
    localObject = (blir)blji.a((Context)localObject, null);
    ((blir)localObject).a(getResources().getString(2131695439));
    ((blir)localObject).a(2131691323, 3);
    ((blir)localObject).c(2131690580);
    ((blir)localObject).a(new ajbs(this, paramChatMessage, (blir)localObject));
    ((blir)localObject).show();
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
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.2(this), 5, null, true);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.3(this), 5, null, true);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    if (!this.jdField_a_of_type_Ajbn.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700524));
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.4(this, i), 5, null, true);
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
    setTitle(getString(2131690644));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mContentView.findViewById(2131370021));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Aggu = new aggu();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(localFragmentActivity);
    int i = zps.a(localFragmentActivity, 10.0F);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localFragmentActivity).inflate(2131558931, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167076));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Ajbn = new ajbn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFragmentActivity, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Ajbn);
    this.jdField_a_of_type_Ajbn.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Amcd = new amcd(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout = ((DispatchTouchEventFrameLayout)this.mContentView.findViewById(2131376925));
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout.setOnDispatchListener(new ajbr(this));
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_exp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Int), "", "");
      return;
      b();
    }
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Ajbn.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryBubbleListForTroopFragment.5(this, i), 5, null, true);
  }
  
  public int getContentLayoutId()
  {
    return 2131560584;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Ajbn != null) {
        this.jdField_a_of_type_Ajbn.notifyDataSetChanged();
      }
    }
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      a();
      return;
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof QQAppInterface); localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      this.jdField_c_of_type_Long = paramBundle.getLong("target_shmsgseq", 0L);
      this.jdField_b_of_type_Int = paramBundle.getInt("from", 0);
      QLog.i("chatHistory.troop.msgList", 1, "mTargetShmsgseq:" + this.jdField_c_of_type_Long);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 38: 
      if (QLog.isColorLevel()) {
        QLog.d("chatHistory.troop.msgList", 2, "resultCode == Activity.RESULT_OK, case REQUEST_JUMP_TO_POSITION");
      }
      a(paramIntent);
    }
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, getActivity());
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getActivity());
    if (this.jdField_a_of_type_Amcd != null) {
      this.jdField_a_of_type_Amcd.a(12);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Ajbn.c();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryBubbleListForTroopFragment.class);
    }
    ahri.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    super.onPause();
    this.jdField_a_of_type_Amcd.a(9);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Ajbn, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryBubbleListForTroopFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_Ajbn != null) {
      this.jdField_a_of_type_Ajbn.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Amcd.a(5);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_c_of_type_Int < paramInt1) {
      a(this.jdField_b_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.d = (paramInt1 + paramInt2 - 1);
      }
      this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_c_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 > 0) && (paramInt1 + paramInt2 - 1 < this.d)) {
        a(this.jdField_c_of_type_AndroidViewView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      this.jdField_a_of_type_Amcd.a(16);
      return;
    }
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_Amcd.a(14);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment
 * JD-Core Version:    0.7.0.1
 */