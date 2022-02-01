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
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.miniapp.WSMiniAppHelper;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.open.base.ToastUtil;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("followStatus:");
    localStringBuilder.append(i);
    localStringBuilder.append(",personInfo hashCode:");
    localStringBuilder.append(paramstSimpleMetaPerson.hashCode());
    WSLog.d("WSVerticalItemTopController", localStringBuilder.toString());
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
      if (paramstSimpleMetaPerson != null)
      {
        int i = paramstSimpleMetaPerson.type;
        Object localObject1;
        Object localObject2;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              paramstSimpleMetaPerson = paramstSimpleMetaPerson.H5Url;
              WeishiActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("h5Url is :");
              ((StringBuilder)localObject1).append(paramstSimpleMetaPerson);
              WSLog.d("weishi", ((StringBuilder)localObject1).toString());
              c(1000004);
            }
          }
          else
          {
            paramstSimpleMetaPerson = paramstSimpleMetaPerson.schema;
            i = WSGlobalConfig.a().a();
            if (WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext))
            {
              WeishiScehmeUtil.a(this.jdField_a_of_type_AndroidContentContext, "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, 1, i, 1);
              c(1000003);
            }
            else
            {
              localObject1 = new WSDownloadParams();
              ((WSDownloadParams)localObject1).mScene = WSVerticalUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
              ((WSDownloadParams)localObject1).mLinkStrategyType = i;
              ((WSDownloadParams)localObject1).mEventId = 1;
              ((WSDownloadParams)localObject1).mTestId = WeishiUtils.a(2);
              localObject2 = UserActionReportPresenter.a();
              ((stReportItem)localObject2).pagetype = 2;
              ((stReportItem)localObject2).optype = 115;
              ((WSDownloadParams)localObject1).mStReportItem = ((stReportItem)localObject2);
              ((WSDownloadParams)localObject1).mScheme = paramstSimpleMetaPerson;
              WeishiDownloadUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getBaseActivity(), (WSDownloadParams)localObject1, false);
              c(1000002);
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("schema is :");
            ((StringBuilder)localObject1).append(paramstSimpleMetaPerson);
            WSLog.d("weishi", ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          localObject1 = paramstSimpleMetaPerson.miniAppSchema;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("miniShema is :");
          ((StringBuilder)localObject2).append((String)localObject1);
          WSLog.d("weishi", ((StringBuilder)localObject2).toString());
          WSMiniAppHelper.a().a(this.jdField_a_of_type_AndroidContentContext, paramstSimpleMetaPerson.miniAppSchema);
          c(1000001);
        }
      }
    }
    WSLog.b("WSVerticalItemTopController", "Jump to personal page.");
  }
  
  private void c(int paramInt)
  {
    WSVerticalBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramInt, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
  }
  
  private void f()
  {
    if (!NetworkUtil.a(a()))
    {
      ToastUtil.a().a(2131720447);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness = WSUserBusiness.a();
    }
    Object localObject = (WSVerticalItemData)a();
    if (localObject == null) {
      return;
    }
    WSLog.b("WSVerticalItemTopController", "Follow user.");
    if ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).a().poster;
      if (localObject != null)
      {
        if (WSFeedUtils.a(((stSimpleMetaPerson)localObject).followStatus))
        {
          WSFeedUtils.a(a(), new WSVerticalItemTopController.1(this, (stSimpleMetaPerson)localObject), null);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDataWSUserBusiness.a(((stSimpleMetaPerson)localObject).id, 1);
        ((stSimpleMetaPerson)localObject).followStatus = 1;
        this.b.setText("已关注");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("---> followStatus:");
        localStringBuilder.append(((stSimpleMetaPerson)localObject).followStatus);
        localStringBuilder.append(",personInfo hashCode:");
        localStringBuilder.append(localObject.hashCode());
        WSLog.a("WSVerticalItemTopController", localStringBuilder.toString());
        this.b.setVisibility(8);
      }
    }
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData == null) {
      return;
    }
    if ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  protected int b()
  {
    return 2131560046;
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateUI hashcode******************************");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(",position:");
    ((StringBuilder)localObject).append(a());
    WSLog.a("WSVerticalItemTopController", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)a();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).a().poster;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((stSimpleMetaPerson)localObject).nick);
        WSPicLoader.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, ((stSimpleMetaPerson)localObject).avatar);
        a((stSimpleMetaPerson)localObject);
      }
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = WeishiUIUtil.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = WeishiUIUtil.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = WeishiUIUtil.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131380445));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380451));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b = ((TextView)a(2131380450));
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = ((WSVerticalItemData)a()).a().poster;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380450: 
      f();
      WSVerticalBeaconReport.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
      return;
    }
    b(localstSimpleMetaPerson);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopController
 * JD-Core Version:    0.7.0.1
 */