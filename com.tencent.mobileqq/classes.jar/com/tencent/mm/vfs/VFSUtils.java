package com.tencent.mm.vfs;

import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VFSUtils
{
  private static final Pattern MACRO_PATTERN = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
  private static final String TAG = "VFS.Utils";
  
  public static void checkFileSystemVersion(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    paramInt ^= paramClass.getName().hashCode();
    int i = paramParcel.readInt();
    if (i == paramInt) {
      return;
    }
    throw new VFSUtils.FileSystemVersionException(paramClass, i, paramInt);
  }
  
  public static void closeQuietly(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to close object: ");
        localStringBuilder.append(paramCursor.toString());
        QLog.w("VFS.Utils", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void closeQuietly(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      return;
    }
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (Exception paramParcelFileDescriptor)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to close object: ");
        localStringBuilder.append(paramParcelFileDescriptor.toString());
        QLog.w("VFS.Utils", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to close object: ");
        localStringBuilder.append(paramCloseable.toString());
        QLog.w("VFS.Utils", 2, localStringBuilder.toString());
      }
    }
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
    if (paramString == null) {
      return null;
    }
    Matcher localMatcher = MACRO_PATTERN.matcher(paramString);
    if (localMatcher.find())
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      int i = 0;
      Object localObject;
      int j;
      do
      {
        localObject = localMatcher.group(1);
        String str = (String)paramMap.get(localObject);
        if (str == null)
        {
          if (QLog.isColorLevel())
          {
            paramMap = new StringBuilder();
            paramMap.append("Macro resolve: ");
            paramMap.append(paramString);
            paramMap.append(" cannot resolve ${");
            paramMap.append((String)localObject);
            paramMap.append("}.");
            QLog.d("VFS.Utils", 2, paramMap.toString());
          }
          return null;
        }
        localStringBuilder.append(paramString.substring(i, localMatcher.start()));
        localStringBuilder.append(str);
        j = localMatcher.end();
        i = j;
      } while (localMatcher.find());
      localStringBuilder.append(paramString.substring(j));
      paramMap = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Macro resolve: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" => ");
        ((StringBuilder)localObject).append(paramMap);
        QLog.d("VFS.Utils", 2, ((StringBuilder)localObject).toString());
      }
      return paramMap;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("Macro resolve: ");
      paramMap.append(paramString);
      paramMap.append(" contains no macros.");
      QLog.d("VFS.Utils", 2, paramMap.toString());
    }
    return paramString;
  }
  
  static String normalizePath(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static String normalizePathSimple(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  static Uri parseUri(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    if ((!paramString.isEmpty()) && (paramString.charAt(0) != '/'))
    {
      int i = paramString.indexOf(':');
      if (i < 0)
      {
        localBuilder.path(paramString);
      }
      else
      {
        localBuilder.scheme(paramString.substring(0, i));
        int k = paramString.length();
        int j = i + 2;
        if ((k > j) && (paramString.charAt(i + 1) == '/') && (paramString.charAt(j) == '/'))
        {
          j = i + 3;
          i = j;
          while (i < k)
          {
            int m = paramString.charAt(i);
            if ((m == 35) || (m == 47) || (m == 63)) {
              break;
            }
            i += 1;
          }
          localBuilder.authority(paramString.substring(j, i));
          if (i < k) {
            localBuilder.path(paramString.substring(i + 1));
          }
        }
        else
        {
          localBuilder.path(paramString.substring(i + 1));
        }
      }
      return localBuilder.build();
    }
    return localBuilder.path(paramString).build();
  }
  
  static String resolveRealPath(Uri paramUri, boolean paramBoolean)
  {
    paramUri = FileSystemManager.instance().resolve(paramUri);
    if (!paramUri.valid()) {
      return null;
    }
    if ((paramUri.fileSystem.capabilityFlags() & 0x2) != 0) {
      return paramUri.fileSystem.realPath(paramUri.path, paramBoolean);
    }
    return null;
  }
  
  /* Error */
  public static long streamCopy(FileSystem paramFileSystem1, String paramString1, FileSystem paramFileSystem2, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: aload_1
    //   8: invokeinterface 260 2 0
    //   13: astore_1
    //   14: aload 8
    //   16: astore_0
    //   17: aload_2
    //   18: aload_3
    //   19: iconst_0
    //   20: invokeinterface 264 3 0
    //   25: astore_2
    //   26: aload_2
    //   27: astore_0
    //   28: sipush 2048
    //   31: newarray byte
    //   33: astore_3
    //   34: lconst_0
    //   35: lstore 5
    //   37: aload_2
    //   38: astore_0
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 270	java/io/InputStream:read	([B)I
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
    //   59: invokevirtual 276	java/io/OutputStream:write	([BII)V
    //   62: lload 5
    //   64: iload 4
    //   66: i2l
    //   67: ladd
    //   68: lstore 5
    //   70: goto -33 -> 37
    //   73: aload_1
    //   74: invokestatic 278	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload_2
    //   78: invokestatic 278	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   81: lload 5
    //   83: lreturn
    //   84: astore_2
    //   85: goto +9 -> 94
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload 7
    //   93: astore_0
    //   94: aload_1
    //   95: invokestatic 278	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload_0
    //   99: invokestatic 278	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   102: goto +5 -> 107
    //   105: aload_2
    //   106: athrow
    //   107: goto -2 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramFileSystem1	FileSystem
    //   0	110	1	paramString1	String
    //   0	110	2	paramFileSystem2	FileSystem
    //   0	110	3	paramString2	String
    //   44	21	4	i	int
    //   35	47	5	l	long
    //   1	91	7	localObject1	Object
    //   4	11	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	84	finally
    //   28	34	84	finally
    //   39	46	84	finally
    //   54	62	84	finally
    //   6	14	88	finally
  }
  
  static String uriToString(Uri paramUri)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramUri.getScheme();
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append(str);
      localStringBuilder.append(':');
    }
    str = paramUri.getAuthority();
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("//");
      localStringBuilder.append(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSUtils
 * JD-Core Version:    0.7.0.1
 */