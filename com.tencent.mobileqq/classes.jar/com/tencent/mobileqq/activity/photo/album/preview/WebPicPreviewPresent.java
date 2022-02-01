package com.tencent.mobileqq.activity.photo.album.preview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;

public class WebPicPreviewPresent
  extends PicPreviewPresent
{
  public WebPicPreviewPresent(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = this.mBean.getPath();
    paramView = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
    localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramViewGroup = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), localURLDrawableOptions);
    if (paramViewGroup == null) {
      QLog.w("PEAK", 2, "drawable == null");
    }
    paramView.setImageDrawable(paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.WebPicPreviewPresent
 * JD-Core Version:    0.7.0.1
 */