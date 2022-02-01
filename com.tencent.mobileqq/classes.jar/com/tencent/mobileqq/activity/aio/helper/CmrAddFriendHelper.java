package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpContext;
import com.tencent.qidian.QidianManager;

public class CmrAddFriendHelper
  extends FriendAddFriendHelper
{
  public CmrAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    if (((BusinessCmrTmpContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      ((BusinessCmrTmpContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).i();
    }
  }
  
  public void e()
  {
    if (((BusinessCmrTmpContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      ((BusinessCmrTmpContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.CmrAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */