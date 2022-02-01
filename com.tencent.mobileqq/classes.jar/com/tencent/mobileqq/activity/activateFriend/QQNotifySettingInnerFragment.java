package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;

public class QQNotifySettingInnerFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private ScrollView k;
  private ImageView l;
  private ImageView m;
  private TextView n;
  private TextView o;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", paramString1);
    localIntent.putExtra("key_busid", paramString2);
    localIntent.putExtra("key_domain", paramString3);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, QQNotifySettingInnerFragment.class, a);
  }
  
  private void c()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.k.post(new QQNotifySettingInnerFragment.1(this, localTranslateAnimation));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131627258, paramViewGroup, false);
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    super.a(paramAcsGetMsgRsp);
    c();
  }
  
  public void b()
  {
    Object localObject;
    if (getBaseActivity() == null) {
      localObject = MobileQQ.getContext();
    } else {
      localObject = getBaseActivity();
    }
    if (localObject == null) {
      return;
    }
    QQToast.makeText((Context)localObject, HardCodeUtil.a(2131908220), 0).show();
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
      this.e.setText(HardCodeUtil.a(2131908218));
      this.n.setText(HardCodeUtil.a(2131908216));
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestHeight = this.m.getHeight();
      paramString.mRequestWidth = this.m.getWidth();
      paramString = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", paramString);
      if (paramString != null)
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        this.m.setImageDrawable(paramString);
      }
    }
    else if (this.i != 2)
    {
      a(this.i, this.j);
    }
  }
  
  public void c(int paramInt, String paramString)
  {
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
    this.o = ((TextView)this.b.findViewById(2131448375));
    this.o.setVisibility(8);
    ((LinearLayout)this.b.findViewById(2131436409)).setVisibility(0);
    this.m = ((ImageView)this.b.findViewById(2131436410));
    this.m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = UIUtils.a(getBaseActivity(), 86.0F);
    paramLayoutInflater.mRequestWidth = UIUtils.a(getBaseActivity(), 86.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_c180abdeaa834c09173949780f36b7a6.png", paramLayoutInflater);
    if (paramLayoutInflater != null)
    {
      if (paramLayoutInflater.getStatus() == 2) {
        paramLayoutInflater.restartDownload();
      }
      this.m.setImageDrawable(paramLayoutInflater);
    }
    this.n = ((TextView)this.b.findViewById(2131436411));
    this.l = ((ImageView)this.b.findViewById(2131429840));
    this.l.setOnClickListener(this);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment
 * JD-Core Version:    0.7.0.1
 */