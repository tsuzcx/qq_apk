import android.graphics.Bitmap;

class bjwu
  extends bkaa
{
  public Bitmap a;
  public Bitmap b;
  
  public bjwu(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bjwu(bkaa parambkaa, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambkaa.jdField_c_of_type_Int, parambkaa.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwu
 * JD-Core Version:    0.7.0.1
 */