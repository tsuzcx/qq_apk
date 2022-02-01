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
  public PreviewScene a;
  public PreviewModel b;
  public PhotoCommonBaseData<O> c;
  public PhotoPreviewBaseData d;
  public IPresenterCallBack e;
  
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
      HashMap localHashMap = this.c.allMediaInfoHashMap;
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
  
  private void b()
  {
    Iterator localIterator = this.d.y.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!this.d.F) || (!QAlbumUtil.isNetUrl(str))) {
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
  
  private void b(Intent paramIntent)
  {
    this.d.y = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (this.d.y == null)
    {
      this.d.y = new ArrayList();
      this.d.y.addAll(this.c.selectedPhotoList);
    }
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if ((paramIntent != null) && (!paramIntent.equals("")))
    {
      this.d.y.clear();
      this.d.y.add(paramIntent);
    }
    b();
    if (this.c.selectedPhotoList == null) {
      this.c.selectedPhotoList = new ArrayList();
    } else {
      this.c.selectedPhotoList.clear();
    }
    this.c.selectedPhotoList.addAll(this.d.y);
    this.c.selectedIndex.clear();
    if (!this.c.isSingleMode)
    {
      int i = 0;
      while (i < this.d.y.size())
      {
        this.c.selectedIndex.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    this.d.y = new ArrayList();
    this.d.y.addAll(this.c.mediaPathsList);
    if (this.d.y.isEmpty()) {
      this.d.y = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    }
    if (this.d.y == null) {
      this.d.y = new ArrayList();
    }
    this.c.selectedPhotoList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    paramIntent = paramIntent.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
    if ((paramIntent != null) && (!paramIntent.isEmpty())) {
      this.c.selectedIndex = paramIntent;
    }
    if ((this.c.selectedIndex == null) || (this.d.y == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAlbum", 2, "initData(): Error! selectedItem or sSelectedIndex is null");
      }
      this.a.a.finish();
    }
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
    Iterator localIterator = this.d.y.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = b(str);
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
          ((PreviewVideoData)localObject).a = c(str);
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
    com.tencent.mobileqq.activity.photo.FlowThumbDecoder.sFlowItemHeight = this.a.a.getResources().getDimension(2131297483);
    this.d.A = paramIntent.getStringExtra("FROM_WHERE");
    paramIntent.removeExtra("FROM_WHERE");
    this.c.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    if (this.c.selectedMediaInfoHashMap == null) {
      this.c.selectedMediaInfoHashMap = new HashMap();
    }
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if ((localObject != null) && (!((HashMap)localObject).isEmpty())) {
      this.c.selectedMediaInfoHashMap.putAll((Map)localObject);
    }
    localObject = (HashMap)paramIntent.getSerializableExtra("PhotoConst.ALL_MEDIA_PATHS");
    if (localObject != null) {
      this.c.allMediaInfoHashMap = ((HashMap)localObject);
    }
    this.c.maxSelectNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    this.d.B = paramIntent.getBooleanExtra("PhotoConst.SHOW_ALBUM", false);
    if (this.d.B) {
      c(paramIntent);
    } else {
      b(paramIntent);
    }
    localObject = this.d;
    ((PhotoPreviewBaseData)localObject).D = ((PhotoPreviewBaseData)localObject).y.size();
    this.d.G = this.a.a.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    if (this.d.G >= this.d.D) {
      this.d.G = -1;
    }
    paramIntent.removeExtra("PhotoConst.CURRENT_SELECTED_INDEX");
    this.c.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
    if (this.c.filter == null) {
      this.c.filter = MediaFileFilter.MEDIA_FILTER_DEFAULT;
    }
    notifyImageListChanged(a(), this.d.G);
  }
  
  public void a(PhotoPreviewCustomization paramPhotoPreviewCustomization)
  {
    this.e = paramPhotoPreviewCustomization;
    this.c = paramPhotoPreviewCustomization.f;
    this.d = paramPhotoPreviewCustomization.h;
  }
  
  public void a(PreviewModel paramPreviewModel)
  {
    super.setBrowserModel(paramPreviewModel);
    this.b = paramPreviewModel;
  }
  
  public void a(PreviewScene paramPreviewScene)
  {
    super.setBrowserScene(paramPreviewScene);
    this.a = paramPreviewScene;
  }
  
  public int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (c(paramString) == null) {
      return QAlbumUtil.getMediaType(paramString);
    }
    return QAlbumUtil.getMediaType(c(paramString));
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.e.a(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("PhotoPreviewCustomization PhotoCommonData = ");
      paramIntent.append(this.c);
      QLog.d("QQAlbum", 2, paramIntent.toString());
    }
  }
  
  public LocalMediaInfo c(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if (this.c.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.c.selectedMediaInfoHashMap.get(paramString);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (this.c.allMediaInfoHashMap != null) {
        localLocalMediaInfo2 = (LocalMediaInfo)this.c.allMediaInfoHashMap.get(paramString);
      }
    }
    a(paramString, localLocalMediaInfo2);
    return localLocalMediaInfo2;
  }
  
  public void c()
  {
    Object localObject1 = getCurrentPresenter();
    if ((localObject1 instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject1).onDestroy();
    }
    try
    {
      localObject1 = this.c.selectedPhotoList.iterator();
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
    this.c.releaseCommonData();
  }
  
  public void e(int paramInt)
  {
    if ((paramInt == 100) || (paramInt == 102))
    {
      if (this.d.x)
      {
        this.a.b.o();
        return;
      }
      this.a.b.p();
    }
  }
  
  public void n()
  {
    IBasePresenterBuilder localIBasePresenterBuilder = getCurrentPresenter();
    if ((localIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localIBasePresenterBuilder).onResume();
    }
    if ((this.d.x) && (this.a.d != null)) {
      this.a.d.setVisibility(0);
    }
  }
  
  public void u()
  {
    IBasePresenterBuilder localIBasePresenterBuilder = getCurrentPresenter();
    if ((localIBasePresenterBuilder instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localIBasePresenterBuilder).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter
 * JD-Core Version:    0.7.0.1
 */