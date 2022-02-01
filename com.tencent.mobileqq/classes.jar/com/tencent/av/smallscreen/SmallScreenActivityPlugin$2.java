package com.tencent.av.smallscreen;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import lzh;
import lzr;

public class SmallScreenActivityPlugin$2
  implements Runnable
{
  public SmallScreenActivityPlugin$2(lzh paramlzh, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    BaseApplication localBaseApplication = this.this$0.a.getApp();
    if ((this.this$0.b) && (this.jdField_a_of_type_Boolean) && (!this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      lzr.a(l, 2, localBaseApplication, bool, this.this$0.a.getCurrentAccountUin(), this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin.2
 * JD-Core Version:    0.7.0.1
 */