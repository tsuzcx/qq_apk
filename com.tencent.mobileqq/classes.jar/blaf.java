import com.tencent.widget.AuthorizationItem;

public final class blaf
{
  public final int a;
  public final String a;
  public final String b;
  
  public blaf(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static blaf a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AuthorizationItem.d;
    case 0: 
      return AuthorizationItem.a;
    case 1: 
      return AuthorizationItem.b;
    }
    return AuthorizationItem.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blaf
 * JD-Core Version:    0.7.0.1
 */