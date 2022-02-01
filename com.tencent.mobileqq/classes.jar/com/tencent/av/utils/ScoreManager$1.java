package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.ArResourceConfigUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ScoreManager$1
  implements INetEngineListener
{
  ScoreManager$1(ScoreManager.DownloadInfo paramDownloadInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramNetResp.mResult == 0)
        {
          File localFile = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
          String str = PortalUtils.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            paramNetResp = new File(this.a.c);
            ArResourceConfigUtils.a(this.a.c, paramNetResp.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + paramNetResp.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + ImageResUtil.a("qav_score_good.jpg") + ", qav_score_normal : " + ImageResUtil.a("qav_score_normal.jpg") + ", qav_score_bad : " + ImageResUtil.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception paramNetResp)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((HttpNetReq)paramNetReq).mReqUrl + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager.1
 * JD-Core Version:    0.7.0.1
 */