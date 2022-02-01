package com.tencent.av.wtogether.data;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WatchTogetherInfo
{
  public final String a;
  public final String b;
  public final int c;
  public final String d;
  public boolean e = false;
  public ChooseFileInfo f;
  public WTogetherRoom g;
  public WTInfoFromPush h = null;
  public int i = 0;
  public int j = 0;
  public final ArrayList<Long> k = new ArrayList();
  private int l;
  private long m;
  private boolean n;
  private int o;
  
  public WatchTogetherInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
    this.l = a(paramInt);
    this.m = 0L;
    this.g = null;
    this.n = false;
    this.i = 0;
  }
  
  private static int a(int paramInt)
  {
    if (paramInt == 3) {
      return 2;
    }
    if (paramInt == 1) {
      return 3;
    }
    return 0;
  }
  
  private static long a(SessionInfo paramSessionInfo)
  {
    VideoController localVideoController = VideoController.f();
    long l2 = paramSessionInfo.D();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (localVideoController != null)
      {
        if (paramSessionInfo.p()) {
          return localVideoController.b(paramSessionInfo);
        }
        l1 = localVideoController.a(paramSessionInfo);
      }
    }
    return l1;
  }
  
  public int a()
  {
    return this.o;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update, from[");
      localStringBuilder.append(this.l);
      localStringBuilder.append(",");
      localStringBuilder.append(this.m);
      localStringBuilder.append("], to[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("WatchTogetherInfo", 2, localStringBuilder.toString());
    }
    if ((this.l != paramInt) || (this.m != paramLong))
    {
      this.l = paramInt;
      this.m = paramLong;
    }
    if (this.o == 1) {
      f();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.o != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFlag, [");
        localStringBuilder.append(this.o);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WatchTogetherInfo", 2, localStringBuilder.toString());
      }
      this.o = paramInt;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo == null) {
      return;
    }
    if ((paramBoolean) || (this.l == 0)) {
      this.l = a(this.c);
    }
    if ((paramBoolean) || (this.m == 0L)) {
      this.m = a(paramSessionInfo);
    }
    if (this.o == 1) {
      f();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.n != paramBoolean)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateChangeFileFlag, [");
        localStringBuilder.append(this.n);
        localStringBuilder.append(" --> ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("");
        QLog.i("WatchTogetherInfo", 4, localStringBuilder.toString());
      }
      this.n = paramBoolean;
    }
  }
  
  public boolean b()
  {
    return (this.m != 0L) && (this.l != 0);
  }
  
  public int c()
  {
    return this.l;
  }
  
  public long d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    return this.n;
  }
  
  public WTogetherRoom f()
  {
    if ((this.g == null) && (b()))
    {
      this.g = new WTogetherRoom(this.l, this.m, this.a);
    }
    else
    {
      Object localObject = this.g;
      if ((localObject != null) && (!((WTogetherRoom)localObject).a(this.l, this.m)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkAndCreateRoom, not same come[");
          ((StringBuilder)localObject).append(this.l);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.m);
          ((StringBuilder)localObject).append("], cur[");
          ((StringBuilder)localObject).append(this.g.b);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.g.c);
          ((StringBuilder)localObject).append("]");
          QLog.i("WatchTogetherInfo", 2, ((StringBuilder)localObject).toString());
        }
        this.g = new WTogetherRoom(this.l, this.m, this.a);
      }
    }
    return this.g;
  }
  
  public long[] g()
  {
    long[] arrayOfLong = new long[this.k.size()];
    int i1 = 0;
    while (i1 < arrayOfLong.length)
    {
      if (this.k.get(i1) != null) {
        arrayOfLong[i1] = ((Long)this.k.get(i1)).longValue();
      } else {
        arrayOfLong[i1] = 0L;
      }
      i1 += 1;
    }
    return arrayOfLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherInfo{sessionId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", selfUin: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", flag: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", relationType: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", relationId: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", roomType: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", quitReason: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isChangingFile: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", room: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WatchTogetherInfo
 * JD-Core Version:    0.7.0.1
 */