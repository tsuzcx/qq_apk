package com.tencent.mobileqq.ark.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public class NativeLibLoader
{
  private static int a(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetPlatformBuildNumber();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getPlatformBuildNumber();
    }
    return 0;
  }
  
  private static long a(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetARMv7LibCRC32();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibCRC32();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibCRC32();
    }
    return -1L;
  }
  
  public static String a()
  {
    return "png-armeabi-v7a";
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.ArkEngineExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getParent());
    localStringBuilder.append("/txlib/");
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    return String.format("lib%s.so", new Object[] { paramString });
  }
  
  private static String a(String paramString, int paramInt)
  {
    String str2 = String.format(Locale.CHINA, "%07x.so", new Object[] { Integer.valueOf(paramInt) });
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() > 6) {
        str1 = str2.substring(0, 6);
      }
    }
    return String.format(Locale.CHINA, "lib%s-%s.so", new Object[] { paramString, str1 });
  }
  
  private static void a(String paramString1, String paramString2)
  {
    paramString2 = String.format("lib%s", new Object[] { paramString2 });
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkEngineExtract", 2, "path.listFiles return null!!");
      }
      return;
    }
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString1[i];
      String str = localObject.getName();
      if (str.startsWith(paramString2))
      {
        localObject.delete();
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "remove previous so: ", str });
        }
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start LoadExtractedSo: ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("ArkApp.ArkEngineExtract", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(a(paramContext));
      ((StringBuilder)localObject1).append(a(paramString));
      localObject1 = ((StringBuilder)localObject1).toString();
      int i = b(paramString);
      long l1 = a(paramString);
      File localFile = new File((String)localObject1);
      if ((localFile.exists()) && ((i == -1) || (i == localFile.length()))) {
        if (l1 != -1L)
        {
          long l2 = IOUtil.getCRC32Value(localFile);
          if (l1 != l2) {}
        }
        else
        {
          try
          {
            System.loadLibrary("c++_shared");
            System.load((String)localObject1);
            return true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("arkso.old.load.fail.2.");
            ((StringBuilder)localObject2).append(paramString);
            localObject2 = ((StringBuilder)localObject2).toString();
            QLog.i("ArkApp.ArkEngineExtract", 1, (String)localObject2, localUnsatisfiedLinkError);
            ArkAppDataReport.a((String)localObject2);
          }
          catch (SecurityException localSecurityException)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("arkso.old.load.fail.1.");
            ((StringBuilder)localObject2).append(paramString);
            localObject2 = ((StringBuilder)localObject2).toString();
            QLog.i("ArkApp.ArkEngineExtract", 1, (String)localObject2, localSecurityException);
            ArkAppDataReport.a((String)localObject2);
          }
        }
      }
      localFile.delete();
      try
      {
        if (b(paramContext, paramString))
        {
          System.loadLibrary("c++_shared");
          System.load((String)localObject1);
          return true;
        }
        paramContext = new StringBuilder();
        paramContext.append("arkso.old.extract.fail.");
        paramContext.append(paramString);
        paramContext = paramContext.toString();
        QLog.i("ArkApp.ArkEngineExtract", 1, paramContext);
        ArkAppDataReport.a(paramContext);
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("arkso.old.load.fail.4.");
        ((StringBuilder)localObject1).append(paramString);
        paramString = ((StringBuilder)localObject1).toString();
        QLog.i("ArkApp.ArkEngineExtract", 1, paramString, paramContext);
        ArkAppDataReport.a(paramString);
      }
      catch (SecurityException paramContext)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("arkso.old.load.fail.3.");
        ((StringBuilder)localObject1).append(paramString);
        paramString = ((StringBuilder)localObject1).toString();
        QLog.i("ArkApp.ArkEngineExtract", 1, paramString, paramContext);
        ArkAppDataReport.a(paramString);
      }
      return true;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      j = a(paramString);
      if (j == 0) {
        break label591;
      }
      if (!paramBoolean) {
        break label586;
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        String str;
        Object localObject1;
        int m;
        long l2;
        Object localObject2;
        long l3;
        for (;;)
        {
          throw paramContext;
        }
        label586:
        int i = 0;
        continue;
        label591:
        i = 1;
        continue;
        paramString = null;
        label598:
        paramBoolean = false;
        continue;
        label603:
        int j = 0;
        continue;
        label609:
        int k = 0;
        continue;
        label615:
        if ((i == 0) && (j == 0))
        {
          label624:
          paramContext = null;
          paramBoolean = true;
          paramString = (String)localObject1;
        }
      }
    }
    l1 = SystemClock.uptimeMillis();
    str = a(paramContext);
    if (TextUtils.isEmpty(str))
    {
      paramContext = "arkso.getTxlibPath.return.null";
    }
    else
    {
      localObject1 = new File(str);
      if ((!((File)localObject1).exists()) && (!((File)localObject1).mkdir()))
      {
        paramContext = "arkso.getTxlibPath.mkdir.fail";
      }
      else
      {
        m = b(paramString);
        l2 = a(paramString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(a(paramString, j));
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if (((File)localObject1).exists())
        {
          if ((m == -1) || (m == ((File)localObject1).length())) {
            break label603;
          }
          j = 1;
          if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value((File)localObject1))) {
            break label609;
          }
          k = 1;
          j |= k;
          if ((j == 0) || (!QLog.isColorLevel())) {
            break label615;
          }
          QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "arkso.corrupt.", ((File)localObject1).getName() });
          break label615;
          ((File)localObject1).delete();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(a(paramString));
        localObject2 = new File(((StringBuilder)localObject2).toString());
        ((File)localObject2).delete();
        a(str, paramString);
        if ((!((File)localObject2).exists()) && (!((File)localObject1).exists()))
        {
          if (SoLoadUtil.a(paramContext, str, "txlib", a(paramString)) != 0)
          {
            ((File)localObject2).delete();
            paramContext = "arkso.extract.fail!!";
            paramString = (String)localObject1;
            break label598;
          }
          if (!((File)localObject2).exists())
          {
            paramContext = "arkso.file.not.exist!!";
            paramString = (String)localObject1;
            break label598;
          }
          l3 = ((File)localObject2).length();
          if ((m != -1) && (m != l3))
          {
            ((File)localObject2).delete();
            paramContext = "arkso.size.mismatch!!";
            paramString = (String)localObject1;
            break label598;
          }
          l3 = IOUtil.getCRC32Value((File)localObject2);
          if ((l2 != -1L) && (l2 != l3))
          {
            ((File)localObject2).delete();
            paramContext = "arkso.crc32.mismatch!!";
            paramString = (String)localObject1;
            break label598;
          }
          ((File)localObject2).renameTo((File)localObject1);
          break label624;
        }
        if (((File)localObject2).exists()) {
          paramContext = ((File)localObject2).getName();
        } else {
          paramContext = ((File)localObject1).getName();
        }
        paramContext = String.format("arkso.delete.%s.fail!!", new Object[] { paramContext });
        paramString = (String)localObject1;
        break label598;
        l2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          if (paramBoolean) {
            QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
          } else if (paramContext != null) {
            QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
          }
        }
        if (paramContext != null) {
          ArkAppDataReport.a(paramContext);
        }
        return paramBoolean;
      }
    }
  }
  
  private static int b(String paramString)
  {
    if (paramString.equals("ark")) {
      return ark.arkGetARMv7LibSize();
    }
    if (paramString.equals("WordSegment")) {
      return WordSegment.getARMv7LibSize();
    }
    if (paramString.equals("png-armeabi-v7a")) {
      return ark.arkGetPngARMv7LibSize();
    }
    return -1;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      l1 = SystemClock.uptimeMillis();
      str = a(paramContext);
      if (TextUtils.isEmpty(str))
      {
        paramContext = "arkso.old.getTxlibPath.return.null";
        break label411;
      }
      localObject = new File(str);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir()))
      {
        paramContext = "arkso.old.mkdir.fail";
        break label411;
      }
      k = b(paramString);
      l2 = a(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(a(paramString));
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        break label172;
      }
      if ((k == -1) || (k == ((File)localObject).length())) {
        break label419;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        long l1;
        String str;
        Object localObject;
        int k;
        long l2;
        for (;;)
        {
          label172:
          throw paramContext;
        }
        label411:
        boolean bool = false;
        paramString = null;
        continue;
        label419:
        int i = 0;
        continue;
        int j = 0;
        label426:
        if ((i | j) == 0)
        {
          label432:
          bool = true;
          paramContext = null;
          paramString = (String)localObject;
          continue;
          label443:
          bool = false;
          paramString = (String)localObject;
        }
      }
    }
    if ((l2 != -1L) && (l2 != IOUtil.getCRC32Value((File)localObject)))
    {
      j = 1;
      break label426;
      ((File)localObject).delete();
      if (((File)localObject).exists())
      {
        paramContext = String.format("arkso.old.delete.%s.fail!!", new Object[] { ((File)localObject).getName() });
        break label443;
      }
      if (SoLoadUtil.a(paramContext, str, "txlib", a(paramString)) != 0)
      {
        ((File)localObject).delete();
        paramContext = "arkso.old.extract.fail!!";
        break label443;
      }
      if (!((File)localObject).exists())
      {
        paramContext = "arkso.old.file.not.exist!!";
        break label443;
      }
      if ((k != -1) && (k != ((File)localObject).length()))
      {
        ((File)localObject).delete();
        paramContext = "arkso.old.size.mismatch!!";
        break label443;
      }
      if ((l2 == -1L) || (l2 == IOUtil.getCRC32Value((File)localObject))) {
        break label432;
      }
      ((File)localObject).delete();
      paramContext = "arkso.old.crc32.mismatch!!";
      break label443;
      l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        if (bool) {
          QLog.d("ArkApp.ArkEngineExtract", 2, new Object[] { "extract.so.", paramString.getName(), ".spend time.", Long.valueOf(l2 - l1) });
        } else if (paramContext != null) {
          QLog.d("ArkApp.ArkEngineExtract", 2, paramContext);
        }
      }
      if (paramContext != null) {
        ArkAppDataReport.a(paramContext);
      }
      return bool;
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    for (;;)
    {
      long l1;
      long l3;
      try
      {
        String str = a(paramString, a(paramString));
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(a(paramContext));
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("start.LoadExtractedSo.");
          ((StringBuilder)localObject2).append(str);
          QLog.i("ArkApp.ArkEngineExtract", 2, ((StringBuilder)localObject2).toString());
        }
        int i = b(paramString);
        l1 = a(paramString);
        Object localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          long l2 = ((File)localObject2).length();
          l3 = IOUtil.getCRC32Value((File)localObject2);
          if ((i == -1) || (i == l2)) {
            break label561;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("ArkApp.ArkEngineExtract", 2, String.format(Locale.CHINA, "library exists but wrong size or crc, fileSize=%d->%d, fileCrc=%d->%d path=%s", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), localObject1 }));
            continue;
            try
            {
              System.loadLibrary("c++_shared");
              System.load((String)localObject1);
              if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkEngineExtract", 2, String.format(Locale.CHINA, "load library with version ok, fileSize=%d->%d, fileCrc=%d->%d path=%s", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), localObject1 }));
              }
              return true;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
            {
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("arkso.load.fail.2.");
              ((StringBuilder)localObject3).append(str);
              localObject3 = ((StringBuilder)localObject3).toString();
              QLog.i("ArkApp.ArkEngineExtract", 1, (String)localObject3, localUnsatisfiedLinkError);
              ArkAppDataReport.a((String)localObject3);
            }
            catch (SecurityException paramContext)
            {
              paramString = new StringBuilder();
              paramString.append("arkso.load.fail.1.");
              paramString.append(str);
              paramString = paramString.toString();
              QLog.i("ArkApp.ArkEngineExtract", 1, paramString, paramContext);
              ArkAppDataReport.a(paramString);
              return false;
            }
          }
        }
        try
        {
          if (a(paramContext, paramString, true))
          {
            System.loadLibrary("c++_shared");
            System.load((String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp.ArkEngineExtract", 2, String.format(Locale.CHINA, "extract and load library with version ok, fileSize=%d, path=%s", new Object[] { Integer.valueOf(i), localObject1 }));
            }
            return true;
          }
          QLog.i("ArkApp.ArkEngineExtract", 1, "arkso.extract.return.false");
          ArkAppDataReport.a("arkso.extract.return.false");
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          paramString = new StringBuilder();
          paramString.append("arkso.load.fail.4.");
          paramString.append(str);
          paramString = paramString.toString();
          QLog.i("ArkApp.ArkEngineExtract", 1, paramString, paramContext);
          ArkAppDataReport.a(paramString);
        }
        catch (SecurityException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append("arkso.load.fail.3.");
          paramString.append(str);
          paramString = paramString.toString();
          QLog.i("ArkApp.ArkEngineExtract", 1, paramString, paramContext);
          ArkAppDataReport.a(paramString);
        }
        return false;
      }
      finally {}
      label561:
      if (l1 != -1L) {
        if (l1 != l3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.NativeLibLoader
 * JD-Core Version:    0.7.0.1
 */