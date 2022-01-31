public class bjxs
{
  private static bjxs jdField_a_of_type_Bjxs = new bjxs();
  private bjxt jdField_a_of_type_Bjxt;
  bjxu jdField_a_of_type_Bjxu;
  
  public static bjxs a()
  {
    return jdField_a_of_type_Bjxs;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjxt = null;
  }
  
  public void a(bjxt parambjxt)
  {
    this.jdField_a_of_type_Bjxt = parambjxt;
  }
  
  public void a(bjxu parambjxu)
  {
    this.jdField_a_of_type_Bjxu = parambjxu;
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (this.jdField_a_of_type_Bjxt == null) {
      return;
    }
    this.jdField_a_of_type_Bjxt.a(paramString, paramLong1, paramArrayOfLong, paramLong2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    bjxu localbjxu = this.jdField_a_of_type_Bjxu;
    if ((localbjxu != null) && (!"0X8009831".equals(paramString1)) && (!"0X8009830".equals(paramString1)) && (!"0X800982E".equals(paramString1)) && (!"0X800982F".equals(paramString1))) {
      localbjxu.a(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjxs
 * JD-Core Version:    0.7.0.1
 */