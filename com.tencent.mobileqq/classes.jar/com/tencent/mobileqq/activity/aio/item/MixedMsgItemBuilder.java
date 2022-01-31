package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import vha;
import vhb;
import vhc;
import vhd;

public class MixedMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, FileTransferManager.Callback
{
  protected View.OnClickListener a;
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new vhb(this);
  private View.OnClickListener b;
  public long c;
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vha(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vhc(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2, List paramList)
  {
    if (paramSpannableStringBuilder1.length() > 0)
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
      ((MessageForText)localMessageRecord).sb = new SpannableStringBuilder(paramSpannableStringBuilder1);
      paramSpannableStringBuilder1.clear();
      if (paramSpannableStringBuilder2.length() > 0) {
        ((MessageForText)localMessageRecord).sb2 = new SpannableStringBuilder(paramSpannableStringBuilder2);
      }
      paramSpannableStringBuilder2.clear();
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((AbsDownloader.a(paramURLDrawable.getURL().toString())) && (paramURLDrawable.getStatus() != 1)) {}
    try
    {
      paramURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
  
  private void a(ArrayList paramArrayList1, ArrayList paramArrayList2, MessageRecord paramMessageRecord)
  {
    if (!SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      break label14;
    }
    label14:
    while (paramArrayList2.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int j = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int m = paramArrayList2.size();
    TextView localTextView;
    Object localObject2;
    int k;
    for (;;)
    {
      if (i < m)
      {
        localTextView = (TextView)paramArrayList2.get(i);
        localObject2 = (SchoolTroopKeywordManager.KeywordResult)paramArrayList1.get(i);
        if ((localObject2 == null) || (((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int == -1))
        {
          localStringBuilder.append(localTextView.getText());
          k = j;
          localObject2 = localObject1;
          if (i != m - 1)
          {
            localStringBuilder.append(" ");
            localObject2 = localObject1;
            k = j;
          }
          label138:
          i += 1;
          j = k;
          localObject1 = localObject2;
        }
        else
        {
          localStringBuilder.append(((SchoolTroopKeywordManager.KeywordResult)localObject2).b());
          if (i != m - 1) {
            localStringBuilder.append(" ");
          }
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      localTextView.setTag(2131363725, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label138;
      if (((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int)
      {
        localObject1 = localObject2;
        j = i;
        continue;
        if (localObject1 != null)
        {
          localObject2 = new SchoolTroopKeywordManager.KeywordResult();
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).a(localStringBuilder.toString());
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).c = localObject1.c;
          ((SchoolTroopKeywordManager.KeywordResult)localObject2).d = localObject1.d;
          ((Spannable)((TextView)paramArrayList2.get(j)).getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SchoolTroopKeywordManager.KeywordResult)localObject2), ((SchoolTroopKeywordManager.KeywordResult)localObject2).c, ((SchoolTroopKeywordManager.KeywordResult)localObject2).d, 17);
          if (QLog.isDevelopLevel()) {
            QLog.d("school_troop.MixedMsgItemBuilder", 2, new Object[] { "matchKeywordResults.size: ", Integer.valueOf(paramArrayList1.size()), "; detect result: ", localObject2 });
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("school_troop.MixedMsgItemBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
        return;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (paramViewHolder.b == null) {
      paramViewHolder.b = new StringBuilder();
    }
    Object localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    if ((!jdField_b_of_type_Boolean) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) != null) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) == paramChatMessage.uniseq) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (((TroopRobotManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramView;
      }
      localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return paramView;
    }
    Object localObject2;
    Object localObject3;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramBaseChatItemLayout = (MessageForMixedMsg)paramChatMessage;
      if (jdField_b_of_type_Boolean)
      {
        if (MsgUtils.a(paramChatMessage.issend)) {
          paramViewHolder.b.append("发出");
        }
      }
      else {
        localObject2 = paramBaseChatItemLayout.msgElemList.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label297;
        }
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          if (jdField_b_of_type_Boolean) {
            paramViewHolder.b.append("图片");
          }
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramBaseChatItemLayout);
          continue;
          paramViewHolder.b.append("发来");
          break;
        }
        if (jdField_b_of_type_Boolean) {
          paramViewHolder.b.append(com.tencent.mobileqq.text.TextUtils.a(((MessageRecord)localObject3).msg));
        }
      }
      label297:
      paramBaseChatItemLayout = a(paramViewHolder, (MixedMsgLinearLayout)paramView, paramBaseChatItemLayout.msgElemList, paramOnLongClickAndTouchListener, paramBaseChatItemLayout);
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
      if (((TroopRobotManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
    }
    for (;;)
    {
      paramChatMessage = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramChatMessage != null) {
        paramChatMessage.a(paramBaseChatItemLayout, this);
      }
      paramView = paramBaseChatItemLayout;
      if (paramBaseChatItemLayout == null) {
        break;
      }
      paramBaseChatItemLayout.setTag(localMixedHolder);
      return paramBaseChatItemLayout;
      localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      continue;
      paramBaseChatItemLayout = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject3 = (MessageForLongMsg)paramChatMessage;
        if (jdField_b_of_type_Boolean) {
          paramViewHolder.b.append("说");
        }
        localObject2 = new ArrayList();
        paramBaseChatItemLayout = paramView;
        if (((MessageForLongMsg)localObject3).longMsgFragmentList != null)
        {
          paramBaseChatItemLayout = paramView;
          if (!((MessageForLongMsg)localObject3).longMsgFragmentList.isEmpty())
          {
            localObject1 = new SpannableStringBuilder();
            paramBaseChatItemLayout = new SpannableStringBuilder();
            localObject3 = ((MessageForLongMsg)localObject3).longMsgFragmentList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (MessageRecord)((Iterator)localObject3).next();
              if ((localObject4 instanceof MessageForText))
              {
                if (!android.text.TextUtils.isEmpty(((MessageForText)localObject4).sb)) {
                  ((SpannableStringBuilder)localObject1).append(((MessageForText)localObject4).sb);
                }
                if (!android.text.TextUtils.isEmpty(((MessageForText)localObject4).sb2)) {
                  paramBaseChatItemLayout.append(((MessageForText)localObject4).sb2);
                } else if (!android.text.TextUtils.isEmpty(((MessageForText)localObject4).sb)) {
                  paramBaseChatItemLayout.append(((MessageForText)localObject4).sb);
                }
              }
              else if ((localObject4 instanceof MessageForPic))
              {
                a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
                ((List)localObject2).add(localObject4);
              }
              else if ((localObject4 instanceof MessageForMixedMsg))
              {
                localObject4 = (MessageForMixedMsg)localObject4;
                List localList = ((MessageForMixedMsg)localObject4).msgElemList;
                int j = localList.size();
                int i = 0;
                label702:
                MessageRecord localMessageRecord;
                if (i < j)
                {
                  localMessageRecord = (MessageRecord)localList.get(i);
                  if (!(localMessageRecord instanceof MessageForPic)) {
                    break label783;
                  }
                  if (((MessageForPic)localMessageRecord).time == 0L) {
                    MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject4);
                  }
                  a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
                  ((List)localObject2).add(localMessageRecord);
                }
                for (;;)
                {
                  i += 1;
                  break label702;
                  break;
                  label783:
                  if ((localMessageRecord instanceof MessageForText))
                  {
                    if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
                      ((SpannableStringBuilder)localObject1).append(((MessageForText)localMessageRecord).sb);
                    }
                    if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
                      paramBaseChatItemLayout.append(((MessageForText)localMessageRecord).sb2);
                    } else if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
                      paramBaseChatItemLayout.append(((MessageForText)localMessageRecord).sb);
                    }
                  }
                  else
                  {
                    ((List)localObject2).add(localMessageRecord);
                  }
                }
              }
            }
            a((SpannableStringBuilder)localObject1, paramBaseChatItemLayout, (List)localObject2);
            paramView = a(paramViewHolder, (MixedMsgLinearLayout)paramView, (List)localObject2, paramOnLongClickAndTouchListener, paramChatMessage);
            MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
            paramBaseChatItemLayout = paramView;
            if (jdField_b_of_type_Boolean)
            {
              paramViewHolder.b.append(com.tencent.mobileqq.text.TextUtils.d(((SpannableStringBuilder)localObject1).toString()));
              paramBaseChatItemLayout = paramView;
            }
          }
        }
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (a(paramView)) {
      return this;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131361877);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131558601, 2131558599, 2131558602, 2131558600);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131362724);
      paramMixedMsgLinearLayout.addRule(3, 2131362966);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramList);
    }
    paramList.a(localArrayList1);
    if (SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramViewHolder = (SchoolTroopKeywordManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261);; paramViewHolder = null)
    {
      paramMixedMsgLinearLayout = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = localArrayList1.size();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = (MessageRecord)localArrayList1.get(i);
        View localView = paramList.getChildAt(i);
        if (localView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgItemBuilder", 2, "getMixedMsgLayout,child is null. size = " + j + ",i = " + i);
          }
          i += 1;
        }
        else
        {
          Object localObject3;
          Object localObject2;
          Object localObject4;
          Object localObject5;
          if ((localObject1 instanceof MessageForReplyText)) {
            if ((localView instanceof LinearLayout))
            {
              localObject3 = (LinearLayout)localView;
              localObject2 = (ViewGroup)((LinearLayout)localObject3).getChildAt(0);
              localObject3 = (TextView)((LinearLayout)localObject3).getChildAt(1);
              localObject4 = (MessageForReplyText)localObject1;
              if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((MessageForReplyText)localObject4).senderuin)) && (((MessageForReplyText)localObject4).mSourceMsgInfo.mLocalAtInfoDone == 0))
              {
                ((MessageForReplyText)localObject4).mSourceMsgInfo.mLocalAtInfoDone = 1;
                if ((((MessageForReplyText)localObject4).atInfoList != null) && (((MessageForReplyText)localObject4).atInfoList.size() > 0))
                {
                  localObject5 = (MessageForText.AtTroopMemberInfo)((MessageForReplyText)localObject4).atInfoList.remove(0);
                  if (((MessageForReplyText)localObject4).msg.length() > ((MessageForText.AtTroopMemberInfo)localObject5).textLen + 1)
                  {
                    ((MessageForReplyText)localObject4).msg = ((MessageForReplyText)localObject4).msg.substring(((MessageForText.AtTroopMemberInfo)localObject5).textLen + 1);
                    ((MessageForReplyText)localObject4).sb = new QQText(((MessageForReplyText)localObject4).msg, 13, 32, (MessageRecord)localObject4);
                  }
                }
              }
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject4).sb))
              {
                ((TextView)localObject3).setText(((MessageForReplyText)localObject4).sb);
                ((TextView)localObject3).setVisibility(0);
                label538:
                if (paramViewHolder != null)
                {
                  paramMixedMsgLinearLayout.add(paramViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                  localArrayList2.add(localObject3);
                }
                ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject4).mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject4).istroop, ((MessageForReplyText)localObject4).uniseq);
              }
            }
            else
            {
              label603:
              localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
              ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.l;
              if (i != j - 1) {
                break label1094;
              }
            }
          }
          label1094:
          for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.l;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
          {
            localView.setOnTouchListener(paramOnLongClickAndTouchListener);
            localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
            break;
            ((TextView)localObject3).setVisibility(8);
            break label538;
            if ((localObject1 instanceof MessageForText))
            {
              localObject2 = (AnimationTextView)localView;
              ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
              if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
                ((AnimationTextView)localObject2).setText(((MessageForText)localObject1).sb2);
              }
              for (;;)
              {
                if (paramViewHolder != null)
                {
                  paramMixedMsgLinearLayout.add(paramViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                  localArrayList2.add(localObject2);
                }
                if (!TroopRobotManager.b(paramMessageRecord)) {
                  break;
                }
                TroopRobotManager.a((TextView)localObject2, (MessageRecord)localObject1);
                break;
                ((AnimationTextView)localObject2).setText(((MessageForText)localObject1).sb);
              }
            }
            if ((localObject1 instanceof MessageForPic))
            {
              localObject1 = (MessageForPic)localObject1;
              localObject2 = (ChatThumbView)localView;
              localObject3 = new int[2];
              tmp812_810 = localObject3;
              tmp812_810[0] = 0;
              tmp816_812 = tmp812_810;
              tmp816_812[1] = 0;
              tmp816_812;
              localObject4 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
              ((ChatThumbView)localObject2).setTag(2131361894, localObject1);
              ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
              localObject5 = ((URLDrawable)localObject4).getURL().getProtocol();
              URL localURL = URLDrawableHelper.a((PicUiInterface)localObject1, 65537);
              AbsDownloader.d(localURL.toString());
              if (PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(((MessageForPic)localObject1).imageType), ((String)localObject5).equals("chatthumb"), localObject3[0], localObject3[1], localURL))
              {
                ((URLDrawable)localObject4).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject4).setWatermarkVisibility(0);
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MixedMsgItemBuilder", 2, "getMixedMsgLayout,set picmsg, picDrawable " + localObject4 + ",picMsg = " + localObject1);
                }
                ((ChatThumbView)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
                a((URLDrawable)localObject4);
                if (((MessageForPic)localObject1).isSendFromLocal()) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForPic)localObject1, 2);
                break;
                ((URLDrawable)localObject4).setWatermarkVisibility(4);
              }
            }
            if (!QLog.isColorLevel()) {
              break label603;
            }
            QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
            break label603;
          }
        }
      }
      a(paramMixedMsgLinearLayout, localArrayList2, paramMessageRecord);
      paramList.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramList.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramList.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      return paramList;
    }
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375633: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131375643: 
      super.c(paramChatMessage);
      return;
    case 2131375639: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      return;
    case 2131363536: 
      CharSequence localCharSequence = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
      paramContext = new Bundle();
      Object localObject = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      paramInt = i;
      if (localObject != null)
      {
        paramInt = i;
        if (((String)localObject).length() > 0)
        {
          localObject = ((String)localObject).split("\\|");
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (localObject.length <= 0) {}
          }
        }
      }
      for (;;)
      {
        try
        {
          paramInt = Integer.parseInt(localObject[0]);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgItemBuilder", 2, "get mixMsgForward switch From config : configSwitch = " + paramInt);
          }
          if (paramInt != 1) {
            continue;
          }
          paramInt = i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          paramInt = i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
          paramInt = i;
          continue;
          paramContext.putInt("forward_type", -1);
          continue;
        }
        if (paramInt == 0) {
          continue;
        }
        paramContext.putInt("forward_type", -5);
        paramContext.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
        paramContext.putString("forward_text", localCharSequence.toString());
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        return;
        paramInt = 0;
      }
    case 2131366774: 
      QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.a(2131433649, 5);
        localActionSheet.c(2131433029);
        localActionSheet.a(new vhd(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)paramView.getTag();
    int i = BaseChatItemLayout.g;
    if (paramChatMessage.isSend())
    {
      MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(TextItemBuilder.g, i, TextItemBuilder.f, TextItemBuilder.e);
      return;
    }
    MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(TextItemBuilder.f, i, TextItemBuilder.g, TextItemBuilder.e);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((MixedMsgItemBuilder.MixedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((MixedMsgItemBuilder.MixedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if ((MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramFileMsg.b) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramFileMsg.c)) {
              break label68;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null) {
            break label593;
          }
          paramInt2 = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildCount();
          paramInt1 = 0;
          label232:
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramFileMsg = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildAt(paramInt1);
            if ((paramFileMsg instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramFileMsg).getTag(2131361894);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramFileMsg = (ChatThumbView)paramFileMsg;
                if (paramFileMsg == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFileMsg, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = URLDrawableHelper.a(paramView, 65537);
                boolean bool = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramFileMsg.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((MixedMsgItemBuilder.MixedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((MixedMsgItemBuilder.MixedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                if ((((MessageForLongMsg)localObject2).longMsgFragmentList == null) || (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())) {
                  break label585;
                }
                localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = (MessageRecord)((Iterator)localObject2).next();
                } while (localObject3 == null);
                if (((MessageRecord)localObject3).uniseq != paramFileMsg.b) {
                  break label579;
                }
                if ((localObject3 instanceof MessageForPic)) {
                  paramView = (MessageForPic)localObject3;
                }
              }
            }
          }
          for (;;)
          {
            label478:
            break label424;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = ((MessageForMixedMsg)localObject3).msgElemList.iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (MessageRecord)((Iterator)localObject3).next();
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramFileMsg.c))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramFileMsg = null;
                    break label232;
                    break;
                  }
                }
              }
            }
          }
          continue;
          paramView = null;
          continue;
          paramView = null;
        }
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject).getBackground();
    if (localObject != null) {
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      ((Drawable)localObject).setColorFilter(paramView);
      ((Drawable)localObject).invalidateSelf();
      return;
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494236);
        if (!paramChatMessage.isSend()) {
          break label79;
        }
      }
      label79:
      for (paramView = paramView.getColorStateList(2131494235);; paramView = paramView.getColorStateList(2131494234))
      {
        MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131494233);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131494234);
    if (paramBubbleInfo.jdField_b_of_type_Int != 0) {
      paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.jdField_b_of_type_Int);
    }
    if (paramBubbleInfo.c != 0) {
      paramView = ColorStateList.valueOf(paramBubbleInfo.c);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    while (paramChatMessage.extraflag != 32768) {
      return false;
    }
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433042));
    localQQCustomMenu.a(2131375639, this.jdField_a_of_type_AndroidContentContext.getString(2131433732), 2130838312);
    localQQCustomMenu.a(2131363536, this.jdField_a_of_type_AndroidContentContext.getString(2131435099), 2130838318);
    a(localChatMessage, localQQCustomMenu);
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131366774, this.jdField_a_of_type_AndroidContentContext.getString(2131431574), 2130838317);
    }
    a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */