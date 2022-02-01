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
  private final WSDramaPageFragment g;
  
  public WSDramaCommonTopAreaController(WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramWSDramaPageFragment.getContext());
    this.g = paramWSDramaPageFragment;
  }
  
  private void l()
  {
    if (this.g.getBaseActivity() != null)
    {
      this.g.getBaseActivity().doOnBackPressed();
      m();
    }
  }
  
  private void m()
  {
    AbsWSDramaHolder localAbsWSDramaHolder = this.g.e();
    String str = this.g.b();
    WSDramaBeaconReport.c(WSDramaUtils.b(localAbsWSDramaHolder), WSDramaUtils.a(localAbsWSDramaHolder), WSDramaUtils.c(localAbsWSDramaHolder), WSDramaUtils.d(localAbsWSDramaHolder), str);
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 1929773067;
  }
  
  protected void j()
  {
    if (this.g == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)c(1929707528);
    WSVerticalUtils.a(this.g.getBaseActivity(), localRelativeLayout);
    c(1929707529).setOnClickListener(this);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    if (paramView.getId() == 1929707529) {
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.topbar.WSDramaCommonTopAreaController
 * JD-Core Version:    0.7.0.1
 */