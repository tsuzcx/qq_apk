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
  public List<MessageRecord> a;
  
  public QQLSActivity$SingleItemAdapter(QQLSActivity paramQQLSActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
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
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561169, null);
      localObject = new QQLSActivity.ViewHolderSinglePush();
      ((QQLSActivity.ViewHolderSinglePush)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374270));
      ((QQLSActivity.ViewHolderSinglePush)localObject).jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      ((QQLSActivity.ViewHolderSinglePush)localObject).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(10);
      ((QQLSActivity.ViewHolderSinglePush)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      paramView.setTag(localObject);
    }
    paramViewGroup = (ImageView)paramView.findViewById(2131374264);
    if (paramViewGroup != null) {
      if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() == 7432) {
        paramViewGroup.setVisibility(4);
      } else {
        paramViewGroup.setVisibility(0);
      }
    }
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return paramView;
    }
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).mTitleName;
    ((QQLSActivity.ViewHolderSinglePush)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    return paramView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1 = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    ((BaseChatItemLayout)localObject1).setId(2131363435);
    ((BaseChatItemLayout)localObject1).setFocusableInTouchMode(true);
    ((BaseChatItemLayout)localObject1).setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
    if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.SinglePttHolder)))
    {
      paramViewGroup = (QQLSActivity.SinglePttHolder)paramView.getTag();
    }
    else
    {
      paramViewGroup = new QQLSActivity.SinglePttHolder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561164, null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374102));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374097));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramView.findViewById(2131374098));
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localObject1);
    MessageForPtt localMessageForPtt;
    if ((localMessageRecord instanceof MessageForPtt))
    {
      localMessageForPtt = (MessageForPtt)localMessageRecord;
      localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord);
      ((TextView)paramView.findViewById(2131374099)).setText(new ColorNickText((CharSequence)localObject2, 16).a());
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
      localObject1 = "";
      if (!((String)localObject2).equals("")) {
        localMarginLayoutParams.setMargins(AIOUtils.b(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), AIOUtils.b(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      } else {
        localMarginLayoutParams.setMargins(0, AIOUtils.b(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      int j = PttItemBuilder.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(paramViewGroup, localMessageForPtt, false, true);
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity;
      ((QQLSActivity)localObject2).a(paramViewGroup, localMessageForPtt, i, ((QQLSActivity)localObject2).a(localMessageForPtt));
      PttInfoCollector.reportPttItemBuilderType(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, localMessageRecord);
      FileTransferManager.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
      if ((QQLSActivity.b()) && (paramViewGroup.jdField_a_of_type_JavaLangStringBuilder == null)) {
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      paramViewGroup.b = paramInt;
      paramViewGroup.jdField_c_of_type_Int = paramInt;
      if (QQLSActivity.b())
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
        if (!TextUtils.isEmpty(paramViewGroup.jdField_a_of_type_JavaLangStringBuilder)) {
          paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.length(), "");
        }
        if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
      }
    }
    try
    {
      localObject2 = TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, localMessageRecord.time * 1000L);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label584:
      break label584;
    }
    Object localObject2 = paramViewGroup.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject2).append((CharSequence)localObject1);
    ((StringBuilder)localObject2).append(" ");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)localMessageRecord);
    ((IPTTPreDownloader)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRuntimeService(IPTTPreDownloader.class)).onViewPTT(localMessageForPtt);
    return paramView;
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() != 1012) && (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() != 7432) && (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() != 1030) && (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() != 1035))
      {
        if ((localMessageRecord != null) && ((localMessageRecord.msgtype == -2002) || (localMessageRecord.msgtype == -1031))) {
          return 2;
        }
        if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType() == 9653) {
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
          localView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561168, null);
          paramView = new QQLSActivity.ViewHolderSingle();
          localObject2 = (TextView)localView.findViewById(2131374270);
          localObject3 = (ImageView)localView.findViewById(2131374273);
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject2).setMaxLines(10);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
          localView.setTag(paramView);
        }
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          localObject2 = (QQLSActivity.ViewHolderSingle)localView.getTag();
          if (((MessageRecord)localObject3).istroop == 7000)
          {
            paramView = (View)localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountService != null) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqSubaccountApiISubAccountService.getLatestUinNick(((MessageRecord)localObject3).frienduin);
            }
            localObject1 = paramView;
            if (paramView == null) {
              localObject1 = ((MessageRecord)localObject3).frienduin;
            }
            paramView = new StringBuilder();
            paramView.append((String)localObject1);
            paramView.append(": ");
            paramView.append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
            paramView = paramView.toString();
          }
          else if ((((MessageRecord)localObject3).istroop != 1001) && (((MessageRecord)localObject3).istroop != 1010) && (((MessageRecord)localObject3).istroop != 10002))
          {
            if ((((MessageRecord)localObject3).istroop == 9501) && ("device_groupchat".equals(((MessageRecord)localObject3).extStr)))
            {
              if ((((MessageRecord)localObject3).msgtype != -4501) && (((MessageRecord)localObject3).msgtype != -4508))
              {
                paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false);
              }
              else
              {
                localObject1 = ContactUtils.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), ((MessageRecord)localObject3).senderuin, true);
                paramView = (View)localObject1;
                if (!TextUtils.isEmpty(((MessageRecord)localObject3).senderuin))
                {
                  paramView = (View)localObject1;
                  if (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) {
                    paramView = SmartDeviceUtil.a(((SmartDeviceProxyMgr)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(((MessageRecord)localObject3).senderuin)));
                  }
                }
                localObject1 = paramView;
                if (paramView == null) {
                  localObject1 = "";
                }
                paramView = new StringBuilder();
                paramView.append((String)localObject1);
                paramView.append(": ");
                paramView.append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
                paramView = paramView.toString();
              }
            }
            else if (AnonymousChatHelper.a((MessageRecord)localObject3))
            {
              paramView = new StringBuilder();
              paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131697238));
              paramView.append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
              paramView = paramView.toString();
            }
            else if ((((MessageRecord)localObject3).istroop == 1) && ((localObject3 instanceof MessageForPubAccount)))
            {
              if (!((MessageForPubAccount)localObject3).isTextMsg())
              {
                paramView = new StringBuilder();
                paramView.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()));
                paramView.append(":");
                paramView = paramView.toString();
              }
              else
              {
                paramView = "";
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramView);
              ((StringBuilder)localObject1).append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
              paramView = ((StringBuilder)localObject1).toString();
            }
            else if (UinTypeUtil.a(((MessageRecord)localObject3).istroop) == 1032)
            {
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false);
            }
            else if ((((MessageRecord)localObject3).istroop != 1041) && (((MessageRecord)localObject3).istroop != 1042))
            {
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false);
            }
            else
            {
              ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374266)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131694443));
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
              ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131699037));
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append(paramView.msg);
              paramView = ((StringBuilder)localObject4).toString();
            }
            else
            {
              localObject1 = ContactUtils.g(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), ((MessageRecord)localObject3).senderuin);
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              if (((MessageRecord)localObject3).frienduin.equals(AppConstants.LOCK_SCREEN_DATE_UIN))
              {
                ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374266)).setText(BaseApplicationImpl.getApplication().getString(2131691449));
                localObject1 = BaseApplicationImpl.getApplication().getString(2131691448);
                ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374272)).setVisibility(8);
                localObject4 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
                paramView = (View)localObject1;
                if (((String)localObject4).length() > 0)
                {
                  localObject4 = ((String)localObject4).split("\\|");
                  paramView = (View)localObject1;
                  if (localObject4.length >= 6)
                  {
                    ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374266)).setText(localObject4[4]);
                    paramView = localObject4[5];
                  }
                }
              }
              else if (((MessageRecord)localObject3).frienduin.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))
              {
                ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374266)).setText(BaseApplicationImpl.getApplication().getString(2131693572));
                localObject1 = BaseApplicationImpl.getApplication().getString(2131693571);
                ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374272)).setVisibility(8);
                localObject4 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
                paramView = (View)localObject1;
                if (((String)localObject4).length() > 0)
                {
                  localObject4 = ((String)localObject4).split("\\|");
                  paramView = (View)localObject1;
                  if (localObject4.length >= 6)
                  {
                    ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131374266)).setText(localObject4[4]);
                    paramView = localObject4[5];
                  }
                }
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramView);
                ((StringBuilder)localObject1).append(": ");
                ((StringBuilder)localObject1).append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
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
            paramView = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject3, (CharSequence)localObject1);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramView.equals("")) && ((((MessageRecord)localObject3).msgtype == -2016) || (((MessageRecord)localObject3).msgtype == -2009) || (((MessageRecord)localObject3).msgtype == -2026)))
          {
            paramView = ((MessageRecord)localObject3).msg;
            ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-570319);
            ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          else
          {
            ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
            ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if ((((MessageRecord)localObject3).istroop == 1) && (!(localObject3 instanceof MessageForPubAccount)))
          {
            localObject1 = ColorNickManager.a((MessageRecord)localObject3, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject3, false));
            if (localObject1 != null) {
              ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            } else {
              ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType()));
            }
          }
          else
          {
            ((QQLSActivity.ViewHolderSingle)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRecentUserType()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.SingleItemAdapter
 * JD-Core Version:    0.7.0.1
 */