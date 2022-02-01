package com.tencent.mobileqq.activity.activateFriend;

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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class QQNotifySettingFragment
  extends QQNotifySettingBaseFragment
  implements View.OnClickListener
{
  private TextView k;
  private LinearLayout l;
  private ImageView m;
  private TextView n;
  
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
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, QQNotifySettingFragment.class);
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131627257, paramViewGroup, false);
  }
  
  public void b()
  {
    QQToast.makeText(getBaseActivity(), HardCodeUtil.a(2131908217), 0).show();
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
      this.e.setText(HardCodeUtil.a(2131908213));
      this.k.setText(HardCodeUtil.a(2131908219));
      this.n.setText(HardCodeUtil.a(2131908215));
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
    paramString = getArguments().getString("key_schema");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("://?retcode=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("&retmsg=");
    localStringBuilder.append(URLEncoder.encode(this.j));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
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
    if (paramView.getId() == 2131448309) {
      a(this.i, this.j);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.l = ((LinearLayout)this.b.findViewById(2131436408));
    this.l.setVisibility(0);
    this.m = ((ImageView)this.b.findViewById(2131436406));
    paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
    paramLayoutInflater.mRequestHeight = UIUtils.a(getBaseActivity(), 106.0F);
    paramLayoutInflater.mRequestWidth = UIUtils.a(getBaseActivity(), 195.0F);
    paramLayoutInflater = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_a69bf0fc5262c4bc452dd03f6b95a9c0.png", paramLayoutInflater);
    if (paramLayoutInflater != null) {
      this.m.setImageDrawable(paramLayoutInflater);
    }
    this.n = ((TextView)this.b.findViewById(2131436407));
    this.k = ((TextView)this.b.findViewById(2131448309));
    this.k.setOnClickListener(this);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment
 * JD-Core Version:    0.7.0.1
 */