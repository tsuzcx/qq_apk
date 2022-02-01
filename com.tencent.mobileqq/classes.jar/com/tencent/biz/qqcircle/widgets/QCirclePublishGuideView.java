package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StPicTextBanner;

public class QCirclePublishGuideView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private RoundCornerImageView a;
  private FrameLayout b;
  private TextView c;
  private TextView d;
  private Button e;
  private QQCircleDitto.StPicTextBanner f;
  private FrameLayout g;
  
  public QCirclePublishGuideView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePublishGuideView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePublishGuideView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    float f1 = ViewUtils.b();
    float f2 = f1 / 2.25F + ViewUtils.a(12.0F);
    if ((f1 > 0.0F) && (f2 > 0.0F))
    {
      localObject = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.a.getLayoutParams();
      float f3 = f1 - ViewUtils.a(24.0F);
      ((FrameLayout.LayoutParams)localObject).width = ((int)f3);
      ((FrameLayout.LayoutParams)localObject).height = ((int)(f3 / 2.25F));
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init width and height :");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(f2);
    QLog.d("QCirclePublishGuideView", 1, ((StringBuilder)localObject).toString());
  }
  
  private void b()
  {
    Option localOption = new Option().setTargetView(this.a).setUrl(this.f.backgroundImage.picUrl.get()).setRequestWidth(this.a.getLayoutParams().width).setRequestHeight(this.a.getLayoutParams().height);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getLayoutParams().width);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.a.getLayoutParams().height);
    localStringBuilder.append("  ");
    localStringBuilder.append(this.a.getWidth());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.a.getHeight());
    QLog.d("QCirclePublishGuideView", 4, localStringBuilder.toString());
    QCircleFeedPicLoader.g().loadImage(localOption, new QCirclePublishGuideView.1(this));
  }
  
  private void c()
  {
    if (getLayoutParams() != null) {
      getLayoutParams().height = 0;
    }
    setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (getReportBean() != null)
    {
      if (this.f == null) {
        return;
      }
      String str = String.valueOf(QCircleCommonUtil.getCurrentAccountLongUin());
      if (getReportBean().getPageId() == 3)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(str).setActionType(23).setSubActionType(5).setThrActionType(paramInt).setExt6(this.f.banner_id.get()));
        return;
      }
      if (getReportBean().getPageId() == 1) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(str).setActionType(22).setSubActionType(16).setThrActionType(paramInt).setExt6(this.f.banner_id.get()));
      }
    }
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof FeedBlockData)) {
      return;
    }
    FeedBlockData localFeedBlockData = (FeedBlockData)paramObject;
    FeedCloudMeta.StFeed localStFeed = localFeedBlockData.b();
    try
    {
      paramObject = new QQCircleDitto.StCircleDittoDataNew();
      boolean bool = localFeedBlockData.a("DITTO_GUIDE_PUBLISH_BANNER") instanceof QQCircleDitto.StCircleDittoDataNew;
      if (bool)
      {
        paramObject = (QQCircleDitto.StCircleDittoDataNew)localFeedBlockData.a("DITTO_GUIDE_PUBLISH_BANNER");
        QLog.d("QCirclePublishGuideView", 2, "get data form blockData");
      }
      else
      {
        paramObject.mergeFrom(localStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        QLog.d("QCirclePublishGuideView", 2, "get data form mergerData");
      }
      this.f = ((QQCircleDitto.StPicTextBanner)paramObject.picTextBanner.get());
      if (this.f.banner_id.get().equals(QCirclePluginGlobalInfo.i()))
      {
        c();
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("title: ");
      paramObject.append(this.f.title.get());
      paramObject.append("content:");
      paramObject.append(this.f.content.get());
      QLog.d("QCirclePublishGuideView", 1, paramObject.toString());
      if (this.f.buttons.get().size() > 0) {
        this.e.setText(((QQCircleDitto.StButton)this.f.buttons.get(0)).name.get());
      }
      this.c.setText(this.f.title.get());
      this.d.setText(this.f.content.get());
      paramObject = new StringBuilder();
      paramObject.append("background url: ");
      paramObject.append(this.f.backgroundImage.picUrl.get());
      QLog.d("QCirclePublishGuideView", 1, paramObject.toString());
      b();
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626928;
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(1);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131441805)
    {
      a(3);
      c();
      QQCircleDitto.StPicTextBanner localStPicTextBanner = this.f;
      if (localStPicTextBanner != null) {
        QCirclePluginGlobalInfo.e(localStPicTextBanner.banner_id.get());
      }
    }
    else if ((i == 2131441802) || (i == 2131441804))
    {
      a(2);
      if (this.f != null) {
        QCircleLauncher.a(getContext(), this.f.actionUrl.get());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((RoundCornerImageView)paramView.findViewById(2131441803));
    this.b = ((FrameLayout)paramView.findViewById(2131441805));
    this.c = ((TextView)paramView.findViewById(2131441809));
    this.d = ((TextView)paramView.findViewById(2131441806));
    this.e = ((Button)paramView.findViewById(2131441802));
    this.g = ((FrameLayout)paramView.findViewById(2131441804));
    this.a.setCorner(36);
    if (QCircleCommonUtil.isInNightMode()) {
      this.a.setAlpha(0.6F);
    }
    this.e.setPadding(ViewUtils.a(25.0F), ViewUtils.a(6.0F), ViewUtils.a(25.0F), ViewUtils.a(6.0F));
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePublishGuideView
 * JD-Core Version:    0.7.0.1
 */