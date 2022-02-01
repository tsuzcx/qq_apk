package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPhotoSelectedThumbAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  PhotoPreviewCustomizationDefault jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public NewPhotoSelectedThumbAdapter(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault = paramPhotoPreviewCustomizationDefault;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDrawable(2130848074);
    this.jdField_a_of_type_Int = Utils.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
    this.b = Utils.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
    this.c = Utils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
    this.d = Utils.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
    this.e = Utils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
    this.f = Utils.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoSelectedThumbAdapter", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(paramString);
    paramString = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramString = new LocalMediaInfo();
      paramString.mMediaType = 0;
    }
    return paramString;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewPhotoSelectedThumbAdapter.Holder localHolder;
    Object localObject1;
    if (paramView == null)
    {
      localHolder = new NewPhotoSelectedThumbAdapter.Holder(this);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localHolder.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localHolder.jdField_a_of_type_ComTencentImageURLImageView.setPadding(this.e, 0, 0, 0);
      paramView = (RelativeLayout)localObject1;
      paramView.addView(localHolder.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_Int, this.b);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(this.e, 0, 0, 0);
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841554);
      paramView.addView(localHolder.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int, this.b);
      localHolder.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localHolder.b.setImageResource(2130839350);
      localHolder.b.setPadding(this.e, 0, 0, this.f);
      localObject2 = new RelativeLayout.LayoutParams(this.c, this.d);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      localHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localHolder.b.setVisibility(4);
      paramView.addView(localHolder.b);
      ((View)localObject1).setTag(localHolder);
    }
    else
    {
      localHolder = (NewPhotoSelectedThumbAdapter.Holder)paramView.getTag();
      localObject1 = paramView;
    }
    paramView = (String)getItem(paramInt);
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = "";
    }
    LocalMediaInfo localLocalMediaInfo = a((String)localObject2);
    localLocalMediaInfo.path = ((String)localObject2);
    int i = this.b;
    localLocalMediaInfo.thumbWidth = i;
    localLocalMediaInfo.thumbHeight = i;
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.a().getItem(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.a().a());
    Object localObject4 = null;
    if ((paramView != null) && (paramView.baseData != null)) {
      paramView = paramView.baseData.filePath;
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      localObject3 = localHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramView.equals(localObject2)) {
        i = 0;
      } else {
        i = 4;
      }
      ((ImageView)localObject3).setVisibility(i);
    }
    else
    {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a((String)localObject2);
    i = 1;
    if (j == 1)
    {
      if (localLocalMediaInfo.isSystemMeidaStore) {
        paramView = a(localLocalMediaInfo, "VIDEO");
      } else {
        paramView = a(localLocalMediaInfo, "APP_VIDEO");
      }
    }
    else if (new File((String)localObject2).exists())
    {
      paramView = a(localLocalMediaInfo, "DEFAULT");
    }
    else
    {
      if (QAlbumUtil.isNetUrl((String)localObject2))
      {
        localObject3 = null;
        break label531;
      }
      paramView = null;
    }
    i = 0;
    Object localObject3 = paramView;
    label531:
    if ((localObject3 != null) || (i != 0))
    {
      URLDrawable localURLDrawable = localHolder.jdField_a_of_type_ComTencentImageURLDrawable;
      if (i != 0)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        i = this.b;
        paramView.mRequestWidth = i;
        paramView.mRequestHeight = i;
        paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl((String)localObject2), paramView);
      }
      else if (localURLDrawable != null)
      {
        paramView = localObject4;
        if (localURLDrawable.getURL().toString().equals(((URL)localObject3).toString())) {}
      }
      else
      {
        paramView = QQAlbumUtils.a((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (paramView != null)
      {
        paramView.setTag(localLocalMediaInfo);
        localHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
        localHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f.containsValue(localObject2)) {
        localHolder.b.setVisibility(0);
      } else {
        localHolder.b.setVisibility(4);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.jdField_a_of_type_JavaUtilArrayList.indexOf(str);
    if (i >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.browserModel.setSelectedIndex(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a.scrollToCurrentPosition();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewCustomizationDefault.a(i);
      notifyDataSetChanged();
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoSelectedThumbAdapter
 * JD-Core Version:    0.7.0.1
 */