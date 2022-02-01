package com.tencent.imsdk.group;

class GroupManager$1$11
  implements Runnable
{
  GroupManager$1$11(GroupManager.1 param1, String paramString1, GroupMemberInfo paramGroupMemberInfo, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onApplicationProcessed(this.val$groupID, this.val$opUser, this.val$isAgreeJoin, this.val$opReason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.11
 * JD-Core Version:    0.7.0.1
 */