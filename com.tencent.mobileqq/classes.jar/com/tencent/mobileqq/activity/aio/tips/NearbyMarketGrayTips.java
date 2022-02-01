package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
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
  private QQMessageFacade jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private NearbyGrayTipsManager jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Random jdField_a_of_type_JavaUtilRandom;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  private int b;
  
  public NearbyMarketGrayTips(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1001) {
      this.b = 1;
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1010) {
      this.b = 2;
    } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 10002) {
      this.b = 3;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager = ((NearbyGrayTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER));
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade = ((QQMessageFacade)paramQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE));
  }
  
  private NearbyGrayTipsManager.GrayTipsConfig a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig1, NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig2)
  {
    if (paramGrayTipsConfig1 != null)
    {
      if (paramGrayTipsConfig2 == null) {
        return paramGrayTipsConfig1;
      }
      if (paramGrayTipsConfig1.priority == paramGrayTipsConfig2.priority)
      {
        if (paramGrayTipsConfig1.createTime >= paramGrayTipsConfig2.createTime)
        {
          long l = paramGrayTipsConfig1.createTime;
          l = paramGrayTipsConfig2.createTime;
          return paramGrayTipsConfig1;
        }
      }
      else
      {
        localGrayTipsConfig = paramGrayTipsConfig1;
        if (paramGrayTipsConfig1.priority >= paramGrayTipsConfig2.priority) {
          break label74;
        }
      }
    }
    else
    {
      if (paramGrayTipsConfig2 == null) {
        break label71;
      }
    }
    return paramGrayTipsConfig2;
    label71:
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = null;
    label74:
    return localGrayTipsConfig;
  }
  
  private boolean a(int paramInt, Object... paramVarArgs)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800524B", "0X800524B", 0, 0, String.valueOf(paramInt), "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str;
    if (this.b == 0) {
      str = "0";
    } else {
      str = "1";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "exp_oper", 0, 0, str, "", "", "");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, paramVarArgs);
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {
      paramVarArgs = paramVarArgs[0].toString();
    } else {
      paramVarArgs = null;
    }
    if (!TextUtils.isEmpty(paramVarArgs))
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2027);
      long l = MessageCache.a();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageRecord.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, str, paramVarArgs, l, -2027, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      return localMessageRecord;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOtherGender, ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("NearbyMarketGrayTips", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("onAIOEvent, ");
      paramVarArgs.append(paramInt);
      QLog.d("NearbyMarketGrayTips", 4, paramVarArgs.toString());
    }
    if ((paramInt != 1000) && (paramInt != 1001)) {
      return;
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(paramInt)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1006;
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1000: 
    case 1001: 
    case 1002: 
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) || (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(MessageCache.a() * 1000L))) {
        return false;
      }
      break;
    }
    int i = paramMessage.what;
    paramMessage = null;
    Object localObject2 = null;
    long l1;
    Object localObject1;
    switch (i)
    {
    default: 
      return false;
    case 1001: 
      paramMessage = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage)) {
        return false;
      }
      l1 = 1000L * MessageCache.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a()) && (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(l1))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (paramMessage != null) && (paramMessage.size() > 0))
      {
        localObject1 = (ChatMessage)paramMessage.get(paramMessage.size() - 1);
        Object localObject3;
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("last msg=");
          ((StringBuilder)localObject3).append(((ChatMessage)localObject1).toString());
          QLog.d("longchen", 4, ((StringBuilder)localObject3).toString());
        }
        if (MessageRecordInfo.b(((ChatMessage)localObject1).issend))
        {
          localObject1 = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
          if (!MsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (com.tencent.imcore.message.Message)localObject1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((com.tencent.imcore.message.Message)localObject1).msg, 1, l1);
            if (paramMessage != null)
            {
              paramMessage = paramMessage.iterator();
              i = 0;
              for (;;)
              {
                j = i;
                if (!paramMessage.hasNext()) {
                  break;
                }
                if (!MessageUtils.a(((ChatMessage)paramMessage.next()).msgtype)) {
                  i += 1;
                }
              }
            }
            int j = 0;
            if (j == 1) {
              paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.c(this.b, this.jdField_a_of_type_Int, l1);
            } else {
              paramMessage = null;
            }
            NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = a((NearbyGrayTipsManager.GrayTipsConfig)localObject1, paramMessage);
            if (QLog.isDevelopLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("send msg done. config1 id=");
              localObject3 = "null";
              if (localObject1 == null) {
                localObject1 = "null";
              } else {
                localObject1 = Integer.valueOf(((NearbyGrayTipsManager.GrayTipsConfig)localObject1).id);
              }
              localStringBuilder.append(localObject1);
              localStringBuilder.append("|config2 id=");
              if (paramMessage == null) {
                paramMessage = "null";
              } else {
                paramMessage = Integer.valueOf(paramMessage.id);
              }
              localStringBuilder.append(paramMessage);
              localStringBuilder.append("|chosen config id=");
              if (localGrayTipsConfig == null) {
                paramMessage = (android.os.Message)localObject3;
              } else {
                paramMessage = Integer.valueOf(localGrayTipsConfig.id);
              }
              localStringBuilder.append(paramMessage);
              QLog.d("nearby_aio_operation_gray_tips", 4, localStringBuilder.toString());
            }
            if (localGrayTipsConfig != null)
            {
              localObject1 = localGrayTipsConfig.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
              if (localObject1 != null)
              {
                if (localGrayTipsConfig.sceneId == 1)
                {
                  paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 1, localGrayTipsConfig.url, this.b);
                }
                else
                {
                  paramMessage = (android.os.Message)localObject2;
                  if (localGrayTipsConfig.sceneId == 3) {
                    paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, localGrayTipsConfig.url, this.b);
                  }
                }
                if (!TextUtils.isEmpty(paramMessage)) {
                  if (a(localGrayTipsConfig.id, new Object[] { paramMessage }))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(localGrayTipsConfig.id, l1);
                    return false;
                  }
                }
              }
            }
          }
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("nearby_aio_operation_gray_tips", 4, "receive message");
          }
          if (!MessageUtils.a(((ChatMessage)localObject1).msgtype))
          {
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, ((ChatMessage)localObject1).msg, 2, l1);
            if (paramMessage != null)
            {
              localObject1 = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
              if (localObject1 != null)
              {
                localObject1 = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, paramMessage.url, this.b);
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  if (a(paramMessage.id, new Object[] { localObject1 }))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
                    return false;
                  }
                }
              }
            }
          }
        }
      }
      break;
    case 1000: 
      l1 = 1000L * MessageCache.a();
      long l2 = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int);
      long l3 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAIOList cost:");
        ((StringBuilder)localObject2).append(l3 - l2);
        ((StringBuilder)localObject2).append(" ms");
        QLog.d("NearbyMarketGrayTips", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a((List)localObject1))
        {
          paramMessage = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
          if (!MessageUtils.a(paramMessage.msgtype))
          {
            if (paramMessage.isSend()) {
              paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 1, l1);
            } else {
              paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, paramMessage.msg, 2, l1);
            }
            if (paramMessage != null)
            {
              localObject1 = paramMessage.getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
              if (localObject1 != null)
              {
                localObject1 = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, paramMessage.url, this.b);
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  if (a(paramMessage.id, new Object[] { localObject1 }))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(paramMessage.id, l1);
                    return false;
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(this.b, this.jdField_a_of_type_Int, l1), this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.d(this.b, this.jdField_a_of_type_Int, l1));
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilRandom.setSeed(l1);
          localObject1 = ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).getGrayTipWording(this.jdField_a_of_type_JavaUtilRandom);
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneId == 2)
          {
            if (localObject1 != null) {
              paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 2, ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).url, this.b);
            }
          }
          else if (((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneId == 4)
          {
            if (localObject1 != null)
            {
              paramMessage = (android.os.Message)localObject1;
              if (!TextUtils.isEmpty(((NearbyGrayTipsManager.Wording)localObject1).text)) {}
            }
            else
            {
              paramMessage = new NearbyGrayTipsManager.Wording();
              paramMessage.text = HardCodeUtil.a(2131707244);
              paramMessage.highlightText = HardCodeUtil.a(2131707243);
            }
            paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, paramMessage.text, paramMessage.highlightText, 8, ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).url, this.b);
          }
          if (!TextUtils.isEmpty(paramMessage)) {
            if (a(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, new Object[] { paramMessage })) {
              this.jdField_a_of_type_ComTencentMobileqqAppNearbyGrayTipsManager.a(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, l1);
            }
          }
        }
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips
 * JD-Core Version:    0.7.0.1
 */