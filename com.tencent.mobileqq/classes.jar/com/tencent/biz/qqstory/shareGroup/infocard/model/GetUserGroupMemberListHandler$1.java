package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class GetUserGroupMemberListHandler$1
  extends SimpleJob<Object>
{
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    ((TroopHandler)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelGetUserGroupMemberListHandler.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), 0L, 5, this.jdField_a_of_type_Int, 0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler.1
 * JD-Core Version:    0.7.0.1
 */