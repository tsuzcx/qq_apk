package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleCommonClick;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StTagMedalInfo;
import feedcloud.FeedCloudMeta.StUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;
import qqcircle.QQCircleRankinglist.RankingItem;

public class QCirclePolymerizationFuelListItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private RelativeLayout a;
  private SquareImageView b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private ImageView f;
  private QQCircleRankinglist.RankingItem g;
  private SquareImageView h;
  private QCirclePolymerizationBean i;
  
  static {}
  
  public QCirclePolymerizationFuelListItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(SquareImageView paramSquareImageView, FeedCloudMeta.StUser paramStUser)
  {
    String str = paramStUser.icon.iconUrl.get();
    if (!TextUtils.isEmpty(str))
    {
      QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(paramSquareImageView).setUrl(str), null);
      return;
    }
    paramSquareImageView.setImageDrawable(HostFaceUtils.getFaceDrawable(1, 4, paramStUser.id.get()));
  }
  
  private void a(QQCircleRankinglist.RankingItem paramRankingItem)
  {
    if (this.h == null) {
      return;
    }
    if (paramRankingItem.user.medal.has())
    {
      QCircleFeedPicLoader.g().loadImage(new Option().setUrl(QCircleConfigHelper.x()).setTargetView(this.h), null);
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.e.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845450));
        this.f.setImageResource(2130845282);
        return;
      }
      this.e.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845449));
      this.f.setImageResource(2130845281);
      return;
    }
    this.e.setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845448));
    this.f.setImageResource(2130845280);
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof QQCircleRankinglist.RankingItem)) {
      return;
    }
    this.g = ((QQCircleRankinglist.RankingItem)paramObject);
    a(this.b, this.g.user);
    this.c.setText(this.g.user.nick.get());
    this.d.setText(QCirclePluginUtil.d(this.g.score.get()));
    a(this.g);
    a(paramInt);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(4).setThrActionType(1).setExt6(String.valueOf(this.i.getPolymerizationName())).setExt7(this.g.user.nick.get()).setPageId(getPageId()));
  }
  
  public int getLayoutId()
  {
    return 2131626974;
  }
  
  protected String getLogTag()
  {
    return "QCircleFuelListItemView";
  }
  
  @QCircleCommonClick
  public void onClick(View paramView)
  {
    JoinPoint localJoinPoint = Factory.makeJP(j, this, this, paramView);
    a(this, paramView, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((RelativeLayout)paramView.findViewById(2131444972));
    this.b = ((SquareImageView)paramView.findViewById(2131446047));
    this.c = ((TextView)paramView.findViewById(2131448852));
    this.d = ((TextView)paramView.findViewById(2131448480));
    this.e = ((LinearLayout)paramView.findViewById(2131437532));
    this.f = ((ImageView)paramView.findViewById(2131436525));
    this.h = ((SquareImageView)paramView.findViewById(2131435247));
    this.a.setOnClickListener(this);
  }
  
  public void setInitBean(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.i = paramQCirclePolymerizationBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListItemView
 * JD-Core Version:    0.7.0.1
 */