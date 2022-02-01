package com.qwallet.temp;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

public abstract interface IChatActivityFacadeTemp
{
  public abstract MessageForPtt a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.IChatActivityFacadeTemp
 * JD-Core Version:    0.7.0.1
 */