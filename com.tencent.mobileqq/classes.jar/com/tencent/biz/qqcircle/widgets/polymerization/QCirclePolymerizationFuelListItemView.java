package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoot;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRankinglist.RankingItem;
import uyx;
import uzg;

public class QCirclePolymerizationFuelListItemView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private QQCircleRankinglist.RankingItem jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem;
  private TextView b;
  
  public QCirclePolymerizationFuelListItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560816;
  }
  
  public String a()
  {
    return "QCircleFuelListItemView";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130844089);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844088);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130844091);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844090);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130844093);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844092);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376804));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377770));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380178));
    this.b = ((TextView)paramView.findViewById(2131379859));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370225));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369340));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof QQCircleRankinglist.RankingItem)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem = ((QQCircleRankinglist.RankingItem)paramObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(aoot.a(((BaseActivity)getContext()).app, 1, 4, this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem.user.id.get()));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem.user.nick.get());
    this.b.setText(uzg.d(this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem.score.get()));
    a(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem != null)
      {
        QCircleInitBean localQCircleInitBean = new QCircleInitBean();
        localQCircleInitBean.setUin(this.jdField_a_of_type_QqcircleQQCircleRankinglist$RankingItem.user.id.get());
        localQCircleInitBean.setFromReportBean(a());
        uyx.b(getContext(), localQCircleInitBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.polymerization.QCirclePolymerizationFuelListItemView
 * JD-Core Version:    0.7.0.1
 */