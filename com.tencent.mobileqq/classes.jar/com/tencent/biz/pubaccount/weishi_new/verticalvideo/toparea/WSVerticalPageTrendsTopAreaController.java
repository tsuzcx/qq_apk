package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageTrendsTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment a;
  
  public WSVerticalPageTrendsTopAreaController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.a = paramWSVerticalPageFragment;
  }
  
  public void a() {}
  
  public int b()
  {
    return 2131560134;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void e()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131381213);
    WSVerticalUtils.a(this.a.getActivity(), localRelativeLayout);
    a(2131381212).setOnClickListener(new WSVerticalPageTrendsTopAreaController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTrendsTopAreaController
 * JD-Core Version:    0.7.0.1
 */