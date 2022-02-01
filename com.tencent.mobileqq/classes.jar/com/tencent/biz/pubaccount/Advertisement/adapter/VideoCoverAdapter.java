package com.tencent.biz.pubaccount.Advertisement.adapter;

import aasb;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import auna;
import bjjh;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import nwe;
import nwf;
import nwg;
import nws;

public class VideoCoverAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private aasb jdField_a_of_type_Aasb;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private VideoCoverView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
  private TVK_IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener;
  private ArrayList<nwg> jdField_a_of_type_JavaUtilArrayList;
  private nwe jdField_a_of_type_Nwe;
  private nwf jdField_a_of_type_Nwf;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoCoverAdapter(Context paramContext, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, nwf paramnwf, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = paramOnCompletionListener;
    if ((paramnwf != null) && (paramnwf.jdField_a_of_type_JavaUtilArrayList != null)) {}
    for (this.jdField_a_of_type_JavaUtilArrayList = paramnwf.jdField_a_of_type_JavaUtilArrayList;; this.jdField_a_of_type_JavaUtilArrayList = new ArrayList())
    {
      this.jdField_a_of_type_Nwf = paramnwf;
      this.jdField_a_of_type_Nwe = new nwe(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_Nwe);
      this.jdField_a_of_type_Aasb = aasb.a();
      this.jdField_a_of_type_Aasb.a();
      return;
    }
  }
  
  private boolean a()
  {
    VideoCoverView localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    boolean bool = nws.a(localVideoCoverView.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "isVideoCached vid:" + localVideoCoverView.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.getVid() + " cache:" + bool);
    }
    return bool;
  }
  
  private void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = a();
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      auna.a(anzj.a(2131714904));
      if (!a()) {
        c();
      }
    }
  }
  
  public TVK_IMediaPlayer a()
  {
    VideoCoverView localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    if (localVideoCoverView != null) {
      return localVideoCoverView.a();
    }
    return null;
  }
  
  public void a()
  {
    VideoCoverView localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    if (localVideoCoverView != null) {
      localVideoCoverView.c();
    }
  }
  
  public void a(int paramInt)
  {
    int i;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((paramInt != this.jdField_a_of_type_Int) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      i = (int)(((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.a() / 1000L);
      localObject1 = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b;
      if (i > 0)
      {
        localObject2 = (Integer)PublicAccountAdvertisementActivity.a.get(localObject1);
        if (localObject2 != null) {
          break label224;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverAdapter", 2, "sum time is null,current time" + i);
        }
        PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(i));
      }
      ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.bringToFront();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_Boolean) {
        break label320;
      }
      bool = nws.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.getVid());
      if (bjjh.a(null) != 1) {
        break label246;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
    }
    label320:
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      label224:
      PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + i));
      break;
      label246:
      if ((bjjh.a(null) == 0) && (bool))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
      }
      else if (VideoCoverFragment.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
        ((VideoCoverView)localObject1).jdField_a_of_type_Int = 6;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.g();
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoCoverAdapter.1(this), 500L);
      }
    }
    VideoCoverView localVideoCoverView;
    do
    {
      return;
      localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    } while (localVideoCoverView == null);
    localVideoCoverView.d();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nwg localnwg = (nwg)localIterator.next();
      if (localnwg.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView != null)
      {
        localnwg.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.f();
        localnwg.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = null;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Nwe);
    if (this.jdField_a_of_type_Aasb != null)
    {
      this.jdField_a_of_type_Aasb.b();
      this.jdField_a_of_type_Aasb = null;
    }
  }
  
  public void c()
  {
    try
    {
      VideoCoverView localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
      if (localVideoCoverView != null) {
        localVideoCoverView.c();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void d()
  {
    VideoCoverView localVideoCoverView = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    if (localVideoCoverView != null) {
      localVideoCoverView.a();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramObject = ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
      if (paramObject != null)
      {
        paramViewGroup.removeView(paramObject);
        paramObject.f();
        ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = null;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    VideoCoverView localVideoCoverView = new VideoCoverView(this.jdField_a_of_type_AndroidContentContext, (nwg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), getCount(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Nwf, this.jdField_a_of_type_Aasb);
    ((nwg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = localVideoCoverView;
    paramViewGroup.addView(localVideoCoverView);
    return localVideoCoverView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter
 * JD-Core Version:    0.7.0.1
 */