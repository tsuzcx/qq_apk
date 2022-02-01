package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.io.IOException;

final class PokeItemHelper$5
  implements INetEngineListener
{
  PokeItemHelper$5(String paramString1, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "pe res download repeating ");
      }
      return;
    }
    boolean bool;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = paramNetResp.mReq.mOutPath;
      String str1 = FileUtils.c(paramNetResp);
      String str2 = this.a;
      if ((str1 != null) && (str1.equalsIgnoreCase(this.b)))
      {
        try
        {
          FileUtils.a(paramNetResp, str2, false);
          MediaUtil.a(str2);
          bool = true;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            label83:
            if (QLog.isColorLevel()) {
              QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but unzip is failed");
            }
            bool = false;
          }
        }
        FileUtils.e(paramNetResp);
        if (!bool) {
          break label189;
        }
        SharedPreUtils.a(true);
        PokeItemHelper.b = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download result = " + bool);
      }
      PokeItemHelper.c = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but md5 is mismatched");
      }
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp failed ");
      }
      bool = false;
      break label83;
      label189:
      PokeItemHelper.o += 1;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.5
 * JD-Core Version:    0.7.0.1
 */