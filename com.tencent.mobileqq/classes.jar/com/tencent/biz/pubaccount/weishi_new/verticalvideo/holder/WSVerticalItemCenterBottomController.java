package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stOpVideo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.BaseApplication;

public class WSVerticalItemCenterBottomController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private stOpVideo jdField_a_of_type_UserGrowthStOpVideo;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  
  public WSVerticalItemCenterBottomController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = WSVerticalUtils.a(paramWSVerticalPageFragment.a());
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_UserGrowthStOpVideo != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      String str3 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      WSStSchemaJumpManager localWSStSchemaJumpManager = new WSStSchemaJumpManager(a()).a(this.jdField_a_of_type_UserGrowthStOpVideo.jump);
      WSVerticalPageFragment localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      String str1;
      if (this.jdField_a_of_type_UserGrowthStOpVideo.jump != null) {
        str1 = this.jdField_a_of_type_UserGrowthStOpVideo.jump.schema;
      } else {
        str1 = "";
      }
      localWSStSchemaJumpManager.a(a(localWSVerticalPageFragment, 17, str1)).a(new WSVerticalItemCenterBottomController.1(this, str2, str3)).c();
    }
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560039;
  }
  
  protected void b()
  {
    Object localObject = (WSVerticalItemData)a();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).a() instanceof stSimpleMetaFeed))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((WSVerticalItemData)localObject).a();
      this.jdField_a_of_type_UserGrowthStOpVideo = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.opVideo;
      localObject = this.jdField_a_of_type_UserGrowthStOpVideo;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((stOpVideo)localObject).img_url))
        {
          localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130841770);
          WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_UserGrowthStOpVideo.img_url, (Drawable)localObject);
          WSVerticalBeaconReport.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStOpVideo.text)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStOpVideo.text);
        }
      }
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131369561));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379981));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131369561) {
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemCenterBottomController
 * JD-Core Version:    0.7.0.1
 */