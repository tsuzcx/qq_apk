package com.tencent.avgame.gamelogic.data;

import android.os.CountDownTimer;
import android.os.Looper;
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
  public GameInfo a;
  public GameRecordInfo a;
  @Nullable
  public Player a;
  private String jdField_a_of_type_JavaLangString;
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
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      d();
      long l = this.jdField_c_of_type_Long;
      if (l <= 0L) {
        return 0;
      }
      int i = (int)(SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long);
      int j = this.jdField_d_of_type_Int;
      return i + j;
    }
    finally {}
  }
  
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
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsCountDownTimer = new Game.2(this, paramInt, paramInt + 1, l, paramInt);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  private void b(int paramInt)
  {
    QLog.d("avgame_logic_Game", 1, new Object[] { "onCountdownFinish left=", Integer.valueOf(paramInt) });
    this.jdField_c_of_type_Int = 2;
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_d_of_type_Int = (-paramInt);
  }
  
  private void d()
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      int i = a(false);
      i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_d_of_type_Int * 1000 - i;
      if (i <= 0)
      {
        b(i);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a(i);
        return;
      }
      new Game.1(this, "CountDownThread", i).start();
    }
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
    if (paramGame == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramGame.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramGame.jdField_b_of_type_Long;
    this.jdField_c_of_type_Int = paramGame.jdField_c_of_type_Int;
    Object localObject1 = paramGame.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    localObject1 = paramGame.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.jdField_b_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    localObject1 = paramGame.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    localObject1 = paramGame.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localObject1);
    localObject1 = paramGame.jdField_a_of_type_ComTencentAvgameGamelogicITopic;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((ITopic)localObject1).a();
    }
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
  }
  
  public void a(GameRecordInfo paramGameRecordInfo)
  {
    if (paramGameRecordInfo != null) {}
    try
    {
      a(paramGameRecordInfo.videoFilePath, paramGameRecordInfo.photoFilePath, paramGameRecordInfo.startGameTimeMills);
      a(paramGameRecordInfo.extraJsonData);
    }
    finally {}
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int j = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    UserScore localUserScore;
    do
    {
      i = j;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUserScore = (UserScore)((Iterator)localObject).next();
    } while ((localUserScore == null) || (!paramString.equalsIgnoreCase(Long.toString(localUserScore.uin))));
    localUserScore.score += paramInt;
    int i = 1;
    if (i == 0)
    {
      localObject = new UserScore();
      ((UserScore)localObject).score = paramInt;
      ((UserScore)localObject).uin = Long.parseLong(paramString);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
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
    if (paramGameStatusInfo == null) {
      return;
    }
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
  
  public boolean a()
  {
    int i = this.jdField_c_of_type_Int;
    boolean bool = true;
    int m = 1;
    if (i != 0)
    {
      if ((i != 1) && (i != 2)) {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) {
            i = 1;
          } else {
            i = 0;
          }
          if ((GameUtil.a(a())) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
            j = 0;
          } else {
            j = 1;
          }
          j = i & 0x1 & j;
          i = j;
          if (this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
            break label151;
          }
          i = j;
          k = m;
          break label153;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) {
        i = 1;
      } else {
        i = 0;
      }
      int j = i & 0x1;
      i = j;
      int k = m;
      if (GameUtil.a(a()))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null)
        {
          i = j;
          k = m;
        }
        else
        {
          label151:
          k = 0;
        }
      }
      label153:
      bool = k & i;
    }
    return bool;
  }
  
  public boolean a(ITopic paramITopic)
  {
    if (paramITopic != null) {
      try
      {
        this.jdField_c_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        this.jdField_d_of_type_Int = 0;
        this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
        d();
        return true;
      }
      finally
      {
        paramITopic = finally;
        throw paramITopic;
      }
    }
    return false;
  }
  
  public boolean a(ITopic paramITopic, int paramInt1, Player paramPlayer, long paramLong, int paramInt2, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic)) && (paramPlayer != null))
      {
        this.jdField_c_of_type_Int = 3;
        this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Long = paramLong;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = paramAnswerInfo;
        a(paramPlayer.uin, paramInt1);
        if ((paramITopic.b() == 1) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer != null))
        {
          this.jdField_b_of_type_Int = paramInt2;
          a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramInt2);
        }
        if (paramBoolean)
        {
          this.jdField_d_of_type_Int = 0;
          this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
        }
        d();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(ITopic paramITopic, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic)))
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
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(ITopic paramITopic, boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic)))
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
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer)
  {
    if (paramPlayer != null) {
      try
      {
        this.jdField_c_of_type_ComTencentAvgameGamelogicDataPlayer = paramPlayer;
        return true;
      }
      finally
      {
        paramPlayer = finally;
        throw paramPlayer;
      }
    }
    return false;
  }
  
  public boolean a(Player paramPlayer, ITopic paramITopic)
  {
    if ((paramPlayer != null) && (paramITopic != null)) {
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
        return true;
      }
      finally {}
    }
    return false;
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
    Player localPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
    if (localPlayer != null) {
      localPlayer.status = 2;
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
    if (this.jdField_c_of_type_Int != 10)
    {
      this.jdField_c_of_type_Int = 10;
      this.jdField_d_of_type_Int = 0;
      this.e = 0;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      Player localPlayer = this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      if (localPlayer != null) {
        localPlayer.status = 0;
      }
      d();
      return true;
    }
    return false;
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
  
  public boolean c(ITopic paramITopic)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvgameGamelogicITopic != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicITopic.a(paramITopic)))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicITopic = paramITopic;
        this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        return true;
      }
      return false;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
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
  
  public int e()
  {
    try
    {
      d();
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1))
      {
        long l = this.jdField_d_of_type_Long;
        if (l <= 0L) {
          return 0;
        }
        int i = (int)(SystemClock.elapsedRealtime() - this.jdField_d_of_type_Long);
        int j = this.e;
        int k = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_d_of_type_Int;
        return i + j - k * 1000;
      }
      return 0;
    }
    finally {}
  }
  
  public int f()
  {
    try
    {
      if (GameUtil.c(a()))
      {
        ITopic localITopic = a();
        if (localITopic != null)
        {
          i = localITopic.c();
          return i * 1000;
        }
      }
      int i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.e;
      return i * 1000;
    }
    finally {}
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("status=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusPastTimeSvr=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("gamePastTimeSvr=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusPastTime=");
    localStringBuilder.append(d());
    localStringBuilder.append("\n");
    localStringBuilder.append("gamePastTime=");
    localStringBuilder.append(e());
    localStringBuilder.append("\n");
    localStringBuilder.append("gameInfo=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("topic=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicITopic);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("player=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("score=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("actorScore");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("rightPlayer=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_d_of_type_ComTencentAvgameGamelogicDataPlayer);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Game
 * JD-Core Version:    0.7.0.1
 */