package com.tencent.mobileqq.app;

import SummaryCard.RespCondSearch;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x972.oidb_0x972.RspBody;

class ConditionSearchManager$5
  extends FriendListObserver
{
  ConditionSearchManager$5(ConditionSearchManager paramConditionSearchManager) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCondSearchFriendResult searchseq = ");
      ((StringBuilder)localObject).append(this.a.q);
      ((StringBuilder)localObject).append(" | seq = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ret=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", searchFrom=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.q != paramLong) {
      return;
    }
    Object localObject = null;
    if ((paramBoolean) && (paramInt1 == 0))
    {
      if ((paramObject instanceof RespCondSearch))
      {
        paramObject = (RespCondSearch)paramObject;
        localObject = this.a;
        if (paramObject.cEndFlag == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        ((ConditionSearchManager)localObject).E = paramBoolean;
        this.a.z = paramObject.iPage;
        this.a.A = paramObject.dwSessionID;
        if (this.a.D == null) {
          this.a.D = paramObject.vUserList;
        } else if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty())) {
          this.a.D.addAll(paramObject.vUserList);
        }
      }
      else if ((paramObject instanceof oidb_0x972.RspBody))
      {
        oidb_0x972.RspBody localRspBody = (oidb_0x972.RspBody)paramObject;
        paramObject = this.a;
        if (localRspBody.is_end.has()) {
          paramInt1 = localRspBody.is_end.get();
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramObject.E = paramBoolean;
        ConditionSearchManager localConditionSearchManager = this.a;
        paramObject = localObject;
        if (localRspBody.cookie.has()) {
          paramObject = localRspBody.cookie.get().toByteArray();
        }
        localConditionSearchManager.B = paramObject;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onCondSearchFriendResult hasMore = ");
          paramObject.append(this.a.E);
          paramObject.append(",cookie = ");
          paramObject.append(this.a.B);
          QLog.d("ConditionSearch.Manager", 2, paramObject.toString());
        }
        paramObject = ConditionSearchManager.a(this.a, localRspBody);
        if (this.a.D == null) {
          this.a.D = paramObject;
        } else if (paramObject != null) {
          this.a.D.addAll(paramObject);
        }
      }
      if ((this.a.C < 2) && ((this.a.D == null) || (this.a.D.size() < 10)) && (this.a.E))
      {
        paramObject = this.a;
        paramObject.C += 1;
        ((FriendListHandler)ConditionSearchManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.a.q, this.a.z + 1, this.a.B, this.a.r, this.a.s, this.a.t, this.a.u, this.a.x, this.a.y, this.a.v, this.a.w, paramInt2);
        return;
      }
      if ((this.a.D == null) || (this.a.D.size() < 6)) {
        this.a.E = false;
      }
      paramObject = this.a;
      paramObject.a(true, paramObject.D, this.a.E, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      paramObject = this.a;
      paramObject.E = false;
      paramObject.a(true, paramObject.D, this.a.E, paramInt2);
      return;
    }
    if (this.a.C == 0)
    {
      paramObject = this.a;
      paramObject.a(false, null, paramObject.E, paramInt2);
      return;
    }
    paramObject = this.a;
    paramObject.a(true, paramObject.D, this.a.E, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.5
 * JD-Core Version:    0.7.0.1
 */