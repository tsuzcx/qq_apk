package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.ShortcutCreateListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSubProcessHandler$1$1
  implements ApolloGameUtil.ShortcutCreateListener
{
  CmGameSubProcessHandler$1$1(CmGameSubProcessHandler.1 param1) {}
  
  public void a(int paramInt)
  {
    int i = 0;
    IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
    if (localIApolloCmdChannel != null) {}
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label108;
        }
        QLog.d("cmgame_process.CmGameSubProcessHandler", 2, new Object[] { "createGameShortCut errorCode:", Integer.valueOf(paramInt) });
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        QLog.e("cmgame_process.CmGameSubProcessHandler", 1, "createGameShortCut Exception:" + localException);
        return;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("ret", i);
      localIApolloCmdChannel.callbackFromRequest(this.a.a, i, "cs.create_xy_shortcut.local", localJSONObject.toString());
      return;
      label108:
      if (paramInt == 1) {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1.1
 * JD-Core Version:    0.7.0.1
 */