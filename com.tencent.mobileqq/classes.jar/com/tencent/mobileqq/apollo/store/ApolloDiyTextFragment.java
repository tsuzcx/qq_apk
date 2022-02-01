package com.tencent.mobileqq.apollo.store;

import agej;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import anhv;
import anhx;
import anzj;
import begd;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ApolloDiyTextFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anhx jdField_a_of_type_Anhx;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= begd.d.length) {
        break;
      }
      int j = paramString.indexOf(begd.d[i], 0);
      str = paramString;
      if (j != -1)
      {
        str = paramString;
        if (j + 2 <= paramString.length()) {
          str = paramString.replace(paramString.substring(j, j + 2), "");
        }
      }
      i += 1;
      paramString = str;
    }
  }
  
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
    anhv.a(super.getActivity());
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      localObject = this.jdField_a_of_type_Anhx.getText();
      if ((localObject != null) && (((Editable)localObject).length() > 0))
      {
        if (((Editable)localObject).length() > 12) {
          QQToast.a(super.getActivity(), anzj.a(2131699237), 0).a();
        }
      }
      else {
        VipUtils.a(null, "cmshow", "Apollo", "ConfirmClick", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("ret", 1);
      if (this.jdField_a_of_type_Anhx.getText() != null) {}
      for (localObject = this.jdField_a_of_type_Anhx.getText().toString();; localObject = "")
      {
        localIntent.putExtra("text", (String)localObject);
        super.getActivity().setResult(-1, localIntent);
        super.getActivity().finish();
        break;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        localIntent = new Intent();
        localIntent.putExtra("ret", 0);
        if (this.jdField_a_of_type_Anhx.getText() != null) {}
        for (localObject = this.jdField_a_of_type_Anhx.getText().toString();; localObject = "")
        {
          localIntent.putExtra("text", (String)localObject);
          super.getActivity().setResult(0, localIntent);
          VipUtils.a(null, "cmshow", "Apollo", "CancelClick", 0, 0, new String[0]);
          super.getActivity().finish();
          break;
        }
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        this.jdField_a_of_type_Anhx.setText("");
        this.jdField_a_of_type_Anhx.setHint(" ");
        VipUtils.a(null, "cmshow", "Apollo", "ClearClick", 0, 0, new String[0]);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = super.getActivity();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1778384896);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramViewGroup = new RelativeLayout.LayoutParams(-2, -2);
    paramViewGroup.addRule(14, -1);
    paramViewGroup.addRule(12, -1);
    paramViewGroup.bottomMargin = agej.a(80.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramViewGroup);
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.bottomMargin = agej.a(44.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramBundle);
    this.jdField_a_of_type_Anhx = new anhx(paramLayoutInflater);
    this.jdField_a_of_type_Anhx.setCursorVisible(true);
    this.jdField_a_of_type_Anhx.setTextSize(24.0F);
    this.jdField_a_of_type_Anhx.setTextColor(-1);
    this.jdField_a_of_type_Anhx.setHintTextColor(-1);
    this.jdField_a_of_type_Anhx.setHint(anzj.a(2131699241));
    this.jdField_a_of_type_Anhx.setBackgroundColor(0);
    this.jdField_a_of_type_Anhx.addTextChangedListener(this);
    this.jdField_a_of_type_Anhx.setSingleLine(false);
    this.jdField_a_of_type_Anhx.setSelection(0);
    float f = this.jdField_a_of_type_Anhx.getPaint().measureText(anzj.a(2131699240));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(13, -1);
    paramViewGroup.addView(this.jdField_a_of_type_Anhx, paramBundle);
    this.jdField_a_of_type_Anhx.setMaxWidth((int)(f + 1.0F));
    paramViewGroup = new RelativeLayout(paramLayoutInflater);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, agej.a(1.0F, getResources())).addRule(10, -1);
    paramViewGroup.addView(paramBundle);
    paramBundle = new View(paramLayoutInflater);
    paramBundle.setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, agej.a(1.0F, getResources())).addRule(12, -1);
    paramViewGroup.addView(paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838470);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(9);
    paramBundle.leftMargin = agej.a(15.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramLayoutInflater);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(15);
    paramBundle.addRule(11);
    paramBundle.rightMargin = agej.a(10.0F, getResources());
    paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131699239));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    paramBundle = new RelativeLayout.LayoutParams(-2, -1);
    paramBundle.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramBundle);
    paramBundle = new RelativeLayout.LayoutParams(-1, agej.a(43.0F, getResources()));
    paramBundle.addRule(12, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.getIntent().getStringExtra("extra_key_last_text");
    if (!TextUtils.isEmpty(paramLayoutInflater))
    {
      this.jdField_a_of_type_Anhx.setGravity(17);
      this.jdField_a_of_type_Anhx.setText(paramLayoutInflater);
      this.jdField_a_of_type_Anhx.a(paramLayoutInflater.length());
      int i = 12 - paramLayoutInflater.length();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131699238) + i + anzj.a(2131699236));
      if (i < 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838472);
    }
    for (;;)
    {
      paramLayoutInflater = new AlphaAnimation(0.0F, 1.0F);
      paramLayoutInflater.setDuration(500L);
      paramLayoutInflater.setFillAfter(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramLayoutInflater);
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 1, 0, new String[0]);
      paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_Anhx.setGravity(3);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838471);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.jdField_a_of_type_Anhx.setHint(" ");
      str = paramCharSequence.toString();
      paramCharSequence = a(str);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDiyTextActivity", 2, "onTextChanged:" + str + " newStr:" + paramCharSequence);
      }
      paramInt1 = paramCharSequence.length();
      paramInt2 = this.jdField_a_of_type_Anhx.getSelectionEnd();
      if (paramInt1 > 50)
      {
        paramCharSequence = paramCharSequence.substring(0, 50);
        if (this.jdField_b_of_type_Boolean) {
          break label414;
        }
        this.jdField_b_of_type_Boolean = true;
        VipUtils.a(null, "cmshow", "Apollo", "reach50", 0, 0, new String[0]);
        paramInt1 = 50;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131699235) + (12 - paramInt1) + anzj.a(2131699234));
      if (paramInt1 > 12)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          VipUtils.a(null, "cmshow", "Apollo", "over12", 0, 0, new String[0]);
        }
        label226:
        if (paramInt2 < paramCharSequence.length()) {
          break label409;
        }
      }
      label280:
      label409:
      for (paramInt1 = paramCharSequence.length();; paramInt1 = paramInt2)
      {
        if (!str.equals(paramCharSequence))
        {
          this.jdField_a_of_type_Anhx.removeTextChangedListener(this);
          this.jdField_a_of_type_Anhx.setText(paramCharSequence);
          this.jdField_a_of_type_Anhx.setSelection(paramInt1);
          this.jdField_a_of_type_Anhx.addTextChangedListener(this);
        }
        if ((this.jdField_a_of_type_Anhx.getText() != null) && (this.jdField_a_of_type_Anhx.getText().length() > 0))
        {
          this.jdField_a_of_type_Anhx.setGravity(17);
          if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838472);
          }
        }
        do
        {
          return;
          if (paramInt1 < 50) {
            this.jdField_b_of_type_Boolean = false;
          }
          break;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          break label226;
          this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          break label280;
          this.jdField_a_of_type_Anhx.setGravity(3);
        } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838471);
        return;
      }
      label414:
      paramInt1 = 50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment
 * JD-Core Version:    0.7.0.1
 */