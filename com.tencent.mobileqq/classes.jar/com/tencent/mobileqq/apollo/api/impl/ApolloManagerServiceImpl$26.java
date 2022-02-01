package com.tencent.mobileqq.apollo.api.impl;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.apollo.api.listener.Save3DFaceListener;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloManagerServiceImpl$26
  extends TransProcessorHandler
{
  ApolloManagerServiceImpl$26(ApolloManagerServiceImpl paramApolloManagerServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 24)) {}
    for (;;)
    {
      return;
      if (localFileMsg.commandId == 79) {
        switch (paramMessage.what)
        {
        case 1002: 
        default: 
          return;
        case 1001: 
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 0, "start upload cmshow3D face data");
            return;
          }
          break;
        case 1003: 
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, "finish upload cmshow3D face data" + localFileMsg.serverPath);
          }
          paramMessage = new Bdh_extinfo.UploadPicExtInfo();
          try
          {
            paramMessage.mergeFrom(localFileMsg.bdhExtendInfo);
            paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
            if ((paramMessage != null) && (ApolloManagerServiceImpl.access$2700(this.a) != null) && (ApolloManagerServiceImpl.access$2700(this.a).get() != null)) {
              ((Save3DFaceListener)ApolloManagerServiceImpl.access$2700(this.a).get()).a(paramMessage);
            }
            if (ApolloManagerServiceImpl.access$2800(this.a) != null)
            {
              ApolloManagerServiceImpl.access$2800(this.a).removeHandle(this);
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
      }
    }
    QLog.e("ApolloManager", 1, "[mTransProcessorHandler] upload cmshow3D face data error:" + localFileMsg.serverPath);
    ((Save3DFaceListener)ApolloManagerServiceImpl.access$2700(this.a).get()).a();
    return;
    QLog.i("ApolloManager", 1, "upload cmshow cmshow3D face data cancel:" + localFileMsg.serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.26
 * JD-Core Version:    0.7.0.1
 */