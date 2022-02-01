package com.tencent.biz.qqcircle.utils;

import android.util.Pair;
import com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCirclePreLoadPicUtil
{
  public static Pair<Integer, Integer> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    case 50002: 
      return new Pair(Integer.valueOf(QCirclePYMKRecommendItemViewHolder.h), Integer.valueOf(QCirclePYMKRecommendItemViewHolder.j));
    }
    return new Pair(Integer.valueOf(QCirclePYMKRecommendItemViewHolder.h), Integer.valueOf(QCirclePYMKRecommendItemViewHolder.i));
  }
  
  public static Pair<Integer, Integer> a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    Object localObject = Integer.valueOf(0);
    localObject = new Pair(localObject, localObject);
    if (paramStFeed != null)
    {
      float f;
      if (paramStFeed.type.get() == 3)
      {
        int i = ImmersiveUtils.b();
        f = paramInt1 / paramInt2;
        if (f >= 1.777778F) {}
        for (f = i / 1.777778F;; f = i / 0.75F)
        {
          paramInt1 = (int)f;
          break;
          if ((f > 0.75F) && (f <= 1.777778F))
          {
            paramInt1 = (int)(i / f);
            break;
          }
        }
        return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt1));
      }
      if (paramStFeed.type.get() == 2)
      {
        paramStFeed = paramStFeed.images.get();
        paramInt1 = ImmersiveUtils.b();
        if (paramStFeed.size() > 0)
        {
          paramStFeed = (FeedCloudMeta.StImage)paramStFeed.get(0);
          if ((paramStFeed.width.get() != 0) && (paramStFeed.height.get() != 0))
          {
            f = Math.max(Math.min(paramStFeed.height.get() / paramStFeed.width.get(), 1.333333F), 0.5625F);
            return new Pair(Integer.valueOf(paramInt1), Integer.valueOf((int)(paramInt1 * f)));
          }
        }
      }
    }
    return localObject;
  }
  
  public static List<QQCircleDitto.StItemInfo> a(List<QQCircleDitto.StItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
        if ((localStItemInfo != null) && (localStItemInfo.buttonInfo.buttonValue.get() == 0) && (!QCircleFollowManager.getInstance().isUinFollowed(localStItemInfo.id.get()))) {
          localArrayList.add(localStItemInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static Pair<Integer, Integer> b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new Pair(Integer.valueOf(0), Integer.valueOf(0));
      }
      return new Pair(Integer.valueOf(QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.h), Integer.valueOf(QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.j));
    }
    return new Pair(Integer.valueOf(QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.h), Integer.valueOf(QCircleTagRecommendWidget.QCircleTagRecommendItemViewHolder.i));
  }
  
  public static List<QQCircleDitto.StItemInfo> b(List<QQCircleDitto.StItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
        if ((localStItemInfo.images.get().size() >= 3) && (localArrayList.size() < 10)) {
          localArrayList.add(localStItemInfo);
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCirclePreLoadPicUtil
 * JD-Core Version:    0.7.0.1
 */