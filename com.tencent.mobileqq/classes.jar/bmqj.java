public class bmqj
{
  private static bmqj jdField_a_of_type_Bmqj = new bmqj();
  private bmqk jdField_a_of_type_Bmqk;
  bmql jdField_a_of_type_Bmql;
  
  public static bmqj a()
  {
    return jdField_a_of_type_Bmqj;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bmqk = null;
  }
  
  public void a(bmqk parambmqk)
  {
    this.jdField_a_of_type_Bmqk = parambmqk;
  }
  
  public void a(bmql parambmql)
  {
    this.jdField_a_of_type_Bmql = parambmql;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bmqk == null) {
      return;
    }
    this.jdField_a_of_type_Bmqk.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bmql localbmql = this.jdField_a_of_type_Bmql;
    if ((localbmql != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbmql.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmqj
 * JD-Core Version:    0.7.0.1
 */