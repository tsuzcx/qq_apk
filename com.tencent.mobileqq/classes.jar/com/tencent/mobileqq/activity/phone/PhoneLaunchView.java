package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@SuppressLint({"ViewConstructor"})
public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private Button l;
  private boolean m;
  private int n;
  
  public PhoneLaunchView(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    setContentView(2131625570);
    this.l = ((Button)a(2131440033));
    this.l.setOnClickListener(this);
    PhoneContactUtils.a(this.a, getResources(), (ImageView)a(2131440035));
  }
  
  private void k()
  {
    Intent localIntent = new Intent(getContext(), BindNumberActivity.class);
    localIntent.putExtra("key_is_modal_pop", true);
    localIntent.putExtra("kSrouce", this.n);
    a(localIntent, 1);
    a(2130772434, 2130772007);
  }
  
  protected void a()
  {
    super.a();
    if (this.c == 3) {
      this.h.setText(HardCodeUtil.a(2131905823));
    } else {
      this.h.setText(HardCodeUtil.a(2131905815));
    }
    this.g.setVisibility(8);
    if (this.m) {
      k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.c == 1)
      {
        this.b.setResult(paramInt2);
        g();
        return;
      }
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("refuse_upload", false)))
        {
          g();
          return;
        }
        this.b.setResult(paramInt2, paramIntent);
        a(new Intent(getContext(), ContactListView.class));
        return;
      }
      if (paramInt2 == 0) {
        g();
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("k_start_number", false)) {
        this.m = true;
      }
      this.n = paramIntent.getIntExtra("kSrouce", -1);
    }
    super.a(paramIntent, paramPhoneInnerFrame);
    if (this.c == 3) {
      ((TextView)a(2131440036)).setText(2131886286);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.l)
    {
      int i = this.e.getSelfBindState();
      ReportController.b(this.a, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        if (i == 5)
        {
          a(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
          a(2130772434, 2130772007);
        }
        else
        {
          a(HardCodeUtil.a(2131905825), HardCodeUtil.a(2131905821));
        }
      }
      else
      {
        ContactUtils.d(6);
        k();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */