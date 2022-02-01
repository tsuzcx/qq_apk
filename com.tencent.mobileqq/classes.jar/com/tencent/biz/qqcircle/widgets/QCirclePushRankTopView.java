package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.richframework.widget.MultiPicViewPager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StItemContainer;

public class QCirclePushRankTopView
  extends QCircleBaseWidgetView
{
  TextView a;
  TextView b;
  ImageView c;
  private MultiPicViewPager d;
  private QCirclePushRankTopView.QCircleRankAdapter e;
  private QCirclePushRankIndicator f;
  private LinearLayout g;
  private int h = 0;
  private List<QQCircleDitto.StItemContainer> i;
  private byte[] j;
  
  public QCirclePushRankTopView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return null;
    }
    try
    {
      localObject = LayoutInflater.from(getContext()).inflate(2131626942, null);
      QCirclePushRankItemView localQCirclePushRankItemView1 = (QCirclePushRankItemView)((View)localObject).findViewById(2131442904);
      QCirclePushRankItemView localQCirclePushRankItemView2 = (QCirclePushRankItemView)((View)localObject).findViewById(2131442902);
      QCirclePushRankItemView localQCirclePushRankItemView3 = (QCirclePushRankItemView)((View)localObject).findViewById(2131442903);
      localQCirclePushRankItemView2.setReportBean(getReportBean());
      localQCirclePushRankItemView1.setReportBean(getReportBean());
      localQCirclePushRankItemView3.setReportBean(getReportBean());
      if (paramStItemContainer != null)
      {
        if ((paramStItemContainer.items.size() > 0) && (localQCirclePushRankItemView2 != null))
        {
          localQCirclePushRankItemView2.setRank(1);
          localQCirclePushRankItemView2.setReportInfo(this.j);
          localQCirclePushRankItemView2.setData(paramStItemContainer);
        }
        if ((paramStItemContainer.items.size() > 1) && (localQCirclePushRankItemView1 != null))
        {
          localQCirclePushRankItemView1.setRank(2);
          localQCirclePushRankItemView2.setReportInfo(this.j);
          localQCirclePushRankItemView1.setData(paramStItemContainer);
        }
        if ((paramStItemContainer.items.size() > 2) && (localQCirclePushRankItemView3 != null))
        {
          localQCirclePushRankItemView3.setRank(3);
          localQCirclePushRankItemView2.setReportInfo(this.j);
          localQCirclePushRankItemView3.setData(paramStItemContainer);
        }
      }
      return localObject;
    }
    catch (Throwable paramStItemContainer)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRankView error:");
      ((StringBuilder)localObject).append(paramStItemContainer.toString());
      QLog.e("QCirclePushRankTopView", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void b(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return;
    }
    this.b.setText(paramStItemContainer.title.get());
    Object localObject = this.a;
    if (localObject != null)
    {
      ((TextView)localObject).setOnClickListener(new QCirclePushRankTopView.1(this));
      this.a.setText(paramStItemContainer.subTitle.get());
    }
    localObject = new QCircleLpReportDc05504.DataBuilder().setActionType(9).setSubActionType(1).setThrActionType(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStItemContainer.containerType.get());
    localStringBuilder.append("");
    QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1(localStringBuilder.toString()).setFeedReportInfo(this.j).setPageId(getPageId()));
  }
  
  protected void beforeInflateView(Context paramContext, int paramInt)
  {
    super.beforeInflateView(paramContext, paramInt);
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew;
    if ((paramObject instanceof FeedBlockData))
    {
      localStFeed = ((FeedBlockData)paramObject).b();
      setReportInfo(localStFeed.busiReport.get().toByteArray());
      localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(9).setSubActionType(1).setThrActionType(0).setPageId(getPageId()));
    }
    for (;;)
    {
      try
      {
        boolean bool = ((FeedBlockData)paramObject).a("DITTO_FUEL_RANK") instanceof QQCircleDitto.StCircleDittoDataNew;
        if (bool)
        {
          paramObject = (QQCircleDitto.StCircleDittoDataNew)((FeedBlockData)paramObject).a("DITTO_FUEL_RANK");
          QLog.d("QCirclePushRankTopView", 1, "get data form blockData");
        }
        else
        {
          localStCircleDittoDataNew.mergeFrom(localStFeed.dittoFeed.dittoDataNew.get().toByteArray());
          QLog.d("QCirclePushRankTopView", 1, "get data form mergerData");
          paramObject = localStCircleDittoDataNew;
        }
        if ((paramObject.get() != null) && (paramObject.multiItemContainter.get() != null))
        {
          this.i = paramObject.multiItemContainter.get();
          if ((this.i != null) && (this.i.size() > 0))
          {
            paramObject = new ArrayList();
            paramInt = 0;
            if (paramInt < this.i.size())
            {
              if (this.i.get(paramInt) == null) {
                break label395;
              }
              paramObject.add(a((QQCircleDitto.StItemContainer)this.i.get(paramInt)));
              break label395;
            }
            this.h = 0;
            this.d.removeAllViews();
            b((QQCircleDitto.StItemContainer)this.i.get(0));
            this.e = new QCirclePushRankTopView.QCircleRankAdapter(this, getContext(), paramObject);
            this.d.setAdapter(this.e);
            this.d.setCurrentItem(this.e.b(), false);
            this.g.removeAllViews();
            this.f = new QCirclePushRankIndicator(getContext(), paramObject.size());
            this.g.addView(this.f);
            this.d.setOnPageChangeListener(new QCirclePushRankTopView.PushRankTopViewPagerListener(this));
            return;
          }
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      return;
      label395:
      paramInt += 1;
    }
  }
  
  public int getLayoutId()
  {
    return 2131626943;
  }
  
  protected String getLogTag()
  {
    return "QCirclePushRankTopView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.d = ((MultiPicViewPager)paramView.findViewById(2131440950));
    this.g = ((LinearLayout)paramView.findViewById(2131440948));
    this.a = ((TextView)paramView.findViewById(2131448667));
    this.b = ((TextView)paramView.findViewById(2131436511));
    this.c = ((ImageView)paramView.findViewById(2131436509));
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.j = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView
 * JD-Core Version:    0.7.0.1
 */