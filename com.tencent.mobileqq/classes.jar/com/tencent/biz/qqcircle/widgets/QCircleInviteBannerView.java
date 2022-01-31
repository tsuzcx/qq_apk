package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StImage;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import tql;
import tzv;
import ueb;
import uec;
import xin;

public class QCircleInviteBannerView
  extends BaseWidgetView
  implements View.OnClickListener
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private uec jdField_a_of_type_Uec;
  
  public QCircleInviteBannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f = paramStImage.height.get() * 1.0F / paramStImage.width.get();
      int i = xin.a(getContext());
      paramStImage = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramStImage.height = ((int)(f * i));
      paramStImage.width = i;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramStImage);
    }
  }
  
  public int a()
  {
    return 2131560555;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368716));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375884));
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
        QLog.d("QCircleInviteBannerPart", 1, "banner url is:" + paramObject.image.picUrl.get());
        a(paramObject.image);
        tql.a(paramObject.image.picUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, null, false, new ueb(this));
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    tzv.a("", 22, 14L, 1L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368716: 
      if (this.jdField_a_of_type_Uec != null) {
        this.jdField_a_of_type_Uec.a();
      }
      tzv.a("", 22, 14L, 2L);
      return;
    }
    if (this.jdField_a_of_type_Uec != null) {
      this.jdField_a_of_type_Uec.b();
    }
    tzv.a("", 22, 14L, 3L);
  }
  
  public void setInviteBannerClickListener(uec paramuec)
  {
    this.jdField_a_of_type_Uec = paramuec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleInviteBannerView
 * JD-Core Version:    0.7.0.1
 */