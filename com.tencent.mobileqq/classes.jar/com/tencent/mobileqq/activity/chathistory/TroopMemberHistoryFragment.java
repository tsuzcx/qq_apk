package com.tencent.mobileqq.activity.chathistory;

import abot;
import agzt;
import agzu;
import agzv;
import agzw;
import agzy;
import agzz;
import alpo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import awbw;
import awbx;
import azmj;
import azqu;
import bahs;
import baig;
import bdbt;
import bdnm;
import bhoe;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopMemberHistoryFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public static final String a;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  public agzz a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new agzv(this);
  public View.OnClickListener a;
  public View a;
  public TextView a;
  TroopMemberHistoryFragment.LoadMsgThread jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread = new TroopMemberHistoryFragment.LoadMsgThread(this, null);
  public QQAppInterface a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhoe(this.jdField_a_of_type_AndroidOsHandler$Callback);
  public boolean a;
  public String b;
  boolean b;
  String c;
  public boolean c;
  String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopMemberHistoryFragment.class.getSimpleName();
  }
  
  public TroopMemberHistoryFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agzw(this);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      b();
      return;
    }
    Object localObject = getActivity();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FragmentActivity)localObject).getAppInterface())
    {
      if (!(localObject instanceof QQAppInterface)) {
        break label123;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin", "0");
      this.jdField_c_of_type_JavaLangString = paramBundle.getString("member_uin", "0");
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("members_uin");
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("member_is_shield", false);
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(((AppInterface)localObject).getCurrentAccountUin()))) {
        break;
      }
      b();
      return;
    }
    label123:
    QLog.e(jdField_a_of_type_JavaLangString, 1, "app is null");
    b();
  }
  
  public List<agzy> a()
  {
    boolean bool = false;
    if (this.jdField_c_of_type_Boolean) {
      return null;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject4 = MessageRecord.getTableName(this.jdField_b_of_type_JavaLangString, 1);
    Object localObject1 = abot.b();
    if ((this.jdField_c_of_type_JavaLangString.equals("0")) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject2 = new StringBuilder();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)localObject2).append("senderuin = ? ");
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuilder)localObject2).append("or ");
        }
        i += 1;
      }
      localObject1 = String.format("%s and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { ((StringBuilder)localObject2).toString(), localObject1 });
      localObject2 = (String[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new String[0]);
    }
    for (;;)
    {
      localObject1 = ((awbw)localObject3).a(MessageRecord.class, (String)localObject4, false, (String)localObject1, (String[])localObject2, null, null, "shmsgseq DESC", String.valueOf(50));
      ((awbw)localObject3).a();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break label264;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "load msg null");
      return null;
      localObject1 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), localObject1 });
      localObject2 = new String[1];
      localObject2[0] = this.jdField_c_of_type_JavaLangString;
    }
    label264:
    if (((List)localObject1).size() < 50) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    Object localObject2 = new LinkedList();
    localObject3 = ((List)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
      switch (((MessageRecord)localObject4).msgtype)
      {
      default: 
        localObject1 = alpo.a(2131715998);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Long > ((MessageRecord)localObject4).shmsgseq) {
        this.jdField_a_of_type_Long = ((MessageRecord)localObject4).shmsgseq;
      }
      ((List)localObject2).add(new agzy(this, ((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).time, (CharSequence)localObject1, ((MessageRecord)localObject4).shmsgseq, (MessageRecord)localObject4));
      break;
      localObject1 = bdnm.a(((MessageRecord)localObject4).msg, (MessageRecord)localObject4, 32, 13);
      continue;
      if ((localObject4 instanceof MessageForPic))
      {
        localObject1 = ((MessageForPic)localObject4).getSummaryMsg();
      }
      else
      {
        localObject1 = BaseApplicationImpl.getApplication().getString(2131693472);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131691351);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131691353);
        continue;
        localObject1 = new MessageForMixedMsg();
        ((MessageForMixedMsg)localObject1).msgData = ((MessageRecord)localObject4).msgData;
        ((MessageForMixedMsg)localObject1).parse();
        if (((MessageForMixedMsg)localObject1).msg == null) {}
        for (localObject1 = alpo.a(2131715969);; localObject1 = new baig(((MessageForMixedMsg)localObject1).msg, 13, 32, 1)) {
          break;
        }
        if ((localObject4 instanceof MessageForMarketFace))
        {
          localObject1 = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((MarkFaceMessage)localObject1).faceName))) {}
          for (localObject1 = "[" + ((MarkFaceMessage)localObject1).faceName + "]";; localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131692098)) {
            break;
          }
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131692098);
        continue;
        localObject1 = BaseApplicationImpl.getApplication().getString(2131692473);
        continue;
        try
        {
          localObject1 = azqu.a(((MessageRecord)localObject4).msgData);
          if (localObject1 == null) {
            localObject1 = alpo.a(2131715940);
          } else {
            localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
          }
        }
        catch (Exception localException)
        {
          String str = alpo.a(2131715932);
        }
        continue;
        return localObject2;
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131370009));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365733);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377566));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131377770).setVisibility(8);
    this.jdField_a_of_type_Agzz = new agzz(this, getActivity());
    this.d = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agzz);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new agzt(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new agzu(this));
    if ((this.jdField_c_of_type_JavaLangString.equals("0")) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      setTitle(alpo.a(2131715950));
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      if (this.d != null)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append(new bahs(this.d, 32).a()).append("的发言");
        setTitle(localSpannableStringBuilder);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    switch (paramInt)
    {
    }
    do
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread.a(paramInt);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment$LoadMsgThread, 8, null, true);
      return;
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698019);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getArguments());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "data inited");
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ui inited");
    }
    a(20);
  }
  
  public int getContentLayoutId()
  {
    return 2131560418;
  }
  
  public void onClick(View paramView) {}
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment
 * JD-Core Version:    0.7.0.1
 */