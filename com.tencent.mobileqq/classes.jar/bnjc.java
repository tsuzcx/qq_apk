public class bnjc
{
  public int a;
  public long a;
  public azfn a;
  public String a;
  public boolean a;
  public long b;
  public azfn b;
  public String b;
  public boolean b;
  public long c;
  
  public bnjc()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bnjc parambnjc)
  {
    if (parambnjc == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = parambnjc.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambnjc.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Azfn = parambnjc.jdField_a_of_type_Azfn;
    this.jdField_a_of_type_Boolean = parambnjc.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = parambnjc.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = parambnjc.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = parambnjc.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = parambnjc.jdField_b_of_type_Long;
    this.c = parambnjc.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjc
 * JD-Core Version:    0.7.0.1
 */