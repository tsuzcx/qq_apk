import android.util.Pair;

final class bhjp
  implements bhjr
{
  public Pair<String, String> a(String paramString)
  {
    paramString = paramString.split(":", 2);
    if ((paramString == null) || (paramString.length < 2)) {
      return null;
    }
    return new Pair(paramString[0].trim(), paramString[1].trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjp
 * JD-Core Version:    0.7.0.1
 */