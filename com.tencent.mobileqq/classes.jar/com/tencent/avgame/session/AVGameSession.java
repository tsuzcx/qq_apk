package com.tencent.avgame.session;

import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameSession
{
  public int a = 0;
  public String b = null;
  public boolean c;
  public int d = 0;
  public long e = 0L;
  public boolean f = false;
  public boolean g = false;
  public boolean h = true;
  public boolean i = false;
  public int j = 0;
  public boolean k = false;
  public long l = 0L;
  public int m = 0;
  public int n = 0;
  public boolean o = false;
  public final ArrayList<VideoViewInfo> p = new ArrayList(8);
  private int q = 0;
  private final List<AVGameUserInfo> r = new ArrayList(8);
  
  public AVGameSession(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return String.format("%s-%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public AVGameUserInfo a()
  {
    return a(this.l);
  }
  
  public AVGameUserInfo a(long paramLong)
  {
    List localList = this.r;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= this.r.size()) {
          break label90;
        }
        if (((AVGameUserInfo)this.r.get(i1)).mUin == paramLong)
        {
          AVGameUserInfo localAVGameUserInfo = (AVGameUserInfo)this.r.get(i1);
          return localAVGameUserInfo;
        }
      }
      finally
      {
        continue;
        throw localObject1;
        continue;
        i1 += 1;
      }
      continue;
      label90:
      Object localObject2 = null;
    }
  }
  
  public AVGameUserInfo a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    if (paramMultiUserInfo == null) {
      return null;
    }
    ??? = a(paramMultiUserInfo.mUin);
    if (??? != null)
    {
      QavDef.MultiUserInfo.copyTo(paramMultiUserInfo, (QavDef.MultiUserInfo)???);
      return ???;
    }
    synchronized (this.r)
    {
      paramMultiUserInfo = new AVGameUserInfo(paramMultiUserInfo, this.l);
      this.r.add(paramMultiUserInfo);
      return paramMultiUserInfo;
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSessionStatus. old status = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", new status = ");
    localStringBuilder.append(paramInt);
    AVLog.d("AVGameSession", localStringBuilder.toString());
    this.q = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.j;
    if (paramBoolean) {
      this.j = ((paramInt ^ 0xFFFFFFFF) & i1);
    } else {
      this.j = (i1 | paramInt);
    }
    if (i1 != this.j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLocalVideoFlag, mask[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], clear[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], [");
      localStringBuilder.append(i1);
      localStringBuilder.append("->");
      localStringBuilder.append(this.j);
      localStringBuilder.append("]");
      AVLog.d("AVGameSession", localStringBuilder.toString());
    }
  }
  
  public void a(List<Long> paramList)
  {
    ArrayList localArrayList;
    if (paramList != null)
    {
      if (this.r.size() == 0) {
        return;
      }
      localArrayList = new ArrayList(this.r.size());
      localArrayList.addAll(this.r);
    }
    for (;;)
    {
      int i1;
      synchronized (this.r)
      {
        this.r.clear();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          Long localLong = (Long)localIterator.next();
          Object localObject = null;
          i1 = 0;
          paramList = localObject;
          if (i1 < localArrayList.size())
          {
            if (((AVGameUserInfo)localArrayList.get(i1)).mUin != localLong.longValue()) {
              break label294;
            }
            paramList = (AVGameUserInfo)localArrayList.get(i1);
          }
          if (paramList != null)
          {
            this.r.add(paramList);
            localArrayList.remove(paramList);
            continue;
          }
          paramList = new StringBuilder();
          paramList.append("updateUserPos cur[");
          paramList.append(localLong);
          paramList.append("] not exist. ");
          AVLog.d("AVGameSession", paramList.toString());
          continue;
        }
        if (localArrayList.size() > 0)
        {
          paramList = new StringBuilder();
          paramList.append("updateUserPos, user[");
          paramList.append(localArrayList.size());
          paramList.append("] not in list.");
          AVLog.d("AVGameSession", paramList.toString());
          this.r.addAll(localArrayList);
        }
        return;
      }
      return;
      label294:
      i1 += 1;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if ((localObject != null) && (((AVGameUserInfo)localObject).hasVideo()))
    {
      ((AVGameUserInfo)localObject).mBigVideo = paramBoolean;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserBigVideoFlag, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], bigVideoFlag[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], updateSuccess[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if (localObject != null)
    {
      ((AVGameUserInfo)localObject).mVideoOn = paramBoolean;
      ((AVGameUserInfo)localObject).mVideoSrc = paramInt;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserVideoStatus, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], on[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], src[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void b()
  {
    List localList = this.r;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.r.size())
        {
          if ((((AVGameUserInfo)this.r.get(i1)).hasVideo()) && (((AVGameUserInfo)this.r.get(i1)).mBigVideo)) {
            ((AVGameUserInfo)this.r.get(i1)).mBigVideo = false;
          }
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("AVGameSession", 4, "clearUserBigVideoFlag");
          }
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i1 += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.m != paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStageStatus, [");
      localStringBuilder.append(this.m);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      AVLog.d("AVGameSession", localStringBuilder.toString());
      this.m = paramInt;
    }
  }
  
  public void b(long paramLong)
  {
    AVGameUserInfo localAVGameUserInfo = a(paramLong);
    if (localAVGameUserInfo != null) {
      synchronized (this.r)
      {
        this.r.remove(localAVGameUserInfo);
        return;
      }
    }
  }
  
  public void b(List<AVGameUserInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList.clear();
    synchronized (this.r)
    {
      paramList.addAll(this.r);
      return;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = a(paramLong);
    boolean bool;
    if (localObject != null)
    {
      ((AVGameUserInfo)localObject).mSubVideoOn = paramBoolean;
      ((AVGameUserInfo)localObject).mSubVideoSrc = paramInt;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserVideoStatus, uin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], on[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], src[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameSession", 4, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public int c()
  {
    return this.q;
  }
  
  public void c(List<AVGameUserInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList.clear();
    List localList = this.r;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 < this.r.size())
        {
          if (((AVGameUserInfo)this.r.get(i1)).hasVideo()) {
            paramList.add(this.r.get(i1));
          }
        }
        else {
          return;
        }
      }
      finally
      {
        continue;
        throw paramList;
        continue;
        i1 += 1;
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    return (this.j & paramInt) == paramInt;
  }
  
  public boolean d()
  {
    int i1 = this.q;
    return (i1 == 0) || (i1 == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("[sessionId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", relationType: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", relationId: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", localSpeakerOn: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", localMute: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", localVideoFlag: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isAutoGoOnStage: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", stageStatus: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.session.AVGameSession
 * JD-Core Version:    0.7.0.1
 */