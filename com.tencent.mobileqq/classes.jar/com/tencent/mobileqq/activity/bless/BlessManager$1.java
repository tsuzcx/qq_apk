package com.tencent.mobileqq.activity.bless;

import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class BlessManager$1
  implements Runnable
{
  BlessManager$1(BlessManager paramBlessManager) {}
  
  public void run()
  {
    BlessManager.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "mCheckMultiConfigRunnable");
    }
    Set localSet = BlessManager.a(this.this$0);
    if ((localSet != null) && (localSet.size() > 0)) {
      this.this$0.a(localSet);
    }
    BlessManager.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.1
 * JD-Core Version:    0.7.0.1
 */