package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import uxo;
import uzl;
import vhk;
import vrf;

public class QCircleMessageNoticeView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private uzl jdField_a_of_type_Uzl;
  private LinearLayout b;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 2131560731;
  }
  
  protected String a()
  {
    return "QCircleMessage_QCircleMessageNoticeView";
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.b = ((LinearLayout)paramView.findViewById(2131370102));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131362651));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379768));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370101));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof uzl))
    {
      this.jdField_a_of_type_Uzl = ((uzl)paramObject);
      paramObject = this.jdField_a_of_type_Uzl.a();
      if ((paramObject == null) || (paramObject.size() <= 0)) {
        break label189;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(0);
      if (paramObject.size() <= this.jdField_a_of_type_Int) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramObject.subList(0, this.jdField_a_of_type_Int));
    }
    for (;;)
    {
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "bindData allUnReadCount:" + this.jdField_a_of_type_Uzl.c() + " messageUnReadCount:" + this.jdField_a_of_type_Uzl.a() + " chatUnReadCount:" + this.jdField_a_of_type_Uzl.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getString(2131697204, new Object[] { vhk.a(this.jdField_a_of_type_Uzl.c()) }));
      this.b.setVisibility(0);
      return;
      label178:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramObject);
      continue;
      label189:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(8);
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
    HashMap localHashMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vrf.a("", 18, 2);
      localHashMap = new HashMap();
    } while (this.jdField_a_of_type_Uzl == null);
    if (this.jdField_a_of_type_Uzl.a() > 0)
    {
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to messageList page");
      localHashMap.put("to", String.valueOf(0));
    }
    for (;;)
    {
      uxo.a(localHashMap, d(), a().clone().setElementIdStr("msg"));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      break;
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "jump to chatList page");
      localHashMap.put("to", String.valueOf(1));
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