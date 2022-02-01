package com.tencent.comic.ipc;

import android.os.Bundle;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import eipc.EIPCResult;
import org.json.JSONObject;

class QQComicIPCModule$ComicConfigCallback
  extends CallBacker
{
  int a;
  
  QQComicIPCModule$ComicConfigCallback(QQComicIPCModule paramQQComicIPCModule, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramLong == 1000L) && ("vipComic_config_v2.json".equals(paramString1)))
    {
      paramString1 = VasUpdateUtil.a(AppHelper.b(), paramString1, false, null);
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("config_json", paramString1.toString());
        this.b.callbackResult(this.a, EIPCResult.createResult(0, paramString2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ipc.QQComicIPCModule.ComicConfigCallback
 * JD-Core Version:    0.7.0.1
 */