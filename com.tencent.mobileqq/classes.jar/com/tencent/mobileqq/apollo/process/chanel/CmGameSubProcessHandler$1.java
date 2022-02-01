package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSubProcessHandler$1
  implements Runnable
{
  CmGameSubProcessHandler$1(CmGameSubProcessHandler paramCmGameSubProcessHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      String str = new JSONObject(this.jdField_a_of_type_JavaLangString).optString("extendInfo");
      ApolloGameUtil.a(CmGameSubProcessHandler.a(this.this$0), str, new CmGameSubProcessHandler.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.1
 * JD-Core Version:    0.7.0.1
 */