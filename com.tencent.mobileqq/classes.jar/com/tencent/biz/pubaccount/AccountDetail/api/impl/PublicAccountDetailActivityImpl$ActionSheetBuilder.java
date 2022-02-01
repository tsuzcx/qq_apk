package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

class PublicAccountDetailActivityImpl$ActionSheetBuilder
{
  private ActionSheet b;
  private List<Integer> c;
  
  public PublicAccountDetailActivityImpl$ActionSheetBuilder(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, ActionSheet paramActionSheet)
  {
    this.b = paramActionSheet;
    this.c = new ArrayList();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.b.addButton(paramInt1, paramInt2);
    this.c.add(Integer.valueOf(paramInt1));
  }
  
  private void h()
  {
    this.b.setOnButtonClickListener(new PublicAccountDetailActivityImpl.ActionSheetBuilder.1(this));
  }
  
  public void a()
  {
    a(2131892987, 5);
  }
  
  public void b()
  {
    a(2131892972, 5);
  }
  
  public void c()
  {
    if (this.a.needShowUnFollowBtnInActionSheet()) {
      a(2131893006, 3);
    }
  }
  
  public void d()
  {
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.a;
    if (PublicAccountDetailActivityImpl.access$900(localPublicAccountDetailActivityImpl, localPublicAccountDetailActivityImpl.uin))
    {
      a(2131892905, 5);
      return;
    }
    a(2131892984, 5);
  }
  
  public void e()
  {
    if ((this.a.needShowUnFollowBtnInActionSheet()) && (PublicAccountUtilImpl.getMessageSetting(this.a.accountDetail) != null)) {
      a(2131892983, 5);
    }
  }
  
  public void f()
  {
    this.b.addButton(2131887648);
    this.c.add(Integer.valueOf(2131887648));
  }
  
  public ActionSheet g()
  {
    h();
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.ActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */