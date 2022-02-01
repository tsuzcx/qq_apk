package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class QQLSActivity$SingleItemAdapter
  extends XBaseAdapter
{
  public List<MessageRecord> a = new ArrayList();
  
  public QQLSActivity$SingleItemAdapter(QQLSActivity paramQQLSActivity) {}
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if ((paramViewGroup instanceof QQLSActivity.ViewHolderSinglePush))
      {
        paramViewGroup = (QQLSActivity.ViewHolderSinglePush)paramViewGroup;
        break label26;
      }
    }
    paramViewGroup = null;
    label26:
    Object localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = this.b.getLayoutInflater().inflate(2131627521, null);
      localObject = new QQLSActivity.ViewHolderSinglePush();
      ((QQLSActivity.ViewHolderSinglePush)localObject).a = ((TextView)paramView.findViewById(2131442433));
      ((QQLSActivity.ViewHolderSinglePush)localObject).a.setEllipsize(TextUtils.TruncateAt.END);
      ((QQLSActivity.ViewHolderSinglePush)localObject).a.setMaxLines(10);
      ((QQLSActivity.ViewHolderSinglePush)localObject).a.setTextColor(-4210755);
      paramView.setTag(localObject);
    }
    paramViewGroup = (ImageView)paramView.findViewById(2131442427);
    if (paramViewGroup != null) {
      if (QQLSActivity.h(this.b).getRecentUserType() == 7432) {
        paramViewGroup.setVisibility(4);
      } else {
        paramViewGroup.setVisibility(0);
      }
    }
    if (paramInt >= this.a.size()) {
      return paramView;
    }
    paramViewGroup = QQLSActivity.h(this.b).mTitleName;
    ((QQLSActivity.ViewHolderSinglePush)localObject).a.setText(paramViewGroup);
    return paramView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageRecord localMessageRecord = (MessageRecord)this.a.get(paramInt);
    Object localObject1 = new BaseChatItemLayout(this.b);
    ((BaseChatItemLayout)localObject1).setId(2131429332);
    ((BaseChatItemLayout)localObject1).setFocusableInTouchMode(true);
    ((BaseChatItemLayout)localObject1).setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
    if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.SinglePttHolder)))
    {
      paramViewGroup = (QQLSActivity.SinglePttHolder)paramView.getTag();
    }
    else
    {
      paramViewGroup = new QQLSActivity.SinglePttHolder();
      paramView = this.b.getLayoutInflater().inflate(2131627516, null);
      paramViewGroup.f = ((TextView)paramView.findViewById(2131442197));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131442192));
      paramViewGroup.g = ((BreathAnimationLayout)paramView.findViewById(2131442193));
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.j = ((BaseChatItemLayout)localObject1);
    MessageForPtt localMessageForPtt;
    if ((localMessageRecord instanceof MessageForPtt))
    {
      localMessageForPtt = (MessageForPtt)localMessageRecord;
      localObject2 = QQLSActivity.a(this.b, localMessageRecord);
      ((TextView)paramView.findViewById(2131442194)).setText(new ColorNickText((CharSequence)localObject2, 16).b());
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.g.getLayoutParams();
      localObject1 = "";
      if (!((String)localObject2).equals("")) {
        localMarginLayoutParams.setMargins(AIOUtils.b(5.0F, this.b.getResources()), AIOUtils.b(7.0F, this.b.getResources()), 0, 0);
      } else {
        localMarginLayoutParams.setMargins(0, AIOUtils.b(7.0F, this.b.getResources()), 0, 0);
      }
      int j = PttItemBuilder.a(QQLSActivity.i(this.b), localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        this.b.a(paramViewGroup, localMessageForPtt, false, true);
        i = 2001;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fileStatus = ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" url ");
        ((StringBuilder)localObject2).append(localMessageForPtt.url);
        ((StringBuilder)localObject2).append(" uniseq ");
        ((StringBuilder)localObject2).append(localMessageForPtt.uniseq);
        QLog.d("PTTItem->getBubbleView", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.b;
      ((QQLSActivity)localObject2).a(paramViewGroup, localMessageForPtt, i, ((QQLSActivity)localObject2).a(localMessageForPtt));
      PttInfoCollector.reportPttItemBuilderType(QQLSActivity.i(this.b), i, localMessageRecord);
      FileTransferManager.a(QQLSActivity.i(this.b)).a(paramView, this.b);
      if ((QQLSActivity.l()) && (paramViewGroup.d == null)) {
        paramViewGroup.d = new StringBuilder();
      }
      paramViewGroup.l = paramInt;
      paramViewGroup.m = paramInt;
      if (QQLSActivity.l())
      {
        paramViewGroup.j.setContentDescription(null);
        if (!TextUtils.isEmpty(paramViewGroup.d)) {
          paramViewGroup.d.replace(0, paramViewGroup.d.length(), "");
        }
        if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
      }
    }
    try
    {
      localObject2 = TimeFormatterUtils.a(this.b, 3, localMessageRecord.time * 1000L);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label584:
      break label584;
    }
    Object localObject2 = paramViewGroup.d;
    ((StringBuilder)localObject2).append((CharSequence)localObject1);
    ((StringBuilder)localObject2).append(" ");
    paramViewGroup.q = ((ChatMessage)localMessageRecord);
    ((IPTTPreDownloader)QQLSActivity.i(this.b).getRuntimeService(IPTTPreDownloader.class)).onViewPTT(localMessageForPtt);
    return paramView;
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)this.a.get(paramInt);
      if ((QQLSActivity.h(this.b).getRecentUserType() != 1012) && (QQLSActivity.h(this.b).getRecentUserType() != 7432) && (QQLSActivity.h(this.b).getRecentUserType() != 1030) && (QQLSActivity.h(this.b).getRecentUserType() != 1035))
      {
        if ((localMessageRecord != null) && ((localMessageRecord.msgtype == -2002) || (localMessageRecord.msgtype == -1031))) {
          return 2;
        }
        if (QQLSActivity.h(this.b).getRecentUserType() == 9653) {
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
    int i = getItemViewType(paramInt);
    if ((i != 1) && (i != 4))
    {
      if (i == 2)
      {
        localView = a(paramInt, paramView, paramViewGroup);
      }
      else
      {
        localObject1 = null;
        Object localObject2;
        Object localObject3;
        if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.ViewHolderSingle)))
        {
          localView = paramView;
        }
        else
        {
          localView = this.b.getLayoutInflater().inflate(2131627520, null);
          paramView = new QQLSActivity.ViewHolderSingle();
          localObject2 = (TextView)localView.findViewById(2131442433);
          localObject3 = (ImageView)localView.findViewById(2131442436);
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject2).setMaxLines(10);
          paramView.a = ((TextView)localObject2);
          paramView.b = ((ImageView)localObject3);
          localView.setTag(paramView);
        }
        if (paramInt < this.a.size())
        {
          localObject3 = (MessageRecord)this.a.get(paramInt);
          localObject2 = (QQLSActivity.ViewHolderSingle)localView.getTag();
          if (((MessageRecord)localObject3).istroop == 7000)
          {
            paramView = (View)localObject1;
            if (this.b.m != null) {
              paramView = this.b.m.getLatestUinNick(((MessageRecord)localObject3).frienduin);
            }
            localObject1 = paramView;
            if (paramView == null) {
              localObject1 = ((MessageRecord)localObject3).frienduin;
            }
            paramView = new StringBuilder();
            paramView.append((String)localObject1);
            paramView.append(": ");
            paramView.append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false));
            paramView = paramView.toString();
          }
          else if ((((MessageRecord)localObject3).istroop != 1001) && (((MessageRecord)localObject3).istroop != 1010) && (((MessageRecord)localObject3).istroop != 10002))
          {
            if ((((MessageRecord)localObject3).istroop == 9501) && ("device_groupchat".equals(((MessageRecord)localObject3).extStr)))
            {
              if ((((MessageRecord)localObject3).msgtype != -4501) && (((MessageRecord)localObject3).msgtype != -4508))
              {
                paramView = QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false);
              }
              else
              {
                localObject1 = ContactUtils.a(QQLSActivity.i(this.b), ((MessageRecord)localObject3).senderuin, true);
                paramView = (View)localObject1;
                if (!TextUtils.isEmpty(((MessageRecord)localObject3).senderuin))
                {
                  paramView = (View)localObject1;
                  if (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) {
                    paramView = SmartDeviceUtil.a(((SmartDeviceProxyMgr)QQLSActivity.i(this.b).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(((MessageRecord)localObject3).senderuin)));
                  }
                }
                localObject1 = paramView;
                if (paramView == null) {
                  localObject1 = "";
                }
                paramView = new StringBuilder();
                paramView.append((String)localObject1);
                paramView.append(": ");
                paramView.append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false));
                paramView = paramView.toString();
              }
            }
            else if (AnonymousChatHelper.c((MessageRecord)localObject3))
            {
              paramView = new StringBuilder();
              paramView.append(this.b.getResources().getString(2131895011));
              paramView.append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false));
              paramView = paramView.toString();
            }
            else if ((((MessageRecord)localObject3).istroop == 1) && ((localObject3 instanceof MessageForPubAccount)))
            {
              if (!((MessageForPubAccount)localObject3).isTextMsg())
              {
                paramView = new StringBuilder();
                paramView.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.i(this.b), BaseApplicationImpl.getContext()));
                paramView.append(":");
                paramView = paramView.toString();
              }
              else
              {
                paramView = "";
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramView);
              ((StringBuilder)localObject1).append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false));
              paramView = ((StringBuilder)localObject1).toString();
            }
            else if (UinTypeUtil.e(((MessageRecord)localObject3).istroop) == 1032)
            {
              paramView = QQLSActivity.i(this.b).getMessageFacade().d(this.b, (MessageRecord)localObject3, false);
            }
            else if ((((MessageRecord)localObject3).istroop != 1041) && (((MessageRecord)localObject3).istroop != 1042))
            {
              paramView = QQLSActivity.i(this.b).getMessageFacade().b(this.b, (MessageRecord)localObject3, false);
            }
            else
            {
              ((TextView)QQLSActivity.j(this.b).findViewById(2131442429)).setText(this.b.getResources().getString(2131892123));
              paramView = ((MessageRecord)localObject3).msg;
            }
          }
          else
          {
            Object localObject4;
            if (((MessageRecord)localObject3).msgtype == -2053)
            {
              paramView = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
              paramView.msgData = ((MessageRecord)localObject3).msgData;
              paramView.parse();
              localObject1 = paramView.nickName;
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.b.getString(2131897046));
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append(paramView.msg);
              paramView = ((StringBuilder)localObject4).toString();
            }
            else
            {
              localObject1 = ContactUtils.h(QQLSActivity.i(this.b), ((MessageRecord)localObject3).senderuin);
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              if (((MessageRecord)localObject3).frienduin.equals(AppConstants.LOCK_SCREEN_DATE_UIN))
              {
                ((TextView)QQLSActivity.j(this.b).findViewById(2131442429)).setText(BaseApplicationImpl.getApplication().getString(2131888404));
                localObject1 = BaseApplicationImpl.getApplication().getString(2131888403);
                ((DragTextView)QQLSActivity.j(this.b).findViewById(2131442435)).setVisibility(8);
                localObject4 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
                paramView = (View)localObject1;
                if (((String)localObject4).length() > 0)
                {
                  localObject4 = ((String)localObject4).split("\\|");
                  paramView = (View)localObject1;
                  if (localObject4.length >= 6)
                  {
                    ((TextView)QQLSActivity.j(this.b).findViewById(2131442429)).setText(localObject4[4]);
                    paramView = localObject4[5];
                  }
                }
              }
              else if (((MessageRecord)localObject3).frienduin.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))
              {
                ((TextView)QQLSActivity.j(this.b).findViewById(2131442429)).setText(BaseApplicationImpl.getApplication().getString(2131891136));
                localObject1 = BaseApplicationImpl.getApplication().getString(2131891135);
                ((DragTextView)QQLSActivity.j(this.b).findViewById(2131442435)).setVisibility(8);
                localObject4 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
                paramView = (View)localObject1;
                if (((String)localObject4).length() > 0)
                {
                  localObject4 = ((String)localObject4).split("\\|");
                  paramView = (View)localObject1;
                  if (localObject4.length >= 6)
                  {
                    ((TextView)QQLSActivity.j(this.b).findViewById(2131442429)).setText(localObject4[4]);
                    paramView = localObject4[5];
                  }
                }
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramView);
                ((StringBuilder)localObject1).append(": ");
                ((StringBuilder)localObject1).append(QQLSActivity.i(this.b).getMessageFacade().c(this.b, (MessageRecord)localObject3, false));
                paramView = ((StringBuilder)localObject1).toString();
              }
            }
          }
          localObject1 = paramView;
          if (TextUtils.isEmpty(paramView)) {
            localObject1 = "";
          }
          paramView = (View)localObject1;
          if (10007 == ((MessageRecord)localObject3).istroop) {
            paramView = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.i(this.b), (MessageRecord)localObject3, (CharSequence)localObject1);
          }
          if ((this.b.q.size() > 0) && (paramView.equals("")) && ((((MessageRecord)localObject3).msgtype == -2016) || (((MessageRecord)localObject3).msgtype == -2009) || (((MessageRecord)localObject3).msgtype == -2026)))
          {
            paramView = ((MessageRecord)localObject3).msg;
            ((QQLSActivity.ViewHolderSingle)localObject2).a.setTextColor(-570319);
            ((QQLSActivity.ViewHolderSingle)localObject2).b.setVisibility(0);
          }
          else
          {
            ((QQLSActivity.ViewHolderSingle)localObject2).a.setTextColor(-4210755);
            ((QQLSActivity.ViewHolderSingle)localObject2).b.setVisibility(8);
          }
          if ((((MessageRecord)localObject3).istroop == 1) && (!(localObject3 instanceof MessageForPubAccount)))
          {
            localObject1 = ColorNickManager.a((MessageRecord)localObject3, QQLSActivity.i(this.b).getMessageFacade().a(this.b, (MessageRecord)localObject3, false));
            if (localObject1 != null) {
              ((QQLSActivity.ViewHolderSingle)localObject2).a.setText((CharSequence)localObject1);
            } else {
              ((QQLSActivity.ViewHolderSingle)localObject2).a.setText(new QQText(paramView, 5, 16, QQLSActivity.h(this.b).getRecentUserType()));
            }
          }
          else
          {
            ((QQLSActivity.ViewHolderSingle)localObject2).a.setText(new QQText(paramView, 5, 16, QQLSActivity.h(this.b).getRecentUserType()));
          }
        }
        paramView = localView;
        localObject1 = paramView;
        break label1691;
      }
    }
    else {
      localView = b(paramInt, paramView, paramViewGroup);
    }
    Object localObject1 = localView;
    View localView = paramView;
    label1691:
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.SingleItemAdapter
 * JD-Core Version:    0.7.0.1
 */