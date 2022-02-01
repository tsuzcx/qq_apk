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
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
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
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
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
import cooperation.peak.PeakUtils;
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
  implements BaseBubbleBuilder.TouchDelegate, ContextMenuBuilder2, FileTransferManager.Callback
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new MixedMsgItemBuilder.3(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private View.OnClickListener b;
  protected long c = 0L;
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new MixedMsgItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ReplyItemClickListener(this);
  }
  
  private View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (MessageRecordInfo.a(paramChatMessage.issend))
      {
        localObject1 = "发出";
        a(paramViewHolder, (String)localObject1);
        localObject1 = (MessageForMixedMsg)paramChatMessage;
        localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label164;
        }
        Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          a(paramViewHolder, "图片");
          localObject3 = (MessageForPic)localObject3;
          if (((MessageForPic)localObject3).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject3, (MessageForMixedMsg)localObject1);
          continue;
          localObject1 = "发来";
          break;
        }
        if ((localObject3 instanceof MessageForReplyText))
        {
          if (((MessageForReplyText)localObject3).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToNormal((MessageRecord)localObject3, (MessageForMixedMsg)localObject1);
          }
        }
        else {
          a(paramViewHolder, com.tencent.mobileqq.text.TextUtils.emoticonToText(((MessageRecord)localObject3).msg));
        }
      }
      label164:
      paramViewHolder = a(paramViewHolder, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramOnLongClickAndTouchListener, (MessageRecord)localObject1);
      MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder, paramChatMessage.uniseq);
      localObject1 = paramViewHolder;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramView = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        paramMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        localObject1 = paramViewHolder;
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramView;
        } while (!(paramChatMessage instanceof MessageForLongMsg));
        localObject2 = (MessageForLongMsg)paramChatMessage;
        a(paramViewHolder, "说");
        localObject1 = paramView;
      } while (((MessageForLongMsg)localObject2).longMsgFragmentList == null);
      localObject1 = paramView;
    } while (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty());
    Object localObject1 = a(((MessageForLongMsg)localObject2).longMsgFragmentList, paramMixedHolder);
    paramViewHolder = a(paramViewHolder, (MixedMsgLinearLayout)paramView, (List)localObject1, paramOnLongClickAndTouchListener, paramChatMessage);
    MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder, paramChatMessage.uniseq);
    return paramViewHolder;
  }
  
  private MessageForPic a(FileMsg paramFileMsg, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    MessageRecord localMessageRecord = null;
    Iterator localIterator = null;
    Object localObject;
    if ((paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      localObject = (MessageForMixedMsg)paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((MixedMsgItemBuilder.MixedHolder.a(paramMixedHolder) == null) || (localObject == null) || (((MessageForMixedMsg)localObject).msgElemList == null)) {
        break label310;
      }
      paramMixedHolder = ((MessageForMixedMsg)localObject).msgElemList.iterator();
      do
      {
        if (!paramMixedHolder.hasNext()) {
          break;
        }
        localObject = (MessageRecord)paramMixedHolder.next();
      } while ((localObject == null) || (((MessageRecord)localObject).uniseq != paramFileMsg.uniseq) || (!(localObject instanceof MessageForPic)) || (((MessageForPic)localObject).subMsgId != paramFileMsg.mSubMsgId));
    }
    label310:
    for (paramFileMsg = (MessageForPic)localObject;; paramFileMsg = null)
    {
      localObject = paramFileMsg;
      do
      {
        do
        {
          do
          {
            return localObject;
            localObject = localIterator;
          } while (!(paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLongMsg));
          paramMixedHolder = (MessageForLongMsg)paramMixedHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = localIterator;
        } while (paramMixedHolder.longMsgFragmentList == null);
        localObject = localIterator;
      } while (paramMixedHolder.longMsgFragmentList.isEmpty());
      localIterator = paramMixedHolder.longMsgFragmentList.iterator();
      paramMixedHolder = localMessageRecord;
      do
      {
        localObject = paramMixedHolder;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MessageRecord)localIterator.next();
      } while (localObject == null);
      if (((MessageRecord)localObject).uniseq == paramFileMsg.uniseq) {
        if ((localObject instanceof MessageForPic)) {
          paramMixedHolder = (MessageForPic)localObject;
        }
      }
      for (;;)
      {
        break;
        if ((localObject instanceof MessageForMixedMsg))
        {
          localObject = ((MessageForMixedMsg)localObject).msgElemList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (((localMessageRecord instanceof MessageForPic)) && (((MessageForPic)localMessageRecord).subMsgId == paramFileMsg.mSubMsgId))
              {
                paramMixedHolder = (MessageForPic)localMessageRecord;
                break;
              }
            }
          }
        }
      }
    }
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
    if (android.text.TextUtils.isEmpty(paramCharSequence)) {}
    String str;
    int i;
    label74:
    do
    {
      return paramCharSequence;
      if ((paramCharSequence instanceof QQText)) {}
      for (str = ((QQText)paramCharSequence).mSource;; str = paramCharSequence.toString())
      {
        i = ChatTextSizeSettingActivity.a();
        if (!paramBoolean) {
          break label74;
        }
        if (!str.startsWith("\n")) {
          break;
        }
        return new QQText(str.substring(1), 13, i, paramMessageRecord);
      }
    } while (!str.endsWith("\n"));
    return new QQText(str.substring(0, str.length() - 1), 13, i, paramMessageRecord);
  }
  
  private HashMap<Integer, CharSequence> a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgItemBuilder", 2, "formatTextMessRecordNewLineSymbol, size:" + paramList.size());
    }
    HashMap localHashMap = new HashMap(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForReplyText)) {
        localHashMap.put(Integer.valueOf(i), ((MessageForReplyText)paramList.get(i)).sb);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramList.get(i) instanceof MessageForText))
        {
          localObject1 = (MessageForText)paramList.get(i);
          if (!android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb2)) {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb2);
          } else {
            localHashMap.put(Integer.valueOf(i), ((MessageForText)localObject1).sb);
          }
        }
        else
        {
          localHashMap.put(Integer.valueOf(i), "");
        }
      }
    }
    Object localObject1 = new ArrayList();
    i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) instanceof MessageForPic)) {
        ((List)localObject1).add(Integer.valueOf(i));
      }
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      i = ((Integer)localObject2).intValue() - 1;
      int j = ((Integer)localObject2).intValue() + 1;
      if ((i >= 0) && (i < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(i));
        localHashMap.put(Integer.valueOf(i), a((MessageRecord)paramList.get(i), (CharSequence)localObject2, false));
      }
      if ((j >= 0) && (j < localHashMap.size()))
      {
        localObject2 = (CharSequence)localHashMap.get(Integer.valueOf(j));
        localHashMap.put(Integer.valueOf(j), a((MessageRecord)paramList.get(j), (CharSequence)localObject2, true));
      }
    }
    return localHashMap;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForText))
      {
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder1.append(((MessageForText)localObject).sb);
        }
        if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb2);
        } else if (!android.text.TextUtils.isEmpty(((MessageForText)localObject).sb)) {
          localSpannableStringBuilder2.append(((MessageForText)localObject).sb);
        }
      }
      else if ((localObject instanceof MessageForPic))
      {
        localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
        localArrayList.add(localObject);
      }
      else if ((localObject instanceof MessageForMixedMsg))
      {
        localObject = (MessageForMixedMsg)localObject;
        Iterator localIterator = ((MessageForMixedMsg)localObject).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject);
            }
            localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
            localArrayList.add(localMessageRecord);
          }
          else if ((localMessageRecord instanceof MessageForText))
          {
            if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder1.append(((MessageForText)localMessageRecord).sb);
            }
            if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb2)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb2);
            } else if (!android.text.TextUtils.isEmpty(((MessageForText)localMessageRecord).sb)) {
              localSpannableStringBuilder2.append(((MessageForText)localMessageRecord).sb);
            }
          }
          else
          {
            localArrayList.add(localMessageRecord);
          }
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject).sb))
        {
          localSpannableStringBuilder1.append(((MessageForReplyText)localObject).sb);
          localSpannableStringBuilder2.append(((MessageForReplyText)localObject).sb);
        }
        localArrayList.add(localObject);
      }
    }
    localArrayList.add(a(localSpannableStringBuilder1, localSpannableStringBuilder2));
    a(paramViewHolder, com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(localSpannableStringBuilder1.toString()));
    return localArrayList;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    String str;
    if (paramURLDrawable.getStatus() != 1)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      str = paramURLDrawable.getURL().toString();
      if (str != null) {
        break label39;
      }
    }
    label39:
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(str)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(str);
    ThreadManager.executeOnSubThread(new MixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
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
    Object localObject;
    int i;
    if (AIOSelectableDelegateImpl.a().c())
    {
      localObject = AIOSelectableDelegateImpl.a().b();
      if (localObject != null) {
        if (((CharSequence)localObject).length() != AIOSelectableDelegateImpl.a().a())
        {
          i = 1;
          if (i != 0) {
            break label255;
          }
          localObject = AIOSelectableDelegateImpl.a().c();
        }
      }
    }
    label61:
    label255:
    for (;;)
    {
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText((CharSequence)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
      if (i != 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
        i = 1;
        break label61;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
      }
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366428, paramChatMessage, null);
    }
    while (i != 1) {
      return;
    }
    a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366427, paramChatMessage, null);
  }
  
  private void a(ArrayList<SchoolTroopKeywordManager.KeywordResult> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      break label14;
    }
    label14:
    while (paramArrayList1.isEmpty()) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    int j = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int m = paramArrayList1.size();
    TextView localTextView;
    Object localObject2;
    int k;
    for (;;)
    {
      if (i < m)
      {
        localTextView = (TextView)paramArrayList1.get(i);
        localObject2 = (SchoolTroopKeywordManager.KeywordResult)paramArrayList.get(i);
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
          label139:
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
      localTextView.setTag(2131367117, "school_troop_span");
      k = j;
      localObject2 = localObject1;
      break label139;
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
          ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (SchoolTroopKeywordManager.KeywordResult)localObject2), ((SchoolTroopKeywordManager.KeywordResult)localObject2).c, ((SchoolTroopKeywordManager.KeywordResult)localObject2).d, 17);
          if (QLog.isDevelopLevel()) {
            QLog.d("school_troop.MixedMsgItemBuilder", 2, new Object[] { "matchKeywordResults.size: ", Integer.valueOf(paramArrayList.size()), "; detect result: ", localObject2 });
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
  
  private boolean a(MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    return (paramMixedHolder.jdField_c_of_type_AndroidWidgetTextView != null) && (paramMixedHolder.jdField_b_of_type_AndroidWidgetTextView != null) && (paramMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 3);
    Object localObject1;
    int i;
    if (AIOSelectableDelegateImpl.a().c())
    {
      localObject1 = AIOSelectableDelegateImpl.a().b();
      if (localObject1 != null) {
        if (((String)localObject1).length() == AIOSelectableDelegateImpl.a().a())
        {
          i = 1;
          if (i != 0) {
            break label588;
          }
          localObject1 = AIOSelectableDelegateImpl.a().c();
        }
      }
    }
    label59:
    label588:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext() != null))
      {
        localObject2 = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localObject2 = ((String)localObject2).split("\\|");
          if ((localObject2 == null) || (localObject2.length <= 0)) {}
        }
      }
      for (;;)
      {
        try
        {
          int j = Integer.parseInt(localObject2[0]);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgItemBuilder", 2, "get mixMsgForward switch From config : configSwitch = " + j);
          }
          if (j == 1)
          {
            j = 1;
            if ((i == 0) || (j == 0)) {
              break label539;
            }
            localBundle.putInt("forward_type", -5);
            localBundle.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
            ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
            localBundle.putString("forward_text", (String)localObject1);
            localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(localBundle);
            ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
            if (i == 0) {
              break label551;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
            if (paramChatMessage.isMultiMsg) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
            }
            return;
            i = 0;
            break;
            i = 0;
            break;
            localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
            i = 1;
            break label59;
          }
          j = 0;
          continue;
          j = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MixedMsgItemBuilder", 2, "get mixMsgForward switch from config error", localNumberFormatException);
          }
        }
        continue;
        localBundle.putInt("forward_type", -1);
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, 4);
    String str;
    int i;
    if (AIOSelectableDelegateImpl.a().c())
    {
      str = AIOSelectableDelegateImpl.a().b();
      if (str != null) {
        if (str.length() == AIOSelectableDelegateImpl.a().a())
        {
          i = 1;
          if (i != 0) {
            break label308;
          }
          str = AIOSelectableDelegateImpl.a().c();
        }
      }
    }
    label271:
    label308:
    for (;;)
    {
      label59:
      if ((i != 0) || (str == null))
      {
        QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, 0, paramChatMessage.istroop);
        label111:
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
        if (i == 0) {
          break label271;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
      }
      for (;;)
      {
        if (paramChatMessage.isMultiMsg) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
        }
        return;
        i = 0;
        break;
        i = 0;
        break;
        str = null;
        i = 1;
        break label59;
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0, paramChatMessage.istroop);
        QfavBuilder.a(null, str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        break label111;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (localMixedHolder.jdField_b_of_type_JavaLangStringBuilder == null) {
      localMixedHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("MixedMsgItemBuilder", 1, "getBubbleView: check is need refresh[" + localMixedHolder.jdField_a_of_type_Boolean + "]");
    }
    if ((!e) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) != null) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) == paramChatMessage.uniseq) && (!localMixedHolder.jdField_a_of_type_Boolean) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))) {
      if (localTroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
      {
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        paramViewHolder = paramView;
        if (localMixedHolder != null)
        {
          paramViewHolder = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localMixedHolder.jdField_c_of_type_AndroidViewView = super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
            super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
            paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramBaseChatItemLayout = localMixedHolder.jdField_c_of_type_AndroidViewView;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
              break label284;
            }
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            label252:
            TroopEssenceReportUtil.a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage);
            paramViewHolder = paramView;
          }
        }
      }
    }
    label284:
    do
    {
      do
      {
        return paramViewHolder;
        localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setRobotNextTipsView(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        break;
        paramChatMessage = null;
        break label252;
        paramView = a(paramChatMessage, paramViewHolder, paramView, paramOnLongClickAndTouchListener, localMixedHolder);
        paramViewHolder = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramViewHolder != null) {
          paramViewHolder.a(paramView, this);
        }
        if (paramView != null) {
          paramView.setTag(localMixedHolder);
        }
        if (localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null) {
          localMixedHolder.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.b(paramChatMessage);
        }
        paramViewHolder = paramView;
      } while (localMixedHolder == null);
      paramViewHolder = paramView;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    localMixedHolder.jdField_c_of_type_AndroidViewView = super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
    super.a(localMixedHolder.jdField_c_of_type_AndroidViewView, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramBaseChatItemLayout = localMixedHolder.jdField_c_of_type_AndroidViewView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {}
    for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; paramChatMessage = null)
    {
      TroopEssenceReportUtil.a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage);
      return paramView;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    int i = 0;
    paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691325));
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label126;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131718487), 2130839052);
      }
      paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      if (AIOUtils.a(5) == 1) {
        paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      }
      return paramQQCustomMenu;
      if ((!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
        label126:
        i = 1;
      }
    }
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List<MessageRecord> paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList1 = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131364634);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131296401, 2131296403, 2131296400, 2131296402);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131368603);
      paramMixedMsgLinearLayout.addRule(3, 2131379106);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramList);
      ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
      ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramList);
      ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
    }
    ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).e = -1;
    ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).jdField_a_of_type_Boolean = false;
    paramList.a(localArrayList1, (MixedMsgItemBuilder.MixedHolder)paramViewHolder);
    if (SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (paramMixedMsgLinearLayout = (SchoolTroopKeywordManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER);; paramMixedMsgLinearLayout = null)
    {
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      HashMap localHashMap = a(localArrayList1);
      int j = localArrayList1.size();
      int i = 0;
      Object localObject1;
      View localView;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      label545:
      boolean bool;
      for (;;)
      {
        if (i < j)
        {
          localObject1 = (MessageRecord)localArrayList1.get(i);
          localView = paramList.getChildAt(i);
          if (localView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MixedMsgItemBuilder", 2, "getMixedMsgLayout,child is null. size = " + j + ",i = " + i);
            }
            i += 1;
          }
          else if ((localObject1 instanceof MessageForReplyText))
          {
            if ((localView instanceof LinearLayout))
            {
              localObject3 = (LinearLayout)localView;
              localObject2 = (ViewGroup)((LinearLayout)localObject3).getChildAt(0);
              localObject4 = (TextView)((LinearLayout)localObject3).getChildAt(1);
              localObject3 = (MessageForReplyText)localObject1;
              ((ViewGroup)localObject2).setId(2131364662);
              ((ViewGroup)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
              ((ViewGroup)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
              ((ViewGroup)localObject2).findViewById(2131371908).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131369714).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ViewGroup)localObject2).findViewById(2131379316).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              if (android.text.TextUtils.isEmpty(((MessageForReplyText)localObject3).sb)) {
                break label769;
              }
              ((TextView)localObject4).setText(((MessageForReplyText)localObject3).sb);
              ((TextView)localObject4).setVisibility(0);
              if (paramMixedMsgLinearLayout != null)
              {
                localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
                localArrayList3.add(localObject4);
              }
              localObject1 = (MessageForReplyText)localObject1;
              ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ViewGroup)localObject2, ((MessageForReplyText)localObject3).mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject3).istroop, (MessageRecord)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              localObject1 = ((ViewGroup)localObject2).findViewById(2131379316);
              if (localObject1 == null) {
                break label1253;
              }
              localObject1 = ((View)localObject1).getTag(2131364649);
              if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
                break label1253;
              }
              bool = ((Boolean)localObject1).booleanValue();
              ((MixedMsgItemBuilder.MixedHolder)paramViewHolder).jdField_a_of_type_Boolean = bool;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MixedMsgItemBuilder", 1, "getMixedMsgLayout: reply check is need refresh[" + bool + "]");
        }
        label717:
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = BaseChatItemLayout.m;
        if (i == j - 1) {}
        for (((LinearLayout.LayoutParams)localObject1).bottomMargin = BaseChatItemLayout.m;; ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0)
        {
          localView.setOnTouchListener(paramOnLongClickAndTouchListener);
          localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          label769:
          ((TextView)localObject4).setVisibility(8);
          break label545;
          if ((localObject1 instanceof MessageForText))
          {
            localObject2 = (AnimationTextView)localView;
            ((AnimationTextView)localObject2).setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
            com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10((TextView)localObject2);
            ((AnimationTextView)localObject2).setText((CharSequence)localHashMap.get(Integer.valueOf(i)));
            if (paramMixedMsgLinearLayout != null)
            {
              localArrayList2.add(paramMixedMsgLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1));
              localArrayList3.add(localObject2);
            }
            if (!TroopRobotManager.b(paramMessageRecord)) {
              break label717;
            }
            TroopRobotManager.a((TextView)localObject2, (MessageRecord)localObject1);
            break label717;
          }
          if ((localObject1 instanceof MessageForPic))
          {
            localObject1 = (MessageForPic)localObject1;
            localObject2 = (ChatThumbView)localView;
            localObject3 = new int[2];
            Object tmp907_905 = localObject3;
            tmp907_905[0] = 0;
            Object tmp911_907 = tmp907_905;
            tmp911_907[1] = 0;
            tmp911_907;
            localObject4 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject1, (ChatThumbView)localObject2, (int[])localObject3);
            ((ChatThumbView)localObject2).setTag(2131364648, localObject1);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(PicItemBuilder.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(PicItemBuilder.a((MessageForPic)localObject1)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            String str = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = URLDrawableHelper.getURL((PicUiInterface)localObject1, 65537);
            if (PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(((MessageForPic)localObject1).imageType), str.equals("chatthumb"), localObject3[0], localObject3[1], localURL))
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a((MessageForPic)localObject1, 2);
              break;
              ((URLDrawable)localObject4).setWatermarkVisibility(4);
            }
          }
          if (!QLog.isColorLevel()) {
            break label717;
          }
          QLog.e("MixedMsgItemBuilder", 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label717;
        }
        a(localArrayList2, localArrayList3, paramMessageRecord);
        paramList.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramList.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramList.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
        return paramList;
        label1253:
        bool = false;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (!android.text.TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = "";; str1 = "") {
      switch (paramInt)
      {
      default: 
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
    return;
    super.a(paramInt, paramContext, paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
    return;
    a(paramChatMessage, str1);
    return;
    b(paramChatMessage, str1);
    return;
    c(paramChatMessage, str1);
    return;
    super.a(paramInt, paramContext, paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
    return;
    AIOSelectableDelegateImpl.a().a(paramChatMessage);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.addButton(2131690018, 5);
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new MixedMsgItemBuilder.4(this, paramView, localActionSheet));
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
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
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label275:
    for (;;)
    {
      return;
      paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
      paramFileMsg = a(paramFileMsg, paramView);
      if (paramFileMsg != null)
      {
        paramInt2 = MixedMsgItemBuilder.MixedHolder.a(paramView).getChildCount();
        paramInt1 = 0;
        Object localObject1;
        Object localObject2;
        if (paramInt1 < paramInt2)
        {
          localObject1 = MixedMsgItemBuilder.MixedHolder.a(paramView).getChildAt(paramInt1);
          if ((localObject1 instanceof ChatThumbView))
          {
            localObject2 = ((ChatThumbView)localObject1).getTag(2131364648);
            if ((!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).uniseq != paramFileMsg.uniseq) || (((MessageForPic)localObject2).subMsgId != paramFileMsg.subMsgId)) {}
          }
        }
        for (paramView = (ChatThumbView)localObject1;; paramView = null)
        {
          if (paramView == null) {
            break label275;
          }
          localObject1 = new int[2];
          tmp131_129 = localObject1;
          tmp131_129[0] = 0;
          tmp135_131 = tmp131_129;
          tmp135_131[1] = 0;
          tmp135_131;
          localObject2 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramFileMsg, paramView, (int[])localObject1);
          String str = ((URLDrawable)localObject2).getURL().getProtocol();
          URL localURL = URLDrawableHelper.getURL(paramFileMsg, 65537);
          boolean bool = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(paramFileMsg.imageType), str.equals("chatthumb"), localObject1[0], localObject1[1], localURL);
          paramView.setImageDrawable((Drawable)localObject2);
          if (bool)
          {
            ((URLDrawable)localObject2).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((URLDrawable)localObject2).setWatermarkVisibility(0);
            return;
            paramInt1 += 1;
            break;
          }
          ((URLDrawable)localObject2).setWatermarkVisibility(4);
          return;
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
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((localMixedHolder.e != -1) && (a(localMixedHolder)))
    {
      localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()) || (SimpleUIUtil.a()))
      {
        paramView = paramView.getResources();
        if (paramChatMessage.isSend())
        {
          paramViewHolder = paramView.getColorStateList(2131167056);
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramViewHolder);
          if (!paramChatMessage.isSend()) {
            break label226;
          }
        }
        label226:
        for (paramViewHolder = paramView.getColorStateList(2131167055);; paramViewHolder = paramView.getColorStateList(2131167054))
        {
          localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
          localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
          ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
          ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
          return;
          paramViewHolder = paramView.getColorStateList(2131167052);
          break;
        }
      }
      if (paramBubbleInfo.jdField_b_of_type_Int == 0)
      {
        localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        if (paramBubbleInfo.c != 0) {
          break label459;
        }
        paramViewHolder = paramView.getResources().getColorStateList(2131167054);
        localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
        localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramViewHolder);
      }
      for (;;)
      {
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_AndroidWidgetTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView, 0.9F);
        return;
        localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        localMixedHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        localMixedHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
        break;
        label459:
        localMixedHolder.jdField_c_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
        localMixedHolder.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
        localMixedHolder.jdField_b_of_type_ComEtrumpMixlayoutETTextView.setLinkTextColor(paramBubbleInfo.c);
      }
    }
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()) || (SimpleUIUtil.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131167056);
        if (!paramChatMessage.isSend()) {
          break label580;
        }
      }
      label580:
      for (paramView = paramView.getColorStateList(2131167055);; paramView = paramView.getColorStateList(2131167054))
      {
        MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131167052);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131167054);
    if (paramBubbleInfo.jdField_b_of_type_Int != 0) {
      paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.jdField_b_of_type_Int);
    }
    if (paramBubbleInfo.c != 0) {
      paramView = ColorStateList.valueOf(paramBubbleInfo.c);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
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
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
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
    if (localChatMessage != null)
    {
      if (!localChatMessage.isMultiMsg) {
        break label45;
      }
      a(localQQCustomMenu, localChatMessage, null);
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      label45:
      b(localQQCustomMenu, localChatMessage, paramView);
    }
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131691325));
    int i;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (((MessageForMixedMsg)paramChatMessage).canSelectable()) {
        break label270;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        paramQQCustomMenu.a(2131365448, this.jdField_a_of_type_AndroidContentContext.getString(2131718487), 2130839052);
      }
      paramQQCustomMenu.a(2131367398, this.jdField_a_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramChatMessage, null);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramBaseHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramBaseHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, new Bundle());
      if (AIOUtils.a(5) == 1) {
        paramQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
      }
      paramBaseHolder = new Bundle();
      paramBaseHolder.putBoolean("isSearch", false);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380949, paramChatMessage, paramBaseHolder);
      a(paramQQCustomMenu, paramChatMessage);
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376940, paramChatMessage, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
      super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return paramQQCustomMenu;
      if (((paramChatMessage instanceof MessageForLongMsg)) && (!((MessageForLongMsg)paramChatMessage).canSelectable())) {
        i = 0;
      } else {
        label270:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */