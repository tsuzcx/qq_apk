import android.text.TextUtils;
import java.io.PrintStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class bhzp
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
      if (a(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("\\n", "\n").replace("&#92;", "\\").replace("&#39;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label139;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label139:
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = "";
      return paramString2;
    }
    if (!TextUtils.isEmpty(paramString2)) {}
    for (String str = paramString2;; str = "UTF-8")
    {
      paramString2 = paramString1;
      for (;;)
      {
        int j;
        int k;
        try
        {
          if (paramString1.getBytes(str).length <= paramInt) {
            break;
          }
          j = 0;
          paramString2 = paramString1;
          if (i >= paramString1.length()) {
            break;
          }
          k = paramString1.substring(i, i + 1).getBytes(str).length;
          if (j + k > paramInt)
          {
            paramString2 = paramString1.substring(0, i);
            paramString1 = paramString2;
            paramString2 = paramString1;
          }
        }
        catch (Exception paramString2) {}
        try
        {
          if (!TextUtils.isEmpty(paramString3)) {
            paramString2 = paramString1 + paramString3;
          }
          return paramString2;
        }
        catch (Exception paramString2)
        {
          break label136;
        }
        j += k;
        i += 1;
      }
      label136:
      System.out.println("StructMsg sSubString error : " + paramString2.getMessage());
      return paramString1;
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramBoolean) {
      return a(paramString, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label154;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label154:
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label148;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label148:
      if ((!paramBoolean1) || (paramBoolean2)) {
        break label188;
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      if ((paramBoolean1) && (paramBoolean2)) {
        localStringBuilder.append("…");
      }
    }
  }
  
  protected static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 0;; i = paramString2.length() + j)
    {
      j = paramString1.indexOf(paramString2, i);
      if (j < 0)
      {
        localArrayList.add(paramString1.substring(i));
        i = localArrayList.size() - 1;
        while ((i >= 0) && (((String)localArrayList.get(i)).length() == 0))
        {
          localArrayList.remove(i);
          i -= 1;
        }
      }
      localArrayList.add(paramString1.substring(i, j));
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("%7D", "%257D").replace("%3A;", "%253A").replace("%2C';", "%252C").replace("}", "%7D").replace(":", "%3A").replace(",", "%2C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzp
 * JD-Core Version:    0.7.0.1
 */