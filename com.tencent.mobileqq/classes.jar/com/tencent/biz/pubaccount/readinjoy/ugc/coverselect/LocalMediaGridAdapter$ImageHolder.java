package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.net.URL;

public class LocalMediaGridAdapter$ImageHolder
  extends BaseViewHolder<AlbumUtils.LocalMediaInfo>
{
  public View a;
  public ImageView a;
  
  public LocalMediaGridAdapter$ImageHolder(LocalMediaGridAdapter paramLocalMediaGridAdapter, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369628));
    this.jdField_a_of_type_AndroidViewView = a(2131371077);
  }
  
  protected URL a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append("FLOW_THUMB");
    try
    {
      paramString = new URL(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public void a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    if (LocalMediaGridAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter) == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new LocalMediaGridAdapter.ImageHolder.1(this, paramInt));
      a(paramLocalMediaInfo);
      return;
    }
  }
  
  protected void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = LocalMediaGridAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter);
      ((URLDrawable.URLDrawableOptions)localObject).mPriority = 2;
      String str = paramLocalMediaInfo.b;
      URL localURL = a(str);
      if ((TextUtils.isEmpty(str)) || (localURL == null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(LocalMediaGridAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter));
        return;
      }
      localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      if (paramLocalMediaInfo.a != null)
      {
        paramLocalMediaInfo.a.thumbWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        paramLocalMediaInfo.a.thumbHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
        ((URLDrawable)localObject).setTag(paramLocalMediaInfo.a);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Throwable paramLocalMediaInfo)
    {
      QLog.e("RIJUGC.LocalMediaGridAdapter", 1, "load cover failed", paramLocalMediaInfo);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter.ImageHolder
 * JD-Core Version:    0.7.0.1
 */