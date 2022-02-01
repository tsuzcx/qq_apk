package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
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
    String str2;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = paramNetResp.mReq.mOutPath;
      String str1 = FileUtils.calcMd5(paramNetResp);
      str2 = this.a;
      if ((str1 == null) || (!str1.equalsIgnoreCase(this.b))) {}
    }
    try
    {
      FileUtils.uncompressZip(paramNetResp, str2, false);
      QQAlbumUtils.a(str2);
      bool = true;
    }
    catch (IOException localIOException)
    {
      boolean bool;
      label81:
      break label81;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but unzip is failed");
      break label112;
      if (QLog.isColorLevel()) {
        QLog.d("PokeEmo", 2, "downloadRes.onResp download succ but md5 is mismatched");
      }
    }
    label112:
    bool = false;
    FileUtils.deleteFile(paramNetResp);
    break label138;
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo", 2, "downloadRes.onResp failed ");
    }
    bool = false;
    label138:
    if (bool)
    {
      SharedPreUtils.a(true);
      PokeItemHelper.b = true;
    }
    else
    {
      PokeItemHelper.o += 1;
    }
    if (QLog.isColorLevel())
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("downloadRes.onResp download result = ");
      paramNetResp.append(bool);
      QLog.d("PokeEmo", 2, paramNetResp.toString());
    }
    PokeItemHelper.c = false;
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.5
 * JD-Core Version:    0.7.0.1
 */