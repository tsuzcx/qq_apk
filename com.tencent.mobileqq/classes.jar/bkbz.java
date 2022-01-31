public class bkbz
{
  private static bkbz jdField_a_of_type_Bkbz = new bkbz();
  private bkca jdField_a_of_type_Bkca;
  bkcb jdField_a_of_type_Bkcb;
  
  public static bkbz a()
  {
    return jdField_a_of_type_Bkbz;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bkca = null;
  }
  
  public void a(bkca parambkca)
  {
    this.jdField_a_of_type_Bkca = parambkca;
  }
  
  public void a(bkcb parambkcb)
  {
    this.jdField_a_of_type_Bkcb = parambkcb;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bkca == null) {
      return;
    }
    this.jdField_a_of_type_Bkca.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bkcb localbkcb = this.jdField_a_of_type_Bkcb;
    if ((localbkcb != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbkcb.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkbz
 * JD-Core Version:    0.7.0.1
 */