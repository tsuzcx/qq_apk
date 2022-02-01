package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
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
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
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
  private static final int a = ScreenUtil.dip2px(42.0F);
  private List<WSVerticalItemData> b = new ArrayList();
  private stSimpleMetaFeed i;
  private String j;
  private boolean k;
  
  public WSVerticalForArkCardPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private WSVerticalItemData a(List<WSVerticalItemData> paramList)
  {
    int m = 0;
    while (m < paramList.size())
    {
      Object localObject = (WSVerticalItemData)paramList.get(m);
      if (localObject != null)
      {
        localObject = ((WSVerticalItemData)localObject).b();
        if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaFeed)localObject).id)) && (((stSimpleMetaFeed)localObject).id.equals(this.j))) {
          return (WSVerticalItemData)paramList.remove(m);
        }
      }
      m += 1;
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
    if ((paramInt == 1) && (this.k))
    {
      paramView = paramView.b();
      if (paramView != null)
      {
        this.k = false;
        paramView.removeItem(paramView.getDataList().get(0));
      }
    }
  }
  
  private void a(WSVerticalPageContract.View paramView, String paramString)
  {
    if ((paramView != null) && (!paramView.t()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramView = QQToast.makeText(BaseApplicationImpl.getContext(), paramString, 1);
      paramView.setType(4);
      paramView.setToastIcon(QQToast.getIconRes(4));
      paramView.show();
      paramView = new StringBuilder();
      paramView.append("[WSVerticalForArkCardPresenter.java][showToast] toastTips:");
      paramView.append(paramString);
      WSLog.e("WSVerticalForArkCardPresenter", paramView.toString());
    }
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject1 = z();
    if ((paramWSVerticalItemData != null) && (localObject1 != null))
    {
      Object localObject2 = ((WSVerticalPageContract.View)localObject1).b();
      if (localObject2 != null)
      {
        localObject1 = ((WSVerticalPageAdapter)localObject2).b();
        if (localObject1 == null) {
          return;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("WSVerticalForArkCardPresenter onSuccess getItemCount: ");
        ((StringBuilder)localObject3).append(((WSVerticalPageAdapter)localObject2).getItemCount());
        WSLog.d("terry_ark", ((StringBuilder)localObject3).toString());
        localObject3 = ((WSVerticalVideoHolder)localObject1).c;
        if ((localObject3 instanceof AbsWSVideoItemView)) {
          ((AbsWSVideoItemView)localObject3).b(paramWSVerticalItemData);
        }
        localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject2).getItem(0);
        if (localObject2 == null) {
          return;
        }
        paramWSVerticalItemData = paramWSVerticalItemData.b();
        if (paramWSVerticalItemData == null) {
          return;
        }
        if (paramWSVerticalItemData.floatingLayerCardStyle != null) {
          paramWSVerticalItemData.floatingLayerCardStyle.cardType = 3;
        }
        ((WSVerticalItemData)localObject2).a(paramWSVerticalItemData);
        if (((WSVerticalVideoHolder)localObject1).f != null) {
          ((WSVerticalVideoHolder)localObject1).f.c = WSPlayerUtils.a(paramWSVerticalItemData);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, List<WSVerticalItemData> paramList)
  {
    if ((paramBoolean) && (!b(paramList))) {
      return C();
    }
    return false;
  }
  
  private void b(WSVerticalPageContract.View paramView)
  {
    if (!(paramView instanceof WSVerticalPageFragment)) {
      return;
    }
    ((WSVerticalPageFragment)paramView).E();
  }
  
  private boolean b(Object paramObject)
  {
    boolean bool3 = paramObject instanceof WSArkCardDataManager.ExtParams;
    boolean bool1 = true;
    boolean bool2 = true;
    if (bool3)
    {
      paramObject = (WSArkCardDataManager.ExtParams)paramObject;
      if ((!TextUtils.isEmpty(this.j)) && (TextUtils.equals(paramObject.a, this.j))) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isIntentFeedVideoInvalid] isInvalid:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", mIntentFeedId:");
      localStringBuilder.append(this.j);
      localStringBuilder.append(", params.mFeedId:");
      localStringBuilder.append(paramObject.a);
      WSLog.e("WSVerticalForArkCardPresenter", localStringBuilder.toString());
    }
    return bool1;
  }
  
  private boolean b(List<WSVerticalItemData> paramList)
  {
    boolean bool2 = false;
    paramList = (WSVerticalItemData)paramList.get(0);
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.i != null)
      {
        bool1 = bool2;
        if ((paramList.b() instanceof stSimpleMetaFeed))
        {
          paramList = paramList.b();
          bool1 = TextUtils.equals(paramList.video_url, this.i.video_url);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[isSameUrlForArkAndFirstFeed] isSame:");
          localStringBuilder.append(bool1);
          localStringBuilder.append(", intentUrl:");
          localStringBuilder.append(this.i.video_url);
          localStringBuilder.append(", firstUrl:");
          localStringBuilder.append(paramList.video_url);
          WSLog.d("WSVerticalForArkCardPresenter", localStringBuilder.toString());
        }
      }
    }
    return bool1;
  }
  
  protected boolean H()
  {
    return true;
  }
  
  protected boolean I()
  {
    return true;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        this.i = ((stSimpleMetaFeed)paramArrayList.get(0));
        this.j = this.i.id;
      }
      return WSVerticalDataUtil.a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    super.a();
    WSAioListHelper.a();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WSVerticalForMiniAppPresenter onPageSelected: ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.d("WSVerticalForArkCardPresenter", ((StringBuilder)localObject).toString());
    localObject = z();
    if (localObject == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.f = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.e });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
    a(paramInt, (WSVerticalPageContract.View)localObject);
  }
  
  public void a(BaseViewHolder<WSVerticalItemData> paramBaseViewHolder, int paramInt)
  {
    super.a(paramBaseViewHolder, paramInt);
    if ((paramInt == 1) && (this.k)) {
      b(z());
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    Object localObject = z();
    if (localObject == null) {
      return;
    }
    if (paramBoolean2)
    {
      boolean bool = b(paramObject);
      this.k = bool;
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
    a((WSVerticalItemData)localObject);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (b(paramObject)) {
      return false;
    }
    return a(paramBoolean2, paramList);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalForArkCardPresenter fetchFeedData isRefresh: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isFirst = ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" from = ");
    localStringBuilder.append(paramString);
    WSLog.d("terry_ark", localStringBuilder.toString());
    paramString = z();
    if ((paramString != null) && (this.i != null))
    {
      if (paramBoolean2) {
        this.b = paramString.g();
      }
      WSArkCardDataManager.a().a(this.i.poster_id, 10007, paramBoolean1, paramBoolean2, this.b, this, null);
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return a;
  }
  
  public void g()
  {
    super.g();
    if (WSExpABTestManager.a().v())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(WSVerticalBeaconReport.c(z().k()));
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(z().k());
      localObject = ((StringBuilder)localObject).toString();
      WSAioListHelper.a(N(), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForArkCardPresenter
 * JD-Core Version:    0.7.0.1
 */