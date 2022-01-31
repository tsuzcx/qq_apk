import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

final class bbhr
  implements bbgg
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    float f1 = 0.0F;
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (i == j)
    {
      f1 = paramInt2 / j;
      localMatrix.setScale(f1, f1);
      return localMatrix;
    }
    float f2;
    if ((i <= paramInt1) || (j <= paramInt2))
    {
      f2 = paramInt1 - i;
      f1 = paramInt2 - j;
      if (f1 < 0.0F) {}
      for (f1 *= 0.1F;; f1 *= 0.5F)
      {
        localMatrix.postTranslate((int)(f2 * 0.5F + 0.5F), (int)(f1 + 0.5F));
        break;
      }
    }
    float f3;
    if (i * paramInt2 > paramInt1 * j)
    {
      f3 = paramInt2 / j;
      f2 = (paramInt1 - i * f3) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
      break;
      f3 = paramInt1 / i;
      f1 = (paramInt2 - j) * f3;
      if (f1 < 0.0F)
      {
        f2 = 0.0F;
        f1 *= 0.1F;
      }
      else
      {
        f2 = 0.0F;
        f1 *= 0.5F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbhr
 * JD-Core Version:    0.7.0.1
 */