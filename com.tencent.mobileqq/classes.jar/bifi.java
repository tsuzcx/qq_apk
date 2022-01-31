import android.graphics.Bitmap;

class bifi
  extends biio
{
  public Bitmap a;
  public Bitmap b;
  
  public bifi(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bifi(biio parambiio, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambiio.jdField_c_of_type_Int, parambiio.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifi
 * JD-Core Version:    0.7.0.1
 */