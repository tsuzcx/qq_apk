package com.tencent.biz.pubaccount.ecshopassit;

import afur;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anry;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.net.URLDecoder;
import ocw;
import ocx;
import ocy;
import odu;
import tzo;

public class BusinessBrowser$BusinessBrowserFragment
  extends WebViewFragment
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = -1;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ocx(this);
  public View a;
  public Animation a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  anry jdField_a_of_type_Anry = new ocy(this);
  public String a;
  public boolean a;
  public int b;
  public View b;
  public Animation b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  
  public BusinessBrowser$BusinessBrowserFragment()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
  }
  
  void a()
  {
    Intent localIntent = new Intent("action_follow_status");
    localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
    super.getActivity().sendBroadcast(localIntent);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (!this.jdField_b_of_type_Boolean) {
      return i;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getActivity().findViewById(2131381162));
    this.jdField_b_of_type_AndroidViewView = super.getActivity().findViewById(2131381152);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(super.getActivity(), 2131561939, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370529);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        if (!ThemeUtil.isInNightMode(this.mApp)) {
          break label294;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371539)).setText(String.valueOf(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368138));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366895));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370198));
      paramBundle = new RelativeLayout.LayoutParams(-1, afur.a(44.0F, super.getResources()));
      paramBundle.addRule(10);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, paramBundle);
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
      this.webView.setOnScrollChangedListener(new ocw(this));
      paramBundle = new Intent("action_get_PA_head");
      paramBundle.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      super.getActivity().sendBroadcast(paramBundle);
      a();
      return i;
      label294:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = this.intent.getIntExtra("jump_from", -1);
    this.jdField_c_of_type_JavaLangString = this.intent.getStringExtra("msg_id");
    this.jdField_c_of_type_Int = afur.a(44.0F, super.getResources());
    Object localObject = Uri.parse(super.getUrlFromIntent());
    boolean bool;
    if (((Uri)localObject).isHierarchical())
    {
      this.jdField_a_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("shopPuin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label231;
      }
      bool = true;
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("shopNick");
      if (this.jdField_b_of_type_JavaLangString != null) {}
      try
      {
        this.jdField_b_of_type_JavaLangString = URLDecoder.decode(this.jdField_b_of_type_JavaLangString, "UTF-8");
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = new IntentFilter("action_decode_finish");
          ((IntentFilter)localObject).addAction("action_follow_status_finish");
        }
      }
      catch (Exception localException1)
      {
        try
        {
          label149:
          label231:
          do
          {
            BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
            this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_c_of_type_Int, 0.0F);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(100L);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
            this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_c_of_type_Int);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(100L);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
            return super.doOnCreate(paramBundle);
            bool = false;
            break;
            localException1 = localException1;
          } while (!QLog.isColorLevel());
          QLog.i("WebLog_WebViewFragment", 2, "msg_id:" + this.jdField_c_of_type_JavaLangString + ",p_uin:" + this.jdField_a_of_type_JavaLangString + ",nick:" + this.jdField_b_of_type_JavaLangString);
        }
        catch (Exception localException2)
        {
          break label149;
        }
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
    }
    while ((paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    Object localObject;
    if (i == 2131366895)
    {
      localObject = (odu)this.mApp.getBusinessHandler(0);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Int == 1) {
          ((odu)localObject).a(134249256, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null, 0L, false);
        }
      }
      else {
        tzo.a(this.mApp, super.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Anry);
      }
    }
    while (i != 2131364254) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Int == 2) {
          ((odu)localObject).a(134249251, this.jdField_a_of_type_JavaLangString, null, null, null, 0L, false);
        }
      }
    }
    if (this.jdField_a_of_type_Int == 1) {
      i = 134249257;
    }
    for (;;)
    {
      localObject = new Intent(super.getActivity(), AccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("report_src_param_type", "");
      ((Intent)localObject).putExtra("report_src_param_name", "");
      if (i != -1) {
        ((Intent)localObject).putExtra("report_business_tvalue", i);
      }
      if (this.jdField_c_of_type_JavaLangString != null) {
        ((Intent)localObject).putExtra("strp1", this.jdField_c_of_type_JavaLangString);
      }
      ((Intent)localObject).setFlags(67108864);
      super.getActivity().startActivity((Intent)localObject);
      break;
      if (this.jdField_a_of_type_Int == 2) {
        i = 134249252;
      } else {
        i = -1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Anry = null;
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */