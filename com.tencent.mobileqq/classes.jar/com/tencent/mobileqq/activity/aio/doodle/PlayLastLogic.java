package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.doodle.IDoodleMsgLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayLastLogic
{
  private static String b = "PlayLastLogic";
  private static PlayLastLogic c;
  public int a = 0;
  private long d = -1L;
  private long e = -1L;
  private boolean f = false;
  private long g = -1L;
  private int h = -1;
  private int i = 0;
  private Map<Integer, MsgInfo> j = new ConcurrentHashMap();
  private Runnable k;
  private Handler l = null;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private WeakReference<BaseDoodleMsgLayout> p;
  private int q;
  private int r;
  
  private int a(int paramInt, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    Object localObject2;
    if (bool)
    {
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkPlayable: bRealPlay:");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (MsgInfo)this.j.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      localObject2 = ((MsgInfo)localObject1).d;
      if (localObject2 != null)
      {
        localObject2 = (BaseDoodleMsgLayout)((WeakReference)localObject2).get();
        if (localObject2 != null)
        {
          Object localObject3 = new Rect();
          if (((BaseDoodleMsgLayout)localObject2).getGlobalVisibleRect((Rect)localObject3))
          {
            double d1 = ((Rect)localObject3).height();
            double d2 = ((BaseDoodleMsgLayout)localObject2).getHeight();
            Double.isNaN(d2);
            if (d1 > d2 * 0.9D)
            {
              if ((!((BaseDoodleMsgLayout)localObject2).e()) && (this.d != ((MsgInfo)localObject1).c) && (((BaseDoodleMsgLayout)localObject2).c()))
              {
                if (paramBoolean)
                {
                  a((BaseDoodleMsgLayout)localObject2, false);
                  if (((MsgInfo)localObject1).c == this.g) {
                    this.f = true;
                  }
                }
                if (QLog.isColorLevel())
                {
                  localObject1 = b;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("checkPlayable: lastID:");
                  ((StringBuilder)localObject2).append(this.e);
                  ((StringBuilder)localObject2).append("lasUniID");
                  ((StringBuilder)localObject2).append(this.g);
                  ((StringBuilder)localObject2).append(" lastMsgPlayed:");
                  ((StringBuilder)localObject2).append(this.f);
                  ((StringBuilder)localObject2).append(" playedID:");
                  ((StringBuilder)localObject2).append(this.d);
                  QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
                }
                return 1;
              }
              if (QLog.isColorLevel())
              {
                localObject3 = b;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkPlayable: can not play:");
                localStringBuilder.append(((MsgInfo)localObject1).a);
                localStringBuilder.append("uniID:");
                localStringBuilder.append(((MsgInfo)localObject1).c);
                localStringBuilder.append(" mPlayedID:");
                localStringBuilder.append(this.d);
                QLog.d((String)localObject3, 2, localStringBuilder.toString());
              }
              paramInt = i1;
              if (!((BaseDoodleMsgLayout)localObject2).e()) {
                return paramInt;
              }
              return 3;
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = b;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkPlayable: invisible MsgID:");
            ((StringBuilder)localObject3).append(((MsgInfo)localObject1).a);
            ((StringBuilder)localObject3).append("uniID:");
            ((StringBuilder)localObject3).append(((MsgInfo)localObject1).c);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    paramInt = 0;
    return paramInt;
  }
  
  public static long a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000)) {
      return paramChatMessage.time;
    }
    return paramChatMessage.shmsgseq;
  }
  
  public static PlayLastLogic a()
  {
    try
    {
      if (c == null) {
        c = new PlayLastLogic();
      }
      return c;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.j.size() == 0) {
      return;
    }
    Iterator localIterator = this.j.entrySet().iterator();
    while (localIterator.hasNext())
    {
      MsgInfo localMsgInfo = (MsgInfo)((Map.Entry)localIterator.next()).getValue();
      if ((localMsgInfo == null) || (localMsgInfo.b < paramInt1) || (localMsgInfo.b > paramInt2)) {
        localIterator.remove();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j.size() == 0) {
      return;
    }
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MsgInfo)localIterator.next();
      if ((localObject != null) && (((MsgInfo)localObject).b >= this.m) && (((MsgInfo)localObject).b <= this.n))
      {
        localObject = ((MsgInfo)localObject).d;
        if (localObject != null)
        {
          localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
          if (localObject != null) {
            ((IDoodleMsgLayout)localObject).b(paramBoolean);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (!this.f)
      {
        if (this.e < 0L) {
          return;
        }
        this.f = true;
        localObject = this.j.values().iterator();
        MsgInfo localMsgInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localMsgInfo = (MsgInfo)((Iterator)localObject).next();
        } while (localMsgInfo.c != this.g);
        localObject = localMsgInfo.d;
        if (localObject == null) {
          return;
        }
        localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
        if (localObject == null) {
          return;
        }
        ((IDoodleMsgLayout)localObject).f();
      }
    }
    else
    {
      int i1 = this.n;
      while (i1 >= this.m)
      {
        if (i1 != paramInt)
        {
          localObject = (MsgInfo)this.j.get(Integer.valueOf(i1));
          if ((localObject != null) && ((((MsgInfo)localObject).a > this.e) || (((MsgInfo)localObject).c == this.g)))
          {
            localObject = ((MsgInfo)localObject).d;
            if (localObject != null)
            {
              localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
              if (localObject != null) {
                ((IDoodleMsgLayout)localObject).f();
              }
            }
          }
        }
        i1 -= 1;
      }
    }
  }
  
  public static long b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.uniseq;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartPlayTimer:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.l == null) {
      this.l = new Handler(Looper.getMainLooper());
    }
    if (this.k != null) {
      this.l.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.k == null) {
      this.k = new PlayLastLogic.1(this);
    }
    this.l.postDelayed(this.k, paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strategy2 :");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" StartPos:");
      localStringBuilder.append(this.m);
      localStringBuilder.append("EndPos:");
      localStringBuilder.append(this.n);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i1 = this.o;
    int i3 = -1;
    int i4;
    if (i1 == 0)
    {
      i2 = this.n;
      for (;;)
      {
        i1 = i3;
        if (i2 < this.m) {
          break;
        }
        i4 = a(i2, paramBoolean);
        if (i4 > 0)
        {
          i1 = i2;
          if (i4 == 1) {
            break;
          }
          i1 = i3;
          if (i4 != 3) {
            break;
          }
          i1 = i2;
          break;
        }
        i2 -= 1;
      }
    }
    int i2 = this.m;
    for (;;)
    {
      i1 = i3;
      if (i2 > this.n) {
        break;
      }
      i4 = a(i2, paramBoolean);
      if (i4 > 0)
      {
        i1 = i2;
        if (i4 != 1)
        {
          i1 = i3;
          if (i4 != 3) {
            break;
          }
          i1 = i2;
        }
        break;
      }
      i2 += 1;
    }
    a(false, i1);
  }
  
  public static void c()
  {
    try
    {
      if (c != null)
      {
        c.b();
        c = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    if (this.a == 0)
    {
      b(1000);
      a(this.m, this.n);
      a(false);
      b(false);
      return;
    }
    b(-1);
    a(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i1 = paramInt2;
    if (paramInt1 == 0)
    {
      i1 = paramInt2;
      if (paramInt3 > 0) {
        i1 = paramInt2 - 1;
      }
    }
    paramInt2 = i1;
    if (paramInt1 + i1 == paramInt5)
    {
      paramInt2 = i1;
      if (paramInt4 > 0) {
        paramInt2 = i1 - 1;
      }
    }
    paramInt1 -= paramInt3;
    if ((this.r == paramInt8) && (this.q == paramInt7))
    {
      paramInt3 = this.h;
      if (paramInt1 > paramInt3)
      {
        this.o = 0;
      }
      else if (paramInt1 < paramInt3)
      {
        this.o = 1;
      }
      else
      {
        paramInt3 = this.i;
        if (paramInt6 < paramInt3) {
          this.o = 0;
        } else if (paramInt6 > paramInt3) {
          this.o = 1;
        }
      }
      this.i = paramInt6;
      this.h = paramInt1;
      paramInt3 = paramInt1;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      }
      this.m = paramInt3;
      paramInt1 = this.m;
      this.n = (paramInt2 + paramInt1 - 1);
      if (this.n < paramInt1) {
        this.n = paramInt1;
      }
      return;
    }
    this.r = paramInt8;
    this.q = paramInt7;
    this.o = 0;
    this.i = paramInt6;
    this.h = paramInt1;
    paramInt3 = paramInt1;
    if (paramInt1 < 0) {
      paramInt3 = 0;
    }
    this.m = paramInt3;
    paramInt1 = this.m;
    this.n = (paramInt2 + paramInt1 - 1);
    if (this.n < paramInt1) {
      this.n = paramInt1;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registLayout:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" pos:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniid:");
      localStringBuilder.append(paramLong1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.j.put(Integer.valueOf(paramInt), new MsgInfo(paramLong1, paramLong2, paramInt, paramBaseDoodleMsgLayout));
    boolean bool;
    if (this.a != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBaseDoodleMsgLayout.b(bool);
    if (a(paramLong1, paramLong2))
    {
      if (QLog.isColorLevel())
      {
        paramBaseDoodleMsgLayout = b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("registLayout: is new msg, lastID:");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" uniID:");
        ((StringBuilder)localObject).append(paramLong1);
        QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
      }
      if (this.a == 0)
      {
        b(1000);
        return;
      }
      this.f = true;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBaseDoodleMsgLayout = b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registLayout: is old msg, lastID:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" uniID:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" lastMsgPlayed:");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(" playedID:");
      ((StringBuilder)localObject).append(this.d);
      QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(BaseDoodleMsgLayout paramBaseDoodleMsgLayout, boolean paramBoolean)
  {
    if (paramBaseDoodleMsgLayout == null) {
      return;
    }
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = (BaseDoodleMsgLayout)((WeakReference)localObject).get();
      if ((localObject != null) && (((BaseDoodleMsgLayout)localObject).e()))
      {
        if ((paramBoolean) && (localObject == paramBaseDoodleMsgLayout))
        {
          ((BaseDoodleMsgLayout)localObject).f();
          return;
        }
        if ((!paramBoolean) && (localObject == paramBaseDoodleMsgLayout))
        {
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "playLayout: same layout, ans is playing, return:");
          }
          return;
        }
        ((BaseDoodleMsgLayout)localObject).f();
      }
    }
    this.p = new WeakReference(paramBaseDoodleMsgLayout);
    paramBaseDoodleMsgLayout.d();
    localObject = this.j.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgInfo localMsgInfo = (MsgInfo)((Iterator)localObject).next();
      if ((localMsgInfo.d != null) && (localMsgInfo.d.get() == paramBaseDoodleMsgLayout))
      {
        this.d = localMsgInfo.c;
        if (QLog.isColorLevel())
        {
          paramBaseDoodleMsgLayout = b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("playLayout: lastPlayedID:");
          ((StringBuilder)localObject).append(this.d);
          QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (paramBoolean) {
      b(-1);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      long l1 = a((ChatMessage)paramList.get(paramList.size() - 1));
      long l2 = b((ChatMessage)paramList.get(paramList.size() - 1));
      if ((l1 > this.e) && (this.g != l2))
      {
        a(true, -1);
        if (this.e < 0L) {
          this.f = ((ChatMessage)paramList.get(paramList.size() - 1)).isread;
        } else {
          this.f = false;
        }
        this.e = l1;
        this.g = l2;
        if (QLog.isColorLevel()) {
          QLog.d(b, 2, "setLastMsgID: a new msg");
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setLastMsgID:");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" :");
        localStringBuilder.append(this.g);
        QLog.d(paramList, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong2 > this.e) && (paramLong1 != this.g)) {
      return true;
    }
    return (this.g == paramLong1) && (!this.f);
  }
  
  public void b()
  {
    this.g = -1L;
    this.e = -1L;
    this.d = -1L;
    this.j.clear();
    this.f = false;
    this.h = 0;
    this.a = 0;
    if (this.k != null) {
      new Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null);
    }
    this.k = null;
    this.l = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic
 * JD-Core Version:    0.7.0.1
 */