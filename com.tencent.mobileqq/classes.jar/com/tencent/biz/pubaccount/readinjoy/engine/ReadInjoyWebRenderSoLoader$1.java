package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import aplw;
import aplx;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ndd;
import org.json.JSONObject;
import oxi;
import oxk;
import oxo;

public final class ReadInjoyWebRenderSoLoader$1
  implements Runnable
{
  public ReadInjoyWebRenderSoLoader$1(oxk paramoxk) {}
  
  public void run()
  {
    Object localObject = oxo.b();
    int j;
    int i;
    label124:
    boolean bool;
    for (;;)
    {
      try
      {
        String str = ndd.a(BaseApplication.context, (String)localObject, "GET", null, null);
        if (QLog.isColorLevel()) {
          QLog.d("viola.ReadInjoyWebRenderSoLoader", 2, "open :" + (String)localObject + ", result: " + str);
        }
        if (TextUtils.isEmpty(str))
        {
          oxo.a();
          oxi.a("viola.ReadInjoyWebRenderSoLoader", this.a);
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
        oxo.a();
        oxo.b();
        return;
      }
      if (j < aplx.a.length)
      {
        if ((!bool) || (!oxo.b(aplx.a[j]))) {
          break label296;
        }
        bool = true;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delJSC : " + bool);
      }
      oxo.a();
      if (i != 0)
      {
        i = 0;
        bool = true;
        if (i < aplw.a.length)
        {
          if ((!bool) || (!oxo.b(aplw.a[i]))) {
            break label308;
          }
          bool = true;
          break label301;
        }
        if (QLog.isColorLevel()) {
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 2, "checkReinstallSoDel delBiz : " + bool);
        }
      }
      oxo.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader.1
 * JD-Core Version:    0.7.0.1
 */