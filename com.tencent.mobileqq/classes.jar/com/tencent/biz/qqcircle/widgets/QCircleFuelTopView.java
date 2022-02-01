package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetRankingListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetRankingListBusiRspData;

public class QCircleFuelTopView
  extends QCircleBaseWidgetView<FeedCloudRead.StGetRankingListRsp>
{
  private QCircleFuelRankItemView a;
  private QCircleFuelRankItemView b;
  private QCircleFuelRankItemView c;
  private RelativeLayout d;
  private TextView e;
  private List<FeedCloudCommon.Entry> f;
  private Part g;
  
  public QCircleFuelTopView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFuelTopView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleFuelTopView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    if ((paramQCircleExtraTypeInfo != null) && (paramQCircleExtraTypeInfo.mFeed != null))
    {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramQCircleExtraTypeInfo.mFeed)).setActionType(paramInt1).setSubActionType(paramInt2).setToUin(paramQCircleExtraTypeInfo.mFeed.poster.id.get()).setPosition(paramQCircleExtraTypeInfo.mDataPosition).setPlayScene(paramQCircleExtraTypeInfo.mPlayScene).setPageId(getPageId()).setfpageid(getParentPageId()));
      return;
    }
    paramQCircleExtraTypeInfo = new StringBuilder();
    paramQCircleExtraTypeInfo.append("extraTypeInfo is null or lost feed,actionType:");
    paramQCircleExtraTypeInfo.append(paramInt1);
    paramQCircleExtraTypeInfo.append(",subActionType:");
    paramQCircleExtraTypeInfo.append(paramInt2);
    QLog.e("QCircleReportHelper_QCircleFuelTopView", 1, paramQCircleExtraTypeInfo.toString());
  }
  
  protected void a(FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp, int paramInt)
  {
    Object localObject = paramStGetRankingListRsp.items.get();
    this.a.setRank(1);
    this.a.setData(localObject);
    this.a.setReportBean(getReportBean());
    this.a.setParentPart(this.g);
    this.b.setRank(2);
    this.b.setData(localObject);
    this.b.setReportBean(getReportBean());
    this.b.setParentPart(this.g);
    this.c.setRank(3);
    this.c.setData(localObject);
    this.c.setReportBean(getReportBean());
    this.c.setParentPart(this.g);
    localObject = new QQCircleFeedBase.StGetRankingListBusiRspData();
    try
    {
      ((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).mergeFrom(paramStGetRankingListRsp.busiRspData.get().toByteArray());
      this.f = ((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).urlInfo.get();
      this.e.setText(((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).rankName.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStGetRankingListRsp)
    {
      paramStGetRankingListRsp.printStackTrace();
    }
  }
  
  public int getLayoutId()
  {
    return 2131626836;
  }
  
  protected String getLogTag()
  {
    return "QCircleFuelTopView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QCircleFuelRankItemView)paramView.findViewById(2131441914));
    this.b = ((QCircleFuelRankItemView)paramView.findViewById(2131441916));
    this.c = ((QCircleFuelRankItemView)paramView.findViewById(2131441915));
    this.d = ((RelativeLayout)paramView.findViewById(2131437533));
    this.e = ((TextView)paramView.findViewById(2131448481));
    this.d.setOnClickListener(new QCircleFuelTopView.1(this));
  }
  
  public void setParentPart(Part paramPart)
  {
    this.g = paramPart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelTopView
 * JD-Core Version:    0.7.0.1
 */