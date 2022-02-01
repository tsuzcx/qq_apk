package com.tencent.luggage.wxa.be;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import com.tencent.luggage.wxa.f.f;
import com.tencent.luggage.wxa.f.h;
import com.tencent.luggage.wxa.f.h.a;
import com.tencent.luggage.wxa.f.q;
import com.tencent.luggage.wxa.g.a;
import com.tencent.luggage.wxa.g.b;
import com.tencent.luggage.wxa.qz.o;

class e$1
  extends h.a
{
  e$1(e parame) {}
  
  public void a(h paramh)
  {
    super.a(paramh);
    o.d("MicroMsg.LuggageRecordView", "onCameraOpened: open success");
    this.a.q();
    if (e.a(this.a) != null) {
      e.a(this.a).a();
    }
  }
  
  public void a(h paramh, String paramString)
  {
    super.a(paramh, paramString);
    if (e.c(this.a) != null) {
      e.c(this.a).a(false);
    }
  }
  
  public void a(h paramh, byte[] paramArrayOfByte)
  {
    super.a(paramh, paramArrayOfByte);
    int i;
    int k;
    label221:
    label230:
    label236:
    float f;
    if (e.b(this.a) != null)
    {
      try
      {
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
        Matrix localMatrix = new Matrix();
        i = b.a(paramh.getCameraOrientation());
        if (((paramh.getPreviewSize().b() <= paramh.getPreviewSize().a()) || (paramArrayOfByte.getHeight() <= paramArrayOfByte.getWidth())) && ((paramh.getPreviewSize().b() >= paramh.getPreviewSize().a()) || (paramArrayOfByte.getHeight() >= paramArrayOfByte.getWidth()) || ((i != 90) && (i != 270)))) {
          break label446;
        }
        localMatrix.postRotate(i);
        i = 1;
        if (this.a.p())
        {
          localMatrix.postScale(-1.0F, 1.0F);
          i = 1;
        }
        paramh = paramArrayOfByte;
        if (i != 0) {
          paramh = Bitmap.createBitmap(paramArrayOfByte, 0, 0, paramArrayOfByte.getWidth(), paramArrayOfByte.getHeight(), localMatrix, true);
        }
        k = b.a(this.a.g());
        if ((k != 0) && (k != 180)) {
          i = paramh.getHeight();
        } else {
          i = paramh.getWidth();
        }
      }
      catch (Exception paramh)
      {
        int j;
        f.c("MicroMsg.LuggageRecordView", "onPictureTaken decode bitmap error", paramh);
        e.b(this.a).a();
      }
      j = paramh.getWidth();
      break label236;
      j = paramh.getHeight();
      if (this.a.a == null) {
        break label468;
      }
      f = this.a.a.getDisplayRatio();
    }
    for (;;)
    {
      paramArrayOfByte = a.a(i, j, k, f);
      if (paramArrayOfByte != null)
      {
        if ((paramArrayOfByte.x <= i) && (paramArrayOfByte.y <= j))
        {
          paramArrayOfByte = Bitmap.createBitmap(paramh, paramh.getWidth() - paramArrayOfByte.x >> 1, paramh.getHeight() - paramArrayOfByte.y >> 1, paramArrayOfByte.x, paramArrayOfByte.y);
          paramh.recycle();
          e.b(this.a).a(paramArrayOfByte);
          return;
        }
        o.c("MicroMsg.LuggageRecordView", "crop over size, width: %d, height: %d, cropWidth: %d, cropHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramArrayOfByte.x), Integer.valueOf(paramArrayOfByte.y) });
        e.b(this.a).a(paramh);
        return;
      }
      e.b(this.a).a(paramh);
      return;
      return;
      label446:
      i = 0;
      break;
      if (k == 0) {
        break label230;
      }
      if (k != 180) {
        break label221;
      }
      break label230;
      label468:
      f = 0.0F;
    }
  }
  
  public void a(h paramh, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramh, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    this.a.a(paramh, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public void b(h paramh)
  {
    super.b(paramh);
  }
  
  public void c(h paramh)
  {
    super.c(paramh);
    if (e.d(this.a) != null) {
      e.d(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.e.1
 * JD-Core Version:    0.7.0.1
 */