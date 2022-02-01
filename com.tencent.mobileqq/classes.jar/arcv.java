import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.MD5;

public class arcv
  extends arcq
  implements arcr
{
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  public boolean a;
  
  public arcv(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label25;
      }
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return;
      label25:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          break;
        }
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_2
    //   13: invokevirtual 33	java/io/File:exists	()Z
    //   16: ifne +86 -> 102
    //   19: aload_2
    //   20: invokevirtual 57	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 59	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: iconst_1
    //   30: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   39: aload_2
    //   40: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   43: aload_2
    //   44: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   47: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   50: ldc 81
    //   52: iconst_0
    //   53: invokevirtual 85	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   56: invokeinterface 91 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 93
    //   65: lload_3
    //   66: invokeinterface 99 4 0
    //   71: pop
    //   72: aload_1
    //   73: invokeinterface 102 1 0
    //   78: pop
    //   79: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +11 -> 93
    //   85: ldc 109
    //   87: iconst_2
    //   88: ldc 111
    //   90: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   101: return
    //   102: aload_2
    //   103: invokevirtual 39	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: invokevirtual 57	java/io/File:createNewFile	()Z
    //   111: pop
    //   112: goto -88 -> 24
    //   115: astore_1
    //   116: aload 5
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull -19 -> 101
    //   123: aload_1
    //   124: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: return
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: goto -5 -> 141
    //   149: astore_1
    //   150: goto -17 -> 133
    //   153: astore_1
    //   154: aload_2
    //   155: astore_1
    //   156: goto -37 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	arcv
    //   0	159	1	paramArrayOfByte	byte[]
    //   0	159	2	paramString	String
    //   0	159	3	paramLong	long
    //   10	107	5	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	24	115	java/lang/Exception
    //   24	34	115	java/lang/Exception
    //   102	112	115	java/lang/Exception
    //   123	127	128	java/lang/Exception
    //   12	24	130	finally
    //   24	34	130	finally
    //   102	112	130	finally
    //   97	101	143	java/lang/Exception
    //   137	141	145	java/lang/Exception
    //   34	93	149	finally
    //   34	93	153	java/lang/Exception
  }
  
  /* Error */
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: new 29	java/io/File
    //   11: dup
    //   12: new 120	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 136
    //   33: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: new 29	java/io/File
    //   47: dup
    //   48: new 120	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   55: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   58: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 141
    //   69: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload 6
    //   85: invokevirtual 33	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 6
    //   93: invokevirtual 144	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload_2
    //   98: invokevirtual 33	java/io/File:exists	()Z
    //   101: ifne +45 -> 146
    //   104: aload_2
    //   105: invokevirtual 57	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 59	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: iconst_1
    //   115: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: astore_2
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   124: aload_2
    //   125: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   128: aload_2
    //   129: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 146	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 147	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iload_3
    //   145: ireturn
    //   146: aload_2
    //   147: invokevirtual 39	java/io/File:delete	()Z
    //   150: pop
    //   151: aload_2
    //   152: invokevirtual 57	java/io/File:createNewFile	()Z
    //   155: pop
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload 5
    //   162: astore_1
    //   163: iconst_0
    //   164: istore_3
    //   165: aload_1
    //   166: ifnull -22 -> 144
    //   169: aload_1
    //   170: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_1
    //   190: aload 4
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   208: goto -7 -> 201
    //   211: astore_1
    //   212: goto -19 -> 193
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -55 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	arcv
    //   0	221	1	paramArrayOfByte	byte[]
    //   0	221	2	paramString	String
    //   7	158	3	bool	boolean
    //   1	190	4	localObject1	java.lang.Object
    //   4	157	5	localObject2	java.lang.Object
    //   42	50	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	97	159	java/lang/Exception
    //   97	109	159	java/lang/Exception
    //   109	119	159	java/lang/Exception
    //   146	156	159	java/lang/Exception
    //   169	173	175	java/io/IOException
    //   136	144	182	java/io/IOException
    //   83	97	189	finally
    //   97	109	189	finally
    //   109	119	189	finally
    //   146	156	189	finally
    //   197	201	203	java/io/IOException
    //   119	132	211	finally
    //   119	132	215	java/lang/Exception
  }
  
  /* Error */
  private boolean b(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: new 29	java/io/File
    //   11: dup
    //   12: new 120	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 153
    //   33: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 155
    //   38: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 6
    //   49: new 29	java/io/File
    //   52: dup
    //   53: new 120	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   60: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   66: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 153
    //   74: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 155
    //   79: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 153
    //   84: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 7
    //   99: aload 4
    //   101: astore_2
    //   102: aload 6
    //   104: invokevirtual 33	java/io/File:exists	()Z
    //   107: ifne +12 -> 119
    //   110: aload 4
    //   112: astore_2
    //   113: aload 6
    //   115: invokevirtual 144	java/io/File:mkdirs	()Z
    //   118: pop
    //   119: aload 4
    //   121: astore_2
    //   122: aload 7
    //   124: invokevirtual 33	java/io/File:exists	()Z
    //   127: ifne +57 -> 184
    //   130: aload 4
    //   132: astore_2
    //   133: aload 7
    //   135: invokevirtual 57	java/io/File:createNewFile	()Z
    //   138: pop
    //   139: aload 4
    //   141: astore_2
    //   142: new 59	java/io/FileOutputStream
    //   145: dup
    //   146: aload 7
    //   148: iconst_1
    //   149: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   152: astore 4
    //   154: aload 4
    //   156: aload_1
    //   157: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   160: aload 4
    //   162: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   165: aload 4
    //   167: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   170: iconst_0
    //   171: ifeq +11 -> 182
    //   174: new 146	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 147	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: iload_3
    //   183: ireturn
    //   184: aload 4
    //   186: astore_2
    //   187: aload 7
    //   189: invokevirtual 39	java/io/File:delete	()Z
    //   192: pop
    //   193: aload 4
    //   195: astore_2
    //   196: aload 7
    //   198: invokevirtual 57	java/io/File:createNewFile	()Z
    //   201: pop
    //   202: goto -63 -> 139
    //   205: astore 4
    //   207: aload 5
    //   209: astore_1
    //   210: aload_1
    //   211: astore_2
    //   212: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +15 -> 230
    //   218: aload_1
    //   219: astore_2
    //   220: ldc 157
    //   222: iconst_2
    //   223: ldc 159
    //   225: aload 4
    //   227: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: iconst_0
    //   231: istore_3
    //   232: aload_1
    //   233: ifnull -51 -> 182
    //   236: aload_1
    //   237: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   254: iconst_1
    //   255: ireturn
    //   256: astore_1
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   272: goto -7 -> 265
    //   275: astore_1
    //   276: aload 4
    //   278: astore_2
    //   279: goto -22 -> 257
    //   282: astore_2
    //   283: aload 4
    //   285: astore_1
    //   286: aload_2
    //   287: astore 4
    //   289: goto -79 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	arcv
    //   0	292	1	paramArrayOfByte	byte[]
    //   0	292	2	paramString	String
    //   7	225	3	bool	boolean
    //   1	193	4	localFileOutputStream	java.io.FileOutputStream
    //   205	79	4	localException	Exception
    //   287	1	4	str	String
    //   4	204	5	localObject	java.lang.Object
    //   47	67	6	localFile1	File
    //   97	100	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   102	110	205	java/lang/Exception
    //   113	119	205	java/lang/Exception
    //   122	130	205	java/lang/Exception
    //   133	139	205	java/lang/Exception
    //   142	154	205	java/lang/Exception
    //   187	193	205	java/lang/Exception
    //   196	202	205	java/lang/Exception
    //   236	240	242	java/io/IOException
    //   174	182	249	java/io/IOException
    //   102	110	256	finally
    //   113	119	256	finally
    //   122	130	256	finally
    //   133	139	256	finally
    //   142	154	256	finally
    //   187	193	256	finally
    //   196	202	256	finally
    //   212	218	256	finally
    //   220	230	256	finally
    //   261	265	267	java/io/IOException
    //   154	170	275	finally
    //   154	170	282	java/lang/Exception
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0L;
    }
    return ((arcw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long;
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: iload_1
    //   14: iflt +18 -> 32
    //   17: iload_1
    //   18: aload_0
    //   19: getfield 166	arcv:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: invokevirtual 172	java/util/ArrayList:size	()I
    //   25: if_icmplt +10 -> 35
    //   28: aload 4
    //   30: astore 5
    //   32: aload 5
    //   34: areturn
    //   35: aload 7
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 166	arcv:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual 176	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 178	arcw
    //   50: astore 8
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: getfield 189	arcw:jdField_a_of_type_Byte	B
    //   61: istore_2
    //   62: aload 4
    //   64: astore 5
    //   66: iload_2
    //   67: tableswitch	default:+25 -> 92, 1:+27->94, 2:+-35->32, 3:+44->111
    //   93: areturn
    //   94: aload 7
    //   96: astore 5
    //   98: aload 8
    //   100: getfield 192	arcw:b	Ljava/lang/String;
    //   103: invokestatic 197	bggl:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   106: astore 4
    //   108: aload 4
    //   110: areturn
    //   111: aload 7
    //   113: astore 5
    //   115: aload_0
    //   116: getfield 166	arcv:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   119: iload_1
    //   120: invokevirtual 176	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   123: checkcast 178	arcw
    //   126: getfield 200	arcw:jdField_a_of_type_ArrayOfByte	[B
    //   129: astore 9
    //   131: aload 7
    //   133: astore 5
    //   135: aload_0
    //   136: getfield 166	arcv:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   139: iload_1
    //   140: invokevirtual 176	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   143: checkcast 178	arcw
    //   146: getfield 203	arcw:c	Ljava/lang/String;
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +47 -> 200
    //   156: aload 7
    //   158: astore 5
    //   160: aload_0
    //   161: getfield 204	arcv:jdField_a_of_type_Byte	B
    //   164: iconst_1
    //   165: if_icmpne +35 -> 200
    //   168: aload 7
    //   170: astore 5
    //   172: aload_0
    //   173: invokevirtual 206	arcv:a	()Z
    //   176: ifne +24 -> 200
    //   179: aload 7
    //   181: astore 5
    //   183: aload_0
    //   184: invokevirtual 208	arcv:b	()Z
    //   187: ifne +13 -> 200
    //   190: aload 7
    //   192: astore 5
    //   194: aload 10
    //   196: invokestatic 197	bggl:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   199: areturn
    //   200: aload 10
    //   202: ifnull +94 -> 296
    //   205: aload 7
    //   207: astore 5
    //   209: aload_0
    //   210: getfield 204	arcv:jdField_a_of_type_Byte	B
    //   213: ifne +83 -> 296
    //   216: aload 7
    //   218: astore 5
    //   220: new 29	java/io/File
    //   223: dup
    //   224: aload 10
    //   226: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 33	java/io/File:exists	()Z
    //   232: ifeq +45 -> 277
    //   235: aload 7
    //   237: astore 5
    //   239: aload 10
    //   241: invokestatic 197	bggl:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   244: astore 4
    //   246: aload 4
    //   248: ifnonnull +261 -> 509
    //   251: aload 8
    //   253: getfield 209	arcw:jdField_a_of_type_Boolean	Z
    //   256: ifeq +253 -> 509
    //   259: aload 8
    //   261: iconst_0
    //   262: putfield 209	arcw:jdField_a_of_type_Boolean	Z
    //   265: aload_0
    //   266: aload 8
    //   268: getfield 192	arcw:b	Ljava/lang/String;
    //   271: invokevirtual 211	arcv:c	(Ljava/lang/String;)V
    //   274: aload 4
    //   276: areturn
    //   277: aload 7
    //   279: astore 5
    //   281: aload_0
    //   282: aload 8
    //   284: getfield 192	arcw:b	Ljava/lang/String;
    //   287: invokevirtual 211	arcv:c	(Ljava/lang/String;)V
    //   290: aconst_null
    //   291: astore 4
    //   293: goto -19 -> 274
    //   296: aload 7
    //   298: astore 5
    //   300: aload 10
    //   302: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +143 -> 448
    //   308: aload 7
    //   310: astore 5
    //   312: aload_0
    //   313: getfield 204	arcv:jdField_a_of_type_Byte	B
    //   316: iconst_2
    //   317: if_icmpne +131 -> 448
    //   320: aload 7
    //   322: astore 5
    //   324: new 29	java/io/File
    //   327: dup
    //   328: aload 10
    //   330: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 33	java/io/File:exists	()Z
    //   336: istore_3
    //   337: aload 6
    //   339: astore 4
    //   341: iload_3
    //   342: ifeq +14 -> 356
    //   345: aload 7
    //   347: astore 5
    //   349: aload 10
    //   351: invokestatic 197	bggl:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   354: astore 4
    //   356: aload 4
    //   358: astore 5
    //   360: aload 4
    //   362: ifnonnull -330 -> 32
    //   365: aload 4
    //   367: astore 5
    //   369: aload_0
    //   370: aload 8
    //   372: getfield 192	arcw:b	Ljava/lang/String;
    //   375: invokevirtual 211	arcv:c	(Ljava/lang/String;)V
    //   378: aload 4
    //   380: areturn
    //   381: astore 6
    //   383: aload 5
    //   385: astore 4
    //   387: aload 4
    //   389: astore 5
    //   391: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -362 -> 32
    //   397: ldc 219
    //   399: iconst_2
    //   400: aload 6
    //   402: invokestatic 223	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   405: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload 4
    //   410: areturn
    //   411: astore 9
    //   413: aload 6
    //   415: astore 4
    //   417: aload 7
    //   419: astore 5
    //   421: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -68 -> 356
    //   427: aload 7
    //   429: astore 5
    //   431: ldc 157
    //   433: iconst_2
    //   434: ldc 228
    //   436: aload 9
    //   438: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 6
    //   443: astore 4
    //   445: goto -89 -> 356
    //   448: aload 4
    //   450: astore 5
    //   452: aload 9
    //   454: ifnull -422 -> 32
    //   457: aload 7
    //   459: astore 5
    //   461: aload 9
    //   463: arraylength
    //   464: istore_1
    //   465: aload 4
    //   467: astore 5
    //   469: iload_1
    //   470: ifle -438 -> 32
    //   473: aload 9
    //   475: iconst_0
    //   476: aload 9
    //   478: arraylength
    //   479: invokestatic 234	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   482: astore 4
    //   484: aload 4
    //   486: areturn
    //   487: astore 4
    //   489: aload 6
    //   491: astore 4
    //   493: goto -137 -> 356
    //   496: astore 6
    //   498: goto -111 -> 387
    //   501: astore 4
    //   503: aconst_null
    //   504: areturn
    //   505: astore 4
    //   507: aconst_null
    //   508: areturn
    //   509: goto -235 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	arcv
    //   0	512	1	paramInt	int
    //   61	6	2	i	int
    //   336	6	3	bool	boolean
    //   7	478	4	localObject1	java.lang.Object
    //   487	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   491	1	4	localThrowable1	java.lang.Throwable
    //   501	1	4	localException1	Exception
    //   505	1	4	localThrowable2	java.lang.Throwable
    //   11	457	5	localObject2	java.lang.Object
    //   1	337	6	localObject3	java.lang.Object
    //   381	109	6	localThrowable3	java.lang.Throwable
    //   496	1	6	localThrowable4	java.lang.Throwable
    //   4	454	7	localObject4	java.lang.Object
    //   50	321	8	localarcw	arcw
    //   129	1	9	arrayOfByte	byte[]
    //   411	66	9	localException2	Exception
    //   149	201	10	str	String
    // Exception table:
    //   from	to	target	type
    //   39	52	381	java/lang/Throwable
    //   56	62	381	java/lang/Throwable
    //   98	108	381	java/lang/Throwable
    //   115	131	381	java/lang/Throwable
    //   135	151	381	java/lang/Throwable
    //   160	168	381	java/lang/Throwable
    //   172	179	381	java/lang/Throwable
    //   183	190	381	java/lang/Throwable
    //   194	200	381	java/lang/Throwable
    //   209	216	381	java/lang/Throwable
    //   220	235	381	java/lang/Throwable
    //   239	246	381	java/lang/Throwable
    //   281	290	381	java/lang/Throwable
    //   300	308	381	java/lang/Throwable
    //   312	320	381	java/lang/Throwable
    //   324	337	381	java/lang/Throwable
    //   349	356	381	java/lang/Throwable
    //   369	378	381	java/lang/Throwable
    //   421	427	381	java/lang/Throwable
    //   431	441	381	java/lang/Throwable
    //   461	465	381	java/lang/Throwable
    //   349	356	411	java/lang/Exception
    //   349	356	487	java/lang/OutOfMemoryError
    //   251	274	496	java/lang/Throwable
    //   98	108	501	java/lang/Exception
    //   473	484	505	java/lang/Throwable
  }
  
  public arcw a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6)
  {
    arcw localarcw = new arcw(this);
    localarcw.jdField_a_of_type_Long = paramLong;
    localarcw.jdField_a_of_type_JavaLangString = paramString1;
    localarcw.b = paramString2;
    localarcw.d = paramString3;
    localarcw.jdField_a_of_type_Byte = paramByte;
    localarcw.c = paramString4;
    localarcw.e = paramString5;
    localarcw.jdField_a_of_type_Short = paramShort;
    localarcw.f = paramString6;
    localarcw.jdField_a_of_type_Int = 0;
    return localarcw;
  }
  
  public arcw a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    arcw localarcw = new arcw(this);
    localarcw.jdField_a_of_type_Long = paramLong;
    localarcw.jdField_a_of_type_JavaLangString = paramString1;
    localarcw.b = paramString2;
    localarcw.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localarcw.d = paramString3;
    localarcw.jdField_a_of_type_Byte = paramByte;
    localarcw.jdField_a_of_type_Int = 0;
    return localarcw;
  }
  
  public arcw a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramString3, paramString4, paramString5, paramShort, "");
  }
  
  public arcw a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramArrayOfByte, paramString3);
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((arcw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e;
  }
  
  public String a(String paramString, byte paramByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    switch (paramByte)
    {
    default: 
      str = paramString;
    }
    for (;;)
    {
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShanPing", 2, "flashlogo final request url = " + str);
      return str;
      str = paramString;
      if (!paramString.startsWith("/"))
      {
        str = "/" + paramString;
        continue;
        if ((paramString.startsWith("http://")) && (!paramString.endsWith(".png")))
        {
          if (this.jdField_a_of_type_Byte == 6) {
            str = paramString + "_" + aqkt.b + "_" + aqkt.jdField_a_of_type_Byte + ".png";
          } else if (this.jdField_a_of_type_Byte == 0) {
            str = paramString + "_" + (aqkt.jdField_a_of_type_Byte - 2) + ".png";
          } else if ((this.jdField_a_of_type_Byte == 1) && (paramString.contains("[]"))) {
            str = paramString.replace("[]", bgln.g() + "x" + bgln.h());
          } else {
            str = paramString + "_" + aqkt.jdField_a_of_type_Byte + ".png";
          }
        }
        else
        {
          str = paramString;
          if (paramString.startsWith("http://"))
          {
            str = paramString;
            if (this.jdField_a_of_type_Byte == 1)
            {
              str = paramString;
              if (paramString.contains("[]")) {
                str = paramString.replace("[]", bgln.g() + "x" + bgln.h());
              }
            }
          }
        }
      }
    }
  }
  
  public short a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((arcw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Short;
  }
  
  public void a()
  {
    a(true);
    long l = this.c;
    this.b = -1L;
    this.c = -1L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    switch (this.jdField_a_of_type_Byte)
    {
    }
    for (;;)
    {
      return;
      c();
      return;
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
      try
      {
        if (localFile.exists())
        {
          localFile.delete();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(bgux parambgux1, bgux parambgux2)
  {
    if ((parambgux1 == null) || (parambgux2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
    }
    a(parambgux1.a(), parambgux2.a());
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.b = paramDataInputStream.readLong();
    this.c = paramDataInputStream.readLong();
    this.jdField_a_of_type_Byte = paramDataInputStream.readByte();
    int j = paramDataInputStream.readInt();
    if (j > 0)
    {
      int i = 0;
      if (i < j)
      {
        arcw localarcw = new arcw(this);
        if (this.jdField_a_of_type_Byte == 2) {
          localarcw.b(paramDataInputStream);
        }
        for (;;)
        {
          a(localarcw);
          i += 1;
          break;
          localarcw.a(paramDataInputStream);
        }
      }
    }
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeLong(this.b);
    paramDataOutputStream.writeLong(this.c);
    paramDataOutputStream.writeByte(this.jdField_a_of_type_Byte);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      paramDataOutputStream.writeInt(0);
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramDataOutputStream.writeInt(j);
    int i = 0;
    label78:
    arcw localarcw;
    if (i < j)
    {
      localarcw = (arcw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_Byte != 2) {
        break label117;
      }
      localarcw.b(paramDataOutputStream);
    }
    for (;;)
    {
      i += 1;
      break label78;
      break;
      label117:
      localarcw.a(paramDataOutputStream);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, byte[] arg2)
  {
    if ((??? == null) || (???.length <= 0) || (paramString == null) || (paramString.length() <= 0))
    {
      if (!TextUtils.isEmpty(paramString)) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
          return;
        }
      }
    }
    else
    {
      ArrayList localArrayList = aqkt.a();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        arcw localarcw = (arcw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramString.startsWith(localarcw.b))
        {
          if (this.jdField_a_of_type_Byte == 1)
          {
            localarcw.c = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
            a(???, localarcw.c, this.b);
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((aqku)???.next()).a(true, this.jdField_a_of_type_Short, i, paramString);
            }
          }
          if (this.jdField_a_of_type_Byte == 0)
          {
            a(???, String.valueOf(localarcw.f));
            try
            {
              ??? = new File(localarcw.c);
              if (!MD5.getFileMD5(???).equalsIgnoreCase(localarcw.f))
              {
                ???.delete();
                if (localarcw.jdField_a_of_type_Int < 1)
                {
                  localarcw.jdField_a_of_type_Int += 1;
                  c(localarcw.b);
                }
              }
              if (localArrayList == null) {
                break;
              }
              ??? = localArrayList.iterator();
              while (???.hasNext()) {
                ((aqku)???.next()).a(true, this.jdField_a_of_type_Short, i, paramString);
              }
            }
            catch (Exception ???)
            {
              for (;;)
              {
                ???.printStackTrace();
              }
            }
          }
          if (this.jdField_a_of_type_Byte != 2) {
            break;
          }
          b(???, String.valueOf(localarcw.f));
          for (;;)
          {
            try
            {
              ??? = new File(localarcw.c);
              paramString = MD5.getFileMD5(???);
              if (!paramString.equalsIgnoreCase(localarcw.f))
              {
                ???.delete();
                if (localarcw.jdField_a_of_type_Int >= 1) {
                  break label517;
                }
                localarcw.jdField_a_of_type_Int += 1;
                c(localarcw.b);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PicAndAdConf", 2, "handle download NearbyBanner image, cid = " + localarcw.jdField_a_of_type_Long + ", md5 is " + paramString.equalsIgnoreCase(localarcw.f));
              return;
            }
            catch (Exception paramString)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            QLog.d("PicAndAdConf", 2, "handleImgData exception, item md5 = " + localarcw.f, paramString);
            return;
            label517:
            synchronized (this.jdField_a_of_type_JavaUtilHashMap)
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localarcw.b, Long.valueOf(System.currentTimeMillis()));
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean a(bgux parambgux1, bgux parambgux2, int paramInt)
  {
    if (paramInt == 3)
    {
      parambgux2 = parambgux2.a("Content-Type");
      parambgux1 = null;
      if (parambgux2 != null) {
        parambgux1 = parambgux2.toLowerCase();
      }
      if ((parambgux1 != null) && (parambgux1.indexOf("image") != -1)) {
        return true;
      }
    }
    return false;
  }
  
  public String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((arcw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f;
  }
  
  public void b(bgux parambgux1, bgux parambgux2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      parambgux2 = (arcw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (parambgux1.a().startsWith(parambgux2.b))
      {
        parambgux2 = aqkt.a();
        if (parambgux2 == null) {
          break;
        }
        parambgux2 = parambgux2.iterator();
        while (parambgux2.hasNext()) {
          ((aqku)parambgux2.next()).a(false, this.jdField_a_of_type_Short, i, parambgux1.a());
        }
      }
      i += 1;
    }
  }
  
  public String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((arcw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d;
  }
  
  public void c()
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic");
    try
    {
      a(localFile);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://"))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Byte == 2) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (Math.abs(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue()) < 36000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicAndAdConf", 2, "sendImgRequest | retry interval is too small, " + paramString);
            }
            return;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      ??? = aqkt.a();
    } while (??? == null);
    ((bgut)???).a(new bgux(paramString, null, this, true));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Byte == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownload NearbyBanner image");
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        arcw localarcw = (arcw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localarcw.c != null)
        {
          File localFile = new File(localarcw.c);
          if ((!localFile.exists()) || (!localFile.canRead())) {
            break label92;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label92:
          localStringBuilder.append(" | ").append(localarcw.jdField_a_of_type_Long);
          ThreadManager.post(new PicAndAdConf.1(this, localarcw), 5, null, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcv
 * JD-Core Version:    0.7.0.1
 */