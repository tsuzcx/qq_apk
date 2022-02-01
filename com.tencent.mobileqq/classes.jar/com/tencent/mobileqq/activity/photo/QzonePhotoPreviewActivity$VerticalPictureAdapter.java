package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

class QzonePhotoPreviewActivity$VerticalPictureAdapter
  extends BaseAdapter
{
  private final String jdField_a_of_type_JavaLangString = "VerticalPictureAdapter";
  
  public QzonePhotoPreviewActivity$VerticalPictureAdapter(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity, Context paramContext)
  {
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.a.setRecyclerListener(new QzonePhotoPreviewActivity.VerticalPictureAdapter.1(this));
  }
  
  private void a(QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder paramVerticalPictureHolder, int paramInt)
  {
    QzonePhotoPreviewActivity.PicInfoItem localPicInfoItem = (QzonePhotoPreviewActivity.PicInfoItem)getItem(paramInt);
    if (localPicInfoItem == null)
    {
      QZLog.e("VerticalPictureAdapter", "photoInfo == null");
      return;
    }
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramVerticalPictureHolder.a.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
    }
    QZLog.d("VerticalPictureAdapter", 1, new Object[] { "photoInfo.heightWeightProportion:", Float.valueOf(localPicInfoItem.jdField_a_of_type_Float) });
    if (localPicInfoItem.jdField_a_of_type_Float != 0.0F) {
      localLayoutParams1.height = ((int)(ViewUtils.a() * localPicInfoItem.jdField_a_of_type_Float));
    }
    paramVerticalPictureHolder.a.setLayoutParams(localLayoutParams1);
    paramVerticalPictureHolder.a.setImageDrawable(null);
  }
  
  private void b(QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder paramVerticalPictureHolder, int paramInt)
  {
    Object localObject1 = (QzonePhotoPreviewActivity.PicInfoItem)getItem(paramInt);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((QzonePhotoPreviewActivity.PicInfoItem)localObject1).jdField_a_of_type_JavaLangString)))
    {
      Object localObject2 = new File(((QzonePhotoPreviewActivity.PicInfoItem)localObject1).jdField_a_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mRequestWidth = ViewUtils.a();
        localURLDrawableOptions2.mRequestHeight = ((int)(ViewUtils.a() * ((QzonePhotoPreviewActivity.PicInfoItem)localObject1).jdField_a_of_type_Float));
        localURLDrawableOptions2.mLoadingDrawable = URLDrawableHelperConstants.a;
        localObject1 = null;
        try
        {
          localObject2 = ((File)localObject2).toURI().toURL();
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
        if (localObject1 != null)
        {
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions2);
          if (localObject1 != null)
          {
            paramInt = ((URLDrawable)localObject1).getStatus();
            if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
              ((URLDrawable)localObject1).startDownload();
            }
          }
          if (localObject1 != null) {
            paramVerticalPictureHolder.a.setImageDrawable((Drawable)localObject1);
          }
        }
      }
      else
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions1.mRequestWidth = ViewUtils.a();
        localURLDrawableOptions1.mRequestHeight = ((int)(ViewUtils.a() * ((QzonePhotoPreviewActivity.PicInfoItem)localObject1).jdField_a_of_type_Float));
        localURLDrawableOptions1.mLoadingDrawable = URLDrawableHelperConstants.a;
        localObject1 = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(((QzonePhotoPreviewActivity.PicInfoItem)localObject1).jdField_a_of_type_JavaLangString), localURLDrawableOptions1);
        if (localObject1 == null) {
          QLog.w("PEAK", 2, "drawable == null");
        }
        paramVerticalPictureHolder.a.setImageDrawable((Drawable)localObject1);
      }
      return;
    }
    QZLog.e("VerticalPictureAdapter", "loadImageData: bigUrl is empty");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wywy getCount =");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size());
        QLog.d("VerticalPictureAdapter", 2, localStringBuilder.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size()) && (paramInt >= 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder localVerticalPictureHolder = new QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder(this, null);
    if (paramView == null)
    {
      localVerticalPictureHolder.a = new URLImageView2(paramViewGroup.getContext());
      localVerticalPictureHolder.a.setTag(localVerticalPictureHolder);
      paramView = localVerticalPictureHolder;
    }
    else
    {
      paramView = (QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder)paramView.getTag();
    }
    a(paramView, paramInt);
    b(paramView, paramInt);
    paramView = paramView.a;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.VerticalPictureAdapter
 * JD-Core Version:    0.7.0.1
 */