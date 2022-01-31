import android.graphics.Bitmap;

class bmmq
  extends bmpw
{
  public Bitmap a;
  public Bitmap b;
  
  public bmmq(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bmmq(bmpw parambmpw, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambmpw.jdField_c_of_type_Int, parambmpw.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmq
 * JD-Core Version:    0.7.0.1
 */