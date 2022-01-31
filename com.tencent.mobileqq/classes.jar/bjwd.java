import android.graphics.Bitmap;

class bjwd
  extends bjzj
{
  public Bitmap a;
  public Bitmap b;
  
  public bjwd(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public bjwd(bjzj parambjzj, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(parambjzj.jdField_c_of_type_Int, parambjzj.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwd
 * JD-Core Version:    0.7.0.1
 */