package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomization;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewModel;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.model.WebPreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.view.ISceneCallback;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PreviewPresenter<O extends OtherCommonData>
  extends MainBrowserPresenter
  implements IPresenterCallBack
{
  public PhotoCommonBaseData<O> a;
  public PhotoPreviewBaseData a;
  public PreviewModel a;
  public IPresenterCallBack a;
  public PreviewScene a;
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.o) || (!QAlbumUtil.isNetUrl(str))) {
        if (str != null)
        {
          if (!new File(str).exists()) {
            localIterator.remove();
          }
        }
        else {
          localIterator.remove();
        }
      }
    }
  }
  
  private void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo != null) && ((paramLocalMediaInfo.mediaWidth == 0) || (paramLocalMediaInfo.mediaHeight == 0)))
    {
      Object localObject = new MediaMetadataUtils.MetaData();
      MediaMetadataUtils.a(paramString, (MediaMetadataUtils.MetaData)localObject);
      paramLocalMediaInfo.mediaWidth = localObject.a[0];
      paramLocalMediaInfo.mediaHeight = localObject.a[1];
      paramLocalMediaInfo.rotation = localObject.a[2];
      localObject = null;
      HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap;
      if (localHashMap != null) {
        localObject = (LocalMediaInfo)localHashMap.get(paramString);
      }
      if ((localObject != null) && ((((LocalMediaInfo)localObject).mediaWidth == 0) || (((LocalMediaInfo)localObject).mediaHeight == 0)))
      {
        ((LocalMediaInfo)localObject).mediaWidth = paramLocalMediaInfo.mediaWidth;
        ((LocalMediaInfo)localObject).mediaHeight = paramLocalMediaInfo.mediaHeight;
        ((LocalMediaInfo)localObject).rotation = paramLocalMediaInfo.rotation;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    }
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if ((paramIntent != null) && (!paramIntent.equals("")))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.add(paramIntent);
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mediaPathsList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    if ((paramIntent != null) && (!paramIntent.isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = paramIntent;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.finish();
    }
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (a(paramString) == null) {
      return QAlbumUtil.getMediaType(paramString);
    }
    return QAlbumUtil.getMediaType(a(paramString));
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
        localLocalMediaInfo2 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
      }
    }
    a(paramString, localLocalMediaInfo2);
    return localLocalMediaInfo2;
  }
  
  RichMediaBrowserInfo a(String paramString)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = new RichMediaBrowserInfo();
    PreviewPictureData localPreviewPictureData = new PreviewPictureData();
    localPreviewPictureData.filePath = paramString;
    localRichMediaBrowserInfo.baseData = localPreviewPictureData;
    return localRichMediaBrowserInfo;
  }
  
  public List<RichMediaBrowserInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = a(str);
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      if (i != 0)
      {
        Object localObject;
        if (i != 1)
        {
          if (QAlbumUtil.isNetUrl(str))
          {
            localRichMediaBrowserInfo = new RichMediaBrowserInfo();
            localObject = new WebPreviewPictureData();
            ((WebPreviewPictureData)localObject).filePath = str;
            localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)localObject);
          }
          else
          {
            localRichMediaBrowserInfo = a(str);
          }
        }
        else
        {
          localRichMediaBrowserInfo = new RichMediaBrowserInfo();
          localObject = new PreviewVideoData();
          ((PreviewVideoData)localObject).filePath = str;
          ((PreviewVideoData)localObject).a = a(str);
          localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)localObject);
        }
      }
      else
      {
        localRichMediaBrowserInfo = a(str);
      }
      if (localRichMediaBrowserInfo != null) {
        localArrayList.add(localRichMediaBrowserInfo);
      }
    }
    return localArrayList;
  }
  
  public void a(Intent paramIntent)
  {
    com.tencent.mobileqq.activity.photo.FlowThumbDecoder.sFlowItemHeight = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources().getDimension(2131297102);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("FROM_WHERE");
    paramIntent.removeExtra("FROM_WHERE");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap = ((HashMap)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.n = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.n) {
      c(paramIntent);
    } else {
      b(paramIntent);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData;
    ((PhotoPreviewBaseData)localObject).jdField_d_of_type_Int = ((PhotoPreviewBaseData)localObject).a.size();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.jdField_d_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f = -1;
    }
    paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.MEDIA_FILTER_DEFAULT;
    }
    notifyImageListChanged(a(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.f);
  }
  
  public void a(PhotoPreviewCustomization paramPhotoPreviewCustomization)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterIPresenterCallBack = paramPhotoPreviewCustomization;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = paramPhotoPreviewCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData = paramPhotoPreviewCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData;
  }
  
  public void a(PreviewModel paramPreviewModel)
  {
    super.setBrowserModel(paramPreviewModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewModelPreviewModel = paramPreviewModel;
  }
  
  public void a(PreviewScene paramPreviewScene)
  {
    super.setBrowserScene(paramPreviewScene);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene = paramPreviewScene;
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterIPresenterCallBack.a(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("PhotoPreviewCustomization PhotoCommonData = ");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, paramIntent.toString());
    }
  }
  
  public void c()
  {
    Object localObject1 = getCurrentPresenter();
    if ((localObject1 instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject1).onDestroy();
    }
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = new File((String)localObject2);
          URLDrawable.removeMemoryCacheByUrl(((File)localObject2).toURL().toString());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject2).toURL().toString());
          localStringBuilder.append("#NOSAMPLE");
          URLDrawable.removeMemoryCacheByUrl(localStringBuilder.toString());
        }
      }
    }
    catch (Exception localException)
    {
      label110:
      break label110;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PhotoPreviewActivity", 2, "remove file error");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public void e(int paramInt)
  {
    if ((paramInt == 100) || (paramInt == 102))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.j();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewISceneCallback.k();
    }
  }
  
  public void i()
  {
    IBasePresenterBuilder localIBasePresenterBuilder = getCurrentPresenter();
    if ((localIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localIBasePresenterBuilder).onResume();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData.m) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewViewPreviewScene.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void l()
  {
    IBasePresenterBuilder localIBasePresenterBuilder = getCurrentPresenter();
    if ((localIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localIBasePresenterBuilder).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter
 * JD-Core Version:    0.7.0.1
 */