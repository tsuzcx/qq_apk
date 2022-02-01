package com.tencent.avgame.gameroom.stage.guesspicture;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import nic;

class GuessPictureStageView$7
  implements Runnable
{
  GuessPictureStageView$7(GuessPictureStageView paramGuessPictureStageView, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    Bitmap localBitmap = nic.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int);
    Message localMessage = GuessPictureStageView.a(this.this$0).obtainMessage();
    localMessage.obj = localBitmap;
    localMessage.what = 1;
    GuessPictureStageView.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView.7
 * JD-Core Version:    0.7.0.1
 */