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
      QQToast.makeText(this.a.b.m, 2, HardCodeUtil.a(2131904838), 0).show();
      return;
    }
    if ((!paramBoolean1) && (paramBoolean2))
    {
      QQToast.makeText(this.a.b.m, 1, HardCodeUtil.a(2131904843), 0).show();
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      QQToast.makeText(this.a.b.m, 1, HardCodeUtil.a(2131904839), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.1
 * JD-Core Version:    0.7.0.1
 */