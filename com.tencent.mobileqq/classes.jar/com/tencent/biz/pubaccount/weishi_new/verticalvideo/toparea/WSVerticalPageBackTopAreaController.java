package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageBackTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment a;
  
  public WSVerticalPageBackTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.a = paramWSVerticalPageFragment;
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560007;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380469);
    WSVerticalUtils.a(this.a.getBaseActivity(), localRelativeLayout);
    a(2131380468).setOnClickListener(new WSVerticalPageBackTopAreaController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageBackTopAreaController
 * JD-Core Version:    0.7.0.1
 */