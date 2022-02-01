package com.tencent.biz.qqstory.shareGroup.infocard.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.List;

public class GetUserGroupMemberListHandler$GetUserGroupMemberListEvent
  extends BaseEvent
{
  public String a;
  public List<String> b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetUserGroupMemberListEvent{troopUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", memberList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.GetUserGroupMemberListHandler.GetUserGroupMemberListEvent
 * JD-Core Version:    0.7.0.1
 */