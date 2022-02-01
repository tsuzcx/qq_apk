package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.InputStream;
import mqq.app.AppRuntime;

public class RegisterGuideView
  extends GuideBaseFragment
  implements View.OnClickListener
{
  private View f;
  private Button g;
  private Button h;
  
  public RegisterGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public RegisterGuideView(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    int i = paramView.getId();
    Object localObject;
    if (i == 2131429928)
    {
      ReportController.b(this.a, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
      ReportController.a(this.a, "dc00898", "", "", "0X800AA26", "0X800AA26", 0, 0, "", "", "", "");
      localObject = this.b.getIntent();
      ((Intent)localObject).putExtra("from_register_guide", true);
      ((Intent)localObject).putExtra("is_need_show_logo_animation", true);
      localObject = GuideHandler.a(this.b, this.a);
      if (this.c != null) {
        this.c.changeGuideBaseView((GuideBaseFragment)localObject);
      }
    }
    else if (i == 2131429986)
    {
      ReportController.b(this.a, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
      ReportController.a(this.a, "dc00898", "", "", "0X800AA25", "0X800AA25", 0, 0, "", "", "", "");
      localObject = new Intent(this.b, RegisterPhoneNumActivity.class);
      ((Intent)localObject).putExtra("key_register_from", 3);
      ((Intent)localObject).putExtra("leftViewText", this.b.getString(2131887625));
      ((Intent)localObject).addFlags(67108864);
      this.b.startActivity((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131625267, paramViewGroup, false);
    this.f = paramViewGroup.findViewById(2131429638);
    this.f.setVisibility(0);
    this.g = ((Button)paramViewGroup.findViewById(2131429928));
    this.h = ((Button)paramViewGroup.findViewById(2131429986));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    paramBundle = (ImageView)paramViewGroup.findViewById(2131446244);
    paramLayoutInflater = "splash.jpg";
    try
    {
      if (paramViewGroup.getContext().getResources().getDisplayMetrics().widthPixels > 1500) {
        paramLayoutInflater = "splash_big.jpg";
      }
      paramLayoutInflater = getQBaseActivity().getAssets().open(paramLayoutInflater);
      paramBundle.setImageDrawable(new BitmapDrawable(getResources(), paramLayoutInflater));
      try
      {
        paramLayoutInflater.close();
      }
      catch (Throwable paramLayoutInflater)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreateView error1:");
        paramBundle.append(paramLayoutInflater.getMessage());
        QLog.e("LoginActivity.RegisterGuideView", 1, paramBundle.toString());
      }
      ReportController.a(this.a, "dc00898", "", "", "0X800AA24", "0X800AA24", 0, 0, "", "", "", "");
    }
    catch (Throwable paramLayoutInflater)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateView error2:");
      paramBundle.append(paramLayoutInflater.getMessage());
      QLog.e("LoginActivity.RegisterGuideView", 1, paramBundle.toString());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView
 * JD-Core Version:    0.7.0.1
 */