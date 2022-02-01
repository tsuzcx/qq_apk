package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class AIOJubaoDialogHelper
  implements DialogGenerator, ILifeCycleHelper
{
  Dialog a;
  Dialog b;
  Dialog c;
  Dialog d;
  private final Context e;
  private final BaseActivity f;
  private final SessionInfo g;
  private final QQAppInterface h;
  private final BaseChatPie i;
  
  public AIOJubaoDialogHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.e = paramBaseChatPie.e;
    this.f = paramBaseChatPie.aX();
    this.g = paramBaseChatPie.ah;
    this.h = paramBaseChatPie.d;
    this.i = paramBaseChatPie;
    paramHelperProvider.a(this);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 233: 
      this.d = new ReportDialog(this.e, 2131953338);
      this.d.setContentView(2131629538);
      localTextView1 = (TextView)this.d.findViewById(2131447089);
      localObject = (ImageView)this.d.findViewById(2131435388);
      localTextView1.setText(2131887670);
      ((ImageView)localObject).setImageResource(2130839791);
      return this.d;
    case 232: 
      this.c = new ReportDialog(this.e, 2131953338);
      this.c.setContentView(2131629538);
      localTextView1 = (TextView)this.c.findViewById(2131447089);
      localObject = (ImageView)this.c.findViewById(2131435388);
      localTextView1.setText(2131887672);
      ((ImageView)localObject).setImageResource(2130839806);
      return this.c;
    case 231: 
      this.b = new ReportDialog(this.e, 2131953338);
      this.b.setContentView(2131623999);
      ((TextView)this.b.findViewById(2131431876)).setText(2131915696);
      return this.b;
    }
    this.a = new ReportDialog(this.e, 2131953338);
    this.a.setContentView(2131624611);
    TextView localTextView1 = (TextView)this.a.findViewById(2131431880);
    Object localObject = (TextView)this.a.findViewById(2131431876);
    TextView localTextView2 = (TextView)this.a.findViewById(2131431864);
    TextView localTextView3 = (TextView)this.a.findViewById(2131431870);
    localTextView1.setText(2131915695);
    ((TextView)localObject).setText(2131915693);
    localTextView3.setText(2131915694);
    localTextView3.setOnClickListener(new AIOJubaoDialogHelper.1(this));
    localTextView2.setText(2131887648);
    localTextView2.setOnClickListener(new AIOJubaoDialogHelper.2(this));
    return this.a;
  }
  
  public void a()
  {
    Dialog localDialog = this.b;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.f.dismissDialog(231);
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if ((paramInt != 232) && (paramInt != 233)) {
      return;
    }
    this.i.j().postDelayed(new AIOJubaoDialogHelper.3(this), 1000L);
  }
  
  public String getTag()
  {
    return "AIOJubaoDialogHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper
 * JD-Core Version:    0.7.0.1
 */