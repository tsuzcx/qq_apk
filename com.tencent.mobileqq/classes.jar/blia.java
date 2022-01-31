import android.graphics.Bitmap;

public class blia
{
  public final int a;
  public final Bitmap a;
  public final String a;
  public final Throwable a;
  public final boolean a;
  
  private blia(boolean paramBoolean, int paramInt, String paramString, Throwable paramThrowable, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  private static blia b(int paramInt, String paramString)
  {
    return new blia(false, paramInt, paramString, null, null);
  }
  
  private static blia b(Bitmap paramBitmap)
  {
    return new blia(true, 0, null, null, paramBitmap);
  }
  
  public String toString()
  {
    return "ChangeFaceResult{isSuccess=" + this.jdField_a_of_type_Boolean + ", errCode=" + this.jdField_a_of_type_Int + ", msg='" + this.jdField_a_of_type_JavaLangString + '\'' + ", exception=" + this.jdField_a_of_type_JavaLangThrowable + ", data=" + this.jdField_a_of_type_AndroidGraphicsBitmap + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blia
 * JD-Core Version:    0.7.0.1
 */