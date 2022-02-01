import android.media.MediaPlayer.OnCompletionListener;
import java.util.ArrayList;

public final class bhfm
  implements MediaPlayer.OnCompletionListener
{
  public bhfm(ArrayList paramArrayList) {}
  
  /* Error */
  public void onCompletion(android.media.MediaPlayer paramMediaPlayer)
  {
    // Byte code:
    //   0: invokestatic 28	com/tencent/mobileqq/vashealth/PathTraceManager:c	()I
    //   3: aload_0
    //   4: getfield 12	bhfm:a	Ljava/util/ArrayList;
    //   7: invokevirtual 33	java/util/ArrayList:size	()I
    //   10: iconst_1
    //   11: isub
    //   12: if_icmpge +142 -> 154
    //   15: invokestatic 28	com/tencent/mobileqq/vashealth/PathTraceManager:c	()I
    //   18: iconst_1
    //   19: iadd
    //   20: invokestatic 36	com/tencent/mobileqq/vashealth/PathTraceManager:a	(I)I
    //   23: pop
    //   24: getstatic 39	com/tencent/mobileqq/vashealth/PathTraceManager:a	Landroid/media/MediaPlayer;
    //   27: invokevirtual 44	android/media/MediaPlayer:reset	()V
    //   30: new 46	java/io/FileInputStream
    //   33: dup
    //   34: new 48	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield 12	bhfm:a	Ljava/util/ArrayList;
    //   42: invokestatic 28	com/tencent/mobileqq/vashealth/PathTraceManager:c	()I
    //   45: invokevirtual 52	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 54	android/net/Uri
    //   51: invokevirtual 58	android/net/Uri:getPath	()Ljava/lang/String;
    //   54: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: getstatic 39	com/tencent/mobileqq/vashealth/PathTraceManager:a	Landroid/media/MediaPlayer;
    //   66: aload_2
    //   67: invokevirtual 68	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   70: invokevirtual 72	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   73: aload_2
    //   74: astore_1
    //   75: getstatic 39	com/tencent/mobileqq/vashealth/PathTraceManager:a	Landroid/media/MediaPlayer;
    //   78: invokevirtual 75	android/media/MediaPlayer:prepare	()V
    //   81: aload_2
    //   82: astore_1
    //   83: getstatic 39	com/tencent/mobileqq/vashealth/PathTraceManager:a	Landroid/media/MediaPlayer;
    //   86: invokevirtual 78	android/media/MediaPlayer:start	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 81	java/io/FileInputStream:close	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   103: return
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_1
    //   109: ldc 86
    //   111: iconst_1
    //   112: ldc 88
    //   114: aload_3
    //   115: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_2
    //   119: ifnull -22 -> 97
    //   122: aload_2
    //   123: invokevirtual 81	java/io/FileInputStream:close	()V
    //   126: return
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 81	java/io/FileInputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: aload_0
    //   155: getfield 12	bhfm:a	Ljava/util/ArrayList;
    //   158: invokevirtual 97	java/util/ArrayList:clear	()V
    //   161: iconst_0
    //   162: invokestatic 36	com/tencent/mobileqq/vashealth/PathTraceManager:a	(I)I
    //   165: pop
    //   166: return
    //   167: astore_2
    //   168: goto -32 -> 136
    //   171: astore_3
    //   172: goto -65 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	bhfm
    //   0	175	1	paramMediaPlayer	android.media.MediaPlayer
    //   60	63	2	localFileInputStream	java.io.FileInputStream
    //   133	12	2	localObject1	Object
    //   167	1	2	localObject2	Object
    //   104	11	3	localException1	java.lang.Exception
    //   171	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   93	97	98	java/io/IOException
    //   30	61	104	java/lang/Exception
    //   122	126	127	java/io/IOException
    //   30	61	133	finally
    //   140	144	146	java/io/IOException
    //   63	73	167	finally
    //   75	81	167	finally
    //   83	89	167	finally
    //   109	118	167	finally
    //   63	73	171	java/lang/Exception
    //   75	81	171	java/lang/Exception
    //   83	89	171	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfm
 * JD-Core Version:    0.7.0.1
 */