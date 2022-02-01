package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;

class GroupFileSearchDialog$1
  implements Runnable
{
  GroupFileSearchDialog$1(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void run()
  {
    Object localObject = TroopFileSearchManager.a();
    GroupFileSearchDialog localGroupFileSearchDialog = this.this$0;
    localGroupFileSearchDialog.B = ((TroopFileSearchManager)localObject).a(localGroupFileSearchDialog.m, this.this$0.l, 0);
    if (this.this$0.s)
    {
      localObject = this.this$0;
      ((GroupFileSearchDialog)localObject).s = false;
      ((GroupFileSearchDialog)localObject).a(((GroupFileSearchDialog)localObject).w);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */