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
  private ScrollView k;
  private Button l;
  private ImageView m;
  private TextView n;
  
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
      this.m.setImageDrawable(paramString);
    }
  }
  
  private void c()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.k.post(new QQRecurrentNotifySettingFragment.1(this, localTranslateAnimation));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131627259, paramViewGroup, false);
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
          str1 = String.format(getResources().getString(2131897888), new Object[] { paramAcsGetMsgRsp.busi_name });
        }
        if (!TextUtils.isEmpty(paramAcsGetMsgRsp.sub_content)) {
          str2 = paramAcsGetMsgRsp.sub_content;
        }
        this.n.setText(str1);
        this.c.setText(str2);
        this.e.setEnabled(true);
        a(paramAcsGetMsgRsp.busi_logo);
        c();
        return;
      }
      this.e.setEnabled(false);
      b();
      b(paramAcsGetMsgRsp.ret_code, paramAcsGetMsgRsp.err_str);
    }
  }
  
  public void b()
  {
    if (MobileQQ.sMobileQQ != null) {
      QQToast.makeText(MobileQQ.sMobileQQ, HardCodeUtil.a(2131908220), 0).show();
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
    this.g = bool;
    this.i = paramInt;
    this.j = paramString;
    if (this.g)
    {
      this.e.setTag("1");
      a(this.i, this.j);
      return;
    }
    if (this.i != 2) {
      a(this.i, this.j);
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
    this.k = ((ScrollView)this.b.findViewById(2131428355));
    ((LinearLayout)this.b.findViewById(2131436409)).setVisibility(0);
    this.m = ((ImageView)this.b.findViewById(2131436410));
    this.m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.n = ((TextView)this.b.findViewById(2131436411));
    this.l = ((Button)this.b.findViewById(2131429840));
    this.l.setOnClickListener(this);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQRecurrentNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */