package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSVerticalForFollowPresenter
  extends AbsWSVerticalPagePresenter
{
  private Intent a;
  
  public WSVerticalForFollowPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private List<WSVerticalItemData> a(List<stSimpleMetaFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (localstSimpleMetaFeed != null)
      {
        WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
        localWSVerticalItemData.a(localstSimpleMetaFeed);
        localArrayList.add(localWSVerticalItemData);
      }
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener, long paramLong)
  {
    WSFeedDataManager.a().a(paramBoolean2, paramBoolean1, "", 10, paramLong, new WSVerticalForFollowPresenter.1(this, paramIFetchDataRspListener, paramBoolean1, paramBoolean2));
  }
  
  public int a(int paramInt)
  {
    return WSFeedDataManager.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) + 1;
  }
  
  public WSPlayerParam a()
  {
    return WSFeedDataManager.a().a();
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    Object localObject = WSFeedDataManager.a().jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)((Iterator)localObject).next();
        WSVerticalItemData localWSVerticalItemData = new WSVerticalItemData();
        localWSVerticalItemData.a(localstSimpleMetaFeed);
        paramArrayList.add(localWSVerticalItemData);
      }
      return paramArrayList;
    }
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    paramViewHolder = a();
    if (paramViewHolder == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent == null) {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_feed_position", paramInt);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_from", paramViewHolder.a());
    this.jdField_a_of_type_AndroidContentIntent.putExtra("key_play_scene", paramViewHolder.b());
    paramViewHolder.a(8193, this.jdField_a_of_type_AndroidContentIntent);
    paramViewHolder = new WSItemExposeEvent(a(paramInt));
    WSSimpleEventBus.a().a(paramViewHolder);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean2) {
      return false;
    }
    a(paramBoolean1, false, this, System.currentTimeMillis());
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void g()
  {
    Object localObject = a();
    if ((this.d) && (localObject != null))
    {
      WSLog.b("WSVerticalForFollowPresenter", "onPause() back to follow page");
      localObject = ((WSVerticalPageContract.View)localObject).a().a();
      if ((localObject != null) && ((((WSVerticalVideoHolder)localObject).a instanceof AbsWSVideoItemView)))
      {
        localObject = (AbsWSVideoItemView)((WSVerticalVideoHolder)localObject).a;
        if ((((AbsWSVideoItemView)localObject).a() instanceof WSVerticalItemVideoAreaController)) {
          ((WSVerticalItemVideoAreaController)((AbsWSVideoItemView)localObject).a()).a(0, 100);
        }
      }
      WSPlayerAudioControl.a().a(false);
      return;
    }
    super.g();
  }
  
  public void h()
  {
    super.h();
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalPageContract.View)localObject).a();
    if (localObject != null)
    {
      localObject = ((WSPlayerManager)localObject).a();
      if (localObject == null) {
        return;
      }
      ((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = null;
      ((WSPlayerParam)localObject).jdField_a_of_type_AndroidViewViewGroup = null;
      WSFeedDataManager.a().a((WSPlayerParam)localObject);
      localObject = new WSVideoPlayEvent();
      ((WSVideoPlayEvent)localObject).mCurrentPosition = this.jdField_a_of_type_Int;
      WSSimpleEventBus.a().a((WSSimpleBaseEvent)localObject);
    }
  }
  
  public boolean j()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFollowPresenter
 * JD-Core Version:    0.7.0.1
 */