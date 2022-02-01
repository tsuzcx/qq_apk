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
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
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
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiGetAioList", 2, "addGuideTips() called with: anchorMsg = [" + paramMessageForUniteGrayTip + "], facade = [" + paramQQMessageFacade + "]");
    }
    paramQQMessageFacade = paramQQMessageFacade.a();
    Object localObject1 = paramQQMessageFacade.getApp().getString(2131694707);
    Object localObject2 = paramQQMessageFacade.getApp().getString(2131694706);
    localObject2 = new UniteGrayTipParam(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.senderuin, (String)localObject1 + (String)localObject2, paramMessageForUniteGrayTip.istroop, -5020, 656396, MessageCache.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 64);
    ((UniteGrayTipParam)localObject2).a(0, ((String)localObject1).length(), localBundle);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQMessageFacade, (UniteGrayTipParam)localObject2);
    ((MessageForUniteGrayTip)localObject1).shmsgseq = paramMessageForUniteGrayTip.shmsgseq;
    UniteGrayTipUtil.a(paramQQMessageFacade, (MessageForUniteGrayTip)localObject1);
  }
  
  private boolean a(QQMessageFacade paramQQMessageFacade)
  {
    for (;;)
    {
      boolean bool;
      long l1;
      try
      {
        paramQQMessageFacade = paramQQMessageFacade.a();
        bool = ((PaiYiPaiManager)paramQQMessageFacade.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a();
        if (bool)
        {
          bool = false;
          return bool;
        }
        paramQQMessageFacade = paramQQMessageFacade.getCurrentAccountUin();
        paramQQMessageFacade = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_add_guide_tip_info" + paramQQMessageFacade, 0);
        l1 = paramQQMessageFacade.getLong("totalTimes", 0L);
        if (!QLog.isColorLevel()) {
          break label245;
        }
        QLog.d("PaiYiPaiGetAioList", 2, "shouldAddGuideTip() called with: totalTimes = [" + l1 + "]");
      }
      finally {}
      Object localObject = new Date();
      localObject = this.a.format((Date)localObject);
      long l2 = paramQQMessageFacade.getLong((String)localObject, 0L);
      if (QLog.isColorLevel()) {
        QLog.d("PaiYiPaiGetAioList", 2, "shouldAddGuideTip() called with: times = [" + l2 + "] in " + (String)localObject);
      }
      if (l2 == 0L)
      {
        paramQQMessageFacade = paramQQMessageFacade.edit();
        paramQQMessageFacade.putLong((String)localObject, l2 + 1L);
        paramQQMessageFacade.putLong("totalTimes", l1 + 1L);
        paramQQMessageFacade.apply();
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label245:
        if (l1 >= 3L) {
          bool = false;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    paramString = ((QQAppInterface)paramAppRuntime).getMessageFacade();
    paramList = paramList.iterator();
    label27:
    while (paramList.hasNext())
    {
      paramAppRuntime = (MessageRecord)paramList.next();
      if ((paramAppRuntime instanceof MessageForUniteGrayTip))
      {
        paramAppRuntime = (MessageForUniteGrayTip)paramAppRuntime;
        if ((TextUtils.equals(paramAppRuntime.getExtInfoFromExtStr("uint64_busi_type"), "12")) && (TextUtils.equals(paramAppRuntime.getExtInfoFromExtStr("uint64_busi_id"), "1061")) && (a(paramString)))
        {
          a(paramAppRuntime, paramString);
          if (paramAppRuntime.istroop != 0) {
            break label146;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B3A3", "0X800B3A3", paramInt1, 0, "", "", "", "");
      break label27;
      break;
      label146:
      if (paramAppRuntime.istroop == 1) {
        paramInt1 = 2;
      } else {
        paramInt1 = 10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.PaiYiPaiGetAioList
 * JD-Core Version:    0.7.0.1
 */