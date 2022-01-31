package com.tencent.mobileqq.activity.history;

import actn;
import acuv;
import adtl;
import aduc;
import adve;
import adzh;
import adzr;
import adzs;
import aeah;
import aecg;
import afbz;
import afcb;
import afyn;
import afyo;
import afyp;
import agfm;
import aibp;
import aibs;
import aiby;
import ajta;
import ajyc;
import akay;
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
import axqw;
import bfoa;
import bfob;
import bfol;
import bfoy;
import bftk;
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
import vzo;

public class ChatHistoryTroopAllFragment
  extends ChatHistoryBaseFragment
  implements afcb, Handler.Callback, View.OnClickListener, bfoa, bfob, bftk
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 9223372036854775807L;
  public afbz a;
  private agfm jdField_a_of_type_Agfm;
  private ajta jdField_a_of_type_Ajta = new afyp(this);
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
            paramView = actn.a(paramView);
            if (adzr.class.isInstance(paramView))
            {
              ((adzr)paramView).a();
              return;
            }
            if (aeah.class.isInstance(paramView))
            {
              ((aeah)paramView).a();
              return;
            }
            if (adtl.class.isInstance(paramView))
            {
              ((adtl)paramView).a();
              return;
            }
            if (!(paramView instanceof aecg)) {
              break label136;
            }
            paramView = (aecg)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof adve)) {
            break label163;
          }
          paramView = (adve)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
      } while (!(paramView instanceof aduc));
      paramView = (aduc)paramView;
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
    paramIntent = this.jdField_a_of_type_Afbz.a();
    if (paramIntent.size() > 0) {
      paramIntent.clear();
    }
    this.jdField_c_of_type_Long = l;
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "locateToPosition, mTargetShmsgseq = " + this.jdField_c_of_type_Long + " , loadTarget");
    }
    t();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      paramViewGroup = getActivity();
    } while (paramViewGroup == null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369275));
    paramLayoutInflater = new SessionInfo();
    paramLayoutInflater.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Int = 1;
    paramLayoutInflater.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramLayoutInflater.jdField_a_of_type_Acuv = new acuv();
    paramLayoutInflater.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(paramViewGroup);
    int i = vzo.a(paramViewGroup, 10.0F);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup).inflate(2131558825, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, false);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166933));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, i, 0, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_Afbz = new afbz(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup, paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Afbz);
    this.jdField_a_of_type_Afbz.a(this);
    if (this.jdField_c_of_type_Long > 0L) {
      t();
    }
    for (;;)
    {
      p();
      paramViewGroup = (DispatchTouchEventLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375501);
      paramViewGroup.setOnDispatchListener(new afyn(this));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131365675);
      if (!acuv.a(BaseApplicationImpl.getContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLayoutInflater.jdField_a_of_type_JavaLangString, true, 0, paramLayoutInflater.jdField_a_of_type_Acuv)) {
        break;
      }
      paramViewGroup.setBackgroundDrawable(paramLayoutInflater.jdField_a_of_type_Acuv.a);
      return;
      s();
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
    localObject = (bfol)bfoy.a((Context)localObject, null);
    ((bfol)localObject).a(getResources().getString(2131696395));
    ((bfol)localObject).a(2131691507, 3);
    ((bfol)localObject).c(2131690596);
    ((bfol)localObject).a(new afyo(this, paramChatMessage, (bfol)localObject));
    ((bfol)localObject).show();
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
      if (this.jdField_a_of_type_Afbz != null)
      {
        if (this.jdField_a_of_type_Afbz.getCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
        }
        this.jdField_a_of_type_Afbz.notifyDataSetChanged();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      u();
    }
    while (paramView.getId() != 2131365764) {
      return;
    }
    q();
    axqw.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 1, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560306, paramViewGroup, false);
    a();
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajta);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQLiveImage.releaseAll(getActivity());
    if (this.jdField_a_of_type_Ajta != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajta);
    }
  }
  
  public void onDestroyView()
  {
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Afbz.c();
    super.onDestroyView();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatHistoryTroopAllFragment.class);
    }
    adzs.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(getActivity());
    adzh.e();
    ShortVideoRealItemBuilder.e();
    aibp localaibp = aibp.a();
    if ((localaibp.c()) && (localaibp.a())) {
      localaibp.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    QQLiveImage.resumeAll(getActivity());
    adzh.f();
    ShortVideoRealItemBuilder.f();
    ((MediaPlayerManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_Afbz, null);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatHistoryTroopAllFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (this.jdField_a_of_type_Afbz != null)
    {
      if (this.jdField_a_of_type_Afbz.getCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEmptyView(this.e);
      }
      this.jdField_a_of_type_Afbz.notifyDataSetChanged();
    }
    axqw.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 1, 0, "", "", "", "");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1) {
      a(this.jdField_c_of_type_AndroidViewView);
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
        a(this.d);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Aiby.a(14);
      AbstractGifImage.resumeAll();
      return;
    }
    this.jdField_a_of_type_Aiby.a(12);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375501)).findViewById(2131375676));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363480).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365764);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  void q()
  {
    akay localakay = (akay)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv = new acuv();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_Agfm = new agfm(getActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakay.k());
    this.jdField_a_of_type_Agfm.show();
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
    if (!this.jdField_a_of_type_Afbz.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("chatHistory.troop.msgList", 2, "loadMore");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131701594));
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ThreadManager.post(new ChatHistoryTroopAllFragment.4(this, i), 5, null, true);
  }
  
  public void v()
  {
    if (!this.jdField_a_of_type_Afbz.b) {
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
      u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment
 * JD-Core Version:    0.7.0.1
 */