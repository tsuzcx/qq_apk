public class bhwh
{
  private static bhwh jdField_a_of_type_Bhwh = new bhwh();
  private bhwi jdField_a_of_type_Bhwi;
  bhwj jdField_a_of_type_Bhwj;
  
  public static bhwh a()
  {
    return jdField_a_of_type_Bhwh;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhwi = null;
  }
  
  public void a(bhwi parambhwi)
  {
    this.jdField_a_of_type_Bhwi = parambhwi;
  }
  
  public void a(bhwj parambhwj)
  {
    this.jdField_a_of_type_Bhwj = parambhwj;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bhwi == null) {
      return;
    }
    this.jdField_a_of_type_Bhwi.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bhwj localbhwj = this.jdField_a_of_type_Bhwj;
    if ((localbhwj != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbhwj.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhwh
 * JD-Core Version:    0.7.0.1
 */