package com.tencent.imcore.message.ext.codec;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallback;
import com.tencent.mobileqq.data.ConversationInfo;

public class UinType4UnreadMsgNumCallback
  implements GetUnreadMsgNumCallback
{
  public int a(String paramString, StringBuilder paramStringBuilder, AppInterface paramAppInterface)
  {
    return 0;
  }
  
  public boolean a(ConversationInfo paramConversationInfo)
  {
    return false;
  }
  
  public boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean, AppInterface paramAppInterface)
  {
    if (paramConversationInfo.type == 4)
    {
      paramArrayOfBoolean[0] = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.UinType4UnreadMsgNumCallback
 * JD-Core Version:    0.7.0.1
 */