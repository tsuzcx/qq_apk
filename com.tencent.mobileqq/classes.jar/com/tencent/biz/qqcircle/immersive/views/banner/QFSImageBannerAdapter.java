package com.tencent.biz.qqcircle.immersive.views.banner;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;

public class QFSImageBannerAdapter
  extends RecyclerView.Adapter<QFSImageBannerAdapter.QFSImageBannerVH>
{
  private int a = 0;
  private FeedCloudMeta.StFeed b;
  private boolean c = true;
  private int d = 2;
  private QCircleReportBean e;
  private IQFSFeedIoc f;
  private int g;
  
  public int a()
  {
    return this.a;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == a()) {
      i = 0;
    }
    return i;
  }
  
  @NonNull
  public QFSImageBannerAdapter.QFSImageBannerVH a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new QCircleContentImage(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    return new QFSImageBannerAdapter.QFSImageBannerVH(paramViewGroup);
  }
  
  public void a(IQFSFeedIoc paramIQFSFeedIoc)
  {
    this.f = paramIQFSFeedIoc;
  }
  
  public void a(@NonNull QFSImageBannerAdapter.QFSImageBannerVH paramQFSImageBannerVH, int paramInt)
  {
    if (this.b == null) {
      return;
    }
    if (paramQFSImageBannerVH.a != null)
    {
      paramQFSImageBannerVH.a.setDataPosInList(a(paramInt));
      paramQFSImageBannerVH.a.setData(new FeedBlockData(this.b));
      paramQFSImageBannerVH.a.b(paramInt);
      paramQFSImageBannerVH.a.setVerticalPos(this.g);
      paramQFSImageBannerVH.a.setIQFSFeedIoc(this.f);
      paramQFSImageBannerVH.a.setSelected(true);
      paramQFSImageBannerVH.a.a(paramInt);
      paramQFSImageBannerVH.a.setPlayScene(this.d);
      paramQFSImageBannerVH.a.setReportBean(this.e);
      paramQFSImageBannerVH.a.setMeasureWidth(ImmersiveUtils.getScreenWidth());
      paramQFSImageBannerVH.a.setMeasureHeight(ImmersiveUtils.getScreenHeight());
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.e = paramQCircleReportBean;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.b = paramStFeed;
    this.a = 0;
    paramStFeed = this.b;
    if (paramStFeed != null) {
      this.a = paramStFeed.images.size();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public boolean c()
  {
    return (this.a > 1) && (this.c);
  }
  
  public int getItemCount()
  {
    if (c()) {
      return this.a + 1;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBannerAdapter
 * JD-Core Version:    0.7.0.1
 */