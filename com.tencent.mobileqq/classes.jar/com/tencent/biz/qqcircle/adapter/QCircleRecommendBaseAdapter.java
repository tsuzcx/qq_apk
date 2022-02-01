package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public abstract class QCircleRecommendBaseAdapter
  extends RecyclerView.Adapter
{
  protected List<QQCircleDitto.StItemInfo> a = new ArrayList();
  protected FeedCloudMeta.StFeed b;
  protected int c;
  protected RecyclerView d;
  protected QCircleBaseWidgetView e;
  protected QQCircleDitto.StItemContainer f;
  
  private void b(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("scrollToScreenLeft removeIndex : ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.i("QCircleRecommendBaseAdapter", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.d;
    if ((localObject1 != null) && ((((RecyclerView)localObject1).getLayoutManager() instanceof LinearLayoutManager)))
    {
      Object localObject2 = ((LinearLayoutManager)this.d.getLayoutManager()).findViewByPosition(paramInt);
      if (localObject2 == null)
      {
        QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft findViewByPosition  view == null");
        return;
      }
      localObject1 = new int[2];
      ((View)localObject2).getLocationOnScreen((int[])localObject1);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject2).getLayoutParams();
      paramInt = ((View)localObject2).getWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("scrollToScreenLeft locationX = ");
      ((StringBuilder)localObject2).append(localObject1[0]);
      ((StringBuilder)localObject2).append("  , viewWidth = ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i("QCircleRecommendBaseAdapter", 1, ((StringBuilder)localObject2).toString());
      if (localObject1[0] < paramInt) {
        return;
      }
      paramInt = localObject1[0];
      this.d.postDelayed(new QCircleRecommendBaseAdapter.2(this, paramInt), 370L);
      return;
    }
    QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft mRecycleView or LinearLayoutManager == null");
  }
  
  protected void a()
  {
    RecyclerView localRecyclerView = this.d;
    if (localRecyclerView == null)
    {
      QLog.d("QCircleRecommendBaseAdapter", 1, "[safeNotify] recycle view should not be null.");
      return;
    }
    if (localRecyclerView.isComputingLayout())
    {
      this.d.postDelayed(new QCircleRecommendBaseAdapter.1(this), 500L);
      return;
    }
    notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if ((this.b != null) && (this.f != null))
    {
      FeedCloudMeta.StDittoFeed localStDittoFeed = new FeedCloudMeta.StDittoFeed();
      localStDittoFeed.dittoId.set(paramInt);
      this.f.items.set(this.a);
      localStDittoFeed.dittoData.set(ByteStringMicro.copyFrom(QCirclePluginUtil.a(this.f).toByteArray()));
      this.b.dittoFeed.set(localStDittoFeed);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.d = paramRecyclerView;
  }
  
  public void a(QCircleBaseWidgetView paramQCircleBaseWidgetView)
  {
    this.e = paramQCircleBaseWidgetView;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = ((QQCircleDitto.StItemInfo)paramObject).id.get();
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.a.size()) {
          break;
        }
        Object localObject = this.a.get(i);
        if (((localObject instanceof QQCircleDitto.StItemInfo)) && (((QQCircleDitto.StItemInfo)localObject).id.get().equals(paramObject)))
        {
          j = i;
          break;
        }
        i += 1;
      }
      if (j >= 0)
      {
        if (paramInt == 1) {
          b(j);
        }
        this.a.remove(j);
        paramObject = new StringBuilder();
        paramObject.append("remove data is ");
        paramObject.append(j);
        QLog.d("QCircleTagPageRecommendWidget", 1, paramObject.toString());
        notifyItemRemoved(j);
        a(paramInt);
        if ((this.a.size() <= 0) && (!b())) {
          this.e.setVisibility(8);
        }
      }
    }
  }
  
  public void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    this.f = paramStItemContainer;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter
 * JD-Core Version:    0.7.0.1
 */