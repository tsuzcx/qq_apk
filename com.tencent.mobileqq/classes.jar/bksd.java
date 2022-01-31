public class bksd
{
  public final bksc a;
  public final bkse a;
  
  private bksd(bksc parambksc, bkse parambkse)
  {
    this.jdField_a_of_type_Bksc = parambksc;
    this.jdField_a_of_type_Bkse = parambkse;
  }
  
  public static bksd a()
  {
    return new bksd(null, bkse.d);
  }
  
  public static bksd a(bksc parambksc)
  {
    return new bksd(parambksc, bkse.b);
  }
  
  public static bksd b()
  {
    return new bksd(null, bkse.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksd
 * JD-Core Version:    0.7.0.1
 */