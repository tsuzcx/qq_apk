package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudRead.StGetRankingListRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase.StGetRankingListBusiRspData;
import vxh;
import zxj;

public class QCircleFuelTopView
  extends QCircleBaseWidgetView<FeedCloudRead.StGetRankingListRsp>
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleFuelRankItemView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView;
  private List<FeedCloudCommon.Entry> jdField_a_of_type_JavaUtilList;
  private zxj jdField_a_of_type_Zxj;
  private QCircleFuelRankItemView b;
  private QCircleFuelRankItemView c;
  
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
  
  public int a()
  {
    return 2131560719;
  }
  
  protected String a()
  {
    return "QCircleFuelTopView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView = ((QCircleFuelRankItemView)paramView.findViewById(2131373949));
    this.b = ((QCircleFuelRankItemView)paramView.findViewById(2131373951));
    this.c = ((QCircleFuelRankItemView)paramView.findViewById(2131373950));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370127));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379682));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new vxh(this));
  }
  
  public void a(FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp)
  {
    Object localObject = paramStGetRankingListRsp.items.get();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.setRank(1);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.setData(localObject);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.setReportBean(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelRankItemView.setParentPart(this.jdField_a_of_type_Zxj);
    this.b.setRank(2);
    this.b.setData(localObject);
    this.b.setReportBean(a());
    this.b.setParentPart(this.jdField_a_of_type_Zxj);
    this.c.setRank(3);
    this.c.setData(localObject);
    this.c.setReportBean(a());
    this.c.setParentPart(this.jdField_a_of_type_Zxj);
    localObject = new QQCircleFeedBase.StGetRankingListBusiRspData();
    try
    {
      ((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).mergeFrom(paramStGetRankingListRsp.busiRspData.get().toByteArray());
      this.jdField_a_of_type_JavaUtilList = ((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).urlInfo.get();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((QQCircleFeedBase.StGetRankingListBusiRspData)localObject).rankName.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStGetRankingListRsp)
    {
      paramStGetRankingListRsp.printStackTrace();
    }
  }
  
  public void setParentPart(zxj paramzxj)
  {
    this.jdField_a_of_type_Zxj = paramzxj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFuelTopView
 * JD-Core Version:    0.7.0.1
 */