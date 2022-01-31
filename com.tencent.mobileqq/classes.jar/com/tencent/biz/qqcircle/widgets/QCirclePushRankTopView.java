package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import qqcircle.QQCircleDitto.StItemContainer;
import tql;
import ucf;

public class QCirclePushRankTopView
  extends BaseWidgetView<QQCircleDitto.StItemContainer>
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QCirclePushRankItemView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QCirclePushRankItemView b;
  QCirclePushRankItemView c;
  
  public QCirclePushRankTopView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131560570;
  }
  
  public void a(Context paramContext, View paramView)
  {
    int i = (int)(ImmersiveUtils.a() / 3 * 1.63F);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378881));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView = ((QCirclePushRankItemView)paramView.findViewById(2131373914));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131379215));
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, i));
    paramContext = tql.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    paramContext.mLoadingDrawable = getResources().getDrawable(2130849999);
    paramContext.mRequestWidth = ((int)(i * 1.21F));
    paramContext.mRequestHeight = i;
    tql.a("https://qzonestyle.gtimg.cn/aoi/sola/20200408162713_19QsjTEiOi.png", this.jdField_a_of_type_ComTencentImageURLImageView, paramContext, false);
    this.b = ((QCirclePushRankItemView)paramView.findViewById(2131373912));
    this.c = ((QCirclePushRankItemView)paramView.findViewById(2131373913));
    this.b.getLayoutParams().height = i;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView.getLayoutParams().height = (i - ImmersiveUtils.a(8.0F));
    this.c.getLayoutParams().height = (i - ImmersiveUtils.a(16.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ucf(this));
  }
  
  protected void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer != null)
    {
      if ((paramStItemContainer.items.size() > 0) && (this.b != null)) {
        this.b.setData(paramStItemContainer.items.get(0));
      }
      if ((paramStItemContainer.items.size() > 1) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView.setData(paramStItemContainer.items.get(1));
      }
      if ((paramStItemContainer.items.size() > 2) && (this.c != null)) {
        this.c.setData(paramStItemContainer.items.get(2));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStItemContainer.subTitle.get());
      }
    }
  }
  
  public void b(Context paramContext, int paramInt)
  {
    super.b(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView
 * JD-Core Version:    0.7.0.1
 */