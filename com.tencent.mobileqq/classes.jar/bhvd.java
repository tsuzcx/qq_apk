public final class bhvd
{
  public static final bhvd a;
  public static final bhvd b = new bhvd(1);
  public static final bhvd c = new bhvd(2);
  public static final bhvd d = new bhvd(3);
  public static final bhvd e = new bhvd(4);
  public static final bhvd f = new bhvd(5);
  public static final bhvd g = new bhvd(6);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bhvd = new bhvd(0);
  }
  
  public bhvd(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bhvd a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g;
    case 0: 
      return jdField_a_of_type_Bhvd;
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
 * Qualified Name:     bhvd
 * JD-Core Version:    0.7.0.1
 */