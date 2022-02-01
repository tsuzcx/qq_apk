package com.tencent.biz.pubaccount.Advertisement.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VideoCoverAdapter
  extends PagerAdapter
{
  private int a = 0;
  private ArrayList<VideoCoverItem> b;
  private Context c;
  private Handler d = new Handler(Looper.getMainLooper());
  private AdvertisementSplitedProgressBar e;
  private TVK_IMediaPlayer.OnCompletionListener f;
  private VideoCoverView g;
  private VideoCoverAdapter.MyNetInfoHandler h;
  private boolean i = false;
  private AdvertisementItem j;
  private TroopMemberApiClient k = null;
  
  public VideoCoverAdapter(Context paramContext, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, AdvertisementItem paramAdvertisementItem, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.c = paramContext;
    this.e = paramAdvertisementSplitedProgressBar;
    this.f = paramOnCompletionListener;
    if ((paramAdvertisementItem != null) && (paramAdvertisementItem.c != null)) {
      this.b = paramAdvertisementItem.c;
    } else {
      this.b = new ArrayList();
    }
    this.j = paramAdvertisementItem;
    this.h = new VideoCoverAdapter.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.h);
    this.k = TroopMemberApiClient.a();
    this.k.e();
  }
  
  private void f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = e();
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      FMToastUtil.a(HardCodeUtil.a(2131913332));
      if (!g()) {
        c();
      }
    }
  }
  
  private boolean g()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
    boolean bool = AdvertisementVideoPreloadManager.b(localVideoCoverView.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVideoCached vid:");
      localStringBuilder.append(localVideoCoverView.b.getVid());
      localStringBuilder.append(" cache:");
      localStringBuilder.append(bool);
      QLog.d("VideoCoverAdapter", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void a()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
    if (localVideoCoverView != null) {
      localVideoCoverView.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.a) && (paramInt < this.b.size()))
    {
      int m = (int)(((VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d).getPlayVideoProgress() / 1000L);
      Object localObject1 = ((VideoCoverItem)this.b.get(this.a)).c;
      if (m > 0)
      {
        Object localObject2 = (Integer)PublicAccountAdvertisementActivity.d.get(localObject1);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sum time is null,current time");
            ((StringBuilder)localObject2).append(m);
            QLog.d("VideoCoverAdapter", 2, ((StringBuilder)localObject2).toString());
          }
          PublicAccountAdvertisementActivity.d.put(localObject1, Integer.valueOf(m));
        }
        else
        {
          PublicAccountAdvertisementActivity.d.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + m));
        }
      }
      ((VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d).b();
      this.g = ((VideoCoverView)((VideoCoverItem)this.b.get(paramInt)).d);
      this.g.bringToFront();
      if (this.g.c)
      {
        boolean bool = AdvertisementVideoPreloadManager.b(this.g.b.getVid());
        if (NetUtil.a(null) == 1)
        {
          this.g.b(this.c);
        }
        else if ((NetUtil.a(null) == 0) && (bool))
        {
          this.g.b(this.c);
        }
        else if (VideoCoverFragment.b)
        {
          this.g.b(this.c);
        }
        else
        {
          localObject1 = this.g;
          ((VideoCoverView)localObject1).f = 6;
          ((VideoCoverView)localObject1).g();
        }
      }
      else
      {
        this.g.a(this.c);
      }
      this.a = paramInt;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b.size() > 0) {
        this.d.postDelayed(new VideoCoverAdapter.1(this), 500L);
      }
    }
    else
    {
      VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
      if (localVideoCoverView != null) {
        localVideoCoverView.d();
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)((Iterator)localObject).next();
      if (localVideoCoverItem.d != null)
      {
        ((VideoCoverView)localVideoCoverItem.d).f();
        localVideoCoverItem.d = null;
      }
    }
    this.b.clear();
    this.e = null;
    this.d.removeCallbacksAndMessages(null);
    this.d = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.h);
    localObject = this.k;
    if (localObject != null)
    {
      ((TroopMemberApiClient)localObject).f();
      this.k = null;
    }
  }
  
  public void c()
  {
    Object localObject;
    try
    {
      VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null) {
      localObject.c();
    }
  }
  
  public void d()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
    if (localVideoCoverView != null) {
      localVideoCoverView.a();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.b.size())
    {
      paramObject = (VideoCoverView)((VideoCoverItem)this.b.get(paramInt)).d;
      if (paramObject != null)
      {
        paramViewGroup.removeView(paramObject);
        paramObject.f();
        ((VideoCoverItem)this.b.get(paramInt)).d = null;
      }
    }
  }
  
  public TVK_IMediaPlayer e()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.b.get(this.a)).d;
    if (localVideoCoverView != null) {
      return localVideoCoverView.getVideoPlayer();
    }
    return null;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    VideoCoverView localVideoCoverView = new VideoCoverView(this.c, (VideoCoverItem)this.b.get(paramInt), getCount(), this.e, this.f, this.b, this.j, this.k);
    ((VideoCoverItem)this.b.get(paramInt)).d = localVideoCoverView;
    paramViewGroup.addView(localVideoCoverView);
    return localVideoCoverView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter
 * JD-Core Version:    0.7.0.1
 */