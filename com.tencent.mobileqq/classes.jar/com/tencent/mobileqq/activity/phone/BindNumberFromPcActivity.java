package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  Button a;
  String b;
  String c;
  private TextView d;
  private TextView e;
  private Button f;
  private String g;
  private ContactBindObserver h;
  private ContactBindObserver i;
  private boolean j;
  
  private void a()
  {
    setTitle(HardCodeUtil.a(2131899359));
    if (this.j) {
      setLeftButton(2131887812, null);
    }
    this.d = ((TextView)findViewById(2131440025));
    int k = this.b.length();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.substring(0, k - 5));
    ((StringBuilder)localObject).append("****");
    ((StringBuilder)localObject).append(this.b.substring(k - 1));
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    this.e = ((TextView)findViewById(2131440024));
    this.e.setText(getResources().getString(2131892452, new Object[] { this.g }));
    this.a = ((Button)findViewById(2131440023));
    this.a.setOnClickListener(this);
    this.f = ((Button)findViewById(2131440022));
    this.f.setOnClickListener(this);
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    if (this.h == null)
    {
      this.h = new BindNumberFromPcActivity.1(this);
      this.app.registObserver(this.h);
    }
    this.a.setEnabled(false);
    this.mPhoneContactService.sendBindMobile(this.c, this.b);
    showProgressDialog(2131916272, 1000L, true);
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_change_number", true);
    startActivityForResult(localIntent, 1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.j) {
      overridePendingTransition(2130772007, 2130772436);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131440023: 
      b();
      break;
    case 2131440022: 
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131625562);
    int k = this.mPhoneContactService.getSelfBindState();
    paramBundle = this.mPhoneContactService.getSelfBindInfo();
    if ((k == 5) && (paramBundle != null))
    {
      this.c = paramBundle.nationCode;
      this.b = paramBundle.mobileNo;
      this.g = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramBundle.bindingTime * 1000L));
      this.j = getIntent().getBooleanExtra("key_is_first_activity", true);
      a();
      return;
    }
    showConfirmFinish(HardCodeUtil.a(2131899358), HardCodeUtil.a(2131899361));
  }
  
  protected void onDestroy()
  {
    if (this.h != null)
    {
      this.app.unRegistObserver(this.h);
      this.h = null;
    }
    if (this.i != null)
    {
      this.app.unRegistObserver(this.i);
      this.i = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */