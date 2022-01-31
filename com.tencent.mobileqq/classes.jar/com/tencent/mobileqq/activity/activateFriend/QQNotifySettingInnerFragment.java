package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import adpn;
import alud;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import xsm;

public class QQNotifySettingInnerFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private ImageView b;
  private TextView c;
  private TextView d;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", paramString1);
    localIntent.putExtra("key_busid", paramString2);
    localIntent.putExtra("key_domain", paramString3);
    adpn.a(paramActivity, localIntent, PublicTransFragmentActivity.class, QQNotifySettingInnerFragment.class, 48128);
  }
  
  private void b()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidWidgetScrollView.post(new QQNotifySettingInnerFragment.1(this, localTranslateAnimation));
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131560799, paramViewGroup, false);
  }
  
  public void a()
  {
    QQToast.a(getActivity(), alud.a(2131710973), 0).a();
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    super.a(paramAcsGetMsgRsp);
    b();
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
        break label124;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setTag("1");
      this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131710971));
      this.c.setText(alud.a(2131710969));
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestHeight = this.b.getHeight();
      paramString.mRequestWidth = this.b.getWidth();
      paramString = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", paramString);
      if (paramString != null)
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        this.b.setImageDrawable(paramString);
      }
    }
    label124:
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
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362566));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378737));
    this.d.setVisibility(8);
    ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368801)).setVisibility(0);
    this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368802));
    this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = xsm.a(getActivity(), 86.0F);
    paramLayoutInflater.mRequestWidth = xsm.a(getActivity(), 86.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_c180abdeaa834c09173949780f36b7a6.png", paramLayoutInflater);
    if (paramLayoutInflater != null)
    {
      if (paramLayoutInflater.getStatus() == 2) {
        paramLayoutInflater.restartDownload();
      }
      this.b.setImageDrawable(paramLayoutInflater);
    }
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368803));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363543));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment
 * JD-Core Version:    0.7.0.1
 */