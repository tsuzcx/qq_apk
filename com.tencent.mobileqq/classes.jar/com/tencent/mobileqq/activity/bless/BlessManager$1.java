package com.tencent.mobileqq.activity.bless;

import ajan;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class BlessManager$1
  implements Runnable
{
  public BlessManager$1(ajan paramajan) {}
  
  public void run()
  {
    ajan.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "mCheckMultiConfigRunnable");
    }
    Set localSet = ajan.a(this.this$0);
    if ((localSet != null) && (localSet.size() > 0)) {
      this.this$0.a(localSet);
    }
    ajan.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.1
 * JD-Core Version:    0.7.0.1
 */