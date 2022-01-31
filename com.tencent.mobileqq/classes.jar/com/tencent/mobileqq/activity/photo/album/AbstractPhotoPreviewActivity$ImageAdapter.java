package com.tencent.mobileqq.activity.photo.album;

import aior;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import bayu;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class AbstractPhotoPreviewActivity$ImageAdapter
  extends BaseAdapter
  implements aior
{
  Bitmap mBitmap;
  URLDrawable mRawDrawable;
  int mRawDrawablePosition = -1;
  
  public AbstractPhotoPreviewActivity$ImageAdapter(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity) {}
  
  public int getCount()
  {
    if (this.this$0.mPhotoPreviewData.paths != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "wywy getCount =" + this.this$0.mPhotoPreviewData.paths.size());
      }
      return this.this$0.mPhotoPreviewData.paths.size();
    }
    return 0;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.this$0.mPhotoPreviewData.paths != null) && (paramInt < this.this$0.mPhotoPreviewData.paths.size()) && (paramInt >= 0)) {
      return (String)this.this$0.mPhotoPreviewData.paths.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (this.this$0.mPhotoPreviewLogic.mImageAdapterCallback != null) {
      localView = this.this$0.mPhotoPreviewLogic.mImageAdapterCallback.getView(paramInt, paramView, paramViewGroup);
    }
    return localView;
  }
  
  String listActiviteDrawables()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
    int i = 0;
    while (i < this.this$0.mPhotoPreviewData.activeDrawable.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.this$0.mPhotoPreviewData.activeDrawable.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.this$0.mPhotoPreviewData.activeDrawable.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
      }
      do
      {
        do
        {
          return null;
        } while (this.this$0.getMediaType(getItem(paramInt)) == 1);
        paramView = getItem(paramInt);
        if (!TextUtils.isEmpty(paramView)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PhotoPreviewActivity", 2, "Path is empty. position " + paramInt + ", size " + getCount());
      return null;
      File localFile = new File(paramView);
      if (localFile.exists())
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = paramViewGroup.getWidth();
        paramView.mRequestHeight = paramViewGroup.getHeight();
        paramView.mLoadingDrawable = bayu.a;
        paramView.mPlayGifImage = true;
        paramViewGroup = this.this$0.getFileUrl(localFile);
        if (paramViewGroup != null)
        {
          paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
          this.this$0.mPhotoPreviewData.activeDrawable.put(paramInt, paramView);
        }
      }
    }
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.this$0.mPhotoPreviewData.activeDrawable.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.this$0.mPhotoPreviewData.activeDrawable.remove(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = (AbstractImageAdapter.URLImageView2)paramView;
          paramViewGroup = paramView.getDrawable();
          localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
        } while ((!(paramViewGroup instanceof URLDrawable)) || (!((URLDrawable)paramViewGroup).isFakeSize()) || (localObject != null));
        paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
      } while ((!"file".equals(paramViewGroup.getProtocol())) || (paramViewGroup.getRef() != null));
      if ((paramInt != this.mRawDrawablePosition) || (this.mRawDrawable == null)) {
        break;
      }
      paramView = this.mRawDrawable;
    } while ((!QLog.isColorLevel()) || (this.mRawDrawable == null));
    QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
      QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.mRawDrawable = null;
    this.mRawDrawablePosition = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "create rawDrawable, position:" + paramInt);
    }
    if (paramViewGroup.getStatus() == 1)
    {
      paramView.jdField_a_of_type_Boolean = true;
      paramView.setImageDrawable(paramViewGroup);
      paramView.jdField_a_of_type_Boolean = false;
      return;
    }
    paramView.setDecodingDrawble(paramViewGroup);
    paramViewGroup.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity.ImageAdapter
 * JD-Core Version:    0.7.0.1
 */