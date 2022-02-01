package com.tencent.biz.qqcircle.scrollers;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCircleFeedPicPreloadScroller
  extends QCircleFeedBaseScroller
{
  private static String g = "QCircleFeedPicPreloadScroller";
  private static final HandlerThread h = new HandlerThread("QCircleFeedPicPreloadScroller", -2);
  private static final Handler i = new Handler(h.getLooper());
  private ConcurrentHashMap<String, Boolean> j = new ConcurrentHashMap();
  
  static
  {
    h.start();
  }
  
  private void a(int paramInt, List<FeedBlockData> paramList)
  {
    try
    {
      localObject1 = paramList.subList(paramInt, paramList.size()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FeedBlockData)((Iterator)localObject1).next();
        FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)localObject2).b();
        if ((this.d != null) && (this.d.pageType == 11)) {
          a(localStFeed);
        } else if (localStFeed.type.get() == 2) {
          d(localStFeed);
        } else if (localStFeed.type.get() == 3) {
          e(localStFeed);
        } else if (localStFeed.dittoFeed.dittoId.get() == 1) {
          b((FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get());
        } else if (localStFeed.dittoFeed.dittoId.get() == 6) {
          a((FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get());
        } else if (localStFeed.dittoFeed.dittoId.get() == 11) {
          a((FeedBlockData)localObject2);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label208:
      break label208;
    }
    localObject1 = g;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("feeds size");
    ((StringBuilder)localObject2).append(paramList.size());
    QLog.e((String)localObject1, 4, ((StringBuilder)localObject2).toString());
  }
  
  private void a(FeedBlockData paramFeedBlockData)
  {
    h().post(new QCircleFeedPicPreloadScroller.1(this, paramFeedBlockData));
  }
  
  private void a(FeedCloudMeta.StDittoFeed paramStDittoFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.4(this, paramStDittoFeed));
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() == 2)
    {
      c(paramStFeed);
      return;
    }
    if (paramStFeed.type.get() == 3) {
      b(paramStFeed);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!f()) {
      return;
    }
    if (paramInt1 >= 0)
    {
      if (paramInt2 < paramInt1) {
        return;
      }
      ArrayList localArrayList = this.f.getDataList();
      if (localArrayList != null)
      {
        if (localArrayList.size() <= paramInt2) {
          return;
        }
        String str = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("feeds size");
        localStringBuilder.append(localArrayList.size());
        QLog.d(str, 4, localStringBuilder.toString());
        a(paramInt1, localArrayList);
      }
    }
  }
  
  private boolean a(List<QQCircleDitto.StItemInfo> paramList, int paramInt1, int paramInt2)
  {
    Pair localPair2 = QCirclePreLoadPicUtil.b(0);
    Pair localPair3 = QCirclePreLoadPicUtil.b(1);
    if ((((Integer)localPair2.first).intValue() != 0) && (((Integer)localPair2.second).intValue() != 0) && (((Integer)localPair3.first).intValue() != 0))
    {
      if (((Integer)localPair3.second).intValue() == 0) {
        return true;
      }
      int k = paramInt1;
      paramInt1 = 0;
      while (paramInt1 < 3)
      {
        String str = ((FeedCloudMeta.StImage)((QQCircleDitto.StItemInfo)paramList.get(paramInt2)).images.get().get(paramInt1)).picUrl.get();
        Pair localPair1;
        if (paramInt1 == 0) {
          localPair1 = localPair2;
        } else {
          localPair1 = localPair3;
        }
        k = a(k, true, str, localPair1);
        paramInt1 += 1;
      }
      return false;
    }
    return true;
  }
  
  private void b(FeedCloudMeta.StDittoFeed paramStDittoFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.5(this, paramStDittoFeed));
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.2(this, paramStFeed));
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.3(this, paramStFeed));
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.6(this, paramStFeed));
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    h().post(new QCircleFeedPicPreloadScroller.8(this, paramStFeed));
  }
  
  private static Handler h()
  {
    return i;
  }
  
  private void i()
  {
    h().post(new QCircleFeedPicPreloadScroller.9(this));
  }
  
  public int a(int paramInt, boolean paramBoolean, String paramString, Pair<Integer, Integer> paramPair)
  {
    paramString = new Option().setFromPreLoad(true).setPredecode(paramBoolean).setUrl(paramString).setRequestWidth(((Integer)paramPair.first).intValue()).setRequestHeight(((Integer)paramPair.second).intValue());
    int k = paramInt + 1;
    paramString = paramString.setPriority(k);
    paramPair = QCircleFeedPicLoader.g().getCacheKey(paramString);
    if (!this.j.containsKey(paramPair))
    {
      QCircleFeedPicLoader.g().loadImage(paramString, new QCircleFeedPicPreloadScroller.7(this));
      this.j.put(paramPair, Boolean.valueOf(false));
      paramInt = k;
    }
    return paramInt;
  }
  
  public void a()
  {
    i();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    super.a(paramRecyclerView);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramBoolean)) {
      a(paramBoolean, paramInt2, paramInt3);
    }
  }
  
  public void c()
  {
    i();
  }
  
  public void e()
  {
    QLog.d(g, 1, "onDestroy");
    i();
    this.j.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller
 * JD-Core Version:    0.7.0.1
 */