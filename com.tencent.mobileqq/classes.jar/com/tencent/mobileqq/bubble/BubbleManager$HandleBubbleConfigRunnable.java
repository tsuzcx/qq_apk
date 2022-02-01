package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BubbleManager$HandleBubbleConfigRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  BubbleConfig jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig;
  boolean jdField_a_of_type_Boolean;
  
  public BubbleManager$HandleBubbleConfigRunnable(BubbleManager paramBubbleManager, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append(this.this$0.a(this.jdField_a_of_type_Int).getAbsolutePath());
    ((StringBuilder)localObject).append(File.separatorChar);
    ((StringBuilder)localObject).append("config.json");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig = this.this$0.a(this.jdField_a_of_type_Int, (String)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBubbleConfig bubbleId=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",filePath=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",bubbleConfig=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig != null)
    {
      this.this$0.a.put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig);
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_Int, "config.json", "0");
      BubbleManager.a(this.this$0, this.jdField_a_of_type_Int);
    }
    localObject = new BubbleManager.HandleBubbleConfigRunnable.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ((Runnable)localObject).run();
      return;
    }
    new Handler(Looper.getMainLooper()).post((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.HandleBubbleConfigRunnable
 * JD-Core Version:    0.7.0.1
 */