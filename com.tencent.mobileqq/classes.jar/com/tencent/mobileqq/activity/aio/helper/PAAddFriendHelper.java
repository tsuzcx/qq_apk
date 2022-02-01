package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;

public class PAAddFriendHelper
  extends AddFriendHelper
{
  public PAAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void f()
  {
    if (!((PAContext)this.a).P()) {
      super.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PAAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */