package com.tencent.imsdk.group;

class GroupManager$1$8
  implements Runnable
{
  GroupManager$1$8(GroupManager.1 param1, String paramString, GroupMemberInfo paramGroupMemberInfo) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onGroupRecycled(this.val$groupID, this.val$opUser);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.8
 * JD-Core Version:    0.7.0.1
 */