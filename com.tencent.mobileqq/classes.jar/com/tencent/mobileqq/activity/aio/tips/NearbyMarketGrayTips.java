package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class NearbyMarketGrayTips
  implements Handler.Callback, GrayTipsTask
{
  private int jdField_a_of_type_Int;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private NearbyGrayTipsManager jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQMessageFacade jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  private Random jdField_a_of_type_JavaUtilRandom;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  private int b;
  
  public NearbyMarketGrayTips(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
      this.b = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager = ((NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)paramQQAppInterface.getManager(19));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
        this.b = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002) {
        this.b = 3;
      }
    }
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig1, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig2)
  {
    if (paramGrayTipsConfig1 != null)
    {
      if (paramGrayTipsConfig2 == null) {}
      do
      {
        do
        {
          return paramGrayTipsConfig1;
          if (paramGrayTipsConfig1.priority != paramGrayTipsConfig2.priority) {
            break;
          }
          if (paramGrayTipsConfig1.createTime < paramGrayTipsConfig2.createTime) {
            return paramGrayTipsConfig2;
          }
        } while (paramGrayTipsConfig1.createTime != paramGrayTipsConfig2.createTime);
        return paramGrayTipsConfig1;
      } while (paramGrayTipsConfig1.priority >= paramGrayTipsConfig2.priority);
      return paramGrayTipsConfig2;
    }
    if (paramGrayTipsConfig2 != null) {
      return paramGrayTipsConfig2;
    }
    return null;
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800524B", "0X800524B", 0, 0, String.valueOf(paramInt), "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.b == 0) {}
    for (String str = "0";; str = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "exp_oper", 0, 0, str, "", "", "");
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, paramVarArgs);
    }
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {}
    for (paramVarArgs = paramVarArgs[0].toString();; paramVarArgs = null)
    {
      if (!TextUtils.isEmpty(paramVarArgs))
      {
        MessageRecord localMessageRecord = MessageRecordFactory.a(-2027);
        long l = MessageCache.a();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localMessageRecord.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, paramVarArgs, l, -2027, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        localMessageRecord.isread = true;
        return localMessageRecord;
      }
      return null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyMarketGrayTips", 2, "setOtherGender, " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("NearbyMarketGrayTips", 4, "onAIOEvent, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(paramInt));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(paramInt);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1006;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      switch (paramMessage.what)
      {
      }
      break;
    }
    long l1;
    label378:
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig;
    int i;
    label681:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(MessageCache.a() * 1000L))) {
              break;
            }
            return false;
            l1 = MessageCache.a() * 1000L;
            long l2 = System.currentTimeMillis();
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            long l3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("NearbyMarketGrayTips", 2, "getAIOList cost:" + (l3 - l2) + " ms");
            }
            if ((paramMessage == null) || (paramMessage.size() <= 0)) {
              break label378;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage));
          paramMessage = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
        } while (MessageUtils.a(paramMessage.msgtype));
        if (paramMessage.isSend()) {}
        for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 1, l1); paramMessage != null; paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 2, l1))
        {
          localObject = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
          if (localObject == null) {
            break;
          }
          localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url, this.b);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (!a(paramMessage.id, new Object[] { localObject })) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
          break;
        }
        localGrayTipsConfig = a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, l1), this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.d(this.b, this.jdField_a_of_type_Int, l1));
      } while (localGrayTipsConfig == null);
      paramMessage = null;
      this.jdField_a_of_type_JavaUtilRandom.setSeed(l1);
      localObject = localGrayTipsConfig.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
      if (localGrayTipsConfig.sceneId == 2) {
        if (localObject != null) {
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 2, localGrayTipsConfig.url, this.b);
        }
      }
      while (!TextUtils.isEmpty(paramMessage))
      {
        if (!a(localGrayTipsConfig.id, new Object[] { paramMessage })) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(localGrayTipsConfig.id, l1);
        break;
        if (localGrayTipsConfig.sceneId == 4)
        {
          if (localObject != null)
          {
            paramMessage = (Message)localObject;
            if (!TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject).text)) {}
          }
          else
          {
            paramMessage = new NearbyGrayTipsManager.Wording();
            paramMessage.text = "不知道如何开口，试试推荐的打招呼吧！";
            paramMessage.highlightText = "打招呼";
          }
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, paramMessage.text, paramMessage.highlightText, 8, localGrayTipsConfig.url, this.b);
        }
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage)) {
        return false;
      }
      l1 = MessageCache.a() * 1000L;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) || (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(l1))) {
        break label874;
      }
      i = 1;
      if ((i == 0) || (paramMessage == null) || (paramMessage.size() <= 0)) {
        break label877;
      }
      localObject = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("longchen", 4, "last msg=" + ((ChatMessage)localObject).toString());
      }
      if (!MsgUtils.b(((ChatMessage)localObject).issend)) {
        break label1195;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (QQMessageFacade.Message)localObject));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((QQMessageFacade.Message)localObject).msg, 1, l1);
    label838:
    int j;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.iterator();
      i = 0;
      j = i;
      if (!paramMessage.hasNext()) {
        break label881;
      }
      if (MessageUtils.a(((ChatMessage)paramMessage.next()).msgtype)) {
        break label1342;
      }
      i += 1;
    }
    label948:
    label1342:
    for (;;)
    {
      break label838;
      label874:
      i = 0;
      break label681;
      label877:
      break;
      j = 0;
      label881:
      if (j == 1) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.c(this.b, this.jdField_a_of_type_Int, l1);; paramMessage = null)
      {
        localGrayTipsConfig = a((NearbyGrayTipsManager.GrayTipsConfig)localObject, paramMessage);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = localStringBuilder1.append("send msg done. config1 id=");
          if (localObject == null)
          {
            localObject = "null";
            localObject = localStringBuilder2.append(localObject).append("|config2 id=");
            if (paramMessage != null) {
              break label1131;
            }
            paramMessage = "null";
            label971:
            localObject = ((StringBuilder)localObject).append(paramMessage).append("|chosen config id=");
            if (localGrayTipsConfig != null) {
              break label1142;
            }
            paramMessage = "null";
            label994:
            ((StringBuilder)localObject).append(paramMessage);
            QLog.d("nearby_aio_operation_gray_tips", 4, localStringBuilder1.toString());
          }
        }
        else
        {
          if (localGrayTipsConfig == null) {
            break;
          }
          localObject = localGrayTipsConfig.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
          if (localObject == null) {
            break;
          }
          paramMessage = null;
          if (localGrayTipsConfig.sceneId != 1) {
            break label1154;
          }
          paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 1, localGrayTipsConfig.url, this.b);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramMessage)) {
            break label1193;
          }
          if (!a(localGrayTipsConfig.id, new Object[] { paramMessage })) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(localGrayTipsConfig.id, l1);
          break;
          localObject = Integer.valueOf(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id);
          break label948;
          label1131:
          paramMessage = Integer.valueOf(paramMessage.id);
          break label971;
          label1142:
          paramMessage = Integer.valueOf(localGrayTipsConfig.id);
          break label994;
          if (localGrayTipsConfig.sceneId == 3) {
            paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, localGrayTipsConfig.url, this.b);
          }
        }
        break;
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 4, "receive message");
        }
        if (MessageUtils.a(((ChatMessage)localObject).msgtype)) {
          break;
        }
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((ChatMessage)localObject).msg, 2, l1);
        if (paramMessage == null) {
          break;
        }
        localObject = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
        if (localObject == null) {
          break;
        }
        localObject = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject).text, ((NearbyGrayTipsManager.Wording)localObject).highlightText, 4, paramMessage.url, this.b);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (!a(paramMessage.id, new Object[] { localObject })) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips
 * JD-Core Version:    0.7.0.1
 */