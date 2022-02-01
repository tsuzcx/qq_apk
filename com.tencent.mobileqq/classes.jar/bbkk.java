public class bbkk
{
  public int a;
  public long a;
  public bddn a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public long c;
  
  public bbkk()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bbkk parambbkk)
  {
    if (parambbkk == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = parambbkk.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Bddn = parambbkk.jdField_a_of_type_Bddn;
    this.jdField_a_of_type_Boolean = parambbkk.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = parambbkk.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = parambbkk.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = parambbkk.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = parambbkk.jdField_b_of_type_Long;
    this.c = parambbkk.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkk
 * JD-Core Version:    0.7.0.1
 */