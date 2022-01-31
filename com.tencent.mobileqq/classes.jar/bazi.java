import android.graphics.Bitmap;
import android.graphics.Matrix;

public class bazi
  extends bazf
  implements baze
{
  String a;
  
  public bazi(String paramString)
  {
    this.a = paramString;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i = bayu.a(this.a);
    if (i == 0) {
      return b(paramBitmap);
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(i, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if ((localObject == null) || (localObject == paramBitmap)) {
      throw new OutOfMemoryError("OOM");
    }
    paramBitmap.recycle();
    return b((Bitmap)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazi
 * JD-Core Version:    0.7.0.1
 */