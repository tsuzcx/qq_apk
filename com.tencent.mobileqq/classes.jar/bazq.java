import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

public class bazq
{
  @Nullable
  public static Bitmap a(int paramInt, Bitmap.Config paramConfig, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      throw new IllegalArgumentException("bitmapArray should not be null or empty");
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfBitmap.length);
    int j = paramArrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject = paramArrayOfBitmap[i];
        if (localObject != null)
        {
          localArrayList.add(localObject);
          if (localArrayList.size() < 6) {}
        }
      }
      else
      {
        j = localArrayList.size();
        if (j > 0) {
          break;
        }
        throw new IllegalArgumentException("can not find any bitmap from bitmapArray");
      }
      i += 1;
    }
    paramArrayOfBitmap = paramConfig;
    if (paramConfig == null) {
      paramArrayOfBitmap = Bitmap.Config.RGB_565;
    }
    Object localObject = new bazs[j];
    i = 0;
    while (i < j)
    {
      localObject[i] = new bazs(null);
      i += 1;
    }
    float f = paramInt / 100.0F;
    i = 0;
    RectF localRectF;
    Rect localRect;
    Paint localPaint1;
    Canvas localCanvas;
    Paint localPaint2;
    label295:
    Bitmap localBitmap;
    int k;
    int m;
    if (j == 1)
    {
      localObject[0].a = 0;
      localObject[0].b = 0;
      i = paramInt;
      localRectF = new RectF();
      localRect = new Rect();
      localPaint1 = new Paint();
      localPaint1.setAntiAlias(true);
      localPaint1.setDither(true);
      localPaint1.setFilterBitmap(true);
      paramArrayOfBitmap = Bitmap.createBitmap(paramInt, paramInt, paramArrayOfBitmap);
      paramConfig = null;
      localCanvas = new Canvas(paramArrayOfBitmap);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint2 = new Paint();
      localPaint2.setAntiAlias(true);
      localPaint2.setDither(true);
      localPaint2.setFilterBitmap(true);
      localPaint2.setColor(0);
      paramInt = 0;
      if (paramInt >= j) {
        break label1172;
      }
      localBitmap = (Bitmap)localArrayList.get(paramInt);
      k = i / 2;
      m = i * 3 / 40;
      localRectF.set(localObject[paramInt].a, localObject[paramInt].b, localObject[paramInt].a + i, localObject[paramInt].b + i);
      localRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      if ((paramInt != 1) || (j < 3)) {
        break label1134;
      }
      localPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      localCanvas.drawCircle(localObject[paramInt].a + k, localObject[paramInt].b + k, m + k, localPaint2);
      paramConfig = Bitmap.createBitmap(paramArrayOfBitmap);
      localPaint2.setXfermode(null);
    }
    for (;;)
    {
      localPaint1.setShader(a(localRectF, localBitmap));
      localCanvas.drawCircle(localObject[paramInt].a + k, localObject[paramInt].b + k, k, localPaint1);
      paramInt += 1;
      break label295;
      if (j == 2)
      {
        i = (int)(60.0F * f + 0.5F);
        localObject[0].a = 0;
        localObject[0].b = 0;
        localObject[1].a = (paramInt - i);
        localObject[1].b = (paramInt - i);
        break;
      }
      if (j == 3)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].a = ((paramInt - i) / 2);
        localObject[0].b = ((int)(2.0F * f));
        localObject[1].a = (paramInt - i);
        localObject[1].b = (paramInt - i - (int)(2.0F * f));
        localObject[2].a = 0;
        localObject[2].b = (paramInt - i - (int)(f * 2.0F));
        break;
      }
      if (j == 4)
      {
        i = (int)(52.0F * f + 0.5F);
        localObject[0].a = (paramInt - i);
        localObject[0].b = 0;
        localObject[1].a = (paramInt - i);
        localObject[1].b = (paramInt - i);
        localObject[2].a = 0;
        localObject[2].b = (paramInt - i);
        localObject[3].a = 0;
        localObject[3].b = 0;
        break;
      }
      if (j == 5)
      {
        i = (int)(40.0F * f + 0.5F);
        localObject[0].a = (paramInt - i);
        localObject[0].b = ((int)(24.0F * f + 0.5F));
        localObject[1].a = (paramInt - i - (int)(12.0F * f + 0.5F));
        localObject[1].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].a = ((int)(12.0F * f + 0.5F));
        localObject[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].a = 0;
        localObject[3].b = ((int)(24.0F * f + 0.5F));
        localObject[4].a = ((int)(30.0F * f + 0.5F));
        localObject[4].b = ((int)(f * 2.0F + 0.5F));
        break;
      }
      if (j >= 6)
      {
        i = (int)(36.0F * f + 0.5F);
        localObject[0].b = ((int)(2.0F * f + 0.5F));
        localObject[0].a = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[1].b = ((int)(32.0F * f + 0.5F));
        localObject[1].a = (paramInt - i);
        localObject[2].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[2].a = (paramInt - i - (int)(15.0F * f + 0.5F));
        localObject[3].b = (paramInt - i - (int)(2.0F * f + 0.5F));
        localObject[3].a = ((int)(15.0F * f + 0.5F));
        localObject[4].b = ((int)(32.0F * f + 0.5F));
        localObject[4].a = 0;
        localObject[5].b = ((int)(2.0F * f + 0.5F));
        localObject[5].a = ((int)(f * 15.0F + 0.5F));
      }
      break;
      label1134:
      localCanvas.drawCircle(localObject[paramInt].a + k, localObject[paramInt].b + k, m + k, localPaint2);
    }
    label1172:
    if (paramConfig != null)
    {
      localRectF.set(0.0F, 0.0F, paramConfig.getWidth(), paramConfig.getHeight());
      localRect.set(0, 0, paramConfig.getWidth(), paramConfig.getHeight());
      localPaint1.setShader(null);
      localCanvas.drawBitmap(paramConfig, localRect, localRectF, localPaint1);
    }
    return paramArrayOfBitmap;
  }
  
  public static Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length <= 0)) {
      paramArrayOfBitmap = null;
    }
    Bitmap[] arrayOfBitmap;
    int i;
    bazs[] arrayOfbazs;
    Paint localPaint;
    RectF localRectF;
    Rect localRect;
    Canvas localCanvas;
    label279:
    do
    {
      Bitmap localBitmap;
      do
      {
        return paramArrayOfBitmap;
        arrayOfBitmap = new Bitmap[paramArrayOfBitmap.length];
        i = 0;
        j = 0;
        while (j < paramArrayOfBitmap.length)
        {
          k = i;
          if (paramArrayOfBitmap[j] != null)
          {
            arrayOfBitmap[i] = paramArrayOfBitmap[j];
            k = i + 1;
          }
          j += 1;
          i = k;
        }
        if (i < 1) {
          return null;
        }
        if (i == 1) {
          return paramArrayOfBitmap[0];
        }
        arrayOfbazs = new bazs[i];
        j = 0;
        while (j < i)
        {
          arrayOfbazs[j] = new bazs(null);
          j += 1;
        }
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        localRectF = new RectF();
        localRect = new Rect();
        localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localCanvas.drawARGB(0, 0, 0, 0);
        if (i != 2) {
          break;
        }
        arrayOfbazs[0].a = 0;
        arrayOfbazs[0].b = 0;
        arrayOfbazs[0].c = (paramInt / 2 - 1);
        arrayOfbazs[0].d = paramInt;
        arrayOfbazs[0].e = 1;
        arrayOfbazs[1].a = (paramInt / 2 + 1);
        arrayOfbazs[1].b = 0;
        arrayOfbazs[1].c = paramInt;
        arrayOfbazs[1].d = paramInt;
        arrayOfbazs[1].e = 1;
        paramInt = 0;
        paramArrayOfBitmap = localBitmap;
      } while (paramInt >= i);
      paramArrayOfBitmap = localBitmap;
    } while (paramInt >= 4);
    int j = arrayOfBitmap[paramInt].getWidth();
    int k = arrayOfBitmap[paramInt].getHeight();
    if (arrayOfbazs[paramInt].e == 1) {
      localRect.set(j / 4, 0, j / 4 * 3, k);
    }
    for (;;)
    {
      localRectF.set(arrayOfbazs[paramInt].a, arrayOfbazs[paramInt].b, arrayOfbazs[paramInt].c, arrayOfbazs[paramInt].d);
      localCanvas.drawBitmap(arrayOfBitmap[paramInt], localRect, localRectF, localPaint);
      paramInt += 1;
      break label279;
      if (i == 3)
      {
        arrayOfbazs[0].a = 0;
        arrayOfbazs[0].b = 0;
        arrayOfbazs[0].c = (paramInt / 2 - 1);
        arrayOfbazs[0].d = paramInt;
        arrayOfbazs[0].e = 1;
        arrayOfbazs[1].a = (paramInt / 2 + 1);
        arrayOfbazs[1].b = 0;
        arrayOfbazs[1].c = paramInt;
        arrayOfbazs[1].d = (paramInt / 2 - 1);
        arrayOfbazs[1].e = 2;
        arrayOfbazs[2].a = (paramInt / 2 + 1);
        arrayOfbazs[2].b = (paramInt / 2 + 1);
        arrayOfbazs[2].c = paramInt;
        arrayOfbazs[2].d = paramInt;
        arrayOfbazs[2].e = 2;
        break;
      }
      if (i < 4) {
        break;
      }
      arrayOfbazs[0].a = 0;
      arrayOfbazs[0].b = 0;
      arrayOfbazs[0].c = (paramInt / 2 - 1);
      arrayOfbazs[0].d = (paramInt / 2 - 1);
      arrayOfbazs[0].e = 2;
      arrayOfbazs[1].a = (paramInt / 2 + 1);
      arrayOfbazs[1].b = 0;
      arrayOfbazs[1].c = paramInt;
      arrayOfbazs[1].d = (paramInt / 2 - 1);
      arrayOfbazs[1].e = 2;
      arrayOfbazs[2].a = (paramInt / 2 + 1);
      arrayOfbazs[2].b = (paramInt / 2 + 1);
      arrayOfbazs[2].c = paramInt;
      arrayOfbazs[2].d = paramInt;
      arrayOfbazs[2].e = 2;
      arrayOfbazs[3].a = 0;
      arrayOfbazs[3].b = (paramInt / 2 + 1);
      arrayOfbazs[3].c = (paramInt / 2 - 1);
      arrayOfbazs[3].d = paramInt;
      arrayOfbazs[3].e = 2;
      break;
      localRect.set(0, 0, j, k);
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2;
    if (paramFloat2 < 1.5F) {
      f = 1.5F;
    }
    int j = Math.max(paramBitmap1.getWidth(), paramBitmap1.getHeight());
    int i = Math.max(paramBitmap2.getWidth(), paramBitmap2.getHeight());
    j = (int)(Math.max(j, i) * f);
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    localPaint.setDither(true);
    paramFloat2 = j / i;
    Object localObject = new Matrix();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap2.getWidth() / 2.0F, paramBitmap2.getHeight() / 2.0F);
    }
    ((Matrix)localObject).postScale(paramFloat2, paramFloat2);
    localCanvas.drawBitmap(paramBitmap2, (Matrix)localObject, localPaint);
    paramBitmap2 = new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
    localObject = new RectF(0.0F, 0.0F, j, j);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap1, paramBitmap2, (RectF)localObject, localPaint);
    return localBitmap;
  }
  
  public static BitmapShader a(RectF paramRectF, @NonNull Bitmap paramBitmap)
  {
    float f1 = 0.0F;
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    paramBitmap = new Matrix();
    float f3;
    float f2;
    if (paramRectF.width() / paramRectF.height() < j / i)
    {
      f3 = paramRectF.height() / i;
      f2 = (paramRectF.width() - j * f3) * 0.5F;
    }
    for (;;)
    {
      paramBitmap.setScale(f3, f3);
      paramBitmap.postTranslate((int)(f2 + 0.5F) + paramRectF.left, (int)(f1 + 0.5F) + paramRectF.top);
      localBitmapShader.setLocalMatrix(paramBitmap);
      return localBitmapShader;
      f3 = paramRectF.width() / j;
      f1 = paramRectF.height();
      float f4 = i;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bazq
 * JD-Core Version:    0.7.0.1
 */