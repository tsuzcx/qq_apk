package com.tencent.mobileqq.apollo.game.process.chanel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class CmGameToolCmdChannel$5
  implements Runnable
{
  CmGameToolCmdChannel$5(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
      if ((localObject != null) && (((CmGameLauncher)localObject).a() != null))
      {
        StartCheckParam localStartCheckParam = ((CmGameLauncher)localObject).a();
        if (TextUtils.isEmpty(localStartCheckParam.mTempAIOUin))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("startCheckParam.mTempAIOUin is empty");
          QLog.e("cmgame_process.CmGameToolCmdChannel", 1, ((StringBuilder)localObject).toString());
          return;
        }
        JSONObject localJSONObject = new JSONObject(this.b);
        localJSONObject.put("friendUin", localStartCheckParam.mTempAIOUin);
        localJSONObject.put("nickName", localStartCheckParam.mTempAIONickName);
        localJSONObject.put("robotOpenId", localStartCheckParam.mRobotOpenId);
        localJSONObject.put("gameId", this.jdField_a_of_type_Int);
        CmGameToolCmdChannel.a(this.jdField_a_of_type_JavaLangString, localJSONObject.toString(), false, null, this.jdField_a_of_type_Int);
        localObject = ((CmGameLauncher)localObject).a();
        if (localObject != null) {
          ((Activity)localObject).finish();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cmd:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("cmGameLauncher == null || cmGameLauncher.getCheckParam() == null");
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameToolCmdChannel.5
 * JD-Core Version:    0.7.0.1
 */