package com.tencent.biz.qqcircle.localphoto.scan;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class LocalPhotoCursor
{
  public static final String a = "LocalPhotoCursor";
  private final Context b;
  private int c;
  private int d;
  private final long e;
  private final long f;
  private final int g;
  private final List<String> h;
  
  private LocalPhotoCursor(@NonNull LocalPhotoCursor.Builder paramBuilder)
  {
    this.b = LocalPhotoCursor.Builder.a(paramBuilder);
    this.c = LocalPhotoCursor.Builder.b(paramBuilder);
    this.d = LocalPhotoCursor.Builder.c(paramBuilder);
    this.e = LocalPhotoCursor.Builder.d(paramBuilder);
    this.f = LocalPhotoCursor.Builder.e(paramBuilder);
    this.g = LocalPhotoCursor.Builder.f(paramBuilder);
    this.h = LocalPhotoCursor.Builder.g(paramBuilder);
    if (this.b != null)
    {
      if (this.c <= 0) {
        this.c = 400;
      }
      if (this.d < this.c) {
        this.d = 20480;
      }
      return;
    }
    throw new RuntimeException("context cannot be null");
  }
  
  private Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    long l = System.currentTimeMillis();
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "_id";
    arrayOfString[1] = "_data";
    arrayOfString[2] = "date_added";
    arrayOfString[3] = "date_modified";
    arrayOfString[4] = "mime_type";
    arrayOfString[5] = "latitude";
    arrayOfString[6] = "longitude";
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 26)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("android:query-arg-sql-selection", paramString);
          ((Bundle)localObject1).putStringArray("android:query-arg-sql-selection-args", paramArrayOfString);
          ((Bundle)localObject1).putString("android:query-arg-sql-sort-order", "date_modified DESC, date_added DESC ");
          if (paramInt != 0) {
            ((Bundle)localObject1).putInt("android:query-arg-limit", paramInt);
          }
          paramString = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString, (Bundle)localObject1, null);
        }
        else
        {
          if (paramInt == 0) {
            break label256;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("date_modified DESC, date_added DESC ");
          ((StringBuilder)localObject1).append("limit ");
          ((StringBuilder)localObject1).append(paramInt);
          localObject1 = ((StringBuilder)localObject1).toString();
          paramString = this.b.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString, paramString, paramArrayOfString, (String)localObject1);
        }
      }
      catch (Exception paramString)
      {
        QLog.e(a, 1, "[getPhotoIndexInfoCursor] failed", paramString);
        paramString = localObject2;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d(a, 4, String.format(Locale.CHINESE, "[getPhotoIndexInfoCursor] cost=%dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return paramString;
      label256:
      Object localObject1 = "date_modified DESC, date_added DESC ";
    }
  }
  
  /* Error */
  @Nullable
  private LinkedList<LocalPhotoInfo> a(Cursor paramCursor, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +313 -> 314
    //   4: aload_1
    //   5: invokeinterface 207 1 0
    //   10: ifne +6 -> 16
    //   13: goto +301 -> 314
    //   16: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   19: lstore 11
    //   21: new 209	java/util/LinkedList
    //   24: dup
    //   25: invokespecial 210	java/util/LinkedList:<init>	()V
    //   28: astore 13
    //   30: aload_1
    //   31: ldc 86
    //   33: invokeinterface 214 2 0
    //   38: istore_3
    //   39: aload_1
    //   40: ldc 88
    //   42: invokeinterface 214 2 0
    //   47: istore 5
    //   49: aload_1
    //   50: ldc 90
    //   52: invokeinterface 214 2 0
    //   57: istore 6
    //   59: aload_1
    //   60: ldc 92
    //   62: invokeinterface 214 2 0
    //   67: istore 7
    //   69: aload_1
    //   70: ldc 94
    //   72: invokeinterface 214 2 0
    //   77: istore 8
    //   79: aload_1
    //   80: ldc 96
    //   82: invokeinterface 214 2 0
    //   87: istore 9
    //   89: aload_1
    //   90: ldc 98
    //   92: invokeinterface 214 2 0
    //   97: istore 10
    //   99: iload_2
    //   100: ifne +216 -> 316
    //   103: ldc 215
    //   105: istore_2
    //   106: goto +210 -> 316
    //   109: aload_1
    //   110: invokeinterface 218 1 0
    //   115: ifeq +125 -> 240
    //   118: iload 4
    //   120: iload_2
    //   121: if_icmpge +119 -> 240
    //   124: iload 4
    //   126: iconst_1
    //   127: iadd
    //   128: istore 4
    //   130: new 220	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo
    //   133: dup
    //   134: invokespecial 221	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:<init>	()V
    //   137: astore 14
    //   139: aload 14
    //   141: aload_1
    //   142: iload_3
    //   143: invokeinterface 225 2 0
    //   148: putfield 227	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:a	I
    //   151: aload 14
    //   153: aload_1
    //   154: iload 5
    //   156: invokeinterface 231 2 0
    //   161: putfield 233	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:b	Ljava/lang/String;
    //   164: aload 14
    //   166: aload_1
    //   167: iload 6
    //   169: invokeinterface 237 2 0
    //   174: putfield 239	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:d	J
    //   177: aload 14
    //   179: aload_1
    //   180: iload 7
    //   182: invokeinterface 237 2 0
    //   187: putfield 240	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:e	J
    //   190: aload 14
    //   192: aload_1
    //   193: iload 8
    //   195: invokeinterface 231 2 0
    //   200: putfield 242	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:c	Ljava/lang/String;
    //   203: aload 14
    //   205: aload_1
    //   206: iload 9
    //   208: invokeinterface 246 2 0
    //   213: putfield 250	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:i	F
    //   216: aload 14
    //   218: aload_1
    //   219: iload 10
    //   221: invokeinterface 246 2 0
    //   226: putfield 253	com/tencent/biz/qqcircle/localphoto/scan/data/LocalPhotoInfo:j	F
    //   229: aload 13
    //   231: aload 14
    //   233: invokevirtual 257	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   236: pop
    //   237: goto -128 -> 109
    //   240: getstatic 167	com/tencent/biz/qqcircle/localphoto/scan/LocalPhotoCursor:a	Ljava/lang/String;
    //   243: iconst_1
    //   244: getstatic 184	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   247: ldc_w 259
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   259: lload 11
    //   261: lsub
    //   262: invokestatic 192	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   265: aastore
    //   266: invokestatic 196	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   269: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: aload_1
    //   274: invokespecial 264	com/tencent/biz/qqcircle/localphoto/scan/LocalPhotoCursor:a	(Landroid/database/Cursor;)V
    //   277: aload 13
    //   279: areturn
    //   280: astore 13
    //   282: goto +24 -> 306
    //   285: astore 13
    //   287: getstatic 167	com/tencent/biz/qqcircle/localphoto/scan/LocalPhotoCursor:a	Ljava/lang/String;
    //   290: iconst_1
    //   291: ldc_w 266
    //   294: aload 13
    //   296: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: aload_0
    //   300: aload_1
    //   301: invokespecial 264	com/tencent/biz/qqcircle/localphoto/scan/LocalPhotoCursor:a	(Landroid/database/Cursor;)V
    //   304: aconst_null
    //   305: areturn
    //   306: aload_0
    //   307: aload_1
    //   308: invokespecial 264	com/tencent/biz/qqcircle/localphoto/scan/LocalPhotoCursor:a	(Landroid/database/Cursor;)V
    //   311: aload 13
    //   313: athrow
    //   314: aconst_null
    //   315: areturn
    //   316: iconst_0
    //   317: istore 4
    //   319: goto -210 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	LocalPhotoCursor
    //   0	322	1	paramCursor	Cursor
    //   0	322	2	paramInt	int
    //   38	105	3	i	int
    //   118	200	4	j	int
    //   47	108	5	k	int
    //   57	111	6	m	int
    //   67	114	7	n	int
    //   77	117	8	i1	int
    //   87	120	9	i2	int
    //   97	123	10	i3	int
    //   19	241	11	l	long
    //   28	250	13	localLinkedList	LinkedList
    //   280	1	13	localObject	Object
    //   285	27	13	localException	Exception
    //   137	95	14	localLocalPhotoInfo	LocalPhotoInfo
    // Exception table:
    //   from	to	target	type
    //   21	99	280	finally
    //   109	118	280	finally
    //   130	237	280	finally
    //   240	272	280	finally
    //   287	299	280	finally
    //   21	99	285	java/lang/Exception
    //   109	118	285	java/lang/Exception
    //   130	237	285	java/lang/Exception
    //   240	272	285	java/lang/Exception
  }
  
  private void a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed())) {
      paramCursor.close();
    }
  }
  
  @Nullable
  public LinkedList<LocalPhotoInfo> a()
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("_size > ?");
    ((StringBuilder)localObject2).append(" AND ");
    ((StringBuilder)localObject2).append("_size< ?");
    int i;
    if ((this.e > 0L) && (this.f > 0L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ((StringBuilder)localObject2).append(" AND ");
      ((StringBuilder)localObject2).append("date_modified > ?");
      ((StringBuilder)localObject2).append(" AND ");
      ((StringBuilder)localObject2).append("date_modified< ?");
    }
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        ((StringBuilder)localObject2).append(" AND ");
        ((StringBuilder)localObject2).append("bucket_display_name != '");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("'");
      }
    }
    if (i != 0)
    {
      localObject1 = new String[4];
      localObject1[0] = String.valueOf(this.c * 1024);
      localObject1[1] = String.valueOf(this.d * 1024);
      localObject1[2] = String.valueOf(this.e);
      localObject1[3] = String.valueOf(this.f);
    }
    else
    {
      localObject1 = new String[2];
      localObject1[0] = String.valueOf(this.c * 1024);
      localObject1[1] = String.valueOf(this.d * 1024);
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    QLog.i(a, 1, String.format(Locale.CHINESE, "[getPhotoIndexInfo] selection sql: %s, selectionArgs=%s", new Object[] { localObject2, Arrays.asList((Object[])localObject1) }));
    return a(a((String)localObject2, (String[])localObject1, this.g), this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.LocalPhotoCursor
 * JD-Core Version:    0.7.0.1
 */