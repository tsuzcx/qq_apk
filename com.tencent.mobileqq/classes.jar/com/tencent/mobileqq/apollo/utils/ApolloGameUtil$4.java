package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ApolloGameUtil$4
  implements Runnable
{
  ApolloGameUtil$4(String paramString, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      long l = ((JSONObject)localObject).optLong("taskId");
      localObject = SpriteRscBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (JSONObject)localObject);
      if (localObject == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", 0);
      localJSONObject.put("actionInfo", localObject);
      localJSONObject.put("taskId", l);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameUtil", 2, new Object[] { "ReqAction,", localJSONObject.toString() });
      }
      ApolloUtilImpl.getCmdChannel().callbackFromRequest(this.jdField_a_of_type_Long, 0, "sc.script_notify_action_ready.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.4
 * JD-Core Version:    0.7.0.1
 */