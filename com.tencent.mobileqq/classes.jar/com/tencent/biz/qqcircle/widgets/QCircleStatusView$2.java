package com.tencent.biz.qqcircle.widgets;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

class QCircleStatusView$2
  implements Runnable
{
  QCircleStatusView$2(QCircleStatusView paramQCircleStatusView, ImageView paramImageView, String paramString) {}
  
  public void run()
  {
    if (this.a != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = new ColorDrawable(this.this$0.getResources().getColor(2131168376));
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestWidth = this.a.getMeasuredWidth();
      localURLDrawableOptions.mRequestHeight = this.a.getMeasuredHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("options.mRequestWidth =");
      ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestWidth);
      ((StringBuilder)localObject).append("options.mRequestHeight =");
      ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestHeight);
      QLog.d("QCircleStatusView", 1, ((StringBuilder)localObject).toString());
      this.a.setImageDrawable(URLDrawable.getFileDrawable(this.b, localURLDrawableOptions));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView.2
 * JD-Core Version:    0.7.0.1
 */