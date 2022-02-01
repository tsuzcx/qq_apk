public class atkh
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public atkh(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = a();
    this.c = b();
    this.d = (paramString + "_" + paramInt1 + "_" + paramInt2);
  }
  
  private String a()
  {
    return "flutter_face_bmp_" + this.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_Int;
  }
  
  private String b()
  {
    return "flutter_face_path_" + this.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    return "DecodeRequest{faceType=" + this.jdField_a_of_type_Int + ", faceUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", faceShape=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkh
 * JD-Core Version:    0.7.0.1
 */