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
  private Context a;
  private TextView b;
  
  public WSTipsInfoDialog(Context paramContext)
  {
    this(paramContext, 2131952032);
  }
  
  protected WSTipsInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b()
  {
    setContentView(2131626040);
    this.b = ((TextView)findViewById(2131450301));
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131450261);
    TextView localTextView = (TextView)findViewById(2131450293);
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
    this.b.setText(paramString);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131450261) && (i != 2131450293)) {
      return;
    }
    WSFollowBeaconReport.c();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSTipsInfoDialog
 * JD-Core Version:    0.7.0.1
 */