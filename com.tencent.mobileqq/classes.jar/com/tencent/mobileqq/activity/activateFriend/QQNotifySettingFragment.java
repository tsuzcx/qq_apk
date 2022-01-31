package com.tencent.mobileqq.activity.activateFriend;

import adpn;
import alud;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URLDecoder;
import java.net.URLEncoder;
import xsm;

public class QQNotifySettingFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView c;
  private TextView d;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_msgid", URLDecoder.decode(paramString1));
    localIntent.putExtra("key_busid", URLDecoder.decode(paramString2));
    localIntent.putExtra("key_schema", URLDecoder.decode(paramString3));
    localIntent.putExtra("key_domain", URLDecoder.decode(paramString4));
    adpn.a(paramContext, localIntent, PublicTransFragmentActivity.class, QQNotifySettingFragment.class);
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131560798, paramViewGroup, false);
  }
  
  public void a()
  {
    QQToast.a(getActivity(), alud.a(2131710970), 0).a();
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
        break label136;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setTag("1");
      this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131710966));
      this.c.setText(alud.a(2131710972));
      this.d.setText(alud.a(2131710968));
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      paramString.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      paramString = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", paramString);
      if (paramString != null)
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
    }
    label136:
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
    paramString = getArguments().getString("key_schema");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString + "://?retcode=" + this.jdField_a_of_type_Int + "&retmsg=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString)));
    paramString.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
    try
    {
      startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131378686) {
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368800));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368798));
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = xsm.a(getActivity(), 106.0F);
    paramLayoutInflater.mRequestWidth = xsm.a(getActivity(), 195.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_a69bf0fc5262c4bc452dd03f6b95a9c0.png", paramLayoutInflater);
    if (paramLayoutInflater != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutInflater);
    }
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368799));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378686));
    this.c.setOnClickListener(this);
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */