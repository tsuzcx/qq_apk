package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@RoutePage(desc="设备更名页面", path="/base/safe/devRenameActivity")
public class AuthDevRenameActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  private ClearableEditText mAuthDevName;
  private Handler mHandler = new AuthDevRenameActivity.3(this);
  private QQProgressDialog mProDialog;
  private SecSvcObserver mSecSvcObserver = new AuthDevRenameActivity.2(this);
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new AuthDevRenameActivity.5(this));
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevRenameActivity.4(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627388);
    super.addObserver(this.mSecSvcObserver);
    super.setRightButton(2131888959, this);
    this.leftView.setText(2131887648);
    this.leftView.setOnClickListener(this);
    if ((this.centerView != null) && ((this.centerView instanceof TextView))) {
      this.centerView.setVisibility(8);
    }
    Object localObject1 = super.getIntent();
    paramBundle = null;
    if (localObject1 != null)
    {
      paramBundle = ((Intent)localObject1).getStringExtra("target_name");
      localObject1 = ((Intent)localObject1).getStringExtra("target_type_info");
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = super.findViewById(2131447534);
    if (localObject2 != null)
    {
      ((View)localObject2).setVisibility(0);
      TextView localTextView = (TextView)((View)localObject2).findViewById(2131447581);
      if (localTextView != null) {
        localTextView.setText(2131889006);
      }
      localObject2 = (TextView)((View)localObject2).findViewById(2131447497);
      if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
    }
    else
    {
      super.setTitle(2131889006);
    }
    this.mAuthDevName = ((ClearableEditText)super.findViewById(2131428894));
    if (!TextUtils.isEmpty(paramBundle)) {
      this.mAuthDevName.setHint(paramBundle);
    }
    this.mAuthDevName.setImeOptions(6);
    this.mAuthDevName.setOnEditorActionListener(this);
    this.mAuthDevName.setImeActionLabel(getString(2131891418), 6);
    this.mAuthDevName.setFilters(new InputFilter[] { new AuthDevRenameActivity.1(this) });
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436211)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        break label174;
      }
      Object localObject1 = this.mAuthDevName.getEditableText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QQToast.makeText(this, getString(2131888975), 0).show(getTitleBarHeight());
        break label174;
      }
      Object localObject2 = super.getIntent();
      if (localObject2 != null)
      {
        String str = ((Intent)localObject2).getStringExtra("target_name");
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(str, (CharSequence)localObject1)))
        {
          localObject2 = ((Intent)localObject2).getExtras();
          ((Bundle)localObject2).putString("target_name", (String)localObject1);
          ((Bundle)localObject2).putString("uin", this.app.getCurrentAccountUin());
          localObject1 = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
          if (localObject1 != null)
          {
            showProgressDialog();
            ((SecSvcHandler)localObject1).a((Bundle)localObject2);
            break label174;
          }
        }
      }
    }
    super.finish();
    label174:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    hideProgerssDialog();
    super.onDestroy();
    super.removeObserver(this.mSecSvcObserver);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 6)
    {
      onClick(this.rightViewText);
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity
 * JD-Core Version:    0.7.0.1
 */