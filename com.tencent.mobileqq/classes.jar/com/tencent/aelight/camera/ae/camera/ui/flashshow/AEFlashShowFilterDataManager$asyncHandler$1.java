package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.os.Handler.Callback;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"}, k=3, mv={1, 1, 16})
final class AEFlashShowFilterDataManager$asyncHandler$1
  implements Handler.Callback
{
  AEFlashShowFilterDataManager$asyncHandler$1(AEFlashShowFilterDataManager paramAEFlashShowFilterDataManager) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AEFlashShowFilterDataManager localAEFlashShowFilterDataManager = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramMessage, "it");
    return AEFlashShowFilterDataManager.a(localAEFlashShowFilterDataManager, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager.asyncHandler.1
 * JD-Core Version:    0.7.0.1
 */