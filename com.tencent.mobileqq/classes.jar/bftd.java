import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bftd
{
  public static long a(Context paramContext, String paramString)
  {
    long l = 0L;
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_flagEx_" + paramString;
    if (paramContext.contains(paramString)) {
      l = paramContext.getLong(paramString, 0L);
    }
    return l;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_name_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    Object localObject = null;
    Matcher localMatcher = Pattern.compile("\\d+", 2).matcher(paramString);
    for (paramString = localObject; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    List localList = a(paramString);
    String str2;
    if (localList.size() > 0)
    {
      int i = 0;
      String str1 = paramString;
      str2 = str1;
      if (i < localList.size())
      {
        String str3 = (String)localList.get(i);
        str2 = "\"" + str3 + "\"";
        int j = paramString.indexOf(str2);
        if (str2.length() + j == paramString.length()) {}
        for (str2 = ContactUtils.getTroopName(paramQQAppInterface, str3, true);; str2 = ContactUtils.getBuddyName(paramQQAppInterface, str3, true))
        {
          str1 = a(str1, str3, str2);
          i += 1;
          break;
        }
      }
    }
    else
    {
      str2 = paramString;
    }
    return str2;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals(paramString3)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    return paramString1.replace("\"" + paramString2 + "\"", localStringBuilder.toString());
  }
  
  private static List<String> a(String paramString)
  {
    Object localObject = Pattern.compile("\"\\d+\"", 2);
    Pattern localPattern = Pattern.compile("\\d+", 2);
    ArrayList localArrayList = new ArrayList();
    paramString = ((Pattern)localObject).matcher(paramString);
    while (paramString.find())
    {
      localObject = localPattern.matcher(paramString.group());
      while (((Matcher)localObject).find()) {
        localArrayList.add(((Matcher)localObject).group());
      }
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_option_" + paramString;
    paramContext.edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_flagEx_" + paramString;
    paramContext.edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString1 = "troop_name_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_question_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static String b(String paramString)
  {
    Object localObject = null;
    Matcher localMatcher = Pattern.compile("\"\\d+\"", 2).matcher(paramString);
    paramString = localObject;
    if (localMatcher.find()) {
      paramString = localMatcher.group();
    }
    return paramString;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString1 = "troop_question_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public static String c(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_answer_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString1 = "troop_answer_" + paramString1;
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bftd
 * JD-Core Version:    0.7.0.1
 */