package com.tencent.mobileqq.activity.bless;

import ahcr;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class BlessManager$1
  implements Runnable
{
  public BlessManager$1(ahcr paramahcr) {}
  
  public void run()
  {
    ahcr.a(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "mCheckMultiConfigRunnable");
    }
    Set localSet = ahcr.a(this.this$0);
    if ((localSet != null) && (localSet.size() > 0)) {
      this.this$0.a(localSet);
    }
    ahcr.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.1
 * JD-Core Version:    0.7.0.1
 */