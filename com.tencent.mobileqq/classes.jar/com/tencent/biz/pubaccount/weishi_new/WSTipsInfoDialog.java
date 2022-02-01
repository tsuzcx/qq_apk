package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.subscribe.comment.SafeDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSTipsInfoDialog
  extends SafeDialog
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public WSTipsInfoDialog(Context paramContext)
  {
    this(paramContext, 2131755174);
  }
  
  protected WSTipsInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    setContentView(2131560125);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131382050));
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131382008);
    TextView localTextView = (TextView)findViewById(2131382042);
    localFrameLayout.setOnClickListener(this);
    localTextView.setOnClickListener(this);
  }
  
  private void c()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
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
      WSFollowBeaconReport.c();
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSTipsInfoDialog
 * JD-Core Version:    0.7.0.1
 */