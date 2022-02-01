package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPicturePresenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PreviewPictureView
  extends BrowserBaseView
  implements IBrowserItemClickEvent
{
  private static Map<String, URLDrawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int = -1;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  protected PreviewPicturePresenter a;
  protected BrowserScaleView a;
  
  public PreviewPictureView(Context paramContext, PreviewPicturePresenter paramPreviewPicturePresenter)
  {
    super(paramContext, paramPreviewPicturePresenter);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter = paramPreviewPicturePresenter;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("(preview) Actives: ");
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(" ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  private void a(int paramInt, BrowserScaleView paramBrowserScaleView, URL paramURL)
  {
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null))
    {
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
        QLog.d("QQAlbum", 2, "use exist raw drawable");
      }
    }
    else
    {
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
        QLog.d("QQAlbum", 2, "rawDrawable is exist");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramURL.toString());
      ((StringBuilder)localObject).append("#NOSAMPLE");
      paramURL = ((StringBuilder)localObject).toString();
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
      paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject);
      paramURL.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create rawDrawable, position:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
      }
      if (paramURL.getStatus() == 1)
      {
        paramBrowserScaleView.ignoreLayout = true;
        paramBrowserScaleView.setImageDrawable(paramURL);
        paramBrowserScaleView.ignoreLayout = false;
      }
    }
  }
  
  public void bindView(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter.a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindView path is null, position :");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = new File(str);
    Object localObject1 = null;
    Object localObject3 = (URLDrawable)jdField_a_of_type_JavaUtilMap.get(str);
    Object localObject4 = new File(str);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter.getFileUrl((File)localObject4);
    if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1) && (((URLDrawable)localObject3).getURL().equals(localObject4)))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable((Drawable)localObject3);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable((Drawable)localObject3, this.mScreenWidthPx, this.mScreenHeightPx, 0);
    }
    else
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.mScreenWidthPx;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.mScreenHeightPx;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter.getFileUrl((File)localObject2);
      if (localObject2 != null)
      {
        localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          paramInt = ((URLDrawable)localObject2).getStatus();
          localObject1 = localObject2;
          if (paramInt != 1)
          {
            localObject1 = localObject2;
            if (paramInt != 2)
            {
              localObject1 = localObject2;
              if (paramInt != 3)
              {
                ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
                ((URLDrawable)localObject2).downloadImediatly();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable((Drawable)localObject1, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        jdField_a_of_type_JavaUtilMap.put(str, localObject1);
      }
    }
    this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setMainBrowserPresenter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter.mainBrowserPresenter);
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558601, paramViewGroup, false));
    this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = ((BrowserScaleView)this.mBrowserItemView.findViewById(2131372759));
    this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setOnItemEventListener(this);
    return this.mBrowserItemView;
  }
  
  public void onClickEvent()
  {
    PreviewPicturePresenter localPreviewPicturePresenter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter;
    if (localPreviewPicturePresenter != null) {
      localPreviewPicturePresenter.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    super.onDestroyView(paramInt, paramView);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onDestroyView:");
      paramView.append(a());
      QLog.d("QQAlbum", 2, paramView.toString());
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter;
    if (paramView != null)
    {
      paramView = paramView.a(paramInt);
      URLDrawable localURLDrawable = (URLDrawable)jdField_a_of_type_JavaUtilMap.get(paramView);
      if (localURLDrawable != null)
      {
        if (localURLDrawable.getStatus() == 0) {
          localURLDrawable.cancelDownload(true);
        }
        jdField_a_of_type_JavaUtilMap.remove(paramView);
      }
    }
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("(preview)destory rawDrawable, position: ");
        paramView.append(paramInt);
        QLog.d("QQAlbum", 2, paramView.toString());
      }
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
  }
  
  public void onLongClickEvent() {}
  
  public void onScaleBegin(int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getDrawable();
    Object localObject1 = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.mDecoding;
    if ((localObject2 instanceof URLDrawable))
    {
      localObject2 = (URLDrawable)localObject2;
      if ((((URLDrawable)localObject2).isFakeSize()) && (localObject1 == null))
      {
        localObject1 = ((URLDrawable)localObject2).getURL();
        if (("file".equals(((URL)localObject1).getProtocol())) && (((URL)localObject1).getRef() == null)) {
          a(paramInt, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView, (URL)localObject1);
        }
      }
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {
      return;
    }
    paramView = ((ImageView)paramView).getDrawable();
    if (!URLDrawable.class.isInstance(paramView)) {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.PreviewPictureView
 * JD-Core Version:    0.7.0.1
 */