package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageBackTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment g;
  
  public WSVerticalPageBackTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.g = paramWSVerticalPageFragment;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626050;
  }
  
  protected void j()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)c(2131449422);
    WSVerticalUtils.a(this.g.getBaseActivity(), localRelativeLayout);
    c(2131449421).setOnClickListener(new WSVerticalPageBackTopAreaController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageBackTopAreaController
 * JD-Core Version:    0.7.0.1
 */