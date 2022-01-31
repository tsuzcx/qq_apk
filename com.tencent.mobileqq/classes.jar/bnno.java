public class bnno
{
  public int a;
  public long a;
  public azjw a;
  public String a;
  public boolean a;
  public long b;
  public azjw b;
  public String b;
  public boolean b;
  public long c;
  
  public bnno()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bnno parambnno)
  {
    if (parambnno == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = parambnno.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambnno.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Azjw = parambnno.jdField_a_of_type_Azjw;
    this.jdField_a_of_type_Boolean = parambnno.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = parambnno.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = parambnno.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = parambnno.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = parambnno.jdField_b_of_type_Long;
    this.c = parambnno.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnno
 * JD-Core Version:    0.7.0.1
 */