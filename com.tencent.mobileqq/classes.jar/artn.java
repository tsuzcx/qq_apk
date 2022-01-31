import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;

public class artn
  implements AudioManager.OnAudioFocusChangeListener
{
  public artn(QQMusicPlayService paramQQMusicPlayService) {}
  
  /* Error */
  public void onAudioFocusChange(int paramInt)
  {
    // Byte code:
    //   0: ldc 22
    //   2: iconst_1
    //   3: new 24	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   10: ldc 27
    //   12: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_1
    //   16: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   29: astore_2
    //   30: aload_2
    //   31: monitorenter
    //   32: iload_1
    //   33: tableswitch	default:+35 -> 68, -3:+210->243, -2:+158->191, -1:+38->71, 0:+35->68, 1:+256->289
    //   69: monitorexit
    //   70: return
    //   71: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   74: ifnull +38 -> 112
    //   77: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   80: invokevirtual 55	android/media/MediaPlayer:isPlaying	()Z
    //   83: ifeq +29 -> 112
    //   86: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   89: invokevirtual 58	android/media/MediaPlayer:stop	()V
    //   92: aload_0
    //   93: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   96: invokestatic 61	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:b	()Ljava/lang/String;
    //   99: iconst_4
    //   100: invokestatic 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;Ljava/lang/String;I)V
    //   103: invokestatic 66	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:b	()Z
    //   106: invokestatic 70	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:c	()I
    //   109: invokestatic 75	artm:b	(ZI)V
    //   112: ldc 22
    //   114: iconst_1
    //   115: ldc 77
    //   117: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   124: iconst_0
    //   125: iconst_0
    //   126: invokestatic 80	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;ZZ)V
    //   129: aload_0
    //   130: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   133: invokestatic 83	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;)Larto;
    //   136: ifnull -68 -> 68
    //   139: aload_0
    //   140: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   143: invokestatic 83	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;)Larto;
    //   146: bipush 11
    //   148: invokevirtual 89	arto:sendEmptyMessage	(I)Z
    //   151: pop
    //   152: goto -84 -> 68
    //   155: astore_3
    //   156: aload_2
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    //   160: astore_2
    //   161: ldc 22
    //   163: iconst_1
    //   164: new 24	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   171: ldc 91
    //   173: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 94	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload_2
    //   187: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: return
    //   191: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   194: ifnull +29 -> 223
    //   197: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   200: invokevirtual 55	android/media/MediaPlayer:isPlaying	()Z
    //   203: ifeq +20 -> 223
    //   206: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   209: invokevirtual 100	android/media/MediaPlayer:pause	()V
    //   212: aload_0
    //   213: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   216: invokestatic 61	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:b	()Ljava/lang/String;
    //   219: iconst_3
    //   220: invokestatic 64	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;Ljava/lang/String;I)V
    //   223: ldc 22
    //   225: iconst_1
    //   226: ldc 102
    //   228: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   235: iconst_0
    //   236: iconst_1
    //   237: invokestatic 80	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;ZZ)V
    //   240: goto -172 -> 68
    //   243: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   246: ifnull +32 -> 278
    //   249: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   252: invokevirtual 55	android/media/MediaPlayer:isPlaying	()Z
    //   255: ifeq +23 -> 278
    //   258: aload_0
    //   259: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   262: invokestatic 105	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;)Z
    //   265: ifne +13 -> 278
    //   268: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   271: ldc 106
    //   273: ldc 106
    //   275: invokevirtual 110	android/media/MediaPlayer:setVolume	(FF)V
    //   278: ldc 22
    //   280: iconst_1
    //   281: ldc 112
    //   283: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto -218 -> 68
    //   289: invokestatic 114	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:d	()I
    //   292: iconst_3
    //   293: if_icmpne +36 -> 329
    //   296: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   299: ifnull +30 -> 329
    //   302: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   305: invokevirtual 55	android/media/MediaPlayer:isPlaying	()Z
    //   308: ifne +21 -> 329
    //   311: aload_0
    //   312: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   315: invokestatic 105	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;)Z
    //   318: ifne +11 -> 329
    //   321: invokestatic 49	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	()Landroid/media/MediaPlayer;
    //   324: fconst_1
    //   325: fconst_1
    //   326: invokevirtual 110	android/media/MediaPlayer:setVolume	(FF)V
    //   329: ldc 22
    //   331: iconst_1
    //   332: ldc 116
    //   334: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload_0
    //   338: getfield 12	artn:a	Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;
    //   341: iconst_1
    //   342: iconst_0
    //   343: invokestatic 80	com/tencent/mobileqq/listentogether/player/QQMusicPlayService:a	(Lcom/tencent/mobileqq/listentogether/player/QQMusicPlayService;ZZ)V
    //   346: goto -278 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	artn
    //   0	349	1	paramInt	int
    //   29	128	2	localQQMusicPlayService	QQMusicPlayService
    //   160	27	2	localException	java.lang.Exception
    //   155	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	70	155	finally
    //   71	112	155	finally
    //   112	152	155	finally
    //   156	158	155	finally
    //   191	223	155	finally
    //   223	240	155	finally
    //   243	278	155	finally
    //   278	286	155	finally
    //   289	329	155	finally
    //   329	346	155	finally
    //   25	32	160	java/lang/Exception
    //   158	160	160	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     artn
 * JD-Core Version:    0.7.0.1
 */