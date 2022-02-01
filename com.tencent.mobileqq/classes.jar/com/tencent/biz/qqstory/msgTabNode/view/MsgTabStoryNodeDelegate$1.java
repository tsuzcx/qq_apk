package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class MsgTabStoryNodeDelegate$1
  extends QQStoryObserver
{
  MsgTabStoryNodeDelegate$1(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    if ((paramBoolean1) && (paramBoolean2))
    {
      QQToast.a(this.a.a.a, 2, HardCodeUtil.a(2131706996), 0).a();
      return;
    }
    if ((!paramBoolean1) && (paramBoolean2))
    {
      QQToast.a(this.a.a.a, 1, HardCodeUtil.a(2131707001), 0).a();
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      QQToast.a(this.a.a.a, 1, HardCodeUtil.a(2131706997), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.1
 * JD-Core Version:    0.7.0.1
 */