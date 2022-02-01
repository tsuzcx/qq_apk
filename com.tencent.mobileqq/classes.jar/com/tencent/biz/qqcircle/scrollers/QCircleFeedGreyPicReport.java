package com.tencent.biz.qqcircle.scrollers;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemVideoPresenter;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QCircleFeedGreyPicReport
{
  private HashMap<String, String> a = new HashMap();
  
  private void a(FeedCloudMeta.StFeed paramStFeed, FrameLayout paramFrameLayout)
  {
    if ((paramStFeed != null) && (paramFrameLayout != null))
    {
      if (this.a.containsKey(paramStFeed.id.get())) {
        return;
      }
      if ((paramFrameLayout.getChildCount() > 0) && ((paramFrameLayout.getChildAt(0) instanceof RecyclerView)))
      {
        paramFrameLayout = (LinearLayoutManager)((RecyclerView)paramFrameLayout.getChildAt(0)).getLayoutManager();
        Object localObject2 = paramFrameLayout.findViewByPosition(paramFrameLayout.findFirstCompletelyVisibleItemPosition());
        Object localObject1 = null;
        if ((paramStFeed.type.get() == 2) && ((localObject2 instanceof QCircleContentImage)))
        {
          paramFrameLayout = ((QCircleContentImage)localObject2).getCover();
        }
        else
        {
          paramFrameLayout = localObject1;
          if (paramStFeed.type.get() == 3)
          {
            paramFrameLayout = localObject1;
            if ((localObject2 instanceof QCircleDoubleClickLayout))
            {
              localObject2 = (QCircleDoubleClickLayout)localObject2;
              paramFrameLayout = localObject1;
              if (((QCircleDoubleClickLayout)localObject2).getChildCount() > 0)
              {
                paramFrameLayout = localObject1;
                if ((((QCircleDoubleClickLayout)localObject2).getChildAt(0) instanceof QCircleContentVideo)) {
                  paramFrameLayout = ((QCircleContentVideo)((QCircleDoubleClickLayout)localObject2).getChildAt(0)).getVideoCover();
                }
              }
            }
          }
        }
        a(paramStFeed.id.get(), paramFrameLayout, 2);
      }
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QCircleInsFeedItemView paramQCircleInsFeedItemView)
  {
    if ((paramStFeed != null) && (paramQCircleInsFeedItemView != null))
    {
      if (this.a.containsKey(paramStFeed.id.get())) {
        return;
      }
      Object localObject2 = null;
      Object localObject1;
      if (paramStFeed.type.get() == 2)
      {
        paramQCircleInsFeedItemView = paramQCircleInsFeedItemView.getPicPresenter();
        localObject1 = localObject2;
        if (paramQCircleInsFeedItemView != null) {
          localObject1 = paramQCircleInsFeedItemView.getCurrentImageView();
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramStFeed.type.get() == 3)
        {
          paramQCircleInsFeedItemView = paramQCircleInsFeedItemView.getVideoPresenter();
          localObject1 = localObject2;
          if (paramQCircleInsFeedItemView != null) {
            localObject1 = paramQCircleInsFeedItemView.mVideoCoverImg;
          }
        }
      }
      a(paramStFeed.id.get(), (ImageView)localObject1, 1);
    }
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      this.a.put(paramString, "");
      paramString = new ArrayList();
      paramString.add(QCircleReportHelper.newEntry("refer", String.valueOf(paramInt)));
      if ((paramImageView instanceof BitmapDrawable))
      {
        QLog.d("QCircleFeedGrayPicReport", 4, "isGrey:false");
        QCircleQualityReporter.reportImageQualityEvent("imgae_show_grey", "", String.valueOf(1), "", 0, new List[] { paramString });
        return;
      }
      QLog.d("QCircleFeedGrayPicReport", 4, "isGrey:true");
      QCircleQualityReporter.reportImageQualityEvent("imgae_show_grey", "", String.valueOf(0), "", 0, new List[] { paramString });
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, View paramView)
  {
    if (paramStFeed == null) {
      return;
    }
    try
    {
      if ((paramView instanceof QCircleInsFeedItemView))
      {
        a(paramStFeed, (QCircleInsFeedItemView)paramView);
        return;
      }
      if ((paramView instanceof FrameLayout))
      {
        a(paramStFeed, (FrameLayout)paramView);
        return;
      }
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedGreyPicReport
 * JD-Core Version:    0.7.0.1
 */