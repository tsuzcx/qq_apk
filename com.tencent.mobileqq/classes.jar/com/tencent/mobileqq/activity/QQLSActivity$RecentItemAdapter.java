package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

class QQLSActivity$RecentItemAdapter
  extends XBaseAdapter
{
  CharSequence a = "";
  private ArrayList<RecentBaseData> c = new ArrayList();
  
  public QQLSActivity$RecentItemAdapter(QQLSActivity paramQQLSActivity) {}
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup instanceof QQLSActivity.ViewHolderPush))
      {
        paramViewGroup = (QQLSActivity.ViewHolderPush)paramViewGroup;
        break label26;
      }
    }
    paramViewGroup = null;
    label26:
    RecentBaseData localRecentBaseData = (RecentBaseData)this.c.get(paramInt);
    Object localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = this.b.getLayoutInflater().inflate(2131627518, null);
      localObject = new QQLSActivity.ViewHolderPush();
      ((QQLSActivity.ViewHolderPush)localObject).a = ((TextView)paramView.findViewById(2131442429));
      ((QQLSActivity.ViewHolderPush)localObject).b = ((DragTextView)paramView.findViewById(2131442435));
      ((QQLSActivity.ViewHolderPush)localObject).b.setOnModeChangeListener(this.b.o);
      ((QQLSActivity.ViewHolderPush)localObject).b.setDragViewType(0);
      paramView.setTag(localObject);
    }
    ((QQLSActivity.ViewHolderPush)localObject).b.setTag(Integer.valueOf(paramInt));
    ((QQLSActivity.ViewHolderPush)localObject).a.setText(localRecentBaseData.mTitleName);
    ((QQLSActivity.ViewHolderPush)localObject).b.setVisibility(0);
    CustomWidgetUtil.a(((QQLSActivity.ViewHolderPush)localObject).b, 3, 1, 0);
    return paramView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject4 = (RecentBaseData)this.c.get(paramInt);
    Object localObject1 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
    paramViewGroup = QQLSActivity.i(this.b).getMessageFacade().a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType(), ((MessageRecord)localObject1).uniseq);
    if (((RecentBaseData)localObject4).getRecentUserType() == 1032) {
      paramViewGroup = ConfessMsgUtil.a(QQLSActivity.i(this.b), (MessageRecord)localObject1);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.RecentPttViewHolder))) {
      break label248;
    }
    paramView = this.b.getLayoutInflater().inflate(2131627519, null);
    localObject1 = new QQLSActivity.RecentPttViewHolder();
    ((QQLSActivity.RecentPttViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131442429));
    ((QQLSActivity.RecentPttViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131442434));
    ((QQLSActivity.RecentPttViewHolder)localObject1).c = ((DragTextView)paramView.findViewById(2131442435));
    paramView.setTag(localObject1);
    ((QQLSActivity.RecentPttViewHolder)localObject1).c.setOnModeChangeListener(this.b.o);
    ((QQLSActivity.RecentPttViewHolder)localObject1).c.setDragViewType(0);
    ((QQLSActivity.RecentPttViewHolder)localObject1).f = ((TextView)paramView.findViewById(2131442197));
    ((QQLSActivity.RecentPttViewHolder)localObject1).e = ((ImageView)paramView.findViewById(2131442192));
    ((QQLSActivity.RecentPttViewHolder)localObject1).g = ((BreathAnimationLayout)paramView.findViewById(2131442193));
    label248:
    QQLSActivity.RecentPttViewHolder localRecentPttViewHolder = (QQLSActivity.RecentPttViewHolder)paramView.getTag();
    localRecentPttViewHolder.c.setTag(Integer.valueOf(paramInt));
    int i;
    if ((!((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)) && (!((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN))) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if (i != 0)
    {
      i = 0;
      j = 0;
    }
    else
    {
      i = QQLSActivity.i(this.b).getConversationFacade().a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
      j = this.b.b(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
    }
    int k = ((RecentBaseData)localObject4).getRecentUserType();
    Object localObject2 = "";
    if ((k != 0) && (((RecentBaseData)localObject4).getRecentUserType() != 3000) && (((RecentBaseData)localObject4).getRecentUserType() != 8)) {
      if ((((RecentBaseData)localObject4).getRecentUserType() != 1001) && (((RecentBaseData)localObject4).getRecentUserType() != 1010) && (((RecentBaseData)localObject4).getRecentUserType() != 10002))
      {
        this.a = ((RecentBaseData)localObject4).mLastMsg;
      }
      else
      {
        if (!((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
          break label560;
        }
        ((RecentBaseData)localObject4).mTitleName = BaseApplicationImpl.getApplication().getString(2131888404);
        this.a = BaseApplicationImpl.getApplication().getString(2131888403);
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
        if (((String)localObject1).length() > 0)
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 6)
          {
            ((RecentBaseData)localObject4).mTitleName = localObject1[4];
            this.a = localObject1[5];
          }
        }
      }
    }
    label560:
    Object localObject3;
    for (;;)
    {
      break;
      if (((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))
      {
        ((RecentBaseData)localObject4).mTitleName = BaseApplicationImpl.getApplication().getString(2131891136);
        this.a = BaseApplicationImpl.getApplication().getString(2131891135);
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
        if (((String)localObject1).length() > 0)
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 6)
          {
            ((RecentBaseData)localObject4).mTitleName = localObject1[4];
            this.a = localObject1[5];
          }
        }
      }
      else
      {
        Message localMessage = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
        localObject3 = ContactUtils.h(QQLSActivity.i(this.b), localMessage.senderuin);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, localMessage, false));
        this.a = ((StringBuilder)localObject3).toString();
        continue;
        if (j > 0)
        {
          localObject1 = this.b.a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("recentList misscallMsg size ");
              ((StringBuilder)localObject3).append(((List)localObject1).size());
              QLog.d("QQLSActivity", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
            long l1 = ((RecentBaseData)localObject4).getLastMsgTime();
            long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
            if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject3).msgtype != -2016) && (((MessageRecord)localObject3).msgtype != -2009) && (((MessageRecord)localObject3).msgtype != -2026)) {
              this.a = ((RecentBaseData)localObject4).mLastMsg;
            } else {
              this.a = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
            }
          }
          else
          {
            this.a = ((RecentBaseData)localObject4).mLastMsg;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
          }
        }
        else
        {
          this.a = ((RecentBaseData)localObject4).mLastMsg;
        }
      }
    }
    localObject1 = paramView;
    localRecentPttViewHolder.a.setText(((RecentBaseData)localObject4).mTitleName);
    localRecentPttViewHolder.b.setText(((RecentBaseData)localObject4).mShowTime);
    if (((RecentBaseData)localObject4).getRecentUserType() == 4000) {
      i = this.b.l.getAllUnreadMessageCount();
    }
    i += j;
    if (i == 0)
    {
      localRecentPttViewHolder.c.setVisibility(4);
    }
    else
    {
      localRecentPttViewHolder.c.setVisibility(0);
      CustomWidgetUtil.a(localRecentPttViewHolder.c, 3, i, 0);
    }
    if ((((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) || (((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))) {
      localRecentPttViewHolder.c.setVisibility(8);
    }
    paramView = new BaseChatItemLayout(this.b);
    paramView.setId(2131429332);
    paramView.setFocusableInTouchMode(true);
    paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
    localRecentPttViewHolder.j = paramView;
    if ((paramViewGroup instanceof MessageForPtt))
    {
      localObject3 = (MessageForPtt)paramViewGroup;
      paramView = QQLSActivity.a(this.b, paramViewGroup);
      ((TextView)((View)localObject1).findViewById(2131442194)).setText(paramView);
      localObject4 = (ViewGroup.MarginLayoutParams)localRecentPttViewHolder.g.getLayoutParams();
      if (!paramView.equals("")) {
        ((ViewGroup.MarginLayoutParams)localObject4).setMargins(AIOUtils.b(5.0F, this.b.getResources()), AIOUtils.b(7.0F, this.b.getResources()), 0, 0);
      } else {
        ((ViewGroup.MarginLayoutParams)localObject4).setMargins(0, AIOUtils.b(7.0F, this.b.getResources()), 0, 0);
      }
      j = PttItemBuilder.a(QQLSActivity.i(this.b), (MessageForPtt)localObject3);
      i = j;
      if (j == -1)
      {
        this.b.a(localRecentPttViewHolder, (MessageForPtt)localObject3, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("fileStatus = ");
        paramView.append(i);
        paramView.append(" url ");
        paramView.append(((MessageForPtt)localObject3).url);
        paramView.append(" uniseq ");
        paramView.append(((MessageForPtt)localObject3).uniseq);
        QLog.d("PTTItem->getBubbleView", 2, paramView.toString());
      }
      paramView = this.b;
      paramView.a(localRecentPttViewHolder, (MessageForPtt)localObject3, i, paramView.a((ChatMessage)localObject3));
      PttInfoCollector.reportPttItemBuilderType(QQLSActivity.i(this.b), i, paramViewGroup);
      FileTransferManager.a(QQLSActivity.i(this.b)).a((View)localObject1, this.b);
      if ((QQLSActivity.l()) && (localRecentPttViewHolder.d == null)) {
        localRecentPttViewHolder.d = new StringBuilder();
      }
      localRecentPttViewHolder.l = paramInt;
      localRecentPttViewHolder.m = paramInt;
      if (QQLSActivity.l())
      {
        localRecentPttViewHolder.j.setContentDescription(null);
        if (!TextUtils.isEmpty(localRecentPttViewHolder.d)) {
          localRecentPttViewHolder.d.replace(0, localRecentPttViewHolder.d.length(), "");
        }
        if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
      }
    }
    try
    {
      paramView = TimeFormatterUtils.a(this.b, 3, paramViewGroup.time * 1000L);
      localObject2 = localRecentPttViewHolder.d;
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append(" ");
      localRecentPttViewHolder.q = ((ChatMessage)paramViewGroup);
      ((IPTTPreDownloader)QQLSActivity.i(this.b).getRuntimeService(IPTTPreDownloader.class)).onViewPTT((MessageForPtt)localObject3);
      return localObject1;
      return localObject1;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = (View)localObject2;
      }
    }
  }
  
  public void a(ArrayList<RecentBaseData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.c.clear();
      this.c.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c.size()))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.c.get(paramInt);
      Message localMessage = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      if ((localRecentBaseData.getRecentUserType() != 1012) && (localRecentBaseData.getRecentUserType() != 7432) && (localRecentBaseData.getRecentUserType() != 1030) && (localRecentBaseData.getRecentUserType() != 1035))
      {
        if ((localMessage != null) && ((localMessage.msgtype == -2002) || (localMessage.msgtype == -1031))) {
          return 2;
        }
        if ((localMessage != null) && (localMessage.msgtype == -2025)) {
          return 3;
        }
        if (localRecentBaseData.getRecentUserType() == 9653) {
          return 4;
        }
      }
      else
      {
        return 1;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int k = getItemViewType(paramInt);
    Object localObject1;
    if ((k != 1) && (k != 4))
    {
      if (k == 2)
      {
        localObject1 = a(paramInt, paramView, paramViewGroup);
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.ViewHolder))) {
          break label190;
        }
        paramView = this.b.getLayoutInflater().inflate(2131627517, null);
        localObject1 = new QQLSActivity.ViewHolder();
        ((QQLSActivity.ViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131442429));
        ((QQLSActivity.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131442433));
        ((QQLSActivity.ViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131442434));
        ((QQLSActivity.ViewHolder)localObject1).d = ((DragTextView)paramView.findViewById(2131442435));
        ((QQLSActivity.ViewHolder)localObject1).e = ((ImageView)paramView.findViewById(2131442436));
        paramView.setTag(localObject1);
        ((QQLSActivity.ViewHolder)localObject1).d.setOnModeChangeListener(this.b.o);
        ((QQLSActivity.ViewHolder)localObject1).d.setDragViewType(0);
        label190:
        RecentBaseData localRecentBaseData = (RecentBaseData)this.c.get(paramInt);
        QQLSActivity.ViewHolder localViewHolder = (QQLSActivity.ViewHolder)paramView.getTag();
        localViewHolder.d.setTag(Integer.valueOf(paramInt));
        if ((!localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)) && (!localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN))) {
          i = 0;
        } else {
          i = 1;
        }
        int j;
        if (i != 0)
        {
          i = 0;
          j = 0;
        }
        else
        {
          i = QQLSActivity.i(this.b).getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          j = this.b.b(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        }
        if (k == 3)
        {
          localObject1 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if (localObject1 != null) {
            localRecentBaseData.mLastMsg = QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject1, false);
          }
        }
        localObject2 = localRecentBaseData.mTitleName;
        label628:
        Object localObject3;
        if ((localRecentBaseData.getRecentUserType() != 0) && (localRecentBaseData.getRecentUserType() != 3000) && (localRecentBaseData.getRecentUserType() != 8))
        {
          if ((localRecentBaseData.getRecentUserType() != 1001) && (localRecentBaseData.getRecentUserType() != 1010) && (localRecentBaseData.getRecentUserType() != 10002))
          {
            if ((localRecentBaseData.getRecentUserType() != 1041) && (localRecentBaseData.getRecentUserType() != 1042))
            {
              if (localRecentBaseData.getRecentUserType() == 1)
              {
                localObject1 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
                localObject1 = QQLSActivity.i(this.b).getMessageFacade().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
                if (((localObject1 instanceof MessageForPubAccount)) && (!((MessageForPubAccount)localObject1).isTextMsg()))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.i(this.b), BaseApplicationImpl.getContext()));
                  ((StringBuilder)localObject1).append(":");
                  localObject1 = ((StringBuilder)localObject1).toString();
                  break label628;
                }
              }
              localObject1 = "";
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(localRecentBaseData.mLastMsg);
              this.a = ((StringBuilder)localObject3).toString();
              if (10007 == localRecentBaseData.getRecentUserType()) {
                this.a = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.i(this.b), localRecentBaseData, localRecentBaseData.mLastMsg);
              }
              if (localRecentBaseData.getRecentUserType() == 7220)
              {
                localObject1 = ((IKanDianMergeManager)QQLSActivity.i(this.b).getRuntimeService(IKanDianMergeManager.class)).getLastMsgForKandian2();
                if (localObject1 != null) {
                  this.a = QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject1, false);
                }
              }
              if ((TextUtils.isEmpty(this.a)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                localObject1 = ((RecentItemTroopMsgData)localRecentBaseData).e().msg;
                if ((localObject1 instanceof TroopReceiptMsg)) {
                  this.a = ((TroopReceiptMsg)localObject1).c;
                }
              }
              localViewHolder.b.setTextColor(-4210755);
              localViewHolder.e.setVisibility(8);
            }
            else
            {
              this.a = ((RecentItemNoticeData)localRecentBaseData).wording;
              localObject1 = this.b.getResources().getString(2131892123);
              i = 1;
              break label1731;
            }
          }
          else
          {
            if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN))
            {
              localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131888404);
              this.a = BaseApplicationImpl.getApplication().getString(2131888403);
              localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
              if (((String)localObject1).length() > 0)
              {
                localObject1 = ((String)localObject1).split("\\|");
                if (localObject1.length >= 6)
                {
                  localRecentBaseData.mTitleName = localObject1[4];
                  this.a = localObject1[5];
                }
              }
            }
            else if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))
            {
              localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131891136);
              this.a = BaseApplicationImpl.getApplication().getString(2131891135);
              localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
              if (((String)localObject1).length() > 0)
              {
                localObject1 = ((String)localObject1).split("\\|");
                if (localObject1.length >= 6)
                {
                  localRecentBaseData.mTitleName = localObject1[4];
                  this.a = localObject1[5];
                }
              }
            }
            else
            {
              Object localObject4 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
              if (((MessageRecord)localObject4).msgtype == -2053)
              {
                localObject1 = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
                ((MessageForNearbyLiveTip)localObject1).msgData = ((MessageRecord)localObject4).msgData;
                ((MessageForNearbyLiveTip)localObject1).parse();
                localObject3 = ((MessageForNearbyLiveTip)localObject1).nickName;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(this.b.getString(2131897046));
                ((StringBuilder)localObject4).append((String)localObject3);
                ((StringBuilder)localObject4).append(((MessageForNearbyLiveTip)localObject1).msg);
                this.a = ((StringBuilder)localObject4).toString();
              }
              else
              {
                localObject3 = ContactUtils.h(QQLSActivity.i(this.b), ((MessageRecord)localObject4).senderuin);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = "";
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append(": ");
                ((StringBuilder)localObject3).append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject4, false));
                this.a = ((StringBuilder)localObject3).toString();
              }
            }
            localViewHolder.b.setTextColor(-4210755);
            localViewHolder.e.setVisibility(8);
          }
        }
        else if (j > 0)
        {
          localViewHolder.e.setVisibility(0);
          localObject1 = this.b.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("recentList misscallMsg size ");
              ((StringBuilder)localObject3).append(((List)localObject1).size());
              QLog.d("QQLSActivity", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = QQLSActivity.i(this.b).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            long l1 = localRecentBaseData.getLastMsgTime();
            long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
            if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject3).msgtype != -2016) && (((MessageRecord)localObject3).msgtype != -2009) && (((MessageRecord)localObject3).msgtype != -2026) && (localRecentBaseData.getRecentUserType() != 8))
            {
              this.a = localRecentBaseData.mLastMsg;
              localViewHolder.b.setTextColor(-4210755);
            }
            else
            {
              this.a = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
              localViewHolder.b.setTextColor(-570319);
            }
          }
          else
          {
            this.a = localRecentBaseData.mLastMsg;
            localViewHolder.b.setTextColor(-4210755);
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
          }
          localViewHolder.c.setText(localRecentBaseData.mShowTime);
        }
        else
        {
          localViewHolder.e.setVisibility(8);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localRecentBaseData.mMsgExtroInfo);
          ((StringBuilder)localObject1).append(localRecentBaseData.mLastMsg);
          this.a = ((StringBuilder)localObject1).toString();
          localViewHolder.b.setTextColor(-4210755);
        }
        localObject1 = localObject2;
        label1731:
        if ((localRecentBaseData.getRecentUserType() == 8) && (localRecentBaseData.mExtraType == 25))
        {
          localObject2 = (IPhoneContactService)QQLSActivity.i(this.b).getRuntimeService(IPhoneContactService.class, "");
          if (localObject2 != null) {
            localObject2 = ((IPhoneContactService)localObject2).queryContactByCodeNumber(localRecentBaseData.mPhoneNumber);
          } else {
            localObject2 = null;
          }
          if (localObject2 != null)
          {
            localRecentBaseData.mTitleName = ((PhoneContact)localObject2).name;
          }
          else
          {
            localObject2 = ((QCallCardManager)QQLSActivity.i(this.b).getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(localRecentBaseData.getRecentUserUin());
            if (localObject2 != null) {
              localRecentBaseData.mTitleName = ((QCallCardInfo)localObject2).nickname;
            }
          }
          if (localRecentBaseData.mTitleName.equals(localRecentBaseData.getRecentUserUin())) {
            localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
          }
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getView mTitleName = ");
            ((StringBuilder)localObject2).append(localRecentBaseData.mTitleName);
            QLog.d("QQLSActivity", 4, ((StringBuilder)localObject2).toString());
          }
        }
        localViewHolder.a.setText((CharSequence)localObject1);
        localViewHolder.b.setText(new QQText(this.a, 5, 16, localRecentBaseData.getRecentUserType()));
        localViewHolder.c.setText(localRecentBaseData.mShowTime);
        if (localRecentBaseData.getRecentUserType() == 4000) {
          i = this.b.l.getAllUnreadMessageCount();
        }
        if (((!TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN)) || (localRecentBaseData.getRecentUserType() != 7220)) && ((!TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.KANDIAN_DAILY_UIN)) || (localRecentBaseData.getRecentUserType() != 1008)))
        {
          k = i;
          if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), AppConstants.NEW_KANDIAN_UIN))
          {
            k = i;
            if (localRecentBaseData.getRecentUserType() != 1008) {}
          }
        }
        else
        {
          k = 1;
        }
        int i = k + j;
        if (i == 0)
        {
          localViewHolder.d.setVisibility(4);
        }
        else
        {
          localViewHolder.d.setVisibility(0);
          CustomWidgetUtil.a(localViewHolder.d, 3, i, 0);
        }
        if ((localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) || (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))) {
          localViewHolder.d.setVisibility(8);
        }
        localObject1 = paramView;
        localObject2 = localObject1;
        break label2200;
      }
    }
    else {
      localObject1 = b(paramInt, paramView, paramViewGroup);
    }
    Object localObject2 = paramView;
    paramView = (View)localObject1;
    label2200:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.RecentItemAdapter
 * JD-Core Version:    0.7.0.1
 */