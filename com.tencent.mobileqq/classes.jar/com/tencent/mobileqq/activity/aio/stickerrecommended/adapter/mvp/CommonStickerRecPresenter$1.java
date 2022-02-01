package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import org.apache.http.Header;

class CommonStickerRecPresenter$1
  implements URLDrawableDownListener
{
  CommonStickerRecPresenter$1(CommonStickerRecPresenter paramCommonStickerRecPresenter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonStickerRec", 2, "drawableListener onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    CommonStickerRecPresenter.a(this.a, paramURLDrawable);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("drawableListener onLoadFialed:");
      paramView.append(paramURLDrawable.getURL());
      QLog.e("CommonStickerRec", 2, paramView.toString(), paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonStickerRec", 2, "drawableListener onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    long l2 = -1L;
    try
    {
      Object localObject = paramURLDrawable.getHeader("report_key_start_download");
      l1 = l2;
      if (localObject == null) {
        break label77;
      }
      localObject = ((Header)localObject).getValue();
      l1 = l2;
      if (localObject == null) {
        break label77;
      }
      l1 = Long.parseLong((String)localObject);
      long l3 = System.currentTimeMillis();
      l1 = l3 - l1;
    }
    catch (Exception localException)
    {
      long l1;
      label57:
      break label57;
    }
    l1 = l2;
    if (QLog.isColorLevel())
    {
      QLog.e("CommonStickerRec", 2, "onLoadSuccessed:get start download time");
      l1 = l2;
    }
    label77:
    CommonStickerRecPresenter.a(this.a, paramURLDrawable, l1);
    paramView = paramView.getTag();
    if (StickerRecManagerImpl.isStickerRecFromRemote((IStickerRecEmoticon)paramView))
    {
      paramView = (StickerRecData)paramView;
      if ((StickerRecManagerImpl.isStickerRecFromRemote(paramView)) && (!CommonStickerRecPresenter.a().contains(paramView.k())))
      {
        CommonStickerRecPresenter.a().add(paramView.k());
        paramURLDrawable = paramView.m();
        CommonStickerRecPresenter.b().add(new StickerRecCacheEntity(paramURLDrawable, System.currentTimeMillis(), paramView.k()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.CommonStickerRecPresenter.1
 * JD-Core Version:    0.7.0.1
 */