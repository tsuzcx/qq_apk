package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.earlydownload.handler.ViolaBizLibHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class ReadInjoyWebRenderSoLoader$1
  implements Runnable
{
  ReadInjoyWebRenderSoLoader$1(ReadInJoyWebRenderEngine.LoadLibCallback paramLoadLibCallback) {}
  
  public void run()
  {
    Object localObject = ReadInjoyWebRenderSoLoader.b();
    int j;
    int i;
    label124:
    boolean bool;
    for (;;)
    {
      try
      {
        String str = HttpUtil.openUrl(BaseApplication.context, (String)localObject, "GET", null, null);
        if (QLog.isColorLevel()) {
          QLog.d("viola.ReadInjoyWebRenderSoLoader", 2, "open :" + (String)localObject + ", result: " + str);
        }
        if (TextUtils.isEmpty(str))
        {
          ReadInjoyWebRenderSoLoader.a();
          ReadInJoyWebRenderEngine.a("viola.ReadInjoyWebRenderSoLoader", this.a);
          return;
        }
        localObject = new JSONObject(str);
        if (((JSONObject)localObject).optInt("reJSC", 0) != 1) {
          break label286;
        }
        j = 1;
        if (((JSONObject)localObject).optInt("reBiz", 0) != 1) {
          break label291;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        label183:
        ReadInjoyWebRenderSoLoader.a();
        ReadInjoyWebRenderSoLoader.b();
        return;
      }
      if (j < ViolaLibHandler.a.length)
      {
        if ((!bool) || (!ReadInjoyWebRenderSoLoader.b(ViolaLibHandler.a[j]))) {
          break label296;
        }
        bool = true;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delJSC : " + bool);
      }
      ReadInjoyWebRenderSoLoader.a();
      if (i != 0)
      {
        i = 0;
        bool = true;
        if (i < ViolaBizLibHandler.a.length)
        {
          if ((!bool) || (!ReadInjoyWebRenderSoLoader.b(ViolaBizLibHandler.a[i]))) {
            break label308;
          }
          bool = true;
          break label301;
        }
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delBiz : " + bool);
        }
      }
      ReadInjoyWebRenderSoLoader.b();
      continue;
      label268:
      if (j == 0) {
        break label294;
      }
      j = 0;
      bool = true;
    }
    for (;;)
    {
      j += 1;
      break label124;
      label286:
      j = 0;
      break;
      label291:
      i = 0;
      break label268;
      label294:
      break label183;
      label296:
      bool = false;
    }
    for (;;)
    {
      label301:
      i += 1;
      break;
      label308:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader.1
 * JD-Core Version:    0.7.0.1
 */