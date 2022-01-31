package com.tencent.mobileqq.bubble;

import almq;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BubbleManager$HandleBubbleConfigRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  almq jdField_a_of_type_Almq;
  boolean jdField_a_of_type_Boolean;
  
  public BubbleManager$HandleBubbleConfigRunnable(BubbleManager paramBubbleManager, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_Int).getAbsolutePath() + File.separatorChar + "config.json";
    this.jdField_a_of_type_Almq = this.this$0.a(this.jdField_a_of_type_Int, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + this.jdField_a_of_type_Int + ",filePath=" + (String)localObject + ",bubbleConfig=" + this.jdField_a_of_type_Almq);
    }
    if (this.jdField_a_of_type_Almq != null) {
      this.this$0.a.put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Almq);
    }
    for (;;)
    {
      localObject = new BubbleManager.HandleBubbleConfigRunnable.1(this);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break;
      }
      ((Runnable)localObject).run();
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.this$0.a(this.jdField_a_of_type_Int, "config.json", "0");
        BubbleManager.a(this.this$0, this.jdField_a_of_type_Int);
      }
    }
    new Handler(Looper.getMainLooper()).post((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.HandleBubbleConfigRunnable
 * JD-Core Version:    0.7.0.1
 */