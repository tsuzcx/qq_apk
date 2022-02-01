package com.tencent.mobileqq.activity.history;

import agej;
import aggu;
import ahld;
import ahlp;
import ahmq;
import ahqw;
import ahrh;
import ahri;
import ahrx;
import ahtx;
import ajbn;
import ajbp;
import akcv;
import akcw;
import akcx;
import akkg;
import ambu;
import ambx;
import amcd;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anua;
import anzj;
import aocm;
import bdll;
import blig;
import blih;
import blir;
import blji;
import blnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import zps;

public class ChatHistoryTroopAllFragment
  extends ChatHistoryBaseFragment
  implements ajbp, Handler.Callback, View.OnClickListener, blig, blih, blnt
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  public ajbn a;
  private akkg jdField_a_of_type_Akkg;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anua jdField_a_of_type_Anua = new akcx(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
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
    this.jdField_b_of_type_JavaLangString = a();
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      QLog.e("chatHistory.troop.msgList", 1, "troop uin id required");
      r();
      return;
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof QQAppInterface); localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      QLog.i("chatHistory.troop.msgList", 1, "mTargetShmsgseq:" + this.jdField_c_of_type_Long);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
    }
    QLog.e("chatHistory.troop.msgList", 1, "app is null");
    r();
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      u();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "ChatHistoryTroopAllFragment doOnActivityResult, resultCode = " + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("chatHistory.troop.msgList", 2, "ChatHistoryTroopAllFragment, locateToPosition");
        }
      } while (paramIntent == null);
      a(paramIntent);
      return;
    } while (-1 != paramInt2);
    ForwardUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent, getActivity());
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(Intent paramIntent)
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
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "locateToPosition, mTargetShmsgseq = " + this.jdField_c_of_type_Long + " , loadTarget");
    }
    t();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle, View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      paramViewGroup = getActivity();
    } while (paramViewGroup == null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramView.findViewById(2131370021));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Aggu = new aggu();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(paramViewGroup);
    int i = zps.a(paramViewGroup, 10.0F);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup).inflate(2131558931, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167076));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Ajbn = new ajbn(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Ajbn);
    this.jdField_a_of_type_Ajbn.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      t();
    }
    for (;;)
    {
      a(paramView);
      paramViewGroup = (DispatchTouchEventLinearLayout)paramView.findViewById(2131376935);
      paramViewGroup.setOnDispatchListener(new akcv(this));
      this.e = paramView.findViewById(2131366047);
      if (!aggu.a(BaseApplicationImpl.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLayoutInflater.jdField_a_of_type_JavaLangString, true, 0, paramLayoutInflater.jdField_a_of_type_Aggu)) {
        break;
      }
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.jdField_a_of_type_Aggu.a);
      return;
      s();
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LinearLayout)paramView.findViewById(2131376935)).findViewById(2131377136));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363745).setVisibility(8);
    paramView = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366151);
    paramView.setFocusableInTouchMode(false);
    paramView.setCursorVisible(false);
    paramView.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
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
    localObject = (blir)blji.a((Context)localObject, null);
    ((blir)localObject).a(getResources().getString(2131695439));
    ((blir)localObject).a(2131691323, 3);
    ((blir)localObject).c(2131690580);
    ((blir)localObject).a(new akcw(this, paramChatMessage, (blir)localObject));
    ((blir)localObject).show();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
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
    v();
    return true;
  }
  
  protected void b() {}
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  protected void c() {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_Ajbn != null)
      {
        if (this.jdField_a_of_type_Ajbn.getCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
        }
        this.jdField_a_of_type_Ajbn.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      u();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131366151)
      {
        q();
        bdll.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131560583, paramViewGroup, false);
    a();
    a(paramLayoutInflater, paramViewGroup, paramBundle, localView);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
    V4FragmentCollector.onV4FragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getActivity());
    if (this.jdField_a_of_type_Anua != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Ajbn.c();
    super.onDestroyView();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    ahri.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    ahqw.e();
    ShortVideoRealItemBuilder.e();
    ambu localambu = ambu.a();
    if ((localambu.c()) && (localambu.a())) {
      localambu.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    ahqw.f();
    ShortVideoRealItemBuilder.f();
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Ajbn, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryTroopAllFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_Ajbn != null)
    {
      if (this.jdField_a_of_type_Ajbn.getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
      }
      this.jdField_a_of_type_Ajbn.notifyDataSetChanged();
    }
    bdll.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      b(this.jdField_c_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.jdField_c_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.d = paramAbsListView.getChildAt(paramInt2 - 1);
      return;
      if ((paramInt1 + paramInt2 - 1 > 0) && (paramInt1 + paramInt2 - 1 < this.jdField_c_of_type_Int)) {
        b(this.d);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Amcd.a(16);
      AbstractGifImage.resumeAll();
      return;
    }
    this.jdField_a_of_type_Amcd.a(14);
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
  
  void q()
  {
    aocm localaocm = (aocm)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aggu = new aggu();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_Akkg = new akkg(getActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaocm.l());
    this.jdField_a_of_type_Akkg.show();
  }
  
  protected void r()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
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
    if (!this.jdField_a_of_type_Ajbn.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700517));
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void v()
  {
    if (!this.jdField_a_of_type_Ajbn.b) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */