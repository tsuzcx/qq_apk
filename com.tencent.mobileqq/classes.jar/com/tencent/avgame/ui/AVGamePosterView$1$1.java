package com.tencent.avgame.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import njc;

class AVGamePosterView$1$1
  implements Runnable
{
  AVGamePosterView$1$1(AVGamePosterView.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.a)) {}
    for (String str = this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0.a();; str = this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.a)
    {
      Object localObject1 = new File(str);
      try
      {
        localFileOutputStream = new FileOutputStream((File)localObject1);
        localObject1 = localFileOutputStream;
        if (localFileOutputStream == null) {}
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          if (0 == 0) {
            break;
          }
          try
          {
            throw new NullPointerException();
          }
          catch (Exception localException1)
          {
            Object localObject2 = null;
          }
        }
      }
      catch (IOException localIOException)
      {
        while (0 != 0) {
          try
          {
            throw new NullPointerException();
          }
          catch (Exception localException2)
          {
            Object localObject3 = null;
          }
        }
      }
      finally
      {
        if (0 == 0) {}
      }
      try
      {
        localFileOutputStream.close();
        localObject1 = localFileOutputStream;
      }
      catch (Exception localException3)
      {
        try
        {
          throw new NullPointerException();
          throw localObject4;
          localException3 = localException3;
          localObject5 = localFileOutputStream;
        }
        catch (Exception localException4)
        {
          break label171;
        }
        Object localObject5 = null;
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject1);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      if (AVGamePosterView.a(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0) != null) {
        AVGamePosterView.a(this.jdField_a_of_type_ComTencentAvgameUiAVGamePosterView$1.this$0).b(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGamePosterView.1.1
 * JD-Core Version:    0.7.0.1
 */