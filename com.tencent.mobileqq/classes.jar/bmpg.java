import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bmpg
{
  public static final String a;
  public static final Pattern a;
  private static boolean a;
  public static final String b;
  public static final Pattern b;
  private static Pattern c;
  private static Pattern d = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
  private static Pattern e = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131710522);
    jdField_b_of_type_JavaLangString = anni.a(2131710519);
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\[/美女\\]|\\[/钱\\]");
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (paramString.find()) {
      i += 1;
    }
    return i;
  }
  
  public static Drawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (arvq.a(paramString) != -1) {
        return arvq.a(arvq.a(paramString));
      }
    } while (arvj.a(paramString) == -1);
    return arvj.a(arvj.a(paramString));
  }
  
  public static String a(String paramString)
  {
    Matcher localMatcher = e.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = g(str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString = paramString.replace(str1, "[" + str2.substring(1) + "]");
      }
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString1);
    while (localMatcher.find()) {
      paramString1 = paramString1.replace(localMatcher.group(), paramString2);
    }
    return paramString1;
  }
  
  public static void a() {}
  
  public static String b(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    if ((c == null) || (paramString == null)) {
      return paramString;
    }
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Matcher localMatcher = d.matcher(paramString);
    while (localMatcher.find())
    {
      if (localMatcher.start() >= i)
      {
        localStringBuilder.append(h(paramString.substring(i, localMatcher.start())));
        localStringBuilder.append(paramString.substring(localMatcher.start(), localMatcher.end()));
      }
      i = localMatcher.end();
    }
    localStringBuilder.append(h(paramString.substring(i, paramString.length())));
    return localStringBuilder.toString();
  }
  
  private static void b()
  {
    int i = 1;
    try
    {
      ArrayList localArrayList = arvq.a();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer("(" + arvq.a(((Integer)localArrayList.get(0)).intValue()) + ")");
        while (i < localArrayList.size())
        {
          localStringBuffer.append("|(" + arvq.a(((Integer)localArrayList.get(i)).intValue()) + ")");
          i += 1;
        }
        c = Pattern.compile(localStringBuffer.toString().replace("吃瓜", "chigua"));
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  public static String c(String paramString)
  {
    Matcher localMatcher = e.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = d(str1);
      if (str2 != null) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (arvq.a(paramString) != -1) {
        return arvq.b(arvq.a(paramString));
      }
    } while (arvj.a(paramString) == -1);
    return arvj.a(arvj.a(paramString)) + "";
  }
  
  public static String e(String paramString)
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  public static String f(String paramString)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = g(str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (arvq.a(paramString) != -1) {
        return arvq.a(arvq.a(paramString));
      }
    } while (arvj.a(paramString) == -1);
    return arvj.a(arvj.a(paramString));
  }
  
  private static String h(String paramString)
  {
    Matcher localMatcher = c.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null)
      {
        String str2 = arvq.a(str1);
        if (str2 != null)
        {
          str1 = paramString.replace(str1, str2);
          if (str1 != null) {
            paramString = str1;
          }
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpg
 * JD-Core Version:    0.7.0.1
 */