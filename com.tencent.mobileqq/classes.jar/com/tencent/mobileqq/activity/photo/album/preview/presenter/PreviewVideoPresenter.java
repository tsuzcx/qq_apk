package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class PreviewVideoPresenter
  extends BasePreviewPresent
{
  private PreviewVideoView jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewVideoView;
  private HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public Drawable a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (localHashMap != null) {
        return (Drawable)localHashMap.get(paramString);
      }
    }
    return null;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof PreviewVideoData))) {
      return ((PreviewVideoData)localRichMediaBrowserInfo.baseData).a;
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof PreviewVideoData))) {
      return ((PreviewVideoData)localRichMediaBrowserInfo.baseData).filePath;
    }
    return null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramDrawable == null) {
        return;
      }
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (localHashMap != null) {
        localHashMap.put(paramString, paramDrawable);
      }
    }
  }
  
  public URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return QAlbumUtil.generateAlbumVideoThumbURL(paramFile.getPath(), "VIDEO");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewVideoView;
    if (localObject != null) {
      ((PreviewVideoView)localObject).onDestroy();
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    PreviewVideoView localPreviewVideoView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewVideoView;
    if (localPreviewVideoView != null) {
      localPreviewVideoView.a();
    }
  }
  
  public void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.setBrowserView(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof PreviewVideoView)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewVideoView = ((PreviewVideoView)paramIBaseViewBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewVideoPresenter
 * JD-Core Version:    0.7.0.1
 */