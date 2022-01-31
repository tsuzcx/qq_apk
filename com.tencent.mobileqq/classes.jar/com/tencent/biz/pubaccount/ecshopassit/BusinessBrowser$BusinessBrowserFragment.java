package com.tencent.biz.pubaccount.ecshopassit;

import aciy;
import ajpe;
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
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.net.URLDecoder;
import nfl;
import nfm;
import nfn;
import ngh;
import rtr;

public class BusinessBrowser$BusinessBrowserFragment
  extends WebViewFragment
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int = -1;
  ajpe jdField_a_of_type_Ajpe = new nfn(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nfm(this);
  public View a;
  public Animation a;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
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
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (!this.jdField_b_of_type_Boolean) {
      return i;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.getActivity().findViewById(2131313572));
    this.jdField_b_of_type_AndroidViewView = super.getActivity().findViewById(2131313562);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(super.getActivity(), 2131495903, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131304131);
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
          break label294;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304981)).setText(String.valueOf(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302061));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300903));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303812));
      paramBundle = new RelativeLayout.LayoutParams(-1, aciy.a(44.0F, super.getResources()));
      paramBundle.addRule(10);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, paramBundle);
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(new nfl(this));
      paramBundle = new Intent("action_get_PA_head");
      paramBundle.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      super.getActivity().sendBroadcast(paramBundle);
      w_();
      return i;
      label294:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
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
  
  public boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("jump_from", -1);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("msg_id");
    this.jdField_c_of_type_Int = aciy.a(44.0F, super.getResources());
    Object localObject = Uri.parse(super.d());
    boolean bool;
    if (((Uri)localObject).isHierarchical())
    {
      this.jdField_a_of_type_JavaLangString = ((Uri)localObject).getQueryParameter("shopPuin");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label230;
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
          label148:
          label230:
          do
          {
            BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
            this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, -this.jdField_c_of_type_Int, 0.0F);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(100L);
            this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
            this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_c_of_type_Int);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(100L);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
            return super.a(paramBundle);
            bool = false;
            break;
            localException1 = localException1;
          } while (!QLog.isColorLevel());
          QLog.i("WebLog_WebViewFragment", 2, "msg_id:" + this.jdField_c_of_type_JavaLangString + ",p_uin:" + this.jdField_a_of_type_JavaLangString + ",nick:" + this.jdField_b_of_type_JavaLangString);
        }
        catch (Exception localException2)
        {
          break label148;
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
    if (i == 2131300903)
    {
      paramView = (ngh)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(0);
      if (paramView != null)
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label79;
        }
        paramView.a(134249256, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null, 0L, false);
      }
    }
    label79:
    while (i != 2131298431) {
      for (;;)
      {
        rtr.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ajpe);
        return;
        if (this.jdField_a_of_type_Int == 2) {
          paramView.a(134249251, this.jdField_a_of_type_JavaLangString, null, null, null, 0L, false);
        }
      }
    }
    if (this.jdField_a_of_type_Int == 1) {
      i = 134249257;
    }
    for (;;)
    {
      paramView = new Intent(super.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("report_src_param_type", "");
      paramView.putExtra("report_src_param_name", "");
      if (i != -1) {
        paramView.putExtra("report_business_tvalue", i);
      }
      if (this.jdField_c_of_type_JavaLangString != null) {
        paramView.putExtra("strp1", this.jdField_c_of_type_JavaLangString);
      }
      paramView.setFlags(67108864);
      super.getActivity().startActivity(paramView);
      return;
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
    this.jdField_a_of_type_Ajpe = null;
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
    w_();
  }
  
  void w_()
  {
    Intent localIntent = new Intent("action_follow_status");
    localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
    super.getActivity().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */