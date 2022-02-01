package com.tencent.mobileqq.apollo.game.process.audio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloGameMusicPlayer
  implements ICmGameAudioPlayer
{
  public static String a = "cmgame_process.ApolloGameMusicPlayer";
  private int jdField_a_of_type_Int = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final Object jdField_a_of_type_JavaLangObject;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<MediaPlayer> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private int b;
  
  public ApolloGameMusicPlayer(int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ApolloGameMusicPlayer.2(this);
    AppInterface localAppInterface = CmGameUtil.a();
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", i);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localAppInterface);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    a(localAppInterface);
  }
  
  private MediaPlayer a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt)) {
            return localMediaPlayer;
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_game_music_switch");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.b);
      this.jdField_a_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = localAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
    } else {
      i = localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
    }
  }
  
  private MediaPlayer b(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt)) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer;
    }
    return null;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getCurPosition], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    localMediaPlayer = b(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.b) });
    }
    a(paramAppInterface);
    return this.jdField_a_of_type_Int;
  }
  
  /* Error */
  public int a(com.tencent.mobileqq.apollo.render.IRenderRunner paramIRenderRunner, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_m1
    //   5: ireturn
    //   6: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: istore 11
    //   11: iconst_0
    //   12: istore 10
    //   14: iload 11
    //   16: ifeq +113 -> 129
    //   19: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: iconst_2
    //   23: bipush 14
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: ldc 221
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: iload_2
    //   36: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 223
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: aload 4
    //   49: aastore
    //   50: dup
    //   51: iconst_4
    //   52: ldc 225
    //   54: aastore
    //   55: dup
    //   56: iconst_5
    //   57: iload_3
    //   58: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: dup
    //   63: bipush 6
    //   65: ldc 227
    //   67: aastore
    //   68: dup
    //   69: bipush 7
    //   71: aload_0
    //   72: getfield 91	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:b	I
    //   75: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: dup
    //   80: bipush 8
    //   82: ldc 229
    //   84: aastore
    //   85: dup
    //   86: bipush 9
    //   88: aload_0
    //   89: getfield 91	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:b	I
    //   92: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: bipush 10
    //   99: ldc 231
    //   101: aastore
    //   102: dup
    //   103: bipush 11
    //   105: iload 7
    //   107: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: bipush 12
    //   114: ldc 233
    //   116: aastore
    //   117: dup
    //   118: bipush 13
    //   120: fload 8
    //   122: invokestatic 238	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   125: aastore
    //   126: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   129: aload_0
    //   130: getfield 91	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:b	I
    //   133: ifle +37 -> 170
    //   136: aload_0
    //   137: getfield 42	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_Int	I
    //   140: ifeq +13 -> 153
    //   143: invokestatic 240	com/tencent/mobileqq/apollo/game/process/CmGameUtil:d	()Z
    //   146: ifeq +7 -> 153
    //   149: aload_1
    //   150: ifnonnull +20 -> 170
    //   153: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +12 -> 168
    //   159: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_2
    //   163: ldc 242
    //   165: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iconst_m1
    //   169: ireturn
    //   170: iload_3
    //   171: istore 9
    //   173: iconst_m1
    //   174: iload_3
    //   175: if_icmpne +7 -> 182
    //   178: ldc 246
    //   180: istore 9
    //   182: aload_1
    //   183: instanceof 248
    //   186: ifeq +15 -> 201
    //   189: aload_1
    //   190: checkcast 248	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloSurfaceView
    //   193: invokevirtual 252	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloSurfaceView:getRender	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;
    //   196: astore 12
    //   198: goto +22 -> 220
    //   201: aload_1
    //   202: instanceof 254
    //   205: ifeq +494 -> 699
    //   208: aload_1
    //   209: checkcast 254	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloTextureView
    //   212: invokevirtual 255	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloTextureView:getRender	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;
    //   215: astore 12
    //   217: goto +3 -> 220
    //   220: aload 12
    //   222: ifnull +67 -> 289
    //   225: aload 4
    //   227: invokestatic 261	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   230: ifeq +10 -> 240
    //   233: aload 4
    //   235: astore 12
    //   237: goto +55 -> 292
    //   240: aload 12
    //   242: aload 4
    //   244: ldc_w 263
    //   247: invokevirtual 269	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getRscPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: astore 12
    //   252: aload 12
    //   254: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifne +32 -> 289
    //   260: new 277	java/io/File
    //   263: dup
    //   264: aload 12
    //   266: invokespecial 280	java/io/File:<init>	(Ljava/lang/String;)V
    //   269: astore 12
    //   271: aload 12
    //   273: invokevirtual 283	java/io/File:exists	()Z
    //   276: ifeq +13 -> 289
    //   279: aload 12
    //   281: invokevirtual 286	java/io/File:getPath	()Ljava/lang/String;
    //   284: astore 12
    //   286: goto +6 -> 292
    //   289: aconst_null
    //   290: astore 12
    //   292: aload 12
    //   294: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifeq +45 -> 342
    //   300: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   303: astore_1
    //   304: new 137	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   311: astore 12
    //   313: aload 12
    //   315: ldc_w 288
    //   318: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 12
    //   324: aload 4
    //   326: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_1
    //   331: iconst_1
    //   332: aload 12
    //   334: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 291	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: iconst_m1
    //   341: ireturn
    //   342: iload_2
    //   343: ifne +71 -> 414
    //   346: aload_0
    //   347: aload 12
    //   349: iload 9
    //   351: invokevirtual 294	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:a	(Ljava/lang/String;I)Landroid/media/MediaPlayer;
    //   354: astore 4
    //   356: aload 4
    //   358: ifnull +54 -> 412
    //   361: iconst_m1
    //   362: iload 7
    //   364: if_icmpeq +10 -> 374
    //   367: aload 4
    //   369: iload 7
    //   371: invokevirtual 297	android/media/MediaPlayer:seekTo	(I)V
    //   374: ldc_w 298
    //   377: fload 8
    //   379: fcmpl
    //   380: ifeq +12 -> 392
    //   383: aload 4
    //   385: fload 8
    //   387: fload 8
    //   389: invokevirtual 302	android/media/MediaPlayer:setVolume	(FF)V
    //   392: invokestatic 307	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   395: aload_1
    //   396: aload 4
    //   398: invokevirtual 133	java/lang/Object:hashCode	()I
    //   401: lload 5
    //   403: invokevirtual 311	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:playMusicInner	(Lcom/tencent/mobileqq/apollo/render/IRenderRunner;IJ)V
    //   406: aload 4
    //   408: invokevirtual 133	java/lang/Object:hashCode	()I
    //   411: ireturn
    //   412: iconst_m1
    //   413: ireturn
    //   414: aload_0
    //   415: getfield 91	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:b	I
    //   418: sipush -10000
    //   421: if_icmpne +10 -> 431
    //   424: aload_0
    //   425: iconst_0
    //   426: aload 4
    //   428: invokevirtual 315	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:c	(ILjava/lang/String;)V
    //   431: new 129	android/media/MediaPlayer
    //   434: dup
    //   435: invokespecial 316	android/media/MediaPlayer:<init>	()V
    //   438: astore 4
    //   440: aload_0
    //   441: getfield 51	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   444: astore 13
    //   446: aload 13
    //   448: monitorenter
    //   449: aload_0
    //   450: getfield 40	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   453: aload 4
    //   455: invokeinterface 320 2 0
    //   460: pop
    //   461: aload 13
    //   463: monitorexit
    //   464: aload_0
    //   465: iconst_1
    //   466: invokespecial 167	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:a	(Z)V
    //   469: aload 4
    //   471: aload 12
    //   473: invokevirtual 323	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   476: iload 9
    //   478: ldc 246
    //   480: if_icmpne +6 -> 486
    //   483: iconst_1
    //   484: istore 10
    //   486: aload 4
    //   488: iload 10
    //   490: invokevirtual 326	android/media/MediaPlayer:setLooping	(Z)V
    //   493: iload 9
    //   495: ldc 246
    //   497: if_icmpeq +72 -> 569
    //   500: aload 4
    //   502: new 328	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer$1
    //   505: dup
    //   506: aload_0
    //   507: iload 9
    //   509: aload_1
    //   510: lload 5
    //   512: invokespecial 331	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer$1:<init>	(Lcom/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer;ILcom/tencent/mobileqq/apollo/render/IRenderRunner;J)V
    //   515: invokevirtual 335	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   518: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +48 -> 569
    //   524: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   527: astore 12
    //   529: new 137	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   536: astore 13
    //   538: aload 13
    //   540: ldc_w 337
    //   543: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 13
    //   549: aload 4
    //   551: invokevirtual 340	android/media/MediaPlayer:getAudioSessionId	()I
    //   554: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 12
    //   560: iconst_2
    //   561: aload 13
    //   563: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: aload 4
    //   571: invokevirtual 343	android/media/MediaPlayer:prepare	()V
    //   574: aload 4
    //   576: invokevirtual 346	android/media/MediaPlayer:start	()V
    //   579: iconst_m1
    //   580: iload 7
    //   582: if_icmpeq +10 -> 592
    //   585: aload 4
    //   587: iload 7
    //   589: invokevirtual 297	android/media/MediaPlayer:seekTo	(I)V
    //   592: ldc_w 298
    //   595: fload 8
    //   597: fcmpl
    //   598: ifeq +12 -> 610
    //   601: aload 4
    //   603: fload 8
    //   605: fload 8
    //   607: invokevirtual 302	android/media/MediaPlayer:setVolume	(FF)V
    //   610: invokestatic 307	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:getInstance	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel;
    //   613: aload_1
    //   614: aload 4
    //   616: invokevirtual 133	java/lang/Object:hashCode	()I
    //   619: lload 5
    //   621: invokevirtual 311	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloCmdChannel:playMusicInner	(Lcom/tencent/mobileqq/apollo/render/IRenderRunner;IJ)V
    //   624: aload 4
    //   626: invokevirtual 133	java/lang/Object:hashCode	()I
    //   629: istore_2
    //   630: iload_2
    //   631: ireturn
    //   632: astore_1
    //   633: aload 13
    //   635: monitorexit
    //   636: aload_1
    //   637: athrow
    //   638: astore_1
    //   639: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   642: iconst_1
    //   643: ldc_w 348
    //   646: aload_1
    //   647: invokestatic 352	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   650: iconst_m1
    //   651: ireturn
    //   652: astore_1
    //   653: getstatic 182	com/tencent/mobileqq/apollo/game/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   656: astore 4
    //   658: new 137	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   665: astore 12
    //   667: aload 12
    //   669: ldc_w 354
    //   672: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 12
    //   678: aload_1
    //   679: invokevirtual 357	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   682: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 4
    //   688: iconst_1
    //   689: aload 12
    //   691: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   697: iconst_m1
    //   698: ireturn
    //   699: aconst_null
    //   700: astore 12
    //   702: goto -482 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	ApolloGameMusicPlayer
    //   0	705	1	paramIRenderRunner	com.tencent.mobileqq.apollo.render.IRenderRunner
    //   0	705	2	paramInt1	int
    //   0	705	3	paramInt2	int
    //   0	705	4	paramString	String
    //   0	705	5	paramLong	long
    //   0	705	7	paramInt3	int
    //   0	705	8	paramFloat	float
    //   171	337	9	i	int
    //   12	477	10	bool1	boolean
    //   9	6	11	bool2	boolean
    //   196	505	12	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   449	464	632	finally
    //   633	636	632	finally
    //   431	449	638	java/lang/Throwable
    //   464	476	638	java/lang/Throwable
    //   486	493	638	java/lang/Throwable
    //   500	569	638	java/lang/Throwable
    //   569	579	638	java/lang/Throwable
    //   585	592	638	java/lang/Throwable
    //   601	610	638	java/lang/Throwable
    //   610	630	638	java/lang/Throwable
    //   636	638	638	java/lang/Throwable
    //   182	198	652	java/lang/Throwable
    //   201	217	652	java/lang/Throwable
    //   225	233	652	java/lang/Throwable
    //   240	286	652	java/lang/Throwable
  }
  
  public MediaPlayer a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        a(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        paramString = this.jdField_a_of_type_AndroidMediaMediaPlayer;
        if (paramInt != 2147483647) {
          break label100;
        }
        bool = true;
        paramString.setLooping(bool);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      catch (Throwable paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramString);
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer;
      label100:
      boolean bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[pauseMusic], gameId:", Integer.valueOf(this.b) });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameMusicPlayer", 2, "pauseMusic bMute false");
      }
      a(false);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
            if (localMediaPlayer != null) {
              localMediaPlayer.pause();
            }
          }
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "pause error:", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[seekTo], hashCode:", Integer.valueOf(paramInt1), ",pos:", Integer.valueOf(paramInt2) });
    }
    MediaPlayer localMediaPlayer = a(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
    localMediaPlayer = b(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
  }
  
  public void a(int paramInt, AppInterface arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[setMusicSwitch], sw:", Integer.valueOf(paramInt), ",gameId:", Integer.valueOf(this.b) });
    }
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject1 != null)
    {
      if (??? == null) {
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      localObject1 = ((SharedPreferences)localObject1).edit();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("apollo_game_music_switch");
      ((StringBuilder)localObject3).append(???.getCurrentAccountUin());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(this.b);
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject3).toString(), paramInt).commit();
      if (paramInt == 0) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (MediaPlayer)((Iterator)localObject1).next();
              if (localObject3 != null) {
                ((MediaPlayer)localObject3).reset();
              }
            }
          }
          ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
          if (??? != null)
          {
            ???.reset();
            return;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[pauseMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
              a(false);
            }
            localMediaPlayer.pause();
            return;
          }
        }
      }
      ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        a(false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getDuration], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    localMediaPlayer = b(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], gameId:", Integer.valueOf(this.b) });
    }
    if ((this.jdField_a_of_type_Int != 0) && (!CmGameUtil.b()) && (!CmGameUtil.c()) && (CmGameUtil.d()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      a(true);
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.start();
              }
            }
          }
          if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "resumeMusic error:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DO NOT play music.");
    }
  }
  
  public void b(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            a(true);
            localMediaPlayer.start();
            return;
          }
        }
      }
      ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        a(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onDestroy],gameId:", Integer.valueOf(this.b) });
    }
    a(false);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if (localMediaPlayer != null)
          {
            localMediaPlayer.stop();
            localMediaPlayer.release();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "stop front music.");
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "stop back music.");
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[stopMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    a(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (this.b == -10000)
        {
          while (this.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            localObject1 = (MediaPlayer)this.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              ((MediaPlayer)localObject1).stop();
            }
            catch (IllegalStateException localIllegalStateException)
            {
              localIllegalStateException.printStackTrace();
            }
            ((MediaPlayer)localObject1).release();
            this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          }
          return;
        }
        Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)((Iterator)localObject1).next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            this.jdField_a_of_type_JavaUtilList.remove(localMediaPlayer);
            localMediaPlayer.stop();
            localMediaPlayer.release();
            return;
          }
        }
      }
      ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */