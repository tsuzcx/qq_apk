package com.tencent.avgame.gamelogic.data;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.IGame;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.PKUserRankInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public class Game
  implements IGame
{
  public int a;
  public long a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  @Nullable
  public ITopic a;
  public AnswerInfo a;
  @NotNull
  public GameInfo a;
  @NotNull
  public GameRecordInfo a;
  @Nullable
  public Player a;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  public CopyOnWriteArrayList<UserScore> a;
  public int b;
  private long b;
  @Nullable
  public Player b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  @Nullable
  public Player c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  @Nullable
  public Player d;
  private int e;
  
  public Game()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo = new GameInfo();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo = new GameRecordInfo();
    a();
  }
  
  /* Error */
  private int a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +7 -> 10
    //   6: aload_0
    //   7: invokespecial 51	com/tencent/avgame/gamelogic/data/Game:d	()V
    //   10: aload_0
    //   11: getfield 53	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Long	J
    //   14: lstore 4
    //   16: lload 4
    //   18: lconst_0
    //   19: lcmp
    //   20: ifgt +9 -> 29
    //   23: iconst_0
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: invokestatic 59	android/os/SystemClock:elapsedRealtime	()J
    //   32: aload_0
    //   33: getfield 53	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Long	J
    //   36: lsub
    //   37: l2i
    //   38: istore_2
    //   39: aload_0
    //   40: getfield 61	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_Int	I
    //   43: istore_3
    //   44: iload_2
    //   45: iload_3
    //   46: iadd
    //   47: istore_2
    //   48: goto -23 -> 25
    //   51: astore 6
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 6
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	Game
    //   0	58	1	paramBoolean	boolean
    //   24	24	2	i	int
    //   43	4	3	j	int
    //   14	3	4	l	long
    //   51	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	10	51	finally
    //   10	16	51	finally
    //   29	44	51	finally
  }
  
  @NotNull
  public static Game a(long paramLong, String paramString, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic)
  {
    Game localGame = new Game();
    localGame.jdField_a_of_type_JavaLangString = paramString;
    localGame.jdField_b_of_type_Long = paramLong;
    localGame.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
    localGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
    localGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a(paramGameInfo);
    return localGame;
  }
  
  private void a(int paramInt)
  {
    QLog.d("avgame_logic_Game", 1, new Object[] { "onCountdownFinish left=", Integer.valueOf(paramInt) });
    this.jdField_c_of_type_Int = 2;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_d_of_type_Int = (-paramInt);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    int i;
    if (this.jdField_c_of_type_Int == 1)
    {
      i = a(false);
      i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_d_of_type_Int * 1000 - i;
      if (i <= 0) {
        a(i);
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsCountDownTimer = new Game.1(this, i, i + 1, l, i);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_b_of_type_Int;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      UserScore localUserScore = (UserScore)localIterator.next();
      if (paramString.equalsIgnoreCase(Long.toString(localUserScore.uin))) {
        return localUserScore.score;
      }
    }
    return 0;
  }
  
  public ITopic a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicITopic;
  }
  
  protected Game a()
  {
    Game localGame = new Game();
    localGame.a(this);
    return localGame;
  }
  
  public Player a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CopyOnWriteArrayList<UserScore> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = null;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.reset();
    d();
  }
  
  public void a(Game paramGame)
  {
    Object localObject2 = null;
    if (paramGame == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramGame.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramGame.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramGame.jdField_c_of_type_Int;
    if (paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)
    {
      localObject1 = null;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramGame.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label202;
      }
      localObject1 = null;
      label54:
      this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramGame.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label213;
      }
      localObject1 = null;
      label68:
      this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramGame.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        break label224;
      }
      localObject1 = null;
      label82:
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
      if (paramGame.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) {
        break label235;
      }
    }
    label202:
    label213:
    label224:
    label235:
    for (Object localObject1 = localObject2;; localObject1 = paramGame.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a())
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = ((ITopic)localObject1);
      this.jdField_d_of_type_Int = paramGame.jdField_d_of_type_Int;
      this.e = paramGame.e;
      this.jdField_c_of_type_Long = paramGame.jdField_c_of_type_Long;
      this.jdField_d_of_type_Long = paramGame.jdField_d_of_type_Long;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a(paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramGame.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
      this.jdField_a_of_type_Int = paramGame.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramGame.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.copyFrom(paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo);
      return;
      localObject1 = paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break;
      localObject1 = paramGame.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label54;
      localObject1 = paramGame.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label68;
      localObject1 = paramGame.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer.clone();
      break label82;
    }
  }
  
  public void a(GameRecordInfo paramGameRecordInfo)
  {
    if (paramGameRecordInfo != null) {}
    try
    {
      a(paramGameRecordInfo.videoFilePath, paramGameRecordInfo.photoFilePath, paramGameRecordInfo.startGameTimeMills);
      a(paramGameRecordInfo.extraJsonData);
      return;
    }
    finally
    {
      paramGameRecordInfo = finally;
      throw paramGameRecordInfo;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.extraJsonData = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        UserScore localUserScore = (UserScore)((Iterator)localObject).next();
        if ((localUserScore != null) && (paramString.equalsIgnoreCase(Long.toString(localUserScore.uin)))) {
          localUserScore.score += paramInt;
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new UserScore();
        ((UserScore)localObject).score = paramInt;
        ((UserScore)localObject).uin = Long.parseLong(paramString);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.gameType = a();
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.videoFilePath = paramString1;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.photoFilePath = paramString2;
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameRecordInfo.startGameTimeMills = paramLong;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(AvGameCommon.GameStatusInfo paramGameStatusInfo)
  {
    if (paramGameStatusInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramGameStatusInfo.play_game_id.get();
      this.jdField_c_of_type_Int = paramGameStatusInfo.game_status.get();
      Object localObject;
      if ((paramGameStatusInfo.actor_info.has()) && (paramGameStatusInfo.actor_info.get() != null))
      {
        localObject = new Player();
        ((Player)localObject).parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.actor_info.get());
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject);
      }
      if ((paramGameStatusInfo.right_actor_info.has()) && (paramGameStatusInfo.right_actor_info.get() != null))
      {
        localObject = new Player();
        ((Player)localObject).parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.right_actor_info.get());
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject);
      }
      if ((paramGameStatusInfo.question_info.has()) && (paramGameStatusInfo.question_info.get() != null)) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = GameUtil.b((AvGameCommon.GameQuestionInfo)paramGameStatusInfo.question_info.get(), false);
      }
      if ((paramGameStatusInfo.game_info.has()) && (paramGameStatusInfo.game_info.get() != null))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a();
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.a((AvGameCommon.GameInfo)paramGameStatusInfo.game_info.get());
      }
      this.jdField_d_of_type_Int = paramGameStatusInfo.status_past_time.get();
      this.e = paramGameStatusInfo.game_past_time.get();
      this.jdField_a_of_type_Int = paramGameStatusInfo.score.get();
      long l = SystemClock.elapsedRealtime();
      this.jdField_c_of_type_Long = l;
      this.jdField_d_of_type_Long = l;
      if ((paramGameStatusInfo.score_list.has()) && (paramGameStatusInfo.score_list.get() != null))
      {
        paramGameStatusInfo = paramGameStatusInfo.score_list.get().iterator();
        while (paramGameStatusInfo.hasNext())
        {
          localObject = (AvGameCommon.PKUserRankInfo)paramGameStatusInfo.next();
          a(Long.toString(((AvGameCommon.PKUserRankInfo)localObject).uin.get()), ((AvGameCommon.PKUserRankInfo)localObject).score.get());
        }
      }
    }
  }
  
  public boolean a()
  {
    int k = 1;
    int m = 1;
    int i;
    int j;
    switch (this.jdField_c_of_type_Int)
    {
    case 0: 
    default: 
      return true;
    case 1: 
    case 2: 
    case 4: 
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null)
      {
        i = 1;
        j = m;
        if (GameUtil.a(a())) {
          if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
            break label89;
          }
        }
      }
      label89:
      for (j = m;; j = 0)
      {
        return j & i & 0x1;
        i = 0;
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null)
    {
      j = 1;
      if (!GameUtil.a(a())) {
        break label147;
      }
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        break label142;
      }
      i = 1;
      label122:
      if (this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        break label152;
      }
    }
    for (;;)
    {
      return k & i & 0x1 & j;
      j = 0;
      break;
      label142:
      i = 0;
      break label122;
      label147:
      i = 1;
      break label122;
      label152:
      k = 0;
    }
  }
  
  public boolean a(ITopic paramITopic)
  {
    boolean bool = false;
    if (paramITopic != null) {}
    try
    {
      this.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
      this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      d();
      bool = true;
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  /* Error */
  public boolean a(ITopic paramITopic, int paramInt1, Player paramPlayer, long paramLong, int paramInt2, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   9: ifnull +127 -> 136
    //   12: aload_0
    //   13: getfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   16: aload_1
    //   17: invokeinterface 347 2 0
    //   22: ifeq +114 -> 136
    //   25: aload_3
    //   26: ifnull +110 -> 136
    //   29: aload_0
    //   30: iconst_3
    //   31: putfield 30	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Int	I
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   39: aload_0
    //   40: aload_3
    //   41: putfield 175	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   44: aload_0
    //   45: iload_2
    //   46: putfield 185	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_Int	I
    //   49: aload_0
    //   50: lload 4
    //   52: putfield 349	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_Long	J
    //   55: aload_0
    //   56: aload 7
    //   58: putfield 351	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo	Lcom/tencent/avgame/gamelogic/data/AnswerInfo;
    //   61: aload_0
    //   62: aload_3
    //   63: getfield 353	com/tencent/avgame/gamelogic/data/Player:uin	Ljava/lang/String;
    //   66: iload_2
    //   67: invokevirtual 340	com/tencent/avgame/gamelogic/data/Game:a	(Ljava/lang/String;I)V
    //   70: aload_1
    //   71: invokeinterface 355 1 0
    //   76: iconst_1
    //   77: if_icmpne +29 -> 106
    //   80: aload_0
    //   81: getfield 71	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   84: ifnull +22 -> 106
    //   87: aload_0
    //   88: iload 6
    //   90: putfield 186	com/tencent/avgame/gamelogic/data/Game:jdField_b_of_type_Int	I
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 71	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   98: getfield 353	com/tencent/avgame/gamelogic/data/Player:uin	Ljava/lang/String;
    //   101: iload 6
    //   103: invokevirtual 340	com/tencent/avgame/gamelogic/data/Game:a	(Ljava/lang/String;I)V
    //   106: iload 8
    //   108: ifeq +15 -> 123
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 61	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_Int	I
    //   116: aload_0
    //   117: invokestatic 59	android/os/SystemClock:elapsedRealtime	()J
    //   120: putfield 53	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Long	J
    //   123: aload_0
    //   124: invokespecial 51	com/tencent/avgame/gamelogic/data/Game:d	()V
    //   127: iload 9
    //   129: istore 8
    //   131: aload_0
    //   132: monitorexit
    //   133: iload 8
    //   135: ireturn
    //   136: iconst_0
    //   137: istore 8
    //   139: goto -8 -> 131
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	Game
    //   0	147	1	paramITopic	ITopic
    //   0	147	2	paramInt1	int
    //   0	147	3	paramPlayer	Player
    //   0	147	4	paramLong	long
    //   0	147	6	paramInt2	int
    //   0	147	7	paramAnswerInfo	AnswerInfo
    //   0	147	8	paramBoolean	boolean
    //   1	127	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	25	142	finally
    //   29	106	142	finally
    //   111	123	142	finally
    //   123	127	142	finally
  }
  
  public boolean a(ITopic paramITopic, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic))
        {
          this.jdField_c_of_type_Int = 4;
          this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
          this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = paramAnswerInfo;
          if (paramBoolean)
          {
            this.jdField_d_of_type_Int = 0;
            this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
          }
          d();
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean a(ITopic paramITopic, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic))
        {
          this.jdField_c_of_type_Int = 4;
          this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
          this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
          if (paramBoolean)
          {
            this.jdField_d_of_type_Int = 0;
            this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
          }
          d();
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer)
  {
    if (paramPlayer != null) {}
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        bool = true;
        return bool;
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean a(Player paramPlayer, ITopic paramITopic)
  {
    boolean bool = true;
    if ((paramPlayer == null) || (paramITopic == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.jdField_c_of_type_Int = 1;
        this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
        }
        this.jdField_d_of_type_Int = 0;
        this.e = 0;
        long l = SystemClock.elapsedRealtime();
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_Long = l;
        d();
      }
      finally {}
    }
  }
  
  public boolean a(List<UserScore> paramList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
      return true;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Int = 1;
    long l = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long = l;
    this.jdField_d_of_type_Long = l;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 2;
    }
    d();
  }
  
  public void b(Game paramGame)
  {
    try
    {
      a(paramGame);
      d();
      return;
    }
    finally
    {
      paramGame = finally;
      throw paramGame;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_c_of_type_Int != 10)
    {
      this.jdField_c_of_type_Int = 10;
      this.jdField_d_of_type_Int = 0;
      this.e = 0;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null) {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.status = 0;
      }
      d();
      bool = true;
    }
    return bool;
  }
  
  public boolean b(ITopic paramITopic)
  {
    try
    {
      boolean bool = a(paramITopic, true);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public int c()
  {
    d();
    return this.jdField_c_of_type_Int;
  }
  
  public void c()
  {
    try
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Long = 0L;
      this.e = 0;
      this.jdField_d_of_type_Long = 0L;
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean c(ITopic paramITopic)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   13: aload_1
    //   14: invokeinterface 347 2 0
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 69	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicITopic	Lcom/tencent/avgame/gamelogic/ITopic;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 175	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer	Lcom/tencent/avgame/gamelogic/data/Player;
    //   32: iconst_1
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -6 -> 34
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	Game
    //   0	48	1	paramITopic	ITopic
    //   33	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	32	43	finally
  }
  
  public int d()
  {
    try
    {
      int i = a(true);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 51	com/tencent/avgame/gamelogic/data/Game:d	()V
    //   8: iload_2
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 30	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Int	I
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 30	com/tencent/avgame/gamelogic/data/Game:jdField_c_of_type_Int	I
    //   21: istore_1
    //   22: iload_1
    //   23: iconst_1
    //   24: if_icmpne +9 -> 33
    //   27: iload_2
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iload_2
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 179	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_Long	J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifle -12 -> 29
    //   44: invokestatic 59	android/os/SystemClock:elapsedRealtime	()J
    //   47: aload_0
    //   48: getfield 179	com/tencent/avgame/gamelogic/data/Game:jdField_d_of_type_Long	J
    //   51: lsub
    //   52: l2i
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 177	com/tencent/avgame/gamelogic/data/Game:e	I
    //   58: istore_2
    //   59: aload_0
    //   60: getfield 35	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo	Lcom/tencent/avgame/gamelogic/data/GameInfo;
    //   63: getfield 104	com/tencent/avgame/gamelogic/data/GameInfo:jdField_d_of_type_Int	I
    //   66: istore_3
    //   67: iload_1
    //   68: iload_2
    //   69: iadd
    //   70: iload_3
    //   71: sipush 1000
    //   74: imul
    //   75: isub
    //   76: istore_1
    //   77: goto -48 -> 29
    //   80: astore 4
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	Game
    //   9	68	1	i	int
    //   1	69	2	j	int
    //   66	9	3	k	int
    //   80	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	8	80	finally
    //   10	22	80	finally
    //   35	67	80	finally
  }
  
  /* Error */
  public int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 236	com/tencent/avgame/gamelogic/data/Game:a	()I
    //   6: invokestatic 372	com/tencent/avgame/gamelogic/GameUtil:c	(I)Z
    //   9: ifeq +29 -> 38
    //   12: aload_0
    //   13: invokevirtual 373	com/tencent/avgame/gamelogic/data/Game:a	()Lcom/tencent/avgame/gamelogic/ITopic;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +20 -> 38
    //   21: aload_2
    //   22: invokeinterface 375 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: sipush 1000
    //   32: imul
    //   33: istore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 35	com/tencent/avgame/gamelogic/data/Game:jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo	Lcom/tencent/avgame/gamelogic/data/GameInfo;
    //   42: getfield 376	com/tencent/avgame/gamelogic/data/GameInfo:e	I
    //   45: istore_1
    //   46: iload_1
    //   47: sipush 1000
    //   50: imul
    //   51: istore_1
    //   52: goto -18 -> 34
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Game
    //   27	25	1	i	int
    //   16	6	2	localITopic	ITopic
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	55	finally
    //   21	28	55	finally
    //   38	46	55	finally
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameId=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n").append("status=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n").append("statusPastTimeSvr=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n").append("gamePastTimeSvr=").append(this.e);
    localStringBuilder.append("\n").append("statusPastTime=").append(d());
    localStringBuilder.append("\n").append("gamePastTime=").append(e());
    localStringBuilder.append("\n").append("gameInfo=").append("[").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo).append("]");
    localStringBuilder.append("\n").append("topic=").append("[").append(this.jdField_a_of_type_ComTencentAvgameGamelogicITopic).append("]");
    localStringBuilder.append("\n").append("player=").append("[").append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    localStringBuilder.append("\n").append("score=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n").append("actorScore").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n").append("rightPlayer=").append("[").append(this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Game
 * JD-Core Version:    0.7.0.1
 */