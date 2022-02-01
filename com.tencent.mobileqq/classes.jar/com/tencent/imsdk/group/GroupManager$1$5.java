package com.tencent.imsdk.group;

import java.util.List;

class GroupManager$1$5
  implements Runnable
{
  GroupManager$1$5(GroupManager.1 param1, String paramString, List paramList) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onMemberInfoChanged(this.val$groupID, this.val$v2TIMGroupMemberChangeInfoList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.5
 * JD-Core Version:    0.7.0.1
 */