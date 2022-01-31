package com.tencent.mobileqq.activity.qwallet;

import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

public class GoldConfigObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(String paramString1, String paramString2, int paramInt, List paramList, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, GoldMsgGetReq paramGoldMsgGetReq, GoldMsgGetRsp paramGoldMsgGetRsp) {}
  
  public void a(boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 4)
    {
      localObject2 = (GoldMsgGetReq)paramBundle.getSerializable("req");
      if (paramBoolean) {
        localObject1 = (GoldMsgGetRsp)paramBundle.getSerializable("rsp");
      }
      a(paramBoolean, (GoldMsgGetReq)localObject2, (GoldMsgGetRsp)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onReceive GOLDMSG_GET,rsp.goldMsgSwitch:");
        if (localObject1 == null) {
          break label119;
        }
        paramBundle = ((GoldMsgGetRsp)localObject1).goldMsgSwitch + ",rsp.goldMsgPrice:" + ((GoldMsgGetRsp)localObject1).goldMsgPrice;
        QLog.d("GoldConfigObserver", 2, paramBundle);
      }
    }
    label119:
    label248:
    do
    {
      do
      {
        return;
        paramBundle = "null";
        break;
        if (paramInt != 5) {
          break label248;
        }
        localObject3 = (GoldMsgSetReq)paramBundle.getSerializable("req");
        localObject1 = localObject2;
        if (paramBoolean) {
          localObject1 = (GoldMsgSetRsp)paramBundle.getSerializable("rsp");
        }
        a(paramBoolean, (GoldMsgSetReq)localObject3, (GoldMsgSetRsp)localObject1);
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("onReceive GOLDMSG_SET,rsp.status:");
      if (localObject1 != null) {}
      for (paramBundle = ((GoldMsgSetRsp)localObject1).status + ",rsp.errMsg:" + ((GoldMsgSetRsp)localObject1).errMsg;; paramBundle = "null")
      {
        QLog.d("GoldConfigObserver", 2, paramBundle);
        return;
      }
      if (paramInt == 8)
      {
        a(paramBundle.getString("goldmsg_frienduin", ""), paramBundle.getLong("goldmsg_min_value_", 0L));
        return;
      }
      if (paramInt == 7)
      {
        a();
        return;
      }
      if (paramInt == 9)
      {
        a(paramBundle);
        return;
      }
      if (paramInt == 16)
      {
        paramBoolean = paramBundle.getBoolean("isFinish");
        localObject1 = paramBundle.getString("receUin");
        paramInt = paramBundle.getInt("receUinType");
        localObject2 = paramBundle.getString("listId");
        int i = paramBundle.getInt("total", 0);
        int j = paramBundle.getInt("current", 0);
        if (QLog.isColorLevel()) {
          QLog.i("GoldConfigObserver", 2, "GOLDMSG_GRAP_SELF listId:" + (String)localObject2 + " receUin:" + (String)localObject1 + " receUinType:" + paramInt + " total:" + i + " current:" + j);
        }
        a((String)localObject2, (String)localObject1, paramInt, i, j, paramBoolean);
        return;
      }
    } while (paramInt != 12);
    paramBoolean = paramBundle.getBoolean("isFinish");
    localObject1 = paramBundle.getString("receUin");
    paramInt = paramBundle.getInt("receUinType");
    localObject2 = paramBundle.getString("listId");
    Object localObject3 = paramBundle.getStringArrayList("uins");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GOLDMSG_GRAP_NOTIFY listId:").append((String)localObject2).append(" isFinish:").append(paramBoolean).append(" uins:");
      if (localObject3 == null) {
        break label580;
      }
    }
    label580:
    for (paramBundle = ((ArrayList)localObject3).toString();; paramBundle = "")
    {
      QLog.i("GoldConfigObserver", 2, paramBundle + " receUin:" + (String)localObject1 + " receUinType:" + paramInt);
      a((String)localObject2, (String)localObject1, paramInt, (List)localObject3, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.GoldConfigObserver
 * JD-Core Version:    0.7.0.1
 */