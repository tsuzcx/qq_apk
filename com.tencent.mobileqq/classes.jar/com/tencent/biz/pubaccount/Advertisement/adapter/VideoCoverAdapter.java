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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoCoverAdapter.MyNetInfoHandler jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$MyNetInfoHandler;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private VideoCoverView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private TVK_IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener;
  private ArrayList<VideoCoverItem> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  
  public VideoCoverAdapter(Context paramContext, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, AdvertisementItem paramAdvertisementItem, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = paramOnCompletionListener;
    if ((paramAdvertisementItem != null) && (paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = paramAdvertisementItem.jdField_a_of_type_JavaUtilArrayList;
    } else {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$MyNetInfoHandler = new VideoCoverAdapter.MyNetInfoHandler(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$MyNetInfoHandler);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  private boolean a()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    boolean bool = AdvertisementVideoPreloadManager.a(localVideoCoverView.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isVideoCached vid:");
      localStringBuilder.append(localVideoCoverView.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.getVid());
      localStringBuilder.append(" cache:");
      localStringBuilder.append(bool);
      QLog.d("VideoCoverAdapter", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = a();
    if ((localTVK_IMediaPlayer != null) && (localTVK_IMediaPlayer.isPlaying()))
    {
      FMToastUtil.a(HardCodeUtil.a(2131715875));
      if (!a()) {
        c();
      }
    }
  }
  
  public TVK_IMediaPlayer a()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    if (localVideoCoverView != null) {
      return localVideoCoverView.a();
    }
    return null;
  }
  
  public void a()
  {
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    if (localVideoCoverView != null) {
      localVideoCoverView.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.jdField_a_of_type_Int) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      int i = (int)(((VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a).a() / 1000L);
      Object localObject1 = ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).b;
      if (i > 0)
      {
        Object localObject2 = (Integer)PublicAccountAdvertisementActivity.a.get(localObject1);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("sum time is null,current time");
            ((StringBuilder)localObject2).append(i);
            QLog.d("VideoCoverAdapter", 2, ((StringBuilder)localObject2).toString());
          }
          PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(i));
        }
        else
        {
          PublicAccountAdvertisementActivity.a.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + i));
        }
      }
      ((VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a).b();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView = ((VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.bringToFront();
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_Boolean)
      {
        boolean bool = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.getVid());
        if (NetUtil.a(null) == 1)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.b(this.jdField_a_of_type_AndroidContentContext);
        }
        else if ((NetUtil.a(null) == 0) && (bool))
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
          ((VideoCoverView)localObject1).jdField_a_of_type_Int = 6;
          ((VideoCoverView)localObject1).g();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView.a(this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoCoverAdapter.1(this), 500L);
      }
    }
    else
    {
      VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
      if (localVideoCoverView != null) {
        localVideoCoverView.d();
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)((Iterator)localObject).next();
      if (localVideoCoverItem.a != null)
      {
        ((VideoCoverView)localVideoCoverItem.a).f();
        localVideoCoverItem.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter$MyNetInfoHandler);
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null)
    {
      ((TroopMemberApiClient)localObject).b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    }
  }
  
  public void c()
  {
    Object localObject;
    try
    {
      VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
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
    VideoCoverView localVideoCoverView = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a;
    if (localVideoCoverView != null) {
      localVideoCoverView.a();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramObject = (VideoCoverView)((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
      if (paramObject != null)
      {
        paramViewGroup.removeView(paramObject);
        paramObject.f();
        ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a = null;
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
    ((VideoCoverItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a = localVideoCoverView;
    paramViewGroup.addView(localVideoCoverView);
    return localVideoCoverView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter
 * JD-Core Version:    0.7.0.1
 */