package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.GetFeedDetailRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WSVerticalForMiniAppPresenter
  extends AbsWSVerticalPagePresenter
{
  private String a;
  
  public WSVerticalForMiniAppPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed)) {
        this.a = ((stSimpleMetaFeed)paramArrayList.get(0)).id;
      }
      return WSVerticalDataUtil.a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSLog.d("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + paramInt);
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(String paramString, IVerticalRspListener paramIVerticalRspListener, long paramLong)
  {
    paramString = new WeishiTask(new GetFeedDetailRequest(paramString), null, new WSVerticalForMiniAppPresenter.1(this, paramLong, paramIVerticalRspListener), 4002);
    WeishiBusinessLooper.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(this.a, this, System.currentTimeMillis());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForMiniAppPresenter
 * JD-Core Version:    0.7.0.1
 */