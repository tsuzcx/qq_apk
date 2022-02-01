package com.qwallet.temp.impl;

import android.os.Bundle;
import com.qwallet.temp.IChatActivityFacadeTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

public class ChatActivityFacadeTemp
  implements IChatActivityFacadeTemp
{
  public MessageForPtt a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    return ChatActivityFacade.a((QQAppInterface)paramBaseQQAppInterface, paramString, (SessionInfo)paramBaseSessionInfo, paramInt1, paramInt2);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    ChatActivityFacade.a((QQAppInterface)paramBaseQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, paramMessageRecord, paramInt6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.ChatActivityFacadeTemp
 * JD-Core Version:    0.7.0.1
 */