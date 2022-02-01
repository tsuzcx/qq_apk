package com.tencent.biz.qqcircle.publish.model;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.publish.queue.util.NeedParcel;
import com.tencent.biz.qqcircle.publish.queue.util.SmartParcelable;

public class UploadObject
  implements SmartParcelable
{
  @NeedParcel
  private String a;
  @NeedParcel
  private String b;
  
  public UploadObject() {}
  
  public UploadObject(String paramString)
  {
    a(paramString);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 49	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 55	java/io/File:exists	()Z
    //   13: istore_2
    //   14: ldc 57
    //   16: astore 7
    //   18: iload_2
    //   19: ifeq +201 -> 220
    //   22: aload_0
    //   23: invokevirtual 60	java/io/File:isFile	()Z
    //   26: ifeq +194 -> 220
    //   29: ldc 62
    //   31: invokestatic 68	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   34: astore 5
    //   36: new 70	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_0
    //   45: aload_0
    //   46: astore_3
    //   47: sipush 16384
    //   50: newarray byte
    //   52: astore 4
    //   54: goto +17 -> 71
    //   57: astore 4
    //   59: goto +68 -> 127
    //   62: aload_0
    //   63: astore_3
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: aload_0
    //   74: aload 4
    //   76: invokevirtual 77	java/io/FileInputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: iconst_m1
    //   82: if_icmpeq +17 -> 99
    //   85: aload_0
    //   86: astore_3
    //   87: aload 5
    //   89: aload 4
    //   91: iconst_0
    //   92: iload_1
    //   93: invokevirtual 81	java/security/MessageDigest:update	([BII)V
    //   96: goto -25 -> 71
    //   99: aload_0
    //   100: astore_3
    //   101: aload 5
    //   103: invokevirtual 85	java/security/MessageDigest:digest	()[B
    //   106: invokestatic 87	com/tencent/biz/qqcircle/publish/model/UploadObject:a	([B)Ljava/lang/String;
    //   109: astore 5
    //   111: aload_0
    //   112: astore 6
    //   114: goto +82 -> 196
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_3
    //   120: goto +90 -> 210
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_0
    //   127: aload 7
    //   129: astore 5
    //   131: aload_0
    //   132: astore 6
    //   134: aload_0
    //   135: astore_3
    //   136: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +57 -> 196
    //   142: aload_0
    //   143: astore_3
    //   144: new 94	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   151: astore 5
    //   153: aload_0
    //   154: astore_3
    //   155: aload 5
    //   157: ldc 97
    //   159: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_0
    //   164: astore_3
    //   165: aload 5
    //   167: aload 4
    //   169: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: astore_3
    //   178: ldc 107
    //   180: iconst_2
    //   181: aload 5
    //   183: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_0
    //   190: astore 6
    //   192: aload 7
    //   194: astore 5
    //   196: aload 6
    //   198: ifnull +8 -> 206
    //   201: aload 6
    //   203: invokevirtual 117	java/io/FileInputStream:close	()V
    //   206: aload 5
    //   208: areturn
    //   209: astore_0
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 117	java/io/FileInputStream:close	()V
    //   218: aload_0
    //   219: athrow
    //   220: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +11 -> 234
    //   226: ldc 107
    //   228: iconst_2
    //   229: ldc 119
    //   231: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: ldc 57
    //   236: areturn
    //   237: astore_3
    //   238: goto -176 -> 62
    //   241: astore_0
    //   242: aload 5
    //   244: areturn
    //   245: astore_3
    //   246: goto -28 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   79	14	1	i	int
    //   13	6	2	bool	boolean
    //   46	169	3	str1	String
    //   237	1	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   245	1	3	localIOException	java.io.IOException
    //   52	1	4	arrayOfByte1	byte[]
    //   57	1	4	localException1	java.lang.Exception
    //   69	21	4	arrayOfByte2	byte[]
    //   123	45	4	localException2	java.lang.Exception
    //   34	209	5	localObject	Object
    //   112	90	6	str2	String
    //   16	177	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   47	54	57	java/lang/Exception
    //   64	71	57	java/lang/Exception
    //   73	80	57	java/lang/Exception
    //   87	96	57	java/lang/Exception
    //   101	111	57	java/lang/Exception
    //   29	45	117	finally
    //   29	45	123	java/lang/Exception
    //   47	54	209	finally
    //   64	71	209	finally
    //   73	80	209	finally
    //   87	96	209	finally
    //   101	111	209	finally
    //   136	142	209	finally
    //   144	153	209	finally
    //   155	163	209	finally
    //   165	176	209	finally
    //   178	189	209	finally
    //   47	54	237	java/lang/OutOfMemoryError
    //   201	206	241	java/io/IOException
    //   214	218	245	java/io/IOException
  }
  
  private String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return b(paramString);
    }
    return null;
  }
  
  public String a()
  {
    String str2 = this.a;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
    this.b = c(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.UploadObject
 * JD-Core Version:    0.7.0.1
 */