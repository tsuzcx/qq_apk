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
  private MqqHandler a = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
  private QQAppInterface b;
  private BaseSessionInfo c;
  private TipsManager d;
  private NearbyGrayTipsManager e;
  private Random f;
  private int g;
  private int h;
  private QQMessageFacade i;
  
  public NearbyMarketGrayTips(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager)
  {
    this.b = paramQQAppInterface;
    this.c = paramBaseSessionInfo;
    this.d = paramTipsManager;
    this.g = -1;
    this.f = new Random();
    if (this.c.a == 1001) {
      this.h = 1;
    } else if (this.c.a == 1010) {
      this.h = 2;
    } else if (this.c.a == 10002) {
      this.h = 3;
    }
    this.e = ((NearbyGrayTipsManager)this.b.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER));
    this.i = ((QQMessageFacade)paramQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE));
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
  
  private boolean b(int paramInt, Object... paramVarArgs)
  {
    ReportController.b(this.b, "CliOper", "", "", "0X800524B", "0X800524B", 0, 0, String.valueOf(paramInt), "", "", "");
    QQAppInterface localQQAppInterface = this.b;
    String str;
    if (this.h == 0) {
      str = "0";
    } else {
      str = "1";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "exp_oper", 0, 0, str, "", "", "");
    return this.d.a(this, paramVarArgs);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOtherGender, ");
      localStringBuilder.append(this.g);
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
    if (!this.a.hasMessages(paramInt)) {
      this.a.sendEmptyMessage(paramInt);
    }
  }
  
  public MessageRecord a_(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {
      paramVarArgs = paramVarArgs[0].toString();
    } else {
      paramVarArgs = null;
    }
    if (!TextUtils.isEmpty(paramVarArgs))
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2027);
      long l = MessageCache.c();
      String str = this.b.getCurrentAccountUin();
      localMessageRecord.init(str, this.c.b, str, paramVarArgs, l, -2027, this.c.a, l);
      localMessageRecord.isread = true;
      return localMessageRecord;
    }
    return null;
  }
  
  public int b()
  {
    return 1006;
  }
  
  public int[] c()
  {
    return null;
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
      if ((!this.e.b()) || (this.e.a(MessageCache.c() * 1000L))) {
        return false;
      }
      break;
    }
    int j = paramMessage.what;
    paramMessage = null;
    Object localObject2 = null;
    long l1;
    Object localObject1;
    switch (j)
    {
    default: 
      return false;
    case 1001: 
      paramMessage = this.i.o(this.c.b, this.c.a);
      if (this.e.a(paramMessage)) {
        return false;
      }
      l1 = 1000L * MessageCache.c();
      if ((this.e.b()) && (!this.e.a(l1))) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j != 0) && (paramMessage != null) && (paramMessage.size() > 0))
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
        if (MessageRecordInfo.c(((ChatMessage)localObject1).issend))
        {
          localObject1 = this.i.getLastMessage(this.c.b, this.c.a);
          if (!MsgUtils.a(this.b, (com.tencent.imcore.message.Message)localObject1))
          {
            localObject1 = this.e.a(this.h, this.g, ((com.tencent.imcore.message.Message)localObject1).msg, 1, l1);
            if (paramMessage != null)
            {
              paramMessage = paramMessage.iterator();
              j = 0;
              for (;;)
              {
                k = j;
                if (!paramMessage.hasNext()) {
                  break;
                }
                if (!MessageUtils.b(((ChatMessage)paramMessage.next()).msgtype)) {
                  j += 1;
                }
              }
            }
            int k = 0;
            if (k == 1) {
              paramMessage = this.e.c(this.h, this.g, l1);
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
              localObject1 = localGrayTipsConfig.getGrayTipWording(this.f);
              if (localObject1 != null)
              {
                if (localGrayTipsConfig.sceneId == 1)
                {
                  paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 1, localGrayTipsConfig.url, this.h);
                }
                else
                {
                  paramMessage = (android.os.Message)localObject2;
                  if (localGrayTipsConfig.sceneId == 3) {
                    paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(localGrayTipsConfig.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, localGrayTipsConfig.url, this.h);
                  }
                }
                if (!TextUtils.isEmpty(paramMessage)) {
                  if (b(localGrayTipsConfig.id, new Object[] { paramMessage }))
                  {
                    this.e.a(localGrayTipsConfig.id, l1);
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
          if (!MessageUtils.b(((ChatMessage)localObject1).msgtype))
          {
            paramMessage = this.e.a(this.h, this.g, ((ChatMessage)localObject1).msg, 2, l1);
            if (paramMessage != null)
            {
              localObject1 = paramMessage.getGrayTipWording(this.f);
              if (localObject1 != null)
              {
                localObject1 = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, paramMessage.url, this.h);
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  if (b(paramMessage.id, new Object[] { localObject1 }))
                  {
                    this.e.a(paramMessage.id, l1);
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
      l1 = 1000L * MessageCache.c();
      long l2 = System.currentTimeMillis();
      localObject1 = this.b.getMessageFacade().o(this.c.b, this.c.a);
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
        if (!this.e.a((List)localObject1))
        {
          paramMessage = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
          if (!MessageUtils.b(paramMessage.msgtype))
          {
            if (paramMessage.isSend()) {
              paramMessage = this.e.a(this.h, this.g, paramMessage.msg, 1, l1);
            } else {
              paramMessage = this.e.a(this.h, this.g, paramMessage.msg, 2, l1);
            }
            if (paramMessage != null)
            {
              localObject1 = paramMessage.getGrayTipWording(this.f);
              if (localObject1 != null)
              {
                localObject1 = MessageForNearbyMarketGrayTips.makeGrayTipMsg(paramMessage.id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 4, paramMessage.url, this.h);
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  if (b(paramMessage.id, new Object[] { localObject1 }))
                  {
                    this.e.a(paramMessage.id, l1);
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
        localObject2 = a(this.e.a(this.h, this.g, l1), this.e.d(this.h, this.g, l1));
        if (localObject2 != null)
        {
          this.f.setSeed(l1);
          localObject1 = ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).getGrayTipWording(this.f);
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneId == 2)
          {
            if (localObject1 != null) {
              paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, ((NearbyGrayTipsManager.Wording)localObject1).text, ((NearbyGrayTipsManager.Wording)localObject1).highlightText, 2, ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).url, this.h);
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
              paramMessage.text = HardCodeUtil.a(2131905071);
              paramMessage.highlightText = HardCodeUtil.a(2131905070);
            }
            paramMessage = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, paramMessage.text, paramMessage.highlightText, 8, ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).url, this.h);
          }
          if (!TextUtils.isEmpty(paramMessage)) {
            if (b(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, new Object[] { paramMessage })) {
              this.e.a(((NearbyGrayTipsManager.GrayTipsConfig)localObject2).id, l1);
            }
          }
        }
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips
 * JD-Core Version:    0.7.0.1
 */