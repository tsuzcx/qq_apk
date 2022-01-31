package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import java.util.List;
import tqs;
import trt;
import tyj;

public class QCircleMessageNoticeView
  extends BaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private trt jdField_a_of_type_Trt;
  private LinearLayout b;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 2131560553;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.b = ((LinearLayout)paramView.findViewById(2131369660));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131362555));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378831));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369659));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject)
  {
    TextView localTextView;
    Context localContext;
    if ((paramObject instanceof trt))
    {
      this.jdField_a_of_type_Trt = ((trt)paramObject);
      if ((this.jdField_a_of_type_Trt.a() == null) || (this.jdField_a_of_type_Trt.a().size() <= 0)) {
        break label160;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(0);
      if (this.jdField_a_of_type_Trt.a().size() <= this.jdField_a_of_type_Int) {
        break label143;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Trt.a().subList(0, this.jdField_a_of_type_Int));
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localContext = getContext();
      if (this.jdField_a_of_type_Trt.a() <= 99) {
        break label172;
      }
    }
    label143:
    label160:
    label172:
    for (paramObject = "99+";; paramObject = String.valueOf(this.jdField_a_of_type_Trt.a()))
    {
      localTextView.setText(localContext.getString(2131698342, new Object[] { paramObject }));
      this.b.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Trt.a());
      break;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(8);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      tyj.a("", 18, 2L);
      if ((this.jdField_a_of_type_Trt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Trt.a()))) {
        tqs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Trt.a(), null);
      }
    } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
    postDelayed(new QCircleMessageNoticeView.1(this, paramView), 200L);
  }
  
  public void setAdapterListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView
 * JD-Core Version:    0.7.0.1
 */