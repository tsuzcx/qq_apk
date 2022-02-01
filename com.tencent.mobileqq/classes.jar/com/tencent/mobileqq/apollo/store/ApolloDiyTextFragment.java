package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ApolloDiyTextFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  boolean a = false;
  boolean b = false;
  private ApolloDiyTextFragment.DisablePasteEditTextView c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private RelativeLayout h;
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ApolloDiyTextFragment.AndroidBug5497Workaround.a(super.getBaseActivity());
  }
  
  public void onClick(View paramView)
  {
    ImageView localImageView = this.e;
    String str = "";
    if (paramView == localImageView)
    {
      paramView = this.c.getText();
      if ((paramView != null) && (paramView.length() > 0)) {
        if (paramView.length() > 12)
        {
          QQToast.makeText(super.getBaseActivity(), HardCodeUtil.a(2131898574), 0).show();
        }
        else
        {
          paramView = new Intent();
          paramView.putExtra("ret", 1);
          if (this.c.getText() != null) {
            str = this.c.getText().toString();
          }
          paramView.putExtra("text", str);
          super.getBaseActivity().setResult(-1, paramView);
          super.getBaseActivity().finish();
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "ConfirmClick", 0, 0, new String[0]);
      return;
    }
    if (paramView == this.d)
    {
      paramView = new Intent();
      paramView.putExtra("ret", 0);
      if (this.c.getText() != null) {
        str = this.c.getText().toString();
      }
      paramView.putExtra("text", str);
      super.getBaseActivity().setResult(0, paramView);
      VipUtils.a(null, "cmshow", "Apollo", "CancelClick", 0, 0, new String[0]);
      super.getBaseActivity().finish();
      return;
    }
    if (paramView == this.f)
    {
      this.c.setText("");
      this.c.setHint(" ");
      VipUtils.a(null, "cmshow", "Apollo", "ClearClick", 0, 0, new String[0]);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = super.getBaseActivity();
    this.h = new RelativeLayout(paramLayoutInflater);
    this.h.setBackgroundColor(-1778384896);
    this.g = new TextView(paramLayoutInflater);
    this.g.setTextSize(14.0F);
    this.g.setTextColor(-1);
    paramViewGroup = new RelativeLayout.LayoutParams(-2, -2);
    paramViewGroup.addRule(14, -1);
    paramViewGroup.addRule(12, -1);
    paramViewGroup.bottomMargin = ViewUtils.dip2px(80.0F);
    this.h.addView(this.g, paramViewGroup);
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.bottomMargin = ViewUtils.dip2px(44.0F);
    this.h.addView(paramViewGroup, paramBundle);
    this.c = new ApolloDiyTextFragment.DisablePasteEditTextView(paramLayoutInflater);
    this.c.setCursorVisible(true);
    this.c.setTextSize(24.0F);
    this.c.setTextColor(-1);
    this.c.setHintTextColor(-1);
    this.c.setHint(HardCodeUtil.a(2131898578));
    this.c.setBackgroundColor(0);
    this.c.addTextChangedListener(this);
    this.c.setSingleLine(false);
    this.c.setSelection(0);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13, -1);
    paramViewGroup.addView(this.c, paramBundle);
    float f1 = this.c.getPaint().measureText(HardCodeUtil.a(2131898577));
    this.c.setMaxWidth((int)(f1 + 1.0F));
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(1.0F)).addRule(10, -1);
    paramViewGroup.addView(paramBundle);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(1.0F)).addRule(12, -1);
    paramViewGroup.addView(paramBundle);
    this.d = new ImageView(paramLayoutInflater);
    this.d.setImageResource(2130838485);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(9);
    paramBundle.leftMargin = ViewUtils.dip2px(15.0F);
    this.d.setOnClickListener(this);
    paramViewGroup.addView(this.d, paramBundle);
    this.e = new ImageView(paramLayoutInflater);
    this.e.setOnClickListener(this);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(11);
    paramBundle.rightMargin = ViewUtils.dip2px(10.0F);
    paramViewGroup.addView(this.e, paramBundle);
    this.f = new TextView(paramLayoutInflater);
    this.f.setText(HardCodeUtil.a(2131898576));
    this.f.setGravity(17);
    this.f.setTextSize(16.0F);
    this.f.setTextColor(-16777216);
    paramBundle = new RelativeLayout.LayoutParams(-2, -1);
    paramBundle.addRule(13);
    this.f.setOnClickListener(this);
    paramViewGroup.addView(this.f, paramBundle);
    paramBundle = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(43.0F));
    paramBundle.addRule(12, -1);
    this.h.addView(paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.getIntent().getStringExtra("extra_key_last_text");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.c.setGravity(17);
      this.c.setText(paramLayoutInflater);
      this.c.a(paramLayoutInflater.length());
      int i = 12 - paramLayoutInflater.length();
      paramLayoutInflater = this.g;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(HardCodeUtil.a(2131898575));
      paramViewGroup.append(i);
      paramViewGroup.append(HardCodeUtil.a(2131898573));
      paramLayoutInflater.setText(paramViewGroup.toString());
      if (i < 0) {
        this.g.setTextColor(-65536);
      }
      this.g.setTextColor(-1);
      this.e.setImageResource(2130838487);
    }
    else
    {
      this.c.setGravity(3);
      this.g.setText("还可以输入12个字");
      this.g.setTextColor(-1);
      this.e.setImageResource(2130838486);
    }
    paramLayoutInflater = new AlphaAnimation(0.0F, 1.0F);
    paramLayoutInflater.setDuration(500L);
    paramLayoutInflater.setFillAfter(true);
    this.h.startAnimation(paramLayoutInflater);
    VipUtils.a(null, "cmshow", "Apollo", "PageView", 1, 0, new String[0]);
    return this.h;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.c.setHint(" ");
      String str = paramCharSequence.toString();
      if (QLog.isColorLevel())
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("onTextChanged:");
        paramCharSequence.append(str);
        paramCharSequence.append(" newStr:");
        paramCharSequence.append(str);
        QLog.d("[cmshow]ApolloDiyTextActivity", 2, paramCharSequence.toString());
      }
      paramInt1 = str.length();
      if (paramInt1 > 50)
      {
        paramCharSequence = str.substring(0, 50);
        if (!this.b)
        {
          this.b = true;
          VipUtils.a(null, "cmshow", "Apollo", "reach50", 0, 0, new String[0]);
        }
        paramInt1 = 50;
      }
      else
      {
        if (paramInt1 < 50) {
          this.b = false;
        }
        paramCharSequence = str;
      }
      TextView localTextView = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898572));
      localStringBuilder.append(12 - paramInt1);
      localStringBuilder.append(HardCodeUtil.a(2131898571));
      localTextView.setText(localStringBuilder.toString());
      if (paramInt1 > 12)
      {
        this.g.setTextColor(-65536);
        if (!this.a)
        {
          this.a = true;
          VipUtils.a(null, "cmshow", "Apollo", "over12", 0, 0, new String[0]);
        }
      }
      else
      {
        this.a = false;
        this.g.setTextColor(-1);
      }
      paramInt2 = this.c.getSelectionEnd();
      paramInt1 = paramInt2;
      if (paramInt2 >= paramCharSequence.length()) {
        paramInt1 = paramCharSequence.length();
      }
      if (!str.equals(paramCharSequence))
      {
        this.c.removeTextChangedListener(this);
        this.c.setText(paramCharSequence);
        this.c.setSelection(paramInt1);
        this.c.addTextChangedListener(this);
      }
    }
    else
    {
      this.g.setText("还可以输入12个字");
      this.g.setTextColor(-1);
    }
    if ((this.c.getText() != null) && (this.c.getText().length() > 0))
    {
      this.c.setGravity(17);
      paramCharSequence = this.e;
      if (paramCharSequence != null) {
        paramCharSequence.setImageResource(2130838487);
      }
    }
    else
    {
      this.c.setGravity(3);
      paramCharSequence = this.e;
      if (paramCharSequence != null) {
        paramCharSequence.setImageResource(2130838486);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment
 * JD-Core Version:    0.7.0.1
 */