package com.tencent.mobileqq.activity.history;

import aekt;
import aemb;
import afpw;
import afqn;
import afrp;
import afvt;
import afwd;
import afwe;
import afwt;
import afys;
import agzc;
import agze;
import ahwj;
import ahwk;
import ahwl;
import aidp;
import ajsx;
import ajta;
import ajtg;
import alkl;
import alpo;
import alsl;
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
import azmj;
import bhpn;
import bhpo;
import bhpy;
import bhql;
import bhuy;
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
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import xod;

public class ChatHistoryTroopAllFragment
  extends ChatHistoryBaseFragment
  implements agze, Handler.Callback, View.OnClickListener, bhpn, bhpo, bhuy
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  public agzc a;
  private aidp jdField_a_of_type_Aidp;
  private alkl jdField_a_of_type_Alkl = new ahwl(this);
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
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
            paramView = aekt.a(paramView);
            if (afwd.class.isInstance(paramView))
            {
              ((afwd)paramView).a();
              return;
            }
            if (afwt.class.isInstance(paramView))
            {
              ((afwt)paramView).a();
              return;
            }
            if (afpw.class.isInstance(paramView))
            {
              ((afpw)paramView).a();
              return;
            }
            if (!(paramView instanceof afys)) {
              break label136;
            }
            paramView = (afys)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof afrp)) {
            break label163;
          }
          paramView = (afrp)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof afqn));
      paramView = (afqn)paramView;
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
      q();
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
    q();
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
    paramIntent = this.jdField_a_of_type_Agzc.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.jdField_c_of_type_Long = l;
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "locateToPosition, mTargetShmsgseq = " + this.jdField_c_of_type_Long + " , loadTarget");
    }
    s();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle, View paramView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      paramViewGroup = getActivity();
    } while (paramViewGroup == null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramView.findViewById(2131369510));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Aemb = new aemb();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(paramViewGroup);
    int i = xod.a(paramViewGroup, 10.0F);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup).inflate(2131558861, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166981));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Agzc = new agzc(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Agzc);
    this.jdField_a_of_type_Agzc.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      s();
    }
    for (;;)
    {
      a(paramView);
      paramViewGroup = (DispatchTouchEventLinearLayout)paramView.findViewById(2131375991);
      paramViewGroup.setOnDispatchListener(new ahwj(this));
      this.e = paramView.findViewById(2131365758);
      if (!aemb.a(BaseApplicationImpl.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLayoutInflater.jdField_a_of_type_JavaLangString, true, 0, paramLayoutInflater.jdField_a_of_type_Aemb)) {
        break;
      }
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.jdField_a_of_type_Aemb.a);
      return;
      r();
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LinearLayout)paramView.findViewById(2131375991)).findViewById(2131376171));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363520).setVisibility(8);
    paramView = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365849);
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
    localObject = (bhpy)bhql.a((Context)localObject, null);
    ((bhpy)localObject).a(getResources().getString(2131696568));
    ((bhpy)localObject).a(2131691561, 3);
    ((bhpy)localObject).c(2131690648);
    ((bhpy)localObject).a(new ahwk(this, paramChatMessage, (bhpy)localObject));
    ((bhpy)localObject).show();
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
    u();
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
      if (this.jdField_a_of_type_Agzc != null)
      {
        if (this.jdField_a_of_type_Agzc.getCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
        }
        this.jdField_a_of_type_Agzc.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      t();
    }
    while (paramView.getId() != 2131365849) {
      return;
    }
    p();
    azmj.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2131560414, paramViewGroup, false);
    a();
    a(paramLayoutInflater, paramViewGroup, paramBundle, localView);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getActivity());
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Agzc.c();
    super.onDestroyView();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    afwe.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    afvt.e();
    ShortVideoRealItemBuilder.e();
    ajsx localajsx = ajsx.a();
    if ((localajsx.c()) && (localajsx.a())) {
      localajsx.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    afvt.f();
    ShortVideoRealItemBuilder.f();
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Agzc, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryTroopAllFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_Agzc != null)
    {
      if (this.jdField_a_of_type_Agzc.getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
      }
      this.jdField_a_of_type_Agzc.notifyDataSetChanged();
    }
    azmj.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
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
      this.jdField_a_of_type_Ajtg.a(14);
      AbstractGifImage.resumeAll();
      return;
    }
    this.jdField_a_of_type_Ajtg.a(12);
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
  
  void p()
  {
    alsl localalsl = (alsl)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb = new aemb();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_Aidp = new aidp(getActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localalsl.l());
    this.jdField_a_of_type_Aidp.show();
  }
  
  protected void q()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadData");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.2(this), 5, null, true);
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadTarget");
    }
    ThreadManager.post(new ChatHistoryTroopAllFragment.3(this), 5, null, true);
  }
  
  public void t()
  {
    if (!this.jdField_a_of_type_Agzc.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701978));
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void u()
  {
    if (!this.jdField_a_of_type_Agzc.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadPrev");
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.5(this, i), 5, null, true);
  }
  
  public void y(int paramInt)
  {
    if (paramInt < 0) {
      t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */