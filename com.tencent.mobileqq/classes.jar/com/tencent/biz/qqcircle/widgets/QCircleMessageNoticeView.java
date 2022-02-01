package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import uyx;
import vbb;
import vjo;
import vtq;

public class QCircleMessageNoticeView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView;
  private vbb jdField_a_of_type_Vbb;
  private LinearLayout b;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 2131560752;
  }
  
  protected String a()
  {
    return "QCircleMessage_QCircleMessageNoticeView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.b = ((LinearLayout)paramView.findViewById(2131370200));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView = ((QCircleAvatarListView)paramView.findViewById(2131362666));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379946));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370199));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof vbb))
    {
      this.jdField_a_of_type_Vbb = ((vbb)paramObject);
      paramObject = this.jdField_a_of_type_Vbb.a();
      if ((paramObject == null) || (paramObject.size() <= 0)) {
        break label189;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setVisibility(0);
      if (paramObject.size() <= this.jdField_a_of_type_Int) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setData(paramObject.subList(0, this.jdField_a_of_type_Int));
    }
    for (;;)
    {
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "bindData allUnReadCount:" + this.jdField_a_of_type_Vbb.c() + " messageUnReadCount:" + this.jdField_a_of_type_Vbb.a() + " chatUnReadCount:" + this.jdField_a_of_type_Vbb.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getString(2131697272, new Object[] { vjo.a(this.jdField_a_of_type_Vbb.c()) }));
      this.b.setVisibility(0);
      return;
      label178:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setData(paramObject);
      continue;
      label189:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setVisibility(8);
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
    QCircleInitBean localQCircleInitBean;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vtq.a("", 18, 2);
      localQCircleInitBean = new QCircleInitBean();
    } while (this.jdField_a_of_type_Vbb == null);
    if (this.jdField_a_of_type_Vbb.a() > 0)
    {
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to messageList page");
      localQCircleInitBean.setLaunchTo(0);
    }
    for (;;)
    {
      localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("msg"));
      uyx.f(getContext(), localQCircleInitBean);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      break;
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to chatList page");
      localQCircleInitBean.setLaunchTo(1);
    }
  }
  
  public void setAdapterListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView
 * JD-Core Version:    0.7.0.1
 */