package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ywf;

public class ApolloGameMusicPlayer
{
  public static String a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public AtomicBoolean a;
  private Map b = Collections.synchronizedMap(new HashMap());
  private Map c = Collections.synchronizedMap(new HashMap());
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.ApolloGameMusicPlayer";
  }
  
  public ApolloGameMusicPlayer(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(int paramInt, MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return;
    }
    List localList = (List)this.b.get(Integer.valueOf(paramInt));
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(paramMediaPlayer);
    this.b.put(Integer.valueOf(paramInt), localObject);
  }
  
  private void a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null) {}
    while ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {}
    for (int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt, 1);; i = 1)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new Integer(i));
      return;
    }
  }
  
  private void b(int paramInt, MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {}
    List localList;
    do
    {
      return;
      localList = (List)this.b.get(Integer.valueOf(paramInt));
    } while (localList == null);
    localList.remove(paramMediaPlayer);
  }
  
  public int a(int paramInt1, AppInterface paramAppInterface, IRenderRunner paramIRenderRunner, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if (paramIRenderRunner == null) {
      return -1;
    }
    boolean bool;
    if ((paramIRenderRunner instanceof ApolloSurfaceView)) {
      if (((ApolloSurfaceView)paramIRenderRunner).getGameId() > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt2), ",musicPath:", paramString, ",loopCount:", Integer.valueOf(paramInt3), ",isGameMode", Boolean.valueOf(bool), ",gameId:", Integer.valueOf(paramInt1) });
      }
      a(paramAppInterface, paramInt1);
      ??? = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
      if ((bool) && ((??? == null) || (((Integer)???).intValue() == 0) || (paramAppInterface == null) || (CmGameUtil.b()) || (CmGameUtil.c()) || (!CmGameUtil.d()) || (paramIRenderRunner == null)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "DO NOT play music.");
        }
        return -1;
        bool = false;
      }
      else
      {
        if (-1 == paramInt3) {
          paramInt3 = 2147483647;
        }
        for (;;)
        {
          label561:
          for (paramAppInterface = null;; paramAppInterface = null)
          {
            try
            {
              if ((paramIRenderRunner instanceof ApolloSurfaceView)) {
                paramAppInterface = ((ApolloSurfaceView)paramIRenderRunner).getRender();
              }
              for (;;)
              {
                if (paramAppInterface == null) {
                  break label561;
                }
                paramAppInterface = new File(paramAppInterface.getRscPath(paramString, "mp3"));
                if ((paramAppInterface != null) && (paramAppInterface.exists())) {
                  break;
                }
                QLog.w(jdField_a_of_type_JavaLangString, 1, "music NOT exist.path:" + paramAppInterface.getAbsolutePath());
                return -1;
                if ((paramIRenderRunner instanceof ApolloTextureView)) {
                  paramAppInterface = ((ApolloTextureView)paramIRenderRunner).getRender();
                }
              }
              if (paramInt2 != 0) {
                break label367;
              }
            }
            catch (Throwable paramAppInterface)
            {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "[playMusic], errInfo->" + paramAppInterface.getMessage());
              return -1;
            }
            paramAppInterface = a(paramInt1, paramAppInterface.getPath(), paramInt3);
            if (paramAppInterface != null) {
              return paramAppInterface.hashCode();
            }
            return -1;
            label367:
            if (paramInt1 == -10000) {
              c(paramInt1, 0, paramString);
            }
            if (0 == 0)
            {
              paramString = new MediaPlayer();
              synchronized (this.jdField_a_of_type_JavaLangObject)
              {
                a(paramInt1, paramString);
              }
            }
            for (;;)
            {
              try
              {
                AudioUtil.a(BaseApplicationImpl.getContext(), true);
                paramString.setDataSource(paramAppInterface.getPath());
                if (paramInt3 == 2147483647)
                {
                  bool = true;
                  paramString.setLooping(bool);
                  if (paramInt3 != 2147483647)
                  {
                    paramString.setOnCompletionListener(new ywf(this, paramInt3, paramInt1, paramIRenderRunner, paramLong));
                    if (QLog.isColorLevel()) {
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "create player, audio_sessionID: " + paramString.getAudioSessionId());
                    }
                  }
                  paramString.prepare();
                  paramString.start();
                  paramInt1 = paramString.hashCode();
                  return paramInt1;
                  paramAppInterface = finally;
                  throw paramAppInterface;
                }
                bool = false;
                continue;
                paramString = null;
              }
              catch (Throwable paramAppInterface)
              {
                QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramAppInterface);
                return -1;
              }
            }
          }
        }
        bool = true;
      }
    }
  }
  
  public int a(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(paramInt) });
    }
    a(paramAppInterface, paramInt);
    paramAppInterface = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (paramAppInterface != null) {}
    for (paramInt = paramAppInterface.intValue();; paramInt = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getMusicSwitch], s:" + paramInt);
      }
      return paramInt;
    }
  }
  
  public MediaPlayer a(int paramInt1, String paramString, int paramInt2)
  {
    MediaPlayer localMediaPlayer = (MediaPlayer)this.c.get(Integer.valueOf(paramInt1));
    if (localMediaPlayer == null)
    {
      localMediaPlayer = new MediaPlayer();
      this.c.put(Integer.valueOf(paramInt1), localMediaPlayer);
      try
      {
        for (;;)
        {
          localMediaPlayer.stop();
          localMediaPlayer.reset();
          AudioUtil.a(BaseApplicationImpl.getContext(), true);
          localMediaPlayer.setDataSource(paramString);
          if (paramInt2 == 2147483647) {}
          for (boolean bool = true;; bool = false)
          {
            localMediaPlayer.setLooping(bool);
            localMediaPlayer.prepare();
            localMediaPlayer.start();
            return localMediaPlayer;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramString);
        return localMediaPlayer;
      }
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +27 -> 30
    //   6: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: iconst_2
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 293
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 45	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_1
    //   35: invokevirtual 296	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc_w 298
    //   47: iconst_2
    //   48: ldc_w 300
    //   51: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: invokestatic 242	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   57: iconst_0
    //   58: invokestatic 247	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 36	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:b	Ljava/util/Map;
    //   66: iload_1
    //   67: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokeinterface 75 2 0
    //   75: checkcast 77	java/util/List
    //   78: astore_3
    //   79: aload_0
    //   80: getfield 47	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   83: astore_2
    //   84: aload_2
    //   85: monitorenter
    //   86: aload_3
    //   87: ifnull +67 -> 154
    //   90: aload_3
    //   91: invokeinterface 304 1 0
    //   96: astore_3
    //   97: aload_3
    //   98: invokeinterface 309 1 0
    //   103: ifeq +51 -> 154
    //   106: aload_3
    //   107: invokeinterface 313 1 0
    //   112: checkcast 233	android/media/MediaPlayer
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull -22 -> 97
    //   122: aload 4
    //   124: invokevirtual 316	android/media/MediaPlayer:pause	()V
    //   127: goto -30 -> 97
    //   130: astore_3
    //   131: aload_2
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_2
    //   136: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +14 -> 153
    //   142: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: iconst_2
    //   146: ldc_w 318
    //   149: aload_2
    //   150: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: return
    //   154: aload_2
    //   155: monitorexit
    //   156: aload_0
    //   157: getfield 38	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:c	Ljava/util/Map;
    //   160: iload_1
    //   161: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: invokeinterface 75 2 0
    //   169: checkcast 233	android/media/MediaPlayer
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull -21 -> 153
    //   177: aload_2
    //   178: invokevirtual 316	android/media/MediaPlayer:pause	()V
    //   181: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ApolloGameMusicPlayer
    //   0	182	1	paramInt	int
    //   83	49	2	localObject1	Object
    //   135	20	2	localException	java.lang.Exception
    //   172	6	2	localMediaPlayer1	MediaPlayer
    //   78	29	3	localObject2	Object
    //   130	4	3	localObject3	Object
    //   115	8	4	localMediaPlayer2	MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   90	97	130	finally
    //   97	117	130	finally
    //   122	127	130	finally
    //   131	133	130	finally
    //   154	156	130	finally
    //   38	54	135	java/lang/Exception
    //   54	86	135	java/lang/Exception
    //   133	135	135	java/lang/Exception
    //   156	173	135	java/lang/Exception
    //   177	181	135	java/lang/Exception
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[pauseMusic], path:", paramString, ",gameId:", Integer.valueOf(paramInt1) });
    }
    List localList = (List)this.b.get(Integer.valueOf(paramInt1));
    paramString = this.jdField_a_of_type_JavaLangObject;
    if (localList != null) {}
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
        if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt2))
        {
          if (localList.size() == 1) {
            AudioUtil.a(BaseApplicationImpl.getContext(), false);
          }
          localMediaPlayer.pause();
          return;
        }
      }
      paramString = (MediaPlayer)this.c.get(Integer.valueOf(paramInt1));
      if ((paramString != null) && (paramString.hashCode() == paramInt2))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        paramString.pause();
        return;
      }
    }
    finally {}
  }
  
  public void a(int paramInt1, AppInterface paramAppInterface, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[setMusicSwitch], sw:", Integer.valueOf(paramInt1), ",gameId:", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (paramAppInterface == null)) {}
    do
    {
      Object localObject3;
      do
      {
        return;
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt2));
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new Integer(paramInt1);
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt2), localObject1);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + paramInt2, paramInt1).commit();
      } while (paramInt1 != 0);
      Object localObject1 = (List)this.b.get(Integer.valueOf(paramInt2));
      paramAppInterface = this.jdField_a_of_type_JavaLangObject;
      if (localObject1 != null) {
        try
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (MediaPlayer)((Iterator)localObject1).next();
            if (localObject3 != null) {
              ((MediaPlayer)localObject3).reset();
            }
          }
        }
        finally {}
      }
      paramAppInterface = (MediaPlayer)this.c.get(Integer.valueOf(paramInt2));
    } while (paramAppInterface == null);
    paramAppInterface.reset();
  }
  
  /* Error */
  public void b(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +27 -> 30
    //   6: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: iconst_2
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 341
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 34	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   34: iload_1
    //   35: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: invokeinterface 75 2 0
    //   43: checkcast 65	java/lang/Integer
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +28 -> 76
    //   51: aload_2
    //   52: invokevirtual 166	java/lang/Integer:intValue	()I
    //   55: ifeq +21 -> 76
    //   58: invokestatic 170	com/tencent/mobileqq/apollo/process/CmGameUtil:b	()Z
    //   61: ifne +15 -> 76
    //   64: invokestatic 172	com/tencent/mobileqq/apollo/process/CmGameUtil:c	()Z
    //   67: ifne +9 -> 76
    //   70: invokestatic 174	com/tencent/mobileqq/apollo/process/CmGameUtil:d	()Z
    //   73: ifne +19 -> 92
    //   76: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +12 -> 91
    //   82: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: iconst_2
    //   86: ldc 176
    //   88: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: return
    //   92: aload_0
    //   93: getfield 45	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   96: iconst_0
    //   97: invokevirtual 296	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   100: aload_0
    //   101: getfield 36	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:b	Ljava/util/Map;
    //   104: iload_1
    //   105: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokeinterface 75 2 0
    //   113: checkcast 77	java/util/List
    //   116: astore 4
    //   118: aload_0
    //   119: getfield 38	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:c	Ljava/util/Map;
    //   122: iload_1
    //   123: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: invokeinterface 75 2 0
    //   131: checkcast 233	android/media/MediaPlayer
    //   134: astore_3
    //   135: aload_3
    //   136: ifnonnull +35 -> 171
    //   139: aload 4
    //   141: ifnull +13 -> 154
    //   144: aload 4
    //   146: invokeinterface 344 1 0
    //   151: ifeq +20 -> 171
    //   154: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -66 -> 91
    //   160: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   163: iconst_2
    //   164: ldc_w 346
    //   167: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: return
    //   171: invokestatic 242	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   174: iconst_1
    //   175: invokestatic 247	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   178: pop
    //   179: aload_0
    //   180: getfield 47	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   183: astore_2
    //   184: aload_2
    //   185: monitorenter
    //   186: aload 4
    //   188: ifnull +65 -> 253
    //   191: aload 4
    //   193: invokeinterface 304 1 0
    //   198: astore 4
    //   200: aload 4
    //   202: invokeinterface 309 1 0
    //   207: ifeq +46 -> 253
    //   210: aload 4
    //   212: invokeinterface 313 1 0
    //   217: checkcast 233	android/media/MediaPlayer
    //   220: astore 5
    //   222: aload 5
    //   224: ifnull -24 -> 200
    //   227: aload 5
    //   229: invokevirtual 273	android/media/MediaPlayer:start	()V
    //   232: goto -32 -> 200
    //   235: astore_3
    //   236: aload_2
    //   237: monitorexit
    //   238: aload_3
    //   239: athrow
    //   240: astore_2
    //   241: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   244: iconst_1
    //   245: ldc_w 348
    //   248: aload_2
    //   249: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: return
    //   253: aload_2
    //   254: monitorexit
    //   255: aload_3
    //   256: ifnull -165 -> 91
    //   259: aload_3
    //   260: invokevirtual 273	android/media/MediaPlayer:start	()V
    //   263: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	ApolloGameMusicPlayer
    //   0	264	1	paramInt	int
    //   46	191	2	localObject1	Object
    //   240	14	2	localException	java.lang.Exception
    //   134	2	3	localMediaPlayer1	MediaPlayer
    //   235	25	3	localObject2	Object
    //   116	95	4	localObject3	Object
    //   220	8	5	localMediaPlayer2	MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   191	200	235	finally
    //   200	222	235	finally
    //   227	232	235	finally
    //   236	238	235	finally
    //   253	255	235	finally
    //   179	186	240	java/lang/Exception
    //   238	240	240	java/lang/Exception
    //   259	263	240	java/lang/Exception
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], path:", paramString, ",gameId:", Integer.valueOf(paramInt1) });
    }
    Object localObject1 = (List)this.b.get(Integer.valueOf(paramInt1));
    paramString = this.jdField_a_of_type_JavaLangObject;
    if (localObject1 != null) {}
    try
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MediaPlayer localMediaPlayer = (MediaPlayer)((Iterator)localObject1).next();
        if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt2))
        {
          AudioUtil.a(BaseApplicationImpl.getContext(), true);
          localMediaPlayer.start();
          return;
        }
      }
      paramString = (MediaPlayer)this.c.get(Integer.valueOf(paramInt1));
      if ((paramString != null) && (paramString.hashCode() == paramInt2))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        paramString.start();
        return;
      }
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onDestroy],gameId:", Integer.valueOf(paramInt) });
    }
    AudioUtil.a(BaseApplicationImpl.getContext(), false);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    List localList = (List)this.b.get(Integer.valueOf(paramInt));
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (localList != null)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if (localMediaPlayer != null)
          {
            localMediaPlayer.stop();
            localMediaPlayer.release();
          }
        }
        if (!QLog.isColorLevel()) {
          break label153;
        }
      }
      finally {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop front music.");
      label153:
      localObject2.clear();
      this.b.remove(Integer.valueOf(paramInt));
    }
    localObject1 = (MediaPlayer)this.c.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "stop back music.");
      }
      ((MediaPlayer)localObject1).stop();
      ((MediaPlayer)localObject1).release();
      this.c.remove(Integer.valueOf(paramInt));
    }
  }
  
  /* Error */
  public void c(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: getstatic 18	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: iconst_4
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w 370
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_3
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc 157
    //   28: aastore
    //   29: dup
    //   30: iconst_3
    //   31: iload_1
    //   32: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: getfield 36	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:b	Ljava/util/Map;
    //   43: iload_1
    //   44: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokeinterface 75 2 0
    //   52: checkcast 77	java/util/List
    //   55: astore 4
    //   57: aload_0
    //   58: getfield 47	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   61: astore_3
    //   62: aload_3
    //   63: monitorenter
    //   64: aload 4
    //   66: ifnull +152 -> 218
    //   69: iload_1
    //   70: sipush -10000
    //   73: if_icmpne +69 -> 142
    //   76: aload 4
    //   78: invokeinterface 323 1 0
    //   83: ifle +56 -> 139
    //   86: aload 4
    //   88: iconst_0
    //   89: invokeinterface 373 2 0
    //   94: checkcast 233	android/media/MediaPlayer
    //   97: astore 5
    //   99: aload 5
    //   101: invokevirtual 286	android/media/MediaPlayer:stop	()V
    //   104: aload 5
    //   106: invokevirtual 357	android/media/MediaPlayer:release	()V
    //   109: aload 4
    //   111: aload 5
    //   113: invokeinterface 127 2 0
    //   118: pop
    //   119: goto -43 -> 76
    //   122: astore 4
    //   124: aload_3
    //   125: monitorexit
    //   126: aload 4
    //   128: athrow
    //   129: astore 6
    //   131: aload 6
    //   133: invokevirtual 376	java/lang/IllegalStateException:printStackTrace	()V
    //   136: goto -32 -> 104
    //   139: aload_3
    //   140: monitorexit
    //   141: return
    //   142: aload 4
    //   144: invokeinterface 304 1 0
    //   149: astore 5
    //   151: aload 5
    //   153: invokeinterface 309 1 0
    //   158: ifeq +60 -> 218
    //   161: aload 5
    //   163: invokeinterface 313 1 0
    //   168: checkcast 233	android/media/MediaPlayer
    //   171: astore 6
    //   173: aload 6
    //   175: ifnull -24 -> 151
    //   178: aload 6
    //   180: invokevirtual 228	java/lang/Object:hashCode	()I
    //   183: iload_2
    //   184: if_icmpne -33 -> 151
    //   187: invokestatic 242	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   190: iconst_0
    //   191: invokestatic 247	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   194: pop
    //   195: aload 4
    //   197: aload 6
    //   199: invokeinterface 127 2 0
    //   204: pop
    //   205: aload 6
    //   207: invokevirtual 286	android/media/MediaPlayer:stop	()V
    //   210: aload 6
    //   212: invokevirtual 357	android/media/MediaPlayer:release	()V
    //   215: aload_3
    //   216: monitorexit
    //   217: return
    //   218: aload_3
    //   219: monitorexit
    //   220: aload_0
    //   221: getfield 38	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:c	Ljava/util/Map;
    //   224: iload_1
    //   225: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: invokeinterface 75 2 0
    //   233: checkcast 233	android/media/MediaPlayer
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +33 -> 271
    //   241: aload_3
    //   242: invokevirtual 228	java/lang/Object:hashCode	()I
    //   245: iload_2
    //   246: if_icmpne +25 -> 271
    //   249: aload_3
    //   250: invokevirtual 286	android/media/MediaPlayer:stop	()V
    //   253: aload_3
    //   254: invokevirtual 357	android/media/MediaPlayer:release	()V
    //   257: aload_0
    //   258: getfield 38	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:c	Ljava/util/Map;
    //   261: iload_1
    //   262: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokeinterface 364 2 0
    //   270: pop
    //   271: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	ApolloGameMusicPlayer
    //   0	272	1	paramInt1	int
    //   0	272	2	paramInt2	int
    //   0	272	3	paramString	String
    //   55	55	4	localList	List
    //   122	74	4	localObject1	Object
    //   97	65	5	localObject2	Object
    //   129	3	6	localIllegalStateException	java.lang.IllegalStateException
    //   171	40	6	localMediaPlayer	MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   76	99	122	finally
    //   99	104	122	finally
    //   104	119	122	finally
    //   124	126	122	finally
    //   131	136	122	finally
    //   139	141	122	finally
    //   142	151	122	finally
    //   151	173	122	finally
    //   178	217	122	finally
    //   218	220	122	finally
    //   99	104	129	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */