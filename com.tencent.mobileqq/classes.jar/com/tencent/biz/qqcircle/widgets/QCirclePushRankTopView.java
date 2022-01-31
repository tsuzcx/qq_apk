package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StItemContainer;
import tql;
import uey;
import uez;
import ufa;

public class QCirclePushRankTopView
  extends BaseWidgetView<QQCircleDitto.StCircleDittoDataNew>
{
  private int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private QCircleMultiPicViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager;
  private QCirclePushRankIndicator jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator;
  private List<QQCircleDitto.StItemContainer> jdField_a_of_type_JavaUtilList;
  private ufa jdField_a_of_type_Ufa;
  TextView b;
  
  public QCirclePushRankTopView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return null;
    }
    View localView = LayoutInflater.from(getContext()).inflate(2131560585, null);
    int i = (int)(ImmersiveUtils.a() / 3 * 1.63F);
    QCirclePushRankItemView localQCirclePushRankItemView = (QCirclePushRankItemView)localView.findViewById(2131373965);
    Object localObject1 = (URLImageView)localView.findViewById(2131379273);
    ((URLImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-2, i));
    Object localObject2 = tql.b((URLImageView)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getResources().getDrawable(2130850072);
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)(i * 1.21F));
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    tql.a("https://sola.gtimg.cn/aoi/sola/20200420155146_yymB24gjPe.png", (URLImageView)localObject1, (URLDrawable.URLDrawableOptions)localObject2, false);
    localObject1 = (QCirclePushRankItemView)localView.findViewById(2131373963);
    localObject2 = (QCirclePushRankItemView)localView.findViewById(2131373964);
    if (paramStItemContainer != null)
    {
      if ((paramStItemContainer.items.size() > 0) && (localObject1 != null))
      {
        ((QCirclePushRankItemView)localObject1).setRank(1);
        ((QCirclePushRankItemView)localObject1).setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 1) && (localQCirclePushRankItemView != null))
      {
        localQCirclePushRankItemView.setRank(2);
        localQCirclePushRankItemView.setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 2) && (localObject2 != null))
      {
        ((QCirclePushRankItemView)localObject2).setRank(3);
        ((QCirclePushRankItemView)localObject2).setData(paramStItemContainer);
      }
    }
    return localView;
  }
  
  private void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    this.b.setText(paramStItemContainer.title.get());
    switch (paramStItemContainer.containerType.get())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new uez(this));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843688);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843685);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843686);
    }
  }
  
  public int a()
  {
    return 2131560586;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager = ((QCircleMultiPicViewPager)paramView.findViewById(2131372548));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372546));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378938));
    this.b = ((TextView)paramView.findViewById(2131368873));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368872));
  }
  
  protected void a(QQCircleDitto.StCircleDittoDataNew paramStCircleDittoDataNew)
  {
    if ((paramStCircleDittoDataNew != null) && (paramStCircleDittoDataNew.multiItemContainter != null))
    {
      this.jdField_a_of_type_JavaUtilList = paramStCircleDittoDataNew.multiItemContainter.get();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        paramStCircleDittoDataNew = new ArrayList();
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (this.jdField_a_of_type_JavaUtilList.get(i) != null) {
            paramStCircleDittoDataNew.add(a((QQCircleDitto.StItemContainer)this.jdField_a_of_type_JavaUtilList.get(i)));
          }
          i += 1;
        }
        this.jdField_a_of_type_Int = 0;
        a((QQCircleDitto.StItemContainer)this.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_Ufa = new ufa(this, getContext(), paramStCircleDittoDataNew);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setAdapter(this.jdField_a_of_type_Ufa);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator = new QCirclePushRankIndicator(getContext(), paramStCircleDittoDataNew.size());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setOnPageChangeListener(new uey(this));
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