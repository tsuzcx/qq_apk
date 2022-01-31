import java.util.Comparator;

class ayvc
  implements Comparator<String>
{
  ayvc(ayvb paramayvb) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    return paramString2.length() - paramString1.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvc
 * JD-Core Version:    0.7.0.1
 */