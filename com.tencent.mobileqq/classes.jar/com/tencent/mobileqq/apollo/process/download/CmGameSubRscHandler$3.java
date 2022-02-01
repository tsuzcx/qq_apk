package com.tencent.mobileqq.apollo.process.download;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameRscVerify.OnVerifyResultCallback;
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
      IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
      if (localIApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("packName", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("result", paramInt);
        localIApolloCmdChannel.callbackFromRequest(CmGameSubRscHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessDownloadCmGameSubRscHandler), 0, "cs.file_correctness_check.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler.3
 * JD-Core Version:    0.7.0.1
 */