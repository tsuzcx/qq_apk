package com.tencent.avgame.gamelogic.data;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.Indexable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EngineData
  implements Cloneable
{
  public int A;
  public boolean B = true;
  private RoomInfo C = new RoomInfo();
  private Game D = new Game();
  private CopyOnWriteArrayList<QuestionClassInfo> E = new CopyOnWriteArrayList();
  public CopyOnWriteArrayList<GameItem> a = new CopyOnWriteArrayList();
  public volatile int b;
  public List<ITopic> c = new ArrayList();
  public String d;
  public String e;
  public volatile boolean f;
  public volatile int g;
  public volatile int h;
  public volatile int i = 0;
  public volatile int j;
  public volatile int k;
  public volatile long l;
  public volatile int m;
  public volatile int n;
  public volatile int o;
  public volatile boolean p;
  public volatile List<Long> q = new ArrayList();
  public volatile List<Long> r = new ArrayList();
  public volatile List<Long> s = new ArrayList();
  public volatile SurvivalPkResultInfo t = new SurvivalPkResultInfo();
  public volatile boolean u = false;
  public volatile boolean v = true;
  public volatile PkCJOperationData w = new PkCJOperationData();
  public volatile FontStyleConfig x = new FontStyleConfig();
  public volatile long y;
  public volatile byte z;
  
  public EngineData()
  {
    a();
  }
  
  private void am()
  {
    b(this.D.b);
    b(this.D.c);
    b(this.D.d);
    b(this.D.e);
  }
  
  public int A()
  {
    ITopic localITopic = s();
    if ((localITopic instanceof Indexable)) {
      return ((Indexable)localITopic).aC_();
    }
    return 0;
  }
  
  public int B()
  {
    return h().f.i;
  }
  
  public List<ITopic> C()
  {
    s();
    int i1 = A();
    ArrayList localArrayList = new ArrayList();
    while (i1 < this.c.size())
    {
      localArrayList.add(this.c.get(i1));
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void D()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        GameItem localGameItem = (GameItem)((Iterator)localObject).next();
        if (GameUtil.a(localGameItem))
        {
          if ((localGameItem.p == 1) && (localGameItem.q <= NetConnInfoCenter.getServerTime())) {
            localGameItem.p = 2;
          }
          if (localGameItem.r <= NetConnInfoCenter.getServerTime())
          {
            int i1 = this.a.indexOf(localGameItem);
            if (this.b == i1) {
              this.b = 0;
            }
            this.a.remove(localGameItem);
          }
        }
      }
    }
  }
  
  public long E()
  {
    long l1 = 9223372036854775807L;
    int i1 = 0;
    while (i1 < this.a.size())
    {
      GameItem localGameItem = (GameItem)this.a.get(i1);
      long l2 = l1;
      if (GameUtil.b((GameItem)this.a.get(i1)))
      {
        l2 = localGameItem.q - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          return 0L;
        }
        l2 = Math.min(l1, l2);
      }
      i1 += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public long F()
  {
    long l1 = 9223372036854775807L;
    int i1 = 0;
    while (i1 < this.a.size())
    {
      GameItem localGameItem = (GameItem)this.a.get(i1);
      long l2 = l1;
      if (GameUtil.a((GameItem)this.a.get(i1)))
      {
        l2 = localGameItem.r - NetConnInfoCenter.getServerTime();
        if (l2 < 0L) {
          return 0L;
        }
        l2 = Math.min(l1, l2);
      }
      i1 += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public long G()
  {
    return Math.min(E(), F());
  }
  
  public int H()
  {
    int i1 = h().f.h;
    if (i1 == 0)
    {
      i1 = h().f.c;
      int i2 = h().f.e + h().f.f;
      if (i2 > 0) {
        return i1 / i2;
      }
    }
    else if (i1 == 1)
    {
      return h().f.i;
    }
    return 0;
  }
  
  public int I()
  {
    RoomInfo localRoomInfo = this.C;
    if (localRoomInfo == null) {
      return 0;
    }
    return localRoomInfo.getUins().size();
  }
  
  public int J()
  {
    int i1 = 0;
    try
    {
      if (this.C != null) {
        i1 = this.C.matchShareId;
      }
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] K()
  {
    try
    {
      if (this.C != null)
      {
        byte[] arrayOfByte = this.C.matchV2Extra;
        return arrayOfByte;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean L()
  {
    try
    {
      RoomInfo localRoomInfo = this.C;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localRoomInfo != null)
      {
        int i1 = this.C.getPlayers().size();
        bool1 = bool2;
        if (i1 >= 8) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean M()
  {
    return this.f;
  }
  
  public boolean N()
  {
    return this.u;
  }
  
  public boolean O()
  {
    return this.v;
  }
  
  public int P()
  {
    return this.g;
  }
  
  public int Q()
  {
    return this.h;
  }
  
  public int R()
  {
    return this.n;
  }
  
  public int S()
  {
    return this.o;
  }
  
  public boolean T()
  {
    return this.p;
  }
  
  public List<Long> U()
  {
    return this.q;
  }
  
  public List<Long> V()
  {
    return this.r;
  }
  
  public int W()
  {
    return this.k;
  }
  
  public int X()
  {
    return this.j;
  }
  
  public int Y()
  {
    return this.i;
  }
  
  public SurvivalPkResultInfo Z()
  {
    return this.t;
  }
  
  public RoomInfo a(RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    try
    {
      this.C.copyFrom(paramRoomInfo);
      if (paramBoolean)
      {
        this.D.b();
        this.c.clear();
      }
      paramRoomInfo = this.C;
      return paramRoomInfo;
    }
    finally {}
  }
  
  public void a()
  {
    this.C.reset();
    this.D.b();
    this.a.clear();
    this.b = 0;
    this.c.clear();
    this.f = false;
    this.v = true;
    this.u = false;
    this.g = 0;
    this.l = 0L;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0L;
    this.y = 0L;
    this.z = 0;
    this.n = 0;
    this.o = 0;
    this.m = 0;
    this.p = false;
    this.q.clear();
    this.r.clear();
    this.s.clear();
    this.t = new SurvivalPkResultInfo();
    this.w = new PkCJOperationData();
    this.x = new FontStyleConfig();
    this.A = 0;
    this.B = true;
  }
  
  public void a(int paramInt)
  {
    try
    {
      i3 = this.b;
      i1 = 0;
    }
    finally
    {
      for (;;)
      {
        int i3;
        int i1;
        int i2;
        for (;;)
        {
          throw localObject;
        }
        label68:
        i1 += 1;
      }
    }
    i2 = i3;
    if (i1 < this.a.size())
    {
      if (paramInt != ((GameItem)this.a.get(i1)).a) {
        break label68;
      }
      i2 = i1;
    }
    this.b = i2;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initForSurvivalPk ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramBoolean);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.f = true;
    this.h = paramInt;
    this.u = paramBoolean;
  }
  
  public void a(long paramLong, int paramInt)
  {
    try
    {
      if ((this.C != null) && (this.C.id == paramLong)) {
        this.C.matchStatus = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(PkCJOperationData paramPkCJOperationData)
  {
    this.w = paramPkCJOperationData;
  }
  
  public void a(SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    this.t.copyFrom(paramSurvivalPkResultInfo);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.D.b(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      this.D.a(paramString1, paramString2, paramLong);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(List<GameItem> paramList, int paramInt)
  {
    try
    {
      this.a.clear();
      if (paramList == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GameItem localGameItem = (GameItem)paramList.next();
        if (GameUtil.f(GameUtil.b(localGameItem.a))) {
          this.a.add(localGameItem);
        }
      }
      D();
      this.b = paramInt;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<QuestionClassInfo> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramString1 != null) && (paramString2 != null)) {
      try
      {
        this.E.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QuestionClassInfo localQuestionClassInfo = (QuestionClassInfo)paramList.next();
          this.E.add(localQuestionClassInfo);
        }
        this.d = paramString1;
        this.e = paramString2;
        return;
      }
      finally {}
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      this.C.updateNicks(paramMap);
      am();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.C != null) {
        this.C.matchV2Extra = paramArrayOfByte;
      }
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean a(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.D.a(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(ITopic paramITopic, int paramInt1, Player paramPlayer, long paramLong, int paramInt2, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.D.a(paramITopic, paramInt1, paramPlayer, paramLong, paramInt2, paramAnswerInfo, paramBoolean);
      if (paramBoolean) {
        b(this.D.e);
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public boolean a(ITopic paramITopic, AnswerInfo paramAnswerInfo, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.D.a(paramITopic, paramAnswerInfo, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(ITopic paramITopic, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.D.a(paramITopic, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean a(Game paramGame)
  {
    try
    {
      this.D.a(paramGame);
      this.D.k();
      this.C.onGameStart();
      this.c.clear();
      am();
      if (this.f)
      {
        g(3);
        if ((paramGame != null) && (this.a != null))
        {
          int i1 = 0;
          while (i1 < this.a.size())
          {
            if (((GameItem)this.a.get(i1)).a == paramGame.f.a)
            {
              this.b = i1;
              break;
            }
            i1 += 1;
          }
        }
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramGame;
    }
  }
  
  public boolean a(Player paramPlayer)
  {
    try
    {
      boolean bool = this.D.a(paramPlayer);
      if (bool) {
        b(this.D.d);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(Player paramPlayer, ITopic paramITopic)
  {
    try
    {
      boolean bool = this.D.a(paramPlayer, paramITopic);
      if (bool) {
        b(this.D.b);
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      if ((paramString.equalsIgnoreCase(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) && (paramInt == 1)) {
        this.D.m();
      }
      this.C.onChangeUserStatus(paramString, paramInt);
      return true;
    }
    finally {}
  }
  
  public boolean a(List<UserScore> paramList)
  {
    try
    {
      boolean bool = this.D.a(paramList);
      return bool;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = this.C;
      boolean bool = false;
      if (localObject1 != null)
      {
        if (paramBoolean)
        {
          paramBoolean = bool;
          if (this.C.isRoomMatching()) {
            if (this.C.matchShareId <= 0)
            {
              localObject1 = this.C.matchV2Extra;
              paramBoolean = bool;
              if (localObject1 == null) {}
            }
            else
            {
              paramBoolean = true;
            }
          }
          return paramBoolean;
        }
        paramBoolean = this.C.isRoomMatching();
        return paramBoolean;
      }
      return false;
    }
    finally {}
  }
  
  public int aa()
  {
    return this.m;
  }
  
  public boolean ab()
  {
    try
    {
      boolean bool = this.C.fromMatchB2;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean ac()
  {
    try
    {
      boolean bool = this.C.startMatching2Quick;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String ad()
  {
    return this.w.bizTitlePicIdx;
  }
  
  public String ae()
  {
    return this.w.bizTitelPicUrl;
  }
  
  public String af()
  {
    return this.w.biaAdTip;
  }
  
  public String ag()
  {
    return this.w.waitingBgUrl;
  }
  
  public int ah()
  {
    return this.w.sponsorId;
  }
  
  public String ai()
  {
    return this.w.answerTip;
  }
  
  public int aj()
  {
    return this.D.f.b();
  }
  
  public int ak()
  {
    return this.A;
  }
  
  public boolean al()
  {
    return this.B;
  }
  
  public int b(String paramString)
  {
    return this.D.a(paramString);
  }
  
  public Game b(Game paramGame)
  {
    try
    {
      this.D.b(paramGame);
      paramGame = this.D;
      return paramGame;
    }
    finally
    {
      paramGame = finally;
      throw paramGame;
    }
  }
  
  public QuestionClassInfo b(int paramInt)
  {
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.E.iterator();
      Object localObject1;
      int i1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (QuestionClassInfo)localIterator.next();
        i1 = ((QuestionClassInfo)localObject1).a;
      } while (i1 != paramInt);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b()
  {
    this.C.reset();
    this.D.b();
    this.a.clear();
    this.b = 0;
    this.c.clear();
  }
  
  public void b(long paramLong, int paramInt)
  {
    try
    {
      if ((this.C != null) && (this.C.id == paramLong)) {
        this.C.matchShareId = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      if (TextUtils.isEmpty(paramPlayer.uin)) {
        return;
      }
      Iterator localIterator = this.C.players.iterator();
      while (localIterator.hasNext())
      {
        Player localPlayer = (Player)localIterator.next();
        if (paramPlayer.isSame(localPlayer)) {
          paramPlayer.nick = localPlayer.nick;
        }
      }
    }
  }
  
  public void b(List<Long> paramList)
  {
    this.r.clear();
    this.q.clear();
    this.q.addAll(paramList);
    Iterator localIterator1 = this.s.iterator();
    while (localIterator1.hasNext())
    {
      int i2 = 0;
      Long localLong = (Long)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      do
      {
        i1 = i2;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!localLong.equals((Long)localIterator2.next()));
      int i1 = 1;
      if (i1 == 0) {
        this.r.add(localLong);
      } else {
        this.q.remove(localLong);
      }
    }
    this.s.clear();
    this.s.addAll(paramList);
  }
  
  public void b(List<Long> paramList, int paramInt)
  {
    this.r.clear();
    this.q.clear();
    if (paramInt == 1)
    {
      this.q.addAll(paramList);
      return;
    }
    if (paramInt == 2) {
      this.r.addAll(paramList);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public boolean b(ITopic paramITopic)
  {
    if (paramITopic == null) {
      return false;
    }
    try
    {
      paramITopic = paramITopic.i();
      this.c.clear();
      this.c.addAll(paramITopic);
      return true;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public void c()
  {
    this.C.reset();
    this.D.b();
    this.a.clear();
    this.b = 0;
    this.c.clear();
    this.g = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0L;
    this.y = 0L;
    this.z = 0;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    this.p = false;
    this.q.clear();
    this.r.clear();
    this.s.clear();
    this.t = new SurvivalPkResultInfo();
  }
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalPoolId ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.g = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean c(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.D.b(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean c(String paramString)
  {
    if (z())
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if ((this.D.b != null) && (paramString.equalsIgnoreCase(this.D.b.uin))) {
        return true;
      }
    }
    return false;
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.C.id != 0L) && (!TextUtils.isEmpty(this.D.c()));
  }
  
  public boolean d(ITopic paramITopic)
  {
    try
    {
      boolean bool = this.D.c(paramITopic);
      return bool;
    }
    finally
    {
      paramITopic = finally;
      throw paramITopic;
    }
  }
  
  public boolean d(String paramString)
  {
    if ((this.D.f() != 0) && (this.D.f() != 10)) {
      return c(paramString);
    }
    return false;
  }
  
  public RoomInfo e()
  {
    return this.C;
  }
  
  public void e(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFromMatchV2 ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EngineData", 2, localStringBuilder.toString());
      this.C.fromMatchB2 = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e(String paramString)
  {
    int i1 = this.D.f();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      if (this.D.f() == 10) {
        return false;
      }
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      bool1 = bool2;
      if (o() == 3)
      {
        bool1 = bool2;
        if (TextUtils.equals(paramString, str)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public GameItem f()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > this.b)) {
      return (GameItem)this.a.get(this.b);
    }
    return null;
  }
  
  public void f(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalPkState ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.k = paramInt;
  }
  
  public void f(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMatchingB2Quick ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EngineData", 2, localStringBuilder.toString());
      this.C.startMatching2Quick = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f(String paramString)
  {
    return c(paramString);
  }
  
  public String g()
  {
    if (o() == 3) {
      return MobileQQ.sMobileQQ.getApplicationContext().getString(2131887425);
    }
    int i1 = p();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GameItem localGameItem = (GameItem)localIterator.next();
      if ((localGameItem != null) && (localGameItem.a == i1)) {
        return localGameItem.b;
      }
    }
    return "";
  }
  
  public void g(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalGameStatus ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.j = paramInt;
  }
  
  public boolean g(String paramString)
  {
    return Long.toString(this.C.owner).equalsIgnoreCase(paramString);
  }
  
  public Game h()
  {
    return this.D;
  }
  
  public void h(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSurvivalCurRound ");
    localStringBuilder.append(paramInt);
    QLog.d("EngineData", 2, localStringBuilder.toString());
    this.i = paramInt;
  }
  
  public long i()
  {
    return this.C.id;
  }
  
  public void i(int paramInt)
  {
    this.m = paramInt;
  }
  
  public int j()
  {
    return this.D.f();
  }
  
  public void k()
  {
    this.D.k = null;
  }
  
  public boolean l()
  {
    return this.D.k == null;
  }
  
  public int m()
  {
    Player localPlayer = q();
    if (localPlayer != null) {
      return localPlayer.status;
    }
    return 1;
  }
  
  public String n()
  {
    return this.D.c();
  }
  
  public int o()
  {
    return this.D.d();
  }
  
  public int p()
  {
    return this.D.e();
  }
  
  public Player q()
  {
    String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    return this.C.getPlayer(str);
  }
  
  public Player r()
  {
    try
    {
      Player localPlayer = this.D.g();
      return localPlayer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ITopic s()
  {
    try
    {
      ITopic localITopic = this.D.h();
      return localITopic;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ITopic> t()
  {
    try
    {
      List localList = this.c;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n");
    localStringBuilder.append("roomInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.C);
    localStringBuilder.append("\n");
    localStringBuilder.append("game");
    localStringBuilder.append("=");
    localStringBuilder.append(this.D);
    localStringBuilder.append("\n");
    localStringBuilder.append("curGameIndex");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("gameListSize");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append("\n");
    localStringBuilder.append("topicCount");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c.size());
    return localStringBuilder.toString();
  }
  
  public boolean u()
  {
    try
    {
      boolean bool = this.D.l();
      if (bool) {
        this.C.onGameOver();
      }
      return bool;
    }
    finally {}
  }
  
  public GameRecordInfo v()
  {
    try
    {
      if (this.D.h.gameType == 0) {
        this.D.h.gameType = o();
      }
      GameRecordInfo localGameRecordInfo = this.D.h;
      return localGameRecordInfo;
    }
    finally {}
  }
  
  /* Error */
  public EngineData w()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 2	com/tencent/avgame/gamelogic/data/EngineData
    //   5: dup
    //   6: invokespecial 643	com/tencent/avgame/gamelogic/data/EngineData:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: getfield 102	com/tencent/avgame/gamelogic/data/EngineData:C	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   14: aload_0
    //   15: getfield 102	com/tencent/avgame/gamelogic/data/EngineData:C	Lcom/tencent/avgame/gamelogic/data/RoomInfo;
    //   18: invokevirtual 279	com/tencent/avgame/gamelogic/data/RoomInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/RoomInfo;)V
    //   21: aload_1
    //   22: getfield 107	com/tencent/avgame/gamelogic/data/EngineData:D	Lcom/tencent/avgame/gamelogic/data/Game;
    //   25: aload_0
    //   26: getfield 107	com/tencent/avgame/gamelogic/data/EngineData:D	Lcom/tencent/avgame/gamelogic/data/Game;
    //   29: invokevirtual 394	com/tencent/avgame/gamelogic/data/Game:a	(Lcom/tencent/avgame/gamelogic/data/Game;)V
    //   32: aload_1
    //   33: getfield 61	com/tencent/avgame/gamelogic/data/EngineData:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   36: aload_0
    //   37: getfield 61	com/tencent/avgame/gamelogic/data/EngineData:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   40: invokevirtual 644	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 199	com/tencent/avgame/gamelogic/data/EngineData:b	I
    //   49: putfield 199	com/tencent/avgame/gamelogic/data/EngineData:b	I
    //   52: aload_1
    //   53: getfield 66	com/tencent/avgame/gamelogic/data/EngineData:c	Ljava/util/List;
    //   56: aload_0
    //   57: getfield 66	com/tencent/avgame/gamelogic/data/EngineData:c	Ljava/util/List;
    //   60: invokeinterface 515 2 0
    //   65: pop
    //   66: aload_1
    //   67: getfield 68	com/tencent/avgame/gamelogic/data/EngineData:E	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   70: aload_0
    //   71: getfield 68	com/tencent/avgame/gamelogic/data/EngineData:E	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   74: invokevirtual 644	java/util/concurrent/CopyOnWriteArrayList:addAll	(Ljava/util/Collection;)Z
    //   77: pop
    //   78: aload_1
    //   79: aload_0
    //   80: getfield 364	com/tencent/avgame/gamelogic/data/EngineData:d	Ljava/lang/String;
    //   83: putfield 364	com/tencent/avgame/gamelogic/data/EngineData:d	Ljava/lang/String;
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 366	com/tencent/avgame/gamelogic/data/EngineData:e	Ljava/lang/String;
    //   91: putfield 366	com/tencent/avgame/gamelogic/data/EngineData:e	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 247	com/tencent/avgame/gamelogic/data/EngineData:f	Z
    //   99: putfield 247	com/tencent/avgame/gamelogic/data/EngineData:f	Z
    //   102: aload_1
    //   103: aload_0
    //   104: getfield 85	com/tencent/avgame/gamelogic/data/EngineData:v	Z
    //   107: putfield 85	com/tencent/avgame/gamelogic/data/EngineData:v	Z
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 83	com/tencent/avgame/gamelogic/data/EngineData:u	Z
    //   115: putfield 83	com/tencent/avgame/gamelogic/data/EngineData:u	Z
    //   118: aload_1
    //   119: aload_0
    //   120: getfield 252	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   123: putfield 252	com/tencent/avgame/gamelogic/data/EngineData:g	I
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 254	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   131: putfield 254	com/tencent/avgame/gamelogic/data/EngineData:h	I
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 70	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   139: putfield 70	com/tencent/avgame/gamelogic/data/EngineData:i	I
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 272	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   147: putfield 272	com/tencent/avgame/gamelogic/data/EngineData:j	I
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 269	com/tencent/avgame/gamelogic/data/EngineData:k	I
    //   155: putfield 269	com/tencent/avgame/gamelogic/data/EngineData:k	I
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 290	com/tencent/avgame/gamelogic/data/EngineData:l	J
    //   163: putfield 290	com/tencent/avgame/gamelogic/data/EngineData:l	J
    //   166: aload_1
    //   167: aload_0
    //   168: getfield 292	com/tencent/avgame/gamelogic/data/EngineData:y	J
    //   171: putfield 292	com/tencent/avgame/gamelogic/data/EngineData:y	J
    //   174: aload_1
    //   175: aload_0
    //   176: getfield 294	com/tencent/avgame/gamelogic/data/EngineData:z	B
    //   179: putfield 294	com/tencent/avgame/gamelogic/data/EngineData:z	B
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 257	com/tencent/avgame/gamelogic/data/EngineData:n	I
    //   187: putfield 257	com/tencent/avgame/gamelogic/data/EngineData:n	I
    //   190: aload_1
    //   191: aload_0
    //   192: getfield 260	com/tencent/avgame/gamelogic/data/EngineData:o	I
    //   195: putfield 260	com/tencent/avgame/gamelogic/data/EngineData:o	I
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 296	com/tencent/avgame/gamelogic/data/EngineData:m	I
    //   203: putfield 296	com/tencent/avgame/gamelogic/data/EngineData:m	I
    //   206: aload_1
    //   207: aload_0
    //   208: getfield 263	com/tencent/avgame/gamelogic/data/EngineData:p	Z
    //   211: putfield 263	com/tencent/avgame/gamelogic/data/EngineData:p	Z
    //   214: aload_1
    //   215: getfield 72	com/tencent/avgame/gamelogic/data/EngineData:q	Ljava/util/List;
    //   218: aload_0
    //   219: getfield 72	com/tencent/avgame/gamelogic/data/EngineData:q	Ljava/util/List;
    //   222: invokeinterface 515 2 0
    //   227: pop
    //   228: aload_1
    //   229: getfield 74	com/tencent/avgame/gamelogic/data/EngineData:r	Ljava/util/List;
    //   232: aload_0
    //   233: getfield 74	com/tencent/avgame/gamelogic/data/EngineData:r	Ljava/util/List;
    //   236: invokeinterface 515 2 0
    //   241: pop
    //   242: aload_1
    //   243: getfield 76	com/tencent/avgame/gamelogic/data/EngineData:s	Ljava/util/List;
    //   246: aload_0
    //   247: getfield 76	com/tencent/avgame/gamelogic/data/EngineData:s	Ljava/util/List;
    //   250: invokeinterface 515 2 0
    //   255: pop
    //   256: aload_1
    //   257: getfield 81	com/tencent/avgame/gamelogic/data/EngineData:t	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   260: aload_0
    //   261: getfield 81	com/tencent/avgame/gamelogic/data/EngineData:t	Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;
    //   264: invokevirtual 341	com/tencent/avgame/gamelogic/data/SurvivalPkResultInfo:copyFrom	(Lcom/tencent/avgame/gamelogic/data/SurvivalPkResultInfo;)V
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 90	com/tencent/avgame/gamelogic/data/EngineData:w	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   272: putfield 90	com/tencent/avgame/gamelogic/data/EngineData:w	Lcom/tencent/avgame/gamelogic/data/PkCJOperationData;
    //   275: aload_1
    //   276: aload_0
    //   277: getfield 95	com/tencent/avgame/gamelogic/data/EngineData:x	Lcom/tencent/avgame/data/FontStyleConfig;
    //   280: putfield 95	com/tencent/avgame/gamelogic/data/EngineData:x	Lcom/tencent/avgame/data/FontStyleConfig;
    //   283: aload_1
    //   284: aload_0
    //   285: getfield 298	com/tencent/avgame/gamelogic/data/EngineData:A	I
    //   288: putfield 298	com/tencent/avgame/gamelogic/data/EngineData:A	I
    //   291: aload_1
    //   292: aload_0
    //   293: getfield 97	com/tencent/avgame/gamelogic/data/EngineData:B	Z
    //   296: putfield 97	com/tencent/avgame/gamelogic/data/EngineData:B	Z
    //   299: aload_0
    //   300: monitorexit
    //   301: aload_1
    //   302: areturn
    //   303: astore_1
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    //   308: astore_2
    //   309: goto -10 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	EngineData
    //   9	293	1	localEngineData	EngineData
    //   303	4	1	localObject	Object
    //   308	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	303	finally
    //   10	299	303	finally
    //   10	299	308	java/lang/Exception
  }
  
  public String x()
  {
    String str = this.D.f.g;
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (str.length() != 0) {}
    }
    else
    {
      localObject = b(this.D.e());
      int i1;
      if ((localObject != null) && (((QuestionClassInfo)localObject).b != null) && (((QuestionClassInfo)localObject).b.size() > 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return MobileQQ.sMobileQQ.getApplicationContext().getString(2131887346);
      }
      localObject = null;
    }
    return localObject;
  }
  
  public String y()
  {
    String str = x();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      if (str.length() == 0) {
        return null;
      }
      localObject1 = b(this.D.e());
      if (localObject1 != null)
      {
        localObject1 = ((QuestionClassInfo)localObject1).b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localQuestionClassInfoItem = (QuestionClassInfoItem)((Iterator)localObject1).next();
          if ((localQuestionClassInfoItem.a != null) && (localQuestionClassInfoItem.a.equals(str))) {
            break label92;
          }
        }
      }
      QuestionClassInfoItem localQuestionClassInfoItem = null;
      label92:
      localObject1 = localObject2;
      if (localQuestionClassInfoItem != null) {
        localObject1 = localQuestionClassInfoItem.c;
      }
    }
    return localObject1;
  }
  
  public boolean z()
  {
    return GameUtil.c(o());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.EngineData
 * JD-Core Version:    0.7.0.1
 */