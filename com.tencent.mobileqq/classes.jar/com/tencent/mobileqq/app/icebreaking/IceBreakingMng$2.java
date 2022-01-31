package com.tencent.mobileqq.app.icebreaking;

import ajzi;
import ajzj;
import java.lang.ref.WeakReference;
import java.util.List;

public class IceBreakingMng$2
  implements Runnable
{
  public IceBreakingMng$2(ajzj paramajzj, List paramList) {}
  
  public void run()
  {
    if ((ajzj.b(this.this$0) != null) && (ajzj.b(this.this$0).get() != null)) {
      ((ajzi)ajzj.b(this.this$0).get()).a(true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.IceBreakingMng.2
 * JD-Core Version:    0.7.0.1
 */