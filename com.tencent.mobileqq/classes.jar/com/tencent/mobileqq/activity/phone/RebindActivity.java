package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RebindActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  String a;
  int b;
  private TextView c;
  private Button d;
  private Button e;
  private String f;
  private int g = 0;
  private ContactBindObserver h;
  private boolean i = false;
  private boolean j = false;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131625571);
    this.i = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.j = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.b = getIntent().getIntExtra("kSrouce", -1);
    this.f = getIntent().getStringExtra("k_country_code");
    this.a = getIntent().getStringExtra("k_number");
    this.g = getIntent().getIntExtra("kBindType", 0);
    setTitle(HardCodeUtil.a(2131910632));
    this.c = ((TextView)findViewById(2131440021));
    paramBundle = new StringBuilder();
    paramBundle.append(this.f);
    paramBundle.append(" ");
    paramBundle.append(this.a);
    paramBundle = paramBundle.toString();
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getResources().getString(2131892528, new Object[] { paramBundle, getIntent().getStringExtra("k_uin"), this.app.getCurrentAccountUin() }));
    localSpannableStringBuilder.setSpan(localForegroundColorSpan, 4, paramBundle.length() + 4, 33);
    this.c.setText(localSpannableStringBuilder);
    this.d = ((Button)findViewById(2131440020));
    this.d.setOnClickListener(this);
    this.e = ((Button)findViewById(2131440019));
    this.e.setOnClickListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.h != null)
    {
      this.app.unRegistObserver(this.h);
      this.h = null;
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        showToast(2131892157);
      }
      else
      {
        if (this.h == null)
        {
          this.h = new RebindActivity.1(this);
          this.app.registObserver(this.h);
        }
        this.mPhoneContactService.sendRebindMobile(this.f, this.a, this.g, this.i, this.j);
        showProgressDialog(2131916272, 1000L, true);
      }
    }
    else if (paramView == this.e) {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity
 * JD-Core Version:    0.7.0.1
 */