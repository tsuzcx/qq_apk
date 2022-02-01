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
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  ChatHistoryBubbleListAdapter jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
  private TroopAllMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ChatHistoryTroopAllFragment.7(this);
  public ChatXListView a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  View jdField_b_of_type_AndroidViewView;
  public QQAppInterface b;
  String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private View d;
  private View e;
  
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
    if ((paramView instanceof TextItemBuilder.Holder))
    {
      paramView = (TextItemBuilder.Holder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
    else if ((paramView instanceof MixedMsgItemBuilder.MixedHolder))
    {
      paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
    else if ((paramView instanceof LongMsgItemBuilder.Holder))
    {
      paramView = (LongMsgItemBuilder.Holder)paramView;
      if (paramView.a != null) {
        paramView.a.d();
      }
    }
  }
  
  protected void a()
  {
    this.jdField_b_of_type_JavaLangString = a();
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      r();
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
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mTargetShmsgseq:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      QLog.i("chatHistory.troop.msgList", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    r();
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
      ForwardUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, getBaseActivity());
    }
  }
  
  public void a(Intent paramIntent)
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("locateToPosition, mTargetShmsgseq = ");
      paramIntent.append(this.jdField_c_of_type_Long);
      paramIntent.append(" , loadTarget");
      QLog.d("chatHistory.troop.msgList", 2, paramIntent.toString());
    }
    t();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle, View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    paramViewGroup = getBaseActivity();
    if (paramViewGroup == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramView.findViewById(2131370120));
    paramLayoutInflater = new SessionInfo();
    paramBundle = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_JavaLangString = paramBundle;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = paramBundle;
    paramLayoutInflater.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(paramViewGroup);
    int i = UIUtils.a(paramViewGroup, 10.0F);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup).inflate(2131558901, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167144));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter = new ChatHistoryBubbleListAdapter(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      t();
    } else {
      s();
    }
    a(paramView);
    paramViewGroup = (DispatchTouchEventLinearLayout)paramView.findViewById(2131376818);
    paramViewGroup.setOnDispatchListener(new ChatHistoryTroopAllFragment.1(this));
    this.e = paramView.findViewById(2131366237);
    if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLayoutInflater.jdField_a_of_type_JavaLangString, true, 0, paramLayoutInflater.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LinearLayout)paramView.findViewById(2131376818)).findViewById(2131377024));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868).setVisibility(8);
    paramView = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333);
    paramView.setFocusableInTouchMode(false);
    paramView.setCursorVisible(false);
    paramView.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
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
    localObject = (ActionSheet)ActionSheetHelper.a((Context)localObject, null);
    ((ActionSheet)localObject).setMainTitle(getResources().getString(2131696093));
    ((ActionSheet)localObject).addButton(2131691479, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryTroopAllFragment.6(this, paramChatMessage, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (paramBoolean2) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 16711697)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
      if (paramMessage != null)
      {
        if (paramMessage.getCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
      }
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      u();
    }
    else if (paramView.getId() == 2131366333)
    {
      q();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131560623, paramViewGroup, false);
    a();
    a(paramLayoutInflater, paramViewGroup, paramBundle, localView);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getBaseActivity());
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localBizTroopObserver);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c();
    super.onDestroyView();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onPause()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getBaseActivity());
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (localAIOSelectableDelegateImpl.a())) {
      localAIOSelectableDelegateImpl.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getBaseActivity());
    ShortVideoItemBuilder.f();
    ShortVideoRealItemBuilder.f();
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter, null);
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryTroopAllFragment.class, (MqqHandler)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter;
    if (localObject != null)
    {
      if (((ChatHistoryBubbleListAdapter)localObject).getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.notifyDataSetChanged();
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1)
    {
      b(this.jdField_c_of_type_AndroidViewView);
    }
    else
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      if ((paramInt3 > 0) && (paramInt3 < this.jdField_c_of_type_Int)) {
        b(this.d);
      }
    }
    this.jdField_b_of_type_Int = paramInt1;
    paramInt1 = paramInt1 + paramInt2 - 1;
    if (paramInt1 >= 0) {
      this.jdField_c_of_type_Int = paramInt1;
    }
    this.jdField_c_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
    this.d = paramAbsListView.getChildAt(paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(18);
      AbstractGifImage.resumeAll();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(16);
    AbstractGifImage.pauseAll();
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0) {
      u();
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
    v();
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  void q()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog = new TroopAllMessageSearchDialog(getBaseActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRoamManager.l());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.show();
  }
  
  protected void r()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.2(this), 5, null, true);
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.3(this), 5, null, true);
  }
  
  public void u()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701818));
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void v()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.5(this, i), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */