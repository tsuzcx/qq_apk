public final class bjnp
{
  public static final bjnp a;
  public static final bjnp b = new bjnp(1);
  public static final bjnp c = new bjnp(2);
  public static final bjnp d = new bjnp(3);
  public static final bjnp e = new bjnp(4);
  public static final bjnp f = new bjnp(5);
  public static final bjnp g = new bjnp(6);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bjnp = new bjnp(0);
  }
  
  public bjnp(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bjnp a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g;
    case 0: 
      return jdField_a_of_type_Bjnp;
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
 * Qualified Name:     bjnp
 * JD-Core Version:    0.7.0.1
 */