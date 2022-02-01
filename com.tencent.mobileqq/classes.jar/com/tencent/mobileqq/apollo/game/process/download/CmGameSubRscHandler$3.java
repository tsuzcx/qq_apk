package com.tencent.mobileqq.apollo.game.process.download;

import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify.OnVerifyResultCallback;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSubRscHandler$3
  implements ApolloGameRscVerify.OnVerifyResultCallback
{
  CmGameSubRscHandler$3(CmGameSubRscHandler paramCmGameSubRscHandler, String paramString) {}
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "[onVerifyResult], retCode:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", this.a);
      localJSONObject.put("result", paramInt);
      ApolloCmdChannel.getInstance().callbackFromRequest(CmGameSubRscHandler.b(this.b), 0, "cs.file_correctness_check.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameSubRscHandler.3
 * JD-Core Version:    0.7.0.1
 */