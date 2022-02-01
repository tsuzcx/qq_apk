package com.tencent.biz.qqcircle.scrollers;

import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.helper.VideoPreloadHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleFeedVideoPreloadScroller
  extends QCircleFeedBaseScroller
{
  private static String g = "QCircleFeedVideoPreloadScroller";
  private ConcurrentHashMap<String, String> h = new ConcurrentHashMap();
  private VideoPreloadHelper i;
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (!f()) {
        return;
      }
      if (paramInt2 > paramInt1)
      {
        Object localObject1 = this.f.getDataList();
        if ((localObject1 != null) && (((List)localObject1).size() > paramInt2))
        {
          Object localObject2 = g;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("feeds size");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
          localObject1 = ((List)localObject1).subList(paramInt1, ((List)localObject1).size()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((FeedBlockData)((Iterator)localObject1).next()).b();
            localObject3 = ((FeedCloudMeta.StFeed)localObject2).id.get();
            if (((FeedCloudMeta.StFeed)localObject2).type.get() == 3) {
              h().post(new QCircleFeedVideoPreloadScroller.1(this, (String)localObject3, (FeedCloudMeta.StFeed)localObject2));
            }
          }
        }
      }
    }
  }
  
  private VideoPreloadHelper g()
  {
    if (this.i == null)
    {
      int j;
      if (this.c == null) {
        j = 0;
      } else {
        j = this.c.hashCode();
      }
      this.i = new VideoPreloadHelper(j);
    }
    return this.i;
  }
  
  private Handler h()
  {
    return RFThreadManager.getSerialThreadHandler();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0) {
      a(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  public void e()
  {
    super.e();
    g().a();
    g().b();
    this.h.clear();
    h().removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedVideoPreloadScroller
 * JD-Core Version:    0.7.0.1
 */