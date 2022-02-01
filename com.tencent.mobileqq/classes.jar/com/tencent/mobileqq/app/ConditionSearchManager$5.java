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
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Long);
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
    if (this.a.jdField_a_of_type_Long != paramLong) {
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
        ((ConditionSearchManager)localObject).jdField_e_of_type_Boolean = paramBoolean;
        this.a.jdField_f_of_type_Int = paramObject.iPage;
        this.a.jdField_b_of_type_Long = paramObject.dwSessionID;
        if (this.a.jdField_b_of_type_JavaUtilList == null) {
          this.a.jdField_b_of_type_JavaUtilList = paramObject.vUserList;
        } else if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty())) {
          this.a.jdField_b_of_type_JavaUtilList.addAll(paramObject.vUserList);
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
        paramObject.jdField_e_of_type_Boolean = paramBoolean;
        ConditionSearchManager localConditionSearchManager = this.a;
        paramObject = localObject;
        if (localRspBody.cookie.has()) {
          paramObject = localRspBody.cookie.get().toByteArray();
        }
        localConditionSearchManager.jdField_a_of_type_ArrayOfByte = paramObject;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onCondSearchFriendResult hasMore = ");
          paramObject.append(this.a.jdField_e_of_type_Boolean);
          paramObject.append(",cookie = ");
          paramObject.append(this.a.jdField_a_of_type_ArrayOfByte);
          QLog.d("ConditionSearch.Manager", 2, paramObject.toString());
        }
        paramObject = ConditionSearchManager.a(this.a, localRspBody);
        if (this.a.jdField_b_of_type_JavaUtilList == null) {
          this.a.jdField_b_of_type_JavaUtilList = paramObject;
        } else if (paramObject != null) {
          this.a.jdField_b_of_type_JavaUtilList.addAll(paramObject);
        }
      }
      if ((this.a.jdField_g_of_type_Int < 2) && ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < 10)) && (this.a.jdField_e_of_type_Boolean))
      {
        paramObject = this.a;
        paramObject.jdField_g_of_type_Int += 1;
        ((FriendListHandler)ConditionSearchManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.a.jdField_a_of_type_Long, this.a.jdField_f_of_type_Int + 1, this.a.jdField_a_of_type_ArrayOfByte, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.c, this.a.jdField_f_of_type_ArrayOfJavaLangString, this.a.jdField_g_of_type_ArrayOfJavaLangString, this.a.d, this.a.jdField_e_of_type_Int, paramInt2);
        return;
      }
      if ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < 6)) {
        this.a.jdField_e_of_type_Boolean = false;
      }
      paramObject = this.a;
      paramObject.a(true, paramObject.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      paramObject = this.a;
      paramObject.jdField_e_of_type_Boolean = false;
      paramObject.a(true, paramObject.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if (this.a.jdField_g_of_type_Int == 0)
    {
      paramObject = this.a;
      paramObject.a(false, null, paramObject.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    paramObject = this.a;
    paramObject.a(true, paramObject.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.5
 * JD-Core Version:    0.7.0.1
 */