public class bgmy
{
  private static bgmy jdField_a_of_type_Bgmy = new bgmy();
  private bgmz jdField_a_of_type_Bgmz;
  bgna jdField_a_of_type_Bgna;
  
  public static bgmy a()
  {
    return jdField_a_of_type_Bgmy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bgmz = null;
  }
  
  public void a(bgmz parambgmz)
  {
    this.jdField_a_of_type_Bgmz = parambgmz;
  }
  
  public void a(bgna parambgna)
  {
    this.jdField_a_of_type_Bgna = parambgna;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bgmz == null) {
      return;
    }
    this.jdField_a_of_type_Bgmz.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bgna localbgna = this.jdField_a_of_type_Bgna;
    if ((localbgna != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbgna.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgmy
 * JD-Core Version:    0.7.0.1
 */