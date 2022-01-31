package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mbl;
import mbt;
import mls;

public class SmallScreenActivityPlugin$2
  implements Runnable
{
  public SmallScreenActivityPlugin$2(mbl parammbl, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    int i;
    long l;
    BaseApplication localBaseApplication;
    if ((Build.VERSION.SDK_INT >= 21) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c()))
    {
      i = 1;
      l = this.jdField_a_of_type_Long;
      localBaseApplication = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp();
      if ((!this.this$0.b) || (!this.jdField_a_of_type_Boolean) || (i != 0)) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      mbt.a(l, localBaseApplication, bool, this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), this.b);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin.2
 * JD-Core Version:    0.7.0.1
 */