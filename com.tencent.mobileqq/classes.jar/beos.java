import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

final class beos
  implements bene
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    paramInt2 = paramDrawable.getIntrinsicWidth();
    float f = paramInt1 / paramInt2;
    localMatrix.setScale(f, f);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beos
 * JD-Core Version:    0.7.0.1
 */