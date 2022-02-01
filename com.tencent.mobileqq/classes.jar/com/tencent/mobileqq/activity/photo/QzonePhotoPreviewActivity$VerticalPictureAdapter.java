package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
    if (localPicInfoItem.jdField_a_of_type_Float != 0.0F)
    {
      float f = ViewUtils.a();
      localLayoutParams1.height = ((int)(localPicInfoItem.jdField_a_of_type_Float * f));
    }
    paramVerticalPictureHolder.a.setLayoutParams(localLayoutParams1);
    paramVerticalPictureHolder.a.setImageDrawable(null);
  }
  
  private void b(QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder paramVerticalPictureHolder, int paramInt)
  {
    Object localObject = (QzonePhotoPreviewActivity.PicInfoItem)getItem(paramInt);
    if ((localObject == null) || (TextUtils.isEmpty(((QzonePhotoPreviewActivity.PicInfoItem)localObject).jdField_a_of_type_JavaLangString))) {
      QZLog.e("VerticalPictureAdapter", "loadImageData: bigUrl is empty");
    }
    for (;;)
    {
      return;
      File localFile = new File(((QzonePhotoPreviewActivity.PicInfoItem)localObject).jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = ViewUtils.a();
        float f = ViewUtils.a();
        localURLDrawableOptions.mRequestHeight = ((int)(((QzonePhotoPreviewActivity.PicInfoItem)localObject).jdField_a_of_type_Float * f));
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        try
        {
          localObject = localFile.toURI().toURL();
          if (localObject != null)
          {
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            if (localObject != null) {
              switch (((URLDrawable)localObject).getStatus())
              {
              default: 
                ((URLDrawable)localObject).startDownload();
              }
            }
            if (localObject != null)
            {
              paramVerticalPictureHolder.a.setImageDrawable((Drawable)localObject);
              return;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localMalformedURLException.printStackTrace();
            localURLDrawable = null;
          }
        }
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = ViewUtils.a();
    localURLDrawableOptions.mRequestHeight = ((int)(ViewUtils.a() * localURLDrawable.jdField_a_of_type_Float));
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(localURLDrawable.jdField_a_of_type_JavaLangString), localURLDrawableOptions);
    if (localURLDrawable == null) {
      QLog.w("PEAK", 2, "drawable == null");
    }
    paramVerticalPictureHolder.a.setImageDrawable(localURLDrawable);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalPictureAdapter", 2, "wywy getCount =" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size());
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
      localVerticalPictureHolder.a = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      localVerticalPictureHolder.a.setTag(localVerticalPictureHolder);
    }
    for (paramView = localVerticalPictureHolder;; paramView = (QzonePhotoPreviewActivity.VerticalPictureAdapter.VerticalPictureHolder)paramView.getTag())
    {
      a(paramView, paramInt);
      b(paramView, paramInt);
      paramView = paramView.a;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.VerticalPictureAdapter
 * JD-Core Version:    0.7.0.1
 */