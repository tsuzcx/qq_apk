package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;

public class QFSAggregationFeedItemView
  extends QCircleBaseWidgetView<FeedBlockData>
{
  private ImageView a;
  private TextView b;
  private String c;
  
  public QFSAggregationFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (TextUtils.equals(this.c, ((FeedBlockData)getData()).b().cover.picUrl.get())) {
      return;
    }
    this.a.setImageDrawable(null);
    this.c = ((FeedBlockData)getData()).b().cover.picUrl.get();
    Option localOption = new Option().setUrl(this.c).setTargetView(this.a);
    localOption.setLoadingDrawable(new ColorDrawable(getResources().getColor(2131166091)));
    QCircleFeedPicLoader.g().loadImage(localOption, null);
  }
  
  private void b()
  {
    String str = QCirclePluginUtil.d(((FeedBlockData)getData()).b().likeInfo.count.get());
    this.b.setText(str);
  }
  
  protected void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return;
      }
      a();
      b();
    }
  }
  
  public int getLayoutId()
  {
    return 2131627111;
  }
  
  protected String getLogTag()
  {
    return "QFSAggregationFeedItemView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ImageView)paramView.findViewById(2131436371));
    this.b = ((TextView)paramView.findViewById(2131448619));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) * 4 / 3, 1073741824));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationFeedItemView
 * JD-Core Version:    0.7.0.1
 */