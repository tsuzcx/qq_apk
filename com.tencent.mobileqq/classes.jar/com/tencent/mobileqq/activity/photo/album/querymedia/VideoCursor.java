package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Arrays;

public class VideoCursor
  extends ICursor
{
  private static final int INDEX_DURATION = SUB_START_INDEX;
  private static final String[] VIDEO_COLUMS = { "duration" };
  
  public VideoCursor(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private boolean checkVideoInfoData(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo.mDuration == 0L) || (paramLocalMediaInfo.mediaHeight <= 0) || (paramLocalMediaInfo.mediaWidth <= 0);
  }
  
  Cursor createCursor(Context paramContext)
  {
    Uri localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    return paramContext.getContentResolver().query(localUri, (String[])this.mColums.toArray(new String[0]), this.mSelector, null, "date_modified DESC, date_added DESC");
  }
  
  /* Error */
  public void fixVideoInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +119 -> 120
    //   4: aload_1
    //   5: getfield 84	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMediaType	I
    //   8: iconst_1
    //   9: if_icmpne +111 -> 120
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 86	com/tencent/mobileqq/activity/photo/album/querymedia/VideoCursor:checkVideoInfoData	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   17: ifeq +103 -> 120
    //   20: new 88	android/media/MediaMetadataRetriever
    //   23: dup
    //   24: invokespecial 90	android/media/MediaMetadataRetriever:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: aload_3
    //   31: aload_1
    //   32: getfield 93	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   35: invokevirtual 97	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_1
    //   41: getfield 34	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   44: lconst_0
    //   45: lcmp
    //   46: ifne +18 -> 64
    //   49: aload_3
    //   50: astore_2
    //   51: aload_1
    //   52: aload_3
    //   53: bipush 9
    //   55: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   58: invokestatic 107	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   61: putfield 34	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   64: aload_3
    //   65: astore_2
    //   66: aload_1
    //   67: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   70: ifgt +18 -> 88
    //   73: aload_3
    //   74: astore_2
    //   75: aload_1
    //   76: aload_3
    //   77: bipush 19
    //   79: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   82: invokestatic 113	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: putfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   88: aload_3
    //   89: astore_2
    //   90: aload_1
    //   91: getfield 40	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   94: ifgt +18 -> 112
    //   97: aload_3
    //   98: astore_2
    //   99: aload_1
    //   100: aload_3
    //   101: bipush 18
    //   103: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   106: invokestatic 113	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: putfield 40	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   112: aload_3
    //   113: ifnull +7 -> 120
    //   116: aload_3
    //   117: invokevirtual 116	android/media/MediaMetadataRetriever:release	()V
    //   120: return
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: astore_2
    //   127: aload 4
    //   129: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   132: aload_3
    //   133: astore_2
    //   134: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +33 -> 170
    //   140: aload_3
    //   141: astore_2
    //   142: ldc 127
    //   144: iconst_2
    //   145: new 129	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   152: ldc 132
    //   154: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: getfield 93	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   161: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 144	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_3
    //   171: ifnull -51 -> 120
    //   174: aload_3
    //   175: invokevirtual 116	android/media/MediaMetadataRetriever:release	()V
    //   178: return
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_2
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 116	android/media/MediaMetadataRetriever:release	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: goto -11 -> 182
    //   196: astore 4
    //   198: goto -73 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	VideoCursor
    //   0	201	1	paramLocalMediaInfo	LocalMediaInfo
    //   29	158	2	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   27	148	3	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   121	7	4	localException1	java.lang.Exception
    //   196	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   20	28	121	java/lang/Exception
    //   20	28	179	finally
    //   30	38	192	finally
    //   40	49	192	finally
    //   51	64	192	finally
    //   66	73	192	finally
    //   75	88	192	finally
    //   90	97	192	finally
    //   99	112	192	finally
    //   127	132	192	finally
    //   134	140	192	finally
    //   142	170	192	finally
    //   30	38	196	java/lang/Exception
    //   40	49	196	java/lang/Exception
    //   51	64	196	java/lang/Exception
    //   66	73	196	java/lang/Exception
    //   75	88	196	java/lang/Exception
    //   90	97	196	java/lang/Exception
    //   99	112	196	java/lang/Exception
  }
  
  protected void init()
  {
    super.init();
    this.mColums.addAll(Arrays.asList(VIDEO_COLUMS));
  }
  
  protected LocalMediaInfo makeMediaInfo()
  {
    LocalMediaInfo localLocalMediaInfo = super.makeMediaInfo();
    localLocalMediaInfo.mMediaType = 1;
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
      localLocalMediaInfo.mDuration = this.mCursor.getInt(INDEX_DURATION);
    }
    fixVideoInfo(localLocalMediaInfo);
    return localLocalMediaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.VideoCursor
 * JD-Core Version:    0.7.0.1
 */