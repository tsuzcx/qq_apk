package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stReportItem;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemTopController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSUserBusiness jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private TextView b;
  
  public WSVerticalItemTopController(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSVerticalItemTopController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (TextUtils.equals(WeishiUtils.d(), paramstSimpleMetaPerson.id))
    {
      this.b.setVisibility(8);
      return;
    }
    int i = paramstSimpleMetaPerson.followStatus;
    WSLog.d("WSVerticalItemTopController", "followStatus:" + i + ",personInfo hashCode:" + paramstSimpleMetaPerson.hashCode());
    if (WSFeedUtils.a(paramstSimpleMetaPerson.followStatus))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setText("关注");
    this.b.setVisibility(0);
  }
  
  private void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson != null)
    {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.avatarSchema;
      if (paramstSimpleMetaPerson != null) {
        switch (paramstSimpleMetaPerson.type)
        {
        }
      }
    }
    for (;;)
    {
      WSLog.b("WSVerticalItemTopController", "Jump to personal page.");
      return;
      Object localObject = paramstSimpleMetaPerson.miniAppSchema;
      WSLog.d("weishi", "miniShema is :" + (String)localObject);
      WSMiniAppHelper.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
      c(1000001);
      continue;
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
      int i = WSGlobalConfig.a().a();
      if (WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext))
      {
        WeishiScehmeUtil.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
        c(1000003);
      }
      for (;;)
      {
        WSLog.d("weishi", "schema is :" + paramstSimpleMetaPerson);
        break;
        localObject = new WSDownloadParams();
        ((WSDownloadParams)localObject).mScene = WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        ((WSDownloadParams)localObject).mLinkStrategyType = i;
        ((WSDownloadParams)localObject).mEventId = 1;
        ((WSDownloadParams)localObject).mTestId = WeishiUtils.a(2);
        stReportItem localstReportItem = UserActionReportPresenter.a();
        localstReportItem.pagetype = 2;
        localstReportItem.optype = 115;
        ((WSDownloadParams)localObject).mStReportItem = localstReportItem;
        ((WSDownloadParams)localObject).mScheme = paramstSimpleMetaPerson;
        WeishiDownloadUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), (WSDownloadParams)localObject, false);
        c(1000002);
      }
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
      WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
      WSLog.d("weishi", "h5Url is :" + paramstSimpleMetaPerson);
      c(1000004);
    }
  }
  
  private void c(int paramInt)
  {
    WSVerticalBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramInt, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  private void f()
  {
    if (!NetworkUtil.a(a())) {
      ToastUtil.a().a(2131720723);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
          }
          localObject = (WSVerticalItemData)a();
        } while (localObject == null);
        WSLog.b("WSVerticalItemTopController", "Follow user.");
      } while (!(((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((WSVerticalItemData)localObject).a().poster;
    } while (localObject == null);
    if (WSFeedUtils.a(((stSimpleMetaPerson)localObject).followStatus))
    {
      WSFeedUtils.a(a(), new WSVerticalItemTopController.1(this, (stSimpleMetaPerson)localObject), null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness.a(((stSimpleMetaPerson)localObject).id, 1);
    ((stSimpleMetaPerson)localObject).followStatus = 1;
    this.b.setText("已关注");
    WSLog.a("WSVerticalItemTopController", "---> followStatus:" + ((stSimpleMetaPerson)localObject).followStatus + ",personInfo hashCode:" + localObject.hashCode());
    this.b.setVisibility(8);
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData == null) {}
    while (!(localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
  }
  
  public int b()
  {
    return 2131560161;
  }
  
  @UiThread
  public void b()
  {
    WSLog.a("WSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    Object localObject = (WSVerticalItemData)a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed));
      localObject = ((WSVerticalItemData)localObject).a().poster;
    } while (localObject == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, ((stSimpleMetaPerson)localObject).avatar);
    a((stSimpleMetaPerson)localObject);
  }
  
  public void c() {}
  
  public void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = WeishiUIUtil.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = WeishiUIUtil.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = WeishiUIUtil.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131381192));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381197));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131381196));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((WSVerticalItemData)a()).a().poster;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(localstSimpleMetaPerson);
      continue;
      f();
      WSVerticalBeaconReport.e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopController
 * JD-Core Version:    0.7.0.1
 */