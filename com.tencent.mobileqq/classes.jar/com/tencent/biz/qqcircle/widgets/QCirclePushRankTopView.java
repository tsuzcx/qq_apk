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
import uxh;
import vrf;
import vxu;
import vxv;
import vxw;

public class QCirclePushRankTopView
  extends QCircleBaseWidgetView<QQCircleDitto.StCircleDittoDataNew>
{
  private int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleMultiPicViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager;
  private QCirclePushRankIndicator jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator;
  private List<QQCircleDitto.StItemContainer> jdField_a_of_type_JavaUtilList;
  private vxw jdField_a_of_type_Vxw;
  private byte[] jdField_a_of_type_ArrayOfByte;
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
    View localView = LayoutInflater.from(getContext()).inflate(2131560770, null);
    int i = (int)(ImmersiveUtils.a() / 3 * 1.63F);
    QCirclePushRankItemView localQCirclePushRankItemView = (QCirclePushRankItemView)localView.findViewById(2131374687);
    Object localObject1 = (URLImageView)localView.findViewById(2131380200);
    ((URLImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-2, i));
    Object localObject2 = uxh.b((URLImageView)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getResources().getDrawable(2130850664);
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((int)(i * 1.21F));
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    uxh.a("https://sola.gtimg.cn/aoi/sola/20200420155146_yymB24gjPe.png", (URLImageView)localObject1, (URLDrawable.URLDrawableOptions)localObject2, false);
    localObject1 = (QCirclePushRankItemView)localView.findViewById(2131374685);
    localObject2 = (QCirclePushRankItemView)localView.findViewById(2131374686);
    ((QCirclePushRankItemView)localObject1).setReportBean(a());
    localQCirclePushRankItemView.setReportBean(a());
    ((QCirclePushRankItemView)localObject2).setReportBean(a());
    if (paramStItemContainer != null)
    {
      if ((paramStItemContainer.items.size() > 0) && (localObject1 != null))
      {
        ((QCirclePushRankItemView)localObject1).setRank(1);
        ((QCirclePushRankItemView)localObject1).setReportInfo(this.jdField_a_of_type_ArrayOfByte);
        ((QCirclePushRankItemView)localObject1).setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 1) && (localQCirclePushRankItemView != null))
      {
        localQCirclePushRankItemView.setRank(2);
        ((QCirclePushRankItemView)localObject1).setReportInfo(this.jdField_a_of_type_ArrayOfByte);
        localQCirclePushRankItemView.setData(paramStItemContainer);
      }
      if ((paramStItemContainer.items.size() > 2) && (localObject2 != null))
      {
        ((QCirclePushRankItemView)localObject2).setRank(3);
        ((QCirclePushRankItemView)localObject1).setReportInfo(this.jdField_a_of_type_ArrayOfByte);
        ((QCirclePushRankItemView)localObject2).setData(paramStItemContainer);
      }
    }
    return localView;
  }
  
  private void a(QQCircleDitto.StItemContainer paramStItemContainer)
  {
    if (paramStItemContainer == null) {
      return;
    }
    this.b.setText(paramStItemContainer.title.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vxv(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStItemContainer.subTitle.get());
    }
    vrf.a("", 9, 1, 0, paramStItemContainer.containerType.get() + "", "", "", "", "", this.jdField_a_of_type_ArrayOfByte, d(), -1);
  }
  
  public int a()
  {
    return 2131560771;
  }
  
  protected String a()
  {
    return "QCirclePushRankTopView";
  }
  
  public void a(Context paramContext, int paramInt)
  {
    super.a(paramContext, paramInt);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager = ((QCircleMultiPicViewPager)paramView.findViewById(2131373159));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131373157));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379830));
    this.b = ((TextView)paramView.findViewById(2131369239));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369237));
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
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.removeAllViews();
        a((QQCircleDitto.StItemContainer)this.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_Vxw = new vxw(this, getContext(), paramStCircleDittoDataNew);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setAdapter(this.jdField_a_of_type_Vxw);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setCurrentItem(this.jdField_a_of_type_Vxw.a(), false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator = new QCirclePushRankIndicator(getContext(), paramStCircleDittoDataNew.size());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankIndicator);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleMultiPicViewPager.setOnPageChangeListener(new vxu(this));
      }
    }
  }
  
  protected String b()
  {
    return "toplist_container";
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView
 * JD-Core Version:    0.7.0.1
 */