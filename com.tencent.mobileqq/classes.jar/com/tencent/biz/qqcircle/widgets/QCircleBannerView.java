package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StImage;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import uxh;
import vrf;
import vuy;
import vuz;
import zby;

public class QCircleBannerView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private vuz jdField_a_of_type_Vuz;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public QCircleBannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f = paramStImage.height.get() * 1.0F / paramStImage.width.get();
      int i = zby.a(getContext());
      paramStImage = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramStImage.height = Math.round(f * i);
      paramStImage.width = -1;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramStImage);
    }
  }
  
  public int a()
  {
    return 2131560720;
  }
  
  protected String a()
  {
    return "QCircleInviteBannerView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369053));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376623));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(true);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof QQCircleDitto.StSinglePicBanner))
    {
      paramObject = (QQCircleDitto.StSinglePicBanner)paramObject;
      if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramObject.image.get() != null) && (!TextUtils.isEmpty(paramObject.image.picUrl.get())))
      {
        QLog.d("QCircleInviteBannerView", 1, "banner url is:" + paramObject.image.picUrl.get());
        a(paramObject.image);
        uxh.a(paramObject.image.picUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, null, false, new vuy(this));
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleInviteBannerView", 1, "onAttachedToWindow");
    vrf.a("", 22, 14, 1, "", "", "", "", "", this.jdField_a_of_type_ArrayOfByte, d(), -1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vuz != null) {
        this.jdField_a_of_type_Vuz.a();
      }
      vrf.a("", 22, 14, 2, "", "", "", "", "", this.jdField_a_of_type_ArrayOfByte, d(), -1);
      continue;
      if (this.jdField_a_of_type_Vuz != null) {
        this.jdField_a_of_type_Vuz.b();
      }
      vrf.a("", 22, 14, 3, "", "", "", "", "", this.jdField_a_of_type_ArrayOfByte, d(), -1);
    }
  }
  
  public void setInviteBannerClickListener(vuz paramvuz)
  {
    this.jdField_a_of_type_Vuz = paramvuz;
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBannerView
 * JD-Core Version:    0.7.0.1
 */