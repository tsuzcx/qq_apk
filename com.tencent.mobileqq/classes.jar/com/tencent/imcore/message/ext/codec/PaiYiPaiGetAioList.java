package com.tencent.imcore.message.ext.codec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.GetAioListCallback;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class PaiYiPaiGetAioList
  implements GetAioListCallback
{
  private SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy", Locale.CHINESE);
  
  private void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQMessageFacade paramQQMessageFacade)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addGuideTips() called with: anchorMsg = [");
      ((StringBuilder)localObject1).append(paramMessageForUniteGrayTip);
      ((StringBuilder)localObject1).append("], facade = [");
      ((StringBuilder)localObject1).append(paramQQMessageFacade);
      ((StringBuilder)localObject1).append("]");
      QLog.d("PaiYiPaiGetAioList", 2, ((StringBuilder)localObject1).toString());
    }
    paramQQMessageFacade = paramQQMessageFacade.g();
    Object localObject1 = paramQQMessageFacade.getApp().getString(2131892375);
    Object localObject2 = paramQQMessageFacade.getApp().getString(2131892374);
    Object localObject3 = paramMessageForUniteGrayTip.frienduin;
    String str = paramMessageForUniteGrayTip.senderuin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append((String)localObject2);
    localObject2 = new UniteGrayTipParam((String)localObject3, str, localStringBuilder.toString(), paramMessageForUniteGrayTip.istroop, -5020, 656396, MessageCache.c());
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 64);
    ((UniteGrayTipParam)localObject2).a(0, ((String)localObject1).length(), (Bundle)localObject3);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQMessageFacade, (UniteGrayTipParam)localObject2);
    ((MessageForUniteGrayTip)localObject1).shmsgseq = paramMessageForUniteGrayTip.shmsgseq;
    UniteGrayTipMsgUtil.a(paramQQMessageFacade, (MessageForUniteGrayTip)localObject1);
  }
  
  private boolean a(QQMessageFacade paramQQMessageFacade)
  {
    try
    {
      paramQQMessageFacade = paramQQMessageFacade.g();
      boolean bool = ((PaiYiPaiManager)paramQQMessageFacade.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a();
      if (bool) {
        return false;
      }
      paramQQMessageFacade = paramQQMessageFacade.getCurrentAccountUin();
      Object localObject = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pai_yi_pai_add_guide_tip_info");
      localStringBuilder.append(paramQQMessageFacade);
      paramQQMessageFacade = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
      long l1 = paramQQMessageFacade.getLong("totalTimes", 0L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shouldAddGuideTip() called with: totalTimes = [");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append("]");
        QLog.d("PaiYiPaiGetAioList", 2, ((StringBuilder)localObject).toString());
      }
      if (l1 >= 3L) {
        return false;
      }
      localObject = new Date();
      localObject = this.a.format((Date)localObject);
      long l2 = paramQQMessageFacade.getLong((String)localObject, 0L);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldAddGuideTip() called with: times = [");
        localStringBuilder.append(l2);
        localStringBuilder.append("] in ");
        localStringBuilder.append((String)localObject);
        QLog.d("PaiYiPaiGetAioList", 2, localStringBuilder.toString());
      }
      if (l2 == 0L)
      {
        paramQQMessageFacade = paramQQMessageFacade.edit();
        paramQQMessageFacade.putLong((String)localObject, l2 + 1L);
        paramQQMessageFacade.putLong("totalTimes", l1 + 1L);
        paramQQMessageFacade.apply();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    paramString = ((QQAppInterface)paramAppRuntime).getMessageFacade();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramAppRuntime = (MessageRecord)paramList.next();
      if ((paramAppRuntime instanceof MessageForUniteGrayTip))
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramAppRuntime;
        if ((TextUtils.equals(localMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_type"), "12")) && (TextUtils.equals(localMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id"), "1061")) && (!TextUtils.equals(paramAppRuntime.getExtInfoFromExtStr("pai_yi_pai_online_status"), "1")) && (a(paramString)))
        {
          a(localMessageForUniteGrayTip, paramString);
          if (localMessageForUniteGrayTip.istroop == 0) {
            paramInt1 = 1;
          } else if (localMessageForUniteGrayTip.istroop == 1) {
            paramInt1 = 2;
          } else {
            paramInt1 = 10;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B3A3", "0X800B3A3", paramInt1, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.PaiYiPaiGetAioList
 * JD-Core Version:    0.7.0.1
 */