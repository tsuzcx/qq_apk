package com.tencent.mobileqq.apollo.process.chanel;

import ajac;
import ajbz;
import ajcf;
import android.content.Context;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class GeneralEventHandler$2
  implements Runnable
{
  public GeneralEventHandler$2(ajbz paramajbz, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new JSONObject(this.a);
      int i = ((JSONObject)localObject1).getInt("xyId");
      if (ajbz.a(this.this$0) == i)
      {
        QLog.e("apollochannel_GeneralEventHandler", 1, "startNewGame error mGameId == gameId");
        return;
      }
      int j = ((JSONObject)localObject1).optInt("src", 302);
      Object localObject2 = ((JSONObject)localObject1).optString("extendInfo");
      localObject1 = new CmGameStartChecker.StartCheckParam(i, true, "launch", 0L, 0, 0, 0, 0, "", j, null);
      ((CmGameStartChecker.StartCheckParam)localObject1).extendJson = ((String)localObject2);
      localObject2 = ajac.a(ajbz.a(this.this$0));
      if (localObject2 != null)
      {
        localObject2 = ((ajcf)localObject2).a();
        if (localObject2 != null)
        {
          ((CmGameStartChecker.StartCheckParam)localObject1).sessionUin = ((CmGameStartChecker.StartCheckParam)localObject2).sessionUin;
          ((CmGameStartChecker.StartCheckParam)localObject1).aioType = ((CmGameStartChecker.StartCheckParam)localObject2).aioType;
          ((CmGameStartChecker.StartCheckParam)localObject1).sessionType = ((CmGameStartChecker.StartCheckParam)localObject2).sessionType;
        }
      }
      ((CmGameStartChecker.StartCheckParam)localObject1).mStartType = 2;
      if (this.this$0.a.get() != null)
      {
        ApolloGameUtil.a((Context)this.this$0.a.get(), (CmGameStartChecker.StartCheckParam)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("apollochannel_GeneralEventHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.2
 * JD-Core Version:    0.7.0.1
 */