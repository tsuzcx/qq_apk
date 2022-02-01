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
    //   1: ifnull +220 -> 221
    //   4: aload_1
    //   5: getfield 84	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMediaType	I
    //   8: iconst_1
    //   9: if_icmpne +212 -> 221
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 86	com/tencent/mobileqq/activity/photo/album/querymedia/VideoCursor:checkVideoInfoData	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   17: ifeq +204 -> 221
    //   20: new 88	android/media/MediaMetadataRetriever
    //   23: dup
    //   24: invokespecial 90	android/media/MediaMetadataRetriever:<init>	()V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_3
    //   30: aload_2
    //   31: aload_1
    //   32: getfield 93	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   35: invokevirtual 97	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: astore_3
    //   40: aload_1
    //   41: getfield 34	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   44: lconst_0
    //   45: lcmp
    //   46: ifne +18 -> 64
    //   49: aload_2
    //   50: astore_3
    //   51: aload_1
    //   52: aload_2
    //   53: bipush 9
    //   55: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   58: invokestatic 107	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   61: putfield 34	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   64: aload_2
    //   65: astore_3
    //   66: aload_1
    //   67: getfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   70: ifgt +18 -> 88
    //   73: aload_2
    //   74: astore_3
    //   75: aload_1
    //   76: aload_2
    //   77: bipush 19
    //   79: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   82: invokestatic 113	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: putfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   88: aload_2
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: aload_1
    //   94: getfield 40	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   97: ifgt +107 -> 204
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: aload_2
    //   104: bipush 18
    //   106: invokevirtual 101	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: invokestatic 113	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: putfield 40	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   115: aload_2
    //   116: astore 4
    //   118: goto +86 -> 204
    //   121: astore 4
    //   123: goto +13 -> 136
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_3
    //   129: goto +82 -> 211
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_3
    //   138: aload 4
    //   140: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   143: aload_2
    //   144: astore_3
    //   145: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +49 -> 197
    //   151: aload_2
    //   152: astore_3
    //   153: new 124	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload_2
    //   163: astore_3
    //   164: aload 4
    //   166: ldc 127
    //   168: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: astore_3
    //   174: aload 4
    //   176: aload_1
    //   177: getfield 93	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   180: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: astore_3
    //   186: ldc 133
    //   188: iconst_2
    //   189: aload 4
    //   191: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_2
    //   198: ifnull +23 -> 221
    //   201: aload_2
    //   202: astore 4
    //   204: aload 4
    //   206: invokevirtual 144	android/media/MediaMetadataRetriever:release	()V
    //   209: return
    //   210: astore_1
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 144	android/media/MediaMetadataRetriever:release	()V
    //   219: aload_1
    //   220: athrow
    //   221: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	VideoCursor
    //   0	222	1	paramLocalMediaInfo	LocalMediaInfo
    //   27	175	2	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   29	187	3	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   89	28	4	localMediaMetadataRetriever3	android.media.MediaMetadataRetriever
    //   121	1	4	localException1	java.lang.Exception
    //   132	7	4	localException2	java.lang.Exception
    //   160	45	4	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   30	38	121	java/lang/Exception
    //   40	49	121	java/lang/Exception
    //   51	64	121	java/lang/Exception
    //   66	73	121	java/lang/Exception
    //   75	88	121	java/lang/Exception
    //   93	100	121	java/lang/Exception
    //   102	115	121	java/lang/Exception
    //   20	28	126	finally
    //   20	28	132	java/lang/Exception
    //   30	38	210	finally
    //   40	49	210	finally
    //   51	64	210	finally
    //   66	73	210	finally
    //   75	88	210	finally
    //   93	100	210	finally
    //   102	115	210	finally
    //   138	143	210	finally
    //   145	151	210	finally
    //   153	162	210	finally
    //   164	172	210	finally
    //   174	184	210	finally
    //   186	197	210	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.VideoCursor
 * JD-Core Version:    0.7.0.1
 */