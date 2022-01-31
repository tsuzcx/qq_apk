package com.tencent.mobileqq.activity.recent.data;

import aeum;
import alof;
import alzl;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import azus;
import azut;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import nrt;
import org.json.JSONObject;
import ors;
import otf;
import owy;
import oxd;
import swy;
import syb;

public class RecentItemKandianMergeData
  extends RecentUserBaseData
{
  public static final int NEW_EXPOSURE_BIT = 536870912;
  public static final int OLD_EXPOSURE_BIT = 1;
  private static String TAG = "RecentItemKandianMergeData";
  
  public RecentItemKandianMergeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    if (bkbq.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
    for (this.mUnreadFlag = 1;; this.mUnreadFlag = 2)
    {
      this.mExtraInfoColor = BaseApplicationImpl.getApplication().getResources().getColor(2131167008);
      return;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (!bkbq.D(paramQQAppInterface)) {}
    while ((paramMessageRecord.isread) || ((paramMessageRecord.extLong & 0x20000000) == 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    this.mUser.lastmsgtime = l;
    ThreadManager.executeOnSubThread(new RecentItemKandianMergeData.2(this, paramQQAppInterface, paramMessageRecord, l));
    nrt.a(null, "CliOper", "", "", "", "0X80089F5", 0, 0, String.valueOf(this.mPosition + 1), "", "", "", false);
    QLog.d(TAG, 2, "no real exposure, try to setTopForUnExposureRedPnt!");
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((oxd)paramAppRuntime.getManager(163)).a();
    paramAppRuntime.d(0);
    paramAppRuntime.d(56);
    paramAppRuntime.e(40677);
    if (otf.b(otf.b())) {
      owy.a().d(otf.b());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    QQMessageFacade.Message localMessage;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        do
        {
          return;
          super.a(paramQQAppInterface, paramContext);
          localObject1 = paramQQAppInterface.a();
        } while (localObject1 == null);
        localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
      } while (localMessage == null);
      localMessageRecord = ((QQMessageFacade)localObject1).b(this.mUser.uin, this.mUser.getType());
    } while (localMessageRecord == null);
    if ((localMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localMessageRecord;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      this.mAuthenIconId = 0;
      MsgSummary localMsgSummary;
      if (bkbq.I(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        this.mUnreadFlag = 1;
        this.mTitleName = swy.c(paramQQAppInterface, paramContext);
        localMsgSummary = a();
        localMsgSummary.strContent = "";
        if ((localMessageRecord.extInt != 1) && (localMessageRecord.extInt != 3)) {
          break label807;
        }
        if (localObject1 == null) {
          break label794;
        }
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label781;
        }
        localMsgSummary.strContent = ((MessageForStructing)localObject1).structingMsg.mMsgBrief;
      }
      for (;;)
      {
        this.mUnreadNum = 0;
        if ((localMessageRecord.extInt != 1) || (localMessageRecord.isread)) {
          break label1375;
        }
        this.mUnreadNum = 1;
        label222:
        this.mMsgExtroInfo = "";
        if (this.mUnreadNum <= 0) {
          break label1659;
        }
        if (localMessageRecord.extInt != 1) {
          break label1460;
        }
        if (localObject1 == null) {
          break label1451;
        }
        if ((((MessageForStructing)localObject1).structingMsg == null) || (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord))) {
          break label1442;
        }
        this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "] ");
        label306:
        if ((bkbq.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) && (this.mUnreadNum == 1))
        {
          if (!TextUtils.isEmpty(localMsgSummary.strPrefix)) {
            break label1668;
          }
          localMsgSummary.strContent = TextUtils.concat(new CharSequence[] { this.mMsgExtroInfo, localMsgSummary.strContent });
          label365:
          this.mMsgExtroInfo = "";
        }
        a(localMessageRecord, paramQQAppInterface);
        this.mDisplayTime = this.mUser.lastmsgtime;
        if (this.mUnreadNum > 0) {
          a(localMessageRecord, (MessageForStructing)localObject1, paramQQAppInterface);
        }
        if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.strPrefix)) && (TextUtils.isEmpty(localMsgSummary.suffix)) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
        {
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, localMessage.getBaseInfoString() + ",isread:" + localMessage.isread + ",issend:" + localMessage.issend + ",extInt:" + localMessage.extInt + ",extLong:" + localMessage.extLong);
            QLog.i(TAG, 2, localMessageRecord.getBaseInfoString() + ",isread:" + localMessageRecord.isread + ",issend:" + localMessageRecord.issend + ",extInt:" + localMessageRecord.extInt + ",extLong:" + localMessageRecord.extLong);
          }
          localMsgSummary.strContent = paramQQAppInterface.getApp().getResources().getString(2131695739);
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.c)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mTitleName).append(",");
          if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
            paramContext.append(this.mMsgExtroInfo).append(",");
          }
          if (!TextUtils.isEmpty(this.mLastMsg)) {
            paramContext.append(this.mLastMsg).append(",");
          }
          if (!TextUtils.isEmpty(this.mShowTime)) {
            paramContext.append(this.mShowTime);
          }
          this.mContentDesc = paramContext.toString();
        }
        a(paramQQAppInterface);
        return;
        if (localMessageRecord.vipBubbleID == -1000L) {}
        for (i = 1;; i = 2)
        {
          this.mUnreadFlag = i;
          break;
        }
        label781:
        QLog.w(TAG, 2, "KANDIAN_REAL_MSG or KANDIAN_FAKE_MSG, structing.structingMsg null");
        continue;
        label794:
        localMsgSummary.strContent = localMessageRecord.msg;
        continue;
        label807:
        if ((localMessageRecord.extInt == 5) || (localMessageRecord.extInt == 6) || ((localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, alof.az))))
        {
          localMsgSummary.strContent = localMessageRecord.msg;
        }
        else
        {
          if (!syb.a(paramQQAppInterface, localMessageRecord.senderuin, localMessage.msgtype)) {
            break label896;
          }
          localMsgSummary.strContent = "";
          localMsgSummary.suffix = "";
        }
      }
      label896:
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
      int i = localMessage.msgtype;
      Object localObject4;
      Object localObject2;
      if ((i == -3006) || (i == -5004))
      {
        localMsgSummary.suffix = "";
        localMsgSummary.strContent = "";
        localObject4 = aeum.a(localMessage);
        if ((localObject4 != null) && (((PAMessage)localObject4).items != null) && (((PAMessage)localObject4).items.size() != 0))
        {
          localObject2 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover != null) || (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList == null)) {
            break label1351;
          }
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
          label1081:
          localMsgSummary.strContent = ((CharSequence)localObject2);
        }
      }
      label1127:
      Object localObject5;
      if (((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix))) || (TextUtils.equals(localMsgSummary.a(paramContext), AbsStructMsg.PA_DEFAULT_MSG_BRIEF)))
      {
        i = 1;
        if ((i != 0) && (localObject1 != null) && (((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsStructMsg)))
        {
          localObject2 = ((AbsShareMsg)((MessageForStructing)localObject1).structingMsg).getStructMsgItemLists();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            label1184:
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (azus)((Iterator)localObject2).next();
              if (!(localObject4 instanceof azut)) {
                break label1698;
              }
              localObject4 = ((azut)localObject4).a.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (azus)((Iterator)localObject4).next();
                if ((localObject5 instanceof StructMsgItemTitle))
                {
                  localMsgSummary.strContent = ((StructMsgItemTitle)localObject5).b();
                  localMsgSummary.suffix = "";
                  i = 1;
                }
              }
            }
          }
        }
      }
      label1668:
      label1698:
      for (;;)
      {
        if (i != 0)
        {
          if ((localMessageRecord.extInt != 2) || (TextUtils.isEmpty(localMessageRecord.senderuin))) {
            break;
          }
          localObject2 = ((alzl)paramQQAppInterface.getManager(56)).b(localMessageRecord.senderuin);
          if ((localObject2 == null) || (TextUtils.isEmpty(((PublicAccountInfo)localObject2).name))) {
            break label1362;
          }
          localMsgSummary.strPrefix = ((PublicAccountInfo)localObject2).name;
          break;
          label1351:
          break label1081;
          i = 0;
          break label1127;
        }
        break label1184;
        label1362:
        localMsgSummary.strPrefix = localMessageRecord.senderuin;
        break;
        label1375:
        if (localMessageRecord.extInt == 2)
        {
          if (localMessageRecord.isread) {}
          for (i = 0;; i = 1)
          {
            this.mUnreadNum = i;
            break;
          }
        }
        if (((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6)) || (localMessageRecord.isread)) {
          break label222;
        }
        this.mUnreadNum = 1;
        break label222;
        label1442:
        this.mMsgExtroInfo = "";
        break label306;
        label1451:
        this.mMsgExtroInfo = "";
        break label306;
        label1460:
        if ((localMessageRecord.extInt == 2) && (!TextUtils.equals(localMessageRecord.senderuin, alof.az)))
        {
          if (!syb.a(paramQQAppInterface, localMessage.senderuin, localMessage.msgtype)) {}
          this.mMsgExtroInfo = "";
          break label306;
        }
        if ((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6) && ((localMessageRecord.extInt != 2) || (!TextUtils.equals(localMessageRecord.senderuin, alof.az)) || (TextUtils.isEmpty(localMessageRecord.extStr)))) {
          break label306;
        }
        localObject4 = null;
        try
        {
          localObject5 = new JSONObject(localMessage.extStr);
          localObject2 = localObject4;
          if (((JSONObject)localObject5).has(KandianMergeManager.b)) {
            localObject2 = ((JSONObject)localObject5).getString(KandianMergeManager.b);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject3 = localObject4;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label306;
        }
        this.mMsgExtroInfo = ("[" + (String)localObject2 + "]");
        break label306;
        label1659:
        this.mMsgExtroInfo = "";
        break label306;
        localMsgSummary.strPrefix = TextUtils.concat(new CharSequence[] { this.mMsgExtroInfo, localMsgSummary.strPrefix });
        break label365;
      }
      continue;
      localObject1 = null;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (bkbq.k()) {}
  }
  
  public long c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {
      return super.c();
    }
    Object localObject2 = localQQAppInterface.a();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      MessageRecord localMessageRecord = ((QQMessageFacade)localObject2).b(this.mUser.uin, this.mUser.getType());
      if (localMessageRecord == null) {
        return super.c();
      }
      if ((localMessageRecord instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)localMessageRecord;
        localObject1 = localObject2;
        if (((MessageForStructing)localObject2).structingMsg == null)
        {
          ((MessageForStructing)localObject2).parse();
          localObject1 = localObject2;
        }
      }
      a(localMessageRecord, localObject1, localQQAppInterface);
      ors.e = ors.a();
    }
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData
 * JD-Core Version:    0.7.0.1
 */