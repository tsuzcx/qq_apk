package com.tencent.mobileqq.activity.photo.album.preview;

import akqw;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import bljm;
import bljo;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class BasePreviewAdapter
  extends BaseAdapter
  implements akqw, bljm, bljo
{
  public static final String TAG = "BasePreviewAdapter";
  BasePreviewPresent mCurrentPreviewPresent;
  ArrayList<String> mPaths;
  protected PhotoPreviewBaseData mPhotoPreviewData;
  PhotoPreviewLogicBase mPhotoPreviewLogic;
  URLDrawable mRawDrawable;
  int mRawDrawablePosition = -1;
  
  public BasePreviewAdapter(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    this.mPhotoPreviewLogic = paramPhotoPreviewLogicBase;
    this.mPhotoPreviewData = paramPhotoPreviewLogicBase.getPhotoPreviewData();
    this.mPaths = this.mPhotoPreviewData.paths;
  }
  
  private BasePreviewPresent generatePreviewPresent(String paramString)
  {
    PreviewBean localPreviewBean = new PreviewBean();
    AbstractPhotoPreviewActivity localAbstractPhotoPreviewActivity = this.mPhotoPreviewLogic.mActivity;
    localPreviewBean.setMediaType(getMediaType(paramString));
    localPreviewBean.setPath(paramString);
    localPreviewBean.setMediaInfo(localAbstractPhotoPreviewActivity.getMediaInfo(paramString));
    return generatePreviewPresent(localPreviewBean);
  }
  
  private int getMediaType(String paramString)
  {
    return this.mPhotoPreviewLogic.mActivity.getMediaType(paramString);
  }
  
  private BasePreviewPresent getPresent(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof BasePreviewPresent))) {
        return (BasePreviewPresent)paramView;
      }
    }
    return null;
  }
  
  protected BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()))
    {
      if (paramPreviewBean.mMediaType == 1) {
        return new VideoPreviewPresent(paramPreviewBean);
      }
      return new PicPreviewPresent(paramPreviewBean);
    }
    return new BasePreviewPresent(paramPreviewBean);
  }
  
  public int getCount()
  {
    if (this.mPaths != null) {
      return this.mPaths.size();
    }
    return 0;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.mPaths != null) && (paramInt < this.mPaths.size()) && (paramInt >= 0)) {
      return (String)this.mPaths.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView != null) {
      localView = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      BasePreviewPresent localBasePreviewPresent = generatePreviewPresent(getItem(paramInt));
      localView = localBasePreviewPresent.getView(paramInt, paramView, paramViewGroup);
      localView.setTag(localBasePreviewPresent);
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    generatePreviewPresent(getItem(paramInt)).onCreateView(paramInt, paramView, paramViewGroup);
    return null;
  }
  
  public void onDestroy()
  {
    if (this.mCurrentPreviewPresent != null) {
      this.mCurrentPreviewPresent.onDestroy();
    }
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getPresent(paramView);
    if (paramView != null) {
      paramView.onDestroyView();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    if (this.mCurrentPreviewPresent != null)
    {
      String str = this.mCurrentPreviewPresent.mBean.getPath();
      i = this.mCurrentPreviewPresent.mBean.getMediaType();
      this.mCurrentPreviewPresent.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      paramAdapterView = str;
    }
    for (;;)
    {
      this.mPhotoPreviewLogic.onGalleryItemClicked(i, paramAdapterView, paramInt);
      return;
      paramView = getItem(paramInt);
      int j = getMediaType(paramView);
      i = j;
      paramAdapterView = paramView;
      if (QLog.isColorLevel())
      {
        QLog.e("BasePreviewAdapter", 2, "onItemSelected error:" + paramInt + " path:" + paramView + " mediaType:" + j);
        i = j;
        paramAdapterView = paramView;
      }
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BasePreviewPresent localBasePreviewPresent = getPresent(paramView);
    if (localBasePreviewPresent != null)
    {
      localBasePreviewPresent.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      this.mCurrentPreviewPresent = localBasePreviewPresent;
    }
    for (;;)
    {
      this.mPhotoPreviewLogic.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("BasePreviewAdapter", 2, "onItemSelected error:" + paramInt);
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    if (this.mCurrentPreviewPresent != null) {
      this.mCurrentPreviewPresent.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.mCurrentPreviewPresent != null) {
      this.mCurrentPreviewPresent.onResume();
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
        QLog.d("BasePreviewAdapter", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
    paramView = getPresent(paramView);
    if (paramView != null) {
      paramView.onViewDetached();
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
      if (QLog.isColorLevel()) {
        QLog.d("BasePreviewAdapter", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
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
    QLog.d("BasePreviewAdapter", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
      QLog.d("BasePreviewAdapter", 2, "rawDrawable is exist");
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
      QLog.d("BasePreviewAdapter", 2, "create rawDrawable, position:" + paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter
 * JD-Core Version:    0.7.0.1
 */