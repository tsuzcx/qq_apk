package com.dataline.activities;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;

class LiteActivity$ShareTask
  extends AsyncTask<Object, Void, Uri>
{
  LiteActivity$ShareTask(LiteActivity paramLiteActivity) {}
  
  /* Error */
  protected Uri a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 22	android/content/Context
    //   6: astore 11
    //   8: aload_1
    //   9: iconst_1
    //   10: aaload
    //   11: checkcast 24	android/net/Uri
    //   14: astore 12
    //   16: getstatic 30	com/tencent/mobileqq/app/AppConstants:SDCARD_SHARE_VCARD	Ljava/lang/String;
    //   19: astore 10
    //   21: aload 11
    //   23: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: aload 12
    //   28: iconst_1
    //   29: anewarray 36	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc 38
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 44	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +30 -> 75
    //   48: aload_1
    //   49: invokeinterface 50 1 0
    //   54: ifeq +21 -> 75
    //   57: aload_1
    //   58: iconst_0
    //   59: invokeinterface 54 2 0
    //   64: astore 6
    //   66: aload_1
    //   67: invokeinterface 57 1 0
    //   72: goto +17 -> 89
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: invokeinterface 57 1 0
    //   85: ldc 59
    //   87: astore 6
    //   89: aconst_null
    //   90: astore 8
    //   92: aconst_null
    //   93: astore_1
    //   94: aconst_null
    //   95: astore 9
    //   97: aconst_null
    //   98: astore_3
    //   99: aconst_null
    //   100: astore 5
    //   102: aload 10
    //   104: invokestatic 65	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   107: ifne +16 -> 123
    //   110: new 67	com/tencent/mm/vfs/VFSFile
    //   113: dup
    //   114: aload 10
    //   116: invokespecial 70	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 73	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   122: pop
    //   123: new 75	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   130: astore 4
    //   132: aload 4
    //   134: aload 10
    //   136: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload 6
    //   144: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 82	com/tencent/mm/vfs/VFSFileOutputStream
    //   151: dup
    //   152: new 67	com/tencent/mm/vfs/VFSFile
    //   155: dup
    //   156: aload 4
    //   158: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 70	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   164: invokespecial 89	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   167: astore 7
    //   169: aload 8
    //   171: astore 4
    //   173: aload 9
    //   175: astore_1
    //   176: aload 7
    //   178: astore_3
    //   179: aload 11
    //   181: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   184: aload 12
    //   186: ldc 91
    //   188: invokevirtual 95	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   191: astore 11
    //   193: aload 11
    //   195: ifnull +97 -> 292
    //   198: aload 8
    //   200: astore 4
    //   202: aload 9
    //   204: astore_1
    //   205: aload 7
    //   207: astore_3
    //   208: aload 11
    //   210: invokevirtual 101	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   213: astore 5
    //   215: aload 5
    //   217: astore 4
    //   219: aload 5
    //   221: astore_1
    //   222: aload 7
    //   224: astore_3
    //   225: sipush 1024
    //   228: newarray byte
    //   230: astore 8
    //   232: aload 5
    //   234: astore 4
    //   236: aload 5
    //   238: astore_1
    //   239: aload 7
    //   241: astore_3
    //   242: aload 5
    //   244: aload 8
    //   246: invokevirtual 107	java/io/InputStream:read	([B)I
    //   249: istore_2
    //   250: iload_2
    //   251: iconst_m1
    //   252: if_icmpeq +25 -> 277
    //   255: aload 5
    //   257: astore 4
    //   259: aload 5
    //   261: astore_1
    //   262: aload 7
    //   264: astore_3
    //   265: aload 7
    //   267: aload 8
    //   269: iconst_0
    //   270: iload_2
    //   271: invokevirtual 111	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   274: goto -42 -> 232
    //   277: aload 5
    //   279: astore 4
    //   281: aload 5
    //   283: astore_1
    //   284: aload 7
    //   286: astore_3
    //   287: aload 7
    //   289: invokevirtual 114	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   292: aload 5
    //   294: ifnull +16 -> 310
    //   297: aload 5
    //   299: invokevirtual 115	java/io/InputStream:close	()V
    //   302: goto +8 -> 310
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   310: aload 7
    //   312: invokevirtual 119	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   315: goto +8 -> 323
    //   318: astore_1
    //   319: aload_1
    //   320: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   323: new 75	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   330: astore_1
    //   331: goto +94 -> 425
    //   334: astore_1
    //   335: aload 4
    //   337: astore 5
    //   339: aload 7
    //   341: astore 4
    //   343: aload_1
    //   344: astore 7
    //   346: goto +24 -> 370
    //   349: astore 4
    //   351: aconst_null
    //   352: astore 5
    //   354: aload_3
    //   355: astore_1
    //   356: aload 5
    //   358: astore_3
    //   359: goto +97 -> 456
    //   362: astore 7
    //   364: aconst_null
    //   365: astore 4
    //   367: aload_1
    //   368: astore 5
    //   370: aload 5
    //   372: astore_1
    //   373: aload 4
    //   375: astore_3
    //   376: aload 7
    //   378: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   381: aload 5
    //   383: ifnull +16 -> 399
    //   386: aload 5
    //   388: invokevirtual 115	java/io/InputStream:close	()V
    //   391: goto +8 -> 399
    //   394: astore_1
    //   395: aload_1
    //   396: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   399: aload 4
    //   401: ifnull +16 -> 417
    //   404: aload 4
    //   406: invokevirtual 119	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   409: goto +8 -> 417
    //   412: astore_1
    //   413: aload_1
    //   414: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   417: new 75	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   424: astore_1
    //   425: aload_1
    //   426: ldc 122
    //   428: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: aload 10
    //   435: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_1
    //   440: aload 6
    //   442: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_1
    //   447: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   453: areturn
    //   454: astore 4
    //   456: aload_1
    //   457: ifnull +15 -> 472
    //   460: aload_1
    //   461: invokevirtual 115	java/io/InputStream:close	()V
    //   464: goto +8 -> 472
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   472: aload_3
    //   473: ifnull +15 -> 488
    //   476: aload_3
    //   477: invokevirtual 119	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   480: goto +8 -> 488
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   488: new 75	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   495: astore_1
    //   496: aload_1
    //   497: ldc 122
    //   499: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_1
    //   504: aload 10
    //   506: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_1
    //   511: aload 6
    //   513: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_1
    //   518: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 126	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   524: pop
    //   525: goto +6 -> 531
    //   528: aload 4
    //   530: athrow
    //   531: goto -3 -> 528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	ShareTask
    //   0	534	1	paramVarArgs	Object[]
    //   249	22	2	i	int
    //   98	379	3	localObject1	Object
    //   130	212	4	localObject2	Object
    //   349	1	4	localObject3	Object
    //   365	40	4	localObject4	Object
    //   454	75	4	localObject5	Object
    //   100	287	5	localObject6	Object
    //   64	448	6	str1	java.lang.String
    //   167	178	7	localObject7	Object
    //   362	15	7	localException	java.lang.Exception
    //   90	178	8	arrayOfByte	byte[]
    //   95	108	9	localObject8	Object
    //   19	486	10	str2	java.lang.String
    //   6	203	11	localObject9	Object
    //   14	171	12	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   297	302	305	java/io/IOException
    //   310	315	318	java/io/IOException
    //   179	193	334	java/lang/Exception
    //   208	215	334	java/lang/Exception
    //   225	232	334	java/lang/Exception
    //   242	250	334	java/lang/Exception
    //   265	274	334	java/lang/Exception
    //   287	292	334	java/lang/Exception
    //   102	123	349	finally
    //   123	169	349	finally
    //   102	123	362	java/lang/Exception
    //   123	169	362	java/lang/Exception
    //   386	391	394	java/io/IOException
    //   404	409	412	java/io/IOException
    //   179	193	454	finally
    //   208	215	454	finally
    //   225	232	454	finally
    //   242	250	454	finally
    //   265	274	454	finally
    //   287	292	454	finally
    //   376	381	454	finally
    //   460	464	467	java/io/IOException
    //   476	480	483	java/io/IOException
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
      return;
    }
    if (!this.a.isFinishing()) {
      if (Build.VERSION.SDK_INT >= 17)
      {
        if (!this.a.isDestroyed()) {
          LiteActivity.a(this.a);
        }
      }
      else {
        LiteActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.ShareTask
 * JD-Core Version:    0.7.0.1
 */