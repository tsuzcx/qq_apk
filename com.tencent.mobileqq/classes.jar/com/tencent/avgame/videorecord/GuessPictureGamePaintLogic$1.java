package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import ngm;
import ngr;

public class GuessPictureGamePaintLogic$1
  implements Runnable
{
  public GuessPictureGamePaintLogic$1(ngr paramngr, View paramView, int paramInt, boolean paramBoolean) {}
  
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
      j = (ngr.a(this.this$0) - j) / 2;
      i = (ngr.b(this.this$0) - i) / 2;
    }
    synchronized (ngr.a(this.this$0))
    {
      ngr.a(this.this$0, new ngm());
      ngr.a(this.this$0).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      ngr.a(this.this$0).e = this.jdField_a_of_type_Int;
      ngr.a(this.this$0).c = j;
      ngr.a(this.this$0).d = i;
      ngr.a(this.this$0).jdField_a_of_type_JavaLangString = "Answer";
      ngr.a(this.this$0).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      ngr.a(this.this$0, true);
      this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(false);
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureGamePaintLogic", 2, "onAnswerViewShow indeed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.videorecord.GuessPictureGamePaintLogic.1
 * JD-Core Version:    0.7.0.1
 */