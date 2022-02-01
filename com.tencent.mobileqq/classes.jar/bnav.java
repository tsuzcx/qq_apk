public class bnav
{
  public final bnau a;
  public final bnaw a;
  
  private bnav(bnau parambnau, bnaw parambnaw)
  {
    this.jdField_a_of_type_Bnau = parambnau;
    this.jdField_a_of_type_Bnaw = parambnaw;
  }
  
  public static bnav a()
  {
    return new bnav(null, bnaw.d);
  }
  
  public static bnav a(bnau parambnau)
  {
    return new bnav(parambnau, bnaw.b);
  }
  
  public static bnav b()
  {
    return new bnav(null, bnaw.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnav
 * JD-Core Version:    0.7.0.1
 */