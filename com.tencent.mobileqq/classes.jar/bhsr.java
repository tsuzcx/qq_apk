import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bhsr
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      int k = paramString.charAt(j);
      if ((k >= 0) && (k <= 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 2;
      }
    }
    return i;
  }
  
  public static long a(String paramString1, String paramString2)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(paramString1, 1, "stringToLong Exception, value[" + paramString2 + "]", localException);
      }
    }
    return 0L;
  }
  
  public static String a(long paramLong)
  {
    String str2 = "" + paramLong;
    String str1 = "";
    if ((paramLong >= 0L) && (paramLong < 1024L)) {
      str1 = str2 + "B";
    }
    do
    {
      return str1;
      if ((paramLong >= 1024L) && (paramLong < 1048576L)) {
        return Long.toString(paramLong / 1024L) + "KB";
      }
      if ((paramLong >= 1048576L) && (paramLong < 1073741824L)) {
        return Long.toString(paramLong / 1048576L) + "MB";
      }
    } while (paramLong < 1073741824L);
    return Long.toString(paramLong / 1073741824L) + "GB";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = 0;
    int k = 1;
    int i = 0;
    if (i < paramString.length())
    {
      int n;
      if (k != 0)
      {
        n = j;
        m = k;
        if (a(paramString.charAt(i)))
        {
          n = i;
          m = 0;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = n;
          k = m;
          break;
          n = j;
          m = k;
        } while (!a(paramString.charAt(i)));
        m = i;
        if (paramString.length() - 1 == i) {
          break label113;
        }
        n = j;
        m = k;
      } while (a(paramString.charAt(i + 1)));
    }
    for (int m = i;; m = 0)
    {
      label113:
      if (j < m + 1) {
        if (m + 1 < paramString.length()) {
          i = m + 1;
        }
      }
      for (paramString = paramString.substring(j, i);; paramString = "")
      {
        return paramString;
        i = paramString.length();
        break;
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    float f = 0.0F;
    int i = 0;
    label20:
    double d1;
    if (i < paramString.length())
    {
      double d2 = f;
      if (c(paramString.charAt(i)))
      {
        d1 = 2.0D;
        label50:
        f = (float)(d1 + d2);
        if (f <= paramInt) {
          break label107;
        }
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      str = paramString;
      if (paramInt == 0) {
        break;
      }
      return paramString.substring(0, i) + "…";
      d1 = 1.5D;
      break label50;
      label107:
      i += 1;
      break label20;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      char c;
      if (i < paramString.length())
      {
        c = paramString.charAt(i);
        if ((c < 0) || (c > 'ÿ')) {
          break label67;
        }
        paramInt1 += 1;
      }
      while (paramInt1 > paramInt2)
      {
        return localStringBuffer.toString();
        label67:
        paramInt1 += 2;
      }
      localStringBuffer.append(c);
      i += 1;
    }
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      char c;
      if (i < paramString1.length())
      {
        c = paramString1.charAt(i);
        if ((c < 0) || (c > 'ÿ')) {
          break label76;
        }
        paramInt1 += 1;
      }
      while (paramInt1 > paramInt2)
      {
        localStringBuffer.append(paramString2);
        return localStringBuffer.toString();
        label76:
        paramInt1 += 2;
      }
      localStringBuffer.append(c);
      i += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      } while (i < 0);
      j = paramString1.indexOf(paramString3, paramString2.length() + i);
    } while (j < 0);
    return paramString1.substring(paramString2.length() + i, j);
  }
  
  public static String a(List<? extends Object> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append(paramList.get(i).toString());
      localStringBuffer.append(paramString);
      i += 1;
    }
    localStringBuffer.delete(localStringBuffer.lastIndexOf(paramString), localStringBuffer.length());
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      if (Integer.toHexString(paramArrayOfByte[i] & 0xFF).length() == 1) {
        localStringBuffer.append("0").append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {}
      for (localObject = localObject.toString();; localObject = null)
      {
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" , ");
        i += 1;
        break;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static boolean a(char paramChar)
  {
    return (!Character.isISOControl(paramChar)) || (Character.isLetterOrDigit(paramChar)) || (Character.isSpace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String[] a(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramString.length();
    if (m == 0) {
      return new String[] { paramString };
    }
    ArrayList localArrayList = new ArrayList(50);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < m) {
      if (arrayOfChar[j] == paramChar)
      {
        localArrayList.add(paramString.substring(k, j));
        k = j + 1;
        j = k;
        i = 1;
      }
      else
      {
        j += 1;
        i = 0;
      }
    }
    if (i == 0) {
      localArrayList.add(paramString.substring(k, j));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramString.length();
      j = 0;
      k = i;
    } while (j >= m);
    k = paramString.codePointAt(j);
    if ((k >= 0) && (k <= 255)) {
      i += 1;
    }
    for (;;)
    {
      j += Character.charCount(k);
      break;
      i += 2;
    }
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue())).append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    for (;;)
    {
      char c;
      if (paramInt1 < paramString.length())
      {
        c = paramString.charAt(paramInt1);
        if (b(localStringBuffer.toString() + c) <= paramInt2) {}
      }
      else
      {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(c);
      paramInt1 += 1;
    }
  }
  
  public static boolean b(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String c(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return String.valueOf(paramString);
  }
  
  public static boolean c(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {}
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      j = paramString.length();
    } while (j < 5);
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label58;
      }
      if (!Character.isDigit(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label58:
    return true;
  }
  
  public static String d(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return paramString;
    }
    paramString = new StringBuffer(paramString);
    while ((paramString.length() > 0) && ((Character.isWhitespace(paramString.charAt(0))) || (paramString.charAt(0) == 0))) {
      paramString.deleteCharAt(0);
    }
    for (int i = paramString.length(); (i > 0) && ((Character.isWhitespace(paramString.charAt(i - 1))) || (paramString.charAt(0) == 0)); i = paramString.length()) {
      paramString.deleteCharAt(i - 1);
    }
    return paramString.toString();
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || ("".equals(paramString.trim())) || (!paramString.trim().startsWith("+"))) {
      bool = false;
    }
    return bool;
  }
  
  public static String e(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() <= 4)) {
      return paramString;
    }
    return a(paramString, paramString.length() - 4, paramString.length());
  }
  
  public static String f(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public static String g(String paramString)
  {
    int i = 2;
    if ((paramString == null) || (paramString.length() < 2)) {
      return paramString;
    }
    int j = paramString.length() - 1;
    if (j == 1) {}
    for (;;)
    {
      paramString = new StringBuffer(paramString);
      paramString.replace(1, i, "*");
      return paramString.toString();
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhsr
 * JD-Core Version:    0.7.0.1
 */