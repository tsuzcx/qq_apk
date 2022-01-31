public class bknw
{
  public final bknv a;
  public final bknx a;
  
  private bknw(bknv parambknv, bknx parambknx)
  {
    this.jdField_a_of_type_Bknv = parambknv;
    this.jdField_a_of_type_Bknx = parambknx;
  }
  
  public static bknw a()
  {
    return new bknw(null, bknx.d);
  }
  
  public static bknw a(bknv parambknv)
  {
    return new bknw(parambknv, bknx.b);
  }
  
  public static bknw b()
  {
    return new bknw(null, bknx.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknw
 * JD-Core Version:    0.7.0.1
 */