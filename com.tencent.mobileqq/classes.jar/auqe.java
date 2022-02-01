import android.text.TextUtils;
import com.tencent.mobileqq.fts.FTSDatabase;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class auqe
{
  public static String a(String paramString)
  {
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder(64);
        aupz localaupz = new aupz(new StringReader(paramString), paramString.length());
        paramString = null;
        try
        {
          localaupw = localaupz.a();
          if (localaupw != null) {
            continue;
          }
          if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && (!TextUtils.isEmpty(paramString.a())))
          {
            localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
            localStringBuilder.append("*");
          }
        }
        catch (IOException paramString)
        {
          aupw localaupw;
          paramString.printStackTrace();
          FTSDatabase.a().a("SegmentUtils", "e", "tokenSegment: failure", paramString);
          continue;
        }
        paramString = localStringBuilder.toString();
        return paramString;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        paramString.printStackTrace();
        FTSDatabase.a().a("SegmentUtils", "e", "tokenSegment: failure", paramString);
      }
      if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && ((!TextUtils.equals(localaupw.b(), "double")) || (paramString.b() < localaupw.a())) && (!TextUtils.isEmpty(paramString.a())))
      {
        localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
        localStringBuilder.append("*");
        localStringBuilder.append(' ');
      }
      if ((!TextUtils.isEmpty(localaupw.a())) && ((!TextUtils.equals(localaupw.b(), "double")) || (localaupw.a().length() != 1)))
      {
        localStringBuilder.append(localaupw.a());
        localStringBuilder.append(' ');
      }
      paramString = localaupw;
    }
    return null;
  }
  
  public static ArrayList<String> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String[] a(String paramString)
  {
    int j = 0;
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = a((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static String[] b(String paramString)
  {
    Object localObject2 = a(paramString);
    FTSDatabase.a().a("SegmentUtils", "i", "query segments = " + Arrays.toString((Object[])localObject2));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label223;
      }
      localObject1 = new String[1];
      localObject1[0] = paramString;
    }
    paramString = new String[localObject1.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2 = new StringBuilder(64);
      String[] arrayOfString = localObject1[i].split(" ");
      int j = 0;
      if (j < arrayOfString.length)
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(" ");
        }
        if ((arrayOfString[j].length() == 1) || ((arrayOfString[j].charAt(0) >= '0') && (arrayOfString[j].charAt(0) <= '9')) || ((arrayOfString[j].charAt(0) >= 'a') && (arrayOfString[j].charAt(0) <= 'z')))
        {
          ((StringBuilder)localObject2).append(arrayOfString[j]);
          ((StringBuilder)localObject2).append("*");
        }
        for (;;)
        {
          j += 1;
          break;
          label223:
          return null;
          ((StringBuilder)localObject2).append(arrayOfString[j]);
        }
      }
      paramString[i] = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqe
 * JD-Core Version:    0.7.0.1
 */