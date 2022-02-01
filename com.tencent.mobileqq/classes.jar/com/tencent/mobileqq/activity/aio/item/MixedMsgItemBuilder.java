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
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.replymsg.ReplyItemClickListener;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.DisplayUtil;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MixedMsgItemBuilder
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, Callback, ContextMenuBuilder2
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new MixedMsgItemBuilder.3(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b = new MixedMsgItemBuilder.1(this);
  protected long c;
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ReplyItemClickListener(this);
  }
  
  private View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    Object localObject1;
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (MessageRecordInfo.a(paramChatMessage.issend)) {
        localObject1 = "发出";
      } else {
        localObject1 = "发来";
      }
      a(paramViewHolder, (String)localObject1);
      localObject1 = (MessageForMixedMsg)paramChatMessage;
      localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          a(paramViewHolder, "图片");
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, (MessageForMixedMsg)localObject1);
          }
        }
        else if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, (MessageForMixedMsg)localObject1);
          }
        }
        else
        {
          a(paramViewHolder, com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject3).msg));
        }
      }
      paramViewHolder = a(paramViewHolder, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramOnLongClickAndTouchListener, (MessageRecord)localObject1);
      MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder, paramChatMessage.uniseq);
      localObject1 = paramViewHolder;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramView = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        paramMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return paramViewHolder;
      }
    }
    else
    {
      localObject1 = paramView;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        localObject2 = (MessageForLongMsg)paramChatMessage;
        a(paramViewHolder, "说");
        localObject1 = paramView;
        if (((MessageForLongMsg)localObject2).longMsgFragmentList != null)
        {
          localObject1 = paramView;
          if (!((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())
          {
            localObject1 = a(((MessageForLongMsg)localObject2).longMsgFragmentList, paramMixedHolder);
            localObject1 = a(paramViewHolder, (MixedMsgLinearLayout)paramView, (List)localObject1, paramOnLongClickAndTouchListener, paramChatMessage);
            MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder, paramChatMessage.uniseq);
          }
        }
      }
    }
    return localObject1;
  }
  
  private MessageForPic a(FileMsg paramFileMsg, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    boolean bool = paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg;
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      localObject2 = (MessageForMixedMsg)paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = localIterator;
      if (MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder) != null)
      {
        localObject1 = localIterator;
        if (localObject2 != null)
        {
          localObject1 = localIterator;
          if (((MessageForMixedMsg)localObject2).msgElemList != null)
          {
            paramMixedHolder = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
            do
            {
              do
              {
                localObject1 = localIterator;
                if (!paramMixedHolder.hasNext()) {
                  break;
                }
                localObject1 = (MessageRecord)paramMixedHolder.next();
              } while ((localObject1 == null) || (((MessageRecord)localObject1).uniseq != paramFileMsg.uniseq) || (!(localObject1 instanceof MessageForPic)));
              localObject1 = (MessageForPic)localObject1;
            } while (((MessageForPic)localObject1).subMsgId != paramFileMsg.mSubMsgId);
            return localObject1;
          }
        }
      }
    }
    else
    {
      localObject1 = localIterator;
      if ((paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg))
      {
        paramMixedHolder = (MessageForLongMsg)paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject1 = localIterator;
        if (paramMixedHolder.longMsgFragmentList != null)
        {
          localObject1 = localIterator;
          if (!paramMixedHolder.longMsgFragmentList.isEmpty())
          {
            localIterator = paramMixedHolder.longMsgFragmentList.iterator();
            paramMixedHolder = (MixedMsgItemBuilder.MixedHolder)localObject2;
            for (;;)
            {
              localObject1 = paramMixedHolder;
              if (!localIterator.hasNext()) {
                break label353;
              }
              localObject1 = (MessageRecord)localIterator.next();
              if ((localObject1 != null) && (((MessageRecord)localObject1).uniseq == paramFileMsg.uniseq)) {
                if ((localObject1 instanceof MessageForPic))
                {
                  paramMixedHolder = (MessageForPic)localObject1;
                }
                else if ((localObject1 instanceof MessageForMixedMsg))
                {
                  localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
                  if (((Iterator)localObject2).hasNext())
                  {
                    localObject1 = (MessageRecord)((Iterator)localObject2).next();
                    if (!(localObject1 instanceof MessageForPic)) {
                      break;
                    }
                    localObject1 = (MessageForPic)localObject1;
                    if (((MessageForPic)localObject1).subMsgId != paramFileMsg.mSubMsgId) {
                      break;
                    }
                    paramMixedHolder = (MixedMsgItemBuilder.MixedHolder)localObject1;
                  }
                }
              }
            }
          }
        }
      }
    }
    label353:
    return localObject1;
  }
  
  private MessageRecord a(SpannableStringBuilder paramSpannableStringBuilder1, SpannableStringBuilder paramSpannableStringBuilder2)
  {
    MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
    if (paramSpannableStringBuilder1.length() > 0)
    {
      localMessageForText.sb = new SpannableStringBuilder(paramSpannableStringBuilder1);
      paramSpannableStringBuilder1.clear();
    }
    if (paramSpannableStringBuilder2.length() > 0)
    {
      localMessageForText.sb2 = new SpannableStringBuilder(paramSpannableStringBuilder2);
      paramSpannableStringBuilder2.clear();
    }
    return localMessageForText;
  }
  
  private CharSequence a(MessageRecord paramMessageRecord, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramCharSequence)) {
      return paramCharSequence;
    }
    String str;
    if ((paramCharSequence instanceof QQText)) {
      str = ((QQText)paramCharSequence).mSource;
    } else {
      str = paramCharSequence.toString();
    }
    int i = ChatTextSizeSettingActivity.a();
    if (paramBoolean)
    {
      if (str.startsWith("\n")) {
        return new QQText(str.substring(1), 13, i, paramMessageRecord);
      }
    }
    else if (str.endsWith("\n")) {
      paramCharSequence = new QQText(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
    }
    return paramCharSequence;
  }
  
  private HashMap<Integer, CharSequence> a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("formatTextMessRecordNewLineSymbol, size:");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("MixedMsgItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashMap(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForReplyText))
      {
        ((HashMap)localObject1).put(Integer.valueOf(i), ((MessageForReplyText)paramList.get(i)).sb);
      }
      else if ((paramList.get(i) instanceof MessageForText))
      {
        localObject2 = (MessageForText)paramList.get(i);
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
          ((HashMap)localObject1).put(Integer.valueOf(i), ((MessageForText)localObject2).sb2);
        } else {
          ((HashMap)localObject1).put(Integer.valueOf(i), ((MessageForText)localObject2).sb);
        }
      }
      else
      {
        ((HashMap)localObject1).put(Integer.valueOf(i), "");
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForPic)) {
        ((List)localObject2).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Integer)((Iterator)localObject2).next();
      i = ((Integer)localObject3).intValue() - 1;
      int j = ((Integer)localObject3).intValue() + 1;
      if ((i >= 0) && (i < ((HashMap)localObject1).size()))
      {
        localObject3 = (CharSequence)((HashMap)localObject1).get(Integer.valueOf(i));
        ((HashMap)localObject1).put(Integer.valueOf(i), a((MessageRecord)paramList.get(i), (CharSequence)localObject3, false));
      }
      if ((j >= 0) && (j < ((HashMap)localObject1).size()))
      {
        localObject3 = (CharSequence)((HashMap)localObject1).get(Integer.valueOf(j));
        ((HashMap)localObject1).put(Integer.valueOf(j), a((MessageRecord)paramList.get(j), (CharSequence)localObject3, true));
      }
    }
    return localObject1;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      if ((localObject1 instanceof MessageForText))
      {
        localObject1 = (MessageForText)localObject1;
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb)) {
          localSpannableStringBuilder1.append(((MessageForText)localObject1).sb);
        }
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject1).sb2);
        } else if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject1).sb);
        }
      }
      else if ((localObject1 instanceof MessageForPic))
      {
        localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
        localArrayList.add(localObject1);
      }
      else
      {
        Object localObject2;
        if ((localObject1 instanceof MessageForMixedMsg))
        {
          localObject1 = (MessageForMixedMsg)localObject1;
          localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if ((localObject3 instanceof MessageForPic))
            {
              MessageForPic localMessageForPic = (MessageForPic)localObject3;
              if (localMessageForPic.time == 0L) {
                MessageForMixedMsg.copyBaseInfoFromMixedToPic(localMessageForPic, (MessageForMixedMsg)localObject1);
              }
              localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
              localArrayList.add(localObject3);
            }
            else if ((localObject3 instanceof MessageForText))
            {
              localObject3 = (MessageForText)localObject3;
              if (!android.text.TextUtils.isEmpty(((MessageForText)localObject3).sb)) {
                localSpannableStringBuilder1.append(((MessageForText)localObject3).sb);
              }
              if (!android.text.TextUtils.isEmpty(((MessageForText)localObject3).sb2)) {
                localSpannableStringBuilder2.append(((MessageForText)localObject3).sb2);
              } else if (!android.text.TextUtils.isEmpty(((MessageForText)localObject3).sb)) {
                localSpannableStringBuilder2.append(((MessageForText)localObject3).sb);
              }
            }
            else
            {
              localArrayList.add(localObject3);
            }
          }
        }
        else if ((localObject1 instanceof MessageForReplyText))
        {
          localObject2 = (MessageForReplyText)localObject1;
          if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject2).sb))
          {
            localSpannableStringBuilder1.append(((MessageForReplyText)localObject2).sb);
            localSpannableStringBuilder2.append(((MessageForReplyText)localObject2).sb);
          }
          localArrayList.add(localObject1);
        }
      }
    }
    localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
    a(paramViewHolder, com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      String str = paramURLDrawable.getURL().toString();
      if (str == null) {
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(str))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
        ThreadManager.executeOnSubThread(new MixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
      }
    }
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder, String paramString)
  {
    if (paramViewHolder.jdField_b_of_type_JavaLangStringBuilder == null) {
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    if (e) {
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(paramString);
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 2);
    boolean bool = AIOSelectableDelegateImpl.a().c();
    int j = 1;
    int i = 1;
    Object localObject;
    if (bool)
    {
      localObject = AIOSelectableDelegateImpl.a().b();
      if ((localObject == null) || (((CharSequence)localObject).length() == AIOSelectableDelegateImpl.a().a())) {
        i = 0;
      }
      j = i;
      if (i == 0)
      {
        localObject = AIOSelectableDelegateImpl.a().c();
        j = i;
      }
    }
    else
    {
      localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
    }
    ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
    if (j != 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366309, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366308, paramChatMessage, null);
    }
  }
  
  private void a(ArrayList<SchoolTroopKeywordManager.KeywordResult> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return;
    }
    if (paramArrayList1.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayList1.size();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    int k;
    for (int j = -1; i < m; j = k)
    {
      TextView localTextView = (TextView)paramArrayList1.get(i);
      localObject2 = (SchoolTroopKeywordManager.KeywordResult)paramArrayList.get(i);
      if ((localObject2 != null) && (((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int != -1))
      {
        localStringBuilder.append(((SchoolTroopKeywordManager.KeywordResult)localObject2).b());
        if (i != m - 1) {
          localStringBuilder.append(" ");
        }
        if ((localObject1 == null) || (((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int < localObject1.jdField_b_of_type_Int))
        {
          j = i;
          localObject1 = localObject2;
        }
        localTextView.setTag(2131366954, "school_troop_span");
        localObject2 = localObject1;
        k = j;
      }
      else
      {
        localStringBuilder.append(localTextView.getText());
        localObject2 = localObject1;
        k = j;
        if (i != m - 1)
        {
          localStringBuilder.append(" ");
          k = j;
          localObject2 = localObject1;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      localObject2 = new SchoolTroopKeywordManager.KeywordResult();
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_Long = paramMessageRecord.uniseq;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_Int = localObject1.jdField_a_of_type_Int;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_a_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_JavaLangString = localObject1.jdField_b_of_type_JavaLangString;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_b_of_type_Int = localObject1.jdField_b_of_type_Int;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).a(localStringBuilder.toString());
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_c_of_type_Int = localObject1.jdField_c_of_type_Int;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).d = localObject1.d;
      ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SchoolTroopKeywordManager.KeywordResult)localObject2), ((SchoolTroopKeywordManager.KeywordResult)localObject2).jdField_c_of_type_Int, ((SchoolTroopKeywordManager.KeywordResult)localObject2).d, 17);
      if (QLog.isDevelopLevel()) {
        QLog.d("school_troop.MixedMsgItemBuilder", 2, new Object[] { "matchKeywordResults.size: ", Integer.valueOf(paramArrayList.size()), "; detect result: ", localObject2 });
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append(" updateSchoolTroopHighlight time cost: ");
      paramArrayList.append(System.currentTimeMillis() - l);
      QLog.i("school_troop.MixedMsgItemBuilder", 2, paramArrayList.toString());
    }
  }
  
  private boolean a(MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    return (paramMixedHolder.jdField_c_of_type_AndroidWidgetTextView != null) && (paramMixedHolder.jdField_b_of_type_AndroidWidgetTextView != null) && (paramMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    boolean bool = AIOSelectableDelegateImpl.a().c();
    int k = 1;
    int i;
    if (bool)
    {
      localObject1 = AIOSelectableDelegateImpl.a().b();
      if ((localObject1 != null) && (((String)localObject1).length() == AIOSelectableDelegateImpl.a().a())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        localObject1 = AIOSelectableDelegateImpl.a().c();
      }
    }
    else
    {
      localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
      i = 1;
    }
    Bundle localBundle = new Bundle();
    int j = k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null)
        {
          Object localObject2 = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (((String)localObject2).length() > 0)
            {
              localObject2 = ((String)localObject2).split("\\|");
              j = k;
              if (localObject2 != null)
              {
                j = k;
                if (localObject2.length > 0) {
                  try
                  {
                    j = Integer.parseInt(localObject2[0]);
                    if (QLog.isColorLevel())
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("get mixMsgForward switch From config : configSwitch = ");
                      ((StringBuilder)localObject2).append(j);
                      QLog.d("MixedMsgItemBuilder", 2, ((StringBuilder)localObject2).toString());
                    }
                    if (j == 1) {
                      j = k;
                    } else {
                      j = 0;
                    }
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    j = k;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
                      j = k;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((i != 0) && (j != 0))
    {
      localBundle.putInt("forward_type", -5);
      localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
      ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
    }
    else
    {
      localBundle.putInt("forward_type", -1);
    }
    localBundle.putString("forward_text", (String)localObject1);
    localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putInt("selection_mode", this.jdField_c_of_type_Int);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    if (i != 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int j;
    if (AIOSelectableDelegateImpl.a().c())
    {
      str = AIOSelectableDelegateImpl.a().b();
      int i;
      if ((str != null) && (str.length() == AIOSelectableDelegateImpl.a().a())) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (i == 0)
      {
        str = AIOSelectableDelegateImpl.a().c();
        j = i;
      }
    }
    else
    {
      str = null;
      j = 1;
    }
    if ((j == 0) && (str != null))
    {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
      QfavBuilder.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    else
    {
      QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
    }
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
    if (j != 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (localMixedHolder.jdField_b_of_type_JavaLangStringBuilder == null) {
      localMixedHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBubbleView: check is need refresh[");
      localStringBuilder.append(localMixedHolder.jdField_a_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.i("MixedMsgItemBuilder", 1, localStringBuilder.toString());
    }
    boolean bool = e;
    StringBuilder localStringBuilder = null;
    Object localObject = null;
    if ((!bool) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) != null) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) == paramChatMessage.uniseq) && (!localMixedHolder.jdField_a_of_type_Boolean) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } else {
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      }
      localMixedHolder.jdField_c_of_type_AndroidViewView = super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramBaseChatItemLayout = localMixedHolder.jdField_c_of_type_AndroidViewView;
      paramChatMessage = localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      TroopEssenceReportUtil.a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage);
      return paramView;
    }
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramOnLongClickAndTouchListener, localMixedHolder);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramViewHolder, this);
    }
    if (paramViewHolder != null) {
      paramViewHolder.setTag(localMixedHolder);
    }
    if (localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) {
      localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramChatMessage);
    }
    localMixedHolder.jdField_c_of_type_AndroidViewView = super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
    super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatItemLayout = localMixedHolder.jdField_c_of_type_AndroidViewView;
    paramChatMessage = localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691246));
    boolean bool = paramChatMessage instanceof MessageForMixedMsg;
    int i = 0;
    if (bool ? !((MessageForMixedMsg)paramChatMessage).canSelectable() : (!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
      i = 1;
    }
    if (i != 0) {
      paramQQCustomMenu.a(2131365311, this.jdField_a_of_type_AndroidContentContext.getString(2131718152), 2130838905);
    }
    paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    if (AIOUtils.a(5) == 1) {
      paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    return paramQQCustomMenu;
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageRecord paramMessageRecord)
  {
    Object localObject1 = paramOnLongClickAndTouchListener;
    Object localObject2 = paramMessageRecord;
    ArrayList localArrayList1 = new ArrayList(paramList);
    if (paramMixedMsgLinearLayout == null)
    {
      paramMixedMsgLinearLayout = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramMixedMsgLinearLayout.setId(2131364521);
      paramMixedMsgLinearLayout.setOrientation(1);
      paramMixedMsgLinearLayout.setFocusable(false);
      paramMixedMsgLinearLayout.setClickable(true);
      paramMixedMsgLinearLayout.setMinimumHeight(AIOUtils.b(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramMixedMsgLinearLayout.setPadding(2131296380, 2131296382, 2131296379, 2131296381);
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.addRule(1, 2131368343);
      paramList.addRule(3, 2131378476);
      paramList.leftMargin = AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.rightMargin = AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.setLayoutParams(paramList);
      paramMixedMsgLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      paramList = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
      MixedMsgItemBuilder.MixedHolder.a(paramList, paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
      paramList.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    Object localObject3 = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    ((MixedMsgItemBuilder.MixedHolder)localObject3).e = -1;
    ((MixedMsgItemBuilder.MixedHolder)localObject3).jdField_a_of_type_Boolean = false;
    paramMixedMsgLinearLayout.a(localArrayList1, (MixedMsgItemBuilder.MixedHolder)localObject3);
    paramViewHolder = null;
    if (SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      paramViewHolder = (SchoolTroopKeywordManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER);
    }
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = a(localArrayList1);
    int i = localArrayList1.size();
    int j = 0;
    paramList = paramViewHolder;
    paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject2;
    localObject2 = localObject1;
    localObject1 = localObject3;
    while (j < i)
    {
      Object localObject4 = (MessageRecord)localArrayList1.get(j);
      localObject3 = paramMixedMsgLinearLayout.getChildAt(j);
      if (localObject3 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getMixedMsgLayout,child is null. size = ");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",i = ");
          ((StringBuilder)localObject3).append(j);
          QLog.e("MixedMsgItemBuilder", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        Object localObject5;
        Object localObject6;
        if ((localObject4 instanceof MessageForReplyText)) {
          if ((localObject3 instanceof LinearLayout))
          {
            localObject5 = (LinearLayout)localObject3;
            paramViewHolder = (ViewGroup)((LinearLayout)localObject5).getChildAt(0);
            localObject5 = (TextView)((LinearLayout)localObject5).getChildAt(1);
            localObject6 = (MessageForReplyText)localObject4;
            paramViewHolder.setId(2131364549);
            paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramViewHolder.setOnTouchListener((View.OnTouchListener)localObject2);
            paramViewHolder.setOnLongClickListener((View.OnLongClickListener)localObject2);
            paramViewHolder.findViewById(2131371529).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramViewHolder.findViewById(2131369413).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramViewHolder.findViewById(2131378668).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject6).sb))
            {
              ((TextView)localObject5).setText(((MessageForReplyText)localObject6).sb);
              ((TextView)localObject5).setVisibility(0);
            }
            else
            {
              ((TextView)localObject5).setVisibility(8);
            }
            if (paramList != null)
            {
              localArrayList3.add(paramList.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject4));
              localArrayList2.add(localObject5);
            }
            ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewHolder, ((MessageForReplyText)localObject6).mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject6).istroop, (MessageRecord)localObject6, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            paramViewHolder = paramViewHolder.findViewById(2131378668);
            if (paramViewHolder != null)
            {
              paramViewHolder = paramViewHolder.getTag(2131364536);
              if ((paramViewHolder != null) && ((paramViewHolder instanceof Boolean)))
              {
                bool = ((Boolean)paramViewHolder).booleanValue();
                ((MixedMsgItemBuilder.MixedHolder)localObject1).jdField_a_of_type_Boolean = bool;
                break label694;
              }
            }
            boolean bool = false;
            label694:
            if (QLog.isColorLevel())
            {
              paramViewHolder = new StringBuilder();
              paramViewHolder.append("getMixedMsgLayout: reply check is need refresh[");
              paramViewHolder.append(bool);
              paramViewHolder.append("]");
              QLog.i("MixedMsgItemBuilder", 1, paramViewHolder.toString());
            }
          }
        }
        for (;;)
        {
          break;
          if ((localObject4 instanceof MessageForText))
          {
            paramViewHolder = (AnimationTextView)localObject3;
            paramViewHolder.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
            com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramViewHolder);
            paramViewHolder.setText((CharSequence)localHashMap.get(Integer.valueOf(j)));
            if (paramList != null)
            {
              localArrayList3.add(paramList.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject4));
              localArrayList2.add(paramViewHolder);
            }
            if (((ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).hasRobotNewsClassId(paramMessageRecord)) {
              TroopRobotManager.a(paramViewHolder, (MessageRecord)localObject4);
            }
          }
          else if ((localObject4 instanceof MessageForPic))
          {
            paramViewHolder = (MessageForPic)localObject4;
            localObject2 = (ChatThumbView)localObject3;
            localObject5 = new int[2];
            Object tmp890_888 = localObject5;
            tmp890_888[0] = 0;
            Object tmp894_890 = tmp890_888;
            tmp894_890[1] = 0;
            tmp894_890;
            localObject4 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramViewHolder, (ChatThumbView)localObject2, (int[])localObject5);
            ((ChatThumbView)localObject2).setTag(2131364535, paramViewHolder);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramViewHolder)));
            ((ChatThumbView)localObject2).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramViewHolder)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            localObject6 = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = URLDrawableHelper.getURL(paramViewHolder, 65537);
            if (PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramViewHolder.imageType), ((String)localObject6).equals("chatthumb"), localObject5[0], localObject5[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
              ((URLDrawable)localObject4).setWatermarkVisibility(0);
            }
            else
            {
              ((URLDrawable)localObject4).setWatermarkVisibility(4);
            }
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("getMixedMsgLayout,set picmsg, picDrawable ");
              ((StringBuilder)localObject5).append(localObject4);
              ((StringBuilder)localObject5).append(",picMsg = ");
              ((StringBuilder)localObject5).append(paramViewHolder);
              QLog.d("MixedMsgItemBuilder", 2, ((StringBuilder)localObject5).toString());
            }
            ((ChatThumbView)localObject2).setOnClickListener(this.b);
            a((URLDrawable)localObject4);
            if (!paramViewHolder.isSendFromLocal()) {
              ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramViewHolder, 2);
            }
          }
          else if (QLog.isColorLevel())
          {
            paramViewHolder = new StringBuilder();
            paramViewHolder.append("mixed type not support yet.");
            paramViewHolder.append(localObject4.getClass().getSimpleName());
            QLog.e("MixedMsgItemBuilder", 2, paramViewHolder.toString());
          }
        }
        paramViewHolder = paramMessageRecord;
        localObject2 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.m;
        if (j == i - 1) {
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = BaseChatItemLayout.m;
        } else {
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
        }
        localObject2 = paramOnLongClickAndTouchListener;
        ((View)localObject3).setOnTouchListener((View.OnTouchListener)localObject2);
        ((View)localObject3).setOnLongClickListener((View.OnLongClickListener)localObject2);
      }
      j += 1;
    }
    a(localArrayList3, localArrayList2, paramViewHolder);
    paramMixedMsgLinearLayout.setOnTouchListener((View.OnTouchListener)localObject2);
    paramMixedMsgLinearLayout.setOnLongClickListener((View.OnLongClickListener)localObject2);
    paramMixedMsgLinearLayout.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return paramMixedMsgLinearLayout;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str2 = "";
    String str1 = str2;
    if (localQQAppInterface != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (android.text.TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131377136: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131376417: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131371603: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131371562: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131367180: 
      b(paramChatMessage, str1);
      return;
    case 2131366494: 
      c(paramChatMessage, str1);
      return;
    case 2131365480: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
      return;
    }
    a(paramChatMessage, str1);
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
        localActionSheet.addButton(2131689933, 5);
        localActionSheet.addCancelButton(2131690728);
        localActionSheet.setOnButtonClickListener(new MixedMsgItemBuilder.4(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = paramView.getBackground();
    if (paramView != null)
    {
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)paramView.getTag();
    int i = BaseChatItemLayout.h;
    if (paramChatMessage.isSend())
    {
      MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(TextItemBuilder.f, i, TextItemBuilder.e, TextItemBuilder.d);
      return;
    }
    MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(TextItemBuilder.e, i, TextItemBuilder.f, TextItemBuilder.d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject).getBackground();
    if (localObject != null)
    {
      if (paramBoolean) {
        paramView = null;
      } else {
        paramView = jdField_a_of_type_AndroidGraphicsColorFilter;
      }
      ((Drawable)localObject).setColorFilter(paramView);
      ((Drawable)localObject).invalidateSelf();
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((localMixedHolder.e != -1) && (a(localMixedHolder)))
    {
      localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()) && (!SimpleUIUtil.a()))
      {
        if (paramBubbleInfo.jdField_b_of_type_Int == 0)
        {
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        }
        else
        {
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        }
        if (paramBubbleInfo.jdField_c_of_type_Int == 0)
        {
          paramViewHolder = paramView.getResources().getColorStateList(2131167077);
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        }
        else
        {
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
        }
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
      }
      paramView = paramView.getResources();
      if (paramChatMessage.isSend()) {
        paramViewHolder = paramView.getColorStateList(2131167079);
      } else {
        paramViewHolder = paramView.getColorStateList(2131167075);
      }
      localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
      localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
      localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
      localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
      localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
      if (paramChatMessage.isSend()) {
        paramViewHolder = paramView.getColorStateList(2131167078);
      } else {
        paramViewHolder = paramView.getColorStateList(2131167077);
      }
      localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
      localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
      return;
    }
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()) && (!SimpleUIUtil.a()))
    {
      paramViewHolder = ColorStateList.valueOf(-16777216);
      paramView = paramView.getResources().getColorStateList(2131167077);
      if (paramBubbleInfo.jdField_b_of_type_Int != 0) {
        paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.jdField_b_of_type_Int);
      }
      if (paramBubbleInfo.jdField_c_of_type_Int != 0) {
        paramView = ColorStateList.valueOf(paramBubbleInfo.jdField_c_of_type_Int);
      }
      MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
      return;
    }
    paramView = paramView.getResources();
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramView.getColorStateList(2131167079);
    } else {
      paramViewHolder = paramView.getColorStateList(2131167075);
    }
    if (paramChatMessage.isSend()) {
      paramView = paramView.getColorStateList(2131167078);
    } else {
      paramView = paramView.getColorStateList(2131167077);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    paramViewHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (MixedMsgItemBuilder.MixedHolder.a(paramViewHolder) != null) {
      MixedMsgItemBuilder.MixedHolder.a(paramViewHolder).a(VasShieldFont.a(paramChatMessage));
    }
    if ((paramViewHolder.e != -1) && (a(paramViewHolder)))
    {
      paramChatMessage = VasShieldFont.a("");
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramChatMessage);
      paramViewHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
      paramViewHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTypeface(paramChatMessage);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = paramChatMessage.isSendFromLocal();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramChatMessage.extraflag == 32768) {
      bool1 = true;
    }
    return bool1;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    ChatMessage localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (localChatMessage != null) {
      if (localChatMessage.isMultiMsg) {
        a(localQQCustomMenu, localChatMessage, null);
      } else {
        b(localQQCustomMenu, localChatMessage, paramView);
      }
    }
    return localQQCustomMenu.a();
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691246));
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {}
    }
    else {
      while (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable()))
      {
        i = 0;
        break;
      }
    }
    int i = 1;
    if (i != 0) {
      paramQQCustomMenu.a(2131365311, this.jdField_a_of_type_AndroidContentContext.getString(2131718152), 2130838905);
    }
    paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramChatMessage, null);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramBaseHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramBaseHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
    if (AIOUtils.a(5) == 1) {
      paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", false);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramChatMessage, paramBaseHolder);
    a(paramQQCustomMenu, paramChatMessage);
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramChatMessage, null);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramQQCustomMenu;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {
      return;
    }
    Object localObject1 = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = a(paramFileMsg, (MixedMsgItemBuilder.MixedHolder)localObject1);
    if (localMessageForPic != null)
    {
      paramFileMsg = null;
      paramInt2 = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildCount();
      paramInt1 = 0;
      Object localObject2;
      for (;;)
      {
        paramView = paramFileMsg;
        if (paramInt1 >= paramInt2) {
          break;
        }
        paramView = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildAt(paramInt1);
        if ((paramView instanceof ChatThumbView))
        {
          paramView = (ChatThumbView)paramView;
          localObject2 = paramView.getTag(2131364535);
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            if ((((MessageForPic)localObject2).uniseq == localMessageForPic.uniseq) && (((MessageForPic)localObject2).subMsgId == localMessageForPic.subMsgId)) {
              break;
            }
          }
        }
        paramInt1 += 1;
      }
      if (paramView != null)
      {
        paramFileMsg = new int[2];
        FileMsg tmp145_144 = paramFileMsg;
        tmp145_144[0] = 0;
        FileMsg tmp149_145 = tmp145_144;
        tmp149_145[1] = 0;
        tmp149_145;
        localObject1 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, paramView, paramFileMsg);
        localObject2 = ((URLDrawable)localObject1).getURL().getProtocol();
        URL localURL = URLDrawableHelper.getURL(localMessageForPic, 65537);
        boolean bool = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(localMessageForPic.imageType), ((String)localObject2).equals("chatthumb"), paramFileMsg[0], paramFileMsg[1], localURL);
        paramView.setImageDrawable((Drawable)localObject1);
        if (bool)
        {
          ((URLDrawable)localObject1).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((URLDrawable)localObject1).setWatermarkVisibility(0);
          return;
        }
        ((URLDrawable)localObject1).setWatermarkVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */