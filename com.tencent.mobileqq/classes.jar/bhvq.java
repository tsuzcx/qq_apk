public class bhvq
{
  private static bhvq jdField_a_of_type_Bhvq = new bhvq();
  private bhvr jdField_a_of_type_Bhvr;
  bhvs jdField_a_of_type_Bhvs;
  
  public static bhvq a()
  {
    return jdField_a_of_type_Bhvq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhvr = null;
  }
  
  public void a(bhvr parambhvr)
  {
    this.jdField_a_of_type_Bhvr = parambhvr;
  }
  
  public void a(bhvs parambhvs)
  {
    this.jdField_a_of_type_Bhvs = parambhvs;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bhvr == null) {
      return;
    }
    this.jdField_a_of_type_Bhvr.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bhvs localbhvs = this.jdField_a_of_type_Bhvs;
    if ((localbhvs != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbhvs.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhvq
 * JD-Core Version:    0.7.0.1
 */