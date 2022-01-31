package com.tencent.biz.pubaccount.ecshopassit.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bbjw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import vzo;

class CustomTabView$2
  implements Runnable
{
  CustomTabView$2(CustomTabView paramCustomTabView, qq_ad.QQAdGetRsp.RedPointInfo paramRedPointInfo, ImageView paramImageView, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_TencentImOidbQqshopQq_ad$QQAdGetRsp$RedPointInfo.red_url.get();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(this.jdField_a_of_type_TencentImOidbQqshopQq_ad$QQAdGetRsp$RedPointInfo.task_id.get()));
    if (bbjw.a((String)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842912);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = vzo.a(CustomTabView.a(this.this$0), 9.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = vzo.a(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-vzo.a(CustomTabView.a(this.this$0), 8.0F));
    }
    for (;;)
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_TencentImOidbQqshopQq_ad$QQAdGetRsp$RedPointInfo.red_type.get() == 1)
        {
          this.this$0.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = vzo.a(CustomTabView.a(this.this$0), 63.0F);
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = vzo.a(CustomTabView.a(this.this$0), 18.0F);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (-vzo.a(CustomTabView.a(this.this$0), 3.0F));
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-vzo.a(CustomTabView.a(this.this$0), 10.0F));
          localURLDrawableOptions.mRequestWidth = vzo.a(CustomTabView.a(this.this$0), 63.0F);
        }
        for (localURLDrawableOptions.mRequestHeight = vzo.a(CustomTabView.a(this.this$0), 20.0F);; localURLDrawableOptions.mRequestHeight = vzo.a(CustomTabView.a(this.this$0), 9.0F))
        {
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          if (localObject == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = vzo.a(CustomTabView.a(this.this$0), 9.0F);
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = vzo.a(CustomTabView.a(this.this$0), 9.0F);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-vzo.a(CustomTabView.a(this.this$0), 8.0F));
          localURLDrawableOptions.mRequestWidth = vzo.a(CustomTabView.a(this.this$0), 9.0F);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView.2
 * JD-Core Version:    0.7.0.1
 */