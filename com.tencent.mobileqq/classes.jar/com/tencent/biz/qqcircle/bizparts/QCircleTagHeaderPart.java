package com.tencent.biz.qqcircle.bizparts;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.TagDescPublishEvent;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleGetRankingListRequest;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleFuelTopView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRankingItem;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetRankingListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleTagHeaderPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  private ImageView a;
  private TextView c;
  private TextView d;
  private QCircleFuelTopView e;
  private LinearLayout f;
  private RelativeLayout g;
  private PopupWindow h;
  private List<FeedCloudMeta.StRankingItem> i = new ArrayList();
  
  private void a(View paramView, FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    paramView = ((ViewStub)paramView.findViewById(2131450019)).inflate();
    this.a = ((ImageView)paramView.findViewById(2131436528));
    this.f = ((LinearLayout)paramView.findViewById(2131437575));
    this.c = ((TextView)paramView.findViewById(2131448794));
    this.d = ((TextView)paramView.findViewById(2131448795));
    this.g = ((RelativeLayout)paramView.findViewById(2131445034));
    this.e = new QCircleFuelTopView(g());
    this.e.setReportBean(d());
    this.e.setParentPart(this);
    this.c.setText(paramStTagInfo.tagName.get());
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetRankingListRequest(paramStTagInfo.tagName.get()), new QCircleTagHeaderPart.1(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.DataBuilder localDataBuilder = new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQCircleExtraTypeInfo.mFeed.poster.id.get();
      }
      QCircleLpReportDc05507.report(localDataBuilder.setToUin(str).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(f()).setfpageid(e()));
      return;
    }
    paramString = new StringBuilder();
    paramString.append("extraTypeInfo is null or lost feed,actionType:");
    paramString.append(paramInt1);
    paramString.append(",subActionType:");
    paramString.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleTagHeaderPart", 1, paramString.toString());
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.i.clear();
      this.i.addAll(paramStGetRankingListRsp.items.get());
      if (paramStGetRankingListRsp.items.size() >= 3)
      {
        this.e.setData(paramStGetRankingListRsp);
        this.a.setVisibility(0);
        this.g.setOnClickListener(this);
      }
    }
  }
  
  private void l()
  {
    this.f.setOnClickListener(this);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void m()
  {
    a("", 81, 1, i());
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StRankingItem localStRankingItem = (FeedCloudMeta.StRankingItem)localIterator.next();
      a(localStRankingItem.user.id.get(), 89, 8, i());
      if (localStRankingItem.user.followState.get() != 1) {
        a(localStRankingItem.user.id.get(), 89, 9, i());
      }
    }
    r();
    this.f.setVisibility(0);
    if (this.h == null) {
      o();
    }
    this.h.showAsDropDown(this.d, 0, ViewUtils.a(20.0F));
    p();
  }
  
  private void n()
  {
    s();
    PopupWindow localPopupWindow = this.h;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.h.dismiss();
    }
    q();
  }
  
  private void o()
  {
    this.h = new PopupWindow(this.e, -1, -2);
    this.h.setAnimationStyle(2131953416);
  }
  
  private void p()
  {
    LinearLayout localLinearLayout = this.f;
    if (localLinearLayout != null) {
      ObjectAnimator.ofFloat(localLinearLayout, "alpha", new float[] { 0.0F, 1.0F }).setDuration(250L).start();
    }
  }
  
  private void q()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      ((ObjectAnimator)localObject).addListener(new QCircleTagHeaderPart.2(this));
      ((ObjectAnimator)localObject).start();
    }
  }
  
  private void r()
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 0.0F, 180.0F }).setDuration(250L).start();
    }
  }
  
  private void s()
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      ObjectAnimator.ofFloat(localImageView, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
    }
  }
  
  public String a()
  {
    return "QCircleTagHeaderPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    FeedCloudMeta.StTagInfo localStTagInfo = ((QCircleInitBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo();
    if (localStTagInfo.has())
    {
      a(paramView, localStTagInfo);
      l();
      a(localStTagInfo);
    }
  }
  
  public boolean ah_()
  {
    PopupWindow localPopupWindow = this.h;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      n();
      return true;
    }
    return super.ah_();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TagDescPublishEvent.class);
    return localArrayList;
  }
  
  public QCircleExtraTypeInfo i()
  {
    return (QCircleExtraTypeInfo)d("get_report_extra_type_info", "");
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.h;
    if (paramActivity != null)
    {
      paramActivity.dismiss();
      this.h = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick , view id: ");
    ((StringBuilder)localObject).append(j);
    QLog.d("QCircleTagHeaderPart", 1, ((StringBuilder)localObject).toString());
    if (j == 2131445034)
    {
      a("", 88, 2, i());
      localObject = this.h;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing())) {
        n();
      } else {
        m();
      }
    }
    else if (j == 2131437575)
    {
      localObject = this.h;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing())) {
        n();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof TagDescPublishEvent))
    {
      paramSimpleBaseEvent = (TagDescPublishEvent)paramSimpleBaseEvent;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent.mTagDesc)) {
        this.d.setText(paramSimpleBaseEvent.mTagDesc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagHeaderPart
 * JD-Core Version:    0.7.0.1
 */