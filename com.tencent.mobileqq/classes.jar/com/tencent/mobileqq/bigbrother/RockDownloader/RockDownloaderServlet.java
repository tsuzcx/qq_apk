package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.ServerApi.ErrorInfo;
import com.tencent.mobileqq.bigbrother.ServerApi.ReqPreDownloadRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi.ReqUpdateDownCountRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi.RspUpdateDownCountRecmd;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class RockDownloaderServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloaderServlet", 2, "onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
    Object localObject = paramIntent.getStringExtra("BUNDLE_CMD");
    boolean bool = paramFromServiceMsg.isSuccess();
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new byte[localByteBuffer.getInt() - 4];
      localByteBuffer.get(paramFromServiceMsg);
      if ("QQApkSvc.pre_download_apk".equals(localObject))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putByteArray("BUNDLE_KEY_RESPONSE_BYTE", paramFromServiceMsg);
        if ((paramIntent instanceof NewIntent))
        {
          paramIntent = (NewIntent)paramIntent;
          if (paramIntent.getObserver() != null) {
            paramIntent.getObserver().onReceive(1, bool, (Bundle)localObject);
          }
        }
      }
      else if ("QQApkSvc.update_download_count".equals(localObject))
      {
        paramIntent = new ServerApi.RspUpdateDownCountRecmd();
        paramIntent.mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = (ServerApi.ErrorInfo)paramIntent.err_info.get();
        if (paramFromServiceMsg != null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("RockDownloaderServlet", 2, new Object[] { localObject, " ", Boolean.valueOf(bool), " ", Integer.valueOf(paramIntent.download_num.get()), " ", paramFromServiceMsg.err_msg.get(), " ", Integer.valueOf(paramFromServiceMsg.err_code.get()), " ", paramFromServiceMsg.jump_url.get() });
        }
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RockDownloaderServlet", 2, paramIntent, new Object[0]);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloaderServlet", 2, new Object[] { localObject, " ", Boolean.valueOf(bool), " ", Integer.valueOf(paramIntent.download_num.get()) });
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloaderServlet", 2, "onSend");
    }
    String str = paramIntent.getStringExtra("BUNDLE_CMD");
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloaderServlet", 2, new Object[] { "cmd=", str });
    }
    Object localObject;
    if ("QQApkSvc.pre_download_apk".equals(str))
    {
      localObject = new ServerApi.ReqPreDownloadRecmd();
      ((ServerApi.ReqPreDownloadRecmd)localObject).platform.set("android");
      ((ServerApi.ReqPreDownloadRecmd)localObject).source.set(paramIntent.getStringExtra("BUNDLE_KEY_SOURCE"));
      ((ServerApi.ReqPreDownloadRecmd)localObject).scene.set(paramIntent.getStringExtra("BUNDLE_KEY_SCENE"));
      ((ServerApi.ReqPreDownloadRecmd)localObject).pkg_name.set(paramIntent.getStringExtra("BUNDLE_KEY_PKG_NAME"));
      ((ServerApi.ReqPreDownloadRecmd)localObject).uin.set(paramIntent.getLongExtra("BUNDLE_KEY_UIN", 0L));
      paramPacket.setSSOCommand(str);
      paramPacket.putSendData(WupUtil.a(((ServerApi.ReqPreDownloadRecmd)localObject).toByteArray()));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloaderServlet", 2, "onSendFinish");
      }
      return;
      if ("QQApkSvc.update_download_count".equals(str))
      {
        localObject = new ServerApi.ReqUpdateDownCountRecmd();
        ((ServerApi.ReqUpdateDownCountRecmd)localObject).source.set(paramIntent.getStringExtra("BUNDLE_KEY_SOURCE"));
        ((ServerApi.ReqUpdateDownCountRecmd)localObject).scene.set(paramIntent.getStringExtra("BUNDLE_KEY_SCENE"));
        ((ServerApi.ReqUpdateDownCountRecmd)localObject).pkg_name.set(paramIntent.getStringExtra("BUNDLE_KEY_PKG_NAME"));
        ((ServerApi.ReqUpdateDownCountRecmd)localObject).uin.set(paramIntent.getLongExtra("BUNDLE_KEY_UIN", 0L));
        paramPacket.setSSOCommand(str);
        paramPacket.putSendData(WupUtil.a(((ServerApi.ReqUpdateDownCountRecmd)localObject).toByteArray()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderServlet
 * JD-Core Version:    0.7.0.1
 */