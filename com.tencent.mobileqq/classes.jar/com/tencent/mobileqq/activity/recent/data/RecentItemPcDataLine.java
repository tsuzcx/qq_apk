package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.text.QQText;

public class RecentItemPcDataLine
  extends RecentUserBaseData
{
  String a;
  CharSequence e;
  int j;
  
  public RecentItemPcDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  protected CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
      }
    }
    for (paramMsgSummary.jdField_b_of_type_Int = 0;; paramMsgSummary.jdField_b_of_type_Int = 1)
    {
      if (!paramBoolean1) {
        break label76;
      }
      paramMsgSummary.a = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label76:
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
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label126:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 6000) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131427485);
      this.e = paramContext.getString(2131427572);
      this.j = 0;
      QQMessageFacade.Message localMessage = null;
      Object localObject = paramQQAppInterface.a();
      if (localObject != null) {
        localMessage = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      }
      if (localMessage == null) {
        break label334;
      }
      this.jdField_a_of_type_Long = localMessage.time;
      localObject = paramQQAppInterface.a();
      if (localObject == null) {
        break label326;
      }
      this.jdField_c_of_type_Int = ((ConversationFacade)localObject).a(localMessage.frienduin, localMessage.istroop);
      if (TextUtils.isEmpty(this.b)) {
        this.b = this.jdField_a_of_type_JavaLangString;
      }
      localObject = a();
      a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject);
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
    } while (!AppSetting.b);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.b).append(",");
    if (this.jdField_c_of_type_Int == 0) {}
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 6003) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131427486);
      this.e = paramContext.getString(2131427573);
      this.j = 1;
      break;
      label326:
      this.jdField_c_of_type_Int = 0;
      break label126;
      label334:
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
      break label126;
      if (this.jdField_c_of_type_Int == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
      }
    }
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool3 = false;
    paramContext = (DataLineHandler)paramQQAppInterface.a(8);
    if ((paramContext != null) && (paramContext.a(this.j)))
    {
      this.jdField_a_of_type_Long = paramContext.a(this.j);
      paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = this.e;
      return;
    }
    boolean bool1;
    boolean bool2;
    if ((paramMessage != null) && (paramMessage.msg != null))
    {
      paramContext = paramQQAppInterface.a().a(this.j).a(paramMessage.msgId);
      if (paramContext == null)
      {
        bool1 = false;
        if (paramContext != null) {
          break label230;
        }
        bool2 = false;
        label101:
        if ((!bool1) || (paramMessage.isSend())) {
          break label492;
        }
        bool1 = bool3;
      }
    }
    label230:
    label492:
    for (;;)
    {
      switch (paramMessage.msgtype)
      {
      default: 
        return;
      case -2335: 
      case -2009: 
      case -2005: 
      case -2000: 
        if (paramContext == null)
        {
          paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
          return;
          if ((paramContext.hasFailed()) && (!paramContext.hasSendingOrRecving()) && (!paramContext.hasWaiting()))
          {
            bool1 = true;
            break;
          }
          bool1 = false;
          break;
          if ((paramContext.isSendFromLocal()) && (paramContext.hasSendingOrRecving()))
          {
            bool2 = true;
            break label101;
          }
          bool2 = false;
        }
        break;
      case -1000: 
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null)
        {
          if (bool1) {
            paramMessage = "F " + paramQQAppInterface;
          }
          for (;;)
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(null, bool1, bool2, new QQText(paramMessage, 1, 16), paramMsgSummary);
            return;
            paramMessage = paramQQAppInterface;
            if (bool2) {
              paramMessage = "S " + paramQQAppInterface;
            }
          }
        }
        paramContext = new StringBuffer();
        if (bool1)
        {
          paramContext.append("F ");
          if (paramQQAppInterface == null) {
            break label444;
          }
        }
        for (paramMessage = paramQQAppInterface.toString().trim();; paramMessage = "")
        {
          paramContext.append(paramMessage);
          try
          {
            paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(null, bool1, bool2, new QQText(paramContext, 1, 16), paramMsgSummary);
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
          if (!bool2) {
            break;
          }
          paramContext.append("S ");
          break;
        }
        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = a(FileManagerUtil.a(paramQQAppInterface, paramContext.getFirstItem()), bool1, bool2, null, paramMsgSummary);
        return;
      case -2015: 
        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
        return;
        paramMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */