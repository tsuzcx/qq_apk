package com.tencent.imsdk.relationship;

import java.util.List;

class RelationshipManager$1$2
  implements Runnable
{
  RelationshipManager$1$2(RelationshipManager.1 param1, List paramList) {}
  
  public void run()
  {
    if (RelationshipManager.access$100(this.this$1.this$0) != null) {
      RelationshipManager.access$100(this.this$1.this$0).OnFriendListAdded(this.val$friendInfoList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.RelationshipManager.1.2
 * JD-Core Version:    0.7.0.1
 */