package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Color;
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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
  private String e;
  
  public QCircleChatIceBreakItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dip2px(paramInt1));
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
      this.e = paramUserPMGiftInfo.uid.get();
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.d.b).setActionType(45).setSubActionType(2).setThrActionType(1));
      Object localObject1 = ContactUtils.a(this.a, this.e, true);
      paramIceBreakViewHolder.g.setAvatar(this.a, paramUserPMGiftInfo.uid.get());
      paramIceBreakViewHolder.h.setText((CharSequence)localObject1);
      localObject1 = new FeedCloudMeta.StUser();
      ((FeedCloudMeta.StUser)localObject1).id.set(this.e);
      paramIceBreakViewHolder.j.setUserData((FeedCloudMeta.StUser)localObject1);
      paramIceBreakViewHolder.j.setItemPreClickListener(new QCircleChatIceBreakItemBuilder.2(this));
      if (paramUserPMGiftInfo.giftInfos.has())
      {
        localObject1 = paramUserPMGiftInfo.giftInfos.get();
        if (paramIceBreakViewHolder.i.getChildCount() > 0) {
          paramIceBreakViewHolder.i.removeAllViews();
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
              QCircleGiftRecordView localQCircleGiftRecordView = new QCircleGiftRecordView(this.c);
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
                ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dpToPx(8.0F);
              }
              paramIceBreakViewHolder.i.addView(localQCircleGiftRecordView, (ViewGroup.LayoutParams)localObject2);
              i += 1;
            }
          }
        }
      }
      if ((paramUserPMGiftInfo.relation.get() != 1) && (paramUserPMGiftInfo.relation.get() != 2))
      {
        paramIceBreakViewHolder.f.setVisibility(0);
        ((LinearLayout.LayoutParams)paramIceBreakViewHolder.e.getLayoutParams()).height = ViewUtils.dpToPx(73.0F);
        return;
      }
      paramIceBreakViewHolder.f.setVisibility(8);
      ((LinearLayout.LayoutParams)paramIceBreakViewHolder.e.getLayoutParams()).height = ViewUtils.dpToPx(78.0F);
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int i;
    if (ThemeUtil.isNowThemeIsNight(this.a, false, null)) {
      i = Color.rgb(34, 34, 34);
    } else {
      i = -1;
    }
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
        paramView = LayoutInflater.from(this.c).inflate(2131626846, null);
        paramMessageRecord = new LinearLayout.LayoutParams(ViewUtils.dpToPx(298.0F), -2);
        paramMessageRecord.topMargin = ViewUtils.dpToPx(24.0F);
        paramMessageRecord.gravity = 1;
        paramView.setLayoutParams(paramMessageRecord);
        paramViewHolder = new QCircleChatIceBreakItemBuilder.IceBreakViewHolder();
        paramView.setTag(paramViewHolder);
      }
      paramViewHolder.d = paramView.findViewById(2131437549);
      paramMessageRecord = a(12, i);
      paramViewHolder.d.setBackgroundDrawable(paramMessageRecord);
      paramViewHolder.e = ((FrameLayout)paramView.findViewById(2131433267));
      paramViewHolder.g = ((QCircleAvatarView)paramView.findViewById(2131436271));
      paramViewHolder.g.setOnClickListener(this);
      paramViewHolder.h = ((TextView)paramView.findViewById(2131448603));
      paramViewHolder.i = ((LinearLayout)paramView.findViewById(2131437463));
      paramViewHolder.f = ((LinearLayout)paramView.findViewById(2131433266));
      paramViewHolder.j = ((QCircleFollowView)paramView.findViewById(2131448468));
      paramViewHolder.j.setFollowStateChangeListener(new QCircleChatIceBreakItemBuilder.1(this, paramViewHolder));
      a(paramViewHolder, paramLinearLayout);
      paramMessageRecord = paramView;
    }
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new QCircleChatIceBreakItemBuilder.IceBreakViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatIceBreakItemBuilder", 2, "destroy ");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436271)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", this.e);
      QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", localHashMap);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(this.d.b).setActionType(45).setSubActionType(2).setThrActionType(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleChatIceBreakItemBuilder
 * JD-Core Version:    0.7.0.1
 */