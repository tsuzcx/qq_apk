import android.graphics.Bitmap;

public class bmer
  extends bmlk
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public bmer(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
  }
  
  public static bmer a(bmer parambmer, Bitmap paramBitmap)
  {
    paramBitmap = new bmer(parambmer.c, paramBitmap);
    paramBitmap.jdField_a_of_type_Int = parambmer.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Int = parambmer.jdField_b_of_type_Int;
    paramBitmap.jdField_a_of_type_JavaLangString = parambmer.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_a_of_type_Boolean = parambmer.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_Boolean = parambmer.jdField_b_of_type_Boolean;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "PlayerContext{startTime=" + this.jdField_a_of_type_Int + ", endTime=" + this.jdField_b_of_type_Int + ", isMute=" + this.jdField_a_of_type_Boolean + ", isDeleted=" + this.jdField_b_of_type_Boolean + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmer
 * JD-Core Version:    0.7.0.1
 */