package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleConfirmCircleMemberShipRequest;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.List;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleTopAuthPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private long a = 8000L;
  private ViewStub c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private Runnable i;
  private Handler j;
  private int k = -1;
  private int l = -1;
  private QQCircleBase.UserCircleInfo m;
  private String n = "";
  private String o = "";
  private String p = "";
  
  private void b(boolean paramBoolean)
  {
    i();
    if (paramBoolean)
    {
      QCirclePluginConfig.a().j();
      if ((this.d.getVisibility() == 8) && (!c().isFinishing())) {
        this.d.setVisibility(0);
      }
    }
    else if ((this.d.getVisibility() == 0) && (!c().isFinishing()))
    {
      this.d.setVisibility(8);
    }
  }
  
  private void i()
  {
    if (F() != null)
    {
      if (this.c != null) {
        return;
      }
      this.c = ((ViewStub)F().findViewById(2131440975));
      this.d = this.c.inflate();
      this.e = ((TextView)this.d.findViewById(2131440976));
      this.f = ((TextView)this.d.findViewById(2131441589));
      this.g = ((TextView)this.d.findViewById(2131441590));
      this.h = ((ImageView)this.d.findViewById(2131441591));
      this.h.setOnClickListener(this);
      this.g.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.j = new Handler(Looper.myLooper());
    }
  }
  
  private QCircleTabInfo l()
  {
    if ((j() != null) && ((j() instanceof QCircleBaseTabFragment))) {
      return ((QCircleBaseTabFragment)j()).U();
    }
    return null;
  }
  
  private void m()
  {
    int i1 = this.l;
    if ((i1 != 1) && (i1 != 2))
    {
      n();
      return;
    }
    if (l() != null)
    {
      Context localContext = g();
      List localList = l().a.urlInfo.get();
      String str;
      if (this.l == 1) {
        str = "authSchoolUrl";
      } else {
        str = "authCampanyUrl";
      }
      QCircleLauncher.a(localContext, QCircleJsUrlConfig.a(localList, str), null, -1);
    }
  }
  
  private void n()
  {
    ActionSheet localActionSheet = ActionSheet.a(g());
    localActionSheet.a(2131895796, 0);
    localActionSheet.a(2131895795, 0);
    localActionSheet.e(2131887648);
    localActionSheet.a(new QCircleTopAuthPart.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void o()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      localObject = new QCircleConfirmCircleMemberShipRequest(null, (QQCircleBase.UserCircleInfo)localObject);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleTopAuthPart.3(this));
    }
  }
  
  public String a()
  {
    return "QCircleTopAuthPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    a(j(), paramView, E());
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.j;
    if (paramActivity != null)
    {
      Runnable localRunnable = this.i;
      if (localRunnable != null) {
        paramActivity.removeCallbacks(localRunnable);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131441591)
    {
      b(false);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(6).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
      QCircleToast.a(QCircleToast.b, 2131895649, 0);
    }
    else if (i1 == 2131441590)
    {
      i1 = this.k;
      if (i1 == -1)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(3).setThrActionType(0).setPageId(f()));
        n();
        b(false);
      }
      else if (i1 == 5)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(4).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(7).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
        m();
        b(false);
      }
      else if (i1 == 4)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(4).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(8).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
        o();
        QCircleToast.a(QCircleToast.d, 2131895629, 0);
        b(false);
      }
    }
    else if (i1 == 2131441589)
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(5).setThrActionType(0).setExt1(this.n).setExt6(this.o).setExt7(this.p).setPageId(f()));
      m();
      b(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart
 * JD-Core Version:    0.7.0.1
 */