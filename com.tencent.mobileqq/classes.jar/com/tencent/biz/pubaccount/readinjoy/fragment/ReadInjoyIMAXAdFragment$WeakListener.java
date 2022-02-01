package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import java.lang.ref.WeakReference;

class ReadInjoyIMAXAdFragment$WeakListener
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, IVideoViewBase.IVideoViewCallBack
{
  private WeakReference<ReadInjoyIMAXAdFragment> a;
  
  public ReadInjoyIMAXAdFragment$WeakListener(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment)
  {
    this.a = new WeakReference(paramReadInjoyIMAXAdFragment);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = (ReadInjoyIMAXAdFragment)this.a.get();
    if (paramTVK_IMediaPlayer == null) {
      return;
    }
    ReadInjoyIMAXAdFragment.e(paramTVK_IMediaPlayer, 9);
    ReadInjoyIMAXAdFragment.i = true;
    paramTVK_IMediaPlayer.j();
    ReadInjoyIMAXAdFragment.u(paramTVK_IMediaPlayer);
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = (ReadInjoyIMAXAdFragment)this.a.get();
    if (paramTVK_IMediaPlayer == null) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("error msg = ");
      paramObject.append(paramString);
      QLog.d("ReadInjoyIMAXAdFragment", 2, paramObject.toString());
    }
    ReadInjoyIMAXAdFragment.e(paramTVK_IMediaPlayer, 8);
    paramTVK_IMediaPlayer.j();
    if (QLog.isColorLevel()) {
      QLog.i("ReadInjoyIMAXAdFragment", 2, "ReadInjoyIMAXAdFragment start video error");
    }
    return false;
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = (ReadInjoyIMAXAdFragment)this.a.get();
    if (paramSurfaceHolder == null) {
      return;
    }
    paramSurfaceHolder.c();
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = (ReadInjoyIMAXAdFragment)this.a.get();
    if (paramTVK_IMediaPlayer == null) {
      return;
    }
    if ((Looper.myLooper() != Looper.getMainLooper()) && (ReadInjoyIMAXAdFragment.s(paramTVK_IMediaPlayer) != null))
    {
      ReadInjoyIMAXAdFragment.s(paramTVK_IMediaPlayer).post(new ReadInjoyIMAXAdFragment.WeakReferenceRunnable(paramTVK_IMediaPlayer, 2));
      return;
    }
    ReadInjoyIMAXAdFragment.t(paramTVK_IMediaPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.WeakListener
 * JD-Core Version:    0.7.0.1
 */