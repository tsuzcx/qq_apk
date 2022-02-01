package com.tencent.mobileqq.activity.chathistory;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import localpb.richMsg.RichMsg.FoldMsg;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class TroopMemberHistoryFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  static final String a = "TroopMemberHistoryFragment";
  XListView b;
  boolean c = false;
  String d;
  String e;
  ArrayList<String> f;
  boolean g;
  String h;
  View i;
  TextView j;
  TroopMemberHistoryFragment.TroopMemberChatHisListAdapter k;
  TroopMemberHistoryFragment.LoadMsgThread l = new TroopMemberHistoryFragment.LoadMsgThread(this, null);
  boolean m = false;
  QQAppInterface n;
  Handler.Callback o = new TroopMemberHistoryFragment.3(this);
  MqqHandler p = new MqqWeakReferenceHandler(this.o);
  View.OnClickListener q = new TroopMemberHistoryFragment.4(this);
  private long r = 9223372036854775807L;
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      b();
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
      this.n = ((QQAppInterface)localObject);
      this.d = paramBundle.getString("troop_uin", "0");
      this.e = paramBundle.getString("member_uin", "0");
      this.f = paramBundle.getStringArrayList("members_uin");
      this.g = paramBundle.getBoolean("member_is_shield", false);
      if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(((AppInterface)localObject).getCurrentAccountUin()))) {
        return;
      }
      b();
      return;
    }
    QLog.e(a, 1, "app is null");
    b();
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("redbag_fold_msg");
    try
    {
      if ((paramMessageRecord.mExJsonObject != null) && (paramMessageRecord.mExJsonObject.has("redbag_fold_msg")) && (Boolean.parseBoolean((String)localObject)))
      {
        localObject = new RichMsg.FoldMsg();
        ((RichMsg.FoldMsg)localObject).mergeFrom(paramMessageRecord.msgData);
        paramMessageRecord.msg = ((RichMsg.FoldMsg)localObject).msg_content.get().toStringUtf8();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageRecord)
    {
      QLog.e(a, 1, "error: ", paramMessageRecord);
    }
  }
  
  protected void a()
  {
    this.b = ((XListView)this.mContentView.findViewById(2131437914));
    this.i = this.mContentView.findViewById(2131432501);
    this.j = ((TextView)this.mContentView.findViewById(2131447089));
    this.i.findViewById(2131447324).setVisibility(8);
    this.k = new TroopMemberHistoryFragment.TroopMemberChatHisListAdapter(this, getBaseActivity());
    this.h = ContactUtils.b(this.n, this.d, this.e);
    this.b.setAdapter(this.k);
    this.b.setOnTouchListener(new TroopMemberHistoryFragment.1(this));
    this.b.setOnScrollListener(new TroopMemberHistoryFragment.2(this));
    if ((this.e.equals("0")) && (this.f != null))
    {
      setTitle(HardCodeUtil.a(2131912827));
    }
    else if (this.h != null)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(new ColorNickText(this.h, 32).b()).append("的发言");
      setTitle(localSpannableStringBuilder);
    }
    ReportController.b(this.n, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_exp", 0, 0, this.d, "", "", "");
  }
  
  public void a(int paramInt)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if ((paramInt == 20) && (this.g))
    {
      this.j.setText(2131895368);
      this.i.setVisibility(0);
      return;
    }
    this.l.a(paramInt);
    ThreadManager.post(this.l, 8, null, true);
  }
  
  protected void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  public List<TroopMemberHistoryFragment.MsgItemEntity> c()
  {
    if (this.m) {
      return null;
    }
    Object localObject3 = this.n.getEntityManagerFactory().createEntityManager();
    Object localObject4 = MessageRecord.getTableName(this.d, 1);
    Object localObject1 = UinTypeUtil.a();
    boolean bool2 = this.e.equals("0");
    boolean bool1 = false;
    int i1;
    if (bool2)
    {
      localObject2 = this.f;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = new StringBuilder();
        i1 = 0;
        while (i1 < this.f.size())
        {
          ((StringBuilder)localObject2).append("senderuin = ? ");
          if (i1 < this.f.size() - 1) {
            ((StringBuilder)localObject2).append("or ");
          }
          i1 += 1;
        }
        localObject1 = String.format("%s and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { ((StringBuilder)localObject2).toString(), localObject1 });
        localObject2 = (String[])this.f.toArray(new String[0]);
        break label219;
      }
    }
    localObject1 = String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype %s and isValid=1", new Object[] { Long.valueOf(this.r), localObject1 });
    Object localObject2 = new String[1];
    localObject2[0] = this.e;
    label219:
    localObject1 = ((EntityManager)localObject3).query(MessageRecord.class, (String)localObject4, false, (String)localObject1, (String[])localObject2, null, null, "shmsgseq DESC", String.valueOf(50));
    ((EntityManager)localObject3).close();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (((List)localObject1).size() < 50) {
        bool1 = true;
      }
      this.m = bool1;
      localObject2 = new LinkedList();
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        a((MessageRecord)localObject4);
        i1 = ((MessageRecord)localObject4).msgtype;
        if (i1 != -20000) {
          if (i1 != -8018) {
            if (i1 != -2022) {
              if (i1 != -2017) {
                if (i1 != -2011) {
                  if (i1 != -2007)
                  {
                    if (i1 == -2005) {
                      break label700;
                    }
                    if (i1 != -1035) {
                      if (i1 != -1000) {
                        switch (i1)
                        {
                        default: 
                          localObject1 = HardCodeUtil.a(2131912873);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          break;
          localObject1 = BaseApplicationImpl.getApplication().getString(2131888237);
          continue;
          localObject1 = ColorNickManager.a(((MessageRecord)localObject4).msg, (MessageRecord)localObject4, 32, 13);
          continue;
          localObject1 = new MessageForMixedMsg();
          ((MessageForMixedMsg)localObject1).msgData = ((MessageRecord)localObject4).msgData;
          ((MessageForMixedMsg)localObject1).parse();
          if (((MessageForMixedMsg)localObject1).msg == null)
          {
            localObject1 = HardCodeUtil.a(2131912845);
          }
          else
          {
            localObject1 = new QQText(((MessageForMixedMsg)localObject1).msg, 13, 32, 1);
            continue;
            if ((localObject4 instanceof MessageForMarketFace))
            {
              localObject1 = ((MessageForMarketFace)localObject4).mMarkFaceMessage;
              if ((localObject1 != null) && (!TextUtils.isEmpty(((MarkFaceMessage)localObject1).faceName)))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[");
                localStringBuilder.append(((MarkFaceMessage)localObject1).faceName);
                localStringBuilder.append("]");
                localObject1 = localStringBuilder.toString();
              }
              else
              {
                localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131888889);
              }
            }
            else
            {
              localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131888889);
            }
          }
          try
          {
            localObject1 = StructMsgFactory.a(((MessageRecord)localObject4).msgData);
            if (localObject1 == null)
            {
              localObject1 = HardCodeUtil.a(2131912817);
              continue;
            }
            localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
          }
          catch (Exception localException)
          {
            label689:
            label700:
            break label689;
          }
          localObject1 = HardCodeUtil.a(2131912809);
          continue;
          localObject1 = BaseApplicationImpl.getApplication().getString(2131889249);
          continue;
          localObject1 = BaseApplicationImpl.getApplication().getString(2131888239);
          continue;
          localObject1 = HardCodeUtil.a(2131886652);
          continue;
          if ((localObject4 instanceof MessageForPic)) {
            localObject1 = ((MessageForPic)localObject4).getSummaryMsg();
          } else {
            localObject1 = BaseApplicationImpl.getApplication().getString(2131890793);
          }
        }
        if (this.r > ((MessageRecord)localObject4).shmsgseq) {
          this.r = ((MessageRecord)localObject4).shmsgseq;
        }
        ((List)localObject2).add(new TroopMemberHistoryFragment.MsgItemEntity(this, ((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).time, (CharSequence)localObject1, ((MessageRecord)localObject4).shmsgseq, (MessageRecord)localObject4));
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "load msg null");
    }
    return null;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getArguments());
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "data inited");
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "ui inited");
    }
    a(20);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626672;
  }
  
  public void onClick(View paramView) {}
  
  public void onDetach()
  {
    super.onDetach();
    MqqHandler localMqqHandler = this.p;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment
 * JD-Core Version:    0.7.0.1
 */