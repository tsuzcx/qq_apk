package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;

public class AnonymousHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void b()
  {
    int i;
    if (((ConfessManager)this.b.getManager(QQManagerFactory.CONFESS_MANAGER)).c().a(this.a.frienduin, this.a.istroop, this.a.getConfessTopicId()).confessorSex == 1) {
      i = 2130846413;
    } else {
      i = 2130846412;
    }
    b(this.c.getResources().getDrawable(i));
  }
  
  protected void c()
  {
    a(null);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    return ConfessMsgUtil.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AnonymousHeadIconController
 * JD-Core Version:    0.7.0.1
 */