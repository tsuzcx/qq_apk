import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import java.io.IOException;

public class bbfc
{
  private static bbfc jdField_a_of_type_Bbfc;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  
  public static bbfc a()
  {
    if (jdField_a_of_type_Bbfc == null) {
      jdField_a_of_type_Bbfc = new bbfc();
    }
    return jdField_a_of_type_Bbfc;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 23	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: invokevirtual 26	android/media/MediaPlayer:reset	()V
    //   28: aload_0
    //   29: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   32: invokevirtual 29	android/media/MediaPlayer:release	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   40: goto -29 -> 11
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	bbfc
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   14	40	43	finally
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 40	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 43	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	bbfc
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  public boolean a(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramContext, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        bool = true;
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
  
  /* Error */
  public boolean a(Context paramContext, java.lang.String paramString, aikg paramaikg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: ifnonnull +63 -> 72
    //   12: aload_0
    //   13: new 20	android/media/MediaPlayer
    //   16: dup
    //   17: invokespecial 31	android/media/MediaPlayer:<init>	()V
    //   20: putfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: aload_0
    //   24: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: iconst_3
    //   28: invokevirtual 54	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   31: new 67	java/io/File
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 73	java/io/File:exists	()Z
    //   44: istore 4
    //   46: iload 4
    //   48: ifne +39 -> 87
    //   51: iload 5
    //   53: istore 4
    //   55: iconst_0
    //   56: ifeq +11 -> 67
    //   59: new 75	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 76	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: aload_0
    //   68: monitorexit
    //   69: iload 4
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   76: invokevirtual 26	android/media/MediaPlayer:reset	()V
    //   79: goto -56 -> 23
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: new 78	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   98: astore_2
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   105: aload_2
    //   106: invokevirtual 87	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   109: invokevirtual 90	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   118: aload_3
    //   119: invokevirtual 94	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   128: invokevirtual 97	android/media/MediaPlayer:prepareAsync	()V
    //   131: aload_2
    //   132: astore_1
    //   133: aload_2
    //   134: invokevirtual 100	java/io/FileInputStream:close	()V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 100	java/io/FileInputStream:close	()V
    //   145: iconst_1
    //   146: istore 4
    //   148: goto -81 -> 67
    //   151: astore 6
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload 6
    //   159: invokevirtual 43	java/lang/IllegalStateException:printStackTrace	()V
    //   162: aload_2
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 104	aikg:a	()V
    //   168: iload 5
    //   170: istore 4
    //   172: aload_2
    //   173: ifnull -106 -> 67
    //   176: aload_2
    //   177: invokevirtual 100	java/io/FileInputStream:close	()V
    //   180: iload 5
    //   182: istore 4
    //   184: goto -117 -> 67
    //   187: astore_1
    //   188: iload 5
    //   190: istore 4
    //   192: goto -125 -> 67
    //   195: astore 6
    //   197: aconst_null
    //   198: astore_2
    //   199: aload_2
    //   200: astore_1
    //   201: aload 6
    //   203: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: invokevirtual 104	aikg:a	()V
    //   212: iload 5
    //   214: istore 4
    //   216: aload_2
    //   217: ifnull -150 -> 67
    //   220: aload_2
    //   221: invokevirtual 100	java/io/FileInputStream:close	()V
    //   224: iload 5
    //   226: istore 4
    //   228: goto -161 -> 67
    //   231: astore_1
    //   232: iload 5
    //   234: istore 4
    //   236: goto -169 -> 67
    //   239: astore 6
    //   241: aconst_null
    //   242: astore_2
    //   243: aload_2
    //   244: astore_1
    //   245: aload 6
    //   247: invokevirtual 63	java/lang/IllegalArgumentException:printStackTrace	()V
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: invokevirtual 104	aikg:a	()V
    //   256: iload 5
    //   258: istore 4
    //   260: aload_2
    //   261: ifnull -194 -> 67
    //   264: aload_2
    //   265: invokevirtual 100	java/io/FileInputStream:close	()V
    //   268: iload 5
    //   270: istore 4
    //   272: goto -205 -> 67
    //   275: astore_1
    //   276: iload 5
    //   278: istore 4
    //   280: goto -213 -> 67
    //   283: astore 6
    //   285: aconst_null
    //   286: astore_2
    //   287: aload_2
    //   288: astore_1
    //   289: aload 6
    //   291: invokevirtual 64	java/lang/SecurityException:printStackTrace	()V
    //   294: aload_2
    //   295: astore_1
    //   296: aload_3
    //   297: invokevirtual 104	aikg:a	()V
    //   300: iload 5
    //   302: istore 4
    //   304: aload_2
    //   305: ifnull -238 -> 67
    //   308: aload_2
    //   309: invokevirtual 100	java/io/FileInputStream:close	()V
    //   312: iload 5
    //   314: istore 4
    //   316: goto -249 -> 67
    //   319: astore_1
    //   320: iload 5
    //   322: istore 4
    //   324: goto -257 -> 67
    //   327: astore_2
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_1
    //   331: ifnull +7 -> 338
    //   334: aload_1
    //   335: invokevirtual 100	java/io/FileInputStream:close	()V
    //   338: aload_2
    //   339: athrow
    //   340: astore_1
    //   341: iload 5
    //   343: istore 4
    //   345: goto -278 -> 67
    //   348: astore_1
    //   349: goto -204 -> 145
    //   352: astore_1
    //   353: goto -15 -> 338
    //   356: astore_2
    //   357: goto -27 -> 330
    //   360: astore 6
    //   362: goto -75 -> 287
    //   365: astore 6
    //   367: goto -124 -> 243
    //   370: astore 6
    //   372: goto -173 -> 199
    //   375: astore 6
    //   377: goto -222 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	bbfc
    //   0	380	1	paramContext	Context
    //   0	380	2	paramString	java.lang.String
    //   0	380	3	paramaikg	aikg
    //   44	300	4	bool1	boolean
    //   1	341	5	bool2	boolean
    //   151	7	6	localIllegalStateException1	IllegalStateException
    //   195	7	6	localIOException1	IOException
    //   239	7	6	localIllegalArgumentException1	IllegalArgumentException
    //   283	7	6	localSecurityException1	SecurityException
    //   360	1	6	localSecurityException2	SecurityException
    //   365	1	6	localIllegalArgumentException2	IllegalArgumentException
    //   370	1	6	localIOException2	IOException
    //   375	1	6	localIllegalStateException2	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   5	23	82	finally
    //   59	67	82	finally
    //   72	79	82	finally
    //   141	145	82	finally
    //   176	180	82	finally
    //   220	224	82	finally
    //   264	268	82	finally
    //   308	312	82	finally
    //   334	338	82	finally
    //   338	340	82	finally
    //   23	46	151	java/lang/IllegalStateException
    //   87	99	151	java/lang/IllegalStateException
    //   176	180	187	java/io/IOException
    //   23	46	195	java/io/IOException
    //   87	99	195	java/io/IOException
    //   220	224	231	java/io/IOException
    //   23	46	239	java/lang/IllegalArgumentException
    //   87	99	239	java/lang/IllegalArgumentException
    //   264	268	275	java/io/IOException
    //   23	46	283	java/lang/SecurityException
    //   87	99	283	java/lang/SecurityException
    //   308	312	319	java/io/IOException
    //   23	46	327	finally
    //   87	99	327	finally
    //   59	67	340	java/io/IOException
    //   141	145	348	java/io/IOException
    //   334	338	352	java/io/IOException
    //   101	112	356	finally
    //   114	122	356	finally
    //   124	131	356	finally
    //   133	137	356	finally
    //   157	162	356	finally
    //   164	168	356	finally
    //   201	206	356	finally
    //   208	212	356	finally
    //   245	250	356	finally
    //   252	256	356	finally
    //   289	294	356	finally
    //   296	300	356	finally
    //   101	112	360	java/lang/SecurityException
    //   114	122	360	java/lang/SecurityException
    //   124	131	360	java/lang/SecurityException
    //   133	137	360	java/lang/SecurityException
    //   101	112	365	java/lang/IllegalArgumentException
    //   114	122	365	java/lang/IllegalArgumentException
    //   124	131	365	java/lang/IllegalArgumentException
    //   133	137	365	java/lang/IllegalArgumentException
    //   101	112	370	java/io/IOException
    //   114	122	370	java/io/IOException
    //   124	131	370	java/io/IOException
    //   133	137	370	java/io/IOException
    //   101	112	375	java/lang/IllegalStateException
    //   114	122	375	java/lang/IllegalStateException
    //   124	131	375	java/lang/IllegalStateException
    //   133	137	375	java/lang/IllegalStateException
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: iload_1
    //   24: invokevirtual 109	android/media/MediaPlayer:setLooping	(Z)V
    //   27: iconst_1
    //   28: istore_1
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 43	java/lang/IllegalStateException:printStackTrace	()V
    //   37: iload_2
    //   38: istore_1
    //   39: goto -24 -> 15
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	bbfc
    //   0	47	1	paramBoolean	boolean
    //   1	37	2	bool	boolean
    //   8	2	3	localMediaPlayer	MediaPlayer
    //   32	2	3	localIllegalStateException	IllegalStateException
    //   42	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	32	java/lang/IllegalStateException
    //   4	9	42	finally
    //   19	27	42	finally
    //   33	37	42	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 23	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 43	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	bbfc
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 114	android/media/MediaPlayer:pause	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 43	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	bbfc
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	bbfc:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 118	android/media/MediaPlayer:isPlaying	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	bbfc
    //   12	13	1	bool	boolean
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfc
 * JD-Core Version:    0.7.0.1
 */