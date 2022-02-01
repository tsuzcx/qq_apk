package com.tencent.mobileqq.apollo.ipc.business;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

class Cm3DMakeupImpl$2
  extends TransProcessorHandler
{
  Cm3DMakeupImpl$2(Cm3DMakeupImpl paramCm3DMakeupImpl, Looper paramLooper, ICm3DMakeup.Save3DFaceListener paramSave3DFaceListener, ITransFileController paramITransFileController)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg != null)
    {
      if (localFileMsg.fileType != 24) {
        return;
      }
      if (localFileMsg.commandId != 79) {
        return;
      }
      switch (paramMessage.what)
      {
      case 1002: 
      default: 
      case 1005: 
        paramMessage = new StringBuilder();
        paramMessage.append("[mTransProcessorHandler] upload cmshow3D face data error:");
        paramMessage.append(localFileMsg.serverPath);
        QLog.e("[cmshow]Cm3DMakeupImpl", 1, paramMessage.toString());
        this.a.a();
        return;
      case 1004: 
        paramMessage = new StringBuilder();
        paramMessage.append("upload cmshow cmshow3D face data cancel:");
        paramMessage.append(localFileMsg.serverPath);
        QLog.i("[cmshow]Cm3DMakeupImpl", 1, paramMessage.toString());
        return;
      case 1003: 
        paramMessage = new StringBuilder();
        paramMessage.append("finish upload cmshow3D face data");
        paramMessage.append(localFileMsg.serverPath);
        QLog.d("[cmshow]Cm3DMakeupImpl", 2, paramMessage.toString());
        paramMessage = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          paramMessage.mergeFrom(localFileMsg.bdhExtendInfo);
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          this.a.a(paramMessage);
          if (this.b != null)
          {
            this.b.removeHandle(this);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          QLog.e("[cmshow]Cm3DMakeupImpl", 1, new Object[] { "send cmshow3D face data error!", paramMessage.getMessage() });
          return;
        }
      case 1001: 
        QLog.d("[cmshow]Cm3DMakeupImpl", 0, "start upload cmshow3D face data");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.Cm3DMakeupImpl.2
 * JD-Core Version:    0.7.0.1
 */