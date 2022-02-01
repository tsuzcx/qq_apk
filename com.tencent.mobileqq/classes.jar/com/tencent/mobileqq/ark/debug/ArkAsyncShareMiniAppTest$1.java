package com.tencent.mobileqq.ark.debug;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessor;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class ArkAsyncShareMiniAppTest$1
  implements IArkMessagePreprocessor
{
  ArkAsyncShareMiniAppTest$1(ArkAsyncShareMiniAppTest paramArkAsyncShareMiniAppTest) {}
  
  public boolean needProcess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.mArkMessagePreprocessor needProcess=", Boolean.valueOf(true) });
    }
    return true;
  }
  
  public void process(JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process msgJson=", paramJSONObject.toString() });
    }
    ThreadManager.getFileThreadHandler().postDelayed(new ArkAsyncShareMiniAppTest.1.1(this, paramJSONObject, paramIArkMessagePreprocessorCallback, paramObject), 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1
 * JD-Core Version:    0.7.0.1
 */