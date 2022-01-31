public abstract class axxl
{
  public static final String a;
  public long a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = axqt.jdField_a_of_type_JavaLangString;
  }
  
  public axxl(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a()
  {
    if (this.b == null) {
      this.b = (jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Long + "/");
    }
  }
  
  public final String a()
  {
    a();
    return this.b + "thumb.jpg";
  }
  
  public final String b()
  {
    a();
    return this.b + "combine.mp4";
  }
  
  public final String c()
  {
    a();
    return this.b + "audio.mp4";
  }
  
  public String d()
  {
    a();
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxl
 * JD-Core Version:    0.7.0.1
 */