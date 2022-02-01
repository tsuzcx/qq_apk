package com.tencent.biz.qqstory.shareGroup.infocard.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class GetUserGroupMemberListHandler
{
  final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  
  private static void b(String paramString, List<oidb_0x899.memberlist> paramList)
  {
    GetUserGroupMemberListHandler.GetUserGroupMemberListEvent localGetUserGroupMemberListEvent = new GetUserGroupMemberListHandler.GetUserGroupMemberListEvent();
    localGetUserGroupMemberListEvent.jdField_a_of_type_JavaLangString = String.valueOf(paramString);
    paramString = new ArrayList();
    localGetUserGroupMemberListEvent.jdField_a_of_type_JavaUtilList = paramString;
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.next();
      if (localmemberlist.uint64_member_uin.has()) {
        paramString.add(localUserManager.b(String.valueOf(localmemberlist.uint64_member_uin.get()), true));
      }
    }
    StoryDispatcher.a().dispatch(localGetUserGroupMemberListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler
 * JD-Core Version:    0.7.0.1
 */