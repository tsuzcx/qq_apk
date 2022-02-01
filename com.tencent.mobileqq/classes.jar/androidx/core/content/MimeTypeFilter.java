package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class MimeTypeFilter
{
  @Nullable
  public static String matches(@Nullable String paramString, @NonNull String[] paramArrayOfString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("/");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (mimeTypeAgainstFilter(paramString, str.split("/"))) {
          return str;
        }
        i += 1;
      }
    }
  }
  
  @Nullable
  public static String matches(@Nullable String[] paramArrayOfString, @NonNull String paramString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("/");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (mimeTypeAgainstFilter(str.split("/"), paramString)) {
          return str;
        }
        i += 1;
      }
    }
  }
  
  public static boolean matches(@Nullable String paramString1, @NonNull String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return mimeTypeAgainstFilter(paramString1.split("/"), paramString2.split("/"));
  }
  
  @NonNull
  public static String[] matchesMany(@Nullable String[] paramArrayOfString, @NonNull String paramString)
  {
    int i = 0;
    if (paramArrayOfString == null) {
      return new String[0];
    }
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split("/");
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (mimeTypeAgainstFilter(str.split("/"), paramString)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static boolean mimeTypeAgainstFilter(@NonNull String[] paramArrayOfString1, @NonNull String[] paramArrayOfString2)
  {
    if (paramArrayOfString2.length != 2) {
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }
    if ((paramArrayOfString2[0].isEmpty()) || (paramArrayOfString2[1].isEmpty())) {
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    }
    if (paramArrayOfString1.length != 2) {}
    while (((!"*".equals(paramArrayOfString2[0])) && (!paramArrayOfString2[0].equals(paramArrayOfString1[0]))) || ((!"*".equals(paramArrayOfString2[1])) && (!paramArrayOfString2[1].equals(paramArrayOfString1[1])))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.MimeTypeFilter
 * JD-Core Version:    0.7.0.1
 */