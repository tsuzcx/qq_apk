import java.util.Comparator;

class auco
  implements Comparator<String>
{
  auco(aucn paramaucn) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    return paramString2.length() - paramString1.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auco
 * JD-Core Version:    0.7.0.1
 */