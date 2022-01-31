import android.annotation.TargetApi;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import java.util.ArrayList;

public class cf
  extends AsyncTask<Object, Void, Uri>
{
  cf(LiteActivity paramLiteActivity) {}
  
  /* Error */
  protected Uri a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_1
    //   15: iconst_0
    //   16: aaload
    //   17: checkcast 22	android/content/Context
    //   20: astore 11
    //   22: aload_1
    //   23: iconst_1
    //   24: aaload
    //   25: checkcast 24	android/net/Uri
    //   28: astore 12
    //   30: getstatic 30	alof:bs	Ljava/lang/String;
    //   33: astore 10
    //   35: aload 11
    //   37: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: aload 12
    //   42: iconst_1
    //   43: anewarray 36	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 38
    //   50: aastore
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +227 -> 286
    //   62: aload_1
    //   63: invokeinterface 50 1 0
    //   68: ifeq +218 -> 286
    //   71: aload_1
    //   72: iconst_0
    //   73: invokeinterface 54 2 0
    //   78: astore 6
    //   80: aload_1
    //   81: invokeinterface 57 1 0
    //   86: aload 10
    //   88: invokestatic 62	bdhb:a	(Ljava/lang/String;)Z
    //   91: ifne +16 -> 107
    //   94: new 64	com/tencent/mm/vfs/VFSFile
    //   97: dup
    //   98: aload 10
    //   100: invokespecial 67	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 70	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   106: pop
    //   107: new 72	com/tencent/mm/vfs/VFSFileOutputStream
    //   110: dup
    //   111: new 64	com/tencent/mm/vfs/VFSFile
    //   114: dup
    //   115: new 74	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   122: aload 10
    //   124: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 6
    //   129: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 67	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   138: invokespecial 86	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   141: astore 5
    //   143: aload 7
    //   145: astore_3
    //   146: aload 8
    //   148: astore_1
    //   149: aload 11
    //   151: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   154: aload 12
    //   156: ldc 88
    //   158: invokevirtual 92	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   161: astore 9
    //   163: aload 9
    //   165: ifnull +149 -> 314
    //   168: aload 7
    //   170: astore_3
    //   171: aload 8
    //   173: astore_1
    //   174: aload 9
    //   176: invokevirtual 98	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   179: astore 4
    //   181: aload 4
    //   183: astore_3
    //   184: aload 4
    //   186: astore_1
    //   187: sipush 1024
    //   190: newarray byte
    //   192: astore 7
    //   194: aload 4
    //   196: astore_3
    //   197: aload 4
    //   199: astore_1
    //   200: aload 4
    //   202: aload 7
    //   204: invokevirtual 104	java/io/InputStream:read	([B)I
    //   207: istore_2
    //   208: iload_2
    //   209: iconst_m1
    //   210: if_icmpeq +93 -> 303
    //   213: aload 4
    //   215: astore_3
    //   216: aload 4
    //   218: astore_1
    //   219: aload 5
    //   221: aload 7
    //   223: iconst_0
    //   224: iload_2
    //   225: invokevirtual 108	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   228: goto -34 -> 194
    //   231: astore 4
    //   233: aload 5
    //   235: astore_1
    //   236: aload 4
    //   238: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 112	java/io/InputStream:close	()V
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 113	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   257: new 74	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   264: ldc 115
    //   266: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 10
    //   271: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 6
    //   276: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   285: areturn
    //   286: aload_1
    //   287: ifnull +9 -> 296
    //   290: aload_1
    //   291: invokeinterface 57 1 0
    //   296: ldc 121
    //   298: astore 6
    //   300: goto -214 -> 86
    //   303: aload 4
    //   305: astore_3
    //   306: aload 4
    //   308: astore_1
    //   309: aload 5
    //   311: invokevirtual 124	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   314: aload 4
    //   316: ifnull +8 -> 324
    //   319: aload 4
    //   321: invokevirtual 112	java/io/InputStream:close	()V
    //   324: aload 5
    //   326: ifnull +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 113	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   334: new 74	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   341: ldc 115
    //   343: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 10
    //   348: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 6
    //   353: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   362: areturn
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   368: goto -44 -> 324
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   376: goto -42 -> 334
    //   379: astore_3
    //   380: aload_3
    //   381: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   384: goto -135 -> 249
    //   387: astore_1
    //   388: aload_1
    //   389: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   392: goto -135 -> 257
    //   395: astore 4
    //   397: aconst_null
    //   398: astore 5
    //   400: aload 9
    //   402: astore_1
    //   403: aload_1
    //   404: ifnull +7 -> 411
    //   407: aload_1
    //   408: invokevirtual 112	java/io/InputStream:close	()V
    //   411: aload 5
    //   413: ifnull +8 -> 421
    //   416: aload 5
    //   418: invokevirtual 113	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   421: new 74	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   428: ldc 115
    //   430: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 10
    //   435: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 6
    //   440: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   449: pop
    //   450: aload 4
    //   452: athrow
    //   453: astore_1
    //   454: aload_1
    //   455: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   458: goto -47 -> 411
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   466: goto -45 -> 421
    //   469: astore 4
    //   471: goto -68 -> 403
    //   474: astore 4
    //   476: aload_1
    //   477: astore 5
    //   479: aload_3
    //   480: astore_1
    //   481: goto -78 -> 403
    //   484: astore 4
    //   486: aconst_null
    //   487: astore_1
    //   488: goto -252 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	cf
    //   0	491	1	paramVarArgs	Object[]
    //   207	18	2	i	int
    //   1	305	3	localObject1	Object
    //   379	101	3	localIOException	java.io.IOException
    //   3	214	4	localFileInputStream	java.io.FileInputStream
    //   231	89	4	localException1	java.lang.Exception
    //   395	56	4	localObject2	Object
    //   469	1	4	localObject3	Object
    //   474	1	4	localObject4	Object
    //   484	1	4	localException2	java.lang.Exception
    //   141	337	5	localObject5	Object
    //   78	361	6	str1	java.lang.String
    //   12	210	7	arrayOfByte	byte[]
    //   9	163	8	localObject6	Object
    //   6	395	9	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   33	401	10	str2	java.lang.String
    //   20	130	11	localContext	android.content.Context
    //   28	127	12	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   149	163	231	java/lang/Exception
    //   174	181	231	java/lang/Exception
    //   187	194	231	java/lang/Exception
    //   200	208	231	java/lang/Exception
    //   219	228	231	java/lang/Exception
    //   309	314	231	java/lang/Exception
    //   319	324	363	java/io/IOException
    //   329	334	371	java/io/IOException
    //   245	249	379	java/io/IOException
    //   253	257	387	java/io/IOException
    //   86	107	395	finally
    //   107	143	395	finally
    //   407	411	453	java/io/IOException
    //   416	421	461	java/io/IOException
    //   149	163	469	finally
    //   174	181	469	finally
    //   187	194	469	finally
    //   200	208	469	finally
    //   219	228	469	finally
    //   309	314	469	finally
    //   236	241	474	finally
    //   86	107	484	java/lang/Exception
    //   107	143	484	java/lang/Exception
  }
  
  @TargetApi(17)
  protected void a(Uri paramUri)
  {
    paramUri = paramUri.getPath();
    if (!TextUtils.isEmpty(paramUri))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramUri);
      this.a.a(localArrayList, 0);
    }
    do
    {
      do
      {
        return;
      } while (this.a.isFinishing());
      if (Build.VERSION.SDK_INT < 17) {
        break;
      }
    } while (this.a.isDestroyed());
    LiteActivity.a(this.a);
    return;
    LiteActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */