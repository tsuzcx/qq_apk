import android.graphics.Bitmap;

public class bnxn
{
  public final int a;
  public final Bitmap a;
  public final String a;
  public final Throwable a;
  public final boolean a;
  
  private bnxn(boolean paramBoolean, int paramInt, String paramString, Throwable paramThrowable, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  private static bnxn b(int paramInt, String paramString)
  {
    return new bnxn(false, paramInt, paramString, null, null);
  }
  
  private static bnxn b(Bitmap paramBitmap)
  {
    return new bnxn(true, 0, null, null, paramBitmap);
  }
  
  public String toString()
  {
    return "ChangeFaceResult{isSuccess=" + this.jdField_a_of_type_Boolean + ", errCode=" + this.jdField_a_of_type_Int + ", msg='" + this.jdField_a_of_type_JavaLangString + '\'' + ", exception=" + this.jdField_a_of_type_JavaLangThrowable + ", data=" + this.jdField_a_of_type_AndroidGraphicsBitmap + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxn
 * JD-Core Version:    0.7.0.1
 */