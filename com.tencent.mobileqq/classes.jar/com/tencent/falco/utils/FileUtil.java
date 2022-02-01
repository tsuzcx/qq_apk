package com.tencent.falco.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintStream;

public final class FileUtil
{
  private static final int BUFFER = 8192;
  
  public static String convertHashToString(byte[] paramArrayOfByte)
  {
    String str = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1);
      i += 1;
    }
    return str.toLowerCase();
  }
  
  /* Error */
  public static boolean copyDir(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore 5
    //   6: new 47	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 54	java/io/File:mkdirs	()Z
    //   17: pop
    //   18: new 47	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 58	java/io/File:list	()[Ljava/lang/String;
    //   29: astore 10
    //   31: iconst_0
    //   32: istore_2
    //   33: iload 5
    //   35: istore 4
    //   37: iload_2
    //   38: aload 10
    //   40: arraylength
    //   41: if_icmpge +297 -> 338
    //   44: aload_0
    //   45: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 66	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   51: ifeq +142 -> 193
    //   54: new 47	java/io/File
    //   57: dup
    //   58: new 18	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 10
    //   71: iload_2
    //   72: aaload
    //   73: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore 7
    //   84: aload 7
    //   86: invokevirtual 69	java/io/File:isFile	()Z
    //   89: istore 4
    //   91: iload 4
    //   93: ifeq +154 -> 247
    //   96: new 71	java/io/FileInputStream
    //   99: dup
    //   100: aload 7
    //   102: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore 6
    //   107: new 76	java/io/FileOutputStream
    //   110: dup
    //   111: new 18	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   118: aload_1
    //   119: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 78
    //   124: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 7
    //   129: invokevirtual 81	java/io/File:getName	()Ljava/lang/String;
    //   132: invokevirtual 82	java/lang/String:toString	()Ljava/lang/String;
    //   135: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   144: astore 9
    //   146: sipush 5120
    //   149: newarray byte
    //   151: astore 11
    //   153: aload 6
    //   155: aload 11
    //   157: invokevirtual 87	java/io/FileInputStream:read	([B)I
    //   160: istore_3
    //   161: iload_3
    //   162: iconst_m1
    //   163: if_icmpeq +69 -> 232
    //   166: aload 9
    //   168: aload 11
    //   170: iconst_0
    //   171: iload_3
    //   172: invokevirtual 91	java/io/FileOutputStream:write	([BII)V
    //   175: goto -22 -> 153
    //   178: astore_0
    //   179: aload 9
    //   181: astore_1
    //   182: aload 6
    //   184: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   187: aload_1
    //   188: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   191: aload_0
    //   192: athrow
    //   193: new 47	java/io/File
    //   196: dup
    //   197: new 18	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   204: aload_0
    //   205: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   211: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 10
    //   216: iload_2
    //   217: aaload
    //   218: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   227: astore 7
    //   229: goto -145 -> 84
    //   232: aload 9
    //   234: invokevirtual 100	java/io/FileOutputStream:flush	()V
    //   237: aload 6
    //   239: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   242: aload 9
    //   244: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   247: aload 7
    //   249: invokevirtual 103	java/io/File:isDirectory	()Z
    //   252: ifeq +59 -> 311
    //   255: new 18	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   262: aload_0
    //   263: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc 78
    //   268: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 10
    //   273: iload_2
    //   274: aaload
    //   275: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: new 18	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   288: aload_1
    //   289: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc 78
    //   294: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 10
    //   299: iload_2
    //   300: aaload
    //   301: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 105	com/tencent/falco/utils/FileUtil:copyDir	(Ljava/lang/String;Ljava/lang/String;)Z
    //   310: pop
    //   311: iload_2
    //   312: iconst_1
    //   313: iadd
    //   314: istore_2
    //   315: goto -282 -> 33
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_1
    //   321: aload 8
    //   323: astore 6
    //   325: goto -143 -> 182
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -149 -> 182
    //   334: astore_0
    //   335: iconst_0
    //   336: istore 4
    //   338: iload 4
    //   340: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramString1	String
    //   0	341	1	paramString2	String
    //   32	283	2	i	int
    //   160	12	3	j	int
    //   35	304	4	bool1	boolean
    //   4	30	5	bool2	boolean
    //   105	219	6	localObject1	Object
    //   82	166	7	localFile	File
    //   1	321	8	localObject2	Object
    //   144	99	9	localFileOutputStream	java.io.FileOutputStream
    //   29	269	10	arrayOfString	String[]
    //   151	18	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   146	153	178	finally
    //   153	161	178	finally
    //   166	175	178	finally
    //   232	237	178	finally
    //   96	107	318	finally
    //   107	146	328	finally
    //   6	31	334	java/lang/Exception
    //   37	84	334	java/lang/Exception
    //   84	91	334	java/lang/Exception
    //   182	193	334	java/lang/Exception
    //   193	229	334	java/lang/Exception
    //   237	247	334	java/lang/Exception
    //   247	311	334	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 47	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   16: invokevirtual 113	java/io/File:exists	()Z
    //   19: ifne +23 -> 42
    //   22: aload_1
    //   23: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 54	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual 113	java/io/File:exists	()Z
    //   34: ifeq +8 -> 42
    //   37: aload_1
    //   38: invokevirtual 116	java/io/File:delete	()Z
    //   41: pop
    //   42: new 47	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 113	java/io/File:exists	()Z
    //   53: istore_3
    //   54: iload_3
    //   55: ifeq +91 -> 146
    //   58: new 71	java/io/FileInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   66: astore_0
    //   67: new 76	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_1
    //   76: sipush 1024
    //   79: newarray byte
    //   81: astore 4
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 121	java/io/InputStream:read	([B)I
    //   89: istore_2
    //   90: iload_2
    //   91: iconst_m1
    //   92: if_icmpeq +40 -> 132
    //   95: aload_1
    //   96: aload 4
    //   98: iconst_0
    //   99: iload_2
    //   100: invokevirtual 91	java/io/FileOutputStream:write	([BII)V
    //   103: goto -20 -> 83
    //   106: astore 5
    //   108: aload_0
    //   109: astore 4
    //   111: aload 5
    //   113: astore_0
    //   114: aload 4
    //   116: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   119: aload_1
    //   120: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_1
    //   133: invokevirtual 100	java/io/FileOutputStream:flush	()V
    //   136: aload_0
    //   137: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   140: aload_1
    //   141: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   144: iconst_1
    //   145: ireturn
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -37 -> 114
    //   154: astore 5
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_0
    //   159: astore 4
    //   161: aload 5
    //   163: astore_0
    //   164: goto -50 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString1	String
    //   0	167	1	paramString2	String
    //   89	11	2	i	int
    //   53	2	3	bool	boolean
    //   1	159	4	localObject1	Object
    //   106	6	5	localObject2	Object
    //   154	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	83	106	finally
    //   83	90	106	finally
    //   95	103	106	finally
    //   132	136	106	finally
    //   3	42	125	java/lang/Exception
    //   42	54	125	java/lang/Exception
    //   114	125	125	java/lang/Exception
    //   136	144	125	java/lang/Exception
    //   58	67	148	finally
    //   67	76	154	finally
  }
  
  public static boolean createDir(String paramString)
  {
    return new File(paramString).mkdirs();
  }
  
  public static void createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      File localFile = paramString.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString.createNewFile();
    }
  }
  
  public static boolean deleteDirectory(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = paramString;
        if (!paramString.endsWith(File.separator)) {
          localObject = paramString + File.separator;
        }
        paramString = new File((String)localObject);
      } while ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()));
      localObject = paramString.listFiles();
    } while (localObject == null);
    if (i < localObject.length)
    {
      if (localObject[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject[i].isFile())
        {
          deleteFile(localObject[i].getAbsolutePath());
          System.out.println(localObject[i].getAbsolutePath() + " delete suc");
        }
        else
        {
          deleteDirectory(localObject[i].getAbsolutePath());
        }
      }
    }
    paramString.delete();
    return true;
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean exists(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String getCacheDir(Context paramContext)
  {
    return paramContext.getCacheDir().getAbsolutePath();
  }
  
  public static String getDir(Context paramContext)
  {
    return paramContext.getDir(null, 0).getAbsolutePath();
  }
  
  public static String getExternalCacheDir(Context paramContext)
  {
    return paramContext.getExternalCacheDir().getAbsolutePath();
  }
  
  /* Error */
  public static String getFileSHA1(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_1
    //   5: new 71	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: sipush 1024
    //   17: newarray byte
    //   19: astore_3
    //   20: ldc 178
    //   22: invokestatic 184	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore 5
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +45 -> 74
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 121	java/io/InputStream:read	([B)I
    //   37: istore_2
    //   38: iload_2
    //   39: istore_1
    //   40: iload_2
    //   41: ifle -14 -> 27
    //   44: aload 5
    //   46: aload_3
    //   47: iconst_0
    //   48: iload_2
    //   49: invokevirtual 187	java/security/MessageDigest:update	([BII)V
    //   52: iload_2
    //   53: istore_1
    //   54: goto -27 -> 27
    //   57: astore_3
    //   58: aload 4
    //   60: astore_3
    //   61: aload_0
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: invokevirtual 189	java/io/InputStream:close	()V
    //   69: aload 4
    //   71: astore_3
    //   72: aload_3
    //   73: areturn
    //   74: aload 5
    //   76: invokevirtual 193	java/security/MessageDigest:digest	()[B
    //   79: invokestatic 195	com/tencent/falco/utils/FileUtil:convertHashToString	([B)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: astore 4
    //   86: aload 4
    //   88: astore_3
    //   89: aload_0
    //   90: ifnull -18 -> 72
    //   93: aload_0
    //   94: invokevirtual 189	java/io/InputStream:close	()V
    //   97: aload 4
    //   99: areturn
    //   100: astore_0
    //   101: aload 4
    //   103: areturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 189	java/io/InputStream:close	()V
    //   115: aload_3
    //   116: athrow
    //   117: astore_0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: goto -6 -> 115
    //   124: astore_3
    //   125: goto -18 -> 107
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: goto -73 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   4	50	1	i	int
    //   37	16	2	j	int
    //   19	28	3	arrayOfByte	byte[]
    //   57	1	3	localException	Exception
    //   60	29	3	localObject1	Object
    //   104	12	3	localObject2	Object
    //   124	1	3	localObject3	Object
    //   1	101	4	localObject4	Object
    //   25	50	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   14	27	57	java/lang/Exception
    //   32	38	57	java/lang/Exception
    //   44	52	57	java/lang/Exception
    //   74	83	57	java/lang/Exception
    //   93	97	100	java/lang/Exception
    //   5	14	104	finally
    //   65	69	117	java/lang/Exception
    //   111	115	120	java/lang/Exception
    //   14	27	124	finally
    //   32	38	124	finally
    //   44	52	124	finally
    //   74	83	124	finally
    //   5	14	128	java/lang/Exception
  }
  
  public static String getFilesDir(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) || (!paramString1.isFile())) {
      return false;
    }
    return paramString1.renameTo(new File(paramString2));
  }
  
  /* Error */
  public static String readString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 18	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: new 71	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 206	java/io/BufferedReader
    //   25: dup
    //   26: new 208	java/io/InputStreamReader
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 211	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 217	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +29 -> 73
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   62: aload_1
    //   63: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   66: aload_0
    //   67: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   70: ldc 16
    //   72: areturn
    //   73: aload 4
    //   75: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_2
    //   79: aload_1
    //   80: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   87: aload_2
    //   88: areturn
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   96: aload_2
    //   97: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: goto -11 -> 92
    //   106: astore_3
    //   107: aload_0
    //   108: astore_2
    //   109: aload_3
    //   110: astore_0
    //   111: goto -19 -> 92
    //   114: astore_3
    //   115: aload_0
    //   116: astore_2
    //   117: aload_3
    //   118: astore_0
    //   119: goto -27 -> 92
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_3
    //   126: astore_1
    //   127: goto -69 -> 58
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -75 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   21	106	1	localObject1	Object
    //   1	49	2	str1	String
    //   57	2	2	localException1	Exception
    //   78	39	2	str2	String
    //   122	1	2	localException2	Exception
    //   130	1	2	localException3	Exception
    //   3	1	3	localObject2	Object
    //   106	4	3	localObject3	Object
    //   114	12	3	localObject4	Object
    //   11	63	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Exception
    //   47	54	57	java/lang/Exception
    //   73	79	57	java/lang/Exception
    //   13	22	89	finally
    //   22	38	102	finally
    //   38	43	106	finally
    //   47	54	106	finally
    //   73	79	106	finally
    //   58	62	114	finally
    //   13	22	122	java/lang/Exception
    //   22	38	130	java/lang/Exception
  }
  
  /* Error */
  public static void writeString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 47	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 47	java/io/File
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 222	java/io/File:getParent	()Ljava/lang/String;
    //   22: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 113	java/io/File:exists	()Z
    //   28: ifne +18 -> 46
    //   31: new 47	java/io/File
    //   34: dup
    //   35: aload_2
    //   36: invokevirtual 222	java/io/File:getParent	()Ljava/lang/String;
    //   39: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 54	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aload_2
    //   47: invokevirtual 113	java/io/File:exists	()Z
    //   50: ifne +8 -> 58
    //   53: aload_2
    //   54: invokevirtual 129	java/io/File:createNewFile	()Z
    //   57: pop
    //   58: new 76	java/io/FileOutputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: new 224	java/io/BufferedWriter
    //   70: dup
    //   71: new 226	java/io/OutputStreamWriter
    //   74: dup
    //   75: aload_2
    //   76: invokespecial 229	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   79: invokespecial 232	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   82: astore_0
    //   83: aload_0
    //   84: aload_1
    //   85: iconst_0
    //   86: aload_1
    //   87: invokevirtual 236	java/lang/String:length	()I
    //   90: invokevirtual 239	java/io/BufferedWriter:write	(Ljava/lang/String;II)V
    //   93: aload_0
    //   94: invokevirtual 240	java/io/BufferedWriter:flush	()V
    //   97: aload_2
    //   98: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   101: aload_0
    //   102: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   105: return
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_3
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   115: aload_0
    //   116: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   119: aload_1
    //   120: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   123: return
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_2
    //   127: aload 4
    //   129: astore_1
    //   130: aload_2
    //   131: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   134: aload_1
    //   135: invokestatic 97	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: aload 4
    //   143: astore_1
    //   144: goto -14 -> 130
    //   147: astore_3
    //   148: aload_0
    //   149: astore_1
    //   150: aload_3
    //   151: astore_0
    //   152: goto -22 -> 130
    //   155: astore_3
    //   156: aload_0
    //   157: astore_2
    //   158: aload_3
    //   159: astore_0
    //   160: goto -30 -> 130
    //   163: astore_1
    //   164: aload_2
    //   165: astore_0
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: goto -59 -> 111
    //   173: astore_1
    //   174: aload_2
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_0
    //   179: astore_1
    //   180: aload_3
    //   181: astore_0
    //   182: goto -71 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString1	String
    //   0	185	1	paramString2	String
    //   13	85	2	localObject1	Object
    //   106	6	2	localException	Exception
    //   126	52	2	localObject2	Object
    //   4	106	3	localObject3	Object
    //   147	4	3	localObject4	Object
    //   155	14	3	localObject5	Object
    //   175	6	3	localObject6	Object
    //   1	141	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	46	106	java/lang/Exception
    //   46	58	106	java/lang/Exception
    //   58	67	106	java/lang/Exception
    //   5	46	124	finally
    //   46	58	124	finally
    //   58	67	124	finally
    //   67	83	140	finally
    //   83	97	147	finally
    //   111	115	155	finally
    //   67	83	163	java/lang/Exception
    //   83	97	173	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */