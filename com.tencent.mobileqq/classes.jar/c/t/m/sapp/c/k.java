package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;

public class k
{
  public File a;
  public File b;
  public Context c;
  
  public k(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.c = paramContext.getApplicationContext();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getExternalFilesDir("data").getAbsolutePath());
      localStringBuilder.append("/d_l");
      this.a = new File(localStringBuilder.toString());
      return;
    }
    catch (Throwable paramContext)
    {
      label62:
      break label62;
    }
    this.a = null;
  }
  
  public final File a()
  {
    try
    {
      File localFile = this.a;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      long l = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
      localObject = q.c(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("d_");
      localStringBuilder.append((String)localObject);
      localFile = new File(localFile, localStringBuilder.toString());
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      label96:
      break label96;
    }
    return null;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +112 -> 113
    //   4: aload_1
    //   5: arraylength
    //   6: ifne +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   14: ifnonnull +11 -> 25
    //   17: aload_0
    //   18: aload_0
    //   19: invokevirtual 90	c/t/m/sapp/c/k:a	()Ljava/io/File;
    //   22: putfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   25: aload_0
    //   26: getfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: aconst_null
    //   36: astore_2
    //   37: new 92	java/io/BufferedOutputStream
    //   40: dup
    //   41: new 94	java/io/FileOutputStream
    //   44: dup
    //   45: aload_0
    //   46: getfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   49: iconst_1
    //   50: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   53: invokespecial 100	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: aload_1
    //   61: invokevirtual 103	java/io/BufferedOutputStream:write	([B)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: invokevirtual 106	java/io/BufferedOutputStream:flush	()V
    //   70: aload_3
    //   71: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   79: return
    //   80: astore_1
    //   81: goto +22 -> 103
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 88	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   101: return
    //   102: astore_1
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: return
    //   114: astore_1
    //   115: return
    //   116: astore_1
    //   117: goto -33 -> 84
    //   120: astore_1
    //   121: aload_3
    //   122: astore_1
    //   123: goto -37 -> 86
    //   126: astore_1
    //   127: goto -53 -> 74
    //   130: astore_1
    //   131: return
    //   132: astore_2
    //   133: goto -22 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	k
    //   0	136	1	paramArrayOfByte	byte[]
    //   29	79	2	localObject	Object
    //   132	1	2	localIOException	java.io.IOException
    //   56	66	3	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	57	80	finally
    //   59	64	102	finally
    //   66	70	102	finally
    //   88	93	102	finally
    //   4	9	114	java/lang/Throwable
    //   10	25	114	java/lang/Throwable
    //   25	30	114	java/lang/Throwable
    //   70	74	114	java/lang/Throwable
    //   74	79	114	java/lang/Throwable
    //   97	101	114	java/lang/Throwable
    //   107	111	114	java/lang/Throwable
    //   111	113	114	java/lang/Throwable
    //   37	57	116	java/io/IOException
    //   59	64	120	java/io/IOException
    //   66	70	120	java/io/IOException
    //   70	74	126	java/io/IOException
    //   97	101	130	java/io/IOException
    //   107	111	132	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.k
 * JD-Core Version:    0.7.0.1
 */