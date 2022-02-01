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
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "onCondSearchFriendResult searchseq = " + this.a.jdField_a_of_type_Long + " | seq = " + paramLong + ", isSuccess=" + paramBoolean + ", ret=" + paramInt1 + ", searchFrom=" + paramInt2);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      Object localObject;
      if ((paramObject instanceof RespCondSearch))
      {
        paramObject = (RespCondSearch)paramObject;
        localObject = this.a;
        if (paramObject.cEndFlag == 0)
        {
          paramBoolean = true;
          ((ConditionSearchManager)localObject).jdField_e_of_type_Boolean = paramBoolean;
          this.a.jdField_f_of_type_Int = paramObject.iPage;
          this.a.jdField_b_of_type_Long = paramObject.dwSessionID;
          if (this.a.jdField_b_of_type_JavaUtilList != null) {
            break label352;
          }
          this.a.jdField_b_of_type_JavaUtilList = paramObject.vUserList;
        }
      }
      label434:
      label441:
      label575:
      label580:
      label586:
      for (;;)
      {
        if ((this.a.jdField_g_of_type_Int >= 2) || ((this.a.jdField_b_of_type_JavaUtilList != null) && (this.a.jdField_b_of_type_JavaUtilList.size() >= 10)) || (!this.a.jdField_e_of_type_Boolean)) {
          break label609;
        }
        paramObject = this.a;
        paramObject.jdField_g_of_type_Int += 1;
        ((FriendListHandler)ConditionSearchManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).condtionalSearchFriendBy0x972(this.a.jdField_a_of_type_Long, this.a.jdField_f_of_type_Int + 1, this.a.jdField_a_of_type_ArrayOfByte, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.c, this.a.jdField_f_of_type_ArrayOfJavaLangString, this.a.jdField_g_of_type_ArrayOfJavaLangString, this.a.d, this.a.jdField_e_of_type_Int, paramInt2);
        return;
        paramBoolean = false;
        break;
        label352:
        if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty()))
        {
          this.a.jdField_b_of_type_JavaUtilList.addAll(paramObject.vUserList);
          continue;
          if ((paramObject instanceof oidb_0x972.RspBody))
          {
            localObject = (oidb_0x972.RspBody)paramObject;
            paramObject = this.a;
            ConditionSearchManager localConditionSearchManager;
            if (((oidb_0x972.RspBody)localObject).is_end.has())
            {
              paramInt1 = ((oidb_0x972.RspBody)localObject).is_end.get();
              if (paramInt1 != 0) {
                break label575;
              }
              paramBoolean = true;
              paramObject.jdField_e_of_type_Boolean = paramBoolean;
              localConditionSearchManager = this.a;
              if (!((oidb_0x972.RspBody)localObject).cookie.has()) {
                break label580;
              }
            }
            for (paramObject = ((oidb_0x972.RspBody)localObject).cookie.get().toByteArray();; paramObject = null)
            {
              localConditionSearchManager.jdField_a_of_type_ArrayOfByte = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.Manager", 2, "onCondSearchFriendResult hasMore = " + this.a.jdField_e_of_type_Boolean + ",cookie = " + this.a.jdField_a_of_type_ArrayOfByte);
              }
              paramObject = ConditionSearchManager.a(this.a, (oidb_0x972.RspBody)localObject);
              if (this.a.jdField_b_of_type_JavaUtilList != null) {
                break label586;
              }
              this.a.jdField_b_of_type_JavaUtilList = paramObject;
              break;
              paramInt1 = 0;
              break label434;
              paramBoolean = false;
              break label441;
            }
            if (paramObject != null) {
              this.a.jdField_b_of_type_JavaUtilList.addAll(paramObject);
            }
          }
        }
      }
      label609:
      if ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < 6)) {
        this.a.jdField_e_of_type_Boolean = false;
      }
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      this.a.jdField_e_of_type_Boolean = false;
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if (this.a.jdField_g_of_type_Int == 0)
    {
      this.a.a(false, null, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.5
 * JD-Core Version:    0.7.0.1
 */