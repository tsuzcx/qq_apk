import android.graphics.Bitmap;

class bmie
  extends bmlk
{
  public Bitmap a;
  public Bitmap b;
  
  public bmie(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bmie(bmlk parambmlk, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambmlk.jdField_c_of_type_Int, parambmlk.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmie
 * JD-Core Version:    0.7.0.1
 */