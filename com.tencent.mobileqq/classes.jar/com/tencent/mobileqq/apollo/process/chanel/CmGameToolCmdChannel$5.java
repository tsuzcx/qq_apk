package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class CmGameToolCmdChannel$5
  implements Runnable
{
  CmGameToolCmdChannel$5(int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam;
    try
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(this.jdField_a_of_type_Int);
      if ((localCmGameLauncher == null) || (localCmGameLauncher.a() == null))
      {
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, "cmd:" + this.jdField_a_of_type_JavaLangString + "cmGameLauncher == null || cmGameLauncher.getCheckParam() == null");
        return;
      }
      localStartCheckParam = localCmGameLauncher.a();
      if (TextUtils.isEmpty(localStartCheckParam.mTempAIOUin))
      {
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, "cmd:" + this.jdField_a_of_type_JavaLangString + "startCheckParam.mTempAIOUin is empty");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
      return;
    }
    JSONObject localJSONObject = new JSONObject(this.b);
    localJSONObject.put("friendUin", localStartCheckParam.mTempAIOUin);
    localJSONObject.put("nickName", localStartCheckParam.mTempAIONickName);
    localJSONObject.put("robotOpenId", localStartCheckParam.mRobotOpenId);
    localJSONObject.put("gameId", this.jdField_a_of_type_Int);
    CmGameToolCmdChannel.a(this.jdField_a_of_type_JavaLangString, localJSONObject.toString(), false, null, this.jdField_a_of_type_Int);
    Activity localActivity = localException.a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel.5
 * JD-Core Version:    0.7.0.1
 */