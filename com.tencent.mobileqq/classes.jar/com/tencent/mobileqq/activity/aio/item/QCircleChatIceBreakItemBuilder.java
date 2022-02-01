package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleAvatarView;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleGiftRecordView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.PMGiftDisplayInfo;
import qqcircle.QQCirclePrivateMsgShow.PMGiftInfo;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class QCircleChatIceBreakItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  private String a;
  
  public QCircleChatIceBreakItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.a(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private void a(QCircleChatIceBreakItemBuilder.IceBreakViewHolder paramIceBreakViewHolder, QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    if ((paramIceBreakViewHolder != null) && (paramUserPMGiftInfo != null))
    {
      if (!paramUserPMGiftInfo.has()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleChatIceBreakItemBuilder", 2, new Object[] { "bind icebreak data,chatUin:", paramUserPMGiftInfo.uid.get(), ",relation:", Integer.valueOf(paramUserPMGiftInfo.relation.get()), ",giftInfo size:", Integer.valueOf(paramUserPMGiftInfo.giftInfos.size()) });
      }
      this.jdField_a_of_type_JavaLangString = paramUserPMGiftInfo.uid.get();
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 2, 1);
      Object localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      paramIceBreakViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleAvatarView.setAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUserPMGiftInfo.uid.get());
      paramIceBreakViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = new FeedCloudMeta.StUser();
      ((FeedCloudMeta.StUser)localObject1).id.set(this.jdField_a_of_type_JavaLangString);
      paramIceBreakViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.setUserData((FeedCloudMeta.StUser)localObject1);
      paramIceBreakViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.setItemPreClickListener(new QCircleChatIceBreakItemBuilder.2(this));
      if (paramUserPMGiftInfo.giftInfos.has())
      {
        localObject1 = paramUserPMGiftInfo.giftInfos.get();
        if (paramIceBreakViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
          paramIceBreakViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (QQCirclePrivateMsgShow.PMGiftInfo)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).has()))
            {
              QCircleGiftRecordView localQCircleGiftRecordView = new QCircleGiftRecordView(this.jdField_a_of_type_AndroidContentContext);
              QQCirclePrivateMsgShow.PMGiftDisplayInfo localPMGiftDisplayInfo = (QQCirclePrivateMsgShow.PMGiftDisplayInfo)((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).display.get();
              if ((localPMGiftDisplayInfo != null) && (localPMGiftDisplayInfo.has()))
              {
                localQCircleGiftRecordView.setIconUrl(localPMGiftDisplayInfo.icon.get());
                localQCircleGiftRecordView.setUIStyle(localPMGiftDisplayInfo.numberColor.get(), localPMGiftDisplayInfo.backgroudColor.get());
              }
              localQCircleGiftRecordView.setGiftCount(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get(), false);
              localObject2 = new LinearLayout.LayoutParams(-2, -1);
              ((LinearLayout.LayoutParams)localObject2).gravity = 17;
              if (i == 0) {
                ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
              } else {
                ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.b(8.0F);
              }
              paramIceBreakViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localQCircleGiftRecordView, (ViewGroup.LayoutParams)localObject2);
              i += 1;
            }
          }
        }
      }
      if ((paramUserPMGiftInfo.relation.get() != 1) && (paramUserPMGiftInfo.relation.get() != 2))
      {
        paramIceBreakViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        ((LinearLayout.LayoutParams)paramIceBreakViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = ViewUtils.b(73.0F);
        return;
      }
      paramIceBreakViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ((LinearLayout.LayoutParams)paramIceBreakViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = ViewUtils.b(78.0F);
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    paramOnLongClickAndTouchListener = ((MessageForQCircleIceBreak)paramMessageRecord).getExtInfoFromExtStr("qcircle_chat_msg_data_key");
    paramMessageRecord = paramView;
    if (!TextUtils.isEmpty(paramOnLongClickAndTouchListener))
    {
      paramLinearLayout = new QQCirclePrivateMsgShow.UserPMGiftInfo();
      try
      {
        paramLinearLayout.mergeFrom(paramOnLongClickAndTouchListener.getBytes());
      }
      catch (InvalidProtocolBufferMicroException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
      if (!paramLinearLayout.has())
      {
        QLog.e("QCircleChatIceBreakItemBuilder", 1, "getItemView miss userGiftInfos");
        return null;
      }
      if ((paramViewHolder instanceof QCircleChatIceBreakItemBuilder.IceBreakViewHolder)) {
        paramMessageRecord = (QCircleChatIceBreakItemBuilder.IceBreakViewHolder)paramViewHolder;
      } else {
        paramMessageRecord = null;
      }
      if (paramView != null)
      {
        paramViewHolder = paramMessageRecord;
        if (paramMessageRecord != null) {}
      }
      else
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560714, null);
        paramMessageRecord = new LinearLayout.LayoutParams(ViewUtils.b(298.0F), -2);
        paramMessageRecord.topMargin = ViewUtils.b(24.0F);
        paramMessageRecord.gravity = 1;
        paramView.setLayoutParams(paramMessageRecord);
        paramViewHolder = new QCircleChatIceBreakItemBuilder.IceBreakViewHolder();
        paramView.setTag(paramViewHolder);
      }
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370302);
      paramMessageRecord = a(12, -1);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
      paramViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366921));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369286));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleAvatarView.setOnClickListener(this);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379782));
      paramViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370258));
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366920));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131379686));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.setFollowStateChangeListener(new QCircleChatIceBreakItemBuilder.1(this, paramViewHolder));
      a(paramViewHolder, paramLinearLayout);
      paramMessageRecord = paramView;
    }
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QCircleChatIceBreakItemBuilder.IceBreakViewHolder();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatIceBreakItemBuilder", 2, "destroy ");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369286)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", this.jdField_a_of_type_JavaLangString);
      QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", localHashMap);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 2, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleChatIceBreakItemBuilder
 * JD-Core Version:    0.7.0.1
 */