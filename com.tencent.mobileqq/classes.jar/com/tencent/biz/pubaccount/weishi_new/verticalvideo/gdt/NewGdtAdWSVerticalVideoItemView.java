package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

public class NewGdtAdWSVerticalVideoItemView
  extends GdtAdWSVerticalVideoItemView
{
  private AbsWsUIGroup<WSVerticalItemData> i;
  
  public NewGdtAdWSVerticalVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private void l()
  {
    ViewStub localViewStub = (ViewStub)this.h.findViewById(2131449747);
    localViewStub.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.i = new GdtAdWSVerticalItemBottomUserController(this.g, this.f);
    this.i.a(localViewStub);
    a(this.i);
  }
  
  public void a()
  {
    super.a();
    AbsWsUIGroup localAbsWsUIGroup = this.i;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.g();
    }
  }
  
  public void b()
  {
    super.b();
    l();
  }
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.NewGdtAdWSVerticalVideoItemView
 * JD-Core Version:    0.7.0.1
 */