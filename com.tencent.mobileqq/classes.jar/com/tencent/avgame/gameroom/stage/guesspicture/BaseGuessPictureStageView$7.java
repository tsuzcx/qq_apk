package com.tencent.avgame.gameroom.stage.guesspicture;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.avgame.util.MosaicUtil;

class BaseGuessPictureStageView$7
  implements Runnable
{
  BaseGuessPictureStageView$7(BaseGuessPictureStageView paramBaseGuessPictureStageView, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    Bitmap localBitmap = MosaicUtil.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int);
    Message localMessage = this.this$0.a.obtainMessage();
    localMessage.obj = localBitmap;
    localMessage.what = 1;
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.7
 * JD-Core Version:    0.7.0.1
 */