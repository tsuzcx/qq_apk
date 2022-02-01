package com.tencent.avgame.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import nih;
import nim;

public class GuessPictureGamePaintLogic$1
  implements Runnable
{
  public GuessPictureGamePaintLogic$1(nim paramnim, View paramView, int paramInt, boolean paramBoolean) {}
  
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
      j = (nim.a(this.this$0) - j) / 2;
      i = (nim.b(this.this$0) - i) / 2;
    }
    synchronized (nim.a(this.this$0))
    {
      nim.a(this.this$0, new nih());
      nim.a(this.this$0).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap.copy(Bitmap.Config.ARGB_8888, false);
      nim.a(this.this$0).e = this.jdField_a_of_type_Int;
      nim.a(this.this$0).c = j;
      nim.a(this.this$0).d = i;
      nim.a(this.this$0).jdField_a_of_type_JavaLangString = "Answer";
      nim.a(this.this$0).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      nim.a(this.this$0, true);
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