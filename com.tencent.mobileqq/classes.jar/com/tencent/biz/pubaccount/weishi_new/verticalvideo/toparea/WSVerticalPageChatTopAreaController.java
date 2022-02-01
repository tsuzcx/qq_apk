package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageChatTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment g;
  
  public WSVerticalPageChatTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.g = paramWSVerticalPageFragment;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626051;
  }
  
  protected void j()
  {
    if (this.g == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)c(2131449422);
    WSVerticalUtils.a(this.g.getBaseActivity(), localRelativeLayout);
    c(2131449423).setOnClickListener(new WSVerticalPageChatTopAreaController.1(this));
    c(2131449424).setOnClickListener(new WSVerticalPageChatTopAreaController.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageChatTopAreaController
 * JD-Core Version:    0.7.0.1
 */