package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.gathererga.core.AndroidInfoProvider;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;
import com.tencent.gathererga.core.internal.util.UUIDUtil;
import java.io.File;
import org.json.JSONObject;

public class AndroidInfoProviderImpl
  implements AndroidInfoProvider
{
  private Context a = null;
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @InfoID(id=405)
  public ProviderResult getKernelVersion(ProviderMethodPriority paramProviderMethodPriority)
  {
    return null;
  }
  
  @InfoID(id=403)
  public ProviderResult getOsVersion(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Build.VERSION.RELEASE);
  }
  
  /* Error */
  @InfoID(id=404)
  public ProviderResult getProcVersion(ProviderMethodPriority paramProviderMethodPriority)
  {
    // Byte code:
    //   0: new 43	java/io/RandomAccessFile
    //   3: dup
    //   4: ldc 45
    //   6: ldc 47
    //   8: invokespecial 50	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: astore_1
    //   16: new 26	com/tencent/gathererga/core/internal/provider/ProviderResultImpl
    //   19: dup
    //   20: iconst_0
    //   21: i2l
    //   22: aload 4
    //   24: invokevirtual 54	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   27: invokespecial 35	com/tencent/gathererga/core/internal/provider/ProviderResultImpl:<init>	(JLjava/lang/Object;)V
    //   30: astore 5
    //   32: aload 4
    //   34: invokevirtual 57	java/io/RandomAccessFile:close	()V
    //   37: aload 5
    //   39: areturn
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   45: aload 5
    //   47: areturn
    //   48: astore 5
    //   50: goto +20 -> 70
    //   53: astore 5
    //   55: goto +99 -> 154
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_1
    //   62: goto +173 -> 235
    //   65: astore 5
    //   67: aconst_null
    //   68: astore 4
    //   70: sipush -402
    //   73: istore_3
    //   74: aload 4
    //   76: astore_1
    //   77: new 62	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   84: astore 6
    //   86: aload 4
    //   88: astore_1
    //   89: aload 6
    //   91: ldc 65
    //   93: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: astore_1
    //   100: aload 6
    //   102: aload 5
    //   104: invokevirtual 72	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: astore_1
    //   114: aload 6
    //   116: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 81	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   122: iload_3
    //   123: istore_2
    //   124: aload 4
    //   126: ifnull +96 -> 222
    //   129: iload_3
    //   130: istore_2
    //   131: aload 4
    //   133: invokevirtual 57	java/io/RandomAccessFile:close	()V
    //   136: iload_3
    //   137: istore_2
    //   138: goto +84 -> 222
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   146: goto +76 -> 222
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: sipush -401
    //   157: istore_3
    //   158: aload 4
    //   160: astore_1
    //   161: new 62	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   168: astore 6
    //   170: aload 4
    //   172: astore_1
    //   173: aload 6
    //   175: ldc 65
    //   177: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: astore_1
    //   184: aload 6
    //   186: aload 5
    //   188: invokevirtual 82	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: astore_1
    //   198: aload 6
    //   200: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 81	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   206: iload_3
    //   207: istore_2
    //   208: aload 4
    //   210: ifnull +12 -> 222
    //   213: iload_3
    //   214: istore_2
    //   215: aload 4
    //   217: invokevirtual 57	java/io/RandomAccessFile:close	()V
    //   220: iload_3
    //   221: istore_2
    //   222: new 26	com/tencent/gathererga/core/internal/provider/ProviderResultImpl
    //   225: dup
    //   226: iload_2
    //   227: i2l
    //   228: aconst_null
    //   229: invokespecial 35	com/tencent/gathererga/core/internal/provider/ProviderResultImpl:<init>	(JLjava/lang/Object;)V
    //   232: areturn
    //   233: astore 4
    //   235: aload_1
    //   236: ifnull +15 -> 251
    //   239: aload_1
    //   240: invokevirtual 57	java/io/RandomAccessFile:close	()V
    //   243: goto +8 -> 251
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   251: aload 4
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	AndroidInfoProviderImpl
    //   0	254	1	paramProviderMethodPriority	ProviderMethodPriority
    //   123	104	2	i	int
    //   73	148	3	j	int
    //   11	22	4	localRandomAccessFile	java.io.RandomAccessFile
    //   58	1	4	localObject1	Object
    //   68	148	4	localObject2	Object
    //   233	19	4	localObject3	Object
    //   30	16	5	localProviderResultImpl	ProviderResultImpl
    //   48	1	5	localIOException1	java.io.IOException
    //   53	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   65	38	5	localIOException2	java.io.IOException
    //   149	38	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   84	115	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	37	40	java/io/IOException
    //   16	32	48	java/io/IOException
    //   16	32	53	java/io/FileNotFoundException
    //   0	13	58	finally
    //   0	13	65	java/io/IOException
    //   131	136	141	java/io/IOException
    //   215	220	141	java/io/IOException
    //   0	13	149	java/io/FileNotFoundException
    //   16	32	233	finally
    //   77	86	233	finally
    //   89	97	233	finally
    //   100	111	233	finally
    //   114	122	233	finally
    //   161	170	233	finally
    //   173	181	233	finally
    //   184	195	233	finally
    //   198	206	233	finally
    //   239	243	246	java/io/IOException
  }
  
  @InfoID(id=402, permissions={"android.permission.WRITE_EXTERNAL_STORAGE"})
  public ProviderResult getUUID(ProviderMethodPriority paramProviderMethodPriority, String paramString)
  {
    return new ProviderResultImpl(0L, UUIDUtil.a.a(this.a, paramString).toString());
  }
  
  @InfoID(id=406)
  public ProviderResult sdCardFreeSpace(ProviderMethodPriority paramProviderMethodPriority)
  {
    boolean bool = "mounted".equals(Environment.getExternalStorageState());
    paramProviderMethodPriority = Integer.valueOf(0);
    if ((bool) && (Environment.getExternalStorageDirectory() != null) && (Environment.getExternalStorageDirectory().exists())) {
      try
      {
        Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = ((StatFs)localObject).getBlockSize();
        localObject = new ProviderResultImpl(0L, Long.valueOf(((StatFs)localObject).getAvailableBlocks() * l));
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return new ProviderResultImpl(-400L, paramProviderMethodPriority);
      }
    }
    return new ProviderResultImpl(-403L, paramProviderMethodPriority);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.impl.AndroidInfoProviderImpl
 * JD-Core Version:    0.7.0.1
 */