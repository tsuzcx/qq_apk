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
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList<RecentBaseData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
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
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561166, null);
      localObject = new QQLSActivity.ViewHolderPush();
      ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374266));
      ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131374272));
      ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramView.setTag(localObject);
    }
    ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mTitleName);
    ((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
    CustomWidgetUtil.a(((QQLSActivity.ViewHolderPush)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
    return paramView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject4 = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType(), ((MessageRecord)localObject1).uniseq);
    if (((RecentBaseData)localObject4).getRecentUserType() == 1032) {
      paramViewGroup = ConfessMsgUtil.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject1);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof QQLSActivity.RecentPttViewHolder))) {
      break label248;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561167, null);
    localObject1 = new QQLSActivity.RecentPttViewHolder();
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374266));
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374271));
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131374272));
    paramView.setTag(localObject1);
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374102));
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374097));
    ((QQLSActivity.RecentPttViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramView.findViewById(2131374098));
    label248:
    QQLSActivity.RecentPttViewHolder localRecentPttViewHolder = (QQLSActivity.RecentPttViewHolder)paramView.getTag();
    localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
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
      i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getConversationFacade().a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
      j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
    }
    int k = ((RecentBaseData)localObject4).getRecentUserType();
    Object localObject2 = "";
    if ((k != 0) && (((RecentBaseData)localObject4).getRecentUserType() != 3000) && (((RecentBaseData)localObject4).getRecentUserType() != 8)) {
      if ((((RecentBaseData)localObject4).getRecentUserType() != 1001) && (((RecentBaseData)localObject4).getRecentUserType() != 1010) && (((RecentBaseData)localObject4).getRecentUserType() != 10002))
      {
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject4).mLastMsg;
      }
      else
      {
        if (!((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
          break label560;
        }
        ((RecentBaseData)localObject4).mTitleName = BaseApplicationImpl.getApplication().getString(2131691449);
        this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131691448);
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
        if (((String)localObject1).length() > 0)
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 6)
          {
            ((RecentBaseData)localObject4).mTitleName = localObject1[4];
            this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
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
        ((RecentBaseData)localObject4).mTitleName = BaseApplicationImpl.getApplication().getString(2131693572);
        this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131693571);
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
        if (((String)localObject1).length() > 0)
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 6)
          {
            ((RecentBaseData)localObject4).mTitleName = localObject1[4];
            this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
          }
        }
      }
      else
      {
        Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
        localObject3 = ContactUtils.g(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
        this.jdField_a_of_type_JavaLangCharSequence = ((StringBuilder)localObject3).toString();
        continue;
        if (j > 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("recentList misscallMsg size ");
              ((StringBuilder)localObject3).append(((List)localObject1).size());
              QLog.d("QQLSActivity", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(((RecentBaseData)localObject4).getRecentUserUin(), ((RecentBaseData)localObject4).getRecentUserType());
            long l1 = ((RecentBaseData)localObject4).getLastMsgTime();
            long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
            if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject3).msgtype != -2016) && (((MessageRecord)localObject3).msgtype != -2009) && (((MessageRecord)localObject3).msgtype != -2026)) {
              this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject4).mLastMsg;
            } else {
              this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
            }
          }
          else
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject4).mLastMsg;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
          }
        }
        else
        {
          this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject4).mLastMsg;
        }
      }
    }
    localObject1 = paramView;
    localRecentPttViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject4).mTitleName);
    localRecentPttViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject4).mShowTime);
    if (((RecentBaseData)localObject4).getRecentUserType() == 4000) {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.getAllUnreadMessageCount();
    }
    i += j;
    if (i == 0)
    {
      localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
    else
    {
      localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      CustomWidgetUtil.a(localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, i, 0);
    }
    if ((((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) || (((RecentBaseData)localObject4).getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))) {
      localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
    }
    paramView = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    paramView.setId(2131363435);
    paramView.setFocusableInTouchMode(true);
    paramView.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
    localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
    if ((paramViewGroup instanceof MessageForPtt))
    {
      localObject3 = (MessageForPtt)paramViewGroup;
      paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramViewGroup);
      ((TextView)((View)localObject1).findViewById(2131374099)).setText(paramView);
      localObject4 = (ViewGroup.MarginLayoutParams)localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
      if (!paramView.equals("")) {
        ((ViewGroup.MarginLayoutParams)localObject4).setMargins(AIOUtils.b(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), AIOUtils.b(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      } else {
        ((ViewGroup.MarginLayoutParams)localObject4).setMargins(0, AIOUtils.b(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      j = PttItemBuilder.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageForPtt)localObject3);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentPttViewHolder, (MessageForPtt)localObject3, false, true);
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
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity;
      paramView.a(localRecentPttViewHolder, (MessageForPtt)localObject3, i, paramView.a((ChatMessage)localObject3));
      PttInfoCollector.reportPttItemBuilderType(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, paramViewGroup);
      FileTransferManager.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
      if ((QQLSActivity.b()) && (localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder == null)) {
        localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      }
      localRecentPttViewHolder.jdField_b_of_type_Int = paramInt;
      localRecentPttViewHolder.jdField_c_of_type_Int = paramInt;
      if (QQLSActivity.b())
      {
        localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
        if (!TextUtils.isEmpty(localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder)) {
          localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder.replace(0, localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder.length(), "");
        }
        if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
      }
    }
    try
    {
      paramView = TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, paramViewGroup.time * 1000L);
      localObject2 = localRecentPttViewHolder.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject2).append(paramView);
      ((StringBuilder)localObject2).append(" ");
      localRecentPttViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramViewGroup);
      ((IPTTPreDownloader)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRuntimeService(IPTTPreDownloader.class)).onViewPTT((MessageForPtt)localObject3);
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
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
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
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561165, null);
        localObject1 = new QQLSActivity.ViewHolder();
        ((QQLSActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374266));
        ((QQLSActivity.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374270));
        ((QQLSActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374271));
        ((QQLSActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131374272));
        ((QQLSActivity.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374273));
        paramView.setTag(localObject1);
        ((QQLSActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((QQLSActivity.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        label190:
        RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        QQLSActivity.ViewHolder localViewHolder = (QQLSActivity.ViewHolder)paramView.getTag();
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
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
          i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getConversationFacade().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        }
        if (k == 3)
        {
          localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if (localObject1 != null) {
            localRecentBaseData.mLastMsg = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject1, false);
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
                localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
                localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
                if (((localObject1 instanceof MessageForPubAccount)) && (!((MessageForPubAccount)localObject1).isTextMsg()))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()));
                  ((StringBuilder)localObject1).append(":");
                  localObject1 = ((StringBuilder)localObject1).toString();
                  break label628;
                }
              }
              localObject1 = "";
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(localRecentBaseData.mLastMsg);
              this.jdField_a_of_type_JavaLangCharSequence = ((StringBuilder)localObject3).toString();
              if (10007 == localRecentBaseData.getRecentUserType()) {
                this.jdField_a_of_type_JavaLangCharSequence = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localRecentBaseData, localRecentBaseData.mLastMsg);
              }
              if (localRecentBaseData.getRecentUserType() == 7220)
              {
                localObject1 = ((IKanDianMergeManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRuntimeService(IKanDianMergeManager.class)).getLastMsgForKandian2();
                if (localObject1 != null) {
                  this.jdField_a_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject1, false);
                }
              }
              if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                localObject1 = ((RecentItemTroopMsgData)localRecentBaseData).a().msg;
                if ((localObject1 instanceof TroopReceiptMsg)) {
                  this.jdField_a_of_type_JavaLangCharSequence = ((TroopReceiptMsg)localObject1).a;
                }
              }
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
            else
            {
              this.jdField_a_of_type_JavaLangCharSequence = ((RecentItemNoticeData)localRecentBaseData).wording;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131694443);
              i = 1;
              break label1731;
            }
          }
          else
          {
            if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN))
            {
              localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131691449);
              this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131691448);
              localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
              if (((String)localObject1).length() > 0)
              {
                localObject1 = ((String)localObject1).split("\\|");
                if (localObject1.length >= 6)
                {
                  localRecentBaseData.mTitleName = localObject1[4];
                  this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
                }
              }
            }
            else if (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))
            {
              localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131693572);
              this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131693571);
              localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
              if (((String)localObject1).length() > 0)
              {
                localObject1 = ((String)localObject1).split("\\|");
                if (localObject1.length >= 6)
                {
                  localRecentBaseData.mTitleName = localObject1[4];
                  this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
                }
              }
            }
            else
            {
              Object localObject4 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
              if (((MessageRecord)localObject4).msgtype == -2053)
              {
                localObject1 = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
                ((MessageForNearbyLiveTip)localObject1).msgData = ((MessageRecord)localObject4).msgData;
                ((MessageForNearbyLiveTip)localObject1).parse();
                localObject3 = ((MessageForNearbyLiveTip)localObject1).nickName;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131699037));
                ((StringBuilder)localObject4).append((String)localObject3);
                ((StringBuilder)localObject4).append(((MessageForNearbyLiveTip)localObject1).msg);
                this.jdField_a_of_type_JavaLangCharSequence = ((StringBuilder)localObject4).toString();
              }
              else
              {
                localObject3 = ContactUtils.g(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), ((MessageRecord)localObject4).senderuin);
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = "";
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append(": ");
                ((StringBuilder)localObject3).append(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject4, false));
                this.jdField_a_of_type_JavaLangCharSequence = ((StringBuilder)localObject3).toString();
              }
            }
            localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        else if (j > 0)
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("recentList misscallMsg size ");
              ((StringBuilder)localObject3).append(((List)localObject1).size());
              QLog.d("QQLSActivity", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getMessageFacade().getLastMessage(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            long l1 = localRecentBaseData.getLastMsgTime();
            long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
            if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject3).msgtype != -2016) && (((MessageRecord)localObject3).msgtype != -2009) && (((MessageRecord)localObject3).msgtype != -2026) && (localRecentBaseData.getRecentUserType() != 8))
            {
              this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
            }
            else
            {
              this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
              localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-570319);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
            localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
          }
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
        }
        else
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localRecentBaseData.mMsgExtroInfo);
          ((StringBuilder)localObject1).append(localRecentBaseData.mLastMsg);
          this.jdField_a_of_type_JavaLangCharSequence = ((StringBuilder)localObject1).toString();
          localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        }
        localObject1 = localObject2;
        label1731:
        if ((localRecentBaseData.getRecentUserType() == 8) && (localRecentBaseData.mExtraType == 25))
        {
          localObject2 = (IPhoneContactService)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getRuntimeService(IPhoneContactService.class, "");
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
            localObject2 = ((QCallCardManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(localRecentBaseData.getRecentUserUin());
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
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.getRecentUserType()));
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
        if (localRecentBaseData.getRecentUserType() == 4000) {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.getAllUnreadMessageCount();
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
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
        }
        else
        {
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
          CustomWidgetUtil.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, i, 0);
        }
        if ((localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) || (localRecentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN))) {
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.RecentItemAdapter
 * JD-Core Version:    0.7.0.1
 */