public class bqei
{
  public int a;
  public long a;
  public bckv a;
  public String a;
  public boolean a;
  public long b;
  public bckv b;
  public String b;
  public boolean b;
  public long c;
  
  public bqei()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(bqei parambqei)
  {
    if (parambqei == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = parambqei.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambqei.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Bckv = parambqei.jdField_a_of_type_Bckv;
    this.jdField_a_of_type_Boolean = parambqei.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = parambqei.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = parambqei.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = parambqei.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = parambqei.jdField_b_of_type_Long;
    this.c = parambqei.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqei
 * JD-Core Version:    0.7.0.1
 */