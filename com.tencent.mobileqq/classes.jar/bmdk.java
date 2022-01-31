public final class bmdk
{
  public static final bmdk a;
  public static final bmdk b = new bmdk(1);
  public static final bmdk c = new bmdk(2);
  public static final bmdk d = new bmdk(3);
  public static final bmdk e = new bmdk(4);
  public static final bmdk f = new bmdk(5);
  public static final bmdk g = new bmdk(6);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bmdk = new bmdk(0);
  }
  
  public bmdk(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static bmdk a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return g;
    case 0: 
      return jdField_a_of_type_Bmdk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdk
 * JD-Core Version:    0.7.0.1
 */