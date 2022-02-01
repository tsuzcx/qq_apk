package com.tencent.mobileqq.apollo.process.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CmGameCommonShare$2
  implements Runnable
{
  CmGameCommonShare$2(CmGameCommonShare paramCmGameCommonShare, int paramInt, Bitmap paramBitmap, File paramFile) {}
  
  public void run()
  {
    int n;
    Object localObject1;
    int i;
    int j;
    int k;
    try
    {
      m = (int)DeviceInfoUtil.i() / 4;
      localBitmap = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localObject2 = QRUtils.a("https://cmshow.qq.com/apollo/html/game-platform/scan-game.html?gameId=" + this.jdField_a_of_type_Int, -1);
      n = ((BitMatrix)localObject2).a();
      localObject1 = new int[n * n];
      i = 0;
    }
    catch (Exception localException)
    {
      int m;
      Bitmap localBitmap;
      Canvas localCanvas;
      Object localObject2;
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, "drawQRBitmap e:", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return;
    }
    if (j < n) {
      if (((BitMatrix)localObject2).a(j, i)) {
        k = -16777216;
      }
    }
    label355:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(n, n, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, n, 0, 0, n, n);
      localObject1 = new Rect(0, 0, m, m);
      localCanvas.drawBitmap((Bitmap)localObject2, new Rect(0, 0, n, n), (Rect)localObject1, null);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        i = m * 8 / 41;
        j = (m - i) / 2;
        k = (m - i) / 2;
        localCanvas.save();
        localCanvas.translate(j, k);
        localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, i, i), null);
        localCanvas.restore();
      }
      ((Bitmap)localObject2).recycle();
      ImageUtil.a(localBitmap, this.jdField_a_of_type_JavaIoFile);
      QLog.d("apollo_cmGame_CmGameCommonShare", 2, "checkDefaultQRSharePic end");
      return;
      for (;;)
      {
        if (i >= n) {
          break label355;
        }
        j = 0;
        break;
        for (;;)
        {
          localObject1[(i * n + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.2
 * JD-Core Version:    0.7.0.1
 */