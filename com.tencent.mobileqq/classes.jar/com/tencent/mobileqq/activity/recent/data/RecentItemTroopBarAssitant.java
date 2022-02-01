package com.tencent.mobileqq.activity.recent.data;

import agaw;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anni;
import anrs;
import bcvs;
import bcvt;
import bgnr;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tvx;
import twi;
import tyg;

public class RecentItemTroopBarAssitant
  extends AbsRecentUserBusinessBaseData
{
  public RecentItemTroopBarAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUnreadFlag = 2;
  }
  
  public void a(Context paramContext)
  {
    if ((this.mUnreadNum > 0) && (!tvx.e((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      if (this.mUnreadNum <= 99)
      {
        this.mMsgExtroInfo = String.format(paramContext.getString(2131695735), new Object[] { Integer.valueOf(this.mUnreadNum) });
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167092);
      }
    }
    for (;;)
    {
      if (this.mDisplayTime == 0L) {
        this.mShowTime = "";
      }
      return;
      this.mMsgExtroInfo = paramContext.getString(2131695730);
      break;
      this.mMsgExtroInfo = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.mStatus = 0;
    TroopBarData localTroopBarData = twi.a().a(paramQQAppInterface);
    if ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (paramQQAppInterface == null);
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(localTroopBarData.mUin, 1008);
    } while ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mStatus = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.mTitleName = tyg.a(paramQQAppInterface, paramContext);
    Object localObject5 = twi.a();
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    Object localObject1;
    label91:
    Object localObject2;
    if (tvx.e(paramQQAppInterface))
    {
      this.mUnreadNum = 1;
      ((twi)localObject5).a = this.mUnreadNum;
      localObject1 = tvx.b(paramQQAppInterface);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localMsgSummary.strContent = paramContext.getString(2131697095);; localMsgSummary.strContent = ((CharSequence)localObject1))
      {
        this.mDisplayTime = ((twi)localObject5).a(paramQQAppInterface);
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.c)
        {
          localObject1 = this.mTitleName;
          if (this.mUnreadNum != 0) {
            break label948;
          }
          localObject2 = paramContext.getString(2131695734);
          if (this.mLastMsg != null) {
            break;
          }
          paramQQAppInterface = "";
          label148:
          this.mContentDesc = String.format((String)localObject2, new Object[] { localObject1, paramQQAppInterface, this.mShowTime });
        }
        label177:
        a(paramContext);
        return;
      }
    }
    label207:
    Object localObject3;
    Object localObject4;
    label350:
    int i;
    if (((twi)localObject5).a(paramQQAppInterface) == 0)
    {
      this.mUnreadNum = 0;
      ((twi)localObject5).a = 0;
      localObject2 = null;
      localObject3 = paramQQAppInterface.a();
      localObject4 = ((twi)localObject5).a(paramQQAppInterface);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((QQMessageFacade)localObject3).a(((TroopBarData)localObject4).mUin, 1008);
        }
      }
      if (localObject1 == null) {
        break label927;
      }
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      if (TextUtils.isEmpty(((twi)localObject5).a(((QQMessageFacade.Message)localObject1).frienduin)))
      {
        localObject2 = (anrs)paramQQAppInterface.getManager(56);
        if (localObject2 != null)
        {
          localObject5 = ((anrs)localObject2).b(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject5 != null) {
            break label629;
          }
          localObject2 = ((anrs)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin);
          if (localObject2 == null) {
            break label619;
          }
          localObject2 = ((AccountDetail)localObject2).name;
        }
      }
      if (localObject1 != null)
      {
        bgnr.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), localMsgSummary, "", true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          localMsgSummary.suffix = "";
          localMsgSummary.strContent = "";
          localObject5 = agaw.a((MessageRecord)localObject1);
          if ((localObject5 != null) && (((PAMessage)localObject5).items != null) && (((PAMessage)localObject5).items.size() != 0)) {
            break label639;
          }
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        }
        if (((!TextUtils.isEmpty(localMsgSummary.strContent)) || (!TextUtils.isEmpty(localMsgSummary.suffix))) && (!TextUtils.equals(localMsgSummary.parseMsg(paramContext), AbsStructMsg.PA_DEFAULT_MSG_BRIEF))) {
          break label755;
        }
        i = 1;
        label496:
        if (i != 0)
        {
          localObject2 = ((QQMessageFacade)localObject3).b(((TroopBarData)localObject4).mUin, 1008);
          if ((localObject2 != null) && ((localObject2 instanceof MessageForStructing))) {
            break label760;
          }
        }
      }
    }
    label528:
    label825:
    label1098:
    label1099:
    for (;;)
    {
      if ((localObject1 == null) && (TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix)))
      {
        localMsgSummary.strPrefix = null;
        localMsgSummary.strContent = (anni.a(2131711931) + tyg.a(paramQQAppInterface, paramContext) + anni.a(2131711947));
        break label91;
        this.mUnreadNum = ((twi)localObject5).a(paramQQAppInterface, false);
        break label207;
        label619:
        localObject2 = ((QQMessageFacade.Message)localObject1).frienduin;
        break label350;
        label629:
        localObject2 = ((PublicAccountInfo)localObject5).name;
        break label350;
        label639:
        localObject2 = ((PAMessage.Item)((PAMessage)localObject5).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject5).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList != null)) {
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject5).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.strContent = ((CharSequence)localObject2);
          break;
        }
        label755:
        i = 0;
        break label496;
        label760:
        ((MessageForStructing)localObject2).parse();
        if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof AbsShareMsg))) {
          break;
        }
        localObject2 = ((AbsShareMsg)((MessageForStructing)localObject2).structingMsg).getStructMsgItemLists();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bcvs)((Iterator)localObject2).next();
          if (!(localObject3 instanceof bcvt)) {
            break label1098;
          }
          localObject3 = ((bcvt)localObject3).a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bcvs)((Iterator)localObject3).next();
            if ((localObject4 instanceof StructMsgItemTitle))
            {
              localMsgSummary.strContent = ((StructMsgItemTitle)localObject4).b();
              localMsgSummary.suffix = "";
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label1099;
        }
        break label825;
        break label528;
        this.mDisplayTime = ((twi)localObject5).a(paramQQAppInterface);
        break label528;
        break;
        paramQQAppInterface = this.mLastMsg;
        break label148;
        if (this.mUnreadNum == 1)
        {
          this.mContentDesc = String.format(paramContext.getString(2131695733), new Object[] { localObject1, anni.a(2131711948), this.mShowTime });
          break label177;
        }
        if (this.mUnreadNum == 2)
        {
          this.mContentDesc = String.format(paramContext.getString(2131695733), new Object[] { localObject1, anni.a(2131711961), this.mShowTime });
          break label177;
        }
        if (this.mUnreadNum <= 0) {
          break label177;
        }
        this.mContentDesc = String.format(paramContext.getString(2131695733), new Object[] { localObject1, Integer.toString(this.mUnreadNum), this.mShowTime });
        break label177;
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
          paramMsgSummary = paramQQAppInterface.a();
        } while (paramMsgSummary == null);
        paramQQAppInterface = twi.a().a(paramQQAppInterface);
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.mUin)) || (this.mDisplayTime >= paramQQAppInterface.mLastDraftTime));
      paramQQAppInterface = paramMsgSummary.getDraftSummaryInfo(paramQQAppInterface.mUin, 1008);
    } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
    this.mDisplayTime = paramQQAppInterface.getTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant
 * JD-Core Version:    0.7.0.1
 */