package com.tencent.mobileqq.activity.recent.data;

import acvy;
import agaw;
import aima;
import aimb;
import alcu;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anhk;
import anni;
import anrs;
import autd;
import autf;
import bgtl;
import bkyx;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import oer;
import org.json.JSONObject;
import phq;
import tue;
import tyg;
import ube;
import uek;

public class RecentItemPublicAccountChatMsgData
  extends RecentItemChatMsgData
{
  private boolean isNewKandian;
  public String mReportKeyBytesOacMsgxtend = "";
  
  public RecentItemPublicAccountChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.isNewKandian = TextUtils.equals(paramRecentUser.uin, anhk.az);
    if (this.isNewKandian) {
      this.mUnreadFlag = 2;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, Context paramContext)
  {
    if ((!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(anni.a(2131711949))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(anni.a(2131711954))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(anni.a(2131711946))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(anni.a(2131711957))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(anni.a(2131711960))))
    {
      if (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(String.format(paramContext.getString(2131695735), new Object[] { Integer.valueOf(this.mUnreadNum) }))) {}
    }
    else {
      this.mMsgExtroInfo = "";
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    Object localObject;
    int i;
    if (paramMessage != null)
    {
      localObject = paramQQAppInterface.a();
      i = paramMessage.msgtype;
      if ((i == -3006) || (i == -5004)) {
        break label1141;
      }
      buildMessageBody(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
      if ((i == -2025) && (this.mUnreadNum > 0) && (tue.a(paramQQAppInterface, this.mUser.uin)))
      {
        this.mExtraInfoColor = -881592;
        this.mMsgExtroInfo = paramMessage.msg;
        this.msgSummary.strContent = "";
      }
    }
    else
    {
      paramContext = null;
      localObject = (anrs)paramQQAppInterface.getManager(56);
      if ((localObject != null) && (!alcu.a(paramQQAppInterface))) {
        break label1332;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = ((anrs)localObject).a(this.mUser.uin, true);
        if ((paramContext == null) && (localObject != null))
        {
          localObject = ((anrs)localObject).a(this.mUser.uin);
          if (localObject != null) {
            this.mTitleName = ((AccountDetail)localObject).name;
          }
          if (this.isNewKandian) {
            this.mTitleName = tyg.b(paramQQAppInterface, paramQQAppInterface.getApp());
          }
        }
        if (paramContext == null) {
          break label1348;
        }
        this.mTitleName = paramContext.name;
        this.mAuthenIconId = 0;
        if (anhk.aR.equals(this.mUser.uin)) {
          this.mTitleName = KandianDailyManager.a(paramMessage);
        }
        if ((paramMessage == null) || (paramMessage.getMessageText() == null)) {
          break label1356;
        }
        this.mDisplayTime = paramMessage.time;
        if (("2747277822".equals(this.mUser.uin)) && (autd.a())) {
          autf.a(paramQQAppInterface, paramMessage, this.msgSummary, this);
        }
        if ("3046055438".equals(this.mUser.uin)) {
          oer.a(paramQQAppInterface, this.msgSummary);
        }
        if ((!this.isNewKandian) && (tue.a(paramQQAppInterface, this.mUser.uin)))
        {
          i = paramQQAppInterface.a().g(this.mUser.uin, this.mUser.getType());
          if (this.mUnreadNum > 0)
          {
            if (!anhk.aQ.equals(this.mUser.uin)) {
              break label1378;
            }
            if (i <= 0) {
              break label1370;
            }
            this.mUnreadNum = 1;
            this.mUnreadFlag = 2;
          }
        }
        if ((paramMessage != null) && (paramMessage.mExJsonObject != null)) {
          this.mReportKeyBytesOacMsgxtend = paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", null);
        }
        if (anhk.aP.equals(this.mUser.uin)) {
          phq.a(this, 9);
        }
        uek.a().a();
        ube.a(this);
        if (("2909288299".equals(this.mUser.uin)) && (this.mUnreadNum > 0))
        {
          paramContext = paramMessage.getExtInfoFromExtStr("news_has_report");
          if ((TextUtils.isEmpty(paramContext)) || (!"1".equals(paramContext)))
          {
            paramMessage.saveExtInfoToExtStr("news_has_report", "1");
            ThreadManager.getSubThreadHandler().postDelayed(new RecentItemPublicAccountChatMsgData.3(this, paramQQAppInterface), 10000L);
          }
        }
        return;
        this.mMsgExtroInfo = "";
        this.mExtraInfoColor = 0;
        if (this.isNewKandian)
        {
          localObject = ((QQMessageFacade)localObject).b(this.mUser.uin, this.mUser.getType());
          if ((localObject == null) || (!(localObject instanceof MessageForStructing))) {
            break;
          }
          localObject = (MessageForStructing)localObject;
          if (((MessageForStructing)localObject).structingMsg == null) {
            ((MessageForStructing)localObject).parse();
          }
          if ((this.mUnreadNum > 0) && (((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mOrangeWord)))
          {
            if (((MessageForStructing)localObject).structingMsg.mOrangeWord.length() >= 8)
            {
              this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject).structingMsg.mOrangeWord.substring(0, 8) + "]");
              a(((MessageForStructing)localObject).structingMsg, paramContext);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
            }
          }
          else
          {
            if ((((MessageForStructing)localObject).extInt != 1) || (((MessageForStructing)localObject).extLong != 1)) {
              break;
            }
            return;
          }
          this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject).structingMsg.mOrangeWord + "]");
          continue;
        }
        if ((anhk.aQ.equals(this.mUser.uin)) || (anhk.aR.equals(this.mUser.uin)))
        {
          localObject = null;
          if ((paramMessage.lastMsg instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)paramMessage.lastMsg;
            localObject = localMessageForStructing;
            if (!localMessageForStructing.mIsParsed)
            {
              localMessageForStructing.parse();
              localObject = localMessageForStructing;
            }
            if ((localObject == null) || (((MessageForStructing)localObject).structingMsg == null)) {
              break;
            }
            this.msgSummary.strContent = ((MessageForStructing)localObject).structingMsg.mMsgBrief;
            this.msgSummary.suffix = "";
            if ((TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mOrangeWord)) || (this.mUnreadNum <= 0)) {
              break;
            }
            this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject).structingMsg.mOrangeWord + "]");
            a(((MessageForStructing)localObject).structingMsg, paramContext);
            this.mExtraInfoColor = -881592;
            break;
          }
          if (paramMessage.msgtype != -2011) {
            continue;
          }
          localObject = new MessageForStructing();
          ((MessageForStructing)localObject).msgData = paramMessage.msgData;
          ((MessageForStructing)localObject).parse();
          paramMessage.lastMsg = ((MessageRecord)localObject);
          continue;
        }
        if (("2290230341".equals(this.mUser.uin)) && (bkyx.a(paramQQAppInterface)))
        {
          paramContext = paramMessage.getExtInfoFromExtStr("qzone_msg_box_promot");
          if (TextUtils.isEmpty(paramContext)) {
            break;
          }
          this.msgSummary.strContent = paramContext;
          break;
        }
        if (this.mUnreadNum > 0)
        {
          bool = true;
          paramContext = bgtl.a(paramQQAppInterface, paramMessage, bool);
          if (paramContext != null) {
            this.msgSummary.strContent = paramContext;
          }
          paramContext = aima.a(paramQQAppInterface, this.mUser.uin);
          if ((paramContext == null) || (paramContext.d != paramMessage.uniseq) || (!paramContext.b())) {
            break;
          }
          ThreadManager.post(new RecentItemPublicAccountChatMsgData.2(this, paramQQAppInterface, paramContext), 2, null, false);
          break;
        }
        boolean bool = false;
        continue;
        label1141:
        this.msgSummary.strContent = "";
        localObject = agaw.a(paramMessage);
        if ((localObject == null) || (((PAMessage)localObject).items == null) || (((PAMessage)localObject).items.size() == 0))
        {
          buildMessageBody(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
          break;
        }
        paramContext = ((PAMessage.Item)((PAMessage)localObject).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject).items.get(0)).digestList != null))
        {
          paramContext = paramContext + "：" + (String)((PAMessage.Item)((PAMessage)localObject).items.get(0)).digestList.get(0);
          this.msgSummary.strContent = paramContext;
          break;
        }
        continue;
      }
      catch (Throwable paramContext)
      {
        paramContext = ((anrs)localObject).b(this.mUser.uin);
        continue;
      }
      label1332:
      paramContext = ((anrs)localObject).b(this.mUser.uin);
      continue;
      label1348:
      this.mAuthenIconId = 0;
      continue;
      label1356:
      this.mDisplayTime = this.mUser.lastmsgtime;
      continue;
      label1370:
      this.mUnreadFlag = 1;
      continue;
      label1378:
      if (anhk.aR.equals(this.mUser.uin))
      {
        if (i > 0) {
          this.mUnreadFlag = 2;
        } else {
          this.mUnreadFlag = 1;
        }
      }
      else if ((this.mUnreadNum == 1) && (i > 0))
      {
        this.mUnreadFlag = 2;
      }
      else if (i > 0)
      {
        this.mUnreadNum -= 1;
        this.mUnreadFlag = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData
 * JD-Core Version:    0.7.0.1
 */