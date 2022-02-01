package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForDramaHistoryPresenter
  extends AbsWSVerticalForDramaPresenter
{
  public WSVerticalForDramaHistoryPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private int a(@Nullable String paramString, @NonNull WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    if (paramString == null) {
      return -1;
    }
    paramWSVerticalPageAdapter = paramWSVerticalPageAdapter.getDataList();
    if (paramWSVerticalPageAdapter == null) {
      return -1;
    }
    int i = 0;
    while (i < paramWSVerticalPageAdapter.size())
    {
      Object localObject = (WSVerticalItemData)paramWSVerticalPageAdapter.get(i);
      if (localObject != null)
      {
        localObject = ((WSVerticalItemData)localObject).a();
        if ((localObject != null) && (paramString.equals(((stSimpleMetaFeed)localObject).id))) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  protected void c(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    super.c(paramList, paramBoolean1, paramBoolean2, paramObject);
    if (paramBoolean2)
    {
      int i = a(this.b, a());
      if ((i != -1) && (a() != null) && (a().a() != null)) {
        a().a().scrollToPosition(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForDramaHistoryPresenter
 * JD-Core Version:    0.7.0.1
 */