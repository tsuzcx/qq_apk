package com.tencent.mobileqq.activity;

import ajxl;
import android.os.Handler;
import bbdd;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.List;

class TroopMemberListActivity$2
  implements Runnable
{
  TroopMemberListActivity$2(TroopMemberListActivity paramTroopMemberListActivity, ajxl paramajxl) {}
  
  public void run()
  {
    Object localObject1 = bbdd.a().a(this.this$0.app, this.this$0.b, this.this$0.v);
    bbdd.a().a(this.this$0.app, this.this$0.b, this.this$0.v);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.2
 * JD-Core Version:    0.7.0.1
 */