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
  public final int a;
  public long a;
  public final WTSyncPlayInfo a;
  public WTogetherPlayInfo a;
  public final String a;
  public List<WTogetherCommon.RoomUserInfo> a;
  private boolean a;
  private int jdField_b_of_type_Int = 0;
  public final long b;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  public long c;
  public String c;
  private long d = 0L;
  
  public WTogetherRoom(int paramInt, long paramLong, String paramString)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo = new WTSyncPlayInfo();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    this.d += 1L;
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_b_of_type_Int != paramInt1) || (this.jdField_c_of_type_Int != paramInt2))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRoomState, cur[");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append("], to[");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("], from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether.room", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_b_of_type_Int != paramInt1)
      {
        localObject = SessionMgr.a().a();
        ((SessionInfo)localObject).a(paramInt1, paramString);
        if ((((SessionInfo)localObject).b() != this.jdField_b_of_type_Long) && (QLog.isColorLevel()))
        {
          paramString = new StringBuilder();
          paramString.append("updateRoomState error, not same id. [");
          paramString.append(((SessionInfo)localObject).b());
          paramString.append(", ");
          paramString.append(this.jdField_b_of_type_Long);
          paramString.append("]");
          QLog.i("WTogether.room", 2, paramString.toString());
        }
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    if ((!e()) && ((!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
    {
      this.jdField_c_of_type_JavaLangString = SessionMgr.a().a().d;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRoomAdmin, uin[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], nick[");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.i("WTogether.room", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (this.jdField_b_of_type_Long == paramLong);
  }
  
  public boolean a(WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramRoomInfo != null)
    {
      if (this.jdField_b_of_type_Long != paramRoomInfo.roomid.get()) {
        return false;
      }
      long l2 = this.jdField_a_of_type_Long;
      a(String.valueOf(paramRoomInfo.owner_uin.get()));
      long l1;
      if (paramRoomInfo.seq.has()) {
        l1 = paramRoomInfo.seq.get();
      } else {
        l1 = l2;
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_JavaUtilList = paramRoomInfo.users.get();
      this.jdField_c_of_type_Long = paramRoomInfo.room_create_ts.get();
      if ((!e()) && (l2 != this.jdField_a_of_type_Long)) {
        a(true, paramString);
      }
      Object localObject = (WTogetherCommon.VideoInfoRsp)paramRoomInfo.video_info_rsp.get();
      WTogetherPlayInfo localWTogetherPlayInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
      if (localWTogetherPlayInfo != null)
      {
        bool1 = bool2;
        if (localWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.a((WTogetherCommon.VideoInfoRsp)localObject)) {}
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo != null) {
          b(true, paramString);
        }
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo = new WTogetherPlayInfo(new WTFileInfo((WTogetherCommon.VideoInfoRsp)localObject));
        bool1 = true;
      }
      localObject = null;
      if (paramRoomInfo.player_status.has()) {
        localObject = (WTogetherCommon.PlayerStatus)paramRoomInfo.player_status.get();
      }
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.a(((WTogetherCommon.PlayerStatus)localObject).video_status.get(), paramString);
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_Float = (((WTogetherCommon.PlayerStatus)localObject).cur_play_rate.get() / 100.0F);
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_Long = ((WTogetherCommon.PlayerStatus)localObject).cur_play_time.get();
        this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_b_of_type_Int = ((WTogetherCommon.PlayerStatus)localObject).left_time.get();
      }
      this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_b_of_type_Long = (paramRoomInfo.last_update_time.get() * 1000L);
    }
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Long = 0L;
    a(0, 0, paramString);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo = null;
    this.jdField_a_of_type_JavaUtilList = null;
    a(false, "clearRoom");
    b(false, "clearRoom");
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a();
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
    this.jdField_b_of_type_Boolean = paramBoolean;
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
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    if (e())
    {
      if ((this.jdField_b_of_type_Int != 5) || (this.jdField_c_of_type_Int != 1)) {}
    }
    else {
      while ((this.jdField_b_of_type_Int == 6) && (this.jdField_c_of_type_Int == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    int i;
    if (e())
    {
      i = this.jdField_b_of_type_Int;
      if (i == 0) {
        break label95;
      }
      if (i != 1)
      {
        if (i == 5) {
          if (this.jdField_c_of_type_Int != 1) {
            break label95;
          }
        }
      }
      else {
        if (this.jdField_c_of_type_Int != 2) {
          break label95;
        }
      }
    }
    else
    {
      i = this.jdField_b_of_type_Int;
      if (i == 0) {
        break label95;
      }
      if (i == 2) {
        break label84;
      }
      if (i == 6) {
        break label73;
      }
    }
    label73:
    label84:
    while (this.jdField_c_of_type_Int == 2) {
      for (;;)
      {
        return true;
        if (this.jdField_c_of_type_Int != 1) {
          break;
        }
      }
    }
    label95:
    return false;
  }
  
  public boolean e()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTRoomInfo{type: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", roomId: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", roomState: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", roomSubState: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", selfUin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", roomAdmin: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", roomCreateTime: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", playInfo: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo);
    localStringBuilder.append(", updateFromAdminFlag: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTogetherRoom
 * JD-Core Version:    0.7.0.1
 */