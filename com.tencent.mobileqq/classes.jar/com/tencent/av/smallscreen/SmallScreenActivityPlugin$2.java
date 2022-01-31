package com.tencent.av.smallscreen;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import lzb;
import lzj;

public class SmallScreenActivityPlugin$2
  implements Runnable
{
  public SmallScreenActivityPlugin$2(lzb paramlzb, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    BaseApplication localBaseApplication = this.this$0.a.getApp();
    if ((this.this$0.b) && (this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      lzj.a(l, localBaseApplication, bool, this.this$0.a.getCurrentAccountUin(), this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin.2
 * JD-Core Version:    0.7.0.1
 */