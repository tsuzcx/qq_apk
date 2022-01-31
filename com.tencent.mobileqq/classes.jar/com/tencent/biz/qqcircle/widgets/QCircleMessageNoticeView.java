package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tqs;
import try;
import tzv;

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
  private try jdField_a_of_type_Try;
  private LinearLayout b;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 2131560561;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.b = ((LinearLayout)paramView.findViewById(2131369679));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131362555));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378886));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369678));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject)
  {
    TextView localTextView;
    Context localContext;
    if ((paramObject instanceof try))
    {
      this.jdField_a_of_type_Try = ((try)paramObject);
      if ((this.jdField_a_of_type_Try.a() == null) || (this.jdField_a_of_type_Try.a().size() <= 0)) {
        break label191;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(0);
      if (this.jdField_a_of_type_Try.a().size() <= this.jdField_a_of_type_Int) {
        break label174;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Try.a().subList(0, this.jdField_a_of_type_Int));
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "bindData count" + this.jdField_a_of_type_Try.a());
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localContext = getContext();
      if (this.jdField_a_of_type_Try.a() <= 99) {
        break label203;
      }
    }
    label174:
    label191:
    label203:
    for (paramObject = "99+";; paramObject = String.valueOf(this.jdField_a_of_type_Try.a()))
    {
      localTextView.setText(localContext.getString(2131698354, new Object[] { paramObject }));
      this.b.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Try.a());
      break;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(8);
      break;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "onAttachedToWindow");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      tzv.a("", 18, 2L);
      tqs.c(null);
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