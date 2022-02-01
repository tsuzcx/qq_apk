import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

final class bhvv
  implements bhui
{
  public Matrix a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramDrawable == null) {
      return localMatrix;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    localMatrix.setScale(f, f);
    localMatrix.postTranslate((int)(0.0F + 0.5F), (int)(0.0F + 0.5F));
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvv
 * JD-Core Version:    0.7.0.1
 */