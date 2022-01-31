package com.tencent.mobileqq.activity;

import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseChatpieHelper
{
  public static List a(List paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size list == null, targetUin=" + paramString);
      }
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size " + paramList.size() + ", targetUin=" + paramString);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (paramString.equals(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "filterTargetUinMsgList targetList " + localArrayList.size() + ", targetUin=" + paramString);
    }
    return localArrayList;
  }
  
  public static void a(SessionInfo paramSessionInfo, EditText paramEditText, Button paramButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramSessionInfo.l = false;
    paramSessionInfo.h = null;
    if (paramBoolean) {
      paramEditText.setText("");
    }
    paramButton.setText("发送");
  }
  
  public static boolean a(Button paramButton, CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper
 * JD-Core Version:    0.7.0.1
 */