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
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
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
  private AnimationTextView.OnDoubleClick A = new MixedMsgItemBuilder.3(this);
  protected long a = 0L;
  private ArrayList<String> w;
  private View.OnClickListener x;
  private MixedImageOnclickListener y = new MixedImageOnclickListener();
  private View.OnClickListener z = new MixedMsgItemBuilder.1(this);
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.y.a = paramSessionInfo;
    this.x = new ReplyItemClickListener(this);
  }
  
  private View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, MixedMsgItemBuilder.MixedHolder paramMixedHolder)
  {
    Object localObject1;
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
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
      if (this.d != null)
      {
        paramView = (TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
        paramMixedHolder.j.setRobotNextTipsView(paramView.a(this.d, paramChatMessage), this.e, this.d, paramChatMessage);
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
    boolean bool = paramMixedHolder.q instanceof MessageForMixedMsg;
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      localObject2 = (MessageForMixedMsg)paramMixedHolder.q;
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
      if ((paramMixedHolder.q instanceof MessageForLongMsg))
      {
        paramMixedHolder = (MessageForLongMsg)paramMixedHolder.q;
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
      if (this.w == null) {
        this.w = new ArrayList();
      }
      String str = paramURLDrawable.getURL().toString();
      if (str == null) {
        return;
      }
      if (!this.w.contains(str))
      {
        this.w.add(str);
        ThreadManager.executeOnSubThread(new MixedMsgItemBuilder.2(this, str, paramURLDrawable), true);
      }
    }
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder, String paramString)
  {
    if (paramViewHolder.r == null) {
      paramViewHolder.r = new StringBuilder();
    }
    if (v) {
      paramViewHolder.r.append(paramString);
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.d, paramChatMessage, 2);
    boolean bool = AIOSelectableDelegateImpl.a().l();
    int j = 1;
    int i = 1;
    Object localObject;
    if (bool)
    {
      localObject = AIOSelectableDelegateImpl.a().d();
      if ((localObject == null) || (((CharSequence)localObject).length() == AIOSelectableDelegateImpl.a().c())) {
        i = 0;
      }
      j = i;
      if (i == 0)
      {
        localObject = AIOSelectableDelegateImpl.a().r();
        j = i;
      }
    }
    else
    {
      localObject = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
    }
    ((ClipboardManager)this.e.getSystemService("clipboard")).setText((CharSequence)localObject);
    ReportController.b(this.d, "CliOper", "", "", "0X8007359", "0X8007359", 0, 0, "", "", "", "");
    if (j != 0) {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 1, 0, "", "", "", "");
    } else {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 1, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.d, "dc00898", "", "", "0X8009D65", "0X8009D65", 3, 0, "3", "", "", "");
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
    }
  }
  
  private void a(ArrayList<SchoolTroopKeywordManager.KeywordResult> paramArrayList, ArrayList<TextView> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (!SchoolTroopKeywordManager.a(this.d, this.f)) {
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
      if ((localObject2 != null) && (((SchoolTroopKeywordManager.KeywordResult)localObject2).d != -1))
      {
        localStringBuilder.append(((SchoolTroopKeywordManager.KeywordResult)localObject2).b());
        if (i != m - 1) {
          localStringBuilder.append(" ");
        }
        if ((localObject1 == null) || (((SchoolTroopKeywordManager.KeywordResult)localObject2).d < localObject1.d))
        {
          j = i;
          localObject1 = localObject2;
        }
        localTextView.setTag(2131433314, "school_troop_span");
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
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).a = paramMessageRecord.uniseq;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).c = localObject1.c;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).b = localObject1.b;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).e = localObject1.e;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).d = localObject1.d;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).a(localStringBuilder.toString());
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).f = localObject1.f;
      ((SchoolTroopKeywordManager.KeywordResult)localObject2).g = localObject1.g;
      ((Spannable)((TextView)paramArrayList1.get(j)).getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(this.d, this.e, (SchoolTroopKeywordManager.KeywordResult)localObject2), ((SchoolTroopKeywordManager.KeywordResult)localObject2).f, ((SchoolTroopKeywordManager.KeywordResult)localObject2).g, 17);
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
    return (paramMixedHolder.g != null) && (paramMixedHolder.d != null) && (paramMixedHolder.e != null) && (paramMixedHolder.f != null);
  }
  
  private void b(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.d, paramChatMessage, 3);
    boolean bool = AIOSelectableDelegateImpl.a().l();
    int k = 1;
    int i;
    if (bool)
    {
      localObject1 = AIOSelectableDelegateImpl.a().d();
      if ((localObject1 != null) && (((String)localObject1).length() == AIOSelectableDelegateImpl.a().c())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        localObject1 = AIOSelectableDelegateImpl.a().r();
      }
    }
    else
    {
      localObject1 = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage).toString();
      i = 1;
    }
    Bundle localBundle = new Bundle();
    int j = k;
    if (this.d != null)
    {
      j = k;
      if (this.d.getApp() != null)
      {
        j = k;
        if (this.d.getApp().getApplicationContext() != null)
        {
          Object localObject2 = SharedPreUtils.x(this.d.getApp().getApplicationContext());
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
      ((MixedMsgManager)this.d.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
    }
    else
    {
      localBundle.putInt("forward_type", -1);
    }
    localBundle.putString("forward_text", (String)localObject1);
    localBundle.putInt("forward_source_uin_type", this.f.a);
    localBundle.putInt("selection_mode", this.u);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.e, (Intent)localObject1, 21);
    ReportController.b(this.d, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
    ReportController.b(this.d, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    if (i != 0) {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAB", 2, 0, "", "", "", "");
    } else {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 3, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 9, 0, "9", "", "", "");
    }
  }
  
  private void b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131432608, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131432607, paramChatMessage, null);
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString)
  {
    ECommerceDataReportUtil.a(this.d, paramChatMessage, 4);
    String str;
    int j;
    if (AIOSelectableDelegateImpl.a().l())
    {
      str = AIOSelectableDelegateImpl.a().d();
      int i;
      if ((str != null) && (str.length() == AIOSelectableDelegateImpl.a().c())) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (i == 0)
      {
        str = AIOSelectableDelegateImpl.a().r();
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
      QfavReport.a(this.d, 1, 0, paramChatMessage.istroop);
      QfavBuilder.a(null, str).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
    }
    else
    {
      QfavBuilder.b(paramChatMessage).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
      QfavReport.a(this.d, 4, 0, paramChatMessage.istroop);
    }
    QfavReport.a(this.d, 6, 8);
    if (j != 0) {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAB", "0X8009AAC", 4, 0, "", "", "", "");
    } else {
      ReportController.b(this.d, "dc00898", "", paramString, "0X8009AAC", "0X8009AAC", 4, 0, "", "", "", "");
    }
    if (paramChatMessage.isMultiMsg) {
      ReportController.b(this.d, "dc00898", "", "", "0X8009D67", "0X8009D67", 9, 0, "9", "", "", "");
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (localMixedHolder.r == null) {
      localMixedHolder.r = new StringBuilder();
    }
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.d.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBubbleView: check is need refresh[");
      localStringBuilder.append(localMixedHolder.t);
      localStringBuilder.append("]");
      QLog.i("MixedMsgItemBuilder", 1, localStringBuilder.toString());
    }
    boolean bool = v;
    StringBuilder localStringBuilder = null;
    Object localObject = null;
    if ((!bool) && (MixedMsgItemBuilder.MixedHolder.a(localMixedHolder) != null) && (MixedMsgItemBuilder.MixedHolder.b(localMixedHolder) == paramChatMessage.uniseq) && (!localMixedHolder.t) && (android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info"))))
    {
      if (localTroopRobotManager.a(this.d, paramChatMessage)) {
        localMixedHolder.j.setRobotNextTipsView(true, this.e, this.d, paramChatMessage);
      } else {
        localMixedHolder.j.setRobotNextTipsView(false, this.e, this.d, paramChatMessage);
      }
      localMixedHolder.s = super.a(localMixedHolder.s, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
      super.a(localMixedHolder.s, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      paramViewHolder = this.d;
      paramBaseChatItemLayout = localMixedHolder.s;
      paramChatMessage = localObject;
      if (this.f != null) {
        paramChatMessage = this.f.b;
      }
      TroopEssenceReportUtil.a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage);
      return paramView;
    }
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramOnLongClickAndTouchListener, localMixedHolder);
    paramView = FileTransferManager.a(this.d);
    if (paramView != null) {
      paramView.a(paramViewHolder, this);
    }
    if (paramViewHolder != null) {
      paramViewHolder.setTag(localMixedHolder);
    }
    if (localMixedHolder.a != null) {
      localMixedHolder.a.b(paramChatMessage);
    }
    localMixedHolder.s = super.a(localMixedHolder.s, localMixedHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
    super.a(localMixedHolder.s, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    paramView = this.d;
    paramBaseChatItemLayout = localMixedHolder.s;
    paramChatMessage = localStringBuilder;
    if (this.f != null) {
      paramChatMessage = this.f.b;
    }
    TroopEssenceReportUtil.a(paramView, paramBaseChatItemLayout, paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramQQCustomMenu.a(this.e.getString(2131888192));
    boolean bool = paramChatMessage instanceof MessageForMixedMsg;
    int i = 0;
    if (bool ? !((MessageForMixedMsg)paramChatMessage).canSelectable() : (!(paramChatMessage instanceof MessageForLongMsg)) || (((MessageForLongMsg)paramChatMessage).canSelectable())) {
      i = 1;
    }
    if (i != 0) {
      paramQQCustomMenu.a(2131431492, this.e.getString(2131915630), 2130839059);
    }
    paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    if (AIOUtils.a(5) == 1) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
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
      paramMixedMsgLinearLayout = new MixedMsgLinearLayout(this.e);
      paramMixedMsgLinearLayout.setId(2131430578);
      paramMixedMsgLinearLayout.setOrientation(1);
      paramMixedMsgLinearLayout.setFocusable(false);
      paramMixedMsgLinearLayout.setClickable(true);
      paramMixedMsgLinearLayout.setMinimumHeight(AIOUtils.b(44.0F, this.e.getResources()));
      paramMixedMsgLinearLayout.setPadding(2131296611, 2131296614, 2131296609, 2131296613);
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.addRule(1, 2131435219);
      paramList.addRule(3, 2131447090);
      paramList.leftMargin = AIOUtils.b(3.0F, this.e.getResources());
      paramList.rightMargin = AIOUtils.b(3.0F, this.e.getResources());
      paramMixedMsgLinearLayout.setLayoutParams(paramList);
      paramMixedMsgLinearLayout.a = this.A;
      paramList = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
      MixedMsgItemBuilder.MixedHolder.a(paramList, paramMixedMsgLinearLayout);
      paramList.a = new AIOSelectableDelegateProxy();
      paramList.a.a(paramMixedMsgLinearLayout);
      paramList.a.a(paramViewHolder.j, paramViewHolder.j);
    }
    Object localObject3 = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    ((MixedMsgItemBuilder.MixedHolder)localObject3).b = -1;
    ((MixedMsgItemBuilder.MixedHolder)localObject3).t = false;
    paramMixedMsgLinearLayout.a(localArrayList1, (MixedMsgItemBuilder.MixedHolder)localObject3);
    paramViewHolder = null;
    if (SchoolTroopKeywordManager.a(this.d, this.f)) {
      paramViewHolder = (SchoolTroopKeywordManager)this.d.getManager(QQManagerFactory.SCHOOL_TROOP_KEYWORD_MANAGER);
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
            paramViewHolder.setId(2131430607);
            paramViewHolder.setOnClickListener(this.x);
            paramViewHolder.setOnTouchListener((View.OnTouchListener)localObject2);
            paramViewHolder.setOnLongClickListener((View.OnLongClickListener)localObject2);
            paramViewHolder.findViewById(2131438908).setOnClickListener(this.x);
            paramViewHolder.findViewById(2131436449).setOnClickListener(this.x);
            paramViewHolder.findViewById(2131447325).setOnClickListener(this.x);
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
              localArrayList3.add(paramList.a(this.f, (MessageRecord)localObject4));
              localArrayList2.add(localObject5);
            }
            ReplyTextItemBuilder.a(this.e, this.d, paramViewHolder, ((MessageForReplyText)localObject6).mSourceMsgInfo, this.y.a.b, ((MessageForReplyText)localObject6).istroop, (MessageRecord)localObject6, false, this.f);
            paramViewHolder = paramViewHolder.findViewById(2131447325);
            if (paramViewHolder != null)
            {
              paramViewHolder = paramViewHolder.getTag(2131430593);
              if ((paramViewHolder != null) && ((paramViewHolder instanceof Boolean)))
              {
                bool = ((Boolean)paramViewHolder).booleanValue();
                ((MixedMsgItemBuilder.MixedHolder)localObject1).t = bool;
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
            paramViewHolder.setTextSize(0, this.f.r);
            com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(paramViewHolder);
            paramViewHolder.setText((CharSequence)localHashMap.get(Integer.valueOf(j)));
            if (paramList != null)
            {
              localArrayList3.add(paramList.a(this.f, (MessageRecord)localObject4));
              localArrayList2.add(paramViewHolder);
            }
            if (((ITroopRobotService)this.d.getRuntimeService(ITroopRobotService.class, "all")).hasRobotNewsClassId(paramMessageRecord)) {
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
            localObject4 = PicItemBuilder.a(this.e, paramViewHolder, (ChatThumbView)localObject2, (int[])localObject5);
            ((ChatThumbView)localObject2).setTag(2131430592, paramViewHolder);
            ((ChatThumbView)localObject2).setAdjustViewBounds(true);
            ((ChatThumbView)localObject2).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramViewHolder)));
            ((ChatThumbView)localObject2).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramViewHolder)));
            ((ChatThumbView)localObject2).setImageDrawable((Drawable)localObject4);
            localObject6 = ((URLDrawable)localObject4).getURL().getProtocol();
            URL localURL = URLDrawableHelper.getURL(paramViewHolder, 65537);
            if (PicItemBuilder.a(this.e, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramViewHolder.imageType), ((String)localObject6).equals("chatthumb"), localObject5[0], localObject5[1], localURL))
            {
              ((URLDrawable)localObject4).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.e.getResources()), AIOUtils.b(6.0F, this.e.getResources()));
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
            ((ChatThumbView)localObject2).setOnClickListener(this.z);
            a((URLDrawable)localObject4);
            if (!paramViewHolder.isSendFromLocal()) {
              ((IPicPreDownload)this.d.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramViewHolder, 2);
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
        ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.n;
        if (j == i - 1) {
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = BaseChatItemLayout.n;
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
    paramMixedMsgLinearLayout.b = this.A;
    return paramMixedMsgLinearLayout;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.d;
    String str2 = "";
    String str1 = str2;
    if (localQQAppInterface != null)
    {
      str1 = this.d.getCurrentAccountUin();
      if (android.text.TextUtils.isEmpty(str1)) {
        str1 = str2;
      }
    }
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131445511: 
      AIOSelectableDelegateImpl.a().a(paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAC", "0X8009AAC", 2, 0, "", "", "", "");
      return;
    case 2131444634: 
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 3, 0, "", "", "", "");
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131439015: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 7, 0, "", "", "", "");
      return;
    case 2131438943: 
      super.a(paramInt, paramContext, paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 5, 0, "", "", "", "");
      return;
    case 2131433636: 
      b(paramChatMessage, str1);
      return;
    case 2131432813: 
      c(paramChatMessage, str1);
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      ReportController.b(this.d, "dc00898", "", str1, "0X8009AAB", "0X8009AAB", 6, 0, "", "", "", "");
      return;
    }
    a(paramChatMessage, str1);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    a(paramView.getBackground(), null);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)paramView.getTag();
    int i = BaseChatItemLayout.k;
    if (paramChatMessage.isSend())
    {
      MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(BaseChatItemLayout.getTextBubblePaddingAlignError(), i, BaseChatItemLayout.getTextBubblePaddingAlignHead(), TextItemBuilder.z);
      return;
    }
    MixedMsgItemBuilder.MixedHolder.a(paramView).setPadding(BaseChatItemLayout.getTextBubblePaddingAlignHead(), i, BaseChatItemLayout.getTextBubblePaddingAlignError(), TextItemBuilder.z);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (MixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    if ((!paramBoolean) && ((paramView instanceof ChatThumbView))) {
      ((ChatThumbView)paramView).a(paramView, true);
    }
    localObject = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject).getBackground();
    if (paramBoolean) {
      paramView = null;
    } else {
      paramView = n;
    }
    a((Drawable)localObject, paramView);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((localMixedHolder.b != -1) && (a(localMixedHolder)))
    {
      localMixedHolder.g.setTextSize(0, this.f.r);
      if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()) && (!SimpleUIUtil.e()))
      {
        if (paramBubbleInfo.l == 0)
        {
          localMixedHolder.g.setTextColor(-16777216);
          localMixedHolder.d.setTextColor(-16777216);
          localMixedHolder.c.setTextColor(-16777216);
          localMixedHolder.e.setTextColor(-16777216);
          localMixedHolder.f.setTextColor(-16777216);
        }
        else
        {
          localMixedHolder.g.setTextColor(paramBubbleInfo.l);
          localMixedHolder.d.setTextColor(paramBubbleInfo.l);
          localMixedHolder.c.setTextColor(paramBubbleInfo.l);
          localMixedHolder.e.setTextColor(paramBubbleInfo.l);
          localMixedHolder.f.setTextColor(paramBubbleInfo.l);
        }
        if (paramBubbleInfo.m == 0)
        {
          paramViewHolder = paramView.getResources().getColorStateList(2131168018);
          localMixedHolder.g.setLinkTextColor(paramViewHolder);
          localMixedHolder.e.setLinkTextColor(paramViewHolder);
          localMixedHolder.f.setLinkTextColor(paramViewHolder);
        }
        else
        {
          localMixedHolder.g.setLinkTextColor(paramBubbleInfo.m);
          localMixedHolder.e.setLinkTextColor(paramBubbleInfo.m);
          localMixedHolder.f.setLinkTextColor(paramBubbleInfo.m);
        }
        ImmersiveUtils.setAlpha(localMixedHolder.d, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.c, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.e, 0.9F);
        ImmersiveUtils.setAlpha(localMixedHolder.f, 0.9F);
        return;
      }
      paramView = paramView.getResources();
      if (paramChatMessage.isSend()) {
        paramViewHolder = paramView.getColorStateList(2131168020);
      } else {
        paramViewHolder = paramView.getColorStateList(2131168016);
      }
      localMixedHolder.g.setTextColor(paramViewHolder);
      localMixedHolder.d.setTextColor(paramViewHolder);
      localMixedHolder.c.setTextColor(paramViewHolder);
      localMixedHolder.e.setTextColor(paramViewHolder);
      localMixedHolder.f.setTextColor(paramViewHolder);
      if (paramChatMessage.isSend()) {
        paramViewHolder = paramView.getColorStateList(2131168019);
      } else {
        paramViewHolder = paramView.getColorStateList(2131168018);
      }
      localMixedHolder.g.setLinkTextColor(paramViewHolder);
      localMixedHolder.e.setLinkTextColor(paramViewHolder);
      localMixedHolder.f.setLinkTextColor(paramViewHolder);
      ImmersiveUtils.setAlpha(localMixedHolder.d, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.c, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.e, 0.9F);
      ImmersiveUtils.setAlpha(localMixedHolder.f, 0.9F);
      return;
    }
    if ((paramBubbleInfo.a != 0) && (paramBubbleInfo.b()) && (!SimpleUIUtil.e()))
    {
      paramViewHolder = ColorStateList.valueOf(-16777216);
      paramView = paramView.getResources().getColorStateList(2131168018);
      if (paramBubbleInfo.l != 0) {
        paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.l);
      }
      if (paramBubbleInfo.m != 0) {
        paramView = ColorStateList.valueOf(paramBubbleInfo.m);
      }
      MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
      return;
    }
    paramView = paramView.getResources();
    if (paramChatMessage.isSend()) {
      paramViewHolder = paramView.getColorStateList(2131168020);
    } else {
      paramViewHolder = paramView.getColorStateList(2131168016);
    }
    if (paramChatMessage.isSend()) {
      paramView = paramView.getColorStateList(2131168019);
    } else {
      paramView = paramView.getColorStateList(2131168018);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    paramViewHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if (MixedMsgItemBuilder.MixedHolder.a(paramViewHolder) != null) {
      MixedMsgItemBuilder.MixedHolder.a(paramViewHolder).a(VasShieldFont.a(paramChatMessage));
    }
    if ((paramViewHolder.b != -1) && (a(paramViewHolder)))
    {
      paramChatMessage = VasShieldFont.a("");
      paramViewHolder.g.setTypeface(paramChatMessage);
      paramViewHolder.d.setTypeface(paramChatMessage);
      paramViewHolder.e.setTypeface(paramChatMessage);
      paramViewHolder.f.setTypeface(paramChatMessage);
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
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    ChatMessage localChatMessage = paramView.q;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (localChatMessage != null) {
      if (localChatMessage.isMultiMsg) {
        a(localQQCustomMenu, localChatMessage, null);
      } else {
        b(localQQCustomMenu, localChatMessage, paramView);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramQQCustomMenu.a(this.e.getString(2131888192));
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
      paramQQCustomMenu.a(2131431492, this.e.getString(2131915630), 2130839059);
    }
    paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    a(paramQQCustomMenu, this.e, 2131444634, paramChatMessage, null);
    a(paramQQCustomMenu, this.e, 2131438943, paramBaseHolder.q, new Bundle());
    a(paramQQCustomMenu, this.e, 2131431695, paramBaseHolder.q, new Bundle());
    a(paramQQCustomMenu, paramChatMessage);
    if (AIOUtils.a(5) == 1) {
      paramQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", false);
    super.a(paramQQCustomMenu, this.e, 2131449133, paramChatMessage, paramBaseHolder);
    b(paramQQCustomMenu, paramChatMessage);
    a(paramQQCustomMenu, this.e, 2131444651, paramChatMessage, null);
    super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
    super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
    return paramQQCustomMenu;
  }
  
  protected void b(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
    if ((paramView.q instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.q;
      if (paramView.isSendFromLocal())
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
        localActionSheet.addButton(2131886574, 5);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new MixedMsgItemBuilder.4(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    if (BubbleUtils.a(paramView)) {
      return this;
    }
    return null;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {
      return;
    }
    Object localObject1 = (MixedMsgItemBuilder.MixedHolder)AIOUtils.b(paramView);
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
          localObject2 = paramView.getTag(2131430592);
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
        localObject1 = PicItemBuilder.a(this.e, localMessageForPic, paramView, paramFileMsg);
        localObject2 = ((URLDrawable)localObject1).getURL().getProtocol();
        URL localURL = URLDrawableHelper.getURL(localMessageForPic, 65537);
        boolean bool = PicItemBuilder.a(this.e, ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(localMessageForPic.imageType), ((String)localObject2).equals("chatthumb"), paramFileMsg[0], paramFileMsg[1], localURL);
        paramView.setImageDrawable((Drawable)localObject1);
        if (bool)
        {
          ((URLDrawable)localObject1).setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.e.getResources()), AIOUtils.b(6.0F, this.e.getResources()));
          ((URLDrawable)localObject1).setWatermarkVisibility(0);
          return;
        }
        ((URLDrawable)localObject1).setWatermarkVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */