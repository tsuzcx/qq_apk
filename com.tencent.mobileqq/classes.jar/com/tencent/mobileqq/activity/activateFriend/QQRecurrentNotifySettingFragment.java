package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;

public class QQRecurrentNotifySettingFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private Button b;
  private TextView c;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", paramString1);
    localIntent.putExtra("key_busid", paramString2);
    localIntent.putExtra("key_domain", paramString3);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, QQRecurrentNotifySettingFragment.class, paramInt);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecurrentNotifySettingFragment", 2, "setBusinessLogo url is empty");
      }
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = UIUtils.a(getBaseActivity(), 28.0F);
    localURLDrawableOptions.mRequestWidth = UIUtils.a(getBaseActivity(), 28.0F);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString != null)
    {
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
  }
  
  private void b()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidWidgetScrollView.post(new QQRecurrentNotifySettingFragment.1(this, localTranslateAnimation));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131560918, paramViewGroup, false);
  }
  
  public void a()
  {
    if (MobileQQ.sMobileQQ != null) {
      QQToast.a(MobileQQ.sMobileQQ, HardCodeUtil.a(2131710532), 0).a();
    }
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    if (paramAcsGetMsgRsp != null)
    {
      if (paramAcsGetMsgRsp.ret_code == 0)
      {
        boolean bool = TextUtils.isEmpty(paramAcsGetMsgRsp.busi_name);
        String str2 = "";
        String str1;
        if (bool) {
          str1 = "";
        } else {
          str1 = String.format(getResources().getString(2131699839), new Object[] { paramAcsGetMsgRsp.busi_name });
        }
        if (!TextUtils.isEmpty(paramAcsGetMsgRsp.sub_content)) {
          str2 = paramAcsGetMsgRsp.sub_content;
        }
        this.c.setText(str1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        a(paramAcsGetMsgRsp.busi_logo);
        b();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      a();
      b(paramAcsGetMsgRsp.ret_code, paramAcsGetMsgRsp.err_str);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTag("1");
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (this.jdField_b_of_type_Int != 2) {
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (getBaseActivity() == null) {
        bool = true;
      }
      QLog.d("QQRecurrentNotifySettingFragment", 2, new Object[] { "callbackResult getActivity is null:", Boolean.valueOf(bool), " errorCode=", Integer.valueOf(paramInt), " msg=", paramString });
    }
    if (getBaseActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("errorCode", paramInt);
      localIntent.putExtra("msg", paramString);
      getBaseActivity().setResult(-1, localIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362686));
    ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369378)).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369379));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369380));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363890));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQRecurrentNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */