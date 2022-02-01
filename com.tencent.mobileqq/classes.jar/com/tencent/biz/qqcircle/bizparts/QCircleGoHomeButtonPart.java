package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizeDetailFragment;
import com.tencent.biz.qqcircle.fragments.feeddetail.QCircleFeedDetailFragment;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalDetailFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.HashMap;
import java.util.Map;

public class QCircleGoHomeButtonPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  protected ImageView a;
  private TextView c;
  private View d;
  private QCircleInitBean e;
  private int f;
  private AnimatorSet g;
  private final Runnable h = new QCircleGoHomeButtonPart.1(this);
  private final Runnable i = new QCircleGoHomeButtonPart.2(this);
  private AnimatorSet j;
  
  private boolean i()
  {
    QCircleInitBean localQCircleInitBean = this.e;
    if (localQCircleInitBean == null) {
      return false;
    }
    return localQCircleInitBean.isNeedShowGoHomeButton();
  }
  
  private void l()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    VideoReport.setElementId(localObject, "em_xsj_home_button");
    localObject = new QCircleDTParamBuilder().buildElementParams();
    ((Map)localObject).put("xsj_banner_content", QCircleConfigHelper.aw());
    VideoReport.setElementParams(this.d, (Map)localObject);
  }
  
  private int m()
  {
    if ((j() instanceof QCircleFeedDetailFragment)) {
      return 54;
    }
    if ((j() instanceof QCirclePersonalDetailFragment)) {
      return 11;
    }
    if ((j() instanceof QCirclePolymerizationFragment)) {
      return 46;
    }
    if ((j() instanceof QCirclePolymerizeDetailFragment))
    {
      int k = this.f;
      if (k != 0) {
        return k;
      }
    }
    return 0;
  }
  
  private int n()
  {
    if ((j() instanceof QCircleFeedDetailFragment)) {
      return 3;
    }
    if ((j() instanceof QCirclePersonalDetailFragment)) {
      return 41;
    }
    if ((j() instanceof QCirclePolymerizationFragment)) {
      return 6;
    }
    if ((j() instanceof QCirclePolymerizeDetailFragment)) {
      return 2;
    }
    return 0;
  }
  
  private void o()
  {
    if (this.c == null) {
      return;
    }
    Object localObject = this.g;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning())) {
      return;
    }
    QCircleSpUtil.a("show_go_home_button_last_time", Long.valueOf(System.currentTimeMillis()));
    this.c.setVisibility(0);
    if (this.g == null) {
      this.g = new AnimatorSet();
    }
    localObject = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 1.0F });
    ((ObjectAnimator)localObject).setDuration(320L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.c, "translationX", new float[] { ViewUtils.a(80.0F), 0.0F });
    localObjectAnimator.setDuration(320L);
    this.g.play((Animator)localObject).with(localObjectAnimator);
    this.g.start();
  }
  
  private void p()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    if (((TextView)localObject).getVisibility() != 0) {
      return;
    }
    localObject = this.g;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning())) {
      return;
    }
    localObject = this.j;
    if ((localObject != null) && (((AnimatorSet)localObject).isRunning())) {
      return;
    }
    if (this.j == null) {
      this.j = new AnimatorSet();
    }
    localObject = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(320L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.c, "translationX", new float[] { 0.0F, ViewUtils.a(80.0F) });
    localObjectAnimator.setDuration(320L);
    this.j.play((Animator)localObject).with(localObjectAnimator);
    this.j.addListener(new QCircleGoHomeButtonPart.3(this));
    this.j.start();
  }
  
  private boolean q()
  {
    boolean bool = false;
    int k;
    try
    {
      k = Integer.parseInt(QCircleConfigHelper.ax());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse go home guide interval error ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleGoHomeButtonPart", 1, localStringBuilder.toString());
      localException.printStackTrace();
      k = 0;
    }
    Object localObject = QCircleSpUtil.b("show_go_home_button_last_time", Long.valueOf(0L));
    if ((localObject instanceof Long))
    {
      if (System.currentTimeMillis() - ((Long)localObject).longValue() >= k * 60L * 60L * 1000L) {
        bool = true;
      }
      return bool;
    }
    return true;
  }
  
  private void r()
  {
    QCircleHostGlobalInfo.setByShareOpenQCircle(true);
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    Object localObject = this.e;
    if ((localObject != null) && (((QCircleInitBean)localObject).getSchemeAttrs() != null) && (this.e.getSchemeAttrs().containsKey("key_scheme")))
    {
      localObject = (String)this.e.getSchemeAttrs().get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localQCircleFolderBean.setLastPageScheme((String)localObject);
      }
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetTabListRequest(null, localQCircleFolderBean), new QCircleGoHomeButtonPart.4(this));
  }
  
  private void s()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(m()).setSubActionType(n()).setThrActionType(2));
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    localQCircleFolderBean.setAssignShowTabType(6);
    localQCircleFolderBean.setFromReportBean(d().clone());
    localQCircleFolderBean.setEnableSplash(true);
    Object localObject = this.e;
    if ((localObject != null) && (((QCircleInitBean)localObject).getSchemeAttrs() != null) && (this.e.getSchemeAttrs().containsKey("key_scheme")))
    {
      localObject = (String)this.e.getSchemeAttrs().get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localQCircleFolderBean.setLastPageScheme((String)localObject);
      }
    }
    QCircleLauncher.a(g(), localQCircleFolderBean);
  }
  
  public String a()
  {
    return "QCircleGoHomeButtonPart";
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    if (i())
    {
      paramView = ((ViewStub)paramView.findViewById(2131441698)).inflate();
      this.d = paramView.findViewById(2131433264);
      this.a = ((ImageView)paramView.findViewById(2131436619));
      this.c = ((TextView)paramView.findViewById(2131448511));
      this.a.setVisibility(0);
      this.d.setOnClickListener(this);
      this.c.setText(QCircleConfigHelper.aw());
      l();
      E().a("publish_show_or_hide", Boolean.valueOf(false));
      if (q())
      {
        RFThreadManager.getUIHandler().postDelayed(this.h, 500L);
        RFThreadManager.getUIHandler().postDelayed(this.i, 3500L);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    RFThreadManager.getUIHandler().removeCallbacks(this.h);
    RFThreadManager.getUIHandler().removeCallbacks(this.i);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (i()) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(m()).setSubActionType(n()).setThrActionType(1));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433264) {
      r();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart
 * JD-Core Version:    0.7.0.1
 */