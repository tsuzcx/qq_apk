public class bnro
{
  private static bnro jdField_a_of_type_Bnro = new bnro();
  private bnrp jdField_a_of_type_Bnrp;
  bnrq jdField_a_of_type_Bnrq;
  
  public static bnro a()
  {
    return jdField_a_of_type_Bnro;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnrp = null;
  }
  
  public void a(bnrp parambnrp)
  {
    this.jdField_a_of_type_Bnrp = parambnrp;
  }
  
  public void a(bnrq parambnrq)
  {
    this.jdField_a_of_type_Bnrq = parambnrq;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnrp == null) {
      return;
    }
    this.jdField_a_of_type_Bnrp.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bnrq localbnrq = this.jdField_a_of_type_Bnrq;
    if ((localbnrq != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbnrq.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bnro
 * JD-Core Version:    0.7.0.1
 */