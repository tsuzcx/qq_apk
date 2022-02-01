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
import android.support.v4.app.FragmentActivity;
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
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ChatHistoryBubbleListAdapter jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
  DispatchTouchEventFrameLayout jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout;
  protected CommonSelectableHelper a;
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
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a();
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
    label119:
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
            paramView = AIOUtils.a(paramView);
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
            if (!(paramView instanceof TextItemBuilder.Holder)) {
              break label119;
            }
            paramView = (TextItemBuilder.Holder)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof MixedMsgItemBuilder.MixedHolder)) {
            break label146;
          }
          paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof LongMsgItemBuilder.Holder));
      paramView = (LongMsgItemBuilder.Holder)paramView;
    } while (paramView.a == null);
    label146:
    paramView.a.d();
  }
  
  protected void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "deleteMessage uniseq=" + paramChatMessage.uniseq + ",id=" + paramChatMessage.getId());
    }
    Object localObject = getActivity();
    if (localObject == null) {
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.a((Context)localObject, null);
    ((ActionSheet)localObject).setMainTitle(getResources().getString(2131696078));
    ((ActionSheet)localObject).addButton(2131691558, 3);
    ((ActionSheet)localObject).addCancelButton(2131690800);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryBubbleListForTroopFragment.6(this, paramChatMessage, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701685));
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
    setTitle(getString(2131690865));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.mContentView.findViewById(2131370461));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(localFragmentActivity);
    int i = UIUtils.a(localFragmentActivity, 10.0F);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(localFragmentActivity).inflate(2131559007, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167119));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter = new ChatHistoryBubbleListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFragmentActivity, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper = new CommonSelectableHelper(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout = ((DispatchTouchEventFrameLayout)this.mContentView.findViewById(2131377356));
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetDispatchTouchEventFrameLayout.setOnDispatchListener(new ChatHistoryBubbleListForTroopFragment.1(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_exp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Int), "", "");
      return;
      b();
    }
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b) {
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
    return 2131560736;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(13);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c();
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
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryBubbleListForTroopFragment.class);
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(10);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryBubbleListForTroopFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(6);
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(17);
      return;
    }
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(15);
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
    QQLiveImage.onForeground(getActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    QQLiveImage.onBackground(getActivity());
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    e();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment
 * JD-Core Version:    0.7.0.1
 */