package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

class Makeup3DJsModule$3
  implements IApolloResManager.ApolloDressInfoListener
{
  Makeup3DJsModule$3(Makeup3DJsModule paramMakeup3DJsModule, String paramString, int paramInt) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleCmShowLoad3DFaceDress] onGetApolloDressInfo: ");
    localStringBuilder.append(paramHashMap);
    localStringBuilder.append(", errMsg: ");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]Makeup3DJsModule", 1, localStringBuilder.toString());
    if (paramHashMap == null)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] onGetApolloDressInfo apolloDressInfo is null! ");
      this.c.a(this.a, "apolloDressInfo is null");
      return;
    }
    paramHashMap = (String)paramHashMap.get(Integer.valueOf(this.b));
    if (TextUtils.isEmpty(paramHashMap))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] dressPath is empty!");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new Makeup3DJsModule.3.1(this, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule.3
 * JD-Core Version:    0.7.0.1
 */