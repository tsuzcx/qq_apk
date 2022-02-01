package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class AEGIFChunkPreviewFragment$7
  implements EIPCResultCallback
{
  AEGIFChunkPreviewFragment$7(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD onCallback");
    if (paramEIPCResult.code == 0)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code == 0");
      return;
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code != 0, eipcResult.code == ", Integer.valueOf(paramEIPCResult.code), ", msg = ", paramEIPCResult.e.getMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */