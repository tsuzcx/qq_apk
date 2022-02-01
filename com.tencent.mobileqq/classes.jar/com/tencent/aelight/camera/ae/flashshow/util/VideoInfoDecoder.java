package com.tencent.aelight.camera.ae.flashshow.util;

import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class VideoInfoDecoder
{
  public String a;
  
  public VideoInfoDecoder(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    paramLocalMediaInfo.mDuration = Long.parseLong(paramMediaMetadataRetriever.extractMetadata(9));
  }
  
  private void b(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramLocalMediaInfo.rotation = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(24));
    }
  }
  
  private void c(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    paramLocalMediaInfo.mediaWidth = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
    paramLocalMediaInfo.mediaHeight = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
  }
  
  private void d(LocalMediaInfo paramLocalMediaInfo, MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    paramMediaMetadataRetriever = paramMediaMetadataRetriever.extractMetadata(23);
    if (paramMediaMetadataRetriever != null) {}
    for (;;)
    {
      int k;
      try
      {
        ArrayList localArrayList = new ArrayList(3);
        StringBuilder localStringBuilder1 = new StringBuilder();
        char[] arrayOfChar = paramMediaMetadataRetriever.toCharArray();
        k = 0;
        int i = 0;
        if (k < arrayOfChar.length)
        {
          char c = arrayOfChar[k];
          if (i < 2)
          {
            if ((c != '+') && (c != '-') && (c != '\n') && (c != 0))
            {
              if ((!Character.isDigit(c)) && (c != '.'))
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("Can not under stand the location string: ");
                localStringBuilder2.append(paramMediaMetadataRetriever);
                localStringBuilder2.append(" !");
                QLog.e("QQAlbum", 2, localStringBuilder2.toString());
                break label301;
              }
              localStringBuilder1.append(c);
              break label301;
            }
            int j = i;
            if (localStringBuilder1.length() > 0)
            {
              localArrayList.add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder1.toString()) * 1000000.0D)));
              localStringBuilder1.setLength(0);
              j = i + 1;
            }
            localStringBuilder1.append(c);
            i = j;
            break label301;
          }
        }
        if (localStringBuilder1.length() > 0) {
          localArrayList.add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder1.toString()) * 1000000.0D)));
        }
        if (localArrayList.size() >= 2)
        {
          paramLocalMediaInfo.latitude = ((Integer)localArrayList.get(0)).intValue();
          paramLocalMediaInfo.longitude = ((Integer)localArrayList.get(1)).intValue();
          return;
        }
      }
      catch (NumberFormatException paramLocalMediaInfo)
      {
        QLog.e(this.a, 2, "getLocation error. ", paramLocalMediaInfo);
      }
      return;
      label301:
      k += 1;
    }
  }
  
  /* Error */
  public boolean a(@androidx.annotation.NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 155	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   10: astore_2
    //   11: new 66	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 157
    //   22: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: aload 5
    //   29: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 162	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 5
    //   43: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +5 -> 51
    //   49: iconst_0
    //   50: ireturn
    //   51: aconst_null
    //   52: astore 4
    //   54: aconst_null
    //   55: astore_2
    //   56: new 17	android/media/MediaMetadataRetriever
    //   59: dup
    //   60: invokespecial 169	android/media/MediaMetadataRetriever:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: aload 5
    //   67: invokevirtual 172	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_1
    //   72: aload_3
    //   73: invokespecial 174	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Landroid/media/MediaMetadataRetriever;)V
    //   76: aload_0
    //   77: aload_1
    //   78: aload_3
    //   79: invokespecial 176	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:b	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Landroid/media/MediaMetadataRetriever;)V
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: invokespecial 178	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:c	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Landroid/media/MediaMetadataRetriever;)V
    //   88: aload_0
    //   89: aload_1
    //   90: aload_3
    //   91: invokespecial 180	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:d	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Landroid/media/MediaMetadataRetriever;)V
    //   94: aload_0
    //   95: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   98: astore_2
    //   99: new 66	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   106: astore 4
    //   108: aload 4
    //   110: ldc 182
    //   112: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload_1
    //   119: getfield 33	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   122: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: ldc 187
    //   130: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 4
    //   136: aload_1
    //   137: getfield 49	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   140: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 4
    //   146: ldc 192
    //   148: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 4
    //   154: aload_1
    //   155: getfield 53	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   158: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: ldc 194
    //   166: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 4
    //   172: aload_1
    //   173: getfield 56	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   176: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 4
    //   182: ldc 196
    //   184: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: aload_1
    //   191: getfield 141	com/tencent/mobileqq/activity/photo/LocalMediaInfo:longitude	I
    //   194: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc 198
    //   202: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 4
    //   208: aload_1
    //   209: getfield 138	com/tencent/mobileqq/activity/photo/LocalMediaInfo:latitude	I
    //   212: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: ldc 200
    //   220: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: aload 4
    //   227: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 162	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_3
    //   234: invokevirtual 203	android/media/MediaMetadataRetriever:release	()V
    //   237: iconst_1
    //   238: ireturn
    //   239: astore_1
    //   240: aload_0
    //   241: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   244: aload_1
    //   245: invokestatic 206	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: iconst_1
    //   249: ireturn
    //   250: astore_1
    //   251: goto +104 -> 355
    //   254: astore_2
    //   255: aload_3
    //   256: astore_1
    //   257: aload_2
    //   258: astore_3
    //   259: goto +13 -> 272
    //   262: astore_1
    //   263: aload_2
    //   264: astore_3
    //   265: goto +90 -> 355
    //   268: astore_3
    //   269: aload 4
    //   271: astore_1
    //   272: aload_1
    //   273: astore_2
    //   274: aload_0
    //   275: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   278: astore 4
    //   280: aload_1
    //   281: astore_2
    //   282: new 66	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   289: astore 6
    //   291: aload_1
    //   292: astore_2
    //   293: aload 6
    //   295: ldc 208
    //   297: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: astore_2
    //   303: aload 6
    //   305: aload 5
    //   307: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: astore_2
    //   313: aload 4
    //   315: aload 6
    //   317: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 210	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_1
    //   324: astore_2
    //   325: aload_0
    //   326: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   329: aload_3
    //   330: invokestatic 206	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload_1
    //   334: ifnull +19 -> 353
    //   337: aload_1
    //   338: invokevirtual 203	android/media/MediaMetadataRetriever:release	()V
    //   341: goto +12 -> 353
    //   344: astore_1
    //   345: aload_0
    //   346: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   349: aload_1
    //   350: invokestatic 206	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_3
    //   356: ifnull +19 -> 375
    //   359: aload_3
    //   360: invokevirtual 203	android/media/MediaMetadataRetriever:release	()V
    //   363: goto +12 -> 375
    //   366: astore_2
    //   367: aload_0
    //   368: getfield 13	com/tencent/aelight/camera/ae/flashshow/util/VideoInfoDecoder:a	Ljava/lang/String;
    //   371: aload_2
    //   372: invokestatic 206	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_1
    //   376: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	VideoInfoDecoder
    //   0	377	1	paramLocalMediaInfo	LocalMediaInfo
    //   10	215	2	str1	String
    //   254	10	2	localThrowable1	java.lang.Throwable
    //   273	52	2	localLocalMediaInfo	LocalMediaInfo
    //   366	6	2	localException	java.lang.Exception
    //   18	247	3	localObject1	Object
    //   268	92	3	localThrowable2	java.lang.Throwable
    //   52	262	4	localObject2	Object
    //   4	302	5	str2	String
    //   289	27	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   233	237	239	java/lang/Exception
    //   64	233	250	finally
    //   64	233	254	java/lang/Throwable
    //   56	64	262	finally
    //   274	280	262	finally
    //   282	291	262	finally
    //   293	301	262	finally
    //   303	311	262	finally
    //   313	323	262	finally
    //   325	333	262	finally
    //   56	64	268	java/lang/Throwable
    //   337	341	344	java/lang/Exception
    //   359	363	366	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.util.VideoInfoDecoder
 * JD-Core Version:    0.7.0.1
 */