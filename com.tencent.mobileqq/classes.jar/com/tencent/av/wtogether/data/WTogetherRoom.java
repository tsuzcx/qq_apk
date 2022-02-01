package com.tencent.av.wtogether.data;

import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import trpc.qq_av_together.common.WTogetherCommon.PlayerStatus;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;
import trpc.qq_av_together.common.WTogetherCommon.RoomUserInfo;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoRsp;

public class WTogetherRoom
{
  public long a;
  public final int b;
  public final long c;
  public final String d;
  public String e = null;
  public String f = null;
  public long g = 0L;
  public WTogetherPlayInfo h = null;
  public List<WTogetherCommon.RoomUserInfo> i = null;
  public final WTSyncPlayInfo j = new WTSyncPlayInfo();
  private int k = 0;
  private int l = 1;
  private boolean m = false;
  private boolean n = false;
  private long o = 0L;
  
  public WTogetherRoom(int paramInt, long paramLong, String paramString)
  {
    this.b = paramInt;
    this.c = paramLong;
    this.d = paramString;
  }
  
  public long a()
  {
    this.o += 1L;
    return this.o;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.k != paramInt1) || (this.l != paramInt2))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRoomState, cur[");
        ((StringBuilder)localObject).append(this.k);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.l);
        ((StringBuilder)localObject).append("], to[");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("], from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether.room", 2, ((StringBuilder)localObject).toString());
      }
      if (this.k != paramInt1)
      {
        localObject = SessionMgr.a().b();
        ((SessionInfo)localObject).a(paramInt1, paramString);
        if ((((SessionInfo)localObject).D() != this.c) && (QLog.isColorLevel()))
        {
          paramString = new StringBuilder();
          paramString.append("updateRoomState error, not same id. [");
          paramString.append(((SessionInfo)localObject).D());
          paramString.append(", ");
          paramString.append(this.c);
          paramString.append("]");
          QLog.i("WTogether.room", 2, paramString.toString());
        }
      }
      this.k = paramInt1;
      this.l = paramInt2;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.e, paramString)) {
      this.e = paramString;
    }
    if ((!i()) && ((!TextUtils.equals(this.e, paramString)) || (TextUtils.isEmpty(this.f))))
    {
      this.f = SessionMgr.a().b().t;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRoomAdmin, uin[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], nick[");
        localStringBuilder.append(this.f);
        localStringBuilder.append("]");
        QLog.i("WTogether.room", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.m = paramBoolean;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUpdateFromAdminFlag, flag[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.room", 4, localStringBuilder.toString());
    }
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.b == paramInt) && (this.c == paramLong);
  }
  
  public boolean a(WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramRoomInfo != null)
    {
      if (this.c != paramRoomInfo.roomid.get()) {
        return false;
      }
      long l2 = this.a;
      a(String.valueOf(paramRoomInfo.owner_uin.get()));
      long l1;
      if (paramRoomInfo.seq.has()) {
        l1 = paramRoomInfo.seq.get();
      } else {
        l1 = l2;
      }
      this.a = l1;
      this.i = paramRoomInfo.users.get();
      this.g = paramRoomInfo.room_create_ts.get();
      if ((!i()) && (l2 != this.a)) {
        a(true, paramString);
      }
      Object localObject = (WTogetherCommon.VideoInfoRsp)paramRoomInfo.video_info_rsp.get();
      WTogetherPlayInfo localWTogetherPlayInfo = this.h;
      if (localWTogetherPlayInfo != null)
      {
        bool1 = bool2;
        if (localWTogetherPlayInfo.a.a((WTogetherCommon.VideoInfoRsp)localObject)) {}
      }
      else
      {
        if (this.h != null) {
          b(true, paramString);
        }
        this.h = new WTogetherPlayInfo(new WTFileInfo((WTogetherCommon.VideoInfoRsp)localObject));
        bool1 = true;
      }
      localObject = null;
      if (paramRoomInfo.player_status.has()) {
        localObject = (WTogetherCommon.PlayerStatus)paramRoomInfo.player_status.get();
      }
      if (localObject != null)
      {
        this.h.a(((WTogetherCommon.PlayerStatus)localObject).video_status.get(), paramString);
        this.h.e = (((WTogetherCommon.PlayerStatus)localObject).cur_play_rate.get() / 100.0F);
        this.h.d = ((WTogetherCommon.PlayerStatus)localObject).cur_play_time.get();
        this.h.f = ((WTogetherCommon.PlayerStatus)localObject).left_time.get();
      }
      this.h.h = (paramRoomInfo.last_update_time.get() * 1000L);
    }
    return bool1;
  }
  
  public long b()
  {
    return this.o;
  }
  
  public void b(String paramString)
  {
    this.a = 0L;
    a(0, 0, paramString);
    this.e = null;
    this.g = 0L;
    this.h = null;
    this.i = null;
    a(false, "clearRoom");
    b(false, "clearRoom");
    this.j.d();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearRoom, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.room", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.n = paramBoolean;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setChangePlayFileFlag, isChangePlayFile[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.room", 4, localStringBuilder.toString());
    }
  }
  
  public boolean c()
  {
    return this.m;
  }
  
  public boolean d()
  {
    return this.n;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public int f()
  {
    return this.l;
  }
  
  public boolean g()
  {
    if (i())
    {
      if ((this.k != 5) || (this.l != 1)) {}
    }
    else {
      while ((this.k == 6) && (this.l == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean h()
  {
    int i1;
    if (i())
    {
      i1 = this.k;
      if (i1 == 0) {
        break label95;
      }
      if (i1 != 1)
      {
        if (i1 == 5) {
          if (this.l != 1) {
            break label95;
          }
        }
      }
      else {
        if (this.l != 2) {
          break label95;
        }
      }
    }
    else
    {
      i1 = this.k;
      if (i1 == 0) {
        break label95;
      }
      if (i1 == 2) {
        break label84;
      }
      if (i1 == 6) {
        break label73;
      }
    }
    label73:
    label84:
    while (this.l == 2) {
      for (;;)
      {
        return true;
        if (this.l != 1) {
          break;
        }
      }
    }
    label95:
    return false;
  }
  
  public boolean i()
  {
    return (!TextUtils.isEmpty(this.d)) && (TextUtils.equals(this.d, this.e));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTRoomInfo{type: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", roomState: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", roomSubState: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", selfUin: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", roomAdmin: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", roomCreateTime: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", playInfo: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", updateFromAdminFlag: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTogetherRoom
 * JD-Core Version:    0.7.0.1
 */