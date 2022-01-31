package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import java.util.ArrayList;
import java.util.List;
import ueg;
import ueh;
import uei;
import yhy;
import yif;

public class QCirclePersonalBottomView
  extends BaseWidgetView<yif>
{
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  private QCirclePersonalDynamicFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment;
  private QCirclePersonalPushFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment;
  private QCircleFolderTabViewPager jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager;
  private List<QCirclePersonalBaseBottomFragment> jdField_a_of_type_JavaUtilList;
  private uei jdField_a_of_type_Uei;
  private yhy jdField_a_of_type_Yhy;
  private RadioButton b;
  
  public QCirclePersonalBottomView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePersonalBottomView(Context paramContext, yhy paramyhy)
  {
    this(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Yhy = paramyhy;
    setInteractor(paramyhy.getInteractor());
    b();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setOffscreenPageLimit(1);
    this.jdField_a_of_type_Uei = new uei(this, ((PublicFragmentActivity)paramContext).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.setAdapter(this.jdField_a_of_type_Uei);
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment = new QCirclePersonalDynamicFragment();
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment = new QCirclePersonalPushFragment();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDynamicFragment);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalPushFragment);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new ueg(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager.a(new ueh(this));
  }
  
  public int a()
  {
    return 2131560568;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)paramView.findViewById(2131375763));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)paramView.findViewById(2131365512));
    this.b = ((RadioButton)paramView.findViewById(2131372511));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFolderTabViewPager = ((QCircleFolderTabViewPager)paramView.findViewById(2131371730));
  }
  
  public void a(yif paramyif) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView
 * JD-Core Version:    0.7.0.1
 */