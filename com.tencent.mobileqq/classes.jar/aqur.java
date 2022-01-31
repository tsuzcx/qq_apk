public class aqur
{
  aqus a;
  
  public aqur(int paramInt)
  {
    this.a = new aqus(paramInt);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "graytip";
    case 2: 
      return "nor_text";
    case 3: 
      return "url";
    case 4: 
      return "qq";
    case 5: 
      return "img";
    case 6: 
      return "dialog";
    case 7: 
      return "title";
    case 8: 
      return "alter";
    case 9: 
      return "btn";
    }
    return "item";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "align";
    case 2: 
      return "text";
    case 3: 
      return "size";
    case 4: 
      return "jump";
    case 5: 
      return "color";
    case 6: 
      return "uin";
    case 7: 
      return "name";
    }
    return "src";
  }
  
  public aqus a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return aqus.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqur
 * JD-Core Version:    0.7.0.1
 */