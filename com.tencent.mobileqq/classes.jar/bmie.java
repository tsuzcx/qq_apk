public class bmie
{
  private static bmie jdField_a_of_type_Bmie = new bmie();
  private bmif jdField_a_of_type_Bmif;
  bmig jdField_a_of_type_Bmig;
  
  public static bmie a()
  {
    return jdField_a_of_type_Bmie;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bmif = null;
  }
  
  public void a(bmif parambmif)
  {
    this.jdField_a_of_type_Bmif = parambmif;
  }
  
  public void a(bmig parambmig)
  {
    this.jdField_a_of_type_Bmig = parambmig;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bmif == null) {
      return;
    }
    this.jdField_a_of_type_Bmif.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bmig localbmig = this.jdField_a_of_type_Bmig;
    if ((localbmig != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbmig.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmie
 * JD-Core Version:    0.7.0.1
 */