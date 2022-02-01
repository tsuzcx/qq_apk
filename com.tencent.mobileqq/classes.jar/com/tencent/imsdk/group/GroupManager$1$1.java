package com.tencent.imsdk.group;

import java.util.List;

class GroupManager$1$1
  implements Runnable
{
  GroupManager$1$1(GroupManager.1 param1, String paramString, List paramList) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onMemberEnter(this.val$groupID, this.val$memberList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.1
 * JD-Core Version:    0.7.0.1
 */