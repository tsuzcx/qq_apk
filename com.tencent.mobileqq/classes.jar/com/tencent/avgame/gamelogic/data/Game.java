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
  @Nullable
  public ITopic a;
  @Nullable
  public Player b;
  @Nullable
  public Player c;
  @Nullable
  public Player d;
  @Nullable
  public Player e;
  public GameInfo f = new GameInfo();
  public CopyOnWriteArrayList<UserScore> g = new CopyOnWriteArrayList();
  public GameRecordInfo h = new GameRecordInfo();
  public int i;
  public long j;
  public AnswerInfo k;
  public int l;
  private String m;
  private long n;
  private int o = 0;
  private int p;
  private int q;
  private long r;
  private long s;
  private CountDownTimer t;
  
  public Game()
  {
    b();
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      q();
      long l1 = this.r;
      if (l1 <= 0L) {
        return 0;
      }
      int i1 = (int)(SystemClock.elapsedRealtime() - this.r);
      int i2 = this.p;
      return i1 + i2;
    }
    finally {}
  }
  
  public static Game a(long paramLong, String paramString, GameInfo paramGameInfo, Player paramPlayer, ITopic paramITopic)
  {
    Game localGame = new Game();
    localGame.m = paramString;
    localGame.n = paramLong;
    localGame.a = paramITopic;
    localGame.b = paramPlayer;
    localGame.f.a(paramGameInfo);
    return localGame;
  }
  
  private void a(int paramInt)
  {
    long l1 = SystemClock.elapsedRealtime();
    this.t = new Game.2(this, paramInt, paramInt + 1, l1, paramInt);
    this.t.start();
  }
  
  private void b(int paramInt)
  {
    QLog.d("avgame_logic_Game", 1, new Object[] { "onCountdownFinish left=", Integer.valueOf(paramInt) });
    this.o = 2;
    this.r = SystemClock.elapsedRealtime();
    this.p = (-paramInt);
  }
  
  private void q()
  {
    CountDownTimer localCountDownTimer = this.t;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      this.t = null;
    }
    if (this.o == 1)
    {
      int i1 = a(false);
      i1 = this.f.d * 1000 - i1;
      if (i1 <= 0)
      {
        b(i1);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a(i1);
        return;
      }
      new Game.1(this, "CountDownThread", i1).start();
    }
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      UserScore localUserScore = (UserScore)localIterator.next();
      if (paramString.equalsIgnoreCase(Long.toString(localUserScore.uin))) {
        return localUserScore.score;
      }
    }
    return 0;
  }
  
  public void a(Game paramGame)
  {
    if (paramGame == null) {
      return;
    }
    this.m = paramGame.m;
    this.n = paramGame.n;
    this.o = paramGame.o;
    Object localObject1 = paramGame.b;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.b = ((Player)localObject1);
    localObject1 = paramGame.c;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.c = ((Player)localObject1);
    localObject1 = paramGame.d;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.d = ((Player)localObject1);
    localObject1 = paramGame.e;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Player)localObject1).clone();
    }
    this.e = ((Player)localObject1);
    localObject1 = paramGame.a;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((ITopic)localObject1).j();
    }
    this.a = ((ITopic)localObject1);
    this.p = paramGame.p;
    this.q = paramGame.q;
    this.r = paramGame.r;
    this.s = paramGame.s;
    this.f.a(paramGame.f);
    this.g.clear();
    this.g.addAll(paramGame.g);
    this.i = paramGame.i;
    this.l = paramGame.l;
    this.h.copyFrom(paramGame.h);
  }
  
  public void a(GameRecordInfo paramGameRecordInfo)
  {
    if (paramGameRecordInfo != null) {}
    try
    {
      a(paramGameRecordInfo.videoFilePath, paramGameRecordInfo.photoFilePath, paramGameRecordInfo.startGameTimeMills);
      b(paramGameRecordInfo.extraJsonData);
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i2 = 0;
    Object localObject = this.g.iterator();
    UserScore localUserScore;
    do
    {
      i1 = i2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUserScore = (UserScore)((Iterator)localObject).next();
    } while ((localUserScore == null) || (!paramString.equalsIgnoreCase(Long.toString(localUserScore.uin))));
    localUserScore.score += paramInt;
    int i1 = 1;
    if (i1 == 0)
    {
      localObject = new UserScore();
      ((UserScore)localObject).score = paramInt;
      ((UserScore)localObject).uin = Long.parseLong(paramString);
      this.g.add(localObject);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.h.gameType = d();
      this.h.videoFilePath = paramString1;
      this.h.photoFilePath = paramString2;
      this.h.startGameTimeMills = paramLong;
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
    this.m = paramGameStatusInfo.play_game_id.get();
    this.o = paramGameStatusInfo.game_status.get();
    Object localObject;
    if ((paramGameStatusInfo.actor_info.has()) && (paramGameStatusInfo.actor_info.get() != null))
    {
      localObject = new Player();
      ((Player)localObject).parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.actor_info.get());
      this.b = ((Player)localObject);
    }
    if ((paramGameStatusInfo.right_actor_info.has()) && (paramGameStatusInfo.right_actor_info.get() != null))
    {
      localObject = new Player();
      ((Player)localObject).parseFrom((AvGameCommon.RoomUserInfo)paramGameStatusInfo.right_actor_info.get());
      this.e = ((Player)localObject);
    }
    if ((paramGameStatusInfo.question_info.has()) && (paramGameStatusInfo.question_info.get() != null)) {
      this.a = GameUtil.b((AvGameCommon.GameQuestionInfo)paramGameStatusInfo.question_info.get(), false);
    }
    if ((paramGameStatusInfo.game_info.has()) && (paramGameStatusInfo.game_info.get() != null))
    {
      this.f.a();
      this.f.a((AvGameCommon.GameInfo)paramGameStatusInfo.game_info.get());
    }
    this.p = paramGameStatusInfo.status_past_time.get();
    this.q = paramGameStatusInfo.game_past_time.get();
    this.i = paramGameStatusInfo.score.get();
    long l1 = SystemClock.elapsedRealtime();
    this.r = l1;
    this.s = l1;
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
    int i1 = this.o;
    boolean bool = true;
    int i4 = 1;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2)) {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return true;
          }
        }
        else
        {
          if (this.a != null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if ((GameUtil.c(d())) && (this.b == null)) {
            i2 = 0;
          } else {
            i2 = 1;
          }
          i2 = i1 & 0x1 & i2;
          i1 = i2;
          if (this.e == null) {
            break label151;
          }
          i1 = i2;
          i3 = i4;
          break label153;
        }
      }
      if (this.a != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = i1 & 0x1;
      i1 = i2;
      int i3 = i4;
      if (GameUtil.c(d()))
      {
        i1 = i2;
        if (this.b != null)
        {
          i1 = i2;
          i3 = i4;
        }
        else
        {
          label151:
          i3 = 0;
        }
      }
      label153:
      bool = i3 & i1;
    }
    return bool;
  }
  
  public boolean a(ITopic paramITopic)
  {
    if (paramITopic != null) {
      try
      {
        this.o = 2;
        this.a = paramITopic;
        this.e = null;
        this.p = 0;
        this.r = SystemClock.elapsedRealtime();
        q();
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
      if ((this.a != null) && (this.a.a(paramITopic)) && (paramPlayer != null))
      {
        this.o = 3;
        this.a = paramITopic;
        this.e = paramPlayer;
        this.i = paramInt1;
        this.j = paramLong;
        this.k = paramAnswerInfo;
        a(paramPlayer.uin, paramInt1);
        if ((paramITopic.b() == 1) && (this.b != null))
        {
          this.l = paramInt2;
          a(this.b.uin, paramInt2);
        }
        if (paramBoolean)
        {
          this.p = 0;
          this.r = SystemClock.elapsedRealtime();
        }
        q();
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
      if ((this.a != null) && (this.a.a(paramITopic)))
      {
        this.o = 4;
        this.a = paramITopic;
        this.e = null;
        this.k = paramAnswerInfo;
        if (paramBoolean)
        {
          this.p = 0;
          this.r = SystemClock.elapsedRealtime();
        }
        q();
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
      if ((this.a != null) && (this.a.a(paramITopic)))
      {
        this.o = 4;
        this.a = paramITopic;
        this.e = null;
        if (paramBoolean)
        {
          this.p = 0;
          this.r = SystemClock.elapsedRealtime();
        }
        q();
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
        this.d = paramPlayer;
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
        this.o = 1;
        this.c = this.b;
        this.b = paramPlayer;
        this.a = paramITopic;
        this.e = null;
        if (this.b != null) {
          this.b.status = 2;
        }
        this.p = 0;
        this.q = 0;
        long l1 = SystemClock.elapsedRealtime();
        this.r = l1;
        this.s = l1;
        q();
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
      this.g.clear();
      this.g.addAll(paramList);
      return true;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public void b()
  {
    this.m = "";
    this.n = 0L;
    this.o = 0;
    this.a = null;
    this.b = null;
    this.d = null;
    this.c = null;
    this.e = null;
    this.p = 0;
    this.q = 0;
    this.r = 0L;
    this.s = 0L;
    this.f.a();
    this.g.clear();
    this.i = 0;
    this.l = 0;
    this.h.reset();
    q();
  }
  
  public void b(Game paramGame)
  {
    try
    {
      a(paramGame);
      q();
      return;
    }
    finally
    {
      paramGame = finally;
      throw paramGame;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.h.extraJsonData = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
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
  
  public String c()
  {
    return this.m;
  }
  
  public boolean c(ITopic paramITopic)
  {
    try
    {
      if ((this.a != null) && (this.a.a(paramITopic)))
      {
        this.a = paramITopic;
        this.e = null;
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
    return this.f.b;
  }
  
  public int e()
  {
    return this.f.a;
  }
  
  public int f()
  {
    q();
    return this.o;
  }
  
  public Player g()
  {
    return this.b;
  }
  
  public ITopic h()
  {
    return this.a;
  }
  
  public CopyOnWriteArrayList<UserScore> i()
  {
    return this.g;
  }
  
  protected Game j()
  {
    Game localGame = new Game();
    localGame.a(this);
    return localGame;
  }
  
  public void k()
  {
    this.o = 1;
    long l1 = SystemClock.elapsedRealtime();
    this.r = l1;
    this.s = l1;
    Player localPlayer = this.b;
    if (localPlayer != null) {
      localPlayer.status = 2;
    }
    q();
  }
  
  public boolean l()
  {
    if (this.o != 10)
    {
      this.o = 10;
      this.p = 0;
      this.q = 0;
      this.r = 0L;
      this.s = 0L;
      Player localPlayer = this.b;
      if (localPlayer != null) {
        localPlayer.status = 0;
      }
      q();
      return true;
    }
    return false;
  }
  
  public void m()
  {
    try
    {
      this.o = 0;
      this.p = 0;
      this.r = 0L;
      this.q = 0;
      this.s = 0L;
      q();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int n()
  {
    try
    {
      int i1 = a(true);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int o()
  {
    try
    {
      q();
      if ((this.o != 0) && (this.o != 1))
      {
        long l1 = this.s;
        if (l1 <= 0L) {
          return 0;
        }
        int i1 = (int)(SystemClock.elapsedRealtime() - this.s);
        int i2 = this.q;
        int i3 = this.f.d;
        return i1 + i2 - i3 * 1000;
      }
      return 0;
    }
    finally {}
  }
  
  public int p()
  {
    try
    {
      if (GameUtil.e(d()))
      {
        ITopic localITopic = h();
        if (localITopic != null)
        {
          i1 = localITopic.f();
          return i1 * 1000;
        }
      }
      int i1 = this.f.e;
      return i1 * 1000;
    }
    finally {}
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gameId=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n");
    localStringBuilder.append("status=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusPastTimeSvr=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n");
    localStringBuilder.append("gamePastTimeSvr=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n");
    localStringBuilder.append("statusPastTime=");
    localStringBuilder.append(n());
    localStringBuilder.append("\n");
    localStringBuilder.append("gamePastTime=");
    localStringBuilder.append(o());
    localStringBuilder.append("\n");
    localStringBuilder.append("gameInfo=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("topic=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("player=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    localStringBuilder.append("score=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n");
    localStringBuilder.append("actorScore");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n");
    localStringBuilder.append("rightPlayer=");
    localStringBuilder.append("[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Game
 * JD-Core Version:    0.7.0.1
 */