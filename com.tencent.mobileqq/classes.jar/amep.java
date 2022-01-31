import android.util.Pair;

public final class amep
  implements amer
{
  public Pair a(String paramString)
  {
    int i = paramString.indexOf(':');
    if ((i <= 0) || (i >= paramString.length())) {
      return null;
    }
    return new Pair(paramString.substring(0, i).trim(), paramString.substring(i + 1).trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amep
 * JD-Core Version:    0.7.0.1
 */