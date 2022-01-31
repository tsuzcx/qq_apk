package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class RecentItemRouterDataLine
  extends RecentUserBaseData
{
  public RecentItemRouterDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private QQMessageFacade.Message a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      if (localMessage != null)
      {
        paramQQAppInterface = localMessage;
        if (localMessage.msgtype != 0) {}
      }
      else
      {
        return null;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
        paramCharSequence = new SpannableStringBuilder(paramCharSequence.toString());
      }
    }
    for (paramMsgSummary.jdField_b_of_type_Int = 0;; paramMsgSummary.jdField_b_of_type_Int = 1)
    {
      if (!paramBoolean1) {
        break label90;
      }
      paramMsgSummary.a = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label90:
    if (paramBoolean2)
    {
      paramMsgSummary.a = 1;
      return paramCharSequence;
    }
    paramMsgSummary.a = 0;
    return paramCharSequence;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    RouterHandler localRouterHandler = (RouterHandler)paramQQAppInterface.a(48);
    Object localObject2 = a(paramQQAppInterface);
    Object localObject1 = localObject2;
    QQMessageFacade localQQMessageFacade;
    String str;
    if (localObject2 == null)
    {
      localQQMessageFacade = paramQQAppInterface.a();
      str = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 6002);
      localObject2 = localRouterHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject2 != null) {
        break label245;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).extInt = 0;
      ((QQMessageFacade.Message)localObject1).time = MessageCache.a();
      ((QQMessageFacade.Message)localObject1).msgtype = 0;
    }
    for (;;)
    {
      localQQMessageFacade.a.put(str, localObject1);
      this.b = localRouterHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin));
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = a();
      a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      if (!AppSetting.b) {
        break;
      }
      this.d = ("与我的路由的会话 [有" + this.jdField_c_of_type_Int + "条未读]  " + ((MsgSummary)localObject2).jdField_b_of_type_JavaLangCharSequence + this.jdField_c_of_type_JavaLangString);
      return;
      label245:
      if (localQQMessageFacade == null) {
        break;
      }
      localObject1 = localObject2;
      if (localQQMessageFacade.a.containsKey(str))
      {
        localQQMessageFacade.a.remove(str);
        localObject1 = localObject2;
      }
    }
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool2 = false;
    if (paramMessage != null)
    {
      paramInt = paramMessage.extInt;
      if (paramInt != 4) {
        break label522;
      }
    }
    label519:
    label522:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      if (paramMessage.msgtype == -1000)
      {
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null) {
          if (bool1) {
            paramQQAppInterface = "F " + paramQQAppInterface;
          }
        }
      }
      for (;;)
      {
        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(null, bool1, bool2, new QQText(paramQQAppInterface, 1, 16), paramMsgSummary);
        for (;;)
        {
          if (paramMessage != null) {
            QLog.d("RecentItemRouterDataLine", 2, "msg info: " + paramMessage.extInt + ":" + paramMessage.msgtype + "msgSummary.strContent:" + paramMsgSummary.jdField_b_of_type_JavaLangCharSequence);
          }
          return;
          if (!bool2) {
            break label519;
          }
          paramQQAppInterface = "S " + paramQQAppInterface;
          break;
          paramQQAppInterface = new StringBuffer();
          if (bool1) {
            paramQQAppInterface.append("F ");
          }
          for (;;)
          {
            for (;;)
            {
              paramQQAppInterface.append("");
              try
              {
                paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(null, bool1, bool2, new QQText(paramQQAppInterface, 1, 16), paramMsgSummary);
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
              }
            }
            break;
            if (bool2) {
              paramQQAppInterface.append("S ");
            }
          }
          if (paramMessage.msgtype == -2000)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramContext.getString(2131434170), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2005)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramContext.getString(2131435081), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2009)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramContext.getString(2131435941), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2335)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(paramContext.getString(2131435081), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2015)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          }
          else if (paramMessage.msgtype == -2060)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          }
          else if (paramMessage.msgtype == -2062)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          }
          else if (paramMessage.msgtype == -2065)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          }
          else if (paramMessage.msgtype == -2066)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
            continue;
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine
 * JD-Core Version:    0.7.0.1
 */