package com.tencent.biz.qqstory.shareGroup.infocard.model;

import android.support.annotation.NonNull;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class GetUserGroupMemberListHandler$GetMemberListBusinessObserver$1
  extends SimpleJob<Object>
{
  GetUserGroupMemberListHandler$GetMemberListBusinessObserver$1(GetUserGroupMemberListHandler.GetMemberListBusinessObserver paramGetMemberListBusinessObserver, String paramString1, String paramString2, List paramList)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    GetUserGroupMemberListHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler.GetMemberListBusinessObserver.1
 * JD-Core Version:    0.7.0.1
 */