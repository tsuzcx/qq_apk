package com.tencent.mobileqq.activity.recent.data;

import abta;
import afex;
import ajlh;
import ajlr;
import ajlv;
import ajmb;
import ajmc;
import ajmd;
import ajmf;
import ajmg;
import ajmh;
import ajmi;
import ajmj;
import ajmk;
import alud;
import amjn;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import auga;
import axap;
import axas;
import azqs;
import bamb;
import bamp;
import banh;
import bcgc;
import bcgg;
import bcoz;
import bcpa;
import bcpx;
import bcqa;
import bdgc;
import bdrv;
import bkds;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nav;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public static final String STR_TOPIC = "[topic]";
  private static final String TAG = "RecentItemTroopMsgData";
  private boolean hasTroopOrg;
  public boolean isForceSetUnreadNumRed;
  public boolean mContainsKeyword;
  protected int mGroupNotify;
  public long mTroopCreditLevel = 5L;
  public String troopHonorStr;
  
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    try
    {
      l = Long.parseLong(a());
      this.mIsGroupVideo = paramQQAppInterface.a().c(l);
      boolean bool = this.mIsGroupVideoNotify;
      this.mIsGroupVideoNotify = paramQQAppInterface.a().b(l);
      Object localObject;
      if (this.mIsGroupVideoNotify)
      {
        localObject = (bcqa)paramQQAppInterface.getManager(164);
        if ((localObject != null) && (((bcqa)localObject).a(a()) == 2)) {
          this.mIsGroupVideoNotify = false;
        }
      }
      if ((this.mIsGroupVideoNotify) && (!bool))
      {
        localObject = String.valueOf(l);
        azqs.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject, "" + bcpx.a(paramQQAppInterface, (String)localObject), "", "");
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    Object localObject1 = paramQQAppInterface.a();
    QQMessageFacade.Message localMessage = null;
    Object localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
    if (localObject2 != null) {}
    for (TroopInfo localTroopInfo = ((TroopManager)localObject2).a(this.mUser.uin, true);; localTroopInfo = null)
    {
      if (localObject1 != null) {
        localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
      }
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        if (this.mDisplayTime == 0L) {
          this.mDisplayTime = this.mUser.opTime;
        }
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.mUnreadNum = ((abta)localObject1).a(localMessage.frienduin, this.mUser.getType());
          label147:
          localObject1 = axap.a(paramQQAppInterface, localMessage.frienduin, localMessage.istroop, this.mUnreadNum, localMessage);
          this.mUnreadNum += ((axas)localObject1).a();
          if (((axas)localObject1).a() > 0) {
            this.mMsgExtroInfo = "";
          }
        }
      }
      MsgSummary localMsgSummary;
      label418:
      label848:
      boolean bool;
      for (;;)
      {
        HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
        HotChatInfo localHotChatInfo = localHotChatManager.a(this.mUser.uin);
        if (localHotChatInfo == null) {
          break label1413;
        }
        this.mUnreadFlag = 3;
        this.mTitleName = localHotChatInfo.name;
        localObject1 = null;
        localMsgSummary = new MsgSummary();
        a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMsgSummary.nState == 0) && ((!TextUtils.isEmpty(localMsgSummary.strContent)) || (!TextUtils.isEmpty(localMsgSummary.suffix))))
        {
          SpannableString localSpannableString = null;
          if (TextUtils.isEmpty(localMsgSummary.strContent)) {
            break label1803;
          }
          Object localObject3 = localMsgSummary.strContent.toString();
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localMsgSummary.strPrefix))
          {
            localObject2 = localObject3;
            if (TextUtils.indexOf(localMsgSummary.strContent, localMsgSummary.strPrefix) == 0)
            {
              if (localMsgSummary.strContent.length() <= localMsgSummary.strPrefix.length() + 2) {
                break label1796;
              }
              localObject2 = (String)((String)localObject3).subSequence(localMsgSummary.strPrefix.length() + 2, localMsgSummary.strContent.length());
            }
          }
          if (!TextUtils.isEmpty(localMsgSummary.strPrefix)) {
            localSpannableString = new bamb(localMsgSummary.strPrefix, 16).a();
          }
          localObject2 = bdrv.a((String)localObject2, localMessage, 16, 3);
          localObject3 = new SpannableStringBuilder();
          if (localSpannableString != null) {
            ((SpannableStringBuilder)localObject3).append(localSpannableString).append(": ");
          }
          ((SpannableStringBuilder)localObject3).append((CharSequence)localObject2);
          localMsgSummary.strContent = new bamp((CharSequence)localObject3, 3, 16);
        }
        if ((localHotChatInfo == null) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.a() == 1) && (TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          localMsgSummary.strContent = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        if (((a().msg instanceof ajmj)) && (this.mUnreadNum > 0))
        {
          localMsgSummary.suffix = "";
          localMsgSummary.strPrefix = "";
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMsgSummary.bShowDraft) && (a().msg == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentItemTroopMsgData.troop.special_msg.special_attention", 2, "msgSummary.bShowDraft && (null == getRecentUser().msg)");
          }
          this.mMsgExtroInfo = "";
        }
        if (!localMsgSummary.bShowDraft) {
          b(paramQQAppInterface, paramContext);
        }
        if ((localMessage != null) && (localMessage.msgtype == -2025) && (this.mUnreadNum > 0))
        {
          localObject2 = paramContext.getString(2131693391);
          if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith((String)localObject2)))
          {
            if (localMessage.bizType > 0) {
              break label1818;
            }
            if ((!TextUtils.isEmpty(this.mMsgExtroInfo)) && (this.mMsgExtroInfo.equals(paramContext.getString(2131719775)))) {
              this.mMsgExtroInfo = "";
            }
            label786:
            if ((!TextUtils.isEmpty(this.mLastMsg)) && (this.mLastMsg.toString().startsWith((String)localObject2)))
            {
              if (this.mExtraInfoColor == 0) {
                this.mExtraInfoColor = paramContext.getResources().getColor(2131167008);
              }
              if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                break label1854;
              }
              localObject1 = localObject2;
              this.mMsgExtroInfo = ((CharSequence)localObject1);
              this.mLastMsg = this.mLastMsg.toString().replace((CharSequence)localObject2, "");
            }
          }
        }
        if (localHotChatManager.b(this.mUser.uin))
        {
          localObject1 = localHotChatManager.a(this.mUser.uin);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((HotChatInfo)localObject1).memo)) && (!((HotChatInfo)localObject1).memoShowed))
          {
            this.mMsgExtroInfo = paramContext.getString(2131720832);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131166981);
          }
        }
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localMsgSummary != null) && (nav.a(localMessage))) {
          this.mLastMsg = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131697672), -1);
        }
        localObject1 = a();
        if ((localObject1 != null) && (((RecentUser)localObject1).msg == null)) {
          ((RecentUser)localObject1).reParse();
        }
        ajlh.a().a(this.mUser.uin, this.mDisplayTime);
        if (localTroopInfo != null)
        {
          this.mTroopCreditLevel = localTroopInfo.troopCreditLevel;
          if (this.mTroopCreditLevel == 0L) {
            this.mTroopCreditLevel = 5L;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.act", 2, "RecentItemTroopMsgData->update," + this.mUser.uin + "," + this.mTroopCreditLevel);
          }
        }
        if ((localTroopInfo == null) || (!localTroopInfo.hasOrgs())) {
          break label1881;
        }
        bool = true;
        label1141:
        this.hasTroopOrg = bool;
        localObject1 = (bcgc)paramQQAppInterface.getManager(346);
        if ((localTroopInfo == null) || (!((bcgc)localObject1).b(this.mUser.uin))) {
          break label1887;
        }
        this.troopHonorStr = localTroopInfo.myHonorList;
        label1188:
        if (AppSetting.c)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.mTitleName).append(",");
          if (this.mUnreadNum != 0) {
            break label1895;
          }
          label1226:
          if (this.mMsgExtroInfo != null) {
            ((StringBuilder)localObject1).append(this.mMsgExtroInfo + ",");
          }
          ((StringBuilder)localObject1).append(banh.e(this.mLastMsg.toString())).append(",").append(this.mShowTime);
          ((StringBuilder)localObject1).append(bcgg.a(paramQQAppInterface, this.mUser.uin, paramQQAppInterface.getCurrentAccountUin()));
          this.mContentDesc = ((StringBuilder)localObject1).toString();
        }
        if ((localMessage == null) || (localMessage.msgtype != -5021)) {
          break;
        }
        paramQQAppInterface = this.mLastMsg.toString();
        paramContext = paramContext.getString(2131697848);
        if (!paramQQAppInterface.endsWith(paramContext)) {
          break;
        }
        this.mLastMsg = paramQQAppInterface.subSequence(0, paramQQAppInterface.length() - paramContext.length() - 1);
        return;
        this.mUnreadNum = 0;
        break label147;
        this.mDisplayTime = this.mUser.opTime;
        this.mUnreadNum = 0;
      }
      label1413:
      int i = this.mMenuFlag;
      if (localTroopInfo != null)
      {
        localObject2 = localTroopInfo.getTroopName();
        localObject1 = localTroopInfo.troopmemo;
      }
      for (;;)
      {
        this.mMenuFlag = (i & 0xFFFFF0FF | 0x100);
        i = paramQQAppInterface.b(this.mUser.uin);
        if ((i == 1) || (this.isForceSetUnreadNumRed))
        {
          this.mUnreadFlag = 1;
          label1479:
          bool = afex.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
          if ((!bool) || (amjn.a(paramQQAppInterface.c(), paramContext))) {
            break label1747;
          }
          this.mUnreadFlag = 0;
          label1520:
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1760;
          }
          this.mTitleName = bdgc.a(paramQQAppInterface, this.mUser.uin, true);
        }
        for (this.mTitleName_cs = new bamb(bdgc.a(paramQQAppInterface, this.mUser.uin, true), 16).a();; this.mTitleName_cs = new bamb((CharSequence)localObject2, 16).a())
        {
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          e();
          if ((localTroopInfo == null) || (localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
            break label1787;
          }
          this.mExtraInfo = ("(" + localTroopInfo.wMemberNumClient + ")");
          if (!QLog.isColorLevel()) {
            break label1793;
          }
          QLog.d("RecentItemTroopMsgData", 2, "update wMemberNumClient:" + localTroopInfo.wMemberNumClient + "  wMemberNum:" + localTroopInfo.wMemberNum + " troopUin:" + localTroopInfo.troopuin);
          break;
          if ((i != 2) && (i != 3) && (i != 4)) {
            break label1479;
          }
          this.mUnreadFlag = 3;
          break label1479;
          label1747:
          if (!bool) {
            break label1520;
          }
          this.mUnreadFlag = 3;
          break label1520;
          label1760:
          this.mTitleName = ((String)localObject2);
        }
        label1787:
        this.mExtraInfo = "";
        label1793:
        break;
        label1796:
        localObject2 = "";
        break label418;
        label1803:
        localObject2 = localMsgSummary.suffix.toString();
        break label418;
        label1818:
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) || (!this.mMsgExtroInfo.equals(paramContext.getString(2131719775)))) {
          break label786;
        }
        this.mLastMsg = "";
        break label786;
        label1854:
        localObject1 = this.mMsgExtroInfo + (String)localObject2;
        break label848;
        label1881:
        bool = false;
        break label1141;
        label1887:
        this.troopHonorStr = null;
        break label1188;
        label1895:
        if (this.mUnreadNum == 1)
        {
          ((StringBuilder)localObject1).append("有一条未读");
          break label1226;
        }
        if (this.mUnreadNum == 2)
        {
          ((StringBuilder)localObject1).append("有两条未读");
          break label1226;
        }
        if (this.mUnreadNum <= 0) {
          break label1226;
        }
        ((StringBuilder)localObject1).append("有").append(this.mUnreadNum).append("条未读,");
        break label1226;
        localObject1 = null;
        localObject2 = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.bShowDraft = false;
          paramMsgSummary.mDraft = null;
        } while (this.mDisplayTime > b());
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.a(a(), a());
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mDisplayTime = paramQQAppInterface.getTime();
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = bdrv.a(paramQQAppInterface.getSummary(), paramQQAppInterface.getAtInfoStr(), 16, null, 3);
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int j = 0;
    int i = 0;
    if (this.mUser == null) {
      return;
    }
    Object localObject1 = (auga)paramQQAppInterface.getManager(37);
    Object localObject2 = a().msg;
    boolean bool2 = false;
    ajlr localajlr;
    boolean bool1;
    if (localObject2 != null)
    {
      if (!(localObject2 instanceof ajlr)) {
        break label1263;
      }
      if ((this.mUnreadNum == 0) && (!(localObject2 instanceof ajmh)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, mUnreadNum:" + this.mUnreadNum);
        }
        this.mMsgExtroInfo = "";
        this.mContentDesc = "";
        return;
      }
      localajlr = (ajlr)localObject2;
      this.mMsgExtroInfo = localajlr.a;
      i = 2131167008;
      this.mContentDesc = localajlr.b;
      long l = ((auga)localObject1).b(this.mUser.uin);
      localObject1 = null;
      if (l != 0L) {
        localObject1 = paramQQAppInterface.a().d(this.mUser.uin, this.mUser.getType(), l);
      }
      if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject1))
      {
        paramQQAppInterface = (MessageForQQWalletMsg)localObject1;
        if ((paramQQAppInterface.messageType == 7) || (paramQQAppInterface.messageType == 8))
        {
          this.mMsgExtroInfo = paramContext.getString(2131719775);
          this.mContentDesc = paramContext.getString(2131719775);
        }
        bool1 = false;
      }
    }
    for (;;)
    {
      if ((!this.mContainsKeyword) && (bool1)) {
        azqs.b(null, "dc00898", "", this.mUser.uin, "qq_vip", "0X800A906", 0, 1, 0, "", "", "", "");
      }
      this.mContainsKeyword = bool1;
      if ((TextUtils.isEmpty(this.mMsgExtroInfo)) || (i <= 0)) {
        break;
      }
      this.mExtraInfoColor = paramContext.getResources().getColor(i);
      return;
      if ((localObject1 instanceof MessageForFuDai))
      {
        ((MessageForFuDai)localObject1).parse();
        paramQQAppInterface = ((MessageForFuDai)localObject1).highlightMsg();
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = alud.a(2131713583) + paramQQAppInterface + "]";
          this.mMsgExtroInfo = paramQQAppInterface;
        }
        for (this.mContentDesc = paramQQAppInterface;; this.mContentDesc = "")
        {
          bool1 = false;
          break;
          this.mMsgExtroInfo = "";
        }
      }
      if ((localObject2 instanceof ajlv))
      {
        this.mContentDesc = String.format(alud.a(2131713556), new Object[] { this.mTitleName });
        bool1 = false;
      }
      else
      {
        if ((a().msg instanceof ajmh))
        {
          localObject1 = (ajmh)a().msg;
          paramQQAppInterface = bcpa.a(paramQQAppInterface, this.mUser.uin);
          if (((ajmh)localObject1).c == 1)
          {
            this.mMsgExtroInfo = paramContext.getString(2131697754);
            i = 2131166981;
          }
          for (;;)
          {
            bool1 = false;
            break;
            if (bcpa.c(this.mUser.uin))
            {
              this.mMsgExtroInfo = localajlr.a;
              i = 2131166981;
            }
            else if (paramQQAppInterface != null)
            {
              if (paramQQAppInterface.a.isEmpty())
              {
                this.mMsgExtroInfo = "";
                i = 2131167008;
              }
              else
              {
                this.mMsgExtroInfo = localajlr.a;
                i = 2131167008;
              }
            }
            else
            {
              this.mMsgExtroInfo = "";
              i = 2131167008;
            }
          }
        }
        if (((localObject2 instanceof bkds)) && (((bkds)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697866))))
        {
          i = 2131166981;
          bool1 = false;
        }
        else if (((localObject2 instanceof ajmg)) && (((ajmg)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697853))))
        {
          i = 2131166981;
          bool1 = false;
        }
        else if (((localObject2 instanceof ajmc)) && ((((ajmc)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697849))) || (((ajmc)localObject2).a.equalsIgnoreCase(paramContext.getString(2131693014)))))
        {
          i = 2131166981;
          bool1 = false;
        }
        else if ((localObject2 instanceof ajmd))
        {
          this.mMsgExtroInfo = "";
          bool1 = false;
        }
        else if (((localObject2 instanceof ajmk)) && (((ajmk)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697851))))
        {
          this.mMsgExtroInfo = "";
          bool1 = false;
        }
        else if (((localObject2 instanceof ajmb)) && (((ajmb)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697854))))
        {
          this.mMsgExtroInfo = "";
          bool1 = false;
        }
        else if (((localObject2 instanceof ajmi)) && (((ajmi)localObject2).a.equalsIgnoreCase(paramContext.getString(2131697856))))
        {
          this.mMsgExtroInfo = "";
          bool1 = false;
        }
        else if ((localObject2 instanceof ajmf))
        {
          bool1 = true;
          continue;
          if (this.mIsGroupVideoNotify)
          {
            i = 2131167008;
            this.mMsgExtroInfo = paramContext.getString(2131698231);
          }
          int k;
          for (;;)
          {
            k = ((auga)localObject1).a(this.mUser.uin);
            if (QLog.isColorLevel()) {
              QLog.d("RecentItemTroopMsgData", 2, "dealMsgAttention, navigateMsgType:" + k + ", mUnreadNum:" + this.mUnreadNum);
            }
            if ((k != 17) || (this.mUnreadNum == 0)) {
              break label1086;
            }
            paramQQAppInterface = ((auga)localObject1).a(this.mUser.uin, 17);
            j = i;
            if (paramQQAppInterface != null)
            {
              j = i;
              if (paramQQAppInterface.size() != 0)
              {
                this.mMsgExtroInfo = paramContext.getString(2131699996);
                j = 2131167008;
                this.mContentDesc = this.mMsgExtroInfo.toString();
              }
            }
            bool1 = false;
            i = j;
            break;
            this.mMsgExtroInfo = "";
            this.mContentDesc = "";
          }
          label1086:
          if ((k == 100) && (this.mUnreadNum != 0))
          {
            paramQQAppInterface = ((auga)localObject1).a(this.mUser.uin, 100);
            j = i;
            bool1 = bool2;
            if (paramQQAppInterface != null)
            {
              j = i;
              bool1 = bool2;
              if (paramQQAppInterface.size() != 0)
              {
                this.mMsgExtroInfo = paramContext.getString(2131699985);
                j = 2131167008;
                this.mContentDesc = this.mMsgExtroInfo.toString();
                bool1 = true;
              }
            }
            i = j;
          }
          else
          {
            j = i;
            if (k == 11)
            {
              j = i;
              if (this.mUnreadNum != 0)
              {
                paramQQAppInterface = ((auga)localObject1).a(this.mUser.uin, 11);
                j = i;
                if (paramQQAppInterface != null)
                {
                  j = i;
                  if (paramQQAppInterface.size() != 0)
                  {
                    this.mMsgExtroInfo = paramContext.getString(2131699977);
                    j = 2131167008;
                    this.mContentDesc = this.mMsgExtroInfo.toString();
                  }
                }
              }
            }
            label1263:
            bool1 = false;
            i = j;
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public long c()
  {
    return this.mTroopCreditLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */