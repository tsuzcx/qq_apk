package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stSimpleMetaFeed;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
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
  private final WSVerticalPageFragment a;
  
  public WSVerticalPageShareTopAreaController(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramWSVerticalPageFragment.getContext());
    this.a = paramWSVerticalPageFragment;
  }
  
  private void f()
  {
    if (this.a.getBaseActivity() != null)
    {
      WSVerticalBeaconReport.d(this.a.a(), this.a.b(), this.a.a());
      this.a.getBaseActivity().doOnBackPressed();
    }
  }
  
  private void g()
  {
    if (WeishiUtils.c())
    {
      WSLog.a("WSVerticalPageShareTopAreaController", "[launchWSHomePage] fast click, ignored: vertical video top homepage");
      return;
    }
    Object localObject = this.a.a();
    WSVerticalBeaconReport.c(this.a.a(), this.a.b(), (stSimpleMetaFeed)localObject);
    BaseActivity localBaseActivity = this.a.getBaseActivity();
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
  
  protected int b()
  {
    return 1929641988;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(1929576472);
    WSVerticalUtils.a(this.a.getBaseActivity(), localRelativeLayout);
    a(1929576473).setOnClickListener(this);
    a(1929576474).setOnClickListener(this);
    a(1929576471).setOnClickListener(this);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 1929576472: 
    default: 
      return;
    case 1929576473: 
      f();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageShareTopAreaController
 * JD-Core Version:    0.7.0.1
 */