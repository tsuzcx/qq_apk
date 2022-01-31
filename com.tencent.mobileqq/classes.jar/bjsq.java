import android.graphics.Bitmap;

public class bjsq
  extends bjzj
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public bjsq(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
  }
  
  public static bjsq a(bjsq parambjsq, Bitmap paramBitmap)
  {
    paramBitmap = new bjsq(parambjsq.c, paramBitmap);
    paramBitmap.jdField_a_of_type_Int = parambjsq.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Int = parambjsq.jdField_b_of_type_Int;
    paramBitmap.jdField_a_of_type_JavaLangString = parambjsq.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_a_of_type_Boolean = parambjsq.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_Boolean = parambjsq.jdField_b_of_type_Boolean;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "PlayerContext{startTime=" + this.jdField_a_of_type_Int + ", endTime=" + this.jdField_b_of_type_Int + ", isMute=" + this.jdField_a_of_type_Boolean + ", isDeleted=" + this.jdField_b_of_type_Boolean + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsq
 * JD-Core Version:    0.7.0.1
 */