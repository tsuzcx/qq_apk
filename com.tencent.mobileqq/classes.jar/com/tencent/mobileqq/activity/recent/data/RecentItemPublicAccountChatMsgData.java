package com.tencent.mobileqq.activity.recent.data;

import acyk;
import aeym;
import aeyn;
import ahon;
import ajsd;
import ajya;
import akdh;
import akpb;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import bggg;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import oob;
import org.json.JSONObject;
import saz;
import sfe;
import shu;
import sjs;

public class RecentItemPublicAccountChatMsgData
  extends RecentItemChatMsgData
{
  private boolean isNewKandian;
  public String mReportKeyBytesOacMsgxtend = "";
  
  public RecentItemPublicAccountChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.isNewKandian = TextUtils.equals(paramRecentUser.uin, ajsd.az);
    if (this.isNewKandian) {
      this.mUnreadFlag = 2;
    }
  }
  
  private void a(AbsStructMsg paramAbsStructMsg, Context paramContext)
  {
    if ((!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(ajya.a(2131713186))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(ajya.a(2131713191))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(ajya.a(2131713183))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(ajya.a(2131713194))) && (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(ajya.a(2131713197))))
    {
      if (!paramAbsStructMsg.mOrangeWord.equalsIgnoreCase(String.format(paramContext.getString(2131696736), new Object[] { Integer.valueOf(this.mUnreadNum) }))) {}
    }
    else {
      this.mMsgExtroInfo = "";
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage != null)
    {
      i = paramMessage.msgtype;
      if ((i == -3006) || (i == -5004)) {
        break label1023;
      }
      a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
      if ((i == -2025) && (this.mUnreadNum > 0) && (saz.a(paramQQAppInterface, this.mUser.uin)))
      {
        this.mExtraInfoColor = -881592;
        this.mMsgExtroInfo = paramMessage.msg;
        this.msgSummary.strContent = "";
      }
    }
    else
    {
      paramContext = null;
      paramQQMessageFacade = (akdh)paramQQAppInterface.getManager(56);
      if ((paramQQMessageFacade != null) && (!ahon.a(paramQQAppInterface))) {
        break label1207;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = paramQQMessageFacade.a(this.mUser.uin, true);
        if ((paramContext == null) && (paramQQMessageFacade != null))
        {
          paramQQMessageFacade = paramQQMessageFacade.a(this.mUser.uin);
          if (paramQQMessageFacade != null) {
            this.mTitleName = paramQQMessageFacade.name;
          }
          if (this.isNewKandian) {
            this.mTitleName = sfe.b(paramQQAppInterface, paramQQAppInterface.getApp());
          }
        }
        if (paramContext == null) {
          break label1222;
        }
        this.mTitleName = paramContext.name;
        this.mAuthenIconId = 0;
        if (ajsd.aR.equals(this.mUser.uin)) {
          this.mTitleName = KandianDailyManager.a(paramMessage);
        }
        if ((paramMessage == null) || (paramMessage.getMessageText() == null)) {
          break label1230;
        }
        this.mDisplayTime = paramMessage.time;
        if ((!this.isNewKandian) && (saz.a(paramQQAppInterface, this.mUser.uin)))
        {
          i = paramQQAppInterface.a().f(this.mUser.uin, this.mUser.getType());
          if (this.mUnreadNum > 0)
          {
            if (!ajsd.aQ.equals(this.mUser.uin)) {
              break label1252;
            }
            if (i <= 0) {
              break label1244;
            }
            this.mUnreadNum = 1;
            this.mUnreadFlag = 2;
          }
        }
        if ((paramMessage != null) && (paramMessage.mExJsonObject != null)) {
          this.mReportKeyBytesOacMsgxtend = paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", null);
        }
        if (ajsd.aP.equals(this.mUser.uin)) {
          oob.a(this, 9);
        }
        sjs.a().a();
        shu.a(this);
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
          paramQQMessageFacade = paramQQMessageFacade.b(this.mUser.uin, this.mUser.getType());
          if ((paramQQMessageFacade == null) || (!(paramQQMessageFacade instanceof MessageForStructing))) {
            break;
          }
          paramQQMessageFacade = (MessageForStructing)paramQQMessageFacade;
          if (paramQQMessageFacade.structingMsg == null) {
            paramQQMessageFacade.parse();
          }
          if ((this.mUnreadNum > 0) && (paramQQMessageFacade.structingMsg != null) && (!TextUtils.isEmpty(paramQQMessageFacade.structingMsg.mOrangeWord)))
          {
            if (paramQQMessageFacade.structingMsg.mOrangeWord.length() >= 8)
            {
              this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord.substring(0, 8) + "]");
              a(paramQQMessageFacade.structingMsg, paramContext);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131166955);
            }
          }
          else
          {
            if ((paramQQMessageFacade.extInt != 1) || (paramQQMessageFacade.extLong != 1)) {
              break;
            }
            return;
          }
          this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord + "]");
          continue;
        }
        if ((ajsd.aQ.equals(this.mUser.uin)) || (ajsd.aR.equals(this.mUser.uin)))
        {
          paramQQMessageFacade = null;
          if ((paramMessage.lastMsg instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)paramMessage.lastMsg;
            paramQQMessageFacade = localMessageForStructing;
            if (!localMessageForStructing.mIsParsed)
            {
              localMessageForStructing.parse();
              paramQQMessageFacade = localMessageForStructing;
            }
            if ((paramQQMessageFacade == null) || (paramQQMessageFacade.structingMsg == null)) {
              break;
            }
            this.msgSummary.strContent = paramQQMessageFacade.structingMsg.mMsgBrief;
            this.msgSummary.suffix = "";
            if ((TextUtils.isEmpty(paramQQMessageFacade.structingMsg.mOrangeWord)) || (this.mUnreadNum <= 0)) {
              break;
            }
            this.mMsgExtroInfo = ("[" + paramQQMessageFacade.structingMsg.mOrangeWord + "]");
            a(paramQQMessageFacade.structingMsg, paramContext);
            this.mExtraInfoColor = -881592;
            break;
          }
          if (paramMessage.msgtype != -2011) {
            continue;
          }
          paramQQMessageFacade = new MessageForStructing();
          paramQQMessageFacade.msgData = paramMessage.msgData;
          paramQQMessageFacade.parse();
          paramMessage.lastMsg = paramQQMessageFacade;
          continue;
        }
        if (("2290230341".equals(this.mUser.uin)) && (bggg.a(paramQQAppInterface)))
        {
          paramContext = paramMessage.getExtInfoFromExtStr("qzone_msg_box_promot");
          if (TextUtils.isEmpty(paramContext)) {
            break;
          }
          this.msgSummary.strContent = paramContext;
          break;
        }
        paramContext = aeym.a(paramQQAppInterface, this.mUser.uin);
        if ((paramContext == null) || (paramContext.d != paramMessage.uniseq) || (!paramContext.b())) {
          break;
        }
        ThreadManager.post(new RecentItemPublicAccountChatMsgData.2(this, paramQQAppInterface, paramContext), 2, null, false);
        break;
        label1023:
        this.msgSummary.strContent = "";
        paramQQMessageFacade = acyk.a(paramMessage);
        if ((paramQQMessageFacade == null) || (paramQQMessageFacade.items == null) || (paramQQMessageFacade.items.size() == 0))
        {
          a(paramMessage, this.mUser.getType(), paramQQAppInterface, paramContext, this.msgSummary);
          break;
        }
        paramContext = ((PAMessage.Item)paramQQMessageFacade.items.get(0)).title;
        if ((((PAMessage.Item)paramQQMessageFacade.items.get(0)).cover == null) && (((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList != null))
        {
          paramContext = paramContext + "：" + (String)((PAMessage.Item)paramQQMessageFacade.items.get(0)).digestList.get(0);
          this.msgSummary.strContent = paramContext;
          break;
        }
        continue;
      }
      catch (Throwable paramContext)
      {
        paramContext = paramQQMessageFacade.b(this.mUser.uin);
        continue;
      }
      label1207:
      paramContext = paramQQMessageFacade.b(this.mUser.uin);
      continue;
      label1222:
      this.mAuthenIconId = 0;
      continue;
      label1230:
      this.mDisplayTime = this.mUser.lastmsgtime;
      continue;
      label1244:
      this.mUnreadFlag = 1;
      continue;
      label1252:
      if (ajsd.aR.equals(this.mUser.uin))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData
 * JD-Core Version:    0.7.0.1
 */