package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class GuessPictureGamePaintLogic$1
  implements Runnable
{
  GuessPictureGamePaintLogic$1(GuessPictureGamePaintLogic paramGuessPictureGamePaintLogic, View paramView, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
    int j;
    int i;
    if (localBitmap != null)
    {
      j = this.jdField_a_of_type_AndroidViewView.getWidth();
      i = this.jdField_a_of_type_AndroidViewView.getHeight();
      j = (GuessPictureGamePaintLogic.a(this.this$0) - j) / 2;
      i = (GuessPictureGamePaintLogic.b(this.this$0) - i) / 2;
    }
    synchronized (GuessPictureGamePaintLogic.a(this.this$0))
    {
      GuessPictureGamePaintLogic.a(this.this$0, new GameImageData());
      GuessPictureGamePaintLogic.a(this.this$0).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      GuessPictureGamePaintLogic.a(this.this$0).e = this.jdField_a_of_type_Int;
      GuessPictureGamePaintLogic.a(this.this$0).c = j;
      GuessPictureGamePaintLogic.a(this.this$0).d = i;
      GuessPictureGamePaintLogic.a(this.this$0).jdField_a_of_type_JavaLangString = "Answer";
      GuessPictureGamePaintLogic.a(this.this$0).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      GuessPictureGamePaintLogic.a(this.this$0, true);
      this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(false);
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGamePaintLogic", 2, "onAnswerViewShow indeed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessPictureGamePaintLogic.1
 * JD-Core Version:    0.7.0.1
 */