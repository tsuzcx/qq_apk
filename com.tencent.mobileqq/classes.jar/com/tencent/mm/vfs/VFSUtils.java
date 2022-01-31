package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VFSUtils
{
  private static final Pattern MACRO_PATTERN = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
  private static final String TAG = "VFS.Utils";
  
  public static void checkFileSystemVersion(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    paramInt = paramClass.getName().hashCode() ^ paramInt;
    int i = paramParcel.readInt();
    if (i != paramInt) {
      throw new VFSUtils.FileSystemVersionException(paramClass, i, paramInt);
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {}
    do
    {
      return;
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    } while (!QLog.isColorLevel());
    QLog.w("VFS.Utils", 2, "Failed to close object: " + paramCloseable.toString());
  }
  
  static String getParentPath(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i <= 0) {
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public static <T> List<T> iterableToList(Iterable<? extends T> paramIterable)
  {
    if (paramIterable == null) {
      return null;
    }
    if ((paramIterable instanceof List)) {
      return (List)paramIterable;
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    return localArrayList;
  }
  
  static String macroResolve(String paramString, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      paramMap = null;
      return paramMap;
    }
    Matcher localMatcher = MACRO_PATTERN.matcher(paramString);
    StringBuilder localStringBuilder;
    int i;
    if (localMatcher.find())
    {
      localStringBuilder = new StringBuilder(paramString.length());
      i = 0;
    }
    for (;;)
    {
      String str1 = localMatcher.group(1);
      String str2 = (String)paramMap.get(str1);
      if (str2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VFS.Utils", 2, "Macro resolve: " + paramString + " cannot resolve ${" + str1 + "}.");
        }
        return null;
      }
      localStringBuilder.append(paramString.substring(i, localMatcher.start())).append(str2);
      i = localMatcher.end();
      if (!localMatcher.find())
      {
        paramMap = paramString.substring(i);
        if (QLog.isColorLevel()) {
          QLog.d("VFS.Utils", 2, "Macro resolve: " + paramString + " => " + paramMap);
        }
        return paramMap;
        paramMap = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VFS.Utils", 2, "Macro resolve: " + paramString + " contains no macros.");
        return paramString;
      }
    }
  }
  
  static String normalizePath(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (paramString.isEmpty()) {}
    int j;
    label184:
    do
    {
      return paramString;
      StringTokenizer localStringTokenizer;
      if (paramString.startsWith("/"))
      {
        j = 1;
        localObject = paramString;
        if (paramString.endsWith("/"))
        {
          localObject = paramString;
          if (paramString.length() > 1) {
            localObject = paramString.substring(0, paramString.length() - 1);
          }
        }
        localStringTokenizer = new StringTokenizer(((String)localObject).substring(j), "/");
        paramString = new ArrayList();
      }
      for (;;)
      {
        if (!localStringTokenizer.hasMoreTokens()) {
          break label184;
        }
        String str = localStringTokenizer.nextToken();
        if ((paramBoolean1) && ("..".equals(str)))
        {
          if (paramString.isEmpty())
          {
            return null;
            j = 0;
            break;
          }
          paramString.remove(paramString.size() - 1);
          i = 0;
          continue;
        }
        if (((paramBoolean1) && (".".equals(str))) || ("".equals(str))) {
          i = 0;
        } else {
          paramString.add(str);
        }
      }
      if (i == 0) {
        break;
      }
      paramString = (String)localObject;
    } while (!paramBoolean2);
    return ((String)localObject).substring(j);
    Object localObject = new StringBuilder();
    if ((!paramBoolean2) && (j > 0)) {
      ((StringBuilder)localObject).append('/');
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      ((StringBuilder)localObject).append(paramString.next());
      while (paramString.hasNext())
      {
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(paramString.next());
      }
    }
    return ((StringBuilder)localObject).toString();
  }
  
  static String normalizePathSimple(String paramString)
  {
    if (paramString.isEmpty()) {}
    for (;;)
    {
      return paramString;
      if (paramString.startsWith("/")) {}
      for (int i = 1; (paramString.endsWith("/")) && (paramString.length() > 1); i = 0) {
        return paramString.substring(i, paramString.length() - 1);
      }
    }
  }
  
  static Uri parseUri(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    if ((paramString.isEmpty()) || (paramString.charAt(0) == '/')) {
      return localBuilder.path(paramString).build();
    }
    int j = paramString.indexOf(':');
    if (j < 0) {
      localBuilder.path(paramString);
    }
    for (;;)
    {
      return localBuilder.build();
      localBuilder.scheme(paramString.substring(0, j));
      int k = paramString.length();
      if ((k > j + 2) && (paramString.charAt(j + 1) == '/') && (paramString.charAt(j + 2) == '/'))
      {
        int i = j + 3;
        while (i < k) {
          switch (paramString.charAt(i))
          {
          default: 
            i += 1;
          }
        }
        localBuilder.authority(paramString.substring(j + 3, i));
        if (i < k) {
          localBuilder.path(paramString.substring(i + 1));
        }
      }
      else
      {
        localBuilder.path(paramString.substring(j + 1));
      }
    }
  }
  
  static String resolveRealPath(Uri paramUri, boolean paramBoolean)
  {
    paramUri = FileSystemManager.instance().resolve(paramUri);
    if (!paramUri.valid()) {}
    while ((paramUri.fileSystem.capabilityFlags() & 0x2) == 0) {
      return null;
    }
    return paramUri.fileSystem.realPath(paramUri.path, paramBoolean);
  }
  
  /* Error */
  public static long streamCopy(FileSystem paramFileSystem1, String paramString1, FileSystem paramFileSystem2, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: lconst_0
    //   7: lstore 5
    //   9: aload_0
    //   10: aload_1
    //   11: invokeinterface 284 2 0
    //   16: astore_1
    //   17: aload 8
    //   19: astore_0
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 288 3 0
    //   28: astore_2
    //   29: aload_2
    //   30: astore_0
    //   31: sipush 2048
    //   34: newarray byte
    //   36: astore_3
    //   37: aload_2
    //   38: astore_0
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 294	java/io/InputStream:read	([B)I
    //   44: istore 4
    //   46: iload 4
    //   48: iconst_m1
    //   49: if_icmpeq +24 -> 73
    //   52: aload_2
    //   53: astore_0
    //   54: aload_2
    //   55: aload_3
    //   56: iconst_0
    //   57: iload 4
    //   59: invokevirtual 300	java/io/OutputStream:write	([BII)V
    //   62: lload 5
    //   64: iload 4
    //   66: i2l
    //   67: ladd
    //   68: lstore 5
    //   70: goto -33 -> 37
    //   73: aload_1
    //   74: invokestatic 302	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload_2
    //   78: invokestatic 302	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   81: lload 5
    //   83: lreturn
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload 7
    //   89: astore_0
    //   90: aload_1
    //   91: invokestatic 302	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aload_0
    //   95: invokestatic 302	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: goto -11 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramFileSystem1	FileSystem
    //   0	104	1	paramString1	String
    //   0	104	2	paramFileSystem2	FileSystem
    //   0	104	3	paramString2	String
    //   44	21	4	i	int
    //   7	75	5	l	long
    //   4	84	7	localObject1	Object
    //   1	17	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	84	finally
    //   20	29	100	finally
    //   31	37	100	finally
    //   39	46	100	finally
    //   54	62	100	finally
  }
  
  static String uriToString(Uri paramUri)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramUri.getScheme();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      localStringBuilder.append(paramUri);
    }
    return localStringBuilder.toString();
  }
  
  public static void writeFileSystemVersion(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    paramParcel.writeInt(paramClass.getName().hashCode() ^ paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSUtils
 * JD-Core Version:    0.7.0.1
 */