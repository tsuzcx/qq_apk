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
  
  public void OnDownload(String paramString1, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, String paramString2)
  {
    if ((this.a.get() != null) && (AlbumGalleryAdapterHolder.c((AlbumGalleryAdapterHolder)this.a.get()) == 2))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        if ((paramString2.contains("\"callBackType\":\"4\"")) && (AlbumGalleryAdapterHolder.d((AlbumGalleryAdapterHolder)this.a.get()) != -1))
        {
          int i = -2;
          SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 4");
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
          {
            AlbumGalleryAdapterHolder.e((AlbumGalleryAdapterHolder)this.a.get());
            i = -1;
          }
          AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), i);
          ((AlbumGalleryAdapterHolder)this.a.get()).a();
          return;
        }
        if ((paramString2.contains("\"callBackType\":\"7\"")) && (AlbumGalleryAdapterHolder.d((AlbumGalleryAdapterHolder)this.a.get()) != 0))
        {
          SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "OnDownload callBackType= 7");
          AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), 0);
          ((AlbumGalleryAdapterHolder)this.a.get()).a();
        }
      }
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore download result");
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if ((this.a.get() != null) && (AlbumGalleryAdapterHolder.c((AlbumGalleryAdapterHolder)this.a.get()) == 2))
    {
      if (paramInt == 5)
      {
        int i = -2;
        paramInt = i;
        if ((paramObject instanceof QQLiveDrawable.ErrorInfo))
        {
          paramString = (QQLiveDrawable.ErrorInfo)paramObject;
          paramInt = i;
          if (paramString.model == 122)
          {
            paramInt = i;
            if (paramString.what == 204) {
              paramInt = -1;
            }
          }
        }
        SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "onStateChange state=STATE_ERROR , set play state = %d", new Object[] { Integer.valueOf(paramInt) });
        AlbumGalleryAdapterHolder.e((AlbumGalleryAdapterHolder)this.a.get());
        AlbumGalleryAdapterHolder.a((AlbumGalleryAdapterHolder)this.a.get(), paramInt);
        ((AlbumGalleryAdapterHolder)this.a.get()).a();
      }
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "holder not play mp4 , ignore onStateChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.QQLiveListener
 * JD-Core Version:    0.7.0.1
 */