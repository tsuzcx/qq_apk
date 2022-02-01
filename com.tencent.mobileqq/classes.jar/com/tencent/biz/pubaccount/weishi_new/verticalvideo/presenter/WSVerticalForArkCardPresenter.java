package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager.ExtParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WSVerticalForArkCardPresenter
  extends AbsWSVerticalPagePresenter
{
  private static final int b = ScreenUtil.dip2px(42.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private String jdField_a_of_type_JavaLangString;
  private List<WSVerticalItemData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean d;
  
  public WSVerticalForArkCardPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private WSVerticalItemData a(List<WSVerticalItemData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (WSVerticalItemData)paramList.get(i);
      if (localObject != null)
      {
        localObject = ((WSVerticalItemData)localObject).a();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.jdField_a_of_type_JavaLangString))) {
          return (WSVerticalItemData)paramList.remove(i);
        }
      }
      i += 1;
    }
    return null;
  }
  
  private String a(Object paramObject)
  {
    if ((paramObject instanceof WSArkCardDataManager.ExtParams)) {
      return ((WSArkCardDataManager.ExtParams)paramObject).b;
    }
    return "";
  }
  
  private void a(int paramInt, WSVerticalPageContract.View paramView)
  {
    if ((paramInt == 1) && (this.d))
    {
      paramView = paramView.a();
      if (paramView != null)
      {
        this.d = false;
        paramView.a(paramView.b().get(0));
      }
    }
  }
  
  private void a(WSVerticalPageContract.View paramView, String paramString)
  {
    if ((paramView == null) || (paramView.c()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramView = QQToast.a(BaseApplicationImpl.getContext(), paramString, 1);
    paramView.b(4);
    paramView.a(QQToast.a(4));
    paramView.a();
    WSLog.e("WSVerticalForArkCardPresenter", "[WSVerticalForArkCardPresenter.java][showToast] toastTips:" + paramString);
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject1 = a();
    Object localObject2;
    if ((paramWSVerticalItemData != null) && (localObject1 != null))
    {
      localObject2 = ((WSVerticalPageContract.View)localObject1).a();
      if (localObject2 != null)
      {
        localObject1 = ((WSVerticalPageAdapter)localObject2).a();
        if (localObject1 != null) {
          break label34;
        }
      }
    }
    label34:
    do
    {
      do
      {
        do
        {
          return;
          WSLog.d("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + ((WSVerticalPageAdapter)localObject2).getItemCount());
          IWSItemView localIWSItemView = ((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
          if ((localIWSItemView instanceof AbsWSVideoItemView)) {
            ((AbsWSVideoItemView)localIWSItemView).b(paramWSVerticalItemData);
          }
          localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject2).a(0);
        } while (localObject2 == null);
        paramWSVerticalItemData = paramWSVerticalItemData.a();
      } while (paramWSVerticalItemData == null);
      if (paramWSVerticalItemData.floatingLayerCardStyle != null) {
        paramWSVerticalItemData.floatingLayerCardStyle.cardType = 3;
      }
      ((WSVerticalItemData)localObject2).a(paramWSVerticalItemData);
    } while (((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam == null);
    ((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a = WSPlayerUtils.a(paramWSVerticalItemData);
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramObject instanceof WSArkCardDataManager.ExtParams))
    {
      paramObject = (WSArkCardDataManager.ExtParams)paramObject;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))) {
        break label92;
      }
    }
    label92:
    for (bool1 = bool2;; bool1 = false)
    {
      WSLog.e("WSVerticalForArkCardPresenter", "[isIntentFeedVideoInvalid] isInvalid:" + bool1 + ", mIntentFeedId:" + this.jdField_a_of_type_JavaLangString + ", params.mFeedId:" + paramObject.jdField_a_of_type_JavaLangString);
      return bool1;
    }
  }
  
  private boolean a(List<WSVerticalItemData> paramList)
  {
    paramList = (WSVerticalItemData)paramList.get(0);
    if ((paramList != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && ((paramList.a() instanceof stSimpleMetaFeed)))
    {
      paramList = paramList.a();
      boolean bool = TextUtils.equals(paramList.video_url, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url);
      WSLog.d("WSVerticalForArkCardPresenter", "[isSameUrlForArkAndFirstFeed] isSame:" + bool + ", intentUrl:" + this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url + ", firstUrl:" + paramList.video_url);
      return bool;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, List<WSVerticalItemData> paramList)
  {
    if ((paramBoolean) && (!a(paramList))) {
      return c();
    }
    return false;
  }
  
  private void b(WSVerticalPageContract.View paramView)
  {
    if (!(paramView instanceof WSVerticalPageFragment)) {
      return;
    }
    ((WSVerticalPageFragment)paramView).g();
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)paramArrayList.get(0));
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id;
      }
      return WSVerticalDataUtil.a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSLog.d("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      WSCommentEvent localWSCommentEvent = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      StoryDispatcher.a().dispatch(localWSCommentEvent);
      if (paramViewHolder.jdField_a_of_type_JavaLangObject != null) {
        localView.b(((WSVerticalItemData)paramViewHolder.jdField_a_of_type_JavaLangObject).a());
      }
    }
    a(paramInt, localView);
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    super.a(paramBaseViewHolder, paramInt);
    if ((paramInt == 1) && (this.d)) {
      b(a());
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (paramBoolean2)
    {
      boolean bool = a(paramObject);
      this.d = bool;
      if (bool)
      {
        super.a(paramList, paramBoolean1, true, paramObject);
        a((WSVerticalPageContract.View)localObject, a(paramObject));
        return;
      }
    }
    if (a(paramBoolean2, paramList))
    {
      super.a(paramList, paramBoolean1, true, paramObject);
      return;
    }
    if (paramBoolean2) {}
    for (localObject = a(paramList);; localObject = null)
    {
      super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
      a((WSVerticalItemData)localObject);
      return;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    WSLog.d("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + paramBoolean1 + " isFirst = " + paramBoolean2 + " from = " + paramString);
    paramString = a();
    if ((paramString != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null))
    {
      if (paramBoolean2) {
        this.jdField_a_of_type_JavaUtilList = paramString.a();
      }
      WSArkCardDataManager.a().a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id, 10007, paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaUtilList, this, null);
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (a(paramObject)) {
      return false;
    }
    return a(paramBoolean2, paramList);
  }
  
  public int b()
  {
    return b;
  }
  
  public void e()
  {
    super.e();
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)) {
      localView.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForArkCardPresenter
 * JD-Core Version:    0.7.0.1
 */