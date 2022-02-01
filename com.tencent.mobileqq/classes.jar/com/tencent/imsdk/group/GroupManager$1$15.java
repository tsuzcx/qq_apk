package com.tencent.imsdk.group;

class GroupManager$1$15
  implements Runnable
{
  GroupManager$1$15(GroupManager.1 param1, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (GroupManager.access$100(this.this$1.this$0) != null) {
      GroupManager.access$100(this.this$1.this$0).onReceiveRESTCustomData(this.val$groupID, this.val$customData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupManager.1.15
 * JD-Core Version:    0.7.0.1
 */