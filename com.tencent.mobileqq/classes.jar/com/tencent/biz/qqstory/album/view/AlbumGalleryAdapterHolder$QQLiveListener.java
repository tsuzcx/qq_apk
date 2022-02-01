package com.tencent.biz.qqstory.album.view;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnDownloadListener;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

class AlbumGalleryAdapterHolder$QQLiveListener
  implements QQLiveDrawable.OnDownloadListener, QQLiveDrawable.OnStateListener
{
  WeakReference<AlbumGalleryAdapterHolder> a;
  
  public AlbumGalleryAdapterHolder$QQLiveListener(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder)
  {
    this.a = new WeakReference(paramAlbumGalleryAdapterHolder);
  }
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    int i = -1;
    if ((this.a.get() == null) || (AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get()) != 2)) {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore download result");
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramString2.contains("\"callBackType\":\"4\"")) && (AlbumGalleryAdapterHolder.b((AlbumGalleryAdapterHolder)this.a.get()) != -1))
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 4");
      if (NetworkUtil.d(BaseApplication.getContext())) {
        break label209;
      }
      AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get());
    }
    for (;;)
    {
      AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), i);
      ((AlbumGalleryAdapterHolder)this.a.get()).a();
      return;
      if ((!paramString2.contains("\"callBackType\":\"7\"")) || (AlbumGalleryAdapterHolder.b((AlbumGalleryAdapterHolder)this.a.get()) == 0)) {
        break;
      }
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 7");
      AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), 0);
      ((AlbumGalleryAdapterHolder)this.a.get()).a();
      return;
      label209:
      i = -2;
    }
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if ((this.a.get() == null) || (AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get()) != 2)) {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore onStateChange");
    }
    while (paramInt != 5) {
      return;
    }
    if ((paramObject instanceof QQLiveDrawable.ErrorInfo))
    {
      paramString = (QQLiveDrawable.ErrorInfo)paramObject;
      if ((paramString.model != 122) || (paramString.what != 204)) {}
    }
    for (paramInt = -1;; paramInt = -2)
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "onStateChange state=STATE_ERROR , set play state = %d", new Object[] { Integer.valueOf(paramInt) });
      AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get());
      AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), paramInt);
      ((AlbumGalleryAdapterHolder)this.a.get()).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.QQLiveListener
 * JD-Core Version:    0.7.0.1
 */