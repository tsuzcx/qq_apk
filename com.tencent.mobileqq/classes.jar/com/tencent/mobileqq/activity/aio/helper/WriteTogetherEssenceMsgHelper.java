package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherEssenceMsgHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private BaseChatPie a;
  private QQAppInterface b;
  private boolean c = false;
  
  public WriteTogetherEssenceMsgHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.i();
    paramHelperProvider.a(this);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l1 = 0L;
      if ((paramLong != 0L) && (paramInt != 0))
      {
        try
        {
          long l2 = Long.valueOf(paramString).longValue();
          l1 = l2;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = new TroopEssenceMsgItem();
        paramString.troopUin = l1;
        paramString.msgSeq = paramLong;
        paramString.msgRandom = paramInt;
        paramString.opUin = this.b.getCurrentUin();
        paramString.msgSenderUin = this.b.getCurrentUin();
        paramString.opType = 1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setEssenceMsgIfNeed: msgItem = ");
          localStringBuilder.append(paramString.toString());
          QLog.i("WriteTogetherEssenceMsgHelper", 1, localStringBuilder.toString());
        }
        ((TroopEssenceMsgManager)this.b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramString, 2);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("WriteTogetherEssenceMsgHelper", 1, "setEssenceMsgIfNeed: return");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public String getTag()
  {
    return "WriteTogetherEssenceMsgHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 18005) {
      return;
    }
    if ((paramInt2 & 0x4) != 0) {
      ((FullScreenInputHelper)this.a.q(24)).e(false);
    }
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      try
      {
        paramIntent = paramIntent.getExtras();
        localObject = paramIntent.getString("KEY_WRITE_TOGETHER_GROUPUIN", null);
        long l = paramIntent.getLong("KEY_WRITE_TOGETHER_MSG_SEQ", 0L);
        paramInt1 = paramIntent.getInt("KEY_WRITE_TOGETHER_MSG_RANDOM", 0);
        if (this.c)
        {
          a((String)localObject, l, paramInt1);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult: e = ");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.i("WriteTogetherEssenceMsgHelper", 1, ((StringBuilder)localObject).toString());
        }
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WriteTogetherEssenceMsgHelper
 * JD-Core Version:    0.7.0.1
 */