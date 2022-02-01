package com.tencent.av.redpacket;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.AVRedPacketConfig.ExpressionInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import lfx;
import lgp;
import lph;
import ltp;
import ltq;
import ltr;
import lts;
import ltu;
import ltx;
import ltz;
import lua;
import lub;
import lud;
import moo;
import mos;
import mqa;
import mqb;
import mqh;
import mqj;
import mqx;

public class AVRedPacketManager
  extends lgp
  implements Handler.Callback
{
  public static int a;
  public static long a;
  public static int b;
  public static long b;
  static final String jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/expressionimg/";
  public static int c;
  public static long c;
  public static int d;
  public static long d;
  public static int e;
  public static long e;
  public static int f;
  public static long f;
  public static long g;
  public Bitmap a;
  public Handler a;
  public AVRedPacketManager.GameStateInfo a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<RedPacketShareFragment> jdField_a_of_type_JavaLangRefWeakReference;
  public List<ltq> a;
  public ltq a;
  public ltu a;
  public ltz a;
  public lua a;
  public lub a;
  lud jdField_a_of_type_Lud = new lud();
  public boolean a;
  public Handler b;
  public ltq b;
  boolean jdField_b_of_type_Boolean = false;
  final String c;
  public volatile boolean c;
  String d;
  public int g;
  int h = 0;
  int i = 0;
  int j;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 1080;
    jdField_f_of_type_Int = 10;
    jdField_a_of_type_Long = 25000L;
    jdField_b_of_type_Long = 50000L;
    jdField_c_of_type_Long = 10000L;
    jdField_d_of_type_Long = 5000L;
    jdField_e_of_type_Long = 5000L;
    jdField_f_of_type_Long = 2000L;
    jdField_g_of_type_Long = 3000L;
  }
  
  public AVRedPacketManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lua = new ltx(this);
    this.jdField_c_of_type_JavaLangString = "https://task.qq.com/index.php/opapi/reportCollectData";
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    paramVideoAppInterface = moo.a();
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if ((paramVideoAppInterface.jdField_g_of_type_Int == 1) && (!mos.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Lub = new lub(localVideoAppInterface, bool);
      this.jdField_a_of_type_Lub.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      return;
      bool = false;
    }
  }
  
  public static int a(int paramInt)
  {
    int k = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "getMirrorEmojiType, inputType = " + paramInt + ",result = " + k);
      }
      return k;
      k = 0;
      continue;
      k = 1;
      continue;
      k = 3;
      continue;
      k = 2;
      continue;
      k = 5;
      continue;
      k = 4;
      continue;
      k = 7;
      continue;
      k = 6;
      continue;
      k = 8;
      continue;
      k = 9;
    }
  }
  
  public static ArrayList<Integer> a(List<Integer> paramList, int paramInt)
  {
    int k = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(paramList);
    ArrayList localArrayList3 = new ArrayList(paramList);
    int m = paramList.size();
    Collections.shuffle(localArrayList2);
    Collections.shuffle(localArrayList3);
    while (localArrayList2.get(m - 1) == localArrayList3.get(0)) {
      Collections.shuffle(localArrayList3);
    }
    ArrayList localArrayList4 = new ArrayList();
    localArrayList4.addAll(localArrayList2);
    localArrayList4.addAll(localArrayList3);
    while (k < paramInt)
    {
      localArrayList1.add(localArrayList4.get(k));
      k += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "getRandomList totalCount = " + paramInt + ",inputList = " + paramList + ",result = " + localArrayList1);
    }
    return localArrayList1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (!a(true)) {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateHitInfo, invalid");
      }
    }
    AVRedPacketManager.GameStateInfo localGameStateInfo;
    AVRedPacketManager.LocalFrameSyncInfo localLocalFrameSyncInfo;
    AVRedPacketManager.LocalHitInfo localLocalHitInfo;
    boolean bool;
    do
    {
      return;
      localGameStateInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
      localLocalFrameSyncInfo = localGameStateInfo.currLocalFrameSyncInfo;
      localLocalHitInfo = localLocalFrameSyncInfo.localHitInfo;
      bool = localLocalFrameSyncInfo.hasHitedEmojiIds.contains(Integer.valueOf(paramInt1));
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "__debug__ updateHitInfo, id=" + paramInt1 + ",hitType=" + paramInt3 + ",hasHit=" + bool);
      }
    } while (bool);
    lts.a(paramInt1, paramInt2, paramInt3, paramFloat, this.h, this.i);
    paramInt2 = 0;
    localLocalHitInfo.emojiId = paramInt1;
    if (paramInt3 == 3)
    {
      localLocalHitInfo.topWordTipType = 3;
      localLocalHitInfo.newAddScore = 0;
      localGameStateInfo.curCommCnt = 0;
      localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
      localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
      localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
      paramInt2 = 0;
      this.h = 0;
      this.i = 0;
    }
    do
    {
      if (paramInt2 != 0) {
        localLocalFrameSyncInfo.hasHitedEmojiIds.add(Integer.valueOf(paramInt1));
      }
      localLocalHitInfo.hitStartTime = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateHitInfo,set needDetectFace false; mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
      }
      a(true, 1010, 0L, localLocalFrameSyncInfo);
      return;
      if (paramInt3 == 2)
      {
        localLocalHitInfo.topWordTipType = 2;
        localGameStateInfo.curCommCnt += 1;
        if (localGameStateInfo.curCommCnt >= 3) {}
        for (localLocalHitInfo.newAddScore = 90;; localLocalHitInfo.newAddScore = 80)
        {
          localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
          localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
          localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
          paramInt2 = 1;
          break;
        }
      }
    } while ((paramInt3 != 1) && (paramInt3 != 4));
    localLocalHitInfo.topWordTipType = paramInt3;
    localGameStateInfo.curCommCnt += 1;
    if (localGameStateInfo.curCommCnt >= 3) {
      if (localGameStateInfo.curScore + 110 >= jdField_e_of_type_Int) {
        localLocalHitInfo.newAddScore = 90;
      }
    }
    for (;;)
    {
      localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
      localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
      localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
      paramInt2 = 1;
      break;
      localLocalHitInfo.newAddScore = 110;
      continue;
      localLocalHitInfo.newAddScore = 100;
    }
  }
  
  private void a(AVRedPacketManager.GameInfoFromBusiServer paramGameInfoFromBusiServer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGameStartSuccFromServer");
    }
    if (!a(true)) {}
    mqa localmqa;
    int m;
    do
    {
      AVRedPacketManager.GameStateInfo localGameStateInfo;
      do
      {
        return;
        localGameStateInfo = new AVRedPacketManager.GameStateInfo(paramGameInfoFromBusiServer.key, 2, paramGameInfoFromBusiServer.sendRedPacketUin, paramGameInfoFromBusiServer.receiveRedPacketUin);
        localGameStateInfo.authKey = paramGameInfoFromBusiServer.authKey;
        paramGameInfoFromBusiServer = new ArrayList();
        localmqa = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      } while ((localmqa == null) || (localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null));
      ArrayList localArrayList = a(localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionIDList, localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionCount);
      m = localArrayList.size();
      if (m == localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionCount)
      {
        int k = 0;
        while (k < m)
        {
          AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = new AVRedPacketManager.LocalEmojiInfo();
          localLocalEmojiInfo.emojiId = k;
          localLocalEmojiInfo.emojiType = ((Integer)localArrayList.get(k)).intValue();
          localLocalEmojiInfo.isBigEmoji = false;
          localLocalEmojiInfo.fallDownDuration = ((Integer)localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionDurationList.get(k)).intValue();
          if (k == m - 1) {
            localLocalEmojiInfo.isBigEmoji = true;
          }
          paramGameInfoFromBusiServer.add(localLocalEmojiInfo);
          k += 1;
        }
        a(localGameStateInfo, paramGameInfoFromBusiServer);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketManager", 2, "onGameStartSuccFromServer size is not equal, size = " + m + ",ExpressionCount=" + localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionCount);
  }
  
  private void a(AVRedPacketManager.GameStateInfo paramGameStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGameReadySuccFromC2C");
    }
    a(false);
    if (a(paramGameStateInfo))
    {
      this.jdField_a_of_type_Ltu.a();
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.money = paramGameStateInfo.money;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.enterType = paramGameStateInfo.enterType;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(1);
      l();
      mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, paramGameStateInfo.enterType);
      e(1);
    }
  }
  
  private boolean a(AVRedPacketManager.GameStateInfo paramGameStateInfo)
  {
    if (((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo != null) && (!this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy)) || (paramGameStateInfo == null)) {}
    for (boolean bool = false;; bool = true)
    {
      QLog.d("AVRedPacketManager", 1, "initCurrGameInfo, result=" + bool + " , currInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
      return bool;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo = new AVRedPacketManager.GameStateInfo(paramGameStateInfo);
      k();
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo == null) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy)) {
      bool = false;
    }
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("AVRedPacketManager", 2, "isCurrInfoValid, result=" + bool + ", currInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
    }
    return bool;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "deleteLocalExpressionImg");
    }
    FileUtils.deleteDirectory(jdField_b_of_type_JavaLangString);
  }
  
  private boolean e()
  {
    boolean bool = true;
    if (lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) == null) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "checkViedoHandler, result=" + bool);
    }
    return bool;
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "initMusicPlayer ,bgMusicIndex = " + paramInt);
    }
    mqa localmqa = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if (!localmqa.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "initMusicPlayer failed,config not ready");
      }
      return;
    }
    this.jdField_a_of_type_Lub.a(paramInt, localmqa);
  }
  
  private void h()
  {
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes");
    ThreadManager.post(new AVRedPacketManager.2(this), 8, null, true);
  }
  
  private void i()
  {
    QLog.d("AVRedPacketManager", 1, "cleartStateInfo");
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy = true;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "removeTimeOutMsg");
    }
    a(1018);
    a(1011);
    a(1012);
    a(1015);
    a(1016);
    a(1021);
    a(1022);
    a(1023);
  }
  
  private void k()
  {
    mqa localmqa = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if ((localmqa != null) && (localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig != null))
    {
      jdField_b_of_type_Long = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.game321MaxTimeOut;
      jdField_a_of_type_Long = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameSendRedBagMaxTimeOut;
      jdField_e_of_type_Int = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameMaxScore;
      jdField_f_of_type_Int = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.gameExpressionCount;
      jdField_g_of_type_Long = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.tipsTimeout;
    }
    QLog.d("AVRedPacketManager", 1, "initConfigValue, MAX_GAME_TIMEOUT=" + jdField_b_of_type_Long + ",COUNTDOWN_TIMEOUT=" + jdField_a_of_type_Long + ",MAX_GAME_SCORE=" + jdField_e_of_type_Int + ",MAX_EMOJI_CNT=" + jdField_f_of_type_Int + ",MAX_EMOJI_TIPS_TIME=" + jdField_g_of_type_Long + ",saveSwitch = " + false);
  }
  
  private void l()
  {
    QLog.d("AVRedPacketManager", 1, "updateFrameInfoState");
    if ((!a(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 1)
      {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3))
      {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 3;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 4);
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 4;
  }
  
  public int a()
  {
    int m = -1;
    Object localObject = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    int k = m;
    if (((mqa)localObject).jdField_c_of_type_Boolean)
    {
      localObject = new File(((mqa)localObject).jdField_b_of_type_JavaLangString).listFiles();
      k = m;
      if (localObject != null)
      {
        k = m;
        if (localObject.length > 0)
        {
          ArrayList localArrayList = new ArrayList();
          m = localObject.length;
          k = 0;
          while (k < m)
          {
            String str = localObject[k].getName();
            if ((str.startsWith("background")) && (str.endsWith(".mp3"))) {
              localArrayList.add(str);
            }
            k += 1;
          }
          k = (int)(Math.random() * localArrayList.size());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "generateBgMusicIndex, result =" + k);
    }
    return k;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Bitmap a(String paramString)
  {
    return mqx.a(paramString, true);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return mqx.a(paramString, paramBoolean);
  }
  
  public AVRedPacketManager.GameStateInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
  }
  
  public AVRedPacketManager.LocalEmojiInfo a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "addDisplayedEmoji, id=" + paramInt1 + ",eventType=" + paramInt2 + ",mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo + ",needDetectFace=" + this.jdField_c_of_type_Boolean + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
    }
    Object localObject;
    if ((!a(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "addDisplayedEmoji, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      localObject = null;
    }
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo;
          localLocalEmojiInfo = new AVRedPacketManager.LocalEmojiInfo();
          localLocalEmojiInfo.emojiId = paramInt1;
          localLocalEmojiInfo.emojiType = paramInt4;
          localLocalEmojiInfo.startTime = paramLong;
          localLocalEmojiInfo.eventType = 1;
          localLocalEmojiInfo.trackNum = paramInt3;
          localLocalEmojiInfo.isBigEmoji = paramBoolean;
          ((AVRedPacketManager.LocalFrameSyncInfo)localObject).localEmojiInfos.add(localLocalEmojiInfo);
          paramLong = NetConnInfoCenter.getServerTimeMillis();
          localObject = localLocalEmojiInfo;
        } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasEmojiTip);
        localObject = localLocalEmojiInfo;
      } while (Math.abs(paramLong - this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameStartTime) < jdField_g_of_type_Long);
      localObject = localLocalEmojiInfo;
    } while (!this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.hasHitedEmojiIds.isEmpty());
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasEmojiTip = true;
    a(true, 1005, 0L, null);
    return localLocalEmojiInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ltu = ((ltu)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    b();
  }
  
  void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "removeMessage, ,msg=" + paramInt);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((a(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1) && ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.syncSuccEmojiId.add(Integer.valueOf(paramInt1));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong2)
  {
    if (!a(false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "addDisplayedEmojiInfoDelay emojiId = " + paramInt1 + ",startTime = " + paramLong1 + ",eventType = " + paramInt2 + ",trackNum = " + paramInt3 + ",emojiType = " + paramInt4 + ",isBigEmoji = " + paramBoolean + ",delay = " + paramLong2);
    }
    a(false, 1013, paramLong2, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    QLog.d("AVRedPacketManager", 1, "sendC2CMsgGameInfo, subType: " + paramInt + ",bundle:" + paramBundle);
    this.jdField_a_of_type_Ltu.b(paramInt, paramBundle);
  }
  
  public void a(int paramInt, AVRedPacketManager.LocalEmojiInfo paramLocalEmojiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "updateFocus, id=" + paramInt);
    }
    if ((!a(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateFocus, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      return;
    }
    AVRedPacketManager.LocalFocusInfo localLocalFocusInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.localFocusInfo;
    localLocalFocusInfo.emojiId = paramInt;
    localLocalFocusInfo.mLocalEmojiInfo = paramLocalEmojiInfo;
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    QLog.d("AVRedPacketManager", 1, "syncGameInfoToBusiServer, actionType=" + paramInt1 + ",fromUin=" + paramString2 + ",key=" + paramString1 + ",currScores=" + paramInt2 + ",totalMoney=" + paramString3);
    a(1018);
    if ((!a(false)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putString("fromUin", paramString2);
    localBundle.putString("toUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localBundle.putInt("currScores", paramInt2);
    localBundle.putString("totalMoney", paramString3);
    this.jdField_a_of_type_Ltu.a(paramInt1, localBundle);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Lub.a(paramInt, paramBoolean);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(AVRedPacketManager.GameStateInfo paramGameStateInfo, List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    QLog.d("AVRedPacketManager", 1, "preStartGame");
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "__debug__ localEmojiInfos=" + paramList);
    }
    if (!a(true)) {
      return;
    }
    if ((paramGameStateInfo != null) && (!TextUtils.isEmpty(paramGameStateInfo.authKey))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.authKey = paramGameStateInfo.authKey;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos = paramList;
    a(true, 1020, 0L, null);
  }
  
  public void a(AVRedPacketManager.LocalEmojiInfo paramLocalEmojiInfo, float paramFloat, AVRedPacketConfig.ExpressionInfo paramExpressionInfo, int paramInt)
  {
    int k = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onEmojiRecognise, id=" + paramLocalEmojiInfo.emojiId + ",score=" + paramFloat + ",emojiType=" + paramLocalEmojiInfo.emojiType + ",continuousHitCount = " + this.j + ",continuousHitThreshold = " + paramInt);
    }
    if (paramFloat >= paramExpressionInfo.coolValue)
    {
      this.j += 1;
      if (this.j >= paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "onEmojiRecognise, id=" + paramLocalEmojiInfo.emojiId + ",score=" + paramFloat + ",emojiType=" + paramLocalEmojiInfo.emojiType + ",really hit");
        }
        this.j = 0;
        if (paramFloat < paramExpressionInfo.perfectValue) {
          break label231;
        }
        if (!paramLocalEmojiInfo.isBigEmoji) {
          break label225;
        }
        paramInt = 4;
      }
    }
    for (;;)
    {
      if (paramInt != 3) {
        a(paramLocalEmojiInfo.emojiId, paramLocalEmojiInfo.emojiType, paramInt, paramFloat);
      }
      label225:
      label231:
      do
      {
        return;
        paramInt = 1;
        break;
        if (paramFloat < paramExpressionInfo.coolValue) {
          break label332;
        }
        paramInt = k;
        if (!paramLocalEmojiInfo.isBigEmoji) {
          break;
        }
        paramInt = 3;
        break;
        this.j = 0;
        if ((paramFloat < paramExpressionInfo.coolValue) && (paramFloat >= paramExpressionInfo.coolValue - 5))
        {
          this.h += 1;
          return;
        }
      } while ((paramFloat >= paramExpressionInfo.coolValue - 5) || (paramFloat <= paramExpressionInfo.coolValue - 10));
      this.i += 1;
      return;
      label332:
      paramInt = 3;
    }
  }
  
  public void a(RedPacketShareFragment paramRedPacketShareFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRedPacketShareFragment);
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("AVRedPacketManager", 2, "onBigSmallSwitched, uinBig= " + paramString1 + ",uinSmall=" + paramString2);
    if (!a(true)) {}
    while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) {
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "onGetGrapRedPacketResult, redPacketId: " + paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("gameState", 5);
    localBundle.putInt("fromWho", 2);
    localBundle.putString("money", paramString2);
    localBundle.putInt("resultCode", Integer.parseInt(paramString3));
    localBundle.putString("resultState", paramString4);
    localBundle.putInt("hitScore", paramInt);
    a(1, localBundle);
  }
  
  public void a(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "raymond detectFaceExpression");
    }
    if ((!a(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null)) {}
    Object localObject;
    int k;
    ltr localltr;
    float f1;
    mqa localmqa;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.localFocusInfo;
          k = ((AVRedPacketManager.LocalFocusInfo)localObject).emojiId;
          localObject = ((AVRedPacketManager.LocalFocusInfo)localObject).mLocalEmojiInfo;
          if (localObject != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("AVRedPacketManager", 2, "detectFaceExpression, emojiInfo is null, focusId=" + k);
        return;
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          this.jdField_a_of_type_Ltq = ((ltq)this.jdField_a_of_type_JavaUtilList.get(a(((AVRedPacketManager.LocalEmojiInfo)localObject).emojiType)));
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "detectFaceExpression, targetExpression=" + this.jdField_a_of_type_Ltq.expressionID + ",emojiType=" + ((AVRedPacketManager.LocalEmojiInfo)localObject).emojiType);
        }
      } while ((paramList == null) || (paramArrayOfFloat == null) || (this.jdField_a_of_type_Ltq == null) || (this.jdField_a_of_type_Ltq.expressionFeat == null) || (this.jdField_a_of_type_Ltq.expressionAngle == null) || (this.jdField_a_of_type_Ltq.expressionWeight == null));
      localltr = ltp.a(this.jdField_a_of_type_Ltq, paramList, ltp.b(paramArrayOfFloat));
      f1 = localltr.a;
      localmqa = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((a(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) && (localmqa != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketManager", 2, "detectFaceExpression, invalid parame");
    return;
    AVRedPacketConfig.ExpressionInfo localExpressionInfo = (AVRedPacketConfig.ExpressionInfo)localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.expressionInfoList.get(((AVRedPacketManager.LocalEmojiInfo)localObject).emojiType);
    if ((f1 > localExpressionInfo.coolValue) && (this.jdField_b_of_type_Ltq != null)) {
      if ((localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.checkEyeOpenClose) && (this.jdField_a_of_type_Ltq.expressionWeight[0] > 0.0D) && (this.jdField_a_of_type_Ltq.expressionWeight[1] > 0.0D) && (!ltp.a(localltr)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "detectFaceExpression, invalid EyeOpenClose,reset score");
        }
        lts.a(1);
        f1 = 0.0F;
        f2 = f1;
        if (localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.checkNormalFaceExpression)
        {
          f2 = f1;
          if (ltp.a(localltr.a, this.jdField_a_of_type_Ltq.expressionWeight, this.jdField_a_of_type_Ltq.a, this.jdField_b_of_type_Ltq, paramList, ltp.b(paramArrayOfFloat)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVRedPacketManager", 2, "detectFaceExpression, is normalFaceExpression,reset score");
            }
            lts.a(2);
          }
        }
      }
    }
    for (float f2 = 0.0F;; f2 = f1)
    {
      int m = localmqa.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.continuousHitCount;
      k = m;
      if (m < 1) {
        k = 1;
      }
      a((AVRedPacketManager.LocalEmojiInfo)localObject, f2, localExpressionInfo, k);
      return;
      break;
    }
  }
  
  public void a(ltz paramltz)
  {
    this.jdField_a_of_type_Ltz = paramltz;
    if (this.jdField_a_of_type_Ltz == null) {}
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("AVRedPacketManager", 1, "setGameFinish, onlyClearUi=" + paramBoolean);
    if (!paramBoolean) {
      j();
    }
    if (!a(true)) {
      return;
    }
    a(true, 1004, 0L, null);
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1) {
      a(true, 1019, 0L, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(4);
      l();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Ltu.b();
      i();
    }
    try
    {
      this.jdField_a_of_type_Lub.a(7);
      this.jdField_a_of_type_Lub.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("AVRedPacketManager", 1, "setGameFinish exception", localException);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          if (!paramBoolean) {
            break label98;
          }
        }
        label98:
        for (Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "sendMessage, ui=" + paramBoolean + ",msg=" + paramInt + ",delay=" + paramLong);
          }
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, AVRedPacketManager.GameInfoFromBusiServer paramGameInfoFromBusiServer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGetGameinfoFromBusiServer, isSuccess=" + paramBoolean + ",actionType=" + paramInt + ",gameInfo=" + paramGameInfoFromBusiServer + ",mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
    }
    if (paramBoolean) {
      if (paramInt == 1) {
        a(paramGameInfoFromBusiServer);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 3) || (!a(true)));
      mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(paramGameInfoFromBusiServer.sendRedPacketUin, paramGameInfoFromBusiServer.receiveRedPacketUin, paramGameInfoFromBusiServer.key, paramGameInfoFromBusiServer.authKey, paramGameInfoFromBusiServer.currScores, jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.hasHitedEmojiIds.size(), jdField_f_of_type_Int, String.valueOf(paramGameInfoFromBusiServer.winMoney), "0", "", true, 0);
      a(false);
      return;
      if (paramInt == 1)
      {
        f(4);
        return;
      }
    } while (paramInt != 3);
    f(5);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("AVRedPacketManager", 1, "onGetC2CMsgGameInfo, isSuccess=" + paramBoolean + ",data=" + paramBundle);
    String str2 = paramBundle.getString("key", "");
    int k = paramBundle.getInt("gameState", 0);
    String str3 = paramBundle.getString("peerUin", "0");
    int m = paramBundle.getInt("fromWho", 0);
    String str1 = paramBundle.getString("money", "0");
    int n = paramBundle.getInt("resultCode", 0);
    String str4 = paramBundle.getString("resultState", "");
    int i1 = paramBundle.getInt("musicId", 0);
    int i2 = paramBundle.getInt("hitScore", 0);
    int i3 = paramBundle.getInt("enterType", 0);
    int i4 = paramBundle.getInt("maxScore", 0);
    int i5 = paramBundle.getInt("totalEmojiNum", 0);
    if (paramBoolean) {
      if (k == 1) {
        if (m == 1)
        {
          paramBundle = new AVRedPacketManager.GameStateInfo(str2, 2, str3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          paramBundle.money = str1;
          paramBundle.enterType = i3;
          this.jdField_g_of_type_Int = i1;
          a(paramBundle);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (k != 2) {
            break;
          }
        } while (m != 2);
        jdField_f_of_type_Int = i5;
        jdField_e_of_type_Int = i4;
        f();
        return;
      } while ((k != 5) || (m != 2) || (!a(true)));
      mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), str3, "", "", i2, jdField_e_of_type_Int, 0, 0, str1 + "", "" + n, str4, true, 0);
      a(false);
      return;
      if ((k == 1) || (k == 2))
      {
        f(6);
        return;
      }
    } while (k != 5);
    f(7);
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGetGameinfoFromFrmeInfo, isSuccess=" + paramBoolean + ",frameSyncInfo=" + paramLocalFrameSyncInfo);
    }
    if ((paramBoolean) && (a(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)) {
      if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2))
      {
        a(true, 1006, 0L, paramLocalFrameSyncInfo);
        if ((paramLocalFrameSyncInfo == null) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null) || (paramLocalFrameSyncInfo.seq != this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.seq)) {
          break label170;
        }
        if ((!a(1023)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.kazhenTipCnt < 1)) {
          a(false, 1023, jdField_e_of_type_Long, null);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo = paramLocalFrameSyncInfo;
      return;
      label170:
      a(1023);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "onSendRedPacketResult, isSucc=" + paramBoolean + ",key=" + paramString + ",fromType=" + paramInt);
    if (paramBoolean)
    {
      a(false);
      if (e())
      {
        paramString = new AVRedPacketManager.GameStateInfo(paramString, 1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), mqx.a());
        if (a(paramString))
        {
          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(1);
          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.enterType = paramInt;
          mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, paramInt);
          a(true, 1008, 0L, paramString);
          this.jdField_g_of_type_Int = a();
          a(true, 1020, 0L, null);
        }
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketSendRedSuc", true, 0L, 0L, null, "");
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((!a(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null)) {
      bool = false;
    }
    return bool;
  }
  
  boolean a(int paramInt)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Boolean) {
      for (;;)
      {
        try
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVRedPacketManager", 2, "hasMessage, msg=" + paramInt);
            }
            if ((!this.jdField_b_of_type_AndroidOsHandler.hasMessages(paramInt)) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(paramInt))) {
              return bool;
            }
          }
          else
          {
            return false;
          }
        }
        finally {}
        bool = true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "doOnGetC2CMsgTip, type=" + paramInt);
    }
    if ((!a(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {}
    do
    {
      return;
      if (paramInt == 2)
      {
        a(true, 1007, 0L, new Object[] { Integer.valueOf(jdField_a_of_type_Int), Boolean.valueOf(true), Integer.valueOf(10000) });
        a(1021);
        return;
      }
    } while (paramInt != 3);
    a(true, 1017, 0L, new Object[] { Integer.valueOf(jdField_b_of_type_Int), Boolean.valueOf(true), Integer.valueOf(10000) });
    a(1021);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("AVRedPacketManager", 1, "onFloatWindowSwitched, changeToBig= " + paramBoolean);
    if (!a(true)) {}
    label123:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramBoolean) {
              break label123;
            }
            if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) {
              break;
            }
          } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 1) || (!a(1015)));
          a(1015);
          e(2);
          return;
        } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) || ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3)));
        f(3);
        return;
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3));
      f(3);
      return;
    } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) || ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3)));
    try
    {
      this.jdField_a_of_type_Lub.a(7);
      a(true, 1019, 0L, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("AVRedPacketManager", 1, "setGameFinish exception", localException);
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    if ((!a(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!a(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "isNeedScreenShot, return false");
      }
      bool2 = false;
      return bool2;
    }
    Object localObject = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if ((localObject != null) && (((mqa)localObject).jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig != null) && (((mqa)localObject).jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.shareExpressionIDList != null) && (((mqa)localObject).jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.shareExpressionIDList.contains(Integer.valueOf(paramInt)))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt = 2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AVRedPacketManager", 2, "isNeedScreenShot, emojiTypeID =" + paramInt + ",result=" + bool1);
      return bool1;
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
        ((AVRedPacketManager.GameStateInfo)localObject).hasScreenShotCnt += 1;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public void c()
  {
    QLog.d("AVRedPacketManager", 1, "onRedPacketCome");
    if (!a(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.mRedPacketComeStartTime = System.currentTimeMillis();
    a(true, 1009, 0L, null);
    a(false, 1012, jdField_b_of_type_Long + 10000L, null);
  }
  
  public void c(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "doOnExceptionFromPeer, exceptionType=" + paramInt);
    if ((!a(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {
      return;
    }
    mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, "", "", 0, 0, 0, jdField_e_of_type_Int, "0", "0", "", false, paramInt);
    a(false);
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("AVRedPacketManager", 1, "onSelfVideoStatusChanged, isOpen= " + paramBoolean);
    if ((paramBoolean) && (a(true)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 1))
    {
      a(1007);
      a(1, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, 0, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.money);
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    QLog.d("AVRedPacketManager", 1, "onShowUserGuideForReceiver");
    if (!a(true)) {
      return;
    }
    mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(true, 1027, 0L, null);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "removeEmojiInfo, id=" + paramInt + ",needDetectFace=" + this.jdField_c_of_type_Boolean + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
    }
    if ((!a(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "removeEmojiInfo, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos.iterator();
    Object localObject2;
    int m;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVRedPacketManager.LocalEmojiInfo)((Iterator)localObject1).next();
        if (((AVRedPacketManager.LocalEmojiInfo)localObject2).emojiId == paramInt)
        {
          m = ((AVRedPacketManager.LocalEmojiInfo)localObject2).emojiType;
          k = m;
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "__debug__ removeEmojiInfo, emojiId = " + paramInt + ",testEmojiType = " + m);
          }
        }
      }
    }
    for (int k = m;; k = -1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
      localObject2 = ((AVRedPacketManager.GameStateInfo)localObject1).currLocalFrameSyncInfo;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = new AVRedPacketManager.LocalEmojiInfo();
      localLocalEmojiInfo.emojiId = paramInt;
      ((AVRedPacketManager.LocalFrameSyncInfo)localObject2).localEmojiInfos.remove(localLocalEmojiInfo);
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "__debug__ removeEmojiInfo,needDetectFace set false, emojiId = " + paramInt + ",testEmojiType = " + k);
        }
        this.jdField_c_of_type_Boolean = false;
      }
      if (!((AVRedPacketManager.LocalFrameSyncInfo)localObject2).hasHitedEmojiIds.contains(Integer.valueOf(paramInt))) {
        a(paramInt, k, 3, -1.0F);
      }
      if ((((AVRedPacketManager.GameStateInfo)localObject1).configEmojiInfos != null) && (!((AVRedPacketManager.GameStateInfo)localObject1).configEmojiInfos.isEmpty()))
      {
        if (((AVRedPacketManager.LocalEmojiInfo)((AVRedPacketManager.GameStateInfo)localObject1).configEmojiInfos.get(((AVRedPacketManager.GameStateInfo)localObject1).configEmojiInfos.size() - 1)).emojiId != paramInt) {
          break label513;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2))
        {
          a(false, 1018, 1500L, Boolean.valueOf(true));
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("succRate", String.format("%.2f", new Object[] { Float.valueOf(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.syncSuccEmojiId.size() * 1.0F / jdField_f_of_type_Int) }));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketEmojiSyncSuccRate", true, 0L, 0L, (HashMap)localObject1, "");
          return;
          paramInt = 1;
        }
        else
        {
          a(2, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, ((AVRedPacketManager.GameStateInfo)localObject1).curScore, "0");
          return;
          label513:
          paramInt = 0;
        }
      }
    }
  }
  
  public boolean d()
  {
    mqb localmqb = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    return (localmqb.a != null) && (localmqb.a.jdField_a_of_type_Boolean);
  }
  
  public void e()
  {
    QLog.d("AVRedPacketManager", 1, "quitGame");
    if (!a(true)) {
      return;
    }
    a(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
    a(true);
  }
  
  public void e(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, isOpen= " + paramInt);
    if (!a(false)) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        if (mqx.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
        {
          e(2);
          return;
        }
        QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, AVActivity not resume");
        a(false, 1015, 10000L, null);
        a(true, 1019, 0L, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
        a(3, null);
        return;
      }
    } while (paramInt != 2);
    if (mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      a(1, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, 0, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.money);
    }
    for (;;)
    {
      c();
      return;
      QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, camera close");
      a(true, 1007, 0L, new Object[] { Integer.valueOf(jdField_a_of_type_Int), Boolean.valueOf(true), Integer.valueOf(10000) });
      a(false, 1016, 10000L, null);
      a(2, null);
    }
  }
  
  public void f()
  {
    QLog.d("AVRedPacketManager", 1, "startGame");
    j();
    if (!a(true)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key);
      ((Bundle)localObject1).putInt("gameState", 2);
      ((Bundle)localObject1).putInt("fromWho", 2);
      ((Bundle)localObject1).putInt("maxScore", jdField_e_of_type_Int);
      ((Bundle)localObject1).putInt("totalEmojiNum", jdField_f_of_type_Int);
      a(1, (Bundle)localObject1);
      boolean bool = lph.g();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "startGame, isSoReady = " + bool);
      }
      this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(2);
    l();
    Object localObject1 = mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "startGame, init expressionList");
      }
      if (((mqa)localObject1).jdField_c_of_type_Boolean)
      {
        Object localObject2 = ((mqa)localObject1).jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        if (((String)localObject2).endsWith("/")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        this.jdField_a_of_type_JavaUtilList = ltp.a((String)localObject1, "params");
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          this.jdField_a_of_type_Ltq = ((ltq)this.jdField_a_of_type_JavaUtilList.get(0));
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ltq)((Iterator)localObject1).next();
            if (((ltq)localObject2).expressionID.equals("99")) {
              this.jdField_b_of_type_Ltq = ((ltq)localObject2);
            }
          }
        }
      }
    }
    a(true, 1002, 0L, new Object[] { Integer.valueOf(jdField_f_of_type_Int), this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos });
    a(false, 1012, jdField_b_of_type_Long, null);
  }
  
  public void f(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "doOnLocalException, exception= " + paramInt);
    if (!a(true)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
    int m = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState;
    boolean bool1;
    int k;
    boolean bool2;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) {
        break label921;
      }
      a(false, 1022, jdField_d_of_type_Long, null);
      bool1 = false;
      k = 0;
      bool2 = false;
    }
    for (;;)
    {
      if (bool2)
      {
        mqx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a().a(((AVRedPacketManager.GameStateInfo)localObject).sendRedPacketUin, ((AVRedPacketManager.GameStateInfo)localObject).receiveRedPacketUin, "", "", 0, jdField_e_of_type_Int, 0, jdField_f_of_type_Int, "0", "0", "", false, k);
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketLocalExp", false, 0L, 0L, (HashMap)localObject, "");
        }
      }
      if (bool1)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("alertExceptionType", k);
        a(4, (Bundle)localObject);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AVRedPacketManager", 2, "doOnLocalException, callGameEnd= " + bool2 + ",sendException=" + bool1 + ",alertExceptionType=" + k + ",frameSyncGameState=" + m);
      return;
      if ((paramInt == 4) || (paramInt == 6))
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          a(false);
          bool1 = false;
          k = 5;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(false);
          bool1 = true;
          k = 3;
          bool2 = true;
        }
      }
      else if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          a(false);
          bool1 = false;
          k = 7;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(false);
          bool1 = true;
          k = 4;
          bool2 = true;
        }
      }
      else if ((paramInt == 5) || (paramInt == 7))
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          a(false);
          bool1 = false;
          k = 4;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(false);
          bool1 = true;
          k = 4;
          bool2 = true;
        }
      }
      else if (paramInt == 8)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(false);
          a(true, 1019, 0L, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          bool1 = true;
          k = 1;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          bool1 = false;
          k = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 9)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(false);
          bool1 = true;
          k = 2;
          bool2 = true;
        }
      }
      else if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          bool1 = false;
          k = 0;
          bool2 = false;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          a(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
          a(true);
          bool1 = false;
          k = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 11)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          if (m == 0)
          {
            a(false);
            bool1 = false;
            k = 6;
            bool2 = true;
            continue;
          }
          bool1 = false;
          k = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 12)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          if (m == 3)
          {
            a(true, 1024, 0L, new Object[] { Integer.valueOf(jdField_c_of_type_Int), Boolean.valueOf(true), Integer.valueOf(5000) });
            a(false, 1012, jdField_b_of_type_Long, null);
            bool1 = false;
          }
          for (k = 0;; k = 3)
          {
            boolean bool3 = false;
            bool2 = bool1;
            bool1 = bool3;
            break;
            a(false);
            bool1 = true;
          }
        }
      }
      else if (paramInt == 13)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          AVRedPacketManager.GameStateInfo localGameStateInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
          localGameStateInfo.kazhenTipCnt += 1;
          a(true, 1025, 0L, new Object[] { Integer.valueOf(jdField_d_of_type_Int), Boolean.valueOf(true), Integer.valueOf(5000) });
        }
        bool1 = false;
        k = 0;
        bool2 = false;
        continue;
      }
      label921:
      bool1 = false;
      k = 0;
      bool2 = false;
    }
  }
  
  public void g()
  {
    QLog.d("AVRedPacketManager", 1, "setGameReadyCountDownFinish");
    if (!a(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(3);
    l();
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameStartTime = NetConnInfoCenter.getServerTimeMillis();
    a(true, 1003, 0L, Integer.valueOf(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 1010: 
    case 1008: 
    case 1009: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1006: 
    case 1005: 
    case 1007: 
    case 1017: 
    case 1024: 
    case 1025: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1018: 
    case 1019: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1026: 
    case 1027: 
      do
      {
        do
        {
          do
          {
            do
            {
              boolean bool;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return false;
                              } while ((this.jdField_a_of_type_Ltz == null) || (!a(false)));
                              this.jdField_a_of_type_Ltz.a((AVRedPacketManager.LocalFrameSyncInfo)paramMessage.obj);
                              return false;
                            } while (this.jdField_a_of_type_Ltz == null);
                            this.jdField_a_of_type_Ltz.d();
                            return false;
                          } while (this.jdField_a_of_type_Ltz == null);
                          this.jdField_a_of_type_Ltz.e();
                          return false;
                          if (this.jdField_a_of_type_Ltz != null)
                          {
                            paramMessage = (Object[])paramMessage.obj;
                            k = ((Integer)paramMessage[0]).intValue();
                            paramMessage = (List)paramMessage[1];
                            this.jdField_a_of_type_Ltz.a(k, paramMessage);
                          }
                        } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
                        ((RedPacketShareFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
                        return false;
                      } while (this.jdField_a_of_type_Ltz == null);
                      this.jdField_a_of_type_Ltz.a(((Integer)paramMessage.obj).intValue());
                      return false;
                    } while (this.jdField_a_of_type_Ltz == null);
                    this.jdField_a_of_type_Ltz.a();
                    return false;
                  } while ((this.jdField_a_of_type_Ltz == null) || (!a(false)));
                  this.jdField_a_of_type_Ltz.b((AVRedPacketManager.LocalFrameSyncInfo)paramMessage.obj);
                  return false;
                } while (this.jdField_a_of_type_Ltz == null);
                this.jdField_a_of_type_Ltz.b();
                return false;
                paramMessage = (Object[])paramMessage.obj;
                k = ((Integer)paramMessage[0]).intValue();
                bool = ((Boolean)paramMessage[1]).booleanValue();
                ((Integer)paramMessage[2]).intValue();
              } while (this.jdField_a_of_type_Ltz == null);
              this.jdField_a_of_type_Ltz.a(k, bool);
              return false;
              f(1);
              return false;
              f(2);
              return false;
              paramMessage = (Object[])paramMessage.obj;
              int k = ((Integer)paramMessage[0]).intValue();
              long l = ((Long)paramMessage[1]).longValue();
              int m = ((Integer)paramMessage[2]).intValue();
              int n = ((Integer)paramMessage[3]).intValue();
              int i1 = ((Integer)paramMessage[4]).intValue();
              paramMessage = a(k, l, m, n, i1, ((Boolean)paramMessage[5]).booleanValue());
              if (QLog.isColorLevel()) {
                QLog.d("AVRedPacketManager", 2, "__debug__ updateFocus, emojiId =" + k + " , emojiType=" + i1);
              }
              a(k, paramMessage);
              return false;
            } while (this.jdField_a_of_type_Ltz == null);
            this.jdField_a_of_type_Ltz.a(((Boolean)paramMessage.obj).booleanValue());
            return false;
            f(8);
            return false;
            f(9);
            return false;
          } while (!((Boolean)paramMessage.obj).booleanValue());
          a(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
          return false;
          paramMessage = (Object[])paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 1, "WL_DEBUG MSG_WHAT_FLOATWINDOW_ANIMATION");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(517), paramMessage[0], paramMessage[1] });
          return false;
        } while (this.jdField_a_of_type_Ltz == null);
        this.jdField_a_of_type_Ltz.a();
        h();
        return false;
        f(11);
        return false;
        f(12);
        return false;
        f(13);
        return false;
        f();
        return false;
      } while (this.jdField_a_of_type_Ltz == null);
      this.jdField_a_of_type_Ltz.f();
      return false;
    }
    d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager
 * JD-Core Version:    0.7.0.1
 */