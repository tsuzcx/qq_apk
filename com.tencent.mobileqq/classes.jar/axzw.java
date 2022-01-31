import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;

class axzw
  extends bavi
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  
  public axzw(axzq paramaxzq, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = this.c;
    int k = paramBitmap.getWidth();
    if (paramBitmap.getHeight() != 0) {}
    for (int i = paramBitmap.getHeight();; i = this.c)
    {
      i = k * j / i;
      return bbdr.b(paramBitmap, this.jdField_a_of_type_Int, i, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzw
 * JD-Core Version:    0.7.0.1
 */