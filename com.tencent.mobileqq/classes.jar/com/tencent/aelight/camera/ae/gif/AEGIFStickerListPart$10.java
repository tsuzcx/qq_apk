package com.tencent.aelight.camera.ae.gif;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.log.AEQLog;

class AEGIFStickerListPart$10
  implements DialogInterface.OnCancelListener
{
  AEGIFStickerListPart$10(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AEQLog.a("AEGIFStickerListPart", "[mTakeSameLoadingDialog.onCancel]");
    AEGIFStickerListPart.a(this.a, null);
    AEGifMaterialManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.10
 * JD-Core Version:    0.7.0.1
 */