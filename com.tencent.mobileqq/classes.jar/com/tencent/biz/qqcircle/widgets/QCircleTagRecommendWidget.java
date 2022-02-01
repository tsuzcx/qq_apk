package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCircleTagRecommendWidget
  extends QCircleBaseWidgetView
{
  private ImageView a;
  private TextView b;
  private RecyclerView c;
  private QCircleRecommendBaseAdapter d;
  private RecyclerView.LayoutManager e;
  private QQCircleDitto.StItemContainer f;
  private QCircleExtraTypeInfo g = new QCircleExtraTypeInfo();
  
  public QCircleTagRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof FeedBlockData)) {
      return;
    }
    paramObject = (FeedBlockData)paramObject;
    FeedCloudMeta.StFeed localStFeed = paramObject.b();
    FeedCloudMeta.StDittoFeed localStDittoFeed = (FeedCloudMeta.StDittoFeed)localStFeed.dittoFeed.get();
    this.g.mFeed = paramObject.b();
    Object localObject = this.g;
    ((QCircleExtraTypeInfo)localObject).mPlayScene = 1;
    ((QCircleExtraTypeInfo)localObject).mDataPosition = paramInt;
    this.f = new QQCircleDitto.StItemContainer();
    localObject = new QCircleTagRecommendWidget.QCircleTagRecommendAdapter(this);
    try
    {
      if ((paramObject.a("DITTO_MAY_INTEREST_SMALL_WORLD") instanceof QQCircleDitto.StItemContainer))
      {
        this.f = ((QQCircleDitto.StItemContainer)paramObject.a("DITTO_MAY_INTEREST_SMALL_WORLD"));
        QLog.d("QCircleTagPageRecommendWidget", 1, "get data from blockData");
      }
      else
      {
        this.f.mergeFrom(localStDittoFeed.dittoData.get().toByteArray());
        QLog.d("QCircleTagPageRecommendWidget", 1, "get data from merge data");
      }
      this.c.removeAllViews();
      ((QCircleTagRecommendWidget.QCircleTagRecommendAdapter)localObject).a(this);
      ((QCircleTagRecommendWidget.QCircleTagRecommendAdapter)localObject).a(this.c);
      ((QCircleTagRecommendWidget.QCircleTagRecommendAdapter)localObject).a(localStFeed, paramInt, this.f.items.get());
      ((QCircleTagRecommendWidget.QCircleTagRecommendAdapter)localObject).a(this.f);
      this.d = ((QCircleRecommendBaseAdapter)localObject);
      this.c.setAdapter(this.d);
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(localStFeed).setToUin(localStFeed.id.get()).setFeedType1(3).setFeedType2(3).setActionType(97).setSubActionType(1).setIndex(1).setContainerSeq(0).setPageId(getPageId())));
      QLog.d("QCircleTagPageRecommendWidget", 1, new Object[] { "bind dittoFeed pos:", Integer.valueOf(paramInt), ",item size:", Integer.valueOf(this.f.items.size()) });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("QCircleTagPageRecommendWidget", 1, new Object[] { "bindData Exception:", paramObject.toString() });
    }
  }
  
  public int getLayoutId()
  {
    return 2131626972;
  }
  
  protected String getLogTag()
  {
    return "QCircleTagPageRecommendWidget";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.a = ((ImageView)paramView.findViewById(2131440970));
      this.b = ((TextView)paramView.findViewById(2131440971));
      QCircleTagRecommendWidget.1 local1 = new QCircleTagRecommendWidget.1(this);
      this.a.setOnClickListener(local1);
      this.b.setOnClickListener(local1);
      this.c = ((RecyclerView)paramView.findViewById(2131440968));
      this.e = new SafeLinearLayoutManager(paramContext, 0, false);
      this.c.setLayoutManager(this.e);
      this.d = new QCircleTagRecommendWidget.QCircleTagRecommendAdapter(this);
      this.c.setAdapter(this.d);
      this.d.a(this);
      this.d.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagRecommendWidget
 * JD-Core Version:    0.7.0.1
 */