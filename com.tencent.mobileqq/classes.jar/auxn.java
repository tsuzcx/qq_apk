public class auxn
{
  public int a;
  public long a;
  public awkz a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public long c;
  
  public auxn()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(auxn paramauxn)
  {
    if (paramauxn == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = paramauxn.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Awkz = paramauxn.jdField_a_of_type_Awkz;
    this.jdField_a_of_type_Boolean = paramauxn.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramauxn.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramauxn.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = paramauxn.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramauxn.jdField_b_of_type_Long;
    this.c = paramauxn.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auxn
 * JD-Core Version:    0.7.0.1
 */