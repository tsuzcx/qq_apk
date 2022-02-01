package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.subscribe.comment.SafeDialog;

public class WSTipsInfoDialog
  extends SafeDialog
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public WSTipsInfoDialog(Context paramContext)
  {
    this(paramContext, 2131755338);
  }
  
  protected WSTipsInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    setContentView(2131559997);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381253));
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131381213);
    TextView localTextView = (TextView)findViewById(2131381245);
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
    int i = paramView.getId();
    if ((i != 2131381213) && (i != 2131381245)) {
      return;
    }
    WSFollowBeaconReport.c();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSTipsInfoDialog
 * JD-Core Version:    0.7.0.1
 */