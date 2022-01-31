import com.qq.im.poi.LbsPackManager;

public class anf
  implements Runnable
{
  public anf(LbsPackManager paramLbsPackManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 21	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   7: ldc 24
    //   9: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 12	anf:a	Lcom/qq/im/poi/LbsPackManager;
    //   16: getfield 33	com/qq/im/poi/LbsPackManager:a	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   19: invokevirtual 39	com/tencent/mobileqq/armap/ArMapInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 48	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 12	anf:a	Lcom/qq/im/poi/LbsPackManager;
    //   36: getfield 33	com/qq/im/poi/LbsPackManager:a	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   39: invokevirtual 52	com/tencent/mobileqq/armap/ArMapInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: invokevirtual 58	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   45: aload_1
    //   46: aconst_null
    //   47: ldc 60
    //   49: iconst_1
    //   50: anewarray 62	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_0
    //   56: getfield 12	anf:a	Lcom/qq/im/poi/LbsPackManager;
    //   59: getfield 33	com/qq/im/poi/LbsPackManager:a	Lcom/tencent/mobileqq/armap/ArMapInterface;
    //   62: invokevirtual 39	com/tencent/mobileqq/armap/ArMapInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   65: aastore
    //   66: aconst_null
    //   67: invokevirtual 68	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +104 -> 176
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: invokeinterface 74 1 0
    //   83: ifle +93 -> 176
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: invokeinterface 78 1 0
    //   94: pop
    //   95: aload_2
    //   96: astore_1
    //   97: aload_2
    //   98: aload_2
    //   99: ldc 80
    //   101: invokeinterface 84 2 0
    //   106: invokeinterface 88 2 0
    //   111: invokestatic 93	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +55 -> 176
    //   124: aload_2
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 12	anf:a	Lcom/qq/im/poi/LbsPackManager;
    //   130: aload_3
    //   131: invokestatic 102	com/qq/im/poi/LbsPackManager:a	(Lcom/qq/im/poi/LbsPackManager;Ljava/lang/String;)Ljava/lang/String;
    //   134: pop
    //   135: aload_2
    //   136: astore_1
    //   137: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +36 -> 176
    //   143: aload_2
    //   144: astore_1
    //   145: ldc 109
    //   147: iconst_2
    //   148: new 21	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   155: ldc 111
    //   157: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: getfield 12	anf:a	Lcom/qq/im/poi/LbsPackManager;
    //   164: invokestatic 114	com/qq/im/poi/LbsPackManager:a	(Lcom/qq/im/poi/LbsPackManager;)Ljava/lang/String;
    //   167: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_2
    //   177: ifnull +9 -> 186
    //   180: aload_2
    //   181: invokeinterface 121 1 0
    //   186: return
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_2
    //   191: astore_1
    //   192: aload_3
    //   193: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   196: aload_2
    //   197: ifnull -11 -> 186
    //   200: aload_2
    //   201: invokeinterface 121 1 0
    //   206: return
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +9 -> 220
    //   214: aload_1
    //   215: invokeinterface 121 1 0
    //   220: aload_2
    //   221: athrow
    //   222: astore_2
    //   223: goto -13 -> 210
    //   226: astore_3
    //   227: goto -37 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	anf
    //   31	184	1	localObject1	Object
    //   70	131	2	localCursor	android.database.Cursor
    //   207	14	2	localObject2	Object
    //   222	1	2	localObject3	Object
    //   114	17	3	str	java.lang.String
    //   187	6	3	localException1	java.lang.Exception
    //   226	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   32	71	187	java/lang/Exception
    //   32	71	207	finally
    //   77	86	222	finally
    //   88	95	222	finally
    //   97	115	222	finally
    //   117	124	222	finally
    //   126	135	222	finally
    //   137	143	222	finally
    //   145	176	222	finally
    //   192	196	222	finally
    //   77	86	226	java/lang/Exception
    //   88	95	226	java/lang/Exception
    //   97	115	226	java/lang/Exception
    //   117	124	226	java/lang/Exception
    //   126	135	226	java/lang/Exception
    //   137	143	226	java/lang/Exception
    //   145	176	226	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anf
 * JD-Core Version:    0.7.0.1
 */