package com.tencent.biz.pubaccount.Advertisement.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.biz.troop.TroopMemberApiClient;
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
import kuf;
import kug;

public class VideoCoverAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private VideoCoverView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private TVK_IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private kug jdField_a_of_type_Kug;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoCoverAdapter(Context paramContext, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, AdvertisementItem paramAdvertisementItem, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = paramOnCompletionListener;
    if ((paramAdvertisementItem != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null)) {}
    for (this.jdField_a_of_type_JavaUtilArrayList = paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList;; this.jdField_a_of_type_JavaUtilArrayList = new ArrayList())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
      this.jdField_a_of_type_Kug = new kug(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_Kug);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      return;
    }
  }
  
  private boolean a()
  {
    VideoCoverView localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    boolean bool = AdvertisementVideoPreloadManager.a(localVideoCoverView.jdField_a_of_type_JavaLangString);
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
      FMToastUtil.a("当前网络不可用");
      if (!a()) {
        c();
      }
    }
  }
  
  public TVK_IMediaPlayer a()
  {
    VideoCoverView localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    if (localVideoCoverView != null) {
      return localVideoCoverView.a();
    }
    return null;
  }
  
  public void a()
  {
    VideoCoverView localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
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
      i = (int)(((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.a() / 1000L);
      localObject1 = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b;
      if (i > 0)
      {
        localObject2 = (Integer)PublicAccountAdvertisementActivity.a.get(localObject1);
        if (localObject2 != null) {
          break label217;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverAdapter", 2, "sum time is null,current time" + i);
        }
        PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(i));
      }
      ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_Boolean) {
        break label313;
      }
      bool = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.getVid());
      if (NetUtil.a(null) != 1) {
        break label239;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
    }
    label313:
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      label217:
      PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + i));
      break;
      label239:
      if ((NetUtil.a(null) == 0) && (bool))
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
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kuf(this), 500L);
      }
    }
    VideoCoverView localVideoCoverView;
    do
    {
      return;
      localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    } while (localVideoCoverView == null);
    localVideoCoverView.d();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)localIterator.next();
      if (localVideoCoverItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView != null)
      {
        localVideoCoverItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.f();
        localVideoCoverItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = null;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Kug);
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    }
  }
  
  public void c()
  {
    try
    {
      VideoCoverView localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
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
    VideoCoverView localVideoCoverView = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
    if (localVideoCoverView != null) {
      localVideoCoverView.a();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramObject = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
      if (paramObject != null)
      {
        paramViewGroup.removeView(paramObject);
        paramObject.f();
        ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = null;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    VideoCoverView localVideoCoverView = new VideoCoverView(this.jdField_a_of_type_AndroidContentContext, (VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), getCount(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient);
    ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = localVideoCoverView;
    paramViewGroup.addView(localVideoCoverView);
    return localVideoCoverView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter
 * JD-Core Version:    0.7.0.1
 */