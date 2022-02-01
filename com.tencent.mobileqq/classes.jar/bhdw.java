import android.content.Context;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class bhdw
{
  private FileOutputStream a;
  
  private static File a(Context paramContext)
  {
    return new File(VipWallpaperService.a(paramContext), ".statuslock");
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: invokestatic 31	bhdw:a	(Landroid/content/Context;)Ljava/io/File;
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 35	java/io/File:exists	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +24 -> 39
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 37	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 38	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: iload_2
    //   31: ireturn
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   37: iconst_0
    //   38: ireturn
    //   39: new 43	java/io/FileOutputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: astore 4
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 50	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   57: invokevirtual 56	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +32 -> 96
    //   67: aload 4
    //   69: astore_0
    //   70: aload 5
    //   72: invokevirtual 61	java/nio/channels/FileLock:release	()V
    //   75: iload_1
    //   76: istore_2
    //   77: aload 4
    //   79: ifnull -49 -> 30
    //   82: aload 4
    //   84: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   87: iload_1
    //   88: ireturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   94: iload_1
    //   95: ireturn
    //   96: iconst_1
    //   97: istore_1
    //   98: goto -23 -> 75
    //   101: astore 5
    //   103: aload 4
    //   105: astore_0
    //   106: aload 5
    //   108: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   111: goto -36 -> 75
    //   114: astore 5
    //   116: aload 4
    //   118: astore_0
    //   119: aload 5
    //   121: invokevirtual 65	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aload 4
    //   126: ifnull -96 -> 30
    //   129: aload 4
    //   131: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: athrow
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   163: goto -8 -> 155
    //   166: astore 4
    //   168: goto -21 -> 147
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: goto -60 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   1	97	1	bool1	boolean
    //   3	74	2	bool2	boolean
    //   13	2	3	bool3	boolean
    //   47	83	4	localFileOutputStream	FileOutputStream
    //   143	13	4	localObject1	Object
    //   166	1	4	localObject2	Object
    //   174	1	4	localObject3	Object
    //   60	11	5	localFileLock	java.nio.channels.FileLock
    //   101	6	5	localIOException	IOException
    //   114	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   171	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   22	30	32	java/io/IOException
    //   82	87	89	java/io/IOException
    //   52	62	101	java/io/IOException
    //   70	75	101	java/io/IOException
    //   52	62	114	java/io/FileNotFoundException
    //   70	75	114	java/io/FileNotFoundException
    //   106	111	114	java/io/FileNotFoundException
    //   129	134	136	java/io/IOException
    //   4	14	143	finally
    //   39	49	143	finally
    //   151	155	158	java/io/IOException
    //   52	62	166	finally
    //   70	75	166	finally
    //   106	111	166	finally
    //   119	124	166	finally
    //   4	14	171	java/io/FileNotFoundException
    //   39	49	171	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (this.a != null) {}
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic 31	bhdw:a	(Landroid/content/Context;)Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 35	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 71	java/io/File:createNewFile	()Z
    //   18: pop
    //   19: aload_0
    //   20: new 43	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: putfield 67	bhdw:a	Ljava/io/FileOutputStream;
    //   31: aload_0
    //   32: getfield 67	bhdw:a	Ljava/io/FileOutputStream;
    //   35: invokevirtual 50	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   38: invokevirtual 56	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +5 -> 48
    //   46: iconst_1
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +43 -> 92
    //   52: aload_0
    //   53: getfield 67	bhdw:a	Ljava/io/FileOutputStream;
    //   56: invokevirtual 64	java/io/FileOutputStream:close	()V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 67	bhdw:a	Ljava/io/FileOutputStream;
    //   64: return
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   70: goto -22 -> 48
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 65	java/io/FileNotFoundException:printStackTrace	()V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   84: goto -25 -> 59
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   92: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	bhdw
    //   0	93	1	paramContext	Context
    //   1	48	2	i	int
    // Exception table:
    //   from	to	target	type
    //   31	42	65	java/io/IOException
    //   2	19	73	java/io/FileNotFoundException
    //   19	31	73	java/io/FileNotFoundException
    //   31	42	73	java/io/FileNotFoundException
    //   52	59	73	java/io/FileNotFoundException
    //   59	64	73	java/io/FileNotFoundException
    //   66	70	73	java/io/FileNotFoundException
    //   80	84	73	java/io/FileNotFoundException
    //   52	59	79	java/io/IOException
    //   2	19	87	java/io/IOException
    //   19	31	87	java/io/IOException
    //   59	64	87	java/io/IOException
    //   66	70	87	java/io/IOException
    //   80	84	87	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdw
 * JD-Core Version:    0.7.0.1
 */