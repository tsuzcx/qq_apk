package com.tencent.mobileqq.apollo.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.HardwareInfo;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.apollo.process.sso.CmGameSSoHandler;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class CmGameUtil
{
  public static int a()
  {
    return CmGameServerQIPCModule.a().a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    do
    {
      return 1;
      if (paramInt == 2) {
        return 8;
      }
    } while (paramInt != 3);
    return 0;
  }
  
  public static int a(long paramLong)
  {
    CmGameLauncher localCmGameLauncher = b(paramLong);
    if (localCmGameLauncher == null) {
      return -1;
    }
    return localCmGameLauncher.a();
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("cmshowgame_module");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ApolloSurfaceView a()
  {
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((CmGameManager)localObject).a();
    } while (localObject == null);
    return ((CmGameLauncher)localObject).a();
  }
  
  public static ApolloCmdChannel a()
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager != null) {
      return localCmGameManager.a();
    }
    return null;
  }
  
  public static CmGameLauncher a()
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a();
  }
  
  public static CmGameLauncher a(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramInt);
  }
  
  public static CmGameLauncher a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getRenderByThreadId();
    if ((localApolloRender == null) || (localApolloRender.getSavaWrapper() == null))
    {
      QLog.w("cmgame_process.CmGameUtil", 1, "render is null.");
      return null;
    }
    return b(localApolloRender.getSavaWrapper().a());
  }
  
  public static CmGameMainManager a()
  {
    int i = a();
    if (-1 == i) {}
    CmGameLifeCycle localCmGameLifeCycle;
    do
    {
      return null;
      localCmGameLifeCycle = CmGameServerQIPCModule.a().a(i);
    } while (localCmGameLifeCycle == null);
    return localCmGameLifeCycle.a();
  }
  
  public static CmGameManager a()
  {
    AppInterface localAppInterface = a();
    if ((localAppInterface instanceof CmGameAppInterface)) {
      return (CmGameManager)((CmGameAppInterface)localAppInterface).getManager(255);
    }
    return null;
  }
  
  public static CmGameOpenIdFinder a(int paramInt)
  {
    CmGameLauncher localCmGameLauncher = a(paramInt);
    if (localCmGameLauncher != null) {
      return localCmGameLauncher.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static CmGameOpenIdFinder a(long paramLong)
  {
    CmGameLauncher localCmGameLauncher = b(paramLong);
    if (localCmGameLauncher != null) {
      return localCmGameLauncher.a();
    }
    QLog.w("cmgame_process.CmGameUtil", 1, "CmGameOpenIdFinder is nulllll.");
    return null;
  }
  
  public static CmGameSSoHandler a()
  {
    try
    {
      Object localObject = a();
      if ((localObject != null) && ((localObject instanceof CmGameAppInterface)))
      {
        localObject = (CmGameSSoHandler)((AppInterface)localObject).getBusinessHandler(0);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
      return null;
    }
    return null;
  }
  
  /* Error */
  public static String a(CmGameInitParams paramCmGameInitParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 137
    //   6: areturn
    //   7: new 139	org/json/JSONObject
    //   10: dup
    //   11: invokespecial 140	org/json/JSONObject:<init>	()V
    //   14: astore 5
    //   16: aload 5
    //   18: ldc 142
    //   20: aload_0
    //   21: getfield 148	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mRoomId	J
    //   24: invokestatic 154	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   27: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: ldc 160
    //   33: aload_0
    //   34: getfield 164	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameName	Ljava/lang/String;
    //   37: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne +15 -> 55
    //   43: ldc 170
    //   45: aload_0
    //   46: getfield 164	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameName	Ljava/lang/String;
    //   49: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +342 -> 394
    //   55: aload 5
    //   57: ldc 172
    //   59: aload_0
    //   60: getfield 164	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameName	Ljava/lang/String;
    //   63: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload 5
    //   69: ldc 174
    //   71: aload_0
    //   72: getfield 177	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mVersion	Ljava/lang/String;
    //   75: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload 5
    //   81: ldc 179
    //   83: ldc 181
    //   85: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload 5
    //   91: ldc 183
    //   93: ldc 185
    //   95: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: getstatic 190	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   102: iconst_0
    //   103: invokevirtual 196	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   106: ifeq +329 -> 435
    //   109: getstatic 199	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo	Lcom/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo;
    //   112: ifnull +323 -> 435
    //   115: aload 5
    //   117: ldc 201
    //   119: getstatic 199	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo	Lcom/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo;
    //   122: getfield 205	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo:jdField_b_of_type_Long	J
    //   125: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 5
    //   131: ldc 210
    //   133: getstatic 199	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine:jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo	Lcom/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo;
    //   136: getfield 213	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo:jdField_c_of_type_Long	J
    //   139: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   142: pop
    //   143: aload 5
    //   145: ldc 215
    //   147: getstatic 217	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload 5
    //   156: ldc 219
    //   158: getstatic 221	com/tencent/mobileqq/apollo/game/ApolloGameStateMachine$HardwareInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload_0
    //   166: getfield 224	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:openId	Ljava/lang/String;
    //   169: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +15 -> 187
    //   175: aload 5
    //   177: ldc 231
    //   179: aload_0
    //   180: getfield 224	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:openId	Ljava/lang/String;
    //   183: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload_0
    //   188: getfield 234	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameParam	Ljava/lang/String;
    //   191: astore 4
    //   193: aload 4
    //   195: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +59 -> 257
    //   201: aload 4
    //   203: ldc 236
    //   205: invokevirtual 239	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   208: istore_2
    //   209: aload 4
    //   211: astore_3
    //   212: iload_2
    //   213: ifeq +35 -> 248
    //   216: new 139	org/json/JSONObject
    //   219: dup
    //   220: aload 4
    //   222: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   225: astore 6
    //   227: aload 4
    //   229: astore_3
    //   230: aload 6
    //   232: ldc 236
    //   234: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   237: ifeq +11 -> 248
    //   240: aload 6
    //   242: ldc 236
    //   244: invokevirtual 250	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore_3
    //   248: aload 5
    //   250: ldc 252
    //   252: aload_3
    //   253: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 5
    //   259: ldc 254
    //   261: aload_0
    //   262: getfield 258	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mSrc	I
    //   265: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 5
    //   271: ldc_w 263
    //   274: invokestatic 267	com/tencent/mobileqq/apollo/utils/ApolloGameBasicEventUtil:b	()I
    //   277: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: invokestatic 271	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: ldc_w 273
    //   287: iconst_0
    //   288: invokevirtual 279	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   291: astore_3
    //   292: aload_3
    //   293: ifnull +242 -> 535
    //   296: aload_3
    //   297: new 281	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 284
    //   307: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: getfield 164	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameName	Ljava/lang/String;
    //   314: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 291	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mSelfUin	Ljava/lang/String;
    //   321: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: iconst_0
    //   328: invokeinterface 301 3 0
    //   333: istore_2
    //   334: aload_0
    //   335: getfield 304	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameMode	I
    //   338: iconst_1
    //   339: if_icmpeq +11 -> 350
    //   342: aload_0
    //   343: getfield 304	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameMode	I
    //   346: iconst_2
    //   347: if_icmpne +156 -> 503
    //   350: aload 5
    //   352: ldc_w 306
    //   355: iconst_1
    //   356: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   359: pop
    //   360: goto +180 -> 540
    //   363: aload 5
    //   365: ldc_w 308
    //   368: iload_1
    //   369: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload 5
    //   375: ldc_w 310
    //   378: aload_0
    //   379: getfield 313	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:gender	I
    //   382: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload 5
    //   388: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   391: astore_0
    //   392: aload_0
    //   393: areturn
    //   394: aload 5
    //   396: ldc 172
    //   398: aload_0
    //   399: getfield 164	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mGameName	Ljava/lang/String;
    //   402: invokestatic 320	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   405: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: goto -342 -> 67
    //   412: astore_3
    //   413: aload_3
    //   414: invokevirtual 323	java/lang/Exception:printStackTrace	()V
    //   417: goto -350 -> 67
    //   420: astore_0
    //   421: ldc 81
    //   423: iconst_2
    //   424: aload_0
    //   425: invokevirtual 326	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: ldc_w 330
    //   434: areturn
    //   435: aload 5
    //   437: ldc 201
    //   439: invokestatic 335	android/os/Process:myPid	()I
    //   442: invokestatic 340	com/tencent/mobileqq/utils/DeviceInfoUtil:a	(I)J
    //   445: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload 5
    //   451: ldc 210
    //   453: invokestatic 343	com/tencent/mobileqq/utils/DeviceInfoUtil:g	()J
    //   456: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   459: pop
    //   460: aload 5
    //   462: ldc 215
    //   464: invokestatic 346	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()Ljava/lang/String;
    //   467: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: aload 5
    //   473: ldc 219
    //   475: invokestatic 349	com/tencent/mobileqq/utils/DeviceInfoUtil:j	()Ljava/lang/String;
    //   478: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: goto -317 -> 165
    //   485: astore_3
    //   486: ldc 81
    //   488: iconst_1
    //   489: aload_3
    //   490: iconst_0
    //   491: anewarray 4	java/lang/Object
    //   494: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   497: aload 4
    //   499: astore_3
    //   500: goto -252 -> 248
    //   503: aload_0
    //   504: getfield 353	com/tencent/mobileqq/apollo/process/data/CmGameInitParams:mIsMaster	Z
    //   507: ifeq +18 -> 525
    //   510: iconst_1
    //   511: istore_1
    //   512: aload 5
    //   514: ldc_w 306
    //   517: iload_1
    //   518: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   521: pop
    //   522: goto +18 -> 540
    //   525: iconst_0
    //   526: istore_1
    //   527: goto -15 -> 512
    //   530: iconst_1
    //   531: istore_1
    //   532: goto -169 -> 363
    //   535: iconst_1
    //   536: istore_2
    //   537: goto -203 -> 334
    //   540: iload_2
    //   541: ifeq -11 -> 530
    //   544: iconst_0
    //   545: istore_1
    //   546: goto -183 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	paramCmGameInitParams	CmGameInitParams
    //   368	178	1	i	int
    //   208	333	2	bool	boolean
    //   211	86	3	localObject	Object
    //   412	2	3	localException	Exception
    //   485	5	3	localThrowable	Throwable
    //   499	1	3	str1	String
    //   191	307	4	str2	String
    //   14	499	5	localJSONObject1	JSONObject
    //   225	16	6	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   394	409	412	java/lang/Exception
    //   7	55	420	java/lang/Exception
    //   55	67	420	java/lang/Exception
    //   67	165	420	java/lang/Exception
    //   165	187	420	java/lang/Exception
    //   187	209	420	java/lang/Exception
    //   216	227	420	java/lang/Exception
    //   230	248	420	java/lang/Exception
    //   248	257	420	java/lang/Exception
    //   257	292	420	java/lang/Exception
    //   296	334	420	java/lang/Exception
    //   334	350	420	java/lang/Exception
    //   350	360	420	java/lang/Exception
    //   363	392	420	java/lang/Exception
    //   413	417	420	java/lang/Exception
    //   435	482	420	java/lang/Exception
    //   486	497	420	java/lang/Exception
    //   503	510	420	java/lang/Exception
    //   512	522	420	java/lang/Exception
    //   216	227	485	java/lang/Throwable
    //   230	248	485	java/lang/Throwable
  }
  
  public static void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      QLog.w("cmgame_process.CmGameUtil", 1, "fail to close game, gameId:" + paramInt);
    }
    do
    {
      return;
      localObject = ((CmGameLauncher)localObject).a();
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "success to close game, gameId:" + paramInt);
    }
    ((Activity)localObject).finish();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QLog.i("cmgame_process.CmGameUtil", 1, "[sendActLifeCycleIpc], gameId:" + paramInt2 + ",status:" + paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", paramInt1);
    localBundle.putInt("gameId", paramInt2);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "game_activity_lifecycle", localBundle, null);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    try
    {
      localObject = a(paramInt);
      if (localObject == null) {
        return;
      }
      localObject = ((CmGameLauncher)localObject).a();
      if (localObject == null)
      {
        QLog.w("cmgame_process.CmGameUtil", 1, "CmGameInitParams is null.");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, paramContext, new Object[0]);
      return;
    }
    if ((paramContext instanceof ApolloGameActivity)) {
      ((ApolloGameActivity)paramContext).moveTaskToBack(true);
    }
    paramInt = ((CmGameStartChecker.StartCheckParam)localObject).enter;
    Object localObject = new Intent(paramContext, SplashActivity.class);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 7))
    {
      ((Intent)localObject).putExtra("fragment_id", 2);
      for (;;)
      {
        ((Intent)localObject).putExtra("fromApollo", 1);
        ((Intent)localObject).setFlags(67174400);
        paramContext.startActivity((Intent)localObject);
        return;
        label122:
        ((Intent)localObject).putExtra("fragment_id", 1);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      break;
      if ((paramInt == 2) || (paramInt == 8)) {
        break label122;
      }
      if (paramInt != 5) {
        if (paramInt != 4) {
          break;
        }
      }
    }
  }
  
  public static void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUtil", 2, "[launchGame]");
    }
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      QLog.e("cmgame_process.CmGameUtil", 1, "[launchGame], null params.");
    }
    do
    {
      return;
      if (!a(paramStartCheckParam)) {
        break;
      }
      localObject = a();
    } while (localObject == null);
    Object localObject = ((CmGameManager)localObject).a();
    if (localObject != null)
    {
      Activity localActivity = ((CmGameLauncher)localObject).a();
      if (localActivity != null)
      {
        localActivity.finish();
        CmGameToolCmdChannel.a("cs.close_room.local", "{}", false, null, ((CmGameLauncher)localObject).a());
        QLog.i("cmgame_process.CmGameUtil", 1, "finish old act.");
      }
    }
    localObject = new Intent(BaseApplicationImpl.getApplication(), ApolloGameActivity.class);
    ((Intent)localObject).putExtra("extra_startcheckparam", paramStartCheckParam);
    ((Intent)localObject).addFlags(268435456);
    BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!a()) {}
    CmGameSSoHandler localCmGameSSoHandler;
    do
    {
      do
      {
        return;
      } while (!"apollo_aio_game.cancel_game_room".equals(paramString1));
      localCmGameSSoHandler = a();
    } while (localCmGameSSoHandler == null);
    localCmGameSSoHandler.a(paramString1, paramString2, -1L, 4);
  }
  
  public static boolean a()
  {
    AppInterface localAppInterface = a();
    return (localAppInterface != null) && ((localAppInterface instanceof CmGameAppInterface));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1000;
  }
  
  public static boolean a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {}
    Object localObject;
    CmGameLauncher localCmGameLauncher;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = a();
        } while (localObject == null);
        localCmGameLauncher = ((CmGameManager)localObject).c(paramStartCheckParam.game.gameId);
        if (localCmGameLauncher != null) {
          break;
        }
      } while (((CmGameManager)localObject).a() == null);
      return true;
      localObject = localCmGameLauncher.a();
      if (paramStartCheckParam.launchNewGame) {
        return true;
      }
    } while ((localCmGameLauncher.a() == paramStartCheckParam.game.gameId) && ((paramStartCheckParam.roomId == 0L) || (paramStartCheckParam.roomId == ((ApolloPanel.GameMsgInfo)localObject).jdField_b_of_type_Long)));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramStartCheckParam.gameId);
    if (localObject == null)
    {
      ApolloItemBuilder.a("游戏数据更新中，请稍后再试", 2, BaseApplicationImpl.getContext());
      ApolloContentUpdateHandler.a(paramQQAppInterface, 2);
      return false;
    }
    ApolloManager localApolloManager = (ApolloManager)paramQQAppInterface.getManager(152);
    if (localApolloManager != null)
    {
      paramStartCheckParam.game = ((ApolloGameData)localObject);
      paramStartCheckParam.version = localApolloManager.a(paramStartCheckParam.gameId);
      localObject = paramQQAppInterface.getCurrentAccountUin();
      paramStartCheckParam.isWhiteUsr = localApolloManager.b((String)localObject);
      paramStartCheckParam.apolloStatus = localApolloManager.b((String)localObject);
    }
    paramStartCheckParam.mGameType = ApolloGameUtil.a(paramStartCheckParam.game.gameId);
    int i = ((ApolloGameManager)paramQQAppInterface.getManager(210)).a(paramStartCheckParam.game.gameId, paramStartCheckParam.mGameType);
    if (i != -1) {
      paramStartCheckParam.game.viewMode = i;
    }
    paramStartCheckParam.gender = ((NearbyCardManager)paramQQAppInterface.getManager(105)).b();
    return true;
  }
  
  public static CmGameLauncher b(int paramInt)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.b(paramInt);
  }
  
  public static CmGameLauncher b(long paramLong)
  {
    CmGameManager localCmGameManager = a();
    if (localCmGameManager == null) {
      return null;
    }
    return localCmGameManager.a(paramLong);
  }
  
  public static String b(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = ApolloGameBasicEventUtil.a(0, ApolloResDownloader.a);
        if (localJSONObject1 == null)
        {
          QLog.e("cmgame_process.CmGameUtil", 1, "json is null");
          return "{}";
        }
        localJSONObject1.put("roomId", String.valueOf(paramCmGameInitParams.mRoomId));
        localJSONObject1.put("svrIp", paramCmGameInitParams.mServerIp);
        localJSONObject1.put("port", paramCmGameInitParams.mPort);
        localJSONObject1.put("spriteDesignHeight", 368);
        if (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))
        {
          localJSONObject1.put("gameId", paramCmGameInitParams.mGameName);
          if ((!ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) || (ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo == null)) {
            break label844;
          }
          localJSONObject1.put("freeMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_b_of_type_Long);
          localJSONObject1.put("totalMemory", ApolloGameStateMachine.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameStateMachine$HardwareInfo.jdField_c_of_type_Long);
          localJSONObject1.put("osVersion", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_JavaLangString);
          localJSONObject1.put("model", ApolloGameStateMachine.HardwareInfo.jdField_b_of_type_JavaLangString);
          localJSONObject1.put("cpuType", ApolloGameStateMachine.HardwareInfo.jdField_c_of_type_JavaLangString);
          localJSONObject1.put("cpuNumber", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Int);
          localJSONObject1.put("cpuFrequency", ApolloGameStateMachine.HardwareInfo.jdField_a_of_type_Long);
          localJSONObject1.put("gameVersion", paramCmGameInitParams.mVersion);
          localJSONObject1.put("QQVer", "7.6.0.3525");
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("gameMode", paramCmGameInitParams.mGameMode);
          if (!TextUtils.isEmpty(paramCmGameInitParams.openId)) {
            localJSONObject1.put("openId", paramCmGameInitParams.openId);
          }
          str2 = paramCmGameInitParams.mGameParam;
          if (!TextUtils.isEmpty(str2))
          {
            bool1 = str2.contains("extendInfo");
            localObject = str2;
            if (!bool1) {}
          }
        }
      }
      catch (Exception paramCmGameInitParams)
      {
        Object localObject;
        JSONObject localJSONObject2;
        QLog.e("cmgame_process.CmGameUtil", 2, paramCmGameInitParams.getMessage());
        return "{}";
      }
      try
      {
        localJSONObject2 = new JSONObject(str2);
        localObject = str2;
        if (localJSONObject2.has("extendInfo")) {
          localObject = localJSONObject2.optString("extendInfo");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUtil", 1, localThrowable, new Object[0]);
        String str1 = str2;
        continue;
        if (TextUtils.isEmpty(paramCmGameInitParams.mSessionId)) {
          continue;
        }
        localJSONObject1.put("sessionId", paramCmGameInitParams.sessionOpenId);
        continue;
        localJSONObject1.put("aioType", paramCmGameInitParams.mSessionType);
        if (!paramCmGameInitParams.mIsMaster) {
          break label1025;
        }
        for (i = 1;; i = 0)
        {
          localJSONObject1.put("isMaster", i);
          localJSONObject1.put("sessionId", paramCmGameInitParams.sessionOpenId);
          break;
        }
        bool2 = false;
        bool1 = true;
        if (!bool1) {
          break label1051;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      localJSONObject1.put("gameParam", localObject);
      if (!paramCmGameInitParams.isWhiteUsr) {
        break label1046;
      }
      i = 1;
      localJSONObject1.put("isWhiteUser", i);
      localJSONObject1.put("extInfo", paramCmGameInitParams.extInfoFromSvr);
      localJSONObject1.put("src", paramCmGameInitParams.mSrc);
      localJSONObject1.put("networkType", ApolloGameBasicEventUtil.b());
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      if (localObject == null) {
        break label1030;
      }
      bool1 = ((SharedPreferences)localObject).getBoolean("is_ever_play_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false);
      bool2 = ((SharedPreferences)localObject).getBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, true);
      if (!bool2) {
        break label1037;
      }
      ((SharedPreferences)localObject).edit().putBoolean("is_first_install_cmgame" + paramCmGameInitParams.mGameName + paramCmGameInitParams.mSelfUin, false).commit();
      break label1037;
      localJSONObject1.put("isFirstPlay", i);
      localJSONObject1.put("isFirstInstall", bool2);
      if ((paramCmGameInitParams.mGameMode != 1) && (paramCmGameInitParams.mGameMode != 2)) {
        break label977;
      }
      localJSONObject1.put("aioType", 1);
      localJSONObject1.put("isMaster", 1);
      if (TextUtils.isEmpty(paramCmGameInitParams.mFriendUin)) {
        break;
      }
      localJSONObject1.put("sessionId", paramCmGameInitParams.mFriendUin);
      if ((!TextUtils.isEmpty(paramCmGameInitParams.mExtraStr)) && (("1".equals(paramCmGameInitParams.mGameName)) || ("2".equals(paramCmGameInitParams.mGameName)))) {
        localJSONObject1.put("extraStr", paramCmGameInitParams.mExtraStr);
      }
      localJSONObject1.put("sex", paramCmGameInitParams.gender);
      localJSONObject1.put("apolloStatus", paramCmGameInitParams.apolloStatus);
      QLog.i("cmgame_process.CmGameUtil", 1, "gameId:" + paramCmGameInitParams.mGameName + ",gameMode:" + paramCmGameInitParams.mGameMode + ",src:" + paramCmGameInitParams.mSrc + ",roomId:" + paramCmGameInitParams.mRoomId);
      paramCmGameInitParams = localJSONObject1.toString();
      return paramCmGameInitParams;
      try
      {
        localJSONObject1.put("gameId", Integer.parseInt(paramCmGameInitParams.mGameName));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      label844:
      localJSONObject1.put("freeMemory", DeviceInfoUtil.a(Process.myPid()));
      localJSONObject1.put("totalMemory", DeviceInfoUtil.g());
      localJSONObject1.put("osVersion", DeviceInfoUtil.f());
      localJSONObject1.put("model", DeviceInfoUtil.j());
      localJSONObject1.put("cpuType", DeviceInfoUtil.h());
      localJSONObject1.put("cpuNumber", DeviceInfoUtil.b());
      localJSONObject1.put("cpuFrequency", DeviceInfoUtil.a());
    }
  }
  
  public static boolean b()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getRingerMode();
        if (i == 1) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("cmgame_process.CmGameUtil", 1, "isRingerVibrate error: " + localThrowable.getMessage());
    }
    return false;
  }
  
  public static boolean c()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public static boolean d()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameUtil
 * JD-Core Version:    0.7.0.1
 */