package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BubbleManager$HandleBubbleConfigRunnable
  implements Runnable
{
  BubbleConfig a;
  int b;
  boolean c;
  
  public BubbleManager$HandleBubbleConfigRunnable(BubbleManager paramBubbleManager, int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public void run()
  {
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append(this.this$0.d(this.b).getAbsolutePath());
    ((StringBuilder)localObject).append(File.separatorChar);
    ((StringBuilder)localObject).append("config.json");
    localObject = ((StringBuilder)localObject).toString();
    this.a = this.this$0.a(this.b, (String)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBubbleConfig bubbleId=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",filePath=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",bubbleConfig=");
      localStringBuilder.append(this.a);
      QLog.d("BubbleManager", 2, localStringBuilder.toString());
    }
    if (this.a != null)
    {
      this.this$0.g.put(Integer.valueOf(this.b), this.a);
    }
    else if (this.c)
    {
      this.this$0.a(this.b, "config.json", "0");
      BubbleManager.a(this.this$0, this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.HandleBubbleConfigRunnable
 * JD-Core Version:    0.7.0.1
 */