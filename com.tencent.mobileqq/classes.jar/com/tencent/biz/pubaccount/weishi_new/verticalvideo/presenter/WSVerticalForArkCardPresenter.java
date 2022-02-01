package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
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
  private boolean f;
  
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
    if ((paramInt == 1) && (this.f))
    {
      paramView = paramView.a();
      if (paramView != null)
      {
        this.f = false;
        paramView.removeItem(paramView.getDataList().get(0));
      }
    }
  }
  
  private void a(WSVerticalPageContract.View paramView, String paramString)
  {
    if ((paramView != null) && (!paramView.c()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramView = QQToast.a(BaseApplicationImpl.getContext(), paramString, 1);
      paramView.b(4);
      paramView.a(QQToast.a(4));
      paramView.a();
      paramView = new StringBuilder();
      paramView.append("[WSVerticalForArkCardPresenter.java][showToast] toastTips:");
      paramView.append(paramString);
      WSLog.e("WSVerticalForArkCardPresenter", paramView.toString());
    }
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool3 = paramObject instanceof WSArkCardDataManager.ExtParams;
    boolean bool1 = true;
    boolean bool2 = true;
    if (bool3)
    {
      paramObject = (WSArkCardDataManager.ExtParams)paramObject;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isIntentFeedVideoInvalid] isInvalid:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", mIntentFeedId:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", params.mFeedId:");
      localStringBuilder.append(paramObject.jdField_a_of_type_JavaLangString);
      WSLog.e("WSVerticalForArkCardPresenter", localStringBuilder.toString());
    }
    return bool1;
  }
  
  private boolean a(List<WSVerticalItemData> paramList)
  {
    boolean bool2 = false;
    paramList = (WSVerticalItemData)paramList.get(0);
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)
      {
        bool1 = bool2;
        if ((paramList.a() instanceof stSimpleMetaFeed))
        {
          paramList = paramList.a();
          bool1 = TextUtils.equals(paramList.video_url, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[isSameUrlForArkAndFirstFeed] isSame:");
          localStringBuilder.append(bool1);
          localStringBuilder.append(", intentUrl:");
          localStringBuilder.append(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_url);
          localStringBuilder.append(", firstUrl:");
          localStringBuilder.append(paramList.video_url);
          WSLog.d("WSVerticalForArkCardPresenter", localStringBuilder.toString());
        }
      }
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean, List<WSVerticalItemData> paramList)
  {
    if ((paramBoolean) && (!a(paramList))) {
      return h();
    }
    return false;
  }
  
  private void b(WSVerticalPageContract.View paramView)
  {
    if (!(paramView instanceof WSVerticalPageFragment)) {
      return;
    }
    ((WSVerticalPageFragment)paramView).i();
  }
  
  private void b(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject1 = a();
    if ((paramWSVerticalItemData != null) && (localObject1 != null))
    {
      Object localObject2 = ((WSVerticalPageContract.View)localObject1).a();
      if (localObject2 != null)
      {
        localObject1 = ((WSVerticalPageAdapter)localObject2).a();
        if (localObject1 == null) {
          return;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("WSVerticalForArkCardPresenter onSuccess getItemCount: ");
        ((StringBuilder)localObject3).append(((WSVerticalPageAdapter)localObject2).getItemCount());
        WSLog.d("terry_ark", ((StringBuilder)localObject3).toString());
        localObject3 = ((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
        if ((localObject3 instanceof AbsWSVideoItemView)) {
          ((AbsWSVideoItemView)localObject3).b(paramWSVerticalItemData);
        }
        localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject2).getItem(0);
        if (localObject2 == null) {
          return;
        }
        paramWSVerticalItemData = paramWSVerticalItemData.a();
        if (paramWSVerticalItemData == null) {
          return;
        }
        if (paramWSVerticalItemData.floatingLayerCardStyle != null) {
          paramWSVerticalItemData.floatingLayerCardStyle.cardType = 3;
        }
        ((WSVerticalItemData)localObject2).a(paramWSVerticalItemData);
        if (((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) {
          ((WSVerticalVideoHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a = WSPlayerUtils.a(paramWSVerticalItemData);
        }
      }
    }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WSVerticalForMiniAppPresenter onPageSelected: ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WSVerticalForArkCardPresenter", ((StringBuilder)localObject).toString());
    localObject = a();
    if (localObject == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.jdField_a_of_type_JavaLangObject });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    a(paramInt, (WSVerticalPageContract.View)localObject);
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    super.a(paramBaseViewHolder, paramInt);
    if ((paramInt == 1) && (this.f)) {
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
      this.f = bool;
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
    if (paramBoolean2) {
      localObject = a(paramList);
    } else {
      localObject = null;
    }
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    b((WSVerticalItemData)localObject);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalForArkCardPresenter fetchFeedData isRefresh: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isFirst = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" from = ");
    localStringBuilder.append(paramString);
    WSLog.d("terry_ark", localStringBuilder.toString());
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
  
  protected boolean k()
  {
    return true;
  }
  
  protected boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForArkCardPresenter
 * JD-Core Version:    0.7.0.1
 */