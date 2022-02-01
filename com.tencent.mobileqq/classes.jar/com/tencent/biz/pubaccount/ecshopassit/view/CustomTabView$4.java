package com.tencent.biz.pubaccount.ecshopassit.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgsp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import odx;
import oet;
import zlx;

class CustomTabView$4
  implements Runnable
{
  CustomTabView$4(CustomTabView paramCustomTabView, odx paramodx, ImageView paramImageView, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    oet.a(this.jdField_a_of_type_Odx.b);
    Object localObject = this.jdField_a_of_type_Odx.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(this.jdField_a_of_type_Odx.jdField_a_of_type_Int));
    if (bgsp.a((String)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843457);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = zlx.a(CustomTabView.a(this.this$0), 9.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = zlx.a(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-zlx.a(CustomTabView.a(this.this$0), 8.0F));
      return;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_Odx.f == 1)
        {
          this.this$0.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = zlx.a(CustomTabView.a(this.this$0), 63.0F);
          this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = zlx.a(CustomTabView.a(this.this$0), 18.0F);
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (-zlx.a(CustomTabView.a(this.this$0), 3.0F));
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-zlx.a(CustomTabView.a(this.this$0), 10.0F));
          localURLDrawableOptions.mRequestWidth = zlx.a(CustomTabView.a(this.this$0), 63.0F);
          localURLDrawableOptions.mRequestHeight = zlx.a(CustomTabView.a(this.this$0), 20.0F);
          localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
          if (localObject == null) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localException));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = zlx.a(CustomTabView.a(this.this$0), 9.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = zlx.a(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).leftMargin = (-zlx.a(CustomTabView.a(this.this$0), 8.0F));
      localURLDrawableOptions.mRequestWidth = zlx.a(CustomTabView.a(this.this$0), 9.0F);
      localURLDrawableOptions.mRequestHeight = zlx.a(CustomTabView.a(this.this$0), 9.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView.4
 * JD-Core Version:    0.7.0.1
 */