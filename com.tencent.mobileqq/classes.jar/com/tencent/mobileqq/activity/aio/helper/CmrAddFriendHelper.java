package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpContext;
import com.tencent.qidian.QidianManager;

public class CmrAddFriendHelper
  extends FriendAddFriendHelper
{
  public CmrAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void f()
  {
    super.f();
    if (((BusinessCmrTmpContext)this.a).Q().m(this.e.b)) {
      ((BusinessCmrTmpContext)this.a).S();
    }
  }
  
  public void g()
  {
    if (((BusinessCmrTmpContext)this.a).Q().m(this.e.b)) {
      ((BusinessCmrTmpContext)this.a).R();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.CmrAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */