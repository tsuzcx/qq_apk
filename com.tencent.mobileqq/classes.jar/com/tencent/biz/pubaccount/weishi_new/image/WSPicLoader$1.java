package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import java.net.URL;

final class WSPicLoader$1
  implements IBitmapCallback
{
  WSPicLoader$1(ImageView paramImageView, Drawable paramDrawable) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    if (TextUtils.equals((String)this.jdField_a_of_type_AndroidWidgetImageView.getTag(), paramImageRequest.a.toString())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramICloseableBitmap.a());
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.1
 * JD-Core Version:    0.7.0.1
 */