public final class bjmy
{
  public static final bjmy a;
  public static final bjmy b = new bjmy(1);
  public static final bjmy c = new bjmy(2);
  public static final bjmy d = new bjmy(3);
  public static final bjmy e = new bjmy(4);
  public static final bjmy f = new bjmy(5);
  public static final bjmy g = new bjmy(6);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bjmy = new bjmy(0);
  }
  
  public bjmy(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bjmy a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g;
    case 0: 
      return jdField_a_of_type_Bjmy;
    case 1: 
      return b;
    case 2: 
      return c;
    case 3: 
      return d;
    case 4: 
      return e;
    case 5: 
      return f;
    }
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmy
 * JD-Core Version:    0.7.0.1
 */