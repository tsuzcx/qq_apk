package com.tencent.imsdk.group;

class GroupManager$1$10
  implements Runnable
{
  GroupManager$1$10(GroupManager.1 param1, String paramString1, GroupMemberInfo paramGroupMemberInfo, String paramString2) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onReceiveJoinApplication(this.val$groupID, this.val$member, this.val$opReason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.10
 * JD-Core Version:    0.7.0.1
 */