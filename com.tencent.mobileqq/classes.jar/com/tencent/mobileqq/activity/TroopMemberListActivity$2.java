package com.tencent.mobileqq.activity;

import android.os.Handler;
import anyw;
import bhlk;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.List;

class TroopMemberListActivity$2
  implements Runnable
{
  TroopMemberListActivity$2(TroopMemberListActivity paramTroopMemberListActivity, anyw paramanyw) {}
  
  public void run()
  {
    Object localObject1 = bhlk.a().a(this.this$0.app, this.this$0.b, this.this$0.v);
    bhlk.a().a(this.this$0.app, this.this$0.b, this.this$0.v);
    if ((localObject1 != null) && (this.a != null))
    {
      this.this$0.a(this.this$0.v);
      synchronized (this.this$0)
      {
        localObject1 = this.this$0.a((TroopMemberInfo)localObject1, this.a);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.2
 * JD-Core Version:    0.7.0.1
 */