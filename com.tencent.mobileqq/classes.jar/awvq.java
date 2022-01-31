import java.util.Comparator;

class awvq
  implements Comparator<String>
{
  awvq(awvp paramawvp) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    return paramString2.length() - paramString1.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvq
 * JD-Core Version:    0.7.0.1
 */