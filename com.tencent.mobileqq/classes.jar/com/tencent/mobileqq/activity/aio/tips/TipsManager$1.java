package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import java.util.Observer;

class TipsManager$1
  implements Runnable
{
  TipsManager$1(TipsManager paramTipsManager, TipsBarTask paramTipsBarTask, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    Object localObject = this.a.a(this.b);
    TipsManager.a(this.this$0).a((View)localObject, this.this$0.b, this.a);
    localObject = this.this$0;
    ((TipsManager)localObject).b = this.a;
    if (TipsManager.b((TipsManager)localObject) != null) {
      TipsManager.b(this.this$0).update(null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TipsManager.1
 * JD-Core Version:    0.7.0.1
 */