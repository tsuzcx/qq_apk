import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

public class bgkv
{
  public static Boolean a;
  public static String a;
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 14	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 22	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 24	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 31	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 35	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 37	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 39	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 35	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 35	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	i	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  public static Uri a(Context paramContext, File paramFile)
  {
    if (a(paramContext)) {
      return b(paramContext, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  public static File a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 71	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 80	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 84	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 86	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc 88
    //   35: invokespecial 91	java/lang/String:<init>	([BLjava/lang/String;)V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 92	java/io/InputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_0
    //   50: ldc 94
    //   52: new 96	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   59: ldc 99
    //   61: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 116	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_2
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: ldc 94
    //   83: new 96	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   90: ldc 118
    //   92: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_2
    //   96: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 116	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 92	java/io/InputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: ldc 94
    //   118: new 96	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   125: ldc 99
    //   127: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 116	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -27 -> 113
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 92	java/io/InputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_0
    //   157: ldc 94
    //   159: new 96	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   166: ldc 99
    //   168: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 116	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: goto -27 -> 154
    //   184: astore_1
    //   185: goto -39 -> 146
    //   188: astore_2
    //   189: goto -110 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   17	58	2	localObject	Object
    //   76	20	2	localException1	Exception
    //   188	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/io/IOException
    //   0	9	76	java/lang/Exception
    //   109	113	115	java/io/IOException
    //   0	9	143	finally
    //   150	154	156	java/io/IOException
    //   11	18	184	finally
    //   20	26	184	finally
    //   28	39	184	finally
    //   81	105	184	finally
    //   11	18	188	java/lang/Exception
    //   20	26	188	java/lang/Exception
    //   28	39	188	java/lang/Exception
  }
  
  public static String a(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = b(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static ArrayList<String> a(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    for (;;)
    {
      try
      {
        int j = localObject.length;
        if (i < j) {
          if (localObject[i].isDirectory())
          {
            if (paramBoolean) {
              paramString.add(localObject[i].getCanonicalPath());
            }
            paramString.addAll(a(localObject[i].getCanonicalPath(), paramBoolean));
          }
          else
          {
            paramString.add(localObject[i].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.e("FileUtils.getChildFiles", "getChildFiles error. " + localException);
      }
      return paramString;
      i += 1;
    }
  }
  
  public static ArrayList<FileInfo> a(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if ((!paramBoolean) && (localObject.getName().startsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localObject.isDirectory()) || (localObject.length() != 0L))
          {
            FileInfo localFileInfo = new FileInfo();
            localFileInfo.d(localObject.getName());
            localFileInfo.a(localObject.isDirectory());
            localFileInfo.e(localObject.getPath());
            localFileInfo.a(localObject.length());
            localFileInfo.b(localObject.lastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      if (paramInt == 0) {
        Collections.sort(localArrayList, new bgkw());
      }
      for (;;)
      {
        return localArrayList;
        Collections.sort(localArrayList, new bgks());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static JSONObject a(String paramString)
  {
    JSONObject localJSONObject;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramString = Os.stat(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", paramString.st_mode);
        localJSONObject.put("size", paramString.st_size);
        localJSONObject.put("lastAccessedTime", paramString.st_atime);
        localJSONObject.put("lastModifiedTime", paramString.st_mtime);
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QMLog.e("FileUtils.getStats", "getStats error. " + paramString);
      }
    }
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        localJSONObject = new JSONObject();
        localJSONObject.put("mode", 0);
        localJSONObject.put("size", paramString.length());
        localJSONObject.put("lastAccessedTime", paramString.lastModified());
        localJSONObject.put("lastModifiedTime", paramString.lastModified());
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        QMLog.e("FileUtils.getStats", "getStats error. " + paramString);
      }
    }
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    bgku.a(paramContext, paramFile);
  }
  
  public static void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = 0;
      if (i < arrayOfFile.length)
      {
        if (arrayOfFile[i].isDirectory()) {
          a(arrayOfFile[i].getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFile[i].delete();
        }
      }
    }
    paramString.delete();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      if ((Build.VERSION.SDK_INT < 24) || (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion < 24)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      return jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    String str = paramString2.getParent();
    if (str != null) {
      c(str);
    }
    boolean bool = b(paramString1, paramString2);
    QMLog.i("FileUtils", "saveVideoToAlbum: " + bool);
    a(paramContext, paramString2);
    return true;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return a(new File(paramString1), new File(paramString2));
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return a(paramString, paramArrayOfByte, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 14	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 22	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_0
    //   23: invokevirtual 58	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 22	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_0
    //   33: invokevirtual 58	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 61	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_0
    //   41: invokevirtual 64	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 381	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: iload_2
    //   51: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 388	java/io/FileOutputStream:write	([BII)V
    //   62: aload_0
    //   63: invokevirtual 391	java/io/FileOutputStream:flush	()V
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore 5
    //   120: aload_0
    //   121: astore_1
    //   122: aload 5
    //   124: astore_0
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: goto -48 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   0	132	1	paramArrayOfByte	byte[]
    //   0	132	2	paramBoolean	boolean
    //   0	132	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject1	Object
    //   118	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	128	java/io/IOException
  }
  
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramString, false);
  }
  
  public static boolean a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return a(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 14	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 22	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 58	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 22	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 58	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 61	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 64	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 381	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 384	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 388	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 391	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: aload_1
    //   124: astore_0
    //   125: goto -44 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramArrayOfByte	byte[]
    //   0	128	1	paramString	String
    //   0	128	2	paramBoolean	boolean
    //   0	128	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	122	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 22	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 402	java/io/BufferedInputStream
    //   12: dup
    //   13: new 24	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 405	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 207	java/io/File:length	()J
    //   30: lstore_3
    //   31: lload_3
    //   32: ldc2_w 406
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +47 -> 89
    //   45: ldc 94
    //   47: new 96	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 409
    //   57: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: lload_3
    //   61: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 414	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload 5
    //   72: ifnull -65 -> 7
    //   75: aload 5
    //   77: invokevirtual 92	java/io/InputStream:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   87: aconst_null
    //   88: areturn
    //   89: lload_3
    //   90: l2i
    //   91: istore_1
    //   92: iload_1
    //   93: newarray byte
    //   95: astore 6
    //   97: iconst_0
    //   98: istore_1
    //   99: iload_1
    //   100: aload 6
    //   102: arraylength
    //   103: if_icmpge +28 -> 131
    //   106: aload 5
    //   108: aload 6
    //   110: iload_1
    //   111: aload 6
    //   113: arraylength
    //   114: iload_1
    //   115: isub
    //   116: invokevirtual 417	java/io/InputStream:read	([BII)I
    //   119: istore_2
    //   120: iload_2
    //   121: iflt +10 -> 131
    //   124: iload_1
    //   125: iload_2
    //   126: iadd
    //   127: istore_1
    //   128: goto -29 -> 99
    //   131: iload_1
    //   132: aload 6
    //   134: arraylength
    //   135: if_icmpge +28 -> 163
    //   138: ldc 94
    //   140: new 96	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 419
    //   150: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 414	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload 5
    //   165: ifnull +8 -> 173
    //   168: aload 5
    //   170: invokevirtual 92	java/io/InputStream:close	()V
    //   173: aload 6
    //   175: areturn
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   181: goto -8 -> 173
    //   184: astore 5
    //   186: aconst_null
    //   187: astore 5
    //   189: ldc 94
    //   191: new 96	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 421
    //   201: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 414	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload 5
    //   216: ifnull -209 -> 7
    //   219: aload 5
    //   221: invokevirtual 92	java/io/InputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: astore 5
    //   237: aload 5
    //   239: ifnull +8 -> 247
    //   242: aload 5
    //   244: invokevirtual 92	java/io/InputStream:close	()V
    //   247: aload_0
    //   248: athrow
    //   249: astore 5
    //   251: aload 5
    //   253: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   256: goto -9 -> 247
    //   259: astore_0
    //   260: goto -23 -> 237
    //   263: astore_0
    //   264: goto -27 -> 237
    //   267: astore 6
    //   269: goto -80 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramFile	File
    //   91	45	1	i	int
    //   119	8	2	j	int
    //   30	60	3	l	long
    //   24	145	5	localBufferedInputStream	java.io.BufferedInputStream
    //   184	1	5	localThrowable1	Throwable
    //   187	56	5	localObject	Object
    //   249	3	5	localThrowable2	Throwable
    //   95	79	6	arrayOfByte	byte[]
    //   267	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   75	80	82	java/lang/Throwable
    //   168	173	176	java/lang/Throwable
    //   9	26	184	java/lang/Throwable
    //   219	224	226	java/lang/Throwable
    //   9	26	233	finally
    //   242	247	249	java/lang/Throwable
    //   26	31	259	finally
    //   45	70	259	finally
    //   92	97	259	finally
    //   99	120	259	finally
    //   131	163	259	finally
    //   189	214	263	finally
    //   26	31	267	java/lang/Throwable
    //   45	70	267	java/lang/Throwable
    //   92	97	267	java/lang/Throwable
    //   99	120	267	java/lang/Throwable
    //   131	163	267	java/lang/Throwable
  }
  
  public static long b(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label36;
      }
      l1 = paramString.length();
    }
    label36:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists())
      {
        if (!localObject.isDirectory()) {
          break label133;
        }
        l1 = l2 + b(localObject.getAbsolutePath());
      }
    }
    for (;;)
    {
      i += 1;
      l2 = l1;
      break;
      label133:
      l1 = l2;
      if (localObject.isFile()) {
        l1 = l2 + localObject.length();
      }
    }
  }
  
  private static Uri b(Context paramContext, File paramFile)
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getUriForFile(paramContext, jdField_a_of_type_JavaLangString, paramFile);
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 22	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 177	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 12	java/io/IOException
    //   29: dup
    //   30: new 96	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 438
    //   40: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 440
    //   50: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 441	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 444	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 12	java/io/IOException
    //   70: dup
    //   71: new 96	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 438
    //   81: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 446
    //   91: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 441	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 448	java/io/FileNotFoundException
    //   104: dup
    //   105: new 96	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 438
    //   115: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 450
    //   125: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 451	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 24	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 453	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc_w 455
    //   152: invokespecial 458	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_0
    //   157: invokevirtual 207	java/io/File:length	()J
    //   160: l2i
    //   161: istore_1
    //   162: iload_1
    //   163: sipush 12288
    //   166: if_icmple +100 -> 266
    //   169: sipush 4096
    //   172: newarray char
    //   174: astore_0
    //   175: new 96	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 461	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 5
    //   187: aload_2
    //   188: aload_0
    //   189: invokevirtual 464	java/io/InputStreamReader:read	([C)I
    //   192: istore_1
    //   193: iconst_m1
    //   194: iload_1
    //   195: if_icmpeq +42 -> 237
    //   198: aload 5
    //   200: aload_0
    //   201: iconst_0
    //   202: iload_1
    //   203: invokevirtual 467	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -20 -> 187
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 92	java/io/InputStream:close	()V
    //   221: aload 4
    //   223: astore_3
    //   224: aload_0
    //   225: ifnull -215 -> 10
    //   228: aload_0
    //   229: invokevirtual 468	java/io/InputStreamReader:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 92	java/io/InputStream:close	()V
    //   251: aload_0
    //   252: astore_3
    //   253: aload_2
    //   254: ifnull -244 -> 10
    //   257: aload_2
    //   258: invokevirtual 468	java/io/InputStreamReader:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_2
    //   264: aload_0
    //   265: areturn
    //   266: iload_1
    //   267: newarray char
    //   269: astore_0
    //   270: new 86	java/lang/String
    //   273: dup
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_2
    //   277: aload_0
    //   278: invokevirtual 464	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 471	java/lang/String:<init>	([CII)V
    //   284: astore_0
    //   285: goto -42 -> 243
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 92	java/io/InputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 468	java/io/InputStreamReader:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: goto -61 -> 251
    //   315: astore_2
    //   316: goto -95 -> 221
    //   319: astore_3
    //   320: goto -19 -> 301
    //   323: astore_2
    //   324: goto -15 -> 309
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -37 -> 293
    //   333: astore_0
    //   334: goto -41 -> 293
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -129 -> 213
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -135 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   161	106	1	i	int
    //   155	103	2	localInputStreamReader	java.io.InputStreamReader
    //   263	14	2	localException1	Exception
    //   292	14	2	localObject1	Object
    //   315	1	2	localException2	Exception
    //   323	1	2	localException3	Exception
    //   329	1	2	localObject2	Object
    //   9	289	3	localObject3	Object
    //   311	1	3	localException4	Exception
    //   319	1	3	localException5	Exception
    //   341	1	3	localObject4	Object
    //   1	221	4	localObject5	Object
    //   185	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	210	java/lang/Exception
    //   169	187	210	java/lang/Exception
    //   187	193	210	java/lang/Exception
    //   198	207	210	java/lang/Exception
    //   237	243	210	java/lang/Exception
    //   266	285	210	java/lang/Exception
    //   228	232	234	java/lang/Exception
    //   257	261	263	java/lang/Exception
    //   135	144	288	finally
    //   247	251	311	java/lang/Exception
    //   217	221	315	java/lang/Exception
    //   297	301	319	java/lang/Exception
    //   305	309	323	java/lang/Exception
    //   144	156	327	finally
    //   156	162	333	finally
    //   169	187	333	finally
    //   187	193	333	finally
    //   198	207	333	finally
    //   237	243	333	finally
    //   266	285	333	finally
    //   135	144	337	java/lang/Exception
    //   144	156	345	java/lang/Exception
  }
  
  public static JSONObject b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("/", a(paramString));
      Object localObject = a(paramString, true);
      paramString = new File(paramString);
      paramString = paramString.getCanonicalPath() + "/";
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str.replace(paramString, ""), a(str));
      }
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QMLog.e("FileUtils.getStatsByDir", "getStatsByDir error. " + paramString);
      return null;
    }
  }
  
  public static void b(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    do
    {
      return;
      paramString = new File(paramString).listFiles();
    } while ((paramString == null) || (paramString.length <= 0));
    int i = 0;
    label38:
    if (i < paramString.length)
    {
      if (!paramString[i].isDirectory()) {
        break label69;
      }
      a(paramString[i].getAbsolutePath());
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label69:
      paramString[i].delete();
    }
  }
  
  /* Error */
  public static boolean b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokevirtual 22	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_1
    //   20: invokevirtual 310	java/io/File:delete	()Z
    //   23: pop
    //   24: new 381	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: new 402	java/io/BufferedInputStream
    //   36: dup
    //   37: new 24	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 405	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 5
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 499	java/io/BufferedInputStream:read	([B)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +52 -> 117
    //   68: aload_1
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 388	java/io/FileOutputStream:write	([BII)V
    //   76: aload_1
    //   77: invokevirtual 391	java/io/FileOutputStream:flush	()V
    //   80: goto -24 -> 56
    //   83: astore 5
    //   85: aload_0
    //   86: astore 5
    //   88: aload_1
    //   89: astore_0
    //   90: aload 5
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   101: iload 4
    //   103: istore_3
    //   104: aload_1
    //   105: ifnull +10 -> 115
    //   108: aload_1
    //   109: invokevirtual 500	java/io/BufferedInputStream:close	()V
    //   112: iload 4
    //   114: istore_3
    //   115: iload_3
    //   116: ireturn
    //   117: iconst_1
    //   118: istore_3
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   127: aload_0
    //   128: ifnull -13 -> 115
    //   131: aload_0
    //   132: invokevirtual 500	java/io/BufferedInputStream:close	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_0
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 7
    //   145: astore_0
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   154: iload 4
    //   156: istore_3
    //   157: aload_0
    //   158: ifnull -43 -> 115
    //   161: aload_0
    //   162: invokevirtual 500	java/io/BufferedInputStream:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 392	java/io/FileOutputStream:close	()V
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 500	java/io/BufferedInputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: goto -67 -> 127
    //   197: astore_0
    //   198: goto -97 -> 101
    //   201: astore_0
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: goto -51 -> 154
    //   208: astore_1
    //   209: goto -28 -> 181
    //   212: astore_1
    //   213: goto -22 -> 191
    //   216: astore_0
    //   217: goto -44 -> 173
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: goto -55 -> 173
    //   231: astore_0
    //   232: aload 7
    //   234: astore_0
    //   235: goto -89 -> 146
    //   238: astore 5
    //   240: goto -94 -> 146
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_0
    //   246: aload 6
    //   248: astore_1
    //   249: goto -156 -> 93
    //   252: astore_0
    //   253: aload_1
    //   254: astore_0
    //   255: aload 6
    //   257: astore_1
    //   258: goto -165 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramFile1	File
    //   0	261	1	paramFile2	File
    //   62	11	2	i	int
    //   103	54	3	bool1	boolean
    //   10	145	4	bool2	boolean
    //   4	66	5	arrayOfByte	byte[]
    //   83	1	5	localIOException	IOException
    //   86	138	5	localFile	File
    //   238	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   7	1	6	localObject1	Object
    //   220	36	6	localObject2	Object
    //   1	232	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	56	83	java/io/IOException
    //   56	63	83	java/io/IOException
    //   68	80	83	java/io/IOException
    //   131	135	137	java/io/IOException
    //   12	24	140	java/lang/OutOfMemoryError
    //   24	33	140	java/lang/OutOfMemoryError
    //   161	165	167	java/io/IOException
    //   12	24	170	finally
    //   24	33	170	finally
    //   123	127	193	java/io/IOException
    //   97	101	197	java/io/IOException
    //   108	112	201	java/io/IOException
    //   150	154	204	java/io/IOException
    //   177	181	208	java/io/IOException
    //   186	191	212	java/io/IOException
    //   33	49	216	finally
    //   49	56	220	finally
    //   56	63	220	finally
    //   68	80	220	finally
    //   33	49	231	java/lang/OutOfMemoryError
    //   49	56	238	java/lang/OutOfMemoryError
    //   56	63	238	java/lang/OutOfMemoryError
    //   68	80	238	java/lang/OutOfMemoryError
    //   12	24	243	java/io/IOException
    //   24	33	243	java/io/IOException
    //   33	49	252	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = b(paramString1, a(paramString2));
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean c(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      QMLog.w("FileUtils", "mkdirs failed, path: " + paramString);
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkv
 * JD-Core Version:    0.7.0.1
 */