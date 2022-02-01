package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class GetUserGroupMemberListHandler$1
  extends SimpleJob<Object>
{
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    ((ITroopMemberListHandler)this.c.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(Long.valueOf(this.a).longValue(), 0L, 5, this.b, 0);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler.1
 * JD-Core Version:    0.7.0.1
 */