package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageChatTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment a;
  
  public WSVerticalPageChatTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.a = paramWSVerticalPageFragment;
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560008;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380469);
    WSVerticalUtils.a(this.a.getBaseActivity(), localRelativeLayout);
    a(2131380470).setOnClickListener(new WSVerticalPageChatTopAreaController.1(this));
    a(2131380471).setOnClickListener(new WSVerticalPageChatTopAreaController.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageChatTopAreaController
 * JD-Core Version:    0.7.0.1
 */