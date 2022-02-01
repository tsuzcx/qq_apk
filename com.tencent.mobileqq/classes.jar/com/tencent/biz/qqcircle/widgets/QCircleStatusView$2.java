package com.tencent.biz.qqcircle.widgets;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

class QCircleStatusView$2
  implements Runnable
{
  QCircleStatusView$2(QCircleStatusView paramQCircleStatusView, ImageView paramImageView, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(this.this$0.getResources().getColor(2131167247));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredHeight();
      QLog.d("QCircleStatusView", 1, "options.mRequestWidth =" + localURLDrawableOptions.mRequestWidth + "options.mRequestHeight =" + localURLDrawableOptions.mRequestHeight);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView.2
 * JD-Core Version:    0.7.0.1
 */