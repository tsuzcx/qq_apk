import android.graphics.Bitmap;

public class bncx
{
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private int b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    while (this.jdField_a_of_type_Int > 0) {
      return;
    }
    this.jdField_a_of_type_Int = bndb.a(this.jdField_a_of_type_AndroidGraphicsBitmap, true);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    bndb.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = -1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getByteCount();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncx
 * JD-Core Version:    0.7.0.1
 */