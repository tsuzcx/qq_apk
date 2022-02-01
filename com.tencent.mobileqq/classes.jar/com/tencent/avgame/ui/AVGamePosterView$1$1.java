package com.tencent.avgame.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import nhn;

class AVGamePosterView$1$1
  implements Runnable
{
  AVGamePosterView$1$1(AVGamePosterView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.a)) {
      str = this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0.a();
    }
    for (;;)
    {
      Object localObject1 = new File(str);
      try
      {
        localObject1 = new FileOutputStream((File)localObject1);
        this.jdField_a_of_type_AndroidGraphicsBitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject1);
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        if (AVGamePosterView.a(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0) != null) {
          AVGamePosterView.a(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0).b(str);
        }
        return;
        str = this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.a;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView.1.1
 * JD-Core Version:    0.7.0.1
 */