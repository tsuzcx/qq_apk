import java.util.Comparator;

final class asxn
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if (paramString1.length() > paramString2.length()) {
      return -1;
    }
    if (paramString1.length() < paramString2.length()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxn
 * JD-Core Version:    0.7.0.1
 */