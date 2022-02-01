package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import afez;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import anzj;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import zps;

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
    afez.a(paramActivity, localIntent, PublicTransFragmentActivity.class, QQRecurrentNotifySettingFragment.class, paramInt);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecurrentNotifySettingFragment", 2, "setBusinessLogo url is empty");
      }
    }
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = zps.a(getActivity(), 28.0F);
      localURLDrawableOptions.mRequestWidth = zps.a(getActivity(), 28.0F);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    } while (paramString == null);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  private void b()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidWidgetScrollView.post(new QQRecurrentNotifySettingFragment.1(this, localTranslateAnimation));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131561037, paramViewGroup, false);
  }
  
  public void a()
  {
    QQToast.a(getActivity(), anzj.a(2131709458), 0).a();
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    String str1;
    if (paramAcsGetMsgRsp != null)
    {
      if (paramAcsGetMsgRsp.ret_code != 0) {
        break label109;
      }
      if (!TextUtils.isEmpty(paramAcsGetMsgRsp.busi_name)) {
        break label74;
      }
      str1 = "";
      if (!TextUtils.isEmpty(paramAcsGetMsgRsp.sub_content)) {
        break label101;
      }
    }
    label74:
    label101:
    for (String str2 = "";; str2 = paramAcsGetMsgRsp.sub_content)
    {
      this.c.setText(str1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      a(paramAcsGetMsgRsp.busi_logo);
      b();
      return;
      str1 = String.format(getResources().getString(2131698554), new Object[] { paramAcsGetMsgRsp.busi_name });
      break;
    }
    label109:
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    a();
    b(paramAcsGetMsgRsp.ret_code, paramAcsGetMsgRsp.err_str);
  }
  
  public void b(int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
      if (!this.jdField_a_of_type_Boolean) {
        break label55;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setTag("1");
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    label55:
    while (this.jdField_a_of_type_Int == 2)
    {
      return;
      bool = false;
      break;
    }
    a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void c(int paramInt, String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (getActivity() == null) {
        bool = true;
      }
      QLog.d("QQRecurrentNotifySettingFragment", 2, new Object[] { "callbackResult getActivity is null:", Boolean.valueOf(bool), " errorCode=", Integer.valueOf(paramInt), " msg=", paramString });
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("errorCode", paramInt);
      localIntent.putExtra("msg", paramString);
      getActivity().setResult(-1, localIntent);
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
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362683));
    ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369239)).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369240));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369241));
    this.b = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363765));
    this.b.setOnClickListener(this);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQRecurrentNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */