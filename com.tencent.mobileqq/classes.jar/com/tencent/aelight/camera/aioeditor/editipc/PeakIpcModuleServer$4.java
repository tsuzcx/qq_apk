package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class PeakIpcModuleServer$4
  extends TransProcessorHandler
{
  PeakIpcModuleServer$4(PeakIpcModuleServer paramPeakIpcModuleServer, ITransFileController paramITransFileController, String paramString) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = (FileMsg)paramMessage.obj;
    if (localObject2 != null)
    {
      if (((FileMsg)localObject2).fileType != 24) {
        return;
      }
      if (((FileMsg)localObject2).commandId != 82) {
        return;
      }
      Bundle localBundle = new Bundle();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uploadVideo--transProcessorHandler--handleMessage: what=");
      ((StringBuilder)localObject1).append(paramMessage.what);
      AEQLog.a("PeakIpcModuleServer", ((StringBuilder)localObject1).toString());
      int i = paramMessage.what;
      if (i != 1008) {
        switch (i)
        {
        default: 
          return;
        case 1005: 
          this.a.removeHandle(this);
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.b, "action_upload_ark_video_fail", localBundle, null);
          return;
        case 1004: 
          this.a.removeHandle(this);
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.b, "action_upload_ark_video_cancel", localBundle, null);
          return;
        case 1002: 
          double d1 = ((FileMsg)localObject2).transferedSize;
          Double.isNaN(d1);
          double d2 = ((FileMsg)localObject2).fileSize;
          Double.isNaN(d2);
          localBundle.putInt("key_upload_ark_video_progress", (int)(d1 * 1.0D / d2 * 100.0D));
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.b, "action_upload_ark_video_progress_update", localBundle, null);
          return;
        }
      }
      this.a.removeHandle(this);
      localObject1 = null;
      Bdh_extinfo.UploadPicExtInfo localUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
      paramMessage = (Message)localObject1;
      try
      {
        localUploadPicExtInfo.mergeFrom(((FileMsg)localObject2).bdhExtendInfo);
        paramMessage = (Message)localObject1;
        localObject1 = localUploadPicExtInfo.bytes_download_url.get().toStringUtf8();
        paramMessage = (Message)localObject1;
        localObject2 = new StringBuilder();
        paramMessage = (Message)localObject1;
        ((StringBuilder)localObject2).append("uploadVideo--transProcessorHandler--handleMessage: videoDownloadUrl=");
        paramMessage = (Message)localObject1;
        ((StringBuilder)localObject2).append((String)localObject1);
        paramMessage = (Message)localObject1;
        AEQLog.b("PeakIpcModuleServer", ((StringBuilder)localObject2).toString());
        paramMessage = (Message)localObject1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        AEQLog.a("PeakIpcModuleServer", "uploadVideo--transProcessorHandler--parse downUrl error:", localInvalidProtocolBufferMicroException);
      }
      if (!TextUtils.isEmpty(paramMessage))
      {
        localBundle.putString("key_upload_ark_video_download_url", paramMessage);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.b, "action_upload_ark_video_success", localBundle, null);
        return;
      }
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", this.b, "action_upload_ark_video_fail", localBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer.4
 * JD-Core Version:    0.7.0.1
 */