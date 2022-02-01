package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.mobileqq.ark.util.NetUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class ArkMultiProc$3
  implements IArkDelegateNet
{
  public void get(String paramString, HashMap<String, String> paramHashMap, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback)
  {
    QLog.d("ArkApp.MultiProc", 1, new Object[] { "http.get url=", paramString });
    NetUtil.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString, paramHashMap, new ArkMultiProc.3.1(this, paramIArkDelegateHTTPCallback));
  }
  
  public int getNetworkType()
  {
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return -1;
            }
            return 5;
          }
          return 4;
        }
        return 3;
      }
      return 1;
    }
    return 0;
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(null);
  }
  
  public void post(String paramString, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback)
  {
    QLog.d("ArkApp.MultiProc", 1, new Object[] { "http.post url=", paramString });
    NetUtil.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString, paramArrayOfByte, paramHashMap, new ArkMultiProc.3.2(this, paramIArkDelegateHTTPCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.3
 * JD-Core Version:    0.7.0.1
 */