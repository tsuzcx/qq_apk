import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class anox
{
  @Nullable
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (bfti.d(paramMessage.msgtype)) {
      return aqyy.a(paramQQAppInterface.getApp(), paramMessage);
    }
    if (paramMessage.msgtype == -2009) {
      return paramQQAppInterface.getMessageFacade().getMsgSummary(paramQQAppInterface.getApp(), paramMessage, true);
    }
    if (paramMessage.msgtype == -2040)
    {
      paramQQAppInterface = new MessageForApproval();
      paramQQAppInterface.msgData = paramMessage.msgData;
      return paramQQAppInterface.getFullTitle();
    }
    if (paramMessage.msgtype == -2041)
    {
      paramMessage = paramQQAppInterface.getApp().getString(2131690102);
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131690101);
      return paramMessage + " " + paramQQAppInterface;
    }
    if (paramMessage.msgtype == -2011) {
      return a(paramQQAppInterface, paramMessage, "");
    }
    if (amrp.a(paramMessage)) {
      return paramQQAppInterface.getApp().getString(2131691169);
    }
    if (paramMessage.msgtype == -7001) {
      return paramQQAppInterface.getApp().getString(2131693971);
    }
    if (paramMessage.msgtype == -2052)
    {
      paramQQAppInterface = new MessageForQQStoryComment();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.parse();
      return paramQQAppInterface.getSummaryMsg();
    }
    if (paramMessage.msgtype == -2057) {
      return MessageForTroopStory.MSG_CONTENT;
    }
    if (paramMessage.msgtype == -2059)
    {
      paramQQAppInterface = new MessageForTroopPobing();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.doParse();
      return paramQQAppInterface.getSummaryMsg();
    }
    CharSequence localCharSequence = paramMessage.getMessageText();
    if (bfdm.b(paramMessage))
    {
      if (!bfdm.d(paramMessage)) {
        bfdm.a(paramMessage);
      }
      paramQQAppInterface = bfdm.b(paramMessage);
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break label373;
      }
    }
    for (;;)
    {
      paramMessage = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramMessage = "";
      }
      if ((paramMessage instanceof QQText))
      {
        return ((QQText)paramMessage).toPlainText();
        if ((paramMessage.msgtype == -5040) && (awha.a(paramQQAppInterface, paramMessage))) {
          paramQQAppInterface = awha.a(paramMessage.msg);
        }
      }
      else
      {
        return new QQText(paramMessage.toString(), 3).toPlainText();
      }
      label373:
      paramQQAppInterface = localCharSequence;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, String paramString)
  {
    try
    {
      paramMessage = bchh.a(paramMessage.msgData);
      if (paramMessage == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
          return paramString;
        }
      }
      else
      {
        if (paramMessage.mMsgServiceID == 61) {
          return paramQQAppInterface.getApp().getResources().getString(2131698116);
        }
        if (paramMessage.mMsgServiceID == 107) {
          return paramQQAppInterface.getApp().getResources().getString(2131697937);
        }
        paramQQAppInterface = paramMessage.mMsgBrief;
        return paramQQAppInterface;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + paramQQAppInterface.getMessage(), paramQQAppInterface);
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anox
 * JD-Core Version:    0.7.0.1
 */