package com.tencent.biz.pubaccount.weishi_new.drama.topbar;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.mobileqq.app.BaseActivity;

public class WSDramaCommonTopAreaController
  extends AbsWsUIGroup<Object>
  implements View.OnClickListener
{
  private final WSDramaPageFragment a;
  
  public WSDramaCommonTopAreaController(WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramWSDramaPageFragment.getContext());
    this.a = paramWSDramaPageFragment;
  }
  
  private void f()
  {
    if (this.a.getBaseActivity() != null)
    {
      this.a.getBaseActivity().doOnBackPressed();
      g();
    }
  }
  
  private void g()
  {
    AbsWSDramaHolder localAbsWSDramaHolder = this.a.a();
    String str = this.a.a();
    WSDramaBeaconReport.c(WSDramaUtils.b(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), WSDramaUtils.c(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), str);
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 1929641987;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(1929576453);
    WSVerticalUtils.a(this.a.getBaseActivity(), localRelativeLayout);
    a(1929576454).setOnClickListener(this);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    if (paramView.getId() == 1929576454) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.topbar.WSDramaCommonTopAreaController
 * JD-Core Version:    0.7.0.1
 */