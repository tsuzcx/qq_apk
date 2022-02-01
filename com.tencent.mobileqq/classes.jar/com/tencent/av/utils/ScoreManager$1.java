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
    Object localObject1;
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Download init. url = ");
        ((StringBuilder)localObject1).append(((HttpNetReq)paramNetResp.mReq).mReqUrl);
        QLog.i("ScoreManager", 1, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2;
    if (paramNetResp.mResult == 0)
    {
      localObject1 = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
      localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equalsIgnoreCase(this.a.b))) {}
    }
    try
    {
      paramNetResp = new File(this.a.c);
      localObject1 = this.a.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramNetResp.getParentFile().getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ArResourceConfigUtils.a((String)localObject1, ((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onDownloadComplete  path : ");
        ((StringBuilder)localObject1).append(paramNetResp.getParentFile().getAbsolutePath());
        QLog.i("ScoreManager", 1, ((StringBuilder)localObject1).toString());
      }
      if (!QLog.isColorLevel()) {
        break label406;
      }
      paramNetResp = new StringBuilder();
      paramNetResp.append("qav_score_good : ");
      paramNetResp.append(ImageResUtil.a("qav_score_good.jpg"));
      paramNetResp.append(", qav_score_normal : ");
      paramNetResp.append(ImageResUtil.a("qav_score_normal.jpg"));
      paramNetResp.append(", qav_score_bad : ");
      paramNetResp.append(ImageResUtil.a("qav_score_bad.jpg"));
      QLog.i("ScoreManager", 1, paramNetResp.toString());
      return;
    }
    catch (Exception paramNetResp)
    {
      label290:
      StringBuilder localStringBuilder;
      label406:
      break label290;
    }
    new File(this.a.c).delete();
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
    }
    return;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download end. MD5 check error. url = ");
      localStringBuilder.append(((HttpNetReq)paramNetResp.mReq).mReqUrl);
      localStringBuilder.append(", fileName = ");
      localStringBuilder.append(((File)localObject1).getAbsolutePath());
      localStringBuilder.append(", fileMD5 = ");
      localStringBuilder.append((String)localObject2);
      QLog.i("ScoreManager", 1, localStringBuilder.toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateProgeress. url = ");
      localStringBuilder.append(((HttpNetReq)paramNetReq).mReqUrl);
      localStringBuilder.append(", total size = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", cur downloaded size = ");
      localStringBuilder.append(paramLong1);
      QLog.d("ScoreManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.ScoreManager.1
 * JD-Core Version:    0.7.0.1
 */