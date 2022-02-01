public class blnm
{
  public final blnl a;
  public final blnn a;
  
  private blnm(blnl paramblnl, blnn paramblnn)
  {
    this.jdField_a_of_type_Blnl = paramblnl;
    this.jdField_a_of_type_Blnn = paramblnn;
  }
  
  public static blnm a()
  {
    return new blnm(null, blnn.d);
  }
  
  public static blnm a(blnl paramblnl)
  {
    return new blnm(paramblnl, blnn.b);
  }
  
  public static blnm b()
  {
    return new blnm(null, blnn.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnm
 * JD-Core Version:    0.7.0.1
 */