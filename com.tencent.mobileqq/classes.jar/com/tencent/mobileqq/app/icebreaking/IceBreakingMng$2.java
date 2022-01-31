package com.tencent.mobileqq.app.icebreaking;

import aknu;
import aknv;
import java.lang.ref.WeakReference;
import java.util.List;

public class IceBreakingMng$2
  implements Runnable
{
  public IceBreakingMng$2(aknv paramaknv, List paramList) {}
  
  public void run()
  {
    if ((aknv.b(this.this$0) != null) && (aknv.b(this.this$0).get() != null)) {
      ((aknu)aknv.b(this.this$0).get()).a(true, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.icebreaking.IceBreakingMng.2
 * JD-Core Version:    0.7.0.1
 */