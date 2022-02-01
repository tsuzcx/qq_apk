import android.graphics.Bitmap;

class bpdw
  extends bphc
{
  public Bitmap a;
  public Bitmap b;
  
  public bpdw(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bpdw(bphc parambphc, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambphc.jdField_c_of_type_Int, parambphc.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdw
 * JD-Core Version:    0.7.0.1
 */