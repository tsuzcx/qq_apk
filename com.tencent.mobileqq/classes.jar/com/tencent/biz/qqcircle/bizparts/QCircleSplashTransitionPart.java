package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleTransitionPageClickEvent;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils;
import com.tencent.biz.qqcircle.utils.QCircleSplashUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StNewUserPymkPageData;

public class QCircleSplashTransitionPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  View a;
  private View c;
  private PopupWindow d;
  private QCircleSplashViewModel e;
  private QCircleAvatarListView f;
  private View g;
  private View h;
  private ImageView i;
  private ImageView j;
  private TextView k;
  private View l;
  private RoundCorneredRelativeLayout m;
  private FeedCloudMeta.StFeed n;
  private FeedCloudMeta.StUser o;
  private QCircleInitBean p;
  private TextView q;
  private boolean r;
  
  private void a(String paramString, ImageView paramImageView, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    paramString = new Option().setTargetView(paramImageView).setUrl(paramString).setTargetView(paramImageView);
    if (paramDrawable1 != null) {
      paramString.setLoadingDrawable(paramDrawable1);
    }
    if (paramDrawable2 != null) {
      paramString.setFailDrawable(paramDrawable2);
    }
    QCircleFeedPicLoader.setViewWidthHeight(paramString, paramImageView);
    QCircleFeedPicLoader.g().loadImage(paramString, null);
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {
      return;
    }
    QCircleAvatarListView localQCircleAvatarListView = this.f;
    if (localQCircleAvatarListView != null) {
      localQCircleAvatarListView.setData(QCircleAvatarListUtils.a(paramStFeedListBusiRspData.newUserPymkPageData.friends.get(), 5));
    }
    paramStFeedListBusiRspData = this.g;
    if (paramStFeedListBusiRspData != null) {
      paramStFeedListBusiRspData.setVisibility(0);
    }
    paramStFeedListBusiRspData = this.h;
    if (paramStFeedListBusiRspData != null) {
      paramStFeedListBusiRspData.setVisibility(8);
    }
    if (this.j != null) {
      a(QCircleSkinHelper.getInstance().getUrl("invitation_welcome_title_860_1"), this.j, null, null);
    }
  }
  
  private void i()
  {
    this.p = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    this.c = LayoutInflater.from(g()).inflate(2131626964, null);
    this.m = ((RoundCorneredRelativeLayout)this.c.findViewById(2131444928));
    this.i = ((ImageView)this.c.findViewById(2131436586));
    this.j = ((ImageView)this.c.findViewById(2131436587));
    this.g = this.c.findViewById(2131437457);
    this.h = this.c.findViewById(2131437507);
    this.f = ((QCircleAvatarListView)this.c.findViewById(2131428291));
    this.q = ((TextView)this.c.findViewById(2131448607));
    this.k = ((TextView)this.c.findViewById(2131448430));
    this.l = this.c.findViewById(2131436318);
    int i1 = ViewUtils.a(12.0F);
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = this.m;
    float f1 = i1;
    localRoundCorneredRelativeLayout.setRadius(f1, f1, f1, f1);
    RFWTypefaceUtil.a(this.q, false);
    this.q.setText(QCircleConfigHelper.aC());
    this.k.setText(QCircleConfigHelper.aB());
    this.l.setOnClickListener(this);
    this.k.setOnClickListener(this);
    l();
    a(QCircleSkinHelper.getInstance().getUrl("invitation_welcome_bg_860"), this.i, null, null);
  }
  
  private void l()
  {
    this.e = ((QCircleSplashViewModel)a(QCircleSplashViewModel.class));
    this.e.a.observe(j(), new QCircleSplashTransitionPart.1(this));
    this.e.a(0, 1);
  }
  
  private void m()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.h;
    if (localView != null) {
      localView.setVisibility(0);
    }
    if (this.j != null) {
      a(QCircleSkinHelper.getInstance().getUrl("invitation_welcome_title_860_2"), this.j, null, null);
    }
  }
  
  private void n()
  {
    if (c() != null)
    {
      if (c().isFinishing()) {
        return;
      }
      if (this.c == null) {
        i();
      }
      if (this.d == null) {
        this.d = new PopupWindow(this.c, -1, ViewUtils.a(g()) + ViewUtils.a());
      }
      this.d.setClippingEnabled(false);
      if ((this.a != null) && (!this.d.isShowing()))
      {
        this.d.showAtLocation(this.a, 17, 0, 0);
        QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(101).setSubActionType(1).setPageId(d().getPageId());
        String str;
        if (this.r) {
          str = "1";
        } else {
          str = "2";
        }
        QCircleLpReportDc05504.report(localDataBuilder.setExt2(str));
      }
    }
  }
  
  private void o()
  {
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    Object localObject = this.p;
    if ((localObject != null) && (((QCircleInitBean)localObject).getSchemeAttrs() != null) && (this.p.getSchemeAttrs().containsKey("key_scheme")))
    {
      localObject = (String)this.p.getSchemeAttrs().get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localQCircleFolderBean.setLastPageScheme((String)localObject);
      }
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetTabListRequest(null, localQCircleFolderBean), new QCircleSplashTransitionPart.2(this));
  }
  
  private void p()
  {
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    localQCircleFolderBean.setAssignShowTabType(6);
    localQCircleFolderBean.setFromReportBean(d().clone());
    localQCircleFolderBean.setEnableSplash(true);
    Object localObject = this.n;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).id.get())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchFolderPage");
      ((StringBuilder)localObject).append(this.n.id.get());
      QLog.d("QCircleSplashTransitionPart", 1, ((StringBuilder)localObject).toString());
      localQCircleFolderBean.setFeed(this.n);
    }
    localObject = this.o;
    if ((localObject != null) && (!TextUtils.isEmpty(((FeedCloudMeta.StUser)localObject).id.get())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchFolderPage");
      ((StringBuilder)localObject).append(this.o.id.get());
      QLog.d("QCircleSplashTransitionPart", 1, ((StringBuilder)localObject).toString());
      localQCircleFolderBean.setUser(this.o);
      localQCircleFolderBean.setLaunchFrom("8");
    }
    localObject = this.p;
    if ((localObject != null) && (((QCircleInitBean)localObject).getSchemeAttrs() != null) && (this.p.getSchemeAttrs().containsKey("key_scheme")))
    {
      localObject = (String)this.p.getSchemeAttrs().get("key_scheme");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localQCircleFolderBean.setLastPageScheme((String)localObject);
      }
    }
    QCircleLauncher.a(g(), localQCircleFolderBean);
  }
  
  private void q()
  {
    PopupWindow localPopupWindow = this.d;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public String a()
  {
    return "QCircleSplashTransitionPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = paramView;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public boolean ah_()
  {
    PopupWindow localPopupWindow = this.d;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      this.d.dismiss();
      return true;
    }
    return super.ah_();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTransitionPageClickEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    q();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (QCircleSplashUtils.a()) {
      i();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    String str = "1";
    QCircleLpReportDc05504.DataBuilder localDataBuilder;
    if (i1 == 2131436318)
    {
      q();
      localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(101).setSubActionType(3).setPageId(d().getPageId());
      if (!this.r) {
        str = "2";
      }
      QCircleLpReportDc05504.report(localDataBuilder.setExt2(str));
    }
    else if (paramView.getId() == 2131448430)
    {
      o();
      localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(101).setSubActionType(2).setPageId(d().getPageId());
      if (!this.r) {
        str = "2";
      }
      QCircleLpReportDc05504.report(localDataBuilder.setExt2(str));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleTransitionPageClickEvent))
    {
      paramSimpleBaseEvent = (QCircleTransitionPageClickEvent)paramSimpleBaseEvent;
      this.n = paramSimpleBaseEvent.mFeed;
      this.o = paramSimpleBaseEvent.mUser;
      n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart
 * JD-Core Version:    0.7.0.1
 */