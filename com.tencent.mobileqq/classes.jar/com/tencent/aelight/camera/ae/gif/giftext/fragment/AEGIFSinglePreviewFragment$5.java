package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AEGIFSinglePreviewFragment$5
  implements EIPCResultCallback
{
  AEGIFSinglePreviewFragment$5(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD onCallback");
    if (paramEIPCResult.code == 0)
    {
      QLog.d("AEGIFSinglePreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code == 0");
      return;
    }
    QLog.d("AEGIFSinglePreviewFragment", 4, new Object[] { "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code != 0, eipcResult.code == ", Integer.valueOf(paramEIPCResult.code), ", msg = ", paramEIPCResult.e.getMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */