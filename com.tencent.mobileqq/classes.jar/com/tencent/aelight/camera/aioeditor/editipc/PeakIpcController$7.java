package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.aelight.camera.log.AEQLog;
import eipc.EIPCModule;
import eipc.EIPCResult;

final class PeakIpcController$7
  extends EIPCModule
{
  PeakIpcController$7(String paramString1, String paramString2, PeakIpcController.IUploadArkVideoCallback paramIUploadArkVideoCallback)
  {
    super(paramString1);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    if ("action_upload_ark_video_progress_update".equals(paramString))
    {
      if (paramBundle.containsKey("key_upload_ark_video_progress"))
      {
        paramInt = paramBundle.getInt("key_upload_ark_video_progress");
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_JavaLangString);
        paramString.append(" uploadArkVideo progress=");
        paramString.append(paramInt);
        AEQLog.a("PeakIpcController", paramString.toString());
        paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcController$IUploadArkVideoCallback;
        if (paramString != null)
        {
          paramString.a(paramInt);
          return null;
        }
      }
    }
    else if ("action_upload_ark_video_success".equals(paramString))
    {
      if (paramBundle.containsKey("key_upload_ark_video_download_url")) {
        paramString = paramBundle.getString("key_upload_ark_video_download_url");
      } else {
        paramString = null;
      }
      paramBundle = new StringBuilder();
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(" uploadArkVideo SUCCESS: videoDownUrl=");
      paramBundle.append(paramString);
      AEQLog.b("PeakIpcController", paramBundle.toString());
      paramBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcController$IUploadArkVideoCallback;
      if (paramBundle != null)
      {
        paramBundle.a(paramString);
        return null;
      }
    }
    else if ("action_upload_ark_video_fail".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(" uploadArkVideo FAIL");
      AEQLog.b("PeakIpcController", paramString.toString());
      paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcController$IUploadArkVideoCallback;
      if (paramString != null)
      {
        paramString.a();
        return null;
      }
    }
    else if ("action_upload_ark_video_cancel".equals(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(" uploadArkVideo CANCEL");
      AEQLog.b("PeakIpcController", paramString.toString());
      paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditipcPeakIpcController$IUploadArkVideoCallback;
      if (paramString != null) {
        paramString.b();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.7
 * JD-Core Version:    0.7.0.1
 */