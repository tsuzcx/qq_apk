package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageCLinkTopAreaController
  extends AbsWsUIGroup<Object>
{
  private final WSVerticalPageFragment g;
  
  public WSVerticalPageCLinkTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.g = paramWSVerticalPageFragment;
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 1929773063;
  }
  
  protected void j()
  {
    Object localObject = (RelativeLayout)c(1929707613);
    WSVerticalUtils.a(this.g.getBaseActivity(), (ViewGroup)localObject);
    localObject = (LinearLayout)c(1929707556);
    ((LinearLayout)localObject).setBackgroundDrawable(WeishiUIUtil.a(d().getResources().getColor(2131168378), WeishiUIUtil.k));
    ((LinearLayout)localObject).setOnClickListener(new WSVerticalPageCLinkTopAreaController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCLinkTopAreaController
 * JD-Core Version:    0.7.0.1
 */