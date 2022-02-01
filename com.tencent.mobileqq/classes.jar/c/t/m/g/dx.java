package c.t.m.g;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dx
{
  public static final Pattern a;
  public static final Pattern b;
  
  static
  {
    Pattern localPattern = Pattern.compile("[0-9a-zA-Z+-]*");
    a = localPattern;
    b = localPattern;
    Pattern.compile("[A-Z0-9]{12}");
  }
  
  public static String a(String paramString, Pattern paramPattern)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramPattern.matcher(paramString).matches()) {
      return "";
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dx
 * JD-Core Version:    0.7.0.1
 */