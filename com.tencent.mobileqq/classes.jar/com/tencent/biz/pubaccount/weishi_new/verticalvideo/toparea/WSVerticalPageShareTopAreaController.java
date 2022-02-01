package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stSimpleMetaFeed;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.WSPublicAccLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.mobileqq.app.BaseActivity;

public class WSVerticalPageShareTopAreaController
  extends AbsWsUIGroup<Object>
  implements View.OnClickListener
{
  private final WSVerticalPageFragment g;
  
  public WSVerticalPageShareTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.g = paramWSVerticalPageFragment;
  }
  
  private boolean l()
  {
    return TextUtils.equals(this.g.H(), "native");
  }
  
  private void m()
  {
    if (this.g.getBaseActivity() != null)
    {
      WSVerticalBeaconReport.d(this.g.k(), this.g.l(), this.g.F());
      this.g.getBaseActivity().doOnBackPressed();
    }
  }
  
  private void n()
  {
    if (WeishiUtils.o())
    {
      WSLog.a("WSVerticalPageShareTopAreaController", "[launchWSHomePage] fast click, ignored: vertical video top homepage");
      return;
    }
    Object localObject = this.g.F();
    WSVerticalBeaconReport.c(this.g.k(), this.g.l(), (stSimpleMetaFeed)localObject);
    BaseActivity localBaseActivity = this.g.getBaseActivity();
    WSPublicAccLaunchParams localWSPublicAccLaunchParams = new WSPublicAccLaunchParams("from_qq_scheme", 0, false).a(true);
    if (localObject != null) {
      localObject = ((stSimpleMetaFeed)localObject).id;
    } else {
      localObject = "";
    }
    WeishiActivityHelper.a(localBaseActivity, localWSPublicAccLaunchParams.a((String)localObject));
    localBaseActivity.finish();
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 1929773071;
  }
  
  protected void j()
  {
    if (this.g == null) {
      return;
    }
    Object localObject = (RelativeLayout)c(1929707613);
    WSVerticalUtils.a(this.g.getBaseActivity(), (ViewGroup)localObject);
    c(1929707614).setOnClickListener(this);
    localObject = c(1929707615);
    ((View)localObject).setOnClickListener(this);
    View localView = c(1929707612);
    localView.setOnClickListener(this);
    boolean bool = l();
    int j = 8;
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    if (l()) {
      i = j;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 1929707613: 
    default: 
      return;
    case 1929707614: 
      m();
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageShareTopAreaController
 * JD-Core Version:    0.7.0.1
 */